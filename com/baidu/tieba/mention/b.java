package com.baidu.tieba.mention;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
public class b extends com.baidu.tbadk.mvc.j.a<FeedData, com.baidu.tbadk.mvc.e.c> {
    private TextView aJa;
    private HeadImageView aKy;
    private TextView aXZ;
    private TextView bFN;
    private TextView bFO;
    private View mLine;

    public b(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aKy = (HeadImageView) view.findViewById(com.baidu.tieba.q.photo);
        this.bFN = (TextView) view.findViewById(com.baidu.tieba.q.add_friend_button);
        this.aXZ = (TextView) view.findViewById(com.baidu.tieba.q.user_name);
        this.aJa = (TextView) view.findViewById(com.baidu.tieba.q.time);
        this.bFO = (TextView) view.findViewById(com.baidu.tieba.q.content);
        this.mLine = view.findViewById(com.baidu.tieba.q.line);
        this.aKy.setOnClickListener(new c(this));
        this.bFN.setOnClickListener(new d(this));
        view.setOnClickListener(new e(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.j.e
    /* renamed from: a */
    public void z(FeedData feedData) {
        super.z(feedData);
        if (feedData.getReplyer() != null) {
            this.aXZ.setText(feedData.getReplyer().getName_show());
            if (feedData.getReplyer().getIsMyFriend() == 1) {
                this.bFN.setVisibility(8);
            } else {
                this.bFN.setVisibility(0);
            }
            this.aKy.setVisibility(0);
            String portrait = feedData.getReplyer().getPortrait();
            this.aKy.setTag(null);
            if (portrait != null && portrait.length() > 0) {
                this.aKy.c(portrait, 12, false);
            } else {
                this.aKy.setImageResource(com.baidu.tieba.p.photo);
            }
        }
        this.aJa.setText(bb.o(feedData.getTime()));
        this.bFO.setText(feedData.getContent());
    }

    @Override // com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        ay.i(getRootView(), com.baidu.tieba.p.list_selector);
        ay.j(this.mLine, com.baidu.tieba.n.cp_bg_line_b);
        if (i == 1) {
            this.aJa.setTextColor(getResources().getColor(com.baidu.tieba.n.c_515865));
            this.bFO.setTextColor(getResources().getColor(com.baidu.tieba.n.c_7b8591));
            this.aXZ.setTextColor(getResources().getColor(com.baidu.tieba.n.cp_cont_c_1));
        } else {
            this.aJa.setTextColor(getResources().getColor(com.baidu.tieba.n.c_b2b6ba));
            this.bFO.setTextColor(getResources().getColor(com.baidu.tieba.n.c_262626));
            this.aXZ.setTextColor(getResources().getColor(com.baidu.tieba.n.cp_cont_c));
        }
        this.bFN.setCompoundDrawablesWithIntrinsicBounds(ay.getDrawable(com.baidu.tieba.p.icon_friend_add), (Drawable) null, (Drawable) null, (Drawable) null);
        this.aJa.setCompoundDrawablesWithIntrinsicBounds(ay.getDrawable(com.baidu.tieba.p.icon_little_time), (Drawable) null, (Drawable) null, (Drawable) null);
        ay.b(this.bFN, com.baidu.tieba.n.cp_link_tip_c, 1);
        return false;
    }
}
