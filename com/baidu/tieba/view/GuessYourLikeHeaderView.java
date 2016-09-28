package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class GuessYourLikeHeaderView extends LinearLayout {
    private View fYf;
    private TextView fYg;
    private View fYh;

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
        LayoutInflater.from(getContext()).inflate(r.h.guess_your_like_header, (ViewGroup) this, true);
        this.fYf = findViewById(r.g.guess_your_like_top_line);
        this.fYg = (TextView) findViewById(r.g.guess_your_like_title);
        this.fYh = findViewById(r.g.guess_your_like_divider);
    }

    public void tx() {
        av.l(this, r.d.cp_bg_line_d);
        av.l(this.fYf, r.d.cp_bg_line_c);
        av.j((View) this.fYg, r.d.cp_cont_d);
        av.l(this.fYh, r.d.cp_bg_line_b);
    }

    public void setTitleText(String str) {
        this.fYg.setText(str);
    }

    public void hide() {
        bqR();
        if (this.fYg.getVisibility() != 8) {
            this.fYg.setVisibility(8);
        }
        if (this.fYh.getVisibility() != 8) {
            this.fYh.setVisibility(8);
        }
    }

    public void show() {
        bqS();
        if (this.fYg.getVisibility() != 0) {
            this.fYg.setVisibility(0);
        }
        if (this.fYh.getVisibility() != 0) {
            this.fYh.setVisibility(0);
        }
    }

    public void bqR() {
        if (this.fYf.getVisibility() != 8) {
            this.fYf.setVisibility(8);
        }
    }

    public void bqS() {
        if (this.fYf.getVisibility() != 0) {
            this.fYf.setVisibility(0);
        }
    }
}
