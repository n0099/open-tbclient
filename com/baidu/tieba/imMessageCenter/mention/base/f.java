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
    private HeadImageView eJi;
    private TextView eJj;
    private MessageRedDotView eJm;
    private View fgn;
    private LinearLayout fgo;
    private ImageView fgp;
    private int mIcon;
    private View mLine;

    public f(TbPageContext tbPageContext) {
        this.fgn = LayoutInflater.from(tbPageContext.getContext()).inflate(e.h.reply_and_at_item, (ViewGroup) null, false);
        this.fgo = (LinearLayout) this.fgn.findViewById(e.g.reply_and_at_item);
        this.fgp = (ImageView) this.fgn.findViewById(e.g.arrow_view);
        this.eJi = (HeadImageView) this.fgn.findViewById(e.g.reply_and_at_head);
        this.eJi.setIsRound(true);
        this.eJi.setDrawBorder(false);
        this.mLine = this.fgn.findViewById(e.g.line);
        this.eJm = (MessageRedDotView) this.fgn.findViewById(e.g.new_message);
        this.eJj = (TextView) this.fgn.findViewById(e.g.desc_view);
    }

    public void aC(String str, int i) {
        this.eJj.setText(str);
        this.mIcon = i;
        aWf();
    }

    public void y(int i, boolean z) {
        if (i > 0) {
            if (z) {
                i = 0;
            }
            this.eJm.refresh(i);
            this.eJm.setVisibility(0);
            return;
        }
        this.eJm.setVisibility(8);
    }

    public void aWf() {
        al.c(this.eJj, e.d.cp_cont_b, 1);
        al.i(this.fgn, e.f.addresslist_item_bg);
        al.i(this.mLine, e.d.cp_bg_line_c);
        al.c(this.fgp, e.f.icon_arrow_gray_right_n);
        al.c(this.eJi, this.mIcon);
        if (this.eJm != null) {
            this.eJm.onChangeSkinType();
        }
    }

    public void qG(int i) {
        if (this.mLine != null) {
            this.mLine.setVisibility(i);
        }
    }

    public View getView() {
        return this.fgn;
    }
}
