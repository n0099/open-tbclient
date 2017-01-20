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
import com.baidu.tieba.r;
import java.util.List;
/* loaded from: classes.dex */
public class al extends com.baidu.tbadk.mvc.f.a<FeedData, com.baidu.tbadk.mvc.d.b> {
    private TextView aNb;
    private TextView agJ;
    private View ame;
    private TbPageContext<?> bBE;
    private TextView bCn;
    private HeadImageView bIe;
    private TextView blH;
    private TextView bnx;
    private TextView dka;
    private TextView dkb;
    private SpannableString dkc;
    private SpannableString dkd;

    public al(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.bBE = tbPageContext;
        this.bIe = (HeadImageView) view.findViewById(r.h.photo);
        this.agJ = (TextView) view.findViewById(r.h.user_name);
        this.bCn = (TextView) view.findViewById(r.h.time);
        this.dka = (TextView) view.findViewById(r.h.add_friend_button);
        this.ame = view.findViewById(r.h.line);
        this.bnx = (TextView) view.findViewById(r.h.content);
        this.aNb = (TextView) view.findViewById(r.h.replyme_title);
        this.blH = (TextView) view.findViewById(r.h.forum);
        this.dkb = (TextView) view.findViewById(r.h.tv_quick_reply_text);
        this.bIe.setOnClickListener(new am(this));
        this.dka.setOnClickListener(new an(this));
        view.setOnClickListener(new ao(this));
        this.dkb.setOnClickListener(new ap(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void E(FeedData feedData) {
        super.E(feedData);
        if (FeedData.TYPE_GRAFFITI.equals(feedData.getPraiseItemType()) || FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType())) {
            if (com.baidu.tieba.graffiti.c.ahy()) {
                e(feedData);
                return;
            } else if (com.baidu.tieba.graffiti.c.ap(null)) {
                d(feedData);
                return;
            } else {
                return;
            }
        }
        this.dkb.setVisibility(0);
        this.dkb.setTag(Integer.valueOf(this.position));
        if (feedData.getReplyer() != null) {
            this.agJ.setText(feedData.getReplyer().getName_show());
            if (feedData.getReplyer().getIsMyFriend() == 1) {
                this.dka.setVisibility(0);
                this.dka.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                this.dka.setTextColor(com.baidu.tbadk.core.util.ap.getColor(r.e.cp_cont_i));
                this.dka.setBackgroundDrawable(com.baidu.tbadk.core.util.ap.getDrawable(r.g.game_center_start_btn));
                this.dka.setText(getString(r.l.chat));
            } else {
                this.dka.setVisibility(0);
                this.dka.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                this.dka.setTextColor(com.baidu.tbadk.core.util.ap.getColor(r.e.cp_cont_i));
                this.dka.setBackgroundDrawable(com.baidu.tbadk.core.util.ap.getDrawable(r.g.game_center_start_btn));
                this.dka.setText(getString(r.l.chat));
            }
            this.bCn.setText(com.baidu.tbadk.core.util.at.r(feedData.getTime()));
            this.dkc = TbFaceManager.DR().a(this.bBE.getPageActivity().getApplicationContext(), feedData.getContent(), null);
            this.bnx.setText(a(this.bnx, this.dkc));
            if (feedData.getThread_Type() == 33) {
                this.aNb.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.ap.getDrawable(r.g.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.aNb.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            if (feedData.getType() == 1) {
                this.dkd = TbFaceManager.DR().a(this.bBE.getPageActivity().getApplicationContext(), this.bBE.getPageActivity().getString(r.l.mention_replyme_original, new Object[]{feedData.getQuote_content()}), null);
                this.aNb.setText(a(this.aNb, this.dkd));
            } else {
                this.aNb.setText(this.bBE.getPageActivity().getString(r.l.mention_replyme_original, new Object[]{feedData.getTitle()}));
            }
            if (feedData.getFname() != null && feedData.getFname().length() > 0) {
                this.blH.setVisibility(0);
                this.blH.setText(com.baidu.tbadk.core.util.at.j(feedData.getFname(), 12).concat(getString(r.l.forum)));
            } else {
                this.blH.setVisibility(8);
            }
            this.bIe.setVisibility(0);
            String portrait = feedData.getReplyer().getPortrait();
            this.bIe.setTag(null);
            this.bIe.c(portrait, 12, false);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.core.util.ap.j(getRootView(), r.g.list_selector);
        com.baidu.tbadk.core.util.ap.k(this.ame, r.e.cp_bg_line_b);
        this.bnx.setTextColor(com.baidu.tbadk.core.util.ap.getColor(r.e.cp_cont_b));
        this.bCn.setTextColor(com.baidu.tbadk.core.util.ap.getColor(r.e.cp_cont_d));
        this.agJ.setTextColor(com.baidu.tbadk.core.util.ap.getColor(r.e.cp_cont_f));
        this.blH.setTextColor(com.baidu.tbadk.core.util.ap.getColor(r.e.cp_cont_d));
        this.aNb.setTextColor(com.baidu.tbadk.core.util.ap.getColor(r.e.cp_cont_c));
        com.baidu.tbadk.core.util.ap.c(this.dkb, r.e.cp_cont_c, 1);
        this.dkb.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.ap.getDrawable(r.g.icon_reply_n), (Drawable) null, (Drawable) null, (Drawable) null);
        com.baidu.tbadk.core.util.ap.j((View) this.aNb, r.g.bg_ta_dialog_content);
        return true;
    }

    private CharSequence a(TextView textView, SpannableString spannableString) {
        if (textView == null || spannableString == null || this.bBE == null) {
            return null;
        }
        return TextUtils.ellipsize(spannableString, textView.getPaint(), (com.baidu.adp.lib.util.k.I(this.bBE.getPageActivity()) - (this.bBE.getResources().getDimensionPixelSize(r.f.ds30) * 2)) - textView.getCompoundPaddingLeft(), TextUtils.TruncateAt.END);
    }

    private void d(FeedData feedData) {
        LikeData likeData;
        if (FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType())) {
            this.dkb.setVisibility(8);
            List<LikeData> praiseList = feedData.getPraiseList();
            if (praiseList != null && praiseList.size() > 0 && (likeData = praiseList.get(0)) != null) {
                this.agJ.setText(likeData.getNameShow());
                this.dka.setVisibility(8);
                this.bCn.setText(com.baidu.tbadk.core.util.at.r(feedData.getTime()));
                if (praiseList.size() > 3 && praiseList.get(1) != null && praiseList.get(2) != null) {
                    this.bnx.setText(String.format(getString(r.l.message_praise_like_list_more), likeData.getNameShow(), praiseList.get(1).getNameShow(), praiseList.get(2).getNameShow(), String.valueOf(feedData.getPraiseNum())));
                } else if (praiseList.size() > 2 && praiseList.get(1) != null && praiseList.get(2) != null) {
                    this.bnx.setText(String.format(getString(r.l.message_praise_like_list_3), likeData.getNameShow(), praiseList.get(1).getNameShow(), praiseList.get(2).getNameShow()));
                } else if (praiseList.size() > 1 && praiseList.get(1) != null) {
                    this.bnx.setText(String.format(getString(r.l.message_praise_like_list_2), likeData.getNameShow(), praiseList.get(1).getNameShow()));
                } else {
                    this.bnx.setText(String.format(getString(r.l.message_praise_like_list_1), likeData.getNameShow()));
                }
                this.aNb.setText(this.bBE.getPageActivity().getString(r.l.mention_replyme_original, new Object[]{feedData.getTitle()}));
                if (feedData.getThread_Type() == 33) {
                    this.aNb.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.ap.getDrawable(r.g.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
                } else {
                    this.aNb.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (feedData.getFname() != null && feedData.getFname().length() > 0) {
                    this.blH.setVisibility(0);
                    this.blH.setText(com.baidu.tbadk.core.util.at.j(feedData.getFname(), 12).concat(getString(r.l.forum)));
                } else {
                    this.blH.setVisibility(8);
                }
                this.bIe.setVisibility(0);
                this.bIe.c(likeData.getPortrait(), 12, false);
            }
        }
    }

    private void e(FeedData feedData) {
        LikeData likeData;
        String string;
        String string2;
        String string3;
        String string4;
        this.dkb.setVisibility(8);
        List<LikeData> praiseList = feedData.getPraiseList();
        if (praiseList != null && praiseList.size() > 0 && (likeData = praiseList.get(0)) != null) {
            this.agJ.setText(likeData.getNameShow());
            this.dka.setVisibility(8);
            this.bCn.setText(com.baidu.tbadk.core.util.at.r(feedData.getTime()));
            if (praiseList.size() > 3 && praiseList.get(1) != null && praiseList.get(2) != null) {
                if (feedData.isAuthor()) {
                    string4 = getString(r.l.message_praise_graffiti_author_list_more);
                } else {
                    string4 = getString(r.l.message_praise_graffiti_list_more);
                }
                Object[] objArr = new Object[4];
                objArr[0] = StringUtils.isNull(likeData.getNameShow()) ? likeData.getName() : likeData.getNameShow();
                objArr[1] = StringUtils.isNull(praiseList.get(1).getNameShow()) ? praiseList.get(1).getName() : praiseList.get(1).getNameShow();
                objArr[2] = StringUtils.isNull(praiseList.get(2).getNameShow()) ? praiseList.get(2).getName() : praiseList.get(2).getNameShow();
                objArr[3] = com.baidu.tbadk.core.util.at.y(feedData.getPraiseNum());
                this.bnx.setText(String.format(string4, objArr));
            } else if (praiseList.size() > 2 && praiseList.get(1) != null && praiseList.get(2) != null) {
                if (feedData.isAuthor()) {
                    string3 = getString(r.l.message_praise_graffiti_author_list_3);
                } else {
                    string3 = getString(r.l.message_praise_graffiti_list_3);
                }
                Object[] objArr2 = new Object[3];
                objArr2[0] = StringUtils.isNull(likeData.getNameShow()) ? likeData.getName() : likeData.getNameShow();
                objArr2[1] = StringUtils.isNull(praiseList.get(1).getNameShow()) ? praiseList.get(1).getName() : praiseList.get(1).getNameShow();
                objArr2[2] = StringUtils.isNull(praiseList.get(2).getNameShow()) ? praiseList.get(2).getName() : praiseList.get(2).getNameShow();
                this.bnx.setText(String.format(string3, objArr2));
            } else if (praiseList.size() > 1 && praiseList.get(1) != null) {
                if (feedData.isAuthor()) {
                    string2 = getString(r.l.message_praise_graffiti_author_list_2);
                } else {
                    string2 = getString(r.l.message_praise_graffiti_list_2);
                }
                Object[] objArr3 = new Object[2];
                objArr3[0] = StringUtils.isNull(likeData.getNameShow()) ? likeData.getName() : likeData.getNameShow();
                objArr3[1] = StringUtils.isNull(praiseList.get(1).getNameShow()) ? praiseList.get(1).getName() : praiseList.get(1).getNameShow();
                this.bnx.setText(String.format(string2, objArr3));
            } else {
                if (feedData.isAuthor()) {
                    string = getString(r.l.message_praise_graffiti_author_list_1);
                } else {
                    string = getString(r.l.message_praise_graffiti_list_1);
                }
                Object[] objArr4 = new Object[1];
                objArr4[0] = StringUtils.isNull(likeData.getNameShow()) ? likeData.getName() : likeData.getNameShow();
                this.bnx.setText(String.format(string, objArr4));
            }
            if (feedData.isAuthor()) {
                this.aNb.setText(this.bBE.getPageActivity().getString(r.l.mention_replyme_graffiti_author, new Object[]{feedData.getTitle()}));
            } else {
                this.aNb.setText(this.bBE.getPageActivity().getString(r.l.mention_replyme_graffiti_landlord, new Object[]{feedData.getTitle()}));
            }
            if (feedData.getThread_Type() == 33) {
                this.aNb.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.ap.getDrawable(r.g.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.aNb.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            if (feedData.getFname() != null && feedData.getFname().length() > 0) {
                this.blH.setVisibility(0);
                this.blH.setText(com.baidu.tbadk.core.util.at.j(feedData.getFname(), 12).concat(getString(r.l.forum)));
            } else {
                this.blH.setVisibility(8);
            }
            this.bIe.setVisibility(0);
            this.bIe.c(likeData.getPortrait(), 12, false);
        }
    }
}
