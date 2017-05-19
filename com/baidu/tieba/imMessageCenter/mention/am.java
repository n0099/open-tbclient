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
    private TextView amB;
    private View arQ;
    private TbPageContext<?> bJY;
    private TextView bKI;
    private HeadImageView bQk;
    private TextView buI;
    private TextView bwB;
    private TextView dhp;
    private TextView dhq;
    private SpannableString dhr;
    private SpannableString dhs;
    private TextView mTitle;

    public am(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.bJY = tbPageContext;
        this.bQk = (HeadImageView) view.findViewById(w.h.photo);
        this.amB = (TextView) view.findViewById(w.h.user_name);
        this.bKI = (TextView) view.findViewById(w.h.time);
        this.dhp = (TextView) view.findViewById(w.h.add_friend_button);
        this.arQ = view.findViewById(w.h.line);
        this.bwB = (TextView) view.findViewById(w.h.content);
        this.mTitle = (TextView) view.findViewById(w.h.replyme_title);
        this.buI = (TextView) view.findViewById(w.h.forum);
        this.dhq = (TextView) view.findViewById(w.h.tv_quick_reply_text);
        this.bQk.setOnClickListener(new an(this));
        this.dhp.setOnClickListener(new ao(this));
        view.setOnClickListener(new ap(this));
        this.dhq.setOnClickListener(new aq(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void E(FeedData feedData) {
        super.E(feedData);
        if (FeedData.TYPE_GRAFFITI.equals(feedData.getPraiseItemType())) {
            if (com.baidu.tieba.graffiti.c.afn()) {
                e(feedData);
            }
        } else if (FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType())) {
            d(feedData);
        } else if (FeedData.TYPE_DECLARE.equals(feedData.getPraiseItemType())) {
            f(feedData);
        } else {
            this.dhq.setVisibility(0);
            this.dhq.setTag(Integer.valueOf(this.position));
            if (feedData.getReplyer() != null) {
                this.amB.setText(feedData.getReplyer().getName_show());
                if (feedData.getReplyer().getIsMyFriend() == 1) {
                    this.dhp.setVisibility(0);
                    this.dhp.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                    this.dhp.setTextColor(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_cont_i));
                    this.dhp.setBackgroundDrawable(com.baidu.tbadk.core.util.aq.getDrawable(w.g.game_center_start_btn));
                    this.dhp.setText(getString(w.l.chat));
                } else {
                    this.dhp.setVisibility(0);
                    this.dhp.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                    this.dhp.setTextColor(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_cont_i));
                    this.dhp.setBackgroundDrawable(com.baidu.tbadk.core.util.aq.getDrawable(w.g.game_center_start_btn));
                    this.dhp.setText(getString(w.l.chat));
                }
                this.bKI.setText(com.baidu.tbadk.core.util.au.q(feedData.getTime()));
                this.dhr = TbFaceManager.DM().a(this.bJY.getPageActivity().getApplicationContext(), feedData.getContent(), null);
                this.bwB.setText(a(this.bwB, this.dhr));
                if (feedData.getThread_Type() == 33) {
                    this.mTitle.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
                } else {
                    this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (feedData.getType() == 1) {
                    this.dhs = TbFaceManager.DM().a(this.bJY.getPageActivity().getApplicationContext(), this.bJY.getPageActivity().getString(w.l.mention_replyme_original, new Object[]{feedData.getQuote_content()}), null);
                    this.mTitle.setText(a(this.mTitle, this.dhs));
                } else {
                    this.mTitle.setText(this.bJY.getPageActivity().getString(w.l.mention_replyme_original, new Object[]{feedData.getTitle()}));
                }
                if (!feedData.isHideForumName() && feedData.getFname() != null && feedData.getFname().length() > 0) {
                    this.buI.setVisibility(0);
                    this.buI.setText(com.baidu.tbadk.core.util.au.j(feedData.getFname(), 12).concat(getString(w.l.forum)));
                } else {
                    this.buI.setVisibility(8);
                }
                this.bQk.setVisibility(0);
                String portrait = feedData.getReplyer().getPortrait();
                this.bQk.setTag(null);
                this.bQk.c(portrait, 12, false);
            }
        }
        if (EY() != null) {
            EY().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9488, feedData, null, null));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.core.util.aq.j(getRootView(), w.g.list_selector);
        com.baidu.tbadk.core.util.aq.k(this.arQ, w.e.cp_bg_line_b);
        this.bwB.setTextColor(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_cont_b));
        this.bKI.setTextColor(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_cont_d));
        this.amB.setTextColor(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_cont_f));
        this.buI.setTextColor(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_cont_d));
        this.mTitle.setTextColor(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_cont_c));
        com.baidu.tbadk.core.util.aq.c(this.dhq, w.e.cp_cont_c, 1);
        this.dhq.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_reply_n), (Drawable) null, (Drawable) null, (Drawable) null);
        com.baidu.tbadk.core.util.aq.j(this.mTitle, w.g.bg_ta_dialog_content);
        return true;
    }

    private CharSequence a(TextView textView, SpannableString spannableString) {
        if (textView == null || spannableString == null || this.bJY == null) {
            return null;
        }
        return TextUtils.ellipsize(spannableString, textView.getPaint(), (com.baidu.adp.lib.util.k.af(this.bJY.getPageActivity()) - (this.bJY.getResources().getDimensionPixelSize(w.f.ds30) * 2)) - textView.getCompoundPaddingLeft(), TextUtils.TruncateAt.END);
    }

    private void d(FeedData feedData) {
        LikeData likeData;
        if (FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType())) {
            this.dhq.setVisibility(8);
            List<LikeData> praiseList = feedData.getPraiseList();
            if (praiseList != null && praiseList.size() > 0 && (likeData = praiseList.get(0)) != null) {
                this.amB.setText(likeData.getNameShow());
                this.dhp.setVisibility(8);
                this.bKI.setText(com.baidu.tbadk.core.util.au.q(feedData.getTime()));
                if (praiseList.size() > 3 && praiseList.get(1) != null && praiseList.get(2) != null) {
                    this.bwB.setText(String.format(getString(w.l.message_praise_like_list_more), likeData.getNameShow(), praiseList.get(1).getNameShow(), praiseList.get(2).getNameShow(), String.valueOf(feedData.getPraiseNum())));
                } else if (praiseList.size() > 2 && praiseList.get(1) != null && praiseList.get(2) != null) {
                    this.bwB.setText(String.format(getString(w.l.message_praise_like_list_3), likeData.getNameShow(), praiseList.get(1).getNameShow(), praiseList.get(2).getNameShow()));
                } else if (praiseList.size() > 1 && praiseList.get(1) != null) {
                    this.bwB.setText(String.format(getString(w.l.message_praise_like_list_2), likeData.getNameShow(), praiseList.get(1).getNameShow()));
                } else {
                    this.bwB.setText(String.format(getString(w.l.message_praise_like_list_1), likeData.getNameShow()));
                }
                this.mTitle.setText(this.bJY.getPageActivity().getString(w.l.mention_replyme_original, new Object[]{feedData.getTitle()}));
                if (feedData.getThread_Type() == 33) {
                    this.mTitle.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
                } else {
                    this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (!feedData.isHideForumName() && feedData.getFname() != null && feedData.getFname().length() > 0) {
                    this.buI.setVisibility(0);
                    this.buI.setText(com.baidu.tbadk.core.util.au.j(feedData.getFname(), 12).concat(getString(w.l.forum)));
                } else {
                    this.buI.setVisibility(8);
                }
                this.bQk.setVisibility(0);
                this.bQk.c(likeData.getPortrait(), 12, false);
            }
        }
    }

    private void e(FeedData feedData) {
        LikeData likeData;
        String string;
        String string2;
        String string3;
        String string4;
        this.dhq.setVisibility(8);
        List<LikeData> praiseList = feedData.getPraiseList();
        if (praiseList != null && praiseList.size() > 0 && (likeData = praiseList.get(0)) != null) {
            this.amB.setText(likeData.getNameShow());
            this.dhp.setVisibility(8);
            this.bKI.setText(com.baidu.tbadk.core.util.au.q(feedData.getTime()));
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
                objArr[3] = com.baidu.tbadk.core.util.au.z(feedData.getPraiseNum());
                this.bwB.setText(String.format(string4, objArr));
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
                this.bwB.setText(String.format(string3, objArr2));
            } else if (praiseList.size() > 1 && praiseList.get(1) != null) {
                if (feedData.isAuthor()) {
                    string2 = getString(w.l.message_praise_graffiti_author_list_2);
                } else {
                    string2 = getString(w.l.message_praise_graffiti_list_2);
                }
                Object[] objArr3 = new Object[2];
                objArr3[0] = StringUtils.isNull(likeData.getNameShow()) ? likeData.getName() : likeData.getNameShow();
                objArr3[1] = StringUtils.isNull(praiseList.get(1).getNameShow()) ? praiseList.get(1).getName() : praiseList.get(1).getNameShow();
                this.bwB.setText(String.format(string2, objArr3));
            } else {
                if (feedData.isAuthor()) {
                    string = getString(w.l.message_praise_graffiti_author_list_1);
                } else {
                    string = getString(w.l.message_praise_graffiti_list_1);
                }
                Object[] objArr4 = new Object[1];
                objArr4[0] = StringUtils.isNull(likeData.getNameShow()) ? likeData.getName() : likeData.getNameShow();
                this.bwB.setText(String.format(string, objArr4));
            }
            if (feedData.isAuthor()) {
                this.mTitle.setText(this.bJY.getPageActivity().getString(w.l.mention_replyme_graffiti_author, new Object[]{feedData.getTitle()}));
            } else {
                this.mTitle.setText(this.bJY.getPageActivity().getString(w.l.mention_replyme_graffiti_landlord, new Object[]{feedData.getTitle()}));
            }
            if (feedData.getThread_Type() == 33) {
                this.mTitle.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            if (!feedData.isHideForumName() && feedData.getFname() != null && feedData.getFname().length() > 0) {
                this.buI.setVisibility(0);
                this.buI.setText(com.baidu.tbadk.core.util.au.j(feedData.getFname(), 12).concat(getString(w.l.forum)));
            } else {
                this.buI.setVisibility(8);
            }
            this.bQk.setVisibility(0);
            this.bQk.c(likeData.getPortrait(), 12, false);
        }
    }

    private void f(FeedData feedData) {
        LikeData likeData;
        this.dhq.setVisibility(8);
        List<LikeData> praiseList = feedData.getPraiseList();
        if (praiseList != null && praiseList.size() > 0 && (likeData = praiseList.get(0)) != null) {
            this.amB.setText(likeData.getNameShow());
            this.dhp.setVisibility(8);
            this.bKI.setText(com.baidu.tbadk.core.util.au.q(feedData.getTime()));
            if (praiseList.size() > 2 && praiseList.get(1) != null) {
                this.bwB.setText(String.format(getString(w.l.message_declare_list_more), likeData.getNameShow(), praiseList.get(1).getNameShow(), String.valueOf(feedData.getPraiseNum())));
            } else if (praiseList.size() == 2 && praiseList.get(1) != null) {
                this.bwB.setText(String.format(getString(w.l.message_declare_list_2), likeData.getNameShow(), praiseList.get(1).getNameShow()));
            } else {
                this.bwB.setText(String.format(getString(w.l.message_declare_list_1), likeData.getNameShow()));
            }
            this.mTitle.setText(this.bJY.getPageActivity().getString(w.l.mention_replyme_original, new Object[]{feedData.getTitle()}));
            if (feedData.getThread_Type() == 33) {
                this.mTitle.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            if (!feedData.isHideForumName() && feedData.getFname() != null && feedData.getFname().length() > 0) {
                this.buI.setVisibility(0);
                this.buI.setText(com.baidu.tbadk.core.util.au.j(feedData.getFname(), 12).concat(getString(w.l.forum)));
            } else {
                this.buI.setVisibility(8);
            }
            this.bQk.setVisibility(0);
            this.bQk.c(likeData.getPortrait(), 12, false);
        }
    }
}
