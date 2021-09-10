package com.baidu.tieba.themeCenter.card.setCard;

import c.a.r0.p3.c;
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
/* loaded from: classes7.dex */
public class SetPersonalCardModel extends BdBaseModel<BaseActivity<T>> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int TYPE_DELETE_USE = 2;
    public static final int TYPE_SET_USE = 1;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public long f57500e;

    /* renamed from: f  reason: collision with root package name */
    public int f57501f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f57502g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f57503h;

    /* renamed from: i  reason: collision with root package name */
    public b f57504i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.e.c.g.a f57505j;

    /* loaded from: classes7.dex */
    public class a extends c.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SetPersonalCardModel f57506a;

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
            this.f57506a = setPersonalCardModel;
        }

        @Override // c.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.f57506a.f57503h = false;
                if (responsedMessage == null) {
                    return;
                }
                boolean z = responsedMessage instanceof SetPersonalCardHttpResponse;
                if (z || (responsedMessage instanceof SetPersonalCardSocketResponse)) {
                    if (responsedMessage.getError() == 0) {
                        this.f57506a.D(true);
                    } else {
                        this.f57506a.D(false);
                    }
                    if (z) {
                        SetPersonalCardHttpResponse setPersonalCardHttpResponse = (SetPersonalCardHttpResponse) responsedMessage;
                        this.f57506a.setCardId(setPersonalCardHttpResponse.getCardId());
                        this.f57506a.setType(setPersonalCardHttpResponse.getType());
                    } else if (responsedMessage instanceof SetPersonalCardSocketResponse) {
                        SetPersonalCardSocketResponse setPersonalCardSocketResponse = (SetPersonalCardSocketResponse) responsedMessage;
                        this.f57506a.setCardId(setPersonalCardSocketResponse.getCardId());
                        this.f57506a.setType(setPersonalCardSocketResponse.getType());
                    }
                    if (this.f57506a.f57504i != null) {
                        int i2 = c.f23870b;
                        if (responsedMessage.getError() == c.f23871c) {
                            i2 = c.f23869a;
                        }
                        this.f57506a.f57504i.a(this.f57506a.f57502g, this.f57506a.f57500e, this.f57506a.f57501f, responsedMessage.getErrorString(), i2);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
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
        this.f57502g = false;
        this.f57503h = false;
        this.f57505j = new a(this, CmdConfigHttp.CMD_SET_PERSONAL_CARD, 309345);
        c.a.r0.j3.d0.a.h(309345, SetPersonalCardSocketResponse.class, false, false);
        c.a.r0.j3.d0.a.c(309345, CmdConfigHttp.CMD_SET_PERSONAL_CARD, TbConfig.SET_PERSONAL_CARD, SetPersonalCardHttpResponse.class, false, false, false, false);
        registerListener(this.f57505j);
    }

    public void B(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f57504i = bVar;
        }
    }

    public void C(long j2, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2)}) == null) || this.f57503h) {
            return;
        }
        this.f57503h = true;
        SetPersonalCardRequest setPersonalCardRequest = new SetPersonalCardRequest();
        setPersonalCardRequest.setCardId(j2);
        setPersonalCardRequest.setType(i2);
        sendMessage(setPersonalCardRequest);
    }

    public void D(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.f57502g = z;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
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

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.f57505j);
        }
    }

    public void setCardId(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j2) == null) {
            this.f57500e = j2;
        }
    }

    public void setType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f57501f = i2;
        }
    }
}
