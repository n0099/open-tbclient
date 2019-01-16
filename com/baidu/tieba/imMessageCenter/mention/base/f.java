package com.baidu.tieba.imMessageCenter.mention.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tieba.e;
/* loaded from: classes4.dex */
public class f {
    private HeadImageView eML;
    private TextView eMM;
    private MessageRedDotView eMP;
    private View fjV;
    private LinearLayout fjW;
    private ImageView fjX;
    private int mIcon;
    private View mLine;

    public f(TbPageContext tbPageContext) {
        this.fjV = LayoutInflater.from(tbPageContext.getContext()).inflate(e.h.reply_and_at_item, (ViewGroup) null, false);
        this.fjW = (LinearLayout) this.fjV.findViewById(e.g.reply_and_at_item);
        this.fjX = (ImageView) this.fjV.findViewById(e.g.arrow_view);
        this.eML = (HeadImageView) this.fjV.findViewById(e.g.reply_and_at_head);
        this.eML.setIsRound(true);
        this.eML.setDrawBorder(false);
        this.mLine = this.fjV.findViewById(e.g.line);
        this.eMP = (MessageRedDotView) this.fjV.findViewById(e.g.new_message);
        this.eMM = (TextView) this.fjV.findViewById(e.g.desc_view);
    }

    public void aD(String str, int i) {
        this.eMM.setText(str);
        this.mIcon = i;
        aXt();
    }

    public void y(int i, boolean z) {
        if (i > 0) {
            if (z) {
                i = 0;
            }
            this.eMP.refresh(i);
            this.eMP.setVisibility(0);
            return;
        }
        this.eMP.setVisibility(8);
    }

    public void aXt() {
        al.c(this.eMM, e.d.cp_cont_b, 1);
        al.i(this.fjV, e.f.addresslist_item_bg);
        al.i(this.mLine, e.d.cp_bg_line_c);
        al.c(this.fjX, e.f.icon_arrow_gray_right_n);
        al.c(this.eML, this.mIcon);
        if (this.eMP != null) {
            this.eMP.onChangeSkinType();
        }
    }

    public void qU(int i) {
        if (this.mLine != null) {
            this.mLine.setVisibility(i);
        }
    }

    public View getView() {
        return this.fjV;
    }
}
