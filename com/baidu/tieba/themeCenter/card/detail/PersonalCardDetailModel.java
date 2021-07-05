package com.baidu.tieba.themeCenter.card.detail;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class PersonalCardDetailModel extends BdBaseModel<PersonalCardDetailActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public d.a.s0.n3.a f21451e;

    /* renamed from: f  reason: collision with root package name */
    public b f21452f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.c.c.g.a f21453g;

    /* loaded from: classes5.dex */
    public class a extends d.a.c.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalCardDetailModel f21454a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(PersonalCardDetailModel personalCardDetailModel, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalCardDetailModel, Integer.valueOf(i2), Integer.valueOf(i3)};
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
            this.f21454a = personalCardDetailModel;
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof PersonalCardDetailHttpReponse;
            if (z || (responsedMessage instanceof PersonalCardDetailSocketReponse)) {
                if (z) {
                    this.f21454a.f21451e = ((PersonalCardDetailHttpReponse) responsedMessage).getCardData();
                } else if (responsedMessage instanceof PersonalCardDetailSocketReponse) {
                    this.f21454a.f21451e = ((PersonalCardDetailSocketReponse) responsedMessage).getCardData();
                }
                if (this.f21454a.f21452f != null) {
                    this.f21454a.f21452f.a(responsedMessage.getError(), responsedMessage.getErrorString(), this.f21454a.f21451e);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(int i2, String str, d.a.s0.n3.a aVar);
    }

    public PersonalCardDetailModel() {
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
        this.f21453g = new a(this, CmdConfigHttp.CMD_GET_CARD_DETAIL, 309333);
        d.a.s0.h3.d0.a.h(309333, PersonalCardDetailSocketReponse.class, false, false);
        d.a.s0.h3.d0.a.c(309333, CmdConfigHttp.CMD_GET_CARD_DETAIL, TbConfig.GET_CARD_DETAIL, PersonalCardDetailHttpReponse.class, false, false, false, false);
        registerListener(this.f21453g);
    }

    public void A(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f21452f = bVar;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.f21453g);
        }
    }

    public void z(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j) == null) {
            PersonalCardDetailRequest personalCardDetailRequest = new PersonalCardDetailRequest();
            personalCardDetailRequest.setCardId(j);
            sendMessage(personalCardDetailRequest);
        }
    }
}
