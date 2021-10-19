package com.baidu.tieba.payment;

import c.a.e.a.f;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
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
/* loaded from: classes7.dex */
public class PaymentConfirmModel<T> extends BdBaseModel<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public f<T> f54929e;

    public PaymentConfirmModel(f<T> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f54929e = fVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void w(PayRequestData payRequestData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, payRequestData) == null) || payRequestData == null) {
            return;
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PAYMENT_PAY);
        httpMessage.addParam("order_id", payRequestData.getOrderId());
        httpMessage.addParam("scene_id", String.valueOf(payRequestData.getSceneId()));
        httpMessage.addParam("open_id", payRequestData.getOpenId());
        httpMessage.addParam(HttpRequest.TBS, payRequestData.getTbs());
        httpMessage.addParam("captcha_vcode_str", payRequestData.getCaptchaVcodeStr());
        httpMessage.addParam("captcha_input_str", payRequestData.getCaptchaInputStr());
        httpMessage.addParam("password", payRequestData.getPassword());
        httpMessage.addParam("bindid", payRequestData.getBindId());
        httpMessage.addParam("mobile_check", payRequestData.getMobileCheck());
        this.f54929e.sendMessage(httpMessage);
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            MessageManager messageManager = MessageManager.getInstance();
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_PAYMENT_CONFIRM_INFO, TbConfig.SERVER_ADDRESS + "c/e/consume/getBuyForm");
            tbHttpMessageTask.setResponsedClass(ResponsePaymentConfirmInfoMessage.class);
            messageManager.registerTask(tbHttpMessageTask);
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            MessageManager messageManager = MessageManager.getInstance();
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_PAYMENT_PAY, TbConfig.SERVER_ADDRESS + "c/c/encourage/consume/payOpenGoods");
            tbHttpMessageTask.setResponsedClass(ResponsePaymentPayMessage.class);
            messageManager.registerTask(tbHttpMessageTask);
        }
    }

    public void z(PaymentConfirmRequestData paymentConfirmRequestData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, paymentConfirmRequestData) == null) || paymentConfirmRequestData == null) {
            return;
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PAYMENT_CONFIRM_INFO);
        httpMessage.addParam("tdou_num", String.valueOf(paymentConfirmRequestData.getTdou_num()));
        httpMessage.addParam("open_id", String.valueOf(paymentConfirmRequestData.getOpen_id()));
        httpMessage.addParam("order_id", String.valueOf(paymentConfirmRequestData.getOrder_id()));
        httpMessage.addParam("scene_id", String.valueOf(paymentConfirmRequestData.getScene_id()));
        httpMessage.addParam("goods_name", paymentConfirmRequestData.getGoods_name());
        httpMessage.addParam("goods_pic", paymentConfirmRequestData.getGoods_pic());
        httpMessage.addParam("terminal", paymentConfirmRequestData.getTerminal());
        httpMessage.addParam("goods_num", String.valueOf(paymentConfirmRequestData.getGoods_num()));
        httpMessage.addParam("goods_unit", paymentConfirmRequestData.getGoods_unit());
        httpMessage.addParam("goods_duration", String.valueOf(paymentConfirmRequestData.getGoods_duration()));
        httpMessage.addParam("goods_user_level", String.valueOf(paymentConfirmRequestData.getGoods_user_level()));
        httpMessage.addParam("pay_type", String.valueOf(paymentConfirmRequestData.getPay_type()));
        httpMessage.addParam("currency", paymentConfirmRequestData.getCurrency());
        this.f54929e.sendMessage(httpMessage);
    }
}
