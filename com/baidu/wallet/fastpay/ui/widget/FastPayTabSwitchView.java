package com.baidu.wallet.fastpay.ui.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.beans.BeanConstants;
import com.baidu.wallet.utils.AccessibilityUtils;
@SuppressLint({"NewApi"})
/* loaded from: classes8.dex */
public class FastPayTabSwitchView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public RelativeLayout f61314a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f61315b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f61316c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f61317d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f61318e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f61319f;

    /* renamed from: g  reason: collision with root package name */
    public a f61320g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f61321h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f61322i;

    /* loaded from: classes8.dex */
    public interface a {
        void a();

        void b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FastPayTabSwitchView(Context context) {
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
        this.f61321h = true;
        this.f61322i = BeanConstants.CHANNEL_ID.equals("baiduapp");
        a();
    }

    public boolean isFirstSelected() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f61321h : invokeV.booleanValue;
    }

    public void setOnTabChangedListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.f61320g = aVar;
        }
    }

    public void setTabChange(boolean z) {
        int color;
        int color2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            TextView textView = this.f61317d;
            if (z) {
                color = ResUtils.getColor(getContext(), this.f61322i ? "bd_wallet_fp_fix_tip" : "bd_wallet_black");
            } else {
                color = ResUtils.getColor(getContext(), this.f61322i ? "bd_wallet_black" : "wallet_fp_main_color");
            }
            textView.setTextColor(color);
            this.f61319f.setVisibility(z ? 4 : 0);
            TextView textView2 = this.f61316c;
            if (z) {
                color2 = ResUtils.getColor(getContext(), this.f61322i ? "bd_wallet_black" : "wallet_fp_main_color");
            } else {
                color2 = ResUtils.getColor(getContext(), this.f61322i ? "bd_wallet_fp_fix_tip" : "bd_wallet_black");
            }
            textView2.setTextColor(color2);
            this.f61318e.setVisibility(z ? 0 : 4);
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            this.f61314a.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.fastpay.ui.widget.FastPayTabSwitchView.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ FastPayTabSwitchView f61323a;

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
                    this.f61323a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        RelativeLayout relativeLayout = this.f61323a.f61314a;
                        AccessibilityUtils.setContentDescription(relativeLayout, ((Object) this.f61323a.f61316c.getText()) + "已选中");
                        RelativeLayout relativeLayout2 = this.f61323a.f61315b;
                        AccessibilityUtils.setContentDescription(relativeLayout2, ((Object) this.f61323a.f61317d.getText()) + "未选中");
                        if (this.f61323a.f61321h) {
                            return;
                        }
                        this.f61323a.f61321h = true;
                        this.f61323a.setTabChange(true);
                        if (this.f61323a.f61320g != null) {
                            this.f61323a.f61320g.a();
                        }
                    }
                }
            });
            this.f61315b.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.fastpay.ui.widget.FastPayTabSwitchView.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ FastPayTabSwitchView f61324a;

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
                    this.f61324a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        RelativeLayout relativeLayout = this.f61324a.f61315b;
                        AccessibilityUtils.setContentDescription(relativeLayout, ((Object) this.f61324a.f61317d.getText()) + "已选中");
                        RelativeLayout relativeLayout2 = this.f61324a.f61314a;
                        AccessibilityUtils.setContentDescription(relativeLayout2, ((Object) this.f61324a.f61316c.getText()) + "未选中");
                        if (this.f61324a.f61321h) {
                            this.f61324a.f61321h = false;
                            this.f61324a.setTabChange(false);
                            if (this.f61324a.f61320g != null) {
                                this.f61324a.f61320g.b();
                            }
                        }
                    }
                }
            });
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), this.f61322i ? "wallet_fp_tab_switch_baiduapp" : "wallet_fp_tab_switch"), this);
            this.f61314a = (RelativeLayout) findViewById(ResUtils.id(getContext(), "wallet_mobile_switch_fastpay"));
            this.f61315b = (RelativeLayout) findViewById(ResUtils.id(getContext(), "wallet_mobile_switch_traffic"));
            this.f61317d = (TextView) findViewById(ResUtils.id(getContext(), "wallet_mobile_traffic_tv"));
            this.f61319f = (TextView) findViewById(ResUtils.id(getContext(), "wallet_mobile_traffic_line"));
            this.f61316c = (TextView) findViewById(ResUtils.id(getContext(), "wallet_mobile_fastpay_tv"));
            this.f61318e = (TextView) findViewById(ResUtils.id(getContext(), "wallet_mobile_fastpay_line"));
            setTabChange(this.f61321h);
            RelativeLayout relativeLayout = this.f61314a;
            AccessibilityUtils.setContentDescription(relativeLayout, ((Object) this.f61316c.getText()) + "已选中");
            RelativeLayout relativeLayout2 = this.f61315b;
            AccessibilityUtils.setContentDescription(relativeLayout2, ((Object) this.f61317d.getText()) + "未选中");
            b();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FastPayTabSwitchView(Context context, AttributeSet attributeSet) {
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
        this.f61321h = true;
        this.f61322i = BeanConstants.CHANNEL_ID.equals("baiduapp");
        a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FastPayTabSwitchView(Context context, AttributeSet attributeSet, int i2) {
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
        this.f61321h = true;
        this.f61322i = BeanConstants.CHANNEL_ID.equals("baiduapp");
        a();
    }
}
