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
    private ImageView eUA;
    private View eUy;
    private LinearLayout eUz;
    private HeadImageView exi;
    private TextView exj;
    private MessageRedDotView exm;
    private int mIcon;
    private View mLine;

    public f(TbPageContext tbPageContext) {
        this.eUy = LayoutInflater.from(tbPageContext.getContext()).inflate(d.h.reply_and_at_item, (ViewGroup) null, false);
        this.eUz = (LinearLayout) this.eUy.findViewById(d.g.reply_and_at_item);
        this.eUA = (ImageView) this.eUy.findViewById(d.g.arrow_view);
        this.exi = (HeadImageView) this.eUy.findViewById(d.g.reply_and_at_head);
        this.exi.setIsRound(true);
        this.exi.setDrawBorder(false);
        this.mLine = this.eUy.findViewById(d.g.line);
        this.exm = (MessageRedDotView) this.eUy.findViewById(d.g.new_message);
        this.exj = (TextView) this.eUy.findViewById(d.g.desc_view);
    }

    public void as(String str, int i) {
        this.exj.setText(str);
        this.mIcon = i;
        aNR();
    }

    public void M(int i, boolean z) {
        if (i > 0) {
            if (z) {
                i = 0;
            }
            this.exm.refresh(i);
            this.exm.setVisibility(0);
            return;
        }
        this.exm.setVisibility(8);
    }

    public void aNR() {
        aj.e(this.exj, d.C0140d.cp_cont_b, 1);
        aj.s(this.eUy, d.f.addresslist_item_bg);
        aj.s(this.mLine, d.C0140d.cp_bg_line_c);
        aj.c(this.eUA, d.f.icon_arrow_gray_right_n);
        aj.c(this.exi, this.mIcon);
        if (this.exm != null) {
            this.exm.onChangeSkinType();
        }
    }

    public void qO(int i) {
        if (this.mLine != null) {
            this.mLine.setVisibility(i);
        }
    }

    public View getView() {
        return this.eUy;
    }
}
