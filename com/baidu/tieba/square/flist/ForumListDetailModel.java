package com.baidu.tieba.square.flist;

import b.a.e.a.f;
import b.a.e.e.d.l;
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
/* loaded from: classes9.dex */
public class ForumListDetailModel extends BdBaseModel<ForumListActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<ForumListActivity> f54053e;

    /* renamed from: f  reason: collision with root package name */
    public ForumListModel.RequestParams f54054f;

    /* renamed from: g  reason: collision with root package name */
    public b f54055g;

    /* renamed from: h  reason: collision with root package name */
    public c f54056h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f54057i;
    public boolean j;

    /* loaded from: classes9.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
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
        this.f54057i = true;
        this.j = false;
        this.f54053e = tbPageContext;
        this.f54054f = requestParams;
    }

    public void D(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f54055g = bVar;
        }
    }

    public void E(ForumListModel.RequestParams requestParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, requestParams) == null) {
            this.f54054f = requestParams;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            c cVar = this.f54056h;
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
            this.f54056h = cVar;
            cVar.execute(new Void[0]);
            return true;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes9.dex */
    public class c extends BdAsyncTask<Void, Void, ForumListModel> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public ForumListModel f54058a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ForumListDetailModel f54059b;

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
            this.f54059b = forumListDetailModel;
            this.f54058a = new ForumListModel(this.f54059b.f54053e);
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
                    if (this.f54059b.f54057i) {
                        b.a.q0.s.r.a.f();
                        l<String> g2 = b.a.q0.s.r.a.g("tb.my_posts");
                        if (g2 != null) {
                            str = g2.get(TbadkCoreApplication.getCurrentAccount() + "_" + this.f54059b.f54054f.menu_name + ForumListModel.KEY);
                        } else {
                            str = null;
                        }
                        if (str != null) {
                            ForumListModel forumListModel = (ForumListModel) OrmObject.objectWithJsonStr(str, ForumListModel.class);
                            this.f54058a = forumListModel;
                            if (forumListModel != null) {
                                publishProgress(new Void[0]);
                            }
                            this.f54059b.j = true;
                        }
                    }
                    this.f54059b.f54057i = false;
                    return ForumListModel.new_fetch(this.f54059b.f54054f);
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
                    this.f54059b.f54055g.a(true, forumListModel.getErrorCode(), forumListModel, forumListModel.getErrorString(), this.f54059b.j);
                } else {
                    this.f54059b.f54055g.a(false, 0, forumListModel, this.f54059b.f54053e.getString(R.string.neterror), this.f54059b.j);
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
                if (this.f54058a != null) {
                    b bVar = this.f54059b.f54055g;
                    int errorCode = this.f54058a.getErrorCode();
                    ForumListModel forumListModel = this.f54058a;
                    bVar.a(true, errorCode, forumListModel, forumListModel.getErrorString(), this.f54059b.j);
                }
            }
        }

        public /* synthetic */ c(ForumListDetailModel forumListDetailModel, a aVar) {
            this(forumListDetailModel);
        }
    }
}
