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
    private TextView ahM;
    private View amH;
    private TextView bgh;
    private HeadImageView bjG;
    private TextView cxh;

    public b(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.bjG = (HeadImageView) view.findViewById(t.g.photo);
        this.ahM = (TextView) view.findViewById(t.g.user_name);
        this.bgh = (TextView) view.findViewById(t.g.time);
        this.cxh = (TextView) view.findViewById(t.g.content);
        this.amH = view.findViewById(t.g.line);
        this.bjG.setOnClickListener(new c(this));
        view.setOnClickListener(new d(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void B(FeedData feedData) {
        super.B(feedData);
        if (feedData.getReplyer() != null) {
            this.ahM.setText(feedData.getReplyer().getName_show());
            this.bjG.setVisibility(0);
            String portrait = feedData.getReplyer().getPortrait();
            this.bjG.setTag(null);
            if (portrait != null && portrait.length() > 0) {
                this.bjG.c(portrait, 12, false);
            } else {
                this.bjG.setImageResource(t.f.photo);
            }
        }
        this.bgh.setText(com.baidu.tbadk.core.util.ay.w(feedData.getTime()));
        this.cxh.setText(feedData.getContent());
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.core.util.at.k(getRootView(), t.f.list_selector);
        com.baidu.tbadk.core.util.at.l(this.amH, t.d.cp_bg_line_b);
        if (i == 1) {
            this.bgh.setTextColor(getResources().getColor(t.d.c_515865));
            this.cxh.setTextColor(getResources().getColor(t.d.c_7b8591));
            this.ahM.setTextColor(getResources().getColor(t.d.cp_cont_c_1));
        } else {
            this.bgh.setTextColor(getResources().getColor(t.d.c_b2b6ba));
            this.cxh.setTextColor(getResources().getColor(t.d.c_262626));
            this.ahM.setTextColor(getResources().getColor(t.d.cp_cont_c));
        }
        this.bgh.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.at.getDrawable(t.f.icon_little_time), (Drawable) null, (Drawable) null, (Drawable) null);
        return false;
    }
}
