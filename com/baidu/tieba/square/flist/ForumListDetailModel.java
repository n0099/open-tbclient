package com.baidu.tieba.square.flist;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.da;
import com.baidu.tieba.e05;
import com.baidu.tieba.square.flist.ForumListModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class ForumListDetailModel extends BdBaseModel<ForumListActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<ForumListActivity> a;
    public ForumListModel.RequestParams b;
    public b c;
    public c d;
    public boolean e;
    public boolean f;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public interface b {
        void a(boolean z, int i, ForumListModel forumListModel, String str, boolean z2);
    }

    /* loaded from: classes8.dex */
    public class c extends BdAsyncTask<Void, Void, ForumListModel> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ForumListModel a;
        public final /* synthetic */ ForumListDetailModel b;

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
            this.b = forumListDetailModel;
            this.a = new ForumListModel(this.b.a);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onProgressUpdate(Void... voidArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, voidArr) == null) {
                super.onProgressUpdate(voidArr);
                if (this.a == null) {
                    return;
                }
                b bVar = this.b.c;
                int errorCode = this.a.getErrorCode();
                ForumListModel forumListModel = this.a;
                bVar.a(true, errorCode, forumListModel, forumListModel.getErrorString(), this.b.f);
            }
        }

        public /* synthetic */ c(ForumListDetailModel forumListDetailModel, a aVar) {
            this(forumListDetailModel);
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
                    if (this.b.e) {
                        e05.k();
                        da<String> l = e05.l("tb.my_posts");
                        if (l != null) {
                            str = l.get(TbadkCoreApplication.getCurrentAccount() + "_" + this.b.b.menu_name + ForumListModel.KEY);
                        } else {
                            str = null;
                        }
                        if (str != null) {
                            ForumListModel forumListModel = (ForumListModel) OrmObject.objectWithJsonStr(str, ForumListModel.class);
                            this.a = forumListModel;
                            if (forumListModel != null) {
                                publishProgress(new Void[0]);
                            }
                            this.b.f = true;
                        }
                    }
                    this.b.e = false;
                    return ForumListModel.new_fetch(this.b.b);
                } catch (Exception e) {
                    BdLog.detailException(e);
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
                    this.b.c.a(true, forumListModel.getErrorCode(), forumListModel, forumListModel.getErrorString(), this.b.f);
                } else {
                    this.b.c.a(false, 0, forumListModel, this.b.a.getString(R.string.obfuscated_res_0x7f0f0e70), this.b.f);
                }
            }
        }
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
                super((BdPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = true;
        this.f = false;
        this.a = tbPageContext;
        this.b = requestParams;
    }

    public void V(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.c = bVar;
        }
    }

    public void W(ForumListModel.RequestParams requestParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, requestParams) == null) {
            this.b = requestParams;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            c cVar = this.d;
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
            this.d = cVar;
            cVar.execute(new Void[0]);
            return true;
        }
        return invokeV.booleanValue;
    }
}
