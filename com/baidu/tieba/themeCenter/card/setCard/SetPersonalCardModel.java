package com.baidu.tieba.themeCenter.card.setCard;

import androidx.core.view.InputDeviceCompat;
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
public class SetPersonalCardModel extends BdBaseModel<BaseActivity<T>> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int TYPE_DELETE_USE = 2;
    public static final int TYPE_SET_USE = 1;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public long f54600e;

    /* renamed from: f  reason: collision with root package name */
    public int f54601f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f54602g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f54603h;

    /* renamed from: i  reason: collision with root package name */
    public b f54604i;
    public b.a.e.c.g.a j;

    /* loaded from: classes9.dex */
    public class a extends b.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SetPersonalCardModel f54605a;

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
            this.f54605a = setPersonalCardModel;
        }

        @Override // b.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.f54605a.f54603h = false;
                if (responsedMessage == null) {
                    return;
                }
                boolean z = responsedMessage instanceof SetPersonalCardHttpResponse;
                if (z || (responsedMessage instanceof SetPersonalCardSocketResponse)) {
                    if (responsedMessage.getError() == 0) {
                        this.f54605a.D(true);
                    } else {
                        this.f54605a.D(false);
                    }
                    if (z) {
                        SetPersonalCardHttpResponse setPersonalCardHttpResponse = (SetPersonalCardHttpResponse) responsedMessage;
                        this.f54605a.setCardId(setPersonalCardHttpResponse.getCardId());
                        this.f54605a.setType(setPersonalCardHttpResponse.getType());
                    } else if (responsedMessage instanceof SetPersonalCardSocketResponse) {
                        SetPersonalCardSocketResponse setPersonalCardSocketResponse = (SetPersonalCardSocketResponse) responsedMessage;
                        this.f54605a.setCardId(setPersonalCardSocketResponse.getCardId());
                        this.f54605a.setType(setPersonalCardSocketResponse.getType());
                    }
                    if (this.f54605a.f54604i != null) {
                        int i2 = c.f23080b;
                        if (responsedMessage.getError() == c.f23081c) {
                            i2 = c.f23079a;
                        }
                        this.f54605a.f54604i.a(this.f54605a.f54602g, this.f54605a.f54600e, this.f54605a.f54601f, responsedMessage.getErrorString(), i2);
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface b {
        void a(boolean z, long j, int i2, String str, int i3);
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
        this.f54602g = false;
        this.f54603h = false;
        this.j = new a(this, CmdConfigHttp.CMD_SET_PERSONAL_CARD, 309345);
        b.a.r0.l3.f0.a.h(309345, SetPersonalCardSocketResponse.class, false, false);
        b.a.r0.l3.f0.a.c(309345, CmdConfigHttp.CMD_SET_PERSONAL_CARD, TbConfig.SET_PERSONAL_CARD, SetPersonalCardHttpResponse.class, false, false, false, false);
        registerListener(this.j);
    }

    public void B(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f54604i = bVar;
        }
    }

    public void C(long j, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), Integer.valueOf(i2)}) == null) || this.f54603h) {
            return;
        }
        this.f54603h = true;
        SetPersonalCardRequest setPersonalCardRequest = new SetPersonalCardRequest();
        setPersonalCardRequest.setCardId(j);
        setPersonalCardRequest.setType(i2);
        sendMessage(setPersonalCardRequest);
    }

    public void D(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.f54602g = z;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f54601f : invokeV.intValue;
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
            MessageManager.getInstance().unRegisterListener(this.j);
        }
    }

    public void setCardId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j) == null) {
            this.f54600e = j;
        }
    }

    public void setType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f54601f = i2;
        }
    }
}
