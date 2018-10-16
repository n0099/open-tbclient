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
    private HeadImageView eAZ;
    private TextView eBa;
    private MessageRedDotView eBd;
    private View eYf;
    private LinearLayout eYg;
    private ImageView eYh;
    private int mIcon;
    private View mLine;

    public f(TbPageContext tbPageContext) {
        this.eYf = LayoutInflater.from(tbPageContext.getContext()).inflate(e.h.reply_and_at_item, (ViewGroup) null, false);
        this.eYg = (LinearLayout) this.eYf.findViewById(e.g.reply_and_at_item);
        this.eYh = (ImageView) this.eYf.findViewById(e.g.arrow_view);
        this.eAZ = (HeadImageView) this.eYf.findViewById(e.g.reply_and_at_head);
        this.eAZ.setIsRound(true);
        this.eAZ.setDrawBorder(false);
        this.mLine = this.eYf.findViewById(e.g.line);
        this.eBd = (MessageRedDotView) this.eYf.findViewById(e.g.new_message);
        this.eBa = (TextView) this.eYf.findViewById(e.g.desc_view);
    }

    public void aB(String str, int i) {
        this.eBa.setText(str);
        this.mIcon = i;
        aUR();
    }

    public void y(int i, boolean z) {
        if (i > 0) {
            if (z) {
                i = 0;
            }
            this.eBd.refresh(i);
            this.eBd.setVisibility(0);
            return;
        }
        this.eBd.setVisibility(8);
    }

    public void aUR() {
        al.c(this.eBa, e.d.cp_cont_b, 1);
        al.i(this.eYf, e.f.addresslist_item_bg);
        al.i(this.mLine, e.d.cp_bg_line_c);
        al.c(this.eYh, e.f.icon_arrow_gray_right_n);
        al.c(this.eAZ, this.mIcon);
        if (this.eBd != null) {
            this.eBd.onChangeSkinType();
        }
    }

    public void pT(int i) {
        if (this.mLine != null) {
            this.mLine.setVisibility(i);
        }
    }

    public View getView() {
        return this.eYf;
    }
}
