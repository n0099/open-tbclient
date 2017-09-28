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
    private View aYL;
    private TextView aou;
    private TextView bKm;
    private TbPageContext<?> chH;
    private TextView cir;
    private HeadImageView csz;
    private View dJu;
    private TextView dJv;
    private TextView dJw;
    private TextView dKo;
    private TextView dKp;
    private SpannableString dKq;
    private SpannableString dKr;
    private TextView mTitle;

    public k(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.chH = tbPageContext;
        this.csz = (HeadImageView) view.findViewById(d.h.photo);
        this.aou = (TextView) view.findViewById(d.h.user_name);
        this.cir = (TextView) view.findViewById(d.h.time);
        this.dKo = (TextView) view.findViewById(d.h.add_friend_button);
        this.aYL = view.findViewById(d.h.line);
        this.dJw = (TextView) view.findViewById(d.h.content);
        this.mTitle = (TextView) view.findViewById(d.h.replyme_title);
        this.dJu = view.findViewById(d.h.divider_between_time_and_fans_reply);
        this.dJv = (TextView) view.findViewById(d.h.fans_reply);
        this.bKm = (TextView) view.findViewById(d.h.forum);
        this.dKp = (TextView) view.findViewById(d.h.tv_quick_reply_text);
        this.csz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                k.this.Fq().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9483, k.this.getData(), null, null));
            }
        });
        this.dKo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.k.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                k.this.Fq().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9485, k.this.getData(), null, null));
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
                k.this.Fq().dispatchMvcEvent(bVar);
            }
        });
        this.dKp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.k.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(9486, k.this.getData(), null, null);
                bVar.setView(k.this.getRootView());
                bVar.fl(k.this.position);
                k.this.Fq().dispatchMvcEvent(bVar);
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
            this.dKp.setVisibility(0);
            this.dKp.setTag(Integer.valueOf(this.position));
            if (feedData.getReplyer() != null) {
                this.aou.setText(feedData.getReplyer().getName_show());
                if (feedData.getReplyer().isBigV()) {
                    aj.i(this.aou, d.e.cp_cont_r);
                } else {
                    aj.i(this.aou, d.e.cp_cont_c);
                }
                if (feedData.getReplyer().getIsMyFriend() == 1) {
                    this.dKo.setVisibility(0);
                    this.dKo.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                    this.dKo.setTextColor(aj.getColor(d.e.cp_cont_i));
                    this.dKo.setBackgroundDrawable(aj.getDrawable(d.g.game_center_start_btn));
                    this.dKo.setText(getString(d.l.chat));
                } else {
                    this.dKo.setVisibility(0);
                    this.dKo.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                    this.dKo.setTextColor(aj.getColor(d.e.cp_cont_i));
                    this.dKo.setBackgroundDrawable(aj.getDrawable(d.g.game_center_start_btn));
                    this.dKo.setText(getString(d.l.chat));
                }
                this.cir.setText(am.q(feedData.getTime()));
                if (feedData.getReplyer().getIsMyFans() == 1) {
                    this.dJu.setVisibility(0);
                    this.dJv.setVisibility(0);
                } else {
                    this.dJu.setVisibility(8);
                    this.dJv.setVisibility(8);
                }
                this.dKq = TbFaceManager.DY().a(this.chH.getPageActivity().getApplicationContext(), feedData.getContent(), null);
                this.dJw.setText(a(this.dJw, this.dKq));
                if (feedData.getThread_Type() == 33) {
                    this.mTitle.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.g.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
                } else {
                    this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (feedData.getType() == 1) {
                    if (feedData.isStory()) {
                        this.dKr = TbFaceManager.DY().a(this.chH.getPageActivity().getApplicationContext(), this.chH.getPageActivity().getString(d.l.story_replyme_floor_original, new Object[]{feedData.getQuote_content()}), null);
                    } else {
                        this.dKr = TbFaceManager.DY().a(this.chH.getPageActivity().getApplicationContext(), this.chH.getPageActivity().getString(d.l.mention_replyme_original, new Object[]{feedData.getQuote_content()}), null);
                    }
                    this.mTitle.setText(a(this.mTitle, this.dKr));
                } else if (feedData.isStory()) {
                    this.mTitle.setText(this.chH.getPageActivity().getString(d.l.story_replyme_original, new Object[]{feedData.getTitle()}));
                } else {
                    this.mTitle.setText(this.chH.getPageActivity().getString(d.l.mention_replyme_original, new Object[]{feedData.getTitle()}));
                }
                if (!feedData.isHideForumName() && feedData.getFname() != null && feedData.getFname().length() > 0) {
                    this.bKm.setVisibility(0);
                    this.bKm.setText(am.j(feedData.getFname(), 12).concat(getString(d.l.forum)));
                } else {
                    this.bKm.setVisibility(8);
                }
                this.csz.setVisibility(0);
                this.csz.setIsRound(true);
                this.csz.setShowV(feedData.getReplyer().isBigV());
                String portrait = feedData.getReplyer().getPortrait();
                this.csz.setTag(null);
                this.csz.c(portrait, 12, false);
            }
        }
        if (Fq() != null) {
            Fq().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9488, feedData, null, null));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.l
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        aj.j(getRootView(), d.g.list_selector);
        aj.k(this.aYL, d.e.cp_bg_line_b);
        this.dJw.setTextColor(aj.getColor(d.e.cp_cont_b));
        this.cir.setTextColor(aj.getColor(d.e.cp_cont_d));
        aj.k(this.dJu, d.e.cp_cont_d);
        aj.i(this.dJv, d.e.cp_cont_d);
        this.bKm.setTextColor(aj.getColor(d.e.cp_cont_d));
        this.mTitle.setTextColor(aj.getColor(d.e.cp_cont_c));
        aj.c(this.dKp, d.e.cp_cont_c, 1);
        this.dKp.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.g.icon_reply_n), (Drawable) null, (Drawable) null, (Drawable) null);
        aj.j(this.mTitle, d.g.bg_ta_dialog_content);
        return true;
    }

    private CharSequence a(TextView textView, SpannableString spannableString) {
        if (textView == null || spannableString == null || this.chH == null) {
            return null;
        }
        return TextUtils.ellipsize(spannableString, textView.getPaint(), (com.baidu.adp.lib.util.l.ad(this.chH.getPageActivity()) - (this.chH.getResources().getDimensionPixelSize(d.f.ds30) * 2)) - textView.getCompoundPaddingLeft(), TextUtils.TruncateAt.END);
    }

    private void e(FeedData feedData) {
        LikeData likeData;
        if (FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType())) {
            this.dKp.setVisibility(8);
            List<LikeData> praiseList = feedData.getPraiseList();
            if (praiseList != null && praiseList.size() > 0 && (likeData = praiseList.get(0)) != null) {
                this.aou.setText(likeData.getNameShow());
                this.csz.setShowV(likeData.isBigV());
                if (likeData.isBigV()) {
                    aj.i(this.aou, d.e.cp_cont_r);
                } else {
                    aj.i(this.aou, d.e.cp_cont_c);
                }
                this.dKo.setVisibility(8);
                this.cir.setText(am.q(feedData.getTime()));
                if (praiseList.size() > 3 && praiseList.get(1) != null && praiseList.get(2) != null) {
                    this.dJw.setText(String.format(getString(d.l.message_praise_like_list_more), likeData.getNameShow(), praiseList.get(1).getNameShow(), praiseList.get(2).getNameShow(), String.valueOf(feedData.getPraiseNum())));
                } else if (praiseList.size() > 2 && praiseList.get(1) != null && praiseList.get(2) != null) {
                    this.dJw.setText(String.format(getString(d.l.message_praise_like_list_3), likeData.getNameShow(), praiseList.get(1).getNameShow(), praiseList.get(2).getNameShow()));
                } else if (praiseList.size() > 1 && praiseList.get(1) != null) {
                    this.dJw.setText(String.format(getString(d.l.message_praise_like_list_2), likeData.getNameShow(), praiseList.get(1).getNameShow()));
                } else {
                    this.dJw.setText(String.format(getString(d.l.message_praise_like_list_1), likeData.getNameShow()));
                }
                if (feedData.isStory()) {
                    this.mTitle.setText(this.chH.getPageActivity().getString(d.l.story_replyme_original, new Object[]{feedData.getTitle()}));
                } else {
                    this.mTitle.setText(this.chH.getPageActivity().getString(d.l.mention_replyme_original, new Object[]{feedData.getTitle()}));
                }
                if (feedData.getThread_Type() == 33) {
                    this.mTitle.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.g.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
                } else {
                    this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (!feedData.isHideForumName() && feedData.getFname() != null && feedData.getFname().length() > 0) {
                    this.bKm.setVisibility(0);
                    this.bKm.setText(am.j(feedData.getFname(), 12).concat(getString(d.l.forum)));
                } else {
                    this.bKm.setVisibility(8);
                }
                this.csz.setVisibility(0);
                this.csz.setIsRound(true);
                this.csz.c(likeData.getPortrait(), 12, false);
            }
        }
    }

    private void f(FeedData feedData) {
        LikeData likeData;
        this.dKp.setVisibility(8);
        List<LikeData> praiseList = feedData.getPraiseList();
        if (praiseList != null && praiseList.size() > 0 && (likeData = praiseList.get(0)) != null) {
            this.aou.setText(likeData.getNameShow());
            this.csz.setShowV(likeData.isBigV());
            if (likeData.isBigV()) {
                aj.i(this.aou, d.e.cp_cont_r);
            } else {
                aj.i(this.aou, d.e.cp_cont_c);
            }
            this.dKo.setVisibility(8);
            this.cir.setText(am.q(feedData.getTime()));
            if (praiseList.size() > 2 && praiseList.get(1) != null) {
                this.dJw.setText(String.format(getString(d.l.message_declare_list_more), likeData.getNameShow(), praiseList.get(1).getNameShow(), String.valueOf(feedData.getPraiseNum())));
            } else if (praiseList.size() == 2 && praiseList.get(1) != null) {
                this.dJw.setText(String.format(getString(d.l.message_declare_list_2), likeData.getNameShow(), praiseList.get(1).getNameShow()));
            } else {
                this.dJw.setText(String.format(getString(d.l.message_declare_list_1), likeData.getNameShow()));
            }
            if (feedData.isStory()) {
                this.mTitle.setText(this.chH.getPageActivity().getString(d.l.story_replyme_original, new Object[]{feedData.getTitle()}));
            } else {
                this.mTitle.setText(this.chH.getPageActivity().getString(d.l.mention_replyme_original, new Object[]{feedData.getTitle()}));
            }
            if (feedData.getThread_Type() == 33) {
                this.mTitle.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.g.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            if (!feedData.isHideForumName() && feedData.getFname() != null && feedData.getFname().length() > 0) {
                this.bKm.setVisibility(0);
                this.bKm.setText(am.j(feedData.getFname(), 12).concat(getString(d.l.forum)));
            } else {
                this.bKm.setVisibility(8);
            }
            this.csz.setVisibility(0);
            this.csz.c(likeData.getPortrait(), 12, false);
        }
    }
}
