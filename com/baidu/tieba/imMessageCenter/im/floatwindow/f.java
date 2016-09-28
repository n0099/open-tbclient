package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class f extends g {
    private HeadImageView aVS;
    private e dqf;
    private TextView dqg;

    public f() {
        super(LayoutInflater.from(TbadkCoreApplication.m9getInst()).inflate(r.h.im_float_head_view, (ViewGroup) null));
        this.dqf = new e();
        this.aVS = (HeadImageView) this.dqm.findViewById(r.g.im_float_head_view_head);
        this.dqg = (TextView) this.dqm.findViewById(r.g.im_float_head_view_text);
        this.aVS.setIsRound(true);
    }

    public void b(int i, int i2, String str, int i3) {
        bb(i, i2);
        ayb();
        this.aVS.c(str, 12, false);
        this.aVS.setUrl(str);
        mg(i3);
        this.aVS.requestFocusFromTouch();
    }

    public void ao(String str, int i) {
        if (TextUtils.equals(str, this.aVS.getUrl())) {
            mg(i);
        }
    }

    private void mg(int i) {
        int i2;
        if (i <= 0) {
            this.dqg.setVisibility(8);
            return;
        }
        this.dqg.setVisibility(0);
        av.c(this.dqg, r.d.cp_cont_i, 1);
        if (i < 10) {
            this.dqg.setText(String.valueOf(i));
            i2 = r.f.icon_news_head_prompt_one;
        } else if (i < 100) {
            this.dqg.setText(String.valueOf(i));
            i2 = r.f.icon_news_head_prompt_two;
        } else {
            this.dqg.setText("   ");
            i2 = r.f.icon_news_head_prompt_more;
        }
        av.k(this.dqg, i2);
    }

    public e axY() {
        this.dqf.aJ(this.dqm);
        return this.dqf;
    }

    public void aZ(int i, int i2) {
        bb(i, i2);
    }
}
