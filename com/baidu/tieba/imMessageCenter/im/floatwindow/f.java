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
    private HeadImageView aHW;
    private e bLk;
    private TextView bLl;

    public f() {
        super(LayoutInflater.from(TbadkCoreApplication.m411getInst()).inflate(i.g.im_float_head_view, (ViewGroup) null));
        this.bLk = new e();
        this.aHW = (HeadImageView) this.bLr.findViewById(i.f.im_float_head_view_head);
        this.bLl = (TextView) this.bLr.findViewById(i.f.im_float_head_view_text);
        this.aHW.setIsRound(true);
    }

    public void b(int i, int i2, String str, int i3) {
        ao(i, i2);
        Yx();
        this.aHW.d(str, 12, false);
        this.aHW.setUrl(str);
        hF(i3);
        this.aHW.requestFocusFromTouch();
    }

    public void Q(String str, int i) {
        if (TextUtils.equals(str, this.aHW.getUrl())) {
            hF(i);
        }
    }

    private void hF(int i) {
        int i2;
        if (i <= 0) {
            this.bLl.setVisibility(8);
            return;
        }
        this.bLl.setVisibility(0);
        an.b(this.bLl, i.c.cp_cont_i, 1);
        if (i < 10) {
            this.bLl.setText(String.valueOf(i));
            i2 = i.e.icon_news_head_prompt_one;
        } else if (i < 100) {
            this.bLl.setText(String.valueOf(i));
            i2 = i.e.icon_news_head_prompt_two;
        } else {
            this.bLl.setText("   ");
            i2 = i.e.icon_news_head_prompt_more;
        }
        an.i((View) this.bLl, i2);
    }

    public e Yu() {
        this.bLk.Q(this.bLr);
        return this.bLk;
    }

    public void am(int i, int i2) {
        ao(i, i2);
    }
}
