package com.baidu.tieba.imMessageCenter.mention;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.mvc.f.a<FeedData, com.baidu.tbadk.mvc.d.b> {
    private TextView amq;
    private View arO;
    private TextView bJn;
    private HeadImageView bPc;
    private TextView buk;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.bPc = (HeadImageView) view.findViewById(w.h.photo);
        this.amq = (TextView) view.findViewById(w.h.user_name);
        this.bJn = (TextView) view.findViewById(w.h.time);
        this.buk = (TextView) view.findViewById(w.h.content);
        this.arO = view.findViewById(w.h.line);
        this.bPc.setOnClickListener(new b(this));
        view.setOnClickListener(new c(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void E(FeedData feedData) {
        super.E(feedData);
        if (feedData.getReplyer() != null) {
            this.amq.setText(feedData.getReplyer().getName_show());
            this.bPc.setVisibility(0);
            String portrait = feedData.getReplyer().getPortrait();
            this.bPc.setTag(null);
            if (portrait != null && portrait.length() > 0) {
                this.bPc.c(portrait, 12, false);
            } else {
                this.bPc.setImageResource(w.g.photo);
            }
        }
        this.bJn.setText(com.baidu.tbadk.core.util.au.q(feedData.getTime()));
        this.buk.setText(feedData.getContent());
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.core.util.aq.j(getRootView(), w.g.list_selector);
        com.baidu.tbadk.core.util.aq.k(this.arO, w.e.cp_bg_line_b);
        if (i == 1) {
            this.bJn.setTextColor(getResources().getColor(w.e.common_color_10071));
            this.buk.setTextColor(getResources().getColor(w.e.common_color_10069));
            this.amq.setTextColor(getResources().getColor(w.e.cp_cont_c_1));
        } else {
            this.bJn.setTextColor(getResources().getColor(w.e.common_color_10070));
            this.buk.setTextColor(getResources().getColor(w.e.common_color_10235));
            this.amq.setTextColor(getResources().getColor(w.e.cp_cont_c));
        }
        this.bJn.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_little_time), (Drawable) null, (Drawable) null, (Drawable) null);
        return false;
    }
}
