package com.baidu.tieba.imMessageCenter.mention;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.d;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public class a extends com.baidu.tbadk.mvc.f.a<FeedData, com.baidu.tbadk.mvc.d.b> {
    private TextView aom;
    private View atu;
    private TextView bHm;
    private TextView ccL;
    private HeadImageView cjV;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.cjV = (HeadImageView) view.findViewById(d.h.photo);
        this.aom = (TextView) view.findViewById(d.h.user_name);
        this.ccL = (TextView) view.findViewById(d.h.time);
        this.bHm = (TextView) view.findViewById(d.h.content);
        this.atu = view.findViewById(d.h.line);
        this.cjV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.FF().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9483, a.this.getData(), null, null));
            }
        });
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.mvc.c.b bVar;
                FeedData data = a.this.getData();
                if (data != null && data.isStory()) {
                    bVar = new com.baidu.tbadk.mvc.c.b(9489, data, null, null);
                } else {
                    bVar = new com.baidu.tbadk.mvc.c.b(9484, data, null, null);
                }
                a.this.FF().dispatchMvcEvent(bVar);
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void E(FeedData feedData) {
        super.E(feedData);
        if (feedData.getReplyer() != null) {
            this.aom.setText(feedData.getReplyer().getName_show());
            if (feedData.getReplyer().isBigV()) {
                ai.i(this.aom, d.e.cp_cont_r);
            } else {
                ai.i(this.aom, d.e.cp_cont_c);
            }
            this.cjV.setShowV(feedData.getReplyer().isBigV());
            this.cjV.setIsRound(true);
            this.cjV.setVisibility(0);
            String portrait = feedData.getReplyer().getPortrait();
            this.cjV.setTag(null);
            if (portrait != null && portrait.length() > 0) {
                this.cjV.c(portrait, 12, false);
            } else {
                this.cjV.setImageResource(d.g.photo);
            }
        }
        this.ccL.setText(al.r(feedData.getTime()));
        this.bHm.setText(feedData.getContent());
    }

    @Override // com.baidu.tieba.tbadkCore.l
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        ai.j(getRootView(), d.g.list_selector);
        ai.k(this.atu, d.e.cp_bg_line_b);
        if (i == 1) {
            this.ccL.setTextColor(getResources().getColor(d.e.common_color_10071));
            this.bHm.setTextColor(getResources().getColor(d.e.common_color_10069));
        } else {
            this.ccL.setTextColor(getResources().getColor(d.e.common_color_10070));
            this.bHm.setTextColor(getResources().getColor(d.e.common_color_10235));
        }
        this.ccL.setCompoundDrawablesWithIntrinsicBounds(ai.getDrawable(d.g.icon_little_time), (Drawable) null, (Drawable) null, (Drawable) null);
        return false;
    }
}
