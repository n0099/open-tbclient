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
    private HeadImageView eMM;
    private TextView eMN;
    private MessageRedDotView eMQ;
    private View fjW;
    private LinearLayout fjX;
    private ImageView fjY;
    private int mIcon;
    private View mLine;

    public f(TbPageContext tbPageContext) {
        this.fjW = LayoutInflater.from(tbPageContext.getContext()).inflate(e.h.reply_and_at_item, (ViewGroup) null, false);
        this.fjX = (LinearLayout) this.fjW.findViewById(e.g.reply_and_at_item);
        this.fjY = (ImageView) this.fjW.findViewById(e.g.arrow_view);
        this.eMM = (HeadImageView) this.fjW.findViewById(e.g.reply_and_at_head);
        this.eMM.setIsRound(true);
        this.eMM.setDrawBorder(false);
        this.mLine = this.fjW.findViewById(e.g.line);
        this.eMQ = (MessageRedDotView) this.fjW.findViewById(e.g.new_message);
        this.eMN = (TextView) this.fjW.findViewById(e.g.desc_view);
    }

    public void aD(String str, int i) {
        this.eMN.setText(str);
        this.mIcon = i;
        aXt();
    }

    public void y(int i, boolean z) {
        if (i > 0) {
            if (z) {
                i = 0;
            }
            this.eMQ.refresh(i);
            this.eMQ.setVisibility(0);
            return;
        }
        this.eMQ.setVisibility(8);
    }

    public void aXt() {
        al.c(this.eMN, e.d.cp_cont_b, 1);
        al.i(this.fjW, e.f.addresslist_item_bg);
        al.i(this.mLine, e.d.cp_bg_line_c);
        al.c(this.fjY, e.f.icon_arrow_gray_right_n);
        al.c(this.eMM, this.mIcon);
        if (this.eMQ != null) {
            this.eMQ.onChangeSkinType();
        }
    }

    public void qU(int i) {
        if (this.mLine != null) {
            this.mLine.setVisibility(i);
        }
    }

    public View getView() {
        return this.fjW;
    }
}
