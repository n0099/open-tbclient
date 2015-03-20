package com.baidu.tieba.mention;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import java.util.List;
/* loaded from: classes.dex */
public class w extends com.baidu.tbadk.mvc.j.a<FeedData, com.baidu.tbadk.mvc.e.c> {
    private TbPageContext<?> XE;
    private TextView aEv;
    private TextView aGK;
    private HeadImageView aIi;
    private TextView aVe;
    private View acX;
    private TextView bCG;
    private TextView bDe;
    private TextView byI;
    private TextView mTitle;

    public w(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.XE = tbPageContext;
        this.aIi = (HeadImageView) view.findViewById(com.baidu.tieba.v.photo);
        this.aVe = (TextView) view.findViewById(com.baidu.tieba.v.user_name);
        this.aGK = (TextView) view.findViewById(com.baidu.tieba.v.time);
        this.bCG = (TextView) view.findViewById(com.baidu.tieba.v.add_friend_button);
        this.acX = view.findViewById(com.baidu.tieba.v.line);
        this.byI = (TextView) view.findViewById(com.baidu.tieba.v.content);
        this.mTitle = (TextView) view.findViewById(com.baidu.tieba.v.replyme_title);
        this.aEv = (TextView) view.findViewById(com.baidu.tieba.v.forum);
        this.bDe = (TextView) view.findViewById(com.baidu.tieba.v.tv_quick_reply_text);
        this.aIi.setOnClickListener(new x(this));
        this.bCG.setOnClickListener(new y(this));
        view.setOnClickListener(new z(this));
        this.bDe.setOnClickListener(new aa(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.j.e
    /* renamed from: a */
    public void A(FeedData feedData) {
        k kVar;
        super.A(feedData);
        if (FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType())) {
            this.bDe.setVisibility(8);
            List<k> praiseList = feedData.getPraiseList();
            if (praiseList != null && praiseList.size() > 0 && (kVar = praiseList.get(0)) != null) {
                this.aVe.setText(kVar.Xy());
                if (kVar.getIsMyFriend() == 1) {
                    this.bCG.setVisibility(8);
                } else {
                    this.bCG.setVisibility(0);
                    this.bCG.setBackgroundDrawable(null);
                    ba.b(this.bCG, com.baidu.tieba.s.cp_link_tip_c, 1);
                    this.bCG.setText(getString(com.baidu.tieba.y.message_add_friend));
                    this.bCG.setCompoundDrawablesWithIntrinsicBounds(ba.getDrawable(com.baidu.tieba.u.icon_friend_add), (Drawable) null, (Drawable) null, (Drawable) null);
                }
                this.aGK.setText(bd.n(feedData.getTime()));
                if (praiseList.size() > 3 && praiseList.get(1) != null && praiseList.get(2) != null) {
                    this.byI.setText(String.format(getString(com.baidu.tieba.y.message_praise_like_list_more), kVar.Xy(), praiseList.get(1).Xy(), praiseList.get(2).Xy(), String.valueOf(feedData.getPraiseNum())));
                } else if (praiseList.size() > 2 && praiseList.get(1) != null && praiseList.get(2) != null) {
                    this.byI.setText(String.format(getString(com.baidu.tieba.y.message_praise_like_list_3), kVar.Xy(), praiseList.get(1).Xy(), praiseList.get(2).Xy()));
                } else if (praiseList.size() > 1 && praiseList.get(1) != null) {
                    this.byI.setText(String.format(getString(com.baidu.tieba.y.message_praise_like_list_2), kVar.Xy(), praiseList.get(1).Xy()));
                } else {
                    this.byI.setText(String.format(getString(com.baidu.tieba.y.message_praise_like_list_1), kVar.Xy()));
                }
                this.mTitle.setText(this.XE.getPageActivity().getString(com.baidu.tieba.y.mention_replyme_original, new Object[]{feedData.getTitle()}));
                if (feedData.getFname() != null && feedData.getFname().length() > 0) {
                    this.aEv.setVisibility(0);
                    this.aEv.setText(bd.h(feedData.getFname(), 12).concat(getString(com.baidu.tieba.y.forum)));
                } else {
                    this.aEv.setVisibility(8);
                }
                this.aIi.setVisibility(0);
                this.aIi.c(kVar.getPortrait(), 12, false);
                return;
            }
            return;
        }
        this.bDe.setVisibility(0);
        this.bDe.setTag(Integer.valueOf(this.position));
        if (feedData.getReplyer() != null) {
            this.aVe.setText(feedData.getReplyer().getName_show());
            if (feedData.getReplyer().getIsMyFriend() == 1) {
                this.bCG.setVisibility(0);
                this.bCG.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                this.bCG.setTextColor(ba.getColor(com.baidu.tieba.s.cp_cont_i));
                this.bCG.setBackgroundDrawable(ba.getDrawable(com.baidu.tieba.u.game_center_start_btn));
                this.bCG.setText(getString(com.baidu.tieba.y.mention_chatme));
            } else {
                this.bCG.setVisibility(0);
                this.bCG.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                this.bCG.setTextColor(ba.getColor(com.baidu.tieba.s.cp_cont_i));
                this.bCG.setBackgroundDrawable(ba.getDrawable(com.baidu.tieba.u.game_center_start_btn));
                this.bCG.setText(getString(com.baidu.tieba.y.mention_chatme));
            }
            this.aGK.setText(bd.n(feedData.getTime()));
            this.byI.setText(feedData.getContent());
            if (feedData.getType() == 1) {
                this.mTitle.setText(this.XE.getPageActivity().getString(com.baidu.tieba.y.mention_replyme_original, new Object[]{feedData.getQuote_content()}));
            } else {
                this.mTitle.setText(this.XE.getPageActivity().getString(com.baidu.tieba.y.mention_replyme_original, new Object[]{feedData.getTitle()}));
            }
            if (feedData.getFname() != null && feedData.getFname().length() > 0) {
                this.aEv.setVisibility(0);
                this.aEv.setText(bd.h(feedData.getFname(), 12).concat(getString(com.baidu.tieba.y.forum)));
            } else {
                this.aEv.setVisibility(8);
            }
            this.aIi.setVisibility(0);
            String portrait = feedData.getReplyer().getPortrait();
            this.aIi.setTag(null);
            this.aIi.c(portrait, 12, false);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        ba.i(getRootView(), com.baidu.tieba.u.list_selector);
        ba.j(this.acX, com.baidu.tieba.s.cp_bg_line_b);
        this.byI.setTextColor(ba.getColor(com.baidu.tieba.s.cp_cont_b));
        this.aGK.setTextColor(ba.getColor(com.baidu.tieba.s.cp_cont_d));
        this.aVe.setTextColor(ba.getColor(com.baidu.tieba.s.cp_cont_f));
        this.aEv.setTextColor(ba.getColor(com.baidu.tieba.s.cp_cont_d));
        this.mTitle.setTextColor(ba.getColor(com.baidu.tieba.s.cp_cont_c));
        ba.b(this.bDe, com.baidu.tieba.s.cp_cont_c, 1);
        this.bDe.setCompoundDrawablesWithIntrinsicBounds(ba.getDrawable(com.baidu.tieba.u.icon_reply_n), (Drawable) null, (Drawable) null, (Drawable) null);
        ba.i((View) this.mTitle, com.baidu.tieba.u.bg_ta_dialog_content);
        return true;
    }
}
