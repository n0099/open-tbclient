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
/* loaded from: classes12.dex */
public class ForumListDetailModel extends BdBaseModel<ForumListActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<ForumListActivity> f49620e;

    /* renamed from: f  reason: collision with root package name */
    public ForumListModel.RequestParams f49621f;

    /* renamed from: g  reason: collision with root package name */
    public b f49622g;

    /* renamed from: h  reason: collision with root package name */
    public c f49623h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f49624i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f49625j;

    /* loaded from: classes12.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes12.dex */
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
        this.f49624i = true;
        this.f49625j = false;
        this.f49620e = tbPageContext;
        this.f49621f = requestParams;
    }

    public void D(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f49622g = bVar;
        }
    }

    public void E(ForumListModel.RequestParams requestParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, requestParams) == null) {
            this.f49621f = requestParams;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            c cVar = this.f49623h;
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
            this.f49623h = cVar;
            cVar.execute(new Void[0]);
            return true;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes12.dex */
    public class c extends BdAsyncTask<Void, Void, ForumListModel> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ForumListModel a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ForumListDetailModel f49626b;

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
            this.f49626b = forumListDetailModel;
            this.a = new ForumListModel(this.f49626b.f49620e);
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
                    if (this.f49626b.f49624i) {
                        c.a.r0.s.s.a.f();
                        l<String> g2 = c.a.r0.s.s.a.g("tb.my_posts");
                        if (g2 != null) {
                            str = g2.get(TbadkCoreApplication.getCurrentAccount() + "_" + this.f49626b.f49621f.menu_name + ForumListModel.KEY);
                        } else {
                            str = null;
                        }
                        if (str != null) {
                            ForumListModel forumListModel = (ForumListModel) OrmObject.objectWithJsonStr(str, ForumListModel.class);
                            this.a = forumListModel;
                            if (forumListModel != null) {
                                publishProgress(new Void[0]);
                            }
                            this.f49626b.f49625j = true;
                        }
                    }
                    this.f49626b.f49624i = false;
                    return ForumListModel.new_fetch(this.f49626b.f49621f);
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
                    this.f49626b.f49622g.a(true, forumListModel.getErrorCode(), forumListModel, forumListModel.getErrorString(), this.f49626b.f49625j);
                } else {
                    this.f49626b.f49622g.a(false, 0, forumListModel, this.f49626b.f49620e.getString(R.string.neterror), this.f49626b.f49625j);
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
                    b bVar = this.f49626b.f49622g;
                    int errorCode = this.a.getErrorCode();
                    ForumListModel forumListModel = this.a;
                    bVar.a(true, errorCode, forumListModel, forumListModel.getErrorString(), this.f49626b.f49625j);
                }
            }
        }

        public /* synthetic */ c(ForumListDetailModel forumListDetailModel, a aVar) {
            this(forumListDetailModel);
        }
    }
}
