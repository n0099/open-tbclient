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
    private TextView bdn;
    private HeadImageView dDL;
    private TextView dsk;
    private ImageView eNU;
    private TextView eNV;
    private View mLine;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.dDL = (HeadImageView) view.findViewById(d.g.photo);
        this.bdn = (TextView) view.findViewById(d.g.user_name);
        this.eNU = (ImageView) view.findViewById(d.g.fans_reply);
        this.dsk = (TextView) view.findViewById(d.g.time);
        this.eNV = (TextView) view.findViewById(d.g.content);
        this.mLine = view.findViewById(d.g.line);
        this.dDL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.Nf().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9483, a.this.getData(), null, null));
            }
        });
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.Nf().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9484, a.this.getData(), null, null));
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void aI(FeedData feedData) {
        super.aI(feedData);
        if (feedData.getReplyer() != null) {
            this.bdn.setText(feedData.getReplyer().getName_show());
            if (feedData.getReplyer().isBigV()) {
                aj.r(this.bdn, d.C0108d.cp_cont_r);
            } else {
                aj.r(this.bdn, d.C0108d.cp_cont_c);
            }
            this.dDL.setShowV(feedData.getReplyer().isBigV());
            this.dDL.setIsRound(true);
            this.dDL.setVisibility(0);
            String portrait = feedData.getReplyer().getPortrait();
            this.dDL.setTag(null);
            if (portrait != null && portrait.length() > 0) {
                this.dDL.startLoad(portrait, 12, false);
            } else {
                this.dDL.setImageResource(d.f.photo);
            }
            if (feedData.getReplyer().getIsMyFans() == 1) {
                this.eNU.setVisibility(0);
            } else {
                this.eNU.setVisibility(8);
            }
        }
        this.dsk.setText(am.z(feedData.getTime()));
        this.eNV.setText(feedData.getContent());
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        aj.s(getRootView(), d.f.list_selector);
        aj.t(this.mLine, d.C0108d.cp_bg_line_b);
        aj.r(this.dsk, d.C0108d.cp_cont_d);
        aj.s(this.eNU, d.f.icon_pb_fans);
        aj.r(this.eNV, d.C0108d.cp_cont_b);
        this.dsk.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_little_time), (Drawable) null, (Drawable) null, (Drawable) null);
        return false;
    }
}
