package com.baidu.wallet.paysdk.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.apollon.eventbus.EventBus;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.apollon.utils.support.ViewHelper;
import com.baidu.wallet.base.controllers.PayController;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.base.widget.BdActionBar;
import com.baidu.wallet.base.widget.SafeKeyBoardEditText;
import com.baidu.wallet.base.widget.SafeScrollView;
import com.baidu.wallet.base.widget.dialog.PromptDialog;
import com.baidu.wallet.base.widget.dialog.PromptImageDialog;
import com.baidu.wallet.base.widget.dialog.PromptMultiBtnDialog;
import com.baidu.wallet.base.widget.dialog.PromptTipDialog;
import com.baidu.wallet.core.beans.BeanErrorContent;
import com.baidu.wallet.core.utils.NFCUtil;
import com.baidu.wallet.core.utils.WalletGlobalUtils;
import com.baidu.wallet.paysdk.PayCallBackManager;
import com.baidu.wallet.paysdk.b.g;
import com.baidu.wallet.paysdk.b.j;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.beans.h;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse;
import com.baidu.wallet.paysdk.datamodel.ErrorContentResponse;
import com.baidu.wallet.paysdk.datamodel.GetCardInfoResponse;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.statistics.api.StatisticManager;
import java.io.Serializable;
/* loaded from: classes5.dex */
public abstract class BindCardBaseActivity extends PayBaseActivity implements View.OnClickListener, View.OnFocusChangeListener, SafeKeyBoardEditText.OnMyFocusChangeListener {
    public static final String BEAN_TAG = "BindCardBaseActivity";

    /* renamed from: a  reason: collision with root package name */
    public PayRequestCache.BindCategory f25903a;

    /* renamed from: b  reason: collision with root package name */
    public LayoutInflater f25904b;
    public BdActionBar bdActionBar;
    public h checkCardInfoBean;
    public boolean isAutoFillPhone;
    public j mBindCardController;
    public ErrorContentResponse mCardInfoUpdateContent;
    public ViewGroup mContentLayout;
    public ViewGroup mRootView;
    public SafeScrollView mScrollView;
    public int mUpdateItemCount = 0;
    public int mBindReason = 0;
    public BindFastRequest mBindReq = null;
    public PayRequest mPayReq = null;
    public final int DIALOG_CAN_AMOUNT_NO_PWD = 629128;

    /* renamed from: c  reason: collision with root package name */
    public final int f25905c = 629129;
    public final int DIALOG_ABANDON_AUTHORIZE = 629130;
    public boolean isFromRestore = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f25906e = false;

    /* renamed from: f  reason: collision with root package name */
    public int f25907f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f25908g = 0;

    private void a() {
        this.bdActionBar.measure(0, View.MeasureSpec.makeMeasureSpec(0, 0));
        ViewHelper.setAlpha(this.bdActionBar, 0.0f);
    }

    private void b() {
        GlobalUtils.hideKeyboard(getActivity());
        PayCallBackManager.callBackClientCancel(this, "BindCardBaseActivitycallBackClientCancel().1");
    }

    public void addContentView(int i) {
        if (this.f25904b == null) {
            this.f25904b = LayoutInflater.from(getActivity());
        }
        a(this.f25904b.inflate(i, (ViewGroup) null));
    }

    @Override // com.baidu.wallet.core.BaseActivity
    public void cancleRequest() {
        j jVar = this.mBindCardController;
        if (jVar != null) {
            jVar.f();
        }
        super.cancleRequest();
    }

    public void changeCurrentStepInfo(String str, int i) {
        initActionBarWithActualTitleValue(str);
        this.f25907f = i;
    }

