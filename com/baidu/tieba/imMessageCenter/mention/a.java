package com.baidu.tieba.imMessageCenter.mention;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.e;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes4.dex */
public class a extends com.baidu.tbadk.mvc.f.a<FeedData, com.baidu.tbadk.mvc.d.b> {
    private TextView aKV;
    private HeadImageView dNy;
    private TextView dxa;
    private ImageView fgs;
    private TextView fgt;
    private View mLine;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.dNy = (HeadImageView) view.findViewById(e.g.photo);
        this.dNy.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.aKV = (TextView) view.findViewById(e.g.user_name);
        this.fgs = (ImageView) view.findViewById(e.g.fans_reply);
        this.dxa = (TextView) view.findViewById(e.g.time);
        this.fgt = (TextView) view.findViewById(e.g.content);
        this.mLine = view.findViewById(e.g.line);
        this.dNy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.OM().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9483, a.this.getData(), null, null));
            }
        });
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.OM().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9484, a.this.getData(), null, null));
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void L(FeedData feedData) {
        super.L(feedData);
        if (feedData.getReplyer() != null) {
            this.aKV.setText(feedData.getReplyer().getName_show());
            if (feedData.getReplyer().isBigV()) {
                al.h(this.aKV, e.d.cp_cont_r);
            } else {
                al.h(this.aKV, e.d.cp_cont_c);
            }
            this.dNy.setShowV(feedData.getReplyer().isBigV());
            this.dNy.setIsRound(true);
            this.dNy.setVisibility(0);
            String portrait = feedData.getReplyer().getPortrait();
            this.dNy.setTag(null);
            if (portrait != null && portrait.length() > 0) {
                this.dNy.startLoad(portrait, 12, false);
            } else {
                this.dNy.setImageResource(e.f.photo);
            }
            if (feedData.getReplyer().getIsMyFans() == 1) {
                this.fgs.setVisibility(0);
            } else {
                this.fgs.setVisibility(8);
            }
        }
        this.dxa.setText(ao.M(feedData.getTime()));
        this.fgt.setText(feedData.getContent());
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        al.i(getRootView(), e.f.list_selector);
        al.j(this.mLine, e.d.cp_bg_line_b);
        al.h(this.dxa, e.d.cp_cont_d);
        al.i(this.fgs, e.f.icon_pb_fans);
        al.h(this.fgt, e.d.cp_cont_b);
        this.dxa.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_little_time), (Drawable) null, (Drawable) null, (Drawable) null);
        return false;
    }
}
