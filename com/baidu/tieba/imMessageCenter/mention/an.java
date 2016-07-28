package com.baidu.tieba.imMessageCenter.mention;

import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.u;
import java.util.List;
/* loaded from: classes.dex */
public class an extends com.baidu.tbadk.mvc.g.a<FeedData, com.baidu.tbadk.mvc.d.b> {
    private TextView aSZ;
    private TextView aeS;
    private View ajP;
    private TextView bAf;
    private HeadImageView bHl;
    private TextView bbc;
    private TbPageContext<?> bzv;
    private TextView dgx;
    private TextView dhg;
    private TextView dhh;
    private SpannableString dhi;
    private SpannableString dhj;

    public an(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.bzv = tbPageContext;
        this.bHl = (HeadImageView) view.findViewById(u.g.photo);
        this.aeS = (TextView) view.findViewById(u.g.user_name);
        this.bAf = (TextView) view.findViewById(u.g.time);
        this.dhg = (TextView) view.findViewById(u.g.add_friend_button);
        this.ajP = view.findViewById(u.g.line);
        this.dgx = (TextView) view.findViewById(u.g.content);
        this.aSZ = (TextView) view.findViewById(u.g.replyme_title);
        this.bbc = (TextView) view.findViewById(u.g.forum);
        this.dhh = (TextView) view.findViewById(u.g.tv_quick_reply_text);
        this.bHl.setOnClickListener(new ao(this));
        this.dhg.setOnClickListener(new ap(this));
        view.setOnClickListener(new aq(this));
        this.dhh.setOnClickListener(new ar(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void E(FeedData feedData) {
        super.E(feedData);
        if (FeedData.TYPE_GRAFFITI.equals(feedData.getPraiseItemType()) || FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType())) {
            if (com.baidu.tieba.graffiti.d.aeW()) {
                c(feedData);
                return;
            } else if (com.baidu.tieba.graffiti.d.al(null)) {
                b(feedData);
                return;
            } else {
                return;
            }
        }
        this.dhh.setVisibility(0);
        this.dhh.setTag(Integer.valueOf(this.position));
        if (feedData.getReplyer() != null) {
            this.aeS.setText(feedData.getReplyer().getName_show());
            if (feedData.getReplyer().getIsMyFriend() == 1) {
                this.dhg.setVisibility(0);
                this.dhg.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                this.dhg.setTextColor(com.baidu.tbadk.core.util.av.getColor(u.d.cp_cont_i));
                this.dhg.setBackgroundDrawable(com.baidu.tbadk.core.util.av.getDrawable(u.f.game_center_start_btn));
                this.dhg.setText(getString(u.j.mention_chatme));
            } else {
                this.dhg.setVisibility(0);
                this.dhg.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                this.dhg.setTextColor(com.baidu.tbadk.core.util.av.getColor(u.d.cp_cont_i));
                this.dhg.setBackgroundDrawable(com.baidu.tbadk.core.util.av.getDrawable(u.f.game_center_start_btn));
                this.dhg.setText(getString(u.j.mention_chatme));
            }
            this.bAf.setText(com.baidu.tbadk.core.util.ba.t(feedData.getTime()));
            this.dhi = TbFaceManager.CO().a(this.bzv.getPageActivity().getApplicationContext(), feedData.getContent(), null);
            this.dgx.setText(a(this.dgx, this.dhi));
            if (feedData.getThread_Type() == 33) {
                this.aSZ.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.av.getDrawable(u.f.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.aSZ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            if (feedData.getType() == 1) {
                this.dhj = TbFaceManager.CO().a(this.bzv.getPageActivity().getApplicationContext(), this.bzv.getPageActivity().getString(u.j.mention_replyme_original, new Object[]{feedData.getQuote_content()}), null);
                this.aSZ.setText(a(this.aSZ, this.dhj));
            } else {
                this.aSZ.setText(this.bzv.getPageActivity().getString(u.j.mention_replyme_original, new Object[]{feedData.getTitle()}));
            }
            if (feedData.getFname() != null && feedData.getFname().length() > 0) {
                this.bbc.setVisibility(0);
                this.bbc.setText(com.baidu.tbadk.core.util.ba.j(feedData.getFname(), 12).concat(getString(u.j.forum)));
            } else {
                this.bbc.setVisibility(8);
            }
            this.bHl.setVisibility(0);
            String portrait = feedData.getReplyer().getPortrait();
            this.bHl.setTag(null);
            this.bHl.c(portrait, 12, false);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.t
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.core.util.av.k(getRootView(), u.f.list_selector);
        com.baidu.tbadk.core.util.av.l(this.ajP, u.d.cp_bg_line_b);
        this.dgx.setTextColor(com.baidu.tbadk.core.util.av.getColor(u.d.cp_cont_b));
        this.bAf.setTextColor(com.baidu.tbadk.core.util.av.getColor(u.d.cp_cont_d));
        this.aeS.setTextColor(com.baidu.tbadk.core.util.av.getColor(u.d.cp_cont_f));
        this.bbc.setTextColor(com.baidu.tbadk.core.util.av.getColor(u.d.cp_cont_d));
        this.aSZ.setTextColor(com.baidu.tbadk.core.util.av.getColor(u.d.cp_cont_c));
        com.baidu.tbadk.core.util.av.c(this.dhh, u.d.cp_cont_c, 1);
        this.dhh.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.av.getDrawable(u.f.icon_reply_n), (Drawable) null, (Drawable) null, (Drawable) null);
        com.baidu.tbadk.core.util.av.k(this.aSZ, u.f.bg_ta_dialog_content);
        return true;
    }

    private CharSequence a(TextView textView, SpannableString spannableString) {
        if (textView == null || spannableString == null || this.bzv == null) {
            return null;
        }
        return TextUtils.ellipsize(spannableString, textView.getPaint(), (com.baidu.adp.lib.util.k.A(this.bzv.getPageActivity()) - (this.bzv.getResources().getDimensionPixelSize(u.e.ds30) * 2)) - textView.getCompoundPaddingLeft(), TextUtils.TruncateAt.END);
    }

    private void b(FeedData feedData) {
        LikeData likeData;
        if (FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType())) {
            this.dhh.setVisibility(8);
            List<LikeData> praiseList = feedData.getPraiseList();
            if (praiseList != null && praiseList.size() > 0 && (likeData = praiseList.get(0)) != null) {
                this.aeS.setText(likeData.getNameShow());
                this.dhg.setVisibility(8);
                this.bAf.setText(com.baidu.tbadk.core.util.ba.t(feedData.getTime()));
                if (praiseList.size() > 3 && praiseList.get(1) != null && praiseList.get(2) != null) {
                    this.dgx.setText(String.format(getString(u.j.message_praise_like_list_more), likeData.getNameShow(), praiseList.get(1).getNameShow(), praiseList.get(2).getNameShow(), String.valueOf(feedData.getPraiseNum())));
                } else if (praiseList.size() > 2 && praiseList.get(1) != null && praiseList.get(2) != null) {
                    this.dgx.setText(String.format(getString(u.j.message_praise_like_list_3), likeData.getNameShow(), praiseList.get(1).getNameShow(), praiseList.get(2).getNameShow()));
                } else if (praiseList.size() > 1 && praiseList.get(1) != null) {
                    this.dgx.setText(String.format(getString(u.j.message_praise_like_list_2), likeData.getNameShow(), praiseList.get(1).getNameShow()));
                } else {
                    this.dgx.setText(String.format(getString(u.j.message_praise_like_list_1), likeData.getNameShow()));
                }
                this.aSZ.setText(this.bzv.getPageActivity().getString(u.j.mention_replyme_original, new Object[]{feedData.getTitle()}));
                if (feedData.getThread_Type() == 33) {
                    this.aSZ.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.av.getDrawable(u.f.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
                } else {
                    this.aSZ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (feedData.getFname() != null && feedData.getFname().length() > 0) {
                    this.bbc.setVisibility(0);
                    this.bbc.setText(com.baidu.tbadk.core.util.ba.j(feedData.getFname(), 12).concat(getString(u.j.forum)));
                } else {
                    this.bbc.setVisibility(8);
                }
                this.bHl.setVisibility(0);
                this.bHl.c(likeData.getPortrait(), 12, false);
            }
        }
    }

    private void c(FeedData feedData) {
        LikeData likeData;
        String string;
        String string2;
        String string3;
        String string4;
        this.dhh.setVisibility(8);
        List<LikeData> praiseList = feedData.getPraiseList();
        if (praiseList != null && praiseList.size() > 0 && (likeData = praiseList.get(0)) != null) {
            this.aeS.setText(likeData.getNameShow());
            this.dhg.setVisibility(8);
            this.bAf.setText(com.baidu.tbadk.core.util.ba.t(feedData.getTime()));
            if (praiseList.size() > 3 && praiseList.get(1) != null && praiseList.get(2) != null) {
                if (feedData.isAuthor()) {
                    string4 = getString(u.j.message_praise_graffiti_author_list_more);
                } else {
                    string4 = getString(u.j.message_praise_graffiti_list_more);
                }
                Object[] objArr = new Object[4];
                objArr[0] = StringUtils.isNull(likeData.getNameShow()) ? likeData.getName() : likeData.getNameShow();
                objArr[1] = StringUtils.isNull(praiseList.get(1).getNameShow()) ? praiseList.get(1).getName() : praiseList.get(1).getNameShow();
                objArr[2] = StringUtils.isNull(praiseList.get(2).getNameShow()) ? praiseList.get(2).getName() : praiseList.get(2).getNameShow();
                objArr[3] = com.baidu.tbadk.core.util.ba.z(feedData.getPraiseNum());
                this.dgx.setText(String.format(string4, objArr));
            } else if (praiseList.size() > 2 && praiseList.get(1) != null && praiseList.get(2) != null) {
                if (feedData.isAuthor()) {
                    string3 = getString(u.j.message_praise_graffiti_author_list_3);
                } else {
                    string3 = getString(u.j.message_praise_graffiti_list_3);
                }
                Object[] objArr2 = new Object[3];
                objArr2[0] = StringUtils.isNull(likeData.getNameShow()) ? likeData.getName() : likeData.getNameShow();
                objArr2[1] = StringUtils.isNull(praiseList.get(1).getNameShow()) ? praiseList.get(1).getName() : praiseList.get(1).getNameShow();
                objArr2[2] = StringUtils.isNull(praiseList.get(2).getNameShow()) ? praiseList.get(2).getName() : praiseList.get(2).getNameShow();
                this.dgx.setText(String.format(string3, objArr2));
            } else if (praiseList.size() > 1 && praiseList.get(1) != null) {
                if (feedData.isAuthor()) {
                    string2 = getString(u.j.message_praise_graffiti_author_list_2);
                } else {
                    string2 = getString(u.j.message_praise_graffiti_list_2);
                }
                Object[] objArr3 = new Object[2];
                objArr3[0] = StringUtils.isNull(likeData.getNameShow()) ? likeData.getName() : likeData.getNameShow();
                objArr3[1] = StringUtils.isNull(praiseList.get(1).getNameShow()) ? praiseList.get(1).getName() : praiseList.get(1).getNameShow();
                this.dgx.setText(String.format(string2, objArr3));
            } else {
                if (feedData.isAuthor()) {
                    string = getString(u.j.message_praise_graffiti_author_list_1);
                } else {
                    string = getString(u.j.message_praise_graffiti_list_1);
                }
                Object[] objArr4 = new Object[1];
                objArr4[0] = StringUtils.isNull(likeData.getNameShow()) ? likeData.getName() : likeData.getNameShow();
                this.dgx.setText(String.format(string, objArr4));
            }
            if (feedData.isAuthor()) {
                this.aSZ.setText(this.bzv.getPageActivity().getString(u.j.mention_replyme_graffiti_author, new Object[]{feedData.getTitle()}));
            } else {
                this.aSZ.setText(this.bzv.getPageActivity().getString(u.j.mention_replyme_graffiti_landlord, new Object[]{feedData.getTitle()}));
            }
            if (feedData.getThread_Type() == 33) {
                this.aSZ.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.av.getDrawable(u.f.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.aSZ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            if (feedData.getFname() != null && feedData.getFname().length() > 0) {
                this.bbc.setVisibility(0);
                this.bbc.setText(com.baidu.tbadk.core.util.ba.j(feedData.getFname(), 12).concat(getString(u.j.forum)));
            } else {
                this.bbc.setVisibility(8);
            }
            this.bHl.setVisibility(0);
            this.bHl.c(likeData.getPortrait(), 12, false);
        }
    }
}
