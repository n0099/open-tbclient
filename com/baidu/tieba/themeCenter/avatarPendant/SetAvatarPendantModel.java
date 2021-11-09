package com.baidu.tieba.themeCenter.avatarPendant;

import b.a.r0.r3.c;
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
    public long f54515e;

    /* renamed from: f  reason: collision with root package name */
    public int f54516f;

    /* renamed from: g  reason: collision with root package name */
    public int f54517g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f54518h;

    /* renamed from: i  reason: collision with root package name */
    public b f54519i;
    public b.a.e.c.g.a j;

    /* loaded from: classes9.dex */
    public class a extends b.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SetAvatarPendantModel f54520a;

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
            this.f54520a = setAvatarPendantModel;
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
                    this.f54520a.E(true);
                } else {
                    this.f54520a.E(false);
                }
                if (z) {
                    SetPendantHttpResponse setPendantHttpResponse = (SetPendantHttpResponse) responsedMessage;
                    this.f54520a.C(setPendantHttpResponse.getPendantId());
                    this.f54520a.f54517g = setPendantHttpResponse.getFreeUseLevel();
                } else if (responsedMessage instanceof SetPendantSocketResponse) {
                    SetPendantSocketResponse setPendantSocketResponse = (SetPendantSocketResponse) responsedMessage;
                    this.f54520a.C(setPendantSocketResponse.getPendantId());
                    this.f54520a.f54517g = setPendantSocketResponse.getFreeUseLevel();
                }
                if (this.f54520a.f54519i != null) {
                    int i2 = c.f23080b;
                    if (responsedMessage.getError() == c.f23081c) {
                        i2 = c.f23079a;
                    }
                    this.f54520a.f54519i.onSetPendantCallback(this.f54520a.f54518h, this.f54520a.f54515e, this.f54520a.f54517g, responsedMessage.getErrorString(), i2);
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
        this.f54518h = false;
        this.j = new a(this, CmdConfigHttp.CMD_SET_PENDANT, 309412);
        b.a.r0.l3.f0.a.h(309412, SetPendantSocketResponse.class, false, false);
        b.a.r0.l3.f0.a.c(309412, CmdConfigHttp.CMD_SET_PENDANT, TbConfig.SET_PENDANT, SetPendantHttpResponse.class, true, true, true, true);
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
            this.f54515e = j;
        }
    }

    public void D(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.f54519i = bVar;
        }
    }

    public void E(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f54518h = z;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f54516f : invokeV.intValue;
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
