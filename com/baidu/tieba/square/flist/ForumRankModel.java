package com.baidu.tieba.square.flist;

import android.content.Intent;
import android.os.Bundle;
import c.a.d.a.f;
import c.a.d.f.d.l;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes13.dex */
public class ForumRankModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f48008e;

    /* renamed from: f  reason: collision with root package name */
    public b f48009f;

    /* renamed from: g  reason: collision with root package name */
    public String f48010g;

    /* loaded from: classes13.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes13.dex */
    public class b extends BdAsyncTask<Void, ForumRankData, ForumRankData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForumRankModel a;

        public b(ForumRankModel forumRankModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumRankModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = forumRankModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public ForumRankData doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            String str;
            ForumRankData forumRankData;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                c.a.s0.s.r.a.f();
                l<String> g2 = c.a.s0.s.r.a.g("tb.forum_rank");
                if (g2 != null) {
                    str = g2.get("forum_rank_cache_key_" + this.a.f48008e);
                } else {
                    str = null;
                }
                if (!StringUtils.isNull(str) && (forumRankData = (ForumRankData) OrmObject.objectWithJsonStr(str, ForumRankData.class)) != null) {
                    publishProgress(forumRankData);
                }
                NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + "c/f/forum/forumsquarelist");
                netWork.addPostData(GameCodeGetMsg.PARAM_LIST_ID, this.a.f48008e);
                netWork.addPostData("st_type", this.a.f48010g);
                String postNetData = netWork.postNetData();
                if (StringUtils.isNull(postNetData)) {
                    return null;
                }
                if (g2 != null) {
                    g2.e("forum_rank_cache_key_" + this.a.f48008e, postNetData, 86400000L);
                }
                return (ForumRankData) OrmObject.objectWithJsonStr(postNetData, ForumRankData.class);
            }
            return (ForumRankData) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ForumRankData forumRankData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, forumRankData) == null) {
                this.a.f48009f = null;
                if (this.a.mLoadDataCallBack != null) {
                    this.a.mLoadDataCallBack.c(forumRankData);
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.cancel(true);
                this.a.f48009f = null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onProgressUpdate(ForumRankData... forumRankDataArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, forumRankDataArr) == null) {
                super.onProgressUpdate(forumRankDataArr);
                if (this.a.mLoadDataCallBack == null || forumRankDataArr == null || forumRankDataArr.length <= 0) {
                    return;
                }
                this.a.mLoadDataCallBack.c(forumRankDataArr[0]);
            }
        }

        public /* synthetic */ b(ForumRankModel forumRankModel, a aVar) {
            this(forumRankModel);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumRankModel(Bundle bundle) {
        super(null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bundle};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f48008e = null;
        this.f48009f = null;
        this.f48010g = null;
        this.f48008e = bundle.getString("id");
        this.f48010g = bundle.getString("st_type");
    }

    public void D(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            bundle.putString("id", this.f48008e);
            bundle.putString("st_type", this.f48010g);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            b bVar = this.f48009f;
            if (bVar != null) {
                bVar.cancel();
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f48008e == null) {
                return false;
            }
            if (this.f48009f == null) {
                b bVar = new b(this, null);
                this.f48009f = bVar;
                bVar.execute(new Void[0]);
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumRankModel(Intent intent) {
        super(null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {intent};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f48008e = null;
        this.f48009f = null;
        this.f48010g = null;
        this.f48008e = intent.getStringExtra("id");
        this.f48010g = intent.getStringExtra("st_type");
    }
}
