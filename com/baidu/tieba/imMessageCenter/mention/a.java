package com.baidu.tieba.imMessageCenter.mention;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.view.View;
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
    private View aXa;
    private TextView apl;
    private TextView cih;
    private HeadImageView crk;
    private TextView dMk;

    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.crk = (HeadImageView) view.findViewById(d.h.photo);
        this.apl = (TextView) view.findViewById(d.h.user_name);
        this.cih = (TextView) view.findViewById(d.h.time);
        this.dMk = (TextView) view.findViewById(d.h.content);
        this.aXa = view.findViewById(d.h.line);
        this.crk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.FL().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9483, a.this.getData(), null, null));
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
                a.this.FL().dispatchMvcEvent(bVar);
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void D(FeedData feedData) {
        super.D(feedData);
        if (feedData.getReplyer() != null) {
            this.apl.setText(feedData.getReplyer().getName_show());
            if (feedData.getReplyer().isBigV()) {
                aj.i(this.apl, d.e.cp_cont_r);
            } else {
                aj.i(this.apl, d.e.cp_cont_c);
            }
            this.crk.setShowV(feedData.getReplyer().isBigV());
            this.crk.setIsRound(true);
            this.crk.setVisibility(0);
            String portrait = feedData.getReplyer().getPortrait();
            this.crk.setTag(null);
            if (portrait != null && portrait.length() > 0) {
                this.crk.c(portrait, 12, false);
            } else {
                this.crk.setImageResource(d.g.photo);
            }
        }
        this.cih.setText(am.r(feedData.getTime()));
        this.dMk.setText(feedData.getContent());
    }

    @Override // com.baidu.tieba.tbadkCore.l
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        aj.j(getRootView(), d.g.list_selector);
        aj.k(this.aXa, d.e.cp_bg_line_b);
        if (i == 1) {
            this.cih.setTextColor(getResources().getColor(d.e.common_color_10071));
            this.dMk.setTextColor(getResources().getColor(d.e.common_color_10069));
        } else {
            this.cih.setTextColor(getResources().getColor(d.e.common_color_10070));
            this.dMk.setTextColor(getResources().getColor(d.e.common_color_10235));
        }
        this.cih.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.g.icon_little_time), (Drawable) null, (Drawable) null, (Drawable) null);
        return false;
    }
}
