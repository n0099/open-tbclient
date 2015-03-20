package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.s;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class k extends l {
    private HeadImageView azr;
    private j bqv;
    private TextView bqw;

    public k() {
        super(com.baidu.adp.lib.g.b.hH().inflate(TbadkCoreApplication.m411getInst(), w.im_float_head_view, null));
        this.bqv = new j();
        this.azr = (HeadImageView) this.bqC.findViewById(v.im_float_head_view_head);
        this.bqw = (TextView) this.bqC.findViewById(v.im_float_head_view_text);
        this.azr.setIsRound(true);
    }

    public void b(int i, int i2, String str, int i3) {
        Y(i, i2);
        UB();
        this.azr.c(str, 12, false);
        this.azr.setUrl(str);
        gs(i3);
        this.azr.requestFocusFromTouch();
    }

    public void K(String str, int i) {
        if (TextUtils.equals(str, this.azr.getUrl())) {
            gs(i);
        }
    }

    private void gs(int i) {
        int i2;
        if (i <= 0) {
            this.bqw.setVisibility(8);
            return;
        }
        this.bqw.setVisibility(0);
        ba.b(this.bqw, s.cp_cont_i, 1);
        if (i < 10) {
            this.bqw.setText(String.valueOf(i));
            i2 = u.icon_news_head_prompt_one;
        } else if (i < 100) {
            this.bqw.setText(String.valueOf(i));
            i2 = u.icon_news_head_prompt_two;
        } else {
            this.bqw.setText("   ");
            i2 = u.icon_news_head_prompt_more;
        }
        ba.i((View) this.bqw, i2);
    }

    public j Uy() {
        this.bqv.G(this.bqC);
        return this.bqv;
    }

    public void W(int i, int i2) {
        Y(i, i2);
    }
}
