package com.baidu.tieba.imMessageCenter.mention;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
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
    private TextView bdf;
    private HeadImageView dDq;
    private TextView drP;
    private TextView eNA;
    private ImageView eNz;
    private View mLine;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.dDq = (HeadImageView) view.findViewById(d.g.photo);
        this.bdf = (TextView) view.findViewById(d.g.user_name);
        this.eNz = (ImageView) view.findViewById(d.g.fans_reply);
        this.drP = (TextView) view.findViewById(d.g.time);
        this.eNA = (TextView) view.findViewById(d.g.content);
        this.mLine = view.findViewById(d.g.line);
        this.dDq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.Nd().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9483, a.this.getData(), null, null));
            }
        });
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.Nd().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9484, a.this.getData(), null, null));
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void aI(FeedData feedData) {
        super.aI(feedData);
        if (feedData.getReplyer() != null) {
            this.bdf.setText(feedData.getReplyer().getName_show());
            if (feedData.getReplyer().isBigV()) {
                aj.r(this.bdf, d.C0107d.cp_cont_r);
            } else {
                aj.r(this.bdf, d.C0107d.cp_cont_c);
            }
            this.dDq.setShowV(feedData.getReplyer().isBigV());
            this.dDq.setIsRound(true);
            this.dDq.setVisibility(0);
            String portrait = feedData.getReplyer().getPortrait();
            this.dDq.setTag(null);
            if (portrait != null && portrait.length() > 0) {
                this.dDq.startLoad(portrait, 12, false);
            } else {
                this.dDq.setImageResource(d.f.photo);
            }
            if (feedData.getReplyer().getIsMyFans() == 1) {
                this.eNz.setVisibility(0);
            } else {
                this.eNz.setVisibility(8);
            }
        }
        this.drP.setText(am.z(feedData.getTime()));
        this.eNA.setText(feedData.getContent());
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        aj.s(getRootView(), d.f.list_selector);
        aj.t(this.mLine, d.C0107d.cp_bg_line_b);
        aj.r(this.drP, d.C0107d.cp_cont_d);
        aj.s(this.eNz, d.f.icon_pb_fans);
        aj.r(this.eNA, d.C0107d.cp_cont_b);
        this.drP.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_little_time), (Drawable) null, (Drawable) null, (Drawable) null);
        return false;
    }
}
