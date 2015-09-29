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
    private TextView aPM;
    private HeadImageView aSY;
    private TextView aYG;
    private TextView bZV;
    private TextView bZW;
    private View mLine;

    public b(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aSY = (HeadImageView) view.findViewById(i.f.photo);
        this.bZV = (TextView) view.findViewById(i.f.add_friend_button);
        this.aYG = (TextView) view.findViewById(i.f.user_name);
        this.aPM = (TextView) view.findViewById(i.f.time);
        this.bZW = (TextView) view.findViewById(i.f.content);
        this.mLine = view.findViewById(i.f.line);
        this.aSY.setOnClickListener(new c(this));
        this.bZV.setOnClickListener(new d(this));
        view.setOnClickListener(new e(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void B(FeedData feedData) {
        super.B(feedData);
        if (feedData.getReplyer() != null) {
            this.aYG.setText(feedData.getReplyer().getName_show());
            if (feedData.getReplyer().getIsMyFriend() == 1) {
                this.bZV.setVisibility(8);
            } else {
                this.bZV.setVisibility(0);
            }
            this.aSY.setVisibility(0);
            String portrait = feedData.getReplyer().getPortrait();
            this.aSY.setTag(null);
            if (portrait != null && portrait.length() > 0) {
                this.aSY.d(portrait, 12, false);
            } else {
                this.aSY.setImageResource(i.e.photo);
            }
        }
        this.aPM.setText(com.baidu.tbadk.core.util.ar.o(feedData.getTime()));
        this.bZW.setText(feedData.getContent());
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.core.util.am.i(getRootView(), i.e.list_selector);
        com.baidu.tbadk.core.util.am.j(this.mLine, i.c.cp_bg_line_b);
        if (i == 1) {
            this.aPM.setTextColor(getResources().getColor(i.c.c_515865));
            this.bZW.setTextColor(getResources().getColor(i.c.c_7b8591));
            this.aYG.setTextColor(getResources().getColor(i.c.cp_cont_c_1));
        } else {
            this.aPM.setTextColor(getResources().getColor(i.c.c_b2b6ba));
            this.bZW.setTextColor(getResources().getColor(i.c.c_262626));
            this.aYG.setTextColor(getResources().getColor(i.c.cp_cont_c));
        }
        this.bZV.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.am.getDrawable(i.e.icon_friend_add), (Drawable) null, (Drawable) null, (Drawable) null);
        this.aPM.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.am.getDrawable(i.e.icon_little_time), (Drawable) null, (Drawable) null, (Drawable) null);
        com.baidu.tbadk.core.util.am.b(this.bZV, i.c.cp_link_tip_c, 1);
        return false;
    }
}
