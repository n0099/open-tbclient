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
    private TextView bcZ;
    private TextView dno;
    private HeadImageView dyP;
    private ImageView eLZ;
    private TextView eMa;
    private View mLine;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.dyP = (HeadImageView) view.findViewById(d.g.photo);
        this.bcZ = (TextView) view.findViewById(d.g.user_name);
        this.eLZ = (ImageView) view.findViewById(d.g.fans_reply);
        this.dno = (TextView) view.findViewById(d.g.time);
        this.eMa = (TextView) view.findViewById(d.g.content);
        this.mLine = view.findViewById(d.g.line);
        this.dyP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.Np().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9483, a.this.getData(), null, null));
            }
        });
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.Np().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9484, a.this.getData(), null, null));
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void aI(FeedData feedData) {
        super.aI(feedData);
        if (feedData.getReplyer() != null) {
            this.bcZ.setText(feedData.getReplyer().getName_show());
            if (feedData.getReplyer().isBigV()) {
                aj.r(this.bcZ, d.C0108d.cp_cont_r);
            } else {
                aj.r(this.bcZ, d.C0108d.cp_cont_c);
            }
            this.dyP.setShowV(feedData.getReplyer().isBigV());
            this.dyP.setIsRound(true);
            this.dyP.setVisibility(0);
            String portrait = feedData.getReplyer().getPortrait();
            this.dyP.setTag(null);
            if (portrait != null && portrait.length() > 0) {
                this.dyP.startLoad(portrait, 12, false);
            } else {
                this.dyP.setImageResource(d.f.photo);
            }
            if (feedData.getReplyer().getIsMyFans() == 1) {
                this.eLZ.setVisibility(0);
            } else {
                this.eLZ.setVisibility(8);
            }
        }
        this.dno.setText(am.z(feedData.getTime()));
        this.eMa.setText(feedData.getContent());
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        aj.s(getRootView(), d.f.list_selector);
        aj.t(this.mLine, d.C0108d.cp_bg_line_b);
        aj.r(this.dno, d.C0108d.cp_cont_d);
        aj.s(this.eLZ, d.f.icon_pb_fans);
        aj.r(this.eMa, d.C0108d.cp_cont_b);
        this.dno.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_little_time), (Drawable) null, (Drawable) null, (Drawable) null);
        return false;
    }
}
