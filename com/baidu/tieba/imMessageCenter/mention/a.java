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
    private TextView amB;
    private View arQ;
    private TextView bKI;
    private HeadImageView bQk;
    private TextView bwB;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.bQk = (HeadImageView) view.findViewById(w.h.photo);
        this.amB = (TextView) view.findViewById(w.h.user_name);
        this.bKI = (TextView) view.findViewById(w.h.time);
        this.bwB = (TextView) view.findViewById(w.h.content);
        this.arQ = view.findViewById(w.h.line);
        this.bQk.setOnClickListener(new b(this));
        view.setOnClickListener(new c(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void E(FeedData feedData) {
        super.E(feedData);
        if (feedData.getReplyer() != null) {
            this.amB.setText(feedData.getReplyer().getName_show());
            this.bQk.setVisibility(0);
            String portrait = feedData.getReplyer().getPortrait();
            this.bQk.setTag(null);
            if (portrait != null && portrait.length() > 0) {
                this.bQk.c(portrait, 12, false);
            } else {
                this.bQk.setImageResource(w.g.photo);
            }
        }
        this.bKI.setText(com.baidu.tbadk.core.util.au.q(feedData.getTime()));
        this.bwB.setText(feedData.getContent());
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.core.util.aq.j(getRootView(), w.g.list_selector);
        com.baidu.tbadk.core.util.aq.k(this.arQ, w.e.cp_bg_line_b);
        if (i == 1) {
            this.bKI.setTextColor(getResources().getColor(w.e.common_color_10071));
            this.bwB.setTextColor(getResources().getColor(w.e.common_color_10069));
            this.amB.setTextColor(getResources().getColor(w.e.cp_cont_c_1));
        } else {
            this.bKI.setTextColor(getResources().getColor(w.e.common_color_10070));
            this.bwB.setTextColor(getResources().getColor(w.e.common_color_10235));
            this.amB.setTextColor(getResources().getColor(w.e.cp_cont_c));
        }
        this.bKI.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_little_time), (Drawable) null, (Drawable) null, (Drawable) null);
        return false;
    }
}
