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
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.view.HeadImageView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class SettingTextImageView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private Context f1971a;
    private LinearLayout b;
    private TextView c;
    private HeadImageView d;
    private ImageView e;

    public SettingTextImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1971a = context;
        d();
        a(attributeSet);
        a(TiebaApplication.g().as());
    }

    public SettingTextImageView(Context context) {
        super(context);
        this.f1971a = context;
        d();
        a(TiebaApplication.g().as());
    }

    public void a(int i) {
        if (i == 1) {
            this.c.setTextColor(this.f1971a.getResources().getColor(R.color.skin_1_common_color));
            this.e.setImageResource(R.drawable.icon_arrow_right_1);
        } else {
            this.c.setTextColor(this.f1971a.getResources().getColor(R.color.more_color));
            this.e.setImageResource(R.drawable.icon_arrow_right);
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

    public void setIcon(String str) {
        if (this.d != null) {
            this.d.a(str, 1);
        }
    }

    public void setIcon(com.baidu.adp.widget.ImageView.e eVar) {
        if (this.d != null) {
            eVar.a(this.d);
        }
    }

    public void setIcon(int i) {
        if (this.d != null) {
            this.d.setImageResource(i);
        }
    }

    public void c() {
    }

    private void d() {
        LayoutInflater.from(this.f1971a).inflate(R.layout.setting_text_image_view, (ViewGroup) this, true);
        this.b = (LinearLayout) findViewById(R.id.container);
        this.c = (TextView) findViewById(R.id.text);
        this.d = (HeadImageView) findViewById(R.id.icon);
        this.e = (ImageView) findViewById(R.id.arrow);
    }

    private void a(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.f1971a.obtainStyledAttributes(attributeSet, com.baidu.tieba.al.SettingView);
        String string = obtainStyledAttributes.getString(0);
        int color = obtainStyledAttributes.getColor(1, -1);
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
