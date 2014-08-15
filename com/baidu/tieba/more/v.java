package com.baidu.tieba.more;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
/* loaded from: classes.dex */
public class v extends FrameLayout {
    protected Context a;
    protected LinearLayout b;
    protected TextView c;
    protected TextView d;
    protected ImageView e;
    protected LinearLayout f;
    protected TextView g;

    public v(Context context) {
        super(context);
        this.a = context;
        c();
    }

    public void setTipColor(int i) {
        if (this.d != null) {
            this.d.setTextColor(i);
        }
    }

    public void a() {
        this.e.setVisibility(8);
    }

    public void b() {
        this.e.setVisibility(0);
    }

    public void setArrowImg(int i) {
        this.e.setImageResource(i);
    }

    public void setHelpText(String str) {
        if (TextUtils.isEmpty(str)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f.getLayoutParams();
            layoutParams.bottomMargin = (int) getResources().getDimension(com.baidu.tieba.s.ds26);
            this.f.setLayoutParams(layoutParams);
            this.g.setText("");
            this.g.setVisibility(8);
            return;
        }
        this.f.setVisibility(0);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f.getLayoutParams();
        layoutParams2.bottomMargin = (int) getResources().getDimension(com.baidu.tieba.s.ds10);
        this.f.setLayoutParams(layoutParams2);
        this.g.setText(str);
        this.g.setVisibility(0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void setStatus(int i) {
        if (i == 1) {
            this.c.setTextColor(getResources().getColor(com.baidu.tieba.r.cp_cont_b));
        } else if (i == 2) {
            this.c.setTextColor(getResources().getColor(com.baidu.tieba.r.cp_link_tip_d));
        } else if (i == 3) {
            this.c.setTextColor(getResources().getColor(com.baidu.tieba.r.cp_cont_e));
        }
    }

    public void setText(String str) {
        this.c.setText(str);
    }

    public void setText(int i) {
        this.c.setText(i);
    }

    public void setTip(String str) {
        this.d.setText(str);
    }

    public CharSequence getTip() {
        return this.d.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.d.setBackgroundDrawable(drawable);
    }

    protected void c() {
        LayoutInflater.from(this.a).inflate(com.baidu.tieba.v.image_problem_item_view, (ViewGroup) this, true);
        this.b = (LinearLayout) findViewById(com.baidu.tieba.u.container);
        this.c = (TextView) findViewById(com.baidu.tieba.u.text);
        this.d = (TextView) findViewById(com.baidu.tieba.u.tip);
        this.e = (ImageView) findViewById(com.baidu.tieba.u.arrow2);
        this.f = (LinearLayout) findViewById(com.baidu.tieba.u.ll_container);
        this.g = (TextView) findViewById(com.baidu.tieba.u.tv_help);
    }
}
