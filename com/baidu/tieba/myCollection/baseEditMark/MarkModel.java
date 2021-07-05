package com.baidu.tieba.myCollection.baseEditMark;

import androidx.core.view.InputDeviceCompat;
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
import d.a.c.a.f;
import d.a.r0.h.a;
import d.a.s0.a2.g.c;
/* loaded from: classes5.dex */
public class MarkModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f18713e;

    /* renamed from: f  reason: collision with root package name */
    public MarkData f18714f;

    /* renamed from: g  reason: collision with root package name */
    public a f18715g;

    /* renamed from: h  reason: collision with root package name */
    public a.InterfaceC1243a f18716h;

    /* loaded from: classes5.dex */
    public class a extends BdAsyncTask<Boolean, Integer, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public NetWork f18717a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f18718b;

        /* renamed from: c  reason: collision with root package name */
        public c f18719c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ MarkModel f18720d;

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
            this.f18720d = markModel;
            this.f18717a = null;
            this.f18718b = true;
            this.f18719c = null;
            this.f18718b = z;
            this.f18719c = new c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Boolean doInBackground(Boolean... boolArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, boolArr)) == null) {
                if (this.f18718b) {
                    this.f18717a = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.MARK_ADDSTORE);
                    d.a.s0.a2.g.a aVar = new d.a.s0.a2.g.a();
                    aVar.j(this.f18720d.f18714f);
                    this.f18717a.addPostData("data", aVar.E(0, 1));
                } else {
                    NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
                    this.f18717a = netWork;
                    netWork.addPostData("user_id", this.f18720d.f18714f.getAccount());
                    this.f18717a.addPostData("tid", this.f18720d.f18714f.getId());
                    this.f18717a.addPostData("fid", this.f18720d.f18714f.getForumId());
                }
                this.f18719c.c(this.f18717a.postNetData());
                boolean z = this.f18719c.a() == 0;
                if (this.f18717a.getNetContext().getResponse().isRequestSuccess() && z) {
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
                NetWork netWork = this.f18717a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                }
                this.f18720d.f18715g = null;
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
                    if (this.f18719c != null) {
                        d.a.r0.r.z.a.a("collection", 0L, 0, "add_collection_thread", this.f18719c.a(), this.f18719c.b(), new Object[0]);
                    }
                    if (bool.booleanValue()) {
                        if (this.f18720d.f18716h != null) {
                            this.f18720d.f18716h.a(true, this.f18718b, null);
                        }
                    } else if (this.f18720d.f18716h != null) {
                        if (this.f18717a == null || this.f18717a.getNetContext().getResponse().isRequestSuccess()) {
                            this.f18720d.f18716h.a(false, this.f18718b, this.f18719c.b());
                        } else {
                            this.f18720d.f18716h.a(false, this.f18718b, this.f18717a.getErrorString());
                        }
                    }
                    this.f18720d.f18715g = null;
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
        this.f18713e = false;
        this.f18714f = null;
        this.f18715g = null;
        this.f18716h = null;
        this.f18714f = new MarkData();
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            a aVar = this.f18715g;
            if (aVar != null) {
                aVar.cancel();
            }
            a aVar2 = new a(this, false);
            this.f18715g = aVar2;
            aVar2.setPriority(3);
            this.f18715g.execute(new Boolean[0]);
        }
    }

    public boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f18713e : invokeV.booleanValue;
    }

    public MarkData C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f18714f : (MarkData) invokeV.objValue;
    }

    public String D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            MarkData markData = this.f18714f;
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
            this.f18713e = z;
        }
    }

    public void F(MarkData markData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, markData) == null) {
            this.f18714f = markData;
        }
    }

    public void G(a.InterfaceC1243a interfaceC1243a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, interfaceC1243a) == null) {
            this.f18716h = interfaceC1243a;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            a aVar = this.f18715g;
            if (aVar != null) {
                aVar.cancel();
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            a aVar = this.f18715g;
            if (aVar != null) {
                aVar.cancel();
            }
            a aVar2 = new a(this, true);
            this.f18715g = aVar2;
            aVar2.setPriority(3);
            this.f18715g.execute(new Boolean[0]);
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
        this.f18713e = false;
        this.f18714f = null;
        this.f18715g = null;
        this.f18716h = null;
        this.f18714f = new MarkData();
    }
}
