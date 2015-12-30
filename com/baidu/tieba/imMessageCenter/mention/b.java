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
    private TextView aZi;
    private TextView agS;
    private HeadImageView bcC;
    private TextView cif;
    private View mLine;

    public b(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.bcC = (HeadImageView) view.findViewById(n.g.photo);
        this.agS = (TextView) view.findViewById(n.g.user_name);
        this.aZi = (TextView) view.findViewById(n.g.time);
        this.cif = (TextView) view.findViewById(n.g.content);
        this.mLine = view.findViewById(n.g.line);
        this.bcC.setOnClickListener(new c(this));
        view.setOnClickListener(new d(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void B(FeedData feedData) {
        super.B(feedData);
        if (feedData.getReplyer() != null) {
            this.agS.setText(feedData.getReplyer().getName_show());
            this.bcC.setVisibility(0);
            String portrait = feedData.getReplyer().getPortrait();
            this.bcC.setTag(null);
            if (portrait != null && portrait.length() > 0) {
                this.bcC.d(portrait, 12, false);
            } else {
                this.bcC.setImageResource(n.f.photo);
            }
        }
        this.aZi.setText(com.baidu.tbadk.core.util.ax.s(feedData.getTime()));
        this.cif.setText(feedData.getContent());
    }

    @Override // com.baidu.tieba.tbadkCore.t
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.core.util.as.i(getRootView(), n.f.list_selector);
        com.baidu.tbadk.core.util.as.j(this.mLine, n.d.cp_bg_line_b);
        if (i == 1) {
            this.aZi.setTextColor(getResources().getColor(n.d.c_515865));
            this.cif.setTextColor(getResources().getColor(n.d.c_7b8591));
            this.agS.setTextColor(getResources().getColor(n.d.cp_cont_c_1));
        } else {
            this.aZi.setTextColor(getResources().getColor(n.d.c_b2b6ba));
            this.cif.setTextColor(getResources().getColor(n.d.c_262626));
            this.agS.setTextColor(getResources().getColor(n.d.cp_cont_c));
        }
        this.aZi.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.as.getDrawable(n.f.icon_little_time), (Drawable) null, (Drawable) null, (Drawable) null);
        return false;
    }
}
