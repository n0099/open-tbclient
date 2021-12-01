package com.baidu.tieba.square.flist;

import c.a.d.a.f;
import c.a.d.f.d.l;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.square.flist.ForumListModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class ForumListDetailModel extends BdBaseModel<ForumListActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<ForumListActivity> f49106e;

    /* renamed from: f  reason: collision with root package name */
    public ForumListModel.RequestParams f49107f;

    /* renamed from: g  reason: collision with root package name */
    public b f49108g;

    /* renamed from: h  reason: collision with root package name */
    public c f49109h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f49110i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f49111j;

    /* loaded from: classes11.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes11.dex */
    public interface b {
        void a(boolean z, int i2, ForumListModel forumListModel, String str, boolean z2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumListDetailModel(TbPageContext<ForumListActivity> tbPageContext, ForumListModel.RequestParams requestParams) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, requestParams};
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
        this.f49110i = true;
        this.f49111j = false;
        this.f49106e = tbPageContext;
        this.f49107f = requestParams;
    }

    public void D(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f49108g = bVar;
        }
    }

    public void E(ForumListModel.RequestParams requestParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, requestParams) == null) {
            this.f49107f = requestParams;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            c cVar = this.f49109h;
            if (cVar == null) {
                return false;
            }
            cVar.cancel();
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            c cVar = new c(this, null);
            this.f49109h = cVar;
            cVar.execute(new Void[0]);
            return true;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes11.dex */
    public class c extends BdAsyncTask<Void, Void, ForumListModel> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ForumListModel a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ForumListDetailModel f49112b;

        public c(ForumListDetailModel forumListDetailModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumListDetailModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49112b = forumListDetailModel;
            this.a = new ForumListModel(this.f49112b.f49106e);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public ForumListModel doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                try {
                    if (this.f49112b.f49110i) {
                        c.a.q0.s.r.a.f();
                        l<String> g2 = c.a.q0.s.r.a.g("tb.my_posts");
                        if (g2 != null) {
                            str = g2.get(TbadkCoreApplication.getCurrentAccount() + "_" + this.f49112b.f49107f.menu_name + ForumListModel.KEY);
                        } else {
                            str = null;
                        }
                        if (str != null) {
                            ForumListModel forumListModel = (ForumListModel) OrmObject.objectWithJsonStr(str, ForumListModel.class);
                            this.a = forumListModel;
                            if (forumListModel != null) {
                                publishProgress(new Void[0]);
                            }
                            this.f49112b.f49111j = true;
                        }
                    }
                    this.f49112b.f49110i = false;
                    return ForumListModel.new_fetch(this.f49112b.f49107f);
                } catch (Exception e2) {
                    BdLog.detailException(e2);
                    return null;
                }
            }
            return (ForumListModel) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ForumListModel forumListModel) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, forumListModel) == null) {
                if (forumListModel != null && forumListModel.isOk()) {
                    this.f49112b.f49108g.a(true, forumListModel.getErrorCode(), forumListModel, forumListModel.getErrorString(), this.f49112b.f49111j);
                } else {
                    this.f49112b.f49108g.a(false, 0, forumListModel, this.f49112b.f49106e.getString(R.string.neterror), this.f49112b.f49111j);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onProgressUpdate(Void... voidArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, voidArr) == null) {
                super.onProgressUpdate(voidArr);
                if (this.a != null) {
                    b bVar = this.f49112b.f49108g;
                    int errorCode = this.a.getErrorCode();
                    ForumListModel forumListModel = this.a;
                    bVar.a(true, errorCode, forumListModel, forumListModel.getErrorString(), this.f49112b.f49111j);
                }
            }
        }

        public /* synthetic */ c(ForumListDetailModel forumListDetailModel, a aVar) {
            this(forumListDetailModel);
        }
    }
}
