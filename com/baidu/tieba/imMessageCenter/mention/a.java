package com.baidu.tieba.imMessageCenter.mention;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.d;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes4.dex */
public class a extends com.baidu.tbadk.mvc.f.a<FeedData, com.baidu.tbadk.mvc.d.b> {
    private TextView bTY;
    private TextView eLa;
    private HeadImageView fbS;
    private ImageView gxm;
    private TextView gxn;
    private View mLine;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.fbS = (HeadImageView) view.findViewById(d.g.photo);
        this.fbS.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.bTY = (TextView) view.findViewById(d.g.user_name);
        this.gxm = (ImageView) view.findViewById(d.g.fans_reply);
        this.eLa = (TextView) view.findViewById(d.g.time);
        this.gxn = (TextView) view.findViewById(d.g.content);
        this.mLine = view.findViewById(d.g.line);
        this.fbS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.aoJ().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9483, a.this.getData(), null, null));
            }
        });
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.aoJ().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9484, a.this.getData(), null, null));
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void af(FeedData feedData) {
        super.af(feedData);
        if (feedData.getReplyer() != null) {
            this.bTY.setText(feedData.getReplyer().getName_show());
            if (feedData.getReplyer().isBigV()) {
                al.j(this.bTY, d.C0277d.cp_cont_r);
            } else {
                al.j(this.bTY, d.C0277d.cp_cont_c);
            }
            this.fbS.setShowV(feedData.getReplyer().isBigV());
            this.fbS.setIsRound(true);
            this.fbS.setVisibility(0);
            String portrait = feedData.getReplyer().getPortrait();
            this.fbS.setTag(null);
            if (portrait != null && portrait.length() > 0) {
                this.fbS.startLoad(portrait, 12, false);
            } else {
                this.fbS.setImageResource(d.f.photo);
            }
            if (feedData.getReplyer().getIsMyFans() == 1) {
                this.gxm.setVisibility(0);
            } else {
                this.gxm.setVisibility(8);
            }
        }
        this.eLa.setText(ap.ao(feedData.getTime()));
        this.gxn.setText(feedData.getContent());
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        al.k(getRootView(), d.f.list_selector);
        al.l(this.mLine, d.C0277d.cp_bg_line_b);
        al.j(this.eLa, d.C0277d.cp_cont_d);
        al.k(this.gxm, d.f.icon_pb_fans);
        al.j(this.gxn, d.C0277d.cp_cont_b);
        this.eLa.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.icon_little_time), (Drawable) null, (Drawable) null, (Drawable) null);
        return false;
    }
}
