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
    private TextView aoU;
    private HeadImageView cJh;
    private TextView cyE;
    private ImageView dYN;
    private TextView dYO;
    private View mLine;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.cJh = (HeadImageView) view.findViewById(d.g.photo);
        this.aoU = (TextView) view.findViewById(d.g.user_name);
        this.dYN = (ImageView) view.findViewById(d.g.fans_reply);
        this.cyE = (TextView) view.findViewById(d.g.time);
        this.dYO = (TextView) view.findViewById(d.g.content);
        this.mLine = view.findViewById(d.g.line);
        this.cJh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.FP().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9483, a.this.getData(), null, null));
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
                a.this.FP().dispatchMvcEvent(bVar);
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void D(FeedData feedData) {
        super.D(feedData);
        if (feedData.getReplyer() != null) {
            this.aoU.setText(feedData.getReplyer().getName_show());
            if (feedData.getReplyer().isBigV()) {
                aj.i(this.aoU, d.C0082d.cp_cont_r);
            } else {
                aj.i(this.aoU, d.C0082d.cp_cont_c);
            }
            this.cJh.setShowV(feedData.getReplyer().isBigV());
            this.cJh.setIsRound(true);
            this.cJh.setVisibility(0);
            String portrait = feedData.getReplyer().getPortrait();
            this.cJh.setTag(null);
            if (portrait != null && portrait.length() > 0) {
                this.cJh.startLoad(portrait, 12, false);
            } else {
                this.cJh.setImageResource(d.f.photo);
            }
            if (feedData.getReplyer().getIsMyFans() == 1) {
                this.dYN.setVisibility(0);
            } else {
                this.dYN.setVisibility(8);
            }
        }
        this.cyE.setText(am.r(feedData.getTime()));
        this.dYO.setText(feedData.getContent());
    }

    @Override // com.baidu.tieba.tbadkCore.n
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        aj.j(getRootView(), d.f.list_selector);
        aj.k(this.mLine, d.C0082d.cp_bg_line_b);
        aj.i(this.cyE, d.C0082d.cp_cont_d);
        aj.j(this.dYN, d.f.icon_pb_fans);
        aj.i(this.dYO, d.C0082d.cp_cont_b);
        this.cyE.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_little_time), (Drawable) null, (Drawable) null, (Drawable) null);
        return false;
    }
}
