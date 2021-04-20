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
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.R$styleable;
/* loaded from: classes4.dex */
public class SettingTextNormalImageView extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f20735e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f20736f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f20737g;

    /* renamed from: h  reason: collision with root package name */
    public TbImageView f20738h;
    public ImageView i;

    public SettingTextNormalImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20735e = context;
        b();
        a(attributeSet);
        c(TbadkCoreApplication.getInst().getSkinType());
    }

    public final void a(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.f20735e.obtainStyledAttributes(attributeSet, R$styleable.TbSettingView);
        String string = obtainStyledAttributes.getString(R$styleable.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(R$styleable.TbSettingView_settingTextColor, -1);
        obtainStyledAttributes.recycle();
        if (string != null) {
            this.f20737g.setText(string);
        }
        if (color > -1) {
            this.f20737g.setTextColor(color);
        }
        this.f20736f.setClickable(false);
        this.f20736f.setFocusable(false);
    }

    public final void b() {
        LayoutInflater.from(this.f20735e).inflate(R.layout.setting_text_normal_image_view, (ViewGroup) this, true);
        this.f20736f = (LinearLayout) findViewById(R.id.container);
        this.f20737g = (TextView) findViewById(R.id.text);
        this.f20738h = (TbImageView) findViewById(R.id.icon);
        this.i = (ImageView) findViewById(R.id.arrow);
    }

    public void c(int i) {
        SkinManager.setViewTextColor(this.f20737g, R.color.CAM_X0105, 1);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.i, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        setBackgroundDrawable(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0205));
        this.f20738h.invalidate();
    }

    public void setLocalIcon(int i) {
        this.f20738h.B();
        this.f20738h.setConrers(0);
        this.f20738h.setImageResource(i);
    }

    public void setText(String str) {
        this.f20737g.setText(str);
    }

    public SettingTextNormalImageView(Context context) {
        super(context);
        this.f20735e = context;
        b();
        c(TbadkCoreApplication.getInst().getSkinType());
    }
}
