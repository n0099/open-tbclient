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
    private TextView aoi;
    private TextView cif;
    private HeadImageView csn;
    private View dJg;
    private TextView dJh;
    private TextView dJi;
    private View mLine;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.csn = (HeadImageView) view.findViewById(d.h.photo);
        this.aoi = (TextView) view.findViewById(d.h.user_name);
        this.cif = (TextView) view.findViewById(d.h.time);
        this.dJg = view.findViewById(d.h.divider_between_time_and_fans_reply);
        this.dJh = (TextView) view.findViewById(d.h.fans_reply);
        this.dJi = (TextView) view.findViewById(d.h.content);
        this.mLine = view.findViewById(d.h.line);
        this.csn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.Fk().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9483, a.this.getData(), null, null));
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
                a.this.Fk().dispatchMvcEvent(bVar);
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void D(FeedData feedData) {
        super.D(feedData);
        if (feedData.getReplyer() != null) {
            this.aoi.setText(feedData.getReplyer().getName_show());
            if (feedData.getReplyer().isBigV()) {
                aj.i(this.aoi, d.e.cp_cont_r);
            } else {
                aj.i(this.aoi, d.e.cp_cont_c);
            }
            this.csn.setShowV(feedData.getReplyer().isBigV());
            this.csn.setIsRound(true);
            this.csn.setVisibility(0);
            String portrait = feedData.getReplyer().getPortrait();
            this.csn.setTag(null);
            if (portrait != null && portrait.length() > 0) {
                this.csn.c(portrait, 12, false);
            } else {
                this.csn.setImageResource(d.g.photo);
            }
            if (feedData.getReplyer().getIsMyFans() == 1) {
                this.dJg.setVisibility(0);
                this.dJh.setVisibility(0);
            } else {
                this.dJg.setVisibility(8);
                this.dJh.setVisibility(8);
            }
        }
        this.cif.setText(am.r(feedData.getTime()));
        this.dJi.setText(feedData.getContent());
    }

    @Override // com.baidu.tieba.tbadkCore.l
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        aj.j(getRootView(), d.g.list_selector);
        aj.k(this.mLine, d.e.cp_bg_line_b);
        aj.i(this.cif, d.e.cp_cont_d);
        aj.k(this.dJg, d.e.cp_cont_d);
        aj.i(this.dJh, d.e.cp_cont_d);
        aj.i(this.dJi, d.e.cp_cont_b);
        this.cif.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.g.icon_little_time), (Drawable) null, (Drawable) null, (Drawable) null);
        return false;
    }
}
