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
    private TextView bTX;
    private TextView eLe;
    private HeadImageView fbT;
    private ImageView gxm;
    private TextView gxn;
    private View mLine;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.fbT = (HeadImageView) view.findViewById(d.g.photo);
        this.fbT.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.bTX = (TextView) view.findViewById(d.g.user_name);
        this.gxm = (ImageView) view.findViewById(d.g.fans_reply);
        this.eLe = (TextView) view.findViewById(d.g.time);
        this.gxn = (TextView) view.findViewById(d.g.content);
        this.mLine = view.findViewById(d.g.line);
        this.fbT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.aoK().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9483, a.this.getData(), null, null));
            }
        });
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.aoK().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9484, a.this.getData(), null, null));
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void af(FeedData feedData) {
        super.af(feedData);
        if (feedData.getReplyer() != null) {
            this.bTX.setText(feedData.getReplyer().getName_show());
            if (feedData.getReplyer().isBigV()) {
                al.j(this.bTX, d.C0236d.cp_cont_r);
            } else {
                al.j(this.bTX, d.C0236d.cp_cont_c);
            }
            this.fbT.setShowV(feedData.getReplyer().isBigV());
            this.fbT.setIsRound(true);
            this.fbT.setVisibility(0);
            String portrait = feedData.getReplyer().getPortrait();
            this.fbT.setTag(null);
            if (portrait != null && portrait.length() > 0) {
                this.fbT.startLoad(portrait, 12, false);
            } else {
                this.fbT.setImageResource(d.f.photo);
            }
            if (feedData.getReplyer().getIsMyFans() == 1) {
                this.gxm.setVisibility(0);
            } else {
                this.gxm.setVisibility(8);
            }
        }
        this.eLe.setText(ap.ao(feedData.getTime()));
        this.gxn.setText(feedData.getContent());
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        al.k(getRootView(), d.f.list_selector);
        al.l(this.mLine, d.C0236d.cp_bg_line_b);
        al.j(this.eLe, d.C0236d.cp_cont_d);
        al.k(this.gxm, d.f.icon_pb_fans);
        al.j(this.gxn, d.C0236d.cp_cont_b);
        this.eLe.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.icon_little_time), (Drawable) null, (Drawable) null, (Drawable) null);
        return false;
    }
}
