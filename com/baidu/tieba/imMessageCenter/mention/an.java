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
public class an extends com.baidu.tbadk.mvc.g.a<FeedData, com.baidu.tbadk.mvc.d.b> {
    private TextView aOH;
    private TextView ahV;
    private View anv;
    private TbPageContext<?> bNR;
    private TextView bOB;
    private HeadImageView bUx;
    private TextView beq;
    private TextView bpH;
    private TextView dzO;
    private TextView dzP;
    private SpannableString dzQ;
    private SpannableString dzR;

    public an(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.bNR = tbPageContext;
        this.bUx = (HeadImageView) view.findViewById(r.g.photo);
        this.ahV = (TextView) view.findViewById(r.g.user_name);
        this.bOB = (TextView) view.findViewById(r.g.time);
        this.dzO = (TextView) view.findViewById(r.g.add_friend_button);
        this.anv = view.findViewById(r.g.line);
        this.beq = (TextView) view.findViewById(r.g.content);
        this.aOH = (TextView) view.findViewById(r.g.replyme_title);
        this.bpH = (TextView) view.findViewById(r.g.forum);
        this.dzP = (TextView) view.findViewById(r.g.tv_quick_reply_text);
        this.bUx.setOnClickListener(new ao(this));
        this.dzO.setOnClickListener(new ap(this));
        view.setOnClickListener(new aq(this));
        this.dzP.setOnClickListener(new ar(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void E(FeedData feedData) {
        super.E(feedData);
        if (FeedData.TYPE_GRAFFITI.equals(feedData.getPraiseItemType()) || FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType())) {
            if (com.baidu.tieba.graffiti.d.alQ()) {
                c(feedData);
                return;
            } else if (com.baidu.tieba.graffiti.d.ak(null)) {
                b(feedData);
                return;
            } else {
                return;
            }
        }
        this.dzP.setVisibility(0);
        this.dzP.setTag(Integer.valueOf(this.position));
        if (feedData.getReplyer() != null) {
            this.ahV.setText(feedData.getReplyer().getName_show());
            if (feedData.getReplyer().getIsMyFriend() == 1) {
                this.dzO.setVisibility(0);
                this.dzO.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                this.dzO.setTextColor(com.baidu.tbadk.core.util.at.getColor(r.d.cp_cont_i));
                this.dzO.setBackgroundDrawable(com.baidu.tbadk.core.util.at.getDrawable(r.f.game_center_start_btn));
                this.dzO.setText(getString(r.j.mention_chatme));
            } else {
                this.dzO.setVisibility(0);
                this.dzO.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                this.dzO.setTextColor(com.baidu.tbadk.core.util.at.getColor(r.d.cp_cont_i));
                this.dzO.setBackgroundDrawable(com.baidu.tbadk.core.util.at.getDrawable(r.f.game_center_start_btn));
                this.dzO.setText(getString(r.j.mention_chatme));
            }
            this.bOB.setText(com.baidu.tbadk.core.util.ax.s(feedData.getTime()));
            this.dzQ = TbFaceManager.Eo().a(this.bNR.getPageActivity().getApplicationContext(), feedData.getContent(), null);
            this.beq.setText(a(this.beq, this.dzQ));
            if (feedData.getThread_Type() == 33) {
                this.aOH.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.at.getDrawable(r.f.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.aOH.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            if (feedData.getType() == 1) {
                this.dzR = TbFaceManager.Eo().a(this.bNR.getPageActivity().getApplicationContext(), this.bNR.getPageActivity().getString(r.j.mention_replyme_original, new Object[]{feedData.getQuote_content()}), null);
                this.aOH.setText(a(this.aOH, this.dzR));
            } else {
                this.aOH.setText(this.bNR.getPageActivity().getString(r.j.mention_replyme_original, new Object[]{feedData.getTitle()}));
            }
            if (feedData.getFname() != null && feedData.getFname().length() > 0) {
                this.bpH.setVisibility(0);
                this.bpH.setText(com.baidu.tbadk.core.util.ax.j(feedData.getFname(), 12).concat(getString(r.j.forum)));
            } else {
                this.bpH.setVisibility(8);
            }
            this.bUx.setVisibility(0);
            String portrait = feedData.getReplyer().getPortrait();
            this.bUx.setTag(null);
            this.bUx.c(portrait, 12, false);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.core.util.at.k(getRootView(), r.f.list_selector);
        com.baidu.tbadk.core.util.at.l(this.anv, r.d.cp_bg_line_b);
        this.beq.setTextColor(com.baidu.tbadk.core.util.at.getColor(r.d.cp_cont_b));
        this.bOB.setTextColor(com.baidu.tbadk.core.util.at.getColor(r.d.cp_cont_d));
        this.ahV.setTextColor(com.baidu.tbadk.core.util.at.getColor(r.d.cp_cont_f));
        this.bpH.setTextColor(com.baidu.tbadk.core.util.at.getColor(r.d.cp_cont_d));
        this.aOH.setTextColor(com.baidu.tbadk.core.util.at.getColor(r.d.cp_cont_c));
        com.baidu.tbadk.core.util.at.c(this.dzP, r.d.cp_cont_c, 1);
        this.dzP.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.at.getDrawable(r.f.icon_reply_n), (Drawable) null, (Drawable) null, (Drawable) null);
        com.baidu.tbadk.core.util.at.k(this.aOH, r.f.bg_ta_dialog_content);
        return true;
    }

    private CharSequence a(TextView textView, SpannableString spannableString) {
        if (textView == null || spannableString == null || this.bNR == null) {
            return null;
        }
        return TextUtils.ellipsize(spannableString, textView.getPaint(), (com.baidu.adp.lib.util.k.K(this.bNR.getPageActivity()) - (this.bNR.getResources().getDimensionPixelSize(r.e.ds30) * 2)) - textView.getCompoundPaddingLeft(), TextUtils.TruncateAt.END);
    }

    private void b(FeedData feedData) {
        LikeData likeData;
        if (FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType())) {
            this.dzP.setVisibility(8);
            List<LikeData> praiseList = feedData.getPraiseList();
            if (praiseList != null && praiseList.size() > 0 && (likeData = praiseList.get(0)) != null) {
                this.ahV.setText(likeData.getNameShow());
                this.dzO.setVisibility(8);
                this.bOB.setText(com.baidu.tbadk.core.util.ax.s(feedData.getTime()));
                if (praiseList.size() > 3 && praiseList.get(1) != null && praiseList.get(2) != null) {
                    this.beq.setText(String.format(getString(r.j.message_praise_like_list_more), likeData.getNameShow(), praiseList.get(1).getNameShow(), praiseList.get(2).getNameShow(), String.valueOf(feedData.getPraiseNum())));
                } else if (praiseList.size() > 2 && praiseList.get(1) != null && praiseList.get(2) != null) {
                    this.beq.setText(String.format(getString(r.j.message_praise_like_list_3), likeData.getNameShow(), praiseList.get(1).getNameShow(), praiseList.get(2).getNameShow()));
                } else if (praiseList.size() > 1 && praiseList.get(1) != null) {
                    this.beq.setText(String.format(getString(r.j.message_praise_like_list_2), likeData.getNameShow(), praiseList.get(1).getNameShow()));
                } else {
                    this.beq.setText(String.format(getString(r.j.message_praise_like_list_1), likeData.getNameShow()));
                }
                this.aOH.setText(this.bNR.getPageActivity().getString(r.j.mention_replyme_original, new Object[]{feedData.getTitle()}));
                if (feedData.getThread_Type() == 33) {
                    this.aOH.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.at.getDrawable(r.f.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
                } else {
                    this.aOH.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (feedData.getFname() != null && feedData.getFname().length() > 0) {
                    this.bpH.setVisibility(0);
                    this.bpH.setText(com.baidu.tbadk.core.util.ax.j(feedData.getFname(), 12).concat(getString(r.j.forum)));
                } else {
                    this.bpH.setVisibility(8);
                }
                this.bUx.setVisibility(0);
                this.bUx.c(likeData.getPortrait(), 12, false);
            }
        }
    }

    private void c(FeedData feedData) {
        LikeData likeData;
        String string;
        String string2;
        String string3;
        String string4;
        this.dzP.setVisibility(8);
        List<LikeData> praiseList = feedData.getPraiseList();
        if (praiseList != null && praiseList.size() > 0 && (likeData = praiseList.get(0)) != null) {
            this.ahV.setText(likeData.getNameShow());
            this.dzO.setVisibility(8);
            this.bOB.setText(com.baidu.tbadk.core.util.ax.s(feedData.getTime()));
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
                objArr[3] = com.baidu.tbadk.core.util.ax.A(feedData.getPraiseNum());
                this.beq.setText(String.format(string4, objArr));
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
                this.beq.setText(String.format(string3, objArr2));
            } else if (praiseList.size() > 1 && praiseList.get(1) != null) {
                if (feedData.isAuthor()) {
                    string2 = getString(r.j.message_praise_graffiti_author_list_2);
                } else {
                    string2 = getString(r.j.message_praise_graffiti_list_2);
                }
                Object[] objArr3 = new Object[2];
                objArr3[0] = StringUtils.isNull(likeData.getNameShow()) ? likeData.getName() : likeData.getNameShow();
                objArr3[1] = StringUtils.isNull(praiseList.get(1).getNameShow()) ? praiseList.get(1).getName() : praiseList.get(1).getNameShow();
                this.beq.setText(String.format(string2, objArr3));
            } else {
                if (feedData.isAuthor()) {
                    string = getString(r.j.message_praise_graffiti_author_list_1);
                } else {
                    string = getString(r.j.message_praise_graffiti_list_1);
                }
                Object[] objArr4 = new Object[1];
                objArr4[0] = StringUtils.isNull(likeData.getNameShow()) ? likeData.getName() : likeData.getNameShow();
                this.beq.setText(String.format(string, objArr4));
            }
            if (feedData.isAuthor()) {
                this.aOH.setText(this.bNR.getPageActivity().getString(r.j.mention_replyme_graffiti_author, new Object[]{feedData.getTitle()}));
            } else {
                this.aOH.setText(this.bNR.getPageActivity().getString(r.j.mention_replyme_graffiti_landlord, new Object[]{feedData.getTitle()}));
            }
            if (feedData.getThread_Type() == 33) {
                this.aOH.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.at.getDrawable(r.f.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.aOH.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            if (feedData.getFname() != null && feedData.getFname().length() > 0) {
                this.bpH.setVisibility(0);
                this.bpH.setText(com.baidu.tbadk.core.util.ax.j(feedData.getFname(), 12).concat(getString(r.j.forum)));
            } else {
                this.bpH.setVisibility(8);
            }
            this.bUx.setVisibility(0);
            this.bUx.c(likeData.getPortrait(), 12, false);
        }
    }
}
