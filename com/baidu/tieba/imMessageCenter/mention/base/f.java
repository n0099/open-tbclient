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
/* loaded from: classes2.dex */
public class f {
    private ImageView eQA;
    private View eQy;
    private LinearLayout eQz;
    private HeadImageView etk;
    private TextView etl;
    private MessageRedDotView eto;
    private int mIcon;
    private View mLine;

    public f(TbPageContext tbPageContext) {
        this.eQy = LayoutInflater.from(tbPageContext.getContext()).inflate(e.h.reply_and_at_item, (ViewGroup) null, false);
        this.eQz = (LinearLayout) this.eQy.findViewById(e.g.reply_and_at_item);
        this.eQA = (ImageView) this.eQy.findViewById(e.g.arrow_view);
        this.etk = (HeadImageView) this.eQy.findViewById(e.g.reply_and_at_head);
        this.etk.setIsRound(true);
        this.etk.setDrawBorder(false);
        this.mLine = this.eQy.findViewById(e.g.line);
        this.eto = (MessageRedDotView) this.eQy.findViewById(e.g.new_message);
        this.etl = (TextView) this.eQy.findViewById(e.g.desc_view);
    }

    public void ax(String str, int i) {
        this.etl.setText(str);
        this.mIcon = i;
        aRD();
    }

    public void y(int i, boolean z) {
        if (i > 0) {
            if (z) {
                i = 0;
            }
            this.eto.refresh(i);
            this.eto.setVisibility(0);
            return;
        }
        this.eto.setVisibility(8);
    }

    public void aRD() {
        al.c(this.etl, e.d.cp_cont_b, 1);
        al.i(this.eQy, e.f.addresslist_item_bg);
        al.i(this.mLine, e.d.cp_bg_line_c);
        al.c(this.eQA, e.f.icon_arrow_gray_right_n);
        al.c(this.etk, this.mIcon);
        if (this.eto != null) {
            this.eto.onChangeSkinType();
        }
    }

    public void pv(int i) {
        if (this.mLine != null) {
            this.mLine.setVisibility(i);
        }
    }

    public View getView() {
        return this.eQy;
    }
}
