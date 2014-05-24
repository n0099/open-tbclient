package com.baidu.tieba.more;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
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
            this.c.setTextColor(this.a.getResources().getColor(com.baidu.tieba.s.about_tip_color_1));
            this.e.setImageResource(com.baidu.tieba.u.icon_arrow_right_1);
        } else {
            this.c.setTextColor(this.a.getResources().getColor(com.baidu.tieba.s.about_tip_color));
            this.e.setImageResource(com.baidu.tieba.u.icon_arrow_right);
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

    public void setIcon(com.baidu.adp.widget.a.a aVar) {
        if (this.d != null && aVar != null) {
            aVar.a(this.d);
        }
    }

    public void setIcon(int i) {
        if (this.d != null) {
            this.d.setDefaultResource(0);
            this.d.setIsRound(true);
            this.d.setNightDefaultResource(0);
            this.d.setImageBitmap(com.baidu.tbadk.core.util.g.a(com.baidu.tieba.u.person_photo));
        }
    }

    public void c() {
    }

    private void d() {
        LayoutInflater.from(this.a).inflate(com.baidu.tieba.w.setting_text_image_view, (ViewGroup) this, true);
        this.b = (LinearLayout) findViewById(com.baidu.tieba.v.container);
        this.c = (TextView) findViewById(com.baidu.tieba.v.text);
        this.d = (HeadImageView) findViewById(com.baidu.tieba.v.icon);
        this.e = (ImageView) findViewById(com.baidu.tieba.v.arrow);
    }

    private void a(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.a.obtainStyledAttributes(attributeSet, com.baidu.tieba.aa.TbSettingView);
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
