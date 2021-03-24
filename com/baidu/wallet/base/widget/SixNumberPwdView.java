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
    public EditText f23965a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView[] f23966b;

    /* renamed from: c  reason: collision with root package name */
    public View[] f23967c;

    /* renamed from: d  reason: collision with root package name */
    public View[] f23968d;

    /* renamed from: e  reason: collision with root package name */
    public OnPwdChangedListener f23969e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f23970f;

    /* renamed from: g  reason: collision with root package name */
    public Animation f23971g;

    /* renamed from: h  reason: collision with root package name */
    public Animation f23972h;
    public Drawable i;
    public Drawable j;
    public int k;

    /* loaded from: classes5.dex */
    public interface OnPwdChangedListener {
        void onPwdChanged(int i);
    }

    public SixNumberPwdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f23966b = new ImageView[6];
        this.f23967c = new View[6];
        this.f23968d = new View[6];
        this.f23970f = true;
        this.f23971g = null;
        this.f23972h = null;
        this.i = null;
        this.j = null;
        this.f23965a = (EditText) LayoutInflater.from(context).inflate(ResUtils.layout(context, "wallet_base_new_view_six_pwd"), this).findViewById(ResUtils.id(context, "pwd_input"));
        this.f23966b[0] = (ImageView) findViewById(ResUtils.id(context, "pwd_iv_1"));
        this.f23967c[0] = findViewById(ResUtils.id(context, "pwd_iv_1_line"));
        this.f23968d[0] = findViewById(ResUtils.id(context, "pwd_iv_1_line_view"));
        this.f23966b[1] = (ImageView) findViewById(ResUtils.id(context, "pwd_iv_2"));
        this.f23967c[1] = findViewById(ResUtils.id(context, "pwd_iv_2_line"));
        this.f23968d[1] = findViewById(ResUtils.id(context, "pwd_iv_2_line_view"));
        this.f23966b[2] = (ImageView) findViewById(ResUtils.id(context, "pwd_iv_3"));
        this.f23967c[2] = findViewById(ResUtils.id(context, "pwd_iv_3_line"));
        this.f23968d[2] = findViewById(ResUtils.id(context, "pwd_iv_3_line_view"));
        this.f23966b[3] = (ImageView) findViewById(ResUtils.id(context, "pwd_iv_4"));
        this.f23967c[3] = findViewById(ResUtils.id(context, "pwd_iv_4_line"));
        this.f23968d[3] = findViewById(ResUtils.id(context, "pwd_iv_4_line_view"));
        this.f23966b[4] = (ImageView) findViewById(ResUtils.id(context, "pwd_iv_5"));
        this.f23967c[4] = findViewById(ResUtils.id(context, "pwd_iv_5_line"));
        this.f23968d[4] = findViewById(ResUtils.id(context, "pwd_iv_5_line_view"));
        this.f23966b[5] = (ImageView) findViewById(ResUtils.id(context, "pwd_iv_6"));
        this.f23967c[5] = findViewById(ResUtils.id(context, "pwd_iv_6_line"));
        this.f23968d[5] = findViewById(ResUtils.id(context, "pwd_iv_6_line_view"));
        this.f23965a.addTextChangedListener(this);
        this.f23971g = AnimationUtils.loadAnimation(context, ResUtils.anim(context, "wallet_base_six_number_pwd_view_circle"));
        this.f23972h = AnimationUtils.loadAnimation(context, ResUtils.anim(context, "wallet_base_new_six_number_pwd_view_line"));
        this.i = ResUtils.getDrawable(context, "wallet_base_new_six_number_pwd_view_circle");
        this.j = ResUtils.getDrawable(context, "wallet_base_safekeyboard_six_number_circle_black");
        this.k = ResUtils.getColor(context, "ebpay_new_six_number_pwd_line_d0d3d9");
        a();
        a(-1);
    }

    private void a() {
        int length = this.f23965a.getText().length();
        for (int i = 0; i < 6; i++) {
            if (i < length) {
                this.f23966b[i].setVisibility(0);
                if (i == length - 1) {
                    this.f23966b[i].setImageDrawable(this.i);
                    if (this.f23970f) {
                        this.f23966b[i].startAnimation(this.f23971g);
                    }
                } else {
                    this.f23966b[i].setImageDrawable(this.j);
                }
            } else {
                this.f23966b[i].setVisibility(8);
            }
        }
    }

    public void addSixNumberPwdChangedListenter(OnPwdChangedListener onPwdChangedListener) {
        this.f23969e = onPwdChangedListener;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        a();
        a(editable.length() - 1);
        OnPwdChangedListener onPwdChangedListener = this.f23969e;
        if (onPwdChangedListener != null) {
            onPwdChangedListener.onPwdChanged(editable.length());
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public String getPwd() {
        return TextUtils.isEmpty(this.f23965a.getText().toString()) ? "" : SafePay.getInstance().localEncrypt1(this.f23965a.getText().toString());
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode2 == 1073741824 || i == Integer.MIN_VALUE) {
            size = View.MeasureSpec.makeMeasureSpec(size, 1073741824);
            i2 = View.MeasureSpec.makeMeasureSpec((size - (DisplayUtils.dip2px(getContext(), 0.5f) * 5)) / 6, 1073741824);
        } else if (mode == 1073741824) {
            size = View.MeasureSpec.makeMeasureSpec((size2 * 6) + (DisplayUtils.dip2px(getContext(), 0.5f) * 5), 1073741824);
        } else {
            i2 = size2;
        }
        super.onMeasure(size, i2);
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (i3 < i2) {
            this.f23970f = false;
        } else {
            this.f23970f = true;
        }
    }

    public void resetPwd() {
        LogUtil.logd("resetPwd");
        this.f23965a.setText("");
    }

    public void setShowInputMethod(boolean z) {
        ((SafeKeyBoardEditText) this.f23965a).setShowInputMethod(z);
    }

    private void a(int i) {
        if (i > 5) {
            return;
        }
        for (int i2 = 0; i2 < 6; i2++) {
            this.f23968d[i2].setBackgroundColor(this.k);
            if (i2 == i) {
                this.f23967c[i2].setVisibility(0);
                this.f23967c[i2].startAnimation(this.f23972h);
            } else {
                this.f23967c[i2].setVisibility(8);
            }
        }
    }
}
