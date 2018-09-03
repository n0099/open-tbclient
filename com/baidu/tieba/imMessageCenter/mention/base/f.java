package com.baidu.tieba.imMessageCenter.mention.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tieba.f;
/* loaded from: classes2.dex */
public class f {
    private View eJi;
    private LinearLayout eJj;
    private ImageView eJk;
    private HeadImageView elP;
    private TextView elQ;
    private MessageRedDotView elT;
    private int mIcon;
    private View mLine;

    public f(TbPageContext tbPageContext) {
        this.eJi = LayoutInflater.from(tbPageContext.getContext()).inflate(f.h.reply_and_at_item, (ViewGroup) null, false);
        this.eJj = (LinearLayout) this.eJi.findViewById(f.g.reply_and_at_item);
        this.eJk = (ImageView) this.eJi.findViewById(f.g.arrow_view);
        this.elP = (HeadImageView) this.eJi.findViewById(f.g.reply_and_at_head);
        this.elP.setIsRound(true);
        this.elP.setDrawBorder(false);
        this.mLine = this.eJi.findViewById(f.g.line);
        this.elT = (MessageRedDotView) this.eJi.findViewById(f.g.new_message);
        this.elQ = (TextView) this.eJi.findViewById(f.g.desc_view);
    }

    public void as(String str, int i) {
        this.elQ.setText(str);
        this.mIcon = i;
        aPq();
    }

    public void x(int i, boolean z) {
        if (i > 0) {
            if (z) {
                i = 0;
            }
            this.elT.refresh(i);
            this.elT.setVisibility(0);
            return;
        }
        this.elT.setVisibility(8);
    }

    public void aPq() {
        am.c(this.elQ, f.d.cp_cont_b, 1);
        am.i(this.eJi, f.C0146f.addresslist_item_bg);
        am.i(this.mLine, f.d.cp_bg_line_c);
        am.c(this.eJk, f.C0146f.icon_arrow_gray_right_n);
        am.c(this.elP, this.mIcon);
        if (this.elT != null) {
            this.elT.onChangeSkinType();
        }
    }

    public void oR(int i) {
        if (this.mLine != null) {
            this.mLine.setVisibility(i);
        }
    }

    public View getView() {
        return this.eJi;
    }
}
