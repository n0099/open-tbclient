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
    private View eFt;
    private LinearLayout eFu;
    private ImageView eFv;
    private HeadImageView eid;
    private TextView eie;
    private MessageRedDotView eih;
    private int mIcon;
    private View mLine;

    public f(TbPageContext tbPageContext) {
        this.eFt = LayoutInflater.from(tbPageContext.getContext()).inflate(d.i.reply_and_at_item, (ViewGroup) null, false);
        this.eFu = (LinearLayout) this.eFt.findViewById(d.g.reply_and_at_item);
        this.eFv = (ImageView) this.eFt.findViewById(d.g.arrow_view);
        this.eid = (HeadImageView) this.eFt.findViewById(d.g.reply_and_at_head);
        this.eid.setIsRound(true);
        this.eid.setDrawBorder(false);
        this.mLine = this.eFt.findViewById(d.g.line);
        this.eih = (MessageRedDotView) this.eFt.findViewById(d.g.new_message);
        this.eie = (TextView) this.eFt.findViewById(d.g.desc_view);
    }

    public void aw(String str, int i) {
        this.eie.setText(str);
        this.mIcon = i;
        aOt();
    }

    public void y(int i, boolean z) {
        if (i > 0) {
            if (z) {
                i = 0;
            }
            this.eih.refresh(i);
            this.eih.setVisibility(0);
            return;
        }
        this.eih.setVisibility(8);
    }

    public void aOt() {
        am.c(this.eie, d.C0142d.cp_cont_b, 1);
        am.i(this.eFt, d.f.addresslist_item_bg);
        am.i(this.mLine, d.C0142d.cp_bg_line_c);
        am.c(this.eFv, d.f.icon_arrow_gray_right_n);
        am.c(this.eid, this.mIcon);
        if (this.eih != null) {
            this.eih.onChangeSkinType();
        }
    }

    public void oC(int i) {
        if (this.mLine != null) {
            this.mLine.setVisibility(i);
        }
    }

    public View getView() {
        return this.eFt;
    }
}
