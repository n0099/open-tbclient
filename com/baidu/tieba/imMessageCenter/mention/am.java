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
import com.baidu.tieba.w;
import java.util.List;
/* loaded from: classes2.dex */
public class am extends com.baidu.tbadk.mvc.f.a<FeedData, com.baidu.tbadk.mvc.d.b> {
    private TextView anw;
    private View asD;
    private TextView bAh;
    private TextView bDf;
    private TextView bXs;
    private TbPageContext<?> bzN;
    private HeadImageView cej;
    private TextView duH;
    private TextView duI;
    private SpannableString duJ;
    private SpannableString duK;
    private TextView mTitle;

    public am(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.bzN = tbPageContext;
        this.cej = (HeadImageView) view.findViewById(w.h.photo);
        this.anw = (TextView) view.findViewById(w.h.user_name);
        this.bXs = (TextView) view.findViewById(w.h.time);
        this.duH = (TextView) view.findViewById(w.h.add_friend_button);
        this.asD = view.findViewById(w.h.line);
        this.bDf = (TextView) view.findViewById(w.h.content);
        this.mTitle = (TextView) view.findViewById(w.h.replyme_title);
        this.bAh = (TextView) view.findViewById(w.h.forum);
        this.duI = (TextView) view.findViewById(w.h.tv_quick_reply_text);
        this.cej.setOnClickListener(new an(this));
        this.duH.setOnClickListener(new ao(this));
        view.setOnClickListener(new ap(this));
        this.duI.setOnClickListener(new aq(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void E(FeedData feedData) {
        super.E(feedData);
        if (FeedData.TYPE_GRAFFITI.equals(feedData.getPraiseItemType())) {
            if (com.baidu.tieba.graffiti.c.akm()) {
                e(feedData);
            }
        } else if (FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType())) {
            d(feedData);
        } else if (FeedData.TYPE_DECLARE.equals(feedData.getPraiseItemType())) {
            f(feedData);
        } else {
            this.duI.setVisibility(0);
            this.duI.setTag(Integer.valueOf(this.position));
            if (feedData.getReplyer() != null) {
                this.anw.setText(feedData.getReplyer().getName_show());
                if (feedData.getReplyer().isBigV()) {
                    com.baidu.tbadk.core.util.as.i(this.anw, w.e.cp_cont_r);
                } else {
                    com.baidu.tbadk.core.util.as.i(this.anw, w.e.cp_cont_c);
                }
                if (feedData.getReplyer().getIsMyFriend() == 1) {
                    this.duH.setVisibility(0);
                    this.duH.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                    this.duH.setTextColor(com.baidu.tbadk.core.util.as.getColor(w.e.cp_cont_i));
                    this.duH.setBackgroundDrawable(com.baidu.tbadk.core.util.as.getDrawable(w.g.game_center_start_btn));
                    this.duH.setText(getString(w.l.chat));
                } else {
                    this.duH.setVisibility(0);
                    this.duH.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                    this.duH.setTextColor(com.baidu.tbadk.core.util.as.getColor(w.e.cp_cont_i));
                    this.duH.setBackgroundDrawable(com.baidu.tbadk.core.util.as.getDrawable(w.g.game_center_start_btn));
                    this.duH.setText(getString(w.l.chat));
                }
                this.bXs.setText(com.baidu.tbadk.core.util.aw.q(feedData.getTime()));
                this.duJ = TbFaceManager.Ea().a(this.bzN.getPageActivity().getApplicationContext(), feedData.getContent(), null);
                this.bDf.setText(a(this.bDf, this.duJ));
                if (feedData.getThread_Type() == 33) {
                    this.mTitle.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.as.getDrawable(w.g.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
                } else {
                    this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (feedData.getType() == 1) {
                    this.duK = TbFaceManager.Ea().a(this.bzN.getPageActivity().getApplicationContext(), this.bzN.getPageActivity().getString(w.l.mention_replyme_original, new Object[]{feedData.getQuote_content()}), null);
                    this.mTitle.setText(a(this.mTitle, this.duK));
                } else {
                    this.mTitle.setText(this.bzN.getPageActivity().getString(w.l.mention_replyme_original, new Object[]{feedData.getTitle()}));
                }
                if (!feedData.isHideForumName() && feedData.getFname() != null && feedData.getFname().length() > 0) {
                    this.bAh.setVisibility(0);
                    this.bAh.setText(com.baidu.tbadk.core.util.aw.j(feedData.getFname(), 12).concat(getString(w.l.forum)));
                } else {
                    this.bAh.setVisibility(8);
                }
                this.cej.setVisibility(0);
                this.cej.setIsRound(true);
                this.cej.setShowV(feedData.getReplyer().isBigV());
                String portrait = feedData.getReplyer().getPortrait();
                this.cej.setTag(null);
                this.cej.c(portrait, 12, false);
            }
        }
        if (Fp() != null) {
            Fp().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9488, feedData, null, null));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.core.util.as.j(getRootView(), w.g.list_selector);
        com.baidu.tbadk.core.util.as.k(this.asD, w.e.cp_bg_line_b);
        this.bDf.setTextColor(com.baidu.tbadk.core.util.as.getColor(w.e.cp_cont_b));
        this.bXs.setTextColor(com.baidu.tbadk.core.util.as.getColor(w.e.cp_cont_d));
        this.bAh.setTextColor(com.baidu.tbadk.core.util.as.getColor(w.e.cp_cont_d));
        this.mTitle.setTextColor(com.baidu.tbadk.core.util.as.getColor(w.e.cp_cont_c));
        com.baidu.tbadk.core.util.as.c(this.duI, w.e.cp_cont_c, 1);
        this.duI.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.as.getDrawable(w.g.icon_reply_n), (Drawable) null, (Drawable) null, (Drawable) null);
        com.baidu.tbadk.core.util.as.j(this.mTitle, w.g.bg_ta_dialog_content);
        return true;
    }

    private CharSequence a(TextView textView, SpannableString spannableString) {
        if (textView == null || spannableString == null || this.bzN == null) {
            return null;
        }
        return TextUtils.ellipsize(spannableString, textView.getPaint(), (com.baidu.adp.lib.util.k.af(this.bzN.getPageActivity()) - (this.bzN.getResources().getDimensionPixelSize(w.f.ds30) * 2)) - textView.getCompoundPaddingLeft(), TextUtils.TruncateAt.END);
    }

    private void d(FeedData feedData) {
        LikeData likeData;
        if (FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType())) {
            this.duI.setVisibility(8);
            List<LikeData> praiseList = feedData.getPraiseList();
            if (praiseList != null && praiseList.size() > 0 && (likeData = praiseList.get(0)) != null) {
                this.anw.setText(likeData.getNameShow());
                this.cej.setShowV(likeData.isBigV());
                if (likeData.isBigV()) {
                    com.baidu.tbadk.core.util.as.i(this.anw, w.e.cp_cont_r);
                } else {
                    com.baidu.tbadk.core.util.as.i(this.anw, w.e.cp_cont_c);
                }
                this.duH.setVisibility(8);
                this.bXs.setText(com.baidu.tbadk.core.util.aw.q(feedData.getTime()));
                if (praiseList.size() > 3 && praiseList.get(1) != null && praiseList.get(2) != null) {
                    this.bDf.setText(String.format(getString(w.l.message_praise_like_list_more), likeData.getNameShow(), praiseList.get(1).getNameShow(), praiseList.get(2).getNameShow(), String.valueOf(feedData.getPraiseNum())));
                } else if (praiseList.size() > 2 && praiseList.get(1) != null && praiseList.get(2) != null) {
                    this.bDf.setText(String.format(getString(w.l.message_praise_like_list_3), likeData.getNameShow(), praiseList.get(1).getNameShow(), praiseList.get(2).getNameShow()));
                } else if (praiseList.size() > 1 && praiseList.get(1) != null) {
                    this.bDf.setText(String.format(getString(w.l.message_praise_like_list_2), likeData.getNameShow(), praiseList.get(1).getNameShow()));
                } else {
                    this.bDf.setText(String.format(getString(w.l.message_praise_like_list_1), likeData.getNameShow()));
                }
                this.mTitle.setText(this.bzN.getPageActivity().getString(w.l.mention_replyme_original, new Object[]{feedData.getTitle()}));
                if (feedData.getThread_Type() == 33) {
                    this.mTitle.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.as.getDrawable(w.g.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
                } else {
                    this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (!feedData.isHideForumName() && feedData.getFname() != null && feedData.getFname().length() > 0) {
                    this.bAh.setVisibility(0);
                    this.bAh.setText(com.baidu.tbadk.core.util.aw.j(feedData.getFname(), 12).concat(getString(w.l.forum)));
                } else {
                    this.bAh.setVisibility(8);
                }
                this.cej.setVisibility(0);
                this.cej.setIsRound(true);
                this.cej.c(likeData.getPortrait(), 12, false);
            }
        }
    }

    private void e(FeedData feedData) {
        LikeData likeData;
        String string;
        String nameShow;
        String string2;
        String nameShow2;
        String nameShow3;
        String string3;
        String nameShow4;
        String nameShow5;
        String nameShow6;
        String string4;
        String nameShow7;
        String nameShow8;
        String nameShow9;
        this.duI.setVisibility(8);
        List<LikeData> praiseList = feedData.getPraiseList();
        if (praiseList != null && praiseList.size() > 0 && (likeData = praiseList.get(0)) != null) {
            this.anw.setText(likeData.getNameShow());
            this.duH.setVisibility(8);
            this.bXs.setText(com.baidu.tbadk.core.util.aw.q(feedData.getTime()));
            if (praiseList.size() > 3 && praiseList.get(1) != null && praiseList.get(2) != null) {
                if (feedData.isAuthor()) {
                    string4 = getString(w.l.message_praise_graffiti_author_list_more);
                } else {
                    string4 = getString(w.l.message_praise_graffiti_list_more);
                }
                Object[] objArr = new Object[4];
                if (StringUtils.isNull(likeData.getNameShow())) {
                    nameShow7 = likeData.getName();
                } else {
                    nameShow7 = likeData.getNameShow();
                }
                objArr[0] = nameShow7;
                if (StringUtils.isNull(praiseList.get(1).getNameShow())) {
                    nameShow8 = praiseList.get(1).getName();
                } else {
                    nameShow8 = praiseList.get(1).getNameShow();
                }
                objArr[1] = nameShow8;
                if (StringUtils.isNull(praiseList.get(2).getNameShow())) {
                    nameShow9 = praiseList.get(2).getName();
                } else {
                    nameShow9 = praiseList.get(2).getNameShow();
                }
                objArr[2] = nameShow9;
                objArr[3] = com.baidu.tbadk.core.util.aw.A(feedData.getPraiseNum());
                this.bDf.setText(String.format(string4, objArr));
            } else if (praiseList.size() > 2 && praiseList.get(1) != null && praiseList.get(2) != null) {
                if (feedData.isAuthor()) {
                    string3 = getString(w.l.message_praise_graffiti_author_list_3);
                } else {
                    string3 = getString(w.l.message_praise_graffiti_list_3);
                }
                Object[] objArr2 = new Object[3];
                if (StringUtils.isNull(likeData.getNameShow())) {
                    nameShow4 = likeData.getName();
                } else {
                    nameShow4 = likeData.getNameShow();
                }
                objArr2[0] = nameShow4;
                if (StringUtils.isNull(praiseList.get(1).getNameShow())) {
                    nameShow5 = praiseList.get(1).getName();
                } else {
                    nameShow5 = praiseList.get(1).getNameShow();
                }
                objArr2[1] = nameShow5;
                if (StringUtils.isNull(praiseList.get(2).getNameShow())) {
                    nameShow6 = praiseList.get(2).getName();
                } else {
                    nameShow6 = praiseList.get(2).getNameShow();
                }
                objArr2[2] = nameShow6;
                this.bDf.setText(String.format(string3, objArr2));
            } else if (praiseList.size() > 1 && praiseList.get(1) != null) {
                if (feedData.isAuthor()) {
                    string2 = getString(w.l.message_praise_graffiti_author_list_2);
                } else {
                    string2 = getString(w.l.message_praise_graffiti_list_2);
                }
                Object[] objArr3 = new Object[2];
                if (StringUtils.isNull(likeData.getNameShow())) {
                    nameShow2 = likeData.getName();
                } else {
                    nameShow2 = likeData.getNameShow();
                }
                objArr3[0] = nameShow2;
                if (StringUtils.isNull(praiseList.get(1).getNameShow())) {
                    nameShow3 = praiseList.get(1).getName();
                } else {
                    nameShow3 = praiseList.get(1).getNameShow();
                }
                objArr3[1] = nameShow3;
                this.bDf.setText(String.format(string2, objArr3));
            } else {
                if (feedData.isAuthor()) {
                    string = getString(w.l.message_praise_graffiti_author_list_1);
                } else {
                    string = getString(w.l.message_praise_graffiti_list_1);
                }
                Object[] objArr4 = new Object[1];
                if (StringUtils.isNull(likeData.getNameShow())) {
                    nameShow = likeData.getName();
                } else {
                    nameShow = likeData.getNameShow();
                }
                objArr4[0] = nameShow;
                this.bDf.setText(String.format(string, objArr4));
            }
            if (feedData.isAuthor()) {
                this.mTitle.setText(this.bzN.getPageActivity().getString(w.l.mention_replyme_graffiti_author, new Object[]{feedData.getTitle()}));
            } else {
                this.mTitle.setText(this.bzN.getPageActivity().getString(w.l.mention_replyme_graffiti_landlord, new Object[]{feedData.getTitle()}));
            }
            if (feedData.getThread_Type() == 33) {
                this.mTitle.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.as.getDrawable(w.g.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            if (!feedData.isHideForumName() && feedData.getFname() != null && feedData.getFname().length() > 0) {
                this.bAh.setVisibility(0);
                this.bAh.setText(com.baidu.tbadk.core.util.aw.j(feedData.getFname(), 12).concat(getString(w.l.forum)));
            } else {
                this.bAh.setVisibility(8);
            }
            this.cej.setVisibility(0);
            this.cej.c(likeData.getPortrait(), 12, false);
        }
    }

    private void f(FeedData feedData) {
        LikeData likeData;
        this.duI.setVisibility(8);
        List<LikeData> praiseList = feedData.getPraiseList();
        if (praiseList != null && praiseList.size() > 0 && (likeData = praiseList.get(0)) != null) {
            this.anw.setText(likeData.getNameShow());
            this.cej.setShowV(likeData.isBigV());
            if (likeData.isBigV()) {
                com.baidu.tbadk.core.util.as.i(this.anw, w.e.cp_cont_r);
            } else {
                com.baidu.tbadk.core.util.as.i(this.anw, w.e.cp_cont_c);
            }
            this.duH.setVisibility(8);
            this.bXs.setText(com.baidu.tbadk.core.util.aw.q(feedData.getTime()));
            if (praiseList.size() > 2 && praiseList.get(1) != null) {
                this.bDf.setText(String.format(getString(w.l.message_declare_list_more), likeData.getNameShow(), praiseList.get(1).getNameShow(), String.valueOf(feedData.getPraiseNum())));
            } else if (praiseList.size() == 2 && praiseList.get(1) != null) {
                this.bDf.setText(String.format(getString(w.l.message_declare_list_2), likeData.getNameShow(), praiseList.get(1).getNameShow()));
            } else {
                this.bDf.setText(String.format(getString(w.l.message_declare_list_1), likeData.getNameShow()));
            }
            this.mTitle.setText(this.bzN.getPageActivity().getString(w.l.mention_replyme_original, new Object[]{feedData.getTitle()}));
            if (feedData.getThread_Type() == 33) {
                this.mTitle.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.as.getDrawable(w.g.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            if (!feedData.isHideForumName() && feedData.getFname() != null && feedData.getFname().length() > 0) {
                this.bAh.setVisibility(0);
                this.bAh.setText(com.baidu.tbadk.core.util.aw.j(feedData.getFname(), 12).concat(getString(w.l.forum)));
            } else {
                this.bAh.setVisibility(8);
            }
            this.cej.setVisibility(0);
            this.cej.c(likeData.getPortrait(), 12, false);
        }
    }
}
