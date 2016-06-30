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
    private HeadImageView aOV;
    private e dab;
    private TextView dac;

    public f() {
        super(LayoutInflater.from(TbadkCoreApplication.m9getInst()).inflate(u.h.im_float_head_view, (ViewGroup) null));
        this.dab = new e();
        this.aOV = (HeadImageView) this.dai.findViewById(u.g.im_float_head_view_head);
        this.dac = (TextView) this.dai.findViewById(u.g.im_float_head_view_text);
        this.aOV.setIsRound(true);
    }

    public void b(int i, int i2, String str, int i3) {
        aS(i, i2);
        asc();
        this.aOV.c(str, 12, false);
        this.aOV.setUrl(str);
        lp(i3);
        this.aOV.requestFocusFromTouch();
    }

    public void ao(String str, int i) {
        if (TextUtils.equals(str, this.aOV.getUrl())) {
            lp(i);
        }
    }

    private void lp(int i) {
        int i2;
        if (i <= 0) {
            this.dac.setVisibility(8);
            return;
        }
        this.dac.setVisibility(0);
        av.c(this.dac, u.d.cp_cont_i, 1);
        if (i < 10) {
            this.dac.setText(String.valueOf(i));
            i2 = u.f.icon_news_head_prompt_one;
        } else if (i < 100) {
            this.dac.setText(String.valueOf(i));
            i2 = u.f.icon_news_head_prompt_two;
        } else {
            this.dac.setText("   ");
            i2 = u.f.icon_news_head_prompt_more;
        }
        av.k(this.dac, i2);
    }

    public e arZ() {
        this.dab.aM(this.dai);
        return this.dab;
    }

    public void aQ(int i, int i2) {
        aS(i, i2);
    }
}
