package com.baidu.wallet.paysdk.ui;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.utils.CheckUtils;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.base.widget.WalletBaseButtonWithImage;
import com.baidu.wallet.base.widget.dialog.PromptMultiBtnDialog;
import com.baidu.wallet.core.BaseActivity;
import com.baidu.wallet.core.beans.BeanManager;
import com.baidu.wallet.core.utils.WalletGlobalUtils;
import com.baidu.wallet.paysdk.banksign.BankSignPayFlow;
import com.baidu.wallet.paysdk.banksign.beans.BankSignFactory;
import com.baidu.wallet.paysdk.banksign.beans.d;
import com.baidu.wallet.paysdk.banksign.datamodel.BindCardResponse;
import com.baidu.wallet.paysdk.banksign.datamodel.PollingResponse;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.payresult.datamodel.PayResultContent;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
/* loaded from: classes5.dex */
public class BusinessSignedGuideActivity extends HalfScreenBaseActivity implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DLG_BANK_SIGN_GUIDE = 64;
    public static final int SIGN_STATE_1 = 1;
    public static final int SIGN_STATE_2 = 2;
    public static final int SIGN_STATE_3 = 3;
    public static final int SIGN_STATE_4 = 4;
    public static final int SIGN_STATE_5 = 5;
    public static final int SIGN_STATE_6 = 6;
    public static final String TAG = "BusinessSignedGuideActivity";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public WalletBaseButtonWithImage f26646a;

    /* renamed from: b  reason: collision with root package name */
    public Runnable f26647b;

    /* renamed from: c  reason: collision with root package name */
    public Handler f26648c;

    /* renamed from: e  reason: collision with root package name */
    public boolean f26649e;

    /* renamed from: f  reason: collision with root package name */
    public QueryResponse f26650f;

    /* renamed from: g  reason: collision with root package name */
    public String f26651g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f26652h;

    /* renamed from: i  reason: collision with root package name */
    public int f26653i;

    public BusinessSignedGuideActivity() {
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
        this.f26648c = new Handler();
        this.f26649e = false;
        this.f26651g = "";
        this.f26652h = false;
        this.f26653i = 0;
    }

    private void d() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            if (TextUtils.isEmpty(this.f26650f.toast_msg) || !this.f26651g.equals("pay")) {
                i2 = 0;
            } else {
                GlobalUtils.toast(this, this.f26650f.toast_msg);
                i2 = 2000;
            }
            this.f26648c.postDelayed(new Runnable(this) { // from class: com.baidu.wallet.paysdk.ui.BusinessSignedGuideActivity.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ BusinessSignedGuideActivity f26662a;

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
                    this.f26662a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f26662a.e();
                    }
                }
            }, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            String str = this.f26650f.form_data;
            com.baidu.wallet.paysdk.banksign.a.a.a().a(str == null ? null : str.getBytes());
            com.baidu.wallet.paysdk.banksign.a.a.a().d(this.f26650f.form_url);
            com.baidu.wallet.paysdk.banksign.a.a.a().e(this.f26650f.webview_title);
            this.f26653i = 0;
            this.f26649e = true;
            BankSignPayFlow a2 = BankSignPayFlow.a();
            a2.a(BankSignPayFlow.Action.JumpResign);
            a2.a(this.mAct);
            this.f26648c.post(this.f26647b);
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.HalfScreenBaseActivity
    public void addContentView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ViewGroup viewGroup = (ViewGroup) View.inflate(this, ResUtils.layout(getActivity(), "wallet_base_half_sign_guide_activity"), null);
            this.mContentView = viewGroup;
            this.mHalfScreenContainer.addView(viewGroup);
        }
    }

    public void bindcard() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            com.baidu.wallet.paysdk.banksign.beans.a aVar = (com.baidu.wallet.paysdk.banksign.beans.a) BankSignFactory.getInstance().getBean((Context) this.mAct, BankSignFactory.BEAN_ID_BIND_CARD, TAG);
            aVar.setResponseCallback(this);
            aVar.execBean();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity
    public void handleErrorContent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            WalletGlobalUtils.safeDismissDialog(this.mAct, -1);
            super.handleErrorContent();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.core.beans.BeanActivity
    public void handleFailure(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(1048579, this, i2, i3, str) == null) || i2 == 769) {
            return;
        }
        if (i2 == 770) {
            WalletGlobalUtils.safeDismissDialog(this.mAct, -1);
            GlobalUtils.toast(this, str);
        } else if (i2 == 771) {
            if (i3 != 0 && !TextUtils.isEmpty(str)) {
                GlobalUtils.toast(this, str, 1000);
            }
            if (PayDataCache.getInstance().isFromPreCashier()) {
                finishWithoutAnim();
                return;
            }
            BankSignPayFlow a2 = BankSignPayFlow.a();
            a2.a(BankSignPayFlow.Action.Cancel);
            a2.a(this.mAct);
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.core.beans.BeanActivity
    public void handleResponse(int i2, Object obj, String str) {
        BindCardResponse bindCardResponse;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048580, this, i2, obj, str) == null) {
            int i3 = 2000;
            boolean z = true;
            if (i2 == 769) {
                PollingResponse pollingResponse = (PollingResponse) obj;
                Handler handler = this.f26648c;
                if (handler == null || pollingResponse == null || pollingResponse.has_sign_result != 1) {
                    return;
                }
                handler.removeCallbacks(this.f26647b);
                if (!TextUtils.isEmpty(pollingResponse.toast_msg)) {
                    GlobalUtils.toast(this.mAct, pollingResponse.toast_msg, 2000);
                }
                this.f26648c.postDelayed(new Runnable(this) { // from class: com.baidu.wallet.paysdk.ui.BusinessSignedGuideActivity.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ BusinessSignedGuideActivity f26656a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i4 = newInitContext.flag;
                            if ((i4 & 1) != 0) {
                                int i5 = i4 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f26656a = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            BaseActivity.clearTasksTopOf(this.f26656a);
                        }
                    }
                }, 5000L);
            } else if (i2 == 770) {
                WalletGlobalUtils.safeDismissDialog(this.mAct, -1);
                QueryResponse queryResponse = (QueryResponse) obj;
                this.f26650f = queryResponse;
                if (queryResponse != null) {
                    int i4 = this.f26653i + 1;
                    this.f26653i = i4;
                    int i5 = queryResponse.sign_state;
                    if (i4 == 1 && i5 == 2) {
                        z = false;
                    }
                    if (!TextUtils.isEmpty(this.f26650f.agreement_trans_id) && z) {
                        com.baidu.wallet.paysdk.banksign.a.a.a().f(this.f26650f.agreement_trans_id);
                    }
                    switch (i5) {
                        case 1:
                            if (this.f26653i == 2) {
                                d();
                                return;
                            }
                            BankSignPayFlow a2 = BankSignPayFlow.a();
                            a2.a(BankSignPayFlow.Action.FirstFail);
                            a2.a(this.mAct);
                            return;
                        case 2:
                            if (this.f26653i == 2) {
                                d();
                                return;
                            } else if (this.f26650f.isGuidanceAvilable()) {
                                WalletGlobalUtils.safeShowDialog(this, 64, "");
                                return;
                            } else {
                                return;
                            }
                        case 3:
                        case 5:
                        case 6:
                            if (this.f26653i != 2 || TextUtils.isEmpty(this.f26650f.toast_msg)) {
                                i3 = 0;
                            } else {
                                GlobalUtils.toast(this, this.f26650f.toast_msg);
                            }
                            this.f26648c.postDelayed(new Runnable(this) { // from class: com.baidu.wallet.paysdk.ui.BusinessSignedGuideActivity.3
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ BusinessSignedGuideActivity f26657a;

                                {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this};
                                        interceptable2.invokeUnInit(65536, newInitContext);
                                        int i6 = newInitContext.flag;
                                        if ((i6 & 1) != 0) {
                                            int i7 = i6 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable2.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.f26657a = this;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable2 = $ic;
                                    if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.f26657a.f26650f.isGuidanceAvilable()) {
                                        WalletGlobalUtils.safeShowDialog(this.f26657a, 64, "");
                                    }
                                }
                            }, i3);
                            return;
                        case 4:
                            if (this.f26653i == 2 && !TextUtils.isEmpty(this.f26650f.toast_msg) && this.f26651g.equals(QueryResponse.Options.JUMP_RESIGN)) {
                                GlobalUtils.toast(this, this.f26650f.toast_msg);
                            } else {
                                i3 = 0;
                            }
                            this.f26648c.postDelayed(new Runnable(this) { // from class: com.baidu.wallet.paysdk.ui.BusinessSignedGuideActivity.4
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ BusinessSignedGuideActivity f26658a;

                                {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this};
                                        interceptable2.invokeUnInit(65536, newInitContext);
                                        int i6 = newInitContext.flag;
                                        if ((i6 & 1) != 0) {
                                            int i7 = i6 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable2.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.f26658a = this;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                        BankSignPayFlow a3 = BankSignPayFlow.a();
                                        a3.a(BankSignPayFlow.Action.Pay);
                                        a3.a(this.f26658a.mAct);
                                        this.f26658a.finishWithoutAnim();
                                    }
                                }
                            }, i3);
                            return;
                        default:
                            return;
                    }
                }
            } else if (i2 != 771 || (bindCardResponse = (BindCardResponse) obj) == null || TextUtils.isEmpty(bindCardResponse.sign_card_no)) {
            } else {
                if (PayDataCache.getInstance().isFromPreCashier()) {
                    String g2 = com.baidu.wallet.paysdk.banksign.a.a.a().g(bindCardResponse.sign_card_no);
                    if (!TextUtils.isEmpty(g2)) {
                        PayDataCache.getInstance().setOrderExtraInfo(g2);
                    }
                }
                BankSignPayFlow a3 = BankSignPayFlow.a();
                a3.a(BankSignPayFlow.Action.Cancel);
                a3.a(this.mAct);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view) == null) {
            if (view == this.mLeftImg) {
                onBackPressed();
            } else if (view != this.f26646a || CheckUtils.isFastDoubleClick()) {
            } else {
                this.f26650f = null;
                BankSignPayFlow a2 = BankSignPayFlow.a();
                a2.a(BankSignPayFlow.Action.JumpResign);
                a2.a(this.mAct);
                this.f26649e = true;
                this.f26646a.setEnabled(false);
                b();
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.HalfScreenBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            super.onCreate(bundle);
            this.f26652h = getIntent().getBooleanExtra("isActiveSign", false);
            a();
            showLikeDismissLadingPage();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, android.app.Activity
    public Dialog onCreateDialog(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            if (64 == i2) {
                return new PromptMultiBtnDialog(this);
            }
            return super.onCreateDialog(i2);
        }
        return (Dialog) invokeI.objValue;
    }

    @Override // com.baidu.wallet.paysdk.ui.HalfScreenBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onDestroy();
            Handler handler = this.f26648c;
            if (handler != null) {
                handler.removeCallbacks(this.f26647b);
            }
            com.baidu.wallet.paysdk.banksign.a.a.a().m();
            BeanManager.getInstance().removeAllBeans(TAG);
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, android.app.Activity
    public void onPrepareDialog(int i2, Dialog dialog) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048585, this, i2, dialog) == null) {
            if (64 == i2) {
                a(dialog);
            } else {
                super.onPrepareDialog(i2, dialog);
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onResume();
            if (this.f26649e) {
                Handler handler = this.f26648c;
                if (handler != null) {
                    handler.removeCallbacks(this.f26647b);
                }
                c();
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity
    public void showPaySuccessPage(boolean z, PayResultContent payResultContent, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Boolean.valueOf(z), payResultContent, Integer.valueOf(i2)}) == null) {
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            Runnable runnable = new Runnable(this, (com.baidu.wallet.paysdk.banksign.beans.c) BankSignFactory.getInstance().getBean((Context) getActivity(), 769, TAG)) { // from class: com.baidu.wallet.paysdk.ui.BusinessSignedGuideActivity.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.baidu.wallet.paysdk.banksign.beans.c f26654a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ BusinessSignedGuideActivity f26655b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r7};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f26655b = this;
                    this.f26654a = r7;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f26654a.setResponseCallback(this.f26655b);
                        this.f26654a.execBean();
                        this.f26655b.f26648c.postDelayed(this, 3000L);
                    }
                }
            };
            this.f26647b = runnable;
            this.f26648c.post(runnable);
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            this.f26649e = false;
            WalletGlobalUtils.safeShowDialog(this.mAct, -1, "");
            d dVar = (d) BankSignFactory.getInstance().getBean((Context) getActivity(), BankSignFactory.BEAN_ID_QUERY, TAG);
            if (!this.f26652h) {
                com.baidu.wallet.paysdk.banksign.a.a.a().a("");
                dVar.setResponseCallback(this);
                dVar.execBean();
                return;
            }
            dVar.execBean();
            finishWithoutAnim();
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            this.mActionBar.setVisibility(0);
            this.mLeftImg.setOnClickListener(this);
            WalletBaseButtonWithImage walletBaseButtonWithImage = (WalletBaseButtonWithImage) findViewById(ResUtils.id(getActivity(), "bd_wallet_sign_btn"));
            this.f26646a = walletBaseButtonWithImage;
            if (this.f26652h) {
                walletBaseButtonWithImage.setText(ResUtils.getString(getActivity(), "dxmpay_banksign_guide_sgin_btn"));
            } else {
                walletBaseButtonWithImage.setText(ResUtils.getString(getActivity(), "dxmpay_banksign_guide_pay_btn"));
            }
            this.f26646a.setDrawableLeftVisible(false);
            this.f26646a.setOnClickListener(this);
        }
    }

    private void a(Dialog dialog) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, dialog) == null) {
            PromptMultiBtnDialog promptMultiBtnDialog = (PromptMultiBtnDialog) dialog;
            QueryResponse queryResponse = this.f26650f;
            if (queryResponse == null) {
                return;
            }
            if (!TextUtils.isEmpty(queryResponse.dialog_title)) {
                promptMultiBtnDialog.setTitleMessage(this.f26650f.dialog_title);
            } else {
                promptMultiBtnDialog.setTitleMessage(ResUtils.getString(this.mAct, "dxmpay_banksign_dialog_title"));
            }
            if (!TextUtils.isEmpty(this.f26650f.dialog_hint)) {
                promptMultiBtnDialog.setMessage(this.f26650f.dialog_hint);
            }
            promptMultiBtnDialog.setFirstBtn(this.f26650f.dialog_options[0].msg, new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.BusinessSignedGuideActivity.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ BusinessSignedGuideActivity f26659a;

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
                    this.f26659a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        WalletGlobalUtils.safeDismissDialog(this.f26659a, 64);
                        BusinessSignedGuideActivity businessSignedGuideActivity = this.f26659a;
                        businessSignedGuideActivity.a(businessSignedGuideActivity.f26650f.dialog_options[0].type);
                    }
                }
            });
            promptMultiBtnDialog.setSecondBtn(this.f26650f.dialog_options[1].msg, new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.BusinessSignedGuideActivity.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ BusinessSignedGuideActivity f26660a;

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
                    this.f26660a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        WalletGlobalUtils.safeDismissDialog(this.f26660a, 64);
                        BusinessSignedGuideActivity businessSignedGuideActivity = this.f26660a;
                        businessSignedGuideActivity.a(businessSignedGuideActivity.f26650f.dialog_options[1].type);
                    }
                }
            });
            promptMultiBtnDialog.setThirdBtn(this.f26650f.dialog_options[2].msg, new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.BusinessSignedGuideActivity.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ BusinessSignedGuideActivity f26661a;

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
                    this.f26661a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        WalletGlobalUtils.safeDismissDialog(this.f26661a, 64);
                        BusinessSignedGuideActivity businessSignedGuideActivity = this.f26661a;
                        businessSignedGuideActivity.a(businessSignedGuideActivity.f26650f.dialog_options[2].type);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void a(String str) {
        char c2;
        PayRequest payRequest;
        CardData.BondCard cardByCardNo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, str) == null) {
            BankSignPayFlow a2 = BankSignPayFlow.a();
            this.f26651g = str;
            switch (str.hashCode()) {
                case -1367724422:
                    if (str.equals(QueryResponse.Options.CANCEL)) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -930533934:
                    if (str.equals(QueryResponse.Options.BIND_CARD)) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 110760:
                    if (str.equals("pay")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1221572179:
                    if (str.equals("change_paytype")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1235694497:
                    if (str.equals(QueryResponse.Options.JUMP_RESIGN)) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            if (c2 == 0) {
                if (this.f26653i == 1 && this.f26650f.sign_state == 2) {
                    c();
                } else {
                    e();
                }
            } else if (c2 == 1) {
                if (this.f26653i == 1 && this.f26650f.sign_state == 2) {
                    c();
                    return;
                }
                QueryResponse queryResponse = this.f26650f;
                if (queryResponse.sign_state == 5 && !TextUtils.isEmpty(queryResponse.sign_card_no) && (cardByCardNo = (payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY)).getCardByCardNo(this.f26650f.sign_card_no)) != null) {
                    payRequest.mBondCard = cardByCardNo;
                }
                a2.a(BankSignPayFlow.Action.Pay);
                a2.a(this.mAct);
                finishWithoutAnim();
            } else if (c2 == 2) {
                a2.a(BankSignPayFlow.Action.Cancel);
                a2.a(this.mAct);
                finishWithoutAnim();
            } else if (c2 == 3) {
                a2.a(BankSignPayFlow.Action.ChangePayType);
                a2.a(this.mAct);
                finishWithoutAnim();
            } else if (c2 != 4) {
            } else {
                a2.a(BankSignPayFlow.Action.BindCard);
                a2.a(this.mAct);
            }
        }
    }
}
