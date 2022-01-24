package com.baidu.wallet.base.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.armor.SafePay;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.utils.LogUtil;
/* loaded from: classes13.dex */
public class SixNumberPwdView extends LinearLayout implements TextWatcher {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int PWD_LEN = 6;
    public transient /* synthetic */ FieldHolder $fh;
    public EditText a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView[] f50798b;

    /* renamed from: c  reason: collision with root package name */
    public View[] f50799c;

    /* renamed from: d  reason: collision with root package name */
    public View[] f50800d;

    /* renamed from: e  reason: collision with root package name */
    public OnPwdChangedListener f50801e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f50802f;

    /* renamed from: g  reason: collision with root package name */
    public Animation f50803g;

    /* renamed from: h  reason: collision with root package name */
    public Animation f50804h;

    /* renamed from: i  reason: collision with root package name */
    public Drawable f50805i;

    /* renamed from: j  reason: collision with root package name */
    public Drawable f50806j;
    public int k;

    /* loaded from: classes13.dex */
    public interface OnPwdChangedListener {
        void onPwdChanged(int i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SixNumberPwdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f50798b = new ImageView[6];
        this.f50799c = new View[6];
        this.f50800d = new View[6];
        this.f50802f = true;
        this.f50803g = null;
        this.f50804h = null;
        this.f50805i = null;
        this.f50806j = null;
        this.a = (EditText) LayoutInflater.from(context).inflate(ResUtils.layout(context, "wallet_base_new_view_six_pwd"), this).findViewById(ResUtils.id(context, "pwd_input"));
        this.f50798b[0] = (ImageView) findViewById(ResUtils.id(context, "pwd_iv_1"));
        this.f50799c[0] = findViewById(ResUtils.id(context, "pwd_iv_1_line"));
        this.f50800d[0] = findViewById(ResUtils.id(context, "pwd_iv_1_line_view"));
        this.f50798b[1] = (ImageView) findViewById(ResUtils.id(context, "pwd_iv_2"));
        this.f50799c[1] = findViewById(ResUtils.id(context, "pwd_iv_2_line"));
        this.f50800d[1] = findViewById(ResUtils.id(context, "pwd_iv_2_line_view"));
        this.f50798b[2] = (ImageView) findViewById(ResUtils.id(context, "pwd_iv_3"));
        this.f50799c[2] = findViewById(ResUtils.id(context, "pwd_iv_3_line"));
        this.f50800d[2] = findViewById(ResUtils.id(context, "pwd_iv_3_line_view"));
        this.f50798b[3] = (ImageView) findViewById(ResUtils.id(context, "pwd_iv_4"));
        this.f50799c[3] = findViewById(ResUtils.id(context, "pwd_iv_4_line"));
        this.f50800d[3] = findViewById(ResUtils.id(context, "pwd_iv_4_line_view"));
        this.f50798b[4] = (ImageView) findViewById(ResUtils.id(context, "pwd_iv_5"));
        this.f50799c[4] = findViewById(ResUtils.id(context, "pwd_iv_5_line"));
        this.f50800d[4] = findViewById(ResUtils.id(context, "pwd_iv_5_line_view"));
        this.f50798b[5] = (ImageView) findViewById(ResUtils.id(context, "pwd_iv_6"));
        this.f50799c[5] = findViewById(ResUtils.id(context, "pwd_iv_6_line"));
        this.f50800d[5] = findViewById(ResUtils.id(context, "pwd_iv_6_line_view"));
        this.a.addTextChangedListener(this);
        this.f50803g = AnimationUtils.loadAnimation(context, ResUtils.anim(context, "wallet_base_six_number_pwd_view_circle"));
        this.f50804h = AnimationUtils.loadAnimation(context, ResUtils.anim(context, "wallet_base_new_six_number_pwd_view_line"));
        this.f50805i = ResUtils.getDrawable(context, "wallet_base_new_six_number_pwd_view_circle");
        this.f50806j = ResUtils.getDrawable(context, "wallet_base_safekeyboard_six_number_circle_black");
        this.k = ResUtils.getColor(context, "ebpay_new_six_number_pwd_line_d0d3d9");
        a();
        a(-1);
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            int length = this.a.getText().length();
            for (int i2 = 0; i2 < 6; i2++) {
                if (i2 < length) {
                    this.f50798b[i2].setVisibility(0);
                    if (i2 == length - 1) {
                        this.f50798b[i2].setImageDrawable(this.f50805i);
                        if (this.f50802f) {
                            this.f50798b[i2].startAnimation(this.f50803g);
                        }
                    } else {
                        this.f50798b[i2].setImageDrawable(this.f50806j);
                    }
                } else {
                    this.f50798b[i2].setVisibility(8);
                }
            }
        }
    }

    public void addSixNumberPwdChangedListenter(OnPwdChangedListener onPwdChangedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onPwdChangedListener) == null) {
            this.f50801e = onPwdChangedListener;
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, editable) == null) {
            a();
            a(editable.length() - 1);
            OnPwdChangedListener onPwdChangedListener = this.f50801e;
            if (onPwdChangedListener != null) {
                onPwdChangedListener.onPwdChanged(editable.length());
            }
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) {
        }
    }

    public String getPwd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? TextUtils.isEmpty(this.a.getText().toString()) ? "" : SafePay.getInstance().localEncrypt1(this.a.getText().toString()) : (String) invokeV.objValue;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048580, this, i2, i3) == null) {
            int mode = View.MeasureSpec.getMode(i3);
            int mode2 = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            int size2 = View.MeasureSpec.getSize(i3);
            if (mode2 == 1073741824 || i2 == Integer.MIN_VALUE) {
                size = View.MeasureSpec.makeMeasureSpec(size, 1073741824);
                i3 = View.MeasureSpec.makeMeasureSpec((size - (DisplayUtils.dip2px(getContext(), 0.5f) * 5)) / 6, 1073741824);
            } else if (mode == 1073741824) {
                size = View.MeasureSpec.makeMeasureSpec((size2 * 6) + (DisplayUtils.dip2px(getContext(), 0.5f) * 5), 1073741824);
            } else {
                i3 = size2;
            }
            super.onMeasure(size, i3);
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048581, this, charSequence, i2, i3, i4) == null) {
            if (i4 < i3) {
                this.f50802f = false;
            } else {
                this.f50802f = true;
            }
        }
    }

    public void resetPwd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            LogUtil.logd("resetPwd");
            this.a.setText("");
        }
    }

    public void setShowInputMethod(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            ((SafeKeyBoardEditText) this.a).setShowInputMethod(z);
        }
    }

    private void a(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65538, this, i2) == null) || i2 > 5) {
            return;
        }
        for (int i3 = 0; i3 < 6; i3++) {
            this.f50800d[i3].setBackgroundColor(this.k);
            if (i3 == i2) {
                this.f50799c[i3].setVisibility(0);
                this.f50799c[i3].startAnimation(this.f50804h);
            } else {
                this.f50799c[i3].setVisibility(8);
            }
        }
    }
}
