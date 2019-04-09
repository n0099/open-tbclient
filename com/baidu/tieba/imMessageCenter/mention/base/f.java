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
    private HeadImageView gcB;
    private TextView gcC;
    private MessageRedDotView gcF;
    private View gzG;
    private LinearLayout gzH;
    private ImageView gzI;
    private int mIcon;
    private View mLine;

    public f(TbPageContext tbPageContext) {
        this.gzG = LayoutInflater.from(tbPageContext.getContext()).inflate(d.h.reply_and_at_item, (ViewGroup) null, false);
        this.gzH = (LinearLayout) this.gzG.findViewById(d.g.reply_and_at_item);
        this.gzI = (ImageView) this.gzG.findViewById(d.g.arrow_view);
        this.gcB = (HeadImageView) this.gzG.findViewById(d.g.reply_and_at_head);
        this.gcB.setIsRound(true);
        this.gcB.setDrawBorder(false);
        this.mLine = this.gzG.findViewById(d.g.line);
        this.gcF = (MessageRedDotView) this.gzG.findViewById(d.g.new_message);
        this.gcC = (TextView) this.gzG.findViewById(d.g.desc_view);
    }

    public void aY(String str, int i) {
        this.gcC.setText(str);
        this.mIcon = i;
        bxS();
    }

    public void E(int i, boolean z) {
        if (i > 0) {
            if (z) {
                i = 0;
            }
            this.gcF.refresh(i);
            this.gcF.setVisibility(0);
            return;
        }
        this.gcF.setVisibility(8);
    }

    public void bxS() {
        al.d(this.gcC, d.C0277d.cp_cont_b, 1);
        al.k(this.gzG, d.f.addresslist_item_bg);
        al.k(this.mLine, d.C0277d.cp_bg_line_c);
        al.c(this.gzI, d.f.icon_arrow_gray_right_n);
        al.c(this.gcB, this.mIcon);
        if (this.gcF != null) {
            this.gcF.onChangeSkinType();
        }
    }

    public void uy(int i) {
        if (this.mLine != null) {
            this.mLine.setVisibility(i);
        }
    }

    public View getView() {
        return this.gzG;
    }
}
