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
    private TextView aoD;
    private HeadImageView cAd;
    private TextView cpT;
    private View dQY;
    private TextView dQZ;
    private TextView dRa;
    private View mLine;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.cAd = (HeadImageView) view.findViewById(d.g.photo);
        this.aoD = (TextView) view.findViewById(d.g.user_name);
        this.cpT = (TextView) view.findViewById(d.g.time);
        this.dQY = view.findViewById(d.g.divider_between_time_and_fans_reply);
        this.dQZ = (TextView) view.findViewById(d.g.fans_reply);
        this.dRa = (TextView) view.findViewById(d.g.content);
        this.mLine = view.findViewById(d.g.line);
        this.cAd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.FI().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9483, a.this.getData(), null, null));
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
                a.this.FI().dispatchMvcEvent(bVar);
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void D(FeedData feedData) {
        super.D(feedData);
        if (feedData.getReplyer() != null) {
            this.aoD.setText(feedData.getReplyer().getName_show());
            if (feedData.getReplyer().isBigV()) {
                aj.i(this.aoD, d.C0080d.cp_cont_r);
            } else {
                aj.i(this.aoD, d.C0080d.cp_cont_c);
            }
            this.cAd.setShowV(feedData.getReplyer().isBigV());
            this.cAd.setIsRound(true);
            this.cAd.setVisibility(0);
            String portrait = feedData.getReplyer().getPortrait();
            this.cAd.setTag(null);
            if (portrait != null && portrait.length() > 0) {
                this.cAd.startLoad(portrait, 12, false);
            } else {
                this.cAd.setImageResource(d.f.photo);
            }
            if (feedData.getReplyer().getIsMyFans() == 1) {
                this.dQY.setVisibility(0);
                this.dQZ.setVisibility(0);
            } else {
                this.dQY.setVisibility(8);
                this.dQZ.setVisibility(8);
            }
        }
        this.cpT.setText(am.r(feedData.getTime()));
        this.dRa.setText(feedData.getContent());
    }

    @Override // com.baidu.tieba.tbadkCore.m
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        aj.j(getRootView(), d.f.list_selector);
        aj.k(this.mLine, d.C0080d.cp_bg_line_b);
        aj.i(this.cpT, d.C0080d.cp_cont_d);
        aj.k(this.dQY, d.C0080d.cp_cont_d);
        aj.i(this.dQZ, d.C0080d.cp_cont_d);
        aj.i(this.dRa, d.C0080d.cp_cont_b);
        this.cpT.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_little_time), (Drawable) null, (Drawable) null, (Drawable) null);
        return false;
    }
}
