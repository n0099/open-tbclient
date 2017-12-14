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
    private TextView aoX;
    private HeadImageView cJr;
    private TextView cyM;
    private ImageView dZS;
    private TextView dZT;
    private View mLine;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.cJr = (HeadImageView) view.findViewById(d.g.photo);
        this.aoX = (TextView) view.findViewById(d.g.user_name);
        this.dZS = (ImageView) view.findViewById(d.g.fans_reply);
        this.cyM = (TextView) view.findViewById(d.g.time);
        this.dZT = (TextView) view.findViewById(d.g.content);
        this.mLine = view.findViewById(d.g.line);
        this.cJr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.FQ().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9483, a.this.getData(), null, null));
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
                a.this.FQ().dispatchMvcEvent(bVar);
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void D(FeedData feedData) {
        super.D(feedData);
        if (feedData.getReplyer() != null) {
            this.aoX.setText(feedData.getReplyer().getName_show());
            if (feedData.getReplyer().isBigV()) {
                aj.i(this.aoX, d.C0096d.cp_cont_r);
            } else {
                aj.i(this.aoX, d.C0096d.cp_cont_c);
            }
            this.cJr.setShowV(feedData.getReplyer().isBigV());
            this.cJr.setIsRound(true);
            this.cJr.setVisibility(0);
            String portrait = feedData.getReplyer().getPortrait();
            this.cJr.setTag(null);
            if (portrait != null && portrait.length() > 0) {
                this.cJr.startLoad(portrait, 12, false);
            } else {
                this.cJr.setImageResource(d.f.photo);
            }
            if (feedData.getReplyer().getIsMyFans() == 1) {
                this.dZS.setVisibility(0);
            } else {
                this.dZS.setVisibility(8);
            }
        }
        this.cyM.setText(am.r(feedData.getTime()));
        this.dZT.setText(feedData.getContent());
    }

    @Override // com.baidu.tieba.tbadkCore.n
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        aj.j(getRootView(), d.f.list_selector);
        aj.k(this.mLine, d.C0096d.cp_bg_line_b);
        aj.i(this.cyM, d.C0096d.cp_cont_d);
        aj.j(this.dZS, d.f.icon_pb_fans);
        aj.i(this.dZT, d.C0096d.cp_cont_b);
        this.cyM.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_little_time), (Drawable) null, (Drawable) null, (Drawable) null);
        return false;
    }
}
