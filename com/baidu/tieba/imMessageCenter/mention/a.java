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
    private TextView amc;
    private View ary;
    private TextView bJu;
    private HeadImageView bPn;
    private TextView bus;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.bPn = (HeadImageView) view.findViewById(w.h.photo);
        this.amc = (TextView) view.findViewById(w.h.user_name);
        this.bJu = (TextView) view.findViewById(w.h.time);
        this.bus = (TextView) view.findViewById(w.h.content);
        this.ary = view.findViewById(w.h.line);
        this.bPn.setOnClickListener(new b(this));
        view.setOnClickListener(new c(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void E(FeedData feedData) {
        super.E(feedData);
        if (feedData.getReplyer() != null) {
            this.amc.setText(feedData.getReplyer().getName_show());
            this.bPn.setVisibility(0);
            String portrait = feedData.getReplyer().getPortrait();
            this.bPn.setTag(null);
            if (portrait != null && portrait.length() > 0) {
                this.bPn.c(portrait, 12, false);
            } else {
                this.bPn.setImageResource(w.g.photo);
            }
        }
        this.bJu.setText(com.baidu.tbadk.core.util.au.q(feedData.getTime()));
        this.bus.setText(feedData.getContent());
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.core.util.aq.j(getRootView(), w.g.list_selector);
        com.baidu.tbadk.core.util.aq.k(this.ary, w.e.cp_bg_line_b);
        if (i == 1) {
            this.bJu.setTextColor(getResources().getColor(w.e.common_color_10071));
            this.bus.setTextColor(getResources().getColor(w.e.common_color_10069));
            this.amc.setTextColor(getResources().getColor(w.e.cp_cont_c_1));
        } else {
            this.bJu.setTextColor(getResources().getColor(w.e.common_color_10070));
            this.bus.setTextColor(getResources().getColor(w.e.common_color_10235));
            this.amc.setTextColor(getResources().getColor(w.e.cp_cont_c));
        }
        this.bJu.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_little_time), (Drawable) null, (Drawable) null, (Drawable) null);
        return false;
    }
}
