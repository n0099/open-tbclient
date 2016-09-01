package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class GuessYourLikeHeaderView extends LinearLayout {
    private View fWa;
    private TextView fWb;
    private View fWc;

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
        LayoutInflater.from(getContext()).inflate(t.h.guess_your_like_header, (ViewGroup) this, true);
        this.fWa = findViewById(t.g.guess_your_like_top_line);
        this.fWb = (TextView) findViewById(t.g.guess_your_like_title);
        this.fWc = findViewById(t.g.guess_your_like_divider);
    }

    public void ti() {
        av.l(this, t.d.cp_bg_line_d);
        av.l(this.fWa, t.d.cp_bg_line_c);
        av.j((View) this.fWb, t.d.cp_cont_d);
        av.l(this.fWc, t.d.cp_bg_line_b);
    }

    public void setTitleText(String str) {
        this.fWb.setText(str);
    }

    public void hide() {
        bqn();
        if (this.fWb.getVisibility() != 8) {
            this.fWb.setVisibility(8);
        }
        if (this.fWc.getVisibility() != 8) {
            this.fWc.setVisibility(8);
        }
    }

    public void show() {
        bqo();
        if (this.fWb.getVisibility() != 0) {
            this.fWb.setVisibility(0);
        }
        if (this.fWc.getVisibility() != 0) {
            this.fWc.setVisibility(0);
        }
    }

    public void bqn() {
        if (this.fWa.getVisibility() != 8) {
            this.fWa.setVisibility(8);
        }
    }

    public void bqo() {
        if (this.fWa.getVisibility() != 0) {
            this.fWa.setVisibility(0);
        }
    }
}
