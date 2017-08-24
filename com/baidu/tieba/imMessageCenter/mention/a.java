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
    private TextView apH;
    private View auO;
    private TextView bJg;
    private TextView ceE;
    private HeadImageView clP;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.clP = (HeadImageView) view.findViewById(d.h.photo);
        this.apH = (TextView) view.findViewById(d.h.user_name);
        this.ceE = (TextView) view.findViewById(d.h.time);
        this.bJg = (TextView) view.findViewById(d.h.content);
        this.auO = view.findViewById(d.h.line);
        this.clP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.FN().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9483, a.this.getData(), null, null));
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
                a.this.FN().dispatchMvcEvent(bVar);
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void E(FeedData feedData) {
        super.E(feedData);
        if (feedData.getReplyer() != null) {
            this.apH.setText(feedData.getReplyer().getName_show());
            if (feedData.getReplyer().isBigV()) {
                ai.i(this.apH, d.e.cp_cont_r);
            } else {
                ai.i(this.apH, d.e.cp_cont_c);
            }
            this.clP.setShowV(feedData.getReplyer().isBigV());
            this.clP.setIsRound(true);
            this.clP.setVisibility(0);
            String portrait = feedData.getReplyer().getPortrait();
            this.clP.setTag(null);
            if (portrait != null && portrait.length() > 0) {
                this.clP.c(portrait, 12, false);
            } else {
                this.clP.setImageResource(d.g.photo);
            }
        }
        this.ceE.setText(al.r(feedData.getTime()));
        this.bJg.setText(feedData.getContent());
    }

    @Override // com.baidu.tieba.tbadkCore.l
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        ai.j(getRootView(), d.g.list_selector);
        ai.k(this.auO, d.e.cp_bg_line_b);
        if (i == 1) {
            this.ceE.setTextColor(getResources().getColor(d.e.common_color_10071));
            this.bJg.setTextColor(getResources().getColor(d.e.common_color_10069));
        } else {
            this.ceE.setTextColor(getResources().getColor(d.e.common_color_10070));
            this.bJg.setTextColor(getResources().getColor(d.e.common_color_10235));
        }
        this.ceE.setCompoundDrawablesWithIntrinsicBounds(ai.getDrawable(d.g.icon_little_time), (Drawable) null, (Drawable) null, (Drawable) null);
        return false;
    }
}
