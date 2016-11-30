package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class GuessYourLikeHeaderView extends LinearLayout {
    private View gfA;
    private TextView gfB;
    private View gfC;

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
        this.gfA = findViewById(r.g.guess_your_like_top_line);
        this.gfB = (TextView) findViewById(r.g.guess_your_like_title);
        this.gfC = findViewById(r.g.guess_your_like_divider);
    }

    public void tB() {
        at.l(this, r.d.cp_bg_line_d);
        at.l(this.gfA, r.d.cp_bg_line_c);
        at.j((View) this.gfB, r.d.cp_cont_d);
        at.l(this.gfC, r.d.cp_bg_line_b);
    }

    public void setTitleText(String str) {
        this.gfB.setText(str);
    }

    public void hide() {
        btk();
        if (this.gfB.getVisibility() != 8) {
            this.gfB.setVisibility(8);
        }
        if (this.gfC.getVisibility() != 8) {
            this.gfC.setVisibility(8);
        }
    }

    public void show() {
        btl();
        if (this.gfB.getVisibility() != 0) {
            this.gfB.setVisibility(0);
        }
        if (this.gfC.getVisibility() != 0) {
            this.gfC.setVisibility(0);
        }
    }

    public void btk() {
        if (this.gfA.getVisibility() != 8) {
            this.gfA.setVisibility(8);
        }
    }

    public void btl() {
        if (this.gfA.getVisibility() != 0) {
            this.gfA.setVisibility(0);
        }
    }
}
