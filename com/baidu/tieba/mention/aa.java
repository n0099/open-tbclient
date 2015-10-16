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
    private TextView aNC;
    private TextView aPX;
    private TbPageContext<?> aPm;
    private TextView aPq;
    private HeadImageView aTj;
    private TextView aYR;
    private TextView caJ;
    private TextView cag;
    private TextView cah;
    private View mLine;

    public aa(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aPm = tbPageContext;
        this.aTj = (HeadImageView) view.findViewById(i.f.photo);
        this.aYR = (TextView) view.findViewById(i.f.user_name);
        this.aPX = (TextView) view.findViewById(i.f.time);
        this.cag = (TextView) view.findViewById(i.f.add_friend_button);
        this.mLine = view.findViewById(i.f.line);
        this.cah = (TextView) view.findViewById(i.f.content);
        this.aPq = (TextView) view.findViewById(i.f.replyme_title);
        this.aNC = (TextView) view.findViewById(i.f.forum);
        this.caJ = (TextView) view.findViewById(i.f.tv_quick_reply_text);
        this.aTj.setOnClickListener(new ab(this));
        this.cag.setOnClickListener(new ac(this));
        view.setOnClickListener(new ad(this));
        this.caJ.setOnClickListener(new ae(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void B(FeedData feedData) {
        LikeData likeData;
        super.B(feedData);
        if (FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType())) {
            this.caJ.setVisibility(8);
            List<LikeData> praiseList = feedData.getPraiseList();
            if (praiseList != null && praiseList.size() > 0 && (likeData = praiseList.get(0)) != null) {
                this.aYR.setText(likeData.getNameShow());
                if (likeData.getIsMyFriend() == 1) {
                    this.cag.setVisibility(8);
                } else {
                    this.cag.setVisibility(0);
                    this.cag.setBackgroundDrawable(null);
                    com.baidu.tbadk.core.util.an.b(this.cag, i.c.cp_link_tip_c, 1);
                    this.cag.setText(getString(i.h.message_add_friend));
                    this.cag.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.an.getDrawable(i.e.icon_friend_add), (Drawable) null, (Drawable) null, (Drawable) null);
                }
                this.aPX.setText(com.baidu.tbadk.core.util.as.o(feedData.getTime()));
                if (praiseList.size() > 3 && praiseList.get(1) != null && praiseList.get(2) != null) {
                    this.cah.setText(String.format(getString(i.h.message_praise_like_list_more), likeData.getNameShow(), praiseList.get(1).getNameShow(), praiseList.get(2).getNameShow(), String.valueOf(feedData.getPraiseNum())));
                } else if (praiseList.size() > 2 && praiseList.get(1) != null && praiseList.get(2) != null) {
                    this.cah.setText(String.format(getString(i.h.message_praise_like_list_3), likeData.getNameShow(), praiseList.get(1).getNameShow(), praiseList.get(2).getNameShow()));
                } else if (praiseList.size() > 1 && praiseList.get(1) != null) {
                    this.cah.setText(String.format(getString(i.h.message_praise_like_list_2), likeData.getNameShow(), praiseList.get(1).getNameShow()));
                } else {
                    this.cah.setText(String.format(getString(i.h.message_praise_like_list_1), likeData.getNameShow()));
                }
                this.aPq.setText(this.aPm.getPageActivity().getString(i.h.mention_replyme_original, new Object[]{feedData.getTitle()}));
                if (feedData.getThread_Type() == 33) {
                    this.aPq.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.an.getDrawable(i.e.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
                } else {
                    this.aPq.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (feedData.getFname() != null && feedData.getFname().length() > 0) {
                    this.aNC.setVisibility(0);
                    this.aNC.setText(com.baidu.tbadk.core.util.as.i(feedData.getFname(), 12).concat(getString(i.h.forum)));
                } else {
                    this.aNC.setVisibility(8);
                }
                this.aTj.setVisibility(0);
                this.aTj.d(likeData.getPortrait(), 12, false);
                return;
            }
            return;
        }
        this.caJ.setVisibility(0);
        this.caJ.setTag(Integer.valueOf(this.position));
        if (feedData.getReplyer() != null) {
            this.aYR.setText(feedData.getReplyer().getName_show());
            if (feedData.getReplyer().getIsMyFriend() == 1) {
                this.cag.setVisibility(0);
                this.cag.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                this.cag.setTextColor(com.baidu.tbadk.core.util.an.getColor(i.c.cp_cont_i));
                this.cag.setBackgroundDrawable(com.baidu.tbadk.core.util.an.getDrawable(i.e.game_center_start_btn));
                this.cag.setText(getString(i.h.mention_chatme));
            } else {
                this.cag.setVisibility(0);
                this.cag.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                this.cag.setTextColor(com.baidu.tbadk.core.util.an.getColor(i.c.cp_cont_i));
                this.cag.setBackgroundDrawable(com.baidu.tbadk.core.util.an.getDrawable(i.e.game_center_start_btn));
                this.cag.setText(getString(i.h.mention_chatme));
            }
            this.aPX.setText(com.baidu.tbadk.core.util.as.o(feedData.getTime()));
            this.cah.setText(feedData.getContent());
            if (feedData.getType() == 1) {
                this.aPq.setText(this.aPm.getPageActivity().getString(i.h.mention_replyme_original, new Object[]{feedData.getQuote_content()}));
            } else {
                this.aPq.setText(this.aPm.getPageActivity().getString(i.h.mention_replyme_original, new Object[]{feedData.getTitle()}));
            }
            if (feedData.getThread_Type() == 33) {
                this.aPq.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.an.getDrawable(i.e.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.aPq.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            if (feedData.getFname() != null && feedData.getFname().length() > 0) {
                this.aNC.setVisibility(0);
                this.aNC.setText(com.baidu.tbadk.core.util.as.i(feedData.getFname(), 12).concat(getString(i.h.forum)));
            } else {
                this.aNC.setVisibility(8);
            }
            this.aTj.setVisibility(0);
            String portrait = feedData.getReplyer().getPortrait();
            this.aTj.setTag(null);
            this.aTj.d(portrait, 12, false);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.core.util.an.i(getRootView(), i.e.list_selector);
        com.baidu.tbadk.core.util.an.j(this.mLine, i.c.cp_bg_line_b);
        this.cah.setTextColor(com.baidu.tbadk.core.util.an.getColor(i.c.cp_cont_b));
        this.aPX.setTextColor(com.baidu.tbadk.core.util.an.getColor(i.c.cp_cont_d));
        this.aYR.setTextColor(com.baidu.tbadk.core.util.an.getColor(i.c.cp_cont_f));
        this.aNC.setTextColor(com.baidu.tbadk.core.util.an.getColor(i.c.cp_cont_d));
        this.aPq.setTextColor(com.baidu.tbadk.core.util.an.getColor(i.c.cp_cont_c));
        com.baidu.tbadk.core.util.an.b(this.caJ, i.c.cp_cont_c, 1);
        this.caJ.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.an.getDrawable(i.e.icon_reply_n), (Drawable) null, (Drawable) null, (Drawable) null);
        com.baidu.tbadk.core.util.an.i((View) this.aPq, i.e.bg_ta_dialog_content);
        return true;
    }
}
