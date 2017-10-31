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
    private TextView aoE;
    private TextView cpA;
    private HeadImageView czK;
    private View dQT;
    private TextView dQU;
    private TextView dQV;
    private View mLine;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.czK = (HeadImageView) view.findViewById(d.g.photo);
        this.aoE = (TextView) view.findViewById(d.g.user_name);
        this.cpA = (TextView) view.findViewById(d.g.time);
        this.dQT = view.findViewById(d.g.divider_between_time_and_fans_reply);
        this.dQU = (TextView) view.findViewById(d.g.fans_reply);
        this.dQV = (TextView) view.findViewById(d.g.content);
        this.mLine = view.findViewById(d.g.line);
        this.czK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.Fw().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9483, a.this.getData(), null, null));
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
                a.this.Fw().dispatchMvcEvent(bVar);
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void D(FeedData feedData) {
        super.D(feedData);
        if (feedData.getReplyer() != null) {
            this.aoE.setText(feedData.getReplyer().getName_show());
            if (feedData.getReplyer().isBigV()) {
                aj.i(this.aoE, d.C0080d.cp_cont_r);
            } else {
                aj.i(this.aoE, d.C0080d.cp_cont_c);
            }
            this.czK.setShowV(feedData.getReplyer().isBigV());
            this.czK.setIsRound(true);
            this.czK.setVisibility(0);
            String portrait = feedData.getReplyer().getPortrait();
            this.czK.setTag(null);
            if (portrait != null && portrait.length() > 0) {
                this.czK.startLoad(portrait, 12, false);
            } else {
                this.czK.setImageResource(d.f.photo);
            }
            if (feedData.getReplyer().getIsMyFans() == 1) {
                this.dQT.setVisibility(0);
                this.dQU.setVisibility(0);
            } else {
                this.dQT.setVisibility(8);
                this.dQU.setVisibility(8);
            }
        }
        this.cpA.setText(am.r(feedData.getTime()));
        this.dQV.setText(feedData.getContent());
    }

    @Override // com.baidu.tieba.tbadkCore.m
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        aj.j(getRootView(), d.f.list_selector);
        aj.k(this.mLine, d.C0080d.cp_bg_line_b);
        aj.i(this.cpA, d.C0080d.cp_cont_d);
        aj.k(this.dQT, d.C0080d.cp_cont_d);
        aj.i(this.dQU, d.C0080d.cp_cont_d);
        aj.i(this.dQV, d.C0080d.cp_cont_b);
        this.cpA.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_little_time), (Drawable) null, (Drawable) null, (Drawable) null);
        return false;
    }
}
