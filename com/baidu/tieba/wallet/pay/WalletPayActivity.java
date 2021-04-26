package com.baidu.tieba.wallet.pay;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.lbspay.BaiduLBSPay;
import com.baidu.android.lbspay.LBSPayBack;
import com.baidu.android.lbspay.network.INetwork;
import com.baidu.android.lbspay.view.PayChannelController;
import com.baidu.android.pay.PayCallBack;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MemberPayResultActivityConfig;
import com.baidu.tbadk.core.atomData.PayWalletActivityConfig;
import com.baidu.tbadk.core.atomData.WalletPayResultActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.pay.PayConfig;
import com.baidu.tbadk.pay.ResponseGetPayinfoMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.wallet.WalletParamsFactory;
import com.baidu.tieba.wallet.WalletStatisticKey;
import com.baidu.tieba.wallet.pay.WalletPayViewController;
import com.baidu.wallet.api.BaiduWallet;
import com.baidu.wallet.core.beans.BeanManager;
import d.a.c.c.g.a;
import d.a.c.e.m.e;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.i0.r.d0.b;
import d.a.i0.r.s.a;
import java.util.Date;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.GetOrder.DataRes;
import tbclient.GetOrder.NotifyPopup;
/* loaded from: classes5.dex */
public class WalletPayActivity extends BaseActivity<WalletPayActivity> {
    public static final int PAY_STATUS_FAIL = 1;
    public static final int PAY_STATUS_NO_ORDER = 3;
    public static final int PAY_STATUS_NO_SUC = 2;
    public static final int PAY_STATUS_SUC = 0;
    public static final String PAY_TYPE_SDK = "sdk";
    public static final String PAY_TYPE_URL = "url";
    public DataRes mDataRes;
    public TextView mDescView;
    public View mDialogRootView;
    public String mOrderId;
    public GetOrderModel mOrderModel;
    public TextView mOtherApkView;
    public PayConfig mPayConfig;
    public TextView mUpdateTipView;
    public TextView mVersionView;
    public WalletPayViewController mViewController;
    public final int SEND_GETINFO_MSG = 1;
    public final int RESEND_INTERVAL = 5000;
    public final int PAY_DIALOG_ERROR_NO = 210009;
    public final String PAY_DIALOG_ERROR_KEY = "pay_dialog_error_key";
    public boolean mIsPaying = false;
    public boolean hasResendGetMsg = false;
    public boolean isPayDialog = false;
    public boolean mOtherApkSelected = true;
    public int checkViewWidth = 0;
    public int isFromDecreaseGiftStepStrategy = 0;
    public Handler mHandler = new Handler() { // from class: com.baidu.tieba.wallet.pay.WalletPayActivity.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what != 1) {
                return;
            }
            WalletPayActivity.this.sendGetPayinfoMessage();
        }
    };
    public WalletPayViewController.ClickCallback mCallback = new WalletPayViewController.ClickCallback() { // from class: com.baidu.tieba.wallet.pay.WalletPayActivity.2
        @Override // com.baidu.tieba.wallet.pay.WalletPayViewController.ClickCallback
        public void doFinish() {
            WalletPayActivity.this.finishSelf();
        }

        @Override // com.baidu.tieba.wallet.pay.WalletPayViewController.ClickCallback
        public void doPay(String str) {
            WalletPayActivity.this.doPayWithChannel(str);
        }
    };
    public HttpMessageListener mGetPayinfoListener = new HttpMessageListener(CmdConfigHttp.GETPAYINFO_CMD) { // from class: com.baidu.tieba.wallet.pay.WalletPayActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001505) {
                WalletPayActivity.this.finishSelf();
                return;
            }
            int statusCode = httpResponsedMessage.getStatusCode();
            int error = httpResponsedMessage.getError();
            ResponseGetPayinfoMessage responseGetPayinfoMessage = (ResponseGetPayinfoMessage) httpResponsedMessage;
            if (statusCode == 200 && error == 0) {
                if (responseGetPayinfoMessage.getPayInfoResultData() != null) {
                    if (WalletPayActivity.this.mPayConfig != null) {
                        WalletPayActivity.this.mPayConfig.orderCompleteTime = responseGetPayinfoMessage.getPayInfoResultData().getCreateTime();
                    }
                    if (responseGetPayinfoMessage.getPayInfoResultData().getPay_status() == 2) {
                        if (!WalletPayActivity.this.hasResendGetMsg) {
                            WalletPayActivity.this.hasResendGetMsg = true;
                            WalletPayActivity.this.mHandler.sendMessageDelayed(WalletPayActivity.this.mHandler.obtainMessage(1), 5000L);
                            return;
                        }
                        WalletPayActivity.this.showResult(Boolean.TRUE);
                        return;
                    } else if (responseGetPayinfoMessage.getPayInfoResultData().getPay_status() == 0) {
                        WalletPayActivity.this.showResult(Boolean.TRUE);
                        return;
                    } else if (responseGetPayinfoMessage.getPayInfoResultData().getPay_status() == 1) {
                        WalletPayActivity walletPayActivity = WalletPayActivity.this;
                        walletPayActivity.createPayDebugLog("getpayinfo", statusCode, "支付失败", error, "logid = " + responseGetPayinfoMessage.logid);
                        WalletPayActivity.this.showResult(Boolean.FALSE);
                        return;
                    } else if (responseGetPayinfoMessage.getPayInfoResultData().getPay_status() == 3) {
                        WalletPayActivity walletPayActivity2 = WalletPayActivity.this;
                        walletPayActivity2.createPayDebugLog("getpayinfo", statusCode, "没有订单", error, "logid = " + responseGetPayinfoMessage.logid);
                        WalletPayActivity.this.showResult(Boolean.FALSE);
                        return;
                    } else {
                        WalletPayActivity walletPayActivity3 = WalletPayActivity.this;
                        walletPayActivity3.createPayDebugLog("getpayinfo", statusCode, "", error, "logid = " + responseGetPayinfoMessage.logid);
                        WalletPayActivity.this.showResult(Boolean.FALSE);
                        return;
                    }
                }
                return;
            }
            WalletPayActivity walletPayActivity4 = WalletPayActivity.this;
            String errorString = httpResponsedMessage.getErrorString();
            walletPayActivity4.createPayDebugLog("getpayinfo", statusCode, errorString, error, "logid = " + responseGetPayinfoMessage.logid);
            WalletPayActivity.this.showResult(Boolean.FALSE);
        }
    };
    public a mNetMessagelistener = new a(CmdConfigHttp.CMD_GET_ORDER, 303043) { // from class: com.baidu.tieba.wallet.pay.WalletPayActivity.5
        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            DataRes data;
            WalletPayActivity.this.mIsPaying = false;
            if (responsedMessage == null) {
                WalletPayActivity.this.showToast(R.string.pay_fail);
                WalletPayActivity.this.createPayDebugLog("getOrder", -1, "ResponsedMessage is null", -1, "");
                WalletPayActivity.this.finishSelf();
                return;
            }
            if (!responsedMessage.hasError() && responsedMessage.getError() == 0) {
                data = responsedMessage instanceof ResponsedGetOrderHttpMessage ? ((ResponsedGetOrderHttpMessage) responsedMessage).getData() : null;
                if (responsedMessage instanceof ResponsedGetOrderSocketMessage) {
                    data = ((ResponsedGetOrderSocketMessage) responsedMessage).getData();
                }
                if (data != null) {
                    WalletPayActivity.this.mOrderId = data.orderId;
                    WalletPayActivity.this.mDataRes = data;
                    if (WalletPayActivity.this.mDataRes != null) {
                        if (!WalletPayActivity.this.mViewController.isValidData(WalletPayActivity.this.mDataRes.pay_channel) || "url".equalsIgnoreCase(WalletPayActivity.this.mDataRes.call_type)) {
                            WalletPayActivity.this.mViewController.showPayingStatus();
                            WalletPayActivity.this.payByWallet();
                            return;
                        }
                        WalletPayActivity.this.mViewController.hideLoadingView();
                        WalletPayActivity.this.mViewController.setData(WalletPayActivity.this.mDataRes);
                        return;
                    }
                    WalletPayActivity.this.showToast(R.string.pay_fail);
                    WalletPayActivity.this.finishSelf();
                    return;
                }
                WalletPayActivity.this.showToast(R.string.pay_fail);
                WalletPayActivity.this.createPayDebugLog("getOrder", -1, "data is null", responsedMessage.getError(), "");
                WalletPayActivity.this.finishSelf();
                return;
            }
            if (responsedMessage.getError() == 210009) {
                data = responsedMessage instanceof ResponsedGetOrderHttpMessage ? ((ResponsedGetOrderHttpMessage) responsedMessage).getData() : null;
                if (responsedMessage instanceof ResponsedGetOrderSocketMessage) {
                    data = ((ResponsedGetOrderSocketMessage) responsedMessage).getData();
                }
                if (data != null) {
                    WalletPayActivity.this.showPayErrorDialog(data.popup);
                }
            } else {
                WalletPayActivity.this.showToast(StringUtils.isNull(responsedMessage.getErrorString()) ? WalletPayActivity.this.getResources().getString(R.string.neterror) : responsedMessage.getErrorString());
                WalletPayActivity.this.finishSelf();
            }
            WalletPayActivity.this.createPayDebugLog("getOrder", responsedMessage instanceof ResponsedGetOrderHttpMessage ? ((ResponsedGetOrderHttpMessage) responsedMessage).getStatusCode() : -1, responsedMessage.getErrorString(), responsedMessage.getError(), "");
        }
    };
    public LBSPayBack mPayCallback = new LBSPayBack() { // from class: com.baidu.tieba.wallet.pay.WalletPayActivity.14
        @Override // com.baidu.android.lbspay.LBSPayBack
        public void onPayResult(int i2, String str) {
            if (i2 == 0) {
                WalletPayActivity.this.sendGetPayinfoMessage();
                TiebaStatic.log("c10123");
            } else if (i2 == 2) {
                e.a().post(new Runnable() { // from class: com.baidu.tieba.wallet.pay.WalletPayActivity.14.1
                    @Override // java.lang.Runnable
                    public void run() {
                        WalletPayActivity walletPayActivity = WalletPayActivity.this;
                        walletPayActivity.showToast(walletPayActivity.getResources().getString(R.string.pay_cancel));
                    }
                });
                WalletPayActivity.this.finishSelf();
            } else if (i2 != 3) {
            } else {
                WalletPayActivity walletPayActivity = WalletPayActivity.this;
                walletPayActivity.showToast(walletPayActivity.getResources().getString(R.string.pay_fail));
                WalletPayActivity.this.createPayDebugLog("", -1, "fail_code LBSPayInner.STATE_CODE_FAILD", 3, "钱包SDK返回支付失败");
                WalletPayActivity.this.finishSelf();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void createPayDebugLog(String str, int i2, String str2, int i3, String str3) {
        d.a.c.e.n.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
        statsItem.b("requestMethod", str);
        statsItem.b("eventType", "requestfail");
        statsItem.c("response_code", Integer.valueOf(i2));
        statsItem.b("error_msg", str2);
        statsItem.c("error_code", Integer.valueOf(i3));
        statsItem.b("extra_msg", str3);
        statsItem.b("uid", TbadkCoreApplication.getCurrentAccount());
        BdStatisticsManager.getInstance().debug("TiebaPayFail", statsItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doPayWithChannel(String str) {
        try {
            JSONObject jSONObject = new JSONObject(BaiduLBSPay.getInstance().getReqData(this));
            jSONObject.put("token", INetwork.LBS_HOST);
            jSONObject.put("payChannel", str);
            BaiduLBSPay.getInstance().doCallFrontCashierPay(getPageContext().getPageActivity(), null, this.mPayCallback, WalletParamsFactory.buildWalletParams(this.mDataRes), jSONObject.toString());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishSelf() {
        finish();
    }

    private void initBundle(Bundle bundle) {
        if (bundle != null) {
            this.mPayConfig = (PayConfig) bundle.getSerializable(PayWalletActivityConfig.PAY_CONFIG);
        } else {
            Intent intent = getPageContext().getPageActivity().getIntent();
            if (intent != null) {
                this.mPayConfig = (PayConfig) intent.getSerializableExtra(PayWalletActivityConfig.PAY_CONFIG);
            }
        }
        PayConfig payConfig = this.mPayConfig;
        if (payConfig == null) {
            showToast(R.string.pay_fail);
            finishSelf();
            return;
        }
        this.isFromDecreaseGiftStepStrategy = payConfig.isFromDecreaseGiftStepStrategy();
    }

    private void loadPayChannelView(HashMap<String, String> hashMap) {
        BaiduLBSPay.getInstance().doPolymerPay(getPageContext().getPageActivity(), this.mPayCallback, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void payByWallet() {
        if ("url".equalsIgnoreCase(this.mDataRes.call_type)) {
            if (!StringUtils.isNull(this.mDataRes.pay_url)) {
                UrlManager.getInstance().dealOneLink((TbPageContext<?>) getPageContext(), new String[]{this.mDataRes.pay_url}, true);
            } else {
                showToast(R.string.pay_fail);
                createPayDebugLog("", -1, "mDataRes.pay_url is null", -1, "h5方式打开钱包");
            }
            finishSelf();
            return;
        }
        loadPayChannelView(WalletParamsFactory.buildWalletParams(this.mDataRes));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshOtherApkViewState() {
        Drawable drawable;
        if (this.mOtherApkView == null) {
            return;
        }
        if (this.mOtherApkSelected) {
            this.mOtherApkSelected = false;
            drawable = SkinManager.getDrawable(R.drawable.btn_dailog_choose_d);
        } else {
            this.mOtherApkSelected = true;
            drawable = SkinManager.getDrawable(R.drawable.btn_dailog_choose_s);
        }
        if (drawable != null) {
            int i2 = this.checkViewWidth;
            drawable.setBounds(0, 0, i2, i2);
        }
        this.mOtherApkView.setCompoundDrawables(drawable, null, null, null);
    }

    private void registerGetPayinfoListener() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.GETPAYINFO_CMD, TbConfig.SERVER_ADDRESS + TbConfig.URL_GETPAYINFO);
        tbHttpMessageTask.setResponsedClass(ResponseGetPayinfoMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        registerListener(this.mGetPayinfoListener);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void sendGetOrderMessage() {
        String optString;
        if (this.mOrderModel == null || this.mPayConfig == null || this.mIsPaying) {
            return;
        }
        String reqData = BaiduLBSPay.getInstance().getReqData(this);
        if (!StringUtils.isNull(reqData)) {
            try {
                optString = new JSONObject(reqData).optString("ua");
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            this.mOrderModel.setWalletSdkUa(optString);
            if (!this.mOrderModel.sendMessage(this.mPayConfig)) {
                this.mIsPaying = true;
                this.mViewController.showLoadingView();
                return;
            }
            showToast(R.string.pay_fail);
            finishSelf();
            return;
        }
        optString = "";
        this.mOrderModel.setWalletSdkUa(optString);
        if (!this.mOrderModel.sendMessage(this.mPayConfig)) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendGetPayinfoMessage() {
        String str = this.mOrderId;
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.GETPAYINFO_CMD);
        httpMessage.setTag(getUniqueId());
        httpMessage.addParam("pay_id", str);
        httpMessage.setExtra(String.valueOf(this.mPayConfig.getTBeanNum()));
        sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showPayErrorDialog(NotifyPopup notifyPopup) {
        if (notifyPopup == null) {
            return;
        }
        if (notifyPopup.popup_times.intValue() == 0) {
            if (notifyPopup.popup_type.intValue() == 1) {
                showSimplePayErrorDialog(notifyPopup);
                return;
            } else if (notifyPopup.popup_type.intValue() == 2) {
                showFullPayErrorDialog(notifyPopup);
                return;
            } else {
                finishSelf();
                return;
            }
        }
        b j = b.j();
        int k = j.k("pay_dialog_error_key" + notifyPopup.popup_id, 0);
        if (k < notifyPopup.popup_times.intValue()) {
            b j2 = b.j();
            j2.v("pay_dialog_error_key" + notifyPopup.popup_id, k + 1);
            if (notifyPopup.popup_type.intValue() == 1) {
                showSimplePayErrorDialog(notifyPopup);
                return;
            } else if (notifyPopup.popup_type.intValue() == 2) {
                showFullPayErrorDialog(notifyPopup);
                return;
            } else {
                finishSelf();
                return;
            }
        }
        finishSelf();
    }

    private String toChineseNumber(String str) {
        String str2;
        try {
            switch (Integer.parseInt(str)) {
                case 1:
                    str2 = "一";
                    break;
                case 2:
                    str2 = "二";
                    break;
                case 3:
                    str2 = "三";
                    break;
                case 4:
                    str2 = "四";
                    break;
                case 5:
                    str2 = "五";
                    break;
                case 6:
                    str2 = "六";
                    break;
                case 7:
                    str2 = "七";
                    break;
                case 8:
                    str2 = "八";
                    break;
                case 9:
                    str2 = "九";
                    break;
                case 10:
                    str2 = "十";
                    break;
                case 11:
                    str2 = "十一";
                    break;
                case 12:
                    str2 = "十二";
                    break;
                default:
                    return "";
            }
            return str2;
        } catch (NumberFormatException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    private void walletDoPay(String str) {
        if (StringUtils.isNull(str)) {
            showToast(R.string.pay_fail);
            finishSelf();
            return;
        }
        BaiduWallet.getInstance().doPay(getPageContext().getPageActivity(), str, new PayCallBack() { // from class: com.baidu.tieba.wallet.pay.WalletPayActivity.3
            @Override // com.baidu.android.pay.PayCallBack
            public boolean isHideLoadingDialog() {
                return false;
            }

            @Override // com.baidu.android.pay.PayCallBack
            public void onPayResult(int i2, String str2) {
                if (i2 == 0) {
                    WalletPayActivity.this.showPaySuccessDialog();
                } else if (i2 != 1) {
                    WalletPayActivity.this.finishSelf();
                } else {
                    WalletPayActivity.this.showToast(R.string.pay_fail);
                    WalletPayActivity.this.finishSelf();
                }
            }
        });
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (intent != null) {
            if (intent.getBooleanExtra("rebuy", false)) {
                finish();
                return;
            }
            Intent intent2 = new Intent();
            intent2.putExtra("success", true);
            setResult(-1, intent2);
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        WalletPayViewController walletPayViewController = this.mViewController;
        if (walletPayViewController != null) {
            walletPayViewController.onChangeSkinType();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.mPayConfig = (PayConfig) getIntent().getSerializableExtra(PayWalletActivityConfig.PAY_CONFIG);
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(false);
        super.onCreate(bundle);
        initBundle(bundle);
        registerListener(this.mNetMessagelistener);
        registerGetPayinfoListener();
        PayActivityStatic.initBaiduWallet();
        if (this.mPayConfig.getPayType() == 3) {
            walletDoPay(this.mPayConfig.mOrderInfo);
        } else {
            this.mViewController = new WalletPayViewController(this, this.mCallback, this.mPayConfig);
            this.mOrderModel = new GetOrderModel(this);
            sendGetOrderMessage();
        }
        TiebaStatic.log("c10119");
        if (this.mPayConfig.getPayType() == 1) {
            TiebaStatic.log(WalletStatisticKey.KEY_PURCHASE_MEMBER_VISIT);
        } else if (this.mPayConfig.getPayType() == 2) {
            TiebaStatic.log(WalletStatisticKey.KEY_PURCHASE_TDOU_VISIT);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        BeanManager.getInstance().removeAllBeans(PayChannelController.BEAN_TAG);
        this.mHandler.removeMessages(1);
        this.mDialogRootView = null;
        WalletPayViewController walletPayViewController = this.mViewController;
        if (walletPayViewController != null) {
            walletPayViewController.destroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (4 == i2) {
            finishSelf();
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        WalletPayViewController walletPayViewController = this.mViewController;
        if (walletPayViewController == null || !walletPayViewController.isPaying()) {
            return;
        }
        this.mViewController.resetPayStatus();
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putSerializable(PayWalletActivityConfig.PAY_CONFIG, this.mPayConfig);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i2, int i3) {
        super.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    public void showFullPayErrorDialog(final NotifyPopup notifyPopup) {
        String str;
        String str2;
        if (notifyPopup == null) {
            return;
        }
        if (this.mDialogRootView == null) {
            this.checkViewWidth = l.g(getActivity(), R.dimen.ds40);
            View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.pay_error_dialog_view, (ViewGroup) null);
            this.mDialogRootView = inflate;
            this.mVersionView = (TextView) inflate.findViewById(R.id.error_pay_dialog_size);
            this.mUpdateTipView = (TextView) this.mDialogRootView.findViewById(R.id.error_pay_dialog_hint);
            this.mDescView = (TextView) this.mDialogRootView.findViewById(R.id.error_pay_dialog_log);
            TextView textView = (TextView) this.mDialogRootView.findViewById(R.id.need_extra_app_wrapper);
            this.mOtherApkView = textView;
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.wallet.pay.WalletPayActivity.10
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view == null) {
                        return;
                    }
                    WalletPayActivity.this.refreshOtherApkViewState();
                }
            });
        }
        String str3 = notifyPopup.app_version + "/" + ((notifyPopup.app_size.intValue() / 1024) / 1024) + "M";
        this.mUpdateTipView.setText(notifyPopup.hint);
        this.mDescView.setText(notifyPopup.changelogs);
        if (!k.isEmpty(notifyPopup.appendix_text) && !k.isEmpty(notifyPopup.appendix_link)) {
            this.mOtherApkView.setVisibility(0);
            this.mOtherApkView.setText(notifyPopup.appendix_text);
            if (notifyPopup.appendix_optional.intValue() == 0) {
                this.mOtherApkSelected = false;
            } else {
                this.mOtherApkSelected = true;
            }
            refreshOtherApkViewState();
        } else {
            this.mOtherApkView.setVisibility(8);
        }
        if (StringUtils.isNull(notifyPopup.n_btn_text)) {
            str = getResources().getString(R.string.cancel);
        } else {
            str = notifyPopup.n_btn_text;
        }
        if (StringUtils.isNull(notifyPopup.y_btn_text)) {
            str2 = getResources().getString(R.string.update_right_now);
        } else {
            str2 = notifyPopup.y_btn_text;
        }
        d.a.i0.r.s.a aVar = new d.a.i0.r.s.a(getActivity());
        aVar.setContentViewSize(1);
        aVar.setCanceledOnTouchOutside(false);
        aVar.setContentView(this.mDialogRootView);
        aVar.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.wallet.pay.WalletPayActivity.11
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
                if (4 == i2) {
                    dialogInterface.dismiss();
                    WalletPayActivity.this.finishSelf();
                    return false;
                }
                return false;
            }
        });
        aVar.setNegativeButton(str, new a.e() { // from class: com.baidu.tieba.wallet.pay.WalletPayActivity.12
            @Override // d.a.i0.r.s.a.e
            public void onClick(d.a.i0.r.s.a aVar2) {
                aVar2.dismiss();
                WalletPayActivity.this.finishSelf();
            }
        });
        aVar.setPositiveButton(str2, new a.e() { // from class: com.baidu.tieba.wallet.pay.WalletPayActivity.13
            @Override // d.a.i0.r.s.a.e
            public void onClick(d.a.i0.r.s.a aVar2) {
                if (!k.isEmpty(notifyPopup.y_btn_link)) {
                    d.a.i0.v.b.l().t("app_update" + new Date().getTime(), notifyPopup.y_btn_link, "tieba" + new Date().getTime(), null);
                }
                if (!k.isEmpty(notifyPopup.appendix_text) && WalletPayActivity.this.mOtherApkSelected && !k.isEmpty(notifyPopup.appendix_link)) {
                    d.a.i0.v.b.l().t("app_update_extra" + new Date().getTime(), notifyPopup.appendix_link, "tiebaextra" + new Date().getTime(), null);
                }
                aVar2.dismiss();
                WalletPayActivity.this.finishSelf();
            }
        });
        aVar.create(getPageContext());
        aVar.show();
    }

    public d.a.i0.r.s.a showPaySuccessDialog() {
        d.a.i0.r.s.a aVar = new d.a.i0.r.s.a(getPageContext().getPageActivity());
        aVar.setCanceledOnTouchOutside(false);
        aVar.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.wallet.pay.WalletPayActivity.6
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
                if (i2 == 4) {
                    dialogInterface.dismiss();
                    WalletPayActivity.this.finishSelf();
                    return false;
                }
                return false;
            }
        });
        aVar.setOnCalcelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.wallet.pay.WalletPayActivity.7
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WalletPayActivity.this.finishSelf();
            }
        });
        aVar.create(getPageContext());
        aVar.show();
        return aVar;
    }

    public void showResult(Boolean bool) {
        PayConfig payConfig;
        WalletPayViewController walletPayViewController = this.mViewController;
        if (walletPayViewController != null) {
            walletPayViewController.payResult(bool.booleanValue());
        }
        if (this.mPayConfig.getFrom() == 4) {
            if (bool.booleanValue()) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MemberPayResultActivityConfig(getPageContext().getPageActivity(), toChineseNumber(this.mPayConfig.getPropsMon()))));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016526, null));
                finish();
                return;
            }
            BdToast.c(getActivity(), getResources().getString(R.string.pay_fail)).q();
            finish();
        } else if (this.isFromDecreaseGiftStepStrategy != 0) {
            finish();
        } else {
            DataRes dataRes = this.mDataRes;
            if (dataRes != null && (payConfig = this.mPayConfig) != null) {
                payConfig.mOrderInfo = dataRes.orderId;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WalletPayResultActivityConfig(getPageContext().getPageActivity(), bool.booleanValue(), this.isPayDialog, this.mPayConfig)));
            finishSelf();
        }
    }

    public void showSimplePayErrorDialog(final NotifyPopup notifyPopup) {
        String str;
        String str2;
        if (notifyPopup == null) {
            return;
        }
        d.a.i0.r.s.a aVar = new d.a.i0.r.s.a(getActivity());
        aVar.setMessage(notifyPopup.hint);
        aVar.setCanceledOnTouchOutside(false);
        if (StringUtils.isNull(notifyPopup.n_btn_text)) {
            str = getResources().getString(R.string.cancel);
        } else {
            str = notifyPopup.n_btn_text;
        }
        if (StringUtils.isNull(notifyPopup.y_btn_text)) {
            str2 = getResources().getString(R.string.update_right_now);
        } else {
            str2 = notifyPopup.y_btn_text;
        }
        aVar.setNegativeButton(str, new a.e() { // from class: com.baidu.tieba.wallet.pay.WalletPayActivity.8
            @Override // d.a.i0.r.s.a.e
            public void onClick(d.a.i0.r.s.a aVar2) {
                aVar2.dismiss();
                WalletPayActivity.this.finishSelf();
            }
        });
        aVar.setPositiveButton(str2, new a.e() { // from class: com.baidu.tieba.wallet.pay.WalletPayActivity.9
            @Override // d.a.i0.r.s.a.e
            public void onClick(d.a.i0.r.s.a aVar2) {
                if (!k.isEmpty(notifyPopup.y_btn_link)) {
                    d.a.i0.v.b.l().t("app_update", notifyPopup.y_btn_link, "tieba", null);
                }
                aVar2.dismiss();
                WalletPayActivity.this.finishSelf();
            }
        });
        aVar.create(getPageContext());
        aVar.show();
    }
}
