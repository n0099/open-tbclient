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
    private HeadImageView dRS;
    private TextView dRT;
    private MessageRedDotView dRW;
    private View epg;
    private LinearLayout eph;
    private ImageView epi;
    private int mIcon;
    private View mLine;

    public f(TbPageContext tbPageContext) {
        this.epg = LayoutInflater.from(tbPageContext.getContext()).inflate(d.i.reply_and_at_item, (ViewGroup) null, false);
        this.eph = (LinearLayout) this.epg.findViewById(d.g.reply_and_at_item);
        this.epi = (ImageView) this.epg.findViewById(d.g.arrow_view);
        this.dRS = (HeadImageView) this.epg.findViewById(d.g.reply_and_at_head);
        this.dRS.setIsRound(true);
        this.dRS.setDrawBorder(false);
        this.mLine = this.epg.findViewById(d.g.line);
        this.dRW = (MessageRedDotView) this.epg.findViewById(d.g.new_message);
        this.dRT = (TextView) this.epg.findViewById(d.g.desc_view);
    }

    public void au(String str, int i) {
        this.dRT.setText(str);
        this.mIcon = i;
        aIT();
    }

    public void y(int i, boolean z) {
        if (i > 0) {
            if (z) {
                i = 0;
            }
            this.dRW.refresh(i);
            this.dRW.setVisibility(0);
            return;
        }
        this.dRW.setVisibility(8);
    }

    public void aIT() {
        ak.c(this.dRT, d.C0126d.cp_cont_b, 1);
        ak.i(this.epg, d.f.addresslist_item_bg);
        ak.i(this.mLine, d.C0126d.cp_bg_line_c);
        ak.c(this.epi, d.f.icon_arrow_gray_right_n);
        ak.c(this.dRS, this.mIcon);
        if (this.dRW != null) {
            this.dRW.onChangeSkinType();
        }
    }

    public void ok(int i) {
        if (this.mLine != null) {
            this.mLine.setVisibility(i);
        }
    }

    public View getView() {
        return this.epg;
    }
}
