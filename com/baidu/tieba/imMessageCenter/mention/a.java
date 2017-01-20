package com.baidu.tieba.imMessageCenter.mention;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.mvc.f.a<FeedData, com.baidu.tbadk.mvc.d.b> {
    private TextView agJ;
    private View ame;
    private TextView bCn;
    private HeadImageView bIe;
    private TextView bnx;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.bIe = (HeadImageView) view.findViewById(r.h.photo);
        this.agJ = (TextView) view.findViewById(r.h.user_name);
        this.bCn = (TextView) view.findViewById(r.h.time);
        this.bnx = (TextView) view.findViewById(r.h.content);
        this.ame = view.findViewById(r.h.line);
        this.bIe.setOnClickListener(new b(this));
        view.setOnClickListener(new c(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void E(FeedData feedData) {
        super.E(feedData);
        if (feedData.getReplyer() != null) {
            this.agJ.setText(feedData.getReplyer().getName_show());
            this.bIe.setVisibility(0);
            String portrait = feedData.getReplyer().getPortrait();
            this.bIe.setTag(null);
            if (portrait != null && portrait.length() > 0) {
                this.bIe.c(portrait, 12, false);
            } else {
                this.bIe.setImageResource(r.g.photo);
            }
        }
        this.bCn.setText(com.baidu.tbadk.core.util.at.r(feedData.getTime()));
        this.bnx.setText(feedData.getContent());
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.core.util.ap.j(getRootView(), r.g.list_selector);
        com.baidu.tbadk.core.util.ap.k(this.ame, r.e.cp_bg_line_b);
        if (i == 1) {
            this.bCn.setTextColor(getResources().getColor(r.e.common_color_10071));
            this.bnx.setTextColor(getResources().getColor(r.e.common_color_10069));
            this.agJ.setTextColor(getResources().getColor(r.e.cp_cont_c_1));
        } else {
            this.bCn.setTextColor(getResources().getColor(r.e.common_color_10070));
            this.bnx.setTextColor(getResources().getColor(r.e.common_color_10235));
            this.agJ.setTextColor(getResources().getColor(r.e.cp_cont_c));
        }
        this.bCn.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.ap.getDrawable(r.g.icon_little_time), (Drawable) null, (Drawable) null, (Drawable) null);
        return false;
    }
}
