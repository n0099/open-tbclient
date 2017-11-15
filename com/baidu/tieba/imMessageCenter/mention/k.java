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
    private TextView aoD;
    private TextView bRT;
    private HeadImageView cAd;
    private TextView cpT;
    private TbPageContext<?> cpj;
    private View dQY;
    private TextView dQZ;
    private TextView dRQ;
    private TextView dRR;
    private SpannableString dRS;
    private SpannableString dRT;
    private TextView dRa;
    private View mLine;
    private TextView mTitle;

    public k(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.cpj = tbPageContext;
        this.cAd = (HeadImageView) view.findViewById(d.g.photo);
        this.aoD = (TextView) view.findViewById(d.g.user_name);
        this.cpT = (TextView) view.findViewById(d.g.time);
        this.dRQ = (TextView) view.findViewById(d.g.add_friend_button);
        this.mLine = view.findViewById(d.g.line);
        this.dRa = (TextView) view.findViewById(d.g.content);
        this.mTitle = (TextView) view.findViewById(d.g.replyme_title);
        this.dQY = view.findViewById(d.g.divider_between_time_and_fans_reply);
        this.dQZ = (TextView) view.findViewById(d.g.fans_reply);
        this.bRT = (TextView) view.findViewById(d.g.forum);
        this.dRR = (TextView) view.findViewById(d.g.tv_quick_reply_text);
        this.cAd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                k.this.FI().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9483, k.this.getData(), null, null));
            }
        });
        this.dRQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.k.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                k.this.FI().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9485, k.this.getData(), null, null));
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
                k.this.FI().dispatchMvcEvent(bVar);
            }
        });
        this.dRR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.k.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(9486, k.this.getData(), null, null);
                bVar.setView(k.this.getRootView());
                bVar.fk(k.this.position);
                k.this.FI().dispatchMvcEvent(bVar);
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
            this.dRR.setVisibility(0);
            this.dRR.setTag(Integer.valueOf(this.position));
            if (feedData.getReplyer() != null) {
                this.aoD.setText(feedData.getReplyer().getName_show());
                if (feedData.getReplyer().isBigV()) {
                    aj.i(this.aoD, d.C0080d.cp_cont_r);
                } else {
                    aj.i(this.aoD, d.C0080d.cp_cont_c);
                }
                if (feedData.getReplyer().getIsMyFriend() == 1) {
                    this.dRQ.setVisibility(0);
                    this.dRQ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                    this.dRQ.setTextColor(aj.getColor(d.C0080d.cp_cont_i));
                    this.dRQ.setBackgroundDrawable(aj.getDrawable(d.f.game_center_start_btn));
                    this.dRQ.setText(getString(d.j.chat));
                } else {
                    this.dRQ.setVisibility(0);
                    this.dRQ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                    this.dRQ.setTextColor(aj.getColor(d.C0080d.cp_cont_i));
                    this.dRQ.setBackgroundDrawable(aj.getDrawable(d.f.game_center_start_btn));
                    this.dRQ.setText(getString(d.j.chat));
                }
                this.cpT.setText(am.r(feedData.getTime()));
                if (feedData.getReplyer().getIsMyFans() == 1) {
                    this.dQY.setVisibility(0);
                    this.dQZ.setVisibility(0);
                } else {
                    this.dQY.setVisibility(8);
                    this.dQZ.setVisibility(8);
                }
                this.dRS = TbFaceManager.Er().a(this.cpj.getPageActivity().getApplicationContext(), feedData.getContent(), null);
                this.dRa.setText(a(this.dRa, this.dRS));
                if (feedData.getThread_Type() == 33) {
                    this.mTitle.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
                } else {
                    this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (feedData.getType() == 1) {
                    if (feedData.isStory()) {
                        this.dRT = TbFaceManager.Er().a(this.cpj.getPageActivity().getApplicationContext(), this.cpj.getPageActivity().getString(d.j.story_replyme_floor_original, new Object[]{feedData.getQuote_content()}), null);
                    } else {
                        this.dRT = TbFaceManager.Er().a(this.cpj.getPageActivity().getApplicationContext(), this.cpj.getPageActivity().getString(d.j.mention_replyme_original, new Object[]{feedData.getQuote_content()}), null);
                    }
                    this.mTitle.setText(a(this.mTitle, this.dRT));
                } else if (feedData.isStory()) {
                    this.mTitle.setText(this.cpj.getPageActivity().getString(d.j.story_replyme_original, new Object[]{feedData.getTitle()}));
                } else {
                    this.mTitle.setText(this.cpj.getPageActivity().getString(d.j.mention_replyme_original, new Object[]{feedData.getTitle()}));
                }
                if (!feedData.isHideForumName() && feedData.getFname() != null && feedData.getFname().length() > 0) {
                    this.bRT.setVisibility(0);
                    this.bRT.setText(am.j(feedData.getFname(), 12).concat(getString(d.j.forum)));
                } else {
                    this.bRT.setVisibility(8);
                }
                this.cAd.setVisibility(0);
                this.cAd.setIsRound(true);
                this.cAd.setShowV(feedData.getReplyer().isBigV());
                String portrait = feedData.getReplyer().getPortrait();
                this.cAd.setTag(null);
                this.cAd.startLoad(portrait, 12, false);
            }
        }
        if (FI() != null) {
            FI().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9488, feedData, null, null));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.m
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        aj.j(getRootView(), d.f.list_selector);
        aj.k(this.mLine, d.C0080d.cp_bg_line_b);
        this.dRa.setTextColor(aj.getColor(d.C0080d.cp_cont_b));
        this.cpT.setTextColor(aj.getColor(d.C0080d.cp_cont_d));
        aj.k(this.dQY, d.C0080d.cp_cont_d);
        aj.i(this.dQZ, d.C0080d.cp_cont_d);
        this.bRT.setTextColor(aj.getColor(d.C0080d.cp_cont_d));
        this.mTitle.setTextColor(aj.getColor(d.C0080d.cp_cont_c));
        aj.c(this.dRR, d.C0080d.cp_cont_c, 1);
        this.dRR.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_reply_n), (Drawable) null, (Drawable) null, (Drawable) null);
        aj.j(this.mTitle, d.f.bg_ta_dialog_content);
        return true;
    }

    private CharSequence a(TextView textView, SpannableString spannableString) {
        if (textView == null || spannableString == null || this.cpj == null) {
            return null;
        }
        return TextUtils.ellipsize(spannableString, textView.getPaint(), (com.baidu.adp.lib.util.l.ac(this.cpj.getPageActivity()) - (this.cpj.getResources().getDimensionPixelSize(d.e.ds30) * 2)) - textView.getCompoundPaddingLeft(), TextUtils.TruncateAt.END);
    }

    private void e(FeedData feedData) {
        LikeData likeData;
        if (FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType())) {
            this.dRR.setVisibility(8);
            List<LikeData> praiseList = feedData.getPraiseList();
            if (praiseList != null && praiseList.size() > 0 && (likeData = praiseList.get(0)) != null) {
                this.aoD.setText(likeData.getNameShow());
                this.cAd.setShowV(likeData.isBigV());
                if (likeData.isBigV()) {
                    aj.i(this.aoD, d.C0080d.cp_cont_r);
                } else {
                    aj.i(this.aoD, d.C0080d.cp_cont_c);
                }
                this.dRQ.setVisibility(8);
                this.cpT.setText(am.r(feedData.getTime()));
                if (praiseList.size() > 3 && praiseList.get(1) != null && praiseList.get(2) != null) {
                    this.dRa.setText(String.format(getString(d.j.message_praise_like_list_more), likeData.getNameShow(), praiseList.get(1).getNameShow(), praiseList.get(2).getNameShow(), String.valueOf(feedData.getPraiseNum())));
                } else if (praiseList.size() > 2 && praiseList.get(1) != null && praiseList.get(2) != null) {
                    this.dRa.setText(String.format(getString(d.j.message_praise_like_list_3), likeData.getNameShow(), praiseList.get(1).getNameShow(), praiseList.get(2).getNameShow()));
                } else if (praiseList.size() > 1 && praiseList.get(1) != null) {
                    this.dRa.setText(String.format(getString(d.j.message_praise_like_list_2), likeData.getNameShow(), praiseList.get(1).getNameShow()));
                } else {
                    this.dRa.setText(String.format(getString(d.j.message_praise_like_list_1), likeData.getNameShow()));
                }
                if (feedData.isStory()) {
                    this.mTitle.setText(this.cpj.getPageActivity().getString(d.j.story_replyme_original, new Object[]{feedData.getTitle()}));
                } else {
                    this.mTitle.setText(this.cpj.getPageActivity().getString(d.j.mention_replyme_original, new Object[]{feedData.getTitle()}));
                }
                if (feedData.getThread_Type() == 33) {
                    this.mTitle.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
                } else {
                    this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (!feedData.isHideForumName() && feedData.getFname() != null && feedData.getFname().length() > 0) {
                    this.bRT.setVisibility(0);
                    this.bRT.setText(am.j(feedData.getFname(), 12).concat(getString(d.j.forum)));
                } else {
                    this.bRT.setVisibility(8);
                }
                this.cAd.setVisibility(0);
                this.cAd.setIsRound(true);
                this.cAd.startLoad(likeData.getPortrait(), 12, false);
            }
        }
    }

    private void f(FeedData feedData) {
        LikeData likeData;
        this.dRR.setVisibility(8);
        List<LikeData> praiseList = feedData.getPraiseList();
        if (praiseList != null && praiseList.size() > 0 && (likeData = praiseList.get(0)) != null) {
            this.aoD.setText(likeData.getNameShow());
            this.cAd.setShowV(likeData.isBigV());
            if (likeData.isBigV()) {
                aj.i(this.aoD, d.C0080d.cp_cont_r);
            } else {
                aj.i(this.aoD, d.C0080d.cp_cont_c);
            }
            this.dRQ.setVisibility(8);
            this.cpT.setText(am.r(feedData.getTime()));
            if (praiseList.size() > 2 && praiseList.get(1) != null) {
                this.dRa.setText(String.format(getString(d.j.message_declare_list_more), likeData.getNameShow(), praiseList.get(1).getNameShow(), String.valueOf(feedData.getPraiseNum())));
            } else if (praiseList.size() == 2 && praiseList.get(1) != null) {
                this.dRa.setText(String.format(getString(d.j.message_declare_list_2), likeData.getNameShow(), praiseList.get(1).getNameShow()));
            } else {
                this.dRa.setText(String.format(getString(d.j.message_declare_list_1), likeData.getNameShow()));
            }
            if (feedData.isStory()) {
                this.mTitle.setText(this.cpj.getPageActivity().getString(d.j.story_replyme_original, new Object[]{feedData.getTitle()}));
            } else {
                this.mTitle.setText(this.cpj.getPageActivity().getString(d.j.mention_replyme_original, new Object[]{feedData.getTitle()}));
            }
            if (feedData.getThread_Type() == 33) {
                this.mTitle.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            if (!feedData.isHideForumName() && feedData.getFname() != null && feedData.getFname().length() > 0) {
                this.bRT.setVisibility(0);
                this.bRT.setText(am.j(feedData.getFname(), 12).concat(getString(d.j.forum)));
            } else {
                this.bRT.setVisibility(8);
            }
            this.cAd.setVisibility(0);
            this.cAd.startLoad(likeData.getPortrait(), 12, false);
        }
    }
}
