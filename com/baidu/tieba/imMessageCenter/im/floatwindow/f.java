package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class f extends g {
    private HeadImageView aYe;
    private e dvM;
    private TextView dvN;

    public f() {
        super(LayoutInflater.from(TbadkCoreApplication.m9getInst()).inflate(r.h.im_float_head_view, (ViewGroup) null));
        this.dvM = new e();
        this.aYe = (HeadImageView) this.dvT.findViewById(r.g.im_float_head_view_head);
        this.dvN = (TextView) this.dvT.findViewById(r.g.im_float_head_view_text);
        this.aYe.setIsRound(true);
    }

    public void b(int i, int i2, String str, int i3) {
        bc(i, i2);
        azY();
        this.aYe.c(str, 12, false);
        this.aYe.setUrl(str);
        mo(i3);
        this.aYe.requestFocusFromTouch();
    }

    public void ao(String str, int i) {
        if (TextUtils.equals(str, this.aYe.getUrl())) {
            mo(i);
        }
    }

    private void mo(int i) {
        int i2;
        if (i <= 0) {
            this.dvN.setVisibility(8);
            return;
        }
        this.dvN.setVisibility(0);
        at.c(this.dvN, r.d.cp_cont_i, 1);
        if (i < 10) {
            this.dvN.setText(String.valueOf(i));
            i2 = r.f.icon_news_head_prompt_one;
        } else if (i < 100) {
            this.dvN.setText(String.valueOf(i));
            i2 = r.f.icon_news_head_prompt_two;
        } else {
            this.dvN.setText("   ");
            i2 = r.f.icon_news_head_prompt_more;
        }
        at.k(this.dvN, i2);
    }

    public e azV() {
        this.dvM.aI(this.dvT);
        return this.dvM;
    }

    public void ba(int i, int i2) {
        bc(i, i2);
    }
}
