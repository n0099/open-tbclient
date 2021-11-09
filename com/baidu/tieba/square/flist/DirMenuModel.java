package com.baidu.tieba.square.flist;

import b.a.e.a.f;
import b.a.e.e.d.l;
import b.a.r0.i3.j.d;
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
    public b f54027e;

    /* renamed from: f  reason: collision with root package name */
    public c f54028f;

    /* renamed from: g  reason: collision with root package name */
    public String f54029g;

    /* renamed from: h  reason: collision with root package name */
    public String f54030h;

    /* renamed from: i  reason: collision with root package name */
    public String f54031i;
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
        this.f54029g = str;
        this.f54030h = str2;
        this.f54031i = str3;
    }

    public void E(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
            this.f54028f = cVar;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            b bVar = this.f54027e;
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
            this.f54027e = bVar;
            bVar.execute(new Object[0]);
            return true;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes9.dex */
    public class b extends BdAsyncTask<Object, Integer, b.a.r0.i3.j.c> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public NetWork f54032a;

        /* renamed from: b  reason: collision with root package name */
        public b.a.r0.i3.j.c f54033b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ DirMenuModel f54034c;

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
            this.f54034c = dirMenuModel;
            this.f54032a = null;
            this.f54033b = new b.a.r0.i3.j.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public b.a.r0.i3.j.c doInBackground(Object... objArr) {
            InterceptResult invokeL;
            String str;
            String postNetData;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
                b.a.q0.s.r.a.f();
                l<String> g2 = b.a.q0.s.r.a.g("tb.my_posts");
                if (g2 != null) {
                    str = g2.get(TbadkCoreApplication.getCurrentAccount() + "_" + this.f54034c.f54029g + "_dir");
                } else {
                    str = null;
                }
                if (str != null) {
                    this.f54033b.e(str);
                    this.f54034c.k = true;
                    publishProgress(new Integer[0]);
                }
                try {
                    NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + "c/f/forum/seconddir");
                    this.f54032a = netWork;
                    netWork.addPostData(ForumListActivity.KEY_MENU_NAME, this.f54034c.f54029g);
                    this.f54032a.addPostData("menu_type", this.f54034c.f54030h);
                    this.f54032a.addPostData(ForumListActivity.KEY_MENU_ID, this.f54034c.f54031i);
                    postNetData = this.f54032a.postNetData();
                } catch (Exception e2) {
                    this.f54033b.g(e2.getMessage());
                    BdLog.detailException(e2);
                }
                if (postNetData == null) {
                    return this.f54033b;
                }
                if (this.f54032a.getNetContext().getResponse().isRequestSuccess()) {
                    this.f54033b.e(postNetData);
                    this.f54034c.j = true;
                    if (g2 != null) {
                        g2.e(TbadkCoreApplication.getCurrentAccount() + "_" + this.f54034c.f54029g + "_dir", postNetData, 86400000L);
                    }
                } else {
                    this.f54033b.g(this.f54032a.getErrorString());
                    this.f54034c.j = false;
                }
                return this.f54033b;
            }
            return (b.a.r0.i3.j.c) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(b.a.r0.i3.j.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
                if (!this.f54034c.j) {
                    this.f54034c.f54028f.a(false, -1, null, cVar.b(), this.f54034c.k);
                } else if (cVar.h() != null) {
                    this.f54034c.f54028f.a(true, cVar.a(), cVar.h(), cVar.b(), this.f54034c.k);
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.cancel(true);
                NetWork netWork = this.f54032a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                    this.f54032a = null;
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
                if (this.f54033b != null) {
                    this.f54034c.f54028f.a(true, this.f54033b.a(), this.f54033b.h(), this.f54033b.b(), this.f54034c.k);
                }
            }
        }

        public /* synthetic */ b(DirMenuModel dirMenuModel, a aVar) {
            this(dirMenuModel);
        }
    }
}
