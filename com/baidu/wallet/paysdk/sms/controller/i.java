package com.baidu.wallet.paysdk.sms.controller;

import android.app.Dialog;
import com.baidu.apollon.armor.SafePay;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.core.utils.StringUtils;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.ui.widget.IdentifyCodeGetFailDialog;
/* loaded from: classes5.dex */
public class i extends f {
    @Override // com.baidu.wallet.paysdk.sms.controller.f, com.baidu.wallet.paysdk.sms.controller.ISmsController
    public Dialog doOnCreateDialog(int i) {
        if (i == 23) {
            return new IdentifyCodeGetFailDialog(this.f25514c, IdentifyCodeGetFailDialog.VerifyCodeType.VOICE);
        }
        return super.doOnCreateDialog(i);
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.f, com.baidu.wallet.paysdk.sms.controller.ISmsController
    public void initSmsActivityView() {
        String string = ResUtils.getString(this.f25514c, "ebpay_submit_pay");
        PayRequest payRequest = this.f25513b;
        if (payRequest != null) {
            if (payRequest.mMktSolution != null) {
                string = String.format(ResUtils.getString(this.f25514c, "wallet_base_confirm_pay"), StringUtils.fen2Yuan(this.f25513b.mMktSolution.easypay_amount));
            } else {
                string = String.format(ResUtils.getString(this.f25514c, "wallet_base_confirm_pay"), StringUtils.fen2Yuan(this.f25513b.getFinalPayAmount()));
            }
        }
        this.f25515d.initSMSActivityView("ebpay_sms_top_tip_voice_verify", "", string, SafePay.unicodeDecode(SafePay.getInstance().localDecryptProxy(this.f25517f)), true);
    }

    @Override // com.baidu.wallet.paysdk.sms.controller.f, com.baidu.wallet.paysdk.sms.controller.ISmsController
    public boolean isSendSmsOnCreate() {
        return false;
    }
}
