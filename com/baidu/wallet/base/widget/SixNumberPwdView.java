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
import com.baidu.apollon.armor.SafePay;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.core.utils.LogUtil;
/* loaded from: classes5.dex */
public class SixNumberPwdView extends LinearLayout implements TextWatcher {
    public static final int PWD_LEN = 6;

    /* renamed from: a  reason: collision with root package name */
    public EditText f23640a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView[] f23641b;

    /* renamed from: c  reason: collision with root package name */
    public View[] f23642c;

    /* renamed from: d  reason: collision with root package name */
    public View[] f23643d;

    /* renamed from: e  reason: collision with root package name */
    public OnPwdChangedListener f23644e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f23645f;

    /* renamed from: g  reason: collision with root package name */
    public Animation f23646g;

    /* renamed from: h  reason: collision with root package name */
    public Animation f23647h;

    /* renamed from: i  reason: collision with root package name */
    public Drawable f23648i;
    public Drawable j;
    public int k;

    /* loaded from: classes5.dex */
    public interface OnPwdChangedListener {
        void onPwdChanged(int i2);
    }

    public SixNumberPwdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f23641b = new ImageView[6];
        this.f23642c = new View[6];
        this.f23643d = new View[6];
        this.f23645f = true;
        this.f23646g = null;
        this.f23647h = null;
        this.f23648i = null;
        this.j = null;
        this.f23640a = (EditText) LayoutInflater.from(context).inflate(ResUtils.layout(context, "wallet_base_new_view_six_pwd"), this).findViewById(ResUtils.id(context, "pwd_input"));
        this.f23641b[0] = (ImageView) findViewById(ResUtils.id(context, "pwd_iv_1"));
        this.f23642c[0] = findViewById(ResUtils.id(context, "pwd_iv_1_line"));
        this.f23643d[0] = findViewById(ResUtils.id(context, "pwd_iv_1_line_view"));
        this.f23641b[1] = (ImageView) findViewById(ResUtils.id(context, "pwd_iv_2"));
        this.f23642c[1] = findViewById(ResUtils.id(context, "pwd_iv_2_line"));
        this.f23643d[1] = findViewById(ResUtils.id(context, "pwd_iv_2_line_view"));
        this.f23641b[2] = (ImageView) findViewById(ResUtils.id(context, "pwd_iv_3"));
        this.f23642c[2] = findViewById(ResUtils.id(context, "pwd_iv_3_line"));
        this.f23643d[2] = findViewById(ResUtils.id(context, "pwd_iv_3_line_view"));
        this.f23641b[3] = (ImageView) findViewById(ResUtils.id(context, "pwd_iv_4"));
        this.f23642c[3] = findViewById(ResUtils.id(context, "pwd_iv_4_line"));
        this.f23643d[3] = findViewById(ResUtils.id(context, "pwd_iv_4_line_view"));
        this.f23641b[4] = (ImageView) findViewById(ResUtils.id(context, "pwd_iv_5"));
        this.f23642c[4] = findViewById(ResUtils.id(context, "pwd_iv_5_line"));
        this.f23643d[4] = findViewById(ResUtils.id(context, "pwd_iv_5_line_view"));
        this.f23641b[5] = (ImageView) findViewById(ResUtils.id(context, "pwd_iv_6"));
        this.f23642c[5] = findViewById(ResUtils.id(context, "pwd_iv_6_line"));
        this.f23643d[5] = findViewById(ResUtils.id(context, "pwd_iv_6_line_view"));
        this.f23640a.addTextChangedListener(this);
        this.f23646g = AnimationUtils.loadAnimation(context, ResUtils.anim(context, "wallet_base_six_number_pwd_view_circle"));
        this.f23647h = AnimationUtils.loadAnimation(context, ResUtils.anim(context, "wallet_base_new_six_number_pwd_view_line"));
        this.f23648i = ResUtils.getDrawable(context, "wallet_base_new_six_number_pwd_view_circle");
        this.j = ResUtils.getDrawable(context, "wallet_base_safekeyboard_six_number_circle_black");
        this.k = ResUtils.getColor(context, "ebpay_new_six_number_pwd_line_d0d3d9");
        a();
        a(-1);
    }

    private void a() {
        int length = this.f23640a.getText().length();
        for (int i2 = 0; i2 < 6; i2++) {
            if (i2 < length) {
                this.f23641b[i2].setVisibility(0);
                if (i2 == length - 1) {
                    this.f23641b[i2].setImageDrawable(this.f23648i);
                    if (this.f23645f) {
                        this.f23641b[i2].startAnimation(this.f23646g);
                    }
                } else {
                    this.f23641b[i2].setImageDrawable(this.j);
                }
            } else {
                this.f23641b[i2].setVisibility(8);
            }
        }
    }

    public void addSixNumberPwdChangedListenter(OnPwdChangedListener onPwdChangedListener) {
        this.f23644e = onPwdChangedListener;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        a();
        a(editable.length() - 1);
        OnPwdChangedListener onPwdChangedListener = this.f23644e;
        if (onPwdChangedListener != null) {
            onPwdChangedListener.onPwdChanged(editable.length());
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    public String getPwd() {
        return TextUtils.isEmpty(this.f23640a.getText().toString()) ? "" : SafePay.getInstance().localEncrypt1(this.f23640a.getText().toString());
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i2, int i3) {
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

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        if (i4 < i3) {
            this.f23645f = false;
        } else {
            this.f23645f = true;
        }
    }

    public void resetPwd() {
        LogUtil.logd("resetPwd");
        this.f23640a.setText("");
    }

    public void setShowInputMethod(boolean z) {
        ((SafeKeyBoardEditText) this.f23640a).setShowInputMethod(z);
    }

    private void a(int i2) {
        if (i2 > 5) {
            return;
        }
        for (int i3 = 0; i3 < 6; i3++) {
            this.f23643d[i3].setBackgroundColor(this.k);
            if (i3 == i2) {
                this.f23642c[i3].setVisibility(0);
                this.f23642c[i3].startAnimation(this.f23647h);
            } else {
                this.f23642c[i3].setVisibility(8);
            }
        }
    }
}
