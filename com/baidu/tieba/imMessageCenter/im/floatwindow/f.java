package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class f extends g {
    private HeadImageView aVj;
    private e doH;
    private TextView doI;

    public f() {
        super(LayoutInflater.from(TbadkCoreApplication.m9getInst()).inflate(t.h.im_float_head_view, (ViewGroup) null));
        this.doH = new e();
        this.aVj = (HeadImageView) this.doO.findViewById(t.g.im_float_head_view_head);
        this.doI = (TextView) this.doO.findViewById(t.g.im_float_head_view_text);
        this.aVj.setIsRound(true);
    }

    public void b(int i, int i2, String str, int i3) {
        aZ(i, i2);
        axC();
        this.aVj.c(str, 12, false);
        this.aVj.setUrl(str);
        lY(i3);
        this.aVj.requestFocusFromTouch();
    }

    public void ao(String str, int i) {
        if (TextUtils.equals(str, this.aVj.getUrl())) {
            lY(i);
        }
    }

    private void lY(int i) {
        int i2;
        if (i <= 0) {
            this.doI.setVisibility(8);
            return;
        }
        this.doI.setVisibility(0);
        av.c(this.doI, t.d.cp_cont_i, 1);
        if (i < 10) {
            this.doI.setText(String.valueOf(i));
            i2 = t.f.icon_news_head_prompt_one;
        } else if (i < 100) {
            this.doI.setText(String.valueOf(i));
            i2 = t.f.icon_news_head_prompt_two;
        } else {
            this.doI.setText("   ");
            i2 = t.f.icon_news_head_prompt_more;
        }
        av.k(this.doI, i2);
    }

    public e axz() {
        this.doH.aK(this.doO);
        return this.doH;
    }

    public void aX(int i, int i2) {
        aZ(i, i2);
    }
}
