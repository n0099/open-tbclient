package com.baidu.tieba.imMessageCenter.mention.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class f {
    private View eUA;
    private LinearLayout eUB;
    private ImageView eUC;
    private HeadImageView exm;
    private TextView exn;
    private MessageRedDotView exq;
    private int mIcon;
    private View mLine;

    public f(TbPageContext tbPageContext) {
        this.eUA = LayoutInflater.from(tbPageContext.getContext()).inflate(d.h.reply_and_at_item, (ViewGroup) null, false);
        this.eUB = (LinearLayout) this.eUA.findViewById(d.g.reply_and_at_item);
        this.eUC = (ImageView) this.eUA.findViewById(d.g.arrow_view);
        this.exm = (HeadImageView) this.eUA.findViewById(d.g.reply_and_at_head);
        this.exm.setIsRound(true);
        this.exm.setDrawBorder(false);
        this.mLine = this.eUA.findViewById(d.g.line);
        this.exq = (MessageRedDotView) this.eUA.findViewById(d.g.new_message);
        this.exn = (TextView) this.eUA.findViewById(d.g.desc_view);
    }

    public void as(String str, int i) {
        this.exn.setText(str);
        this.mIcon = i;
        aNR();
    }

    public void M(int i, boolean z) {
        if (i > 0) {
            if (z) {
                i = 0;
            }
            this.exq.refresh(i);
            this.exq.setVisibility(0);
            return;
        }
        this.exq.setVisibility(8);
    }

    public void aNR() {
        aj.e(this.exn, d.C0141d.cp_cont_b, 1);
        aj.s(this.eUA, d.f.addresslist_item_bg);
        aj.s(this.mLine, d.C0141d.cp_bg_line_c);
        aj.c(this.eUC, d.f.icon_arrow_gray_right_n);
        aj.c(this.exm, this.mIcon);
        if (this.exq != null) {
            this.exq.onChangeSkinType();
        }
    }

    public void qP(int i) {
        if (this.mLine != null) {
            this.mLine.setVisibility(i);
        }
    }

    public View getView() {
        return this.eUA;
    }
}
