package com.baidu.tieba.imMessageCenter.mention;

import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.r;
import java.util.List;
/* loaded from: classes.dex */
public class ap extends com.baidu.tbadk.mvc.f.a<FeedData, com.baidu.tbadk.mvc.d.b> {
    private TextView aNY;
    private TextView ahw;
    private View amY;
    private HeadImageView bAJ;
    private TextView bbT;
    private TextView bdI;
    private TbPageContext<?> btW;
    private TextView buG;
    private TextView dcP;
    private TextView dcQ;
    private SpannableString dcR;
    private SpannableString dcS;

    public ap(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.btW = tbPageContext;
        this.bAJ = (HeadImageView) view.findViewById(r.g.photo);
        this.ahw = (TextView) view.findViewById(r.g.user_name);
        this.buG = (TextView) view.findViewById(r.g.time);
        this.dcP = (TextView) view.findViewById(r.g.add_friend_button);
        this.amY = view.findViewById(r.g.line);
        this.bdI = (TextView) view.findViewById(r.g.content);
        this.aNY = (TextView) view.findViewById(r.g.replyme_title);
        this.bbT = (TextView) view.findViewById(r.g.forum);
        this.dcQ = (TextView) view.findViewById(r.g.tv_quick_reply_text);
        this.bAJ.setOnClickListener(new aq(this));
        this.dcP.setOnClickListener(new ar(this));
        view.setOnClickListener(new as(this));
        this.dcQ.setOnClickListener(new at(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void E(FeedData feedData) {
        super.E(feedData);
        if (FeedData.TYPE_GRAFFITI.equals(feedData.getPraiseItemType()) || FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType())) {
            if (com.baidu.tieba.graffiti.d.agr()) {
                e(feedData);
                return;
            } else if (com.baidu.tieba.graffiti.d.ak(null)) {
                d(feedData);
                return;
            } else {
                return;
            }
        }
        this.dcQ.setVisibility(0);
        this.dcQ.setTag(Integer.valueOf(this.position));
        if (feedData.getReplyer() != null) {
            this.ahw.setText(feedData.getReplyer().getName_show());
            if (feedData.getReplyer().getIsMyFriend() == 1) {
                this.dcP.setVisibility(0);
                this.dcP.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                this.dcP.setTextColor(com.baidu.tbadk.core.util.ar.getColor(r.d.cp_cont_i));
                this.dcP.setBackgroundDrawable(com.baidu.tbadk.core.util.ar.getDrawable(r.f.game_center_start_btn));
                this.dcP.setText(getString(r.j.mention_chatme));
            } else {
                this.dcP.setVisibility(0);
                this.dcP.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                this.dcP.setTextColor(com.baidu.tbadk.core.util.ar.getColor(r.d.cp_cont_i));
                this.dcP.setBackgroundDrawable(com.baidu.tbadk.core.util.ar.getDrawable(r.f.game_center_start_btn));
                this.dcP.setText(getString(r.j.mention_chatme));
            }
            this.buG.setText(com.baidu.tbadk.core.util.av.s(feedData.getTime()));
            this.dcR = TbFaceManager.DW().a(this.btW.getPageActivity().getApplicationContext(), feedData.getContent(), null);
            this.bdI.setText(a(this.bdI, this.dcR));
            if (feedData.getThread_Type() == 33) {
                this.aNY.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.ar.getDrawable(r.f.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.aNY.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            if (feedData.getType() == 1) {
                this.dcS = TbFaceManager.DW().a(this.btW.getPageActivity().getApplicationContext(), this.btW.getPageActivity().getString(r.j.mention_replyme_original, new Object[]{feedData.getQuote_content()}), null);
                this.aNY.setText(a(this.aNY, this.dcS));
            } else {
                this.aNY.setText(this.btW.getPageActivity().getString(r.j.mention_replyme_original, new Object[]{feedData.getTitle()}));
            }
            if (feedData.getFname() != null && feedData.getFname().length() > 0) {
                this.bbT.setVisibility(0);
                this.bbT.setText(com.baidu.tbadk.core.util.av.j(feedData.getFname(), 12).concat(getString(r.j.forum)));
            } else {
                this.bbT.setVisibility(8);
            }
            this.bAJ.setVisibility(0);
            String portrait = feedData.getReplyer().getPortrait();
            this.bAJ.setTag(null);
            this.bAJ.c(portrait, 12, false);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.r
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.core.util.ar.k(getRootView(), r.f.list_selector);
        com.baidu.tbadk.core.util.ar.l(this.amY, r.d.cp_bg_line_b);
        this.bdI.setTextColor(com.baidu.tbadk.core.util.ar.getColor(r.d.cp_cont_b));
        this.buG.setTextColor(com.baidu.tbadk.core.util.ar.getColor(r.d.cp_cont_d));
        this.ahw.setTextColor(com.baidu.tbadk.core.util.ar.getColor(r.d.cp_cont_f));
        this.bbT.setTextColor(com.baidu.tbadk.core.util.ar.getColor(r.d.cp_cont_d));
        this.aNY.setTextColor(com.baidu.tbadk.core.util.ar.getColor(r.d.cp_cont_c));
        com.baidu.tbadk.core.util.ar.c(this.dcQ, r.d.cp_cont_c, 1);
        this.dcQ.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.ar.getDrawable(r.f.icon_reply_n), (Drawable) null, (Drawable) null, (Drawable) null);
        com.baidu.tbadk.core.util.ar.k(this.aNY, r.f.bg_ta_dialog_content);
        return true;
    }

    private CharSequence a(TextView textView, SpannableString spannableString) {
        if (textView == null || spannableString == null || this.btW == null) {
            return null;
        }
        return TextUtils.ellipsize(spannableString, textView.getPaint(), (com.baidu.adp.lib.util.k.I(this.btW.getPageActivity()) - (this.btW.getResources().getDimensionPixelSize(r.e.ds30) * 2)) - textView.getCompoundPaddingLeft(), TextUtils.TruncateAt.END);
    }

    private void d(FeedData feedData) {
        LikeData likeData;
        if (FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType())) {
            this.dcQ.setVisibility(8);
            List<LikeData> praiseList = feedData.getPraiseList();
            if (praiseList != null && praiseList.size() > 0 && (likeData = praiseList.get(0)) != null) {
                this.ahw.setText(likeData.getNameShow());
                this.dcP.setVisibility(8);
                this.buG.setText(com.baidu.tbadk.core.util.av.s(feedData.getTime()));
                if (praiseList.size() > 3 && praiseList.get(1) != null && praiseList.get(2) != null) {
                    this.bdI.setText(String.format(getString(r.j.message_praise_like_list_more), likeData.getNameShow(), praiseList.get(1).getNameShow(), praiseList.get(2).getNameShow(), String.valueOf(feedData.getPraiseNum())));
                } else if (praiseList.size() > 2 && praiseList.get(1) != null && praiseList.get(2) != null) {
                    this.bdI.setText(String.format(getString(r.j.message_praise_like_list_3), likeData.getNameShow(), praiseList.get(1).getNameShow(), praiseList.get(2).getNameShow()));
                } else if (praiseList.size() > 1 && praiseList.get(1) != null) {
                    this.bdI.setText(String.format(getString(r.j.message_praise_like_list_2), likeData.getNameShow(), praiseList.get(1).getNameShow()));
                } else {
                    this.bdI.setText(String.format(getString(r.j.message_praise_like_list_1), likeData.getNameShow()));
                }
                this.aNY.setText(this.btW.getPageActivity().getString(r.j.mention_replyme_original, new Object[]{feedData.getTitle()}));
                if (feedData.getThread_Type() == 33) {
                    this.aNY.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.ar.getDrawable(r.f.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
                } else {
                    this.aNY.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (feedData.getFname() != null && feedData.getFname().length() > 0) {
                    this.bbT.setVisibility(0);
                    this.bbT.setText(com.baidu.tbadk.core.util.av.j(feedData.getFname(), 12).concat(getString(r.j.forum)));
                } else {
                    this.bbT.setVisibility(8);
                }
                this.bAJ.setVisibility(0);
                this.bAJ.c(likeData.getPortrait(), 12, false);
            }
        }
    }

    private void e(FeedData feedData) {
        LikeData likeData;
        String string;
        String string2;
        String string3;
        String string4;
        this.dcQ.setVisibility(8);
        List<LikeData> praiseList = feedData.getPraiseList();
        if (praiseList != null && praiseList.size() > 0 && (likeData = praiseList.get(0)) != null) {
            this.ahw.setText(likeData.getNameShow());
            this.dcP.setVisibility(8);
            this.buG.setText(com.baidu.tbadk.core.util.av.s(feedData.getTime()));
            if (praiseList.size() > 3 && praiseList.get(1) != null && praiseList.get(2) != null) {
                if (feedData.isAuthor()) {
                    string4 = getString(r.j.message_praise_graffiti_author_list_more);
                } else {
                    string4 = getString(r.j.message_praise_graffiti_list_more);
                }
                Object[] objArr = new Object[4];
                objArr[0] = StringUtils.isNull(likeData.getNameShow()) ? likeData.getName() : likeData.getNameShow();
                objArr[1] = StringUtils.isNull(praiseList.get(1).getNameShow()) ? praiseList.get(1).getName() : praiseList.get(1).getNameShow();
                objArr[2] = StringUtils.isNull(praiseList.get(2).getNameShow()) ? praiseList.get(2).getName() : praiseList.get(2).getNameShow();
                objArr[3] = com.baidu.tbadk.core.util.av.A(feedData.getPraiseNum());
                this.bdI.setText(String.format(string4, objArr));
            } else if (praiseList.size() > 2 && praiseList.get(1) != null && praiseList.get(2) != null) {
                if (feedData.isAuthor()) {
                    string3 = getString(r.j.message_praise_graffiti_author_list_3);
                } else {
                    string3 = getString(r.j.message_praise_graffiti_list_3);
                }
                Object[] objArr2 = new Object[3];
                objArr2[0] = StringUtils.isNull(likeData.getNameShow()) ? likeData.getName() : likeData.getNameShow();
                objArr2[1] = StringUtils.isNull(praiseList.get(1).getNameShow()) ? praiseList.get(1).getName() : praiseList.get(1).getNameShow();
                objArr2[2] = StringUtils.isNull(praiseList.get(2).getNameShow()) ? praiseList.get(2).getName() : praiseList.get(2).getNameShow();
                this.bdI.setText(String.format(string3, objArr2));
            } else if (praiseList.size() > 1 && praiseList.get(1) != null) {
                if (feedData.isAuthor()) {
                    string2 = getString(r.j.message_praise_graffiti_author_list_2);
                } else {
                    string2 = getString(r.j.message_praise_graffiti_list_2);
                }
                Object[] objArr3 = new Object[2];
                objArr3[0] = StringUtils.isNull(likeData.getNameShow()) ? likeData.getName() : likeData.getNameShow();
                objArr3[1] = StringUtils.isNull(praiseList.get(1).getNameShow()) ? praiseList.get(1).getName() : praiseList.get(1).getNameShow();
                this.bdI.setText(String.format(string2, objArr3));
            } else {
                if (feedData.isAuthor()) {
                    string = getString(r.j.message_praise_graffiti_author_list_1);
                } else {
                    string = getString(r.j.message_praise_graffiti_list_1);
                }
                Object[] objArr4 = new Object[1];
                objArr4[0] = StringUtils.isNull(likeData.getNameShow()) ? likeData.getName() : likeData.getNameShow();
                this.bdI.setText(String.format(string, objArr4));
            }
            if (feedData.isAuthor()) {
                this.aNY.setText(this.btW.getPageActivity().getString(r.j.mention_replyme_graffiti_author, new Object[]{feedData.getTitle()}));
            } else {
                this.aNY.setText(this.btW.getPageActivity().getString(r.j.mention_replyme_graffiti_landlord, new Object[]{feedData.getTitle()}));
            }
            if (feedData.getThread_Type() == 33) {
                this.aNY.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.ar.getDrawable(r.f.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.aNY.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            if (feedData.getFname() != null && feedData.getFname().length() > 0) {
                this.bbT.setVisibility(0);
                this.bbT.setText(com.baidu.tbadk.core.util.av.j(feedData.getFname(), 12).concat(getString(r.j.forum)));
            } else {
                this.bbT.setVisibility(8);
            }
            this.bAJ.setVisibility(0);
            this.bAJ.c(likeData.getPortrait(), 12, false);
        }
    }
}
