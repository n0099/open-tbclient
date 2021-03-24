package com.baidu.tieba.payment;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.payment.data.PayRequestData;
import com.baidu.tieba.payment.message.ResponsePaymentConfirmInfoMessage;
import com.baidu.tieba.payment.message.ResponsePaymentPayMessage;
import com.baidu.tieba.tbadkCore.data.PaymentConfirmRequestData;
import d.b.b.a.f;
/* loaded from: classes4.dex */
public class PaymentConfirmModel<T> extends BdBaseModel<T> {

    /* renamed from: e  reason: collision with root package name */
    public f<T> f19454e;

    public PaymentConfirmModel(f<T> fVar) {
        this.f19454e = fVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void s(PayRequestData payRequestData) {
        if (payRequestData == null) {
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
        this.f19454e.sendMessage(httpMessage);
    }

    public void t() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_PAYMENT_CONFIRM_INFO, TbConfig.SERVER_ADDRESS + "c/e/consume/getBuyForm");
        tbHttpMessageTask.setResponsedClass(ResponsePaymentConfirmInfoMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    public void u() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_PAYMENT_PAY, TbConfig.SERVER_ADDRESS + "c/c/encourage/consume/payOpenGoods");
        tbHttpMessageTask.setResponsedClass(ResponsePaymentPayMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    public void v(PaymentConfirmRequestData paymentConfirmRequestData) {
        if (paymentConfirmRequestData == null) {
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
        this.f19454e.sendMessage(httpMessage);
    }
}
