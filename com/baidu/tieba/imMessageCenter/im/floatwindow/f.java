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
    private HeadImageView aJP;
    private e caJ;
    private TextView caK;

    public f() {
        super(LayoutInflater.from(TbadkCoreApplication.m411getInst()).inflate(n.g.im_float_head_view, (ViewGroup) null));
        this.caJ = new e();
        this.aJP = (HeadImageView) this.caQ.findViewById(n.f.im_float_head_view_head);
        this.caK = (TextView) this.caQ.findViewById(n.f.im_float_head_view_text);
        this.aJP.setIsRound(true);
    }

    public void b(int i, int i2, String str, int i3) {
        as(i, i2);
        abU();
        this.aJP.d(str, 12, false);
        this.aJP.setUrl(str);
        iG(i3);
        this.aJP.requestFocusFromTouch();
    }

    public void V(String str, int i) {
        if (TextUtils.equals(str, this.aJP.getUrl())) {
            iG(i);
        }
    }

    private void iG(int i) {
        int i2;
        if (i <= 0) {
            this.caK.setVisibility(8);
            return;
        }
        this.caK.setVisibility(0);
        as.b(this.caK, n.c.cp_cont_i, 1);
        if (i < 10) {
            this.caK.setText(String.valueOf(i));
            i2 = n.e.icon_news_head_prompt_one;
        } else if (i < 100) {
            this.caK.setText(String.valueOf(i));
            i2 = n.e.icon_news_head_prompt_two;
        } else {
            this.caK.setText("   ");
            i2 = n.e.icon_news_head_prompt_more;
        }
        as.i((View) this.caK, i2);
    }

    public e abR() {
        this.caJ.W(this.caQ);
        return this.caJ;
    }

    public void aq(int i, int i2) {
        as(i, i2);
    }
}
