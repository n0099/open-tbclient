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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.base.widget.WalletBaseButtonWithImage;
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
import com.dxmpay.apollon.beans.IBeanResponseCallback;
import com.dxmpay.apollon.utils.CheckUtils;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.widget.dialog.PromptMultiBtnDialog;
import com.dxmpay.wallet.core.BaseActivity;
import com.dxmpay.wallet.core.beans.BeanManager;
import com.dxmpay.wallet.core.utils.WalletGlobalUtils;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.StatHelper;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes6.dex */
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

    /* renamed from: g  reason: collision with root package name */
    public static boolean f50873g;
    public transient /* synthetic */ FieldHolder $fh;
    public WalletBaseButtonWithImage a;

    /* renamed from: b  reason: collision with root package name */
    public Runnable f50874b;

    /* renamed from: c  reason: collision with root package name */
    public Handler f50875c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f50876d;

    /* renamed from: e  reason: collision with root package name */
    public QueryResponse f50877e;

    /* renamed from: f  reason: collision with root package name */
    public String f50878f;

    /* renamed from: h  reason: collision with root package name */
    public int f50879h;

    /* loaded from: classes6.dex */
    public static class a implements IBeanResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        @Override // com.dxmpay.apollon.beans.IBeanResponseCallback
        public void onBeanExecFailure(int i2, int i3, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIL(1048576, this, i2, i3, str) == null) {
                BusinessSignedGuideActivity.b(false, i3, str);
                StatHelper.cacheCodeAndMsg(i3 + "", str);
                BeanManager.getInstance().removeAllBeans("QueryBean");
            }
        }

        @Override // com.dxmpay.apollon.beans.IBeanResponseCallback
        public void onBeanExecSuccess(int i2, Object obj, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, obj, str) == null) {
                QueryResponse queryResponse = (QueryResponse) obj;
                StatHelper.cacheCodeAndMsg("0", StatHelper.SENSOR_OK);
                if (queryResponse != null) {
                    BusinessSignedGuideActivity.b(true, queryResponse.sign_state, queryResponse.agreement_trans_id);
                }
                BeanManager.getInstance().removeAllBeans("QueryBean");
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1695679058, "Lcom/baidu/wallet/paysdk/ui/BusinessSignedGuideActivity;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1695679058, "Lcom/baidu/wallet/paysdk/ui/BusinessSignedGuideActivity;");
        }
    }

    public BusinessSignedGuideActivity() {
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
        this.f50875c = new Handler();
        this.f50876d = false;
        this.f50878f = "";
        this.f50879h = 0;
    }

    private void d() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            if (TextUtils.isEmpty(this.f50877e.toast_msg) || !this.f50878f.equals("pay")) {
                i2 = 0;
            } else {
                GlobalUtils.toast(this, this.f50877e.toast_msg);
                i2 = 2000;
            }
            this.f50875c.postDelayed(new Runnable(this) { // from class: com.baidu.wallet.paysdk.ui.BusinessSignedGuideActivity.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BusinessSignedGuideActivity a;

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
                        this.a.e();
                    }
                }
            }, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            String str = this.f50877e.form_data;
            com.baidu.wallet.paysdk.banksign.a.a.a().a(str == null ? null : str.getBytes());
            com.baidu.wallet.paysdk.banksign.a.a.a().d(this.f50877e.form_url);
            com.baidu.wallet.paysdk.banksign.a.a.a().e(this.f50877e.webview_title);
            this.f50879h = 0;
            this.f50876d = true;
            f();
            BankSignPayFlow a2 = BankSignPayFlow.a();
            a2.a(BankSignPayFlow.Action.JumpResign);
            a2.a(this.mAct);
            this.f50875c.post(this.f50874b);
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            if (f50873g && !PayRequestCache.getInstance().isPaying()) {
                StatisticManager.onEventWithValues(PayStatServiceEvent.INITIATIVE_BANKSIGN_ENETR, StatHelper.collectData(StatHelper.getBankCode(), StatHelper.getCardType()));
                return;
            }
            List<String> collectData = StatHelper.collectData(StatHelper.getOrderNo(), StatHelper.getBankCode(), StatHelper.getCardType());
            StatHelper.setPayBankSign(true);
            StatisticManager.onEventWithValues(PayStatServiceEvent.PAY_BANKSIGN_ENTER, collectData);
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

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.dxmpay.wallet.core.beans.BeanActivity
    public void handleFailure(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(1048579, this, i2, i3, str) == null) || i2 == 769) {
            return;
        }
        if (i2 == 770) {
            StatHelper.cacheCodeAndMsg(i3 + "", str);
            b(false, i3, str);
            WalletGlobalUtils.safeDismissDialog(this.mAct, -1);
            GlobalUtils.toast(this, str);
        } else if (i2 == 771) {
            StatHelper.cacheCodeAndMsg(i3 + "", str);
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

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.dxmpay.wallet.core.beans.BeanActivity
    public void handleResponse(int i2, Object obj, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048580, this, i2, obj, str) == null) {
            int i3 = 2000;
            boolean z = true;
            if (i2 == 769) {
                PollingResponse pollingResponse = (PollingResponse) obj;
                Handler handler = this.f50875c;
                if (handler == null || pollingResponse == null || pollingResponse.has_sign_result != 1) {
                    return;
                }
                handler.removeCallbacks(this.f50874b);
                if (!TextUtils.isEmpty(pollingResponse.toast_msg)) {
                    GlobalUtils.toast(this.mAct, pollingResponse.toast_msg, 2000);
                }
                this.f50875c.postDelayed(new Runnable(this) { // from class: com.baidu.wallet.paysdk.ui.BusinessSignedGuideActivity.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ BusinessSignedGuideActivity a;

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
                        this.a = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            BaseActivity.clearTasksTopOf(this.a);
                        }
                    }
                }, 5000L);
            } else if (i2 != 770) {
                if (i2 == 771) {
                    StatHelper.cacheCodeAndMsg("0", StatHelper.SENSOR_OK);
                    BindCardResponse bindCardResponse = (BindCardResponse) obj;
                    if (bindCardResponse == null || TextUtils.isEmpty(bindCardResponse.sign_card_no)) {
                        return;
                    }
                    if (PayDataCache.getInstance().isFromPreCashier()) {
                        String g2 = com.baidu.wallet.paysdk.banksign.a.a.a().g(bindCardResponse.sign_card_no);
                        if (!TextUtils.isEmpty(g2)) {
                            PayDataCache.getInstance().setOrderExtraInfo(g2);
                        }
                    }
                    BankSignPayFlow a2 = BankSignPayFlow.a();
                    a2.a(BankSignPayFlow.Action.Cancel);
                    a2.a(this.mAct);
                }
            } else {
                WalletGlobalUtils.safeDismissDialog(this.mAct, -1);
                StatHelper.cacheCodeAndMsg("0", StatHelper.SENSOR_OK);
                QueryResponse queryResponse = (QueryResponse) obj;
                this.f50877e = queryResponse;
                if (queryResponse != null) {
                    this.f50879h++;
                    int i4 = queryResponse.sign_state;
                    b(true, i4, queryResponse.agreement_trans_id);
                    if (this.f50879h == 1 && i4 == 2) {
                        z = false;
                    }
                    if (!TextUtils.isEmpty(this.f50877e.agreement_trans_id) && z) {
                        com.baidu.wallet.paysdk.banksign.a.a.a().f(this.f50877e.agreement_trans_id);
                    }
                    switch (i4) {
                        case 1:
                            if (this.f50879h == 2) {
                                d();
                                return;
                            }
                            BankSignPayFlow a3 = BankSignPayFlow.a();
                            a3.a(BankSignPayFlow.Action.FirstFail);
                            a3.a(this.mAct);
                            return;
                        case 2:
                            if (this.f50879h == 2) {
                                d();
                                return;
                            } else if (this.f50877e.isGuidanceAvilable()) {
                                WalletGlobalUtils.safeShowDialog(this, 64, "");
                                return;
                            } else {
                                return;
                            }
                        case 3:
                        case 5:
                        case 6:
                            if (this.f50879h != 2 || TextUtils.isEmpty(this.f50877e.toast_msg)) {
                                i3 = 0;
                            } else {
                                GlobalUtils.toast(this, this.f50877e.toast_msg);
                            }
                            this.f50875c.postDelayed(new Runnable(this) { // from class: com.baidu.wallet.paysdk.ui.BusinessSignedGuideActivity.3
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ BusinessSignedGuideActivity a;

                                {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this};
                                        interceptable2.invokeUnInit(65536, newInitContext);
                                        int i5 = newInitContext.flag;
                                        if ((i5 & 1) != 0) {
                                            int i6 = i5 & 2;
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
                                    if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.a.f50877e.isGuidanceAvilable()) {
                                        WalletGlobalUtils.safeShowDialog(this.a, 64, "");
                                    }
                                }
                            }, i3);
                            return;
                        case 4:
                            if (this.f50879h == 2 && !TextUtils.isEmpty(this.f50877e.toast_msg) && this.f50878f.equals(QueryResponse.Options.JUMP_RESIGN)) {
                                GlobalUtils.toast(this, this.f50877e.toast_msg);
                            } else {
                                i3 = 0;
                            }
                            this.f50875c.postDelayed(new Runnable(this) { // from class: com.baidu.wallet.paysdk.ui.BusinessSignedGuideActivity.4
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ BusinessSignedGuideActivity a;

                                {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this};
                                        interceptable2.invokeUnInit(65536, newInitContext);
                                        int i5 = newInitContext.flag;
                                        if ((i5 & 1) != 0) {
                                            int i6 = i5 & 2;
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
                                        BankSignPayFlow a4 = BankSignPayFlow.a();
                                        a4.a(BankSignPayFlow.Action.Pay);
                                        a4.a(this.a.mAct);
                                        this.a.finishWithoutAnim();
                                    }
                                }
                            }, i3);
                            return;
                        default:
                            return;
                    }
                }
            }
        }
    }

    @Override // com.dxmpay.wallet.core.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            StatHelper.cacheCodeAndMsg(StatHelper.SENSOR_ERR_2, "BusinessSignGuideCancel");
            super.onBackPressed();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view) == null) {
            if (view == this.mLeftImg) {
                onBackPressed();
            } else if (view != this.a || CheckUtils.isFastDoubleClick()) {
            } else {
                f();
                this.f50877e = null;
                BankSignPayFlow a2 = BankSignPayFlow.a();
                a2.a(BankSignPayFlow.Action.JumpResign);
                a2.a(this.mAct);
                this.f50876d = true;
                this.a.setEnabled(false);
                b();
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.HalfScreenBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.beans.BeanActivity, com.dxmpay.wallet.core.BaseActivity, com.dxmpay.wallet.core.SDKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            super.onCreate(bundle);
            f50873g = getIntent().getBooleanExtra("isActiveSign", false);
            StatisticManager.onEventStart(PayStatServiceEvent.PAY_BANK_SIGN_DURATION);
            a();
            showLikeDismissLadingPage();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.BaseActivity, android.app.Activity
    public Dialog onCreateDialog(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            if (64 == i2) {
                return new PromptMultiBtnDialog(this);
            }
            return super.onCreateDialog(i2);
        }
        return (Dialog) invokeI.objValue;
    }

    @Override // com.baidu.wallet.paysdk.ui.HalfScreenBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onDestroy();
            Handler handler = this.f50875c;
            if (handler != null) {
                handler.removeCallbacks(this.f50874b);
            }
            HashMap hashMap = new HashMap();
            hashMap.put(StatHelper.BANK_SIGN_TYPE, f50873g ? "1" : "0");
            StatHelper.payEventEndWithValues(PayStatServiceEvent.PAY_BANK_SIGN_DURATION, hashMap, new String[0]);
            com.baidu.wallet.paysdk.banksign.a.a.a().m();
            BeanManager.getInstance().removeAllBeans(TAG);
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.BaseActivity, android.app.Activity
    public void onPrepareDialog(int i2, Dialog dialog) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048586, this, i2, dialog) == null) {
            if (64 == i2) {
                a(dialog);
            } else {
                super.onPrepareDialog(i2, dialog);
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.beans.BeanActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onResume();
            if (this.f50876d) {
                Handler handler = this.f50875c;
                if (handler != null) {
                    handler.removeCallbacks(this.f50874b);
                }
                c();
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity
    public void showPaySuccessPage(boolean z, PayResultContent payResultContent, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Boolean.valueOf(z), payResultContent, Integer.valueOf(i2)}) == null) {
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            Runnable runnable = new Runnable(this, (com.baidu.wallet.paysdk.banksign.beans.c) BankSignFactory.getInstance().getBean((Context) getActivity(), 769, TAG)) { // from class: com.baidu.wallet.paysdk.ui.BusinessSignedGuideActivity.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ com.baidu.wallet.paysdk.banksign.beans.c a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ BusinessSignedGuideActivity f50880b;

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
                    this.f50880b = this;
                    this.a = r7;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.a.setResponseCallback(this.f50880b);
                        this.a.execBean();
                        this.f50880b.f50875c.postDelayed(this, 3000L);
                    }
                }
            };
            this.f50874b = runnable;
            this.f50875c.post(runnable);
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            this.f50876d = false;
            WalletGlobalUtils.safeShowDialog(this.mAct, -1, "");
            d dVar = (d) BankSignFactory.getInstance().getBean((Context) getActivity(), BankSignFactory.BEAN_ID_QUERY, TAG);
            if (!f50873g) {
                com.baidu.wallet.paysdk.banksign.a.a.a().a("");
                dVar.setResponseCallback(this);
                dVar.execBean();
                return;
            }
            d dVar2 = (d) BankSignFactory.getInstance().getBean((Context) getActivity(), BankSignFactory.BEAN_ID_QUERY, "QueryBean");
            dVar2.execBean();
            dVar2.setResponseCallback(new a());
            finishWithoutAnim();
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.mActionBar.setVisibility(0);
            this.mLeftImg.setOnClickListener(this);
            WalletBaseButtonWithImage walletBaseButtonWithImage = (WalletBaseButtonWithImage) findViewById(ResUtils.id(getActivity(), "bd_wallet_sign_btn"));
            this.a = walletBaseButtonWithImage;
            if (f50873g) {
                walletBaseButtonWithImage.setText(ResUtils.getString(getActivity(), "dxmpay_banksign_guide_sgin_btn"));
            } else {
                walletBaseButtonWithImage.setText(ResUtils.getString(getActivity(), "dxmpay_banksign_guide_pay_btn"));
            }
            this.a.setDrawableLeftVisible(false);
            this.a.setOnClickListener(this);
        }
    }

    public static void b(boolean z, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65547, null, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), str}) == null) {
            if (z) {
                if (f50873g && !PayRequestCache.getInstance().isPaying()) {
                    String bankCode = StatHelper.getBankCode();
                    StatisticManager.onEventWithValues(PayStatServiceEvent.INITIATIVE_BANKSIGN_RESULT, StatHelper.collectData(bankCode, StatHelper.getCardType(), i2 + "", str));
                    return;
                }
                String orderNo = StatHelper.getOrderNo();
                StatisticManager.onEventWithValues(PayStatServiceEvent.PAY_BANKSIGN_RESULT, StatHelper.collectData(orderNo, StatHelper.getBankCode(), StatHelper.getCardType(), i2 + "", str));
            } else if (f50873g && !PayRequestCache.getInstance().isPaying()) {
                String bankCode2 = StatHelper.getBankCode();
                StatisticManager.onEventWithValues("pay_banksign_error", StatHelper.collectData(bankCode2, StatHelper.getCardType(), i2 + "", str));
            } else {
                String orderNo2 = StatHelper.getOrderNo();
                StatisticManager.onEventWithValues("pay_banksign_error", StatHelper.collectData(orderNo2, StatHelper.getBankCode(), StatHelper.getCardType(), i2 + "", str));
            }
        }
    }

    private void a(Dialog dialog) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, dialog) == null) {
            PromptMultiBtnDialog promptMultiBtnDialog = (PromptMultiBtnDialog) dialog;
            QueryResponse queryResponse = this.f50877e;
            if (queryResponse == null) {
                return;
            }
            if (!TextUtils.isEmpty(queryResponse.dialog_title)) {
                promptMultiBtnDialog.setTitleMessage(this.f50877e.dialog_title);
            } else {
                promptMultiBtnDialog.setTitleMessage(ResUtils.getString(this.mAct, "dxmpay_banksign_dialog_title"));
            }
            if (!TextUtils.isEmpty(this.f50877e.dialog_hint)) {
                promptMultiBtnDialog.setMessage(this.f50877e.dialog_hint);
            }
            promptMultiBtnDialog.setFirstBtn(this.f50877e.dialog_options[0].msg, new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.BusinessSignedGuideActivity.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BusinessSignedGuideActivity a;

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
                        WalletGlobalUtils.safeDismissDialog(this.a, 64);
                        BusinessSignedGuideActivity businessSignedGuideActivity = this.a;
                        businessSignedGuideActivity.a(businessSignedGuideActivity.f50877e.dialog_options[0].type);
                    }
                }
            });
            promptMultiBtnDialog.setSecondBtn(this.f50877e.dialog_options[1].msg, new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.BusinessSignedGuideActivity.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BusinessSignedGuideActivity a;

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
                        WalletGlobalUtils.safeDismissDialog(this.a, 64);
                        BusinessSignedGuideActivity businessSignedGuideActivity = this.a;
                        businessSignedGuideActivity.a(businessSignedGuideActivity.f50877e.dialog_options[1].type);
                    }
                }
            });
            promptMultiBtnDialog.setThirdBtn(this.f50877e.dialog_options[2].msg, new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.BusinessSignedGuideActivity.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BusinessSignedGuideActivity a;

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
                        WalletGlobalUtils.safeDismissDialog(this.a, 64);
                        BusinessSignedGuideActivity businessSignedGuideActivity = this.a;
                        businessSignedGuideActivity.a(businessSignedGuideActivity.f50877e.dialog_options[2].type);
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
        if (interceptable == null || interceptable.invokeL(65543, this, str) == null) {
            BankSignPayFlow a2 = BankSignPayFlow.a();
            this.f50878f = str;
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
                if (this.f50879h == 1 && this.f50877e.sign_state == 2) {
                    c();
                } else {
                    e();
                }
            } else if (c2 == 1) {
                if (this.f50879h == 1 && this.f50877e.sign_state == 2) {
                    c();
                    return;
                }
                QueryResponse queryResponse = this.f50877e;
                if (queryResponse.sign_state == 5 && !TextUtils.isEmpty(queryResponse.sign_card_no) && (cardByCardNo = (payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY)).getCardByCardNo(this.f50877e.sign_card_no)) != null) {
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
