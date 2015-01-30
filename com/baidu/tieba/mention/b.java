package com.baidu.tieba.mention;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
public class b extends com.baidu.tbadk.mvc.j.a<FeedData, com.baidu.tbadk.mvc.e.c> {
    private View Td;
    private HeadImageView aCp;
    private TextView ayA;
    private TextView bsu;
    private TextView bti;
    private TextView btj;

    public b(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aCp = (HeadImageView) view.findViewById(com.baidu.tieba.w.photo);
        this.btj = (TextView) view.findViewById(com.baidu.tieba.w.add_friend_button);
        this.bti = (TextView) view.findViewById(com.baidu.tieba.w.user_name);
        this.ayA = (TextView) view.findViewById(com.baidu.tieba.w.time);
        this.bsu = (TextView) view.findViewById(com.baidu.tieba.w.content);
        this.Td = view.findViewById(com.baidu.tieba.w.line);
        this.aCp.setOnClickListener(new c(this));
        this.btj.setOnClickListener(new d(this));
        view.setOnClickListener(new e(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.j.d
    /* renamed from: a */
    public void y(FeedData feedData) {
        super.y(feedData);
        if (feedData.getReplyer() != null) {
            this.bti.setText(feedData.getReplyer().getName_show());
            if (feedData.getReplyer().getIsMyFriend() == 1) {
                this.btj.setVisibility(8);
            } else {
                this.btj.setVisibility(0);
            }
            this.aCp.setVisibility(0);
            String portrait = feedData.getReplyer().getPortrait();
            this.aCp.setTag(null);
            if (portrait != null && portrait.length() > 0) {
                this.aCp.d(portrait, 12, false);
            } else {
                this.aCp.setImageResource(com.baidu.tieba.v.photo);
            }
        }
        this.ayA.setText(bf.n(feedData.getTime()));
        this.bsu.setText(feedData.getContent());
    }

    @Override // com.baidu.tieba.tbadkCore.y
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        bc.i(getRootView(), com.baidu.tieba.v.list_selector);
        bc.j(this.Td, com.baidu.tieba.t.cp_bg_line_b);
        if (i == 1) {
            this.ayA.setTextColor(getResources().getColor(com.baidu.tieba.t.c_515865));
            this.bsu.setTextColor(getResources().getColor(com.baidu.tieba.t.c_7b8591));
            this.bti.setTextColor(getResources().getColor(com.baidu.tieba.t.cp_cont_c_1));
        } else {
            this.ayA.setTextColor(getResources().getColor(com.baidu.tieba.t.c_b2b6ba));
            this.bsu.setTextColor(getResources().getColor(com.baidu.tieba.t.c_262626));
            this.bti.setTextColor(getResources().getColor(com.baidu.tieba.t.cp_cont_c));
        }
        this.btj.setCompoundDrawablesWithIntrinsicBounds(bc.getDrawable(com.baidu.tieba.v.icon_friend_add), (Drawable) null, (Drawable) null, (Drawable) null);
        this.ayA.setCompoundDrawablesWithIntrinsicBounds(bc.getDrawable(com.baidu.tieba.v.icon_little_time), (Drawable) null, (Drawable) null, (Drawable) null);
        bc.b(this.btj, com.baidu.tieba.t.cp_link_tip_c, 1);
        return false;
    }
}
