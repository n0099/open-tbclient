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
/* loaded from: classes.dex */
public class al extends com.baidu.tbadk.mvc.f.a<FeedData, com.baidu.tbadk.mvc.d.b> {
    private TextView amq;
    private View arO;
    private TbPageContext<?> bKU;
    private TextView bLE;
    private HeadImageView bRt;
    private TextView buL;
    private TextView bwC;
    private TextView dnk;
    private TextView dnl;
    private SpannableString dnm;
    private SpannableString dnn;
    private TextView mTitle;

    public al(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.bKU = tbPageContext;
        this.bRt = (HeadImageView) view.findViewById(w.h.photo);
        this.amq = (TextView) view.findViewById(w.h.user_name);
        this.bLE = (TextView) view.findViewById(w.h.time);
        this.dnk = (TextView) view.findViewById(w.h.add_friend_button);
        this.arO = view.findViewById(w.h.line);
        this.bwC = (TextView) view.findViewById(w.h.content);
        this.mTitle = (TextView) view.findViewById(w.h.replyme_title);
        this.buL = (TextView) view.findViewById(w.h.forum);
        this.dnl = (TextView) view.findViewById(w.h.tv_quick_reply_text);
        this.bRt.setOnClickListener(new am(this));
        this.dnk.setOnClickListener(new an(this));
        view.setOnClickListener(new ao(this));
        this.dnl.setOnClickListener(new ap(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void E(FeedData feedData) {
        super.E(feedData);
        if (FeedData.TYPE_GRAFFITI.equals(feedData.getPraiseItemType())) {
            if (com.baidu.tieba.graffiti.c.ahE()) {
                e(feedData);
            }
        } else if (FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType())) {
            d(feedData);
        } else if (FeedData.TYPE_DECLARE.equals(feedData.getPraiseItemType())) {
            f(feedData);
        } else {
            this.dnl.setVisibility(0);
            this.dnl.setTag(Integer.valueOf(this.position));
            if (feedData.getReplyer() != null) {
                this.amq.setText(feedData.getReplyer().getName_show());
                if (feedData.getReplyer().getIsMyFriend() == 1) {
                    this.dnk.setVisibility(0);
                    this.dnk.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                    this.dnk.setTextColor(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_cont_i));
                    this.dnk.setBackgroundDrawable(com.baidu.tbadk.core.util.aq.getDrawable(w.g.game_center_start_btn));
                    this.dnk.setText(getString(w.l.chat));
                } else {
                    this.dnk.setVisibility(0);
                    this.dnk.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                    this.dnk.setTextColor(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_cont_i));
                    this.dnk.setBackgroundDrawable(com.baidu.tbadk.core.util.aq.getDrawable(w.g.game_center_start_btn));
                    this.dnk.setText(getString(w.l.chat));
                }
                this.bLE.setText(com.baidu.tbadk.core.util.au.q(feedData.getTime()));
                this.dnm = TbFaceManager.EI().a(this.bKU.getPageActivity().getApplicationContext(), feedData.getContent(), null);
                this.bwC.setText(a(this.bwC, this.dnm));
                if (feedData.getThread_Type() == 33) {
                    this.mTitle.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
                } else {
                    this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (feedData.getType() == 1) {
                    this.dnn = TbFaceManager.EI().a(this.bKU.getPageActivity().getApplicationContext(), this.bKU.getPageActivity().getString(w.l.mention_replyme_original, new Object[]{feedData.getQuote_content()}), null);
                    this.mTitle.setText(a(this.mTitle, this.dnn));
                } else {
                    this.mTitle.setText(this.bKU.getPageActivity().getString(w.l.mention_replyme_original, new Object[]{feedData.getTitle()}));
                }
                if (feedData.getFname() != null && feedData.getFname().length() > 0) {
                    this.buL.setVisibility(0);
                    this.buL.setText(com.baidu.tbadk.core.util.au.j(feedData.getFname(), 12).concat(getString(w.l.forum)));
                } else {
                    this.buL.setVisibility(8);
                }
                this.bRt.setVisibility(0);
                String portrait = feedData.getReplyer().getPortrait();
                this.bRt.setTag(null);
                this.bRt.c(portrait, 12, false);
            }
        }
        if (FU() != null) {
            FU().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9488, feedData, null, null));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.core.util.aq.j(getRootView(), w.g.list_selector);
        com.baidu.tbadk.core.util.aq.k(this.arO, w.e.cp_bg_line_b);
        this.bwC.setTextColor(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_cont_b));
        this.bLE.setTextColor(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_cont_d));
        this.amq.setTextColor(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_cont_f));
        this.buL.setTextColor(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_cont_d));
        this.mTitle.setTextColor(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_cont_c));
        com.baidu.tbadk.core.util.aq.c(this.dnl, w.e.cp_cont_c, 1);
        this.dnl.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_reply_n), (Drawable) null, (Drawable) null, (Drawable) null);
        com.baidu.tbadk.core.util.aq.j(this.mTitle, w.g.bg_ta_dialog_content);
        return true;
    }

    private CharSequence a(TextView textView, SpannableString spannableString) {
        if (textView == null || spannableString == null || this.bKU == null) {
            return null;
        }
        return TextUtils.ellipsize(spannableString, textView.getPaint(), (com.baidu.adp.lib.util.k.af(this.bKU.getPageActivity()) - (this.bKU.getResources().getDimensionPixelSize(w.f.ds30) * 2)) - textView.getCompoundPaddingLeft(), TextUtils.TruncateAt.END);
    }

    private void d(FeedData feedData) {
        LikeData likeData;
        if (FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType())) {
            this.dnl.setVisibility(8);
            List<LikeData> praiseList = feedData.getPraiseList();
            if (praiseList != null && praiseList.size() > 0 && (likeData = praiseList.get(0)) != null) {
                this.amq.setText(likeData.getNameShow());
                this.dnk.setVisibility(8);
                this.bLE.setText(com.baidu.tbadk.core.util.au.q(feedData.getTime()));
                if (praiseList.size() > 3 && praiseList.get(1) != null && praiseList.get(2) != null) {
                    this.bwC.setText(String.format(getString(w.l.message_praise_like_list_more), likeData.getNameShow(), praiseList.get(1).getNameShow(), praiseList.get(2).getNameShow(), String.valueOf(feedData.getPraiseNum())));
                } else if (praiseList.size() > 2 && praiseList.get(1) != null && praiseList.get(2) != null) {
                    this.bwC.setText(String.format(getString(w.l.message_praise_like_list_3), likeData.getNameShow(), praiseList.get(1).getNameShow(), praiseList.get(2).getNameShow()));
                } else if (praiseList.size() > 1 && praiseList.get(1) != null) {
                    this.bwC.setText(String.format(getString(w.l.message_praise_like_list_2), likeData.getNameShow(), praiseList.get(1).getNameShow()));
                } else {
                    this.bwC.setText(String.format(getString(w.l.message_praise_like_list_1), likeData.getNameShow()));
                }
                this.mTitle.setText(this.bKU.getPageActivity().getString(w.l.mention_replyme_original, new Object[]{feedData.getTitle()}));
                if (feedData.getThread_Type() == 33) {
                    this.mTitle.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
                } else {
                    this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (feedData.getFname() != null && feedData.getFname().length() > 0) {
                    this.buL.setVisibility(0);
                    this.buL.setText(com.baidu.tbadk.core.util.au.j(feedData.getFname(), 12).concat(getString(w.l.forum)));
                } else {
                    this.buL.setVisibility(8);
                }
                this.bRt.setVisibility(0);
                this.bRt.c(likeData.getPortrait(), 12, false);
            }
        }
    }

    private void e(FeedData feedData) {
        LikeData likeData;
        String string;
        String string2;
        String string3;
        String string4;
        this.dnl.setVisibility(8);
        List<LikeData> praiseList = feedData.getPraiseList();
        if (praiseList != null && praiseList.size() > 0 && (likeData = praiseList.get(0)) != null) {
            this.amq.setText(likeData.getNameShow());
            this.dnk.setVisibility(8);
            this.bLE.setText(com.baidu.tbadk.core.util.au.q(feedData.getTime()));
            if (praiseList.size() > 3 && praiseList.get(1) != null && praiseList.get(2) != null) {
                if (feedData.isAuthor()) {
                    string4 = getString(w.l.message_praise_graffiti_author_list_more);
                } else {
                    string4 = getString(w.l.message_praise_graffiti_list_more);
                }
                Object[] objArr = new Object[4];
                objArr[0] = StringUtils.isNull(likeData.getNameShow()) ? likeData.getName() : likeData.getNameShow();
                objArr[1] = StringUtils.isNull(praiseList.get(1).getNameShow()) ? praiseList.get(1).getName() : praiseList.get(1).getNameShow();
                objArr[2] = StringUtils.isNull(praiseList.get(2).getNameShow()) ? praiseList.get(2).getName() : praiseList.get(2).getNameShow();
                objArr[3] = com.baidu.tbadk.core.util.au.y(feedData.getPraiseNum());
                this.bwC.setText(String.format(string4, objArr));
            } else if (praiseList.size() > 2 && praiseList.get(1) != null && praiseList.get(2) != null) {
                if (feedData.isAuthor()) {
                    string3 = getString(w.l.message_praise_graffiti_author_list_3);
                } else {
                    string3 = getString(w.l.message_praise_graffiti_list_3);
                }
                Object[] objArr2 = new Object[3];
                objArr2[0] = StringUtils.isNull(likeData.getNameShow()) ? likeData.getName() : likeData.getNameShow();
                objArr2[1] = StringUtils.isNull(praiseList.get(1).getNameShow()) ? praiseList.get(1).getName() : praiseList.get(1).getNameShow();
                objArr2[2] = StringUtils.isNull(praiseList.get(2).getNameShow()) ? praiseList.get(2).getName() : praiseList.get(2).getNameShow();
                this.bwC.setText(String.format(string3, objArr2));
            } else if (praiseList.size() > 1 && praiseList.get(1) != null) {
                if (feedData.isAuthor()) {
                    string2 = getString(w.l.message_praise_graffiti_author_list_2);
                } else {
                    string2 = getString(w.l.message_praise_graffiti_list_2);
                }
                Object[] objArr3 = new Object[2];
                objArr3[0] = StringUtils.isNull(likeData.getNameShow()) ? likeData.getName() : likeData.getNameShow();
                objArr3[1] = StringUtils.isNull(praiseList.get(1).getNameShow()) ? praiseList.get(1).getName() : praiseList.get(1).getNameShow();
                this.bwC.setText(String.format(string2, objArr3));
            } else {
                if (feedData.isAuthor()) {
                    string = getString(w.l.message_praise_graffiti_author_list_1);
                } else {
                    string = getString(w.l.message_praise_graffiti_list_1);
                }
                Object[] objArr4 = new Object[1];
                objArr4[0] = StringUtils.isNull(likeData.getNameShow()) ? likeData.getName() : likeData.getNameShow();
                this.bwC.setText(String.format(string, objArr4));
            }
            if (feedData.isAuthor()) {
                this.mTitle.setText(this.bKU.getPageActivity().getString(w.l.mention_replyme_graffiti_author, new Object[]{feedData.getTitle()}));
            } else {
                this.mTitle.setText(this.bKU.getPageActivity().getString(w.l.mention_replyme_graffiti_landlord, new Object[]{feedData.getTitle()}));
            }
            if (feedData.getThread_Type() == 33) {
                this.mTitle.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            if (feedData.getFname() != null && feedData.getFname().length() > 0) {
                this.buL.setVisibility(0);
                this.buL.setText(com.baidu.tbadk.core.util.au.j(feedData.getFname(), 12).concat(getString(w.l.forum)));
            } else {
                this.buL.setVisibility(8);
            }
            this.bRt.setVisibility(0);
            this.bRt.c(likeData.getPortrait(), 12, false);
        }
    }

    private void f(FeedData feedData) {
        LikeData likeData;
        this.dnl.setVisibility(8);
        List<LikeData> praiseList = feedData.getPraiseList();
        if (praiseList != null && praiseList.size() > 0 && (likeData = praiseList.get(0)) != null) {
            this.amq.setText(likeData.getNameShow());
            this.dnk.setVisibility(8);
            this.bLE.setText(com.baidu.tbadk.core.util.au.q(feedData.getTime()));
            if (praiseList.size() > 2 && praiseList.get(1) != null) {
                this.bwC.setText(String.format(getString(w.l.message_declare_list_more), likeData.getNameShow(), praiseList.get(1).getNameShow(), String.valueOf(feedData.getPraiseNum())));
            } else if (praiseList.size() == 2 && praiseList.get(1) != null) {
                this.bwC.setText(String.format(getString(w.l.message_declare_list_2), likeData.getNameShow(), praiseList.get(1).getNameShow()));
            } else {
                this.bwC.setText(String.format(getString(w.l.message_declare_list_1), likeData.getNameShow()));
            }
            this.mTitle.setText(this.bKU.getPageActivity().getString(w.l.mention_replyme_original, new Object[]{feedData.getTitle()}));
            if (feedData.getThread_Type() == 33) {
                this.mTitle.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            if (feedData.getFname() != null && feedData.getFname().length() > 0) {
                this.buL.setVisibility(0);
                this.buL.setText(com.baidu.tbadk.core.util.au.j(feedData.getFname(), 12).concat(getString(w.l.forum)));
            } else {
                this.buL.setVisibility(8);
            }
            this.bRt.setVisibility(0);
            this.bRt.c(likeData.getPortrait(), 12, false);
        }
    }
}
