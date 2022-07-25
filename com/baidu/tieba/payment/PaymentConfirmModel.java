package com.baidu.tieba.payment;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.views.logindialog.view.a;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.payment.data.PayRequestData;
import com.baidu.tieba.payment.message.ResponsePaymentConfirmInfoMessage;
import com.baidu.tieba.payment.message.ResponsePaymentPayMessage;
import com.baidu.tieba.tbadkCore.data.PaymentConfirmRequestData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.d9;
/* loaded from: classes3.dex */
public class PaymentConfirmModel<T> extends BdBaseModel<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d9<T> a;

    public PaymentConfirmModel(d9<T> d9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {d9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = d9Var;
    }

    public void A(PayRequestData payRequestData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, payRequestData) == null) || payRequestData == null) {
            return;
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PAYMENT_PAY);
        httpMessage.addParam("order_id", payRequestData.getOrderId());
        httpMessage.addParam(MemberPayActivityConfig.SCENE_ID, String.valueOf(payRequestData.getSceneId()));
        httpMessage.addParam("open_id", payRequestData.getOpenId());
        httpMessage.addParam(HttpRequest.TBS, payRequestData.getTbs());
        httpMessage.addParam("captcha_vcode_str", payRequestData.getCaptchaVcodeStr());
        httpMessage.addParam("captcha_input_str", payRequestData.getCaptchaInputStr());
        httpMessage.addParam(a.m, payRequestData.getPassword());
        httpMessage.addParam("bindid", payRequestData.getBindId());
        httpMessage.addParam("mobile_check", payRequestData.getMobileCheck());
        this.a.sendMessage(httpMessage);
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            MessageManager messageManager = MessageManager.getInstance();
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_PAYMENT_CONFIRM_INFO, TbConfig.SERVER_ADDRESS + "c/e/consume/getBuyForm");
            tbHttpMessageTask.setResponsedClass(ResponsePaymentConfirmInfoMessage.class);
            messageManager.registerTask(tbHttpMessageTask);
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            MessageManager messageManager = MessageManager.getInstance();
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_PAYMENT_PAY, TbConfig.SERVER_ADDRESS + "c/c/encourage/consume/payOpenGoods");
            tbHttpMessageTask.setResponsedClass(ResponsePaymentPayMessage.class);
            messageManager.registerTask(tbHttpMessageTask);
        }
    }

    public void D(PaymentConfirmRequestData paymentConfirmRequestData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, paymentConfirmRequestData) == null) || paymentConfirmRequestData == null) {
            return;
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PAYMENT_CONFIRM_INFO);
        httpMessage.addParam("tdou_num", String.valueOf(paymentConfirmRequestData.getTdou_num()));
        httpMessage.addParam("open_id", String.valueOf(paymentConfirmRequestData.getOpen_id()));
        httpMessage.addParam("order_id", String.valueOf(paymentConfirmRequestData.getOrder_id()));
        httpMessage.addParam(MemberPayActivityConfig.SCENE_ID, String.valueOf(paymentConfirmRequestData.getScene_id()));
        httpMessage.addParam("goods_name", paymentConfirmRequestData.getGoods_name());
        httpMessage.addParam("goods_pic", paymentConfirmRequestData.getGoods_pic());
        httpMessage.addParam("terminal", paymentConfirmRequestData.getTerminal());
        httpMessage.addParam("goods_num", String.valueOf(paymentConfirmRequestData.getGoods_num()));
        httpMessage.addParam("goods_unit", paymentConfirmRequestData.getGoods_unit());
        httpMessage.addParam("goods_duration", String.valueOf(paymentConfirmRequestData.getGoods_duration()));
        httpMessage.addParam("goods_user_level", String.valueOf(paymentConfirmRequestData.getGoods_user_level()));
        httpMessage.addParam("pay_type", String.valueOf(paymentConfirmRequestData.getPay_type()));
        httpMessage.addParam("currency", paymentConfirmRequestData.getCurrency());
        this.a.sendMessage(httpMessage);
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

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }
}
