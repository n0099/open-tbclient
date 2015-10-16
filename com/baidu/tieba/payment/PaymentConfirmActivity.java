package com.baidu.tieba.payment;

import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.BuyTBeanActivityConfig;
import com.baidu.tbadk.core.atomData.PayVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.PaymentConfirmActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.i;
import com.baidu.tieba.payment.data.PayRequestData;
import com.baidu.tieba.payment.data.PayVcodeInfoData;
import com.baidu.tieba.payment.data.PaymentConfirmInfoData;
import com.baidu.tieba.tbadkCore.data.PaymentConfirmRequestData;
import java.net.URLEncoder;
/* loaded from: classes.dex */
public class PaymentConfirmActivity extends BaseActivity<PaymentConfirmActivity> {
    private q cdV;
    private p<PaymentConfirmActivity> cdW;
    private PaymentConfirmRequestData cdX;
    private boolean cdY;
    private boolean cdZ;
    private HttpMessageListener cea = new c(this, CmdConfigHttp.CMD_PAYMENT_CONFIRM_INFO);
    private HttpMessageListener ceb = new h(this, CmdConfigHttp.CMD_PAYMENT_PAY);
    private CustomMessageListener cec = new i(this, CmdConfigCustom.CMD_TDOU_PAY_BUNDING_PHONE);
    private String mUserId;
    private PaymentConfirmInfoData paymentConfirmInfoData;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData();
        initUI();
        AJ();
        aep();
        r.jz("c10291");
    }

    private void initData() {
        this.cdX = (PaymentConfirmRequestData) getIntent().getSerializableExtra(PaymentConfirmActivityConfig.REQUEST_PARAMS);
        this.cdW = new p<>(getPageContext());
    }

    private void initUI() {
        this.cdV = new q(this);
        this.cdV.aew().setChecked(com.baidu.tbadk.core.sharedPref.b.tu().getBoolean(jy("payment_confirm_show"), true) ? false : true);
        this.cdV.aew().setOnCheckedChangeListener(new j(this));
        this.cdV.aex().setOnClickListener(new k(this));
    }

    private void AJ() {
        this.cdW.aek();
        this.cdW.aes();
        registerListener(this.cea);
        registerListener(this.ceb);
        registerListener(this.cec);
    }

    private void aep() {
        if (com.baidu.adp.lib.util.k.jd()) {
            showLoadingView(this.cdV.aev(), false);
            this.cdW.a(this.cdX);
            return;
        }
        showNetRefreshViewNoClick(this.cdV.aev(), getResources().getString(i.h.neterror));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(PaymentConfirmInfoData paymentConfirmInfoData) {
        PaymentConfirmInfoData.UserInfo.UserScores parr_scores;
        PaymentConfirmInfoData.UserInfo user_info = paymentConfirmInfoData.getUser_info();
        PaymentConfirmInfoData.GoodsInfo goods_info = paymentConfirmInfoData.getGoods_info();
        return (user_info == null || goods_info == null || (parr_scores = user_info.getParr_scores()) == null || parr_scores.getScores_total() < goods_info.getTdou_num()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(PaymentConfirmInfoData paymentConfirmInfoData, boolean z) {
        PaymentConfirmInfoData.OrderInfo order_info;
        PaymentConfirmInfoData.OrderInfo.Cpath cpath;
        if (paymentConfirmInfoData == null || (order_info = paymentConfirmInfoData.getOrder_info()) == null || (cpath = order_info.getCpath()) == null) {
            return false;
        }
        if (z) {
            if (cpath.getPay_cashier() == 1) {
                aer();
                return true;
            }
        } else if (cpath.getGettdou_cashier() == 1) {
            aeq();
            return true;
        }
        if (cpath.getTip_exist() != 1 || com.baidu.tbadk.core.sharedPref.b.tu().getBoolean(jy("payment_confirm_show"), true)) {
            return false;
        }
        int i = com.baidu.tbadk.core.sharedPref.b.tu().getInt(jy("payment_confirm_notshow_count"), 0);
        if (i < cpath.getTip_days()) {
            com.baidu.tbadk.core.sharedPref.b.tu().putInt(jy("payment_confirm_notshow_count"), i + 1);
            if (z) {
                aer();
                return true;
            }
            aeq();
            return true;
        } else if (i != 0) {
            this.cdV.aew().setChecked(false);
            return false;
        } else {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(int i, String str) {
        ViewGroup aet = this.cdV.aet();
        this.cdV.aeu();
        this.cdV.iE(i);
        this.cdV.clearPassword();
        com.baidu.tbadk.core.dialog.a b = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).m(aet).a(i.h.payment_input_dialog_yes, new l(this, str)).b(i.h.payment_input_dialog_cancel, new m(this)).b(getPageContext());
        if (i <= 0) {
            b.am(false);
            this.cdV.ei(false);
        } else {
            b.am(true);
            this.cdV.ei(true);
        }
        if (this.cdV.aeA() != null) {
            if (StringUtils.isNull(this.cdV.aez())) {
                b.am(false);
            }
            this.cdV.aeA().addTextChangedListener(new n(this, b));
        }
        if (this.cdV.aey() != null) {
            this.cdV.aey().setOnClickListener(new o(this));
        }
        b.sR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iD(int i) {
        String str = "";
        String str2 = "";
        switch (i) {
            case 2270040:
                str = getResources().getString(i.h.payment_dilaog_error_recommend_bunding_phone);
                str2 = getResources().getString(i.h.bunding_phone);
                break;
            case 2270041:
                str = getResources().getString(i.h.payment_dilaog_error_bunding_phone);
                str2 = getResources().getString(i.h.bunding_phone);
                break;
            case 2270042:
                str = getResources().getString(i.h.payment_dilaog_error_message_validate);
                str2 = getResources().getString(i.h.msg_validate);
                break;
            case 2270066:
                str = getResources().getString(i.h.payment_dilaog_error_bunding_password);
                str2 = getResources().getString(i.h.setup_password);
                break;
        }
        new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).cu(str).b(i.h.alert_no_button, new d(this)).a(str2, new e(this, i, str2)).b(getPageContext()).sR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aU(String str, String str2) {
        new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).cu(str).b(i.h.alert_no_button, new f(this)).a(i.h.payment_dilaog_error_button, new g(this, str2)).b(getPageContext()).sR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PayVcodeInfoData payVcodeInfoData) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PayVcodeActivityConfig(getPageContext().getPageActivity(), payVcodeInfoData.getCaptcha_vcode_str(), payVcodeInfoData.getVcode_pic_url(), 230017)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(int i, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(getPageContext().getPageActivity(), str, TbConfig.WEB_URL_TDOU_UEG + i, true, true, true)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String jy(String str) {
        return String.valueOf(str) + this.mUserId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aeq() {
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(getPageContext().getPageActivity(), 0L)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, String str3, String str4, String str5, boolean z) {
        PaymentConfirmInfoData.OrderInfo order_info;
        if (this.paymentConfirmInfoData != null && (order_info = this.paymentConfirmInfoData.getOrder_info()) != null) {
            showLoadingDialog(getResources().getString(i.h.payment_confirm_pay_loading));
            this.cdV.eh(false);
            PayRequestData payRequestData = new PayRequestData();
            payRequestData.setOrderId(order_info.getOrder_id());
            payRequestData.setSceneId(order_info.getScene_id());
            payRequestData.setOpenId(order_info.getOpen_id());
            payRequestData.setTbs(this.paymentConfirmInfoData.getTbs());
            if (!StringUtils.isNull(str2)) {
                payRequestData.setPassword(URLEncoder.encode(com.baidu.tieba.payment.a.a.encrypt(str2, str)));
            }
            if (!StringUtils.isNull(str3)) {
                payRequestData.setCaptchaVcodeStr(str3);
            }
            if (!StringUtils.isNull(str4)) {
                payRequestData.setCaptchaInputStr(str4);
            }
            if (!StringUtils.isNull(str5)) {
                payRequestData.setBindId(str5);
            }
            if (z) {
                payRequestData.setMobileCheck("1");
            }
            this.cdW.a(payRequestData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aer() {
        a(null, null, null, null, null, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cdV.onChangeSkinType(i);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 230017 && intent != null) {
            a(null, null, intent.getStringExtra(PayVcodeActivityConfig.VCODE_MD5), intent.getStringExtra(PayVcodeActivityConfig.VCODE_RESULT), null, false);
        }
    }
}
