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
    public Context f20743e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f20744f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f20745g;

    /* renamed from: h  reason: collision with root package name */
    public TbImageView f20746h;
    public ImageView i;

    public SettingTextNormalImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20743e = context;
        b();
        a(attributeSet);
        c(TbadkCoreApplication.getInst().getSkinType());
    }

    public final void a(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.f20743e.obtainStyledAttributes(attributeSet, R$styleable.TbSettingView);
        String string = obtainStyledAttributes.getString(R$styleable.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(R$styleable.TbSettingView_settingTextColor, -1);
        obtainStyledAttributes.recycle();
        if (string != null) {
            this.f20745g.setText(string);
        }
        if (color > -1) {
            this.f20745g.setTextColor(color);
        }
        this.f20744f.setClickable(false);
        this.f20744f.setFocusable(false);
    }

    public final void b() {
        LayoutInflater.from(this.f20743e).inflate(R.layout.setting_text_normal_image_view, (ViewGroup) this, true);
        this.f20744f = (LinearLayout) findViewById(R.id.container);
        this.f20745g = (TextView) findViewById(R.id.text);
        this.f20746h = (TbImageView) findViewById(R.id.icon);
        this.i = (ImageView) findViewById(R.id.arrow);
    }

    public void c(int i) {
        SkinManager.setViewTextColor(this.f20745g, R.color.CAM_X0105, 1);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.i, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        setBackgroundDrawable(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0205));
        this.f20746h.invalidate();
    }

    public void setLocalIcon(int i) {
        this.f20746h.B();
        this.f20746h.setConrers(0);
        this.f20746h.setImageResource(i);
    }

    public void setText(String str) {
        this.f20745g.setText(str);
    }

    public SettingTextNormalImageView(Context context) {
        super(context);
        this.f20743e = context;
        b();
        c(TbadkCoreApplication.getInst().getSkinType());
    }
}
