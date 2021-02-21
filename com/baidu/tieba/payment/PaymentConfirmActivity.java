package com.baidu.tieba.payment;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BuyTBeanActivityConfig;
import com.baidu.tbadk.core.atomData.PayVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.PaymentConfirmActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tieba.R;
import com.baidu.tieba.payment.data.PayRequestData;
import com.baidu.tieba.payment.data.PayResultData;
import com.baidu.tieba.payment.data.PayVcodeInfoData;
import com.baidu.tieba.payment.data.PaymentConfirmInfoData;
import com.baidu.tieba.payment.message.ResponsePaymentConfirmInfoMessage;
import com.baidu.tieba.payment.message.ResponsePaymentPayMessage;
import com.baidu.tieba.tbadkCore.data.PaymentConfirmRequestData;
import com.baidu.tieba.tbadkCore.data.g;
import java.net.URLEncoder;
/* loaded from: classes9.dex */
public class PaymentConfirmActivity extends BaseActivity<PaymentConfirmActivity> {
    private c lHG;
    private PaymentConfirmModel<PaymentConfirmActivity> lHH;
    private PaymentConfirmRequestData lHI;
    private boolean lHJ;
    private boolean lHK;
    private long lHL;
    private int lHM = -1;
    private String lHN = "";
    private HttpMessageListener lHO = new HttpMessageListener(1001536) { // from class: com.baidu.tieba.payment.PaymentConfirmActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            PaymentConfirmActivity.this.hideLoadingView(PaymentConfirmActivity.this.lHG.getContentView());
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof ResponsePaymentConfirmInfoMessage)) {
                ResponsePaymentConfirmInfoMessage responsePaymentConfirmInfoMessage = (ResponsePaymentConfirmInfoMessage) httpResponsedMessage;
                PaymentConfirmActivity.this.paymentConfirmInfoData = responsePaymentConfirmInfoMessage.getPaymentConfirmInfoData();
                if (responsePaymentConfirmInfoMessage.hasError() || PaymentConfirmActivity.this.paymentConfirmInfoData == null) {
                    if (responsePaymentConfirmInfoMessage.getError() == 1) {
                        Intent intent = new Intent();
                        intent.putExtra(DealIntentService.KEY_CLASS, 32);
                        intent.putExtra(PaymentConfirmActivityConfig.REQUEST_PARAMS, PaymentConfirmActivity.this.lHI);
                        intent.putExtra("refer_page", PaymentConfirmActivity.this.mReferPage);
                        intent.putExtra("click_zone", PaymentConfirmActivity.this.mClickZone);
                        TbadkCoreApplication.setIntent(intent);
                        ReloginManager.brI().e(null);
                        PaymentConfirmActivity.this.closeActivity();
                        return;
                    }
                    String errorString = responsePaymentConfirmInfoMessage.getErrorString();
                    if (StringUtils.isNull(errorString)) {
                        errorString = PaymentConfirmActivity.this.getResources().getString(R.string.neterror);
                    }
                    PaymentConfirmActivity.this.showToast(errorString);
                    return;
                }
                PaymentConfirmActivity.this.lHJ = PaymentConfirmActivity.this.a(PaymentConfirmActivity.this.paymentConfirmInfoData);
                PaymentConfirmActivity.this.lHG.b(PaymentConfirmActivity.this.paymentConfirmInfoData, PaymentConfirmActivity.this.lHJ);
                PaymentConfirmActivity.this.a(PaymentConfirmActivity.this.paymentConfirmInfoData, PaymentConfirmActivity.this.lHJ);
            }
        }
    };
    private HttpMessageListener lHP = new HttpMessageListener(1001537) { // from class: com.baidu.tieba.payment.PaymentConfirmActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            PayResultData.UnusualInfo describe;
            PayVcodeInfoData vcode;
            String string;
            PaymentConfirmActivity.this.closeLoadingDialog();
            PaymentConfirmActivity.this.lHG.uA(true);
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof ResponsePaymentPayMessage)) {
                ResponsePaymentPayMessage responsePaymentPayMessage = (ResponsePaymentPayMessage) httpResponsedMessage;
                if (!responsePaymentPayMessage.hasError()) {
                    int error = responsePaymentPayMessage.getError();
                    if (error == 0) {
                        d.Pf("c10294");
                        PayResultData payRequestDataData = responsePaymentPayMessage.getPayRequestDataData();
                        if (payRequestDataData != null && payRequestDataData.getDescribe() != null && payRequestDataData.getDescribe().getWord() != null) {
                            string = payRequestDataData.getDescribe().getWord();
                        } else {
                            string = PaymentConfirmActivity.this.getString(R.string.exchange_success);
                        }
                        new com.baidu.tbadk.core.view.c().showSuccessToast(string);
                        if (!TextUtils.isEmpty(PaymentConfirmActivity.this.lHN)) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CLOSR_READER_SDK));
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_BOOK_BUY_STATE_CHANGED, PaymentConfirmActivity.this.lHN));
                        }
                        if (PaymentConfirmActivity.this.lHI != null) {
                            PaymentConfirmActivity.this.Pc(PaymentConfirmActivity.this.lHI.getOrder_id());
                        }
                        PaymentConfirmActivity.this.closeActivity();
                        return;
                    } else if (error == 2270018) {
                        PayResultData payRequestDataData2 = responsePaymentPayMessage.getPayRequestDataData();
                        if (payRequestDataData2 != null) {
                            PaymentConfirmActivity.this.bO(5, payRequestDataData2.getPubkey());
                            return;
                        }
                        return;
                    } else if (error == 2150040) {
                        PayResultData payRequestDataData3 = responsePaymentPayMessage.getPayRequestDataData();
                        if (payRequestDataData3 != null && (vcode = payRequestDataData3.getVcode()) != null) {
                            PaymentConfirmActivity.this.a(vcode);
                            return;
                        }
                        return;
                    } else if (error == 2) {
                        PayResultData payRequestDataData4 = responsePaymentPayMessage.getPayRequestDataData();
                        if (payRequestDataData4 != null) {
                            PaymentConfirmActivity.this.bO(5 - payRequestDataData4.getWrongtime(), payRequestDataData4.getPubkey());
                            return;
                        }
                        return;
                    } else if (error == 2190005) {
                        PaymentConfirmActivity.this.lHK = true;
                        PaymentConfirmActivity.this.bO(0, null);
                        return;
                    } else if (error == 2270066 || error == 2270040 || error == 2270041 || error == 2270042) {
                        PaymentConfirmActivity.this.Fo(error);
                        return;
                    } else {
                        PayResultData payRequestDataData5 = responsePaymentPayMessage.getPayRequestDataData();
                        if (payRequestDataData5 != null && (describe = payRequestDataData5.getDescribe()) != null) {
                            String word = describe.getWord();
                            String url = describe.getUrl();
                            if (!StringUtils.isNull(word) && !StringUtils.isNull(url)) {
                                PaymentConfirmActivity.this.fR(word, url);
                                return;
                            }
                        }
                        com.baidu.tbadk.core.view.c cVar = new com.baidu.tbadk.core.view.c();
                        String errorString = responsePaymentPayMessage.getErrorString();
                        if (StringUtils.isNull(errorString)) {
                            errorString = PaymentConfirmActivity.this.getResources().getString(R.string.plugin_pay_error);
                        }
                        cVar.showFailToast(errorString);
                        return;
                    }
                }
                PaymentConfirmActivity.this.showToast(R.string.neterror);
            }
        }
    };
    private CustomMessageListener lHQ = new CustomMessageListener(CmdConfigCustom.CMD_TDOU_PAY_BUNDING_PHONE) { // from class: com.baidu.tieba.payment.PaymentConfirmActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!StringUtils.isNull(str)) {
                    PaymentConfirmActivity.this.b(null, null, null, null, str, false);
                } else {
                    PaymentConfirmActivity.this.b(null, null, null, null, null, true);
                }
            }
        }
    };
    private CustomMessageListener lHR = new CustomMessageListener(CmdConfigCustom.CMD_BUY_YINJI_SUCCESS) { // from class: com.baidu.tieba.payment.PaymentConfirmActivity.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof g)) {
                PaymentConfirmActivity.this.lHL -= com.baidu.adp.lib.f.b.toInt(((g) customResponsedMessage.getData()).getTBeanNum(), 0);
                if (PaymentConfirmActivity.this.lHL <= 0) {
                    PaymentConfirmActivity.this.lHJ = true;
                    PaymentConfirmInfoData.GoodsInfo goods_info = PaymentConfirmActivity.this.paymentConfirmInfoData.getGoods_info();
                    if (goods_info != null) {
                        PaymentConfirmActivity.this.lHG.hp(goods_info.getTdou_num());
                    }
                }
            }
        }
    };
    private String mClickZone;
    private String mReferPage;
    private String mUserId;
    private PaymentConfirmInfoData paymentConfirmInfoData;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData();
        initUI();
        register();
        dkF();
        d.Pf("c10291");
    }

    private void initData() {
        try {
            Intent intent = getIntent();
            this.lHI = (PaymentConfirmRequestData) intent.getSerializableExtra(PaymentConfirmActivityConfig.REQUEST_PARAMS);
            this.lHM = intent.getIntExtra("book_type", -1);
            this.lHN = intent.getStringExtra("book_id");
            this.mReferPage = getIntent().getStringExtra("refer_page");
            this.mClickZone = getIntent().getStringExtra("click_zone");
        } catch (Exception e) {
            e.printStackTrace();
            closeActivity();
        }
        this.lHH = new PaymentConfirmModel<>(getPageContext());
    }

    private void initUI() {
        this.lHG = new c(this, this.lHM == 2);
        this.lHG.dkL().setChecked(com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean(Pd(SharedPrefConfig.PAYMENT_CONFIRM_SHOW), true) ? false : true);
        this.lHG.dkL().setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.payment.PaymentConfirmActivity.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean(PaymentConfirmActivity.this.Pd(SharedPrefConfig.PAYMENT_CONFIRM_SHOW), !z);
                if (!z) {
                    com.baidu.tbadk.core.sharedPref.b.brQ().putInt(PaymentConfirmActivity.this.Pd(SharedPrefConfig.PAYMENT_CONFIRM_NOT_SHOW_COUNT), 0);
                }
            }
        });
        this.lHG.dkM().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.payment.PaymentConfirmActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PaymentConfirmActivity.this.lHK) {
                    PaymentConfirmActivity.this.bO(0, null);
                } else if (PaymentConfirmActivity.this.lHJ) {
                    d.Pf("c10292");
                    PaymentConfirmActivity.this.dkH();
                } else {
                    d.Pf("c10293");
                    PaymentConfirmActivity.this.dkG();
                }
            }
        });
    }

    private void register() {
        this.lHH.dkA();
        this.lHH.dkI();
        registerListener(this.lHO);
        this.lHP.setSelfListener(true);
        registerListener(this.lHP);
        registerListener(this.lHQ);
        registerListener(this.lHR);
    }

    private void dkF() {
        if (l.isNetOk()) {
            showLoadingView(this.lHG.getContentView(), false);
            this.lHH.a(this.lHI);
            return;
        }
        showNetRefreshViewNoClick(this.lHG.getContentView(), getResources().getString(R.string.neterror));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pc(String str) {
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
        this.lHL = tdou_num - scores_total;
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
                dkH();
                return true;
            }
        } else if (cpath.getGettdou_cashier() == 1) {
            dkG();
            return true;
        }
        if (cpath.getTip_exist() != 1 || com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean(Pd(SharedPrefConfig.PAYMENT_CONFIRM_SHOW), true)) {
            return false;
        }
        int i = com.baidu.tbadk.core.sharedPref.b.brQ().getInt(Pd(SharedPrefConfig.PAYMENT_CONFIRM_NOT_SHOW_COUNT), 0);
        if (i < cpath.getTip_days()) {
            com.baidu.tbadk.core.sharedPref.b.brQ().putInt(Pd(SharedPrefConfig.PAYMENT_CONFIRM_NOT_SHOW_COUNT), i + 1);
            if (z) {
                dkH();
                return true;
            }
            dkG();
            return true;
        } else if (i != 0) {
            this.lHG.dkL().setChecked(false);
            return false;
        } else {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bO(int i, final String str) {
        ViewGroup dkJ = this.lHG.dkJ();
        this.lHG.dkK();
        this.lHG.Fp(i);
        this.lHG.bIU();
        final com.baidu.tbadk.core.dialog.a b2 = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).bn(dkJ).a(R.string.push_commit, new a.b() { // from class: com.baidu.tieba.payment.PaymentConfirmActivity.13
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                String dkO = PaymentConfirmActivity.this.lHG.dkO();
                if (!StringUtils.isNull(dkO)) {
                    PaymentConfirmActivity.this.b(str, dkO, null, null, null, false);
                }
            }
        }).b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.payment.PaymentConfirmActivity.12
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        }).b(getPageContext());
        if (i <= 0) {
            b2.setYesBtnClickable(false);
            this.lHG.uB(false);
        } else {
            b2.setYesBtnClickable(true);
            this.lHG.uB(true);
        }
        if (this.lHG.dkP() != null) {
            if (StringUtils.isNull(this.lHG.dkO())) {
                b2.setYesBtnClickable(false);
            }
            this.lHG.dkP().addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.payment.PaymentConfirmActivity.14
                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    b2.setYesBtnClickable(!StringUtils.isNull(editable.toString()));
                }
            });
        }
        if (this.lHG.dkN() != null) {
            this.lHG.dkN().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.payment.PaymentConfirmActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PaymentConfirmActivity.this.bP(2270066, PaymentConfirmActivity.this.getResources().getString(R.string.sapi_forget_password_title));
                }
            });
        }
        b2.bqx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fo(final int i) {
        String str = "";
        final String str2 = "";
        switch (i) {
            case 2270040:
                str = getResources().getString(R.string.payment_dilaog_error_recommend_bunding_phone);
                str2 = getResources().getString(R.string.bunding_phone);
                break;
            case 2270041:
                str = getResources().getString(R.string.payment_dilaog_error_bunding_phone);
                str2 = getResources().getString(R.string.bunding_phone);
                break;
            case 2270042:
                str = getResources().getString(R.string.payment_dilaog_error_message_validate);
                str2 = getResources().getString(R.string.msg_validate);
                break;
            case 2270066:
                str = getResources().getString(R.string.payment_dilaog_error_bunding_password);
                str2 = getResources().getString(R.string.setup_password);
                break;
        }
        new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).Au(str).b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.payment.PaymentConfirmActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        }).a(str2, new a.b() { // from class: com.baidu.tieba.payment.PaymentConfirmActivity.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                PaymentConfirmActivity.this.bP(i, str2);
            }
        }).b(getPageContext()).bqx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fR(String str, final String str2) {
        new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).Au(str).b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.payment.PaymentConfirmActivity.6
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                PaymentConfirmActivity.this.closeActivity();
            }
        }).a(R.string.payment_dilaog_error_button, new a.b() { // from class: com.baidu.tieba.payment.PaymentConfirmActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(PaymentConfirmActivity.this.getPageContext().getPageActivity(), PaymentConfirmActivity.this.getResources().getString(R.string.payment_dilaog_error_button), str2, true, true, true)));
            }
        }).b(getPageContext()).bqx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PayVcodeInfoData payVcodeInfoData) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PayVcodeActivityConfig(getPageContext().getPageActivity(), payVcodeInfoData.getCaptcha_vcode_str(), payVcodeInfoData.getVcode_pic_url(), RequestResponseCode.REQUEST_PAY_VCODE)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bP(int i, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(getPageContext().getPageActivity(), str, TbConfig.WEB_URL_TDOU_UEG + i, true, true, true)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Pd(String str) {
        return str + this.mUserId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dkG() {
        BuyTBeanActivityConfig buyTBeanActivityConfig = new BuyTBeanActivityConfig(getPageContext().getPageActivity(), this.lHL);
        buyTBeanActivityConfig.setReferPageAndClickZone(this.mReferPage, this.mClickZone);
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, buyTBeanActivityConfig));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, String str2, String str3, String str4, String str5, boolean z) {
        PaymentConfirmInfoData.OrderInfo order_info;
        if (this.paymentConfirmInfoData != null && (order_info = this.paymentConfirmInfoData.getOrder_info()) != null) {
            showLoadingDialog(getResources().getString(R.string.payment_confirm_pay_loading));
            this.lHG.uA(false);
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
            this.lHH.a(payRequestData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dkH() {
        b(null, null, null, null, null, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.lHG.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 230017 && intent != null) {
            b(null, null, intent.getStringExtra(PayVcodeActivityConfig.VCODE_MD5), intent.getStringExtra(PayVcodeActivityConfig.VCODE_RESULT), null, false);
        }
    }
}
