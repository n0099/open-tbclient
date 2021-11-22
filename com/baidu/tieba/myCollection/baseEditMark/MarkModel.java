package com.baidu.tieba.myCollection.baseEditMark;

import androidx.core.view.InputDeviceCompat;
import b.a.e.a.f;
import b.a.q0.i.a;
import b.a.r0.d2.g.c;
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
/* loaded from: classes9.dex */
public class MarkModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f52624e;

    /* renamed from: f  reason: collision with root package name */
    public MarkData f52625f;

    /* renamed from: g  reason: collision with root package name */
    public a f52626g;

    /* renamed from: h  reason: collision with root package name */
    public a.InterfaceC0699a f52627h;

    /* loaded from: classes9.dex */
    public class a extends BdAsyncTask<Boolean, Integer, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public NetWork f52628a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f52629b;

        /* renamed from: c  reason: collision with root package name */
        public c f52630c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ MarkModel f52631d;

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
            this.f52631d = markModel;
            this.f52628a = null;
            this.f52629b = true;
            this.f52630c = null;
            this.f52629b = z;
            this.f52630c = new c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Boolean doInBackground(Boolean... boolArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, boolArr)) == null) {
                if (this.f52629b) {
                    this.f52628a = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                    b.a.r0.d2.g.a aVar = new b.a.r0.d2.g.a();
                    aVar.j(this.f52631d.f52625f);
                    this.f52628a.addPostData("data", aVar.E(0, 1));
                } else {
                    NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
                    this.f52628a = netWork;
                    netWork.addPostData("user_id", this.f52631d.f52625f.getAccount());
                    this.f52628a.addPostData("tid", this.f52631d.f52625f.getId());
                    this.f52628a.addPostData("fid", this.f52631d.f52625f.getForumId());
                }
                this.f52630c.c(this.f52628a.postNetData());
                boolean z = this.f52630c.a() == 0;
                if (this.f52628a.getNetContext().getResponse().isRequestSuccess() && z) {
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
                NetWork netWork = this.f52628a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                }
                this.f52631d.f52626g = null;
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
                    if (this.f52630c != null) {
                        b.a.q0.s.a0.a.a("collection", 0L, 0, "add_collection_thread", this.f52630c.a(), this.f52630c.b(), new Object[0]);
                    }
                    if (bool.booleanValue()) {
                        if (this.f52631d.f52627h != null) {
                            this.f52631d.f52627h.a(true, this.f52629b, null);
                        }
                    } else if (this.f52631d.f52627h != null) {
                        if (this.f52628a == null || this.f52628a.getNetContext().getResponse().isRequestSuccess()) {
                            this.f52631d.f52627h.a(false, this.f52629b, this.f52630c.b());
                        } else {
                            this.f52631d.f52627h.a(false, this.f52629b, this.f52628a.getErrorString());
                        }
                    }
                    this.f52631d.f52626g = null;
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
        this.f52624e = false;
        this.f52625f = null;
        this.f52626g = null;
        this.f52627h = null;
        this.f52625f = new MarkData();
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            a aVar = this.f52626g;
            if (aVar != null) {
                aVar.cancel();
            }
            a aVar2 = new a(this, false);
            this.f52626g = aVar2;
            aVar2.setPriority(3);
            this.f52626g.execute(new Boolean[0]);
        }
    }

    public boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f52624e : invokeV.booleanValue;
    }

    public MarkData C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f52625f : (MarkData) invokeV.objValue;
    }

    public String D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            MarkData markData = this.f52625f;
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
            this.f52624e = z;
        }
    }

    public void F(MarkData markData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, markData) == null) {
            this.f52625f = markData;
        }
    }

    public void G(a.InterfaceC0699a interfaceC0699a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, interfaceC0699a) == null) {
            this.f52627h = interfaceC0699a;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            a aVar = this.f52626g;
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
            a aVar = this.f52626g;
            if (aVar != null) {
                aVar.cancel();
            }
            a aVar2 = new a(this, true);
            this.f52626g = aVar2;
            aVar2.setPriority(3);
            this.f52626g.execute(new Boolean[0]);
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
        this.f52624e = false;
        this.f52625f = null;
        this.f52626g = null;
        this.f52627h = null;
        this.f52625f = new MarkData();
    }
}
