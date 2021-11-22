package com.baidu.wallet.newbindcard.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.newbindcard.NewBindCardEntry;
import com.baidu.wallet.newbindcard.c.a;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.beans.r;
import com.baidu.wallet.paysdk.beans.y;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.CardAddResponse;
import com.baidu.wallet.paysdk.datamodel.GetCardInfoResponse;
import com.baidu.wallet.paysdk.datamodel.QueryBankBinResponse;
import com.baidu.wallet.paysdk.fingerprint.entrance.DxmCheckFingerprint;
import com.baidu.wallet.paysdk.payresult.datamodel.PayResultContent;
import com.baidu.wallet.paysdk.payresult.presenter.H5LifeCycleCallback;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.ui.PayBaseActivity;
import com.baidu.wallet.paysdk.ui.SignChannelListActivity;
import com.baidu.wallet.router.LocalRouter;
import com.baidu.wallet.router.RouterCallback;
import com.baidu.wallet.router.RouterRequest;
import com.baidu.walletsdk.pay.R;
import com.dxmpay.apollon.base.widget.NetImageView;
import com.dxmpay.apollon.eventbus.EventBus;
import com.dxmpay.apollon.utils.Base64Utils;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.apollon.utils.LogUtil;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.apollon.utils.support.Base64;
import com.dxmpay.wallet.api.BaiduWalletDelegate;
import com.dxmpay.wallet.base.datamodel.UserData;
import com.dxmpay.wallet.base.widget.DivisionEditText;
import com.dxmpay.wallet.base.widget.SafeKeyBoardEditText;
import com.dxmpay.wallet.base.widget.SafeScrollView;
import com.dxmpay.wallet.base.widget.dialog.PromptDialog;
import com.dxmpay.wallet.core.beans.BeanManager;
import com.dxmpay.wallet.core.lollipop.json.JSONException;
import com.dxmpay.wallet.core.lollipop.json.JSONObject;
import com.dxmpay.wallet.core.utils.WalletGlobalUtils;
import com.dxmpay.wallet.paysdk.datamodel.SdkInitResponse;
import com.dxmpay.wallet.paysdk.entrance.EnterDxmPayServiceAction;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.StatHelper;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public class NewBindCardEnterActivity extends PayBaseActivity implements View.OnClickListener, SafeKeyBoardEditText.OnMyFocusChangeListener {
    public static /* synthetic */ Interceptable $ic;
    public static boolean o;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ViewGroup f60227a;

    /* renamed from: b  reason: collision with root package name */
    public SafeScrollView f60228b;

    /* renamed from: c  reason: collision with root package name */
    public DivisionEditText f60229c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f60230d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f60231e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f60232f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f60233g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f60234h;

    /* renamed from: i  reason: collision with root package name */
    public NetImageView f60235i;
    public TextView j;
    public TextView k;
    public CardAddResponse l;
    public BindFastRequest m;
    public RelativeLayout n;
    public String p;
    public boolean q;
    public int r;
    public GetCardInfoResponse s;
    public View t;
    public String u;
    public boolean v;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(560588848, "Lcom/baidu/wallet/newbindcard/ui/NewBindCardEnterActivity;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(560588848, "Lcom/baidu/wallet/newbindcard/ui/NewBindCardEnterActivity;");
        }
    }

    public NewBindCardEnterActivity() {
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
        this.q = false;
        this.r = 100027;
        this.v = false;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        SafeScrollView safeScrollView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
            if (motionEvent.getAction() == 0 && !a(this.f60230d, motionEvent) && (safeScrollView = this.f60228b) != null && safeScrollView.isShouldHideInput(getCurrentFocus(), motionEvent) && this.f60228b.isPopupWindowShowing()) {
                this.f60229c.clearFocus();
                this.f60228b.dismissKeyBoard(this.f60229c);
                if (this.f60234h) {
                    this.f60230d.setImageResource(R.drawable.dxm_wallet_new_bind_card_camera_icon);
                    this.f60230d.setOnClickListener(this);
                } else {
                    this.f60230d.setVisibility(8);
                }
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public String formatCardNo(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
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

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.dxmpay.wallet.core.beans.BeanActivity
    public void handleFailure(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i2, i3, str) == null) {
            WalletGlobalUtils.safeDismissDialog(this, -2);
            if (i2 != 7 && i2 == 4) {
                this.mDialogMsg = str;
                if (i3 == 100010) {
                    b(true);
                } else if (i3 == 100040 || i3 == 100026) {
                    WalletGlobalUtils.safeShowDialog(this, 3, "");
                } else if (i3 == 100028) {
                    this.r = i3;
                    this.q = false;
                    WalletGlobalUtils.safeShowDialog(this, 33, "");
                } else if (i3 == -8) {
                    if (TextUtils.isEmpty(str)) {
                        str = getString(ResUtils.string(getActivity(), "dxm_ebpay_no_network"));
                    }
                    GlobalUtils.toast(this, str);
                } else {
                    WalletGlobalUtils.safeShowDialog(this, 12, "");
                }
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.dxmpay.wallet.core.beans.BeanActivity
    public void handleResponse(int i2, Object obj, String str) {
        int i3;
        QueryBankBinResponse queryBankBinResponse;
        GetCardInfoResponse.CardInfo cardInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048579, this, i2, obj, str) == null) {
            WalletGlobalUtils.safeDismissDialog(this, -2);
            if (i2 == 7) {
                if (obj == null || !(obj instanceof QueryBankBinResponse) || (queryBankBinResponse = (QueryBankBinResponse) obj) == null || (cardInfo = queryBankBinResponse.card_info) == null) {
                    return;
                }
                a.a(cardInfo.front_bank_code);
                a.b(queryBankBinResponse.card_info.card_type + "");
                a(queryBankBinResponse.card_info);
            } else if (i2 == 4) {
                GetCardInfoResponse getCardInfoResponse = (GetCardInfoResponse) obj;
                this.s = getCardInfoResponse;
                if (getCardInfoResponse == null) {
                    return;
                }
                a(getCardInfoResponse.card_info);
                this.r = -1;
                this.mDialogMsg = "";
                Map<String, String> map = this.s.cashdesk;
                if (map != null && map.size() > 0) {
                    PayDataCache.getInstance().setSessionData(this.s.cashdesk);
                }
                GetCardInfoResponse.CardInfo cardInfo2 = this.s.card_info;
                if (cardInfo2 != null) {
                    a.a(cardInfo2.bank_no);
                    a.b(this.s.card_info.card_type + "");
                }
                GetCardInfoResponse.Algorithm algorithm = this.s.algorithm_check_info;
                if (algorithm != null && (i3 = algorithm.code) == 100027) {
                    this.r = i3;
                    this.mDialogMsg = algorithm.msg;
                    this.q = false;
                    WalletGlobalUtils.safeShowDialog(this, 33, "");
                    return;
                }
                GetCardInfoResponse.BindCardInfo bindCardInfo = this.s.bind_card_info;
                if (bindCardInfo != null && !TextUtils.isEmpty(bindCardInfo.bind_card_desc)) {
                    this.r = 100027;
                    this.mDialogMsg = this.s.bind_card_info.bind_card_desc;
                    this.q = true;
                    WalletGlobalUtils.safeShowDialog(this, 33, "");
                    return;
                }
                a(this.s);
            }
        }
    }

    @Override // com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048580, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i2 != 40976 || i3 != -1 || intent == null || intent.getExtras() == null) {
                return;
            }
            b(intent.getExtras().getString("subbankcode"));
        }
    }

    @Override // com.dxmpay.wallet.core.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            NewBindCardEntry.getInstance().newBindCardCallback(StatHelper.SENSOR_ERR_2, "NewBindCardEnterActivity onBackPressed", false);
            super.onBackPressed();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, view) == null) && view == this.f60230d) {
            a.a(PayStatServiceEvent.NEW_CLICK_BANK_DETECT, new String[0]);
            LocalRouter.getInstance(this).route(this, new RouterRequest().provider("bankdetection").action("bankcarddetction"), new RouterCallback(this) { // from class: com.baidu.wallet.newbindcard.ui.NewBindCardEnterActivity.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ NewBindCardEnterActivity f60250a;

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
                    this.f60250a = this;
                }

                @Override // com.baidu.wallet.router.RouterCallback
                public void onResult(int i2, HashMap hashMap) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, hashMap) == null) {
                        if (i2 == 0) {
                            if (hashMap == null || TextUtils.isEmpty((String) hashMap.get("card_num"))) {
                                return;
                            }
                            String str = (String) hashMap.get("card_num");
                            if (TextUtils.isEmpty(str) || str.equals(this.f60250a.f60229c.getRealText())) {
                                return;
                            }
                            if (str.length() > 10) {
                                this.f60250a.a(str.substring(0, 10));
                            }
                            this.f60250a.f60229c.setText(str);
                            this.f60250a.f60229c.setSelection(this.f60250a.f60229c.getText().toString().length());
                            this.f60250a.f60229c.requestFocus();
                            this.f60250a.f60232f.setEnabled(true);
                        } else if (i2 == 5) {
                            StatHelper.bankCardDetction(PayStatServiceEvent.BANKCARD_DETCTION_ERROR, i2 + "");
                            HashMap hashMap2 = new HashMap();
                            hashMap2.put("provider", "bankdetection");
                            hashMap2.put("action", "bankcarddetction");
                            StatisticManager.onEventEndWithValues("sdk_router_error", i2, hashMap2.values());
                        } else {
                            StatHelper.bankCardDetction(PayStatServiceEvent.BANKCARD_DETCTION_ERROR, i2 + "");
                        }
                    }
                }
            });
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.beans.BeanActivity, com.dxmpay.wallet.core.BaseActivity, com.dxmpay.wallet.core.SDKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.wallet_cashdesk_new_bind_card_enter_activity);
            setFlagActiveBindCard();
            CardAddResponse cardAddResponse = CardAddResponse.getInstance();
            this.l = cardAddResponse;
            if (cardAddResponse == null) {
                NewBindCardEntry.getInstance().newBindCardCallback(StatHelper.SENSOR_ERR_2, "NewBindCardEnterActivity CardAddResponse is null", false);
                return;
            }
            BindFastRequest bindReq = NewBindCardEntry.getInstance().getBindReq();
            this.m = bindReq;
            if (bindReq == null) {
                NewBindCardEntry.getInstance().newBindCardCallback(StatHelper.SENSOR_ERR_2, "NewBindCardEnterActivity mBindFastRequest is null", false);
            } else {
                b();
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.BaseActivity, android.app.Activity
    public Dialog onCreateDialog(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) ? super.onCreateDialog(i2) : (Dialog) invokeI.objValue;
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.v = false;
            SafeScrollView safeScrollView = this.f60228b;
            if (safeScrollView != null && safeScrollView.isPopupWindowShowing()) {
                this.f60228b.dismissKeyBoard(this.f60229c);
            }
            BeanManager.getInstance().removeAllBeans("NewBindCardEnterActivity");
            EventBus.getInstance().unregister(this, BeanConstants.EVENT_H5_QUICK_BIND_CARD);
            if (this.f60234h) {
                LocalRouter.getInstance(this.mAct).route(this.mAct, new RouterRequest().provider("bankdetection").action("clearcallback"), new RouterCallback(this) { // from class: com.baidu.wallet.newbindcard.ui.NewBindCardEnterActivity.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ NewBindCardEnterActivity f60247a;

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
                        this.f60247a = this;
                    }

                    @Override // com.baidu.wallet.router.RouterCallback
                    public void onResult(int i2, HashMap hashMap) {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, hashMap) == null) && i2 == 5) {
                            HashMap hashMap2 = new HashMap();
                            hashMap2.put("provider", "bankcarddetection");
                            hashMap2.put("action", "clearcallback");
                            StatisticManager.onEventEndWithValues("sdk_router_error", i2, hashMap2.values());
                        }
                    }
                });
            }
            super.onDestroy();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity
    public void onModuleEvent(EventBus.Event event) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, event) == null) || event == null || !BeanConstants.EVENT_H5_QUICK_BIND_CARD.equals(event.mEventKey) || event.mEventObj == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject((String) event.mEventObj);
            if (jSONObject.has("bind_card_result") && 1 == jSONObject.getInt("bind_card_result")) {
                o = true;
                this.u = jSONObject.optString("card_no", "");
                a.a(PayStatServiceEvent.NEW_QUICK_BIND_SUCCESS, a.a());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.dxmpay.wallet.base.widget.SafeKeyBoardEditText.OnMyFocusChangeListener
    public void onMyFocusChange(View view, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048587, this, view, z) == null) && view == this.f60229c) {
            ViewGroup.LayoutParams layoutParams = this.t.getLayoutParams();
            if (z) {
                this.t.setBackgroundColor(ResUtils.getColor(this, "wallet_cashdesk_new_bind_card_2222"));
                layoutParams.height = (int) ResUtils.getDimension(this, "wallet_cashdesk_new_bind_card_hasfocus_line_size");
                if (!TextUtils.isEmpty(this.f60229c.getRealText())) {
                    d();
                } else if (this.f60234h) {
                    this.f60230d.setImageResource(R.drawable.dxm_wallet_new_bind_card_camera_icon);
                    this.f60230d.setOnClickListener(this);
                } else {
                    this.f60230d.setVisibility(8);
                }
            } else {
                this.t.setBackgroundColor(ResUtils.getColor(this, "wallet_cashdesk_new_bind_card_E0EA"));
                layoutParams.height = (int) ResUtils.getDimension(this, "wallet_cashdesk_new_bind_card_line_size");
            }
            this.t.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onPause();
            this.f60229c.clearFocus();
            this.f60228b.dismissKeyBoard();
            EventBus.getInstance().unregister(this, "ev_bean_execut_err_content");
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.BaseActivity, android.app.Activity
    public void onPrepareDialog(int i2, Dialog dialog) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048589, this, i2, dialog) == null) {
            if (i2 == 3) {
                PromptDialog promptDialog = (PromptDialog) dialog;
                promptDialog.setMessage(this.mDialogMsg);
                if (!TextUtils.isEmpty(this.p)) {
                    promptDialog.setTitleText(formatCardNo(this.p));
                }
                a.a(PayStatServiceEvent.NEW_NOT_SUPPORT_BANK_DIALOG, new String[0]);
                promptDialog.setCanceledOnTouchOutside(false);
                promptDialog.setNegativeBtn(ResUtils.string(getActivity(), "ebpay_choose_credit_tip2"), new View.OnClickListener(this) { // from class: com.baidu.wallet.newbindcard.ui.NewBindCardEnterActivity.12
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ NewBindCardEnterActivity f60239a;

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
                        this.f60239a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            a.a(PayStatServiceEvent.NEW_CLICK_SUPPORT_BANK, new String[0]);
                            WalletGlobalUtils.safeDismissDialog(this.f60239a, 3);
                            this.f60239a.b(false);
                        }
                    }
                });
                promptDialog.setPositiveBtn(ResUtils.string(getActivity(), "dxm_ebpay_confirm"), new View.OnClickListener(this) { // from class: com.baidu.wallet.newbindcard.ui.NewBindCardEnterActivity.13
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ NewBindCardEnterActivity f60240a;

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
                        this.f60240a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            a.a(PayStatServiceEvent.NEW_NOT_SUPPORT_CHANGE_CARD, new String[0]);
                            WalletGlobalUtils.safeDismissDialog(this.f60240a, 3);
                        }
                    }
                });
            } else if (i2 == 12) {
                PromptDialog promptDialog2 = (PromptDialog) dialog;
                promptDialog2.setMessage(this.mDialogMsg);
                promptDialog2.setCanceledOnTouchOutside(false);
                a.a(PayStatServiceEvent.NEW_CARD_INFO_ERR_DIALOG, new String[0]);
                promptDialog2.setPositiveBtn(ResUtils.string(getActivity(), "dxm_ebpay_know"), new View.OnClickListener(this) { // from class: com.baidu.wallet.newbindcard.ui.NewBindCardEnterActivity.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ NewBindCardEnterActivity f60243a;

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
                        this.f60243a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            a.a(PayStatServiceEvent.NEW_CARD_INFO_ERR_CLICK, new String[0]);
                            WalletGlobalUtils.safeDismissDialog(this.f60243a, 12);
                        }
                    }
                });
                promptDialog2.hideNegativeButton();
            } else if (i2 != 33) {
                super.onPrepareDialog(i2, dialog);
            } else {
                PromptDialog promptDialog3 = (PromptDialog) dialog;
                promptDialog3.setMessage(this.mDialogMsg);
                if (!this.q && !TextUtils.isEmpty(this.p)) {
                    if (this.q) {
                        promptDialog3.setTitleText(ResUtils.string(getActivity(), "dxm_ebpay_tip"));
                    } else {
                        promptDialog3.setTitleText(formatCardNo(this.p));
                    }
                }
                a.a(PayStatServiceEvent.NEW_BIND_CARD_CHECK_DIALOG, a.a(), a.b());
                promptDialog3.setCanceledOnTouchOutside(false);
                String string = ResUtils.getString(getActivity(), this.q ? "ebpay_choose_bind_sure" : "ebpay_choose_modify_card");
                String string2 = ResUtils.getString(getActivity(), this.q ? "ebpay_choose_bind_continue" : "ebpay_choose_confirm");
                promptDialog3.setNegativeBtn(string, new View.OnClickListener(this) { // from class: com.baidu.wallet.newbindcard.ui.NewBindCardEnterActivity.14
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ NewBindCardEnterActivity f60241a;

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
                        this.f60241a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            a.a(PayStatServiceEvent.NEW_BIND_CARD_CHECK_DIALOG_MODIFY, a.a(), a.b());
                            WalletGlobalUtils.safeDismissDialog(this.f60241a, 33);
                        }
                    }
                });
                promptDialog3.setPositiveBtn(string2, new View.OnClickListener(this) { // from class: com.baidu.wallet.newbindcard.ui.NewBindCardEnterActivity.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ NewBindCardEnterActivity f60242a;

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
                        this.f60242a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            WalletGlobalUtils.safeDismissDialog(this.f60242a, 33);
                            a.a(PayStatServiceEvent.NEW_CONFIRM_CARD_NO, a.a(), a.b());
                            if (this.f60242a.r != 100027) {
                                if (this.f60242a.r == 100028) {
                                    this.f60242a.b(true);
                                    return;
                                }
                                return;
                            }
                            NewBindCardEnterActivity newBindCardEnterActivity = this.f60242a;
                            newBindCardEnterActivity.a(newBindCardEnterActivity.s);
                        }
                    }
                });
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.beans.BeanActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onResume();
            this.f60229c.requestFocus();
            EventBus.getInstance().registerSticky(this, "ev_bean_execut_err_content", 0, EventBus.ThreadMode.MainThread);
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity
    public void showPaySuccessPage(boolean z, PayResultContent payResultContent, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Boolean.valueOf(z), payResultContent, Integer.valueOf(i2)}) == null) {
        }
    }

    private void e() {
        UserData.UserModel userModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65564, this) == null) {
            CardAddResponse cardAddResponse = this.l;
            if (cardAddResponse != null && (userModel = cardAddResponse.user) != null) {
                String str = userModel.true_name;
                if (!TextUtils.isEmpty(str) && 1 == this.l.user.has_mobile_password) {
                    DivisionEditText divisionEditText = this.f60229c;
                    divisionEditText.setHint("请输入" + str + "的银行卡号");
                }
            }
            this.f60229c.addTextChangedListener(new TextWatcher(this) { // from class: com.baidu.wallet.newbindcard.ui.NewBindCardEnterActivity.10
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ NewBindCardEnterActivity f60237a;

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
                    this.f60237a = this;
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, editable) == null) {
                        this.f60237a.f60230d.setVisibility(0);
                        if (!this.f60237a.f60234h || editable.length() != 0) {
                            this.f60237a.d();
                            String realText = this.f60237a.f60229c.getRealText();
                            if (TextUtils.isEmpty(realText)) {
                                this.f60237a.f60230d.setVisibility(8);
                                this.f60237a.f60229c.setTypeface(Typeface.defaultFromStyle(0));
                                return;
                            }
                            this.f60237a.f60229c.setTypeface(Typeface.defaultFromStyle(1));
                            if (realText.length() == 10) {
                                this.f60237a.a(realText);
                                this.f60237a.f60232f.setEnabled(true);
                                return;
                            } else if (realText.length() < 10) {
                                this.f60237a.f60231e.setVisibility(8);
                                this.f60237a.f60232f.setEnabled(false);
                                return;
                            } else {
                                this.f60237a.f60232f.setEnabled(true);
                                return;
                            }
                        }
                        this.f60237a.f60230d.setImageResource(R.drawable.dxm_wallet_new_bind_card_camera_icon);
                        this.f60237a.f60229c.setTypeface(Typeface.defaultFromStyle(0));
                        this.f60237a.f60230d.setOnClickListener(this.f60237a);
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
            this.f60229c.setOnMyFocusChangeListener(this);
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65566, this) == null) {
            this.f60232f.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.newbindcard.ui.NewBindCardEnterActivity.11
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ NewBindCardEnterActivity f60238a;

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
                    this.f60238a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        if (!this.f60238a.v) {
                            this.f60238a.v = true;
                            a.a(PayStatServiceEvent.NEW_NA_BIND_CARD_ENTER, new String[0]);
                        }
                        this.f60238a.f60228b.dismissKeyBoard(this.f60238a.f60229c);
                        NewBindCardEnterActivity newBindCardEnterActivity = this.f60238a;
                        newBindCardEnterActivity.p = newBindCardEnterActivity.f60229c.getRealText();
                        a.a(PayStatServiceEvent.NEW_CLICK_SUBMIT_CARD, a.a(), a.b());
                        this.f60238a.b("");
                    }
                }
            });
        }
    }

    private void g() {
        CardAddResponse.QuickBindCardList[] quickBindCardListArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65568, this) == null) {
            this.f60233g.removeAllViews();
            CardAddResponse cardAddResponse = this.l;
            if (cardAddResponse != null && (quickBindCardListArr = cardAddResponse.bank_list) != null && quickBindCardListArr.length > 0) {
                for (int i2 = 0; i2 < quickBindCardListArr.length; i2++) {
                    CardAddResponse.QuickBindCardList quickBindCardList = quickBindCardListArr[i2];
                    if (quickBindCardList != null) {
                        View inflate = LayoutInflater.from(this).inflate(R.layout.wallet_base_new_quick_support_bank_card_item, (ViewGroup) null);
                        View findViewById = inflate.findViewById(R.id.view_line);
                        ((NetImageView) inflate.findViewById(R.id.iv_new_quick_support_bank_icon)).setImageUrl(quickBindCardList.bank_icon_url);
                        ((TextView) inflate.findViewById(R.id.tv_new_quick_support_bank_name)).setText(quickBindCardList.bank_name);
                        if (i2 == quickBindCardListArr.length - 1) {
                            findViewById.setVisibility(8);
                        }
                        this.f60233g.addView(inflate);
                        inflate.setOnClickListener(new View.OnClickListener(this, quickBindCardList) { // from class: com.baidu.wallet.newbindcard.ui.NewBindCardEnterActivity.4
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ CardAddResponse.QuickBindCardList f60244a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ NewBindCardEnterActivity f60245b;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, quickBindCardList};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i3 = newInitContext.flag;
                                    if ((i3 & 1) != 0) {
                                        int i4 = i3 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f60245b = this;
                                this.f60244a = quickBindCardList;
                            }

                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                                    a.a(this.f60244a.bank_uniq_code);
                                    a.a(PayStatServiceEvent.NEW_ENTER_QULICK_BIND, this.f60244a.bank_uniq_code);
                                    Bundle bundle = new Bundle();
                                    String quickBindCardUrl = SdkInitResponse.getInstance().getQuickBindCardUrl(this.f60245b);
                                    if (TextUtils.isEmpty(quickBindCardUrl)) {
                                        quickBindCardUrl = BeanConstants.API_QUICK_BIND_CARD_URL;
                                    }
                                    StringBuffer stringBuffer = new StringBuffer();
                                    stringBuffer.append(quickBindCardUrl);
                                    CardAddResponse.QuickBindCardTypeList[] quickBindCardTypeListArr = this.f60244a.type;
                                    if (quickBindCardTypeListArr != null && quickBindCardTypeListArr.length > 0) {
                                        for (int i3 = 0; i3 < this.f60244a.type.length; i3++) {
                                            stringBuffer.append("card_type");
                                            stringBuffer.append(this.f60244a.type[i3].card_type);
                                            stringBuffer.append("=");
                                            stringBuffer.append(this.f60244a.type[i3].front_bank_code);
                                            stringBuffer.append("&");
                                        }
                                    }
                                    stringBuffer.append("device_biometrics=");
                                    if (this.f60245b.l.support_pwd_info != null && this.f60245b.l.support_pwd_info.length > 0 && "finger".equalsIgnoreCase(this.f60245b.l.support_pwd_info[0].verify_type)) {
                                        stringBuffer.append("1&");
                                    } else {
                                        stringBuffer.append("0&");
                                    }
                                    stringBuffer.append("verify_type=2&");
                                    stringBuffer.append("max_retry=");
                                    stringBuffer.append(this.f60245b.l.support_pwd_info[0].max_retry);
                                    if (this.f60245b.m != null) {
                                        stringBuffer.append("&session_id=");
                                        stringBuffer.append(this.f60245b.m.getSessionId());
                                    }
                                    stringBuffer.append("&is_from_sdk=1");
                                    LogUtil.d("----d", stringBuffer.toString());
                                    H5LifeCycleCallback h5LifeCycleCallback = new H5LifeCycleCallback(this) { // from class: com.baidu.wallet.newbindcard.ui.NewBindCardEnterActivity.4.1
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;

                                        /* renamed from: a  reason: collision with root package name */
                                        public final /* synthetic */ AnonymousClass4 f60246a;

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
                                            this.f60246a = this;
                                        }

                                        @Override // com.baidu.wallet.paysdk.payresult.presenter.H5LifeCycleCallback, android.app.Application.ActivityLifecycleCallbacks
                                        public void onActivityDestroyed(Activity activity) {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 == null || interceptable3.invokeL(1048576, this, activity) == null) {
                                                pop();
                                                if (NewBindCardEnterActivity.o) {
                                                    NewBindCardEntry.getInstance().newBindCardCallback("0", this.f60246a.f60245b.u, true);
                                                }
                                                this.f60246a.f60245b.u = null;
                                                boolean unused = NewBindCardEnterActivity.o = false;
                                            }
                                        }
                                    };
                                    bundle.putBoolean("with_anim", false);
                                    bundle.putBoolean("show_share", false);
                                    bundle.putString("url", stringBuffer.toString());
                                    bundle.putParcelable("lifecycleLsnr", h5LifeCycleCallback);
                                    h5LifeCycleCallback.push();
                                    EventBus.getInstance().register(this.f60245b, BeanConstants.EVENT_H5_QUICK_BIND_CARD, 0, EventBus.ThreadMode.MainThread);
                                    BaiduWalletDelegate.getInstance().openH5Module(this.f60245b, bundle);
                                }
                            }
                        });
                    }
                }
                return;
            }
            this.f60233g.setVisibility(8);
        }
    }

    private void c() {
        CardAddResponse cardAddResponse;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65559, this) == null) {
            if (LocalRouter.getInstance(getActivity()).isProviderExisted("bankdetection") && (cardAddResponse = this.l) != null && "1".equals(cardAddResponse.bank_card_detect_enabled)) {
                this.f60234h = true;
            } else {
                this.f60234h = false;
            }
            if (this.f60234h) {
                this.f60230d.setImageResource(R.drawable.dxm_wallet_new_bind_card_camera_icon);
            } else {
                this.f60230d.setImageResource(R.drawable.dxm_wallet_base_delete);
            }
            this.f60229c.setUseSafeKeyBoard(true);
            this.f60229c.setViewType(25);
            if (this.f60234h && TextUtils.isEmpty(this.f60229c.getRealText())) {
                this.f60230d.setOnClickListener(this);
            } else {
                d();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65563, this) == null) {
            this.f60230d.setImageResource(R.drawable.dxm_wallet_base_delete);
            this.f60230d.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.newbindcard.ui.NewBindCardEnterActivity.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ NewBindCardEnterActivity f60251a;

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
                    this.f60251a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f60251a.f60229c.setText("");
                        this.f60251a.f60231e.setVisibility(8);
                        this.f60251a.f60232f.setEnabled(false);
                    }
                }
            });
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
            this.f60227a = (ViewGroup) findViewById(R.id.new_bind_card_enter_activity);
            this.f60228b = (SafeScrollView) findViewById(R.id.scroll_bindcard_enter);
            this.f60229c = (DivisionEditText) findViewById(R.id.et_new_bank_card_no);
            this.f60230d = (ImageView) findViewById(R.id.iv_new_bind_card_icon);
            this.f60231e = (LinearLayout) findViewById(R.id.lin_new_bank_card_info);
            this.f60232f = (LinearLayout) findViewById(R.id.btn_new_bank_card_submit);
            this.f60235i = (NetImageView) findViewById(R.id.iv_new_bankinfo_logo);
            this.j = (TextView) findViewById(R.id.tv_new_bankinfo_name);
            this.f60233g = (LinearLayout) findViewById(R.id.lin_support_bank_list);
            this.n = (RelativeLayout) findViewById(R.id.title_left_imgzone2);
            this.k = (TextView) findViewById(R.id.tv_support_bank);
            this.t = findViewById(R.id.view_line);
            if (!"walletapp".equalsIgnoreCase(com.dxmpay.wallet.core.beans.BeanConstants.CHANNEL_ID) && !com.dxmpay.wallet.core.beans.BeanConstants.CHANNEL_ID_WALLET_APP_PRO.equalsIgnoreCase(com.dxmpay.wallet.core.beans.BeanConstants.CHANNEL_ID)) {
                this.f60232f.setBackgroundResource(R.drawable.dxm_wallet_base_blue_397be6_btn);
            } else {
                this.f60232f.setBackgroundResource(R.drawable.dxm_wallet_base_red_fa5050_btn);
            }
            this.f60232f.setEnabled(false);
            this.f60231e.setVisibility(8);
            DivisionEditText divisionEditText = this.f60229c;
            divisionEditText.initSafeKeyBoardParams(this.f60227a, this.f60228b, divisionEditText, false);
            c();
            e();
            f();
            g();
            this.n.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.newbindcard.ui.NewBindCardEnterActivity.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ NewBindCardEnterActivity f60236a;

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
                    this.f60236a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f60236a.onBackPressed();
                    }
                }
            });
            this.k.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.newbindcard.ui.NewBindCardEnterActivity.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ NewBindCardEnterActivity f60249a;

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
                    this.f60249a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        a.a(PayStatServiceEvent.NEW_CLICK_SUPPORT_BANK, new String[0]);
                        this.f60249a.b(false);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, this, str) == null) {
            y yVar = (y) PayBeanFactory.getInstance().getBean((Context) this, 7, "NewBindCardEnterActivity");
            yVar.setResponseCallback(this);
            yVar.a(str);
            yVar.execBean();
        }
    }

    private void a(GetCardInfoResponse.CardInfo cardInfo) {
        String string;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65545, this, cardInfo) == null) || cardInfo == null || TextUtils.isEmpty(cardInfo.bank_logourl) || TextUtils.isEmpty(cardInfo.bank_name)) {
            return;
        }
        this.f60231e.setVisibility(0);
        this.f60235i.setImageUrl(cardInfo.bank_logourl);
        TextView textView = this.j;
        StringBuilder sb = new StringBuilder();
        sb.append(cardInfo.bank_name);
        sb.append(" ");
        if (cardInfo.card_type == 1) {
            string = ResUtils.getString(getActivity(), "bd_wallet_credit");
        } else {
            string = ResUtils.getString(getActivity(), "bd_wallet_debit");
        }
        sb.append(string);
        textView.setText(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(GetCardInfoResponse getCardInfoResponse) {
        UserData.UserModel userModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65546, this, getCardInfoResponse) == null) || getCardInfoResponse == null || this.m == null) {
            return;
        }
        GetCardInfoResponse.CardInfo cardInfo = getCardInfoResponse.card_info;
        if (cardInfo != null && !TextUtils.isEmpty(cardInfo.bank_no)) {
            this.m.mBankNo = getCardInfoResponse.card_info.bank_no;
        }
        this.m.setmBankInfo(getCardInfoResponse);
        CardAddResponse cardAddResponse = this.l;
        if (cardAddResponse == null || (userModel = cardAddResponse.user) == null) {
            return;
        }
        if (1 == userModel.has_mobile_password) {
            CardAddResponse.SupportPwdInfo[] supportPwdInfoArr = cardAddResponse.support_pwd_info;
            if (supportPwdInfoArr != null && supportPwdInfoArr.length > 0) {
                CardAddResponse.SupportPwdInfo supportPwdInfo = supportPwdInfoArr[0];
                if (supportPwdInfo != null && "finger".equalsIgnoreCase(supportPwdInfo.verify_type)) {
                    a.d("1");
                    a(supportPwdInfo.max_retry);
                    return;
                }
                a.d("1");
                a(true, -1);
                return;
            }
            a.d("1");
            a(true, -1);
            return;
        }
        a.c("0");
        a.d("0");
        a(false, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65556, this, z) == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                extras = new Bundle();
            }
            extras.putBoolean("isSelectBank", z);
            Intent intent = new Intent(getActivity(), SignChannelListActivity.class);
            intent.putExtras(extras);
            startActivityForResult(intent, BeanConstants.REQUEST_CODE_SIGN_CHANNEL_LIST);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, this, str) == null) {
            WalletGlobalUtils.safeShowDialog(this, -2, "");
            r rVar = (r) PayBeanFactory.getInstance().getBean((Context) this, 4, "NewBindCardEnterActivity");
            BindFastRequest bindFastRequest = this.m;
            if (bindFastRequest != null) {
                bindFastRequest.setSubBankCode(str);
            }
            a(this.m);
            rVar.a(this.p, "");
            rVar.a(this.m);
            rVar.setResponseCallback(this);
            rVar.execBean();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65548, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            Intent intent = new Intent();
            if (z) {
                intent.setClass(this, NewCheckPwdActivity.class);
                intent.putExtra(NewCheckPwdActivity.CHECK_FINGERPRINGT_STATUS, i2);
            } else {
                intent.setClass(this, NewBindCardMainActivity.class);
            }
            intent.putExtra(NewBindCardMainActivity.BIND_CARD_NUMBER, this.f60229c.getRealText());
            startActivityWithoutAnim(intent);
        }
    }

    private void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65539, this, i2) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("showSwitchPwd", 1);
                jSONObject.put("checkTimes", i2);
                DxmCheckFingerprint.getInstance().startCherkFingerprint(this, jSONObject.toString(), new RouterCallback(this) { // from class: com.baidu.wallet.newbindcard.ui.NewBindCardEnterActivity.6
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ NewBindCardEnterActivity f60248a;

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
                        this.f60248a = this;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:26:0x005f  */
                    /* JADX WARN: Removed duplicated region for block: B:27:0x0065  */
                    @Override // com.baidu.wallet.router.RouterCallback
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public void onResult(int i3, HashMap hashMap) {
                        int i4;
                        boolean z;
                        JSONObject jSONObject2;
                        JSONObject optJSONObject;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null && interceptable2.invokeIL(1048576, this, i3, hashMap) != null) {
                            return;
                        }
                        if (i3 == 0 && hashMap != null && hashMap.get("result") != null) {
                            try {
                                jSONObject2 = new JSONObject(hashMap.get("result").toString());
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                            }
                            if (jSONObject2.optInt("result", -1) == 0 && (optJSONObject = jSONObject2.optJSONObject(com.dxmpay.wallet.core.beans.BeanConstants.DXM_OCR_KEY_CNT)) != null && optJSONObject.optString("data") != null) {
                                i4 = new JSONObject(new String(Base64Utils.decode(optJSONObject.optString("data")))).optInt(EnterDxmPayServiceAction.SERVICE_STATUS_CODE, -1);
                                if (i4 == 0) {
                                    z = true;
                                    if (z) {
                                        this.f60248a.a(false, -1);
                                        return;
                                    } else {
                                        this.f60248a.a(true, i4);
                                        return;
                                    }
                                }
                                if (i4 == -203) {
                                    return;
                                }
                                z = false;
                                if (z) {
                                }
                            }
                        }
                        i4 = -1;
                        z = false;
                        if (z) {
                        }
                    }
                });
            } catch (JSONException e2) {
                e2.printStackTrace();
                a(true, -1);
            }
        }
    }

    private void a(BindFastRequest bindFastRequest) {
        Pair<Integer, Object> checkSecurityEvn;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65544, this, bindFastRequest) == null) && (checkSecurityEvn = BaiduWalletDelegate.getInstance().checkSecurityEvn()) != null && ((Integer) checkSecurityEvn.first).intValue() == 0) {
            Object obj = checkSecurityEvn.second;
            String str = null;
            if (obj != null && (obj instanceof String)) {
                str = (String) obj;
            }
            if (bindFastRequest == null || TextUtils.isEmpty(str)) {
                return;
            }
            bindFastRequest.mSecurityParams = Base64.encodeBytes(str.getBytes());
        }
    }

    private boolean a(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, this, view, motionEvent)) == null) {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int i2 = iArr[0];
            int i3 = iArr[1];
            return motionEvent.getX() >= ((float) i2) && motionEvent.getX() <= ((float) (i2 + view.getWidth())) && motionEvent.getY() >= ((float) i3) && motionEvent.getY() <= ((float) (i3 + view.getHeight()));
        }
        return invokeLL.booleanValue;
    }
}
