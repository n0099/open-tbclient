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
    private TextView aPX;
    private HeadImageView aTj;
    private TextView aYR;
    private TextView cag;
    private TextView cah;
    private View mLine;

    public b(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aTj = (HeadImageView) view.findViewById(i.f.photo);
        this.cag = (TextView) view.findViewById(i.f.add_friend_button);
        this.aYR = (TextView) view.findViewById(i.f.user_name);
        this.aPX = (TextView) view.findViewById(i.f.time);
        this.cah = (TextView) view.findViewById(i.f.content);
        this.mLine = view.findViewById(i.f.line);
        this.aTj.setOnClickListener(new c(this));
        this.cag.setOnClickListener(new d(this));
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
                this.cag.setVisibility(8);
            } else {
                this.cag.setVisibility(0);
            }
            this.aTj.setVisibility(0);
            String portrait = feedData.getReplyer().getPortrait();
            this.aTj.setTag(null);
            if (portrait != null && portrait.length() > 0) {
                this.aTj.d(portrait, 12, false);
            } else {
                this.aTj.setImageResource(i.e.photo);
            }
        }
        this.aPX.setText(com.baidu.tbadk.core.util.as.m(feedData.getTime()));
        this.cah.setText(feedData.getContent());
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.core.util.an.i(getRootView(), i.e.list_selector);
        com.baidu.tbadk.core.util.an.j(this.mLine, i.c.cp_bg_line_b);
        if (i == 1) {
            this.aPX.setTextColor(getResources().getColor(i.c.c_515865));
            this.cah.setTextColor(getResources().getColor(i.c.c_7b8591));
            this.aYR.setTextColor(getResources().getColor(i.c.cp_cont_c_1));
        } else {
            this.aPX.setTextColor(getResources().getColor(i.c.c_b2b6ba));
            this.cah.setTextColor(getResources().getColor(i.c.c_262626));
            this.aYR.setTextColor(getResources().getColor(i.c.cp_cont_c));
        }
        this.cag.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.an.getDrawable(i.e.icon_friend_add), (Drawable) null, (Drawable) null, (Drawable) null);
        this.aPX.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.an.getDrawable(i.e.icon_little_time), (Drawable) null, (Drawable) null, (Drawable) null);
        com.baidu.tbadk.core.util.an.b(this.cag, i.c.cp_link_tip_c, 1);
        return false;
    }
}
