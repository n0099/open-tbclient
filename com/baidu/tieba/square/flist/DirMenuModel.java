package com.baidu.tieba.square.flist;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumListActivityConfig;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.a.f;
import d.a.c.e.d.l;
import d.a.s0.e3.j.d;
/* loaded from: classes5.dex */
public class DirMenuModel extends BdBaseModel<ForumListActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public b f20914e;

    /* renamed from: f  reason: collision with root package name */
    public c f20915f;

    /* renamed from: g  reason: collision with root package name */
    public String f20916g;

    /* renamed from: h  reason: collision with root package name */
    public String f20917h;

    /* renamed from: i  reason: collision with root package name */
    public String f20918i;
    public boolean j;
    public boolean k;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
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
        this.f20916g = str;
        this.f20917h = str2;
        this.f20918i = str3;
    }

    public void E(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
            this.f20915f = cVar;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            b bVar = new b(this, null);
            this.f20914e = bVar;
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
            b bVar = this.f20914e;
            if (bVar != null) {
                bVar.cancel();
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes5.dex */
    public class b extends BdAsyncTask<Object, Integer, d.a.s0.e3.j.c> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public NetWork f20919a;

        /* renamed from: b  reason: collision with root package name */
        public d.a.s0.e3.j.c f20920b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ DirMenuModel f20921c;

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
            this.f20921c = dirMenuModel;
            this.f20919a = null;
            this.f20920b = new d.a.s0.e3.j.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public d.a.s0.e3.j.c doInBackground(Object... objArr) {
            InterceptResult invokeL;
            String str;
            String postNetData;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
                l<String> g2 = d.a.r0.r.r.a.f().g("tb.my_posts");
                if (g2 != null) {
                    str = g2.get(TbadkCoreApplication.getCurrentAccount() + "_" + this.f20921c.f20916g + "_dir");
                } else {
                    str = null;
                }
                if (str != null) {
                    this.f20920b.e(str);
                    this.f20921c.k = true;
                    publishProgress(new Integer[0]);
                }
                try {
                    NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + "c/f/forum/seconddir");
                    this.f20919a = netWork;
                    netWork.addPostData("menu_name", this.f20921c.f20916g);
                    this.f20919a.addPostData(ForumListActivityConfig.KEY_MENU_TYPE, this.f20921c.f20917h);
                    this.f20919a.addPostData("menu_id", this.f20921c.f20918i);
                    postNetData = this.f20919a.postNetData();
                } catch (Exception e2) {
                    this.f20920b.g(e2.getMessage());
                    BdLog.detailException(e2);
                }
                if (postNetData == null) {
                    return this.f20920b;
                }
                if (this.f20919a.getNetContext().getResponse().isRequestSuccess()) {
                    this.f20920b.e(postNetData);
                    this.f20921c.j = true;
                    if (g2 != null) {
                        g2.e(TbadkCoreApplication.getCurrentAccount() + "_" + this.f20921c.f20916g + "_dir", postNetData, 86400000L);
                    }
                } else {
                    this.f20920b.g(this.f20919a.getErrorString());
                    this.f20921c.j = false;
                }
                return this.f20920b;
            }
            return (d.a.s0.e3.j.c) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(d.a.s0.e3.j.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
                if (!this.f20921c.j) {
                    this.f20921c.f20915f.a(false, -1, null, cVar.b(), this.f20921c.k);
                } else if (cVar.h() != null) {
                    this.f20921c.f20915f.a(true, cVar.a(), cVar.h(), cVar.b(), this.f20921c.k);
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.cancel(true);
                NetWork netWork = this.f20919a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                    this.f20919a = null;
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
                if (this.f20920b != null) {
                    this.f20921c.f20915f.a(true, this.f20920b.a(), this.f20920b.h(), this.f20920b.b(), this.f20921c.k);
                }
            }
        }

        public /* synthetic */ b(DirMenuModel dirMenuModel, a aVar) {
            this(dirMenuModel);
        }
    }
}
