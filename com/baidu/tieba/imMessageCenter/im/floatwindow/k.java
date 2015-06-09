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
    private HeadImageView aBl;
    private j btw;
    private TextView btx;

    public k() {
        super(com.baidu.adp.lib.g.b.hr().inflate(TbadkCoreApplication.m411getInst(), r.im_float_head_view, null));
        this.btw = new j();
        this.aBl = (HeadImageView) this.btD.findViewById(q.im_float_head_view_head);
        this.btx = (TextView) this.btD.findViewById(q.im_float_head_view_text);
        this.aBl.setIsRound(true);
    }

    public void b(int i, int i2, String str, int i3) {
        aa(i, i2);
        Wg();
        this.aBl.c(str, 12, false);
        this.aBl.setUrl(str);
        gL(i3);
        this.aBl.requestFocusFromTouch();
    }

    public void K(String str, int i) {
        if (TextUtils.equals(str, this.aBl.getUrl())) {
            gL(i);
        }
    }

    private void gL(int i) {
        int i2;
        if (i <= 0) {
            this.btx.setVisibility(8);
            return;
        }
        this.btx.setVisibility(0);
        ay.b(this.btx, com.baidu.tieba.n.cp_cont_i, 1);
        if (i < 10) {
            this.btx.setText(String.valueOf(i));
            i2 = p.icon_news_head_prompt_one;
        } else if (i < 100) {
            this.btx.setText(String.valueOf(i));
            i2 = p.icon_news_head_prompt_two;
        } else {
            this.btx.setText("   ");
            i2 = p.icon_news_head_prompt_more;
        }
        ay.i((View) this.btx, i2);
    }

    public j Wd() {
        this.btw.J(this.btD);
        return this.btw;
    }

    public void Y(int i, int i2) {
        aa(i, i2);
    }
}
