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
    private TextView ahv;
    private View amC;
    private TextView bLI;
    private HeadImageView bSk;
    private TextView bbl;

    public b(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.bSk = (HeadImageView) view.findViewById(r.g.photo);
        this.ahv = (TextView) view.findViewById(r.g.user_name);
        this.bLI = (TextView) view.findViewById(r.g.time);
        this.bbl = (TextView) view.findViewById(r.g.content);
        this.amC = view.findViewById(r.g.line);
        this.bSk.setOnClickListener(new c(this));
        view.setOnClickListener(new d(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void E(FeedData feedData) {
        super.E(feedData);
        if (feedData.getReplyer() != null) {
            this.ahv.setText(feedData.getReplyer().getName_show());
            this.bSk.setVisibility(0);
            String portrait = feedData.getReplyer().getPortrait();
            this.bSk.setTag(null);
            if (portrait != null && portrait.length() > 0) {
                this.bSk.c(portrait, 12, false);
            } else {
                this.bSk.setImageResource(r.f.photo);
            }
        }
        this.bLI.setText(com.baidu.tbadk.core.util.az.t(feedData.getTime()));
        this.bbl.setText(feedData.getContent());
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.core.util.av.k(getRootView(), r.f.list_selector);
        com.baidu.tbadk.core.util.av.l(this.amC, r.d.cp_bg_line_b);
        if (i == 1) {
            this.bLI.setTextColor(getResources().getColor(r.d.common_color_10071));
            this.bbl.setTextColor(getResources().getColor(r.d.common_color_10069));
            this.ahv.setTextColor(getResources().getColor(r.d.cp_cont_c_1));
        } else {
            this.bLI.setTextColor(getResources().getColor(r.d.common_color_10070));
            this.bbl.setTextColor(getResources().getColor(r.d.common_color_10235));
            this.ahv.setTextColor(getResources().getColor(r.d.cp_cont_c));
        }
        this.bLI.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.av.getDrawable(r.f.icon_little_time), (Drawable) null, (Drawable) null, (Drawable) null);
        return false;
    }
}
