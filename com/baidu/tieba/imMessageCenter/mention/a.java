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
/* loaded from: classes2.dex */
public class a extends com.baidu.tbadk.mvc.f.a<FeedData, com.baidu.tbadk.mvc.d.b> {
    private TextView aBX;
    private TextView deC;
    private HeadImageView duU;
    private ImageView eNL;
    private TextView eNM;
    private View mLine;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.duU = (HeadImageView) view.findViewById(e.g.photo);
        this.duU.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.aBX = (TextView) view.findViewById(e.g.user_name);
        this.eNL = (ImageView) view.findViewById(e.g.fans_reply);
        this.deC = (TextView) view.findViewById(e.g.time);
        this.eNM = (TextView) view.findViewById(e.g.content);
        this.mLine = view.findViewById(e.g.line);
        this.duU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.LA().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9483, a.this.getData(), null, null));
            }
        });
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.LA().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9484, a.this.getData(), null, null));
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void H(FeedData feedData) {
        super.H(feedData);
        if (feedData.getReplyer() != null) {
            this.aBX.setText(feedData.getReplyer().getName_show());
            if (feedData.getReplyer().isBigV()) {
                al.h(this.aBX, e.d.cp_cont_r);
            } else {
                al.h(this.aBX, e.d.cp_cont_c);
            }
            this.duU.setShowV(feedData.getReplyer().isBigV());
            this.duU.setIsRound(true);
            this.duU.setVisibility(0);
            String portrait = feedData.getReplyer().getPortrait();
            this.duU.setTag(null);
            if (portrait != null && portrait.length() > 0) {
                this.duU.startLoad(portrait, 12, false);
            } else {
                this.duU.setImageResource(e.f.photo);
            }
            if (feedData.getReplyer().getIsMyFans() == 1) {
                this.eNL.setVisibility(0);
            } else {
                this.eNL.setVisibility(8);
            }
        }
        this.deC.setText(ao.A(feedData.getTime()));
        this.eNM.setText(feedData.getContent());
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        al.i(getRootView(), e.f.list_selector);
        al.j(this.mLine, e.d.cp_bg_line_b);
        al.h(this.deC, e.d.cp_cont_d);
        al.i(this.eNL, e.f.icon_pb_fans);
        al.h(this.eNM, e.d.cp_cont_b);
        this.deC.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_little_time), (Drawable) null, (Drawable) null, (Drawable) null);
        return false;
    }
}
