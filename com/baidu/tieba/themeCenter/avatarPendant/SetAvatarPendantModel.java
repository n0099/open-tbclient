package com.baidu.tieba.themeCenter.avatarPendant;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.s0.n3.c;
import tbclient.T;
/* loaded from: classes5.dex */
public class SetAvatarPendantModel extends BdBaseModel<BaseActivity<T>> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int TYPE_SET_USE = 1;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public long f21370e;

    /* renamed from: f  reason: collision with root package name */
    public int f21371f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f21372g;

    /* renamed from: h  reason: collision with root package name */
    public b f21373h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.c.c.g.a f21374i;

    /* loaded from: classes5.dex */
    public class a extends d.a.c.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SetAvatarPendantModel f21375a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(SetAvatarPendantModel setAvatarPendantModel, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {setAvatarPendantModel, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21375a = setAvatarPendantModel;
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof SetPendantHttpResponse;
            if (z || (responsedMessage instanceof SetPendantSocketResponse)) {
                if (responsedMessage.getError() == 0) {
                    this.f21375a.E(true);
                } else {
                    this.f21375a.E(false);
                }
                if (z) {
                    SetPendantHttpResponse setPendantHttpResponse = (SetPendantHttpResponse) responsedMessage;
                    this.f21375a.C(setPendantHttpResponse.getPendantId());
                    this.f21375a.f21371f = setPendantHttpResponse.getFreeUseLevel();
                } else if (responsedMessage instanceof SetPendantSocketResponse) {
                    SetPendantSocketResponse setPendantSocketResponse = (SetPendantSocketResponse) responsedMessage;
                    this.f21375a.C(setPendantSocketResponse.getPendantId());
                    this.f21375a.f21371f = setPendantSocketResponse.getFreeUseLevel();
                }
                if (this.f21375a.f21373h != null) {
                    int i2 = c.f64103b;
                    if (responsedMessage.getError() == c.f64104c) {
                        i2 = c.f64102a;
                    }
                    this.f21375a.f21373h.onSetPendantCallback(this.f21375a.f21372g, this.f21375a.f21370e, this.f21375a.f21371f, responsedMessage.getErrorString(), i2);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void onSetPendantCallback(boolean z, long j, int i2, String str, int i3);
    }

    public SetAvatarPendantModel() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f21372g = false;
        this.f21374i = new a(this, CmdConfigHttp.CMD_SET_PENDANT, 309412);
        d.a.s0.h3.d0.a.h(309412, SetPendantSocketResponse.class, false, false);
        d.a.s0.h3.d0.a.c(309412, CmdConfigHttp.CMD_SET_PENDANT, TbConfig.SET_PENDANT, SetPendantHttpResponse.class, true, true, true, true);
        registerListener(this.f21374i);
    }

    public void B(long j, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            SetPendantRequest setPendantRequest = new SetPendantRequest();
            setPendantRequest.setPendantId(j);
            setPendantRequest.setType(i2);
            setPendantRequest.setFreeUseLevel(i3);
            MessageManager.getInstance().sendMessage(setPendantRequest);
        }
    }

    public void C(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            this.f21370e = j;
        }
    }

    public void D(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.f21373h = bVar;
        }
    }

    public void E(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f21372g = z;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.f21374i);
        }
    }
}
