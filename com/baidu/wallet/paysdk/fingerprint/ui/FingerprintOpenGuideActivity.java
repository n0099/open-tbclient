package com.baidu.wallet.paysdk.fingerprint.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.controllers.PayController;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.fingerprint.FingerprintCallback;
import com.baidu.wallet.paysdk.fingerprint.IFingerprintPay;
import com.baidu.wallet.paysdk.fingerprint.WalletFingerprint;
import com.baidu.wallet.paysdk.payresult.datamodel.H5ResultParams;
import com.baidu.wallet.paysdk.payresult.datamodel.PayResultContent;
import com.baidu.wallet.paysdk.payresult.presenter.CashierDeskPayResult;
import com.baidu.wallet.paysdk.payresult.view.WalletPayResultCommonActivity;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.HalfScreenBaseActivity;
import com.baidu.wallet.paysdk.ui.PayBaseBeanActivity;
import com.dxmpay.apollon.utils.CheckUtils;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.api.BaiduWalletDelegate;
import com.dxmpay.wallet.base.datamodel.UserData;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.StatHelper;
import java.io.Serializable;
/* loaded from: classes8.dex */
public class FingerprintOpenGuideActivity extends HalfScreenBaseActivity implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TextView f62555a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f62556b;

    /* renamed from: c  reason: collision with root package name */
    public Button f62557c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f62558d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f62559e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f62560f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f62561g;

    /* renamed from: h  reason: collision with root package name */
    public PayController.PayResultWrapper f62562h;

    public FingerprintOpenGuideActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.HalfScreenBaseActivity
    public void addContentView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mContentView = (ViewGroup) View.inflate(this, ResUtils.layout(getActivity(), "wallet_fingerprint_open_guide"), null);
            this.mContentView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
            this.mHalfScreenContainer.addView(this.mContentView);
        }
    }

    @Override // com.dxmpay.wallet.core.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            StatHelper.cacheCodeAndMsg(StatHelper.SENSOR_ERR_2, "FingerprintOpenGuideCancel");
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) || CheckUtils.isFastDoubleClick()) {
            return;
        }
        if (view == this.f62557c) {
            PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
            IFingerprintPay fingerprintPay = WalletFingerprint.getInstance(getActivity()).getFingerprintPay(WalletFingerprint.FpType.SYSTEM_FINGERPRINT);
            if (payRequest == null || fingerprintPay == null) {
                return;
            }
            StatHelper.statServiceEvent(PayStatServiceEvent.FP_OPEN_START);
            StatisticManager.onEventStart(PayStatServiceEvent.PAY_OPEN_FINGERPRINT_DURATION);
            fingerprintPay.open(getActivity(), new FingerprintCallback(this, payRequest, fingerprintPay) { // from class: com.baidu.wallet.paysdk.fingerprint.ui.FingerprintOpenGuideActivity.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ FingerprintOpenGuideActivity this$0;
                public final /* synthetic */ IFingerprintPay val$iFingerprintPay;
                public final /* synthetic */ PayRequest val$payRequest;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, payRequest, fingerprintPay};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$payRequest = payRequest;
                    this.val$iFingerprintPay = fingerprintPay;
                }

                @Override // com.baidu.wallet.paysdk.fingerprint.FingerprintCallback
                public void onAuthorizeResult(IFingerprintPay.Action action, int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIL(1048576, this, action, i2, str) == null) {
                        if (i2 == 0) {
                            StatHelper.cacheCodeAndMsg(i2 + "", StatHelper.SENSOR_OK);
                        } else {
                            StatHelper.cacheCodeAndMsg(i2 + "", str);
                        }
                        if (i2 == 0) {
                            int i3 = this.val$payRequest.FP_Guide_Strategy;
                            if (i3 == 1) {
                                GlobalUtils.toast(this.this$0.getActivity(), ResUtils.getString(this.this$0.getActivity(), "wallet_fp_open_success"));
                                StatHelper.statServiceEvent("fp_open_success");
                            } else if (i3 == 2) {
                                GlobalUtils.toast(this.this$0.getActivity(), ResUtils.getString(this.this$0.getActivity(), "wallet_fp_reopen_success"));
                                StatHelper.statServiceEvent("fp_reopen_success");
                            } else if (i3 == 3) {
                                GlobalUtils.toast(this.this$0.getActivity(), ResUtils.getString(this.this$0.getActivity(), "wallet_fp_upgrade_success"));
                                StatHelper.statServiceEvent("fp_upgrade_success");
                            }
                            this.this$0.f62557c.postDelayed(new Runnable(this) { // from class: com.baidu.wallet.paysdk.fingerprint.ui.FingerprintOpenGuideActivity.3.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass3 f62567a;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i4 = newInitContext.flag;
                                        if ((i4 & 1) != 0) {
                                            int i5 = i4 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.f62567a = this;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        this.f62567a.this$0.c();
                                    }
                                }
                            }, 2000L);
                            this.this$0.f62557c.setClickable(false);
                            this.this$0.mRightTxt.setClickable(false);
                        } else if (i2 == 2) {
                            if (TextUtils.isEmpty(str)) {
                                int i4 = this.val$payRequest.FP_Guide_Strategy;
                                if (i4 == 1) {
                                    StatHelper.statServiceEvent("fp_open_failed");
                                    str = ResUtils.getString(this.this$0.getActivity(), "wallet_fp_open_failed");
                                } else if (i4 == 2) {
                                    str = ResUtils.getString(this.this$0.getActivity(), "wallet_fp_reopen_failed");
                                    StatHelper.statServiceEvent("fp_reopen_failed");
                                } else if (i4 != 3) {
                                    str = "";
                                } else {
                                    str = ResUtils.getString(this.this$0.getActivity(), "wallet_fp_upgrade_failed");
                                    StatHelper.statServiceEvent("fp_upgrade_failed");
                                }
                            }
                            GlobalUtils.toast(this.this$0.getActivity(), str);
                            this.this$0.f62557c.postDelayed(new Runnable(this) { // from class: com.baidu.wallet.paysdk.fingerprint.ui.FingerprintOpenGuideActivity.3.2
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass3 f62568a;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i5 = newInitContext.flag;
                                        if ((i5 & 1) != 0) {
                                            int i6 = i5 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.f62568a = this;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        this.f62568a.this$0.c();
                                    }
                                }
                            }, 2000L);
                            this.this$0.f62557c.setClickable(false);
                            this.this$0.mRightTxt.setClickable(false);
                        } else if (i2 == 1) {
                            int i5 = this.val$payRequest.FP_Guide_Strategy;
                            if (i5 == 1) {
                                StatHelper.statServiceEvent("fp_open_cancle");
                            } else if (i5 == 2) {
                                StatHelper.statServiceEvent("fp_reopen_cancle");
                            } else if (i5 == 3) {
                                StatHelper.statServiceEvent("fp_upgrade_cancle");
                            }
                        }
                        this.val$iFingerprintPay.destory();
                    }
                }
            }, false);
        } else if (view == this.mRightTxt) {
            StatHelper.statServiceEvent(PayStatServiceEvent.FP_OPEN_SKIP);
            c();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.HalfScreenBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.beans.BeanActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            if (bundle != null) {
                Serializable serializable = bundle.getSerializable("payresultwrapper");
                if (serializable instanceof PayController.PayResultWrapper) {
                    this.f62562h = (PayController.PayResultWrapper) serializable;
                }
            } else {
                Intent intent = getIntent();
                if (intent != null && (intent.getSerializableExtra("payresultwrapper") instanceof PayController.PayResultWrapper)) {
                    this.f62562h = (PayController.PayResultWrapper) intent.getSerializableExtra("payresultwrapper");
                }
            }
            if (this.f62562h == null) {
                PayBaseBeanActivity.exitEbpay();
                finish();
            }
            a();
            b();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.HalfScreenBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDestroy();
            StatHelper.payEventEndWithValues(PayStatServiceEvent.PAY_OPEN_FINGERPRINT_DURATION, null, new String[0]);
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putSerializable("payresultwrapper", this.f62562h);
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity
    public void showPaySuccessPage(boolean z, PayResultContent payResultContent, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), payResultContent, Integer.valueOf(i2)}) == null) {
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            this.mLeftImg.setVisibility(4);
            this.f62555a = (TextView) this.mContentView.findViewById(ResUtils.id(this, "fingerprint_title"));
            this.f62556b = (TextView) this.mContentView.findViewById(ResUtils.id(this, "fingerprint_subtitle"));
            this.f62558d = (TextView) this.mContentView.findViewById(ResUtils.id(this, "fingerprint_hint1"));
            this.f62559e = (TextView) this.mContentView.findViewById(ResUtils.id(this, "fingerprint_hint2"));
            this.mRightTxt.setTextColor(ResUtils.getColor(this, "wallet_base_primary_color"));
            this.mRightTxt.setText(ResUtils.getString(this, "wallet_base_skip"));
            this.mRightTxt.setOnClickListener(this);
            Button button = (Button) this.mContentView.findViewById(ResUtils.id(this, "fingerprint_open_btn"));
            this.f62557c = button;
            button.setOnClickListener(this);
            this.f62560f = (TextView) this.mContentView.findViewById(ResUtils.id(this, "fingerprint_protocol_prefix"));
            this.f62561g = (TextView) this.mContentView.findViewById(ResUtils.id(this, "fingerprint_protocol_msg"));
        }
    }

    private void b() {
        String str;
        String str2;
        String string;
        String string2;
        String string3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
            UserData.UserModel.FingerprintMsg fingerprintMsg = PayDataCache.getInstance().getFingerprintMsg();
            if (payRequest != null) {
                int i2 = payRequest.FP_Guide_Strategy;
                String str3 = "";
                String[] strArr = null;
                if (i2 == 1) {
                    StatisticManager.onEvent("fp_guide_show_open_system_fingerprint_dialog");
                    if (fingerprintMsg != null && fingerprintMsg.getOpen() != null && !TextUtils.isEmpty(fingerprintMsg.getOpen().getTitle())) {
                        string3 = fingerprintMsg.getOpen().getTitle();
                    } else {
                        string3 = ResUtils.getString(this, "bd_wallet_fingerprint_open_guide");
                    }
                    str3 = string3;
                    if (fingerprintMsg != null && fingerprintMsg.getOpen() != null && !TextUtils.isEmpty(fingerprintMsg.getOpen().getSubtitle())) {
                        str = fingerprintMsg.getOpen().getSubtitle();
                    } else {
                        str = ResUtils.getString(this, "bd_wallet_fingerprint_open_guide_subtitle");
                    }
                    String string4 = ResUtils.getString(this, "bd_wallet_fingerprint_open_guide_btn");
                    String[] strArr2 = fingerprintMsg != null ? fingerprintMsg.getOpen().hints : new String[]{ResUtils.getString(this, "bd_wallet_fingerprint_open_guide_hint0"), ResUtils.getString(this, "bd_wallet_fingerprint_open_guide_hint1")};
                    if (fingerprintMsg != null && fingerprintMsg.getOpen() != null && fingerprintMsg.getOpen().getFingerprintProtocol() != null && !TextUtils.isEmpty(fingerprintMsg.getOpen().getFingerprintProtocol().getFingerprintProtocolPrefix()) && !TextUtils.isEmpty(fingerprintMsg.getOpen().getFingerprintProtocol().getFingerprintProtocolMsg()) && !TextUtils.isEmpty(fingerprintMsg.getOpen().getFingerprintProtocol().getFingerprintProtocolUrl())) {
                        this.f62560f.setText(fingerprintMsg.getOpen().getFingerprintProtocol().getFingerprintProtocolPrefix());
                        this.f62561g.setText(fingerprintMsg.getOpen().getFingerprintProtocol().getFingerprintProtocolMsg());
                        this.f62561g.setVisibility(0);
                        this.f62560f.setVisibility(0);
                        this.f62561g.setOnClickListener(new View.OnClickListener(this, fingerprintMsg) { // from class: com.baidu.wallet.paysdk.fingerprint.ui.FingerprintOpenGuideActivity.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ UserData.UserModel.FingerprintMsg f62563a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ FingerprintOpenGuideActivity f62564b;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, fingerprintMsg};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i3 = newInitContext.flag;
                                    if ((i3 & 1) != 0) {
                                        int i4 = i3 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f62564b = this;
                                this.f62563a = fingerprintMsg;
                            }

                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                                    BaiduWalletDelegate.getInstance().openH5Module(this.f62564b, this.f62563a.getOpen().getFingerprintProtocol().getFingerprintProtocolUrl(), false);
                                }
                            }
                        });
                    } else {
                        this.f62561g.setVisibility(8);
                        this.f62560f.setVisibility(8);
                    }
                    str2 = string4;
                    strArr = strArr2;
                } else if (i2 == 2) {
                    StatHelper.statServiceEvent("fp_show_reopen_system_dialog");
                    if (fingerprintMsg != null && fingerprintMsg.getReopen() != null && !TextUtils.isEmpty(fingerprintMsg.getOpen().getTitle())) {
                        string2 = fingerprintMsg.getReopen().getTitle();
                    } else {
                        string2 = ResUtils.getString(this, "bd_wallet_fingerprint_reopen_guide");
                    }
                    str3 = string2;
                    if (fingerprintMsg != null && fingerprintMsg.getReopen() != null && !TextUtils.isEmpty(fingerprintMsg.getOpen().getSubtitle())) {
                        str = fingerprintMsg.getReopen().getSubtitle();
                    } else {
                        str = ResUtils.getString(this, "bd_wallet_fingerprint_reopen_guide_subtitle");
                    }
                    String string5 = ResUtils.getString(this, "bd_wallet_fingerprint_reopen_guide_btn");
                    if (fingerprintMsg != null && fingerprintMsg.getReopen() != null && fingerprintMsg.getReopen().getFingerprintProtocol() != null && !TextUtils.isEmpty(fingerprintMsg.getReopen().getFingerprintProtocol().getFingerprintProtocolPrefix()) && !TextUtils.isEmpty(fingerprintMsg.getReopen().getFingerprintProtocol().getFingerprintProtocolMsg()) && !TextUtils.isEmpty(fingerprintMsg.getReopen().getFingerprintProtocol().getFingerprintProtocolUrl())) {
                        this.f62560f.setText(fingerprintMsg.getReopen().getFingerprintProtocol().getFingerprintProtocolPrefix());
                        this.f62561g.setText(fingerprintMsg.getReopen().getFingerprintProtocol().getFingerprintProtocolMsg());
                        this.f62561g.setVisibility(0);
                        this.f62560f.setVisibility(0);
                        this.f62561g.setOnClickListener(new View.OnClickListener(this, fingerprintMsg) { // from class: com.baidu.wallet.paysdk.fingerprint.ui.FingerprintOpenGuideActivity.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ UserData.UserModel.FingerprintMsg f62565a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ FingerprintOpenGuideActivity f62566b;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, fingerprintMsg};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i3 = newInitContext.flag;
                                    if ((i3 & 1) != 0) {
                                        int i4 = i3 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f62566b = this;
                                this.f62565a = fingerprintMsg;
                            }

                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                                    BaiduWalletDelegate.getInstance().openH5Module(this.f62566b, this.f62565a.getReopen().getFingerprintProtocol().getFingerprintProtocolUrl(), false);
                                }
                            }
                        });
                    } else {
                        this.f62561g.setVisibility(8);
                        this.f62560f.setVisibility(8);
                    }
                    str2 = string5;
                } else if (i2 == 3) {
                    StatisticManager.onEvent("fp_show_upgrade_system_dialog");
                    if (fingerprintMsg != null && fingerprintMsg.getUpdate() != null && !TextUtils.isEmpty(fingerprintMsg.getOpen().getTitle())) {
                        string = fingerprintMsg.getUpdate().getTitle();
                    } else {
                        string = ResUtils.getString(this, "bd_wallet_fingerprint_upgrade_guide");
                    }
                    str3 = string;
                    if (fingerprintMsg != null && fingerprintMsg.getUpdate() != null && !TextUtils.isEmpty(fingerprintMsg.getOpen().getSubtitle())) {
                        str = fingerprintMsg.getUpdate().getSubtitle();
                    } else {
                        str = ResUtils.getString(this, "bd_wallet_fingerprint_upgrade_guide_subtitle");
                    }
                    str2 = ResUtils.getString(this, "bd_wallet_fingerprint_upgrade_guide_btn");
                } else {
                    str = "";
                    str2 = str;
                }
                this.f62555a.setText(str3);
                this.f62556b.setText(str);
                this.f62557c.setText(str2);
                if (strArr != null && strArr.length > 0) {
                    this.f62558d.setVisibility(0);
                    this.f62559e.setVisibility(0);
                    if (strArr.length == 1) {
                        this.f62558d.setText(!TextUtils.isEmpty(strArr[0]) ? strArr[0] : ResUtils.getString(this, "bd_wallet_fingerprint_open_guide_hint0"));
                        this.f62559e.setText(ResUtils.getString(this, "bd_wallet_fingerprint_open_guide_hint1"));
                        return;
                    } else if (strArr.length >= 2) {
                        this.f62558d.setText(!TextUtils.isEmpty(strArr[0]) ? strArr[0] : ResUtils.getString(this, "bd_wallet_fingerprint_open_guide_hint0"));
                        this.f62559e.setText(!TextUtils.isEmpty(strArr[1]) ? strArr[1] : ResUtils.getString(this, "bd_wallet_fingerprint_open_guide_hint1"));
                        return;
                    } else {
                        return;
                    }
                }
                this.f62558d.setVisibility(8);
                this.f62559e.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            PayController.PayResultWrapper payResultWrapper = this.f62562h;
            if (payResultWrapper.payResult == 0) {
                PayResultContent payResultContent = payResultWrapper.payResultContent;
                if (payResultContent != null) {
                    payResultContent.isPaySuccess = true;
                }
                PayDataCache.getInstance().setPayReslutContent(payResultContent);
                H5ResultParams h5ResultParams = PayDataCache.getInstance().getH5ResultParams();
                if (h5ResultParams != null && h5ResultParams.toShowH5ResultPage()) {
                    CashierDeskPayResult cashierDeskPayResult = new CashierDeskPayResult(getActivity(), h5ResultParams);
                    cashierDeskPayResult.beforeShow();
                    cashierDeskPayResult.show();
                    return;
                }
                PayDataCache.getInstance().setPayReslutContent(payResultContent);
                Bundle bundle = new Bundle();
                bundle.putInt(BeanConstants.KEY_PAY_RESULT_TYPE, this.f62562h.payResultType);
                startActivityWithExtras(bundle, WalletPayResultCommonActivity.class);
                PayBaseBeanActivity.exitEbpay();
            }
        }
    }
}
