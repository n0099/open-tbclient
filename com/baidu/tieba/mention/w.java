package com.baidu.tieba.mention;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import java.util.List;
/* loaded from: classes.dex */
public class w extends com.baidu.tbadk.mvc.j.a<FeedData, com.baidu.tbadk.mvc.e.c> {
    private TbPageContext<?> Yt;
    private TextView aGI;
    private TextView aJb;
    private HeadImageView aKz;
    private TextView aYa;
    private TextView bFO;
    private TextView bFP;
    private TextView bGn;
    private View mLine;
    private TextView mTitle;

    public w(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.Yt = tbPageContext;
        this.aKz = (HeadImageView) view.findViewById(com.baidu.tieba.q.photo);
        this.aYa = (TextView) view.findViewById(com.baidu.tieba.q.user_name);
        this.aJb = (TextView) view.findViewById(com.baidu.tieba.q.time);
        this.bFO = (TextView) view.findViewById(com.baidu.tieba.q.add_friend_button);
        this.mLine = view.findViewById(com.baidu.tieba.q.line);
        this.bFP = (TextView) view.findViewById(com.baidu.tieba.q.content);
        this.mTitle = (TextView) view.findViewById(com.baidu.tieba.q.replyme_title);
        this.aGI = (TextView) view.findViewById(com.baidu.tieba.q.forum);
        this.bGn = (TextView) view.findViewById(com.baidu.tieba.q.tv_quick_reply_text);
        this.aKz.setOnClickListener(new x(this));
        this.bFO.setOnClickListener(new y(this));
        view.setOnClickListener(new z(this));
        this.bGn.setOnClickListener(new aa(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.j.e
    /* renamed from: a */
    public void z(FeedData feedData) {
        k kVar;
        super.z(feedData);
        if (FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType())) {
            this.bGn.setVisibility(8);
            List<k> praiseList = feedData.getPraiseList();
            if (praiseList != null && praiseList.size() > 0 && (kVar = praiseList.get(0)) != null) {
                this.aYa.setText(kVar.Zk());
                if (kVar.getIsMyFriend() == 1) {
                    this.bFO.setVisibility(8);
                } else {
                    this.bFO.setVisibility(0);
                    this.bFO.setBackgroundDrawable(null);
                    ay.b(this.bFO, com.baidu.tieba.n.cp_link_tip_c, 1);
                    this.bFO.setText(getString(com.baidu.tieba.t.message_add_friend));
                    this.bFO.setCompoundDrawablesWithIntrinsicBounds(ay.getDrawable(com.baidu.tieba.p.icon_friend_add), (Drawable) null, (Drawable) null, (Drawable) null);
                }
                this.aJb.setText(bb.o(feedData.getTime()));
                if (praiseList.size() > 3 && praiseList.get(1) != null && praiseList.get(2) != null) {
                    this.bFP.setText(String.format(getString(com.baidu.tieba.t.message_praise_like_list_more), kVar.Zk(), praiseList.get(1).Zk(), praiseList.get(2).Zk(), String.valueOf(feedData.getPraiseNum())));
                } else if (praiseList.size() > 2 && praiseList.get(1) != null && praiseList.get(2) != null) {
                    this.bFP.setText(String.format(getString(com.baidu.tieba.t.message_praise_like_list_3), kVar.Zk(), praiseList.get(1).Zk(), praiseList.get(2).Zk()));
                } else if (praiseList.size() > 1 && praiseList.get(1) != null) {
                    this.bFP.setText(String.format(getString(com.baidu.tieba.t.message_praise_like_list_2), kVar.Zk(), praiseList.get(1).Zk()));
                } else {
                    this.bFP.setText(String.format(getString(com.baidu.tieba.t.message_praise_like_list_1), kVar.Zk()));
                }
                this.mTitle.setText(this.Yt.getPageActivity().getString(com.baidu.tieba.t.mention_replyme_original, new Object[]{feedData.getTitle()}));
                if (feedData.getFname() != null && feedData.getFname().length() > 0) {
                    this.aGI.setVisibility(0);
                    this.aGI.setText(bb.h(feedData.getFname(), 12).concat(getString(com.baidu.tieba.t.forum)));
                } else {
                    this.aGI.setVisibility(8);
                }
                this.aKz.setVisibility(0);
                this.aKz.c(kVar.getPortrait(), 12, false);
                return;
            }
            return;
        }
        this.bGn.setVisibility(0);
        this.bGn.setTag(Integer.valueOf(this.position));
        if (feedData.getReplyer() != null) {
            this.aYa.setText(feedData.getReplyer().getName_show());
            if (feedData.getReplyer().getIsMyFriend() == 1) {
                this.bFO.setVisibility(0);
                this.bFO.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                this.bFO.setTextColor(ay.getColor(com.baidu.tieba.n.cp_cont_i));
                this.bFO.setBackgroundDrawable(ay.getDrawable(com.baidu.tieba.p.game_center_start_btn));
                this.bFO.setText(getString(com.baidu.tieba.t.mention_chatme));
            } else {
                this.bFO.setVisibility(0);
                this.bFO.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                this.bFO.setTextColor(ay.getColor(com.baidu.tieba.n.cp_cont_i));
                this.bFO.setBackgroundDrawable(ay.getDrawable(com.baidu.tieba.p.game_center_start_btn));
                this.bFO.setText(getString(com.baidu.tieba.t.mention_chatme));
            }
            this.aJb.setText(bb.o(feedData.getTime()));
            this.bFP.setText(feedData.getContent());
            if (feedData.getType() == 1) {
                this.mTitle.setText(this.Yt.getPageActivity().getString(com.baidu.tieba.t.mention_replyme_original, new Object[]{feedData.getQuote_content()}));
            } else {
                this.mTitle.setText(this.Yt.getPageActivity().getString(com.baidu.tieba.t.mention_replyme_original, new Object[]{feedData.getTitle()}));
            }
            if (feedData.getFname() != null && feedData.getFname().length() > 0) {
                this.aGI.setVisibility(0);
                this.aGI.setText(bb.h(feedData.getFname(), 12).concat(getString(com.baidu.tieba.t.forum)));
            } else {
                this.aGI.setVisibility(8);
            }
            this.aKz.setVisibility(0);
            String portrait = feedData.getReplyer().getPortrait();
            this.aKz.setTag(null);
            this.aKz.c(portrait, 12, false);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        ay.i(getRootView(), com.baidu.tieba.p.list_selector);
        ay.j(this.mLine, com.baidu.tieba.n.cp_bg_line_b);
        this.bFP.setTextColor(ay.getColor(com.baidu.tieba.n.cp_cont_b));
        this.aJb.setTextColor(ay.getColor(com.baidu.tieba.n.cp_cont_d));
        this.aYa.setTextColor(ay.getColor(com.baidu.tieba.n.cp_cont_f));
        this.aGI.setTextColor(ay.getColor(com.baidu.tieba.n.cp_cont_d));
        this.mTitle.setTextColor(ay.getColor(com.baidu.tieba.n.cp_cont_c));
        ay.b(this.bGn, com.baidu.tieba.n.cp_cont_c, 1);
        this.bGn.setCompoundDrawablesWithIntrinsicBounds(ay.getDrawable(com.baidu.tieba.p.icon_reply_n), (Drawable) null, (Drawable) null, (Drawable) null);
        ay.i((View) this.mTitle, com.baidu.tieba.p.bg_ta_dialog_content);
        return true;
    }
}
