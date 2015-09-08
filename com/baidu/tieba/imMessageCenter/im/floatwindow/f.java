package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class f extends g {
    private HeadImageView aIT;
    private e bHU;
    private TextView bHV;

    public f() {
        super(LayoutInflater.from(TbadkCoreApplication.m411getInst()).inflate(i.g.im_float_head_view, (ViewGroup) null));
        this.bHU = new e();
        this.aIT = (HeadImageView) this.bIb.findViewById(i.f.im_float_head_view_head);
        this.bHV = (TextView) this.bIb.findViewById(i.f.im_float_head_view_text);
        this.aIT.setIsRound(true);
    }

    public void b(int i, int i2, String str, int i3) {
        an(i, i2);
        XP();
        this.aIT.d(str, 12, false);
        this.aIT.setUrl(str);
        hz(i3);
        this.aIT.requestFocusFromTouch();
    }

    public void O(String str, int i) {
        if (TextUtils.equals(str, this.aIT.getUrl())) {
            hz(i);
        }
    }

    private void hz(int i) {
        int i2;
        if (i <= 0) {
            this.bHV.setVisibility(8);
            return;
        }
        this.bHV.setVisibility(0);
        al.b(this.bHV, i.c.cp_cont_i, 1);
        if (i < 10) {
            this.bHV.setText(String.valueOf(i));
            i2 = i.e.icon_news_head_prompt_one;
        } else if (i < 100) {
            this.bHV.setText(String.valueOf(i));
            i2 = i.e.icon_news_head_prompt_two;
        } else {
            this.bHV.setText("   ");
            i2 = i.e.icon_news_head_prompt_more;
        }
        al.h((View) this.bHV, i2);
    }

    public e XM() {
        this.bHU.O(this.bIb);
        return this.bHU;
    }

    public void al(int i, int i2) {
        an(i, i2);
    }
}
