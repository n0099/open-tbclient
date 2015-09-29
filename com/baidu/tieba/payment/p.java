package com.baidu.tieba.payment;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.PayTBeanActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.payment.data.PayRequestData;
import com.baidu.tieba.payment.message.ResponsePaymentConfirmInfoMessage;
import com.baidu.tieba.payment.message.ResponsePaymentPayMessage;
import com.baidu.tieba.tbadkCore.data.PaymentConfirmRequestData;
/* loaded from: classes.dex */
public class p<T> extends com.baidu.adp.base.e<T> {
    private com.baidu.adp.base.h<T> cdE;

    public p(com.baidu.adp.base.h<T> hVar) {
        this.cdE = hVar;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public void a(PaymentConfirmRequestData paymentConfirmRequestData) {
        if (paymentConfirmRequestData != null) {
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
            httpMessage.addParam(PayTBeanActivityConfig.PAY_TYPE, String.valueOf(paymentConfirmRequestData.getPay_type()));
            this.cdE.sendMessage(httpMessage);
        }
    }

    public void aek() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_PAYMENT_CONFIRM_INFO, String.valueOf(TbConfig.SERVER_ADDRESS) + "c/e/consume/getBuyForm");
        tbHttpMessageTask.setResponsedClass(ResponsePaymentConfirmInfoMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    public void a(PayRequestData payRequestData) {
        if (payRequestData != null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PAYMENT_PAY);
            httpMessage.addParam("order_id", payRequestData.getOrderId());
            httpMessage.addParam("scene_id", String.valueOf(payRequestData.getSceneId()));
            httpMessage.addParam("open_id", payRequestData.getOpenId());
            httpMessage.addParam("tbs", payRequestData.getTbs());
            httpMessage.addParam("captcha_vcode_str", payRequestData.getCaptchaVcodeStr());
            httpMessage.addParam("captcha_input_str", payRequestData.getCaptchaInputStr());
            httpMessage.addParam("password", payRequestData.getPassword());
            httpMessage.addParam("bindid", payRequestData.getBindId());
            httpMessage.addParam("mobile_check", payRequestData.getMobileCheck());
            this.cdE.sendMessage(httpMessage);
        }
    }

    public void aes() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_PAYMENT_PAY, String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/encourage/consume/payOpenGoods");
        tbHttpMessageTask.setResponsedClass(ResponsePaymentPayMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }
}
