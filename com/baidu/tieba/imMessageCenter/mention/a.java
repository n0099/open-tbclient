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
    private TextView anw;
    private View asD;
    private TextView bDf;
    private TextView bXs;
    private HeadImageView cej;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.cej = (HeadImageView) view.findViewById(w.h.photo);
        this.anw = (TextView) view.findViewById(w.h.user_name);
        this.bXs = (TextView) view.findViewById(w.h.time);
        this.bDf = (TextView) view.findViewById(w.h.content);
        this.asD = view.findViewById(w.h.line);
        this.cej.setOnClickListener(new b(this));
        view.setOnClickListener(new c(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void E(FeedData feedData) {
        super.E(feedData);
        if (feedData.getReplyer() != null) {
            this.anw.setText(feedData.getReplyer().getName_show());
            if (feedData.getReplyer().isBigV()) {
                com.baidu.tbadk.core.util.as.i(this.anw, w.e.cp_cont_r);
            } else {
                com.baidu.tbadk.core.util.as.i(this.anw, w.e.cp_cont_c);
            }
            this.cej.setShowV(feedData.getReplyer().isBigV());
            this.cej.setIsRound(true);
            this.cej.setVisibility(0);
            String portrait = feedData.getReplyer().getPortrait();
            this.cej.setTag(null);
            if (portrait != null && portrait.length() > 0) {
                this.cej.c(portrait, 12, false);
            } else {
                this.cej.setImageResource(w.g.photo);
            }
        }
        this.bXs.setText(com.baidu.tbadk.core.util.aw.q(feedData.getTime()));
        this.bDf.setText(feedData.getContent());
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.core.util.as.j(getRootView(), w.g.list_selector);
        com.baidu.tbadk.core.util.as.k(this.asD, w.e.cp_bg_line_b);
        if (i == 1) {
            this.bXs.setTextColor(getResources().getColor(w.e.common_color_10071));
            this.bDf.setTextColor(getResources().getColor(w.e.common_color_10069));
        } else {
            this.bXs.setTextColor(getResources().getColor(w.e.common_color_10070));
            this.bDf.setTextColor(getResources().getColor(w.e.common_color_10235));
        }
        this.bXs.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.as.getDrawable(w.g.icon_little_time), (Drawable) null, (Drawable) null, (Drawable) null);
        return false;
    }
}
