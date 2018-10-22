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
    private HeadImageView eBa;
    private TextView eBb;
    private MessageRedDotView eBe;
    private View eYg;
    private LinearLayout eYh;
    private ImageView eYi;
    private int mIcon;
    private View mLine;

    public f(TbPageContext tbPageContext) {
        this.eYg = LayoutInflater.from(tbPageContext.getContext()).inflate(e.h.reply_and_at_item, (ViewGroup) null, false);
        this.eYh = (LinearLayout) this.eYg.findViewById(e.g.reply_and_at_item);
        this.eYi = (ImageView) this.eYg.findViewById(e.g.arrow_view);
        this.eBa = (HeadImageView) this.eYg.findViewById(e.g.reply_and_at_head);
        this.eBa.setIsRound(true);
        this.eBa.setDrawBorder(false);
        this.mLine = this.eYg.findViewById(e.g.line);
        this.eBe = (MessageRedDotView) this.eYg.findViewById(e.g.new_message);
        this.eBb = (TextView) this.eYg.findViewById(e.g.desc_view);
    }

    public void aB(String str, int i) {
        this.eBb.setText(str);
        this.mIcon = i;
        aUR();
    }

    public void y(int i, boolean z) {
        if (i > 0) {
            if (z) {
                i = 0;
            }
            this.eBe.refresh(i);
            this.eBe.setVisibility(0);
            return;
        }
        this.eBe.setVisibility(8);
    }

    public void aUR() {
        al.c(this.eBb, e.d.cp_cont_b, 1);
        al.i(this.eYg, e.f.addresslist_item_bg);
        al.i(this.mLine, e.d.cp_bg_line_c);
        al.c(this.eYi, e.f.icon_arrow_gray_right_n);
        al.c(this.eBa, this.mIcon);
        if (this.eBe != null) {
            this.eBe.onChangeSkinType();
        }
    }

    public void pT(int i) {
        if (this.mLine != null) {
            this.mLine.setVisibility(i);
        }
    }

    public View getView() {
        return this.eYg;
    }
}
