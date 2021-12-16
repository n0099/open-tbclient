package com.baidu.wallet.paysdk.ui;

import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.livesdk.sdk.service.IMLikeRequest;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.controllers.PayController;
import com.baidu.wallet.base.datamodel.Authorize;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.base.widget.OrderConfirmation;
import com.baidu.wallet.base.widget.WalletBaseButtonWithImage;
import com.baidu.wallet.paysdk.PayCallBackManager;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.paysdk.b.f;
import com.baidu.wallet.paysdk.b.g;
import com.baidu.wallet.paysdk.b.j;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.beans.w;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.CardAddResponse;
import com.baidu.wallet.paysdk.datamodel.CheckCardInfoResponse;
import com.baidu.wallet.paysdk.datamodel.ErrorContentResponse;
import com.baidu.wallet.paysdk.datamodel.GetCardInfoResponse;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.datamodel.QueryBankBinResponse;
import com.baidu.wallet.paysdk.payresult.datamodel.PayResultContent;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.widget.AuthorizeInfoView;
import com.baidu.wallet.paysdk.ui.widget.BankCardInfoView;
import com.baidu.wallet.paysdk.ui.widget.BankCvv2InfoView;
import com.baidu.wallet.paysdk.ui.widget.BankMsgInfoView;
import com.baidu.wallet.paysdk.ui.widget.BankUserInfoView;
import com.baidu.wallet.paysdk.ui.widget.BindCardHeadView;
import com.baidu.wallet.paysdk.ui.widget.CertificateMenuView;
import com.baidu.wallet.router.LocalRouter;
import com.baidu.wallet.router.RouterCallback;
import com.baidu.wallet.router.RouterRequest;
import com.dxmpay.apollon.eventbus.EventBus;
import com.dxmpay.apollon.statusbar.StatusBarUtils;
import com.dxmpay.apollon.utils.CheckUtils;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.apollon.utils.support.Base64;
import com.dxmpay.apollon.utils.support.ViewHelper;
import com.dxmpay.wallet.api.BaiduWalletDelegate;
import com.dxmpay.wallet.api.WalletLoginHelper;
import com.dxmpay.wallet.base.widget.DivisionEditText;
import com.dxmpay.wallet.base.widget.SafeKeyBoardEditText;
import com.dxmpay.wallet.base.widget.SafeKeyBoardUtil;
import com.dxmpay.wallet.base.widget.SafeScrollView;
import com.dxmpay.wallet.base.widget.dialog.PromptDialog;
import com.dxmpay.wallet.core.beans.BeanManager;
import com.dxmpay.wallet.core.utils.WalletGlobalUtils;
import com.dxmpay.wallet.paysdk.ui.WebViewActivity;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.AccessibilityUtils;
import com.dxmpay.wallet.utils.StatHelper;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
/* loaded from: classes13.dex */
public class BindCardImplActivity extends BindCardBaseActivity implements c {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "BindCardImplActivity";
    public static Pattern z;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public ViewGroup B;
    public boolean C;
    public String D;
    public String E;
    public GetCardInfoResponse.CertificateTypeInfo F;
    public int G;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f54255b;

    /* renamed from: c  reason: collision with root package name */
    public EditText f54256c;

    /* renamed from: d  reason: collision with root package name */
    public GetCardInfoResponse f54257d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f54258e;

    /* renamed from: f  reason: collision with root package name */
    public int f54259f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f54260g;

    /* renamed from: h  reason: collision with root package name */
    public BankCardInfoView f54261h;

    /* renamed from: i  reason: collision with root package name */
    public OrderConfirmation f54262i;

    /* renamed from: j  reason: collision with root package name */
    public AuthorizeInfoView f54263j;

    /* renamed from: k  reason: collision with root package name */
    public BankMsgInfoView f54264k;
    public LinearLayout l;
    public WalletBaseButtonWithImage m;
    public BankCvv2InfoView mBankCvv2InfoView;
    public BankUserInfoView mBankUserInfoView;
    public com.baidu.wallet.paysdk.ui.widget.b mCertificateTypeDialog;
    public TextView n;
    public CheckBox o;
    public BindCardHeadView p;
    public TextView q;
    public TextView r;
    public LinearLayout s;
    public LinearLayout t;
    public GetCardInfoResponse u;
    public GetCardInfoResponse.CardInfo v;
    public StringBuilder w;
    public boolean x;
    public a y;

