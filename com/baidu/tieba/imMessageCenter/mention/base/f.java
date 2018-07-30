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
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class f {
    private View eJn;
    private LinearLayout eJo;
    private ImageView eJp;
    private HeadImageView elT;
    private TextView elU;
    private MessageRedDotView elX;
    private int mIcon;
    private View mLine;

    public f(TbPageContext tbPageContext) {
        this.eJn = LayoutInflater.from(tbPageContext.getContext()).inflate(d.h.reply_and_at_item, (ViewGroup) null, false);
        this.eJo = (LinearLayout) this.eJn.findViewById(d.g.reply_and_at_item);
        this.eJp = (ImageView) this.eJn.findViewById(d.g.arrow_view);
        this.elT = (HeadImageView) this.eJn.findViewById(d.g.reply_and_at_head);
        this.elT.setIsRound(true);
        this.elT.setDrawBorder(false);
        this.mLine = this.eJn.findViewById(d.g.line);
        this.elX = (MessageRedDotView) this.eJn.findViewById(d.g.new_message);
        this.elU = (TextView) this.eJn.findViewById(d.g.desc_view);
    }

    public void as(String str, int i) {
        this.elU.setText(str);
        this.mIcon = i;
        aPt();
    }

    public void x(int i, boolean z) {
        if (i > 0) {
            if (z) {
                i = 0;
            }
            this.elX.refresh(i);
            this.elX.setVisibility(0);
            return;
        }
        this.elX.setVisibility(8);
    }

    public void aPt() {
        am.c(this.elU, d.C0140d.cp_cont_b, 1);
        am.i(this.eJn, d.f.addresslist_item_bg);
        am.i(this.mLine, d.C0140d.cp_bg_line_c);
        am.c(this.eJp, d.f.icon_arrow_gray_right_n);
        am.c(this.elT, this.mIcon);
        if (this.elX != null) {
            this.elX.onChangeSkinType();
        }
    }

    public void oR(int i) {
        if (this.mLine != null) {
            this.mLine.setVisibility(i);
        }
    }

    public View getView() {
        return this.eJn;
    }
}
