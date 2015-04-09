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
    private TbPageContext<?> XG;
    private TextView aED;
    private TextView aGS;
    private HeadImageView aIq;
    private TextView aVt;
    private View adg;
    private TextView bCT;
    private TextView bDr;
    private TextView byT;
    private TextView mTitle;

    public w(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.XG = tbPageContext;
        this.aIq = (HeadImageView) view.findViewById(com.baidu.tieba.v.photo);
        this.aVt = (TextView) view.findViewById(com.baidu.tieba.v.user_name);
        this.aGS = (TextView) view.findViewById(com.baidu.tieba.v.time);
        this.bCT = (TextView) view.findViewById(com.baidu.tieba.v.add_friend_button);
        this.adg = view.findViewById(com.baidu.tieba.v.line);
        this.byT = (TextView) view.findViewById(com.baidu.tieba.v.content);
        this.mTitle = (TextView) view.findViewById(com.baidu.tieba.v.replyme_title);
        this.aED = (TextView) view.findViewById(com.baidu.tieba.v.forum);
        this.bDr = (TextView) view.findViewById(com.baidu.tieba.v.tv_quick_reply_text);
        this.aIq.setOnClickListener(new x(this));
        this.bCT.setOnClickListener(new y(this));
        view.setOnClickListener(new z(this));
        this.bDr.setOnClickListener(new aa(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.j.e
    /* renamed from: a */
    public void A(FeedData feedData) {
        k kVar;
        super.A(feedData);
        if (FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType())) {
            this.bDr.setVisibility(8);
            List<k> praiseList = feedData.getPraiseList();
            if (praiseList != null && praiseList.size() > 0 && (kVar = praiseList.get(0)) != null) {
                this.aVt.setText(kVar.XK());
                if (kVar.getIsMyFriend() == 1) {
                    this.bCT.setVisibility(8);
                } else {
                    this.bCT.setVisibility(0);
                    this.bCT.setBackgroundDrawable(null);
                    ba.b(this.bCT, com.baidu.tieba.s.cp_link_tip_c, 1);
                    this.bCT.setText(getString(com.baidu.tieba.y.message_add_friend));
                    this.bCT.setCompoundDrawablesWithIntrinsicBounds(ba.getDrawable(com.baidu.tieba.u.icon_friend_add), (Drawable) null, (Drawable) null, (Drawable) null);
                }
                this.aGS.setText(bd.n(feedData.getTime()));
                if (praiseList.size() > 3 && praiseList.get(1) != null && praiseList.get(2) != null) {
                    this.byT.setText(String.format(getString(com.baidu.tieba.y.message_praise_like_list_more), kVar.XK(), praiseList.get(1).XK(), praiseList.get(2).XK(), String.valueOf(feedData.getPraiseNum())));
                } else if (praiseList.size() > 2 && praiseList.get(1) != null && praiseList.get(2) != null) {
                    this.byT.setText(String.format(getString(com.baidu.tieba.y.message_praise_like_list_3), kVar.XK(), praiseList.get(1).XK(), praiseList.get(2).XK()));
                } else if (praiseList.size() > 1 && praiseList.get(1) != null) {
                    this.byT.setText(String.format(getString(com.baidu.tieba.y.message_praise_like_list_2), kVar.XK(), praiseList.get(1).XK()));
                } else {
                    this.byT.setText(String.format(getString(com.baidu.tieba.y.message_praise_like_list_1), kVar.XK()));
                }
                this.mTitle.setText(this.XG.getPageActivity().getString(com.baidu.tieba.y.mention_replyme_original, new Object[]{feedData.getTitle()}));
                if (feedData.getFname() != null && feedData.getFname().length() > 0) {
                    this.aED.setVisibility(0);
                    this.aED.setText(bd.h(feedData.getFname(), 12).concat(getString(com.baidu.tieba.y.forum)));
                } else {
                    this.aED.setVisibility(8);
                }
                this.aIq.setVisibility(0);
                this.aIq.c(kVar.getPortrait(), 12, false);
                return;
            }
            return;
        }
        this.bDr.setVisibility(0);
        this.bDr.setTag(Integer.valueOf(this.position));
        if (feedData.getReplyer() != null) {
            this.aVt.setText(feedData.getReplyer().getName_show());
            if (feedData.getReplyer().getIsMyFriend() == 1) {
                this.bCT.setVisibility(0);
                this.bCT.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                this.bCT.setTextColor(ba.getColor(com.baidu.tieba.s.cp_cont_i));
                this.bCT.setBackgroundDrawable(ba.getDrawable(com.baidu.tieba.u.game_center_start_btn));
                this.bCT.setText(getString(com.baidu.tieba.y.mention_chatme));
            } else {
                this.bCT.setVisibility(0);
                this.bCT.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                this.bCT.setTextColor(ba.getColor(com.baidu.tieba.s.cp_cont_i));
                this.bCT.setBackgroundDrawable(ba.getDrawable(com.baidu.tieba.u.game_center_start_btn));
                this.bCT.setText(getString(com.baidu.tieba.y.mention_chatme));
            }
            this.aGS.setText(bd.n(feedData.getTime()));
            this.byT.setText(feedData.getContent());
            if (feedData.getType() == 1) {
                this.mTitle.setText(this.XG.getPageActivity().getString(com.baidu.tieba.y.mention_replyme_original, new Object[]{feedData.getQuote_content()}));
            } else {
                this.mTitle.setText(this.XG.getPageActivity().getString(com.baidu.tieba.y.mention_replyme_original, new Object[]{feedData.getTitle()}));
            }
            if (feedData.getFname() != null && feedData.getFname().length() > 0) {
                this.aED.setVisibility(0);
                this.aED.setText(bd.h(feedData.getFname(), 12).concat(getString(com.baidu.tieba.y.forum)));
            } else {
                this.aED.setVisibility(8);
            }
            this.aIq.setVisibility(0);
            String portrait = feedData.getReplyer().getPortrait();
            this.aIq.setTag(null);
            this.aIq.c(portrait, 12, false);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        ba.i(getRootView(), com.baidu.tieba.u.list_selector);
        ba.j(this.adg, com.baidu.tieba.s.cp_bg_line_b);
        this.byT.setTextColor(ba.getColor(com.baidu.tieba.s.cp_cont_b));
        this.aGS.setTextColor(ba.getColor(com.baidu.tieba.s.cp_cont_d));
        this.aVt.setTextColor(ba.getColor(com.baidu.tieba.s.cp_cont_f));
        this.aED.setTextColor(ba.getColor(com.baidu.tieba.s.cp_cont_d));
        this.mTitle.setTextColor(ba.getColor(com.baidu.tieba.s.cp_cont_c));
        ba.b(this.bDr, com.baidu.tieba.s.cp_cont_c, 1);
        this.bDr.setCompoundDrawablesWithIntrinsicBounds(ba.getDrawable(com.baidu.tieba.u.icon_reply_n), (Drawable) null, (Drawable) null, (Drawable) null);
        ba.i((View) this.mTitle, com.baidu.tieba.u.bg_ta_dialog_content);
        return true;
    }
}
