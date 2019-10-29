package com.baidu.tieba.live.tbean;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.adp.widget.listview.IAdapterData;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.BaseActivity;
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
import com.baidu.live.tbadk.util.PageDialogHelper;
import com.baidu.live.utils.c;
import com.baidu.tieba.live.tbean.BuyTBeanFullscreenModel;
import com.baidu.tieba.live.tbean.BuyTBeanFullscreenView;
import com.baidu.tieba.live.tbean.data.CustomData;
import com.baidu.tieba.live.tbean.data.GiftBagWrapperData;
import com.baidu.tieba.live.tbean.data.IconInfoWrapperData;
import com.baidu.tieba.live.tbean.data.UserInfoData;
import java.lang.ref.WeakReference;
/* loaded from: classes6.dex */
public class BuyTBeanFullscreenActivity extends BaseActivity<BuyTBeanFullscreenActivity> implements BuyTBeanFullscreenModel.CallBack {
    public static final String BROADCAST_ACTION = "com.baidu.minivideo.live.action.pay_broadcast";
    public static final String BROADCAST_PERMISSION = "com.baidu.minivideo.live.permission.PAY_BROADCAST";
    private static final String GIFT_TBEAN = "gift_tbean";
    private String callback;
    private String extraFromForLog;
    private String from;
    private boolean isTBeanNotEnough;
    private String mClickZone;
    private MyBroadcastReceiver mDetailReceive;
    private long mGiftBbean;
    private CustomData mLastPayDataInfo;
    private BuyTBeanFullscreenModel mModel;
    private String mOtherParams;
    private String mReferPage;
    private BuyTBeanFullscreenView mView;
    private final int PAY_STATUS_SUCC = 0;
    private final int PAY_STATUS_CANCEL = 1;
    private final int PAY_STATUS_FAIL = 2;
    private final String ACTION_CALLBACK_LIVE_BUYTBEAN_RESULT = "action_callback_live_buytbean_result";
    private boolean mIsFromH5 = false;
    private boolean isInputShowing = false;
    private int mPayStatus = 1;
    private int mLastPayItemTbeanCount = -1;
    private String mLastTotalMoneyByFen = "";
    private String orderId = "";
    private CustomMessageListener mOnAccountChangedListener = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.live.tbean.BuyTBeanFullscreenActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage.getData() instanceof AccountData) && !TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount()) && BuyTBeanFullscreenActivity.this.mModel != null) {
                BuyTBeanFullscreenActivity.this.mModel.requestYinJiInfo();
            }
        }
    };
    CustomMessageListener notifyDialogDismissListener = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.live.tbean.BuyTBeanFullscreenActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                BuyTBeanFullscreenActivity.this.finish();
            }
        }
    };
    private BuyTBeanFullscreenView.OnPayClickListener mOnPayClickListener = new BuyTBeanFullscreenView.OnPayClickListener() { // from class: com.baidu.tieba.live.tbean.BuyTBeanFullscreenActivity.3
        @Override // com.baidu.tieba.live.tbean.BuyTBeanFullscreenView.OnPayClickListener
        public void onClick(IAdapterData iAdapterData, UserInfoData userInfoData) {
            if (iAdapterData instanceof GiftBagWrapperData) {
                GiftBagWrapperData giftBagWrapperData = (GiftBagWrapperData) iAdapterData;
                if (giftBagWrapperData.mData != null) {
                    BuyTBeanFullscreenActivity.this.payForTbean(giftBagWrapperData.mData.productId, giftBagWrapperData.mData.icon_id, TBeanUtil.getYuanFromFen(giftBagWrapperData.mData.dubi) * 1, 1, giftBagWrapperData.mData.non_member_t * 1, giftBagWrapperData.mData.pic_url, giftBagWrapperData.mData.duration, giftBagWrapperData.mData.name);
                    TiebaInitialize.log(TbeanStatisticKey.BUY_TBEAN_GIFT_BAG);
                }
            } else if (iAdapterData instanceof IconInfoWrapperData) {
                IconInfoWrapperData iconInfoWrapperData = (IconInfoWrapperData) iAdapterData;
                if (iconInfoWrapperData.info != null) {
                    String str = iconInfoWrapperData.info.productId;
                    int yuanFromFen = TBeanUtil.getYuanFromFen(iconInfoWrapperData.info.dubi) * 1;
                    int tBeanNum = TBeanUtil.getTBeanNum(userInfoData, iconInfoWrapperData.info.non_member_t, iconInfoWrapperData.mSetting) * 1;
                    BuyTBeanFullscreenActivity.this.payForTbean(str, iconInfoWrapperData.info.iconId, yuanFromFen, 1, tBeanNum, iconInfoWrapperData.info.picUrl, iconInfoWrapperData.info.duration, iconInfoWrapperData.info.name);
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        LogManager.getCommonLogger().doClickBuyTBeanListLog(BuyTBeanFullscreenActivity.this.extraFromForLog, BuyTBeanFullscreenActivity.this.mOtherParams, String.valueOf(yuanFromFen));
                    }
                    if (TbadkCoreApplication.getInst().isQuanmin()) {
                        LogManager.getCommonLogger().doClickBuyTBeanListLog(BuyTBeanFullscreenActivity.this.extraFromForLog, BuyTBeanFullscreenActivity.this.mOtherParams, String.valueOf(tBeanNum));
                    }
                }
            }
        }
    };
    private boolean mReceiverTag = false;

    public void payForTbean(String str, String str2, int i, int i2, int i3, String str3, int i4, String str4) {
        IntentConfig payWalletActivityConfig;
        if (!StringUtils.isNull(str2) && i >= 0 && i2 >= 0 && i3 >= 0) {
            TbeanStatisticKey.logWithMember(TbeanStatisticKey.BUY_TBEAN_BUY);
            String valueOf = String.valueOf(i);
            String valueOf2 = String.valueOf(i2);
            String valueOf3 = String.valueOf(i3);
            if (Build.VERSION.SDK_INT >= 28 && !c.at(getPageContext().getPageActivity())) {
                payWalletActivityConfig = new PayWalletActivityOpaqueConfig(getPageContext().getPageActivity(), 2, "0", str2, valueOf, valueOf2, true, valueOf3, false, PageDialogHelper.PayForm.NOT_SET, getReferPage(), getClickZone(), RequestResponseCode.REQUEST_DO_PAY);
                if (!TextUtils.isEmpty(this.from)) {
                    ((PayWalletActivityOpaqueConfig) payWalletActivityConfig).setFrom(this.from);
                }
            } else {
                payWalletActivityConfig = new PayWalletActivityConfig(getPageContext().getPageActivity(), 2, "0", str2, valueOf, valueOf2, true, valueOf3, false, PageDialogHelper.PayForm.NOT_SET, getReferPage(), getClickZone(), RequestResponseCode.REQUEST_DO_PAY);
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
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        getWindow().setSoftInputMode(16);
        this.mReferPage = getIntent().getStringExtra("refer_page");
        this.mClickZone = getIntent().getStringExtra("click_zone");
        this.mOtherParams = getIntent().getStringExtra("other_params");
        this.callback = getIntent().getStringExtra(BuyTBeanActivityConfig.CALLBACK);
        this.isTBeanNotEnough = getIntent().getBooleanExtra(BuyTBeanActivityConfig.T_BEAN_NOT_ENOUGH, false);
        boolean booleanExtra = getIntent().getBooleanExtra(BuyTBeanActivityConfig.FROM_LIVE, false);
        boolean booleanExtra2 = getIntent().getBooleanExtra("is_translucent", false);
        this.from = getIntent().getStringExtra("from");
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(false);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        super.onCreate(bundle);
        if (bundle != null) {
            this.mGiftBbean = bundle.getLong("gift_tbean");
            this.mIsFromH5 = bundle.getBoolean(BuyTBeanActivityConfig.PAY_SOURCE, false);
        }
        getGiftTBean(getIntent());
        showLoadingDialog(getPageContext().getString(a.i.sdk_tbn_flist_loading));
        this.mView = new BuyTBeanFullscreenView(this, booleanExtra, booleanExtra2, this.isTBeanNotEnough);
        this.mView.hideRootView();
        this.mView.setOtherParams(this.mOtherParams);
        this.mView.setOnPayClickListener(this.mOnPayClickListener);
        this.mModel = new BuyTBeanFullscreenModel(this, this);
        this.mModel.registerYinJiHttpListener();
        this.mModel.requestYinJiInfo();
        TiebaInitialize.log(TbeanStatisticKey.BUY_TBEAN_ACTIVITY);
        MessageManager.getInstance().registerListener(this.mOnAccountChangedListener);
        MessageManager.getInstance().registerListener(this.notifyDialogDismissListener);
        this.mLastPayDataInfo = new CustomData();
        if (getIntent() != null) {
            this.extraFromForLog = getIntent().getStringExtra(BuyTBeanActivityConfig.FROM_EXTRA);
        }
        if (this.extraFromForLog == null) {
            this.extraFromForLog = "";
        }
        LogManager.getCommonLogger().doDisplayBuyTBeanPageLog(null, this.mOtherParams, this.extraFromForLog);
        if (!this.mReceiverTag) {
            this.mDetailReceive = new MyBroadcastReceiver(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.minivideo.live.action.pay_broadcast");
            registerReceiver(this.mDetailReceive, intentFilter, "com.baidu.minivideo.live.permission.PAY_BROADCAST", null);
            this.mReceiverTag = true;
        }
    }

    @Override // com.baidu.live.tbadk.BaseActivity
    public void enterExitAnimation() {
        clearAnimatable();
        clearAnimation();
        overridePendingTransition(0, 0);
    }

    @Override // com.baidu.live.tbadk.BaseActivity
    public void closeAnimation() {
        clearAnimatable();
        clearAnimation();
        overridePendingTransition(0, 0);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putLong("gift_tbean", this.mGiftBbean);
        bundle.putBoolean(BuyTBeanActivityConfig.PAY_SOURCE, this.mIsFromH5);
    }

    @Override // com.baidu.live.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == a.g.tbean_get_introduce || view.getId() == a.g.sdk_tbn_t_dou_introduce_activity_right_button) {
            UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{"https://tieba.baidu.com/tb/tdou_mobile_quanmin.html"});
        } else if (view.getId() == a.g.navigationBarGoBack || view.getId() == a.g.empty_stub_view) {
            processClose();
        } else if (view.getId() == a.g.tbean_dialog_close_btn) {
            processClose();
        }
    }

    @Override // com.baidu.live.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.isInputShowing) {
                return super.onKeyDown(i, keyEvent);
            }
            processClose();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void processClose() {
        if (this.mPayStatus != 0) {
            BdAlertDialog bdAlertDialog = new BdAlertDialog(getActivity());
            bdAlertDialog.setAutoNight(true);
            bdAlertDialog.setCancelable(true);
            bdAlertDialog.setTitleShowCenter(true);
            bdAlertDialog.setMessageShowCenter(true);
            bdAlertDialog.setTitle(getString(a.i.sdk_tbn_buy_tbean_exit_dialog_title));
            bdAlertDialog.setMessage(getString(a.i.sdk_tbn_buy_tbean_exit_dialog_sub_title));
            bdAlertDialog.setPositiveButton(getString(a.i.sdk_tbn_go_on), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.live.tbean.BuyTBeanFullscreenActivity.4
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog2) {
                    bdAlertDialog2.dismiss();
                    BuyTBeanFullscreenActivity.this.mView.hidePayResultView();
                }
            });
            bdAlertDialog.setNegativeButton(getString(a.i.sdk_tbn_buy_tbean_exit_dialog_quit), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.live.tbean.BuyTBeanFullscreenActivity.5
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog2) {
                    BuyTBeanFullscreenActivity.this.finishSelf();
                }
            });
            bdAlertDialog.create(getPageContext()).show();
            return;
        }
        finishSelf();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (25041 == i && intent != null) {
            int intExtra = intent.getIntExtra("result_code", -1);
            int intExtra2 = intent.getIntExtra("result_payinfo_status", -1);
            String stringExtra = intent.getStringExtra("result_tbean_num");
            this.orderId = intent.getStringExtra("result_order_id");
            handlePayResult(intExtra, intExtra2, stringExtra);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlePayResult(int i, int i2, String str) {
        switch (i) {
            case 0:
                this.mPayStatus = 0;
                this.mView.showPayResultView(true, this.mLastPayItemTbeanCount, this.mLastPayDataInfo);
                notifyPayResult(true, i2, str);
                return;
            case 1:
                this.mPayStatus = 1;
                return;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                this.mPayStatus = 2;
                this.mView.showPayResultView(false, this.mLastPayItemTbeanCount, this.mLastPayDataInfo);
                notifyPayResult(false, i2, str);
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

    public BuyTBeanFullscreenView getView() {
        return this.mView;
    }

    @Override // com.baidu.tieba.live.tbean.BuyTBeanFullscreenModel.CallBack
    public void onFailed(String str) {
        showToast(str);
        closeLoadingDialog();
        if (this.mView != null) {
            this.mView.showRootView();
            this.mView.hideContainerView();
            setNetRefreshViewTopMargin(0);
            showNetRefreshView(this.mView.getRootView(), getResources().getString(a.i.sdk_neterror));
        }
    }

    @Override // com.baidu.tieba.live.tbean.BuyTBeanFullscreenModel.CallBack
    public void onSuccess() {
        closeLoadingDialog();
        hideNetRefreshView(this.mView.getRootView());
        if (this.mView != null) {
            this.mView.showRootView();
            this.mView.showContainerView();
            this.mView.setData(this.mModel);
        }
    }

    @Override // com.baidu.tieba.live.tbean.BuyTBeanFullscreenModel.CallBack
    public void onGetWalletUrl(String str) {
        if (!StringUtils.isNull(str)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_OPEN_WALLET_ICASH, str));
        }
    }

    public void refresh() {
        if (this.mModel != null && this.mView != null) {
            showLoadingDialog(getPageContext().getString(a.i.sdk_tbn_flist_loading));
            this.mView.hideContainerView();
            this.mModel.requestYinJiInfo();
        }
    }

    @Override // com.baidu.live.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        refresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishSelf() {
        if (this.mPayStatus == 0) {
            PayHelper.notifyPayResult(PayHelper.STATUS_SUCC, "成功", getActivity(), this.mIsFromH5);
            setBuyResultForCallback(0);
        } else if (this.mPayStatus == 2) {
            PayHelper.notifyPayResult(PayHelper.STATUS_FAIL, PayHelper.STATUS_FAIL_DESC, getActivity(), this.mIsFromH5);
            setBuyResultForCallback(-1);
        } else if (this.mPayStatus == 1) {
            PayHelper.notifyPayResult("1000", PayHelper.STATUS_CANCEL_DESC, getActivity(), this.mIsFromH5);
            setBuyResultForCallback(-2);
        } else {
            PayHelper.notifyPayResult("1000", PayHelper.STATUS_CANCEL_DESC, getActivity(), this.mIsFromH5);
            setBuyResultForCallback(-2);
        }
        getActivity().finish();
    }

    private void setBuyResultForCallback(int i) {
        if (!TextUtils.isEmpty(this.callback)) {
            Intent intent = new Intent("action_callback_live_buytbean_result");
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
                setResult(-1, intent);
            } else if (i == -1) {
                intent.putExtra("status", -1);
                intent.putExtra("message", "充值失败");
                setResult(0, intent);
            } else {
                intent.putExtra("status", -2);
                intent.putExtra("message", "取消充值");
                setResult(0, intent);
            }
            ExtraParamsManager.getInstance();
            ExtraParamsManager.handleResultCallback(ExtraParamsManager.KEY_BUY_TBEAN_RESULT_CALLBACK, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        clearAnimatable();
        clearAnimation();
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.mOnAccountChangedListener);
        MessageManager.getInstance().unRegisterListener(this.notifyDialogDismissListener);
        if (this.mDetailReceive != null && this.mReceiverTag) {
            unregisterReceiver(this.mDetailReceive);
            this.mReceiverTag = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
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

    /* loaded from: classes6.dex */
    public static class MyBroadcastReceiver extends BroadcastReceiver {
        WeakReference<BuyTBeanFullscreenActivity> reference;

        public MyBroadcastReceiver(BuyTBeanFullscreenActivity buyTBeanFullscreenActivity) {
            this.reference = new WeakReference<>(buyTBeanFullscreenActivity);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null && this.reference != null && this.reference.get() != null && TextUtils.equals("com.baidu.minivideo.live.action.pay_broadcast", intent.getAction())) {
                int intExtra = intent.getIntExtra("result_code", -1);
                int intExtra2 = intent.getIntExtra("result_payinfo_status", -1);
                String stringExtra = intent.getStringExtra("result_tbean_num");
                this.reference.get().orderId = intent.getStringExtra("result_order_id");
                this.reference.get().handlePayResult(intExtra, intExtra2, stringExtra);
            }
        }
    }
}