    /* loaded from: classes13.dex */
    public static class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<c> a;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(cVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            WeakReference<c> weakReference;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                super.handleMessage(message);
                if (message.what == 0 && (weakReference = this.a) != null) {
                    weakReference.get().showBindCardDialog();
                }
            }
        }
    }

    /* loaded from: classes13.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public CharSequence a;

        /* renamed from: b  reason: collision with root package name */
        public CharSequence f54295b;

        /* renamed from: c  reason: collision with root package name */
        public CharSequence f54296c;

        /* renamed from: d  reason: collision with root package name */
        public CharSequence f54297d;

        /* renamed from: e  reason: collision with root package name */
        public CharSequence f54298e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ BindCardImplActivity f54299f;

        public b(BindCardImplActivity bindCardImplActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bindCardImplActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54299f = bindCardImplActivity;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(62819033, "Lcom/baidu/wallet/paysdk/ui/BindCardImplActivity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(62819033, "Lcom/baidu/wallet/paysdk/ui/BindCardImplActivity;");
                return;
            }
        }
        z = Pattern.compile("(4|1(1|2))");
    }

    public BindCardImplActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f54259f = 100027;
        this.f54260g = false;
        this.w = new StringBuilder();
        this.C = true;
        this.D = "";
        this.E = "";
        this.G = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        BindFastRequest bindFastRequest;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, this) == null) || (bindFastRequest = this.mBindReq) == null) {
            return;
        }
        if (bindFastRequest.getmBindFrom() == 1) {
            List<String> collectData = StatHelper.collectData(StatHelper.getSessionId(), StatHelper.SENSOR_ERR_2, "initivativeBindCardCancel");
            HashMap hashMap = new HashMap();
            hashMap.put(StatHelper.BIND_CARD_USER_TYPE, StatHelper.getBindCardUserType());
            StatisticManager.onEventWithValues(PayStatServiceEvent.INITIVATIVE_BIND_CARD_FAILED, collectData, hashMap);
        } else if (this.mBindReq.getmBindFrom() == 0) {
            StatHelper.statServiceEvent(PayStatServiceEvent.PAY_BIND_CARD_FAILED, null, StatHelper.SENSOR_ERR_2, "payBindCardCancel");
            StatHelper.cacheCodeAndMsg(StatHelper.SENSOR_ERR_2, "payBindCardCancel");
            StatHelper.payEventEndWithValues(PayStatServiceEvent.PAY_BIND_CARD_DURATION, null, new String[0]);
        } else if (this.mBindReq.getmBindFrom() == 6) {
            StatHelper.statServiceEvent(PayStatServiceEvent.STD_PAY_CANCEL);
            StatHelper.statServiceEvent(PayStatServiceEvent.PAY_BIND_CARD_FAILED, null, StatHelper.SENSOR_ERR_2, "authorizeBindCardCancel");
            StatHelper.cacheCodeAndMsg(StatHelper.SENSOR_ERR_2, "authorizeBindCardCancel");
            StatHelper.payEventEndWithValues(PayStatServiceEvent.PAY_BIND_CARD_DURATION, null, new String[0]);
        } else {
            int i2 = this.mBindReq.mBindFrom;
            if (i2 == 2 || i2 == 7) {
                StatHelper.cacheCodeAndMsg(StatHelper.SENSOR_ERR_2, "completeBindCardCardCancel");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) ? this.f54256c : (EditText) invokeV.objValue;
    }

    private boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65593, this)) == null) ? this.mBindCardController.n() && this.mBankUserInfoView.getMobileEditText().isEnabled() && !this.mBankUserInfoView.getMobileFromNet() && !CheckUtils.isMobileAvailable(this.mBankUserInfoView.getMobileEditText().getRealText()) : invokeV.booleanValue;
    }

    private boolean p() {
        InterceptResult invokeV;
        int parseInt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65594, this)) == null) {
            if (this.mBindCardController.l() && this.mBankCvv2InfoView.getDateInputView().isEnabled()) {
                String obj = this.mBankCvv2InfoView.getDateInputView().getText().toString();
                if (!TextUtils.isEmpty(obj) && obj.length() == 5) {
                    try {
                        if (TextUtils.isEmpty(obj) || ((parseInt = Integer.parseInt(obj.substring(0, 2))) > 0 && parseInt <= 12)) {
                            return Integer.parseInt(obj.substring(3, 5)) < q();
                        }
                        return true;
                    } catch (Exception unused) {
                    }
                }
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private int q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65595, this)) == null) {
            String format = new SimpleDateFormat("yyyy").format(new Date(System.currentTimeMillis()));
            if (!TextUtils.isEmpty(format) && format.length() == 4) {
                try {
                    return Integer.parseInt(format.substring(2, 4));
                } catch (Exception unused) {
                }
            }
            return 18;
        }
        return invokeV.intValue;
    }

    private boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65596, this)) == null) ? this.mBindCardController.k() && this.mBankCvv2InfoView.getCvv2InputView().isEnabled() && !CheckUtils.isBandCardEndAvailable(this.mBankCvv2InfoView.getCvv2InputView().getText().toString()) : invokeV.booleanValue;
    }

    private void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65597, this) == null) {
            DivisionEditText cardNoView = this.f54261h.getCardNoView();
            cardNoView.addTextChangedListener(new TextWatcher(this) { // from class: com.baidu.wallet.paysdk.ui.BindCardImplActivity.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public boolean a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ BindCardImplActivity f54294b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f54294b = this;
                    this.a = false;
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, editable) == null) {
                        if (!this.a) {
                            StatisticManager.onEvent("clickInputCardNo");
                            this.a = true;
                        }
                        this.f54294b.y();
                    }
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2, i3, i4) == null) {
                    }
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) {
                    }
                }
            });
            this.f54261h.setTipClick(this);
            cardNoView.setOnMyFocusChangeListener(this);
        }
    }

    private void t() {
        CardData.BondCard bondCard;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65598, this) == null) {
            int currentStep = getCurrentStep();
            if (currentStep == 0) {
                this.mScrollView.dismissKeyBoard(this.f54261h.getCardNoView());
                a("");
                return;
            }
            if (currentStep != 1) {
                return;
            }
            if (!this.f54261h.getCardNoView().isEnabled()) {
                BindFastRequest bindFastRequest = this.mBindReq;
                if (bindFastRequest != null && (bondCard = bindFastRequest.mBondCard) != null) {
                    this.D = bondCard.account_no;
                }
            } else {
                this.D = this.f54261h.getCardNoView().getRealText();
            }
            if (TextUtils.isEmpty(this.D)) {
                StringBuilder sb = new StringBuilder();
                sb.append("view.isEnable:");
                sb.append(this.f54261h.getCardNoView().isEnabled());
                if (this.mBindReq != null) {
                    sb.append(";mBindReq.mBondCard(isNull):");
                    sb.append(this.mBindReq.mBondCard == null);
                }
                sb.append("; realText:");
                sb.append(this.f54261h.getCardNoView().getRealText());
                StatisticManager.onEventEndWithValue("bindcard.cardNo", -1, sb.toString());
            }
            BindFastRequest bindFastRequest2 = this.mBindReq;
            if (bindFastRequest2 != null) {
                bindFastRequest2.setmBankCard(this.D);
            }
            if (this.mBindCardController.E()) {
                w();
            } else {
                u();
            }
        }
    }

    private void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65599, this) == null) {
            j jVar = this.mBindCardController;
            if (jVar instanceof g) {
                g gVar = (g) jVar;
                String[] strArr = new String[6];
                strArr[0] = this.mBankCvv2InfoView.getCvv2InputView().getText().toString();
                strArr[1] = this.mBankCvv2InfoView.getDateInputView().getText().toString();
                strArr[2] = this.mBankUserInfoView.getTrueNameText().getText().toString();
                strArr[3] = this.mBankUserInfoView.getIdEditText().getText().toString();
                strArr[4] = this.mBankUserInfoView.getMobileEditText().getText().toString();
                GetCardInfoResponse.CertificateTypeInfo certificateTypeInfo = this.F;
                strArr[5] = certificateTypeInfo != null ? certificateTypeInfo.type : "";
                gVar.b(strArr);
                WalletGlobalUtils.safeShowDialog(this, 0, "");
                w wVar = (w) PayBeanFactory.getInstance().getBean((Context) this, 13, BindCardBaseActivity.BEAN_TAG);
                wVar.setResponseCallback(this);
                wVar.execBean();
            }
        }
    }

    private boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65600, this)) == null) {
            int currentStep = getCurrentStep();
            if (currentStep != 0) {
                if (currentStep != 1) {
                    return true;
                }
                return k() && l();
            }
            if (!this.f54261h.getCardNoView().isEnabled()) {
                CardData.BondCard bondCard = this.mBindReq.mBondCard;
                if (bondCard != null) {
                    this.D = bondCard.account_no;
                }
            } else {
                this.D = this.f54261h.getCardNoView().getRealText();
            }
            return j();
        }
        return invokeV.booleanValue;
    }

    private void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65601, this) == null) {
            StatHelper.statServiceEvent("secondNext");
            if (isBindInvalid()) {
                return;
            }
            WalletGlobalUtils.safeShowDialog(this, -2, "");
            j jVar = this.mBindCardController;
            String[] strArr = new String[6];
            strArr[0] = this.mBankCvv2InfoView.getCvv2InputView().getText().toString();
            strArr[1] = this.mBankCvv2InfoView.getDateInputView().getText().toString();
            strArr[2] = this.mBankUserInfoView.getTrueNameText().getText().toString();
            strArr[3] = this.mBankUserInfoView.getIdEditText().getText().toString();
            strArr[4] = this.mBankUserInfoView.getMobileEditText().getText().toString();
            GetCardInfoResponse.CertificateTypeInfo certificateTypeInfo = this.F;
            strArr[5] = certificateTypeInfo != null ? certificateTypeInfo.type : "";
            jVar.c(strArr);
        }
    }

    private void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65602, this) == null) {
            if (com.baidu.wallet.paysdk.a.b.a()) {
                WalletGlobalUtils.safeShowDialog(this, 629130, "");
            } else {
                WalletGlobalUtils.safeShowDialog(this, 4, "");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ed  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean y() {
        InterceptResult invokeV;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65603, this)) == null) {
            this.f54261h.getClearView().setVisibility(8);
            View currentFocus = getWindow().getCurrentFocus();
            String realText = this.f54261h.getCardNoView().getRealText();
            if (this.f54261h.getCardNoView().isEnabled() && getCurrentStep() != 0 && !realText.equals(this.D)) {
                resetCardInfoState();
                this.E = "";
            }
            boolean z3 = false;
            if (currentFocus != null) {
                if (currentFocus.getId() == this.f54261h.getCardNoView().getId() && this.f54261h.getCardNoView().isEnabled()) {
                    if (!TextUtils.isEmpty(realText)) {
                        this.f54261h.getClearView().setVisibility(0);
                        this.f54261h.setTipDel();
                    } else {
                        if (this.mBindCardController.y()) {
                            this.f54261h.getClearView().setVisibility(0);
                        } else {
                            this.f54261h.getClearView().setVisibility(8);
                        }
                        this.f54261h.setTipScan();
                    }
                } else {
                    this.f54261h.getClearView().setVisibility(8);
                }
            }
            boolean z4 = true;
            if (this.f54261h.getCardNoView().getVisibility() == 0) {
                if (!TextUtils.isEmpty(realText) && realText.length() >= 10) {
                    String substring = realText.substring(0, 10);
                    GetCardInfoResponse.CardInfo cardInfo = this.v;
                    if (cardInfo != null) {
                        String str = cardInfo.bank_no;
                        if (!TextUtils.isEmpty(str)) {
                            String replace = str.replace(" ", "");
                            if (replace.length() >= 10 && replace.substring(0, 10).equals(substring)) {
                                z2 = true;
                                if (!z2) {
                                    updateBankTitleInfo(this.v, false);
                                } else if (realText.length() == 10) {
                                    b(realText);
                                } else {
                                    b(realText.substring(0, 10));
                                }
                            }
                        }
                    }
                    z2 = false;
                    if (!z2) {
                    }
                } else {
                    this.E = "";
                    updateBankTitleInfo(null, false);
                }
            }
            boolean j2 = j();
            if (getCurrentStep() != 0) {
                j2 = (j2 && l() && k()) ? false : false;
            }
            if (this.l.getVisibility() != 0 || this.o.isChecked()) {
                z3 = j2;
            }
            this.m.setEnabled(z3);
            return z3;
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65604, this) == null) {
            boolean v = v();
            if (this.l.getVisibility() == 0 && !this.o.isChecked()) {
                v = false;
            }
            this.m.setEnabled(v);
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity
    public void doLivingPay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            u();
        }
    }

    public void handleBindOtherCard() {
        BankCardInfoView bankCardInfoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (bankCardInfoView = this.f54261h) == null) {
            return;
        }
        bankCardInfoView.getCardNoView().getText().clear();
    }

    @Override // com.baidu.wallet.paysdk.ui.BindCardBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseActivity, com.dxmpay.wallet.core.beans.BeanActivity
    public void handleFailure(int i2, int i3, String str) {
        GetCardInfoResponse.ChannelInfo channelInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i2, i3, str) == null) {
            if (i3 == 65025) {
                GlobalUtils.toast(this, str);
                PayRequestCache.getInstance().clearPaySdkRequestCache();
                PayBaseBeanActivity.exitEbpay();
            } else if (i2 != 4) {
                if (i2 == 5 || i2 == 17) {
                    WalletGlobalUtils.safeDismissDialog(this, -2);
                    super.handleFailure(i2, i3, str);
                    this.mDialogMsg = str;
                    WalletGlobalUtils.safeShowDialog(this, 12, "");
                } else if (i2 == 13) {
                    WalletGlobalUtils.safeDismissDialog(this.mAct, 0);
                    this.mDialogMsg = str;
                    this.mPayErrorCode = i3;
                    this.mBeanId = i2;
                    WalletGlobalUtils.safeShowDialog(this, 12, "");
                    StatisticManager.onEventWithValue("bindPayAcceptFail", String.valueOf(i3));
                }
            } else {
                GetCardInfoResponse getCardInfoResponse = this.f54257d;
                StatisticManager.onEventEndWithValue("getCardInfo", i3, (getCardInfoResponse == null || (channelInfo = getCardInfoResponse.channel_info) == null) ? "0" : channelInfo.channel_no);
                WalletGlobalUtils.safeDismissDialog(this, -2);
                this.mDialogMsg = str;
                if (i3 == 100010) {
                    a(true);
                } else if (i3 == 100040 || i3 == 100026) {
                    WalletGlobalUtils.safeShowDialog(this, 3, "");
                } else if (i3 == 100028) {
                    this.f54259f = i3;
                    this.f54260g = false;
                    WalletGlobalUtils.safeShowDialog(this, 33, "");
                } else {
                    WalletGlobalUtils.safeShowDialog(this, 12, "");
                }
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.BindCardBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseActivity, com.dxmpay.wallet.core.beans.BeanActivity
    public void handleResponse(int i2, Object obj, String str) {
        CardAddResponse.CustomerSvcCfg customerSvcCfg;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048579, this, i2, obj, str) == null) {
            super.handleResponse(i2, obj, str);
            if (i2 == 7) {
                if (obj == null || !(obj instanceof QueryBankBinResponse)) {
                    return;
                }
                QueryBankBinResponse queryBankBinResponse = (QueryBankBinResponse) obj;
                GetCardInfoResponse.CardInfo cardInfo = queryBankBinResponse.card_info;
                if (cardInfo != null) {
                    String str2 = cardInfo.bank_name;
                    this.v = cardInfo;
                    if (this.f54261h.getCardNoView() != null && !TextUtils.isEmpty(this.f54261h.getCardNoView().getText())) {
                        this.v.bank_no = this.f54261h.getCardNoView().getText().toString();
                    }
                }
                updateBankTitleInfo(queryBankBinResponse.card_info, false);
            } else if (i2 == 4) {
                WalletGlobalUtils.safeDismissDialog(this, -2);
                GetCardInfoResponse getCardInfoResponse = (GetCardInfoResponse) obj;
                this.f54257d = getCardInfoResponse;
                if (getCardInfoResponse == null) {
                    return;
                }
                GetCardInfoResponse.ChannelInfo channelInfo = getCardInfoResponse.channel_info;
                StatisticManager.onEventEndWithValue("getCardInfo", 0, channelInfo != null ? channelInfo.channel_no : "0");
                this.f54259f = -1;
                this.mDialogMsg = "";
                Map<String, String> map = this.f54257d.cashdesk;
                if (map != null && map.size() > 0) {
                    PayDataCache.getInstance().setSessionData(this.f54257d.cashdesk);
                }
                GetCardInfoResponse.Algorithm algorithm = this.f54257d.algorithm_check_info;
                if (algorithm != null && (i3 = algorithm.code) == 100027) {
                    this.f54259f = i3;
                    this.mDialogMsg = algorithm.msg;
                    this.f54260g = false;
                    WalletGlobalUtils.safeShowDialog(this, 33, "");
                    return;
                }
                GetCardInfoResponse.BindCardInfo bindCardInfo = this.f54257d.bind_card_info;
                if (bindCardInfo != null && !TextUtils.isEmpty(bindCardInfo.bind_card_desc)) {
                    this.f54259f = 100027;
                    this.mDialogMsg = this.f54257d.bind_card_info.bind_card_desc;
                    this.f54260g = true;
                    WalletGlobalUtils.safeShowDialog(this, 33, "");
                    return;
                }
                a(this.f54257d);
            } else if (i2 != 5 && i2 != 17) {
                if (i2 == 13) {
                    WalletGlobalUtils.safeDismissDialog(this.mAct, 0);
                } else if (597 == i2) {
                    CardAddResponse.updateContent(obj);
                    CardAddResponse cardAddResponse = CardAddResponse.getInstance();
                    if (cardAddResponse == null || (customerSvcCfg = cardAddResponse.intelligent_service) == null) {
                        return;
                    }
                    com.baidu.wallet.paysdk.ui.b.a(this.mAct, this.bdActionBar, customerSvcCfg.customer_service_url, customerSvcCfg.customer_service_icon, customerSvcCfg.customer_service_copy, "CSTM_SVC_cardAdd");
                }
            } else {
                WalletGlobalUtils.safeDismissDialog(this, -2);
                CheckCardInfoResponse checkCardInfoResponse = (CheckCardInfoResponse) obj;
                this.mBindReq.setmNeedSms((1 == checkCardInfoResponse.send_sms_by_bfb || "1".equals(checkCardInfoResponse.need_verify_sms)) ? 1 : 0);
                Map<String, String> map2 = checkCardInfoResponse.cashdesk;
                if (map2 != null && map2.size() > 0) {
                    PayDataCache.getInstance().setSessionData(checkCardInfoResponse.cashdesk);
                }
                if (!TextUtils.isEmpty(checkCardInfoResponse.channel_no)) {
                    this.mBindReq.setChannelNo(checkCardInfoResponse.channel_no);
                }
                this.mBindReq.setRegEx(checkCardInfoResponse.sms_pattern);
                this.mBindReq.setSmsLength(checkCardInfoResponse.sms_length);
                this.mBindReq.setSmsType(checkCardInfoResponse.sms_type);
                this.mBindReq.setSendSmsphone(checkCardInfoResponse.send_sms_phone);
                if (i2 == 5) {
                    Bundle extras = getIntent().getExtras();
                    if (extras == null) {
                        extras = new Bundle();
                    }
                    extras.putString(BeanConstants.UPDATE_MOBILE_DESC, checkCardInfoResponse.update_mobile_desc);
                    extras.putInt(BeanConstants.SMS_ACTIVITY_FROM_KEY, this.mBindReq.getmBindFrom() == 1 ? 7 : 0);
                    PayRequestCache.BindCategory bindCategory = ((BindCardBaseActivity) this).a;
                    if (bindCategory == null) {
                        bindCategory = PayRequestCache.BindCategory.Other;
                    }
                    extras.putString("baidu.wallet.from", bindCategory.name());
                    a(extras, WalletSmsActivity.class, false);
                }
                if (i2 == 17) {
                    if (com.baidu.wallet.paysdk.a.b.a()) {
                        this.mBindReq.mBindFrom = 7;
                    } else {
                        this.mBindReq.mBindFrom = 2;
                    }
                    Intent intent = new Intent();
                    intent.setClass(this, WalletSmsActivity.class);
                    intent.putExtra(BeanConstants.UPDATE_MOBILE_DESC, checkCardInfoResponse.update_mobile_desc);
                    intent.putExtra(BeanConstants.SMS_ACTIVITY_FOR_COMPLETION_PAY, false);
                    intent.putExtra(BeanConstants.SMS_ACTIVITY_FROM_KEY, 0);
                    intent.putExtra(BeanConstants.KEY_SEND_SMS_AUTO, false);
                    PayRequestCache.BindCategory bindCategory2 = ((BindCardBaseActivity) this).a;
                    if (bindCategory2 == null) {
                        bindCategory2 = PayRequestCache.BindCategory.Other;
                    }
                    intent.putExtra("baidu.wallet.from", bindCategory2.name());
                    startActivityForResultWithoutAnim(intent, 0);
                }
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.BindCardBaseActivity
    public void initSafeKeyBoard() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (isShowWithHalfScreeen()) {
                SafeKeyBoardEditText[] safeKeyBoardEditTextArr = {this.f54261h.getCardNoView(), this.mBankCvv2InfoView.getDateInputView(), this.mBankCvv2InfoView.getCvv2InputView(), this.mBankUserInfoView.getTrueNameText(), this.mBankUserInfoView.getIdEditText(), this.mBankUserInfoView.getMobileEditText()};
                for (int i2 = 0; i2 < 6; i2++) {
                    SafeKeyBoardEditText safeKeyBoardEditText = safeKeyBoardEditTextArr[i2];
                    safeKeyBoardEditText.setOnMyFocusChangeListener(this);
                    safeKeyBoardEditText.initSafeKeyBoardParams(this.mRootView, this.mScrollView, (View) safeKeyBoardEditText.getTag(), false);
                }
            } else if (this.f54261h.getCardNoView().isEnabled()) {
                this.f54261h.getCardNoView().setOnMyFocusChangeListener(this);
                this.f54261h.getCardNoView().initSafeKeyBoardParams(this.mRootView, this.mScrollView, this.l.getVisibility() == 0 ? this.l : this.r.getVisibility() == 0 ? this.r : this.m, false);
            }
            super.initSafeKeyBoard();
        }
    }

    @Override // com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048581, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i2 == 40976 && i3 == -1 && intent != null && intent.getExtras() != null) {
                a(intent.getExtras().getString("subbankcode"));
            }
            if (i2 != 0 || i3 == -1) {
                return;
            }
            this.mBindReq.mBindFrom = this.A;
        }
    }

    @Override // com.dxmpay.wallet.core.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            PayRequest payRequest = this.mPayReq;
            if (payRequest != null) {
                payRequest.clearMktSolution();
            }
            if (!this.f54258e) {
                A();
            }
            if (this.mBindReq.getmBindFrom() == 1) {
                PayController.getInstance().bindFail(this, "");
                PayRequestCache.getInstance().clearPaySdkRequestCache();
                finish();
            } else if (this.mBindReq.getmBindFrom() == 5) {
                PayController.getInstance().bindFail(this, "");
                finish();
            } else if (this.f54258e) {
                x();
            } else if ((this.mBindReq.getmBindFrom() == 2 || this.mBindReq.getmBindFrom() == 0) && PayDataCache.getInstance().isFromPreCashier()) {
                PayCallBackManager.callBackClientCancel(this, "BindCardImplActivity.onBackPressed().1");
            } else {
                super.onBackPressed();
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.BindCardBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, view) == null) {
            if (view != this.m && view.getId() != ResUtils.id(this.mAct, "wallet_base_safekeyboard_confirm")) {
                if (view == this.f54262i.getCouponInfoView()) {
                    StatisticManager.onEvent("pressOtherDiscount");
                    PayController.getInstance().gotoDiscountPage(this);
                }
            } else if (v()) {
                BankCardInfoView bankCardInfoView = this.f54261h;
                if (bankCardInfoView != null) {
                    String scanCardNum = bankCardInfoView.getScanCardNum();
                    if (!TextUtils.isEmpty(scanCardNum) && !scanCardNum.equals(this.f54261h.getCardNoView().getRealText())) {
                        StatisticManager.onEvent("#bankCardNumChangedAfterScan");
                    }
                    this.f54261h.resetScanCardNum();
                }
                t();
            }
            super.onClick(view);
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.BindCardBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.beans.BeanActivity, com.dxmpay.wallet.core.BaseActivity, com.dxmpay.wallet.core.SDKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) {
            super.onCreate(bundle);
            setIsShowMultiWindowTips(true);
            EventBus.getInstance().registerSticky(this, "order_confirm_event_bus_key", 0, EventBus.ThreadMode.MainThread);
            if (LocalRouter.getInstance(getActivity()).isProviderExisted("bankdetection")) {
                this.C = getIntent().getBooleanExtra("baidu.wallet.listbankcard.extra", true);
            } else {
                this.C = false;
            }
            if (bundle == null) {
                this.f54258e = getIntent().getBooleanExtra(BindFastRequest.BIND_IS_FIRST, false);
                Serializable serializableExtra = getIntent().getSerializableExtra("cardinforesponse");
                if (serializableExtra != null && (serializableExtra instanceof GetCardInfoResponse)) {
                    this.u = (GetCardInfoResponse) serializableExtra;
                }
            } else {
                this.f54258e = bundle.getBoolean("isFrist", false);
                this.f54260g = bundle.getBoolean("bindTipFromActivity", false);
                if (this.f54257d == null) {
                    Serializable serializable = bundle.getSerializable("cacheResult");
                    if (serializable != null && (serializable instanceof GetCardInfoResponse)) {
                        this.f54257d = (GetCardInfoResponse) serializable;
                    }
                    Serializable serializable2 = bundle.getSerializable("cardinforesponse");
                    if (serializable2 != null && (serializable2 instanceof GetCardInfoResponse)) {
                        this.u = (GetCardInfoResponse) serializable2;
                    }
                }
            }
            a();
            getBindCardFlagDelegate().a(this.mBindReq);
            this.A = this.mBindReq.getmBindFrom();
            StatHelper.statServiceEvent(PayStatServiceEvent.ENTER_BIND_CARD_ACTIVITY);
            BindFastRequest bindFastRequest = this.mBindReq;
            if (bindFastRequest != null) {
                int i2 = bindFastRequest.mBindFrom;
                if (i2 == 2 || i2 == 7) {
                    StatisticManager.onEventStart(PayStatServiceEvent.PAY_COMPLETION_BANK_CARD_DURATION);
                }
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.BindCardBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.BaseActivity, android.app.Activity
    public Dialog onCreateDialog(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            if (i2 == 629128) {
                return new PromptDialog(getActivity());
            }
            return super.onCreateDialog(i2);
        }
        return (Dialog) invokeI.objValue;
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            BindFastRequest bindFastRequest = this.mBindReq;
            if (bindFastRequest != null && ((i2 = bindFastRequest.mBindFrom) == 2 || i2 == 7)) {
                StatHelper.payEventEndWithValues(PayStatServiceEvent.PAY_COMPLETION_BANK_CARD_DURATION, null, new String[0]);
            }
            EventBus.getInstance().unregister(this, "order_confirm_event_bus_key");
            this.mBindReq.setmBankInfo(null);
            this.mBindReq.mCardInfoUpdateContent = null;
            BeanManager.getInstance().removeAllBeans(BindCardBaseActivity.BEAN_TAG);
            if (LocalRouter.getInstance(this.mAct).isProviderExisted("bankdetection")) {
                LocalRouter.getInstance(this.mAct).route(this.mAct, new RouterRequest().provider("bankdetection").action("clearcallback"), new RouterCallback(this) { // from class: com.baidu.wallet.paysdk.ui.BindCardImplActivity.19
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ BindCardImplActivity a;

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
                        this.a = this;
                    }

                    @Override // com.baidu.wallet.router.RouterCallback
                    public void onResult(int i3, HashMap hashMap) {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeIL(1048576, this, i3, hashMap) == null) && i3 == 5) {
                            HashMap hashMap2 = new HashMap();
                            hashMap2.put("provider", "bankcarddetection");
                            hashMap2.put("action", "clearcallback");
                            StatisticManager.onEventEndWithValues("sdk_router_error", i3, hashMap2.values());
                        }
                    }
                });
            }
            this.p.deleteSpan();
            super.onDestroy();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.BindCardBaseActivity, android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048587, this, view, z2) == null) {
            a(view, z2);
            if (z2) {
                if (view instanceof EditText) {
                    this.f54256c = (EditText) view;
                }
                z();
            } else {
                a(view);
            }
            super.onFocusChange(view, z2);
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.BindCardBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseActivity
    public void onModuleEvent(EventBus.Event event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, event) == null) {
            if (event != null && "order_confirm_event_bus_key".equals(event.mEventKey)) {
                if (this.mBindCardController.d()) {
                    this.mBindCardController.o();
                }
                resetCardInfoState();
                y();
                return;
            }
            super.onModuleEvent(event);
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.BindCardBaseActivity, com.dxmpay.wallet.base.widget.SafeKeyBoardEditText.OnMyFocusChangeListener
    public void onMyFocusChange(View view, boolean z2) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048589, this, view, z2) == null) {
            if (this.mRootView instanceof LinearLayout) {
                View findViewById = findViewById(ResUtils.id(this.mAct, "padding_view"));
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
                int height = findViewById.getHeight();
                if (1.0f == layoutParams.weight && height > 0) {
                    PayRequest payRequest = this.mPayReq;
                    boolean z3 = payRequest != null && BaiduPay.PAY_FROM_AUTHORIZE.equals(payRequest.mPayFrom);
                    if (!PayDataCache.getInstance().isFromPreCashier() && !z3) {
                        drawable = new ColorDrawable(0);
                    } else {
                        drawable = ResUtils.getDrawable(this.mAct, "dxm_wallet_base_halfscreen_bg");
                    }
                    findViewById.setBackgroundDrawable(drawable);
                    layoutParams.weight = 0.0f;
                    layoutParams.height = height;
                    findViewById.setLayoutParams(layoutParams);
                }
            }
            if (view == this.f54261h.getCardNoView()) {
                if (z2) {
                    y();
                } else if (this.f54261h.getCardNoView().isEnabled()) {
                    if (this.mBindCardController.y()) {
                        this.f54261h.getClearView().setVisibility(0);
                    } else {
                        this.f54261h.getClearView().setVisibility(8);
                    }
                    this.f54261h.setTipScan();
                } else {
                    this.f54261h.getClearView().setVisibility(8);
                }
                com.baidu.wallet.paysdk.ui.widget.a.a(view, false, z2);
            } else {
                a(view, z2);
                if (z2) {
                    if (view instanceof EditText) {
                        this.f54256c = (EditText) view;
                    }
                    z();
                    this.mBankCvv2InfoView.getCvv2InputView();
                    int i2 = view != this.mBankCvv2InfoView.getDateInputView() ? 0 : 1;
                    if (view == this.mBankUserInfoView.getIdEditText()) {
                        i2 = 3;
                    }
                    if (view == this.mBankUserInfoView.getMobileEditText()) {
                        i2 = 4;
                    }
                    a(i2);
                } else {
                    a(view);
                }
            }
            super.onMyFocusChange(view, z2);
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.BindCardBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, intent) == null) {
            boolean runInHalfScreenMode = runInHalfScreenMode();
            b d2 = d();
            super.onNewIntent(intent);
            int i2 = this.mBindReq.mBindFrom;
            if (i2 == 9) {
                j a2 = com.baidu.wallet.paysdk.b.c.a(i2);
                this.mBindCardController = a2;
                a2.a(this);
            }
            this.mBindCardController.a(this.mBindReq);
            if (runInHalfScreenMode != isShowWithHalfScreeen()) {
                a();
                a(d2);
            } else if (this.mBindCardController.s()) {
                loadCvv2();
            }
            if (this.mBindCardController instanceof f) {
                this.mBankUserInfoView.getMobileEditText().setEnabled(true);
                a(d2);
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.BindCardBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.BaseActivity, android.app.Activity
    public void onPrepareDialog(int i2, Dialog dialog) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048591, this, i2, dialog) == null) {
            if (i2 == 3) {
                PromptDialog promptDialog = (PromptDialog) dialog;
                promptDialog.setMessage(this.mDialogMsg);
                if (!TextUtils.isEmpty(this.D)) {
                    promptDialog.setTitleText(formatCardNo(this.D));
                }
                promptDialog.setCanceledOnTouchOutside(false);
                promptDialog.setNegativeBtn(ResUtils.string(getActivity(), "ebpay_choose_credit_tip2"), new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.BindCardImplActivity.10
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ BindCardImplActivity a;

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
                        this.a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            StatisticManager.onEvent("clickSupportBankList");
                            WalletGlobalUtils.safeDismissDialog(this.a, 3);
                            this.a.a(false);
                        }
                    }
                });
                promptDialog.setPositiveBtn(ResUtils.string(getActivity(), "dxm_ebpay_confirm"), new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.BindCardImplActivity.11
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ BindCardImplActivity a;

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
                        this.a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            StatisticManager.onEvent("selectOtherPayTypeFromCard");
                            WalletGlobalUtils.safeDismissDialog(this.a, 3);
                        }
                    }
                });
            } else if (i2 == 12) {
                PromptDialog promptDialog2 = (PromptDialog) dialog;
                promptDialog2.setMessage(this.mDialogMsg);
                promptDialog2.setCanceledOnTouchOutside(false);
                promptDialog2.setPositiveBtn(ResUtils.string(getActivity(), "dxm_ebpay_know"), new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.BindCardImplActivity.16
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ BindCardImplActivity a;

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
                        this.a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            WalletGlobalUtils.safeDismissDialog(this.a, 12);
                        }
                    }
                });
                promptDialog2.hideNegativeButton();
            } else if (i2 == 33) {
                PromptDialog promptDialog3 = (PromptDialog) dialog;
                promptDialog3.setMessage(this.mDialogMsg);
                if (!this.f54260g && !TextUtils.isEmpty(this.D)) {
                    if (this.f54260g) {
                        promptDialog3.setTitleText(ResUtils.string(getActivity(), "dxm_ebpay_tip"));
                    } else {
                        promptDialog3.setTitleText(formatCardNo(this.D));
                    }
                }
                StatHelper.statServiceEvent(PayStatServiceEvent.BIND_CARD_CHECK_DIALOG, null, this.mDialogMsg);
                promptDialog3.setCanceledOnTouchOutside(false);
                String string = ResUtils.getString(getActivity(), this.f54260g ? "ebpay_choose_bind_sure" : "ebpay_choose_modify_card");
                String string2 = ResUtils.getString(getActivity(), this.f54260g ? "ebpay_choose_bind_continue" : "ebpay_choose_confirm");
                promptDialog3.setNegativeBtn(string, new View.OnClickListener(this, string) { // from class: com.baidu.wallet.paysdk.ui.BindCardImplActivity.13
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ String a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ BindCardImplActivity f54271b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, string};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f54271b = this;
                        this.a = string;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            StatHelper.statServiceEvent(PayStatServiceEvent.BIND_CARD_CHECK_DIALOG_MODIFY, null, this.a);
                            WalletGlobalUtils.safeDismissDialog(this.f54271b, 33);
                        }
                    }
                });
                promptDialog3.setPositiveBtn(string2, new View.OnClickListener(this, string2) { // from class: com.baidu.wallet.paysdk.ui.BindCardImplActivity.14
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ String a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ BindCardImplActivity f54272b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, string2};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f54272b = this;
                        this.a = string2;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            StatHelper.statServiceEvent("confirmCardNo", null, this.a);
                            WalletGlobalUtils.safeDismissDialog(this.f54272b, 33);
                            if (this.f54272b.f54259f != 100027) {
                                if (this.f54272b.f54259f == 100028) {
                                    this.f54272b.a(true);
                                    return;
                                }
                                return;
                            }
                            BindCardImplActivity bindCardImplActivity = this.f54272b;
                            bindCardImplActivity.a(bindCardImplActivity.f54257d);
                        }
                    }
                });
            } else if (i2 == 629128) {
                PromptDialog promptDialog4 = (PromptDialog) dialog;
                promptDialog4.setMessage(this.mDialogMsg);
                promptDialog4.setCanceledOnTouchOutside(false);
                promptDialog4.hideNegativeButton();
                promptDialog4.setPositiveBtn(ResUtils.string(getActivity(), "dxm_ebpay_know"), new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.BindCardImplActivity.15
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ BindCardImplActivity a;

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
                        this.a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            WalletGlobalUtils.safeDismissDialog(this.a, 629128);
                        }
                    }
                });
            } else if (i2 != 629130) {
                super.onPrepareDialog(i2, dialog);
            } else {
                PromptDialog promptDialog5 = (PromptDialog) dialog;
                promptDialog5.setCanceledOnTouchOutside(false);
                promptDialog5.setMessage(ResUtils.getString(this, "bd_wallet_auth_confirm_to_cancel"));
                promptDialog5.setNegativeBtn(ResUtils.string(this, "dxm_ebpay_cancel"), new View.OnClickListener(this, promptDialog5) { // from class: com.baidu.wallet.paysdk.ui.BindCardImplActivity.17
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ PromptDialog a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ BindCardImplActivity f54273b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, promptDialog5};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f54273b = this;
                        this.a = promptDialog5;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            this.a.dismiss();
                        }
                    }
                });
                promptDialog5.setPositiveBtn(ResUtils.string(this, "bd_wallet_auth_cancel_auth"), new View.OnClickListener(this, promptDialog5) { // from class: com.baidu.wallet.paysdk.ui.BindCardImplActivity.18
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ PromptDialog a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ BindCardImplActivity f54274b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, promptDialog5};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f54274b = this;
                        this.a = promptDialog5;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            this.f54274b.A();
                            this.a.dismiss();
                            PayCallBackManager.callBackClientCancel(this.f54274b, "BindCardImplActivity.onPrepareDialog().1");
                        }
                    }
                });
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.BindCardBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.beans.BeanActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onResume();
            if (this.isFromRestore) {
                this.isFromRestore = false;
                WalletGlobalUtils.safeDismissDialog(this.mAct, 3);
                WalletGlobalUtils.safeDismissDialog(this.mAct, 33);
                WalletGlobalUtils.safeDismissDialog(this.mAct, 12);
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.BindCardBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bundle) == null) {
            GetCardInfoResponse getCardInfoResponse = this.f54257d;
            if (getCardInfoResponse != null) {
                bundle.putSerializable("cacheResult", getCardInfoResponse);
            }
            GetCardInfoResponse getCardInfoResponse2 = this.u;
            if (getCardInfoResponse2 != null) {
                bundle.putSerializable("cardinforesponse", getCardInfoResponse2);
            }
            bundle.putBoolean("bindTipFromActivity", this.f54260g);
            bundle.putBoolean("is_first", this.f54258e);
            super.onSaveInstanceState(bundle);
        }
    }

    public void resetCardInfoState() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || getCurrentStep() == 0) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.l.getLayoutParams();
        layoutParams.bottomMargin = 0;
        this.l.setLayoutParams(layoutParams);
        this.mBindReq.setmBankInfo(null);
        this.mBindReq.setmBankCard("");
        this.F = null;
        this.E = "";
        this.f54256c = null;
        this.mBindCardController.b(null);
        this.l.setVisibility(8);
        this.f54264k.setVisibility(8);
        this.f54264k.hideCouponView();
        this.q.setVisibility(8);
        this.mBankCvv2InfoView.clearEditMsg();
        this.mBankCvv2InfoView.setVisibility(8);
        this.mBankCvv2InfoView.hideErrorLayout();
        this.mBankUserInfoView.clearEditMsg();
        this.mBankUserInfoView.setVisibility(8);
        this.mBankUserInfoView.hideErrorLayout();
        this.mBankUserInfoView.setMoblieFromNet(false);
        this.mBankUserInfoView.setIdCardFromNet(false);
        this.r.setVisibility(8);
        g();
        initSafeKeyBoard();
        this.mScrollView.invalidate();
        this.G = 0;
        changeCurrentStepInfo(this.mBindCardController.a(0)[0], 0);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.m.getLayoutParams();
        if (layoutParams2 == null) {
            layoutParams2 = new LinearLayout.LayoutParams(-1, 100);
        }
        layoutParams2.topMargin = 0;
        this.m.setLayoutParams(layoutParams2);
        this.m.setText(this.mBindCardController.a(0)[1]);
        this.m.setDrawableLeftVisible(true);
        this.mScrollView.setBackgroundColor(ResUtils.getColor(this.mAct, "dxm_wallet_base_whiteColor"));
    }

    public boolean runInHalfScreenMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.mRootView instanceof LinearLayout : invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.ui.c
    public void showBindCardDialog() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || this.isFromRestore) {
            return;
        }
        WalletGlobalUtils.safeShowDialog(this, 629128, "");
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity
    public void showPaySuccessPage(boolean z2, PayResultContent payResultContent, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{Boolean.valueOf(z2), payResultContent, Integer.valueOf(i2)}) == null) {
            if (z2) {
                PayController.getInstance().paySucess(this, payResultContent, i2);
            } else {
                PayController.getInstance().payPaying(this, payResultContent, i2);
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity
    public void triggerSmsVerify(ErrorContentResponse.Verify verify, boolean z2, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{verify, Boolean.valueOf(z2), str, Integer.valueOf(i2)}) == null) {
            StatHelper.statServiceEvent("triggleSmsPay");
            Intent intent = new Intent();
            intent.setClass(this, WalletSmsActivity.class);
            intent.putExtra(BeanConstants.SMS_ACTIVITY_FOR_COMPLETION_PAY, true);
            intent.putExtra(BeanConstants.SMS_ACTIVITY_FROM_KEY, 0);
            intent.putExtra(BeanConstants.KEY_SEND_SMS_AUTO, z2);
            intent.putExtra(BeanConstants.EXTRA_VERIFY_VOICE_DATA, verify);
            intent.putExtra(BeanConstants.KEY_SMS_HINT, str);
            intent.putExtra(BeanConstants.KEY_THE_REASON_FOR_SENDING, i2);
            PayRequestCache.BindCategory bindCategory = ((BindCardBaseActivity) this).a;
            if (bindCategory == null) {
                bindCategory = PayRequestCache.BindCategory.Other;
            }
            intent.putExtra("baidu.wallet.from", bindCategory.name());
            startActivityWithoutAnim(intent);
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity
    public void triggerSpeechVerify(ErrorContentResponse.Verify verify) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, verify) == null) {
            StatisticManager.onEvent("triggerSpeechVerify");
            Intent intent = new Intent();
            intent.setClass(this, VoiceVerifyActivity.class);
            intent.putExtra(BeanConstants.SMS_ACTIVITY_FOR_COMPLETION_PAY, true);
            intent.putExtra(BeanConstants.SMS_ACTIVITY_FROM_KEY, 0);
            intent.putExtra(BeanConstants.EXTRA_VERIFY_VOICE_DATA, verify);
            startActivityWithoutAnim(intent);
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.BindCardBaseActivity
    public void updateBankCouponDesc(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, charSequence) == null) {
            this.f54264k.setCouponDesc(charSequence);
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.BindCardBaseActivity
    public void updateBankTitleInfo(GetCardInfoResponse.CardInfo cardInfo, boolean z2) {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048601, this, cardInfo, z2) == null) {
            if (cardInfo != null) {
                this.f54264k.setVisibility(isShowWithHalfScreeen() ? 8 : 0);
                BankMsgInfoView bankMsgInfoView = this.f54264k;
                String str = cardInfo.bank_logourl;
                StringBuilder sb = new StringBuilder();
                sb.append(cardInfo.bank_name);
                sb.append(" ");
                if (cardInfo.card_type == 1) {
                    string = ResUtils.getString(getActivity(), "bd_wallet_credit");
                } else {
                    string = ResUtils.getString(getActivity(), "bd_wallet_debit");
                }
                sb.append(string);
                bankMsgInfoView.setBankInfo(str, sb.toString());
            } else if (isShowWithHalfScreeen()) {
                this.f54264k.setVisibility(8);
            } else {
                this.f54264k.setVisibility(z2 ? 8 : 4);
            }
            this.f54264k.invalidate();
            if (TextUtils.isEmpty(this.mBindCardController.c())) {
                this.q.setVisibility(8);
                return;
            }
            this.q.setVisibility(0);
            this.q.setText(this.mBindCardController.c());
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.BindCardBaseActivity
    public void updateBindCardProtocolFields(GetCardInfoResponse.ProtocolPlatformInfo protocolPlatformInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, protocolPlatformInfo) == null) {
            if (protocolPlatformInfo == null) {
                this.l.setVisibility(8);
                return;
            }
            this.l.setVisibility(0);
            CheckBox checkBox = (CheckBox) findViewById(ResUtils.id(getActivity(), "ebpay_protocol"));
            this.o = checkBox;
            if (checkBox != null) {
                checkBox.setChecked(protocolPlatformInfo.isProtocolCheckedDefault());
                this.o.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(this) { // from class: com.baidu.wallet.paysdk.ui.BindCardImplActivity.26
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ BindCardImplActivity a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = this;
                    }

                    @Override // android.widget.CompoundButton.OnCheckedChangeListener
                    public void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLZ(1048576, this, compoundButton, z2) == null) {
                            String[] strArr = new String[1];
                            strArr[0] = z2 ? "0" : "1";
                            StatHelper.statServiceEvent("clickAgreeBtn", null, strArr);
                            this.a.z();
                        }
                    }
                });
            }
            TextView textView = (TextView) findViewById(ResUtils.id(getActivity(), "ebpay_protocol_text"));
            if (textView != null && protocolPlatformInfo != null && !TextUtils.isEmpty(protocolPlatformInfo.prefix) && !TextUtils.isEmpty(protocolPlatformInfo.prefix)) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                int color = ResUtils.getColor(getActivity(), "wallet_base_font_868e9e");
                spannableStringBuilder.append((CharSequence) (protocolPlatformInfo.prefix + " "));
                spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, protocolPlatformInfo.prefix.length(), 33);
                spannableStringBuilder.append((CharSequence) "《");
                spannableStringBuilder.append((CharSequence) protocolPlatformInfo.main_title);
                spannableStringBuilder.append((CharSequence) "》");
                spannableStringBuilder.setSpan(new ClickableSpan(this, protocolPlatformInfo) { // from class: com.baidu.wallet.paysdk.ui.BindCardImplActivity.27
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ GetCardInfoResponse.ProtocolPlatformInfo a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ BindCardImplActivity f54286b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, protocolPlatformInfo};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f54286b = this;
                        this.a = protocolPlatformInfo;
                    }

                    @Override // android.text.style.ClickableSpan
                    public void onClick(View view) {
                        String str;
                        String obj;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            StatHelper.statServiceEvent("clickUserTerms");
                            Intent intent = new Intent(this.f54286b.getActivity(), BindCardProtocolActivity.class);
                            PayRequestCache.BindCategory bindCategory = ((BindCardBaseActivity) this.f54286b).a;
                            if (bindCategory == null) {
                                bindCategory = PayRequestCache.BindCategory.Other;
                            }
                            intent.putExtra("baidu.wallet.from", bindCategory.name());
                            intent.putExtra(BindCardProtocolActivity.PROTOCOL_SNAPSHOT_ID, this.a.snapshotId);
                            BankUserInfoView bankUserInfoView = this.f54286b.mBankUserInfoView;
                            if (bankUserInfoView != null) {
                                if (TextUtils.isEmpty(bankUserInfoView.getTrueNameText().getText())) {
                                    obj = PayDataCache.getInstance().getUserName();
                                } else {
                                    obj = this.f54286b.mBankUserInfoView.getTrueNameText().getText().toString();
                                }
                                intent.putExtra(BindCardProtocolActivity.TRUE_NAME, obj);
                                intent.putExtra("identity_code", this.f54286b.mBankUserInfoView.getIdEditText().getText().toString());
                                intent.putExtra("mobile", this.f54286b.mBankUserInfoView.getMobileEditText().getText().toString());
                            }
                            if (this.f54286b.F != null) {
                                if (!TextUtils.isEmpty(this.f54286b.F.type)) {
                                    str = this.f54286b.F.type;
                                } else {
                                    str = PayDataCache.getInstance().getCertificateType();
                                }
                                intent.putExtra(BindCardProtocolActivity.IDENTITY_TYPE, str);
                            }
                            intent.putExtra("card_no", this.f54286b.D);
                            this.f54286b.startActivityWithoutAnim(intent);
                        }
                    }

                    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                    public void updateDrawState(TextPaint textPaint) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                            textPaint.setColor(ResUtils.getColor(this.f54286b.getActivity(), "dxm_wallet_base_color_clickable"));
                        }
                    }
                }, protocolPlatformInfo.prefix.length(), spannableStringBuilder.length(), 33);
                textView.setEnabled(true);
                textView.setMovementMethod(LinkMovementMethod.getInstance());
                textView.setHintTextColor(-1);
                textView.setText(spannableStringBuilder);
                return;
            }
            CheckBox checkBox2 = this.o;
            if (checkBox2 != null) {
                checkBox2.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.BindCardBaseActivity
    public void updateCardElement(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048603, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5), Boolean.valueOf(z6)}) == null) {
            if (!z2 && !z3) {
                this.mBankCvv2InfoView.setVisibility(8);
            } else {
                this.mBankCvv2InfoView.setVisibility(0);
                this.mBankCvv2InfoView.hideArea(!z2, !z3);
            }
            if (!z4 && !z5 && !z6) {
                this.mBankUserInfoView.setVisibility(8);
            } else {
                this.mBankUserInfoView.setVisibility(0);
                this.mBankUserInfoView.hideArea(!z4, !z5, !z6);
            }
            this.mBankUserInfoView.setMobileInputAreaStatus(this.mBindCardController.u());
            GetCardInfoResponse.CertificateTypeInfo w = this.mBindCardController.w();
            this.F = w;
            this.mBankUserInfoView.updateCertificateType(w);
            this.mBankUserInfoView.setIdInputAreaStatus(this.mBindCardController.a(this.F));
            int x = this.mBindCardController.x();
            this.mBankUserInfoView.setCertificateCanClick(x > 1);
            if (x > 1) {
                this.mBankUserInfoView.setOnCodeTypeClickListener(new View.OnClickListener(this, z5, z2, z3, z4, z6) { // from class: com.baidu.wallet.paysdk.ui.BindCardImplActivity.20
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ boolean a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ boolean f54276b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ boolean f54277c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ boolean f54278d;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ boolean f54279e;

                    /* renamed from: f  reason: collision with root package name */
                    public final /* synthetic */ BindCardImplActivity f54280f;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Boolean.valueOf(z5), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z6)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f54280f = this;
                        this.a = z5;
                        this.f54276b = z2;
                        this.f54277c = z3;
                        this.f54278d = z4;
                        this.f54279e = z6;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            StatisticManager.onEvent("clickSwitchIdentityType");
                            if (this.f54280f.B() != null) {
                                BindCardImplActivity bindCardImplActivity = this.f54280f;
                                bindCardImplActivity.mScrollView.dismissKeyBoard((SafeKeyBoardEditText) bindCardImplActivity.B());
                            }
                            com.baidu.wallet.paysdk.ui.widget.b bVar = this.f54280f.mCertificateTypeDialog;
                            if (bVar != null) {
                                bVar.dismiss();
                            }
                            BindCardImplActivity bindCardImplActivity2 = this.f54280f;
                            bindCardImplActivity2.mCertificateTypeDialog = new com.baidu.wallet.paysdk.ui.widget.b(view, bindCardImplActivity2.a(bindCardImplActivity2.F, this.f54280f.mBindCardController.v()));
                            this.f54280f.mCertificateTypeDialog.a(new CertificateMenuView.b(this) { // from class: com.baidu.wallet.paysdk.ui.BindCardImplActivity.20.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass20 a;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.a = this;
                                }

                                @Override // com.baidu.wallet.paysdk.ui.widget.CertificateMenuView.b
                                public void a(GetCardInfoResponse.CertificateTypeInfo certificateTypeInfo) {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeL(1048576, this, certificateTypeInfo) == null) {
                                        this.a.f54280f.mCertificateTypeDialog.dismiss();
                                        this.a.f54280f.F = certificateTypeInfo;
                                        this.a.f54280f.mBindCardController.b(certificateTypeInfo);
                                        BindCardImplActivity bindCardImplActivity3 = this.a.f54280f;
                                        bindCardImplActivity3.mBankUserInfoView.setIdInputAreaStatus(bindCardImplActivity3.mBindCardController.a(bindCardImplActivity3.F), false);
                                        this.a.f54280f.mBankUserInfoView.updateCertificateType(certificateTypeInfo);
                                        AnonymousClass20 anonymousClass20 = this.a;
                                        if (anonymousClass20.a && anonymousClass20.f54280f.mBankUserInfoView.getIdEditText().isEnabled()) {
                                            SafeKeyBoardEditText idEditText = this.a.f54280f.mBankUserInfoView.getIdEditText();
                                            AnonymousClass20 anonymousClass202 = this.a;
                                            BindCardImplActivity bindCardImplActivity4 = anonymousClass202.f54280f;
                                            idEditText.initSafeKeyBoardParams(bindCardImplActivity4.mRootView, bindCardImplActivity4.mScrollView, bindCardImplActivity4.a(3, anonymousClass202.f54276b, anonymousClass202.f54277c, anonymousClass202.f54278d, anonymousClass202.a, anonymousClass202.f54279e), false);
                                        }
                                        this.a.f54280f.mBankUserInfoView.setIdTipRedColor(false);
                                        BindCardImplActivity bindCardImplActivity5 = this.a.f54280f;
                                        bindCardImplActivity5.a(bindCardImplActivity5.mBankUserInfoView.getIdEditText());
                                        this.a.f54280f.z();
                                    }
                                }
                            });
                            this.f54280f.mCertificateTypeDialog.show();
                        }
                    }
                });
            }
            changeCurrentStepInfo(this.mBindCardController.a(1)[0], 1);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.m.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-1, 100);
            }
            layoutParams.topMargin = this.mAct.getResources().getDimensionPixelSize(ResUtils.dimen(this.mAct, "ebpay_bind_card_info_below_height"));
            this.m.setLayoutParams(layoutParams);
            this.m.setText(this.mBindCardController.a(1)[1]);
            this.m.setDrawableLeftVisible(false);
            if (isShowWithHalfScreeen()) {
                this.m.setVisibility(8);
            }
            z();
            this.mScrollView.setBackgroundColor(ResUtils.getColor(this.mAct, "dxm_wallet_base_whiteColor"));
            new Handler().postDelayed(new Runnable(this, z2, z3, z4, z5, z6) { // from class: com.baidu.wallet.paysdk.ui.BindCardImplActivity.21
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ boolean a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ boolean f54281b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ boolean f54282c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ boolean f54283d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ boolean f54284e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ BindCardImplActivity f54285f;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5), Boolean.valueOf(z6)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f54285f = this;
                    this.a = z2;
                    this.f54281b = z3;
                    this.f54282c = z4;
                    this.f54283d = z5;
                    this.f54284e = z6;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f54285f.a(this.a, this.f54281b, this.f54282c, this.f54283d, this.f54284e);
                    }
                }
            }, 150L);
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.BindCardBaseActivity
    public void updateChangeCard() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048604, this) == null) && this.f54261h.getCardNoView().isEnabled()) {
            this.f54261h.getCardNoView().requestFocus();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.BindCardBaseActivity
    public void updateCvv2Info(boolean z2, boolean z3, boolean z4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048605, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4)}) == null) {
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.BindCardBaseActivity
    public void updateDiscountTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, str) == null) {
            this.f54262i.setTitle(str);
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.BindCardBaseActivity
    public void updateDiscountTxt(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, CharSequence charSequence5) {
        String displayName;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048607, this, charSequence, charSequence2, charSequence3, charSequence4, charSequence5) == null) {
            this.f54262i.setOrderPrice(charSequence5, charSequence2);
            this.f54262i.setDiscountInfoVisiable(true);
            this.f54262i.setCouponInfo(charSequence3, charSequence4, this);
            this.f54262i.setOrderInfo(charSequence);
            this.f54262i.setSpNameValue(PayDataCache.getInstance().getSpName());
            if (PayDataCache.getInstance().isRemotePay() || com.baidu.wallet.paysdk.a.b.c()) {
                if (!TextUtils.isEmpty(WalletLoginHelper.getInstance().getPassUserName())) {
                    displayName = WalletLoginHelper.getInstance().getPassUserName();
                } else {
                    displayName = PayDataCache.getInstance().getPayResponse().getDisplayName();
                }
                this.f54262i.setAccountInfo(displayName, null);
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.BindCardBaseActivity
    public void updateProtocolFields(GetCardInfoResponse.ProtocolInfo protocolInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, protocolInfo) == null) {
            if (protocolInfo == null) {
                this.l.setVisibility(8);
                return;
            }
            this.l.setVisibility(0);
            CheckBox checkBox = (CheckBox) findViewById(ResUtils.id(getActivity(), "ebpay_protocol"));
            this.o = checkBox;
            if (checkBox != null) {
                checkBox.setChecked(protocolInfo.isProtocolCheckedDefault());
                this.o.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(this) { // from class: com.baidu.wallet.paysdk.ui.BindCardImplActivity.28
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ BindCardImplActivity a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = this;
                    }

                    @Override // android.widget.CompoundButton.OnCheckedChangeListener
                    public void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLZ(1048576, this, compoundButton, z2) == null) {
                            String[] strArr = new String[1];
                            strArr[0] = z2 ? "0" : "1";
                            StatHelper.statServiceEvent("clickAgreeBtn", null, strArr);
                            this.a.z();
                        }
                    }
                });
            }
            TextView textView = (TextView) findViewById(ResUtils.id(getActivity(), "ebpay_protocol_text"));
            if (textView != null) {
                ArrayList arrayList = new ArrayList();
                GetCardInfoResponse.ProtocolItem[] protocolItemArr = protocolInfo.list;
                if (protocolItemArr != null) {
                    for (GetCardInfoResponse.ProtocolItem protocolItem : protocolItemArr) {
                        if (!TextUtils.isEmpty(protocolItem.title)) {
                            arrayList.add(protocolItem);
                        }
                    }
                }
                if (arrayList.size() > 0) {
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    int color = ResUtils.getColor(getActivity(), "wallet_base_font_868e9e");
                    spannableStringBuilder.append((CharSequence) (protocolInfo.prefix + " "));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, protocolInfo.prefix.length(), 33);
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        GetCardInfoResponse.ProtocolItem protocolItem2 = (GetCardInfoResponse.ProtocolItem) arrayList.get(i2);
                        if (i2 != 0) {
                            String str = protocolInfo.separator;
                            if (i2 == arrayList.size() - 1) {
                                str = protocolInfo.last_separator;
                            }
                            if (!TextUtils.isEmpty(str)) {
                                spannableStringBuilder.append((CharSequence) str);
                                spannableStringBuilder.setSpan(new ForegroundColorSpan(color), spannableStringBuilder.length() - str.length(), spannableStringBuilder.length(), 33);
                            }
                        }
                        spannableStringBuilder.append((CharSequence) protocolItem2.title);
                        if (!TextUtils.isEmpty(protocolItem2.url)) {
                            spannableStringBuilder.setSpan(new ClickableSpan(this, protocolItem2.url, protocolItem2.title.replaceAll("<|>|《|》", "")) { // from class: com.baidu.wallet.paysdk.ui.BindCardImplActivity.29
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ String a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ String f54287b;

                                /* renamed from: c  reason: collision with root package name */
                                public final /* synthetic */ BindCardImplActivity f54288c;

                                {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, r7, r8};
                                        interceptable2.invokeUnInit(65536, newInitContext);
                                        int i3 = newInitContext.flag;
                                        if ((i3 & 1) != 0) {
                                            int i4 = i3 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable2.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.f54288c = this;
                                    this.a = r7;
                                    this.f54287b = r8;
                                }

                                @Override // android.text.style.ClickableSpan
                                public void onClick(View view) {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                                        StatisticManager.onEvent("clickUserTerms");
                                        Intent intent = new Intent(this.f54288c.getActivity(), WebViewActivity.class);
                                        intent.putExtra("jump_url", this.a);
                                        intent.putExtra("webview_title_string", this.f54287b);
                                        this.f54288c.startActivity(intent);
                                    }
                                }

                                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                                public void updateDrawState(TextPaint textPaint) {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                                        textPaint.setColor(ResUtils.getColor(this.f54288c.getActivity(), "dxm_wallet_base_color_clickable"));
                                    }
                                }
                            }, spannableStringBuilder.length() - protocolItem2.title.length(), spannableStringBuilder.length(), 33);
                        } else {
                            spannableStringBuilder.setSpan(new ForegroundColorSpan(color), spannableStringBuilder.length() - protocolItem2.title.length(), spannableStringBuilder.length(), 33);
                        }
                    }
                    textView.setEnabled(true);
                    textView.setMovementMethod(LinkMovementMethod.getInstance());
                    if (!TextUtils.isEmpty(protocolInfo.suffix)) {
                        spannableStringBuilder.append((CharSequence) protocolInfo.suffix);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(color), spannableStringBuilder.length() - protocolInfo.suffix.length(), spannableStringBuilder.length(), 33);
                    }
                    textView.setText(spannableStringBuilder);
                    return;
                }
                textView.setVisibility(8);
                CheckBox checkBox2 = this.o;
                if (checkBox2 != null) {
                    checkBox2.setVisibility(8);
                    return;
                }
                return;
            }
            CheckBox checkBox3 = this.o;
            if (checkBox3 != null) {
                checkBox3.setVisibility(8);
            }
        }
    }

    public void updateUiMode(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, intent) == null) {
            onNewIntent(intent);
        }
    }

    private void b() {
        BindFastRequest bindFastRequest;
        CardData.BondCard bondCard;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65566, this) == null) || (bindFastRequest = this.mBindReq) == null || (bondCard = bindFastRequest.mBondCard) == null) {
            return;
        }
        bindFastRequest.mBankNo = bondCard.bank_code;
        this.mBindCardController.a();
    }

    private void c() {
        Pair<Integer, Object> checkSecurityEvn;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65570, this) == null) && (checkSecurityEvn = BaiduWalletDelegate.getInstance().checkSecurityEvn()) != null && ((Integer) checkSecurityEvn.first).intValue() == 0) {
            Object obj = checkSecurityEvn.second;
            String str = null;
            if (obj != null && (obj instanceof String)) {
                str = (String) obj;
            }
            if (this.mBindReq == null || TextUtils.isEmpty(str)) {
                return;
            }
            this.mBindReq.mSecurityParams = Base64.encodeBytes(str.getBytes());
        }
    }

    private b d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65572, this)) == null) {
            b bVar = new b();
            BankCvv2InfoView bankCvv2InfoView = this.mBankCvv2InfoView;
            if (bankCvv2InfoView != null) {
                bVar.f54295b = bankCvv2InfoView.getCvv2InputView().getEditableText().toString();
                bVar.f54296c = this.mBankCvv2InfoView.getDateInputView().getEditableText().toString();
            }
            BankUserInfoView bankUserInfoView = this.mBankUserInfoView;
            if (bankUserInfoView != null) {
                bVar.a = bankUserInfoView.getTrueNameText().getEditableText().toString();
                bVar.f54297d = this.mBankUserInfoView.getIdEditText().getEditableText().toString();
                bVar.f54298e = this.mBankUserInfoView.getMobileEditText().getEditableText().toString();
            }
            return bVar;
        }
        return (b) invokeV.objValue;
    }

    private void e() {
        CardData.BondCard bondCard;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65574, this) == null) {
            if (this.mBindCardController.g()) {
                this.f54261h.setTrueName(this.mBindCardController.h());
            } else {
                this.f54261h.setTrueName("");
            }
            this.f54261h.setBindcardTip(this.mBindCardController.D());
            this.f54262i.setDiscountInfoVisiable(this.mBindCardController.e());
            this.p.setVisibility(this.mBindCardController.b() ? 0 : 8);
            ArrayList<CharSequence> z2 = this.mBindCardController.z();
            if (z2 != null && z2.size() > 0) {
                this.p.setTitleVisiable(true);
                this.p.setImageSrcId(ResUtils.drawable(getActivity(), "wallet_base_bind_card_pic"));
                if (z2.size() >= 1) {
                    this.p.setTitle(z2.get(0));
                }
                if (z2.size() >= 2) {
                    this.p.setSubTitle(z2.get(1));
                } else {
                    this.p.setSubTitleVisibility(8);
                }
            } else {
                this.p.setTitleVisiable(false);
            }
            if (this.mBindCardController.d()) {
                this.f54262i.setVisibility(0);
                a(this.f54262i, this.t);
                if (!com.baidu.wallet.paysdk.a.b.a() && PayDataCache.getInstance().hasCanAmount()) {
                    this.mDialogMsg = ResUtils.getString(getActivity(), "ebpay_complete_tip8");
                    if (this.x && (aVar = this.y) != null) {
                        aVar.postDelayed(new Runnable(this) { // from class: com.baidu.wallet.paysdk.ui.BindCardImplActivity.23
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ BindCardImplActivity a;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.a = this;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    this.a.y.obtainMessage(0).sendToTarget();
                                }
                            }
                        }, IMLikeRequest.TIME_INTERVAL);
                    } else {
                        showBindCardDialog();
                    }
                }
            } else {
                this.f54262i.setVisibility(8);
            }
            if (this.mBindCardController.i()) {
                this.f54263j.setVisibility(0);
                this.f54263j.refreshView();
            } else {
                this.f54263j.setVisibility(8);
            }
            boolean q = this.mBindCardController.q();
            if (q) {
                this.f54261h.getCardNoView().setEnabled(true);
                this.f54261h.getCardNoView().setFormatEnable(true);
                this.f54261h.getCardNoView().requestFocus();
            } else {
                this.f54261h.getCardNoView().setEnabled(false);
                this.f54261h.getCardNoView().setFormatEnable(false);
                this.f54261h.getClearView().setVisibility(8);
            }
            if (q) {
                this.f54261h.getCardNoView().setMyHint(this.mBindCardController.p(), "ebpay_bind_card_edittext_hint_txt_size");
            } else {
                this.f54261h.getCardNoView().setMyHint(this.mBindCardController.p(), "dxm_wallet_base_level18Font");
                this.f54261h.getCardNoView().setHintTextColor(ResUtils.getColor(this.mAct, "dxm_wallet_base_font_text3Color"));
            }
            BindFastRequest bindFastRequest = this.mBindReq;
            if (bindFastRequest != null && bindFastRequest.getmBondCard() != null && !TextUtils.isEmpty(this.mBindReq.getmBondCard().card_required_msg)) {
                com.baidu.wallet.paysdk.ui.widget.a.a(this.B, this.mBindReq.getmBondCard().card_required_msg, null, null);
            } else {
                BindFastRequest bindFastRequest2 = this.mBindReq;
                if (bindFastRequest2 != null && (bondCard = bindFastRequest2.mBondCard) != null && bondCard.bank_code != null) {
                    com.baidu.wallet.paysdk.ui.widget.a.a(this.B, "请完善", bondCard.getCardDesc(this.mAct, false), "的信息后继续支付");
                } else {
                    com.baidu.wallet.paysdk.ui.widget.a.a(this.B, ResUtils.getString(this.mAct, "ebpay_title_complete_fixmsg"), null, null);
                }
            }
            findViewById(ResUtils.id(this.mAct, "wallet_bind_card_subtitle")).setVisibility(this.mBindCardController.t() ? 0 : 8);
            if (this.mBindCardController.d()) {
                this.mBindCardController.o();
            }
            g();
            BindFastRequest bindFastRequest3 = this.mBindReq;
            if (bindFastRequest3 != null && bindFastRequest3.getmBankInfo() != null) {
                this.mBindCardController.a();
            }
            if (this.mBindCardController.s()) {
                loadCvv2();
            }
            BindFastRequest bindFastRequest4 = this.mBindReq;
            if (bindFastRequest4 == null || !bindFastRequest4.isNotPayBindCard() || CardAddResponse.getInstance().intelligent_service == null) {
                return;
            }
            com.baidu.wallet.paysdk.ui.b.a(this.mAct, this.bdActionBar, CardAddResponse.getInstance().intelligent_service.customer_service_url, CardAddResponse.getInstance().intelligent_service.customer_service_icon, CardAddResponse.getInstance().intelligent_service.customer_service_copy, "CSTM_SVC_cardAdd");
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65575, this) == null) {
            addContentView(ResUtils.layout(getActivity(), isShowWithHalfScreeen() ? "wallet_cashdesk_bind_card_view_half_screen" : "wallet_cashdesk_bind_card_view"));
            this.t = (LinearLayout) findViewById(ResUtils.id(getActivity(), "ebpay_parent_bindcard"));
            this.s = (LinearLayout) findViewById(ResUtils.id(getActivity(), "bindcard_root_view"));
            this.q = (TextView) findViewById(ResUtils.id(getActivity(), "bindcard_onecentsdecs"));
            BankCardInfoView bankCardInfoView = (BankCardInfoView) findViewById(ResUtils.id(getActivity(), "bindcard_cardinfo"));
            this.f54261h = bankCardInfoView;
            bankCardInfoView.configDetectCardNum(this.C);
            this.f54262i = (OrderConfirmation) findViewById(ResUtils.id(getActivity(), "bindcard_amount"));
            this.f54263j = (AuthorizeInfoView) findViewById(ResUtils.id(getActivity(), "auth_info_view"));
            this.f54264k = (BankMsgInfoView) findViewById(ResUtils.id(getActivity(), "bindcard_msginfo"));
            this.mBankCvv2InfoView = (BankCvv2InfoView) findViewById(ResUtils.id(getActivity(), "bindcard_cvv2info"));
            BankUserInfoView bankUserInfoView = (BankUserInfoView) findViewById(ResUtils.id(getActivity(), "bindcard_userinfo"));
            this.mBankUserInfoView = bankUserInfoView;
            bankUserInfoView.getMobileEditText().setFormatEnable(false);
            this.mBankUserInfoView.getIdEditText().setUseSafeKeyBoard(true);
            this.mBankUserInfoView.getIdEditText().setUseKeyX(true);
            this.m = (WalletBaseButtonWithImage) findViewById(ResUtils.id(getActivity(), "next_btn"));
            TextView textView = (TextView) findViewById(ResUtils.id(getActivity(), "lv_skip_text_view"));
            this.r = textView;
            textView.setVisibility(8);
            this.n = (TextView) findViewById(ResUtils.id(getActivity(), "authorize_fee_tip"));
            this.l = (LinearLayout) findViewById(ResUtils.id(getActivity(), "protocol_display_area"));
            this.p = (BindCardHeadView) findViewById(ResUtils.id(getActivity(), "bindcard_pic"));
            if (!isShowWithHalfScreeen()) {
                findViewById(ResUtils.id(this.mAct, "card_area_top_margin")).setVisibility(this.mBindCardController.F() ? 4 : 8);
            }
            this.m.setEnabled(false);
            this.m.setOnClickListener(this);
            changeCurrentStepInfo(this.mBindCardController.a(0)[0], 0);
            this.m.setText(this.mBindCardController.a(0)[1]);
            this.mScrollView.setKeyBoardStatusChangeListener(new SafeScrollView.onKeyBoardStatusChangeListener(this) { // from class: com.baidu.wallet.paysdk.ui.BindCardImplActivity.30
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BindCardImplActivity a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.dxmpay.wallet.base.widget.SafeScrollView.onKeyBoardStatusChangeListener
                public void onKeyBoardStatusChange(boolean z2, int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) {
                        String str = "安全键盘的状态" + z2;
                        if (z2) {
                            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.a.l.getLayoutParams();
                            if (this.a.G - i2 >= 0) {
                                layoutParams.bottomMargin = this.a.G - i2;
                            } else {
                                layoutParams.bottomMargin = 0;
                            }
                            this.a.l.setLayoutParams(layoutParams);
                            this.a.s.postInvalidate();
                            return;
                        }
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.a.l.getLayoutParams();
                        layoutParams2.bottomMargin = this.a.G;
                        this.a.l.setLayoutParams(layoutParams2);
                    }
                }
            });
            View.OnClickListener onClickListener = new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.BindCardImplActivity.31
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BindCardImplActivity a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.a.onBackPressed();
                    }
                }
            };
            this.f54262i.getBackButton().setOnClickListener(onClickListener);
            if (isShowWithHalfScreeen()) {
                findViewById(ResUtils.id(getActivity(), "action_bar_left_img")).setOnClickListener(onClickListener);
                SafeKeyBoardUtil safeKeyBoardUtil = new SafeKeyBoardUtil();
                safeKeyBoardUtil.setState(SafeKeyBoardUtil.SafeKeyBoardState.CONFRIM_STATE);
                this.mScrollView.setSafeKeyBoardUtil(safeKeyBoardUtil);
                this.mScrollView.setAlwaysShowSoftKeyBoard(true);
                this.m.setVisibility(8);
            } else {
                int bindCardCause = getBindCardCause();
                View findViewById = findViewById(ResUtils.id(this.mAct, "bind_card_head_block"));
                if (1 != bindCardCause && 2 != bindCardCause) {
                    findViewById.setVisibility(8);
                } else {
                    findViewById.setVisibility(0);
                }
            }
            this.B = (ViewGroup) findViewById(ResUtils.id(this.mAct, "wallet_bind_card_subtitle"));
            if (Build.VERSION.SDK_INT >= 19) {
                OrderConfirmation orderConfirmation = this.f54262i;
                orderConfirmation.setPadding(orderConfirmation.getPaddingLeft(), StatusBarUtils.getStatusBarHeight(this.mAct), this.f54262i.getPaddingRight(), this.f54262i.getPaddingBottom());
            }
            s();
            h();
            i();
        }
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65578, this) == null) || !com.baidu.wallet.paysdk.a.b.a() || PayDataCache.getInstance().hasBondCards() || PayDataCache.getInstance().getPayResponse() == null || PayDataCache.getInstance().getPayResponse().authorize == null) {
            return;
        }
        Authorize authorize = PayDataCache.getInstance().getPayResponse().authorize;
        if (authorize.agreement_info != null) {
            updateProtocolFields(PayDataCache.getInstance().getPayResponse().authorize.agreement_info);
        }
        Authorize.Extra extra = authorize.extra;
        if (extra != null && !TextUtils.isEmpty(extra.fee_tip)) {
            this.n.setVisibility(0);
            this.n.setText(authorize.extra.fee_tip);
            return;
        }
        this.n.setVisibility(8);
    }

    private void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65579, this) == null) {
            this.mBankUserInfoView.getTrueNameText().addTextChangedListener(new TextWatcher(this) { // from class: com.baidu.wallet.paysdk.ui.BindCardImplActivity.32
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BindCardImplActivity a;

                /* renamed from: b  reason: collision with root package name */
                public boolean f54290b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                    this.f54290b = false;
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, editable) == null) {
                        this.a.mBankUserInfoView.setTrueNameRedColor(false);
                        BankUserInfoView bankUserInfoView = this.a.mBankUserInfoView;
                        bankUserInfoView.hideErrorLayoutWithTag(bankUserInfoView.getTrueNameText(), this.a.mBankUserInfoView.getTrueNameText() == this.a.f54256c);
                        if (!this.f54290b) {
                            StatisticManager.onEvent("clickInputTrueName");
                            this.f54290b = true;
                        }
                        this.a.z();
                        BindCardImplActivity bindCardImplActivity = this.a;
                        bindCardImplActivity.a((TextView) bindCardImplActivity.mBankUserInfoView.getTrueNameText(), this.a.mBankUserInfoView.getNameTip());
                    }
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2, i3, i4) == null) {
                    }
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) {
                    }
                }
            });
            this.mBankUserInfoView.getTrueNameText().setOnMyFocusChangeListener(this);
            this.mBankUserInfoView.getIdEditText().addTextChangedListener(new TextWatcher(this) { // from class: com.baidu.wallet.paysdk.ui.BindCardImplActivity.33
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BindCardImplActivity a;

                /* renamed from: b  reason: collision with root package name */
                public boolean f54291b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                    this.f54291b = false;
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, editable) == null) {
                        if (this.a.mBankUserInfoView.getIdCardFromNet()) {
                            this.a.mBankUserInfoView.setIdCardFromNet(false);
                            this.a.mBankUserInfoView.getIdEditText().setText("");
                        }
                        this.a.mBankUserInfoView.setIdTipRedColor(false);
                        BankUserInfoView bankUserInfoView = this.a.mBankUserInfoView;
                        bankUserInfoView.hideErrorLayoutWithTag(bankUserInfoView.getIdEditText(), this.a.mBankUserInfoView.getIdEditText() == this.a.f54256c);
                        if (!this.f54291b) {
                            StatisticManager.onEvent("clickInputIdCard");
                            this.f54291b = true;
                        }
                        this.a.z();
                        BindCardImplActivity bindCardImplActivity = this.a;
                        bindCardImplActivity.a((TextView) bindCardImplActivity.mBankUserInfoView.getIdEditText(), this.a.mBankUserInfoView.getIdTip());
                    }
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2, i3, i4) == null) {
                    }
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) {
                    }
                }
            });
            this.mBankUserInfoView.getIdEditText().setOnMyFocusChangeListener(this);
            this.mBankUserInfoView.getMobileEditText().addTextChangedListener(new TextWatcher(this) { // from class: com.baidu.wallet.paysdk.ui.BindCardImplActivity.34
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BindCardImplActivity a;

                /* renamed from: b  reason: collision with root package name */
                public boolean f54292b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                    this.f54292b = false;
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, editable) == null) {
                        if (this.a.mBankUserInfoView.getMobileFromNet()) {
                            this.a.mBankUserInfoView.setMoblieFromNet(false);
                            this.a.mBankUserInfoView.getMobileEditText().setText("");
                        }
                        this.a.mBankUserInfoView.setMobileRedColor(false);
                        BankUserInfoView bankUserInfoView = this.a.mBankUserInfoView;
                        bankUserInfoView.hideErrorLayoutWithTag(bankUserInfoView.getMobileEditText(), this.a.mBankUserInfoView.getMobileEditText() == this.a.f54256c);
                        if (!this.f54292b) {
                            StatisticManager.onEvent("clickInputMobileNo");
                            this.f54292b = true;
                        }
                        this.a.z();
                        BindCardImplActivity bindCardImplActivity = this.a;
                        bindCardImplActivity.a((TextView) bindCardImplActivity.mBankUserInfoView.getMobileEditText(), this.a.mBankUserInfoView.getMobileTip());
                    }
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2, i3, i4) == null) {
                    }
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) {
                    }
                }
            });
            this.mBankUserInfoView.getMobileEditText().setOnMyFocusChangeListener(this);
            a((TextView) this.mBankUserInfoView.getTrueNameText(), this.mBankUserInfoView.getNameTip());
            a((TextView) this.mBankUserInfoView.getIdEditText(), this.mBankUserInfoView.getIdTip());
            a((TextView) this.mBankUserInfoView.getMobileEditText(), this.mBankUserInfoView.getMobileTip());
        }
    }

    private void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65582, this) == null) {
            this.mBankCvv2InfoView.getDateInputView().addTextChangedListener(new TextWatcher(this) { // from class: com.baidu.wallet.paysdk.ui.BindCardImplActivity.35
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public boolean a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ BindCardImplActivity f54293b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f54293b = this;
                    this.a = false;
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, editable) == null) {
                        this.f54293b.mBankCvv2InfoView.setValidDateRedColor(false);
                        BankCvv2InfoView bankCvv2InfoView = this.f54293b.mBankCvv2InfoView;
                        bankCvv2InfoView.hideErrorLayoutWithTag(bankCvv2InfoView.getDateInputView(), this.f54293b.mBankCvv2InfoView.getDateInputView() == this.f54293b.f54256c);
                        if (!this.a) {
                            StatisticManager.onEvent("clickInputDate");
                            this.a = true;
                        }
                        String obj = this.f54293b.mBankCvv2InfoView.getDateInputView().getText().toString();
                        if (this.f54293b.w.toString().equals(obj)) {
                            this.f54293b.z();
                            BindCardImplActivity bindCardImplActivity = this.f54293b;
                            bindCardImplActivity.a((TextView) bindCardImplActivity.mBankCvv2InfoView.getDateInputView(), this.f54293b.mBankCvv2InfoView.getDateTip());
                            if (this.f54293b.mBankCvv2InfoView.getDateInputView().getText().toString().length() == 5) {
                                BindCardImplActivity bindCardImplActivity2 = this.f54293b;
                                bindCardImplActivity2.a((View) bindCardImplActivity2.mBankCvv2InfoView.getDateInputView(), 0, true);
                                return;
                            }
                            return;
                        }
                        this.f54293b.w.delete(0, this.f54293b.w.length());
                        this.f54293b.w.append(obj.replace("/", ""));
                        if (this.f54293b.w.length() > 2) {
                            this.f54293b.w.insert(2, "/");
                        }
                        this.f54293b.mBankCvv2InfoView.getDateInputView().setText(this.f54293b.w);
                        this.f54293b.mBankCvv2InfoView.getDateInputView().setSelection(this.f54293b.w.length());
                        this.f54293b.z();
                    }
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2, i3, i4) == null) {
                    }
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) {
                    }
                }
            });
            this.mBankCvv2InfoView.getDateInputView().setOnMyFocusChangeListener(this);
            this.mBankCvv2InfoView.getCvv2InputView().addTextChangedListener(new TextWatcher(this) { // from class: com.baidu.wallet.paysdk.ui.BindCardImplActivity.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public boolean a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ BindCardImplActivity f54275b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f54275b = this;
                    this.a = false;
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, editable) == null) {
                        this.f54275b.mBankCvv2InfoView.setCNN2RedColor(false);
                        BankCvv2InfoView bankCvv2InfoView = this.f54275b.mBankCvv2InfoView;
                        bankCvv2InfoView.hideErrorLayoutWithTag(bankCvv2InfoView.getCvv2InputView(), this.f54275b.mBankCvv2InfoView.getCvv2InputView() == this.f54275b.f54256c);
                        if (!this.a) {
                            StatisticManager.onEvent("clickInputCvv");
                            this.a = true;
                        }
                        this.f54275b.z();
                        BindCardImplActivity bindCardImplActivity = this.f54275b;
                        bindCardImplActivity.a((TextView) bindCardImplActivity.mBankCvv2InfoView.getCvv2InputView(), this.f54275b.mBankCvv2InfoView.getCvv2Tip());
                        if (this.f54275b.mBankCvv2InfoView.getCvv2InputView().getText().toString().length() == 3) {
                            BindCardImplActivity bindCardImplActivity2 = this.f54275b;
                            bindCardImplActivity2.a((View) bindCardImplActivity2.mBankCvv2InfoView.getCvv2InputView(), 1, true);
                        }
                    }
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2, i3, i4) == null) {
                    }
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) {
                    }
                }
            });
            this.mBankCvv2InfoView.getCvv2InputView().setOnMyFocusChangeListener(this);
            a((TextView) this.mBankCvv2InfoView.getCvv2InputView(), this.mBankCvv2InfoView.getCvv2Tip());
            a((TextView) this.mBankCvv2InfoView.getDateInputView(), this.mBankCvv2InfoView.getDateTip());
        }
    }

    private boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65584, this)) == null) {
            return (this.f54261h.getCardNoView().getVisibility() == 0 && this.f54261h.getCardNoView().isEnabled() && this.f54261h.getCardNoView().getRealText().length() < 10) ? false : true;
        }
        return invokeV.booleanValue;
    }

    private boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65586, this)) == null) ? (m() || n() || o()) ? false : true : invokeV.booleanValue;
    }

    private boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65588, this)) == null) ? (r() || p()) ? false : true : invokeV.booleanValue;
    }

    private boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65590, this)) == null) ? this.mBindCardController.j() && this.mBankUserInfoView.getTrueNameText().isEnabled() && this.mBankUserInfoView.getTrueNameText().getText().toString().trim().length() < 2 : invokeV.booleanValue;
    }

    private boolean n() {
        InterceptResult invokeV;
        GetCardInfoResponse.CertificateTypeInfo certificateTypeInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65592, this)) == null) {
            if (!this.mBindCardController.m() || !this.mBankUserInfoView.getIdEditText().isEnabled() || this.mBankUserInfoView.getIdCardFromNet() || (certificateTypeInfo = this.F) == null) {
                return false;
            }
            return !certificateTypeInfo.getValidator().a(this.mBankUserInfoView.getIdEditText().getText());
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65567, this, view, view2) == null) {
            view.setDrawingCacheEnabled(true);
            Bitmap drawingCache = view.getDrawingCache();
            view2.setDrawingCacheEnabled(true);
            Bitmap drawingCache2 = view2.getDrawingCache();
            ImageView imageView = new ImageView(this);
            imageView.setImageBitmap(drawingCache);
            ImageView imageView2 = new ImageView(this);
            imageView2.setImageBitmap(drawingCache2);
            this.f54255b.addView(imageView, new LinearLayout.LayoutParams(-1, -2));
            this.f54255b.addView(imageView2, new LinearLayout.LayoutParams(-1, -2));
            this.y.post(new Runnable(this, imageView, imageView2) { // from class: com.baidu.wallet.paysdk.ui.BindCardImplActivity.12
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ImageView a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ ImageView f54267b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ BindCardImplActivity f54268c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, imageView, imageView2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f54268c = this;
                    this.a = imageView;
                    this.f54267b = imageView2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ViewGroup viewGroup = (ViewGroup) this.a.getParent();
                        viewGroup.getTop();
                        viewGroup.getBottom();
                        int bottom = this.a.getBottom();
                        int height = viewGroup.getHeight() - this.f54267b.getTop();
                        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
                        ofFloat.setDuration(500L).setInterpolator(new LinearInterpolator());
                        ofFloat.start();
                        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this, bottom, height) { // from class: com.baidu.wallet.paysdk.ui.BindCardImplActivity.12.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ int a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ int f54269b;

                            /* renamed from: c  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass12 f54270c;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, Integer.valueOf(bottom), Integer.valueOf(height)};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f54270c = this;
                                this.a = bottom;
                                this.f54269b = height;
                            }

                            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeL(1048576, this, valueAnimator) == null) {
                                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                                    ViewHelper.setTranslationY(this.f54270c.a, (-this.a) * floatValue);
                                    ViewHelper.setTranslationY(this.f54270c.f54267b, this.f54269b * floatValue);
                                    if (floatValue <= 0.0f) {
                                        this.f54270c.f54268c.initSafeKeyBoard();
                                        this.f54270c.f54268c.f54255b.setVisibility(8);
                                        this.f54270c.f54268c.f54261h.getCardNoView().clearFocus();
                                        this.f54270c.f54268c.f54261h.getCardNoView().requestFocus();
                                    }
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            f();
            e();
            if (!this.x) {
                initSafeKeyBoard();
            }
            if ((this.mBindCardController instanceof g) && !this.f54261h.getCardNoView().isEnabled() && getCurrentStep() == 0) {
                this.mScrollView.setBackgroundColor(ResUtils.getColor(this.mAct, "dxm_wallet_base_whiteColor"));
                b();
            }
        }
    }

    private void b(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65568, this, str) == null) || this.E.equals(str)) {
            return;
        }
        this.E = str;
        updateBankTitleInfo(null, false);
        this.mBindCardController.a(str);
    }

    private void a(View view, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, this, view, view2) == null) {
            this.x = true;
            this.y = new a(this);
            LinearLayout linearLayout = new LinearLayout(this);
            this.f54255b = linearLayout;
            linearLayout.setOrientation(1);
            this.f54255b.setBackgroundResource(ResUtils.color(this, "dxm_wallet_base_window_bg"));
            ((ViewGroup) findViewById(16908290)).addView(this.f54255b, new FrameLayout.LayoutParams(-1, -1));
            this.y.post(new Runnable(this, view, view2) { // from class: com.baidu.wallet.paysdk.ui.BindCardImplActivity.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ View a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ View f54265b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ BindCardImplActivity f54266c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, view, view2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f54266c = this;
                    this.a = view;
                    this.f54265b = view2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f54266c.b(this.a, this.f54265b);
                    }
                }
            });
        }
    }

    private void a(b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65552, this, bVar) == null) || bVar == null) {
            return;
        }
        BankCvv2InfoView bankCvv2InfoView = this.mBankCvv2InfoView;
        if (bankCvv2InfoView != null) {
            bankCvv2InfoView.getCvv2InputView().setText(bVar.f54295b);
            this.mBankCvv2InfoView.getDateInputView().setText(bVar.f54296c);
        }
        BankUserInfoView bankUserInfoView = this.mBankUserInfoView;
        if (bankUserInfoView != null) {
            bankUserInfoView.getTrueNameText().setText(bVar.a);
            this.mBankUserInfoView.getIdEditText().setText(bVar.f54297d);
            this.mBankUserInfoView.getMobileEditText().setText(bVar.f54298e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TextView textView, ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65550, this, textView, imageView) == null) {
            imageView.setVisibility(0);
            if (textView.getText().toString().length() == 0) {
                imageView.setImageResource(ResUtils.drawable(getActivity(), "wallet_base_info_btn_selector"));
                AccessibilityUtils.setContentDescription(imageView, "预留手机号说明");
                imageView.setOnClickListener(this);
                if (imageView == this.mBankUserInfoView.getIdTip()) {
                    imageView.setVisibility(4);
                }
            } else if (textView.isEnabled()) {
                imageView.setImageResource(ResUtils.drawable(getActivity(), "dxm_wallet_base_delete"));
                AccessibilityUtils.setContentDescription(imageView, "清除");
                imageView.setOnClickListener(new View.OnClickListener(this, textView) { // from class: com.baidu.wallet.paysdk.ui.BindCardImplActivity.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ TextView a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ BindCardImplActivity f54289b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, textView};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f54289b = this;
                        this.a = textView;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            this.a.setText("");
                            this.a.requestFocus();
                        }
                    }
                });
            } else {
                imageView.setImageResource(ResUtils.drawable(getActivity(), "wallet_base_info_btn_selector"));
                AccessibilityUtils.setContentDescription(imageView, "预留手机号说明");
                imageView.setOnClickListener(this);
                if (imageView == this.mBankUserInfoView.getIdTip()) {
                    imageView.setVisibility(4);
                }
            }
        }
    }

    private void a(View view, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65549, this, view, z2) == null) {
            if (view == this.mBankCvv2InfoView.getCvv2InputView()) {
                int length = ((SafeKeyBoardEditText) view).getText().toString().length();
                if (!z2) {
                    this.mBankCvv2InfoView.getCvv2Tip().setImageResource(ResUtils.drawable(getActivity(), "wallet_base_info_btn_selector"));
                    this.mBankCvv2InfoView.getCvv2Tip().setOnClickListener(this);
                    return;
                }
                this.mBankCvv2InfoView.hideErrorLayoutWithTag(view, true);
                if (length == 0) {
                    this.mBankCvv2InfoView.getCvv2Tip().setImageResource(ResUtils.drawable(getActivity(), "wallet_base_info_btn_selector"));
                    this.mBankCvv2InfoView.getCvv2Tip().setOnClickListener(this);
                    return;
                }
                this.mBankCvv2InfoView.getCvv2Tip().setImageResource(ResUtils.drawable(getActivity(), "dxm_wallet_base_delete"));
                this.mBankCvv2InfoView.getCvv2Tip().setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.BindCardImplActivity.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ BindCardImplActivity a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                            this.a.mBankCvv2InfoView.getCvv2InputView().setText("");
                            this.a.mBankCvv2InfoView.getCvv2InputView().requestFocus();
                        }
                    }
                });
            } else if (view == this.mBankCvv2InfoView.getDateInputView()) {
                int length2 = ((SafeKeyBoardEditText) view).getText().toString().length();
                if (!z2) {
                    this.mBankCvv2InfoView.getDateTip().setImageResource(ResUtils.drawable(getActivity(), "wallet_base_info_btn_selector"));
                    this.mBankCvv2InfoView.getDateTip().setOnClickListener(this);
                    return;
                }
                this.mBankCvv2InfoView.hideErrorLayoutWithTag(view, true);
                if (length2 == 0) {
                    this.mBankCvv2InfoView.getDateTip().setImageResource(ResUtils.drawable(getActivity(), "wallet_base_info_btn_selector"));
                    this.mBankCvv2InfoView.getDateTip().setOnClickListener(this);
                    return;
                }
                this.mBankCvv2InfoView.getDateTip().setImageResource(ResUtils.drawable(getActivity(), "dxm_wallet_base_delete"));
                this.mBankCvv2InfoView.getDateTip().setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.BindCardImplActivity.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ BindCardImplActivity a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                            this.a.mBankCvv2InfoView.getDateInputView().setText("");
                            this.a.mBankCvv2InfoView.getDateInputView().requestFocus();
                        }
                    }
                });
            } else if (view == this.mBankUserInfoView.getTrueNameText()) {
                int length3 = ((EditText) view).getText().toString().length();
                if (!z2) {
                    this.mBankUserInfoView.getNameTip().setImageResource(ResUtils.drawable(getActivity(), "wallet_base_info_btn_selector"));
                    this.mBankUserInfoView.getNameTip().setOnClickListener(this);
                    return;
                }
                this.mBankUserInfoView.hideErrorLayoutWithTag(view, true);
                if (length3 == 0) {
                    this.mBankUserInfoView.getNameTip().setImageResource(ResUtils.drawable(getActivity(), "wallet_base_info_btn_selector"));
                    this.mBankUserInfoView.getNameTip().setOnClickListener(this);
                    return;
                }
                this.mBankUserInfoView.getNameTip().setImageResource(ResUtils.drawable(getActivity(), "dxm_wallet_base_delete"));
                this.mBankUserInfoView.getNameTip().setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.BindCardImplActivity.6
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ BindCardImplActivity a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                            this.a.mBankUserInfoView.getTrueNameText().setText("");
                            this.a.mBankUserInfoView.getTrueNameText().requestFocus();
                        }
                    }
                });
            } else if (view == this.mBankUserInfoView.getMobileEditText()) {
                int length4 = ((DivisionEditText) view).getText().toString().length();
                if (!z2) {
                    this.mBankUserInfoView.getMobileTip().setImageResource(ResUtils.drawable(getActivity(), "wallet_base_info_btn_selector"));
                    this.mBankUserInfoView.getMobileTip().setOnClickListener(this);
                    return;
                }
                this.mBankUserInfoView.hideErrorLayoutWithTag(view, true);
                if (length4 == 0) {
                    this.mBankUserInfoView.getMobileTip().setImageResource(ResUtils.drawable(getActivity(), "wallet_base_info_btn_selector"));
                    this.mBankUserInfoView.getMobileTip().setOnClickListener(this);
                    return;
                }
                this.mBankUserInfoView.getMobileTip().setImageResource(ResUtils.drawable(getActivity(), "dxm_wallet_base_delete"));
                this.mBankUserInfoView.getMobileTip().setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.BindCardImplActivity.7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ BindCardImplActivity a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                            this.a.mBankUserInfoView.getMobileEditText().setText("");
                            this.a.mBankUserInfoView.getMobileEditText().requestFocus();
                        }
                    }
                });
            } else if (view == this.mBankUserInfoView.getIdEditText()) {
                int length5 = ((SafeKeyBoardEditText) view).getText().toString().length();
                if (!z2) {
                    this.mBankUserInfoView.getIdTip().setVisibility(4);
                    return;
                }
                this.mBankUserInfoView.hideErrorLayoutWithTag(view, true);
                if (length5 == 0) {
                    this.mBankUserInfoView.getIdTip().setImageResource(ResUtils.drawable(getActivity(), "wallet_base_info_btn_selector"));
                    this.mBankUserInfoView.getIdTip().setOnClickListener(this);
                    this.mBankUserInfoView.getIdTip().setVisibility(4);
                    return;
                }
                this.mBankUserInfoView.getIdTip().setVisibility(0);
                this.mBankUserInfoView.getIdTip().setImageResource(ResUtils.drawable(getActivity(), "dxm_wallet_base_delete"));
                this.mBankUserInfoView.getIdTip().setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.BindCardImplActivity.8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ BindCardImplActivity a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                            this.a.mBankUserInfoView.getIdEditText().setText("");
                            this.a.mBankUserInfoView.getIdEditText().requestFocus();
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, view) == null) {
            if (view == this.mBankCvv2InfoView.getCvv2InputView()) {
                if (!TextUtils.isEmpty(this.mBankCvv2InfoView.getCvv2InputView().getText().toString()) && r()) {
                    StatisticManager.onEventWithValue("showInputError", ResUtils.getString(getActivity(), "ebpay_bank_cvv2_errortip"));
                    this.mBankCvv2InfoView.showErrorLayout(ResUtils.getString(getActivity(), "ebpay_bank_cvv2"), ResUtils.getString(getActivity(), "ebpay_bank_cvv2_errortip"), view);
                    return;
                }
                this.mBankCvv2InfoView.hideErrorLayoutWithTag(view, false);
            } else if (view == this.mBankCvv2InfoView.getDateInputView()) {
                if (!TextUtils.isEmpty(this.mBankCvv2InfoView.getDateInputView().getText().toString()) && p()) {
                    StatisticManager.onEventWithValue("showInputError", ResUtils.getString(getActivity(), "ebpay_valid_date_errortip"));
                    this.mBankCvv2InfoView.showErrorLayout(ResUtils.getString(getActivity(), "ebpay_valid_date"), ResUtils.getString(getActivity(), "ebpay_valid_date_errortip"), view);
                    return;
                }
                this.mBankCvv2InfoView.hideErrorLayoutWithTag(view, false);
            } else if (view == this.mBankUserInfoView.getTrueNameText()) {
                if (!TextUtils.isEmpty(this.mBankUserInfoView.getTrueNameText().getText().toString()) && m()) {
                    StatisticManager.onEventWithValue("showInputError", ResUtils.getString(getActivity(), "ebpay_name_error_tip"));
                    this.mBankUserInfoView.showErrorLayout(ResUtils.getString(getActivity(), "ebpay_name"), ResUtils.getString(getActivity(), "ebpay_name_error_tip"), view);
                    return;
                }
                this.mBankUserInfoView.hideErrorLayoutWithTag(view, false);
            } else if (view == this.mBankUserInfoView.getIdEditText()) {
                if (!TextUtils.isEmpty(this.mBankUserInfoView.getIdEditText().getText()) && n()) {
                    StatisticManager.onEventWithValue("showInputError", ResUtils.getString(getActivity(), "ebpay_id_card_errortip"));
                    BankUserInfoView bankUserInfoView = this.mBankUserInfoView;
                    GetCardInfoResponse.CertificateTypeInfo certificateTypeInfo = this.F;
                    bankUserInfoView.showErrorLayout((certificateTypeInfo == null || TextUtils.isEmpty(certificateTypeInfo.description)) ? ResUtils.getString(getActivity(), "ebpay_id_card") : this.F.description, ResUtils.getString(getActivity(), "ebpay_id_card_errortip"), view);
                    return;
                }
                this.mBankUserInfoView.hideErrorLayoutWithTag(view, false);
            } else if (view == this.mBankUserInfoView.getMobileEditText()) {
                if (!TextUtils.isEmpty(this.mBankUserInfoView.getMobileEditText().getRealText()) && o()) {
                    StatisticManager.onEventWithValue("showInputError", ResUtils.getString(getActivity(), "ebpay_bank_bind_phone_errortip"));
                    this.mBankUserInfoView.showErrorLayout(ResUtils.getString(getActivity(), "ebpay_bank_bind_phone"), ResUtils.getString(getActivity(), "ebpay_bank_bind_phone_errortip"), view);
                    return;
                }
                this.mBankUserInfoView.hideErrorLayoutWithTag(view, false);
            }
        }
    }

    private void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65560, this, str) == null) {
            StatHelper.statServiceEvent("firstNext");
            if (isBindInvalid()) {
                return;
            }
            WalletGlobalUtils.safeShowDialog(this, -2, "");
            c();
            this.mBindReq.setChannelNo("");
            this.mBindReq.setSubBankCode(str);
            this.mBindCardController.d(this.D, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(GetCardInfoResponse getCardInfoResponse) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65551, this, getCardInfoResponse) == null) || getCardInfoResponse == null) {
            return;
        }
        GetCardInfoResponse.CardInfo cardInfo = getCardInfoResponse.card_info;
        if (cardInfo != null && !TextUtils.isEmpty(cardInfo.bank_no)) {
            this.mBindReq.mBankNo = getCardInfoResponse.card_info.bank_no;
        }
        this.mBindReq.setmBankInfo(getCardInfoResponse);
        this.mBindReq.setmBankCard(this.D);
        this.mBindCardController.a();
        this.r.setVisibility(8);
        this.n.setVisibility(8);
    }

    private void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65545, this, i2) == null) {
            if (i2 == 0) {
                this.mBankCvv2InfoView.getDateTip().setVisibility(0);
                this.mBankUserInfoView.getNameTip().setVisibility(0);
                this.mBankUserInfoView.getMobileTip().setVisibility(0);
                this.mBankCvv2InfoView.getDateTip().setImageResource(ResUtils.drawable(getActivity(), "wallet_base_info_btn_selector"));
                this.mBankCvv2InfoView.getDateTip().setOnClickListener(this);
                this.mBankUserInfoView.getNameTip().setImageResource(ResUtils.drawable(getActivity(), "wallet_base_info_btn_selector"));
                this.mBankUserInfoView.getNameTip().setOnClickListener(this);
                this.mBankUserInfoView.getMobileTip().setImageResource(ResUtils.drawable(getActivity(), "wallet_base_info_btn_selector"));
                this.mBankUserInfoView.getMobileTip().setOnClickListener(this);
            } else if (i2 == 1) {
                this.mBankCvv2InfoView.getCvv2Tip().setVisibility(0);
                this.mBankUserInfoView.getNameTip().setVisibility(0);
                this.mBankUserInfoView.getMobileTip().setVisibility(0);
                this.mBankCvv2InfoView.getCvv2Tip().setImageResource(ResUtils.drawable(getActivity(), "wallet_base_info_btn_selector"));
                this.mBankCvv2InfoView.getCvv2Tip().setOnClickListener(this);
                this.mBankUserInfoView.getNameTip().setImageResource(ResUtils.drawable(getActivity(), "wallet_base_info_btn_selector"));
                this.mBankUserInfoView.getNameTip().setOnClickListener(this);
                this.mBankUserInfoView.getMobileTip().setImageResource(ResUtils.drawable(getActivity(), "wallet_base_info_btn_selector"));
                this.mBankUserInfoView.getMobileTip().setOnClickListener(this);
            } else if (i2 == 2) {
                this.mBankCvv2InfoView.getDateTip().setVisibility(0);
                this.mBankCvv2InfoView.getCvv2Tip().setVisibility(0);
                this.mBankUserInfoView.getMobileTip().setVisibility(0);
                this.mBankCvv2InfoView.getDateTip().setImageResource(ResUtils.drawable(getActivity(), "wallet_base_info_btn_selector"));
                this.mBankCvv2InfoView.getDateTip().setOnClickListener(this);
                this.mBankCvv2InfoView.getCvv2Tip().setImageResource(ResUtils.drawable(getActivity(), "wallet_base_info_btn_selector"));
                this.mBankCvv2InfoView.getCvv2Tip().setOnClickListener(this);
                this.mBankUserInfoView.getMobileTip().setImageResource(ResUtils.drawable(getActivity(), "wallet_base_info_btn_selector"));
                this.mBankUserInfoView.getMobileTip().setOnClickListener(this);
            } else if (i2 != 3) {
                if (i2 != 4) {
                    return;
                }
                this.mBankCvv2InfoView.getDateTip().setVisibility(0);
                this.mBankCvv2InfoView.getCvv2Tip().setVisibility(0);
                this.mBankUserInfoView.getNameTip().setVisibility(0);
                this.mBankCvv2InfoView.getDateTip().setImageResource(ResUtils.drawable(getActivity(), "wallet_base_info_btn_selector"));
                this.mBankCvv2InfoView.getDateTip().setOnClickListener(this);
                this.mBankCvv2InfoView.getCvv2Tip().setImageResource(ResUtils.drawable(getActivity(), "wallet_base_info_btn_selector"));
                this.mBankCvv2InfoView.getCvv2Tip().setOnClickListener(this);
                this.mBankUserInfoView.getNameTip().setImageResource(ResUtils.drawable(getActivity(), "wallet_base_info_btn_selector"));
                this.mBankUserInfoView.getNameTip().setOnClickListener(this);
            } else {
                this.mBankCvv2InfoView.getDateTip().setVisibility(0);
                this.mBankCvv2InfoView.getCvv2Tip().setVisibility(0);
                this.mBankUserInfoView.getNameTip().setVisibility(0);
                this.mBankUserInfoView.getMobileTip().setVisibility(0);
                this.mBankCvv2InfoView.getDateTip().setImageResource(ResUtils.drawable(getActivity(), "wallet_base_info_btn_selector"));
                this.mBankCvv2InfoView.getDateTip().setOnClickListener(this);
                this.mBankCvv2InfoView.getCvv2Tip().setImageResource(ResUtils.drawable(getActivity(), "wallet_base_info_btn_selector"));
                this.mBankCvv2InfoView.getCvv2Tip().setOnClickListener(this);
                this.mBankUserInfoView.getMobileTip().setImageResource(ResUtils.drawable(getActivity(), "wallet_base_info_btn_selector"));
                this.mBankUserInfoView.getMobileTip().setOnClickListener(this);
                this.mBankUserInfoView.getNameTip().setImageResource(ResUtils.drawable(getActivity(), "wallet_base_info_btn_selector"));
                this.mBankUserInfoView.getNameTip().setOnClickListener(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public GetCardInfoResponse.CertificateTypeInfo[] a(GetCardInfoResponse.CertificateTypeInfo certificateTypeInfo, GetCardInfoResponse.CertificateTypeInfo[] certificateTypeInfoArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65563, this, certificateTypeInfo, certificateTypeInfoArr)) == null) {
            if (certificateTypeInfoArr != null) {
                for (GetCardInfoResponse.CertificateTypeInfo certificateTypeInfo2 : certificateTypeInfoArr) {
                    if (certificateTypeInfo != null) {
                        if (certificateTypeInfo.type.equals(certificateTypeInfo2.type)) {
                            certificateTypeInfo2.setDisplay(true);
                        } else {
                            certificateTypeInfo2.setDisplay(false);
                        }
                    } else {
                        certificateTypeInfo2.setDisplay(false);
                    }
                }
            }
            return certificateTypeInfoArr;
        }
        return (GetCardInfoResponse.CertificateTypeInfo[]) invokeLL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z2) {
        BindFastRequest bindFastRequest;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65561, this, z2) == null) || (bindFastRequest = this.mBindReq) == null) {
            return;
        }
        if (z2) {
            bindFastRequest.setmBankCard(this.D);
        }
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            extras = new Bundle();
        }
        extras.putBoolean("isSelectBank", z2);
        Intent intent = new Intent(getActivity(), SignChannelListActivity.class);
        intent.putExtras(extras);
        startActivityForResult(intent, BeanConstants.REQUEST_CODE_SIGN_CHANNEL_LIST);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, int i2, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65547, this, new Object[]{view, Integer.valueOf(i2), Boolean.valueOf(z2)}) == null) {
            boolean[] zArr = new boolean[5];
            boolean z3 = true;
            zArr[0] = this.mBindCardController.l() && this.mBankCvv2InfoView.getDateInputView().isEnabled();
            zArr[1] = this.mBindCardController.k() && this.mBankCvv2InfoView.getCvv2InputView().isEnabled();
            zArr[2] = this.mBindCardController.j() && this.mBankUserInfoView.getTrueNameText().isEnabled();
            zArr[3] = this.mBindCardController.m() && this.mBankUserInfoView.getIdEditText().isEnabled();
            zArr[4] = this.mBindCardController.n() && this.mBankUserInfoView.getMobileEditText().isEnabled();
            View a2 = a(i2, zArr);
            if (((a2 instanceof TextView) && TextUtils.isEmpty(((TextView) a2).getText())) ? false : false) {
                a2.requestFocus();
                if (a2 == this.mBankUserInfoView.getTrueNameText()) {
                    new Handler().postDelayed(new Runnable(this) { // from class: com.baidu.wallet.paysdk.ui.BindCardImplActivity.22
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ BindCardImplActivity a;

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
                            this.a = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                GlobalUtils.showInputMethod(this.a.getActivity(), this.a.mBankUserInfoView.getTrueNameText());
                            }
                        }
                    }, 150L);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        CardData.BondCard bondCard;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65562, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5), Boolean.valueOf(z6)}) == null) {
            if (isShowWithHalfScreeen()) {
                SafeKeyBoardEditText[] safeKeyBoardEditTextArr = {this.f54261h.getCardNoView(), this.mBankCvv2InfoView.getDateInputView(), this.mBankCvv2InfoView.getCvv2InputView(), this.mBankUserInfoView.getIdEditText(), this.mBankUserInfoView.getMobileEditText()};
                SafeKeyBoardEditText.CheckFunc checkFunc = new SafeKeyBoardEditText.CheckFunc(this) { // from class: com.baidu.wallet.paysdk.ui.BindCardImplActivity.24
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ BindCardImplActivity a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = this;
                    }

                    @Override // com.dxmpay.wallet.base.widget.SafeKeyBoardEditText.CheckFunc
                    public boolean check(String str) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, str)) == null) ? this.a.y() : invokeL.booleanValue;
                    }
                };
                boolean z7 = false;
                for (int i2 = 0; i2 < 5; i2++) {
                    SafeKeyBoardEditText safeKeyBoardEditText = safeKeyBoardEditTextArr[i2];
                    if (safeKeyBoardEditText.isShown()) {
                        safeKeyBoardEditText.setConfirmListener(this);
                        safeKeyBoardEditText.setCheckFunc(checkFunc);
                        if (!z7) {
                            SafeScrollView safeScrollView = this.mScrollView;
                            safeScrollView.showKeyBoard(safeScrollView, safeKeyBoardEditText, (View) safeKeyBoardEditText.getTag());
                            z7 = true;
                        }
                    }
                }
                if (this.mBankUserInfoView.getIdEditText().isShown()) {
                    this.mBankUserInfoView.getIdEditText().setUseKeyX(true);
                }
                BindFastRequest bindFastRequest = this.mBindReq;
                if (bindFastRequest != null && (bondCard = bindFastRequest.mBondCard) != null && bondCard.bank_code != null) {
                    com.baidu.wallet.paysdk.ui.widget.a.a(this.B, "请完善", bondCard.getCardDesc(this.mAct, false), "的信息后继续支付");
                } else {
                    com.baidu.wallet.paysdk.ui.widget.a.a(this.B, ResUtils.getString(this.mAct, "ebpay_title_complete_fixmsg"), null, null);
                }
            }
            this.f54261h.getCardNoView().initSafeKeyBoardParams(this.mRootView, this.mScrollView, this.f54261h.getCardNoView(), false);
            if (z3 && this.mBankCvv2InfoView.getDateInputView().isEnabled()) {
                this.mBankCvv2InfoView.getDateInputView().setOnMyFocusChangeListener(this);
                this.mBankCvv2InfoView.getDateInputView().initSafeKeyBoardParams(this.mRootView, this.mScrollView, (View) this.mBankCvv2InfoView.getDateInputView().getTag(), false);
                this.mBankCvv2InfoView.getDateInputView().requestFocus();
            }
            if (z2 && this.mBankCvv2InfoView.getCvv2InputView().isEnabled()) {
                this.mBankCvv2InfoView.getCvv2InputView().setOnMyFocusChangeListener(this);
                this.mBankCvv2InfoView.getCvv2InputView().initSafeKeyBoardParams(this.mRootView, this.mScrollView, this.mBankCvv2InfoView.getCvv2InputView(), false);
                if (!z3) {
                    this.mBankCvv2InfoView.getCvv2InputView().requestFocus();
                }
            }
            if (z4 && this.mBankUserInfoView.getTrueNameText().isEnabled() && !z2 && !z3) {
                try {
                    this.mBankUserInfoView.getTrueNameText().setSelection(this.mBankUserInfoView.getTrueNameText().getText().length());
                } catch (Exception unused) {
                }
                this.mBankUserInfoView.getTrueNameText().requestFocus();
                new Handler().postDelayed(new Runnable(this) { // from class: com.baidu.wallet.paysdk.ui.BindCardImplActivity.25
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ BindCardImplActivity a;

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
                        this.a = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            GlobalUtils.showInputMethod(this.a.getActivity(), this.a.mBankUserInfoView.getTrueNameText());
                        }
                    }
                }, 150L);
            }
            if (z5 && this.mBankUserInfoView.getIdEditText().isEnabled()) {
                this.mBankUserInfoView.getIdEditText().setOnMyFocusChangeListener(this);
                this.mBankUserInfoView.getIdEditText().initSafeKeyBoardParams(this.mRootView, this.mScrollView, a(3, z2, z3, z4, z5, z6), false);
                if (!z4 && !z3 && !z2) {
                    try {
                        this.mBankUserInfoView.getIdEditText().setSelection(this.mBankUserInfoView.getIdEditText().getText().length());
                    } catch (Exception unused2) {
                    }
                    this.mBankUserInfoView.getIdEditText().requestFocus();
                }
            }
            if (z6 && this.mBankUserInfoView.getMobileEditText().isEnabled()) {
                this.mBankUserInfoView.getMobileEditText().setOnMyFocusChangeListener(this);
                this.mBankUserInfoView.getMobileEditText().initSafeKeyBoardParams(this.mRootView, this.mScrollView, a(4, z2, z3, z4, z5, z6), false);
                if (z4 || z3 || z2) {
                    return;
                }
                if (z5 && this.mBankUserInfoView.getIdEditText().isEnabled()) {
                    return;
                }
                try {
                    this.mBankUserInfoView.getMobileEditText().setSelection(this.mBankUserInfoView.getMobileEditText().getText().length());
                } catch (Exception unused3) {
                }
                this.mBankUserInfoView.getMobileEditText().requestFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View a(int i2, boolean... zArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(InputDeviceCompat.SOURCE_TRACKBALL, this, i2, zArr)) == null) {
            if (i2 >= zArr.length) {
                return this.m;
            }
            for (int i3 = i2 + 1; i3 < zArr.length; i3++) {
                if (zArr[i3]) {
                    if (i3 != 0) {
                        if (i3 != 1) {
                            if (i3 != 2) {
                                if (i3 != 3) {
                                    if (i3 != 4) {
                                        return this.m;
                                    }
                                    return this.mBankUserInfoView.getMobileEditText();
                                }
                                return this.mBankUserInfoView.getIdEditText();
                            }
                            return this.mBankUserInfoView.getTrueNameText();
                        }
                        return this.mBankCvv2InfoView.getCvv2InputView();
                    }
                    return this.mBankCvv2InfoView.getDateInputView();
                }
            }
            return this.m;
        }
        return (View) invokeIL.objValue;
    }
}
