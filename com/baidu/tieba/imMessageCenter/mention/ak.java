package com.baidu.tieba.imMessageCenter.mention;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.n;
import java.util.List;
/* loaded from: classes.dex */
public class ak extends com.baidu.tbadk.mvc.g.a<FeedData, com.baidu.tbadk.mvc.d.b> {
    private TextView aLY;
    private TextView aUB;
    private TbPageContext<?> aUx;
    private TextView aVi;
    private HeadImageView aYF;
    private TextView bff;
    private TextView ceK;
    private TextView ceL;
    private TextView cee;
    private View mLine;

    public ak(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aUx = tbPageContext;
        this.aYF = (HeadImageView) view.findViewById(n.f.photo);
        this.bff = (TextView) view.findViewById(n.f.user_name);
        this.aVi = (TextView) view.findViewById(n.f.time);
        this.ceK = (TextView) view.findViewById(n.f.add_friend_button);
        this.mLine = view.findViewById(n.f.line);
        this.cee = (TextView) view.findViewById(n.f.content);
        this.aUB = (TextView) view.findViewById(n.f.replyme_title);
        this.aLY = (TextView) view.findViewById(n.f.forum);
        this.ceL = (TextView) view.findViewById(n.f.tv_quick_reply_text);
        this.aYF.setOnClickListener(new al(this));
        this.ceK.setOnClickListener(new am(this));
        view.setOnClickListener(new an(this));
        this.ceL.setOnClickListener(new ao(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void B(FeedData feedData) {
        LikeData likeData;
        super.B(feedData);
        if (FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType())) {
            this.ceL.setVisibility(8);
            List<LikeData> praiseList = feedData.getPraiseList();
            if (praiseList != null && praiseList.size() > 0 && (likeData = praiseList.get(0)) != null) {
                this.bff.setText(likeData.getNameShow());
                this.ceK.setVisibility(8);
                this.aVi.setText(com.baidu.tbadk.core.util.ax.s(feedData.getTime()));
                if (praiseList.size() > 3 && praiseList.get(1) != null && praiseList.get(2) != null) {
                    this.cee.setText(String.format(getString(n.i.message_praise_like_list_more), likeData.getNameShow(), praiseList.get(1).getNameShow(), praiseList.get(2).getNameShow(), String.valueOf(feedData.getPraiseNum())));
                } else if (praiseList.size() > 2 && praiseList.get(1) != null && praiseList.get(2) != null) {
                    this.cee.setText(String.format(getString(n.i.message_praise_like_list_3), likeData.getNameShow(), praiseList.get(1).getNameShow(), praiseList.get(2).getNameShow()));
                } else if (praiseList.size() > 1 && praiseList.get(1) != null) {
                    this.cee.setText(String.format(getString(n.i.message_praise_like_list_2), likeData.getNameShow(), praiseList.get(1).getNameShow()));
                } else {
                    this.cee.setText(String.format(getString(n.i.message_praise_like_list_1), likeData.getNameShow()));
                }
                this.aUB.setText(this.aUx.getPageActivity().getString(n.i.mention_replyme_original, new Object[]{feedData.getTitle()}));
                if (feedData.getThread_Type() == 33) {
                    this.aUB.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.as.getDrawable(n.e.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
                } else {
                    this.aUB.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (feedData.getFname() != null && feedData.getFname().length() > 0) {
                    this.aLY.setVisibility(0);
                    this.aLY.setText(com.baidu.tbadk.core.util.ax.i(feedData.getFname(), 12).concat(getString(n.i.forum)));
                } else {
                    this.aLY.setVisibility(8);
                }
                this.aYF.setVisibility(0);
                this.aYF.d(likeData.getPortrait(), 12, false);
                return;
            }
            return;
        }
        this.ceL.setVisibility(0);
        this.ceL.setTag(Integer.valueOf(this.position));
        if (feedData.getReplyer() != null) {
            this.bff.setText(feedData.getReplyer().getName_show());
            if (feedData.getReplyer().getIsMyFriend() == 1) {
                this.ceK.setVisibility(0);
                this.ceK.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                this.ceK.setTextColor(com.baidu.tbadk.core.util.as.getColor(n.c.cp_cont_i));
                this.ceK.setBackgroundDrawable(com.baidu.tbadk.core.util.as.getDrawable(n.e.game_center_start_btn));
                this.ceK.setText(getString(n.i.mention_chatme));
            } else {
                this.ceK.setVisibility(0);
                this.ceK.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                this.ceK.setTextColor(com.baidu.tbadk.core.util.as.getColor(n.c.cp_cont_i));
                this.ceK.setBackgroundDrawable(com.baidu.tbadk.core.util.as.getDrawable(n.e.game_center_start_btn));
                this.ceK.setText(getString(n.i.mention_chatme));
            }
            this.aVi.setText(com.baidu.tbadk.core.util.ax.s(feedData.getTime()));
            this.cee.setText(feedData.getContent());
            if (feedData.getType() == 1) {
                this.aUB.setText(this.aUx.getPageActivity().getString(n.i.mention_replyme_original, new Object[]{feedData.getQuote_content()}));
            } else {
                this.aUB.setText(this.aUx.getPageActivity().getString(n.i.mention_replyme_original, new Object[]{feedData.getTitle()}));
            }
            if (feedData.getThread_Type() == 33) {
                this.aUB.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.as.getDrawable(n.e.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.aUB.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            if (feedData.getFname() != null && feedData.getFname().length() > 0) {
                this.aLY.setVisibility(0);
                this.aLY.setText(com.baidu.tbadk.core.util.ax.i(feedData.getFname(), 12).concat(getString(n.i.forum)));
            } else {
                this.aLY.setVisibility(8);
            }
            this.aYF.setVisibility(0);
            String portrait = feedData.getReplyer().getPortrait();
            this.aYF.setTag(null);
            this.aYF.d(portrait, 12, false);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.t
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.core.util.as.i(getRootView(), n.e.list_selector);
        com.baidu.tbadk.core.util.as.j(this.mLine, n.c.cp_bg_line_b);
        this.cee.setTextColor(com.baidu.tbadk.core.util.as.getColor(n.c.cp_cont_b));
        this.aVi.setTextColor(com.baidu.tbadk.core.util.as.getColor(n.c.cp_cont_d));
        this.bff.setTextColor(com.baidu.tbadk.core.util.as.getColor(n.c.cp_cont_f));
        this.aLY.setTextColor(com.baidu.tbadk.core.util.as.getColor(n.c.cp_cont_d));
        this.aUB.setTextColor(com.baidu.tbadk.core.util.as.getColor(n.c.cp_cont_c));
        com.baidu.tbadk.core.util.as.b(this.ceL, n.c.cp_cont_c, 1);
        this.ceL.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.as.getDrawable(n.e.icon_reply_n), (Drawable) null, (Drawable) null, (Drawable) null);
        com.baidu.tbadk.core.util.as.i((View) this.aUB, n.e.bg_ta_dialog_content);
        return true;
    }
}
