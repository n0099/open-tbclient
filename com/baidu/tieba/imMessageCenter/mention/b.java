package com.baidu.tieba.imMessageCenter.mention;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class b extends com.baidu.tbadk.mvc.f.a<FeedData, com.baidu.tbadk.mvc.d.b> {
    private TextView ahw;
    private View amY;
    private HeadImageView bAJ;
    private TextView bdI;
    private TextView buG;

    public b(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.bAJ = (HeadImageView) view.findViewById(r.g.photo);
        this.ahw = (TextView) view.findViewById(r.g.user_name);
        this.buG = (TextView) view.findViewById(r.g.time);
        this.bdI = (TextView) view.findViewById(r.g.content);
        this.amY = view.findViewById(r.g.line);
        this.bAJ.setOnClickListener(new c(this));
        view.setOnClickListener(new d(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void E(FeedData feedData) {
        super.E(feedData);
        if (feedData.getReplyer() != null) {
            this.ahw.setText(feedData.getReplyer().getName_show());
            this.bAJ.setVisibility(0);
            String portrait = feedData.getReplyer().getPortrait();
            this.bAJ.setTag(null);
            if (portrait != null && portrait.length() > 0) {
                this.bAJ.c(portrait, 12, false);
            } else {
                this.bAJ.setImageResource(r.f.photo);
            }
        }
        this.buG.setText(com.baidu.tbadk.core.util.av.s(feedData.getTime()));
        this.bdI.setText(feedData.getContent());
    }

    @Override // com.baidu.tieba.tbadkCore.r
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.core.util.ar.k(getRootView(), r.f.list_selector);
        com.baidu.tbadk.core.util.ar.l(this.amY, r.d.cp_bg_line_b);
        if (i == 1) {
            this.buG.setTextColor(getResources().getColor(r.d.common_color_10071));
            this.bdI.setTextColor(getResources().getColor(r.d.common_color_10069));
            this.ahw.setTextColor(getResources().getColor(r.d.cp_cont_c_1));
        } else {
            this.buG.setTextColor(getResources().getColor(r.d.common_color_10070));
            this.bdI.setTextColor(getResources().getColor(r.d.common_color_10235));
            this.ahw.setTextColor(getResources().getColor(r.d.cp_cont_c));
        }
        this.buG.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.ar.getDrawable(r.f.icon_little_time), (Drawable) null, (Drawable) null, (Drawable) null);
        return false;
    }
}
