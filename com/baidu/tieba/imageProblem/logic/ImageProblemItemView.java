package com.baidu.tieba.imageProblem.logic;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.R$styleable;
/* loaded from: classes4.dex */
public class ImageProblemItemView extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f17708e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f17709f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f17710g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f17711h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f17712i;
    public LinearLayout j;
    public TextView k;

    public ImageProblemItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17708e = context;
        a();
        b(attributeSet);
    }

    public void a() {
        LayoutInflater.from(this.f17708e).inflate(R.layout.image_problem_item_view, (ViewGroup) this, true);
        this.f17709f = (LinearLayout) findViewById(R.id.container);
        this.f17710g = (TextView) findViewById(R.id.text);
        this.f17711h = (TextView) findViewById(R.id.tip);
        this.f17712i = (ImageView) findViewById(R.id.arrow2);
        this.j = (LinearLayout) findViewById(R.id.ll_container);
        this.k = (TextView) findViewById(R.id.tv_help);
    }

    public void b(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.f17708e.obtainStyledAttributes(attributeSet, R$styleable.TbSettingView);
        String string = obtainStyledAttributes.getString(R$styleable.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(R$styleable.TbSettingView_settingTextColor, -1);
        String string2 = obtainStyledAttributes.getString(R$styleable.TbSettingView_settingTip);
        int color2 = obtainStyledAttributes.getColor(R$styleable.TbSettingView_settingTipColor, -1);
        if (string != null) {
            this.f17710g.setText(string);
        }
        if (color > -1) {
            this.f17710g.setTextColor(color);
        }
        if (string2 != null) {
            this.f17711h.setText(string2);
        }
        if (color2 > -1) {
            this.f17711h.setTextColor(color2);
        }
        obtainStyledAttributes.recycle();
        this.f17709f.setClickable(false);
        this.f17709f.setFocusable(false);
        this.f17712i.setVisibility(4);
    }

    public void displayArrow() {
        this.f17712i.setVisibility(0);
    }

    public void displayTip() {
        TextView textView = this.f17711h;
        if (textView != null) {
            textView.setVisibility(0);
        }
    }

    public CharSequence getTip() {
        return this.f17711h.getText();
    }

    public void hideArrow() {
        this.f17712i.setVisibility(8);
    }

    public void hideTip() {
        TextView textView = this.f17711h;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    public void setArrowImg(int i2) {
        this.f17712i.setImageResource(i2);
    }

    public void setHelpText(String str) {
        if (TextUtils.isEmpty(str)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.j.getLayoutParams();
            layoutParams.bottomMargin = (int) getResources().getDimension(R.dimen.ds26);
            this.j.setLayoutParams(layoutParams);
            this.k.setText("");
            this.k.setVisibility(8);
            return;
        }
        this.j.setVisibility(0);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.j.getLayoutParams();
        layoutParams2.bottomMargin = (int) getResources().getDimension(R.dimen.ds10);
        this.j.setLayoutParams(layoutParams2);
        this.k.setText(str);
        this.k.setVisibility(0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void setStatus(int i2) {
        if (i2 == 1) {
            this.f17710g.setTextColor(getResources().getColor(R.color.CAM_X0105));
        } else if (i2 == 2) {
            this.f17710g.setTextColor(getResources().getColor(R.color.CAM_X0305));
        } else if (i2 == 3) {
            this.f17710g.setTextColor(getResources().getColor(R.color.CAM_X0110));
        }
    }

    public void setText(String str) {
        this.f17710g.setText(str);
    }

    public void setTip(String str) {
        this.f17711h.setText(str);
    }

    public void setTipBackground(Drawable drawable) {
        this.f17711h.setBackgroundDrawable(drawable);
    }

    public void setTipColor(int i2) {
        TextView textView = this.f17711h;
        if (textView != null) {
            textView.setTextColor(i2);
        }
    }

    public void setText(int i2) {
        this.f17710g.setText(i2);
    }

    public ImageProblemItemView(Context context) {
        super(context);
        this.f17708e = context;
        a();
    }
}
