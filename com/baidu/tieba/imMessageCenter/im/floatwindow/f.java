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
    private HeadImageView aPn;
    private e ctO;
    private TextView ctP;

    public f() {
        super(LayoutInflater.from(TbadkCoreApplication.m411getInst()).inflate(t.h.im_float_head_view, (ViewGroup) null));
        this.ctO = new e();
        this.aPn = (HeadImageView) this.ctV.findViewById(t.g.im_float_head_view_head);
        this.ctP = (TextView) this.ctV.findViewById(t.g.im_float_head_view_text);
        this.aPn.setIsRound(true);
    }

    public void b(int i, int i2, String str, int i3) {
        aC(i, i2);
        ajG();
        this.aPn.c(str, 12, false);
        this.aPn.setUrl(str);
        kj(i3);
        this.aPn.requestFocusFromTouch();
    }

    public void ad(String str, int i) {
        if (TextUtils.equals(str, this.aPn.getUrl())) {
            kj(i);
        }
    }

    private void kj(int i) {
        int i2;
        if (i <= 0) {
            this.ctP.setVisibility(8);
            return;
        }
        this.ctP.setVisibility(0);
        at.b(this.ctP, t.d.cp_cont_i, 1);
        if (i < 10) {
            this.ctP.setText(String.valueOf(i));
            i2 = t.f.icon_news_head_prompt_one;
        } else if (i < 100) {
            this.ctP.setText(String.valueOf(i));
            i2 = t.f.icon_news_head_prompt_two;
        } else {
            this.ctP.setText("   ");
            i2 = t.f.icon_news_head_prompt_more;
        }
        at.k(this.ctP, i2);
    }

    public e ajD() {
        this.ctO.aA(this.ctV);
        return this.ctO;
    }

    public void aA(int i, int i2) {
        aC(i, i2);
    }
}
