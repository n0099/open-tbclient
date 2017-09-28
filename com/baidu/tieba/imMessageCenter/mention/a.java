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
    private View aYL;
    private TextView aou;
    private TextView cir;
    private HeadImageView csz;
    private View dJu;
    private TextView dJv;
    private TextView dJw;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.csz = (HeadImageView) view.findViewById(d.h.photo);
        this.aou = (TextView) view.findViewById(d.h.user_name);
        this.cir = (TextView) view.findViewById(d.h.time);
        this.dJu = view.findViewById(d.h.divider_between_time_and_fans_reply);
        this.dJv = (TextView) view.findViewById(d.h.fans_reply);
        this.dJw = (TextView) view.findViewById(d.h.content);
        this.aYL = view.findViewById(d.h.line);
        this.csz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.Fq().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9483, a.this.getData(), null, null));
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
                a.this.Fq().dispatchMvcEvent(bVar);
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void D(FeedData feedData) {
        super.D(feedData);
        if (feedData.getReplyer() != null) {
            this.aou.setText(feedData.getReplyer().getName_show());
            if (feedData.getReplyer().isBigV()) {
                aj.i(this.aou, d.e.cp_cont_r);
            } else {
                aj.i(this.aou, d.e.cp_cont_c);
            }
            this.csz.setShowV(feedData.getReplyer().isBigV());
            this.csz.setIsRound(true);
            this.csz.setVisibility(0);
            String portrait = feedData.getReplyer().getPortrait();
            this.csz.setTag(null);
            if (portrait != null && portrait.length() > 0) {
                this.csz.c(portrait, 12, false);
            } else {
                this.csz.setImageResource(d.g.photo);
            }
            if (feedData.getReplyer().getIsMyFans() == 1) {
                this.dJu.setVisibility(0);
                this.dJv.setVisibility(0);
            } else {
                this.dJu.setVisibility(8);
                this.dJv.setVisibility(8);
            }
        }
        this.cir.setText(am.q(feedData.getTime()));
        this.dJw.setText(feedData.getContent());
    }

    @Override // com.baidu.tieba.tbadkCore.l
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        aj.j(getRootView(), d.g.list_selector);
        aj.k(this.aYL, d.e.cp_bg_line_b);
        aj.i(this.cir, d.e.cp_cont_d);
        aj.k(this.dJu, d.e.cp_cont_d);
        aj.i(this.dJv, d.e.cp_cont_d);
        aj.i(this.dJw, d.e.cp_cont_b);
        this.cir.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.g.icon_little_time), (Drawable) null, (Drawable) null, (Drawable) null);
        return false;
    }
}
