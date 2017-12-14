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
    private TextView aoG;
    private TextView aoX;
    private HeadImageView cJr;
    private TextView cyM;
    private TbPageContext<?> cyd;
    private ImageView dZS;
    private TextView dZT;
    private TextView eaJ;
    private View eaK;
    private TextView eaL;
    private TextView eaM;
    private SpannableString eaN;
    private SpannableString eaO;
    private View mLine;
    private TextView mTitle;

    public k(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.cyd = tbPageContext;
        this.cJr = (HeadImageView) view.findViewById(d.g.photo);
        this.aoX = (TextView) view.findViewById(d.g.user_name);
        this.dZS = (ImageView) view.findViewById(d.g.fans_reply);
        this.cyM = (TextView) view.findViewById(d.g.time);
        this.eaJ = (TextView) view.findViewById(d.g.add_friend_button);
        this.mLine = view.findViewById(d.g.line);
        this.dZT = (TextView) view.findViewById(d.g.content);
        this.mTitle = (TextView) view.findViewById(d.g.replyme_title);
        this.eaK = view.findViewById(d.g.divider_between_time_and_post_from);
        this.eaL = (TextView) view.findViewById(d.g.post_from);
        this.aoG = (TextView) view.findViewById(d.g.forum);
        this.eaM = (TextView) view.findViewById(d.g.tv_quick_reply_text);
        this.cJr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                k.this.FQ().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9483, k.this.getData(), null, null));
            }
        });
        this.eaJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.k.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                k.this.FQ().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9485, k.this.getData(), null, null));
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
                k.this.FQ().dispatchMvcEvent(bVar);
            }
        });
        this.eaM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.k.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(9486, k.this.getData(), null, null);
                bVar.setView(k.this.getRootView());
                bVar.fj(k.this.position);
                k.this.FQ().dispatchMvcEvent(bVar);
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
            this.eaM.setVisibility(0);
            this.eaM.setTag(Integer.valueOf(this.position));
            if (feedData.getReplyer() != null) {
                this.aoX.setText(feedData.getReplyer().getName_show());
                if (feedData.getReplyer().isBigV()) {
                    aj.i(this.aoX, d.C0096d.cp_cont_r);
                } else {
                    aj.i(this.aoX, d.C0096d.cp_cont_c);
                }
                if (feedData.getReplyer().getIsMyFriend() == 1) {
                    this.eaJ.setVisibility(0);
                    this.eaJ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                    this.eaJ.setTextColor(aj.getColor(d.C0096d.cp_cont_i));
                    this.eaJ.setBackgroundDrawable(aj.getDrawable(d.f.game_center_start_btn));
                    this.eaJ.setText(getString(d.j.chat));
                } else {
                    this.eaJ.setVisibility(0);
                    this.eaJ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                    this.eaJ.setTextColor(aj.getColor(d.C0096d.cp_cont_i));
                    this.eaJ.setBackgroundDrawable(aj.getDrawable(d.f.game_center_start_btn));
                    this.eaJ.setText(getString(d.j.chat));
                }
                this.cyM.setText(am.r(feedData.getTime()));
                if (feedData.getReplyer().getIsMyFans() == 1) {
                    this.dZS.setVisibility(0);
                } else {
                    this.dZS.setVisibility(8);
                }
                this.eaN = TbFaceManager.Ez().a(this.cyd.getPageActivity().getApplicationContext(), feedData.getContent(), null);
                this.dZT.setText(a(this.dZT, this.eaN));
                if (feedData.getThread_Type() == 33) {
                    this.mTitle.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
                } else {
                    this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (feedData.getType() == 1) {
                    if (feedData.isStory()) {
                        this.eaO = TbFaceManager.Ez().a(this.cyd.getPageActivity().getApplicationContext(), this.cyd.getPageActivity().getString(d.j.story_replyme_floor_original, new Object[]{feedData.getQuote_content()}), null);
                    } else {
                        this.eaO = TbFaceManager.Ez().a(this.cyd.getPageActivity().getApplicationContext(), this.cyd.getPageActivity().getString(d.j.mention_replyme_original, new Object[]{feedData.getQuote_content()}), null);
                    }
                    this.mTitle.setText(a(this.mTitle, this.eaO));
                } else if (feedData.isStory()) {
                    this.mTitle.setText(this.cyd.getPageActivity().getString(d.j.story_replyme_original, new Object[]{feedData.getTitle()}));
                } else if (feedData.isShareThread() && feedData.getOriginalThreadInfo() != null) {
                    this.mTitle.setText(this.cyd.getPageActivity().getString(d.j.share_replyme_original, new Object[]{feedData.getOriginalThreadInfo().showText}));
                } else {
                    this.mTitle.setText(this.cyd.getPageActivity().getString(d.j.mention_replyme_original, new Object[]{feedData.getTitle()}));
                }
                if (!feedData.isHideForumName() && feedData.getFname() != null && feedData.getFname().length() > 0) {
                    this.aoG.setVisibility(0);
                    this.aoG.setText(am.j(feedData.getFname(), 12).concat(getString(d.j.forum)));
                } else {
                    this.aoG.setVisibility(8);
                }
                this.cJr.setVisibility(0);
                this.cJr.setIsRound(true);
                this.cJr.setShowV(feedData.getReplyer().isBigV());
                String portrait = feedData.getReplyer().getPortrait();
                this.cJr.setTag(null);
                this.cJr.startLoad(portrait, 12, false);
                if (!am.isEmpty(feedData.getPostFrom())) {
                    this.eaK.setVisibility(0);
                    this.eaL.setVisibility(0);
                    this.eaL.setText(feedData.getPostFrom());
                } else {
                    this.eaK.setVisibility(8);
                    this.eaL.setVisibility(8);
                }
            }
        }
        if (FQ() != null) {
            FQ().dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9488, feedData, null, null));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.n
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        aj.j(getRootView(), d.f.list_selector);
        aj.k(this.mLine, d.C0096d.cp_bg_line_b);
        this.dZT.setTextColor(aj.getColor(d.C0096d.cp_cont_b));
        this.cyM.setTextColor(aj.getColor(d.C0096d.cp_cont_d));
        aj.k(this.eaK, d.C0096d.cp_cont_d);
        aj.i(this.eaL, d.C0096d.cp_cont_d);
        this.aoG.setTextColor(aj.getColor(d.C0096d.cp_cont_d));
        this.mTitle.setTextColor(aj.getColor(d.C0096d.cp_cont_c));
        aj.c(this.eaM, d.C0096d.cp_cont_c, 1);
        aj.j(this.dZS, d.f.icon_pb_fans);
        this.eaM.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_reply_n), (Drawable) null, (Drawable) null, (Drawable) null);
        aj.j(this.mTitle, d.f.bg_ta_dialog_content);
        return true;
    }

    private CharSequence a(TextView textView, SpannableString spannableString) {
        if (textView == null || spannableString == null || this.cyd == null) {
            return null;
        }
        return TextUtils.ellipsize(spannableString, textView.getPaint(), (com.baidu.adp.lib.util.l.ac(this.cyd.getPageActivity()) - (this.cyd.getResources().getDimensionPixelSize(d.e.ds30) * 2)) - textView.getCompoundPaddingLeft(), TextUtils.TruncateAt.END);
    }

    private void e(FeedData feedData) {
        LikeData likeData;
        if (FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType())) {
            this.eaM.setVisibility(8);
            List<LikeData> praiseList = feedData.getPraiseList();
            if (praiseList != null && praiseList.size() > 0 && (likeData = praiseList.get(0)) != null) {
                this.aoX.setText(likeData.getNameShow());
                this.cJr.setShowV(likeData.isBigV());
                if (likeData.isBigV()) {
                    aj.i(this.aoX, d.C0096d.cp_cont_r);
                } else {
                    aj.i(this.aoX, d.C0096d.cp_cont_c);
                }
                this.eaJ.setVisibility(8);
                this.cyM.setText(am.r(feedData.getTime()));
                if (praiseList.size() > 3 && praiseList.get(1) != null && praiseList.get(2) != null) {
                    this.dZT.setText(String.format(getString(d.j.message_praise_like_list_more), likeData.getNameShow(), praiseList.get(1).getNameShow(), praiseList.get(2).getNameShow(), String.valueOf(feedData.getPraiseNum())));
                } else if (praiseList.size() > 2 && praiseList.get(1) != null && praiseList.get(2) != null) {
                    this.dZT.setText(String.format(getString(d.j.message_praise_like_list_3), likeData.getNameShow(), praiseList.get(1).getNameShow(), praiseList.get(2).getNameShow()));
                } else if (praiseList.size() > 1 && praiseList.get(1) != null) {
                    this.dZT.setText(String.format(getString(d.j.message_praise_like_list_2), likeData.getNameShow(), praiseList.get(1).getNameShow()));
                } else {
                    this.dZT.setText(String.format(getString(d.j.message_praise_like_list_1), likeData.getNameShow()));
                }
                if (feedData.isStory()) {
                    this.mTitle.setText(this.cyd.getPageActivity().getString(d.j.story_replyme_original, new Object[]{feedData.getTitle()}));
                } else {
                    this.mTitle.setText(this.cyd.getPageActivity().getString(d.j.mention_replyme_original, new Object[]{feedData.getTitle()}));
                }
                if (feedData.getThread_Type() == 33) {
                    this.mTitle.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
                } else {
                    this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (!feedData.isHideForumName() && feedData.getFname() != null && feedData.getFname().length() > 0) {
                    this.aoG.setVisibility(0);
                    this.aoG.setText(am.j(feedData.getFname(), 12).concat(getString(d.j.forum)));
                } else {
                    this.aoG.setVisibility(8);
                }
                this.cJr.setVisibility(0);
                this.cJr.setIsRound(true);
                this.cJr.startLoad(likeData.getPortrait(), 12, false);
            }
        }
    }

    private void f(FeedData feedData) {
        LikeData likeData;
        this.eaM.setVisibility(8);
        List<LikeData> praiseList = feedData.getPraiseList();
        if (praiseList != null && praiseList.size() > 0 && (likeData = praiseList.get(0)) != null) {
            this.aoX.setText(likeData.getNameShow());
            this.cJr.setShowV(likeData.isBigV());
            if (likeData.isBigV()) {
                aj.i(this.aoX, d.C0096d.cp_cont_r);
            } else {
                aj.i(this.aoX, d.C0096d.cp_cont_c);
            }
            this.eaJ.setVisibility(8);
            this.cyM.setText(am.r(feedData.getTime()));
            if (praiseList.size() > 2 && praiseList.get(1) != null) {
                this.dZT.setText(String.format(getString(d.j.message_declare_list_more), likeData.getNameShow(), praiseList.get(1).getNameShow(), String.valueOf(feedData.getPraiseNum())));
            } else if (praiseList.size() == 2 && praiseList.get(1) != null) {
                this.dZT.setText(String.format(getString(d.j.message_declare_list_2), likeData.getNameShow(), praiseList.get(1).getNameShow()));
            } else {
                this.dZT.setText(String.format(getString(d.j.message_declare_list_1), likeData.getNameShow()));
            }
            if (feedData.isStory()) {
                this.mTitle.setText(this.cyd.getPageActivity().getString(d.j.story_replyme_original, new Object[]{feedData.getTitle()}));
            } else {
                this.mTitle.setText(this.cyd.getPageActivity().getString(d.j.mention_replyme_original, new Object[]{feedData.getTitle()}));
            }
            if (feedData.getThread_Type() == 33) {
                this.mTitle.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.mTitle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            if (!feedData.isHideForumName() && feedData.getFname() != null && feedData.getFname().length() > 0) {
                this.aoG.setVisibility(0);
                this.aoG.setText(am.j(feedData.getFname(), 12).concat(getString(d.j.forum)));
            } else {
                this.aoG.setVisibility(8);
            }
            this.cJr.setVisibility(0);
            this.cJr.startLoad(likeData.getPortrait(), 12, false);
        }
    }
}
