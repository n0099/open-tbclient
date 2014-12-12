package com.baidu.tieba.mention;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
public class b extends com.baidu.tbadk.mvc.j.a<FeedData, com.baidu.tbadk.mvc.e.c> {
    private HeadImageView aBo;
    private TextView axA;
    private TextView bqW;
    private TextView brM;
    private TextView brN;
    private View mLine;

    public b(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aBo = (HeadImageView) view.findViewById(com.baidu.tieba.w.photo);
        this.brN = (TextView) view.findViewById(com.baidu.tieba.w.add_friend_button);
        this.brM = (TextView) view.findViewById(com.baidu.tieba.w.user_name);
        this.axA = (TextView) view.findViewById(com.baidu.tieba.w.time);
        this.bqW = (TextView) view.findViewById(com.baidu.tieba.w.content);
        this.mLine = view.findViewById(com.baidu.tieba.w.line);
        this.aBo.setOnClickListener(new c(this));
        this.brN.setOnClickListener(new d(this));
        view.setOnClickListener(new e(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.j.d
    /* renamed from: a */
    public void y(FeedData feedData) {
        super.y(feedData);
        if (feedData.getReplyer() != null) {
            this.brM.setText(feedData.getReplyer().getName_show());
            if (feedData.getReplyer().getIsMyFriend() == 1) {
                this.brN.setVisibility(8);
            } else {
                this.brN.setVisibility(0);
            }
            this.aBo.setVisibility(0);
            String portrait = feedData.getReplyer().getPortrait();
            this.aBo.setTag(null);
            if (portrait != null && portrait.length() > 0) {
                this.aBo.d(portrait, 12, false);
            } else {
                this.aBo.setImageResource(com.baidu.tieba.v.photo);
            }
        }
        this.axA.setText(ba.n(feedData.getTime()));
        this.bqW.setText(feedData.getContent());
    }

    @Override // com.baidu.tieba.tbadkCore.y
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        ax.i(getRootView(), com.baidu.tieba.v.list_selector);
        ax.j(this.mLine, com.baidu.tieba.t.cp_bg_line_b);
        if (i == 1) {
            this.axA.setTextColor(getResources().getColor(com.baidu.tieba.t.c_515865));
            this.bqW.setTextColor(getResources().getColor(com.baidu.tieba.t.c_7b8591));
            this.brM.setTextColor(getResources().getColor(com.baidu.tieba.t.cp_cont_c_1));
        } else {
            this.axA.setTextColor(getResources().getColor(com.baidu.tieba.t.c_b2b6ba));
            this.bqW.setTextColor(getResources().getColor(com.baidu.tieba.t.c_262626));
            this.brM.setTextColor(getResources().getColor(com.baidu.tieba.t.cp_cont_c));
        }
        this.brN.setCompoundDrawablesWithIntrinsicBounds(ax.getDrawable(com.baidu.tieba.v.icon_friend_add), (Drawable) null, (Drawable) null, (Drawable) null);
        this.axA.setCompoundDrawablesWithIntrinsicBounds(ax.getDrawable(com.baidu.tieba.v.icon_little_time), (Drawable) null, (Drawable) null, (Drawable) null);
        ax.b(this.brN, com.baidu.tieba.t.cp_link_tip_c, 1);
        return false;
    }
}
