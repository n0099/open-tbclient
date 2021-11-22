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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.controllers.PayController;
import com.baidu.wallet.paysdk.PayCallBackManager;
import com.baidu.wallet.paysdk.b.j;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.beans.g;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse;
import com.baidu.wallet.paysdk.datamodel.ErrorContentResponse;
import com.baidu.wallet.paysdk.datamodel.GetCardInfoResponse;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.dxmpay.apollon.eventbus.EventBus;
import com.dxmpay.apollon.utils.DisplayUtils;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.apollon.utils.support.ViewHelper;
import com.dxmpay.wallet.base.widget.BdActionBar;
import com.dxmpay.wallet.base.widget.SafeKeyBoardEditText;
import com.dxmpay.wallet.base.widget.SafeScrollView;
import com.dxmpay.wallet.base.widget.dialog.PromptDialog;
import com.dxmpay.wallet.base.widget.dialog.PromptImageDialog;
import com.dxmpay.wallet.base.widget.dialog.PromptMultiBtnDialog;
import com.dxmpay.wallet.base.widget.dialog.PromptTipDialog;
import com.dxmpay.wallet.core.beans.BeanErrorContent;
import com.dxmpay.wallet.core.utils.NFCUtil;
import com.dxmpay.wallet.core.utils.WalletGlobalUtils;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import java.io.Serializable;
/* loaded from: classes10.dex */
public abstract class BindCardBaseActivity extends PayBaseActivity implements View.OnClickListener, View.OnFocusChangeListener, SafeKeyBoardEditText.OnMyFocusChangeListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String BEAN_TAG = "BindCardBaseActivity";
    public transient /* synthetic */ FieldHolder $fh;
    public final int DIALOG_ABANDON_AUTHORIZE;
    public final int DIALOG_CAN_AMOUNT_NO_PWD;

    /* renamed from: a  reason: collision with root package name */
    public PayRequestCache.BindCategory f60939a;

    /* renamed from: b  reason: collision with root package name */
    public LayoutInflater f60940b;
    public BdActionBar bdActionBar;

    /* renamed from: c  reason: collision with root package name */
    public final int f60941c;
    public g checkCardInfoBean;

    /* renamed from: d  reason: collision with root package name */
    public boolean f60942d;

    /* renamed from: e  reason: collision with root package name */
    public int f60943e;

    /* renamed from: f  reason: collision with root package name */
    public int f60944f;
    public boolean isAutoFillPhone;
    public boolean isFromRestore;
    public j mBindCardController;
    public int mBindReason;
    public BindFastRequest mBindReq;
    public ErrorContentResponse mCardInfoUpdateContent;
    public ViewGroup mContentLayout;
    public PayRequest mPayReq;
    public ViewGroup mRootView;
    public SafeScrollView mScrollView;
    public int mUpdateItemCount;

    public BindCardBaseActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mUpdateItemCount = 0;
        this.mBindReason = 0;
        this.mBindReq = null;
        this.mPayReq = null;
        this.DIALOG_CAN_AMOUNT_NO_PWD = 629128;
        this.f60941c = 629129;
        this.DIALOG_ABANDON_AUTHORIZE = 629130;
        this.isFromRestore = false;
        this.f60942d = false;
        this.f60943e = 0;
        this.f60944f = 0;
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            this.bdActionBar.measure(0, View.MeasureSpec.makeMeasureSpec(0, 0));
            ViewHelper.setAlpha(this.bdActionBar, 0.0f);
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            GlobalUtils.hideKeyboard(getActivity());
            PayCallBackManager.callBackClientCancel(this, "BindCardBaseActivitycallBackClientCancel().1");
        }
    }

    public void addContentView(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            if (this.f60940b == null) {
                this.f60940b = LayoutInflater.from(getActivity());
            }
            a(this.f60940b.inflate(i2, (ViewGroup) null));
        }
    }

    @Override // com.dxmpay.wallet.core.BaseActivity
    public void cancleRequest() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            j jVar = this.mBindCardController;
            if (jVar != null) {
                jVar.f();
            }
            super.cancleRequest();
        }
    }

    public void changeCurrentStepInfo(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, str, i2) == null) {
            initActionBarWithActualTitleValue(str);
            this.f60943e = i2;
        }
    }

    public String formatCardNo(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            int i2 = 0;
            while (i2 < str.length()) {
                int i3 = i2 + 4;
                if (i3 < str.length()) {
                    sb.append(str.substring(i2, i3));
                    sb.append(" ");
                } else {
                    sb.append(str.substring(i2, str.length()));
                }
                i2 = i3;
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public int getBindCardCause() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mBindReason : invokeV.intValue;
    }

    public PayRequestCache.BindCategory getCategory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f60939a : (PayRequestCache.BindCategory) invokeV.objValue;
    }

    public int getCurrentStep() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f60943e : invokeV.intValue;
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.dxmpay.wallet.core.beans.BeanActivity
    public void handleFailure(int i2, int i3, String str) {
        PayRequest payRequest;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3, str) == null) || (payRequest = this.mPayReq) == null) {
            return;
        }
        payRequest.clearMktSolution();
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.dxmpay.wallet.core.beans.BeanActivity
    public void handleResponse(int i2, Object obj, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048585, this, i2, obj, str) == null) {
            super.handleResponse(i2, obj, str);
        }
    }

    public void initSafeKeyBoard() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
        }
    }

    public boolean isBindInvalid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
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
        return invokeV.booleanValue;
    }

    public boolean isShowWithHalfScreeen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            int i2 = this.mUpdateItemCount;
            return 1 == i2 || 2 == i2;
        }
        return invokeV.booleanValue;
    }

    @Override // com.dxmpay.wallet.core.BaseActivity
    public boolean isWindowNightMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void loadCvv2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            WalletGlobalUtils.safeDismissDialog(this, 34);
            this.mBindCardController.r();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.beans.BeanActivity
    public void onBeanExecFailureWithErrContent(int i2, int i3, String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, obj}) == null) {
            if (i3 != 80320 && i3 != 80321 && i3 != 80326 && i3 != 80327) {
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
                    if (i3 == 15500 && (this.mBindReq.getmBindFrom() == 2 || this.mBindReq.getmBindFrom() == 7 || this.mBindReq.getmBindFrom() == 9)) {
                        this.f60942d = i2 == 13;
                        this.mCardInfoUpdateContent = (ErrorContentResponse) obj;
                        this.mDialogMsg = str;
                        this.mPayErrorCode = i3;
                        this.mBeanId = i2;
                        WalletGlobalUtils.safeDismissDialog(this, 0);
                        WalletGlobalUtils.safeDismissDialog(this, -2);
                        WalletGlobalUtils.safeShowDialog(this, 34, "");
                        return;
                    }
                    super.onBeanExecFailureWithErrContent(i2, i3, str, obj);
                    return;
                }
                super.onBeanExecFailureWithErrContent(i2, i3, str, obj);
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
                this.mPayErrorCode = i3;
                this.mBeanId = i2;
                if (this.mBindCardController instanceof com.baidu.wallet.paysdk.b.g) {
                    WalletGlobalUtils.safeShowDialog(this, 629129, "");
                } else {
                    WalletGlobalUtils.safeShowDialog(this, 35, "");
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, view) == null) {
            int id = view.getId();
            if (id == ResUtils.id(getActivity(), "date_tip_img")) {
                this.f60944f = 1;
                this.mDialogMsg = ResUtils.getString(getActivity(), "ebpay_date_tip");
                StatisticManager.onEvent("clickHelpDate");
                WalletGlobalUtils.safeShowDialog(this, 2, "");
            } else if (id == ResUtils.id(getActivity(), "cvv_tip_img")) {
                this.f60944f = 0;
                this.mDialogMsg = ResUtils.getString(getActivity(), "ebpay_cvv2_tip");
                StatisticManager.onEvent("clickHelpCVV");
                WalletGlobalUtils.safeShowDialog(this, 2, "");
            } else if (id == ResUtils.id(getActivity(), "phone_tip_img")) {
                this.mDialogMsg = ResUtils.getString(getActivity(), "ebpay_mobile_tip");
                StatisticManager.onEvent("clickHelpPhone");
                WalletGlobalUtils.safeShowDialog(this, 13, "");
            } else if (id == ResUtils.id(getActivity(), "name_tip_img") || id == ResUtils.id(getActivity(), "card_name_tip_img")) {
                this.mDialogMsg = ResUtils.getString(getActivity(), "ebpay_name_tip");
                StatisticManager.onEvent("clickHelpName");
                WalletGlobalUtils.safeShowDialog(this, 14, "");
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.beans.BeanActivity, com.dxmpay.wallet.core.BaseActivity, com.dxmpay.wallet.core.SDKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bundle) == null) {
            super.onCreate(bundle);
            setFlagPaySdk();
            setIsShowMultiWindowTips(true);
            if (bundle == null) {
                this.mPayReq = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
                this.f60939a = PayRequestCache.getInstance().getBindCategoryByIntent(getIntent());
                this.mBindReq = (BindFastRequest) PayRequestCache.getInstance().getRequest(this.f60939a);
                PayDataCache.getInstance().setCurrentPayRequest(this.f60939a);
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
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.BaseActivity, android.app.Activity
    public Dialog onCreateDialog(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i2)) == null) {
            if (i2 != 2) {
                if (i2 != 14) {
                    if (i2 != 40) {
                        if (i2 != 629129) {
                            if (i2 != 34) {
                                if (i2 != 35) {
                                    return super.onCreateDialog(i2);
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
        return (Dialog) invokeI.objValue;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048595, this, view, z) == null) {
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity
    public void onModuleEvent(EventBus.Event event) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, event) == null) && event != null && "ev_bean_execut_err_content".equals(event.mEventKey)) {
            Object obj = event.mEventObj;
            if (obj instanceof BeanErrorContent) {
                BeanErrorContent beanErrorContent = (BeanErrorContent) obj;
                onBeanExecFailureWithErrContent(beanErrorContent.getBeanId(), beanErrorContent.getRet(), beanErrorContent.getMsg(), beanErrorContent.getErrContent());
                EventBus.getInstance().removeStickyEvent("ev_bean_execut_err_content");
            }
        }
    }

    @Override // com.dxmpay.wallet.base.widget.SafeKeyBoardEditText.OnMyFocusChangeListener
    public void onMyFocusChange(View view, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048597, this, view, z) == null) {
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, intent) == null) {
            super.onNewIntent(intent);
            this.f60939a = PayRequestCache.getInstance().getBindCategoryByIntent(getIntent());
            this.mBindReq = (BindFastRequest) PayRequestCache.getInstance().getRequest(this.f60939a);
            PayDataCache.getInstance().setCurrentPayRequest(this.f60939a);
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
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            super.onPause();
            EventBus.getInstance().unregister(this, "ev_bean_execut_err_content");
            if (Build.VERSION.SDK_INT >= 10) {
                NFCUtil.getInstance().disableForegroundDispatch(getActivity(), false);
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.BaseActivity, android.app.Activity
    public void onPrepareDialog(int i2, Dialog dialog) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048600, this, i2, dialog) == null) {
            if (i2 == 2) {
                PromptImageDialog promptImageDialog = (PromptImageDialog) dialog;
                promptImageDialog.setMessage(this.mDialogMsg);
                if (this.f60944f == 0) {
                    promptImageDialog.setTitleMessage(ResUtils.getString(getActivity(), "ebpay_cvv2_tip_title"));
                    promptImageDialog.setImage(ResUtils.drawable(getActivity(), "wallet_base_help_cvv"));
                    return;
                }
                promptImageDialog.setTitleMessage(ResUtils.getString(getActivity(), "ebpay_date_tip_title"));
                promptImageDialog.setImage(ResUtils.drawable(getActivity(), "wallet_base_help_date"));
            } else if (i2 == 3) {
                PromptDialog promptDialog = (PromptDialog) dialog;
                promptDialog.setMessage(this.mDialogMsg);
                promptDialog.setCanceledOnTouchOutside(false);
                promptDialog.hideNegativeButton();
                promptDialog.setPositiveBtn(ResUtils.string(getActivity(), "dxm_ebpay_confirm"), new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.BindCardBaseActivity.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ BindCardBaseActivity f60947a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f60947a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            WalletGlobalUtils.safeDismissDialog(this.f60947a, 3);
                        }
                    }
                });
            } else if (i2 == 13) {
                PromptTipDialog promptTipDialog = (PromptTipDialog) dialog;
                promptTipDialog.setMessage(ResUtils.getString(getActivity(), "ebpay_mobile_tip"));
                promptTipDialog.setTitleMessage(ResUtils.getString(getActivity(), "ebpay_bank_phone"));
            } else if (i2 == 14) {
                PromptTipDialog promptTipDialog2 = (PromptTipDialog) dialog;
                promptTipDialog2.setMessage(this.mDialogMsg);
                promptTipDialog2.setTitleMessage(ResUtils.getString(getActivity(), "ebpay_name_title"));
            } else if (i2 == 34) {
                StatisticManager.onEvent("showCardOverDue");
                PromptDialog promptDialog2 = (PromptDialog) dialog;
                promptDialog2.setMessage(this.mDialogMsg);
                promptDialog2.showCloseBtn(false);
                promptDialog2.setCanceledOnTouchOutside(false);
                promptDialog2.setNegativeBtn(ResUtils.getString(getActivity(), "dxm_ebpay_cancel"), new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.BindCardBaseActivity.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ BindCardBaseActivity f60948a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f60948a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            BindCardBaseActivity bindCardBaseActivity = this.f60948a;
                            bindCardBaseActivity.addDoPayorCheckCardStatistics(ResUtils.getString(bindCardBaseActivity.getActivity(), "dxm_ebpay_cancel"));
                            WalletGlobalUtils.safeDismissDialog(this.f60948a, 34);
                        }
                    }
                });
                if (this.f60942d) {
                    promptDialog2.hideNegativeButton();
                }
                promptDialog2.setPositiveBtn(ResUtils.string(this, "ebpay_wallet_continue_pay"), new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.BindCardBaseActivity.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ BindCardBaseActivity f60949a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f60949a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            BindCardBaseActivity bindCardBaseActivity = this.f60949a;
                            bindCardBaseActivity.addDoPayorCheckCardStatistics(ResUtils.getString(bindCardBaseActivity.getActivity(), "ebpay_wallet_continue_pay"));
                            StatisticManager.onEvent("continueFromCardOverdue");
                            WalletGlobalUtils.safeDismissDialog(this.f60949a, 34);
                            PayController payController = PayController.getInstance();
                            BindCardBaseActivity bindCardBaseActivity2 = this.f60949a;
                            payController.updateCardInfoPay(bindCardBaseActivity2, bindCardBaseActivity2.mCardInfoUpdateContent);
                        }
                    }
                });
            } else if (i2 == 35) {
                StatisticManager.onEvent("showOrigPriceAlert");
                PromptMultiBtnDialog promptMultiBtnDialog = (PromptMultiBtnDialog) dialog;
                promptMultiBtnDialog.setMessage(this.mDialogMsg);
                promptMultiBtnDialog.setFirstBtn(ResUtils.getString(this, "bd_wallet_pay_by_order_price"), new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.BindCardBaseActivity.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ BindCardBaseActivity f60950a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f60950a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            StatisticManager.onEvent("origPriceFromAlert");
                            BindCardBaseActivity bindCardBaseActivity = this.f60950a;
                            bindCardBaseActivity.addDoPayorCheckCardStatistics(ResUtils.getString(bindCardBaseActivity.getActivity(), "bd_wallet_pay_by_order_price"));
                            ErrorContentResponse errorContentResponse = this.f60950a.mCardInfoUpdateContent;
                            if (errorContentResponse == null || errorContentResponse.mkt_solution == null) {
                                return;
                            }
                            ((PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY)).setMktSolution(this.f60950a.mCardInfoUpdateContent.mkt_solution);
                            if (this.f60950a.mBindReq.getmBindFrom() == 9) {
                                this.f60950a.mBindCardController.c(new String[0]);
                            } else {
                                BindCardBaseActivity bindCardBaseActivity2 = this.f60950a;
                                if (bindCardBaseActivity2.checkCardInfoBean == null) {
                                    bindCardBaseActivity2.checkCardInfoBean = (g) PayBeanFactory.getInstance().getBean((Context) this.f60950a.getActivity(), 5, BindCardBaseActivity.BEAN_TAG);
                                }
                                BindCardBaseActivity bindCardBaseActivity3 = this.f60950a;
                                bindCardBaseActivity3.checkCardInfoBean.a(bindCardBaseActivity3.mBindReq);
                                BindCardBaseActivity bindCardBaseActivity4 = this.f60950a;
                                bindCardBaseActivity4.checkCardInfoBean.setResponseCallback(bindCardBaseActivity4);
                                this.f60950a.checkCardInfoBean.execBean();
                            }
                            WalletGlobalUtils.safeShowDialog(this.f60950a, -2, "");
                            WalletGlobalUtils.safeDismissDialog(this.f60950a, 35);
                        }
                    }
                });
                promptMultiBtnDialog.setSecondBtn(ResUtils.getString(this, "bd_wallet_modify_card_no"), new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.BindCardBaseActivity.6
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ BindCardBaseActivity f60951a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f60951a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            BindCardBaseActivity bindCardBaseActivity = this.f60951a;
                            bindCardBaseActivity.addDoPayorCheckCardStatistics(ResUtils.getString(bindCardBaseActivity.getActivity(), "bd_wallet_modify_card_no"));
                            WalletGlobalUtils.safeDismissDialog(this.f60951a, 35);
                            this.f60951a.updateChangeCard();
                        }
                    }
                });
                promptMultiBtnDialog.setThirdBtn(ResUtils.getString(this, "dxm_ebpay_cancel"), new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.BindCardBaseActivity.7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ BindCardBaseActivity f60952a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f60952a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            BindCardBaseActivity bindCardBaseActivity = this.f60952a;
                            bindCardBaseActivity.addDoPayorCheckCardStatistics(ResUtils.getString(bindCardBaseActivity.getActivity(), "dxm_ebpay_cancel"));
                            WalletGlobalUtils.safeDismissDialog(this.f60952a, 35);
                        }
                    }
                });
            } else if (i2 == 40) {
                PromptDialog promptDialog3 = (PromptDialog) dialog;
                promptDialog3.setMessage(this.mDialogMsg);
                promptDialog3.hideNegativeButton();
                promptDialog3.setPositiveBtn(ResUtils.string(this, "dxm_ebpay_know"), new View.OnClickListener(this, promptDialog3) { // from class: com.baidu.wallet.paysdk.ui.BindCardBaseActivity.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ PromptDialog f60945a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ BindCardBaseActivity f60946b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, promptDialog3};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f60946b = this;
                        this.f60945a = promptDialog3;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            PayController payController = PayController.getInstance();
                            BindCardBaseActivity bindCardBaseActivity = this.f60946b;
                            payController.updateCardInfoPay(bindCardBaseActivity, bindCardBaseActivity.mCardInfoUpdateContent);
                            this.f60945a.dismiss();
                        }
                    }
                });
            } else if (i2 != 629129) {
                super.onPrepareDialog(i2, dialog);
            } else {
                StatisticManager.onEvent("showOrigPriceAlert");
                PromptDialog promptDialog4 = (PromptDialog) dialog;
                promptDialog4.setMessage(this.mDialogMsg);
                promptDialog4.showCloseBtn(false);
                promptDialog4.setCanceledOnTouchOutside(false);
                promptDialog4.setNegativeBtn(ResUtils.getString(getActivity(), "dxm_ebpay_cancel"), new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.BindCardBaseActivity.8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ BindCardBaseActivity f60953a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f60953a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            BindCardBaseActivity bindCardBaseActivity = this.f60953a;
                            bindCardBaseActivity.addDoPayorCheckCardStatistics(ResUtils.getString(bindCardBaseActivity.getActivity(), "dxm_ebpay_cancel"));
                            WalletGlobalUtils.safeDismissDialog(this.f60953a, 629129);
                        }
                    }
                });
                promptDialog4.setPositiveBtn(ResUtils.string(this, "bd_wallet_pay_by_order_price"), new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.BindCardBaseActivity.9
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ BindCardBaseActivity f60954a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f60954a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            StatisticManager.onEvent("origPriceFromAlert");
                            BindCardBaseActivity bindCardBaseActivity = this.f60954a;
                            bindCardBaseActivity.addDoPayorCheckCardStatistics(ResUtils.getString(bindCardBaseActivity.getActivity(), "bd_wallet_pay_by_order_price"));
                            ErrorContentResponse errorContentResponse = this.f60954a.mCardInfoUpdateContent;
                            if (errorContentResponse == null || errorContentResponse.mkt_solution == null) {
                                return;
                            }
                            ((PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY)).setMktSolution(this.f60954a.mCardInfoUpdateContent.mkt_solution);
                            if (this.f60954a.mBindReq.getmBindFrom() == 9) {
                                this.f60954a.mBindCardController.c(new String[0]);
                            } else {
                                BindCardBaseActivity bindCardBaseActivity2 = this.f60954a;
                                if (bindCardBaseActivity2.checkCardInfoBean == null) {
                                    bindCardBaseActivity2.checkCardInfoBean = (g) PayBeanFactory.getInstance().getBean((Context) this.f60954a.getActivity(), 5, BindCardBaseActivity.BEAN_TAG);
                                }
                                BindCardBaseActivity bindCardBaseActivity3 = this.f60954a;
                                bindCardBaseActivity3.checkCardInfoBean.a(bindCardBaseActivity3.mBindReq);
                                BindCardBaseActivity bindCardBaseActivity4 = this.f60954a;
                                bindCardBaseActivity4.checkCardInfoBean.setResponseCallback(bindCardBaseActivity4);
                                this.f60954a.checkCardInfoBean.execBean();
                            }
                            WalletGlobalUtils.safeShowDialog(this.f60954a, -2, "");
                            WalletGlobalUtils.safeDismissDialog(this.f60954a, 629129);
                        }
                    }
                });
            }
        }
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, bundle) == null) {
            a(bundle);
            super.onRestoreInstanceState(bundle);
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.beans.BeanActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
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
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, bundle) == null) {
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
            bundle.putInt("currentStep", this.f60943e);
            bundle.putInt("halfScreen", this.mUpdateItemCount);
            bundle.putInt("reasonForChangeCardItem", this.mBindReason);
            super.onSaveInstanceState(bundle);
        }
    }

    public void startActivityForBind(Class<?> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, cls) == null) {
            startActivity(new Intent(getActivity(), cls));
        }
    }

    public void stastics(String str) {
        BindFastRequest bindFastRequest;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048605, this, str) == null) || (bindFastRequest = this.mBindReq) == null) {
            return;
        }
        int i2 = bindFastRequest.getmBindFrom();
        if (i2 == 0) {
            StatisticManager.onEventWithValue(str, "pay");
        } else if (i2 == 1) {
            StatisticManager.onEventWithValue(str, "bind");
        } else if (i2 == 2) {
            StatisticManager.onEventWithValue(str, "completion");
        } else if (i2 == 3) {
            StatisticManager.onEventWithValue(str, "foggetPwd");
        } else if (i2 != 5) {
            b();
        } else {
            StatisticManager.onEventWithValue(str, "only_completion");
        }
    }

    public abstract void updateBankCouponDesc(CharSequence charSequence);

    public abstract void updateBankTitleInfo(GetCardInfoResponse.CardInfo cardInfo, boolean z);

    public abstract void updateBindCardProtocolFields(GetCardInfoResponse.ProtocolPlatformInfo protocolPlatformInfo);

    public abstract void updateCardElement(boolean z, boolean z2, boolean z3, boolean z4, boolean z5);

    public abstract void updateChangeCard();

    public abstract void updateCvv2Info(boolean z, boolean z2, boolean z3);

    public void updateDiscountTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, str) == null) {
        }
    }

    public abstract void updateDiscountTxt(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, CharSequence charSequence5);

    public abstract void updateProtocolFields(GetCardInfoResponse.ProtocolInfo protocolInfo);

    private void a(Bundle bundle) {
        Serializable serializable;
        Serializable serializable2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, this, bundle) == null) || bundle == null) {
            return;
        }
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
        this.f60943e = bundle.getInt("currentStep");
        this.mUpdateItemCount = bundle.getInt("halfScreen", 0);
        this.mBindReason = bundle.getInt("reasonForChangeCardItem", 0);
    }

    public void a(Bundle bundle, Class<?> cls, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048576, this, bundle, cls, z) == null) {
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
    }

    private void a(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, view) == null) {
            this.mContentLayout.setVisibility(0);
            if (this.mContentLayout.getChildCount() > 0) {
                this.mContentLayout.removeAllViews();
            }
            this.mContentLayout.addView(view);
        }
    }

    private void a(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, intent) == null) {
            if (intent == null) {
                this.mUpdateItemCount = 0;
                this.mBindReason = 0;
                return;
            }
            this.mUpdateItemCount = intent.getIntExtra("halfScreen", 0);
            this.mBindReason = intent.getIntExtra("reasonForChangeCardItem", 0);
        }
    }

    private void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(AdIconUtil.AD_TEXT_ID, this, z) == null) {
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
}
