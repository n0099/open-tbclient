package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class GuessYourLikeHeaderView extends LinearLayout {
    private View fOa;
    private TextView fOb;
    private View fOc;

    public GuessYourLikeHeaderView(Context context) {
        super(context);
        init();
    }

    public GuessYourLikeHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public GuessYourLikeHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(u.h.guess_your_like_header, (ViewGroup) this, true);
        this.fOa = findViewById(u.g.guess_your_like_top_line);
        this.fOb = (TextView) findViewById(u.g.guess_your_like_title);
        this.fOc = findViewById(u.g.guess_your_like_divider);
    }

    public void sd() {
        av.l(this, u.d.cp_bg_line_d);
        av.l(this.fOa, u.d.cp_bg_line_c);
        av.j((View) this.fOb, u.d.cp_cont_d);
        av.l(this.fOc, u.d.cp_bg_line_b);
    }

    public void setTitleText(String str) {
        this.fOb.setText(str);
    }

    public void hide() {
        bmC();
        if (this.fOb.getVisibility() != 8) {
            this.fOb.setVisibility(8);
        }
        if (this.fOc.getVisibility() != 8) {
            this.fOc.setVisibility(8);
        }
    }

    public void show() {
        bmD();
        if (this.fOb.getVisibility() != 0) {
            this.fOb.setVisibility(0);
        }
        if (this.fOc.getVisibility() != 0) {
            this.fOc.setVisibility(0);
        }
    }

    public void bmC() {
        if (this.fOa.getVisibility() != 8) {
            this.fOa.setVisibility(8);
        }
    }

    public void bmD() {
        if (this.fOa.getVisibility() != 0) {
            this.fOa.setVisibility(0);
        }
    }
}
