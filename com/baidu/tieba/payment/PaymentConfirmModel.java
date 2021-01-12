package com.baidu.tieba.payment;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.f;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.payment.data.PayRequestData;
import com.baidu.tieba.payment.message.ResponsePaymentConfirmInfoMessage;
import com.baidu.tieba.payment.message.ResponsePaymentPayMessage;
import com.baidu.tieba.tbadkCore.data.PaymentConfirmRequestData;
/* loaded from: classes8.dex */
public class PaymentConfirmModel<T> extends BdBaseModel<T> {
    private f<T> lyz;

    public PaymentConfirmModel(f<T> fVar) {
        this.lyz = fVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void a(PaymentConfirmRequestData paymentConfirmRequestData) {
        if (paymentConfirmRequestData != null) {
            HttpMessage httpMessage = new HttpMessage(1001536);
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
            this.lyz.sendMessage(httpMessage);
        }
    }

    public void dih() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1001536, TbConfig.SERVER_ADDRESS + Config.PAYMENT_CONFIRM_INFO);
        tbHttpMessageTask.setResponsedClass(ResponsePaymentConfirmInfoMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    public void a(PayRequestData payRequestData) {
        if (payRequestData != null) {
            HttpMessage httpMessage = new HttpMessage(1001537);
            httpMessage.addParam("order_id", payRequestData.getOrderId());
            httpMessage.addParam("scene_id", String.valueOf(payRequestData.getSceneId()));
            httpMessage.addParam("open_id", payRequestData.getOpenId());
            httpMessage.addParam("tbs", payRequestData.getTbs());
            httpMessage.addParam("captcha_vcode_str", payRequestData.getCaptchaVcodeStr());
            httpMessage.addParam("captcha_input_str", payRequestData.getCaptchaInputStr());
            httpMessage.addParam("password", payRequestData.getPassword());
            httpMessage.addParam("bindid", payRequestData.getBindId());
            httpMessage.addParam("mobile_check", payRequestData.getMobileCheck());
            this.lyz.sendMessage(httpMessage);
        }
    }

    public void dip() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1001537, TbConfig.SERVER_ADDRESS + Config.PAYMENT_PAY);
        tbHttpMessageTask.setResponsedClass(ResponsePaymentPayMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }
}
