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
import d.a.q0.n3.c;
import tbclient.T;
/* loaded from: classes4.dex */
public class SetAvatarPendantModel extends BdBaseModel<BaseActivity<T>> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int TYPE_SET_USE = 1;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public long f21534e;

    /* renamed from: f  reason: collision with root package name */
    public int f21535f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f21536g;

    /* renamed from: h  reason: collision with root package name */
    public b f21537h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.d.c.g.a f21538i;

    /* loaded from: classes4.dex */
    public class a extends d.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SetAvatarPendantModel f21539a;

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
            this.f21539a = setAvatarPendantModel;
        }

        @Override // d.a.d.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof SetPendantHttpResponse;
            if (z || (responsedMessage instanceof SetPendantSocketResponse)) {
                if (responsedMessage.getError() == 0) {
                    this.f21539a.E(true);
                } else {
                    this.f21539a.E(false);
                }
                if (z) {
                    SetPendantHttpResponse setPendantHttpResponse = (SetPendantHttpResponse) responsedMessage;
                    this.f21539a.C(setPendantHttpResponse.getPendantId());
                    this.f21539a.f21535f = setPendantHttpResponse.getFreeUseLevel();
                } else if (responsedMessage instanceof SetPendantSocketResponse) {
                    SetPendantSocketResponse setPendantSocketResponse = (SetPendantSocketResponse) responsedMessage;
                    this.f21539a.C(setPendantSocketResponse.getPendantId());
                    this.f21539a.f21535f = setPendantSocketResponse.getFreeUseLevel();
                }
                if (this.f21539a.f21537h != null) {
                    int i2 = c.f61483b;
                    if (responsedMessage.getError() == c.f61484c) {
                        i2 = c.f61482a;
                    }
                    this.f21539a.f21537h.onSetPendantCallback(this.f21539a.f21536g, this.f21539a.f21534e, this.f21539a.f21535f, responsedMessage.getErrorString(), i2);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
        this.f21536g = false;
        this.f21538i = new a(this, CmdConfigHttp.CMD_SET_PENDANT, 309412);
        d.a.q0.h3.d0.a.h(309412, SetPendantSocketResponse.class, false, false);
        d.a.q0.h3.d0.a.c(309412, CmdConfigHttp.CMD_SET_PENDANT, TbConfig.SET_PENDANT, SetPendantHttpResponse.class, true, true, true, true);
        registerListener(this.f21538i);
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
            this.f21534e = j;
        }
    }

    public void D(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.f21537h = bVar;
        }
    }

    public void E(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f21536g = z;
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
            MessageManager.getInstance().unRegisterListener(this.f21538i);
        }
    }
}
