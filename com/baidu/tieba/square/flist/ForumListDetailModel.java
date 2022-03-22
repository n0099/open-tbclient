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
/* loaded from: classes6.dex */
public class ForumListDetailModel extends BdBaseModel<ForumListActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<ForumListActivity> a;

    /* renamed from: b  reason: collision with root package name */
    public ForumListModel.RequestParams f35989b;

    /* renamed from: c  reason: collision with root package name */
    public b f35990c;

    /* renamed from: d  reason: collision with root package name */
    public c f35991d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f35992e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f35993f;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public interface b {
        void a(boolean z, int i, ForumListModel forumListModel, String str, boolean z2);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f35992e = true;
        this.f35993f = false;
        this.a = tbPageContext;
        this.f35989b = requestParams;
    }

    public void F(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f35990c = bVar;
        }
    }

    public void G(ForumListModel.RequestParams requestParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, requestParams) == null) {
            this.f35989b = requestParams;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            c cVar = this.f35991d;
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
            this.f35991d = cVar;
            cVar.execute(new Void[0]);
            return true;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes6.dex */
    public class c extends BdAsyncTask<Void, Void, ForumListModel> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ForumListModel a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ForumListDetailModel f35994b;

        public c(ForumListDetailModel forumListDetailModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumListDetailModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35994b = forumListDetailModel;
            this.a = new ForumListModel(this.f35994b.a);
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
                    if (this.f35994b.f35992e) {
                        c.a.o0.r.s.a.f();
                        l<String> g2 = c.a.o0.r.s.a.g("tb.my_posts");
                        if (g2 != null) {
                            str = g2.get(TbadkCoreApplication.getCurrentAccount() + "_" + this.f35994b.f35989b.menu_name + ForumListModel.KEY);
                        } else {
                            str = null;
                        }
                        if (str != null) {
                            ForumListModel forumListModel = (ForumListModel) OrmObject.objectWithJsonStr(str, ForumListModel.class);
                            this.a = forumListModel;
                            if (forumListModel != null) {
                                publishProgress(new Void[0]);
                            }
                            this.f35994b.f35993f = true;
                        }
                    }
                    this.f35994b.f35992e = false;
                    return ForumListModel.new_fetch(this.f35994b.f35989b);
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
                    this.f35994b.f35990c.a(true, forumListModel.getErrorCode(), forumListModel, forumListModel.getErrorString(), this.f35994b.f35993f);
                } else {
                    this.f35994b.f35990c.a(false, 0, forumListModel, this.f35994b.a.getString(R.string.obfuscated_res_0x7f0f0c15), this.f35994b.f35993f);
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
                    b bVar = this.f35994b.f35990c;
                    int errorCode = this.a.getErrorCode();
                    ForumListModel forumListModel = this.a;
                    bVar.a(true, errorCode, forumListModel, forumListModel.getErrorString(), this.f35994b.f35993f);
                }
            }
        }

        public /* synthetic */ c(ForumListDetailModel forumListDetailModel, a aVar) {
            this(forumListDetailModel);
        }
    }
}
