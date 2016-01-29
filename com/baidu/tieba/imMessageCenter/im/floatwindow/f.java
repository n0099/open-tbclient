package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class f extends g {
    private HeadImageView aMs;
    private e cjj;
    private TextView cjk;

    public f() {
        super(LayoutInflater.from(TbadkCoreApplication.m411getInst()).inflate(t.h.im_float_head_view, (ViewGroup) null));
        this.cjj = new e();
        this.aMs = (HeadImageView) this.cjq.findViewById(t.g.im_float_head_view_head);
        this.cjk = (TextView) this.cjq.findViewById(t.g.im_float_head_view_text);
        this.aMs.setIsRound(true);
    }

    public void b(int i, int i2, String str, int i3) {
        aF(i, i2);
        agm();
        this.aMs.d(str, 12, false);
        this.aMs.setUrl(str);
        jD(i3);
        this.aMs.requestFocusFromTouch();
    }

    public void W(String str, int i) {
        if (TextUtils.equals(str, this.aMs.getUrl())) {
            jD(i);
        }
    }

    private void jD(int i) {
        int i2;
        if (i <= 0) {
            this.cjk.setVisibility(8);
            return;
        }
        this.cjk.setVisibility(0);
        ar.b(this.cjk, t.d.cp_cont_i, 1);
        if (i < 10) {
            this.cjk.setText(String.valueOf(i));
            i2 = t.f.icon_news_head_prompt_one;
        } else if (i < 100) {
            this.cjk.setText(String.valueOf(i));
            i2 = t.f.icon_news_head_prompt_two;
        } else {
            this.cjk.setText("   ");
            i2 = t.f.icon_news_head_prompt_more;
        }
        ar.k(this.cjk, i2);
    }

    public e agj() {
        this.cjj.ap(this.cjq);
        return this.cjj;
    }

    public void aD(int i, int i2) {
        aF(i, i2);
    }
}
