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
/* loaded from: classes13.dex */
public class FastPayTabSwitchView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RelativeLayout a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f51110b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f51111c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f51112d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f51113e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f51114f;

    /* renamed from: g  reason: collision with root package name */
    public a f51115g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f51116h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f51117i;

    /* loaded from: classes13.dex */
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
        this.f51116h = true;
        this.f51117i = BeanConstants.CHANNEL_ID.equals("baiduapp");
        a();
    }

    public boolean isFirstSelected() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f51116h : invokeV.booleanValue;
    }

    public void setOnTabChangedListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.f51115g = aVar;
        }
    }

    public void setTabChange(boolean z) {
        int color;
        int color2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            TextView textView = this.f51112d;
            if (z) {
                color = ResUtils.getColor(getContext(), this.f51117i ? "bd_wallet_fp_fix_tip" : "bd_wallet_black");
            } else {
                color = ResUtils.getColor(getContext(), this.f51117i ? "bd_wallet_black" : "wallet_fp_main_color");
            }
            textView.setTextColor(color);
            this.f51114f.setVisibility(z ? 4 : 0);
            TextView textView2 = this.f51111c;
            if (z) {
                color2 = ResUtils.getColor(getContext(), this.f51117i ? "bd_wallet_black" : "wallet_fp_main_color");
            } else {
                color2 = ResUtils.getColor(getContext(), this.f51117i ? "bd_wallet_fp_fix_tip" : "bd_wallet_black");
            }
            textView2.setTextColor(color2);
            this.f51113e.setVisibility(z ? 0 : 4);
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            this.a.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.fastpay.ui.widget.FastPayTabSwitchView.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ FastPayTabSwitchView a;

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
                        RelativeLayout relativeLayout = this.a.a;
                        AccessibilityUtils.setContentDescription(relativeLayout, ((Object) this.a.f51111c.getText()) + "已选中");
                        RelativeLayout relativeLayout2 = this.a.f51110b;
                        AccessibilityUtils.setContentDescription(relativeLayout2, ((Object) this.a.f51112d.getText()) + "未选中");
                        if (this.a.f51116h) {
                            return;
                        }
                        this.a.f51116h = true;
                        this.a.setTabChange(true);
                        if (this.a.f51115g != null) {
                            this.a.f51115g.a();
                        }
                    }
                }
            });
            this.f51110b.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.fastpay.ui.widget.FastPayTabSwitchView.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ FastPayTabSwitchView a;

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
                        RelativeLayout relativeLayout = this.a.f51110b;
                        AccessibilityUtils.setContentDescription(relativeLayout, ((Object) this.a.f51112d.getText()) + "已选中");
                        RelativeLayout relativeLayout2 = this.a.a;
                        AccessibilityUtils.setContentDescription(relativeLayout2, ((Object) this.a.f51111c.getText()) + "未选中");
                        if (this.a.f51116h) {
                            this.a.f51116h = false;
                            this.a.setTabChange(false);
                            if (this.a.f51115g != null) {
                                this.a.f51115g.b();
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
            LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), this.f51117i ? "wallet_fp_tab_switch_baiduapp" : "wallet_fp_tab_switch"), this);
            this.a = (RelativeLayout) findViewById(ResUtils.id(getContext(), "wallet_mobile_switch_fastpay"));
            this.f51110b = (RelativeLayout) findViewById(ResUtils.id(getContext(), "wallet_mobile_switch_traffic"));
            this.f51112d = (TextView) findViewById(ResUtils.id(getContext(), "wallet_mobile_traffic_tv"));
            this.f51114f = (TextView) findViewById(ResUtils.id(getContext(), "wallet_mobile_traffic_line"));
            this.f51111c = (TextView) findViewById(ResUtils.id(getContext(), "wallet_mobile_fastpay_tv"));
            this.f51113e = (TextView) findViewById(ResUtils.id(getContext(), "wallet_mobile_fastpay_line"));
            setTabChange(this.f51116h);
            RelativeLayout relativeLayout = this.a;
            AccessibilityUtils.setContentDescription(relativeLayout, ((Object) this.f51111c.getText()) + "已选中");
            RelativeLayout relativeLayout2 = this.f51110b;
            AccessibilityUtils.setContentDescription(relativeLayout2, ((Object) this.f51112d.getText()) + "未选中");
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
        this.f51116h = true;
        this.f51117i = BeanConstants.CHANNEL_ID.equals("baiduapp");
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
        this.f51116h = true;
        this.f51117i = BeanConstants.CHANNEL_ID.equals("baiduapp");
        a();
    }
}
