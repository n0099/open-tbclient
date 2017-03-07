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
    private TextView aSO;
    private TextView amc;
    private View ary;
    private TbPageContext<?> bIK;
    private TextView bJu;
    private HeadImageView bPn;
    private TextView bsA;
    private TextView bus;
    private TextView dmu;
    private TextView dmv;
    private SpannableString dmw;
    private SpannableString dmx;

    public al(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.bIK = tbPageContext;
        this.bPn = (HeadImageView) view.findViewById(w.h.photo);
        this.amc = (TextView) view.findViewById(w.h.user_name);
        this.bJu = (TextView) view.findViewById(w.h.time);
        this.dmu = (TextView) view.findViewById(w.h.add_friend_button);
        this.ary = view.findViewById(w.h.line);
        this.bus = (TextView) view.findViewById(w.h.content);
        this.aSO = (TextView) view.findViewById(w.h.replyme_title);
        this.bsA = (TextView) view.findViewById(w.h.forum);
        this.dmv = (TextView) view.findViewById(w.h.tv_quick_reply_text);
        this.bPn.setOnClickListener(new am(this));
        this.dmu.setOnClickListener(new an(this));
        view.setOnClickListener(new ao(this));
        this.dmv.setOnClickListener(new ap(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void E(FeedData feedData) {
        super.E(feedData);
        if (FeedData.TYPE_GRAFFITI.equals(feedData.getPraiseItemType())) {
            if (com.baidu.tieba.graffiti.c.agJ()) {
                e(feedData);
            }
        } else if (FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType())) {
            d(feedData);
        } else if (FeedData.TYPE_DECLARE.equals(feedData.getPraiseItemType())) {
            f(feedData);
        } else {
            this.dmv.setVisibility(0);
            this.dmv.setTag(Integer.valueOf(this.position));
            if (feedData.getReplyer() != null) {
                this.amc.setText(feedData.getReplyer().getName_show());
                if (feedData.getReplyer().getIsMyFriend() == 1) {
                    this.dmu.setVisibility(0);
                    this.dmu.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                    this.dmu.setTextColor(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_cont_i));
                    this.dmu.setBackgroundDrawable(com.baidu.tbadk.core.util.aq.getDrawable(w.g.game_center_start_btn));
                    this.dmu.setText(getString(w.l.chat));
                } else {
                    this.dmu.setVisibility(0);
                    this.dmu.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                    this.dmu.setTextColor(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_cont_i));
                    this.dmu.setBackgroundDrawable(com.baidu.tbadk.core.util.aq.getDrawable(w.g.game_center_start_btn));
                    this.dmu.setText(getString(w.l.chat));
                }
                this.bJu.setText(com.baidu.tbadk.core.util.au.q(feedData.getTime()));
                this.dmw = TbFaceManager.Ek().a(this.bIK.getPageActivity().getApplicationContext(), feedData.getContent(), null);
                this.bus.setText(a(this.bus, this.dmw));
                if (feedData.getThread_Type() == 33) {
                    this.aSO.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
                } else {
                    this.aSO.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (feedData.getType() == 1) {
                    this.dmx = TbFaceManager.Ek().a(this.bIK.getPageActivity().getApplicationContext(), this.bIK.getPageActivity().getString(w.l.mention_replyme_original, new Object[]{feedData.getQuote_content()}), null);
                    this.aSO.setText(a(this.aSO, this.dmx));
                } else {
                    this.aSO.setText(this.bIK.getPageActivity().getString(w.l.mention_replyme_original, new Object[]{feedData.getTitle()}));
                }
                if (feedData.getFname() != null && feedData.getFname().length() > 0) {
                    this.bsA.setVisibility(0);
                    this.bsA.setText(com.baidu.tbadk.core.util.au.j(feedData.getFname(), 12).concat(getString(w.l.forum)));
                } else {
                    this.bsA.setVisibility(8);
                }
                this.bPn.setVisibility(0);
                String portrait = feedData.getReplyer().getPortrait();
                this.bPn.setTag(null);
                this.bPn.c(portrait, 12, false);
            }
        }
        if (Fw() != null) {
            Fw().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9488, feedData, null, null));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.core.util.aq.j(getRootView(), w.g.list_selector);
        com.baidu.tbadk.core.util.aq.k(this.ary, w.e.cp_bg_line_b);
        this.bus.setTextColor(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_cont_b));
        this.bJu.setTextColor(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_cont_d));
        this.amc.setTextColor(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_cont_f));
        this.bsA.setTextColor(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_cont_d));
        this.aSO.setTextColor(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_cont_c));
        com.baidu.tbadk.core.util.aq.c(this.dmv, w.e.cp_cont_c, 1);
        this.dmv.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_reply_n), (Drawable) null, (Drawable) null, (Drawable) null);
        com.baidu.tbadk.core.util.aq.j(this.aSO, w.g.bg_ta_dialog_content);
        return true;
    }

    private CharSequence a(TextView textView, SpannableString spannableString) {
        if (textView == null || spannableString == null || this.bIK == null) {
            return null;
        }
        return TextUtils.ellipsize(spannableString, textView.getPaint(), (com.baidu.adp.lib.util.k.ag(this.bIK.getPageActivity()) - (this.bIK.getResources().getDimensionPixelSize(w.f.ds30) * 2)) - textView.getCompoundPaddingLeft(), TextUtils.TruncateAt.END);
    }

    private void d(FeedData feedData) {
        LikeData likeData;
        if (FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType())) {
            this.dmv.setVisibility(8);
            List<LikeData> praiseList = feedData.getPraiseList();
            if (praiseList != null && praiseList.size() > 0 && (likeData = praiseList.get(0)) != null) {
                this.amc.setText(likeData.getNameShow());
                this.dmu.setVisibility(8);
                this.bJu.setText(com.baidu.tbadk.core.util.au.q(feedData.getTime()));
                if (praiseList.size() > 3 && praiseList.get(1) != null && praiseList.get(2) != null) {
                    this.bus.setText(String.format(getString(w.l.message_praise_like_list_more), likeData.getNameShow(), praiseList.get(1).getNameShow(), praiseList.get(2).getNameShow(), String.valueOf(feedData.getPraiseNum())));
                } else if (praiseList.size() > 2 && praiseList.get(1) != null && praiseList.get(2) != null) {
                    this.bus.setText(String.format(getString(w.l.message_praise_like_list_3), likeData.getNameShow(), praiseList.get(1).getNameShow(), praiseList.get(2).getNameShow()));
                } else if (praiseList.size() > 1 && praiseList.get(1) != null) {
                    this.bus.setText(String.format(getString(w.l.message_praise_like_list_2), likeData.getNameShow(), praiseList.get(1).getNameShow()));
                } else {
                    this.bus.setText(String.format(getString(w.l.message_praise_like_list_1), likeData.getNameShow()));
                }
                this.aSO.setText(this.bIK.getPageActivity().getString(w.l.mention_replyme_original, new Object[]{feedData.getTitle()}));
                if (feedData.getThread_Type() == 33) {
                    this.aSO.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
                } else {
                    this.aSO.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (feedData.getFname() != null && feedData.getFname().length() > 0) {
                    this.bsA.setVisibility(0);
                    this.bsA.setText(com.baidu.tbadk.core.util.au.j(feedData.getFname(), 12).concat(getString(w.l.forum)));
                } else {
                    this.bsA.setVisibility(8);
                }
                this.bPn.setVisibility(0);
                this.bPn.c(likeData.getPortrait(), 12, false);
            }
        }
    }

    private void e(FeedData feedData) {
        LikeData likeData;
        String string;
        String string2;
        String string3;
        String string4;
        this.dmv.setVisibility(8);
        List<LikeData> praiseList = feedData.getPraiseList();
        if (praiseList != null && praiseList.size() > 0 && (likeData = praiseList.get(0)) != null) {
            this.amc.setText(likeData.getNameShow());
            this.dmu.setVisibility(8);
            this.bJu.setText(com.baidu.tbadk.core.util.au.q(feedData.getTime()));
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
                this.bus.setText(String.format(string4, objArr));
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
                this.bus.setText(String.format(string3, objArr2));
            } else if (praiseList.size() > 1 && praiseList.get(1) != null) {
                if (feedData.isAuthor()) {
                    string2 = getString(w.l.message_praise_graffiti_author_list_2);
                } else {
                    string2 = getString(w.l.message_praise_graffiti_list_2);
                }
                Object[] objArr3 = new Object[2];
                objArr3[0] = StringUtils.isNull(likeData.getNameShow()) ? likeData.getName() : likeData.getNameShow();
                objArr3[1] = StringUtils.isNull(praiseList.get(1).getNameShow()) ? praiseList.get(1).getName() : praiseList.get(1).getNameShow();
                this.bus.setText(String.format(string2, objArr3));
            } else {
                if (feedData.isAuthor()) {
                    string = getString(w.l.message_praise_graffiti_author_list_1);
                } else {
                    string = getString(w.l.message_praise_graffiti_list_1);
                }
                Object[] objArr4 = new Object[1];
                objArr4[0] = StringUtils.isNull(likeData.getNameShow()) ? likeData.getName() : likeData.getNameShow();
                this.bus.setText(String.format(string, objArr4));
            }
            if (feedData.isAuthor()) {
                this.aSO.setText(this.bIK.getPageActivity().getString(w.l.mention_replyme_graffiti_author, new Object[]{feedData.getTitle()}));
            } else {
                this.aSO.setText(this.bIK.getPageActivity().getString(w.l.mention_replyme_graffiti_landlord, new Object[]{feedData.getTitle()}));
            }
            if (feedData.getThread_Type() == 33) {
                this.aSO.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.aSO.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            if (feedData.getFname() != null && feedData.getFname().length() > 0) {
                this.bsA.setVisibility(0);
                this.bsA.setText(com.baidu.tbadk.core.util.au.j(feedData.getFname(), 12).concat(getString(w.l.forum)));
            } else {
                this.bsA.setVisibility(8);
            }
            this.bPn.setVisibility(0);
            this.bPn.c(likeData.getPortrait(), 12, false);
        }
    }

    private void f(FeedData feedData) {
        LikeData likeData;
        this.dmv.setVisibility(8);
        List<LikeData> praiseList = feedData.getPraiseList();
        if (praiseList != null && praiseList.size() > 0 && (likeData = praiseList.get(0)) != null) {
            this.amc.setText(likeData.getNameShow());
            this.dmu.setVisibility(8);
            this.bJu.setText(com.baidu.tbadk.core.util.au.q(feedData.getTime()));
            if (praiseList.size() > 2 && praiseList.get(1) != null) {
                this.bus.setText(String.format(getString(w.l.message_declare_list_more), likeData.getNameShow(), praiseList.get(1).getNameShow(), String.valueOf(feedData.getPraiseNum())));
            } else if (praiseList.size() == 2 && praiseList.get(1) != null) {
                this.bus.setText(String.format(getString(w.l.message_declare_list_2), likeData.getNameShow(), praiseList.get(1).getNameShow()));
            } else {
                this.bus.setText(String.format(getString(w.l.message_declare_list_1), likeData.getNameShow()));
            }
            this.aSO.setText(this.bIK.getPageActivity().getString(w.l.mention_replyme_original, new Object[]{feedData.getTitle()}));
            if (feedData.getThread_Type() == 33) {
                this.aSO.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.aq.getDrawable(w.g.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.aSO.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            if (feedData.getFname() != null && feedData.getFname().length() > 0) {
                this.bsA.setVisibility(0);
                this.bsA.setText(com.baidu.tbadk.core.util.au.j(feedData.getFname(), 12).concat(getString(w.l.forum)));
            } else {
                this.bsA.setVisibility(8);
            }
            this.bPn.setVisibility(0);
            this.bPn.c(likeData.getPortrait(), 12, false);
        }
    }
}
