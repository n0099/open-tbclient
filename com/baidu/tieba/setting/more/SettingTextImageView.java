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
    public Context f21045e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f21046f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f21047g;

    /* renamed from: h  reason: collision with root package name */
    public HeadImageView f21048h;
    public ImageView i;

    public SettingTextImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21045e = context;
        d();
        c(attributeSet);
        f(TbadkCoreApplication.getInst().getSkinType());
    }

    public void a() {
        HeadImageView headImageView = this.f21048h;
        if (headImageView != null) {
            headImageView.setVisibility(0);
        }
    }

    public void b() {
        HeadImageView headImageView = this.f21048h;
        if (headImageView != null) {
            headImageView.setVisibility(8);
        }
    }

    public final void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.f21045e.obtainStyledAttributes(attributeSet, R$styleable.TbSettingView);
        String string = obtainStyledAttributes.getString(R$styleable.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(R$styleable.TbSettingView_settingTextColor, -1);
        obtainStyledAttributes.recycle();
        if (string != null) {
            this.f21047g.setText(string);
        }
        if (color > -1) {
            this.f21047g.setTextColor(color);
        }
        this.f21046f.setClickable(false);
        this.f21046f.setFocusable(false);
    }

    public final void d() {
        LayoutInflater.from(this.f21045e).inflate(R.layout.setting_text_image_view, (ViewGroup) this, true);
        this.f21046f = (LinearLayout) findViewById(R.id.container);
        this.f21047g = (TextView) findViewById(R.id.text);
        this.f21048h = (HeadImageView) findViewById(R.id.icon);
        this.i = (ImageView) findViewById(R.id.arrow);
    }

    public void e() {
    }

    public void f(int i) {
        setBackgroundDrawable(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0205));
        SkinManager.setViewTextColor(this.f21047g, R.color.CAM_X0105, 1);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.i, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        this.f21048h.invalidate();
    }

    public void setIcon(String str, boolean z) {
        if (z) {
            this.f21048h.W(str, 26, false);
        } else {
            this.f21048h.W(str, 12, false);
        }
    }

    public void setText(String str) {
        this.f21047g.setText(str);
    }

    public SettingTextImageView(Context context) {
        super(context);
        this.f21045e = context;
        d();
        f(TbadkCoreApplication.getInst().getSkinType());
    }
}
