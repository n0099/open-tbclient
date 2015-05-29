package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.p;
import com.baidu.tieba.q;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class k extends l {
    private HeadImageView aBk;
    private j btv;
    private TextView btw;

    public k() {
        super(com.baidu.adp.lib.g.b.hr().inflate(TbadkCoreApplication.m411getInst(), r.im_float_head_view, null));
        this.btv = new j();
        this.aBk = (HeadImageView) this.btC.findViewById(q.im_float_head_view_head);
        this.btw = (TextView) this.btC.findViewById(q.im_float_head_view_text);
        this.aBk.setIsRound(true);
    }

    public void b(int i, int i2, String str, int i3) {
        aa(i, i2);
        Wf();
        this.aBk.c(str, 12, false);
        this.aBk.setUrl(str);
        gL(i3);
        this.aBk.requestFocusFromTouch();
    }

    public void K(String str, int i) {
        if (TextUtils.equals(str, this.aBk.getUrl())) {
            gL(i);
        }
    }

    private void gL(int i) {
        int i2;
        if (i <= 0) {
            this.btw.setVisibility(8);
            return;
        }
        this.btw.setVisibility(0);
        ay.b(this.btw, com.baidu.tieba.n.cp_cont_i, 1);
        if (i < 10) {
            this.btw.setText(String.valueOf(i));
            i2 = p.icon_news_head_prompt_one;
        } else if (i < 100) {
            this.btw.setText(String.valueOf(i));
            i2 = p.icon_news_head_prompt_two;
        } else {
            this.btw.setText("   ");
            i2 = p.icon_news_head_prompt_more;
        }
        ay.i((View) this.btw, i2);
    }

    public j Wc() {
        this.btv.J(this.btC);
        return this.btv;
    }

    public void Y(int i, int i2) {
        aa(i, i2);
    }
}
