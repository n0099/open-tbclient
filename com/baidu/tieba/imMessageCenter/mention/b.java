package com.baidu.tieba.imMessageCenter.mention;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class b extends com.baidu.tbadk.mvc.g.a<FeedData, com.baidu.tbadk.mvc.d.b> {
    private TextView aVi;
    private HeadImageView aYF;
    private TextView bff;
    private TextView cee;
    private View mLine;

    public b(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aYF = (HeadImageView) view.findViewById(n.f.photo);
        this.bff = (TextView) view.findViewById(n.f.user_name);
        this.aVi = (TextView) view.findViewById(n.f.time);
        this.cee = (TextView) view.findViewById(n.f.content);
        this.mLine = view.findViewById(n.f.line);
        this.aYF.setOnClickListener(new c(this));
        view.setOnClickListener(new d(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void B(FeedData feedData) {
        super.B(feedData);
        if (feedData.getReplyer() != null) {
            this.bff.setText(feedData.getReplyer().getName_show());
            this.aYF.setVisibility(0);
            String portrait = feedData.getReplyer().getPortrait();
            this.aYF.setTag(null);
            if (portrait != null && portrait.length() > 0) {
                this.aYF.d(portrait, 12, false);
            } else {
                this.aYF.setImageResource(n.e.photo);
            }
        }
        this.aVi.setText(com.baidu.tbadk.core.util.ax.s(feedData.getTime()));
        this.cee.setText(feedData.getContent());
    }

    @Override // com.baidu.tieba.tbadkCore.t
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.core.util.as.i(getRootView(), n.e.list_selector);
        com.baidu.tbadk.core.util.as.j(this.mLine, n.c.cp_bg_line_b);
        if (i == 1) {
            this.aVi.setTextColor(getResources().getColor(n.c.c_515865));
            this.cee.setTextColor(getResources().getColor(n.c.c_7b8591));
            this.bff.setTextColor(getResources().getColor(n.c.cp_cont_c_1));
        } else {
            this.aVi.setTextColor(getResources().getColor(n.c.c_b2b6ba));
            this.cee.setTextColor(getResources().getColor(n.c.c_262626));
            this.bff.setTextColor(getResources().getColor(n.c.cp_cont_c));
        }
        this.aVi.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.as.getDrawable(n.e.icon_little_time), (Drawable) null, (Drawable) null, (Drawable) null);
        return false;
    }
}
