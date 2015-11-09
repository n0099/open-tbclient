package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class f extends g {
    private HeadImageView aGQ;
    private e bLF;
    private TextView bLG;

    public f() {
        super(LayoutInflater.from(TbadkCoreApplication.m411getInst()).inflate(i.g.im_float_head_view, (ViewGroup) null));
        this.bLF = new e();
        this.aGQ = (HeadImageView) this.bLM.findViewById(i.f.im_float_head_view_head);
        this.bLG = (TextView) this.bLM.findViewById(i.f.im_float_head_view_text);
        this.aGQ.setIsRound(true);
    }

    public void b(int i, int i2, String str, int i3) {
        aq(i, i2);
        YO();
        this.aGQ.d(str, 12, false);
        this.aGQ.setUrl(str);
        hS(i3);
        this.aGQ.requestFocusFromTouch();
    }

    public void Q(String str, int i) {
        if (TextUtils.equals(str, this.aGQ.getUrl())) {
            hS(i);
        }
    }

    private void hS(int i) {
        int i2;
        if (i <= 0) {
            this.bLG.setVisibility(8);
            return;
        }
        this.bLG.setVisibility(0);
        an.b(this.bLG, i.c.cp_cont_i, 1);
        if (i < 10) {
            this.bLG.setText(String.valueOf(i));
            i2 = i.e.icon_news_head_prompt_one;
        } else if (i < 100) {
            this.bLG.setText(String.valueOf(i));
            i2 = i.e.icon_news_head_prompt_two;
        } else {
            this.bLG.setText("   ");
            i2 = i.e.icon_news_head_prompt_more;
        }
        an.i((View) this.bLG, i2);
    }

    public e YL() {
        this.bLF.P(this.bLM);
        return this.bLF;
    }

    public void ao(int i, int i2) {
        aq(i, i2);
    }
}
