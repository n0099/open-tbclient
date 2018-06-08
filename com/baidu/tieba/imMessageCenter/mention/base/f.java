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
/* loaded from: classes2.dex */
public class f {
    private View eBD;
    private LinearLayout eBE;
    private ImageView eBF;
    private HeadImageView eej;
    private TextView eek;
    private MessageRedDotView een;
    private int mIcon;
    private View mLine;

    public f(TbPageContext tbPageContext) {
        this.eBD = LayoutInflater.from(tbPageContext.getContext()).inflate(d.i.reply_and_at_item, (ViewGroup) null, false);
        this.eBE = (LinearLayout) this.eBD.findViewById(d.g.reply_and_at_item);
        this.eBF = (ImageView) this.eBD.findViewById(d.g.arrow_view);
        this.eej = (HeadImageView) this.eBD.findViewById(d.g.reply_and_at_head);
        this.eej.setIsRound(true);
        this.eej.setDrawBorder(false);
        this.mLine = this.eBD.findViewById(d.g.line);
        this.een = (MessageRedDotView) this.eBD.findViewById(d.g.new_message);
        this.eek = (TextView) this.eBD.findViewById(d.g.desc_view);
    }

    public void ax(String str, int i) {
        this.eek.setText(str);
        this.mIcon = i;
        aNN();
    }

    public void y(int i, boolean z) {
        if (i > 0) {
            if (z) {
                i = 0;
            }
            this.een.refresh(i);
            this.een.setVisibility(0);
            return;
        }
        this.een.setVisibility(8);
    }

    public void aNN() {
        al.c(this.eek, d.C0141d.cp_cont_b, 1);
        al.i(this.eBD, d.f.addresslist_item_bg);
        al.i(this.mLine, d.C0141d.cp_bg_line_c);
        al.c(this.eBF, d.f.icon_arrow_gray_right_n);
        al.c(this.eej, this.mIcon);
        if (this.een != null) {
            this.een.onChangeSkinType();
        }
    }

    public void ov(int i) {
        if (this.mLine != null) {
            this.mLine.setVisibility(i);
        }
    }

    public View getView() {
        return this.eBD;
    }
}
