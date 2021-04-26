package com.baidu.wallet.paysdk.sms.controller;

import android.app.Dialog;
import com.baidu.apollon.armor.SafePay;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.core.utils.StringUtils;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.ui.widget.IdentifyCodeGetFailDialog;
/* loaded from: classes5.dex */
public class h extends d {
    @Override // com.baidu.wallet.paysdk.sms.controller.d, com.baidu.wallet.paysdk.sms.controller.ISmsController
    public Dialog doOnCreateDialog(int i2) {
        if (i2 == 23) {
            return new IdentifyCodeGetFailDialog(this.f26262a, IdentifyCodeGetFailDialog.VerifyCodeType.VOICE);
        }
        return super.doOnCreateDialog(i2);
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.d, com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void initSmsActivityView() {
        String string = ResUtils.getString(this.f26262a, "ebpay_submit_pay");
        PayRequest payRequest = this.f26265d;
        if (payRequest != null) {
            if (payRequest.mMktSolution != null) {
                string = String.format(ResUtils.getString(this.f26262a, "wallet_base_confirm_pay"), StringUtils.fen2Yuan(this.f26265d.mMktSolution.easypay_amount));
            } else {
                string = String.format(ResUtils.getString(this.f26262a, "wallet_base_confirm_pay"), StringUtils.fen2Yuan(this.f26265d.getFinalPayAmount()));
            }
        }
        this.f26263b.initSMSActivityView("ebpay_sms_top_tip_voice_verify", "", string, SafePay.unicodeDecode(SafePay.getInstance().localDecryptProxy(this.f26266e)), true);
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.d, com.baidu.wallet.paysdk.sms.controller.ISmsController
    public boolean isSendSmsOnCreate() {
        return false;
    }
}
