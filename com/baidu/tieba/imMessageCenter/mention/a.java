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
    private View auN;
    private TextView bJf;
    private TextView ceD;
    private HeadImageView clO;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.clO = (HeadImageView) view.findViewById(d.h.photo);
        this.apH = (TextView) view.findViewById(d.h.user_name);
        this.ceD = (TextView) view.findViewById(d.h.time);
        this.bJf = (TextView) view.findViewById(d.h.content);
        this.auN = view.findViewById(d.h.line);
        this.clO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.1
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
            this.clO.setShowV(feedData.getReplyer().isBigV());
            this.clO.setIsRound(true);
            this.clO.setVisibility(0);
            String portrait = feedData.getReplyer().getPortrait();
            this.clO.setTag(null);
            if (portrait != null && portrait.length() > 0) {
                this.clO.c(portrait, 12, false);
            } else {
                this.clO.setImageResource(d.g.photo);
            }
        }
        this.ceD.setText(al.r(feedData.getTime()));
        this.bJf.setText(feedData.getContent());
    }

    @Override // com.baidu.tieba.tbadkCore.l
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        ai.j(getRootView(), d.g.list_selector);
        ai.k(this.auN, d.e.cp_bg_line_b);
        if (i == 1) {
            this.ceD.setTextColor(getResources().getColor(d.e.common_color_10071));
            this.bJf.setTextColor(getResources().getColor(d.e.common_color_10069));
        } else {
            this.ceD.setTextColor(getResources().getColor(d.e.common_color_10070));
            this.bJf.setTextColor(getResources().getColor(d.e.common_color_10235));
        }
        this.ceD.setCompoundDrawablesWithIntrinsicBounds(ai.getDrawable(d.g.icon_little_time), (Drawable) null, (Drawable) null, (Drawable) null);
        return false;
    }
}
