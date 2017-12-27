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
    private TextView bcI;
    private TextView bcZ;
    private TbPageContext<?> dmF;
    private TextView dno;
    private HeadImageView dyP;
    private ImageView eLZ;
    private TextView eMQ;
    private View eMR;
    private TextView eMS;
    private TextView eMT;
    private SpannableString eMU;
    private SpannableString eMV;
    private TextView eMa;
    private View mLine;
    private TextView mTitle;

    public k(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.dmF = tbPageContext;
        this.dyP = (HeadImageView) view.findViewById(d.g.photo);
        this.bcZ = (TextView) view.findViewById(d.g.user_name);
        this.eLZ = (ImageView) view.findViewById(d.g.fans_reply);
        this.dno = (TextView) view.findViewById(d.g.time);
        this.eMQ = (TextView) view.findViewById(d.g.add_friend_button);
        this.mLine = view.findViewById(d.g.line);
        this.eMa = (TextView) view.findViewById(d.g.content);
        this.mTitle = (TextView) view.findViewById(d.g.replyme_title);
        this.eMR = view.findViewById(d.g.divider_between_time_and_post_from);
        this.eMS = (TextView) view.findViewById(d.g.post_from);
        this.bcI = (TextView) view.findViewById(d.g.forum);
        this.eMT = (TextView) view.findViewById(d.g.tv_quick_reply_text);
        this.dyP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                k.this.Np().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9483, k.this.getData(), null, null));
            }
        });
        this.eMQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.k.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                k.this.Np().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9485, k.this.getData(), null, null));
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
                k.this.Np().dispatchMvcEvent(bVar);
            }
        });
        this.eMT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.k.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(9486, k.this.getData(), null, null);
                bVar.setView(k.this.getRootView());
                bVar.ii(k.this.position);
                k.this.Np().dispatchMvcEvent(bVar);
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
            this.eMT.setVisibility(0);
            this.eMT.setTag(Integer.valueOf(this.position));
            if (feedData.getReplyer() != null) {
                this.bcZ.setText(feedData.getReplyer().getName_show());
                if (feedData.getReplyer().isBigV()) {
                    aj.r(this.bcZ, d.C0108d.cp_cont_r);
                } else {
                    aj.r(this.bcZ, d.C0108d.cp_cont_c);
                }
                if (feedData.getReplyer().getIsMyFriend() == 1) {
                    this.eMQ.setVisibility(0);
                    this.eMQ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                    this.eMQ.setTextColor(aj.getColor(d.C0108d.cp_cont_i));
                    this.eMQ.setBackgroundDrawable(aj.getDrawable(d.f.game_center_start_btn));
                    this.eMQ.setText(getString(d.j.chat));
                } else {
                    this.eMQ.setVisibility(0);
                    this.eMQ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                    this.eMQ.setTextColor(aj.getColor(d.C0108d.cp_cont_i));
                    this.eMQ.setBackgroundDrawable(aj.getDrawable(d.f.game_center_start_btn));
                    this.eMQ.setText(getString(d.j.chat));
                }
                this.dno.setText(am.z(feedData.getTime()));
                if (feedData.getReplyer().getIsMyFans() == 1) {
                    this.eLZ.setVisibility(0);
                } else {
                    this.eLZ.setVisibility(8);
                }
                this.eMU = TbFaceManager.Ma().a(this.dmF.getPageActivity().getApplicationContext(), feedData.getContent(), null);
                this.eMa.setText(a(this.eMa, this.eMU));
                if (feedData.getThread_Type() == 33) {
                    this.mTitle.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
                } else {
                    this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (feedData.getType() == 1) {
                    if (feedData.isStory()) {
                        this.eMV = TbFaceManager.Ma().a(this.dmF.getPageActivity().getApplicationContext(), this.dmF.getPageActivity().getString(d.j.story_replyme_floor_original, new Object[]{feedData.getQuote_content()}), null);
                    } else {
                        this.eMV = TbFaceManager.Ma().a(this.dmF.getPageActivity().getApplicationContext(), this.dmF.getPageActivity().getString(d.j.mention_replyme_original, new Object[]{feedData.getQuote_content()}), null);
                    }
                    this.mTitle.setText(a(this.mTitle, this.eMV));
                } else if (feedData.isStory()) {
                    this.mTitle.setText(this.dmF.getPageActivity().getString(d.j.story_replyme_original, new Object[]{feedData.getTitle()}));
                } else if (feedData.isShareThread() && feedData.getOriginalThreadInfo() != null) {
                    this.mTitle.setText(this.dmF.getPageActivity().getString(d.j.share_replyme_original, new Object[]{feedData.getOriginalThreadInfo().showText}));
                } else {
                    this.mTitle.setText(this.dmF.getPageActivity().getString(d.j.mention_replyme_original, new Object[]{feedData.getTitle()}));
                }
                if (!feedData.isHideForumName() && feedData.getFname() != null && feedData.getFname().length() > 0) {
                    this.bcI.setVisibility(0);
                    this.bcI.setText(am.k(feedData.getFname(), 12).concat(getString(d.j.forum)));
                } else {
                    this.bcI.setVisibility(8);
                }
                this.dyP.setVisibility(0);
                this.dyP.setIsRound(true);
                this.dyP.setShowV(feedData.getReplyer().isBigV());
                String portrait = feedData.getReplyer().getPortrait();
                this.dyP.setTag(null);
                this.dyP.startLoad(portrait, 12, false);
                if (!am.isEmpty(feedData.getPostFrom())) {
                    this.eMR.setVisibility(0);
                    this.eMS.setVisibility(0);
                    this.eMS.setText(feedData.getPostFrom());
                } else {
                    this.eMR.setVisibility(8);
                    this.eMS.setVisibility(8);
                }
            }
        }
        if (Np() != null) {
            Np().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9488, feedData, null, null));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        aj.s(getRootView(), d.f.list_selector);
        aj.t(this.mLine, d.C0108d.cp_bg_line_b);
        this.eMa.setTextColor(aj.getColor(d.C0108d.cp_cont_b));
        this.dno.setTextColor(aj.getColor(d.C0108d.cp_cont_d));
        aj.t(this.eMR, d.C0108d.cp_cont_d);
        aj.r(this.eMS, d.C0108d.cp_cont_d);
        this.bcI.setTextColor(aj.getColor(d.C0108d.cp_cont_d));
        this.mTitle.setTextColor(aj.getColor(d.C0108d.cp_cont_c));
        aj.e(this.eMT, d.C0108d.cp_cont_c, 1);
        aj.s(this.eLZ, d.f.icon_pb_fans);
        this.eMT.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_reply_n), (Drawable) null, (Drawable) null, (Drawable) null);
        aj.s(this.mTitle, d.f.bg_ta_dialog_content);
        return true;
    }

    private CharSequence a(TextView textView, SpannableString spannableString) {
        if (textView == null || spannableString == null || this.dmF == null) {
            return null;
        }
        return TextUtils.ellipsize(spannableString, textView.getPaint(), (com.baidu.adp.lib.util.l.ao(this.dmF.getPageActivity()) - (this.dmF.getResources().getDimensionPixelSize(d.e.ds30) * 2)) - textView.getCompoundPaddingLeft(), TextUtils.TruncateAt.END);
    }

    private void d(FeedData feedData) {
        LikeData likeData;
        if (FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType())) {
            this.eMT.setVisibility(8);
            List<LikeData> praiseList = feedData.getPraiseList();
            if (praiseList != null && praiseList.size() > 0 && (likeData = praiseList.get(0)) != null) {
                this.bcZ.setText(likeData.getNameShow());
                this.dyP.setShowV(likeData.isBigV());
                if (likeData.isBigV()) {
                    aj.r(this.bcZ, d.C0108d.cp_cont_r);
                } else {
                    aj.r(this.bcZ, d.C0108d.cp_cont_c);
                }
                this.eMQ.setVisibility(8);
                this.dno.setText(am.z(feedData.getTime()));
                if (praiseList.size() > 3 && praiseList.get(1) != null && praiseList.get(2) != null) {
                    this.eMa.setText(String.format(getString(d.j.message_praise_like_list_more), likeData.getNameShow(), praiseList.get(1).getNameShow(), praiseList.get(2).getNameShow(), String.valueOf(feedData.getPraiseNum())));
                } else if (praiseList.size() > 2 && praiseList.get(1) != null && praiseList.get(2) != null) {
                    this.eMa.setText(String.format(getString(d.j.message_praise_like_list_3), likeData.getNameShow(), praiseList.get(1).getNameShow(), praiseList.get(2).getNameShow()));
                } else if (praiseList.size() > 1 && praiseList.get(1) != null) {
                    this.eMa.setText(String.format(getString(d.j.message_praise_like_list_2), likeData.getNameShow(), praiseList.get(1).getNameShow()));
                } else {
                    this.eMa.setText(String.format(getString(d.j.message_praise_like_list_1), likeData.getNameShow()));
                }
                if (feedData.isStory()) {
                    this.mTitle.setText(this.dmF.getPageActivity().getString(d.j.story_replyme_original, new Object[]{feedData.getTitle()}));
                } else {
                    this.mTitle.setText(this.dmF.getPageActivity().getString(d.j.mention_replyme_original, new Object[]{feedData.getTitle()}));
                }
                if (feedData.getThread_Type() == 33) {
                    this.mTitle.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
                } else {
                    this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (!feedData.isHideForumName() && feedData.getFname() != null && feedData.getFname().length() > 0) {
                    this.bcI.setVisibility(0);
                    this.bcI.setText(am.k(feedData.getFname(), 12).concat(getString(d.j.forum)));
                } else {
                    this.bcI.setVisibility(8);
                }
                this.dyP.setVisibility(0);
                this.dyP.setIsRound(true);
                this.dyP.startLoad(likeData.getPortrait(), 12, false);
                if (feedData.getReplyer() != null) {
                    if (feedData.getReplyer().getIsMyFans() == 1) {
                        this.eLZ.setVisibility(0);
                    } else {
                        this.eLZ.setVisibility(8);
                    }
                }
                this.eMR.setVisibility(8);
                this.eMS.setVisibility(8);
            }
        }
    }

    private void e(FeedData feedData) {
        LikeData likeData;
        this.eMT.setVisibility(8);
        List<LikeData> praiseList = feedData.getPraiseList();
        if (praiseList != null && praiseList.size() > 0 && (likeData = praiseList.get(0)) != null) {
            this.bcZ.setText(likeData.getNameShow());
            this.dyP.setShowV(likeData.isBigV());
            if (likeData.isBigV()) {
                aj.r(this.bcZ, d.C0108d.cp_cont_r);
            } else {
                aj.r(this.bcZ, d.C0108d.cp_cont_c);
            }
            this.eMQ.setVisibility(8);
            this.dno.setText(am.z(feedData.getTime()));
            if (praiseList.size() > 2 && praiseList.get(1) != null) {
                this.eMa.setText(String.format(getString(d.j.message_declare_list_more), likeData.getNameShow(), praiseList.get(1).getNameShow(), String.valueOf(feedData.getPraiseNum())));
            } else if (praiseList.size() == 2 && praiseList.get(1) != null) {
                this.eMa.setText(String.format(getString(d.j.message_declare_list_2), likeData.getNameShow(), praiseList.get(1).getNameShow()));
            } else {
                this.eMa.setText(String.format(getString(d.j.message_declare_list_1), likeData.getNameShow()));
            }
            if (feedData.isStory()) {
                this.mTitle.setText(this.dmF.getPageActivity().getString(d.j.story_replyme_original, new Object[]{feedData.getTitle()}));
            } else {
                this.mTitle.setText(this.dmF.getPageActivity().getString(d.j.mention_replyme_original, new Object[]{feedData.getTitle()}));
            }
            if (feedData.getThread_Type() == 33) {
                this.mTitle.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            if (!feedData.isHideForumName() && feedData.getFname() != null && feedData.getFname().length() > 0) {
                this.bcI.setVisibility(0);
                this.bcI.setText(am.k(feedData.getFname(), 12).concat(getString(d.j.forum)));
            } else {
                this.bcI.setVisibility(8);
            }
            this.dyP.setVisibility(0);
            this.dyP.startLoad(likeData.getPortrait(), 12, false);
        }
    }
}
