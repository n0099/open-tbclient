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
    private final ImageView bGK;
    private final TextView bGL;
    private final View bGM;
    private final View bGN;
    private String bGO;
    private String bGP;
    private String bGQ;
    private final Interpolator bGR;
    private RotateAnimation bGS;
    private RotateAnimation bGT;
    private final int mode;

    public a(Context context, int i, String str, String str2, String str3) {
        super(context);
        this.bGR = new LinearInterpolator();
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(w.pull_to_refresh_header, this);
        this.bGL = (TextView) viewGroup.findViewById(v.pull_to_refresh_text);
        this.bGK = (ImageView) viewGroup.findViewById(v.pull_to_refresh_image);
        this.bGN = viewGroup.findViewById(v.pull_to_refresh_bottom_line);
        this.bGM = viewGroup.findViewById(v.pull_to_refresh_top_line);
        this.bGQ = str;
        this.bGO = str2;
        this.bGP = str3;
        this.mode = i;
        hf(i);
    }

    private void hf(int i) {
        if (i == 1) {
            this.bGM.setVisibility(8);
            this.bGN.setVisibility(0);
            return;
        }
        this.bGM.setVisibility(0);
        this.bGN.setVisibility(8);
    }

    private RotateAnimation getRotateAnimation() {
        if (this.bGS == null) {
            this.bGS = new RotateAnimation(0.0f, -180.0f, 1, 0.5f, 1, 0.5f);
            this.bGS.setInterpolator(this.bGR);
            this.bGS.setDuration(150L);
            this.bGS.setFillAfter(true);
        }
        return this.bGS;
    }

    private RotateAnimation getResetAnimiation() {
        if (this.bGT == null) {
            this.bGT = new RotateAnimation(-180.0f, 0.0f, 1, 0.5f, 1, 0.5f);
            this.bGT.setInterpolator(this.bGR);
            this.bGT.setDuration(150L);
            this.bGT.setFillAfter(true);
        }
        return this.bGT;
    }

    public void reset() {
        this.bGL.setText(this.bGO);
        this.bGK.setVisibility(0);
    }

    public void mO() {
        this.bGL.setText(this.bGQ);
        this.bGK.clearAnimation();
        this.bGK.startAnimation(getRotateAnimation());
    }

    public void setPullLabel(String str) {
        this.bGO = str;
    }

    public void mP() {
        this.bGL.setText(this.bGP);
        this.bGK.clearAnimation();
        this.bGK.setVisibility(4);
    }

    public void setRefreshingLabel(String str) {
        this.bGP = str;
    }

    public void setReleaseLabel(String str) {
        this.bGQ = str;
    }

    public void ne() {
        this.bGL.setText(this.bGO);
        this.bGK.clearAnimation();
        this.bGK.startAnimation(getResetAnimiation());
    }

    public void setTextColor(int i) {
        this.bGL.setTextColor(i);
    }

    public void rk() {
        ba.b(this.bGL, s.cp_cont_d, 1);
        ba.j(this.bGN, s.cp_bg_line_b);
        ba.j(this.bGM, s.cp_bg_line_b);
        if (this.mode == 2) {
            ba.c(this.bGK, u.icon_pullup);
        } else {
            ba.c(this.bGK, u.icon_pulldown);
        }
    }
}
