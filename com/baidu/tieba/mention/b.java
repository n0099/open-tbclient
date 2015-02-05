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
    private View Ta;
    private HeadImageView aCm;
    private TextView ayx;
    private TextView bst;
    private TextView bth;
    private TextView bti;

    public b(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aCm = (HeadImageView) view.findViewById(com.baidu.tieba.w.photo);
        this.bti = (TextView) view.findViewById(com.baidu.tieba.w.add_friend_button);
        this.bth = (TextView) view.findViewById(com.baidu.tieba.w.user_name);
        this.ayx = (TextView) view.findViewById(com.baidu.tieba.w.time);
        this.bst = (TextView) view.findViewById(com.baidu.tieba.w.content);
        this.Ta = view.findViewById(com.baidu.tieba.w.line);
        this.aCm.setOnClickListener(new c(this));
        this.bti.setOnClickListener(new d(this));
        view.setOnClickListener(new e(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.j.d
    /* renamed from: a */
    public void y(FeedData feedData) {
        super.y(feedData);
        if (feedData.getReplyer() != null) {
            this.bth.setText(feedData.getReplyer().getName_show());
            if (feedData.getReplyer().getIsMyFriend() == 1) {
                this.bti.setVisibility(8);
            } else {
                this.bti.setVisibility(0);
            }
            this.aCm.setVisibility(0);
            String portrait = feedData.getReplyer().getPortrait();
            this.aCm.setTag(null);
            if (portrait != null && portrait.length() > 0) {
                this.aCm.d(portrait, 12, false);
            } else {
                this.aCm.setImageResource(com.baidu.tieba.v.photo);
            }
        }
        this.ayx.setText(bf.n(feedData.getTime()));
        this.bst.setText(feedData.getContent());
    }

    @Override // com.baidu.tieba.tbadkCore.y
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        bc.i(getRootView(), com.baidu.tieba.v.list_selector);
        bc.j(this.Ta, com.baidu.tieba.t.cp_bg_line_b);
        if (i == 1) {
            this.ayx.setTextColor(getResources().getColor(com.baidu.tieba.t.c_515865));
            this.bst.setTextColor(getResources().getColor(com.baidu.tieba.t.c_7b8591));
            this.bth.setTextColor(getResources().getColor(com.baidu.tieba.t.cp_cont_c_1));
        } else {
            this.ayx.setTextColor(getResources().getColor(com.baidu.tieba.t.c_b2b6ba));
            this.bst.setTextColor(getResources().getColor(com.baidu.tieba.t.c_262626));
            this.bth.setTextColor(getResources().getColor(com.baidu.tieba.t.cp_cont_c));
        }
        this.bti.setCompoundDrawablesWithIntrinsicBounds(bc.getDrawable(com.baidu.tieba.v.icon_friend_add), (Drawable) null, (Drawable) null, (Drawable) null);
        this.ayx.setCompoundDrawablesWithIntrinsicBounds(bc.getDrawable(com.baidu.tieba.v.icon_little_time), (Drawable) null, (Drawable) null, (Drawable) null);
        bc.b(this.bti, com.baidu.tieba.t.cp_link_tip_c, 1);
        return false;
    }
}
