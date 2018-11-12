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
    private HeadImageView eCt;
    private TextView eCu;
    private MessageRedDotView eCx;
    private ImageView eZA;
    private View eZy;
    private LinearLayout eZz;
    private int mIcon;
    private View mLine;

    public f(TbPageContext tbPageContext) {
        this.eZy = LayoutInflater.from(tbPageContext.getContext()).inflate(e.h.reply_and_at_item, (ViewGroup) null, false);
        this.eZz = (LinearLayout) this.eZy.findViewById(e.g.reply_and_at_item);
        this.eZA = (ImageView) this.eZy.findViewById(e.g.arrow_view);
        this.eCt = (HeadImageView) this.eZy.findViewById(e.g.reply_and_at_head);
        this.eCt.setIsRound(true);
        this.eCt.setDrawBorder(false);
        this.mLine = this.eZy.findViewById(e.g.line);
        this.eCx = (MessageRedDotView) this.eZy.findViewById(e.g.new_message);
        this.eCu = (TextView) this.eZy.findViewById(e.g.desc_view);
    }

    public void aB(String str, int i) {
        this.eCu.setText(str);
        this.mIcon = i;
        aUo();
    }

    public void y(int i, boolean z) {
        if (i > 0) {
            if (z) {
                i = 0;
            }
            this.eCx.refresh(i);
            this.eCx.setVisibility(0);
            return;
        }
        this.eCx.setVisibility(8);
    }

    public void aUo() {
        al.c(this.eCu, e.d.cp_cont_b, 1);
        al.i(this.eZy, e.f.addresslist_item_bg);
        al.i(this.mLine, e.d.cp_bg_line_c);
        al.c(this.eZA, e.f.icon_arrow_gray_right_n);
        al.c(this.eCt, this.mIcon);
        if (this.eCx != null) {
            this.eCx.onChangeSkinType();
        }
    }

    public void qm(int i) {
        if (this.mLine != null) {
            this.mLine.setVisibility(i);
        }
    }

    public View getView() {
        return this.eZy;
    }
}
