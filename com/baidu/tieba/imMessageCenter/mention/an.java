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
    private TextView aYh;
    private TextView ahN;
    private View amU;
    private TbPageContext<?> bKX;
    private TextView bLH;
    private HeadImageView bSr;
    private TextView baU;
    private TextView bmz;
    private TextView dsM;
    private TextView dsN;
    private SpannableString dsO;
    private SpannableString dsP;

    public an(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.bKX = tbPageContext;
        this.bSr = (HeadImageView) view.findViewById(t.g.photo);
        this.ahN = (TextView) view.findViewById(t.g.user_name);
        this.bLH = (TextView) view.findViewById(t.g.time);
        this.dsM = (TextView) view.findViewById(t.g.add_friend_button);
        this.amU = view.findViewById(t.g.line);
        this.baU = (TextView) view.findViewById(t.g.content);
        this.aYh = (TextView) view.findViewById(t.g.replyme_title);
        this.bmz = (TextView) view.findViewById(t.g.forum);
        this.dsN = (TextView) view.findViewById(t.g.tv_quick_reply_text);
        this.bSr.setOnClickListener(new ao(this));
        this.dsM.setOnClickListener(new ap(this));
        view.setOnClickListener(new aq(this));
        this.dsN.setOnClickListener(new ar(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void E(FeedData feedData) {
        super.E(feedData);
        if (FeedData.TYPE_GRAFFITI.equals(feedData.getPraiseItemType()) || FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType())) {
            if (com.baidu.tieba.graffiti.d.ajH()) {
                c(feedData);
                return;
            } else if (com.baidu.tieba.graffiti.d.al(null)) {
                b(feedData);
                return;
            } else {
                return;
            }
        }
        this.dsN.setVisibility(0);
        this.dsN.setTag(Integer.valueOf(this.position));
        if (feedData.getReplyer() != null) {
            this.ahN.setText(feedData.getReplyer().getName_show());
            if (feedData.getReplyer().getIsMyFriend() == 1) {
                this.dsM.setVisibility(0);
                this.dsM.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                this.dsM.setTextColor(com.baidu.tbadk.core.util.av.getColor(t.d.cp_cont_i));
                this.dsM.setBackgroundDrawable(com.baidu.tbadk.core.util.av.getDrawable(t.f.game_center_start_btn));
                this.dsM.setText(getString(t.j.mention_chatme));
            } else {
                this.dsM.setVisibility(0);
                this.dsM.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                this.dsM.setTextColor(com.baidu.tbadk.core.util.av.getColor(t.d.cp_cont_i));
                this.dsM.setBackgroundDrawable(com.baidu.tbadk.core.util.av.getDrawable(t.f.game_center_start_btn));
                this.dsM.setText(getString(t.j.mention_chatme));
            }
            this.bLH.setText(com.baidu.tbadk.core.util.ba.t(feedData.getTime()));
            this.dsO = TbFaceManager.Ej().a(this.bKX.getPageActivity().getApplicationContext(), feedData.getContent(), null);
            this.baU.setText(a(this.baU, this.dsO));
            if (feedData.getThread_Type() == 33) {
                this.aYh.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.av.getDrawable(t.f.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.aYh.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            if (feedData.getType() == 1) {
                this.dsP = TbFaceManager.Ej().a(this.bKX.getPageActivity().getApplicationContext(), this.bKX.getPageActivity().getString(t.j.mention_replyme_original, new Object[]{feedData.getQuote_content()}), null);
                this.aYh.setText(a(this.aYh, this.dsP));
            } else {
                this.aYh.setText(this.bKX.getPageActivity().getString(t.j.mention_replyme_original, new Object[]{feedData.getTitle()}));
            }
            if (feedData.getFname() != null && feedData.getFname().length() > 0) {
                this.bmz.setVisibility(0);
                this.bmz.setText(com.baidu.tbadk.core.util.ba.j(feedData.getFname(), 12).concat(getString(t.j.forum)));
            } else {
                this.bmz.setVisibility(8);
            }
            this.bSr.setVisibility(0);
            String portrait = feedData.getReplyer().getPortrait();
            this.bSr.setTag(null);
            this.bSr.c(portrait, 12, false);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.core.util.av.k(getRootView(), t.f.list_selector);
        com.baidu.tbadk.core.util.av.l(this.amU, t.d.cp_bg_line_b);
        this.baU.setTextColor(com.baidu.tbadk.core.util.av.getColor(t.d.cp_cont_b));
        this.bLH.setTextColor(com.baidu.tbadk.core.util.av.getColor(t.d.cp_cont_d));
        this.ahN.setTextColor(com.baidu.tbadk.core.util.av.getColor(t.d.cp_cont_f));
        this.bmz.setTextColor(com.baidu.tbadk.core.util.av.getColor(t.d.cp_cont_d));
        this.aYh.setTextColor(com.baidu.tbadk.core.util.av.getColor(t.d.cp_cont_c));
        com.baidu.tbadk.core.util.av.c(this.dsN, t.d.cp_cont_c, 1);
        this.dsN.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.av.getDrawable(t.f.icon_reply_n), (Drawable) null, (Drawable) null, (Drawable) null);
        com.baidu.tbadk.core.util.av.k(this.aYh, t.f.bg_ta_dialog_content);
        return true;
    }

    private CharSequence a(TextView textView, SpannableString spannableString) {
        if (textView == null || spannableString == null || this.bKX == null) {
            return null;
        }
        return TextUtils.ellipsize(spannableString, textView.getPaint(), (com.baidu.adp.lib.util.k.K(this.bKX.getPageActivity()) - (this.bKX.getResources().getDimensionPixelSize(t.e.ds30) * 2)) - textView.getCompoundPaddingLeft(), TextUtils.TruncateAt.END);
    }

    private void b(FeedData feedData) {
        LikeData likeData;
        if (FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType())) {
            this.dsN.setVisibility(8);
            List<LikeData> praiseList = feedData.getPraiseList();
            if (praiseList != null && praiseList.size() > 0 && (likeData = praiseList.get(0)) != null) {
                this.ahN.setText(likeData.getNameShow());
                this.dsM.setVisibility(8);
                this.bLH.setText(com.baidu.tbadk.core.util.ba.t(feedData.getTime()));
                if (praiseList.size() > 3 && praiseList.get(1) != null && praiseList.get(2) != null) {
                    this.baU.setText(String.format(getString(t.j.message_praise_like_list_more), likeData.getNameShow(), praiseList.get(1).getNameShow(), praiseList.get(2).getNameShow(), String.valueOf(feedData.getPraiseNum())));
                } else if (praiseList.size() > 2 && praiseList.get(1) != null && praiseList.get(2) != null) {
                    this.baU.setText(String.format(getString(t.j.message_praise_like_list_3), likeData.getNameShow(), praiseList.get(1).getNameShow(), praiseList.get(2).getNameShow()));
                } else if (praiseList.size() > 1 && praiseList.get(1) != null) {
                    this.baU.setText(String.format(getString(t.j.message_praise_like_list_2), likeData.getNameShow(), praiseList.get(1).getNameShow()));
                } else {
                    this.baU.setText(String.format(getString(t.j.message_praise_like_list_1), likeData.getNameShow()));
                }
                this.aYh.setText(this.bKX.getPageActivity().getString(t.j.mention_replyme_original, new Object[]{feedData.getTitle()}));
                if (feedData.getThread_Type() == 33) {
                    this.aYh.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.av.getDrawable(t.f.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
                } else {
                    this.aYh.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (feedData.getFname() != null && feedData.getFname().length() > 0) {
                    this.bmz.setVisibility(0);
                    this.bmz.setText(com.baidu.tbadk.core.util.ba.j(feedData.getFname(), 12).concat(getString(t.j.forum)));
                } else {
                    this.bmz.setVisibility(8);
                }
                this.bSr.setVisibility(0);
                this.bSr.c(likeData.getPortrait(), 12, false);
            }
        }
    }

    private void c(FeedData feedData) {
        LikeData likeData;
        String string;
        String string2;
        String string3;
        String string4;
        this.dsN.setVisibility(8);
        List<LikeData> praiseList = feedData.getPraiseList();
        if (praiseList != null && praiseList.size() > 0 && (likeData = praiseList.get(0)) != null) {
            this.ahN.setText(likeData.getNameShow());
            this.dsM.setVisibility(8);
            this.bLH.setText(com.baidu.tbadk.core.util.ba.t(feedData.getTime()));
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
                objArr[3] = com.baidu.tbadk.core.util.ba.A(feedData.getPraiseNum());
                this.baU.setText(String.format(string4, objArr));
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
                this.baU.setText(String.format(string3, objArr2));
            } else if (praiseList.size() > 1 && praiseList.get(1) != null) {
                if (feedData.isAuthor()) {
                    string2 = getString(t.j.message_praise_graffiti_author_list_2);
                } else {
                    string2 = getString(t.j.message_praise_graffiti_list_2);
                }
                Object[] objArr3 = new Object[2];
                objArr3[0] = StringUtils.isNull(likeData.getNameShow()) ? likeData.getName() : likeData.getNameShow();
                objArr3[1] = StringUtils.isNull(praiseList.get(1).getNameShow()) ? praiseList.get(1).getName() : praiseList.get(1).getNameShow();
                this.baU.setText(String.format(string2, objArr3));
            } else {
                if (feedData.isAuthor()) {
                    string = getString(t.j.message_praise_graffiti_author_list_1);
                } else {
                    string = getString(t.j.message_praise_graffiti_list_1);
                }
                Object[] objArr4 = new Object[1];
                objArr4[0] = StringUtils.isNull(likeData.getNameShow()) ? likeData.getName() : likeData.getNameShow();
                this.baU.setText(String.format(string, objArr4));
            }
            if (feedData.isAuthor()) {
                this.aYh.setText(this.bKX.getPageActivity().getString(t.j.mention_replyme_graffiti_author, new Object[]{feedData.getTitle()}));
            } else {
                this.aYh.setText(this.bKX.getPageActivity().getString(t.j.mention_replyme_graffiti_landlord, new Object[]{feedData.getTitle()}));
            }
            if (feedData.getThread_Type() == 33) {
                this.aYh.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.av.getDrawable(t.f.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.aYh.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            if (feedData.getFname() != null && feedData.getFname().length() > 0) {
                this.bmz.setVisibility(0);
                this.bmz.setText(com.baidu.tbadk.core.util.ba.j(feedData.getFname(), 12).concat(getString(t.j.forum)));
            } else {
                this.bmz.setVisibility(8);
            }
            this.bSr.setVisibility(0);
            this.bSr.c(likeData.getPortrait(), 12, false);
        }
    }
}
