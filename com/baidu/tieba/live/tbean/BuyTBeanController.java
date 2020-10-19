package com.baidu.tieba.live.tbean;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.adp.widget.listview.IAdapterData;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.BuyTBeanActivityConfig;
import com.baidu.live.tbadk.core.atomdata.PayWalletActivityConfig;
import com.baidu.live.tbadk.core.atomdata.PayWalletActivityOpaqueConfig;
import com.baidu.live.tbadk.core.data.AccountData;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.UrlManager;
import com.baidu.live.tbadk.data.BuyYinjiInfo;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.pay.PayHelper;
import com.baidu.live.tbadk.pay.PayManager;
import com.baidu.live.tbadk.pay.channel.interfaces.PayChannelType;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.tbadk.util.PageDialogHelper;
import com.baidu.live.utils.d;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.tieba.live.tbean.AbsBuyTBeanView;
import com.baidu.tieba.live.tbean.BuyTBeanModel;
import com.baidu.tieba.live.tbean.data.CustomData;
import com.baidu.tieba.live.tbean.data.GiftBagWrapperData;
import com.baidu.tieba.live.tbean.data.IconInfoWrapperData;
import com.baidu.tieba.live.tbean.data.UserInfoData;
import com.baidu.webkit.sdk.performance.ZeusPerformanceTiming;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class BuyTBeanController implements View.OnClickListener, BuyTBeanModel.CallBack {
    public static final String ACTION_CALLBACK_LIVE_BUYTBEAN_RESULT = "action_callback_live_buytbean_result";
    public static final String GIFT_TBEAN = "gift_tbean";
    public static final int PAY_STATUS_CANCEL = 1;
    public static final int PAY_STATUS_FAIL = 2;
    public static final int PAY_STATUS_SUCC = 0;
    private Activity activity;
    private IBuyTBeanActivity buyTBeanActivityImpl;
    private String callback;
    private String chargeId;
    private String entry;
    private String extraFromForLog;
    private String from;
    private boolean isTBeanNotEnough;
    private String mClickZone;
    private long mGiftBbean;
    private CustomData mLastPayDataInfo;
    private BuyTBeanModel mModel;
    private String mOtherParams;
    private String mReferPage;
    private AbsBuyTBeanView mView;
    private TbPageContext<?> tbPageContext;
    private String tdouNum;
    private boolean mIsFromH5 = false;
    private boolean isInputShowing = false;
    private int mPayStatus = 1;
    private int mLastPayItemTbeanCount = -1;
    private String mLastTotalMoneyByFen = "";
    private String orderId = "";
    private PayChannelType mPayChannelType = null;
    private CustomMessageListener mOnAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.live.tbean.BuyTBeanController.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage.getData() instanceof AccountData) && !TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount()) && BuyTBeanController.this.mModel != null) {
                BuyTBeanController.this.mModel.requestYinJiInfo();
            }
        }
    };
    CustomMessageListener notifyDialogDismissListener = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.live.tbean.BuyTBeanController.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view") && BuyTBeanController.this.buyTBeanActivityImpl != null) {
                BuyTBeanController.this.buyTBeanActivityImpl.finish();
            }
        }
    };
    private AbsBuyTBeanView.OnPayClickListener mOnPayClickListener = new AbsBuyTBeanView.OnPayClickListener() { // from class: com.baidu.tieba.live.tbean.BuyTBeanController.5
        @Override // com.baidu.tieba.live.tbean.AbsBuyTBeanView.OnPayClickListener
        public void onClick(IAdapterData iAdapterData, UserInfoData userInfoData, int i) {
            if (iAdapterData instanceof GiftBagWrapperData) {
                GiftBagWrapperData giftBagWrapperData = (GiftBagWrapperData) iAdapterData;
                if (giftBagWrapperData.mData != null) {
                    BuyTBeanController.this.payForTbean(giftBagWrapperData.mData.productId, giftBagWrapperData.mData.icon_id, TBeanUtil.getYuanFromFen(giftBagWrapperData.mData.dubi) * 1, 1, giftBagWrapperData.mData.non_member_t * 1, giftBagWrapperData.mData.pic_url, giftBagWrapperData.mData.duration, giftBagWrapperData.mData.name, i);
                    TiebaInitialize.log(TbeanStatisticKey.BUY_TBEAN_GIFT_BAG);
                }
            } else if (iAdapterData instanceof IconInfoWrapperData) {
                IconInfoWrapperData iconInfoWrapperData = (IconInfoWrapperData) iAdapterData;
                if (iconInfoWrapperData.info != null) {
                    String str = iconInfoWrapperData.info.productId;
                    int yuanFromFen = TBeanUtil.getYuanFromFen(iconInfoWrapperData.info.dubi) * 1;
                    int tBeanNum = TBeanUtil.getTBeanNum(userInfoData, iconInfoWrapperData.info.non_member_t, iconInfoWrapperData.mSetting) * 1;
                    BuyTBeanController.this.payForTbean(str, iconInfoWrapperData.info.iconId, yuanFromFen, 1, tBeanNum, iconInfoWrapperData.info.picUrl, iconInfoWrapperData.info.duration, iconInfoWrapperData.info.name, i);
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        LogManager.getCommonLogger().doClickBuyTBeanListLog(BuyTBeanController.this.extraFromForLog, BuyTBeanController.this.mOtherParams, String.valueOf(yuanFromFen));
                    }
                    if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                        LogManager.getCommonLogger().doClickBuyTBeanListLog(BuyTBeanController.this.extraFromForLog, BuyTBeanController.this.mOtherParams, String.valueOf(tBeanNum));
                    }
                }
            }
        }
    };
    CustomMessageListener mPayResultListener = new CustomMessageListener(2913137) { // from class: com.baidu.tieba.live.tbean.BuyTBeanController.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Intent)) {
                Intent intent = (Intent) customResponsedMessage.getData();
                int intExtra = intent.getIntExtra("result_code", -1);
                int intExtra2 = intent.getIntExtra("result_payinfo_status", -1);
                String stringExtra = intent.getStringExtra("result_tbean_num");
                BuyTBeanController.this.orderId = intent.getStringExtra("result_order_id");
                BuyTBeanController.this.handlePayResult(intExtra, intExtra2, stringExtra);
                String stringExtra2 = intent.getStringExtra("pay_channel_type_name");
                BuyTBeanController.this.mPayChannelType = PayChannelType.valueOf(stringExtra2);
            }
        }
    };

    public BuyTBeanController(TbPageContext<?> tbPageContext, IBuyTBeanActivity iBuyTBeanActivity, Intent intent) {
        this.tbPageContext = tbPageContext;
        this.activity = tbPageContext.getPageActivity();
        this.buyTBeanActivityImpl = iBuyTBeanActivity;
        init(intent);
    }

    protected void init(Intent intent) {
        this.mReferPage = intent.getStringExtra("refer_page");
        this.mClickZone = intent.getStringExtra("click_zone");
        this.mOtherParams = intent.getStringExtra("other_params");
        this.callback = intent.getStringExtra(BuyTBeanActivityConfig.CALLBACK);
        this.isTBeanNotEnough = intent.getBooleanExtra(BuyTBeanActivityConfig.T_BEAN_NOT_ENOUGH, false);
        boolean booleanExtra = intent.getBooleanExtra(BuyTBeanActivityConfig.FROM_LIVE, false);
        boolean booleanExtra2 = intent.getBooleanExtra("is_translucent", false);
        this.from = intent.getStringExtra("from");
        this.mGiftBbean = intent.getLongExtra("gift_tbean", 0L);
        this.mIsFromH5 = intent.getBooleanExtra(BuyTBeanActivityConfig.PAY_SOURCE, false);
        this.buyTBeanActivityImpl.showLoadingDialog(this.activity.getString(a.i.sdk_tbn_flist_loading));
        this.mView = BuyTBeanViewFactory.buildBuyTBeanView(this.tbPageContext, this, booleanExtra, booleanExtra2, this.isTBeanNotEnough);
        this.mView.hideRootView();
        this.mView.setOtherParams(this.mOtherParams);
        this.mView.setOnPayClickListener(this.mOnPayClickListener);
        this.mModel = new BuyTBeanModel(this.tbPageContext, this, this);
        this.mModel.registerYinJiHttpListener();
        this.mModel.requestYinJiInfo();
        TiebaInitialize.log(TbeanStatisticKey.BUY_TBEAN_ACTIVITY);
        MessageManager.getInstance().registerListener(this.mOnAccountChangedListener);
        MessageManager.getInstance().registerListener(this.notifyDialogDismissListener);
        MessageManager.getInstance().registerListener(this.mPayResultListener);
        this.mLastPayDataInfo = new CustomData();
        this.extraFromForLog = intent.getStringExtra(BuyTBeanActivityConfig.FROM_EXTRA);
        if (this.extraFromForLog == null) {
            this.extraFromForLog = "";
        }
        LogManager.getCommonLogger().doDisplayBuyTBeanPageLog(null, this.mOtherParams, this.extraFromForLog);
        this.entry = this.extraFromForLog;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("charge_mode", this.isTBeanNotEnough ? "2" : "1");
            if (this.entry != null) {
                jSONObject.putOpt(ZeusPerformanceTiming.KEY_BROWSER_STARTUP, this.entry);
            }
            jSONObject.putOpt("charge_id", "");
            jSONObject.putOpt("td_num", "");
        } catch (Exception e) {
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "charge_show").setContentExt(null, MapController.POPUP_LAYER_TAG, jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putLong("gift_tbean", this.mGiftBbean);
        bundle.putBoolean(BuyTBeanActivityConfig.PAY_SOURCE, this.mIsFromH5);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == a.g.tbean_get_introduce || view.getId() == a.g.sdk_tbn_t_dou_introduce_activity_right_button) {
            UrlManager.getInstance().dealOneLink(this.tbPageContext, new String[]{"https://sv.baidu.com/cashliveui/statictHtml.html#/tbeanDesc"});
        } else if (view.getId() == a.g.navigationBarGoBack || view.getId() == a.g.empty_stub_view) {
            processClose();
        } else if (view.getId() == a.g.tbean_dialog_close_btn) {
            processClose();
        } else if (view.getId() == a.g.img_back) {
            processClose();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || this.isInputShowing) {
            return false;
        }
        processClose();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void processClose() {
        if (this.mPayStatus != 0) {
            BdAlertDialog bdAlertDialog = new BdAlertDialog(this.activity);
            bdAlertDialog.setAutoNight(true);
            bdAlertDialog.setCancelable(true);
            bdAlertDialog.setTitleShowCenter(true);
            bdAlertDialog.setMessageShowCenter(true);
            bdAlertDialog.setTitle(this.activity.getString(a.i.sdk_tbn_buy_tbean_exit_dialog_title));
            bdAlertDialog.setMessage(this.activity.getString(a.i.sdk_tbn_buy_tbean_exit_dialog_sub_title));
            bdAlertDialog.setPositiveButton(this.activity.getString(a.i.sdk_tbn_go_on), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.live.tbean.BuyTBeanController.1
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog2) {
                    bdAlertDialog2.dismiss();
                    BuyTBeanController.this.mView.hidePayResultView();
                }
            });
            bdAlertDialog.setNegativeButton(this.activity.getString(a.i.sdk_tbn_buy_tbean_exit_dialog_quit), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.live.tbean.BuyTBeanController.2
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog2) {
                    BuyTBeanController.this.finishSelf();
                }
            });
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                bdAlertDialog.setPositiveButtonTextColor(this.activity.getResources().getColorStateList(a.f.sdk_dialog_blue_button_txt_selector));
                bdAlertDialog.setNagetiveButtonTextColor(this.activity.getResources().getColorStateList(a.f.sdk_dialog_gray_button_txt_selector));
            }
            bdAlertDialog.create(this.tbPageContext).show();
            return;
        }
        finishSelf();
    }

    public void payForTbean(String str, String str2, int i, int i2, int i3, String str3, int i4, String str4, int i5) {
        IntentConfig payWalletActivityConfig;
        if (!StringUtils.isNull(str2) && i >= 0 && i2 >= 0 && i3 >= 0) {
            this.chargeId = String.valueOf(i5 + 1);
            this.tdouNum = String.valueOf(i3);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("charge_mode", this.isTBeanNotEnough ? "0" : "1");
                if (this.entry != null) {
                    jSONObject.putOpt(ZeusPerformanceTiming.KEY_BROWSER_STARTUP, this.entry);
                }
                jSONObject.putOpt("charge_id", this.chargeId);
                jSONObject.putOpt("td_num", this.tdouNum);
            } catch (Exception e) {
            }
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "charge_clk").setContentExt(null, MapController.POPUP_LAYER_TAG, jSONObject));
            TbeanStatisticKey.logWithMember(TbeanStatisticKey.BUY_TBEAN_BUY);
            String valueOf = String.valueOf(i);
            String valueOf2 = String.valueOf(i2);
            String valueOf3 = String.valueOf(i3);
            if (!TbadkCoreApplication.getInst().isMobileBaidu() && Build.VERSION.SDK_INT >= 28 && !d.aA(this.activity)) {
                payWalletActivityConfig = new PayWalletActivityOpaqueConfig(this.activity, 2, "0", str2, valueOf, valueOf2, true, valueOf3, false, PageDialogHelper.PayForm.NOT_SET, getReferPage(), getClickZone(), RequestResponseCode.REQUEST_DO_PAY);
                if (!TextUtils.isEmpty(this.from)) {
                    ((PayWalletActivityOpaqueConfig) payWalletActivityConfig).setFrom(this.from);
                }
            } else {
                payWalletActivityConfig = new PayWalletActivityConfig(this.activity, 2, "0", str2, valueOf, valueOf2, true, valueOf3, false, PageDialogHelper.PayForm.NOT_SET, getReferPage(), getClickZone(), RequestResponseCode.REQUEST_DO_PAY);
                if (!TextUtils.isEmpty(this.from)) {
                    ((PayWalletActivityConfig) payWalletActivityConfig).setFrom(this.from);
                }
            }
            PayManager.getInstance().doPayByWallet(payWalletActivityConfig);
            this.mLastPayDataInfo.pic_url = str3;
            this.mLastPayDataInfo.duration = i4;
            this.mLastPayDataInfo.name = str4;
            this.mLastPayDataInfo.productId = str;
            this.mLastTotalMoneyByFen = (i * 100) + "";
            this.mLastPayItemTbeanCount = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (25041 == i && intent != null) {
            int intExtra = intent.getIntExtra("result_code", -1);
            int intExtra2 = intent.getIntExtra("result_payinfo_status", -1);
            String stringExtra = intent.getStringExtra("result_tbean_num");
            this.mPayChannelType = PayChannelType.valueOf(intent.getStringExtra("pay_channel_type_name"));
            this.orderId = intent.getStringExtra("result_order_id");
            handlePayResult(intExtra, intExtra2, stringExtra);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlePayResult(int i, int i2, String str) {
        switch (i) {
            case 0:
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("charge_mode", this.isTBeanNotEnough ? "0" : "1");
                    if (this.entry != null) {
                        jSONObject.putOpt(ZeusPerformanceTiming.KEY_BROWSER_STARTUP, this.entry);
                    }
                    jSONObject.putOpt("order_id", this.orderId);
                    jSONObject.putOpt("charge_status", "1");
                    jSONObject.putOpt("charge_id", this.chargeId);
                    jSONObject.putOpt("td_num", this.tdouNum);
                } catch (Exception e) {
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "chargesucc").setContentExt(null, MapController.POPUP_LAYER_TAG, jSONObject));
                this.mPayStatus = 0;
                this.mView.showPayResultView(true, this.mLastPayItemTbeanCount, this.mLastPayDataInfo);
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.putOpt("charge_mode", this.isTBeanNotEnough ? "0" : "1");
                    if (this.entry != null) {
                        jSONObject2.putOpt(ZeusPerformanceTiming.KEY_BROWSER_STARTUP, this.entry);
                    }
                    jSONObject2.putOpt("charge_status", "1");
                    jSONObject2.putOpt("charge_id", this.chargeId);
                    jSONObject2.putOpt("td_num", this.tdouNum);
                } catch (Exception e2) {
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "chargesucc").setContentExt(null, MapController.POPUP_LAYER_TAG, jSONObject2));
                notifyPayResult(true, i2, str);
                return;
            case 1:
                this.mPayStatus = 1;
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.putOpt("charge_mode", this.isTBeanNotEnough ? "0" : "1");
                    if (this.entry != null) {
                        jSONObject3.putOpt(ZeusPerformanceTiming.KEY_BROWSER_STARTUP, this.entry);
                    }
                    jSONObject3.putOpt("order_id", this.orderId);
                    jSONObject3.putOpt("charge_status", "2");
                    jSONObject3.putOpt("charge_id", this.chargeId);
                    jSONObject3.putOpt("td_num", this.tdouNum);
                } catch (Exception e3) {
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "chargesucc").setContentExt(null, MapController.POPUP_LAYER_TAG, jSONObject3));
                return;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                this.mPayStatus = 2;
                this.mView.showPayResultView(false, this.mLastPayItemTbeanCount, this.mLastPayDataInfo);
                notifyPayResult(false, i2, str);
                JSONObject jSONObject4 = new JSONObject();
                try {
                    jSONObject4.putOpt("charge_mode", this.isTBeanNotEnough ? "0" : "1");
                    if (this.entry != null) {
                        jSONObject4.putOpt(ZeusPerformanceTiming.KEY_BROWSER_STARTUP, this.entry);
                    }
                    jSONObject4.putOpt("order_id", this.orderId);
                    jSONObject4.putOpt("charge_status", "1");
                    jSONObject4.putOpt("charge_id", this.chargeId);
                    jSONObject4.putOpt("td_num", this.tdouNum);
                } catch (Exception e4) {
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "chargesucc").setContentExt(null, MapController.POPUP_LAYER_TAG, jSONObject4));
                return;
            default:
                return;
        }
    }

    private void notifyPayResult(boolean z, int i, String str) {
        if (z) {
            TbeanStatisticKey.logWithMember(TbeanStatisticKey.BUY_TBEAN_SUCCESS);
            BuyYinjiInfo buyYinjiInfo = new BuyYinjiInfo();
            buyYinjiInfo.setTBeanNum(str);
            buyYinjiInfo.setStatus(i);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_BUY_YINJI_SUCCESS, buyYinjiInfo));
        }
    }

    private void getGiftTBean(Intent intent) {
        this.mGiftBbean = intent.getLongExtra("gift_tbean", 0L);
        this.mIsFromH5 = intent.getBooleanExtra(BuyTBeanActivityConfig.PAY_SOURCE, false);
    }

    public long getGiftTBean() {
        return this.mGiftBbean;
    }

    public AbsBuyTBeanView getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.live.tbean.BuyTBeanModel.CallBack
    public void onFailed(String str) {
        this.buyTBeanActivityImpl.showToast(str);
        this.buyTBeanActivityImpl.closeLoadingDialog();
        if (this.mView != null) {
            this.mView.showRootView();
            this.mView.hideContainerView();
            this.buyTBeanActivityImpl.setNetRefreshViewTopMargin(0);
            this.buyTBeanActivityImpl.showNetRefreshView(this.mView.getRootView(), this.activity.getResources().getString(a.i.sdk_neterror));
        }
    }

    @Override // com.baidu.tieba.live.tbean.BuyTBeanModel.CallBack
    public void onSuccess() {
        this.buyTBeanActivityImpl.closeLoadingDialog();
        this.buyTBeanActivityImpl.hideNetRefreshView(this.mView.getRootView());
        if (this.mView != null) {
            this.mView.showRootView();
            this.mView.showContainerView();
            this.mView.setData(this.mModel);
        }
    }

    @Override // com.baidu.tieba.live.tbean.BuyTBeanModel.CallBack
    public void onGetWalletUrl(String str) {
        if (!StringUtils.isNull(str)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_OPEN_WALLET_ICASH, str));
        }
    }

    public void refresh() {
        if (this.mModel != null && this.mView != null) {
            this.buyTBeanActivityImpl.showLoadingDialog(this.activity.getString(a.i.sdk_tbn_flist_loading));
            this.mView.hideContainerView();
            this.mModel.requestYinJiInfo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishSelf() {
        if (this.mPayStatus == 0) {
            PayHelper.notifyPayResult(PayHelper.STATUS_SUCC, "成功", setBuyResultForCallBack(), this.activity, this.mIsFromH5, this.mPayChannelType);
            setBuyResultForCallback(0);
        } else if (this.mPayStatus == 2) {
            PayHelper.notifyPayResult(PayHelper.STATUS_FAIL, PayHelper.STATUS_FAIL_DESC, setBuyResultForCallBack(), this.activity, this.mIsFromH5, this.mPayChannelType);
            setBuyResultForCallback(-1);
        } else if (this.mPayStatus == 1) {
            PayHelper.notifyPayResult("1000", PayHelper.STATUS_CANCEL_DESC, setBuyResultForCallBack(), this.activity, this.mIsFromH5, this.mPayChannelType);
            setBuyResultForCallback(-2);
        } else {
            PayHelper.notifyPayResult("1000", PayHelper.STATUS_CANCEL_DESC, setBuyResultForCallBack(), this.activity, this.mIsFromH5, this.mPayChannelType);
            setBuyResultForCallback(-2);
        }
        this.buyTBeanActivityImpl.finish();
    }

    private String setBuyResultForCallBack() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(BuyTBeanActivityConfig.CALLBACK, this.callback);
            if (this.mLastPayDataInfo != null && !TextUtils.isEmpty(this.mLastPayDataInfo.productId)) {
                jSONObject.put("productId", this.mLastPayDataInfo.productId);
            }
            if (!TextUtils.isEmpty(this.mLastTotalMoneyByFen)) {
                jSONObject.put("total", this.mLastTotalMoneyByFen);
            }
            if (!TextUtils.isEmpty(this.orderId)) {
                jSONObject.put("transitionId", this.orderId);
            }
        } catch (Exception e) {
            BdLog.e("make pay callback result fail");
        }
        return jSONObject.toString();
    }

    private void setBuyResultForCallback(int i) {
        if (!TextUtils.isEmpty(this.callback)) {
            Intent intent = new Intent(ACTION_CALLBACK_LIVE_BUYTBEAN_RESULT);
            intent.putExtra(BuyTBeanActivityConfig.CALLBACK, this.callback);
            if (this.mLastPayDataInfo != null && !TextUtils.isEmpty(this.mLastPayDataInfo.productId)) {
                intent.putExtra("productId", this.mLastPayDataInfo.productId);
            }
            if (!TextUtils.isEmpty(this.mLastTotalMoneyByFen)) {
                intent.putExtra("total", this.mLastTotalMoneyByFen);
            }
            if (!TextUtils.isEmpty(this.orderId)) {
                intent.putExtra("transitionId", this.orderId);
            }
            if (i >= 0) {
                intent.putExtra("status", 0);
                intent.putExtra("message", "充值成功");
                this.buyTBeanActivityImpl.setResultIntent(-1, intent);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913189, "chargeSuc"));
            } else if (i == -1) {
                intent.putExtra("status", -1);
                intent.putExtra("message", "充值失败");
                this.buyTBeanActivityImpl.setResultIntent(0, intent);
            } else {
                intent.putExtra("status", -2);
                intent.putExtra("message", "取消充值");
                this.buyTBeanActivityImpl.setResultIntent(0, intent);
            }
            ExtraParamsManager.getInstance();
            ExtraParamsManager.handleResultCallback(ExtraParamsManager.KEY_BUY_TBEAN_RESULT_CALLBACK, intent);
        }
    }

    public void finish() {
        this.buyTBeanActivityImpl.finish();
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.mOnAccountChangedListener);
        MessageManager.getInstance().unRegisterListener(this.notifyDialogDismissListener);
        MessageManager.getInstance().unRegisterListener(this.mPayResultListener);
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        this.isInputShowing = z;
        if (this.mView != null) {
            this.mView.onKeyboardVisibilityChanged(z);
        }
    }

    public String getReferPage() {
        return this.mReferPage;
    }

    public String getClickZone() {
        return this.mClickZone;
    }
}
