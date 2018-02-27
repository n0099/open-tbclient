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
    private View eUm;
    private LinearLayout eUn;
    private ImageView eUo;
    private HeadImageView ewW;
    private TextView ewX;
    private MessageRedDotView exa;
    private int mIcon;
    private View mLine;

    public f(TbPageContext tbPageContext) {
        this.eUm = LayoutInflater.from(tbPageContext.getContext()).inflate(d.h.reply_and_at_item, (ViewGroup) null, false);
        this.eUn = (LinearLayout) this.eUm.findViewById(d.g.reply_and_at_item);
        this.eUo = (ImageView) this.eUm.findViewById(d.g.arrow_view);
        this.ewW = (HeadImageView) this.eUm.findViewById(d.g.reply_and_at_head);
        this.ewW.setIsRound(true);
        this.ewW.setDrawBorder(false);
        this.mLine = this.eUm.findViewById(d.g.line);
        this.exa = (MessageRedDotView) this.eUm.findViewById(d.g.new_message);
        this.ewX = (TextView) this.eUm.findViewById(d.g.desc_view);
    }

    public void as(String str, int i) {
        this.ewX.setText(str);
        this.mIcon = i;
        aNQ();
    }

    public void M(int i, boolean z) {
        if (i > 0) {
            if (z) {
                i = 0;
            }
            this.exa.refresh(i);
            this.exa.setVisibility(0);
            return;
        }
        this.exa.setVisibility(8);
    }

    public void aNQ() {
        aj.e(this.ewX, d.C0141d.cp_cont_b, 1);
        aj.s(this.eUm, d.f.addresslist_item_bg);
        aj.s(this.mLine, d.C0141d.cp_bg_line_c);
        aj.c(this.eUo, d.f.icon_arrow_gray_right_n);
        aj.c(this.ewW, this.mIcon);
        if (this.exa != null) {
            this.exa.onChangeSkinType();
        }
    }

    public void qP(int i) {
        if (this.mLine != null) {
            this.mLine.setVisibility(i);
        }
    }

    public View getView() {
        return this.eUm;
    }
}
