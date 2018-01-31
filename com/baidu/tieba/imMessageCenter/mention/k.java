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
    private TextView bcW;
    private TextView bdn;
    private HeadImageView dDL;
    private TbPageContext<?> drB;
    private TextView dsk;
    private ImageView eNU;
    private TextView eNV;
    private TextView eOK;
    private View eOL;
    private TextView eOM;
    private TextView eON;
    private SpannableString eOO;
    private SpannableString eOP;
    private View mLine;
    private TextView mTitle;

    public k(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.drB = tbPageContext;
        this.dDL = (HeadImageView) view.findViewById(d.g.photo);
        this.bdn = (TextView) view.findViewById(d.g.user_name);
        this.eNU = (ImageView) view.findViewById(d.g.fans_reply);
        this.dsk = (TextView) view.findViewById(d.g.time);
        this.eOK = (TextView) view.findViewById(d.g.add_friend_button);
        this.mLine = view.findViewById(d.g.line);
        this.eNV = (TextView) view.findViewById(d.g.content);
        this.mTitle = (TextView) view.findViewById(d.g.replyme_title);
        this.eOL = view.findViewById(d.g.divider_between_time_and_post_from);
        this.eOM = (TextView) view.findViewById(d.g.post_from);
        this.bcW = (TextView) view.findViewById(d.g.forum);
        this.eON = (TextView) view.findViewById(d.g.tv_quick_reply_text);
        this.dDL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                k.this.Nf().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9483, k.this.getData(), null, null));
            }
        });
        this.eOK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.k.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                k.this.Nf().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9485, k.this.getData(), null, null));
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
                k.this.Nf().dispatchMvcEvent(bVar);
            }
        });
        this.eON.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.k.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(9486, k.this.getData(), null, null);
                bVar.setView(k.this.getRootView());
                bVar.ie(k.this.position);
                k.this.Nf().dispatchMvcEvent(bVar);
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
            this.eON.setVisibility(0);
            this.eON.setTag(Integer.valueOf(this.position));
            if (feedData.getReplyer() != null) {
                this.bdn.setText(feedData.getReplyer().getName_show());
                if (feedData.getReplyer().isBigV()) {
                    aj.r(this.bdn, d.C0108d.cp_cont_r);
                } else {
                    aj.r(this.bdn, d.C0108d.cp_cont_c);
                }
                if (feedData.getReplyer().getIsMyFriend() == 1) {
                    this.eOK.setVisibility(0);
                    this.eOK.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                    this.eOK.setTextColor(aj.getColor(d.C0108d.cp_cont_i));
                    this.eOK.setBackgroundDrawable(aj.getDrawable(d.f.game_center_start_btn));
                    this.eOK.setText(getString(d.j.chat));
                } else {
                    this.eOK.setVisibility(0);
                    this.eOK.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                    this.eOK.setTextColor(aj.getColor(d.C0108d.cp_cont_i));
                    this.eOK.setBackgroundDrawable(aj.getDrawable(d.f.game_center_start_btn));
                    this.eOK.setText(getString(d.j.chat));
                }
                this.dsk.setText(am.z(feedData.getTime()));
                if (feedData.getReplyer().getIsMyFans() == 1) {
                    this.eNU.setVisibility(0);
                } else {
                    this.eNU.setVisibility(8);
                }
                this.eOO = TbFaceManager.LQ().a(this.drB.getPageActivity().getApplicationContext(), feedData.getContent(), null);
                this.eNV.setText(a(this.eNV, this.eOO));
                if (feedData.getThread_Type() == 33) {
                    this.mTitle.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
                } else {
                    this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (feedData.getType() == 1) {
                    if (feedData.isStory()) {
                        this.eOP = TbFaceManager.LQ().a(this.drB.getPageActivity().getApplicationContext(), this.drB.getPageActivity().getString(d.j.story_replyme_floor_original, new Object[]{feedData.getQuote_content()}), null);
                    } else {
                        this.eOP = TbFaceManager.LQ().a(this.drB.getPageActivity().getApplicationContext(), this.drB.getPageActivity().getString(d.j.mention_replyme_original, new Object[]{feedData.getQuote_content()}), null);
                    }
                    this.mTitle.setText(a(this.mTitle, this.eOP));
                } else if (feedData.isStory()) {
                    this.mTitle.setText(this.drB.getPageActivity().getString(d.j.story_replyme_original, new Object[]{feedData.getTitle()}));
                } else if (feedData.isShareThread() && feedData.getOriginalThreadInfo() != null) {
                    this.mTitle.setText(this.drB.getPageActivity().getString(d.j.share_replyme_original, new Object[]{feedData.getOriginalThreadInfo().showText}));
                } else {
                    this.mTitle.setText(this.drB.getPageActivity().getString(d.j.mention_replyme_original, new Object[]{feedData.getTitle()}));
                }
                if (!feedData.isHideForumName() && feedData.getFname() != null && feedData.getFname().length() > 0) {
                    this.bcW.setVisibility(0);
                    this.bcW.setText(am.k(feedData.getFname(), 12).concat(getString(d.j.forum)));
                } else {
                    this.bcW.setVisibility(8);
                }
                this.dDL.setVisibility(0);
                this.dDL.setIsRound(true);
                this.dDL.setShowV(feedData.getReplyer().isBigV());
                String portrait = feedData.getReplyer().getPortrait();
                this.dDL.setTag(null);
                this.dDL.startLoad(portrait, 12, false);
                if (!am.isEmpty(feedData.getPostFrom())) {
                    this.eOL.setVisibility(0);
                    this.eOM.setVisibility(0);
                    this.eOM.setText(feedData.getPostFrom());
                } else {
                    this.eOL.setVisibility(8);
                    this.eOM.setVisibility(8);
                }
            }
        }
        if (Nf() != null) {
            Nf().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9488, feedData, null, null));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        aj.s(getRootView(), d.f.list_selector);
        aj.t(this.mLine, d.C0108d.cp_bg_line_b);
        this.eNV.setTextColor(aj.getColor(d.C0108d.cp_cont_b));
        this.dsk.setTextColor(aj.getColor(d.C0108d.cp_cont_d));
        aj.t(this.eOL, d.C0108d.cp_cont_d);
        aj.r(this.eOM, d.C0108d.cp_cont_d);
        this.bcW.setTextColor(aj.getColor(d.C0108d.cp_cont_d));
        this.mTitle.setTextColor(aj.getColor(d.C0108d.cp_cont_c));
        aj.e(this.eON, d.C0108d.cp_cont_c, 1);
        aj.s(this.eNU, d.f.icon_pb_fans);
        this.eON.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_reply_n), (Drawable) null, (Drawable) null, (Drawable) null);
        aj.s(this.mTitle, d.f.bg_ta_dialog_content);
        return true;
    }

    private CharSequence a(TextView textView, SpannableString spannableString) {
        if (textView == null || spannableString == null || this.drB == null) {
            return null;
        }
        return TextUtils.ellipsize(spannableString, textView.getPaint(), (com.baidu.adp.lib.util.l.ao(this.drB.getPageActivity()) - (this.drB.getResources().getDimensionPixelSize(d.e.ds30) * 2)) - textView.getCompoundPaddingLeft(), TextUtils.TruncateAt.END);
    }

    private void d(FeedData feedData) {
        LikeData likeData;
        if (FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType())) {
            this.eON.setVisibility(8);
            List<LikeData> praiseList = feedData.getPraiseList();
            if (praiseList != null && praiseList.size() > 0 && (likeData = praiseList.get(0)) != null) {
                this.bdn.setText(likeData.getNameShow());
                this.dDL.setShowV(likeData.isBigV());
                if (likeData.isBigV()) {
                    aj.r(this.bdn, d.C0108d.cp_cont_r);
                } else {
                    aj.r(this.bdn, d.C0108d.cp_cont_c);
                }
                this.eOK.setVisibility(8);
                this.dsk.setText(am.z(feedData.getTime()));
                if (praiseList.size() > 3 && praiseList.get(1) != null && praiseList.get(2) != null) {
                    this.eNV.setText(String.format(getString(d.j.message_praise_like_list_more), likeData.getNameShow(), praiseList.get(1).getNameShow(), praiseList.get(2).getNameShow(), String.valueOf(feedData.getPraiseNum())));
                } else if (praiseList.size() > 2 && praiseList.get(1) != null && praiseList.get(2) != null) {
                    this.eNV.setText(String.format(getString(d.j.message_praise_like_list_3), likeData.getNameShow(), praiseList.get(1).getNameShow(), praiseList.get(2).getNameShow()));
                } else if (praiseList.size() > 1 && praiseList.get(1) != null) {
                    this.eNV.setText(String.format(getString(d.j.message_praise_like_list_2), likeData.getNameShow(), praiseList.get(1).getNameShow()));
                } else {
                    this.eNV.setText(String.format(getString(d.j.message_praise_like_list_1), likeData.getNameShow()));
                }
                if (feedData.isStory()) {
                    this.mTitle.setText(this.drB.getPageActivity().getString(d.j.story_replyme_original, new Object[]{feedData.getTitle()}));
                } else {
                    this.mTitle.setText(this.drB.getPageActivity().getString(d.j.mention_replyme_original, new Object[]{feedData.getTitle()}));
                }
                if (feedData.getThread_Type() == 33) {
                    this.mTitle.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
                } else {
                    this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (!feedData.isHideForumName() && feedData.getFname() != null && feedData.getFname().length() > 0) {
                    this.bcW.setVisibility(0);
                    this.bcW.setText(am.k(feedData.getFname(), 12).concat(getString(d.j.forum)));
                } else {
                    this.bcW.setVisibility(8);
                }
                this.dDL.setVisibility(0);
                this.dDL.setIsRound(true);
                this.dDL.startLoad(likeData.getPortrait(), 12, false);
                if (feedData.getReplyer() != null) {
                    if (feedData.getReplyer().getIsMyFans() == 1) {
                        this.eNU.setVisibility(0);
                    } else {
                        this.eNU.setVisibility(8);
                    }
                }
                this.eOL.setVisibility(8);
                this.eOM.setVisibility(8);
            }
        }
    }

    private void e(FeedData feedData) {
        LikeData likeData;
        this.eON.setVisibility(8);
        List<LikeData> praiseList = feedData.getPraiseList();
        if (praiseList != null && praiseList.size() > 0 && (likeData = praiseList.get(0)) != null) {
            this.bdn.setText(likeData.getNameShow());
            this.dDL.setShowV(likeData.isBigV());
            if (likeData.isBigV()) {
                aj.r(this.bdn, d.C0108d.cp_cont_r);
            } else {
                aj.r(this.bdn, d.C0108d.cp_cont_c);
            }
            this.eOK.setVisibility(8);
            this.dsk.setText(am.z(feedData.getTime()));
            if (praiseList.size() > 2 && praiseList.get(1) != null) {
                this.eNV.setText(String.format(getString(d.j.message_declare_list_more), likeData.getNameShow(), praiseList.get(1).getNameShow(), String.valueOf(feedData.getPraiseNum())));
            } else if (praiseList.size() == 2 && praiseList.get(1) != null) {
                this.eNV.setText(String.format(getString(d.j.message_declare_list_2), likeData.getNameShow(), praiseList.get(1).getNameShow()));
            } else {
                this.eNV.setText(String.format(getString(d.j.message_declare_list_1), likeData.getNameShow()));
            }
            if (feedData.isStory()) {
                this.mTitle.setText(this.drB.getPageActivity().getString(d.j.story_replyme_original, new Object[]{feedData.getTitle()}));
            } else {
                this.mTitle.setText(this.drB.getPageActivity().getString(d.j.mention_replyme_original, new Object[]{feedData.getTitle()}));
            }
            if (feedData.getThread_Type() == 33) {
                this.mTitle.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            if (!feedData.isHideForumName() && feedData.getFname() != null && feedData.getFname().length() > 0) {
                this.bcW.setVisibility(0);
                this.bcW.setText(am.k(feedData.getFname(), 12).concat(getString(d.j.forum)));
            } else {
                this.bcW.setVisibility(8);
            }
            this.dDL.setVisibility(0);
            this.dDL.startLoad(likeData.getPortrait(), 12, false);
        }
    }
}
