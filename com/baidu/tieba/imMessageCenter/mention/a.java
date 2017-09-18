package com.baidu.tieba.imMessageCenter.mention;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.d;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public class a extends com.baidu.tbadk.mvc.f.a<FeedData, com.baidu.tbadk.mvc.d.b> {
    private View aWX;
    private TextView apj;
    private TextView ciZ;
    private HeadImageView csc;
    private TextView dNe;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.csc = (HeadImageView) view.findViewById(d.h.photo);
        this.apj = (TextView) view.findViewById(d.h.user_name);
        this.ciZ = (TextView) view.findViewById(d.h.time);
        this.dNe = (TextView) view.findViewById(d.h.content);
        this.aWX = view.findViewById(d.h.line);
        this.csc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.FL().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9483, a.this.getData(), null, null));
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
                a.this.FL().dispatchMvcEvent(bVar);
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void D(FeedData feedData) {
        super.D(feedData);
        if (feedData.getReplyer() != null) {
            this.apj.setText(feedData.getReplyer().getName_show());
            if (feedData.getReplyer().isBigV()) {
                aj.i(this.apj, d.e.cp_cont_r);
            } else {
                aj.i(this.apj, d.e.cp_cont_c);
            }
            this.csc.setShowV(feedData.getReplyer().isBigV());
            this.csc.setIsRound(true);
            this.csc.setVisibility(0);
            String portrait = feedData.getReplyer().getPortrait();
            this.csc.setTag(null);
            if (portrait != null && portrait.length() > 0) {
                this.csc.c(portrait, 12, false);
            } else {
                this.csc.setImageResource(d.g.photo);
            }
        }
        this.ciZ.setText(am.r(feedData.getTime()));
        this.dNe.setText(feedData.getContent());
    }

    @Override // com.baidu.tieba.tbadkCore.l
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        aj.j(getRootView(), d.g.list_selector);
        aj.k(this.aWX, d.e.cp_bg_line_b);
        if (i == 1) {
            this.ciZ.setTextColor(getResources().getColor(d.e.common_color_10071));
            this.dNe.setTextColor(getResources().getColor(d.e.common_color_10069));
        } else {
            this.ciZ.setTextColor(getResources().getColor(d.e.common_color_10070));
            this.dNe.setTextColor(getResources().getColor(d.e.common_color_10235));
        }
        this.ciZ.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.g.icon_little_time), (Drawable) null, (Drawable) null, (Drawable) null);
        return false;
    }
}
