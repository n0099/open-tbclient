package com.baidu.wallet.paysdk.ui.widget;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.paysdk.ui.BindCardImplActivity;
import com.baidu.wallet.router.LocalRouter;
import com.baidu.wallet.router.RouterCallback;
import com.baidu.wallet.router.RouterRequest;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.widget.DivisionEditText;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.AccessibilityUtils;
import com.dxmpay.wallet.utils.StatHelper;
import java.util.HashMap;
@SuppressLint({"NewApi"})
/* loaded from: classes8.dex */
public class BankCardInfoView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TextView f62838a;

    /* renamed from: b  reason: collision with root package name */
    public DivisionEditText f62839b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f62840c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f62841d;

    /* renamed from: e  reason: collision with root package name */
    public View f62842e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f62843f;

    /* renamed from: g  reason: collision with root package name */
    public View f62844g;

    /* renamed from: h  reason: collision with root package name */
    public String f62845h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f62846i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BankCardInfoView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f62840c = true;
        this.f62845h = null;
        this.f62846i = false;
        a();
    }

    public void ajustCompleteUi() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            findViewById(ResUtils.id(getContext(), "line0")).setVisibility(0);
            findViewById(ResUtils.id(getContext(), "line2")).setLayoutParams(new LinearLayout.LayoutParams(-1, 1));
        }
    }

    public void configDetectCardNum(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.f62840c = z;
            this.f62843f.setImageResource(ResUtils.drawable(getContext(), z ? "dxm_wallet_base_camera_scan_btn_selector" : "dxm_wallet_base_delete"));
        }
    }

    public DivisionEditText getCardNoView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f62839b : (DivisionEditText) invokeV.objValue;
    }

    public View getClearView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f62843f : (View) invokeV.objValue;
    }

    public String getScanCardNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f62845h : (String) invokeV.objValue;
    }

    public View getTrueNameView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f62842e : (View) invokeV.objValue;
    }

    public void resetScanCardNum() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f62845h = null;
        }
    }

    public void setBindcardTip(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, charSequence) == null) || this.f62838a == null) {
            return;
        }
        if (TextUtils.isEmpty(charSequence)) {
            this.f62838a.setVisibility(8);
            return;
        }
        this.f62838a.setVisibility(0);
        this.f62838a.setText(charSequence);
    }

    public void setTipClick(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onClickListener) == null) {
            this.f62844g.setOnClickListener(onClickListener);
        }
    }

    public void setTipDel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f62846i = true;
            this.f62843f.setImageResource(ResUtils.drawable(getContext(), "dxm_wallet_base_delete"));
            AccessibilityUtils.setContentDescription(this.f62843f, "清除");
        }
    }

    public void setTipScan() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f62846i = false;
            this.f62843f.setVisibility(0);
            if (this.f62840c) {
                this.f62843f.setImageResource(ResUtils.drawable(getContext(), "dxm_wallet_base_camera_scan_btn_selector"));
            } else if (!TextUtils.isEmpty(this.f62839b.getRealText())) {
                this.f62843f.setImageResource(ResUtils.drawable(getContext(), "dxm_wallet_base_delete"));
            } else {
                this.f62843f.setVisibility(4);
            }
            AccessibilityUtils.setContentDescription(this.f62843f, "扫描银行卡");
        }
    }

    public void setTrueName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            a(!TextUtils.isEmpty(str));
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.f62841d.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(24)
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            if (Build.VERSION.SDK_INT >= 24 && (getContext() instanceof Activity) && ((Activity) getContext()).isInMultiWindowMode()) {
                GlobalUtils.toast(getContext(), ResUtils.getString(getContext(), "dxm_wallet_base_multi_window_close"), -1, 1);
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_cashdesk_bind_cardinfo_view"), this);
            this.f62838a = (TextView) findViewById(ResUtils.id(getContext(), "wallet_bindcard_tip"));
            ImageView imageView = (ImageView) findViewById(ResUtils.id(getContext(), "card_clear"));
            this.f62843f = imageView;
            AccessibilityUtils.setContentDescription(imageView, "扫描银行卡");
            this.f62842e = findViewById(ResUtils.id(getContext(), "card_true_name_area"));
            this.f62841d = (TextView) findViewById(ResUtils.id(getContext(), "card_true_name"));
            this.f62844g = findViewById(ResUtils.id(getContext(), "card_name_tip_img"));
            View findViewById = findViewById(ResUtils.id(getContext(), "card_area"));
            DivisionEditText divisionEditText = (DivisionEditText) findViewById.findViewById(ResUtils.id(getContext(), "ebpay_card_no_id"));
            this.f62839b = divisionEditText;
            divisionEditText.setUseSafeKeyBoard(true);
            this.f62839b.setViewType(25);
            this.f62839b.setTag(findViewById.findViewWithTag(ResUtils.getString(getContext(), "wallet_base_string_bindcard_item_line_tag")));
            this.f62845h = null;
            ImageView imageView2 = this.f62843f;
            if (imageView2 != null) {
                imageView2.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.widget.BankCardInfoView.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ BankCardInfoView f62847a;

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
                        this.f62847a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            if (this.f62847a.f62846i) {
                                this.f62847a.f62839b.setText("");
                            } else if (LocalRouter.getInstance(this.f62847a.getContext()).isProviderExisted("bankdetection") && this.f62847a.f62840c && !this.f62847a.b()) {
                                LocalRouter.getInstance(this.f62847a.getContext()).route(this.f62847a.getContext(), new RouterRequest().provider("bankdetection").action("bankcarddetction"), new RouterCallback(this) { // from class: com.baidu.wallet.paysdk.ui.widget.BankCardInfoView.1.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;

                                    /* renamed from: a  reason: collision with root package name */
                                    public final /* synthetic */ AnonymousClass1 f62848a;

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
                                        this.f62848a = this;
                                    }

                                    @Override // com.baidu.wallet.router.RouterCallback
                                    public void onResult(int i2, HashMap hashMap) {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || interceptable3.invokeIL(1048576, this, i2, hashMap) == null) {
                                            if (i2 == 0) {
                                                if (hashMap == null || TextUtils.isEmpty((String) hashMap.get("card_num"))) {
                                                    return;
                                                }
                                                this.f62848a.f62847a.f62845h = (String) hashMap.get("card_num");
                                                if (this.f62848a.f62847a.f62845h.equals(this.f62848a.f62847a.f62839b.getRealText())) {
                                                    return;
                                                }
                                                if (this.f62848a.f62847a.getContext() instanceof BindCardImplActivity) {
                                                    ((BindCardImplActivity) this.f62848a.f62847a.getContext()).resetCardInfoState();
                                                }
                                                this.f62848a.f62847a.f62839b.setText(this.f62848a.f62847a.f62845h);
                                                try {
                                                    this.f62848a.f62847a.f62839b.setSelection(this.f62848a.f62847a.f62839b.getText().toString().length());
                                                    this.f62848a.f62847a.f62839b.requestFocus();
                                                } catch (Exception unused) {
                                                }
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
                    }
                });
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BankCardInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f62840c = true;
        this.f62845h = null;
        this.f62846i = false;
        a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BankCardInfoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f62840c = true;
        this.f62845h = null;
        this.f62846i = false;
        a();
    }

    private void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(AdIconUtil.AD_TEXT_ID, this, z) == null) {
            this.f62842e.setVisibility(!z ? 8 : 0);
        }
    }
}
