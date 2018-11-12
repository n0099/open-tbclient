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
    private TextView aHt;
    private HeadImageView dEl;
    private TextView dnM;
    private ImageView eWM;
    private TextView eWN;
    private View mLine;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.dEl = (HeadImageView) view.findViewById(e.g.photo);
        this.dEl.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.aHt = (TextView) view.findViewById(e.g.user_name);
        this.eWM = (ImageView) view.findViewById(e.g.fans_reply);
        this.dnM = (TextView) view.findViewById(e.g.time);
        this.eWN = (TextView) view.findViewById(e.g.content);
        this.mLine = view.findViewById(e.g.line);
        this.dEl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.NH().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9483, a.this.getData(), null, null));
            }
        });
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.NH().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9484, a.this.getData(), null, null));
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void L(FeedData feedData) {
        super.L(feedData);
        if (feedData.getReplyer() != null) {
            this.aHt.setText(feedData.getReplyer().getName_show());
            if (feedData.getReplyer().isBigV()) {
                al.h(this.aHt, e.d.cp_cont_r);
            } else {
                al.h(this.aHt, e.d.cp_cont_c);
            }
            this.dEl.setShowV(feedData.getReplyer().isBigV());
            this.dEl.setIsRound(true);
            this.dEl.setVisibility(0);
            String portrait = feedData.getReplyer().getPortrait();
            this.dEl.setTag(null);
            if (portrait != null && portrait.length() > 0) {
                this.dEl.startLoad(portrait, 12, false);
            } else {
                this.dEl.setImageResource(e.f.photo);
            }
            if (feedData.getReplyer().getIsMyFans() == 1) {
                this.eWM.setVisibility(0);
            } else {
                this.eWM.setVisibility(8);
            }
        }
        this.dnM.setText(ao.E(feedData.getTime()));
        this.eWN.setText(feedData.getContent());
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        al.i(getRootView(), e.f.list_selector);
        al.j(this.mLine, e.d.cp_bg_line_b);
        al.h(this.dnM, e.d.cp_cont_d);
        al.i(this.eWM, e.f.icon_pb_fans);
        al.h(this.eWN, e.d.cp_cont_b);
        this.dnM.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_little_time), (Drawable) null, (Drawable) null, (Drawable) null);
        return false;
    }
}
