package com.baidu.tieba.wallet.pay;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.pay.PayConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.a.f;
import d.a.c.e.m.b;
/* loaded from: classes4.dex */
public class GetOrderModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String mWalletSdkUa;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetOrderModel(BaseActivity<?> baseActivity) {
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
    }

    private GetOrderNetMessage createNetMessage(PayConfig payConfig) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, payConfig)) == null) {
            GetOrderNetMessage getOrderNetMessage = new GetOrderNetMessage();
            getOrderNetMessage.setParams(payConfig.getPayType(), b.d(payConfig.getIsLeft(), 0), payConfig.getPropsId(), b.d(payConfig.getMoney(), 0), b.d(payConfig.getPropsMon(), 0), payConfig.isAutoPay(), payConfig.paymentPosKey, this.mWalletSdkUa);
            getOrderNetMessage.mReferPage = payConfig.mReferPage;
            getOrderNetMessage.mClickZone = payConfig.mClickZone;
            return getOrderNetMessage;
        }
        return (GetOrderNetMessage) invokeL.objValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean sendMessage(PayConfig payConfig) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, payConfig)) == null) {
            if (payConfig == null) {
                return false;
            }
            sendMessage(createNetMessage(payConfig));
            return true;
        }
        return invokeL.booleanValue;
    }

    public void setWalletSdkUa(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.mWalletSdkUa = str;
        }
    }
}
