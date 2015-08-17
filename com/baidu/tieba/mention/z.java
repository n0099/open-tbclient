package com.baidu.tieba.mention;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.i;
import java.util.List;
/* loaded from: classes.dex */
public class z extends com.baidu.tbadk.mvc.g.a<FeedData, com.baidu.tbadk.mvc.d.b> {
    private TextView aOi;
    private TextView aPV;
    private TextView aQC;
    private HeadImageView aTO;
    private TextView aYA;
    private TbPageContext<?> adr;
    private TextView bVD;
    private TextView bVE;
    private TextView bWe;
    private View mLine;

    public z(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.adr = tbPageContext;
        this.aTO = (HeadImageView) view.findViewById(i.f.photo);
        this.aYA = (TextView) view.findViewById(i.f.user_name);
        this.aQC = (TextView) view.findViewById(i.f.time);
        this.bVD = (TextView) view.findViewById(i.f.add_friend_button);
        this.mLine = view.findViewById(i.f.line);
        this.bVE = (TextView) view.findViewById(i.f.content);
        this.aPV = (TextView) view.findViewById(i.f.replyme_title);
        this.aOi = (TextView) view.findViewById(i.f.forum);
        this.bWe = (TextView) view.findViewById(i.f.tv_quick_reply_text);
        this.aTO.setOnClickListener(new aa(this));
        this.bVD.setOnClickListener(new ab(this));
        view.setOnClickListener(new ac(this));
        this.bWe.setOnClickListener(new ad(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void A(FeedData feedData) {
        LikeData likeData;
        super.A(feedData);
        if (FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType())) {
            this.bWe.setVisibility(8);
            List<LikeData> praiseList = feedData.getPraiseList();
            if (praiseList != null && praiseList.size() > 0 && (likeData = praiseList.get(0)) != null) {
                this.aYA.setText(likeData.getNameShow());
                if (likeData.getIsMyFriend() == 1) {
                    this.bVD.setVisibility(8);
                } else {
                    this.bVD.setVisibility(0);
                    this.bVD.setBackgroundDrawable(null);
                    com.baidu.tbadk.core.util.al.b(this.bVD, i.c.cp_link_tip_c, 1);
                    this.bVD.setText(getString(i.C0057i.message_add_friend));
                    this.bVD.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.al.getDrawable(i.e.icon_friend_add), (Drawable) null, (Drawable) null, (Drawable) null);
                }
                this.aQC.setText(com.baidu.tbadk.core.util.aq.m(feedData.getTime()));
                if (praiseList.size() > 3 && praiseList.get(1) != null && praiseList.get(2) != null) {
                    this.bVE.setText(String.format(getString(i.C0057i.message_praise_like_list_more), likeData.getNameShow(), praiseList.get(1).getNameShow(), praiseList.get(2).getNameShow(), String.valueOf(feedData.getPraiseNum())));
                } else if (praiseList.size() > 2 && praiseList.get(1) != null && praiseList.get(2) != null) {
                    this.bVE.setText(String.format(getString(i.C0057i.message_praise_like_list_3), likeData.getNameShow(), praiseList.get(1).getNameShow(), praiseList.get(2).getNameShow()));
                } else if (praiseList.size() > 1 && praiseList.get(1) != null) {
                    this.bVE.setText(String.format(getString(i.C0057i.message_praise_like_list_2), likeData.getNameShow(), praiseList.get(1).getNameShow()));
                } else {
                    this.bVE.setText(String.format(getString(i.C0057i.message_praise_like_list_1), likeData.getNameShow()));
                }
                this.aPV.setText(this.adr.getPageActivity().getString(i.C0057i.mention_replyme_original, new Object[]{feedData.getTitle()}));
                if (feedData.getFname() != null && feedData.getFname().length() > 0) {
                    this.aOi.setVisibility(0);
                    this.aOi.setText(com.baidu.tbadk.core.util.aq.i(feedData.getFname(), 12).concat(getString(i.C0057i.forum)));
                } else {
                    this.aOi.setVisibility(8);
                }
                this.aTO.setVisibility(0);
                this.aTO.d(likeData.getPortrait(), 12, false);
                return;
            }
            return;
        }
        this.bWe.setVisibility(0);
        this.bWe.setTag(Integer.valueOf(this.position));
        if (feedData.getReplyer() != null) {
            this.aYA.setText(feedData.getReplyer().getName_show());
            if (feedData.getReplyer().getIsMyFriend() == 1) {
                this.bVD.setVisibility(0);
                this.bVD.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                this.bVD.setTextColor(com.baidu.tbadk.core.util.al.getColor(i.c.cp_cont_i));
                this.bVD.setBackgroundDrawable(com.baidu.tbadk.core.util.al.getDrawable(i.e.game_center_start_btn));
                this.bVD.setText(getString(i.C0057i.mention_chatme));
            } else {
                this.bVD.setVisibility(0);
                this.bVD.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                this.bVD.setTextColor(com.baidu.tbadk.core.util.al.getColor(i.c.cp_cont_i));
                this.bVD.setBackgroundDrawable(com.baidu.tbadk.core.util.al.getDrawable(i.e.game_center_start_btn));
                this.bVD.setText(getString(i.C0057i.mention_chatme));
            }
            this.aQC.setText(com.baidu.tbadk.core.util.aq.m(feedData.getTime()));
            this.bVE.setText(feedData.getContent());
            if (feedData.getType() == 1) {
                this.aPV.setText(this.adr.getPageActivity().getString(i.C0057i.mention_replyme_original, new Object[]{feedData.getQuote_content()}));
            } else {
                this.aPV.setText(this.adr.getPageActivity().getString(i.C0057i.mention_replyme_original, new Object[]{feedData.getTitle()}));
            }
            if (feedData.getFname() != null && feedData.getFname().length() > 0) {
                this.aOi.setVisibility(0);
                this.aOi.setText(com.baidu.tbadk.core.util.aq.i(feedData.getFname(), 12).concat(getString(i.C0057i.forum)));
            } else {
                this.aOi.setVisibility(8);
            }
            this.aTO.setVisibility(0);
            String portrait = feedData.getReplyer().getPortrait();
            this.aTO.setTag(null);
            this.aTO.d(portrait, 12, false);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.r
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.core.util.al.i(getRootView(), i.e.list_selector);
        com.baidu.tbadk.core.util.al.j(this.mLine, i.c.cp_bg_line_b);
        this.bVE.setTextColor(com.baidu.tbadk.core.util.al.getColor(i.c.cp_cont_b));
        this.aQC.setTextColor(com.baidu.tbadk.core.util.al.getColor(i.c.cp_cont_d));
        this.aYA.setTextColor(com.baidu.tbadk.core.util.al.getColor(i.c.cp_cont_f));
        this.aOi.setTextColor(com.baidu.tbadk.core.util.al.getColor(i.c.cp_cont_d));
        this.aPV.setTextColor(com.baidu.tbadk.core.util.al.getColor(i.c.cp_cont_c));
        com.baidu.tbadk.core.util.al.b(this.bWe, i.c.cp_cont_c, 1);
        this.bWe.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.al.getDrawable(i.e.icon_reply_n), (Drawable) null, (Drawable) null, (Drawable) null);
        com.baidu.tbadk.core.util.al.i((View) this.aPV, i.e.bg_ta_dialog_content);
        return true;
    }
}
