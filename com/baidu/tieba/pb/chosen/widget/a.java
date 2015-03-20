package com.baidu.tieba.pb.chosen.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.s;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class a extends FrameLayout {
    private final View bGA;
    private String bGB;
    private String bGC;
    private String bGD;
    private final Interpolator bGE;
    private RotateAnimation bGF;
    private RotateAnimation bGG;
    private final ImageView bGx;
    private final TextView bGy;
    private final View bGz;
    private final int mode;

    public a(Context context, int i, String str, String str2, String str3) {
        super(context);
        this.bGE = new LinearInterpolator();
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(w.pull_to_refresh_header, this);
        this.bGy = (TextView) viewGroup.findViewById(v.pull_to_refresh_text);
        this.bGx = (ImageView) viewGroup.findViewById(v.pull_to_refresh_image);
        this.bGA = viewGroup.findViewById(v.pull_to_refresh_bottom_line);
        this.bGz = viewGroup.findViewById(v.pull_to_refresh_top_line);
        this.bGD = str;
        this.bGB = str2;
        this.bGC = str3;
        this.mode = i;
        hd(i);
    }

    private void hd(int i) {
        if (i == 1) {
            this.bGz.setVisibility(8);
            this.bGA.setVisibility(0);
            return;
        }
        this.bGz.setVisibility(0);
        this.bGA.setVisibility(8);
    }

    private RotateAnimation getRotateAnimation() {
        if (this.bGF == null) {
            this.bGF = new RotateAnimation(0.0f, -180.0f, 1, 0.5f, 1, 0.5f);
            this.bGF.setInterpolator(this.bGE);
            this.bGF.setDuration(150L);
            this.bGF.setFillAfter(true);
        }
        return this.bGF;
    }

    private RotateAnimation getResetAnimiation() {
        if (this.bGG == null) {
            this.bGG = new RotateAnimation(-180.0f, 0.0f, 1, 0.5f, 1, 0.5f);
            this.bGG.setInterpolator(this.bGE);
            this.bGG.setDuration(150L);
            this.bGG.setFillAfter(true);
        }
        return this.bGG;
    }

    public void reset() {
        this.bGy.setText(this.bGB);
        this.bGx.setVisibility(0);
    }

    public void mO() {
        this.bGy.setText(this.bGD);
        this.bGx.clearAnimation();
        this.bGx.startAnimation(getRotateAnimation());
    }

    public void setPullLabel(String str) {
        this.bGB = str;
    }

    public void mP() {
        this.bGy.setText(this.bGC);
        this.bGx.clearAnimation();
        this.bGx.setVisibility(4);
    }

    public void setRefreshingLabel(String str) {
        this.bGC = str;
    }

    public void setReleaseLabel(String str) {
        this.bGD = str;
    }

    public void ne() {
        this.bGy.setText(this.bGB);
        this.bGx.clearAnimation();
        this.bGx.startAnimation(getResetAnimiation());
    }

    public void setTextColor(int i) {
        this.bGy.setTextColor(i);
    }

    public void rk() {
        ba.b(this.bGy, s.cp_cont_d, 1);
        ba.j(this.bGA, s.cp_bg_line_b);
        ba.j(this.bGz, s.cp_bg_line_b);
        if (this.mode == 2) {
            ba.c(this.bGx, u.icon_pullup);
        } else {
            ba.c(this.bGx, u.icon_pulldown);
        }
    }
}
