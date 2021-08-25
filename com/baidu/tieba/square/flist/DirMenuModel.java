package com.baidu.tieba.square.flist;

import c.a.e.a.f;
import c.a.e.e.d.l;
import c.a.q0.f3.j.d;
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
/* loaded from: classes7.dex */
public class DirMenuModel extends BdBaseModel<ForumListActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public b f56722e;

    /* renamed from: f  reason: collision with root package name */
    public c f56723f;

    /* renamed from: g  reason: collision with root package name */
    public String f56724g;

    /* renamed from: h  reason: collision with root package name */
    public String f56725h;

    /* renamed from: i  reason: collision with root package name */
    public String f56726i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f56727j;
    public boolean k;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
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
        this.f56727j = false;
        this.k = false;
        this.f56724g = str;
        this.f56725h = str2;
        this.f56726i = str3;
    }

    public void E(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
            this.f56723f = cVar;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            b bVar = new b(this, null);
            this.f56722e = bVar;
            bVar.execute(new Object[0]);
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            b bVar = this.f56722e;
            if (bVar != null) {
                bVar.cancel();
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes7.dex */
    public class b extends BdAsyncTask<Object, Integer, c.a.q0.f3.j.c> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public NetWork f56728a;

        /* renamed from: b  reason: collision with root package name */
        public c.a.q0.f3.j.c f56729b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ DirMenuModel f56730c;

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
            this.f56730c = dirMenuModel;
            this.f56728a = null;
            this.f56729b = new c.a.q0.f3.j.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public c.a.q0.f3.j.c doInBackground(Object... objArr) {
            InterceptResult invokeL;
            String str;
            String postNetData;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
                c.a.p0.s.r.a.f();
                l<String> g2 = c.a.p0.s.r.a.g("tb.my_posts");
                if (g2 != null) {
                    str = g2.get(TbadkCoreApplication.getCurrentAccount() + "_" + this.f56730c.f56724g + "_dir");
                } else {
                    str = null;
                }
                if (str != null) {
                    this.f56729b.e(str);
                    this.f56730c.k = true;
                    publishProgress(new Integer[0]);
                }
                try {
                    NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + "c/f/forum/seconddir");
                    this.f56728a = netWork;
                    netWork.addPostData(ForumListActivity.KEY_MENU_NAME, this.f56730c.f56724g);
                    this.f56728a.addPostData("menu_type", this.f56730c.f56725h);
                    this.f56728a.addPostData(ForumListActivity.KEY_MENU_ID, this.f56730c.f56726i);
                    postNetData = this.f56728a.postNetData();
                } catch (Exception e2) {
                    this.f56729b.g(e2.getMessage());
                    BdLog.detailException(e2);
                }
                if (postNetData == null) {
                    return this.f56729b;
                }
                if (this.f56728a.getNetContext().getResponse().isRequestSuccess()) {
                    this.f56729b.e(postNetData);
                    this.f56730c.f56727j = true;
                    if (g2 != null) {
                        g2.e(TbadkCoreApplication.getCurrentAccount() + "_" + this.f56730c.f56724g + "_dir", postNetData, 86400000L);
                    }
                } else {
                    this.f56729b.g(this.f56728a.getErrorString());
                    this.f56730c.f56727j = false;
                }
                return this.f56729b;
            }
            return (c.a.q0.f3.j.c) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(c.a.q0.f3.j.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
                if (!this.f56730c.f56727j) {
                    this.f56730c.f56723f.a(false, -1, null, cVar.b(), this.f56730c.k);
                } else if (cVar.h() != null) {
                    this.f56730c.f56723f.a(true, cVar.a(), cVar.h(), cVar.b(), this.f56730c.k);
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.cancel(true);
                NetWork netWork = this.f56728a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                    this.f56728a = null;
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
                if (this.f56729b != null) {
                    this.f56730c.f56723f.a(true, this.f56729b.a(), this.f56729b.h(), this.f56729b.b(), this.f56730c.k);
                }
            }
        }

        public /* synthetic */ b(DirMenuModel dirMenuModel, a aVar) {
            this(dirMenuModel);
        }
    }
}
