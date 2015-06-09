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
    private TextView aJb;
    private HeadImageView aKz;
    private TextView aYa;
    private TextView bFO;
    private TextView bFP;
    private View mLine;

    public b(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aKz = (HeadImageView) view.findViewById(com.baidu.tieba.q.photo);
        this.bFO = (TextView) view.findViewById(com.baidu.tieba.q.add_friend_button);
        this.aYa = (TextView) view.findViewById(com.baidu.tieba.q.user_name);
        this.aJb = (TextView) view.findViewById(com.baidu.tieba.q.time);
        this.bFP = (TextView) view.findViewById(com.baidu.tieba.q.content);
        this.mLine = view.findViewById(com.baidu.tieba.q.line);
        this.aKz.setOnClickListener(new c(this));
        this.bFO.setOnClickListener(new d(this));
        view.setOnClickListener(new e(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.j.e
    /* renamed from: a */
    public void z(FeedData feedData) {
        super.z(feedData);
        if (feedData.getReplyer() != null) {
            this.aYa.setText(feedData.getReplyer().getName_show());
            if (feedData.getReplyer().getIsMyFriend() == 1) {
                this.bFO.setVisibility(8);
            } else {
                this.bFO.setVisibility(0);
            }
            this.aKz.setVisibility(0);
            String portrait = feedData.getReplyer().getPortrait();
            this.aKz.setTag(null);
            if (portrait != null && portrait.length() > 0) {
                this.aKz.c(portrait, 12, false);
            } else {
                this.aKz.setImageResource(com.baidu.tieba.p.photo);
            }
        }
        this.aJb.setText(bb.o(feedData.getTime()));
        this.bFP.setText(feedData.getContent());
    }

    @Override // com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        ay.i(getRootView(), com.baidu.tieba.p.list_selector);
        ay.j(this.mLine, com.baidu.tieba.n.cp_bg_line_b);
        if (i == 1) {
            this.aJb.setTextColor(getResources().getColor(com.baidu.tieba.n.c_515865));
            this.bFP.setTextColor(getResources().getColor(com.baidu.tieba.n.c_7b8591));
            this.aYa.setTextColor(getResources().getColor(com.baidu.tieba.n.cp_cont_c_1));
        } else {
            this.aJb.setTextColor(getResources().getColor(com.baidu.tieba.n.c_b2b6ba));
            this.bFP.setTextColor(getResources().getColor(com.baidu.tieba.n.c_262626));
            this.aYa.setTextColor(getResources().getColor(com.baidu.tieba.n.cp_cont_c));
        }
        this.bFO.setCompoundDrawablesWithIntrinsicBounds(ay.getDrawable(com.baidu.tieba.p.icon_friend_add), (Drawable) null, (Drawable) null, (Drawable) null);
        this.aJb.setCompoundDrawablesWithIntrinsicBounds(ay.getDrawable(com.baidu.tieba.p.icon_little_time), (Drawable) null, (Drawable) null, (Drawable) null);
        ay.b(this.bFO, com.baidu.tieba.n.cp_link_tip_c, 1);
        return false;
    }
}
