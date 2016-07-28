package com.baidu.tieba.imMessageCenter.mention;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class b extends com.baidu.tbadk.mvc.g.a<FeedData, com.baidu.tbadk.mvc.d.b> {
    private TextView aeS;
    private View ajP;
    private TextView bAf;
    private HeadImageView bHl;
    private TextView dgx;

    public b(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.bHl = (HeadImageView) view.findViewById(u.g.photo);
        this.aeS = (TextView) view.findViewById(u.g.user_name);
        this.bAf = (TextView) view.findViewById(u.g.time);
        this.dgx = (TextView) view.findViewById(u.g.content);
        this.ajP = view.findViewById(u.g.line);
        this.bHl.setOnClickListener(new c(this));
        view.setOnClickListener(new d(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void E(FeedData feedData) {
        super.E(feedData);
        if (feedData.getReplyer() != null) {
            this.aeS.setText(feedData.getReplyer().getName_show());
            this.bHl.setVisibility(0);
            String portrait = feedData.getReplyer().getPortrait();
            this.bHl.setTag(null);
            if (portrait != null && portrait.length() > 0) {
                this.bHl.c(portrait, 12, false);
            } else {
                this.bHl.setImageResource(u.f.photo);
            }
        }
        this.bAf.setText(com.baidu.tbadk.core.util.ba.t(feedData.getTime()));
        this.dgx.setText(feedData.getContent());
    }

    @Override // com.baidu.tieba.tbadkCore.t
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.core.util.av.k(getRootView(), u.f.list_selector);
        com.baidu.tbadk.core.util.av.l(this.ajP, u.d.cp_bg_line_b);
        if (i == 1) {
            this.bAf.setTextColor(getResources().getColor(u.d.common_color_10071));
            this.dgx.setTextColor(getResources().getColor(u.d.common_color_10069));
            this.aeS.setTextColor(getResources().getColor(u.d.cp_cont_c_1));
        } else {
            this.bAf.setTextColor(getResources().getColor(u.d.common_color_10070));
            this.dgx.setTextColor(getResources().getColor(u.d.common_color_10235));
            this.aeS.setTextColor(getResources().getColor(u.d.cp_cont_c));
        }
        this.bAf.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.av.getDrawable(u.f.icon_little_time), (Drawable) null, (Drawable) null, (Drawable) null);
        return false;
    }
}
