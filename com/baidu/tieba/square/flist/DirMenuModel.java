package com.baidu.tieba.square.flist;

import b.a.e.a.f;
import b.a.e.f.d.l;
import b.a.r0.j3.j.d;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class DirMenuModel extends BdBaseModel<ForumListActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public b f54947e;

    /* renamed from: f  reason: collision with root package name */
    public c f54948f;

    /* renamed from: g  reason: collision with root package name */
    public String f54949g;

    /* renamed from: h  reason: collision with root package name */
    public String f54950h;

    /* renamed from: i  reason: collision with root package name */
    public String f54951i;
    public boolean j;
    public boolean k;

    /* loaded from: classes9.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
    public interface c {
        void a(boolean z, int i2, d dVar, String str, boolean z2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DirMenuModel(TbPageContext<ForumListActivity> tbPageContext, String str, String str2, String str3) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, str, str2, str3};
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
        this.j = false;
        this.k = false;
        this.f54949g = str;
        this.f54950h = str2;
        this.f54951i = str3;
    }

    public void E(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
            this.f54948f = cVar;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            b bVar = this.f54947e;
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
            b bVar = new b(this, null);
            this.f54947e = bVar;
            bVar.execute(new Object[0]);
            return true;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes9.dex */
    public class b extends BdAsyncTask<Object, Integer, b.a.r0.j3.j.c> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public NetWork f54952a;

        /* renamed from: b  reason: collision with root package name */
        public b.a.r0.j3.j.c f54953b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ DirMenuModel f54954c;

        public b(DirMenuModel dirMenuModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dirMenuModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54954c = dirMenuModel;
            this.f54952a = null;
            this.f54953b = new b.a.r0.j3.j.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public b.a.r0.j3.j.c doInBackground(Object... objArr) {
            InterceptResult invokeL;
            String str;
            String postNetData;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
                b.a.q0.s.r.a.f();
                l<String> g2 = b.a.q0.s.r.a.g("tb.my_posts");
                if (g2 != null) {
                    str = g2.get(TbadkCoreApplication.getCurrentAccount() + "_" + this.f54954c.f54949g + "_dir");
                } else {
                    str = null;
                }
                if (str != null) {
                    this.f54953b.e(str);
                    this.f54954c.k = true;
                    publishProgress(new Integer[0]);
                }
                try {
                    NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + "c/f/forum/seconddir");
                    this.f54952a = netWork;
                    netWork.addPostData(ForumListActivity.KEY_MENU_NAME, this.f54954c.f54949g);
                    this.f54952a.addPostData("menu_type", this.f54954c.f54950h);
                    this.f54952a.addPostData(ForumListActivity.KEY_MENU_ID, this.f54954c.f54951i);
                    postNetData = this.f54952a.postNetData();
                } catch (Exception e2) {
                    this.f54953b.g(e2.getMessage());
                    BdLog.detailException(e2);
                }
                if (postNetData == null) {
                    return this.f54953b;
                }
                if (this.f54952a.getNetContext().getResponse().isRequestSuccess()) {
                    this.f54953b.e(postNetData);
                    this.f54954c.j = true;
                    if (g2 != null) {
                        g2.e(TbadkCoreApplication.getCurrentAccount() + "_" + this.f54954c.f54949g + "_dir", postNetData, 86400000L);
                    }
                } else {
                    this.f54953b.g(this.f54952a.getErrorString());
                    this.f54954c.j = false;
                }
                return this.f54953b;
            }
            return (b.a.r0.j3.j.c) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(b.a.r0.j3.j.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
                if (!this.f54954c.j) {
                    this.f54954c.f54948f.a(false, -1, null, cVar.b(), this.f54954c.k);
                } else if (cVar.h() != null) {
                    this.f54954c.f54948f.a(true, cVar.a(), cVar.h(), cVar.b(), this.f54954c.k);
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.cancel(true);
                NetWork netWork = this.f54952a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                    this.f54952a = null;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onProgressUpdate(Integer... numArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, numArr) == null) {
                super.onProgressUpdate(numArr);
                if (this.f54953b != null) {
                    this.f54954c.f54948f.a(true, this.f54953b.a(), this.f54953b.h(), this.f54953b.b(), this.f54954c.k);
                }
            }
        }

        public /* synthetic */ b(DirMenuModel dirMenuModel, a aVar) {
            this(dirMenuModel);
        }
    }
}
