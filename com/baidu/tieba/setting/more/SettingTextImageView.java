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
    public Context f20460e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f20461f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f20462g;

    /* renamed from: h  reason: collision with root package name */
    public HeadImageView f20463h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f20464i;

    public SettingTextImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20460e = context;
        d();
        c(attributeSet);
        f(TbadkCoreApplication.getInst().getSkinType());
    }

    public void a() {
        HeadImageView headImageView = this.f20463h;
        if (headImageView != null) {
            headImageView.setVisibility(0);
        }
    }

    public void b() {
        HeadImageView headImageView = this.f20463h;
        if (headImageView != null) {
            headImageView.setVisibility(8);
        }
    }

    public final void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.f20460e.obtainStyledAttributes(attributeSet, R$styleable.TbSettingView);
        String string = obtainStyledAttributes.getString(R$styleable.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(R$styleable.TbSettingView_settingTextColor, -1);
        obtainStyledAttributes.recycle();
        if (string != null) {
            this.f20462g.setText(string);
        }
        if (color > -1) {
            this.f20462g.setTextColor(color);
        }
        this.f20461f.setClickable(false);
        this.f20461f.setFocusable(false);
    }

    public final void d() {
        LayoutInflater.from(this.f20460e).inflate(R.layout.setting_text_image_view, (ViewGroup) this, true);
        this.f20461f = (LinearLayout) findViewById(R.id.container);
        this.f20462g = (TextView) findViewById(R.id.text);
        this.f20463h = (HeadImageView) findViewById(R.id.icon);
        this.f20464i = (ImageView) findViewById(R.id.arrow);
    }

    public void e() {
    }

    public void f(int i2) {
        setBackgroundDrawable(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0205));
        SkinManager.setViewTextColor(this.f20462g, R.color.CAM_X0105, 1);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f20464i, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        this.f20463h.invalidate();
    }

    public void setIcon(String str, boolean z) {
        if (z) {
            this.f20463h.V(str, 26, false);
        } else {
            this.f20463h.V(str, 12, false);
        }
    }

    public void setText(String str) {
        this.f20462g.setText(str);
    }

    public SettingTextImageView(Context context) {
        super(context);
        this.f20460e = context;
        d();
        f(TbadkCoreApplication.getInst().getSkinType());
    }
}
