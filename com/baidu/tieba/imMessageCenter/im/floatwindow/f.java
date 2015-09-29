package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class f extends g {
    private HeadImageView aHL;
    private e bKZ;
    private TextView bLa;

    public f() {
        super(LayoutInflater.from(TbadkCoreApplication.m411getInst()).inflate(i.g.im_float_head_view, (ViewGroup) null));
        this.bKZ = new e();
        this.aHL = (HeadImageView) this.bLg.findViewById(i.f.im_float_head_view_head);
        this.bLa = (TextView) this.bLg.findViewById(i.f.im_float_head_view_text);
        this.aHL.setIsRound(true);
    }

    public void b(int i, int i2, String str, int i3) {
        ao(i, i2);
        Yx();
        this.aHL.d(str, 12, false);
        this.aHL.setUrl(str);
        hF(i3);
        this.aHL.requestFocusFromTouch();
    }

    public void Q(String str, int i) {
        if (TextUtils.equals(str, this.aHL.getUrl())) {
            hF(i);
        }
    }

    private void hF(int i) {
        int i2;
        if (i <= 0) {
            this.bLa.setVisibility(8);
            return;
        }
        this.bLa.setVisibility(0);
        am.b(this.bLa, i.c.cp_cont_i, 1);
        if (i < 10) {
            this.bLa.setText(String.valueOf(i));
            i2 = i.e.icon_news_head_prompt_one;
        } else if (i < 100) {
            this.bLa.setText(String.valueOf(i));
            i2 = i.e.icon_news_head_prompt_two;
        } else {
            this.bLa.setText("   ");
            i2 = i.e.icon_news_head_prompt_more;
        }
        am.i((View) this.bLa, i2);
    }

    public e Yu() {
        this.bKZ.Q(this.bLg);
        return this.bKZ;
    }

    public void am(int i, int i2) {
        ao(i, i2);
    }
}
