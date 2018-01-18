package com.baidu.tieba.imMessageCenter.mention;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
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
    private TextView bcO;
    private TextView bdf;
    private HeadImageView dDq;
    private TextView drP;
    private TbPageContext<?> drg;
    private TextView eNA;
    private ImageView eNz;
    private TextView eOp;
    private View eOq;
    private TextView eOr;
    private TextView eOs;
    private SpannableString eOt;
    private SpannableString eOu;
    private View mLine;
    private TextView mTitle;

    public k(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.drg = tbPageContext;
        this.dDq = (HeadImageView) view.findViewById(d.g.photo);
        this.bdf = (TextView) view.findViewById(d.g.user_name);
        this.eNz = (ImageView) view.findViewById(d.g.fans_reply);
        this.drP = (TextView) view.findViewById(d.g.time);
        this.eOp = (TextView) view.findViewById(d.g.add_friend_button);
        this.mLine = view.findViewById(d.g.line);
        this.eNA = (TextView) view.findViewById(d.g.content);
        this.mTitle = (TextView) view.findViewById(d.g.replyme_title);
        this.eOq = view.findViewById(d.g.divider_between_time_and_post_from);
        this.eOr = (TextView) view.findViewById(d.g.post_from);
        this.bcO = (TextView) view.findViewById(d.g.forum);
        this.eOs = (TextView) view.findViewById(d.g.tv_quick_reply_text);
        this.dDq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                k.this.Nd().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9483, k.this.getData(), null, null));
            }
        });
        this.eOp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.k.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                k.this.Nd().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9485, k.this.getData(), null, null));
                TiebaStatic.log("c10095");
            }
        });
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.k.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.mvc.c.b bVar;
                FeedData data = k.this.getData();
                if (data != null && FeedData.TYPE_GRAFFITI.equals(data.getPraiseItemType())) {
                    bVar = new com.baidu.tbadk.mvc.c.b(9487, data, null, null);
                } else {
                    bVar = new com.baidu.tbadk.mvc.c.b(9484, data, null, null);
                }
                k.this.Nd().dispatchMvcEvent(bVar);
            }
        });
        this.eOs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.k.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(9486, k.this.getData(), null, null);
                bVar.setView(k.this.getRootView());
                bVar.ie(k.this.position);
                k.this.Nd().dispatchMvcEvent(bVar);
                TiebaStatic.log("c10096");
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void aI(FeedData feedData) {
        super.aI(feedData);
        if (FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType())) {
            d(feedData);
        } else if (FeedData.TYPE_DECLARE.equals(feedData.getPraiseItemType())) {
            e(feedData);
        } else {
            this.eOs.setVisibility(0);
            this.eOs.setTag(Integer.valueOf(this.position));
            if (feedData.getReplyer() != null) {
                this.bdf.setText(feedData.getReplyer().getName_show());
                if (feedData.getReplyer().isBigV()) {
                    aj.r(this.bdf, d.C0107d.cp_cont_r);
                } else {
                    aj.r(this.bdf, d.C0107d.cp_cont_c);
                }
                if (feedData.getReplyer().getIsMyFriend() == 1) {
                    this.eOp.setVisibility(0);
                    this.eOp.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                    this.eOp.setTextColor(aj.getColor(d.C0107d.cp_cont_i));
                    this.eOp.setBackgroundDrawable(aj.getDrawable(d.f.game_center_start_btn));
                    this.eOp.setText(getString(d.j.chat));
                } else {
                    this.eOp.setVisibility(0);
                    this.eOp.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                    this.eOp.setTextColor(aj.getColor(d.C0107d.cp_cont_i));
                    this.eOp.setBackgroundDrawable(aj.getDrawable(d.f.game_center_start_btn));
                    this.eOp.setText(getString(d.j.chat));
                }
                this.drP.setText(am.z(feedData.getTime()));
                if (feedData.getReplyer().getIsMyFans() == 1) {
                    this.eNz.setVisibility(0);
                } else {
                    this.eNz.setVisibility(8);
                }
                this.eOt = TbFaceManager.LO().a(this.drg.getPageActivity().getApplicationContext(), feedData.getContent(), null);
                this.eNA.setText(a(this.eNA, this.eOt));
                if (feedData.getThread_Type() == 33) {
                    this.mTitle.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
                } else {
                    this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (feedData.getType() == 1) {
                    if (feedData.isStory()) {
                        this.eOu = TbFaceManager.LO().a(this.drg.getPageActivity().getApplicationContext(), this.drg.getPageActivity().getString(d.j.story_replyme_floor_original, new Object[]{feedData.getQuote_content()}), null);
                    } else {
                        this.eOu = TbFaceManager.LO().a(this.drg.getPageActivity().getApplicationContext(), this.drg.getPageActivity().getString(d.j.mention_replyme_original, new Object[]{feedData.getQuote_content()}), null);
                    }
                    this.mTitle.setText(a(this.mTitle, this.eOu));
                } else if (feedData.isStory()) {
                    this.mTitle.setText(this.drg.getPageActivity().getString(d.j.story_replyme_original, new Object[]{feedData.getTitle()}));
                } else if (feedData.isShareThread() && feedData.getOriginalThreadInfo() != null) {
                    this.mTitle.setText(this.drg.getPageActivity().getString(d.j.share_replyme_original, new Object[]{feedData.getOriginalThreadInfo().showText}));
                } else {
                    this.mTitle.setText(this.drg.getPageActivity().getString(d.j.mention_replyme_original, new Object[]{feedData.getTitle()}));
                }
                if (!feedData.isHideForumName() && feedData.getFname() != null && feedData.getFname().length() > 0) {
                    this.bcO.setVisibility(0);
                    this.bcO.setText(am.k(feedData.getFname(), 12).concat(getString(d.j.forum)));
                } else {
                    this.bcO.setVisibility(8);
                }
                this.dDq.setVisibility(0);
                this.dDq.setIsRound(true);
                this.dDq.setShowV(feedData.getReplyer().isBigV());
                String portrait = feedData.getReplyer().getPortrait();
                this.dDq.setTag(null);
                this.dDq.startLoad(portrait, 12, false);
                if (!am.isEmpty(feedData.getPostFrom())) {
                    this.eOq.setVisibility(0);
                    this.eOr.setVisibility(0);
                    this.eOr.setText(feedData.getPostFrom());
                } else {
                    this.eOq.setVisibility(8);
                    this.eOr.setVisibility(8);
                }
            }
        }
        if (Nd() != null) {
            Nd().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9488, feedData, null, null));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        aj.s(getRootView(), d.f.list_selector);
        aj.t(this.mLine, d.C0107d.cp_bg_line_b);
        this.eNA.setTextColor(aj.getColor(d.C0107d.cp_cont_b));
        this.drP.setTextColor(aj.getColor(d.C0107d.cp_cont_d));
        aj.t(this.eOq, d.C0107d.cp_cont_d);
        aj.r(this.eOr, d.C0107d.cp_cont_d);
        this.bcO.setTextColor(aj.getColor(d.C0107d.cp_cont_d));
        this.mTitle.setTextColor(aj.getColor(d.C0107d.cp_cont_c));
        aj.e(this.eOs, d.C0107d.cp_cont_c, 1);
        aj.s(this.eNz, d.f.icon_pb_fans);
        this.eOs.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_reply_n), (Drawable) null, (Drawable) null, (Drawable) null);
        aj.s(this.mTitle, d.f.bg_ta_dialog_content);
        return true;
    }

    private CharSequence a(TextView textView, SpannableString spannableString) {
        if (textView == null || spannableString == null || this.drg == null) {
            return null;
        }
        return TextUtils.ellipsize(spannableString, textView.getPaint(), (com.baidu.adp.lib.util.l.ao(this.drg.getPageActivity()) - (this.drg.getResources().getDimensionPixelSize(d.e.ds30) * 2)) - textView.getCompoundPaddingLeft(), TextUtils.TruncateAt.END);
    }

    private void d(FeedData feedData) {
        LikeData likeData;
        if (FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType())) {
            this.eOs.setVisibility(8);
            List<LikeData> praiseList = feedData.getPraiseList();
            if (praiseList != null && praiseList.size() > 0 && (likeData = praiseList.get(0)) != null) {
                this.bdf.setText(likeData.getNameShow());
                this.dDq.setShowV(likeData.isBigV());
                if (likeData.isBigV()) {
                    aj.r(this.bdf, d.C0107d.cp_cont_r);
                } else {
                    aj.r(this.bdf, d.C0107d.cp_cont_c);
                }
                this.eOp.setVisibility(8);
                this.drP.setText(am.z(feedData.getTime()));
                if (praiseList.size() > 3 && praiseList.get(1) != null && praiseList.get(2) != null) {
                    this.eNA.setText(String.format(getString(d.j.message_praise_like_list_more), likeData.getNameShow(), praiseList.get(1).getNameShow(), praiseList.get(2).getNameShow(), String.valueOf(feedData.getPraiseNum())));
                } else if (praiseList.size() > 2 && praiseList.get(1) != null && praiseList.get(2) != null) {
                    this.eNA.setText(String.format(getString(d.j.message_praise_like_list_3), likeData.getNameShow(), praiseList.get(1).getNameShow(), praiseList.get(2).getNameShow()));
                } else if (praiseList.size() > 1 && praiseList.get(1) != null) {
                    this.eNA.setText(String.format(getString(d.j.message_praise_like_list_2), likeData.getNameShow(), praiseList.get(1).getNameShow()));
                } else {
                    this.eNA.setText(String.format(getString(d.j.message_praise_like_list_1), likeData.getNameShow()));
                }
                if (feedData.isStory()) {
                    this.mTitle.setText(this.drg.getPageActivity().getString(d.j.story_replyme_original, new Object[]{feedData.getTitle()}));
                } else {
                    this.mTitle.setText(this.drg.getPageActivity().getString(d.j.mention_replyme_original, new Object[]{feedData.getTitle()}));
                }
                if (feedData.getThread_Type() == 33) {
                    this.mTitle.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
                } else {
                    this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (!feedData.isHideForumName() && feedData.getFname() != null && feedData.getFname().length() > 0) {
                    this.bcO.setVisibility(0);
                    this.bcO.setText(am.k(feedData.getFname(), 12).concat(getString(d.j.forum)));
                } else {
                    this.bcO.setVisibility(8);
                }
                this.dDq.setVisibility(0);
                this.dDq.setIsRound(true);
                this.dDq.startLoad(likeData.getPortrait(), 12, false);
                if (feedData.getReplyer() != null) {
                    if (feedData.getReplyer().getIsMyFans() == 1) {
                        this.eNz.setVisibility(0);
                    } else {
                        this.eNz.setVisibility(8);
                    }
                }
                this.eOq.setVisibility(8);
                this.eOr.setVisibility(8);
            }
        }
    }

    private void e(FeedData feedData) {
        LikeData likeData;
        this.eOs.setVisibility(8);
        List<LikeData> praiseList = feedData.getPraiseList();
        if (praiseList != null && praiseList.size() > 0 && (likeData = praiseList.get(0)) != null) {
            this.bdf.setText(likeData.getNameShow());
            this.dDq.setShowV(likeData.isBigV());
            if (likeData.isBigV()) {
                aj.r(this.bdf, d.C0107d.cp_cont_r);
            } else {
                aj.r(this.bdf, d.C0107d.cp_cont_c);
            }
            this.eOp.setVisibility(8);
            this.drP.setText(am.z(feedData.getTime()));
            if (praiseList.size() > 2 && praiseList.get(1) != null) {
                this.eNA.setText(String.format(getString(d.j.message_declare_list_more), likeData.getNameShow(), praiseList.get(1).getNameShow(), String.valueOf(feedData.getPraiseNum())));
            } else if (praiseList.size() == 2 && praiseList.get(1) != null) {
                this.eNA.setText(String.format(getString(d.j.message_declare_list_2), likeData.getNameShow(), praiseList.get(1).getNameShow()));
            } else {
                this.eNA.setText(String.format(getString(d.j.message_declare_list_1), likeData.getNameShow()));
            }
            if (feedData.isStory()) {
                this.mTitle.setText(this.drg.getPageActivity().getString(d.j.story_replyme_original, new Object[]{feedData.getTitle()}));
            } else {
                this.mTitle.setText(this.drg.getPageActivity().getString(d.j.mention_replyme_original, new Object[]{feedData.getTitle()}));
            }
            if (feedData.getThread_Type() == 33) {
                this.mTitle.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            if (!feedData.isHideForumName() && feedData.getFname() != null && feedData.getFname().length() > 0) {
                this.bcO.setVisibility(0);
                this.bcO.setText(am.k(feedData.getFname(), 12).concat(getString(d.j.forum)));
            } else {
                this.bcO.setVisibility(8);
            }
            this.dDq.setVisibility(0);
            this.dDq.startLoad(likeData.getPortrait(), 12, false);
        }
    }
}
