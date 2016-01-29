package com.baidu.tieba.imMessageCenter.mention;

import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.t;
import java.util.List;
/* loaded from: classes.dex */
public class al extends com.baidu.tbadk.mvc.g.a<FeedData, com.baidu.tbadk.mvc.d.b> {
    private TextView aPa;
    private TextView aPr;
    private TextView ahH;
    private View amq;
    private TbPageContext<?> baN;
    private TextView bbx;
    private HeadImageView beU;
    private TextView cmF;
    private TextView cnm;
    private TextView cnn;
    private SpannableString cno;
    private SpannableString cnp;

    public al(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.baN = tbPageContext;
        this.beU = (HeadImageView) view.findViewById(t.g.photo);
        this.ahH = (TextView) view.findViewById(t.g.user_name);
        this.bbx = (TextView) view.findViewById(t.g.time);
        this.cnm = (TextView) view.findViewById(t.g.add_friend_button);
        this.amq = view.findViewById(t.g.line);
        this.cmF = (TextView) view.findViewById(t.g.content);
        this.aPr = (TextView) view.findViewById(t.g.replyme_title);
        this.aPa = (TextView) view.findViewById(t.g.forum);
        this.cnn = (TextView) view.findViewById(t.g.tv_quick_reply_text);
        this.beU.setOnClickListener(new am(this));
        this.cnm.setOnClickListener(new an(this));
        view.setOnClickListener(new ao(this));
        this.cnn.setOnClickListener(new ap(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void B(FeedData feedData) {
        LikeData likeData;
        super.B(feedData);
        if (FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType())) {
            this.cnn.setVisibility(8);
            List<LikeData> praiseList = feedData.getPraiseList();
            if (praiseList != null && praiseList.size() > 0 && (likeData = praiseList.get(0)) != null) {
                this.ahH.setText(likeData.getNameShow());
                this.cnm.setVisibility(8);
                this.bbx.setText(com.baidu.tbadk.core.util.aw.t(feedData.getTime()));
                if (praiseList.size() > 3 && praiseList.get(1) != null && praiseList.get(2) != null) {
                    this.cmF.setText(String.format(getString(t.j.message_praise_like_list_more), likeData.getNameShow(), praiseList.get(1).getNameShow(), praiseList.get(2).getNameShow(), String.valueOf(feedData.getPraiseNum())));
                } else if (praiseList.size() > 2 && praiseList.get(1) != null && praiseList.get(2) != null) {
                    this.cmF.setText(String.format(getString(t.j.message_praise_like_list_3), likeData.getNameShow(), praiseList.get(1).getNameShow(), praiseList.get(2).getNameShow()));
                } else if (praiseList.size() > 1 && praiseList.get(1) != null) {
                    this.cmF.setText(String.format(getString(t.j.message_praise_like_list_2), likeData.getNameShow(), praiseList.get(1).getNameShow()));
                } else {
                    this.cmF.setText(String.format(getString(t.j.message_praise_like_list_1), likeData.getNameShow()));
                }
                this.aPr.setText(this.baN.getPageActivity().getString(t.j.mention_replyme_original, new Object[]{feedData.getTitle()}));
                if (feedData.getThread_Type() == 33) {
                    this.aPr.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.ar.getDrawable(t.f.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
                } else {
                    this.aPr.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (feedData.getFname() != null && feedData.getFname().length() > 0) {
                    this.aPa.setVisibility(0);
                    this.aPa.setText(com.baidu.tbadk.core.util.aw.j(feedData.getFname(), 12).concat(getString(t.j.forum)));
                } else {
                    this.aPa.setVisibility(8);
                }
                this.beU.setVisibility(0);
                this.beU.d(likeData.getPortrait(), 12, false);
                return;
            }
            return;
        }
        this.cnn.setVisibility(0);
        this.cnn.setTag(Integer.valueOf(this.position));
        if (feedData.getReplyer() != null) {
            this.ahH.setText(feedData.getReplyer().getName_show());
            if (feedData.getReplyer().getIsMyFriend() == 1) {
                this.cnm.setVisibility(0);
                this.cnm.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                this.cnm.setTextColor(com.baidu.tbadk.core.util.ar.getColor(t.d.cp_cont_i));
                this.cnm.setBackgroundDrawable(com.baidu.tbadk.core.util.ar.getDrawable(t.f.game_center_start_btn));
                this.cnm.setText(getString(t.j.mention_chatme));
            } else {
                this.cnm.setVisibility(0);
                this.cnm.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                this.cnm.setTextColor(com.baidu.tbadk.core.util.ar.getColor(t.d.cp_cont_i));
                this.cnm.setBackgroundDrawable(com.baidu.tbadk.core.util.ar.getDrawable(t.f.game_center_start_btn));
                this.cnm.setText(getString(t.j.mention_chatme));
            }
            this.bbx.setText(com.baidu.tbadk.core.util.aw.t(feedData.getTime()));
            this.cno = TbFaceManager.Ec().a(this.baN.getPageActivity().getApplicationContext(), feedData.getContent(), null);
            this.cmF.setText(a(this.cmF, this.cno));
            if (feedData.getThread_Type() == 33) {
                this.aPr.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.ar.getDrawable(t.f.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.aPr.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            if (feedData.getType() == 1) {
                this.cnp = TbFaceManager.Ec().a(this.baN.getPageActivity().getApplicationContext(), this.baN.getPageActivity().getString(t.j.mention_replyme_original, new Object[]{feedData.getQuote_content()}), null);
                this.aPr.setText(a(this.aPr, this.cnp));
            } else {
                this.aPr.setText(this.baN.getPageActivity().getString(t.j.mention_replyme_original, new Object[]{feedData.getTitle()}));
            }
            if (feedData.getFname() != null && feedData.getFname().length() > 0) {
                this.aPa.setVisibility(0);
                this.aPa.setText(com.baidu.tbadk.core.util.aw.j(feedData.getFname(), 12).concat(getString(t.j.forum)));
            } else {
                this.aPa.setVisibility(8);
            }
            this.beU.setVisibility(0);
            String portrait = feedData.getReplyer().getPortrait();
            this.beU.setTag(null);
            this.beU.d(portrait, 12, false);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.core.util.ar.k(getRootView(), t.f.list_selector);
        com.baidu.tbadk.core.util.ar.l(this.amq, t.d.cp_bg_line_b);
        this.cmF.setTextColor(com.baidu.tbadk.core.util.ar.getColor(t.d.cp_cont_b));
        this.bbx.setTextColor(com.baidu.tbadk.core.util.ar.getColor(t.d.cp_cont_d));
        this.ahH.setTextColor(com.baidu.tbadk.core.util.ar.getColor(t.d.cp_cont_f));
        this.aPa.setTextColor(com.baidu.tbadk.core.util.ar.getColor(t.d.cp_cont_d));
        this.aPr.setTextColor(com.baidu.tbadk.core.util.ar.getColor(t.d.cp_cont_c));
        com.baidu.tbadk.core.util.ar.b(this.cnn, t.d.cp_cont_c, 1);
        this.cnn.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.ar.getDrawable(t.f.icon_reply_n), (Drawable) null, (Drawable) null, (Drawable) null);
        com.baidu.tbadk.core.util.ar.k(this.aPr, t.f.bg_ta_dialog_content);
        return true;
    }

    private CharSequence a(TextView textView, SpannableString spannableString) {
        if (textView == null || spannableString == null || this.baN == null) {
            return null;
        }
        return TextUtils.ellipsize(spannableString, textView.getPaint(), (com.baidu.adp.lib.util.k.K(this.baN.getPageActivity()) - (this.baN.getResources().getDimensionPixelSize(t.e.ds30) * 2)) - textView.getCompoundPaddingLeft(), TextUtils.TruncateAt.END);
    }
}
