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
    private HeadImageView eLZ;
    private TextView eMa;
    private MessageRedDotView eMd;
    private View fjg;
    private LinearLayout fjh;
    private ImageView fji;
    private int mIcon;
    private View mLine;

    public f(TbPageContext tbPageContext) {
        this.fjg = LayoutInflater.from(tbPageContext.getContext()).inflate(e.h.reply_and_at_item, (ViewGroup) null, false);
        this.fjh = (LinearLayout) this.fjg.findViewById(e.g.reply_and_at_item);
        this.fji = (ImageView) this.fjg.findViewById(e.g.arrow_view);
        this.eLZ = (HeadImageView) this.fjg.findViewById(e.g.reply_and_at_head);
        this.eLZ.setIsRound(true);
        this.eLZ.setDrawBorder(false);
        this.mLine = this.fjg.findViewById(e.g.line);
        this.eMd = (MessageRedDotView) this.fjg.findViewById(e.g.new_message);
        this.eMa = (TextView) this.fjg.findViewById(e.g.desc_view);
    }

    public void aD(String str, int i) {
        this.eMa.setText(str);
        this.mIcon = i;
        aWT();
    }

    public void y(int i, boolean z) {
        if (i > 0) {
            if (z) {
                i = 0;
            }
            this.eMd.refresh(i);
            this.eMd.setVisibility(0);
            return;
        }
        this.eMd.setVisibility(8);
    }

    public void aWT() {
        al.c(this.eMa, e.d.cp_cont_b, 1);
        al.i(this.fjg, e.f.addresslist_item_bg);
        al.i(this.mLine, e.d.cp_bg_line_c);
        al.c(this.fji, e.f.icon_arrow_gray_right_n);
        al.c(this.eLZ, this.mIcon);
        if (this.eMd != null) {
            this.eMd.onChangeSkinType();
        }
    }

    public void qT(int i) {
        if (this.mLine != null) {
            this.mLine.setVisibility(i);
        }
    }

    public View getView() {
        return this.fjg;
    }
}
