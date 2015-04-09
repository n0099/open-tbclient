package com.baidu.tieba.mention;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
public class b extends com.baidu.tbadk.mvc.j.a<FeedData, com.baidu.tbadk.mvc.e.c> {
    private TextView aGS;
    private HeadImageView aIq;
    private TextView aVt;
    private View adg;
    private TextView bCT;
    private TextView byT;

    public b(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aIq = (HeadImageView) view.findViewById(com.baidu.tieba.v.photo);
        this.bCT = (TextView) view.findViewById(com.baidu.tieba.v.add_friend_button);
        this.aVt = (TextView) view.findViewById(com.baidu.tieba.v.user_name);
        this.aGS = (TextView) view.findViewById(com.baidu.tieba.v.time);
        this.byT = (TextView) view.findViewById(com.baidu.tieba.v.content);
        this.adg = view.findViewById(com.baidu.tieba.v.line);
        this.aIq.setOnClickListener(new c(this));
        this.bCT.setOnClickListener(new d(this));
        view.setOnClickListener(new e(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.j.e
    /* renamed from: a */
    public void A(FeedData feedData) {
        super.A(feedData);
        if (feedData.getReplyer() != null) {
            this.aVt.setText(feedData.getReplyer().getName_show());
            if (feedData.getReplyer().getIsMyFriend() == 1) {
                this.bCT.setVisibility(8);
            } else {
                this.bCT.setVisibility(0);
            }
            this.aIq.setVisibility(0);
            String portrait = feedData.getReplyer().getPortrait();
            this.aIq.setTag(null);
            if (portrait != null && portrait.length() > 0) {
                this.aIq.c(portrait, 12, false);
            } else {
                this.aIq.setImageResource(com.baidu.tieba.u.photo);
            }
        }
        this.aGS.setText(bd.n(feedData.getTime()));
        this.byT.setText(feedData.getContent());
    }

    @Override // com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        ba.i(getRootView(), com.baidu.tieba.u.list_selector);
        ba.j(this.adg, com.baidu.tieba.s.cp_bg_line_b);
        if (i == 1) {
            this.aGS.setTextColor(getResources().getColor(com.baidu.tieba.s.c_515865));
            this.byT.setTextColor(getResources().getColor(com.baidu.tieba.s.c_7b8591));
            this.aVt.setTextColor(getResources().getColor(com.baidu.tieba.s.cp_cont_c_1));
        } else {
            this.aGS.setTextColor(getResources().getColor(com.baidu.tieba.s.c_b2b6ba));
            this.byT.setTextColor(getResources().getColor(com.baidu.tieba.s.c_262626));
            this.aVt.setTextColor(getResources().getColor(com.baidu.tieba.s.cp_cont_c));
        }
        this.bCT.setCompoundDrawablesWithIntrinsicBounds(ba.getDrawable(com.baidu.tieba.u.icon_friend_add), (Drawable) null, (Drawable) null, (Drawable) null);
        this.aGS.setCompoundDrawablesWithIntrinsicBounds(ba.getDrawable(com.baidu.tieba.u.icon_little_time), (Drawable) null, (Drawable) null, (Drawable) null);
        ba.b(this.bCT, com.baidu.tieba.s.cp_link_tip_c, 1);
        return false;
    }
}
