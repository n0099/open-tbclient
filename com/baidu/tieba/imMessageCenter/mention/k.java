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
    private TextView apG;
    private View auM;
    private TbPageContext<?> bFe;
    private TextView bFy;
    private TextView bIw;
    private TextView cdR;
    private HeadImageView cld;
    private TextView dEA;
    private SpannableString dEB;
    private SpannableString dEC;
    private TextView dEz;
    private TextView mTitle;

    public k(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.bFe = tbPageContext;
        this.cld = (HeadImageView) view.findViewById(d.h.photo);
        this.apG = (TextView) view.findViewById(d.h.user_name);
        this.cdR = (TextView) view.findViewById(d.h.time);
        this.dEz = (TextView) view.findViewById(d.h.add_friend_button);
        this.auM = view.findViewById(d.h.line);
        this.bIw = (TextView) view.findViewById(d.h.content);
        this.mTitle = (TextView) view.findViewById(d.h.replyme_title);
        this.bFy = (TextView) view.findViewById(d.h.forum);
        this.dEA = (TextView) view.findViewById(d.h.tv_quick_reply_text);
        this.cld.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                k.this.FN().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9483, k.this.getData(), null, null));
            }
        });
        this.dEz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.k.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                k.this.FN().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9485, k.this.getData(), null, null));
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
                k.this.FN().dispatchMvcEvent(bVar);
            }
        });
        this.dEA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.k.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(9486, k.this.getData(), null, null);
                bVar.setView(k.this.getRootView());
                bVar.fa(k.this.position);
                k.this.FN().dispatchMvcEvent(bVar);
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
            if (com.baidu.tieba.graffiti.b.alZ()) {
                f(feedData);
            }
        } else if (FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType())) {
            e(feedData);
        } else if (FeedData.TYPE_DECLARE.equals(feedData.getPraiseItemType())) {
            g(feedData);
        } else {
            this.dEA.setVisibility(0);
            this.dEA.setTag(Integer.valueOf(this.position));
            if (feedData.getReplyer() != null) {
                this.apG.setText(feedData.getReplyer().getName_show());
                if (feedData.getReplyer().isBigV()) {
                    ai.i(this.apG, d.e.cp_cont_r);
                } else {
                    ai.i(this.apG, d.e.cp_cont_c);
                }
                if (feedData.getReplyer().getIsMyFriend() == 1) {
                    this.dEz.setVisibility(0);
                    this.dEz.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                    this.dEz.setTextColor(ai.getColor(d.e.cp_cont_i));
                    this.dEz.setBackgroundDrawable(ai.getDrawable(d.g.game_center_start_btn));
                    this.dEz.setText(getString(d.l.chat));
                } else {
                    this.dEz.setVisibility(0);
                    this.dEz.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                    this.dEz.setTextColor(ai.getColor(d.e.cp_cont_i));
                    this.dEz.setBackgroundDrawable(ai.getDrawable(d.g.game_center_start_btn));
                    this.dEz.setText(getString(d.l.chat));
                }
                this.cdR.setText(al.r(feedData.getTime()));
                this.dEB = TbFaceManager.Ew().a(this.bFe.getPageActivity().getApplicationContext(), feedData.getContent(), null);
                this.bIw.setText(a(this.bIw, this.dEB));
                if (feedData.getThread_Type() == 33) {
                    this.mTitle.setCompoundDrawablesWithIntrinsicBounds(ai.getDrawable(d.g.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
                } else {
                    this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (feedData.getType() == 1) {
                    if (feedData.isStory()) {
                        this.dEC = TbFaceManager.Ew().a(this.bFe.getPageActivity().getApplicationContext(), this.bFe.getPageActivity().getString(d.l.story_replyme_floor_original, new Object[]{feedData.getQuote_content()}), null);
                    } else {
                        this.dEC = TbFaceManager.Ew().a(this.bFe.getPageActivity().getApplicationContext(), this.bFe.getPageActivity().getString(d.l.mention_replyme_original, new Object[]{feedData.getQuote_content()}), null);
                    }
                    this.mTitle.setText(a(this.mTitle, this.dEC));
                } else if (feedData.isStory()) {
                    this.mTitle.setText(this.bFe.getPageActivity().getString(d.l.story_replyme_original, new Object[]{feedData.getTitle()}));
                } else {
                    this.mTitle.setText(this.bFe.getPageActivity().getString(d.l.mention_replyme_original, new Object[]{feedData.getTitle()}));
                }
                if (!feedData.isHideForumName() && feedData.getFname() != null && feedData.getFname().length() > 0) {
                    this.bFy.setVisibility(0);
                    this.bFy.setText(al.j(feedData.getFname(), 12).concat(getString(d.l.forum)));
                } else {
                    this.bFy.setVisibility(8);
                }
                this.cld.setVisibility(0);
                this.cld.setIsRound(true);
                this.cld.setShowV(feedData.getReplyer().isBigV());
                String portrait = feedData.getReplyer().getPortrait();
                this.cld.setTag(null);
                this.cld.c(portrait, 12, false);
            }
        }
        if (FN() != null) {
            FN().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9488, feedData, null, null));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.l
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        ai.j(getRootView(), d.g.list_selector);
        ai.k(this.auM, d.e.cp_bg_line_b);
        this.bIw.setTextColor(ai.getColor(d.e.cp_cont_b));
        this.cdR.setTextColor(ai.getColor(d.e.cp_cont_d));
        this.bFy.setTextColor(ai.getColor(d.e.cp_cont_d));
        this.mTitle.setTextColor(ai.getColor(d.e.cp_cont_c));
        ai.c(this.dEA, d.e.cp_cont_c, 1);
        this.dEA.setCompoundDrawablesWithIntrinsicBounds(ai.getDrawable(d.g.icon_reply_n), (Drawable) null, (Drawable) null, (Drawable) null);
        ai.j(this.mTitle, d.g.bg_ta_dialog_content);
        return true;
    }

    private CharSequence a(TextView textView, SpannableString spannableString) {
        if (textView == null || spannableString == null || this.bFe == null) {
            return null;
        }
        return TextUtils.ellipsize(spannableString, textView.getPaint(), (com.baidu.adp.lib.util.k.ag(this.bFe.getPageActivity()) - (this.bFe.getResources().getDimensionPixelSize(d.f.ds30) * 2)) - textView.getCompoundPaddingLeft(), TextUtils.TruncateAt.END);
    }

    private void e(FeedData feedData) {
        LikeData likeData;
        if (FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType())) {
            this.dEA.setVisibility(8);
            List<LikeData> praiseList = feedData.getPraiseList();
            if (praiseList != null && praiseList.size() > 0 && (likeData = praiseList.get(0)) != null) {
                this.apG.setText(likeData.getNameShow());
                this.cld.setShowV(likeData.isBigV());
                if (likeData.isBigV()) {
                    ai.i(this.apG, d.e.cp_cont_r);
                } else {
                    ai.i(this.apG, d.e.cp_cont_c);
                }
                this.dEz.setVisibility(8);
                this.cdR.setText(al.r(feedData.getTime()));
                if (praiseList.size() > 3 && praiseList.get(1) != null && praiseList.get(2) != null) {
                    this.bIw.setText(String.format(getString(d.l.message_praise_like_list_more), likeData.getNameShow(), praiseList.get(1).getNameShow(), praiseList.get(2).getNameShow(), String.valueOf(feedData.getPraiseNum())));
                } else if (praiseList.size() > 2 && praiseList.get(1) != null && praiseList.get(2) != null) {
                    this.bIw.setText(String.format(getString(d.l.message_praise_like_list_3), likeData.getNameShow(), praiseList.get(1).getNameShow(), praiseList.get(2).getNameShow()));
                } else if (praiseList.size() > 1 && praiseList.get(1) != null) {
                    this.bIw.setText(String.format(getString(d.l.message_praise_like_list_2), likeData.getNameShow(), praiseList.get(1).getNameShow()));
                } else {
                    this.bIw.setText(String.format(getString(d.l.message_praise_like_list_1), likeData.getNameShow()));
                }
                if (feedData.isStory()) {
                    this.mTitle.setText(this.bFe.getPageActivity().getString(d.l.story_replyme_original, new Object[]{feedData.getTitle()}));
                } else {
                    this.mTitle.setText(this.bFe.getPageActivity().getString(d.l.mention_replyme_original, new Object[]{feedData.getTitle()}));
                }
                if (feedData.getThread_Type() == 33) {
                    this.mTitle.setCompoundDrawablesWithIntrinsicBounds(ai.getDrawable(d.g.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
                } else {
                    this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (!feedData.isHideForumName() && feedData.getFname() != null && feedData.getFname().length() > 0) {
                    this.bFy.setVisibility(0);
                    this.bFy.setText(al.j(feedData.getFname(), 12).concat(getString(d.l.forum)));
                } else {
                    this.bFy.setVisibility(8);
                }
                this.cld.setVisibility(0);
                this.cld.setIsRound(true);
                this.cld.c(likeData.getPortrait(), 12, false);
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
        this.dEA.setVisibility(8);
        List<LikeData> praiseList = feedData.getPraiseList();
        if (praiseList != null && praiseList.size() > 0 && (likeData = praiseList.get(0)) != null) {
            this.apG.setText(likeData.getNameShow());
            this.cld.setShowV(likeData.isBigV());
            if (likeData.isBigV()) {
                ai.i(this.apG, d.e.cp_cont_r);
            } else {
                ai.i(this.apG, d.e.cp_cont_c);
            }
            this.dEz.setVisibility(8);
            this.cdR.setText(al.r(feedData.getTime()));
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
                this.bIw.setText(String.format(string4, objArr));
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
                this.bIw.setText(String.format(string3, objArr2));
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
                this.bIw.setText(String.format(string2, objArr3));
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
                this.bIw.setText(String.format(string, objArr4));
            }
            if (feedData.isAuthor()) {
                this.mTitle.setText(this.bFe.getPageActivity().getString(d.l.mention_replyme_graffiti_author, new Object[]{feedData.getTitle()}));
            } else {
                this.mTitle.setText(this.bFe.getPageActivity().getString(d.l.mention_replyme_graffiti_landlord, new Object[]{feedData.getTitle()}));
            }
            if (feedData.getThread_Type() == 33) {
                this.mTitle.setCompoundDrawablesWithIntrinsicBounds(ai.getDrawable(d.g.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            if (!feedData.isHideForumName() && feedData.getFname() != null && feedData.getFname().length() > 0) {
                this.bFy.setVisibility(0);
                this.bFy.setText(al.j(feedData.getFname(), 12).concat(getString(d.l.forum)));
            } else {
                this.bFy.setVisibility(8);
            }
            this.cld.setVisibility(0);
            this.cld.c(likeData.getPortrait(), 12, false);
        }
    }

    private void g(FeedData feedData) {
        LikeData likeData;
        this.dEA.setVisibility(8);
        List<LikeData> praiseList = feedData.getPraiseList();
        if (praiseList != null && praiseList.size() > 0 && (likeData = praiseList.get(0)) != null) {
            this.apG.setText(likeData.getNameShow());
            this.cld.setShowV(likeData.isBigV());
            if (likeData.isBigV()) {
                ai.i(this.apG, d.e.cp_cont_r);
            } else {
                ai.i(this.apG, d.e.cp_cont_c);
            }
            this.dEz.setVisibility(8);
            this.cdR.setText(al.r(feedData.getTime()));
            if (praiseList.size() > 2 && praiseList.get(1) != null) {
                this.bIw.setText(String.format(getString(d.l.message_declare_list_more), likeData.getNameShow(), praiseList.get(1).getNameShow(), String.valueOf(feedData.getPraiseNum())));
            } else if (praiseList.size() == 2 && praiseList.get(1) != null) {
                this.bIw.setText(String.format(getString(d.l.message_declare_list_2), likeData.getNameShow(), praiseList.get(1).getNameShow()));
            } else {
                this.bIw.setText(String.format(getString(d.l.message_declare_list_1), likeData.getNameShow()));
            }
            if (feedData.isStory()) {
                this.mTitle.setText(this.bFe.getPageActivity().getString(d.l.story_replyme_original, new Object[]{feedData.getTitle()}));
            } else {
                this.mTitle.setText(this.bFe.getPageActivity().getString(d.l.mention_replyme_original, new Object[]{feedData.getTitle()}));
            }
            if (feedData.getThread_Type() == 33) {
                this.mTitle.setCompoundDrawablesWithIntrinsicBounds(ai.getDrawable(d.g.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            if (!feedData.isHideForumName() && feedData.getFname() != null && feedData.getFname().length() > 0) {
                this.bFy.setVisibility(0);
                this.bFy.setText(al.j(feedData.getFname(), 12).concat(getString(d.l.forum)));
            } else {
                this.bFy.setVisibility(8);
            }
            this.cld.setVisibility(0);
            this.cld.c(likeData.getPortrait(), 12, false);
        }
    }
}
