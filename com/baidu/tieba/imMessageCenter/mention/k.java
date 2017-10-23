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
    private TextView aoi;
    private TextView bKa;
    private TbPageContext<?> chv;
    private TextView cif;
    private HeadImageView csn;
    private View dJg;
    private TextView dJh;
    private TextView dJi;
    private TextView dKa;
    private TextView dKb;
    private SpannableString dKc;
    private SpannableString dKd;
    private View mLine;
    private TextView mTitle;

    public k(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.chv = tbPageContext;
        this.csn = (HeadImageView) view.findViewById(d.h.photo);
        this.aoi = (TextView) view.findViewById(d.h.user_name);
        this.cif = (TextView) view.findViewById(d.h.time);
        this.dKa = (TextView) view.findViewById(d.h.add_friend_button);
        this.mLine = view.findViewById(d.h.line);
        this.dJi = (TextView) view.findViewById(d.h.content);
        this.mTitle = (TextView) view.findViewById(d.h.replyme_title);
        this.dJg = view.findViewById(d.h.divider_between_time_and_fans_reply);
        this.dJh = (TextView) view.findViewById(d.h.fans_reply);
        this.bKa = (TextView) view.findViewById(d.h.forum);
        this.dKb = (TextView) view.findViewById(d.h.tv_quick_reply_text);
        this.csn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                k.this.Fk().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9483, k.this.getData(), null, null));
            }
        });
        this.dKa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.k.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                k.this.Fk().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9485, k.this.getData(), null, null));
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
                k.this.Fk().dispatchMvcEvent(bVar);
            }
        });
        this.dKb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.k.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(9486, k.this.getData(), null, null);
                bVar.setView(k.this.getRootView());
                bVar.fk(k.this.position);
                k.this.Fk().dispatchMvcEvent(bVar);
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
            this.dKb.setVisibility(0);
            this.dKb.setTag(Integer.valueOf(this.position));
            if (feedData.getReplyer() != null) {
                this.aoi.setText(feedData.getReplyer().getName_show());
                if (feedData.getReplyer().isBigV()) {
                    aj.i(this.aoi, d.e.cp_cont_r);
                } else {
                    aj.i(this.aoi, d.e.cp_cont_c);
                }
                if (feedData.getReplyer().getIsMyFriend() == 1) {
                    this.dKa.setVisibility(0);
                    this.dKa.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                    this.dKa.setTextColor(aj.getColor(d.e.cp_cont_i));
                    this.dKa.setBackgroundDrawable(aj.getDrawable(d.g.game_center_start_btn));
                    this.dKa.setText(getString(d.l.chat));
                } else {
                    this.dKa.setVisibility(0);
                    this.dKa.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                    this.dKa.setTextColor(aj.getColor(d.e.cp_cont_i));
                    this.dKa.setBackgroundDrawable(aj.getDrawable(d.g.game_center_start_btn));
                    this.dKa.setText(getString(d.l.chat));
                }
                this.cif.setText(am.r(feedData.getTime()));
                if (feedData.getReplyer().getIsMyFans() == 1) {
                    this.dJg.setVisibility(0);
                    this.dJh.setVisibility(0);
                } else {
                    this.dJg.setVisibility(8);
                    this.dJh.setVisibility(8);
                }
                this.dKc = TbFaceManager.DS().a(this.chv.getPageActivity().getApplicationContext(), feedData.getContent(), null);
                this.dJi.setText(a(this.dJi, this.dKc));
                if (feedData.getThread_Type() == 33) {
                    this.mTitle.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.g.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
                } else {
                    this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (feedData.getType() == 1) {
                    if (feedData.isStory()) {
                        this.dKd = TbFaceManager.DS().a(this.chv.getPageActivity().getApplicationContext(), this.chv.getPageActivity().getString(d.l.story_replyme_floor_original, new Object[]{feedData.getQuote_content()}), null);
                    } else {
                        this.dKd = TbFaceManager.DS().a(this.chv.getPageActivity().getApplicationContext(), this.chv.getPageActivity().getString(d.l.mention_replyme_original, new Object[]{feedData.getQuote_content()}), null);
                    }
                    this.mTitle.setText(a(this.mTitle, this.dKd));
                } else if (feedData.isStory()) {
                    this.mTitle.setText(this.chv.getPageActivity().getString(d.l.story_replyme_original, new Object[]{feedData.getTitle()}));
                } else {
                    this.mTitle.setText(this.chv.getPageActivity().getString(d.l.mention_replyme_original, new Object[]{feedData.getTitle()}));
                }
                if (!feedData.isHideForumName() && feedData.getFname() != null && feedData.getFname().length() > 0) {
                    this.bKa.setVisibility(0);
                    this.bKa.setText(am.j(feedData.getFname(), 12).concat(getString(d.l.forum)));
                } else {
                    this.bKa.setVisibility(8);
                }
                this.csn.setVisibility(0);
                this.csn.setIsRound(true);
                this.csn.setShowV(feedData.getReplyer().isBigV());
                String portrait = feedData.getReplyer().getPortrait();
                this.csn.setTag(null);
                this.csn.c(portrait, 12, false);
            }
        }
        if (Fk() != null) {
            Fk().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9488, feedData, null, null));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.l
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        aj.j(getRootView(), d.g.list_selector);
        aj.k(this.mLine, d.e.cp_bg_line_b);
        this.dJi.setTextColor(aj.getColor(d.e.cp_cont_b));
        this.cif.setTextColor(aj.getColor(d.e.cp_cont_d));
        aj.k(this.dJg, d.e.cp_cont_d);
        aj.i(this.dJh, d.e.cp_cont_d);
        this.bKa.setTextColor(aj.getColor(d.e.cp_cont_d));
        this.mTitle.setTextColor(aj.getColor(d.e.cp_cont_c));
        aj.c(this.dKb, d.e.cp_cont_c, 1);
        this.dKb.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.g.icon_reply_n), (Drawable) null, (Drawable) null, (Drawable) null);
        aj.j(this.mTitle, d.g.bg_ta_dialog_content);
        return true;
    }

    private CharSequence a(TextView textView, SpannableString spannableString) {
        if (textView == null || spannableString == null || this.chv == null) {
            return null;
        }
        return TextUtils.ellipsize(spannableString, textView.getPaint(), (com.baidu.adp.lib.util.l.ad(this.chv.getPageActivity()) - (this.chv.getResources().getDimensionPixelSize(d.f.ds30) * 2)) - textView.getCompoundPaddingLeft(), TextUtils.TruncateAt.END);
    }

    private void e(FeedData feedData) {
        LikeData likeData;
        if (FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType())) {
            this.dKb.setVisibility(8);
            List<LikeData> praiseList = feedData.getPraiseList();
            if (praiseList != null && praiseList.size() > 0 && (likeData = praiseList.get(0)) != null) {
                this.aoi.setText(likeData.getNameShow());
                this.csn.setShowV(likeData.isBigV());
                if (likeData.isBigV()) {
                    aj.i(this.aoi, d.e.cp_cont_r);
                } else {
                    aj.i(this.aoi, d.e.cp_cont_c);
                }
                this.dKa.setVisibility(8);
                this.cif.setText(am.r(feedData.getTime()));
                if (praiseList.size() > 3 && praiseList.get(1) != null && praiseList.get(2) != null) {
                    this.dJi.setText(String.format(getString(d.l.message_praise_like_list_more), likeData.getNameShow(), praiseList.get(1).getNameShow(), praiseList.get(2).getNameShow(), String.valueOf(feedData.getPraiseNum())));
                } else if (praiseList.size() > 2 && praiseList.get(1) != null && praiseList.get(2) != null) {
                    this.dJi.setText(String.format(getString(d.l.message_praise_like_list_3), likeData.getNameShow(), praiseList.get(1).getNameShow(), praiseList.get(2).getNameShow()));
                } else if (praiseList.size() > 1 && praiseList.get(1) != null) {
                    this.dJi.setText(String.format(getString(d.l.message_praise_like_list_2), likeData.getNameShow(), praiseList.get(1).getNameShow()));
                } else {
                    this.dJi.setText(String.format(getString(d.l.message_praise_like_list_1), likeData.getNameShow()));
                }
                if (feedData.isStory()) {
                    this.mTitle.setText(this.chv.getPageActivity().getString(d.l.story_replyme_original, new Object[]{feedData.getTitle()}));
                } else {
                    this.mTitle.setText(this.chv.getPageActivity().getString(d.l.mention_replyme_original, new Object[]{feedData.getTitle()}));
                }
                if (feedData.getThread_Type() == 33) {
                    this.mTitle.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.g.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
                } else {
                    this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (!feedData.isHideForumName() && feedData.getFname() != null && feedData.getFname().length() > 0) {
                    this.bKa.setVisibility(0);
                    this.bKa.setText(am.j(feedData.getFname(), 12).concat(getString(d.l.forum)));
                } else {
                    this.bKa.setVisibility(8);
                }
                this.csn.setVisibility(0);
                this.csn.setIsRound(true);
                this.csn.c(likeData.getPortrait(), 12, false);
            }
        }
    }

    private void f(FeedData feedData) {
        LikeData likeData;
        this.dKb.setVisibility(8);
        List<LikeData> praiseList = feedData.getPraiseList();
        if (praiseList != null && praiseList.size() > 0 && (likeData = praiseList.get(0)) != null) {
            this.aoi.setText(likeData.getNameShow());
            this.csn.setShowV(likeData.isBigV());
            if (likeData.isBigV()) {
                aj.i(this.aoi, d.e.cp_cont_r);
            } else {
                aj.i(this.aoi, d.e.cp_cont_c);
            }
            this.dKa.setVisibility(8);
            this.cif.setText(am.r(feedData.getTime()));
            if (praiseList.size() > 2 && praiseList.get(1) != null) {
                this.dJi.setText(String.format(getString(d.l.message_declare_list_more), likeData.getNameShow(), praiseList.get(1).getNameShow(), String.valueOf(feedData.getPraiseNum())));
            } else if (praiseList.size() == 2 && praiseList.get(1) != null) {
                this.dJi.setText(String.format(getString(d.l.message_declare_list_2), likeData.getNameShow(), praiseList.get(1).getNameShow()));
            } else {
                this.dJi.setText(String.format(getString(d.l.message_declare_list_1), likeData.getNameShow()));
            }
            if (feedData.isStory()) {
                this.mTitle.setText(this.chv.getPageActivity().getString(d.l.story_replyme_original, new Object[]{feedData.getTitle()}));
            } else {
                this.mTitle.setText(this.chv.getPageActivity().getString(d.l.mention_replyme_original, new Object[]{feedData.getTitle()}));
            }
            if (feedData.getThread_Type() == 33) {
                this.mTitle.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.g.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            if (!feedData.isHideForumName() && feedData.getFname() != null && feedData.getFname().length() > 0) {
                this.bKa.setVisibility(0);
                this.bKa.setText(am.j(feedData.getFname(), 12).concat(getString(d.l.forum)));
            } else {
                this.bKa.setVisibility(8);
            }
            this.csn.setVisibility(0);
            this.csn.c(likeData.getPortrait(), 12, false);
        }
    }
}
