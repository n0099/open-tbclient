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
    private TextView aQQ;
    private HeadImageView aUc;
    private TextView aYR;
    private TextView bWj;
    private TextView bWk;
    private View mLine;

    public b(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aUc = (HeadImageView) view.findViewById(i.f.photo);
        this.bWj = (TextView) view.findViewById(i.f.add_friend_button);
        this.aYR = (TextView) view.findViewById(i.f.user_name);
        this.aQQ = (TextView) view.findViewById(i.f.time);
        this.bWk = (TextView) view.findViewById(i.f.content);
        this.mLine = view.findViewById(i.f.line);
        this.aUc.setOnClickListener(new c(this));
        this.bWj.setOnClickListener(new d(this));
        view.setOnClickListener(new e(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void B(FeedData feedData) {
        super.B(feedData);
        if (feedData.getReplyer() != null) {
            this.aYR.setText(feedData.getReplyer().getName_show());
            if (feedData.getReplyer().getIsMyFriend() == 1) {
                this.bWj.setVisibility(8);
            } else {
                this.bWj.setVisibility(0);
            }
            this.aUc.setVisibility(0);
            String portrait = feedData.getReplyer().getPortrait();
            this.aUc.setTag(null);
            if (portrait != null && portrait.length() > 0) {
                this.aUc.d(portrait, 12, false);
            } else {
                this.aUc.setImageResource(i.e.photo);
            }
        }
        this.aQQ.setText(com.baidu.tbadk.core.util.aq.m(feedData.getTime()));
        this.bWk.setText(feedData.getContent());
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.core.util.al.h(getRootView(), i.e.list_selector);
        com.baidu.tbadk.core.util.al.i(this.mLine, i.c.cp_bg_line_b);
        if (i == 1) {
            this.aQQ.setTextColor(getResources().getColor(i.c.c_515865));
            this.bWk.setTextColor(getResources().getColor(i.c.c_7b8591));
            this.aYR.setTextColor(getResources().getColor(i.c.cp_cont_c_1));
        } else {
            this.aQQ.setTextColor(getResources().getColor(i.c.c_b2b6ba));
            this.bWk.setTextColor(getResources().getColor(i.c.c_262626));
            this.aYR.setTextColor(getResources().getColor(i.c.cp_cont_c));
        }
        this.bWj.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.al.getDrawable(i.e.icon_friend_add), (Drawable) null, (Drawable) null, (Drawable) null);
        this.aQQ.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.al.getDrawable(i.e.icon_little_time), (Drawable) null, (Drawable) null, (Drawable) null);
        com.baidu.tbadk.core.util.al.b(this.bWj, i.c.cp_link_tip_c, 1);
        return false;
    }
}
