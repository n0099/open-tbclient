package com.baidu.wallet.paysdk.ui;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.eventbus.EventBus;
import com.baidu.apollon.statusbar.ImmersiveStatusBarManager;
import com.baidu.apollon.statusbar.StatusBarUtils;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.pass.biometrics.face.liveness.dto.PassFaceRecogDTO;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.datamodel.Authorize;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.base.widget.BdActionBar;
import com.baidu.wallet.base.widget.OrderConfirmation;
import com.baidu.wallet.base.widget.WalletBaseButtonWithImage;
import com.baidu.wallet.base.widget.dialog.PromptDialog;
import com.baidu.wallet.core.SDKBaseActivity;
import com.baidu.wallet.core.utils.WalletGlobalUtils;
import com.baidu.wallet.paysdk.PayCallBackManager;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.paysdk.beans.BeanConstants;
import com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse;
import com.baidu.wallet.paysdk.datamodel.GetCardInfoResponse;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.presenter.d;
import com.baidu.wallet.paysdk.presenter.e;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.widget.AuthorizeInfoView;
import com.baidu.wallet.statistics.api.StatisticManager;
import com.baidu.wallet.util.StatHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes5.dex */
public class AuthorizeSignActivity extends PayBaseBeanActivity implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String AUTH_SIGN_TYPE = "AuthorizeSignType";
    public static final int BUTTON_STATE_AUTH = 3;
    public static final int BUTTON_STATE_AUTH_NEWCARD = 4;
    public static final int BUTTON_STATE_NEWCARD = 2;
    public static final int BUTTON_STATE_NEXT = 1;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public e f26498a;

    /* renamed from: b  reason: collision with root package name */
    public AuthorizeInfoView f26499b;

    /* renamed from: c  reason: collision with root package name */
    public OrderConfirmation f26500c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f26501d;

    /* renamed from: e  reason: collision with root package name */
    public NetImageView f26502e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f26503f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f26504g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f26505h;

    /* renamed from: i  reason: collision with root package name */
    public WalletBaseButtonWithImage f26506i;
    public LinearLayout j;
    public TextView k;
    public LinearLayout l;
    public CheckBox m;
    public TextView n;
    public PayRequest o;
    public DirectPayContentResponse p;
    public CardData.BondCard q;
    public View r;

    public AuthorizeSignActivity() {
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

    public AuthorizeInfoView.b getAuthInfoViewAdapter(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            if (this.f26499b != null) {
                return AuthorizeInfoView.a.a().a(i2, this.f26499b);
            }
            return null;
        }
        return (AuthorizeInfoView.b) invokeI.objValue;
    }

    @Override // com.baidu.wallet.core.SDKBaseActivity
    public SDKBaseActivity.BottomBarType getBottomBarType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? SDKBaseActivity.BottomBarType.NONE : (SDKBaseActivity.BottomBarType) invokeV.objValue;
    }

    public PayRequest getPayRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.o == null) {
                this.o = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(BeanConstants.REQUEST_ID_PAY);
            }
            return this.o;
        }
        return (PayRequest) invokeV.objValue;
    }

    public DirectPayContentResponse getPayResponse() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.p == null) {
                this.p = PayDataCache.getInstance().getPayResponse();
            }
            return this.p;
        }
        return (DirectPayContentResponse) invokeV.objValue;
    }

    public CardData.BondCard getSelectedCard() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.q : (CardData.BondCard) invokeV.objValue;
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity
    public void handleResponse(int i2, Object obj, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048581, this, i2, obj, str) == null) {
        }
    }

    public void initActionBarByString(String str) {
        BdActionBar bdActionBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || (bdActionBar = (BdActionBar) findViewById(ResUtils.id(getActivity(), "bdactionbar"))) == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = ResUtils.getString(getApplicationContext(), "bd_wallet_withhold_title");
        }
        bdActionBar.setTitle(str);
        bdActionBar.setLeftZoneOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.AuthorizeSignActivity.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ AuthorizeSignActivity f26509a;

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
                this.f26509a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    GlobalUtils.hideKeyboard(this.f26509a.getActivity());
                    this.f26509a.onBackPressed();
                }
            }
        });
    }

    public void initCardList() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.f26501d == null || this.f26503f == null || this.f26504g == null || this.f26502e == null) {
            return;
        }
        PayRequest payRequest = getPayRequest();
        if (payRequest != null) {
            this.q = payRequest.getDefaultBankCardIdx();
        }
        e eVar = this.f26498a;
        if (eVar != null) {
            eVar.a(this.q != null);
        }
        a();
        updateSelBankInfo(this.q);
    }

    public void initNextButton(View.OnClickListener onClickListener) {
        WalletBaseButtonWithImage walletBaseButtonWithImage;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onClickListener) == null) || (walletBaseButtonWithImage = this.f26506i) == null) {
            return;
        }
        if (onClickListener != null) {
            walletBaseButtonWithImage.setOnClickListener(onClickListener);
        }
        updateNextButton();
    }

    public void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            setContentView(ResUtils.layout(getApplicationContext(), "wallet_cashdesk_authorize_sign_activity"));
            this.f26499b = (AuthorizeInfoView) findViewById(ResUtils.id(getApplicationContext(), "sign_info_view"));
            this.f26500c = (OrderConfirmation) findViewById(ResUtils.id(getApplicationContext(), "sign_order_view"));
            this.f26501d = (LinearLayout) findViewById(ResUtils.id(getApplicationContext(), "select_card_panel"));
            this.f26502e = (NetImageView) findViewById(ResUtils.id(getApplicationContext(), "select_card_bank_logo"));
            this.f26503f = (TextView) findViewById(ResUtils.id(getApplicationContext(), "select_card_bank_info"));
            this.f26504g = (TextView) findViewById(ResUtils.id(getApplicationContext(), "select_card_txt"));
            this.f26505h = (TextView) findViewById(ResUtils.id(getApplicationContext(), "select_card_need_detail"));
            this.f26506i = (WalletBaseButtonWithImage) findViewById(ResUtils.id(getApplicationContext(), "sign_next_btn"));
            this.j = (LinearLayout) findViewById(ResUtils.id(getApplicationContext(), "sign_hint_panel"));
            this.k = (TextView) findViewById(ResUtils.id(getApplicationContext(), "sign_hint_txt"));
            this.l = (LinearLayout) findViewById(ResUtils.id(getApplicationContext(), "sign_protocol_panel"));
            this.m = (CheckBox) findViewById(ResUtils.id(getApplicationContext(), "sign_protocol_cb"));
            this.n = (TextView) findViewById(ResUtils.id(getApplicationContext(), "sign_protocol_txt"));
            this.f26500c.getBackButton().setOnClickListener(this);
            this.r = findViewById(ResUtils.id(getApplicationContext(), "statusbar_top"));
            e eVar = this.f26498a;
            if (eVar != null) {
                this.f26499b.setVisibility(eVar.d() ? 0 : 8);
                this.f26500c.setVisibility(this.f26498a.e() ? 0 : 8);
                this.j.setVisibility(this.f26498a.f() ? 0 : 8);
                if (this.f26498a.c()) {
                    getBdActionBar().setVisibility(0);
                } else {
                    getBdActionBar().setVisibility(8);
                    setTop();
                }
                getBdActionBar().setVisibility(this.f26498a.c() ? 0 : 8);
                this.f26498a.a();
            }
        }
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            WalletGlobalUtils.safeShowDialog(this, 18, "");
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, view) == null) && view.getId() == ResUtils.id(getApplicationContext(), "bd_wallet_id_base_order_back")) {
            onBackPressed();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bundle) == null) {
            super.onCreate(bundle);
            setFlagPaySdk();
            this.f26498a = d.a().a(getIntent().getIntExtra(AUTH_SIGN_TYPE, 0), this);
            initView();
            EventBus.getInstance().registerSticky(this, "order_confirm_event_bus_key", 0, EventBus.ThreadMode.MainThread);
            refreshUI();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onDestroy();
            EventBus.getInstance().unregister(this, "order_confirm_event_bus_key");
        }
    }

    public void onModuleEvent(EventBus.Event event) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, event) == null) && event != null && "order_confirm_event_bus_key".equals(event.mEventKey)) {
            refreshUI();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.BaseActivity, android.app.Activity
    public void onPrepareDialog(int i2, Dialog dialog) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048591, this, i2, dialog) == null) {
            if (i2 == 18) {
                PromptDialog promptDialog = (PromptDialog) dialog;
                promptDialog.setCanceledOnTouchOutside(false);
                promptDialog.setMessage(ResUtils.getString(this, "bd_wallet_auth_confirm_to_cancel"));
                promptDialog.setNegativeBtn(ResUtils.string(this, "ebpay_cancel"), new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.AuthorizeSignActivity.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ AuthorizeSignActivity f26507a;

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
                        this.f26507a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            WalletGlobalUtils.safeDismissDialog(this.f26507a, 18);
                        }
                    }
                });
                promptDialog.setPositiveBtn(ResUtils.string(this, "bd_wallet_auth_cancel_auth"), new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.AuthorizeSignActivity.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ AuthorizeSignActivity f26508a;

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
                        this.f26508a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            List<String> collectData = StatHelper.collectData(StatHelper.getOrderNo(), new String[0]);
                            HashMap hashMap = new HashMap();
                            hashMap.put(PassFaceRecogDTO.KEY_EXTRA_PASS_PRODUCT_ID, StatHelper.getSpNo());
                            hashMap.put(BaiduPay.AMOUNT, StatHelper.getPayAmount());
                            StatisticManager.onEventWithValues(PayStatServiceEvent.STD_PAY_CANCEL, collectData, hashMap);
                            WalletGlobalUtils.safeDismissDialog(this.f26508a, 18);
                            PayCallBackManager.callBackClientCancel(this.f26508a, "AuthorizeActivity.onPrepareDialog().1");
                            this.f26508a.finishWithoutAnim();
                        }
                    }
                });
                return;
            }
            super.onPrepareDialog(i2, dialog);
        }
    }

    public void refreshUI() {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (eVar = this.f26498a) == null) {
            return;
        }
        eVar.b();
    }

    public void setSelectCardListener(View.OnClickListener onClickListener) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, onClickListener) == null) || (linearLayout = this.f26501d) == null) {
            return;
        }
        linearLayout.setOnClickListener(onClickListener);
    }

    public void setTop() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || Build.VERSION.SDK_INT < 19) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.r.getLayoutParams());
        layoutParams.height = StatusBarUtils.getStatusBarHeight(this.mAct);
        this.r.setLayoutParams(layoutParams);
        ImmersiveStatusBarManager.setTopBar(this.mAct.getActivity(), this.r, this.mAct.isStatusbarTextColorBlack());
    }

    public void updateDiscountTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.f26500c.setTitle(str);
        }
    }

    public void updateDiscountTxt(boolean z, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, CharSequence charSequence5, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{Boolean.valueOf(z), charSequence, charSequence2, charSequence3, charSequence4, charSequence5, onClickListener}) == null) {
            this.f26500c.setDiscountInfoVisiable(z);
            this.f26500c.setOrderPrice(charSequence5, charSequence2);
            this.f26500c.setCouponInfo(charSequence3, charSequence4, onClickListener);
            this.f26500c.setOrderInfo(charSequence);
            this.f26500c.setSpNameValue(PayDataCache.getInstance().getSpName());
        }
    }

    public void updateHintText(String str) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, str) == null) || (textView = this.k) == null) {
            return;
        }
        textView.setText(str);
    }

    public void updateNextButton() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            e eVar = this.f26498a;
            int g2 = eVar != null ? eVar.g() : 0;
            if (g2 == 1) {
                this.f26506i.setText(ResUtils.getString(getApplicationContext(), "wallet_base_next_step"));
                this.f26506i.setDrawableLeftVisible(false);
            } else if (g2 == 2) {
                this.f26506i.setText(ResUtils.getString(getApplicationContext(), "ebpay_use_newcard_topay"));
                this.f26506i.setDrawableLeftVisible(false);
            } else if (g2 == 3) {
                this.f26506i.setText(ResUtils.getString(getApplicationContext(), "bd_wallet_auth_submit_sign"));
                this.f26506i.setDrawableLeftVisible(true);
            } else if (g2 != 4) {
                this.f26506i.setText(ResUtils.getString(getApplicationContext(), "wallet_base_next_step"));
                this.f26506i.setDrawableLeftVisible(false);
            } else {
                this.f26506i.setText(ResUtils.getString(getApplicationContext(), "bd_wallet_auth_newcard_submit_sign"));
                this.f26506i.setDrawableLeftVisible(true);
            }
            a(this.m.isChecked());
        }
    }

    public void updateProtocolFields() {
        Authorize authorize;
        Authorize.AgreementInfo agreementInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            DirectPayContentResponse payResponse = getPayResponse();
            if (payResponse != null && (authorize = payResponse.authorize) != null && (agreementInfo = authorize.agreement_info) != null) {
                this.l.setVisibility(0);
                CheckBox checkBox = this.m;
                if (checkBox != null) {
                    checkBox.setChecked(agreementInfo.isProtocolCheckedDefault());
                    this.m.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(this) { // from class: com.baidu.wallet.paysdk.ui.AuthorizeSignActivity.4
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ AuthorizeSignActivity f26510a;

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
                            this.f26510a = this;
                        }

                        @Override // android.widget.CompoundButton.OnCheckedChangeListener
                        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeLZ(1048576, this, compoundButton, z) == null) {
                                StatisticManager.onEventWithValue(StatServiceEvent.CLICK_AGREE_BTN, z ? "0" : "1");
                                this.f26510a.a(z);
                            }
                        }
                    });
                }
                if (this.n != null) {
                    ArrayList arrayList = new ArrayList();
                    GetCardInfoResponse.ProtocolItem[] protocolItemArr = agreementInfo.list;
                    if (protocolItemArr != null) {
                        for (GetCardInfoResponse.ProtocolItem protocolItem : protocolItemArr) {
                            if (!TextUtils.isEmpty(protocolItem.title)) {
                                arrayList.add(protocolItem);
                            }
                        }
                    }
                    if (arrayList.size() > 0) {
                        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                        int color = ResUtils.getColor(getActivity(), "bd_wallet_text_gray");
                        spannableStringBuilder.append((CharSequence) (agreementInfo.prefix + " "));
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, agreementInfo.prefix.length(), 33);
                        for (int i2 = 0; i2 < arrayList.size(); i2++) {
                            GetCardInfoResponse.ProtocolItem protocolItem2 = (GetCardInfoResponse.ProtocolItem) arrayList.get(i2);
                            if (i2 != 0) {
                                String str = agreementInfo.separator;
                                if (i2 == arrayList.size() - 1) {
                                    str = agreementInfo.last_separator;
                                }
                                if (!TextUtils.isEmpty(str)) {
                                    spannableStringBuilder.append((CharSequence) str);
                                    spannableStringBuilder.setSpan(new ForegroundColorSpan(color), spannableStringBuilder.length() - str.length(), spannableStringBuilder.length(), 33);
                                }
                            }
                            spannableStringBuilder.append((CharSequence) protocolItem2.title);
                            if (!TextUtils.isEmpty(protocolItem2.url)) {
                                spannableStringBuilder.setSpan(new ClickableSpan(this, protocolItem2.url, protocolItem2.title.replaceAll("<|>|《|》", "")) { // from class: com.baidu.wallet.paysdk.ui.AuthorizeSignActivity.5
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;

                                    /* renamed from: a  reason: collision with root package name */
                                    public final /* synthetic */ String f26511a;

                                    /* renamed from: b  reason: collision with root package name */
                                    public final /* synthetic */ String f26512b;

                                    /* renamed from: c  reason: collision with root package name */
                                    public final /* synthetic */ AuthorizeSignActivity f26513c;

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
                                        this.f26513c = this;
                                        this.f26511a = r7;
                                        this.f26512b = r8;
                                    }

                                    @Override // android.text.style.ClickableSpan
                                    public void onClick(View view) {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                                            StatisticManager.onEvent(StatServiceEvent.CLICK_USER_TERMS);
                                            Intent intent = new Intent(this.f26513c.getActivity(), WebViewActivity.class);
                                            intent.putExtra("jump_url", this.f26511a);
                                            intent.putExtra("webview_title_string", this.f26512b);
                                            this.f26513c.startActivity(intent);
                                        }
                                    }

                                    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                                    public void updateDrawState(TextPaint textPaint) {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                                            textPaint.setColor(ResUtils.getColor(this.f26513c.getActivity(), "wallet_base_mainColor"));
                                        }
                                    }
                                }, spannableStringBuilder.length() - protocolItem2.title.length(), spannableStringBuilder.length(), 33);
                            } else {
                                spannableStringBuilder.setSpan(new ForegroundColorSpan(color), spannableStringBuilder.length() - protocolItem2.title.length(), spannableStringBuilder.length(), 33);
                            }
                        }
                        this.n.setEnabled(true);
                        this.n.setMovementMethod(LinkMovementMethod.getInstance());
                        this.n.setText(spannableStringBuilder);
                        return;
                    }
                    this.n.setVisibility(8);
                    this.l.setVisibility(8);
                    return;
                }
                this.l.setVisibility(8);
                return;
            }
            this.l.setVisibility(8);
        }
    }

    public void updateSelBankInfo(CardData.BondCard bondCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, bondCard) == null) {
            if (bondCard != null && "1".equals(bondCard.card_state)) {
                PayRequest payRequest = getPayRequest();
                this.q = bondCard;
                if (payRequest != null) {
                    payRequest.mBondCard = bondCard;
                }
                this.f26504g.setText(bondCard.getCardDesc(this.mAct, true));
                if (!TextUtils.isEmpty(bondCard.bank_card_msg)) {
                    this.f26505h.setVisibility(0);
                    this.f26505h.setText(bondCard.bank_card_msg);
                } else {
                    this.f26505h.setVisibility(4);
                }
            } else {
                this.f26504g.setText(ResUtils.string(getActivity(), "ebpay_has_no_avaible_pay_type"));
            }
            this.f26503f.setText(ResUtils.getString(getApplicationContext(), "bd_wallet_auth_primary_pay_method"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65539, this, z) == null) {
            if (z) {
                this.f26506i.setEnabled(true);
            } else {
                this.f26506i.setEnabled(false);
            }
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65537, this) == null) || this.f26504g == null) {
            return;
        }
        Drawable drawable = ResUtils.getDrawable(getActivity(), "wallet_base_indicator_arrow");
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        this.f26504g.setCompoundDrawables(null, null, drawable, null);
        this.f26504g.setCompoundDrawablePadding(DisplayUtils.dip2px(getApplicationContext(), 5.0f));
    }
}
