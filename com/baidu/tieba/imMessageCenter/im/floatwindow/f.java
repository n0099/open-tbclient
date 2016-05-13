package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class f extends g {
    private HeadImageView aLx;
    private e cuM;
    private TextView cuN;

    public f() {
        super(LayoutInflater.from(TbadkCoreApplication.m11getInst()).inflate(t.h.im_float_head_view, (ViewGroup) null));
        this.cuM = new e();
        this.aLx = (HeadImageView) this.cuT.findViewById(t.g.im_float_head_view_head);
        this.cuN = (TextView) this.cuT.findViewById(t.g.im_float_head_view_text);
        this.aLx.setIsRound(true);
    }

    public void b(int i, int i2, String str, int i3) {
        aB(i, i2);
        ajO();
        this.aLx.c(str, 12, false);
        this.aLx.setUrl(str);
        jN(i3);
        this.aLx.requestFocusFromTouch();
    }

    public void ah(String str, int i) {
        if (TextUtils.equals(str, this.aLx.getUrl())) {
            jN(i);
        }
    }

    private void jN(int i) {
        int i2;
        if (i <= 0) {
            this.cuN.setVisibility(8);
            return;
        }
        this.cuN.setVisibility(0);
        at.c(this.cuN, t.d.cp_cont_i, 1);
        if (i < 10) {
            this.cuN.setText(String.valueOf(i));
            i2 = t.f.icon_news_head_prompt_one;
        } else if (i < 100) {
            this.cuN.setText(String.valueOf(i));
            i2 = t.f.icon_news_head_prompt_two;
        } else {
            this.cuN.setText("   ");
            i2 = t.f.icon_news_head_prompt_more;
        }
        at.k(this.cuN, i2);
    }

    public e ajL() {
        this.cuM.aE(this.cuT);
        return this.cuM;
    }

    public void az(int i, int i2) {
        aB(i, i2);
    }
}
