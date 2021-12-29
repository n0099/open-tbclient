package com.baidu.tieba.myCollection.baseEditMark;

import androidx.core.view.InputDeviceCompat;
import c.a.d.a.f;
import c.a.s0.i.a;
import c.a.t0.k2.g.c;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public class MarkModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f47827e;

    /* renamed from: f  reason: collision with root package name */
    public MarkData f47828f;

    /* renamed from: g  reason: collision with root package name */
    public a f47829g;

    /* renamed from: h  reason: collision with root package name */
    public a.InterfaceC0841a f47830h;

    /* loaded from: classes12.dex */
    public class a extends BdAsyncTask<Boolean, Integer, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public NetWork a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f47831b;

        /* renamed from: c  reason: collision with root package name */
        public c f47832c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ MarkModel f47833d;

        public a(MarkModel markModel, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {markModel, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47833d = markModel;
            this.a = null;
            this.f47831b = true;
            this.f47832c = null;
            this.f47831b = z;
            this.f47832c = new c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Boolean doInBackground(Boolean... boolArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, boolArr)) == null) {
                if (this.f47831b) {
                    this.a = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                    c.a.t0.k2.g.a aVar = new c.a.t0.k2.g.a();
                    aVar.j(this.f47833d.f47828f);
                    this.a.addPostData("data", aVar.E(0, 1));
                } else {
                    NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
                    this.a = netWork;
                    netWork.addPostData("user_id", this.f47833d.f47828f.getAccount());
                    this.a.addPostData("tid", this.f47833d.f47828f.getId());
                    this.a.addPostData("fid", this.f47833d.f47828f.getForumId());
                }
                this.f47832c.c(this.a.postNetData());
                boolean z = this.f47832c.a() == 0;
                if (this.a.getNetContext().getResponse().isRequestSuccess() && z) {
                    return Boolean.TRUE;
                }
                return Boolean.FALSE;
            }
            return (Boolean) invokeL.objValue;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.cancel(true);
                NetWork netWork = this.a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                }
                this.f47833d.f47829g = null;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, bool) == null) {
                try {
                    if (this.f47832c != null) {
                        c.a.s0.s.b0.a.a("collection", 0L, 0, "add_collection_thread", this.f47832c.a(), this.f47832c.b(), new Object[0]);
                    }
                    if (bool.booleanValue()) {
                        if (this.f47833d.f47830h != null) {
                            this.f47833d.f47830h.a(true, this.f47831b, null);
                        }
                    } else if (this.f47833d.f47830h != null) {
                        if (this.a == null || this.a.getNetContext().getResponse().isRequestSuccess()) {
                            this.f47833d.f47830h.a(false, this.f47831b, this.f47832c.b());
                        } else {
                            this.f47833d.f47830h.a(false, this.f47831b, this.a.getErrorString());
                        }
                    }
                    this.f47833d.f47829g = null;
                } catch (Throwable th) {
                    BdLog.e(th.toString());
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MarkModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseActivity};
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
        this.f47827e = false;
        this.f47828f = null;
        this.f47829g = null;
        this.f47830h = null;
        this.f47828f = new MarkData();
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            a aVar = this.f47829g;
            if (aVar != null) {
                aVar.cancel();
            }
            a aVar2 = new a(this, false);
            this.f47829g = aVar2;
            aVar2.setPriority(3);
            this.f47829g.execute(new Boolean[0]);
        }
    }

    public boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f47827e : invokeV.booleanValue;
    }

    public MarkData C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f47828f : (MarkData) invokeV.objValue;
    }

    public String D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            MarkData markData = this.f47828f;
            if (markData != null) {
                return markData.getPostId();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public void E(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f47827e = z;
        }
    }

    public void F(MarkData markData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, markData) == null) {
            this.f47828f = markData;
        }
    }

    public void G(a.InterfaceC0841a interfaceC0841a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, interfaceC0841a) == null) {
            this.f47830h = interfaceC0841a;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            a aVar = this.f47829g;
            if (aVar != null) {
                aVar.cancel();
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
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            a aVar = this.f47829g;
            if (aVar != null) {
                aVar.cancel();
            }
            a aVar2 = new a(this, true);
            this.f47829g = aVar2;
            aVar2.setPriority(3);
            this.f47829g.execute(new Boolean[0]);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MarkModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragmentActivity};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f47827e = false;
        this.f47828f = null;
        this.f47829g = null;
        this.f47830h = null;
        this.f47828f = new MarkData();
    }
}
