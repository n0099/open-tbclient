package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.widget.TextView;
/* loaded from: classes.dex */
public class aa extends com.baidu.adp.widget.ScrollView.o {
    public aa(Context context) {
        super(context);
    }

    public void bM(int i) {
        TextView hD = hD();
        TextView hC = hC();
        if (hD != null && hC != null && this.uj != null && this.uk != null) {
            if (i == 1) {
                int color = getContext().getResources().getColor(com.baidu.tieba.s.cp_cont_b_1);
                int color2 = getContext().getResources().getColor(com.baidu.tieba.s.cp_cont_c_1);
                this.uj.setBackgroundColor(getContext().getResources().getColor(com.baidu.tieba.s.cp_bg_line_c_1));
                hD.setTextColor(color);
                hC.setTextColor(color2);
                this.ut = new AnimationDrawable();
                Drawable drawable = getContext().getResources().getDrawable(com.baidu.tieba.u.listview_pull_refresh02_1);
                if (drawable != null) {
                    this.ut.addFrame(drawable, 100);
                }
                Drawable drawable2 = getContext().getResources().getDrawable(com.baidu.tieba.u.listview_pull_refresh01_1);
                if (drawable2 != null) {
                    this.ut.addFrame(drawable2, 100);
                }
                this.ut.setOneShot(false);
                this.uk.setBackgroundDrawable(this.ut);
                return;
            }
            int color3 = getContext().getResources().getColor(com.baidu.tieba.s.cp_cont_b);
            int color4 = getContext().getResources().getColor(com.baidu.tieba.s.cp_cont_c);
            this.uj.setBackgroundColor(getContext().getResources().getColor(com.baidu.tieba.s.cp_bg_line_c));
            hD.setTextColor(color3);
            hC.setTextColor(color4);
            this.ut = new AnimationDrawable();
            Drawable drawable3 = getContext().getResources().getDrawable(com.baidu.tieba.u.listview_pull_refresh02);
            if (drawable3 != null) {
                this.ut.addFrame(drawable3, 100);
            }
            Drawable drawable4 = getContext().getResources().getDrawable(com.baidu.tieba.u.listview_pull_refresh01);
            if (drawable4 != null) {
                this.ut.addFrame(drawable4, 100);
            }
            this.ut.setOneShot(false);
            this.uk.setBackgroundDrawable(this.ut);
        }
    }
}
