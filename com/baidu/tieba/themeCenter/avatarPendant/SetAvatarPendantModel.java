package com.baidu.tieba.themeCenter.avatarPendant;

import b.a.r0.s3.c;
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
import tbclient.T;
/* loaded from: classes9.dex */
public class SetAvatarPendantModel extends BdBaseModel<BaseActivity<T>> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int TYPE_SET_USE = 1;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public long f55435e;

    /* renamed from: f  reason: collision with root package name */
    public int f55436f;

    /* renamed from: g  reason: collision with root package name */
    public int f55437g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f55438h;

    /* renamed from: i  reason: collision with root package name */
    public b f55439i;
    public b.a.e.c.g.a j;

    /* loaded from: classes9.dex */
    public class a extends b.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SetAvatarPendantModel f55440a;

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
            this.f55440a = setAvatarPendantModel;
        }

        @Override // b.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof SetPendantHttpResponse;
            if (z || (responsedMessage instanceof SetPendantSocketResponse)) {
                if (responsedMessage.getError() == 0) {
                    this.f55440a.E(true);
                } else {
                    this.f55440a.E(false);
                }
                if (z) {
                    SetPendantHttpResponse setPendantHttpResponse = (SetPendantHttpResponse) responsedMessage;
                    this.f55440a.C(setPendantHttpResponse.getPendantId());
                    this.f55440a.f55437g = setPendantHttpResponse.getFreeUseLevel();
                } else if (responsedMessage instanceof SetPendantSocketResponse) {
                    SetPendantSocketResponse setPendantSocketResponse = (SetPendantSocketResponse) responsedMessage;
                    this.f55440a.C(setPendantSocketResponse.getPendantId());
                    this.f55440a.f55437g = setPendantSocketResponse.getFreeUseLevel();
                }
                if (this.f55440a.f55439i != null) {
                    int i2 = c.f24867b;
                    if (responsedMessage.getError() == c.f24868c) {
                        i2 = c.f24866a;
                    }
                    this.f55440a.f55439i.onSetPendantCallback(this.f55440a.f55438h, this.f55440a.f55435e, this.f55440a.f55437g, responsedMessage.getErrorString(), i2);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
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
        this.f55438h = false;
        this.j = new a(this, CmdConfigHttp.CMD_SET_PENDANT, 309412);
        b.a.r0.m3.f0.a.h(309412, SetPendantSocketResponse.class, false, false);
        b.a.r0.m3.f0.a.c(309412, CmdConfigHttp.CMD_SET_PENDANT, TbConfig.SET_PENDANT, SetPendantHttpResponse.class, true, true, true, true);
        registerListener(this.j);
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
            this.f55435e = j;
        }
    }

    public void D(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.f55439i = bVar;
        }
    }

    public void E(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f55438h = z;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f55436f : invokeV.intValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.j);
        }
    }
}
