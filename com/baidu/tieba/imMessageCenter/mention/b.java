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
    private TextView ahH;
    private View amq;
    private TextView bbx;
    private HeadImageView beU;
    private TextView cmF;

    public b(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.beU = (HeadImageView) view.findViewById(t.g.photo);
        this.ahH = (TextView) view.findViewById(t.g.user_name);
        this.bbx = (TextView) view.findViewById(t.g.time);
        this.cmF = (TextView) view.findViewById(t.g.content);
        this.amq = view.findViewById(t.g.line);
        this.beU.setOnClickListener(new c(this));
        view.setOnClickListener(new d(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void B(FeedData feedData) {
        super.B(feedData);
        if (feedData.getReplyer() != null) {
            this.ahH.setText(feedData.getReplyer().getName_show());
            this.beU.setVisibility(0);
            String portrait = feedData.getReplyer().getPortrait();
            this.beU.setTag(null);
            if (portrait != null && portrait.length() > 0) {
                this.beU.d(portrait, 12, false);
            } else {
                this.beU.setImageResource(t.f.photo);
            }
        }
        this.bbx.setText(com.baidu.tbadk.core.util.aw.t(feedData.getTime()));
        this.cmF.setText(feedData.getContent());
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.core.util.ar.k(getRootView(), t.f.list_selector);
        com.baidu.tbadk.core.util.ar.l(this.amq, t.d.cp_bg_line_b);
        if (i == 1) {
            this.bbx.setTextColor(getResources().getColor(t.d.c_515865));
            this.cmF.setTextColor(getResources().getColor(t.d.c_7b8591));
            this.ahH.setTextColor(getResources().getColor(t.d.cp_cont_c_1));
        } else {
            this.bbx.setTextColor(getResources().getColor(t.d.c_b2b6ba));
            this.cmF.setTextColor(getResources().getColor(t.d.c_262626));
            this.ahH.setTextColor(getResources().getColor(t.d.cp_cont_c));
        }
        this.bbx.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.ar.getDrawable(t.f.icon_little_time), (Drawable) null, (Drawable) null, (Drawable) null);
        return false;
    }
}
