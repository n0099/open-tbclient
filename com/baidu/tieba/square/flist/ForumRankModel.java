package com.baidu.tieba.square.flist;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.a.f;
import d.a.c.e.d.l;
/* loaded from: classes5.dex */
public class ForumRankModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f20956e;

    /* renamed from: f  reason: collision with root package name */
    public b f20957f;

    /* renamed from: g  reason: collision with root package name */
    public String f20958g;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public class b extends BdAsyncTask<Void, ForumRankData, ForumRankData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ForumRankModel f20959a;

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
            this.f20959a = forumRankModel;
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
                l<String> g2 = d.a.r0.r.r.a.f().g("tb.forum_rank");
                if (g2 != null) {
                    str = g2.get("forum_rank_cache_key_" + this.f20959a.f20956e);
                } else {
                    str = null;
                }
                if (!StringUtils.isNull(str) && (forumRankData = (ForumRankData) OrmObject.objectWithJsonStr(str, ForumRankData.class)) != null) {
                    publishProgress(forumRankData);
                }
                NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + "c/f/forum/forumsquarelist");
                netWork.addPostData("list_id", this.f20959a.f20956e);
                netWork.addPostData("st_type", this.f20959a.f20958g);
                String postNetData = netWork.postNetData();
                if (StringUtils.isNull(postNetData)) {
                    return null;
                }
                if (g2 != null) {
                    g2.e("forum_rank_cache_key_" + this.f20959a.f20956e, postNetData, 86400000L);
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
                this.f20959a.f20957f = null;
                if (this.f20959a.mLoadDataCallBack != null) {
                    this.f20959a.mLoadDataCallBack.c(forumRankData);
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.cancel(true);
                this.f20959a.f20957f = null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onProgressUpdate(ForumRankData... forumRankDataArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, forumRankDataArr) == null) {
                super.onProgressUpdate(forumRankDataArr);
                if (this.f20959a.mLoadDataCallBack == null || forumRankDataArr == null || forumRankDataArr.length <= 0) {
                    return;
                }
                this.f20959a.mLoadDataCallBack.c(forumRankDataArr[0]);
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
        this.f20956e = null;
        this.f20957f = null;
        this.f20958g = null;
        this.f20956e = bundle.getString("id");
        this.f20958g = bundle.getString("st_type");
    }

    public void D(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            bundle.putString("id", this.f20956e);
            bundle.putString("st_type", this.f20958g);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f20956e == null) {
                return false;
            }
            if (this.f20957f == null) {
                b bVar = new b(this, null);
                this.f20957f = bVar;
                bVar.execute(new Void[0]);
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            b bVar = this.f20957f;
            if (bVar != null) {
                bVar.cancel();
                return false;
            }
            return false;
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
        this.f20956e = null;
        this.f20957f = null;
        this.f20958g = null;
        this.f20956e = intent.getStringExtra("id");
        this.f20958g = intent.getStringExtra("st_type");
    }
}
