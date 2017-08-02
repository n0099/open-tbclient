package com.baidu.tieba.imMessageCenter.mention;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.d;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public class k extends com.baidu.tbadk.mvc.f.a<FeedData, com.baidu.tbadk.mvc.d.b> {
    private TextView aom;
    private View atu;
    private TbPageContext<?> bDU;
    private TextView bEo;
    private TextView bHm;
    private TextView ccL;
    private HeadImageView cjV;
    private TextView dDi;
    private TextView dDj;
    private SpannableString dDk;
    private SpannableString dDl;
    private TextView mTitle;

    public k(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.bDU = tbPageContext;
        this.cjV = (HeadImageView) view.findViewById(d.h.photo);
        this.aom = (TextView) view.findViewById(d.h.user_name);
        this.ccL = (TextView) view.findViewById(d.h.time);
        this.dDi = (TextView) view.findViewById(d.h.add_friend_button);
        this.atu = view.findViewById(d.h.line);
        this.bHm = (TextView) view.findViewById(d.h.content);
        this.mTitle = (TextView) view.findViewById(d.h.replyme_title);
        this.bEo = (TextView) view.findViewById(d.h.forum);
        this.dDj = (TextView) view.findViewById(d.h.tv_quick_reply_text);
        this.cjV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                k.this.FF().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9483, k.this.getData(), null, null));
            }
        });
        this.dDi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.k.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                k.this.FF().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9485, k.this.getData(), null, null));
                TiebaStatic.log("c10095");
            }
        });
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.k.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.mvc.c.b bVar;
                FeedData data = k.this.getData();
                if (data != null && data.isStory()) {
                    bVar = new com.baidu.tbadk.mvc.c.b(9489, data, null, null);
                } else if (data != null && FeedData.TYPE_GRAFFITI.equals(data.getPraiseItemType())) {
                    bVar = new com.baidu.tbadk.mvc.c.b(9487, data, null, null);
                } else {
                    bVar = new com.baidu.tbadk.mvc.c.b(9484, data, null, null);
                }
                k.this.FF().dispatchMvcEvent(bVar);
            }
        });
        this.dDj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.k.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(9486, k.this.getData(), null, null);
                bVar.setView(k.this.getRootView());
                bVar.eY(k.this.position);
                k.this.FF().dispatchMvcEvent(bVar);
                TiebaStatic.log("c10096");
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void E(FeedData feedData) {
        super.E(feedData);
        if (FeedData.TYPE_GRAFFITI.equals(feedData.getPraiseItemType())) {
            if (com.baidu.tieba.graffiti.b.alM()) {
                f(feedData);
            }
        } else if (FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType())) {
            e(feedData);
        } else if (FeedData.TYPE_DECLARE.equals(feedData.getPraiseItemType())) {
            g(feedData);
        } else {
            this.dDj.setVisibility(0);
            this.dDj.setTag(Integer.valueOf(this.position));
            if (feedData.getReplyer() != null) {
                this.aom.setText(feedData.getReplyer().getName_show());
                if (feedData.getReplyer().isBigV()) {
                    ai.i(this.aom, d.e.cp_cont_r);
                } else {
                    ai.i(this.aom, d.e.cp_cont_c);
                }
                if (feedData.getReplyer().getIsMyFriend() == 1) {
                    this.dDi.setVisibility(0);
                    this.dDi.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                    this.dDi.setTextColor(ai.getColor(d.e.cp_cont_i));
                    this.dDi.setBackgroundDrawable(ai.getDrawable(d.g.game_center_start_btn));
                    this.dDi.setText(getString(d.l.chat));
                } else {
                    this.dDi.setVisibility(0);
                    this.dDi.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                    this.dDi.setTextColor(ai.getColor(d.e.cp_cont_i));
                    this.dDi.setBackgroundDrawable(ai.getDrawable(d.g.game_center_start_btn));
                    this.dDi.setText(getString(d.l.chat));
                }
                this.ccL.setText(al.r(feedData.getTime()));
                this.dDk = TbFaceManager.Eo().a(this.bDU.getPageActivity().getApplicationContext(), feedData.getContent(), null);
                this.bHm.setText(a(this.bHm, this.dDk));
                if (feedData.getThread_Type() == 33) {
                    this.mTitle.setCompoundDrawablesWithIntrinsicBounds(ai.getDrawable(d.g.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
                } else {
                    this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (feedData.getType() == 1) {
                    if (feedData.isStory()) {
                        this.dDl = TbFaceManager.Eo().a(this.bDU.getPageActivity().getApplicationContext(), this.bDU.getPageActivity().getString(d.l.story_replyme_floor_original, new Object[]{feedData.getQuote_content()}), null);
                    } else {
                        this.dDl = TbFaceManager.Eo().a(this.bDU.getPageActivity().getApplicationContext(), this.bDU.getPageActivity().getString(d.l.mention_replyme_original, new Object[]{feedData.getQuote_content()}), null);
                    }
                    this.mTitle.setText(a(this.mTitle, this.dDl));
                } else if (feedData.isStory()) {
                    this.mTitle.setText(this.bDU.getPageActivity().getString(d.l.story_replyme_original, new Object[]{feedData.getTitle()}));
                } else {
                    this.mTitle.setText(this.bDU.getPageActivity().getString(d.l.mention_replyme_original, new Object[]{feedData.getTitle()}));
                }
                if (!feedData.isHideForumName() && feedData.getFname() != null && feedData.getFname().length() > 0) {
                    this.bEo.setVisibility(0);
                    this.bEo.setText(al.j(feedData.getFname(), 12).concat(getString(d.l.forum)));
                } else {
                    this.bEo.setVisibility(8);
                }
                this.cjV.setVisibility(0);
                this.cjV.setIsRound(true);
                this.cjV.setShowV(feedData.getReplyer().isBigV());
                String portrait = feedData.getReplyer().getPortrait();
                this.cjV.setTag(null);
                this.cjV.c(portrait, 12, false);
            }
        }
        if (FF() != null) {
            FF().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9488, feedData, null, null));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.l
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        ai.j(getRootView(), d.g.list_selector);
        ai.k(this.atu, d.e.cp_bg_line_b);
        this.bHm.setTextColor(ai.getColor(d.e.cp_cont_b));
        this.ccL.setTextColor(ai.getColor(d.e.cp_cont_d));
        this.bEo.setTextColor(ai.getColor(d.e.cp_cont_d));
        this.mTitle.setTextColor(ai.getColor(d.e.cp_cont_c));
        ai.c(this.dDj, d.e.cp_cont_c, 1);
        this.dDj.setCompoundDrawablesWithIntrinsicBounds(ai.getDrawable(d.g.icon_reply_n), (Drawable) null, (Drawable) null, (Drawable) null);
        ai.j(this.mTitle, d.g.bg_ta_dialog_content);
        return true;
    }

    private CharSequence a(TextView textView, SpannableString spannableString) {
        if (textView == null || spannableString == null || this.bDU == null) {
            return null;
        }
        return TextUtils.ellipsize(spannableString, textView.getPaint(), (com.baidu.adp.lib.util.k.af(this.bDU.getPageActivity()) - (this.bDU.getResources().getDimensionPixelSize(d.f.ds30) * 2)) - textView.getCompoundPaddingLeft(), TextUtils.TruncateAt.END);
    }

    private void e(FeedData feedData) {
        LikeData likeData;
        if (FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType())) {
            this.dDj.setVisibility(8);
            List<LikeData> praiseList = feedData.getPraiseList();
            if (praiseList != null && praiseList.size() > 0 && (likeData = praiseList.get(0)) != null) {
                this.aom.setText(likeData.getNameShow());
                this.cjV.setShowV(likeData.isBigV());
                if (likeData.isBigV()) {
                    ai.i(this.aom, d.e.cp_cont_r);
                } else {
                    ai.i(this.aom, d.e.cp_cont_c);
                }
                this.dDi.setVisibility(8);
                this.ccL.setText(al.r(feedData.getTime()));
                if (praiseList.size() > 3 && praiseList.get(1) != null && praiseList.get(2) != null) {
                    this.bHm.setText(String.format(getString(d.l.message_praise_like_list_more), likeData.getNameShow(), praiseList.get(1).getNameShow(), praiseList.get(2).getNameShow(), String.valueOf(feedData.getPraiseNum())));
                } else if (praiseList.size() > 2 && praiseList.get(1) != null && praiseList.get(2) != null) {
                    this.bHm.setText(String.format(getString(d.l.message_praise_like_list_3), likeData.getNameShow(), praiseList.get(1).getNameShow(), praiseList.get(2).getNameShow()));
                } else if (praiseList.size() > 1 && praiseList.get(1) != null) {
                    this.bHm.setText(String.format(getString(d.l.message_praise_like_list_2), likeData.getNameShow(), praiseList.get(1).getNameShow()));
                } else {
                    this.bHm.setText(String.format(getString(d.l.message_praise_like_list_1), likeData.getNameShow()));
                }
                if (feedData.isStory()) {
                    this.mTitle.setText(this.bDU.getPageActivity().getString(d.l.story_replyme_original, new Object[]{feedData.getTitle()}));
                } else {
                    this.mTitle.setText(this.bDU.getPageActivity().getString(d.l.mention_replyme_original, new Object[]{feedData.getTitle()}));
                }
                if (feedData.getThread_Type() == 33) {
                    this.mTitle.setCompoundDrawablesWithIntrinsicBounds(ai.getDrawable(d.g.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
                } else {
                    this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (!feedData.isHideForumName() && feedData.getFname() != null && feedData.getFname().length() > 0) {
                    this.bEo.setVisibility(0);
                    this.bEo.setText(al.j(feedData.getFname(), 12).concat(getString(d.l.forum)));
                } else {
                    this.bEo.setVisibility(8);
                }
                this.cjV.setVisibility(0);
                this.cjV.setIsRound(true);
                this.cjV.c(likeData.getPortrait(), 12, false);
            }
        }
    }

    private void f(FeedData feedData) {
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
        this.dDj.setVisibility(8);
        List<LikeData> praiseList = feedData.getPraiseList();
        if (praiseList != null && praiseList.size() > 0 && (likeData = praiseList.get(0)) != null) {
            this.aom.setText(likeData.getNameShow());
            this.cjV.setShowV(likeData.isBigV());
            if (likeData.isBigV()) {
                ai.i(this.aom, d.e.cp_cont_r);
            } else {
                ai.i(this.aom, d.e.cp_cont_c);
            }
            this.dDi.setVisibility(8);
            this.ccL.setText(al.r(feedData.getTime()));
            if (praiseList.size() > 3 && praiseList.get(1) != null && praiseList.get(2) != null) {
                if (feedData.isAuthor()) {
                    string4 = getString(d.l.message_praise_graffiti_author_list_more);
                } else {
                    string4 = getString(d.l.message_praise_graffiti_list_more);
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
                objArr[3] = al.B(feedData.getPraiseNum());
                this.bHm.setText(String.format(string4, objArr));
            } else if (praiseList.size() > 2 && praiseList.get(1) != null && praiseList.get(2) != null) {
                if (feedData.isAuthor()) {
                    string3 = getString(d.l.message_praise_graffiti_author_list_3);
                } else {
                    string3 = getString(d.l.message_praise_graffiti_list_3);
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
                this.bHm.setText(String.format(string3, objArr2));
            } else if (praiseList.size() > 1 && praiseList.get(1) != null) {
                if (feedData.isAuthor()) {
                    string2 = getString(d.l.message_praise_graffiti_author_list_2);
                } else {
                    string2 = getString(d.l.message_praise_graffiti_list_2);
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
                this.bHm.setText(String.format(string2, objArr3));
            } else {
                if (feedData.isAuthor()) {
                    string = getString(d.l.message_praise_graffiti_author_list_1);
                } else {
                    string = getString(d.l.message_praise_graffiti_list_1);
                }
                Object[] objArr4 = new Object[1];
                if (StringUtils.isNull(likeData.getNameShow())) {
                    nameShow = likeData.getName();
                } else {
                    nameShow = likeData.getNameShow();
                }
                objArr4[0] = nameShow;
                this.bHm.setText(String.format(string, objArr4));
            }
            if (feedData.isAuthor()) {
                this.mTitle.setText(this.bDU.getPageActivity().getString(d.l.mention_replyme_graffiti_author, new Object[]{feedData.getTitle()}));
            } else {
                this.mTitle.setText(this.bDU.getPageActivity().getString(d.l.mention_replyme_graffiti_landlord, new Object[]{feedData.getTitle()}));
            }
            if (feedData.getThread_Type() == 33) {
                this.mTitle.setCompoundDrawablesWithIntrinsicBounds(ai.getDrawable(d.g.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            if (!feedData.isHideForumName() && feedData.getFname() != null && feedData.getFname().length() > 0) {
                this.bEo.setVisibility(0);
                this.bEo.setText(al.j(feedData.getFname(), 12).concat(getString(d.l.forum)));
            } else {
                this.bEo.setVisibility(8);
            }
            this.cjV.setVisibility(0);
            this.cjV.c(likeData.getPortrait(), 12, false);
        }
    }

    private void g(FeedData feedData) {
        LikeData likeData;
        this.dDj.setVisibility(8);
        List<LikeData> praiseList = feedData.getPraiseList();
        if (praiseList != null && praiseList.size() > 0 && (likeData = praiseList.get(0)) != null) {
            this.aom.setText(likeData.getNameShow());
            this.cjV.setShowV(likeData.isBigV());
            if (likeData.isBigV()) {
                ai.i(this.aom, d.e.cp_cont_r);
            } else {
                ai.i(this.aom, d.e.cp_cont_c);
            }
            this.dDi.setVisibility(8);
            this.ccL.setText(al.r(feedData.getTime()));
            if (praiseList.size() > 2 && praiseList.get(1) != null) {
                this.bHm.setText(String.format(getString(d.l.message_declare_list_more), likeData.getNameShow(), praiseList.get(1).getNameShow(), String.valueOf(feedData.getPraiseNum())));
            } else if (praiseList.size() == 2 && praiseList.get(1) != null) {
                this.bHm.setText(String.format(getString(d.l.message_declare_list_2), likeData.getNameShow(), praiseList.get(1).getNameShow()));
            } else {
                this.bHm.setText(String.format(getString(d.l.message_declare_list_1), likeData.getNameShow()));
            }
            if (feedData.isStory()) {
                this.mTitle.setText(this.bDU.getPageActivity().getString(d.l.story_replyme_original, new Object[]{feedData.getTitle()}));
            } else {
                this.mTitle.setText(this.bDU.getPageActivity().getString(d.l.mention_replyme_original, new Object[]{feedData.getTitle()}));
            }
            if (feedData.getThread_Type() == 33) {
                this.mTitle.setCompoundDrawablesWithIntrinsicBounds(ai.getDrawable(d.g.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            if (!feedData.isHideForumName() && feedData.getFname() != null && feedData.getFname().length() > 0) {
                this.bEo.setVisibility(0);
                this.bEo.setText(al.j(feedData.getFname(), 12).concat(getString(d.l.forum)));
            } else {
                this.bEo.setVisibility(8);
            }
            this.cjV.setVisibility(0);
            this.cjV.c(likeData.getPortrait(), 12, false);
        }
    }
}
