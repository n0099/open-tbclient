package com.baidu.tieba.more;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.HeadImageView;
/* loaded from: classes.dex */
public class SettingTextImageView extends FrameLayout {
    private Context a;
    private LinearLayout b;
    private TextView c;
    private HeadImageView d;
    private ImageView e;

    public SettingTextImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = context;
        d();
        a(attributeSet);
        a(TbadkApplication.m252getInst().getSkinType());
    }

    public SettingTextImageView(Context context) {
        super(context);
        this.a = context;
        d();
        a(TbadkApplication.m252getInst().getSkinType());
    }

    public void a(int i) {
        if (i == 1) {
            this.c.setTextColor(this.a.getResources().getColor(com.baidu.tieba.r.about_tip_color_1));
            this.e.setImageResource(com.baidu.tieba.t.icon_arrow_right_1);
        } else {
            this.c.setTextColor(this.a.getResources().getColor(com.baidu.tieba.r.about_tip_color));
            this.e.setImageResource(com.baidu.tieba.t.icon_arrow_right);
        }
        this.d.invalidate();
    }

    public void a() {
        if (this.d != null) {
            this.d.setVisibility(8);
        }
    }

    public void b() {
        if (this.d != null) {
            this.d.setVisibility(0);
        }
    }

    public void setText(String str) {
        this.c.setText(str);
    }

    public void a(String str, boolean z) {
        if (z) {
            this.d.a(str, 26, false);
        } else {
            this.d.a(str, 12, false);
        }
    }

    public void c() {
    }

    private void d() {
        com.baidu.adp.lib.e.b.a().a(this.a, com.baidu.tieba.v.setting_text_image_view, this, true);
        this.b = (LinearLayout) findViewById(com.baidu.tieba.u.container);
        this.c = (TextView) findViewById(com.baidu.tieba.u.text);
        this.d = (HeadImageView) findViewById(com.baidu.tieba.u.icon);
        this.e = (ImageView) findViewById(com.baidu.tieba.u.arrow);
    }

    private void a(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.a.obtainStyledAttributes(attributeSet, com.baidu.tieba.z.TbSettingView);
        String string = obtainStyledAttributes.getString(0);
        int color = obtainStyledAttributes.getColor(1, -1);
        obtainStyledAttributes.recycle();
        if (string != null) {
            this.c.setText(string);
        }
        if (color > -1) {
            this.c.setTextColor(color);
        }
        this.b.setClickable(false);
        this.b.setFocusable(false);
    }
}
