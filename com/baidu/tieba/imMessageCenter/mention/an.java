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
import com.baidu.tieba.t;
import java.util.List;
/* loaded from: classes.dex */
public class an extends com.baidu.tbadk.mvc.g.a<FeedData, com.baidu.tbadk.mvc.d.b> {
    private TextView aOG;
    private TextView aZB;
    private TextView adG;
    private View aiu;
    private TextView bbW;
    private TbPageContext<?> bbm;
    private HeadImageView bfG;
    private TextView cyN;
    private TextView cyO;
    private SpannableString cyP;
    private SpannableString cyQ;
    private TextView cyf;

    public an(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.bbm = tbPageContext;
        this.bfG = (HeadImageView) view.findViewById(t.g.photo);
        this.adG = (TextView) view.findViewById(t.g.user_name);
        this.bbW = (TextView) view.findViewById(t.g.time);
        this.cyN = (TextView) view.findViewById(t.g.add_friend_button);
        this.aiu = view.findViewById(t.g.line);
        this.cyf = (TextView) view.findViewById(t.g.content);
        this.aOG = (TextView) view.findViewById(t.g.replyme_title);
        this.aZB = (TextView) view.findViewById(t.g.forum);
        this.cyO = (TextView) view.findViewById(t.g.tv_quick_reply_text);
        this.bfG.setOnClickListener(new ao(this));
        this.cyN.setOnClickListener(new ap(this));
        view.setOnClickListener(new aq(this));
        this.cyO.setOnClickListener(new ar(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void B(FeedData feedData) {
        super.B(feedData);
        if (FeedData.TYPE_GRAFFITI.equals(feedData.getPraiseItemType()) || FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType())) {
            if (com.baidu.tieba.graffiti.d.XZ()) {
                c(feedData);
                return;
            } else if (com.baidu.tieba.graffiti.d.aj(null)) {
                b(feedData);
                return;
            } else {
                return;
            }
        }
        this.cyO.setVisibility(0);
        this.cyO.setTag(Integer.valueOf(this.position));
        if (feedData.getReplyer() != null) {
            this.adG.setText(feedData.getReplyer().getName_show());
            if (feedData.getReplyer().getIsMyFriend() == 1) {
                this.cyN.setVisibility(0);
                this.cyN.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                this.cyN.setTextColor(com.baidu.tbadk.core.util.at.getColor(t.d.cp_cont_i));
                this.cyN.setBackgroundDrawable(com.baidu.tbadk.core.util.at.getDrawable(t.f.game_center_start_btn));
                this.cyN.setText(getString(t.j.mention_chatme));
            } else {
                this.cyN.setVisibility(0);
                this.cyN.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                this.cyN.setTextColor(com.baidu.tbadk.core.util.at.getColor(t.d.cp_cont_i));
                this.cyN.setBackgroundDrawable(com.baidu.tbadk.core.util.at.getDrawable(t.f.game_center_start_btn));
                this.cyN.setText(getString(t.j.mention_chatme));
            }
            this.bbW.setText(com.baidu.tbadk.core.util.ay.x(feedData.getTime()));
            this.cyP = TbFaceManager.CG().a(this.bbm.getPageActivity().getApplicationContext(), feedData.getContent(), null);
            this.cyf.setText(a(this.cyf, this.cyP));
            if (feedData.getThread_Type() == 33) {
                this.aOG.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.at.getDrawable(t.f.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.aOG.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            if (feedData.getType() == 1) {
                this.cyQ = TbFaceManager.CG().a(this.bbm.getPageActivity().getApplicationContext(), this.bbm.getPageActivity().getString(t.j.mention_replyme_original, new Object[]{feedData.getQuote_content()}), null);
                this.aOG.setText(a(this.aOG, this.cyQ));
            } else {
                this.aOG.setText(this.bbm.getPageActivity().getString(t.j.mention_replyme_original, new Object[]{feedData.getTitle()}));
            }
            if (feedData.getFname() != null && feedData.getFname().length() > 0) {
                this.aZB.setVisibility(0);
                this.aZB.setText(com.baidu.tbadk.core.util.ay.j(feedData.getFname(), 12).concat(getString(t.j.forum)));
            } else {
                this.aZB.setVisibility(8);
            }
            this.bfG.setVisibility(0);
            String portrait = feedData.getReplyer().getPortrait();
            this.bfG.setTag(null);
            this.bfG.c(portrait, 12, false);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.core.util.at.k(getRootView(), t.f.list_selector);
        com.baidu.tbadk.core.util.at.l(this.aiu, t.d.cp_bg_line_b);
        this.cyf.setTextColor(com.baidu.tbadk.core.util.at.getColor(t.d.cp_cont_b));
        this.bbW.setTextColor(com.baidu.tbadk.core.util.at.getColor(t.d.cp_cont_d));
        this.adG.setTextColor(com.baidu.tbadk.core.util.at.getColor(t.d.cp_cont_f));
        this.aZB.setTextColor(com.baidu.tbadk.core.util.at.getColor(t.d.cp_cont_d));
        this.aOG.setTextColor(com.baidu.tbadk.core.util.at.getColor(t.d.cp_cont_c));
        com.baidu.tbadk.core.util.at.c(this.cyO, t.d.cp_cont_c, 1);
        this.cyO.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.at.getDrawable(t.f.icon_reply_n), (Drawable) null, (Drawable) null, (Drawable) null);
        com.baidu.tbadk.core.util.at.k(this.aOG, t.f.bg_ta_dialog_content);
        return true;
    }

    private CharSequence a(TextView textView, SpannableString spannableString) {
        if (textView == null || spannableString == null || this.bbm == null) {
            return null;
        }
        return TextUtils.ellipsize(spannableString, textView.getPaint(), (com.baidu.adp.lib.util.k.B(this.bbm.getPageActivity()) - (this.bbm.getResources().getDimensionPixelSize(t.e.ds30) * 2)) - textView.getCompoundPaddingLeft(), TextUtils.TruncateAt.END);
    }

    private void b(FeedData feedData) {
        LikeData likeData;
        if (FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType())) {
            this.cyO.setVisibility(8);
            List<LikeData> praiseList = feedData.getPraiseList();
            if (praiseList != null && praiseList.size() > 0 && (likeData = praiseList.get(0)) != null) {
                this.adG.setText(likeData.getNameShow());
                this.cyN.setVisibility(8);
                this.bbW.setText(com.baidu.tbadk.core.util.ay.x(feedData.getTime()));
                if (praiseList.size() > 3 && praiseList.get(1) != null && praiseList.get(2) != null) {
                    this.cyf.setText(String.format(getString(t.j.message_praise_like_list_more), likeData.getNameShow(), praiseList.get(1).getNameShow(), praiseList.get(2).getNameShow(), String.valueOf(feedData.getPraiseNum())));
                } else if (praiseList.size() > 2 && praiseList.get(1) != null && praiseList.get(2) != null) {
                    this.cyf.setText(String.format(getString(t.j.message_praise_like_list_3), likeData.getNameShow(), praiseList.get(1).getNameShow(), praiseList.get(2).getNameShow()));
                } else if (praiseList.size() > 1 && praiseList.get(1) != null) {
                    this.cyf.setText(String.format(getString(t.j.message_praise_like_list_2), likeData.getNameShow(), praiseList.get(1).getNameShow()));
                } else {
                    this.cyf.setText(String.format(getString(t.j.message_praise_like_list_1), likeData.getNameShow()));
                }
                this.aOG.setText(this.bbm.getPageActivity().getString(t.j.mention_replyme_original, new Object[]{feedData.getTitle()}));
                if (feedData.getThread_Type() == 33) {
                    this.aOG.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.at.getDrawable(t.f.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
                } else {
                    this.aOG.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (feedData.getFname() != null && feedData.getFname().length() > 0) {
                    this.aZB.setVisibility(0);
                    this.aZB.setText(com.baidu.tbadk.core.util.ay.j(feedData.getFname(), 12).concat(getString(t.j.forum)));
                } else {
                    this.aZB.setVisibility(8);
                }
                this.bfG.setVisibility(0);
                this.bfG.c(likeData.getPortrait(), 12, false);
            }
        }
    }

    private void c(FeedData feedData) {
        LikeData likeData;
        String string;
        String string2;
        String string3;
        String string4;
        this.cyO.setVisibility(8);
        List<LikeData> praiseList = feedData.getPraiseList();
        if (praiseList != null && praiseList.size() > 0 && (likeData = praiseList.get(0)) != null) {
            this.adG.setText(likeData.getNameShow());
            this.cyN.setVisibility(8);
            this.bbW.setText(com.baidu.tbadk.core.util.ay.x(feedData.getTime()));
            if (praiseList.size() > 3 && praiseList.get(1) != null && praiseList.get(2) != null) {
                if (feedData.isAuthor()) {
                    string4 = getString(t.j.message_praise_graffiti_author_list_more);
                } else {
                    string4 = getString(t.j.message_praise_graffiti_list_more);
                }
                Object[] objArr = new Object[4];
                objArr[0] = StringUtils.isNull(likeData.getNameShow()) ? likeData.getName() : likeData.getNameShow();
                objArr[1] = StringUtils.isNull(praiseList.get(1).getNameShow()) ? praiseList.get(1).getName() : praiseList.get(1).getNameShow();
                objArr[2] = StringUtils.isNull(praiseList.get(2).getNameShow()) ? praiseList.get(2).getName() : praiseList.get(2).getNameShow();
                objArr[3] = com.baidu.tbadk.core.util.ay.C(feedData.getPraiseNum());
                this.cyf.setText(String.format(string4, objArr));
            } else if (praiseList.size() > 2 && praiseList.get(1) != null && praiseList.get(2) != null) {
                if (feedData.isAuthor()) {
                    string3 = getString(t.j.message_praise_graffiti_author_list_3);
                } else {
                    string3 = getString(t.j.message_praise_graffiti_list_3);
                }
                Object[] objArr2 = new Object[3];
                objArr2[0] = StringUtils.isNull(likeData.getNameShow()) ? likeData.getName() : likeData.getNameShow();
                objArr2[1] = StringUtils.isNull(praiseList.get(1).getNameShow()) ? praiseList.get(1).getName() : praiseList.get(1).getNameShow();
                objArr2[2] = StringUtils.isNull(praiseList.get(2).getNameShow()) ? praiseList.get(2).getName() : praiseList.get(2).getNameShow();
                this.cyf.setText(String.format(string3, objArr2));
            } else if (praiseList.size() > 1 && praiseList.get(1) != null) {
                if (feedData.isAuthor()) {
                    string2 = getString(t.j.message_praise_graffiti_author_list_2);
                } else {
                    string2 = getString(t.j.message_praise_graffiti_list_2);
                }
                Object[] objArr3 = new Object[2];
                objArr3[0] = StringUtils.isNull(likeData.getNameShow()) ? likeData.getName() : likeData.getNameShow();
                objArr3[1] = StringUtils.isNull(praiseList.get(1).getNameShow()) ? praiseList.get(1).getName() : praiseList.get(1).getNameShow();
                this.cyf.setText(String.format(string2, objArr3));
            } else {
                if (feedData.isAuthor()) {
                    string = getString(t.j.message_praise_graffiti_author_list_1);
                } else {
                    string = getString(t.j.message_praise_graffiti_list_1);
                }
                Object[] objArr4 = new Object[1];
                objArr4[0] = StringUtils.isNull(likeData.getNameShow()) ? likeData.getName() : likeData.getNameShow();
                this.cyf.setText(String.format(string, objArr4));
            }
            if (feedData.isAuthor()) {
                this.aOG.setText(this.bbm.getPageActivity().getString(t.j.mention_replyme_graffiti_author, new Object[]{feedData.getTitle()}));
            } else {
                this.aOG.setText(this.bbm.getPageActivity().getString(t.j.mention_replyme_graffiti_landlord, new Object[]{feedData.getTitle()}));
            }
            if (feedData.getThread_Type() == 33) {
                this.aOG.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.at.getDrawable(t.f.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.aOG.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            if (feedData.getFname() != null && feedData.getFname().length() > 0) {
                this.aZB.setVisibility(0);
                this.aZB.setText(com.baidu.tbadk.core.util.ay.j(feedData.getFname(), 12).concat(getString(t.j.forum)));
            } else {
                this.aZB.setVisibility(8);
            }
            this.bfG.setVisibility(0);
            this.bfG.c(likeData.getPortrait(), 12, false);
        }
    }
}
