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
public class aa extends com.baidu.tbadk.mvc.g.a<FeedData, com.baidu.tbadk.mvc.d.b> {
    private TextView aNr;
    private TextView aPM;
    private TbPageContext<?> aPb;
    private TextView aPf;
    private HeadImageView aSY;
    private TextView aYG;
    private TextView bZV;
    private TextView bZW;
    private TextView cay;
    private View mLine;

    public aa(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aPb = tbPageContext;
        this.aSY = (HeadImageView) view.findViewById(i.f.photo);
        this.aYG = (TextView) view.findViewById(i.f.user_name);
        this.aPM = (TextView) view.findViewById(i.f.time);
        this.bZV = (TextView) view.findViewById(i.f.add_friend_button);
        this.mLine = view.findViewById(i.f.line);
        this.bZW = (TextView) view.findViewById(i.f.content);
        this.aPf = (TextView) view.findViewById(i.f.replyme_title);
        this.aNr = (TextView) view.findViewById(i.f.forum);
        this.cay = (TextView) view.findViewById(i.f.tv_quick_reply_text);
        this.aSY.setOnClickListener(new ab(this));
        this.bZV.setOnClickListener(new ac(this));
        view.setOnClickListener(new ad(this));
        this.cay.setOnClickListener(new ae(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void B(FeedData feedData) {
        LikeData likeData;
        super.B(feedData);
        if (FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType())) {
            this.cay.setVisibility(8);
            List<LikeData> praiseList = feedData.getPraiseList();
            if (praiseList != null && praiseList.size() > 0 && (likeData = praiseList.get(0)) != null) {
                this.aYG.setText(likeData.getNameShow());
                if (likeData.getIsMyFriend() == 1) {
                    this.bZV.setVisibility(8);
                } else {
                    this.bZV.setVisibility(0);
                    this.bZV.setBackgroundDrawable(null);
                    com.baidu.tbadk.core.util.am.b(this.bZV, i.c.cp_link_tip_c, 1);
                    this.bZV.setText(getString(i.h.message_add_friend));
                    this.bZV.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.am.getDrawable(i.e.icon_friend_add), (Drawable) null, (Drawable) null, (Drawable) null);
                }
                this.aPM.setText(com.baidu.tbadk.core.util.ar.o(feedData.getTime()));
                if (praiseList.size() > 3 && praiseList.get(1) != null && praiseList.get(2) != null) {
                    this.bZW.setText(String.format(getString(i.h.message_praise_like_list_more), likeData.getNameShow(), praiseList.get(1).getNameShow(), praiseList.get(2).getNameShow(), String.valueOf(feedData.getPraiseNum())));
                } else if (praiseList.size() > 2 && praiseList.get(1) != null && praiseList.get(2) != null) {
                    this.bZW.setText(String.format(getString(i.h.message_praise_like_list_3), likeData.getNameShow(), praiseList.get(1).getNameShow(), praiseList.get(2).getNameShow()));
                } else if (praiseList.size() > 1 && praiseList.get(1) != null) {
                    this.bZW.setText(String.format(getString(i.h.message_praise_like_list_2), likeData.getNameShow(), praiseList.get(1).getNameShow()));
                } else {
                    this.bZW.setText(String.format(getString(i.h.message_praise_like_list_1), likeData.getNameShow()));
                }
                this.aPf.setText(this.aPb.getPageActivity().getString(i.h.mention_replyme_original, new Object[]{feedData.getTitle()}));
                if (feedData.getThread_Type() == 33) {
                    this.aPf.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.am.getDrawable(i.e.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
                } else {
                    this.aPf.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (feedData.getFname() != null && feedData.getFname().length() > 0) {
                    this.aNr.setVisibility(0);
                    this.aNr.setText(com.baidu.tbadk.core.util.ar.i(feedData.getFname(), 12).concat(getString(i.h.forum)));
                } else {
                    this.aNr.setVisibility(8);
                }
                this.aSY.setVisibility(0);
                this.aSY.d(likeData.getPortrait(), 12, false);
                return;
            }
            return;
        }
        this.cay.setVisibility(0);
        this.cay.setTag(Integer.valueOf(this.position));
        if (feedData.getReplyer() != null) {
            this.aYG.setText(feedData.getReplyer().getName_show());
            if (feedData.getReplyer().getIsMyFriend() == 1) {
                this.bZV.setVisibility(0);
                this.bZV.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                this.bZV.setTextColor(com.baidu.tbadk.core.util.am.getColor(i.c.cp_cont_i));
                this.bZV.setBackgroundDrawable(com.baidu.tbadk.core.util.am.getDrawable(i.e.game_center_start_btn));
                this.bZV.setText(getString(i.h.mention_chatme));
            } else {
                this.bZV.setVisibility(0);
                this.bZV.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                this.bZV.setTextColor(com.baidu.tbadk.core.util.am.getColor(i.c.cp_cont_i));
                this.bZV.setBackgroundDrawable(com.baidu.tbadk.core.util.am.getDrawable(i.e.game_center_start_btn));
                this.bZV.setText(getString(i.h.mention_chatme));
            }
            this.aPM.setText(com.baidu.tbadk.core.util.ar.o(feedData.getTime()));
            this.bZW.setText(feedData.getContent());
            if (feedData.getType() == 1) {
                this.aPf.setText(this.aPb.getPageActivity().getString(i.h.mention_replyme_original, new Object[]{feedData.getQuote_content()}));
            } else {
                this.aPf.setText(this.aPb.getPageActivity().getString(i.h.mention_replyme_original, new Object[]{feedData.getTitle()}));
            }
            if (feedData.getThread_Type() == 33) {
                this.aPf.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.am.getDrawable(i.e.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.aPf.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            if (feedData.getFname() != null && feedData.getFname().length() > 0) {
                this.aNr.setVisibility(0);
                this.aNr.setText(com.baidu.tbadk.core.util.ar.i(feedData.getFname(), 12).concat(getString(i.h.forum)));
            } else {
                this.aNr.setVisibility(8);
            }
            this.aSY.setVisibility(0);
            String portrait = feedData.getReplyer().getPortrait();
            this.aSY.setTag(null);
            this.aSY.d(portrait, 12, false);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.core.util.am.i(getRootView(), i.e.list_selector);
        com.baidu.tbadk.core.util.am.j(this.mLine, i.c.cp_bg_line_b);
        this.bZW.setTextColor(com.baidu.tbadk.core.util.am.getColor(i.c.cp_cont_b));
        this.aPM.setTextColor(com.baidu.tbadk.core.util.am.getColor(i.c.cp_cont_d));
        this.aYG.setTextColor(com.baidu.tbadk.core.util.am.getColor(i.c.cp_cont_f));
        this.aNr.setTextColor(com.baidu.tbadk.core.util.am.getColor(i.c.cp_cont_d));
        this.aPf.setTextColor(com.baidu.tbadk.core.util.am.getColor(i.c.cp_cont_c));
        com.baidu.tbadk.core.util.am.b(this.cay, i.c.cp_cont_c, 1);
        this.cay.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.am.getDrawable(i.e.icon_reply_n), (Drawable) null, (Drawable) null, (Drawable) null);
        com.baidu.tbadk.core.util.am.i((View) this.aPf, i.e.bg_ta_dialog_content);
        return true;
    }
}
