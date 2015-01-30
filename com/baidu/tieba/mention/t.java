package com.baidu.tieba.mention;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import java.util.List;
/* loaded from: classes.dex */
public class t extends com.baidu.tbadk.mvc.j.a<FeedData, com.baidu.tbadk.mvc.e.c> {
    private TbPageContext<?> MA;
    private View Td;
    private HeadImageView aCp;
    private TextView aQx;
    private TextView ayA;
    private TextView bsu;
    private TextView btF;
    private LinearLayout btG;
    private ImageView btH;
    private TextView btI;
    private LinearLayout btJ;
    private TextView bti;
    private TextView btj;
    private TextView mTitle;

    public t(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.MA = tbPageContext;
        this.btJ = (LinearLayout) view.findViewById(com.baidu.tieba.w.reply_container);
        this.aCp = (HeadImageView) view.findViewById(com.baidu.tieba.w.photo);
        this.bti = (TextView) view.findViewById(com.baidu.tieba.w.user_name);
        this.ayA = (TextView) view.findViewById(com.baidu.tieba.w.time);
        this.btj = (TextView) view.findViewById(com.baidu.tieba.w.add_friend_button);
        this.Td = view.findViewById(com.baidu.tieba.w.line);
        this.bsu = (TextView) view.findViewById(com.baidu.tieba.w.content);
        this.mTitle = (TextView) view.findViewById(com.baidu.tieba.w.title);
        this.aQx = (TextView) view.findViewById(com.baidu.tieba.w.forum);
        this.btF = (TextView) view.findViewById(com.baidu.tieba.w.reply_type);
        this.btG = (LinearLayout) view.findViewById(com.baidu.tieba.w.ll_quick_reply);
        this.btH = (ImageView) view.findViewById(com.baidu.tieba.w.iv_quick_reply_icon);
        this.btI = (TextView) view.findViewById(com.baidu.tieba.w.tv_quick_reply_text);
        this.aCp.setOnClickListener(new u(this));
        this.btj.setOnClickListener(new v(this));
        view.setOnClickListener(new w(this));
        this.btG.setOnClickListener(new x(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.j.d
    /* renamed from: a */
    public void y(FeedData feedData) {
        k kVar;
        super.y(feedData);
        if (FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType())) {
            this.btG.setVisibility(8);
            List<k> praiseList = feedData.getPraiseList();
            if (praiseList != null && praiseList.size() > 0 && (kVar = praiseList.get(0)) != null) {
                this.bti.setText(kVar.Um());
                if (kVar.getIsMyFriend() == 1) {
                    this.btj.setVisibility(8);
                } else {
                    this.btj.setVisibility(0);
                    this.btj.setBackgroundDrawable(null);
                    bc.b(this.btj, com.baidu.tieba.t.cp_link_tip_c, 1);
                    this.btj.setText(getString(com.baidu.tieba.z.message_add_friend));
                    this.btj.setCompoundDrawablesWithIntrinsicBounds(bc.getDrawable(com.baidu.tieba.v.icon_friend_add), (Drawable) null, (Drawable) null, (Drawable) null);
                }
                this.ayA.setText(bf.n(feedData.getTime()));
                if (praiseList.size() > 3 && praiseList.get(1) != null && praiseList.get(2) != null) {
                    this.bsu.setText(String.format(getString(com.baidu.tieba.z.message_praise_like_list_more), kVar.Um(), praiseList.get(1).Um(), praiseList.get(2).Um(), String.valueOf(feedData.getPraiseNum())));
                } else if (praiseList.size() > 2 && praiseList.get(1) != null && praiseList.get(2) != null) {
                    this.bsu.setText(String.format(getString(com.baidu.tieba.z.message_praise_like_list_3), kVar.Um(), praiseList.get(1).Um(), praiseList.get(2).Um()));
                } else if (praiseList.size() > 1 && praiseList.get(1) != null) {
                    this.bsu.setText(String.format(getString(com.baidu.tieba.z.message_praise_like_list_2), kVar.Um(), praiseList.get(1).Um()));
                } else {
                    this.bsu.setText(String.format(getString(com.baidu.tieba.z.message_praise_like_list_1), kVar.Um()));
                }
                this.mTitle.setText(feedData.getTitle());
                if (feedData.getFname() != null && feedData.getFname().length() > 0) {
                    this.aQx.setVisibility(0);
                    this.aQx.setText(bf.h(feedData.getFname(), 12).concat(getString(com.baidu.tieba.z.forum)));
                } else {
                    this.aQx.setVisibility(8);
                }
                this.aCp.setVisibility(0);
                this.aCp.d(kVar.getPortrait(), 12, false);
                return;
            }
            return;
        }
        this.btG.setVisibility(0);
        this.btG.setTag(Integer.valueOf(this.position));
        if (feedData.getReplyer() != null) {
            this.bti.setText(feedData.getReplyer().getName_show());
            if (feedData.getReplyer().getIsMyFriend() == 1) {
                this.btj.setVisibility(0);
                this.btj.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                this.btj.setTextColor(bc.getColor(com.baidu.tieba.t.cp_cont_i));
                this.btj.setBackgroundDrawable(bc.getDrawable(com.baidu.tieba.v.game_center_start_btn));
                this.btj.setText(getString(com.baidu.tieba.z.mention_chatme));
            } else {
                this.btj.setVisibility(0);
                this.btj.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                this.btj.setTextColor(bc.getColor(com.baidu.tieba.t.cp_cont_i));
                this.btj.setBackgroundDrawable(bc.getDrawable(com.baidu.tieba.v.game_center_start_btn));
                this.btj.setText(getString(com.baidu.tieba.z.mention_chatme));
            }
            this.ayA.setText(bf.n(feedData.getTime()));
            this.bsu.setText(feedData.getContent());
            if (feedData.getType() == 1) {
                this.mTitle.setText(feedData.getQuote_content());
            } else {
                this.mTitle.setText(feedData.getTitle());
            }
            if (feedData.getFname() != null && feedData.getFname().length() > 0) {
                this.aQx.setVisibility(0);
                this.aQx.setText(bf.h(feedData.getFname(), 12).concat(getString(com.baidu.tieba.z.forum)));
            } else {
                this.aQx.setVisibility(8);
            }
            this.aCp.setVisibility(0);
            String portrait = feedData.getReplyer().getPortrait();
            this.aCp.setTag(null);
            this.aCp.d(portrait, 12, false);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.y
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        bc.i(getRootView(), com.baidu.tieba.v.list_selector);
        bc.j(this.Td, com.baidu.tieba.t.cp_bg_line_b);
        this.bsu.setTextColor(bc.getColor(com.baidu.tieba.t.cp_cont_b));
        this.ayA.setTextColor(bc.getColor(com.baidu.tieba.t.cp_cont_d));
        this.bti.setTextColor(bc.getColor(com.baidu.tieba.t.cp_cont_f));
        this.aQx.setTextColor(bc.getColor(com.baidu.tieba.t.cp_cont_d));
        this.mTitle.setTextColor(bc.getColor(com.baidu.tieba.t.cp_cont_c));
        this.btF.setTextColor(bc.getColor(com.baidu.tieba.t.cp_cont_c));
        bc.b(this.btI, com.baidu.tieba.t.cp_cont_c, 1);
        bc.c(this.btH, com.baidu.tieba.v.icon_reply_n);
        bc.i(this.btJ, com.baidu.tieba.v.bg_ta_dialog_content);
        return true;
    }
}
