package com.baidu.tieba.payment;

import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.BuyTBeanActivityConfig;
import com.baidu.tbadk.core.atomData.PayVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.PaymentConfirmActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.n;
import com.baidu.tieba.payment.data.PayRequestData;
import com.baidu.tieba.payment.data.PayVcodeInfoData;
import com.baidu.tieba.payment.data.PaymentConfirmInfoData;
import com.baidu.tieba.tbadkCore.data.PaymentConfirmRequestData;
import java.net.URLEncoder;
/* loaded from: classes.dex */
public class PaymentConfirmActivity extends BaseActivity<PaymentConfirmActivity> {
    private s cwU;
    private r<PaymentConfirmActivity> cwV;
    private PaymentConfirmRequestData cwW;
    private boolean cwX;
    private boolean cwY;
    private long cwZ;
    private HttpMessageListener cxa = new d(this, CmdConfigHttp.CMD_PAYMENT_CONFIRM_INFO);
    private HttpMessageListener cxb = new j(this, CmdConfigHttp.CMD_PAYMENT_PAY);
    private CustomMessageListener cxc = new k(this, CmdConfigCustom.CMD_TDOU_PAY_BUNDING_PHONE);
    private CustomMessageListener cxd = new l(this, CmdConfigCustom.CMD_BUY_YINJI_SUCCESS);
    private String mUserId;
    private PaymentConfirmInfoData paymentConfirmInfoData;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData();
        initUI();
        BK();
        aiZ();
        t.kr("c10291");
    }

    private void initData() {
        try {
            this.cwW = (PaymentConfirmRequestData) getIntent().getSerializableExtra(PaymentConfirmActivityConfig.REQUEST_PARAMS);
        } catch (Exception e) {
            e.printStackTrace();
            closeActivity();
        }
        this.cwV = new r<>(getPageContext());
    }

    private void initUI() {
        this.cwU = new s(this);
        this.cwU.ajf().setChecked(com.baidu.tbadk.core.sharedPref.b.tZ().getBoolean(kq("payment_confirm_show"), true) ? false : true);
        this.cwU.ajf().setOnCheckedChangeListener(new m(this));
        this.cwU.ajg().setOnClickListener(new n(this));
    }

    private void BK() {
        this.cwV.aiU();
        this.cwV.ajc();
        registerListener(this.cxa);
        registerListener(this.cxb);
        registerListener(this.cxc);
        registerListener(this.cxd);
    }

    private void aiZ() {
        if (com.baidu.adp.lib.util.k.jg()) {
            showLoadingView(this.cwU.RT(), false);
            this.cwV.a(this.cwW);
            return;
        }
        showNetRefreshViewNoClick(this.cwU.RT(), getResources().getString(n.i.neterror));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kp(String str) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PAYMENT_CONFIRM_SUCCESS, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(PaymentConfirmInfoData paymentConfirmInfoData) {
        PaymentConfirmInfoData.UserInfo.UserScores parr_scores;
        PaymentConfirmInfoData.UserInfo user_info = paymentConfirmInfoData.getUser_info();
        PaymentConfirmInfoData.GoodsInfo goods_info = paymentConfirmInfoData.getGoods_info();
        if (user_info == null || goods_info == null || (parr_scores = user_info.getParr_scores()) == null) {
            return false;
        }
        long scores_total = parr_scores.getScores_total();
        long tdou_num = goods_info.getTdou_num();
        if (scores_total - tdou_num >= 0) {
            return true;
        }
        this.cwZ = tdou_num - scores_total;
        return false;
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
                ajb();
                return true;
            }
        } else if (cpath.getGettdou_cashier() == 1) {
            aja();
            return true;
        }
        if (cpath.getTip_exist() != 1 || com.baidu.tbadk.core.sharedPref.b.tZ().getBoolean(kq("payment_confirm_show"), true)) {
            return false;
        }
        int i = com.baidu.tbadk.core.sharedPref.b.tZ().getInt(kq("payment_confirm_notshow_count"), 0);
        if (i < cpath.getTip_days()) {
            com.baidu.tbadk.core.sharedPref.b.tZ().putInt(kq("payment_confirm_notshow_count"), i + 1);
            if (z) {
                ajb();
                return true;
            }
            aja();
            return true;
        } else if (i != 0) {
            this.cwU.ajf().setChecked(false);
            return false;
        } else {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(int i, String str) {
        ViewGroup ajd = this.cwU.ajd();
        this.cwU.aje();
        this.cwU.jJ(i);
        this.cwU.clearPassword();
        com.baidu.tbadk.core.dialog.a b = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).m(ajd).a(n.i.payment_input_dialog_yes, new o(this, str)).b(n.i.payment_input_dialog_cancel, new p(this)).b(getPageContext());
        if (i <= 0) {
            b.ao(false);
            this.cwU.eM(false);
        } else {
            b.ao(true);
            this.cwU.eM(true);
        }
        if (this.cwU.ajj() != null) {
            if (StringUtils.isNull(this.cwU.aji())) {
                b.ao(false);
            }
            this.cwU.ajj().addTextChangedListener(new q(this, b));
        }
        if (this.cwU.ajh() != null) {
            this.cwU.ajh().setOnClickListener(new e(this));
        }
        b.tv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jI(int i) {
        String str = "";
        String str2 = "";
        switch (i) {
            case 2270040:
                str = getResources().getString(n.i.payment_dilaog_error_recommend_bunding_phone);
                str2 = getResources().getString(n.i.bunding_phone);
                break;
            case 2270041:
                str = getResources().getString(n.i.payment_dilaog_error_bunding_phone);
                str2 = getResources().getString(n.i.bunding_phone);
                break;
            case 2270042:
                str = getResources().getString(n.i.payment_dilaog_error_message_validate);
                str2 = getResources().getString(n.i.msg_validate);
                break;
            case 2270066:
                str = getResources().getString(n.i.payment_dilaog_error_bunding_password);
                str2 = getResources().getString(n.i.setup_password);
                break;
        }
        new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).cC(str).b(n.i.alert_no_button, new f(this)).a(str2, new g(this, i, str2)).b(getPageContext()).tv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aY(String str, String str2) {
        new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).cC(str).b(n.i.alert_no_button, new h(this)).a(n.i.payment_dilaog_error_button, new i(this, str2)).b(getPageContext()).tv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PayVcodeInfoData payVcodeInfoData) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PayVcodeActivityConfig(getPageContext().getPageActivity(), payVcodeInfoData.getCaptcha_vcode_str(), payVcodeInfoData.getVcode_pic_url(), 230017)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(int i, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(getPageContext().getPageActivity(), str, TbConfig.WEB_URL_TDOU_UEG + i, true, true, true)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String kq(String str) {
        return String.valueOf(str) + this.mUserId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aja() {
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(getPageContext().getPageActivity(), this.cwZ)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, String str3, String str4, String str5, boolean z) {
        PaymentConfirmInfoData.OrderInfo order_info;
        if (this.paymentConfirmInfoData != null && (order_info = this.paymentConfirmInfoData.getOrder_info()) != null) {
            showLoadingDialog(getResources().getString(n.i.payment_confirm_pay_loading));
            this.cwU.eL(false);
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
            this.cwV.a(payRequestData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajb() {
        a(null, null, null, null, null, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cwU.onChangeSkinType(i);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 230017 && intent != null) {
            a(null, null, intent.getStringExtra(PayVcodeActivityConfig.VCODE_MD5), intent.getStringExtra(PayVcodeActivityConfig.VCODE_RESULT), null, false);
        }
    }
}
