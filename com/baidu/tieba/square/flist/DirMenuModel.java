package com.baidu.tieba.square.flist;

import c.a.d.a.f;
import c.a.d.f.d.l;
import c.a.r0.q3.j.d;
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
/* loaded from: classes11.dex */
public class DirMenuModel extends BdBaseModel<ForumListActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public b f49083e;

    /* renamed from: f  reason: collision with root package name */
    public c f49084f;

    /* renamed from: g  reason: collision with root package name */
    public String f49085g;

    /* renamed from: h  reason: collision with root package name */
    public String f49086h;

    /* renamed from: i  reason: collision with root package name */
    public String f49087i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f49088j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f49089k;

    /* loaded from: classes11.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes11.dex */
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
        this.f49088j = false;
        this.f49089k = false;
        this.f49085g = str;
        this.f49086h = str2;
        this.f49087i = str3;
    }

    public void E(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
            this.f49084f = cVar;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            b bVar = this.f49083e;
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
            this.f49083e = bVar;
            bVar.execute(new Object[0]);
            return true;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes11.dex */
    public class b extends BdAsyncTask<Object, Integer, c.a.r0.q3.j.c> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public NetWork a;

        /* renamed from: b  reason: collision with root package name */
        public c.a.r0.q3.j.c f49090b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ DirMenuModel f49091c;

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
            this.f49091c = dirMenuModel;
            this.a = null;
            this.f49090b = new c.a.r0.q3.j.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public c.a.r0.q3.j.c doInBackground(Object... objArr) {
            InterceptResult invokeL;
            String str;
            String postNetData;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
                c.a.q0.s.r.a.f();
                l<String> g2 = c.a.q0.s.r.a.g("tb.my_posts");
                if (g2 != null) {
                    str = g2.get(TbadkCoreApplication.getCurrentAccount() + "_" + this.f49091c.f49085g + "_dir");
                } else {
                    str = null;
                }
                if (str != null) {
                    this.f49090b.e(str);
                    this.f49091c.f49089k = true;
                    publishProgress(new Integer[0]);
                }
                try {
                    NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + "c/f/forum/seconddir");
                    this.a = netWork;
                    netWork.addPostData(ForumListActivity.KEY_MENU_NAME, this.f49091c.f49085g);
                    this.a.addPostData("menu_type", this.f49091c.f49086h);
                    this.a.addPostData(ForumListActivity.KEY_MENU_ID, this.f49091c.f49087i);
                    postNetData = this.a.postNetData();
                } catch (Exception e2) {
                    this.f49090b.g(e2.getMessage());
                    BdLog.detailException(e2);
                }
                if (postNetData == null) {
                    return this.f49090b;
                }
                if (this.a.getNetContext().getResponse().isRequestSuccess()) {
                    this.f49090b.e(postNetData);
                    this.f49091c.f49088j = true;
                    if (g2 != null) {
                        g2.e(TbadkCoreApplication.getCurrentAccount() + "_" + this.f49091c.f49085g + "_dir", postNetData, 86400000L);
                    }
                } else {
                    this.f49090b.g(this.a.getErrorString());
                    this.f49091c.f49088j = false;
                }
                return this.f49090b;
            }
            return (c.a.r0.q3.j.c) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(c.a.r0.q3.j.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
                if (!this.f49091c.f49088j) {
                    this.f49091c.f49084f.a(false, -1, null, cVar.b(), this.f49091c.f49089k);
                } else if (cVar.h() != null) {
                    this.f49091c.f49084f.a(true, cVar.a(), cVar.h(), cVar.b(), this.f49091c.f49089k);
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.cancel(true);
                NetWork netWork = this.a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                    this.a = null;
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
                if (this.f49090b != null) {
                    this.f49091c.f49084f.a(true, this.f49090b.a(), this.f49090b.h(), this.f49090b.b(), this.f49091c.f49089k);
                }
            }
        }

        public /* synthetic */ b(DirMenuModel dirMenuModel, a aVar) {
            this(dirMenuModel);
        }
    }
}
