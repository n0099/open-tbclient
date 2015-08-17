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
    private HeadImageView aIG;
    private e bHn;
    private TextView bHo;

    public f() {
        super(LayoutInflater.from(TbadkCoreApplication.m411getInst()).inflate(i.g.im_float_head_view, (ViewGroup) null));
        this.bHn = new e();
        this.aIG = (HeadImageView) this.bHu.findViewById(i.f.im_float_head_view_head);
        this.bHo = (TextView) this.bHu.findViewById(i.f.im_float_head_view_text);
        this.aIG.setIsRound(true);
    }

    public void b(int i, int i2, String str, int i3) {
        an(i, i2);
        XN();
        this.aIG.d(str, 12, false);
        this.aIG.setUrl(str);
        hp(i3);
        this.aIG.requestFocusFromTouch();
    }

    public void N(String str, int i) {
        if (TextUtils.equals(str, this.aIG.getUrl())) {
            hp(i);
        }
    }

    private void hp(int i) {
        int i2;
        if (i <= 0) {
            this.bHo.setVisibility(8);
            return;
        }
        this.bHo.setVisibility(0);
        al.b(this.bHo, i.c.cp_cont_i, 1);
        if (i < 10) {
            this.bHo.setText(String.valueOf(i));
            i2 = i.e.icon_news_head_prompt_one;
        } else if (i < 100) {
            this.bHo.setText(String.valueOf(i));
            i2 = i.e.icon_news_head_prompt_two;
        } else {
            this.bHo.setText("   ");
            i2 = i.e.icon_news_head_prompt_more;
        }
        al.i((View) this.bHo, i2);
    }

    public e XK() {
        this.bHn.O(this.bHu);
        return this.bHn;
    }

    public void al(int i, int i2) {
        an(i, i2);
    }
}
