package com.baidu.tieba.imMessageCenter.im.floatwindow;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class f extends g {
    private HeadImageView aLn;
    private e ceK;
    private TextView ceL;

    public f() {
        super(LayoutInflater.from(TbadkCoreApplication.m411getInst()).inflate(n.h.im_float_head_view, (ViewGroup) null));
        this.ceK = new e();
        this.aLn = (HeadImageView) this.ceR.findViewById(n.g.im_float_head_view_head);
        this.ceL = (TextView) this.ceR.findViewById(n.g.im_float_head_view_text);
        this.aLn.setIsRound(true);
    }

    public void b(int i, int i2, String str, int i3) {
        aE(i, i2);
        add();
        this.aLn.d(str, 12, false);
        this.aLn.setUrl(str);
        jf(i3);
        this.aLn.requestFocusFromTouch();
    }

    public void V(String str, int i) {
        if (TextUtils.equals(str, this.aLn.getUrl())) {
            jf(i);
        }
    }

    private void jf(int i) {
        int i2;
        if (i <= 0) {
            this.ceL.setVisibility(8);
            return;
        }
        this.ceL.setVisibility(0);
        as.b(this.ceL, n.d.cp_cont_i, 1);
        if (i < 10) {
            this.ceL.setText(String.valueOf(i));
            i2 = n.f.icon_news_head_prompt_one;
        } else if (i < 100) {
            this.ceL.setText(String.valueOf(i));
            i2 = n.f.icon_news_head_prompt_two;
        } else {
            this.ceL.setText("   ");
            i2 = n.f.icon_news_head_prompt_more;
        }
        as.i((View) this.ceL, i2);
    }

    public e ada() {
        this.ceK.ab(this.ceR);
        return this.ceK;
    }

    public void aC(int i, int i2) {
        aE(i, i2);
    }
}
