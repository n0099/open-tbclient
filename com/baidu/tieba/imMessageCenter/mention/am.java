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
    private TextView amy;
    private View arA;
    private TextView bCm;
    private TextView bQv;
    private HeadImageView bWb;
    private TbPageContext<?> byP;
    private TextView bzo;
    private TextView dmL;
    private TextView dmM;
    private SpannableString dmN;
    private SpannableString dmO;
    private TextView mTitle;

    public am(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.byP = tbPageContext;
        this.bWb = (HeadImageView) view.findViewById(w.h.photo);
        this.amy = (TextView) view.findViewById(w.h.user_name);
        this.bQv = (TextView) view.findViewById(w.h.time);
        this.dmL = (TextView) view.findViewById(w.h.add_friend_button);
        this.arA = view.findViewById(w.h.line);
        this.bCm = (TextView) view.findViewById(w.h.content);
        this.mTitle = (TextView) view.findViewById(w.h.replyme_title);
        this.bzo = (TextView) view.findViewById(w.h.forum);
        this.dmM = (TextView) view.findViewById(w.h.tv_quick_reply_text);
        this.bWb.setOnClickListener(new an(this));
        this.dmL.setOnClickListener(new ao(this));
        view.setOnClickListener(new ap(this));
        this.dmM.setOnClickListener(new aq(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void E(FeedData feedData) {
        super.E(feedData);
        if (FeedData.TYPE_GRAFFITI.equals(feedData.getPraiseItemType())) {
            if (com.baidu.tieba.graffiti.c.agC()) {
                e(feedData);
            }
        } else if (FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType())) {
            d(feedData);
        } else if (FeedData.TYPE_DECLARE.equals(feedData.getPraiseItemType())) {
            f(feedData);
        } else {
            this.dmM.setVisibility(0);
            this.dmM.setTag(Integer.valueOf(this.position));
            if (feedData.getReplyer() != null) {
                this.amy.setText(feedData.getReplyer().getName_show());
                if (feedData.getReplyer().getIsMyFriend() == 1) {
                    this.dmL.setVisibility(0);
                    this.dmL.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                    this.dmL.setTextColor(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_cont_i));
                    this.dmL.setBackgroundDrawable(com.baidu.tbadk.core.util.aq.getDrawable(w.g.game_center_start_btn));
                    this.dmL.setText(getString(w.l.chat));
                } else {
                    this.dmL.setVisibility(0);
                    this.dmL.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                    this.dmL.setTextColor(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_cont_i));
                    this.dmL.setBackgroundDrawable(com.baidu.tbadk.core.util.aq.getDrawable(w.g.game_center_start_btn));
                    this.dmL.setText(getString(w.l.chat));
                }
                this.bQv.setText(com.baidu.tbadk.core.util.au.q(feedData.getTime()));
                this.dmN = TbFaceManager.DG().a(this.byP.getPageActivity().getApplicationContext(), feedData.getContent(), null);
                this.bCm.setText(a(this.bCm, this.dmN));
                if (feedData.getThread_Type() == 33) {
                    this.mTitle.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
                } else {
                    this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (feedData.getType() == 1) {
                    this.dmO = TbFaceManager.DG().a(this.byP.getPageActivity().getApplicationContext(), this.byP.getPageActivity().getString(w.l.mention_replyme_original, new Object[]{feedData.getQuote_content()}), null);
                    this.mTitle.setText(a(this.mTitle, this.dmO));
                } else {
                    this.mTitle.setText(this.byP.getPageActivity().getString(w.l.mention_replyme_original, new Object[]{feedData.getTitle()}));
                }
                if (!feedData.isHideForumName() && feedData.getFname() != null && feedData.getFname().length() > 0) {
                    this.bzo.setVisibility(0);
                    this.bzo.setText(com.baidu.tbadk.core.util.au.j(feedData.getFname(), 12).concat(getString(w.l.forum)));
                } else {
                    this.bzo.setVisibility(8);
                }
                this.bWb.setVisibility(0);
                String portrait = feedData.getReplyer().getPortrait();
                this.bWb.setTag(null);
                this.bWb.c(portrait, 12, false);
            }
        }
        if (ES() != null) {
            ES().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9488, feedData, null, null));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.core.util.aq.j(getRootView(), w.g.list_selector);
        com.baidu.tbadk.core.util.aq.k(this.arA, w.e.cp_bg_line_b);
        this.bCm.setTextColor(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_cont_b));
        this.bQv.setTextColor(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_cont_d));
        this.amy.setTextColor(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_cont_f));
        this.bzo.setTextColor(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_cont_d));
        this.mTitle.setTextColor(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_cont_c));
        com.baidu.tbadk.core.util.aq.c(this.dmM, w.e.cp_cont_c, 1);
        this.dmM.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_reply_n), (Drawable) null, (Drawable) null, (Drawable) null);
        com.baidu.tbadk.core.util.aq.j(this.mTitle, w.g.bg_ta_dialog_content);
        return true;
    }

    private CharSequence a(TextView textView, SpannableString spannableString) {
        if (textView == null || spannableString == null || this.byP == null) {
            return null;
        }
        return TextUtils.ellipsize(spannableString, textView.getPaint(), (com.baidu.adp.lib.util.k.af(this.byP.getPageActivity()) - (this.byP.getResources().getDimensionPixelSize(w.f.ds30) * 2)) - textView.getCompoundPaddingLeft(), TextUtils.TruncateAt.END);
    }

    private void d(FeedData feedData) {
        LikeData likeData;
        if (FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType())) {
            this.dmM.setVisibility(8);
            List<LikeData> praiseList = feedData.getPraiseList();
            if (praiseList != null && praiseList.size() > 0 && (likeData = praiseList.get(0)) != null) {
                this.amy.setText(likeData.getNameShow());
                this.dmL.setVisibility(8);
                this.bQv.setText(com.baidu.tbadk.core.util.au.q(feedData.getTime()));
                if (praiseList.size() > 3 && praiseList.get(1) != null && praiseList.get(2) != null) {
                    this.bCm.setText(String.format(getString(w.l.message_praise_like_list_more), likeData.getNameShow(), praiseList.get(1).getNameShow(), praiseList.get(2).getNameShow(), String.valueOf(feedData.getPraiseNum())));
                } else if (praiseList.size() > 2 && praiseList.get(1) != null && praiseList.get(2) != null) {
                    this.bCm.setText(String.format(getString(w.l.message_praise_like_list_3), likeData.getNameShow(), praiseList.get(1).getNameShow(), praiseList.get(2).getNameShow()));
                } else if (praiseList.size() > 1 && praiseList.get(1) != null) {
                    this.bCm.setText(String.format(getString(w.l.message_praise_like_list_2), likeData.getNameShow(), praiseList.get(1).getNameShow()));
                } else {
                    this.bCm.setText(String.format(getString(w.l.message_praise_like_list_1), likeData.getNameShow()));
                }
                this.mTitle.setText(this.byP.getPageActivity().getString(w.l.mention_replyme_original, new Object[]{feedData.getTitle()}));
                if (feedData.getThread_Type() == 33) {
                    this.mTitle.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
                } else {
                    this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (!feedData.isHideForumName() && feedData.getFname() != null && feedData.getFname().length() > 0) {
                    this.bzo.setVisibility(0);
                    this.bzo.setText(com.baidu.tbadk.core.util.au.j(feedData.getFname(), 12).concat(getString(w.l.forum)));
                } else {
                    this.bzo.setVisibility(8);
                }
                this.bWb.setVisibility(0);
                this.bWb.c(likeData.getPortrait(), 12, false);
            }
        }
    }

    private void e(FeedData feedData) {
        LikeData likeData;
        String string;
        String string2;
        String string3;
        String string4;
        this.dmM.setVisibility(8);
        List<LikeData> praiseList = feedData.getPraiseList();
        if (praiseList != null && praiseList.size() > 0 && (likeData = praiseList.get(0)) != null) {
            this.amy.setText(likeData.getNameShow());
            this.dmL.setVisibility(8);
            this.bQv.setText(com.baidu.tbadk.core.util.au.q(feedData.getTime()));
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
                this.bCm.setText(String.format(string4, objArr));
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
                this.bCm.setText(String.format(string3, objArr2));
            } else if (praiseList.size() > 1 && praiseList.get(1) != null) {
                if (feedData.isAuthor()) {
                    string2 = getString(w.l.message_praise_graffiti_author_list_2);
                } else {
                    string2 = getString(w.l.message_praise_graffiti_list_2);
                }
                Object[] objArr3 = new Object[2];
                objArr3[0] = StringUtils.isNull(likeData.getNameShow()) ? likeData.getName() : likeData.getNameShow();
                objArr3[1] = StringUtils.isNull(praiseList.get(1).getNameShow()) ? praiseList.get(1).getName() : praiseList.get(1).getNameShow();
                this.bCm.setText(String.format(string2, objArr3));
            } else {
                if (feedData.isAuthor()) {
                    string = getString(w.l.message_praise_graffiti_author_list_1);
                } else {
                    string = getString(w.l.message_praise_graffiti_list_1);
                }
                Object[] objArr4 = new Object[1];
                objArr4[0] = StringUtils.isNull(likeData.getNameShow()) ? likeData.getName() : likeData.getNameShow();
                this.bCm.setText(String.format(string, objArr4));
            }
            if (feedData.isAuthor()) {
                this.mTitle.setText(this.byP.getPageActivity().getString(w.l.mention_replyme_graffiti_author, new Object[]{feedData.getTitle()}));
            } else {
                this.mTitle.setText(this.byP.getPageActivity().getString(w.l.mention_replyme_graffiti_landlord, new Object[]{feedData.getTitle()}));
            }
            if (feedData.getThread_Type() == 33) {
                this.mTitle.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            if (!feedData.isHideForumName() && feedData.getFname() != null && feedData.getFname().length() > 0) {
                this.bzo.setVisibility(0);
                this.bzo.setText(com.baidu.tbadk.core.util.au.j(feedData.getFname(), 12).concat(getString(w.l.forum)));
            } else {
                this.bzo.setVisibility(8);
            }
            this.bWb.setVisibility(0);
            this.bWb.c(likeData.getPortrait(), 12, false);
        }
    }

    private void f(FeedData feedData) {
        LikeData likeData;
        this.dmM.setVisibility(8);
        List<LikeData> praiseList = feedData.getPraiseList();
        if (praiseList != null && praiseList.size() > 0 && (likeData = praiseList.get(0)) != null) {
            this.amy.setText(likeData.getNameShow());
            this.dmL.setVisibility(8);
            this.bQv.setText(com.baidu.tbadk.core.util.au.q(feedData.getTime()));
            if (praiseList.size() > 2 && praiseList.get(1) != null) {
                this.bCm.setText(String.format(getString(w.l.message_declare_list_more), likeData.getNameShow(), praiseList.get(1).getNameShow(), String.valueOf(feedData.getPraiseNum())));
            } else if (praiseList.size() == 2 && praiseList.get(1) != null) {
                this.bCm.setText(String.format(getString(w.l.message_declare_list_2), likeData.getNameShow(), praiseList.get(1).getNameShow()));
            } else {
                this.bCm.setText(String.format(getString(w.l.message_declare_list_1), likeData.getNameShow()));
            }
            this.mTitle.setText(this.byP.getPageActivity().getString(w.l.mention_replyme_original, new Object[]{feedData.getTitle()}));
            if (feedData.getThread_Type() == 33) {
                this.mTitle.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            if (!feedData.isHideForumName() && feedData.getFname() != null && feedData.getFname().length() > 0) {
                this.bzo.setVisibility(0);
                this.bzo.setText(com.baidu.tbadk.core.util.au.j(feedData.getFname(), 12).concat(getString(w.l.forum)));
            } else {
                this.bzo.setVisibility(8);
            }
            this.bWb.setVisibility(0);
            this.bWb.c(likeData.getPortrait(), 12, false);
        }
    }
}
