package com.baidu.tieba.imMessageCenter.mention;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.d;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public class k extends com.baidu.tbadk.mvc.f.a<FeedData, com.baidu.tbadk.mvc.d.b> {
    private TextView aoE;
    private TextView bRG;
    private TbPageContext<?> coQ;
    private TextView cpA;
    private HeadImageView czK;
    private View dQT;
    private TextView dQU;
    private TextView dQV;
    private TextView dRM;
    private TextView dRN;
    private SpannableString dRO;
    private SpannableString dRP;
    private View mLine;
    private TextView mTitle;

    public k(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.coQ = tbPageContext;
        this.czK = (HeadImageView) view.findViewById(d.g.photo);
        this.aoE = (TextView) view.findViewById(d.g.user_name);
        this.cpA = (TextView) view.findViewById(d.g.time);
        this.dRM = (TextView) view.findViewById(d.g.add_friend_button);
        this.mLine = view.findViewById(d.g.line);
        this.dQV = (TextView) view.findViewById(d.g.content);
        this.mTitle = (TextView) view.findViewById(d.g.replyme_title);
        this.dQT = view.findViewById(d.g.divider_between_time_and_fans_reply);
        this.dQU = (TextView) view.findViewById(d.g.fans_reply);
        this.bRG = (TextView) view.findViewById(d.g.forum);
        this.dRN = (TextView) view.findViewById(d.g.tv_quick_reply_text);
        this.czK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                k.this.Fw().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9483, k.this.getData(), null, null));
            }
        });
        this.dRM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.k.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                k.this.Fw().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9485, k.this.getData(), null, null));
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
                k.this.Fw().dispatchMvcEvent(bVar);
            }
        });
        this.dRN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.k.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(9486, k.this.getData(), null, null);
                bVar.setView(k.this.getRootView());
                bVar.fl(k.this.position);
                k.this.Fw().dispatchMvcEvent(bVar);
                TiebaStatic.log("c10096");
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void D(FeedData feedData) {
        super.D(feedData);
        if (FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType())) {
            e(feedData);
        } else if (FeedData.TYPE_DECLARE.equals(feedData.getPraiseItemType())) {
            f(feedData);
        } else {
            this.dRN.setVisibility(0);
            this.dRN.setTag(Integer.valueOf(this.position));
            if (feedData.getReplyer() != null) {
                this.aoE.setText(feedData.getReplyer().getName_show());
                if (feedData.getReplyer().isBigV()) {
                    aj.i(this.aoE, d.C0080d.cp_cont_r);
                } else {
                    aj.i(this.aoE, d.C0080d.cp_cont_c);
                }
                if (feedData.getReplyer().getIsMyFriend() == 1) {
                    this.dRM.setVisibility(0);
                    this.dRM.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                    this.dRM.setTextColor(aj.getColor(d.C0080d.cp_cont_i));
                    this.dRM.setBackgroundDrawable(aj.getDrawable(d.f.game_center_start_btn));
                    this.dRM.setText(getString(d.j.chat));
                } else {
                    this.dRM.setVisibility(0);
                    this.dRM.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                    this.dRM.setTextColor(aj.getColor(d.C0080d.cp_cont_i));
                    this.dRM.setBackgroundDrawable(aj.getDrawable(d.f.game_center_start_btn));
                    this.dRM.setText(getString(d.j.chat));
                }
                this.cpA.setText(am.r(feedData.getTime()));
                if (feedData.getReplyer().getIsMyFans() == 1) {
                    this.dQT.setVisibility(0);
                    this.dQU.setVisibility(0);
                } else {
                    this.dQT.setVisibility(8);
                    this.dQU.setVisibility(8);
                }
                this.dRO = TbFaceManager.Ef().a(this.coQ.getPageActivity().getApplicationContext(), feedData.getContent(), null);
                this.dQV.setText(a(this.dQV, this.dRO));
                if (feedData.getThread_Type() == 33) {
                    this.mTitle.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
                } else {
                    this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (feedData.getType() == 1) {
                    if (feedData.isStory()) {
                        this.dRP = TbFaceManager.Ef().a(this.coQ.getPageActivity().getApplicationContext(), this.coQ.getPageActivity().getString(d.j.story_replyme_floor_original, new Object[]{feedData.getQuote_content()}), null);
                    } else {
                        this.dRP = TbFaceManager.Ef().a(this.coQ.getPageActivity().getApplicationContext(), this.coQ.getPageActivity().getString(d.j.mention_replyme_original, new Object[]{feedData.getQuote_content()}), null);
                    }
                    this.mTitle.setText(a(this.mTitle, this.dRP));
                } else if (feedData.isStory()) {
                    this.mTitle.setText(this.coQ.getPageActivity().getString(d.j.story_replyme_original, new Object[]{feedData.getTitle()}));
                } else {
                    this.mTitle.setText(this.coQ.getPageActivity().getString(d.j.mention_replyme_original, new Object[]{feedData.getTitle()}));
                }
                if (!feedData.isHideForumName() && feedData.getFname() != null && feedData.getFname().length() > 0) {
                    this.bRG.setVisibility(0);
                    this.bRG.setText(am.j(feedData.getFname(), 12).concat(getString(d.j.forum)));
                } else {
                    this.bRG.setVisibility(8);
                }
                this.czK.setVisibility(0);
                this.czK.setIsRound(true);
                this.czK.setShowV(feedData.getReplyer().isBigV());
                String portrait = feedData.getReplyer().getPortrait();
                this.czK.setTag(null);
                this.czK.startLoad(portrait, 12, false);
            }
        }
        if (Fw() != null) {
            Fw().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9488, feedData, null, null));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.m
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        aj.j(getRootView(), d.f.list_selector);
        aj.k(this.mLine, d.C0080d.cp_bg_line_b);
        this.dQV.setTextColor(aj.getColor(d.C0080d.cp_cont_b));
        this.cpA.setTextColor(aj.getColor(d.C0080d.cp_cont_d));
        aj.k(this.dQT, d.C0080d.cp_cont_d);
        aj.i(this.dQU, d.C0080d.cp_cont_d);
        this.bRG.setTextColor(aj.getColor(d.C0080d.cp_cont_d));
        this.mTitle.setTextColor(aj.getColor(d.C0080d.cp_cont_c));
        aj.c(this.dRN, d.C0080d.cp_cont_c, 1);
        this.dRN.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_reply_n), (Drawable) null, (Drawable) null, (Drawable) null);
        aj.j(this.mTitle, d.f.bg_ta_dialog_content);
        return true;
    }

    private CharSequence a(TextView textView, SpannableString spannableString) {
        if (textView == null || spannableString == null || this.coQ == null) {
            return null;
        }
        return TextUtils.ellipsize(spannableString, textView.getPaint(), (com.baidu.adp.lib.util.l.ac(this.coQ.getPageActivity()) - (this.coQ.getResources().getDimensionPixelSize(d.e.ds30) * 2)) - textView.getCompoundPaddingLeft(), TextUtils.TruncateAt.END);
    }

    private void e(FeedData feedData) {
        LikeData likeData;
        if (FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType())) {
            this.dRN.setVisibility(8);
            List<LikeData> praiseList = feedData.getPraiseList();
            if (praiseList != null && praiseList.size() > 0 && (likeData = praiseList.get(0)) != null) {
                this.aoE.setText(likeData.getNameShow());
                this.czK.setShowV(likeData.isBigV());
                if (likeData.isBigV()) {
                    aj.i(this.aoE, d.C0080d.cp_cont_r);
                } else {
                    aj.i(this.aoE, d.C0080d.cp_cont_c);
                }
                this.dRM.setVisibility(8);
                this.cpA.setText(am.r(feedData.getTime()));
                if (praiseList.size() > 3 && praiseList.get(1) != null && praiseList.get(2) != null) {
                    this.dQV.setText(String.format(getString(d.j.message_praise_like_list_more), likeData.getNameShow(), praiseList.get(1).getNameShow(), praiseList.get(2).getNameShow(), String.valueOf(feedData.getPraiseNum())));
                } else if (praiseList.size() > 2 && praiseList.get(1) != null && praiseList.get(2) != null) {
                    this.dQV.setText(String.format(getString(d.j.message_praise_like_list_3), likeData.getNameShow(), praiseList.get(1).getNameShow(), praiseList.get(2).getNameShow()));
                } else if (praiseList.size() > 1 && praiseList.get(1) != null) {
                    this.dQV.setText(String.format(getString(d.j.message_praise_like_list_2), likeData.getNameShow(), praiseList.get(1).getNameShow()));
                } else {
                    this.dQV.setText(String.format(getString(d.j.message_praise_like_list_1), likeData.getNameShow()));
                }
                if (feedData.isStory()) {
                    this.mTitle.setText(this.coQ.getPageActivity().getString(d.j.story_replyme_original, new Object[]{feedData.getTitle()}));
                } else {
                    this.mTitle.setText(this.coQ.getPageActivity().getString(d.j.mention_replyme_original, new Object[]{feedData.getTitle()}));
                }
                if (feedData.getThread_Type() == 33) {
                    this.mTitle.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
                } else {
                    this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (!feedData.isHideForumName() && feedData.getFname() != null && feedData.getFname().length() > 0) {
                    this.bRG.setVisibility(0);
                    this.bRG.setText(am.j(feedData.getFname(), 12).concat(getString(d.j.forum)));
                } else {
                    this.bRG.setVisibility(8);
                }
                this.czK.setVisibility(0);
                this.czK.setIsRound(true);
                this.czK.startLoad(likeData.getPortrait(), 12, false);
            }
        }
    }

    private void f(FeedData feedData) {
        LikeData likeData;
        this.dRN.setVisibility(8);
        List<LikeData> praiseList = feedData.getPraiseList();
        if (praiseList != null && praiseList.size() > 0 && (likeData = praiseList.get(0)) != null) {
            this.aoE.setText(likeData.getNameShow());
            this.czK.setShowV(likeData.isBigV());
            if (likeData.isBigV()) {
                aj.i(this.aoE, d.C0080d.cp_cont_r);
            } else {
                aj.i(this.aoE, d.C0080d.cp_cont_c);
            }
            this.dRM.setVisibility(8);
            this.cpA.setText(am.r(feedData.getTime()));
            if (praiseList.size() > 2 && praiseList.get(1) != null) {
                this.dQV.setText(String.format(getString(d.j.message_declare_list_more), likeData.getNameShow(), praiseList.get(1).getNameShow(), String.valueOf(feedData.getPraiseNum())));
            } else if (praiseList.size() == 2 && praiseList.get(1) != null) {
                this.dQV.setText(String.format(getString(d.j.message_declare_list_2), likeData.getNameShow(), praiseList.get(1).getNameShow()));
            } else {
                this.dQV.setText(String.format(getString(d.j.message_declare_list_1), likeData.getNameShow()));
            }
            if (feedData.isStory()) {
                this.mTitle.setText(this.coQ.getPageActivity().getString(d.j.story_replyme_original, new Object[]{feedData.getTitle()}));
            } else {
                this.mTitle.setText(this.coQ.getPageActivity().getString(d.j.mention_replyme_original, new Object[]{feedData.getTitle()}));
            }
            if (feedData.getThread_Type() == 33) {
                this.mTitle.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            if (!feedData.isHideForumName() && feedData.getFname() != null && feedData.getFname().length() > 0) {
                this.bRG.setVisibility(0);
                this.bRG.setText(am.j(feedData.getFname(), 12).concat(getString(d.j.forum)));
            } else {
                this.bRG.setVisibility(8);
            }
            this.czK.setVisibility(0);
            this.czK.startLoad(likeData.getPortrait(), 12, false);
        }
    }
}