    public String formatCardNo(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < str.length()) {
            int i2 = i + 4;
            if (i2 < str.length()) {
                sb.append(str.substring(i, i2));
                sb.append(" ");
            } else {
                sb.append(str.substring(i, str.length()));
            }
            i = i2;
        }
        return sb.toString();
    }

    public int getBindCardCause() {
        return this.mBindReason;
    }

    public PayRequestCache.BindCategory getCategory() {
        return this.f25903a;
    }

    public int getCurrentStep() {
        return this.f25907f;
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.core.beans.BeanActivity
    public void handleFailure(int i, int i2, String str) {
        PayRequest payRequest = this.mPayReq;
        if (payRequest != null) {
            payRequest.clearMktSolution();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.core.beans.BeanActivity
    public void handleResponse(int i, Object obj, String str) {
        super.handleResponse(i, obj, str);
    }

    public void initSafeKeyBoard() {
    }

    public boolean isBindInvalid() {
        BindFastRequest bindFastRequest = this.mBindReq;
        if (bindFastRequest == null) {
            b();
            return true;
        } else if (bindFastRequest.isRealPay() && this.mPayReq == null) {
            b();
            return true;
        } else {
            return false;
        }
    }

    public boolean isShowWithHalfScreeen() {
        int i = this.mUpdateItemCount;
        return 1 == i || 2 == i;
    }

    @Override // com.baidu.wallet.core.BaseActivity
    public boolean isWindowNightMode() {
        return false;
    }

    public void loadCvv2() {
        WalletGlobalUtils.safeDismissDialog(this, 34);
        this.mBindCardController.r();
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.beans.BeanActivity
    public void onBeanExecFailureWithErrContent(int i, int i2, String str, Object obj) {
        if (i2 != 80320 && i2 != 80321 && i2 != 80326 && i2 != 80327) {
            if (obj instanceof ErrorContentResponse) {
                if (this.mBindReq.getmBindFrom() == 2 || this.mBindReq.getmBindFrom() == 9) {
                    ErrorContentResponse errorContentResponse = (ErrorContentResponse) obj;
                    if (errorContentResponse.card_item_required != null) {
                        this.mCardInfoUpdateContent = errorContentResponse;
                        this.mDialogMsg = str;
                        WalletGlobalUtils.safeDismissDialog(this, 0);
                        WalletGlobalUtils.safeDismissDialog(this, -2);
                        WalletGlobalUtils.safeShowDialog(this, 40, "");
                        return;
                    }
                }
                if (i2 == 15500 && (this.mBindReq.getmBindFrom() == 2 || this.mBindReq.getmBindFrom() == 7 || this.mBindReq.getmBindFrom() == 9)) {
                    this.f25906e = i == 13;
                    this.mCardInfoUpdateContent = (ErrorContentResponse) obj;
                    this.mDialogMsg = str;
                    this.mPayErrorCode = i2;
                    this.mBeanId = i;
                    WalletGlobalUtils.safeDismissDialog(this, 0);
                    WalletGlobalUtils.safeDismissDialog(this, -2);
                    WalletGlobalUtils.safeShowDialog(this, 34, "");
                    return;
                }
                super.onBeanExecFailureWithErrContent(i, i2, str, obj);
                return;
            }
            super.onBeanExecFailureWithErrContent(i, i2, str, obj);
            return;
        }
        WalletGlobalUtils.safeDismissDialog(this, 0);
        WalletGlobalUtils.safeDismissDialog(this, -2);
        if (obj instanceof ErrorContentResponse) {
            this.mCardInfoUpdateContent = (ErrorContentResponse) obj;
            PayDataCache.getInstance().cleanDetainmentDesc();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.mDialogMsg = str;
            this.mPayErrorCode = i2;
            this.mBeanId = i;
            if (this.mBindCardController instanceof g) {
                WalletGlobalUtils.safeShowDialog(this, 629129, "");
            } else {
                WalletGlobalUtils.safeShowDialog(this, 35, "");
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == ResUtils.id(getActivity(), "date_tip_img")) {
            this.f25908g = 1;
            this.mDialogMsg = ResUtils.getString(getActivity(), "ebpay_date_tip");
            PayStatisticsUtil.onEvent(StatServiceEvent.CLICK_HELP_DATE);
            WalletGlobalUtils.safeShowDialog(this, 2, "");
        } else if (id == ResUtils.id(getActivity(), "cvv_tip_img")) {
            this.f25908g = 0;
            this.mDialogMsg = ResUtils.getString(getActivity(), "ebpay_cvv2_tip");
            PayStatisticsUtil.onEvent(StatServiceEvent.CLICK_HELP_CVV);
            WalletGlobalUtils.safeShowDialog(this, 2, "");
        } else if (id == ResUtils.id(getActivity(), "phone_tip_img")) {
            this.mDialogMsg = ResUtils.getString(getActivity(), "ebpay_mobile_tip");
            PayStatisticsUtil.onEvent(StatServiceEvent.CLICK_HELP_PHONE);
            WalletGlobalUtils.safeShowDialog(this, 13, "");
        } else if (id == ResUtils.id(getActivity(), "name_tip_img") || id == ResUtils.id(getActivity(), "card_name_tip_img")) {
            this.mDialogMsg = ResUtils.getString(getActivity(), "ebpay_name_tip");
            PayStatisticsUtil.onEvent(StatServiceEvent.CLICK_HELP_NAME);
            WalletGlobalUtils.safeShowDialog(this, 14, "");
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setFlagPaySdk();
        setIsShowMultiWindowTips(true);
        if (bundle == null) {
            this.mPayReq = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
            this.f25903a = PayRequestCache.getInstance().getBindCategoryByIntent(getIntent());
            this.mBindReq = (BindFastRequest) PayRequestCache.getInstance().getRequest(this.f25903a);
            PayDataCache.getInstance().setCurrentPayRequest(this.f25903a);
            a(getIntent());
            this.isFromRestore = false;
        } else {
            this.isFromRestore = true;
            a(bundle);
        }
        if (this.mBindReq == null) {
            BindFastRequest bindFastRequest = new BindFastRequest();
            this.mBindReq = bindFastRequest;
            bindFastRequest.mBindFrom = 0;
            PayRequestCache.getInstance().addBeanRequestToCache(this.mBindReq.getRequestId(), this.mBindReq);
        }
        j a2 = com.baidu.wallet.paysdk.b.c.a(this.mBindReq.mBindFrom);
        this.mBindCardController = a2;
        a2.a(this);
        this.mBindCardController.a(this.mBindReq);
        a(isShowWithHalfScreeen());
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, android.app.Activity
    public Dialog onCreateDialog(int i) {
        if (i != 2) {
            if (i != 14) {
                if (i != 40) {
                    if (i != 629129) {
                        if (i != 34) {
                            if (i != 35) {
                                return super.onCreateDialog(i);
                            }
                            return new PromptMultiBtnDialog(getActivity());
                        }
                        return new PromptDialog(getActivity());
                    }
                    return new PromptDialog(getActivity());
                }
                return new PromptDialog(getActivity());
            }
            return new PromptTipDialog(getActivity());
        }
        return new PromptImageDialog(getActivity());
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity
    public void onModuleEvent(EventBus.Event event) {
        if (event == null || !"ev_bean_execut_err_content".equals(event.mEventKey)) {
            return;
        }
        Object obj = event.mEventObj;
        if (obj instanceof BeanErrorContent) {
            BeanErrorContent beanErrorContent = (BeanErrorContent) obj;
            onBeanExecFailureWithErrContent(beanErrorContent.getBeanId(), beanErrorContent.getRet(), beanErrorContent.getMsg(), beanErrorContent.getErrContent());
            EventBus.getInstance().removeStickyEvent("ev_bean_execut_err_content");
        }
    }

    @Override // com.baidu.wallet.base.widget.SafeKeyBoardEditText.OnMyFocusChangeListener
    public void onMyFocusChange(View view, boolean z) {
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.f25903a = PayRequestCache.getInstance().getBindCategoryByIntent(getIntent());
        this.mBindReq = (BindFastRequest) PayRequestCache.getInstance().getRequest(this.f25903a);
        PayDataCache.getInstance().setCurrentPayRequest(this.f25903a);
        if (this.mBindReq == null) {
            BindFastRequest bindFastRequest = new BindFastRequest();
            this.mBindReq = bindFastRequest;
            bindFastRequest.mBindFrom = 0;
            PayRequestCache.getInstance().addBeanRequestToCache(this.mBindReq.getRequestId(), this.mBindReq);
        }
        j a2 = com.baidu.wallet.paysdk.b.c.a(this.mBindReq.mBindFrom);
        this.mBindCardController = a2;
        a2.a(this);
        this.mBindCardController.a(this.mBindReq);
        boolean z = this.mRootView instanceof LinearLayout;
        a(intent);
        if (z != isShowWithHalfScreeen()) {
            a(isShowWithHalfScreeen());
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        EventBus.getInstance().unregister(this, "ev_bean_execut_err_content");
        if (Build.VERSION.SDK_INT >= 10) {
            NFCUtil.getInstance().disableForegroundDispatch(getActivity(), false);
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, android.app.Activity
    public void onPrepareDialog(int i, Dialog dialog) {
        if (i == 2) {
            PromptImageDialog promptImageDialog = (PromptImageDialog) dialog;
            promptImageDialog.setMessage(this.mDialogMsg);
            if (this.f25908g == 0) {
                promptImageDialog.setTitleMessage(ResUtils.getString(getActivity(), "ebpay_cvv2_tip_title"));
                promptImageDialog.setImage(ResUtils.drawable(getActivity(), "wallet_base_help_cvv"));
                return;
            }
            promptImageDialog.setTitleMessage(ResUtils.getString(getActivity(), "ebpay_date_tip_title"));
            promptImageDialog.setImage(ResUtils.drawable(getActivity(), "wallet_base_help_date"));
        } else if (i == 3) {
            PromptDialog promptDialog = (PromptDialog) dialog;
            promptDialog.setMessage(this.mDialogMsg);
            promptDialog.setCanceledOnTouchOutside(false);
            promptDialog.hideNegativeButton();
            promptDialog.setPositiveBtn(ResUtils.string(getActivity(), "ebpay_confirm"), new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.BindCardBaseActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WalletGlobalUtils.safeDismissDialog(BindCardBaseActivity.this, 3);
                }
            });
        } else if (i == 13) {
            PromptTipDialog promptTipDialog = (PromptTipDialog) dialog;
            promptTipDialog.setMessage(ResUtils.getString(getActivity(), "ebpay_mobile_tip"));
            promptTipDialog.setTitleMessage(ResUtils.getString(getActivity(), "ebpay_bank_phone"));
        } else if (i == 14) {
            PromptTipDialog promptTipDialog2 = (PromptTipDialog) dialog;
            promptTipDialog2.setMessage(this.mDialogMsg);
            promptTipDialog2.setTitleMessage(ResUtils.getString(getActivity(), "ebpay_name_title"));
        } else if (i == 34) {
            StatisticManager.onEvent(StatServiceEvent.EVENT_SHOW_CARD_UPDATE);
            PromptDialog promptDialog2 = (PromptDialog) dialog;
            promptDialog2.setMessage(this.mDialogMsg);
            promptDialog2.showCloseBtn(false);
            promptDialog2.setCanceledOnTouchOutside(false);
            promptDialog2.setNegativeBtn(ResUtils.getString(getActivity(), "ebpay_cancel"), new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.BindCardBaseActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    BindCardBaseActivity bindCardBaseActivity = BindCardBaseActivity.this;
                    bindCardBaseActivity.addDoPayorCheckCardStatistics(ResUtils.getString(bindCardBaseActivity.getActivity(), "ebpay_cancel"));
                    WalletGlobalUtils.safeDismissDialog(BindCardBaseActivity.this, 34);
                }
            });
            if (this.f25906e) {
                promptDialog2.hideNegativeButton();
            }
            promptDialog2.setPositiveBtn(ResUtils.string(this, "ebpay_wallet_continue_pay"), new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.BindCardBaseActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    BindCardBaseActivity bindCardBaseActivity = BindCardBaseActivity.this;
                    bindCardBaseActivity.addDoPayorCheckCardStatistics(ResUtils.getString(bindCardBaseActivity.getActivity(), "ebpay_wallet_continue_pay"));
                    PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_CLICK_CONTINUE_PAY_IN_CARD_UPDATE);
                    WalletGlobalUtils.safeDismissDialog(BindCardBaseActivity.this, 34);
                    PayController payController = PayController.getInstance();
                    BindCardBaseActivity bindCardBaseActivity2 = BindCardBaseActivity.this;
                    payController.updateCardInfoPay(bindCardBaseActivity2, bindCardBaseActivity2.mCardInfoUpdateContent);
                }
            });
        } else if (i == 35) {
            StatisticManager.onEvent(StatServiceEvent.EVENT_SHOW_ORIGN_PRICE_ALERT);
            PromptMultiBtnDialog promptMultiBtnDialog = (PromptMultiBtnDialog) dialog;
            promptMultiBtnDialog.setMessage(this.mDialogMsg);
            promptMultiBtnDialog.setFirstBtn(ResUtils.getString(this, "bd_wallet_pay_by_order_price"), new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.BindCardBaseActivity.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_CLICK_ORIGN_PRICE_PAY);
                    BindCardBaseActivity bindCardBaseActivity = BindCardBaseActivity.this;
                    bindCardBaseActivity.addDoPayorCheckCardStatistics(ResUtils.getString(bindCardBaseActivity.getActivity(), "bd_wallet_pay_by_order_price"));
                    ErrorContentResponse errorContentResponse = BindCardBaseActivity.this.mCardInfoUpdateContent;
                    if (errorContentResponse == null || errorContentResponse.mkt_solution == null) {
                        return;
                    }
                    ((PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY)).setMktSolution(BindCardBaseActivity.this.mCardInfoUpdateContent.mkt_solution);
                    if (BindCardBaseActivity.this.mBindReq.getmBindFrom() == 9) {
                        BindCardBaseActivity.this.mBindCardController.c(new String[0]);
                    } else {
                        BindCardBaseActivity bindCardBaseActivity2 = BindCardBaseActivity.this;
                        if (bindCardBaseActivity2.checkCardInfoBean == null) {
                            bindCardBaseActivity2.checkCardInfoBean = (h) PayBeanFactory.getInstance().getBean((Context) BindCardBaseActivity.this.getActivity(), 5, BindCardBaseActivity.BEAN_TAG);
                        }
                        BindCardBaseActivity bindCardBaseActivity3 = BindCardBaseActivity.this;
                        bindCardBaseActivity3.checkCardInfoBean.a(bindCardBaseActivity3.mBindReq);
                        BindCardBaseActivity bindCardBaseActivity4 = BindCardBaseActivity.this;
                        bindCardBaseActivity4.checkCardInfoBean.setResponseCallback(bindCardBaseActivity4);
                        BindCardBaseActivity.this.checkCardInfoBean.execBean();
                    }
                    WalletGlobalUtils.safeShowDialog(BindCardBaseActivity.this, -2, "");
                    WalletGlobalUtils.safeDismissDialog(BindCardBaseActivity.this, 35);
                }
            });
            promptMultiBtnDialog.setSecondBtn(ResUtils.getString(this, "bd_wallet_modify_card_no"), new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.BindCardBaseActivity.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    BindCardBaseActivity bindCardBaseActivity = BindCardBaseActivity.this;
                    bindCardBaseActivity.addDoPayorCheckCardStatistics(ResUtils.getString(bindCardBaseActivity.getActivity(), "bd_wallet_modify_card_no"));
                    WalletGlobalUtils.safeDismissDialog(BindCardBaseActivity.this, 35);
                    BindCardBaseActivity.this.updateChangeCard();
                }
            });
            promptMultiBtnDialog.setThirdBtn(ResUtils.getString(this, "ebpay_cancel"), new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.BindCardBaseActivity.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    BindCardBaseActivity bindCardBaseActivity = BindCardBaseActivity.this;
                    bindCardBaseActivity.addDoPayorCheckCardStatistics(ResUtils.getString(bindCardBaseActivity.getActivity(), "ebpay_cancel"));
                    WalletGlobalUtils.safeDismissDialog(BindCardBaseActivity.this, 35);
                }
            });
        } else if (i == 40) {
            final PromptDialog promptDialog3 = (PromptDialog) dialog;
            promptDialog3.setMessage(this.mDialogMsg);
            promptDialog3.hideNegativeButton();
            promptDialog3.setPositiveBtn(ResUtils.string(this, "ebpay_know"), new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.BindCardBaseActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PayController payController = PayController.getInstance();
                    BindCardBaseActivity bindCardBaseActivity = BindCardBaseActivity.this;
                    payController.updateCardInfoPay(bindCardBaseActivity, bindCardBaseActivity.mCardInfoUpdateContent);
                    promptDialog3.dismiss();
                }
            });
        } else if (i != 629129) {
            super.onPrepareDialog(i, dialog);
        } else {
            StatisticManager.onEvent(StatServiceEvent.EVENT_SHOW_ORIGN_PRICE_ALERT);
            PromptDialog promptDialog4 = (PromptDialog) dialog;
            promptDialog4.setMessage(this.mDialogMsg);
            promptDialog4.showCloseBtn(false);
            promptDialog4.setCanceledOnTouchOutside(false);
            promptDialog4.setNegativeBtn(ResUtils.getString(getActivity(), "ebpay_cancel"), new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.BindCardBaseActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    BindCardBaseActivity bindCardBaseActivity = BindCardBaseActivity.this;
                    bindCardBaseActivity.addDoPayorCheckCardStatistics(ResUtils.getString(bindCardBaseActivity.getActivity(), "ebpay_cancel"));
                    WalletGlobalUtils.safeDismissDialog(BindCardBaseActivity.this, 629129);
                }
            });
            promptDialog4.setPositiveBtn(ResUtils.string(this, "bd_wallet_pay_by_order_price"), new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.BindCardBaseActivity.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_CLICK_ORIGN_PRICE_PAY);
                    BindCardBaseActivity bindCardBaseActivity = BindCardBaseActivity.this;
                    bindCardBaseActivity.addDoPayorCheckCardStatistics(ResUtils.getString(bindCardBaseActivity.getActivity(), "bd_wallet_pay_by_order_price"));
                    ErrorContentResponse errorContentResponse = BindCardBaseActivity.this.mCardInfoUpdateContent;
                    if (errorContentResponse == null || errorContentResponse.mkt_solution == null) {
                        return;
                    }
                    ((PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY)).setMktSolution(BindCardBaseActivity.this.mCardInfoUpdateContent.mkt_solution);
                    if (BindCardBaseActivity.this.mBindReq.getmBindFrom() == 9) {
                        BindCardBaseActivity.this.mBindCardController.c(new String[0]);
                    } else {
                        BindCardBaseActivity bindCardBaseActivity2 = BindCardBaseActivity.this;
                        if (bindCardBaseActivity2.checkCardInfoBean == null) {
                            bindCardBaseActivity2.checkCardInfoBean = (h) PayBeanFactory.getInstance().getBean((Context) BindCardBaseActivity.this.getActivity(), 5, BindCardBaseActivity.BEAN_TAG);
                        }
                        BindCardBaseActivity bindCardBaseActivity3 = BindCardBaseActivity.this;
                        bindCardBaseActivity3.checkCardInfoBean.a(bindCardBaseActivity3.mBindReq);
                        BindCardBaseActivity bindCardBaseActivity4 = BindCardBaseActivity.this;
                        bindCardBaseActivity4.checkCardInfoBean.setResponseCallback(bindCardBaseActivity4);
                        BindCardBaseActivity.this.checkCardInfoBean.execBean();
                    }
                    WalletGlobalUtils.safeShowDialog(BindCardBaseActivity.this, -2, "");
                    WalletGlobalUtils.safeDismissDialog(BindCardBaseActivity.this, 629129);
                }
            });
        }
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        a(bundle);
        super.onRestoreInstanceState(bundle);
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        EventBus.getInstance().register(this, "ev_bean_execut_err_content", 0, EventBus.ThreadMode.MainThread);
        if (Build.VERSION.SDK_INT >= 10) {
            NFCUtil.getInstance().enableForegroundDispatch(getActivity(), false);
        }
        if (this.isFromRestore) {
            this.isFromRestore = false;
            WalletGlobalUtils.safeDismissDialog(this.mAct, 14);
            WalletGlobalUtils.safeDismissDialog(this.mAct, 13);
            WalletGlobalUtils.safeDismissDialog(this.mAct, 3);
            WalletGlobalUtils.safeDismissDialog(this.mAct, 2);
            WalletGlobalUtils.safeDismissDialog(this.mAct, 34);
            WalletGlobalUtils.safeDismissDialog(this.mAct, 35);
            WalletGlobalUtils.safeDismissDialog(this.mAct, 629129);
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        if (!TextUtils.isEmpty(this.mDialogMsg)) {
            bundle.putString("dialogMsg", this.mDialogMsg);
        }
        BindFastRequest bindFastRequest = this.mBindReq;
        if (bindFastRequest != null) {
            bundle.putSerializable("deliver_bind_request", bindFastRequest);
        }
        PayRequest payRequest = this.mPayReq;
        if (payRequest != null) {
            bundle.putSerializable("deliver_pay_request", payRequest);
        }
        ErrorContentResponse errorContentResponse = this.mCardInfoUpdateContent;
        if (errorContentResponse != null) {
            bundle.putSerializable("mCardInfoUpdateContent", errorContentResponse);
        }
        bundle.putSerializable("PayResponse", PayDataCache.getInstance().getPayResponse());
        bundle.putBoolean("isautofillphone", this.isAutoFillPhone);
        bundle.putInt("currentStep", this.f25907f);
        bundle.putInt("halfScreen", this.mUpdateItemCount);
        bundle.putInt("reasonForChangeCardItem", this.mBindReason);
        super.onSaveInstanceState(bundle);
    }

    public void startActivityForBind(Class<?> cls) {
        startActivity(new Intent(getActivity(), cls));
    }

    public void stastics(String str) {
        BindFastRequest bindFastRequest = this.mBindReq;
        if (bindFastRequest == null) {
            return;
        }
        int i = bindFastRequest.getmBindFrom();
        if (i == 0) {
            PayStatisticsUtil.onEventWithValue(str, "pay");
        } else if (i == 1) {
            PayStatisticsUtil.onEventWithValue(str, "bind");
        } else if (i == 2) {
            PayStatisticsUtil.onEventWithValue(str, "completion");
        } else if (i == 3) {
            PayStatisticsUtil.onEventWithValue(str, "foggetPwd");
        } else if (i != 5) {
            b();
        } else {
            PayStatisticsUtil.onEventWithValue(str, "only_completion");
        }
    }

    public abstract void updateBankCouponDesc(CharSequence charSequence);

    public abstract void updateBankTitleInfo(GetCardInfoResponse.CardInfo cardInfo, boolean z);

    public abstract void updateCardElement(boolean z, boolean z2, boolean z3, boolean z4, boolean z5);

    public abstract void updateChangeCard();

    public abstract void updateCvv2Info(boolean z, boolean z2, boolean z3);

    public void updateDiscountTitle(String str) {
    }

    public abstract void updateDiscountTxt(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, CharSequence charSequence5);

    public abstract void updateProtocolFields(GetCardInfoResponse.ProtocolInfo protocolInfo);

    private void a(Bundle bundle) {
        Serializable serializable;
        Serializable serializable2;
        if (bundle != null) {
            this.mDialogMsg = bundle.getString("dialogMsg");
            if (this.mPayReq == null && (serializable2 = bundle.getSerializable("deliver_pay_request")) != null && (serializable2 instanceof PayRequest)) {
                this.mPayReq = (PayRequest) serializable2;
                PayRequestCache.getInstance().addBeanRequestToCache(this.mPayReq.getRequestId(), this.mPayReq);
            }
            if (this.mBindReq == null && (serializable = bundle.getSerializable("deliver_bind_request")) != null && (serializable instanceof BindFastRequest)) {
                this.mBindReq = (BindFastRequest) serializable;
                PayRequestCache.getInstance().addBeanRequestToCache(this.mBindReq.getRequestId(), this.mBindReq);
            }
            Serializable serializable3 = bundle.getSerializable("PayResponse");
            if (serializable3 != null && (serializable3 instanceof DirectPayContentResponse)) {
                ((DirectPayContentResponse) serializable3).storeResponse(getActivity());
            }
            Serializable serializable4 = bundle.getSerializable("mCardInfoUpdateContent");
            if (serializable4 != null && (serializable4 instanceof ErrorContentResponse)) {
                this.mCardInfoUpdateContent = (ErrorContentResponse) serializable4;
            }
            this.isAutoFillPhone = bundle.getBoolean("isautofillphone");
            this.f25907f = bundle.getInt("currentStep");
            this.mUpdateItemCount = bundle.getInt("halfScreen", 0);
            this.mBindReason = bundle.getInt("reasonForChangeCardItem", 0);
        }
    }

    public void a(Bundle bundle, Class<?> cls, boolean z) {
        if (bundle == null && getIntent().getExtras() != null) {
            bundle = getIntent().getExtras();
        } else if (bundle == null) {
            bundle = new Bundle();
        }
        Intent intent = new Intent(getActivity(), cls);
        intent.putExtras(bundle);
        if (z) {
            startActivity(intent);
        } else {
            startActivityWithoutAnim(intent);
        }
    }

    private void a(View view) {
        this.mContentLayout.setVisibility(0);
        if (this.mContentLayout.getChildCount() > 0) {
            this.mContentLayout.removeAllViews();
        }
        this.mContentLayout.addView(view);
    }

    private void a(Intent intent) {
        if (intent == null) {
            this.mUpdateItemCount = 0;
            this.mBindReason = 0;
            return;
        }
        this.mUpdateItemCount = intent.getIntExtra("halfScreen", 0);
        this.mBindReason = intent.getIntExtra("reasonForChangeCardItem", 0);
    }

    private void a(boolean z) {
        ViewGroup viewGroup = this.mRootView;
        if (viewGroup != null) {
            ((ViewGroup) viewGroup.getParent()).removeView(this.mRootView);
        }
        setContentView(ResUtils.layout(getActivity(), z ? "wallet_cashdesk_bind_base_half_screen" : "wallet_cashdesk_bind_base_activity"));
        this.mRootView = (ViewGroup) findViewById(ResUtils.id(getActivity(), "root_view"));
        this.mScrollView = (SafeScrollView) findViewById(ResUtils.id(getActivity(), "scrollview"));
        this.bdActionBar = (BdActionBar) findViewById(ResUtils.id(getActivity(), "bdactionbar"));
        this.mContentLayout = (ViewGroup) findViewById(ResUtils.id(getActivity(), "content_layout"));
        if (2 == this.mUpdateItemCount) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mScrollView.getLayoutParams();
            layoutParams.height += DisplayUtils.dip2px(this.mAct, 68.0f);
            this.mScrollView.setLayoutParams(layoutParams);
        }
        if (isShowWithHalfScreeen()) {
            TextView textView = (TextView) findViewById(ResUtils.id(getActivity(), "ebpay_halfscreen_action_bar")).findViewById(ResUtils.id(getActivity(), "bd_wallet_bind_card_title"));
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) textView.getLayoutParams();
            int dimension = (int) ResUtils.getDimension(this.mAct, "bd_wallet_bindcard_margin");
            layoutParams2.rightMargin = dimension;
            layoutParams2.leftMargin = dimension;
            textView.setLayoutParams(layoutParams2);
            textView.setText(ResUtils.getString(getActivity(), "ebpay_title_complete_info"));
        }
        if (!this.mBindCardController.C()) {
            a();
        } else if (isShowWithHalfScreeen()) {
        } else {
            ((RelativeLayout.LayoutParams) this.mScrollView.getLayoutParams()).addRule(3, this.bdActionBar.getId());
            this.mScrollView.requestLayout();
        }
    }
}
