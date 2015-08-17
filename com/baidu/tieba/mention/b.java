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
    private TextView aQC;
    private HeadImageView aTO;
    private TextView aYA;
    private TextView bVD;
    private TextView bVE;
    private View mLine;

    public b(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aTO = (HeadImageView) view.findViewById(i.f.photo);
        this.bVD = (TextView) view.findViewById(i.f.add_friend_button);
        this.aYA = (TextView) view.findViewById(i.f.user_name);
        this.aQC = (TextView) view.findViewById(i.f.time);
        this.bVE = (TextView) view.findViewById(i.f.content);
        this.mLine = view.findViewById(i.f.line);
        this.aTO.setOnClickListener(new c(this));
        this.bVD.setOnClickListener(new d(this));
        view.setOnClickListener(new e(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void A(FeedData feedData) {
        super.A(feedData);
        if (feedData.getReplyer() != null) {
            this.aYA.setText(feedData.getReplyer().getName_show());
            if (feedData.getReplyer().getIsMyFriend() == 1) {
                this.bVD.setVisibility(8);
            } else {
                this.bVD.setVisibility(0);
            }
            this.aTO.setVisibility(0);
            String portrait = feedData.getReplyer().getPortrait();
            this.aTO.setTag(null);
            if (portrait != null && portrait.length() > 0) {
                this.aTO.d(portrait, 12, false);
            } else {
                this.aTO.setImageResource(i.e.photo);
            }
        }
        this.aQC.setText(com.baidu.tbadk.core.util.aq.m(feedData.getTime()));
        this.bVE.setText(feedData.getContent());
    }

    @Override // com.baidu.tieba.tbadkCore.r
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.core.util.al.i(getRootView(), i.e.list_selector);
        com.baidu.tbadk.core.util.al.j(this.mLine, i.c.cp_bg_line_b);
        if (i == 1) {
            this.aQC.setTextColor(getResources().getColor(i.c.c_515865));
            this.bVE.setTextColor(getResources().getColor(i.c.c_7b8591));
            this.aYA.setTextColor(getResources().getColor(i.c.cp_cont_c_1));
        } else {
            this.aQC.setTextColor(getResources().getColor(i.c.c_b2b6ba));
            this.bVE.setTextColor(getResources().getColor(i.c.c_262626));
            this.aYA.setTextColor(getResources().getColor(i.c.cp_cont_c));
        }
        this.bVD.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.al.getDrawable(i.e.icon_friend_add), (Drawable) null, (Drawable) null, (Drawable) null);
        this.aQC.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.al.getDrawable(i.e.icon_little_time), (Drawable) null, (Drawable) null, (Drawable) null);
        com.baidu.tbadk.core.util.al.b(this.bVD, i.c.cp_link_tip_c, 1);
        return false;
    }
}
