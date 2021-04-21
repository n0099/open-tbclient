package com.baidu.tieba.setting.more;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.R$styleable;
/* loaded from: classes4.dex */
public class SettingTextImageView extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f20739e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f20740f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f20741g;

    /* renamed from: h  reason: collision with root package name */
    public HeadImageView f20742h;
    public ImageView i;

    public SettingTextImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20739e = context;
        d();
        c(attributeSet);
        f(TbadkCoreApplication.getInst().getSkinType());
    }

    public void a() {
        HeadImageView headImageView = this.f20742h;
        if (headImageView != null) {
            headImageView.setVisibility(0);
        }
    }

    public void b() {
        HeadImageView headImageView = this.f20742h;
        if (headImageView != null) {
            headImageView.setVisibility(8);
        }
    }

    public final void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.f20739e.obtainStyledAttributes(attributeSet, R$styleable.TbSettingView);
        String string = obtainStyledAttributes.getString(R$styleable.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(R$styleable.TbSettingView_settingTextColor, -1);
        obtainStyledAttributes.recycle();
        if (string != null) {
            this.f20741g.setText(string);
        }
        if (color > -1) {
            this.f20741g.setTextColor(color);
        }
        this.f20740f.setClickable(false);
        this.f20740f.setFocusable(false);
    }

    public final void d() {
        LayoutInflater.from(this.f20739e).inflate(R.layout.setting_text_image_view, (ViewGroup) this, true);
        this.f20740f = (LinearLayout) findViewById(R.id.container);
        this.f20741g = (TextView) findViewById(R.id.text);
        this.f20742h = (HeadImageView) findViewById(R.id.icon);
        this.i = (ImageView) findViewById(R.id.arrow);
    }

    public void e() {
    }

    public void f(int i) {
        setBackgroundDrawable(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0205));
        SkinManager.setViewTextColor(this.f20741g, R.color.CAM_X0105, 1);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.i, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        this.f20742h.invalidate();
    }

    public void setIcon(String str, boolean z) {
        if (z) {
            this.f20742h.W(str, 26, false);
        } else {
            this.f20742h.W(str, 12, false);
        }
    }

    public void setText(String str) {
        this.f20741g.setText(str);
    }

    public SettingTextImageView(Context context) {
        super(context);
        this.f20739e = context;
        d();
        f(TbadkCoreApplication.getInst().getSkinType());
    }
}
