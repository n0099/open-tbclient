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
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class f {
    private HeadImageView gcN;
    private TextView gcO;
    private MessageRedDotView gcR;
    private View gzS;
    private LinearLayout gzT;
    private ImageView gzU;
    private int mIcon;
    private View mLine;

    public f(TbPageContext tbPageContext) {
        this.gzS = LayoutInflater.from(tbPageContext.getContext()).inflate(d.h.reply_and_at_item, (ViewGroup) null, false);
        this.gzT = (LinearLayout) this.gzS.findViewById(d.g.reply_and_at_item);
        this.gzU = (ImageView) this.gzS.findViewById(d.g.arrow_view);
        this.gcN = (HeadImageView) this.gzS.findViewById(d.g.reply_and_at_head);
        this.gcN.setIsRound(true);
        this.gcN.setDrawBorder(false);
        this.mLine = this.gzS.findViewById(d.g.line);
        this.gcR = (MessageRedDotView) this.gzS.findViewById(d.g.new_message);
        this.gcO = (TextView) this.gzS.findViewById(d.g.desc_view);
    }

    public void aY(String str, int i) {
        this.gcO.setText(str);
        this.mIcon = i;
        bxV();
    }

    public void E(int i, boolean z) {
        if (i > 0) {
            if (z) {
                i = 0;
            }
            this.gcR.refresh(i);
            this.gcR.setVisibility(0);
            return;
        }
        this.gcR.setVisibility(8);
    }

    public void bxV() {
        al.d(this.gcO, d.C0236d.cp_cont_b, 1);
        al.k(this.gzS, d.f.addresslist_item_bg);
        al.k(this.mLine, d.C0236d.cp_bg_line_c);
        al.c(this.gzU, d.f.icon_arrow_gray_right_n);
        al.c(this.gcN, this.mIcon);
        if (this.gcR != null) {
            this.gcR.onChangeSkinType();
        }
    }

    public void uC(int i) {
        if (this.mLine != null) {
            this.mLine.setVisibility(i);
        }
    }

    public View getView() {
        return this.gzS;
    }
}
