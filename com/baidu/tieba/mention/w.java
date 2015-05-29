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
    private TextView aGH;
    private TextView aJa;
    private HeadImageView aKy;
    private TextView aXZ;
    private TextView bFN;
    private TextView bFO;
    private TextView bGm;
    private View mLine;
    private TextView mTitle;

    public w(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.Yt = tbPageContext;
        this.aKy = (HeadImageView) view.findViewById(com.baidu.tieba.q.photo);
        this.aXZ = (TextView) view.findViewById(com.baidu.tieba.q.user_name);
        this.aJa = (TextView) view.findViewById(com.baidu.tieba.q.time);
        this.bFN = (TextView) view.findViewById(com.baidu.tieba.q.add_friend_button);
        this.mLine = view.findViewById(com.baidu.tieba.q.line);
        this.bFO = (TextView) view.findViewById(com.baidu.tieba.q.content);
        this.mTitle = (TextView) view.findViewById(com.baidu.tieba.q.replyme_title);
        this.aGH = (TextView) view.findViewById(com.baidu.tieba.q.forum);
        this.bGm = (TextView) view.findViewById(com.baidu.tieba.q.tv_quick_reply_text);
        this.aKy.setOnClickListener(new x(this));
        this.bFN.setOnClickListener(new y(this));
        view.setOnClickListener(new z(this));
        this.bGm.setOnClickListener(new aa(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.j.e
    /* renamed from: a */
    public void z(FeedData feedData) {
        k kVar;
        super.z(feedData);
        if (FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType())) {
            this.bGm.setVisibility(8);
            List<k> praiseList = feedData.getPraiseList();
            if (praiseList != null && praiseList.size() > 0 && (kVar = praiseList.get(0)) != null) {
                this.aXZ.setText(kVar.Zj());
                if (kVar.getIsMyFriend() == 1) {
                    this.bFN.setVisibility(8);
                } else {
                    this.bFN.setVisibility(0);
                    this.bFN.setBackgroundDrawable(null);
                    ay.b(this.bFN, com.baidu.tieba.n.cp_link_tip_c, 1);
                    this.bFN.setText(getString(com.baidu.tieba.t.message_add_friend));
                    this.bFN.setCompoundDrawablesWithIntrinsicBounds(ay.getDrawable(com.baidu.tieba.p.icon_friend_add), (Drawable) null, (Drawable) null, (Drawable) null);
                }
                this.aJa.setText(bb.o(feedData.getTime()));
                if (praiseList.size() > 3 && praiseList.get(1) != null && praiseList.get(2) != null) {
                    this.bFO.setText(String.format(getString(com.baidu.tieba.t.message_praise_like_list_more), kVar.Zj(), praiseList.get(1).Zj(), praiseList.get(2).Zj(), String.valueOf(feedData.getPraiseNum())));
                } else if (praiseList.size() > 2 && praiseList.get(1) != null && praiseList.get(2) != null) {
                    this.bFO.setText(String.format(getString(com.baidu.tieba.t.message_praise_like_list_3), kVar.Zj(), praiseList.get(1).Zj(), praiseList.get(2).Zj()));
                } else if (praiseList.size() > 1 && praiseList.get(1) != null) {
                    this.bFO.setText(String.format(getString(com.baidu.tieba.t.message_praise_like_list_2), kVar.Zj(), praiseList.get(1).Zj()));
                } else {
                    this.bFO.setText(String.format(getString(com.baidu.tieba.t.message_praise_like_list_1), kVar.Zj()));
                }
                this.mTitle.setText(this.Yt.getPageActivity().getString(com.baidu.tieba.t.mention_replyme_original, new Object[]{feedData.getTitle()}));
                if (feedData.getFname() != null && feedData.getFname().length() > 0) {
                    this.aGH.setVisibility(0);
                    this.aGH.setText(bb.h(feedData.getFname(), 12).concat(getString(com.baidu.tieba.t.forum)));
                } else {
                    this.aGH.setVisibility(8);
                }
                this.aKy.setVisibility(0);
                this.aKy.c(kVar.getPortrait(), 12, false);
                return;
            }
            return;
        }
        this.bGm.setVisibility(0);
        this.bGm.setTag(Integer.valueOf(this.position));
        if (feedData.getReplyer() != null) {
            this.aXZ.setText(feedData.getReplyer().getName_show());
            if (feedData.getReplyer().getIsMyFriend() == 1) {
                this.bFN.setVisibility(0);
                this.bFN.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                this.bFN.setTextColor(ay.getColor(com.baidu.tieba.n.cp_cont_i));
                this.bFN.setBackgroundDrawable(ay.getDrawable(com.baidu.tieba.p.game_center_start_btn));
                this.bFN.setText(getString(com.baidu.tieba.t.mention_chatme));
            } else {
                this.bFN.setVisibility(0);
                this.bFN.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                this.bFN.setTextColor(ay.getColor(com.baidu.tieba.n.cp_cont_i));
                this.bFN.setBackgroundDrawable(ay.getDrawable(com.baidu.tieba.p.game_center_start_btn));
                this.bFN.setText(getString(com.baidu.tieba.t.mention_chatme));
            }
            this.aJa.setText(bb.o(feedData.getTime()));
            this.bFO.setText(feedData.getContent());
            if (feedData.getType() == 1) {
                this.mTitle.setText(this.Yt.getPageActivity().getString(com.baidu.tieba.t.mention_replyme_original, new Object[]{feedData.getQuote_content()}));
            } else {
                this.mTitle.setText(this.Yt.getPageActivity().getString(com.baidu.tieba.t.mention_replyme_original, new Object[]{feedData.getTitle()}));
            }
            if (feedData.getFname() != null && feedData.getFname().length() > 0) {
                this.aGH.setVisibility(0);
                this.aGH.setText(bb.h(feedData.getFname(), 12).concat(getString(com.baidu.tieba.t.forum)));
            } else {
                this.aGH.setVisibility(8);
            }
            this.aKy.setVisibility(0);
            String portrait = feedData.getReplyer().getPortrait();
            this.aKy.setTag(null);
            this.aKy.c(portrait, 12, false);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        ay.i(getRootView(), com.baidu.tieba.p.list_selector);
        ay.j(this.mLine, com.baidu.tieba.n.cp_bg_line_b);
        this.bFO.setTextColor(ay.getColor(com.baidu.tieba.n.cp_cont_b));
        this.aJa.setTextColor(ay.getColor(com.baidu.tieba.n.cp_cont_d));
        this.aXZ.setTextColor(ay.getColor(com.baidu.tieba.n.cp_cont_f));
        this.aGH.setTextColor(ay.getColor(com.baidu.tieba.n.cp_cont_d));
        this.mTitle.setTextColor(ay.getColor(com.baidu.tieba.n.cp_cont_c));
        ay.b(this.bGm, com.baidu.tieba.n.cp_cont_c, 1);
        this.bGm.setCompoundDrawablesWithIntrinsicBounds(ay.getDrawable(com.baidu.tieba.p.icon_reply_n), (Drawable) null, (Drawable) null, (Drawable) null);
        ay.i((View) this.mTitle, com.baidu.tieba.p.bg_ta_dialog_content);
        return true;
    }
}
