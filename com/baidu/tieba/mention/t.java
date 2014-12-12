package com.baidu.tieba.mention;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import java.util.List;
/* loaded from: classes.dex */
public class t extends com.baidu.tbadk.mvc.j.a<FeedData, com.baidu.tbadk.mvc.e.c> {
    private TbPageContext<?> Me;
    private HeadImageView aBo;
    private TextView aPs;
    private TextView axA;
    private TextView bqW;
    private TextView brM;
    private TextView brN;
    private TextView bsi;
    private LinearLayout bsj;
    private ImageView bsk;
    private TextView bsl;
    private LinearLayout bsm;
    private View mLine;
    private TextView mTitle;

    public t(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.Me = tbPageContext;
        this.bsm = (LinearLayout) view.findViewById(com.baidu.tieba.w.reply_container);
        this.aBo = (HeadImageView) view.findViewById(com.baidu.tieba.w.photo);
        this.brM = (TextView) view.findViewById(com.baidu.tieba.w.user_name);
        this.axA = (TextView) view.findViewById(com.baidu.tieba.w.time);
        this.brN = (TextView) view.findViewById(com.baidu.tieba.w.add_friend_button);
        this.mLine = view.findViewById(com.baidu.tieba.w.line);
        this.bqW = (TextView) view.findViewById(com.baidu.tieba.w.content);
        this.mTitle = (TextView) view.findViewById(com.baidu.tieba.w.title);
        this.aPs = (TextView) view.findViewById(com.baidu.tieba.w.forum);
        this.bsi = (TextView) view.findViewById(com.baidu.tieba.w.reply_type);
        this.bsj = (LinearLayout) view.findViewById(com.baidu.tieba.w.ll_quick_reply);
        this.bsk = (ImageView) view.findViewById(com.baidu.tieba.w.iv_quick_reply_icon);
        this.bsl = (TextView) view.findViewById(com.baidu.tieba.w.tv_quick_reply_text);
        this.aBo.setOnClickListener(new u(this));
        this.brN.setOnClickListener(new v(this));
        view.setOnClickListener(new w(this));
        this.bsj.setOnClickListener(new x(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.j.d
    /* renamed from: a */
    public void y(FeedData feedData) {
        k kVar;
        super.y(feedData);
        if (FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType())) {
            this.bsj.setVisibility(8);
            List<k> praiseList = feedData.getPraiseList();
            if (praiseList != null && praiseList.size() > 0 && (kVar = praiseList.get(0)) != null) {
                this.brM.setText(kVar.TP());
                if (kVar.getIsMyFriend() == 1) {
                    this.brN.setVisibility(8);
                } else {
                    this.brN.setVisibility(0);
                    this.brN.setBackgroundDrawable(null);
                    ax.b(this.brN, com.baidu.tieba.t.cp_link_tip_c, 1);
                    this.brN.setText(getString(com.baidu.tieba.z.message_add_friend));
                    this.brN.setCompoundDrawablesWithIntrinsicBounds(ax.getDrawable(com.baidu.tieba.v.icon_friend_add), (Drawable) null, (Drawable) null, (Drawable) null);
                }
                this.axA.setText(ba.n(feedData.getTime()));
                if (praiseList.size() > 3 && praiseList.get(1) != null && praiseList.get(2) != null) {
                    this.bqW.setText(String.format(getString(com.baidu.tieba.z.message_praise_like_list_more), kVar.TP(), praiseList.get(1).TP(), praiseList.get(2).TP(), String.valueOf(feedData.getPraiseNum())));
                } else if (praiseList.size() > 2 && praiseList.get(1) != null && praiseList.get(2) != null) {
                    this.bqW.setText(String.format(getString(com.baidu.tieba.z.message_praise_like_list_3), kVar.TP(), praiseList.get(1).TP(), praiseList.get(2).TP()));
                } else if (praiseList.size() > 1 && praiseList.get(1) != null) {
                    this.bqW.setText(String.format(getString(com.baidu.tieba.z.message_praise_like_list_2), kVar.TP(), praiseList.get(1).TP()));
                } else {
                    this.bqW.setText(String.format(getString(com.baidu.tieba.z.message_praise_like_list_1), kVar.TP()));
                }
                this.mTitle.setText(feedData.getTitle());
                if (feedData.getFname() != null && feedData.getFname().length() > 0) {
                    this.aPs.setVisibility(0);
                    this.aPs.setText(ba.h(feedData.getFname(), 12).concat(getString(com.baidu.tieba.z.forum)));
                } else {
                    this.aPs.setVisibility(8);
                }
                this.aBo.setVisibility(0);
                this.aBo.d(kVar.getPortrait(), 12, false);
                return;
            }
            return;
        }
        this.bsj.setVisibility(0);
        this.bsj.setTag(Integer.valueOf(this.position));
        if (feedData.getReplyer() != null) {
            this.brM.setText(feedData.getReplyer().getName_show());
            if (feedData.getReplyer().getIsMyFriend() == 1) {
                this.brN.setVisibility(0);
                this.brN.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                this.brN.setTextColor(ax.getColor(com.baidu.tieba.t.cp_cont_i));
                this.brN.setBackgroundDrawable(ax.getDrawable(com.baidu.tieba.v.game_center_start_btn));
                this.brN.setText(getString(com.baidu.tieba.z.mention_chatme));
            } else {
                this.brN.setVisibility(0);
                this.brN.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                this.brN.setTextColor(ax.getColor(com.baidu.tieba.t.cp_cont_i));
                this.brN.setBackgroundDrawable(ax.getDrawable(com.baidu.tieba.v.game_center_start_btn));
                this.brN.setText(getString(com.baidu.tieba.z.mention_chatme));
            }
            this.axA.setText(ba.n(feedData.getTime()));
            this.bqW.setText(feedData.getContent());
            if (feedData.getType() == 1) {
                this.mTitle.setText(feedData.getQuote_content());
            } else {
                this.mTitle.setText(feedData.getTitle());
            }
            if (feedData.getFname() != null && feedData.getFname().length() > 0) {
                this.aPs.setVisibility(0);
                this.aPs.setText(ba.h(feedData.getFname(), 12).concat(getString(com.baidu.tieba.z.forum)));
            } else {
                this.aPs.setVisibility(8);
            }
            this.aBo.setVisibility(0);
            String portrait = feedData.getReplyer().getPortrait();
            this.aBo.setTag(null);
            this.aBo.d(portrait, 12, false);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.y
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        ax.i(getRootView(), com.baidu.tieba.v.list_selector);
        ax.j(this.mLine, com.baidu.tieba.t.cp_bg_line_b);
        this.bqW.setTextColor(ax.getColor(com.baidu.tieba.t.cp_cont_b));
        this.axA.setTextColor(ax.getColor(com.baidu.tieba.t.cp_cont_d));
        this.brM.setTextColor(ax.getColor(com.baidu.tieba.t.cp_cont_f));
        this.aPs.setTextColor(ax.getColor(com.baidu.tieba.t.cp_cont_d));
        this.mTitle.setTextColor(ax.getColor(com.baidu.tieba.t.cp_cont_c));
        this.bsi.setTextColor(ax.getColor(com.baidu.tieba.t.cp_cont_c));
        ax.b(this.bsl, com.baidu.tieba.t.cp_cont_c, 1);
        ax.c(this.bsk, com.baidu.tieba.v.icon_reply_n);
        ax.i(this.bsm, com.baidu.tieba.v.bg_ta_dialog_content);
        return true;
    }
}
