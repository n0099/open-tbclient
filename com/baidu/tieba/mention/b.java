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
    private TextView aGK;
    private HeadImageView aIi;
    private TextView aVe;
    private View acX;
    private TextView bCG;
    private TextView byI;

    public b(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aIi = (HeadImageView) view.findViewById(com.baidu.tieba.v.photo);
        this.bCG = (TextView) view.findViewById(com.baidu.tieba.v.add_friend_button);
        this.aVe = (TextView) view.findViewById(com.baidu.tieba.v.user_name);
        this.aGK = (TextView) view.findViewById(com.baidu.tieba.v.time);
        this.byI = (TextView) view.findViewById(com.baidu.tieba.v.content);
        this.acX = view.findViewById(com.baidu.tieba.v.line);
        this.aIi.setOnClickListener(new c(this));
        this.bCG.setOnClickListener(new d(this));
        view.setOnClickListener(new e(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.j.e
    /* renamed from: a */
    public void A(FeedData feedData) {
        super.A(feedData);
        if (feedData.getReplyer() != null) {
            this.aVe.setText(feedData.getReplyer().getName_show());
            if (feedData.getReplyer().getIsMyFriend() == 1) {
                this.bCG.setVisibility(8);
            } else {
                this.bCG.setVisibility(0);
            }
            this.aIi.setVisibility(0);
            String portrait = feedData.getReplyer().getPortrait();
            this.aIi.setTag(null);
            if (portrait != null && portrait.length() > 0) {
                this.aIi.c(portrait, 12, false);
            } else {
                this.aIi.setImageResource(com.baidu.tieba.u.photo);
            }
        }
        this.aGK.setText(bd.n(feedData.getTime()));
        this.byI.setText(feedData.getContent());
    }

    @Override // com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        ba.i(getRootView(), com.baidu.tieba.u.list_selector);
        ba.j(this.acX, com.baidu.tieba.s.cp_bg_line_b);
        if (i == 1) {
            this.aGK.setTextColor(getResources().getColor(com.baidu.tieba.s.c_515865));
            this.byI.setTextColor(getResources().getColor(com.baidu.tieba.s.c_7b8591));
            this.aVe.setTextColor(getResources().getColor(com.baidu.tieba.s.cp_cont_c_1));
        } else {
            this.aGK.setTextColor(getResources().getColor(com.baidu.tieba.s.c_b2b6ba));
            this.byI.setTextColor(getResources().getColor(com.baidu.tieba.s.c_262626));
            this.aVe.setTextColor(getResources().getColor(com.baidu.tieba.s.cp_cont_c));
        }
        this.bCG.setCompoundDrawablesWithIntrinsicBounds(ba.getDrawable(com.baidu.tieba.u.icon_friend_add), (Drawable) null, (Drawable) null, (Drawable) null);
        this.aGK.setCompoundDrawablesWithIntrinsicBounds(ba.getDrawable(com.baidu.tieba.u.icon_little_time), (Drawable) null, (Drawable) null, (Drawable) null);
        ba.b(this.bCG, com.baidu.tieba.s.cp_link_tip_c, 1);
        return false;
    }
}
