package com.baidu.tieba.imMessageCenter.mention;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class b extends com.baidu.tbadk.mvc.g.a<FeedData, com.baidu.tbadk.mvc.d.b> {
    private TextView ahN;
    private View amU;
    private TextView bLH;
    private HeadImageView bSr;
    private TextView baU;

    public b(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.bSr = (HeadImageView) view.findViewById(t.g.photo);
        this.ahN = (TextView) view.findViewById(t.g.user_name);
        this.bLH = (TextView) view.findViewById(t.g.time);
        this.baU = (TextView) view.findViewById(t.g.content);
        this.amU = view.findViewById(t.g.line);
        this.bSr.setOnClickListener(new c(this));
        view.setOnClickListener(new d(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void E(FeedData feedData) {
        super.E(feedData);
        if (feedData.getReplyer() != null) {
            this.ahN.setText(feedData.getReplyer().getName_show());
            this.bSr.setVisibility(0);
            String portrait = feedData.getReplyer().getPortrait();
            this.bSr.setTag(null);
            if (portrait != null && portrait.length() > 0) {
                this.bSr.c(portrait, 12, false);
            } else {
                this.bSr.setImageResource(t.f.photo);
            }
        }
        this.bLH.setText(com.baidu.tbadk.core.util.ba.t(feedData.getTime()));
        this.baU.setText(feedData.getContent());
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.core.util.av.k(getRootView(), t.f.list_selector);
        com.baidu.tbadk.core.util.av.l(this.amU, t.d.cp_bg_line_b);
        if (i == 1) {
            this.bLH.setTextColor(getResources().getColor(t.d.common_color_10071));
            this.baU.setTextColor(getResources().getColor(t.d.common_color_10069));
            this.ahN.setTextColor(getResources().getColor(t.d.cp_cont_c_1));
        } else {
            this.bLH.setTextColor(getResources().getColor(t.d.common_color_10070));
            this.baU.setTextColor(getResources().getColor(t.d.common_color_10235));
            this.ahN.setTextColor(getResources().getColor(t.d.cp_cont_c));
        }
        this.bLH.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.av.getDrawable(t.f.icon_little_time), (Drawable) null, (Drawable) null, (Drawable) null);
        return false;
    }
}
