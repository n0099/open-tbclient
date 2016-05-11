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
    private TextView adG;
    private View aiu;
    private TextView bbW;
    private HeadImageView bfG;
    private TextView cyf;

    public b(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.bfG = (HeadImageView) view.findViewById(t.g.photo);
        this.adG = (TextView) view.findViewById(t.g.user_name);
        this.bbW = (TextView) view.findViewById(t.g.time);
        this.cyf = (TextView) view.findViewById(t.g.content);
        this.aiu = view.findViewById(t.g.line);
        this.bfG.setOnClickListener(new c(this));
        view.setOnClickListener(new d(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void B(FeedData feedData) {
        super.B(feedData);
        if (feedData.getReplyer() != null) {
            this.adG.setText(feedData.getReplyer().getName_show());
            this.bfG.setVisibility(0);
            String portrait = feedData.getReplyer().getPortrait();
            this.bfG.setTag(null);
            if (portrait != null && portrait.length() > 0) {
                this.bfG.c(portrait, 12, false);
            } else {
                this.bfG.setImageResource(t.f.photo);
            }
        }
        this.bbW.setText(com.baidu.tbadk.core.util.ay.x(feedData.getTime()));
        this.cyf.setText(feedData.getContent());
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.core.util.at.k(getRootView(), t.f.list_selector);
        com.baidu.tbadk.core.util.at.l(this.aiu, t.d.cp_bg_line_b);
        if (i == 1) {
            this.bbW.setTextColor(getResources().getColor(t.d.c_515865));
            this.cyf.setTextColor(getResources().getColor(t.d.c_7b8591));
            this.adG.setTextColor(getResources().getColor(t.d.cp_cont_c_1));
        } else {
            this.bbW.setTextColor(getResources().getColor(t.d.c_b2b6ba));
            this.cyf.setTextColor(getResources().getColor(t.d.c_262626));
            this.adG.setTextColor(getResources().getColor(t.d.cp_cont_c));
        }
        this.bbW.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.at.getDrawable(t.f.icon_little_time), (Drawable) null, (Drawable) null, (Drawable) null);
        return false;
    }
}
