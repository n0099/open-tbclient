package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class f extends g {
    private HeadImageView aPP;
    private e dcZ;
    private TextView dda;

    public f() {
        super(LayoutInflater.from(TbadkCoreApplication.m10getInst()).inflate(u.h.im_float_head_view, (ViewGroup) null));
        this.dcZ = new e();
        this.aPP = (HeadImageView) this.ddg.findViewById(u.g.im_float_head_view_head);
        this.dda = (TextView) this.ddg.findViewById(u.g.im_float_head_view_text);
        this.aPP.setIsRound(true);
    }

    public void b(int i, int i2, String str, int i3) {
        aV(i, i2);
        asO();
        this.aPP.c(str, 12, false);
        this.aPP.setUrl(str);
        lv(i3);
        this.aPP.requestFocusFromTouch();
    }

    public void ao(String str, int i) {
        if (TextUtils.equals(str, this.aPP.getUrl())) {
            lv(i);
        }
    }

    private void lv(int i) {
        int i2;
        if (i <= 0) {
            this.dda.setVisibility(8);
            return;
        }
        this.dda.setVisibility(0);
        av.c(this.dda, u.d.cp_cont_i, 1);
        if (i < 10) {
            this.dda.setText(String.valueOf(i));
            i2 = u.f.icon_news_head_prompt_one;
        } else if (i < 100) {
            this.dda.setText(String.valueOf(i));
            i2 = u.f.icon_news_head_prompt_two;
        } else {
            this.dda.setText("   ");
            i2 = u.f.icon_news_head_prompt_more;
        }
        av.k(this.dda, i2);
    }

    public e asL() {
        this.dcZ.aK(this.ddg);
        return this.dcZ;
    }

    public void aT(int i, int i2) {
        aV(i, i2);
    }
}
