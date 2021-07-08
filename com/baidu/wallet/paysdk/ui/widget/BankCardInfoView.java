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
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.base.widget.DivisionEditText;
import com.baidu.wallet.paysdk.ui.BindCardImplActivity;
import com.baidu.wallet.router.LocalRouter;
import com.baidu.wallet.router.RouterCallback;
import com.baidu.wallet.router.RouterRequest;
import com.baidu.wallet.statistics.api.StatisticManager;
import com.baidu.wallet.utils.AccessibilityUtils;
import java.util.HashMap;
@SuppressLint({"NewApi"})
/* loaded from: classes5.dex */
public class BankCardInfoView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TextView f26844a;

    /* renamed from: b  reason: collision with root package name */
    public DivisionEditText f26845b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f26846c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f26847d;

    /* renamed from: e  reason: collision with root package name */
    public View f26848e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f26849f;

    /* renamed from: g  reason: collision with root package name */
    public View f26850g;

    /* renamed from: h  reason: collision with root package name */
    public String f26851h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f26852i;

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
        this.f26846c = true;
        this.f26851h = null;
        this.f26852i = false;
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
            this.f26846c = z;
            this.f26849f.setImageResource(ResUtils.drawable(getContext(), z ? "wallet_base_camera_scan_btn_selector" : "wallet_base_delete"));
        }
    }

    public DivisionEditText getCardNoView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f26845b : (DivisionEditText) invokeV.objValue;
    }

    public View getClearView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f26849f : (View) invokeV.objValue;
    }

    public String getScanCardNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f26851h : (String) invokeV.objValue;
    }

    public View getTrueNameView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f26848e : (View) invokeV.objValue;
    }

    public void resetScanCardNum() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f26851h = null;
        }
    }

    public void setBindcardTip(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, charSequence) == null) || this.f26844a == null) {
            return;
        }
        if (TextUtils.isEmpty(charSequence)) {
            this.f26844a.setVisibility(8);
            return;
        }
        this.f26844a.setVisibility(0);
        this.f26844a.setText(charSequence);
    }

    public void setTipClick(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onClickListener) == null) {
            this.f26850g.setOnClickListener(onClickListener);
        }
    }

    public void setTipDel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f26852i = true;
            this.f26849f.setImageResource(ResUtils.drawable(getContext(), "wallet_base_delete"));
            AccessibilityUtils.setContentDescription(this.f26849f, "清除");
        }
    }

    public void setTipScan() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f26852i = false;
            this.f26849f.setVisibility(0);
            if (this.f26846c) {
                this.f26849f.setImageResource(ResUtils.drawable(getContext(), "wallet_base_camera_scan_btn_selector"));
            } else if (!TextUtils.isEmpty(this.f26845b.getRealText())) {
                this.f26849f.setImageResource(ResUtils.drawable(getContext(), "wallet_base_delete"));
            } else {
                this.f26849f.setVisibility(4);
            }
            AccessibilityUtils.setContentDescription(this.f26849f, "扫描银行卡");
        }
    }

    public void setTrueName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            a(!TextUtils.isEmpty(str));
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.f26847d.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(24)
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            if (Build.VERSION.SDK_INT >= 24 && (getContext() instanceof Activity) && ((Activity) getContext()).isInMultiWindowMode()) {
                GlobalUtils.toast(getContext(), ResUtils.getString(getContext(), "wallet_base_multi_window_close"), -1, 1);
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
            this.f26844a = (TextView) findViewById(ResUtils.id(getContext(), "wallet_bindcard_tip"));
            ImageView imageView = (ImageView) findViewById(ResUtils.id(getContext(), "card_clear"));
            this.f26849f = imageView;
            AccessibilityUtils.setContentDescription(imageView, "扫描银行卡");
            this.f26848e = findViewById(ResUtils.id(getContext(), "card_true_name_area"));
            this.f26847d = (TextView) findViewById(ResUtils.id(getContext(), "card_true_name"));
            this.f26850g = findViewById(ResUtils.id(getContext(), "card_name_tip_img"));
            View findViewById = findViewById(ResUtils.id(getContext(), "card_area"));
            DivisionEditText divisionEditText = (DivisionEditText) findViewById.findViewById(ResUtils.id(getContext(), "ebpay_card_no_id"));
            this.f26845b = divisionEditText;
            divisionEditText.setUseSafeKeyBoard(true);
            this.f26845b.setViewType(25);
            this.f26845b.setTag(findViewById.findViewWithTag(ResUtils.getString(getContext(), "wallet_base_string_bindcard_item_line_tag")));
            this.f26851h = null;
            ImageView imageView2 = this.f26849f;
            if (imageView2 != null) {
                imageView2.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.widget.BankCardInfoView.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ BankCardInfoView f26853a;

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
                        this.f26853a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            if (this.f26853a.f26852i) {
                                this.f26853a.f26845b.setText("");
                            } else if (LocalRouter.getInstance(this.f26853a.getContext()).isProviderExisted("bankdetection") && this.f26853a.f26846c && !this.f26853a.b()) {
                                LocalRouter.getInstance(this.f26853a.getContext()).route(this.f26853a.getContext(), new RouterRequest().provider("bankdetection").action("bankcarddetction"), new RouterCallback(this) { // from class: com.baidu.wallet.paysdk.ui.widget.BankCardInfoView.1.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;

                                    /* renamed from: a  reason: collision with root package name */
                                    public final /* synthetic */ AnonymousClass1 f26854a;

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
                                        this.f26854a = this;
                                    }

                                    @Override // com.baidu.wallet.router.RouterCallback
                                    public void onResult(int i2, HashMap hashMap) {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || interceptable3.invokeIL(1048576, this, i2, hashMap) == null) {
                                            if (i2 != 0) {
                                                if (i2 == 5) {
                                                    HashMap hashMap2 = new HashMap();
                                                    hashMap2.put("provider", "bankdetection");
                                                    hashMap2.put("action", "bankcarddetction");
                                                    StatisticManager.onEventEndWithValues(StatServiceEvent.SDK_ROUTER_ERROR, i2, hashMap2.values());
                                                }
                                            } else if (hashMap == null || TextUtils.isEmpty((String) hashMap.get("card_num"))) {
                                            } else {
                                                this.f26854a.f26853a.f26851h = (String) hashMap.get("card_num");
                                                if (this.f26854a.f26853a.f26851h.equals(this.f26854a.f26853a.f26845b.getRealText())) {
                                                    return;
                                                }
                                                if (this.f26854a.f26853a.getContext() instanceof BindCardImplActivity) {
                                                    ((BindCardImplActivity) this.f26854a.f26853a.getContext()).resetCardInfoState();
                                                }
                                                this.f26854a.f26853a.f26845b.setText(this.f26854a.f26853a.f26851h);
                                                try {
                                                    this.f26854a.f26853a.f26845b.setSelection(this.f26854a.f26853a.f26845b.getText().toString().length());
                                                    this.f26854a.f26853a.f26845b.requestFocus();
                                                } catch (Exception unused) {
                                                }
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
        this.f26846c = true;
        this.f26851h = null;
        this.f26852i = false;
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
        this.f26846c = true;
        this.f26851h = null;
        this.f26852i = false;
        a();
    }

    private void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(AdIconUtil.AD_TEXT_ID, this, z) == null) {
            this.f26848e.setVisibility(!z ? 8 : 0);
        }
    }
}
