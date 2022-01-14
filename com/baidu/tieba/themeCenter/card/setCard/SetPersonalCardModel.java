package com.baidu.tieba.themeCenter.card.setCard;

import androidx.core.view.InputDeviceCompat;
import c.a.t0.c4.c;
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
/* loaded from: classes12.dex */
public class SetPersonalCardModel extends BdBaseModel<BaseActivity<Object>> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int TYPE_DELETE_USE = 2;
    public static final int TYPE_SET_USE = 1;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public long f48475e;

    /* renamed from: f  reason: collision with root package name */
    public int f48476f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f48477g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f48478h;

    /* renamed from: i  reason: collision with root package name */
    public b f48479i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.d.c.g.a f48480j;

    /* loaded from: classes12.dex */
    public class a extends c.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SetPersonalCardModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(SetPersonalCardModel setPersonalCardModel, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {setPersonalCardModel, Integer.valueOf(i2), Integer.valueOf(i3)};
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
            this.a = setPersonalCardModel;
        }

        @Override // c.a.d.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.a.f48478h = false;
                if (responsedMessage == null) {
                    return;
                }
                boolean z = responsedMessage instanceof SetPersonalCardHttpResponse;
                if (z || (responsedMessage instanceof SetPersonalCardSocketResponse)) {
                    if (responsedMessage.getError() == 0) {
                        this.a.D(true);
                    } else {
                        this.a.D(false);
                    }
                    if (z) {
                        SetPersonalCardHttpResponse setPersonalCardHttpResponse = (SetPersonalCardHttpResponse) responsedMessage;
                        this.a.setCardId(setPersonalCardHttpResponse.getCardId());
                        this.a.setType(setPersonalCardHttpResponse.getType());
                    } else if (responsedMessage instanceof SetPersonalCardSocketResponse) {
                        SetPersonalCardSocketResponse setPersonalCardSocketResponse = (SetPersonalCardSocketResponse) responsedMessage;
                        this.a.setCardId(setPersonalCardSocketResponse.getCardId());
                        this.a.setType(setPersonalCardSocketResponse.getType());
                    }
                    if (this.a.f48479i != null) {
                        int i2 = c.f15485b;
                        if (responsedMessage.getError() == c.f15486c) {
                            i2 = c.a;
                        }
                        this.a.f48479i.a(this.a.f48477g, this.a.f48475e, this.a.f48476f, responsedMessage.getErrorString(), i2);
                    }
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public interface b {
        void a(boolean z, long j2, int i2, String str, int i3);
    }

    public SetPersonalCardModel() {
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
        this.f48477g = false;
        this.f48478h = false;
        this.f48480j = new a(this, CmdConfigHttp.CMD_SET_PERSONAL_CARD, 309345);
        c.a.t0.w3.f0.a.h(309345, SetPersonalCardSocketResponse.class, false, false);
        c.a.t0.w3.f0.a.c(309345, CmdConfigHttp.CMD_SET_PERSONAL_CARD, TbConfig.SET_PERSONAL_CARD, SetPersonalCardHttpResponse.class, false, false, false, false);
        registerListener(this.f48480j);
    }

    public void B(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f48479i = bVar;
        }
    }

    public void C(long j2, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2)}) == null) || this.f48478h) {
            return;
        }
        this.f48478h = true;
        SetPersonalCardRequest setPersonalCardRequest = new SetPersonalCardRequest();
        setPersonalCardRequest.setCardId(j2);
        setPersonalCardRequest.setType(i2);
        sendMessage(setPersonalCardRequest);
    }

    public void D(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.f48477g = z;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f48476f : invokeV.intValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
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
            MessageManager.getInstance().unRegisterListener(this.f48480j);
        }
    }

    public void setCardId(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j2) == null) {
            this.f48475e = j2;
        }
    }

    public void setType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f48476f = i2;
        }
    }
}
