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
    private TbPageContext<?> Mx;
    private View Ta;
    private HeadImageView aCm;
    private TextView aQw;
    private TextView ayx;
    private TextView bst;
    private TextView btE;
    private LinearLayout btF;
    private ImageView btG;
    private TextView btH;
    private LinearLayout btI;
    private TextView bth;
    private TextView bti;
    private TextView mTitle;

    public t(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.Mx = tbPageContext;
        this.btI = (LinearLayout) view.findViewById(com.baidu.tieba.w.reply_container);
        this.aCm = (HeadImageView) view.findViewById(com.baidu.tieba.w.photo);
        this.bth = (TextView) view.findViewById(com.baidu.tieba.w.user_name);
        this.ayx = (TextView) view.findViewById(com.baidu.tieba.w.time);
        this.bti = (TextView) view.findViewById(com.baidu.tieba.w.add_friend_button);
        this.Ta = view.findViewById(com.baidu.tieba.w.line);
        this.bst = (TextView) view.findViewById(com.baidu.tieba.w.content);
        this.mTitle = (TextView) view.findViewById(com.baidu.tieba.w.title);
        this.aQw = (TextView) view.findViewById(com.baidu.tieba.w.forum);
        this.btE = (TextView) view.findViewById(com.baidu.tieba.w.reply_type);
        this.btF = (LinearLayout) view.findViewById(com.baidu.tieba.w.ll_quick_reply);
        this.btG = (ImageView) view.findViewById(com.baidu.tieba.w.iv_quick_reply_icon);
        this.btH = (TextView) view.findViewById(com.baidu.tieba.w.tv_quick_reply_text);
        this.aCm.setOnClickListener(new u(this));
        this.bti.setOnClickListener(new v(this));
        view.setOnClickListener(new w(this));
        this.btF.setOnClickListener(new x(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.j.d
    /* renamed from: a */
    public void y(FeedData feedData) {
        k kVar;
        super.y(feedData);
        if (FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType())) {
            this.btF.setVisibility(8);
            List<k> praiseList = feedData.getPraiseList();
            if (praiseList != null && praiseList.size() > 0 && (kVar = praiseList.get(0)) != null) {
                this.bth.setText(kVar.Uh());
                if (kVar.getIsMyFriend() == 1) {
                    this.bti.setVisibility(8);
                } else {
                    this.bti.setVisibility(0);
                    this.bti.setBackgroundDrawable(null);
                    bc.b(this.bti, com.baidu.tieba.t.cp_link_tip_c, 1);
                    this.bti.setText(getString(com.baidu.tieba.z.message_add_friend));
                    this.bti.setCompoundDrawablesWithIntrinsicBounds(bc.getDrawable(com.baidu.tieba.v.icon_friend_add), (Drawable) null, (Drawable) null, (Drawable) null);
                }
                this.ayx.setText(bf.n(feedData.getTime()));
                if (praiseList.size() > 3 && praiseList.get(1) != null && praiseList.get(2) != null) {
                    this.bst.setText(String.format(getString(com.baidu.tieba.z.message_praise_like_list_more), kVar.Uh(), praiseList.get(1).Uh(), praiseList.get(2).Uh(), String.valueOf(feedData.getPraiseNum())));
                } else if (praiseList.size() > 2 && praiseList.get(1) != null && praiseList.get(2) != null) {
                    this.bst.setText(String.format(getString(com.baidu.tieba.z.message_praise_like_list_3), kVar.Uh(), praiseList.get(1).Uh(), praiseList.get(2).Uh()));
                } else if (praiseList.size() > 1 && praiseList.get(1) != null) {
                    this.bst.setText(String.format(getString(com.baidu.tieba.z.message_praise_like_list_2), kVar.Uh(), praiseList.get(1).Uh()));
                } else {
                    this.bst.setText(String.format(getString(com.baidu.tieba.z.message_praise_like_list_1), kVar.Uh()));
                }
                this.mTitle.setText(feedData.getTitle());
                if (feedData.getFname() != null && feedData.getFname().length() > 0) {
                    this.aQw.setVisibility(0);
                    this.aQw.setText(bf.h(feedData.getFname(), 12).concat(getString(com.baidu.tieba.z.forum)));
                } else {
                    this.aQw.setVisibility(8);
                }
                this.aCm.setVisibility(0);
                this.aCm.d(kVar.getPortrait(), 12, false);
                return;
            }
            return;
        }
        this.btF.setVisibility(0);
        this.btF.setTag(Integer.valueOf(this.position));
        if (feedData.getReplyer() != null) {
            this.bth.setText(feedData.getReplyer().getName_show());
            if (feedData.getReplyer().getIsMyFriend() == 1) {
                this.bti.setVisibility(0);
                this.bti.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                this.bti.setTextColor(bc.getColor(com.baidu.tieba.t.cp_cont_i));
                this.bti.setBackgroundDrawable(bc.getDrawable(com.baidu.tieba.v.game_center_start_btn));
                this.bti.setText(getString(com.baidu.tieba.z.mention_chatme));
            } else {
                this.bti.setVisibility(0);
                this.bti.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                this.bti.setTextColor(bc.getColor(com.baidu.tieba.t.cp_cont_i));
                this.bti.setBackgroundDrawable(bc.getDrawable(com.baidu.tieba.v.game_center_start_btn));
                this.bti.setText(getString(com.baidu.tieba.z.mention_chatme));
            }
            this.ayx.setText(bf.n(feedData.getTime()));
            this.bst.setText(feedData.getContent());
            if (feedData.getType() == 1) {
                this.mTitle.setText(feedData.getQuote_content());
            } else {
                this.mTitle.setText(feedData.getTitle());
            }
            if (feedData.getFname() != null && feedData.getFname().length() > 0) {
                this.aQw.setVisibility(0);
                this.aQw.setText(bf.h(feedData.getFname(), 12).concat(getString(com.baidu.tieba.z.forum)));
            } else {
                this.aQw.setVisibility(8);
            }
            this.aCm.setVisibility(0);
            String portrait = feedData.getReplyer().getPortrait();
            this.aCm.setTag(null);
            this.aCm.d(portrait, 12, false);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.y
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        bc.i(getRootView(), com.baidu.tieba.v.list_selector);
        bc.j(this.Ta, com.baidu.tieba.t.cp_bg_line_b);
        this.bst.setTextColor(bc.getColor(com.baidu.tieba.t.cp_cont_b));
        this.ayx.setTextColor(bc.getColor(com.baidu.tieba.t.cp_cont_d));
        this.bth.setTextColor(bc.getColor(com.baidu.tieba.t.cp_cont_f));
        this.aQw.setTextColor(bc.getColor(com.baidu.tieba.t.cp_cont_d));
        this.mTitle.setTextColor(bc.getColor(com.baidu.tieba.t.cp_cont_c));
        this.btE.setTextColor(bc.getColor(com.baidu.tieba.t.cp_cont_c));
        bc.b(this.btH, com.baidu.tieba.t.cp_cont_c, 1);
        bc.c(this.btG, com.baidu.tieba.v.icon_reply_n);
        bc.i(this.btI, com.baidu.tieba.v.bg_ta_dialog_content);
        return true;
    }
}
