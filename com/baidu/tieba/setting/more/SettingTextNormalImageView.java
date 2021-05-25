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
/* loaded from: classes5.dex */
public class SettingTextNormalImageView extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f20465e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f20466f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f20467g;

    /* renamed from: h  reason: collision with root package name */
    public TbImageView f20468h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f20469i;

    public SettingTextNormalImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20465e = context;
        b();
        a(attributeSet);
        c(TbadkCoreApplication.getInst().getSkinType());
    }

    public final void a(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.f20465e.obtainStyledAttributes(attributeSet, R$styleable.TbSettingView);
        String string = obtainStyledAttributes.getString(R$styleable.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(R$styleable.TbSettingView_settingTextColor, -1);
        obtainStyledAttributes.recycle();
        if (string != null) {
            this.f20467g.setText(string);
        }
        if (color > -1) {
            this.f20467g.setTextColor(color);
        }
        this.f20466f.setClickable(false);
        this.f20466f.setFocusable(false);
    }

    public final void b() {
        LayoutInflater.from(this.f20465e).inflate(R.layout.setting_text_normal_image_view, (ViewGroup) this, true);
        this.f20466f = (LinearLayout) findViewById(R.id.container);
        this.f20467g = (TextView) findViewById(R.id.text);
        this.f20468h = (TbImageView) findViewById(R.id.icon);
        this.f20469i = (ImageView) findViewById(R.id.arrow);
    }

    public void c(int i2) {
        SkinManager.setViewTextColor(this.f20467g, R.color.CAM_X0105, 1);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f20469i, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        setBackgroundDrawable(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0205));
        this.f20468h.invalidate();
    }

    public void setLocalIcon(int i2) {
        this.f20468h.A();
        this.f20468h.setConrers(0);
        this.f20468h.setImageResource(i2);
    }

    public void setText(String str) {
        this.f20467g.setText(str);
    }

    public SettingTextNormalImageView(Context context) {
        super(context);
        this.f20465e = context;
        b();
        c(TbadkCoreApplication.getInst().getSkinType());
    }
}
