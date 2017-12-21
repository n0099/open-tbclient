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
    private TextView apa;
    private HeadImageView cJv;
    private TextView cyQ;
    private ImageView dZW;
    private TextView dZX;
    private View mLine;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.cJv = (HeadImageView) view.findViewById(d.g.photo);
        this.apa = (TextView) view.findViewById(d.g.user_name);
        this.dZW = (ImageView) view.findViewById(d.g.fans_reply);
        this.cyQ = (TextView) view.findViewById(d.g.time);
        this.dZX = (TextView) view.findViewById(d.g.content);
        this.mLine = view.findViewById(d.g.line);
        this.cJv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.1
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
            this.apa.setText(feedData.getReplyer().getName_show());
            if (feedData.getReplyer().isBigV()) {
                aj.i(this.apa, d.C0095d.cp_cont_r);
            } else {
                aj.i(this.apa, d.C0095d.cp_cont_c);
            }
            this.cJv.setShowV(feedData.getReplyer().isBigV());
            this.cJv.setIsRound(true);
            this.cJv.setVisibility(0);
            String portrait = feedData.getReplyer().getPortrait();
            this.cJv.setTag(null);
            if (portrait != null && portrait.length() > 0) {
                this.cJv.startLoad(portrait, 12, false);
            } else {
                this.cJv.setImageResource(d.f.photo);
            }
            if (feedData.getReplyer().getIsMyFans() == 1) {
                this.dZW.setVisibility(0);
            } else {
                this.dZW.setVisibility(8);
            }
        }
        this.cyQ.setText(am.r(feedData.getTime()));
        this.dZX.setText(feedData.getContent());
    }

    @Override // com.baidu.tieba.tbadkCore.n
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        aj.j(getRootView(), d.f.list_selector);
        aj.k(this.mLine, d.C0095d.cp_bg_line_b);
        aj.i(this.cyQ, d.C0095d.cp_cont_d);
        aj.j(this.dZW, d.f.icon_pb_fans);
        aj.i(this.dZX, d.C0095d.cp_cont_b);
        this.cyQ.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_little_time), (Drawable) null, (Drawable) null, (Drawable) null);
        return false;
    }
}
