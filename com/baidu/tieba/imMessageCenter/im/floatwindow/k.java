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
    private HeadImageView azz;
    private j bqL;
    private TextView bqM;

    public k() {
        super(com.baidu.adp.lib.g.b.hH().inflate(TbadkCoreApplication.m411getInst(), w.im_float_head_view, null));
        this.bqL = new j();
        this.azz = (HeadImageView) this.bqS.findViewById(v.im_float_head_view_head);
        this.bqM = (TextView) this.bqS.findViewById(v.im_float_head_view_text);
        this.azz.setIsRound(true);
    }

    public void b(int i, int i2, String str, int i3) {
        Y(i, i2);
        UO();
        this.azz.c(str, 12, false);
        this.azz.setUrl(str);
        gu(i3);
        this.azz.requestFocusFromTouch();
    }

    public void K(String str, int i) {
        if (TextUtils.equals(str, this.azz.getUrl())) {
            gu(i);
        }
    }

    private void gu(int i) {
        int i2;
        if (i <= 0) {
            this.bqM.setVisibility(8);
            return;
        }
        this.bqM.setVisibility(0);
        ba.b(this.bqM, s.cp_cont_i, 1);
        if (i < 10) {
            this.bqM.setText(String.valueOf(i));
            i2 = u.icon_news_head_prompt_one;
        } else if (i < 100) {
            this.bqM.setText(String.valueOf(i));
            i2 = u.icon_news_head_prompt_two;
        } else {
            this.bqM.setText("   ");
            i2 = u.icon_news_head_prompt_more;
        }
        ba.i((View) this.bqM, i2);
    }

    public j UL() {
        this.bqL.G(this.bqS);
        return this.bqL;
    }

    public void W(int i, int i2) {
        Y(i, i2);
    }
}
