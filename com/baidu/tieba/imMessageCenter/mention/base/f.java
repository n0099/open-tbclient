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
/* loaded from: classes4.dex */
public class f {
    private HeadImageView gcO;
    private TextView gcP;
    private MessageRedDotView gcS;
    private View gzT;
    private LinearLayout gzU;
    private ImageView gzV;
    private int mIcon;
    private View mLine;

    public f(TbPageContext tbPageContext) {
        this.gzT = LayoutInflater.from(tbPageContext.getContext()).inflate(d.h.reply_and_at_item, (ViewGroup) null, false);
        this.gzU = (LinearLayout) this.gzT.findViewById(d.g.reply_and_at_item);
        this.gzV = (ImageView) this.gzT.findViewById(d.g.arrow_view);
        this.gcO = (HeadImageView) this.gzT.findViewById(d.g.reply_and_at_head);
        this.gcO.setIsRound(true);
        this.gcO.setDrawBorder(false);
        this.mLine = this.gzT.findViewById(d.g.line);
        this.gcS = (MessageRedDotView) this.gzT.findViewById(d.g.new_message);
        this.gcP = (TextView) this.gzT.findViewById(d.g.desc_view);
    }

    public void aY(String str, int i) {
        this.gcP.setText(str);
        this.mIcon = i;
        bxW();
    }

    public void E(int i, boolean z) {
        if (i > 0) {
            if (z) {
                i = 0;
            }
            this.gcS.refresh(i);
            this.gcS.setVisibility(0);
            return;
        }
        this.gcS.setVisibility(8);
    }

    public void bxW() {
        al.d(this.gcP, d.C0236d.cp_cont_b, 1);
        al.k(this.gzT, d.f.addresslist_item_bg);
        al.k(this.mLine, d.C0236d.cp_bg_line_c);
        al.c(this.gzV, d.f.icon_arrow_gray_right_n);
        al.c(this.gcO, this.mIcon);
        if (this.gcS != null) {
            this.gcS.onChangeSkinType();
        }
    }

    public void uC(int i) {
        if (this.mLine != null) {
            this.mLine.setVisibility(i);
        }
    }

    public View getView() {
        return this.gzT;
    }
}
