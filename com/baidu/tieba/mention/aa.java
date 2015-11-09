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
    private TextView aNK;
    private TbPageContext<?> aPu;
    private TextView aPy;
    private TextView aQf;
    private HeadImageView aTr;
    private TextView aZd;
    private TextView caH;
    private TextView caI;
    private TextView cbk;
    private View mLine;

    public aa(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aPu = tbPageContext;
        this.aTr = (HeadImageView) view.findViewById(i.f.photo);
        this.aZd = (TextView) view.findViewById(i.f.user_name);
        this.aQf = (TextView) view.findViewById(i.f.time);
        this.caH = (TextView) view.findViewById(i.f.add_friend_button);
        this.mLine = view.findViewById(i.f.line);
        this.caI = (TextView) view.findViewById(i.f.content);
        this.aPy = (TextView) view.findViewById(i.f.replyme_title);
        this.aNK = (TextView) view.findViewById(i.f.forum);
        this.cbk = (TextView) view.findViewById(i.f.tv_quick_reply_text);
        this.aTr.setOnClickListener(new ab(this));
        this.caH.setOnClickListener(new ac(this));
        view.setOnClickListener(new ad(this));
        this.cbk.setOnClickListener(new ae(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void B(FeedData feedData) {
        LikeData likeData;
        super.B(feedData);
        if (FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType())) {
            this.cbk.setVisibility(8);
            List<LikeData> praiseList = feedData.getPraiseList();
            if (praiseList != null && praiseList.size() > 0 && (likeData = praiseList.get(0)) != null) {
                this.aZd.setText(likeData.getNameShow());
                if (likeData.getIsMyFriend() == 1) {
                    this.caH.setVisibility(8);
                } else {
                    this.caH.setVisibility(0);
                    this.caH.setBackgroundDrawable(null);
                    com.baidu.tbadk.core.util.an.b(this.caH, i.c.cp_link_tip_c, 1);
                    this.caH.setText(getString(i.h.message_add_friend));
                    this.caH.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.an.getDrawable(i.e.icon_friend_add), (Drawable) null, (Drawable) null, (Drawable) null);
                }
                this.aQf.setText(com.baidu.tbadk.core.util.as.m(feedData.getTime()));
                if (praiseList.size() > 3 && praiseList.get(1) != null && praiseList.get(2) != null) {
                    this.caI.setText(String.format(getString(i.h.message_praise_like_list_more), likeData.getNameShow(), praiseList.get(1).getNameShow(), praiseList.get(2).getNameShow(), String.valueOf(feedData.getPraiseNum())));
                } else if (praiseList.size() > 2 && praiseList.get(1) != null && praiseList.get(2) != null) {
                    this.caI.setText(String.format(getString(i.h.message_praise_like_list_3), likeData.getNameShow(), praiseList.get(1).getNameShow(), praiseList.get(2).getNameShow()));
                } else if (praiseList.size() > 1 && praiseList.get(1) != null) {
                    this.caI.setText(String.format(getString(i.h.message_praise_like_list_2), likeData.getNameShow(), praiseList.get(1).getNameShow()));
                } else {
                    this.caI.setText(String.format(getString(i.h.message_praise_like_list_1), likeData.getNameShow()));
                }
                this.aPy.setText(this.aPu.getPageActivity().getString(i.h.mention_replyme_original, new Object[]{feedData.getTitle()}));
                if (feedData.getThread_Type() == 33) {
                    this.aPy.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.an.getDrawable(i.e.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
                } else {
                    this.aPy.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (feedData.getFname() != null && feedData.getFname().length() > 0) {
                    this.aNK.setVisibility(0);
                    this.aNK.setText(com.baidu.tbadk.core.util.as.i(feedData.getFname(), 12).concat(getString(i.h.forum)));
                } else {
                    this.aNK.setVisibility(8);
                }
                this.aTr.setVisibility(0);
                this.aTr.d(likeData.getPortrait(), 12, false);
                return;
            }
            return;
        }
        this.cbk.setVisibility(0);
        this.cbk.setTag(Integer.valueOf(this.position));
        if (feedData.getReplyer() != null) {
            this.aZd.setText(feedData.getReplyer().getName_show());
            if (feedData.getReplyer().getIsMyFriend() == 1) {
                this.caH.setVisibility(0);
                this.caH.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                this.caH.setTextColor(com.baidu.tbadk.core.util.an.getColor(i.c.cp_cont_i));
                this.caH.setBackgroundDrawable(com.baidu.tbadk.core.util.an.getDrawable(i.e.game_center_start_btn));
                this.caH.setText(getString(i.h.mention_chatme));
            } else {
                this.caH.setVisibility(0);
                this.caH.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                this.caH.setTextColor(com.baidu.tbadk.core.util.an.getColor(i.c.cp_cont_i));
                this.caH.setBackgroundDrawable(com.baidu.tbadk.core.util.an.getDrawable(i.e.game_center_start_btn));
                this.caH.setText(getString(i.h.mention_chatme));
            }
            this.aQf.setText(com.baidu.tbadk.core.util.as.m(feedData.getTime()));
            this.caI.setText(feedData.getContent());
            if (feedData.getType() == 1) {
                this.aPy.setText(this.aPu.getPageActivity().getString(i.h.mention_replyme_original, new Object[]{feedData.getQuote_content()}));
            } else {
                this.aPy.setText(this.aPu.getPageActivity().getString(i.h.mention_replyme_original, new Object[]{feedData.getTitle()}));
            }
            if (feedData.getThread_Type() == 33) {
                this.aPy.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.an.getDrawable(i.e.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.aPy.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            if (feedData.getFname() != null && feedData.getFname().length() > 0) {
                this.aNK.setVisibility(0);
                this.aNK.setText(com.baidu.tbadk.core.util.as.i(feedData.getFname(), 12).concat(getString(i.h.forum)));
            } else {
                this.aNK.setVisibility(8);
            }
            this.aTr.setVisibility(0);
            String portrait = feedData.getReplyer().getPortrait();
            this.aTr.setTag(null);
            this.aTr.d(portrait, 12, false);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.core.util.an.i(getRootView(), i.e.list_selector);
        com.baidu.tbadk.core.util.an.j(this.mLine, i.c.cp_bg_line_b);
        this.caI.setTextColor(com.baidu.tbadk.core.util.an.getColor(i.c.cp_cont_b));
        this.aQf.setTextColor(com.baidu.tbadk.core.util.an.getColor(i.c.cp_cont_d));
        this.aZd.setTextColor(com.baidu.tbadk.core.util.an.getColor(i.c.cp_cont_f));
        this.aNK.setTextColor(com.baidu.tbadk.core.util.an.getColor(i.c.cp_cont_d));
        this.aPy.setTextColor(com.baidu.tbadk.core.util.an.getColor(i.c.cp_cont_c));
        com.baidu.tbadk.core.util.an.b(this.cbk, i.c.cp_cont_c, 1);
        this.cbk.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.an.getDrawable(i.e.icon_reply_n), (Drawable) null, (Drawable) null, (Drawable) null);
        com.baidu.tbadk.core.util.an.i((View) this.aPy, i.e.bg_ta_dialog_content);
        return true;
    }
}
