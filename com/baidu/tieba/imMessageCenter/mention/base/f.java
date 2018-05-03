package com.baidu.tieba.imMessageCenter.mention.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class f {
    private HeadImageView dRP;
    private TextView dRQ;
    private MessageRedDotView dRT;
    private View epd;
    private LinearLayout epe;
    private ImageView epf;
    private int mIcon;
    private View mLine;

    public f(TbPageContext tbPageContext) {
        this.epd = LayoutInflater.from(tbPageContext.getContext()).inflate(d.i.reply_and_at_item, (ViewGroup) null, false);
        this.epe = (LinearLayout) this.epd.findViewById(d.g.reply_and_at_item);
        this.epf = (ImageView) this.epd.findViewById(d.g.arrow_view);
        this.dRP = (HeadImageView) this.epd.findViewById(d.g.reply_and_at_head);
        this.dRP.setIsRound(true);
        this.dRP.setDrawBorder(false);
        this.mLine = this.epd.findViewById(d.g.line);
        this.dRT = (MessageRedDotView) this.epd.findViewById(d.g.new_message);
        this.dRQ = (TextView) this.epd.findViewById(d.g.desc_view);
    }

    public void au(String str, int i) {
        this.dRQ.setText(str);
        this.mIcon = i;
        aIT();
    }

    public void y(int i, boolean z) {
        if (i > 0) {
            if (z) {
                i = 0;
            }
            this.dRT.refresh(i);
            this.dRT.setVisibility(0);
            return;
        }
        this.dRT.setVisibility(8);
    }

    public void aIT() {
        ak.c(this.dRQ, d.C0126d.cp_cont_b, 1);
        ak.i(this.epd, d.f.addresslist_item_bg);
        ak.i(this.mLine, d.C0126d.cp_bg_line_c);
        ak.c(this.epf, d.f.icon_arrow_gray_right_n);
        ak.c(this.dRP, this.mIcon);
        if (this.dRT != null) {
            this.dRT.onChangeSkinType();
        }
    }

    public void ok(int i) {
        if (this.mLine != null) {
            this.mLine.setVisibility(i);
        }
    }

    public View getView() {
        return this.epd;
    }
}
