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
/* loaded from: classes5.dex */
public class SettingTextImageView extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f21296e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f21297f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f21298g;

    /* renamed from: h  reason: collision with root package name */
    public HeadImageView f21299h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f21300i;

    public SettingTextImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21296e = context;
        d();
        c(attributeSet);
        f(TbadkCoreApplication.getInst().getSkinType());
    }

    public void a() {
        HeadImageView headImageView = this.f21299h;
        if (headImageView != null) {
            headImageView.setVisibility(0);
        }
    }

    public void b() {
        HeadImageView headImageView = this.f21299h;
        if (headImageView != null) {
            headImageView.setVisibility(8);
        }
    }

    public final void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.f21296e.obtainStyledAttributes(attributeSet, R$styleable.TbSettingView);
        String string = obtainStyledAttributes.getString(R$styleable.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(R$styleable.TbSettingView_settingTextColor, -1);
        obtainStyledAttributes.recycle();
        if (string != null) {
            this.f21298g.setText(string);
        }
        if (color > -1) {
            this.f21298g.setTextColor(color);
        }
        this.f21297f.setClickable(false);
        this.f21297f.setFocusable(false);
    }

    public final void d() {
        LayoutInflater.from(this.f21296e).inflate(R.layout.setting_text_image_view, (ViewGroup) this, true);
        this.f21297f = (LinearLayout) findViewById(R.id.container);
        this.f21298g = (TextView) findViewById(R.id.text);
        this.f21299h = (HeadImageView) findViewById(R.id.icon);
        this.f21300i = (ImageView) findViewById(R.id.arrow);
    }

    public void e() {
    }

    public void f(int i2) {
        setBackgroundDrawable(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0205));
        SkinManager.setViewTextColor(this.f21298g, R.color.CAM_X0105, 1);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f21300i, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        this.f21299h.invalidate();
    }

    public void setIcon(String str, boolean z) {
        if (z) {
            this.f21299h.V(str, 26, false);
        } else {
            this.f21299h.V(str, 12, false);
        }
    }

    public void setText(String str) {
        this.f21298g.setText(str);
    }

    public SettingTextImageView(Context context) {
        super(context);
        this.f21296e = context;
        d();
        f(TbadkCoreApplication.getInst().getSkinType());
    }
}
