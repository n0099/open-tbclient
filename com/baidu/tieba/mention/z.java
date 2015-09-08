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
    private TextView aOv;
    private TextView aQQ;
    private TextView aQj;
    private HeadImageView aUc;
    private TextView aYR;
    private TbPageContext<?> adB;
    private TextView bWK;
    private TextView bWj;
    private TextView bWk;
    private View mLine;

    public z(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.adB = tbPageContext;
        this.aUc = (HeadImageView) view.findViewById(i.f.photo);
        this.aYR = (TextView) view.findViewById(i.f.user_name);
        this.aQQ = (TextView) view.findViewById(i.f.time);
        this.bWj = (TextView) view.findViewById(i.f.add_friend_button);
        this.mLine = view.findViewById(i.f.line);
        this.bWk = (TextView) view.findViewById(i.f.content);
        this.aQj = (TextView) view.findViewById(i.f.replyme_title);
        this.aOv = (TextView) view.findViewById(i.f.forum);
        this.bWK = (TextView) view.findViewById(i.f.tv_quick_reply_text);
        this.aUc.setOnClickListener(new aa(this));
        this.bWj.setOnClickListener(new ab(this));
        view.setOnClickListener(new ac(this));
        this.bWK.setOnClickListener(new ad(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void B(FeedData feedData) {
        LikeData likeData;
        super.B(feedData);
        if (FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType())) {
            this.bWK.setVisibility(8);
            List<LikeData> praiseList = feedData.getPraiseList();
            if (praiseList != null && praiseList.size() > 0 && (likeData = praiseList.get(0)) != null) {
                this.aYR.setText(likeData.getNameShow());
                if (likeData.getIsMyFriend() == 1) {
                    this.bWj.setVisibility(8);
                } else {
                    this.bWj.setVisibility(0);
                    this.bWj.setBackgroundDrawable(null);
                    com.baidu.tbadk.core.util.al.b(this.bWj, i.c.cp_link_tip_c, 1);
                    this.bWj.setText(getString(i.h.message_add_friend));
                    this.bWj.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.al.getDrawable(i.e.icon_friend_add), (Drawable) null, (Drawable) null, (Drawable) null);
                }
                this.aQQ.setText(com.baidu.tbadk.core.util.aq.m(feedData.getTime()));
                if (praiseList.size() > 3 && praiseList.get(1) != null && praiseList.get(2) != null) {
                    this.bWk.setText(String.format(getString(i.h.message_praise_like_list_more), likeData.getNameShow(), praiseList.get(1).getNameShow(), praiseList.get(2).getNameShow(), String.valueOf(feedData.getPraiseNum())));
                } else if (praiseList.size() > 2 && praiseList.get(1) != null && praiseList.get(2) != null) {
                    this.bWk.setText(String.format(getString(i.h.message_praise_like_list_3), likeData.getNameShow(), praiseList.get(1).getNameShow(), praiseList.get(2).getNameShow()));
                } else if (praiseList.size() > 1 && praiseList.get(1) != null) {
                    this.bWk.setText(String.format(getString(i.h.message_praise_like_list_2), likeData.getNameShow(), praiseList.get(1).getNameShow()));
                } else {
                    this.bWk.setText(String.format(getString(i.h.message_praise_like_list_1), likeData.getNameShow()));
                }
                this.aQj.setText(this.adB.getPageActivity().getString(i.h.mention_replyme_original, new Object[]{feedData.getTitle()}));
                if (feedData.getThread_Type() == 33) {
                    this.aQj.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.al.getDrawable(i.e.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
                } else {
                    this.aQj.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (feedData.getFname() != null && feedData.getFname().length() > 0) {
                    this.aOv.setVisibility(0);
                    this.aOv.setText(com.baidu.tbadk.core.util.aq.i(feedData.getFname(), 12).concat(getString(i.h.forum)));
                } else {
                    this.aOv.setVisibility(8);
                }
                this.aUc.setVisibility(0);
                this.aUc.d(likeData.getPortrait(), 12, false);
                return;
            }
            return;
        }
        this.bWK.setVisibility(0);
        this.bWK.setTag(Integer.valueOf(this.position));
        if (feedData.getReplyer() != null) {
            this.aYR.setText(feedData.getReplyer().getName_show());
            if (feedData.getReplyer().getIsMyFriend() == 1) {
                this.bWj.setVisibility(0);
                this.bWj.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                this.bWj.setTextColor(com.baidu.tbadk.core.util.al.getColor(i.c.cp_cont_i));
                this.bWj.setBackgroundDrawable(com.baidu.tbadk.core.util.al.getDrawable(i.e.game_center_start_btn));
                this.bWj.setText(getString(i.h.mention_chatme));
            } else {
                this.bWj.setVisibility(0);
                this.bWj.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                this.bWj.setTextColor(com.baidu.tbadk.core.util.al.getColor(i.c.cp_cont_i));
                this.bWj.setBackgroundDrawable(com.baidu.tbadk.core.util.al.getDrawable(i.e.game_center_start_btn));
                this.bWj.setText(getString(i.h.mention_chatme));
            }
            this.aQQ.setText(com.baidu.tbadk.core.util.aq.m(feedData.getTime()));
            this.bWk.setText(feedData.getContent());
            if (feedData.getType() == 1) {
                this.aQj.setText(this.adB.getPageActivity().getString(i.h.mention_replyme_original, new Object[]{feedData.getQuote_content()}));
            } else {
                this.aQj.setText(this.adB.getPageActivity().getString(i.h.mention_replyme_original, new Object[]{feedData.getTitle()}));
            }
            if (feedData.getThread_Type() == 33) {
                this.aQj.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.al.getDrawable(i.e.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.aQj.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            if (feedData.getFname() != null && feedData.getFname().length() > 0) {
                this.aOv.setVisibility(0);
                this.aOv.setText(com.baidu.tbadk.core.util.aq.i(feedData.getFname(), 12).concat(getString(i.h.forum)));
            } else {
                this.aOv.setVisibility(8);
            }
            this.aUc.setVisibility(0);
            String portrait = feedData.getReplyer().getPortrait();
            this.aUc.setTag(null);
            this.aUc.d(portrait, 12, false);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.core.util.al.h(getRootView(), i.e.list_selector);
        com.baidu.tbadk.core.util.al.i(this.mLine, i.c.cp_bg_line_b);
        this.bWk.setTextColor(com.baidu.tbadk.core.util.al.getColor(i.c.cp_cont_b));
        this.aQQ.setTextColor(com.baidu.tbadk.core.util.al.getColor(i.c.cp_cont_d));
        this.aYR.setTextColor(com.baidu.tbadk.core.util.al.getColor(i.c.cp_cont_f));
        this.aOv.setTextColor(com.baidu.tbadk.core.util.al.getColor(i.c.cp_cont_d));
        this.aQj.setTextColor(com.baidu.tbadk.core.util.al.getColor(i.c.cp_cont_c));
        com.baidu.tbadk.core.util.al.b(this.bWK, i.c.cp_cont_c, 1);
        this.bWK.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.al.getDrawable(i.e.icon_reply_n), (Drawable) null, (Drawable) null, (Drawable) null);
        com.baidu.tbadk.core.util.al.h((View) this.aQj, i.e.bg_ta_dialog_content);
        return true;
    }
}
