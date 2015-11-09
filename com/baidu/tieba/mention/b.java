package com.baidu.tieba.mention;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class b extends com.baidu.tbadk.mvc.g.a<FeedData, com.baidu.tbadk.mvc.d.b> {
    private TextView aQf;
    private HeadImageView aTr;
    private TextView aZd;
    private TextView caH;
    private TextView caI;
    private View mLine;

    public b(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aTr = (HeadImageView) view.findViewById(i.f.photo);
        this.caH = (TextView) view.findViewById(i.f.add_friend_button);
        this.aZd = (TextView) view.findViewById(i.f.user_name);
        this.aQf = (TextView) view.findViewById(i.f.time);
        this.caI = (TextView) view.findViewById(i.f.content);
        this.mLine = view.findViewById(i.f.line);
        this.aTr.setOnClickListener(new c(this));
        this.caH.setOnClickListener(new d(this));
        view.setOnClickListener(new e(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void B(FeedData feedData) {
        super.B(feedData);
        if (feedData.getReplyer() != null) {
            this.aZd.setText(feedData.getReplyer().getName_show());
            if (feedData.getReplyer().getIsMyFriend() == 1) {
                this.caH.setVisibility(8);
            } else {
                this.caH.setVisibility(0);
            }
            this.aTr.setVisibility(0);
            String portrait = feedData.getReplyer().getPortrait();
            this.aTr.setTag(null);
            if (portrait != null && portrait.length() > 0) {
                this.aTr.d(portrait, 12, false);
            } else {
                this.aTr.setImageResource(i.e.photo);
            }
        }
        this.aQf.setText(com.baidu.tbadk.core.util.as.m(feedData.getTime()));
        this.caI.setText(feedData.getContent());
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.core.util.an.i(getRootView(), i.e.list_selector);
        com.baidu.tbadk.core.util.an.j(this.mLine, i.c.cp_bg_line_b);
        if (i == 1) {
            this.aQf.setTextColor(getResources().getColor(i.c.c_515865));
            this.caI.setTextColor(getResources().getColor(i.c.c_7b8591));
            this.aZd.setTextColor(getResources().getColor(i.c.cp_cont_c_1));
        } else {
            this.aQf.setTextColor(getResources().getColor(i.c.c_b2b6ba));
            this.caI.setTextColor(getResources().getColor(i.c.c_262626));
            this.aZd.setTextColor(getResources().getColor(i.c.cp_cont_c));
        }
        this.caH.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.an.getDrawable(i.e.icon_friend_add), (Drawable) null, (Drawable) null, (Drawable) null);
        this.aQf.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.an.getDrawable(i.e.icon_little_time), (Drawable) null, (Drawable) null, (Drawable) null);
        com.baidu.tbadk.core.util.an.b(this.caH, i.c.cp_link_tip_c, 1);
        return false;
    }
}
