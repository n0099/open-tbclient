package com.baidu.tieba.themeCenter.avatarPendant;

import c.a.p0.f4.c;
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
/* loaded from: classes6.dex */
public class SetAvatarPendantModel extends BdBaseModel<BaseActivity<Object>> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int TYPE_SET_USE = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public int f36305b;

    /* renamed from: c  reason: collision with root package name */
    public int f36306c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f36307d;

    /* renamed from: e  reason: collision with root package name */
    public b f36308e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.d.c.g.a f36309f;

    /* loaded from: classes6.dex */
    public class a extends c.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SetAvatarPendantModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(SetAvatarPendantModel setAvatarPendantModel, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {setAvatarPendantModel, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = setAvatarPendantModel;
        }

        @Override // c.a.d.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof SetPendantHttpResponse;
            if (z || (responsedMessage instanceof SetPendantSocketResponse)) {
                if (responsedMessage.getError() == 0) {
                    this.a.G(true);
                } else {
                    this.a.G(false);
                }
                if (z) {
                    SetPendantHttpResponse setPendantHttpResponse = (SetPendantHttpResponse) responsedMessage;
                    this.a.E(setPendantHttpResponse.getPendantId());
                    this.a.f36306c = setPendantHttpResponse.getFreeUseLevel();
                } else if (responsedMessage instanceof SetPendantSocketResponse) {
                    SetPendantSocketResponse setPendantSocketResponse = (SetPendantSocketResponse) responsedMessage;
                    this.a.E(setPendantSocketResponse.getPendantId());
                    this.a.f36306c = setPendantSocketResponse.getFreeUseLevel();
                }
                if (this.a.f36308e != null) {
                    int i = c.f14994b;
                    if (responsedMessage.getError() == c.f14995c) {
                        i = c.a;
                    }
                    this.a.f36308e.onSetPendantCallback(this.a.f36307d, this.a.a, this.a.f36306c, responsedMessage.getErrorString(), i);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        void onSetPendantCallback(boolean z, long j, int i, String str, int i2);
    }

    public SetAvatarPendantModel() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f36307d = false;
        this.f36309f = new a(this, CmdConfigHttp.CMD_SET_PENDANT, 309412);
        c.a.p0.a4.g0.a.h(309412, SetPendantSocketResponse.class, false, false);
        c.a.p0.a4.g0.a.c(309412, CmdConfigHttp.CMD_SET_PENDANT, TbConfig.SET_PENDANT, SetPendantHttpResponse.class, true, true, true, true);
        registerListener(this.f36309f);
    }

    public void D(long j, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2)}) == null) {
            SetPendantRequest setPendantRequest = new SetPendantRequest();
            setPendantRequest.setPendantId(j);
            setPendantRequest.setType(i);
            setPendantRequest.setFreeUseLevel(i2);
            MessageManager.getInstance().sendMessage(setPendantRequest);
        }
    }

    public void E(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            this.a = j;
        }
    }

    public void F(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.f36308e = bVar;
        }
    }

    public void G(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f36307d = z;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f36305b : invokeV.intValue;
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
            MessageManager.getInstance().unRegisterListener(this.f36309f);
        }
    }
}
