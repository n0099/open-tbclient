package com.baidu.tieba.imMessageCenter.mention;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class b extends com.baidu.tbadk.mvc.g.a<FeedData, com.baidu.tbadk.mvc.d.b> {
    private TextView ahV;
    private View anv;
    private TextView bOB;
    private HeadImageView bUx;
    private TextView beq;

    public b(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.bUx = (HeadImageView) view.findViewById(r.g.photo);
        this.ahV = (TextView) view.findViewById(r.g.user_name);
        this.bOB = (TextView) view.findViewById(r.g.time);
        this.beq = (TextView) view.findViewById(r.g.content);
        this.anv = view.findViewById(r.g.line);
        this.bUx.setOnClickListener(new c(this));
        view.setOnClickListener(new d(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void E(FeedData feedData) {
        super.E(feedData);
        if (feedData.getReplyer() != null) {
            this.ahV.setText(feedData.getReplyer().getName_show());
            this.bUx.setVisibility(0);
            String portrait = feedData.getReplyer().getPortrait();
            this.bUx.setTag(null);
            if (portrait != null && portrait.length() > 0) {
                this.bUx.c(portrait, 12, false);
            } else {
                this.bUx.setImageResource(r.f.photo);
            }
        }
        this.bOB.setText(com.baidu.tbadk.core.util.ax.s(feedData.getTime()));
        this.beq.setText(feedData.getContent());
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.core.util.at.k(getRootView(), r.f.list_selector);
        com.baidu.tbadk.core.util.at.l(this.anv, r.d.cp_bg_line_b);
        if (i == 1) {
            this.bOB.setTextColor(getResources().getColor(r.d.common_color_10071));
            this.beq.setTextColor(getResources().getColor(r.d.common_color_10069));
            this.ahV.setTextColor(getResources().getColor(r.d.cp_cont_c_1));
        } else {
            this.bOB.setTextColor(getResources().getColor(r.d.common_color_10070));
            this.beq.setTextColor(getResources().getColor(r.d.common_color_10235));
            this.ahV.setTextColor(getResources().getColor(r.d.cp_cont_c));
        }
        this.bOB.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.at.getDrawable(r.f.icon_little_time), (Drawable) null, (Drawable) null, (Drawable) null);
        return false;
    }
}
