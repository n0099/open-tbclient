package com.baidu.tieba.imMessageCenter.mention;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.w;
/* loaded from: classes2.dex */
public class a extends com.baidu.tbadk.mvc.f.a<FeedData, com.baidu.tbadk.mvc.d.b> {
    private TextView amy;
    private View arA;
    private TextView bCm;
    private TextView bQv;
    private HeadImageView bWb;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.bWb = (HeadImageView) view.findViewById(w.h.photo);
        this.amy = (TextView) view.findViewById(w.h.user_name);
        this.bQv = (TextView) view.findViewById(w.h.time);
        this.bCm = (TextView) view.findViewById(w.h.content);
        this.arA = view.findViewById(w.h.line);
        this.bWb.setOnClickListener(new b(this));
        view.setOnClickListener(new c(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void E(FeedData feedData) {
        super.E(feedData);
        if (feedData.getReplyer() != null) {
            this.amy.setText(feedData.getReplyer().getName_show());
            this.bWb.setVisibility(0);
            String portrait = feedData.getReplyer().getPortrait();
            this.bWb.setTag(null);
            if (portrait != null && portrait.length() > 0) {
                this.bWb.c(portrait, 12, false);
            } else {
                this.bWb.setImageResource(w.g.photo);
            }
        }
        this.bQv.setText(com.baidu.tbadk.core.util.au.q(feedData.getTime()));
        this.bCm.setText(feedData.getContent());
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.core.util.aq.j(getRootView(), w.g.list_selector);
        com.baidu.tbadk.core.util.aq.k(this.arA, w.e.cp_bg_line_b);
        if (i == 1) {
            this.bQv.setTextColor(getResources().getColor(w.e.common_color_10071));
            this.bCm.setTextColor(getResources().getColor(w.e.common_color_10069));
            this.amy.setTextColor(getResources().getColor(w.e.cp_cont_c_1));
        } else {
            this.bQv.setTextColor(getResources().getColor(w.e.common_color_10070));
            this.bCm.setTextColor(getResources().getColor(w.e.common_color_10235));
            this.amy.setTextColor(getResources().getColor(w.e.cp_cont_c));
        }
        this.bQv.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_little_time), (Drawable) null, (Drawable) null, (Drawable) null);
        return false;
    }
}
