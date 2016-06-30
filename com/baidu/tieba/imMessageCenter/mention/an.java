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
import com.baidu.tieba.u;
import java.util.List;
/* loaded from: classes.dex */
public class an extends com.baidu.tbadk.mvc.g.a<FeedData, com.baidu.tbadk.mvc.d.b> {
    private TextView aSd;
    private TextView aee;
    private View aja;
    private HeadImageView bBS;
    private TextView bad;
    private TextView bxR;
    private TbPageContext<?> bxh;
    private TextView ddB;
    private TextView dej;
    private TextView dek;
    private SpannableString del;
    private SpannableString dem;

    public an(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.bxh = tbPageContext;
        this.bBS = (HeadImageView) view.findViewById(u.g.photo);
        this.aee = (TextView) view.findViewById(u.g.user_name);
        this.bxR = (TextView) view.findViewById(u.g.time);
        this.dej = (TextView) view.findViewById(u.g.add_friend_button);
        this.aja = view.findViewById(u.g.line);
        this.ddB = (TextView) view.findViewById(u.g.content);
        this.aSd = (TextView) view.findViewById(u.g.replyme_title);
        this.bad = (TextView) view.findViewById(u.g.forum);
        this.dek = (TextView) view.findViewById(u.g.tv_quick_reply_text);
        this.bBS.setOnClickListener(new ao(this));
        this.dej.setOnClickListener(new ap(this));
        view.setOnClickListener(new aq(this));
        this.dek.setOnClickListener(new ar(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void B(FeedData feedData) {
        super.B(feedData);
        if (FeedData.TYPE_GRAFFITI.equals(feedData.getPraiseItemType()) || FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType())) {
            if (com.baidu.tieba.graffiti.d.aet()) {
                c(feedData);
                return;
            } else if (com.baidu.tieba.graffiti.d.an(null)) {
                b(feedData);
                return;
            } else {
                return;
            }
        }
        this.dek.setVisibility(0);
        this.dek.setTag(Integer.valueOf(this.position));
        if (feedData.getReplyer() != null) {
            this.aee.setText(feedData.getReplyer().getName_show());
            if (feedData.getReplyer().getIsMyFriend() == 1) {
                this.dej.setVisibility(0);
                this.dej.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                this.dej.setTextColor(com.baidu.tbadk.core.util.av.getColor(u.d.cp_cont_i));
                this.dej.setBackgroundDrawable(com.baidu.tbadk.core.util.av.getDrawable(u.f.game_center_start_btn));
                this.dej.setText(getString(u.j.mention_chatme));
            } else {
                this.dej.setVisibility(0);
                this.dej.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                this.dej.setTextColor(com.baidu.tbadk.core.util.av.getColor(u.d.cp_cont_i));
                this.dej.setBackgroundDrawable(com.baidu.tbadk.core.util.av.getDrawable(u.f.game_center_start_btn));
                this.dej.setText(getString(u.j.mention_chatme));
            }
            this.bxR.setText(com.baidu.tbadk.core.util.ba.y(feedData.getTime()));
            this.del = TbFaceManager.CP().a(this.bxh.getPageActivity().getApplicationContext(), feedData.getContent(), null);
            this.ddB.setText(a(this.ddB, this.del));
            if (feedData.getThread_Type() == 33) {
                this.aSd.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.av.getDrawable(u.f.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.aSd.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            if (feedData.getType() == 1) {
                this.dem = TbFaceManager.CP().a(this.bxh.getPageActivity().getApplicationContext(), this.bxh.getPageActivity().getString(u.j.mention_replyme_original, new Object[]{feedData.getQuote_content()}), null);
                this.aSd.setText(a(this.aSd, this.dem));
            } else {
                this.aSd.setText(this.bxh.getPageActivity().getString(u.j.mention_replyme_original, new Object[]{feedData.getTitle()}));
            }
            if (feedData.getFname() != null && feedData.getFname().length() > 0) {
                this.bad.setVisibility(0);
                this.bad.setText(com.baidu.tbadk.core.util.ba.j(feedData.getFname(), 12).concat(getString(u.j.forum)));
            } else {
                this.bad.setVisibility(8);
            }
            this.bBS.setVisibility(0);
            String portrait = feedData.getReplyer().getPortrait();
            this.bBS.setTag(null);
            this.bBS.c(portrait, 12, false);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.t
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.core.util.av.k(getRootView(), u.f.list_selector);
        com.baidu.tbadk.core.util.av.l(this.aja, u.d.cp_bg_line_b);
        this.ddB.setTextColor(com.baidu.tbadk.core.util.av.getColor(u.d.cp_cont_b));
        this.bxR.setTextColor(com.baidu.tbadk.core.util.av.getColor(u.d.cp_cont_d));
        this.aee.setTextColor(com.baidu.tbadk.core.util.av.getColor(u.d.cp_cont_f));
        this.bad.setTextColor(com.baidu.tbadk.core.util.av.getColor(u.d.cp_cont_d));
        this.aSd.setTextColor(com.baidu.tbadk.core.util.av.getColor(u.d.cp_cont_c));
        com.baidu.tbadk.core.util.av.c(this.dek, u.d.cp_cont_c, 1);
        this.dek.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.av.getDrawable(u.f.icon_reply_n), (Drawable) null, (Drawable) null, (Drawable) null);
        com.baidu.tbadk.core.util.av.k(this.aSd, u.f.bg_ta_dialog_content);
        return true;
    }

    private CharSequence a(TextView textView, SpannableString spannableString) {
        if (textView == null || spannableString == null || this.bxh == null) {
            return null;
        }
        return TextUtils.ellipsize(spannableString, textView.getPaint(), (com.baidu.adp.lib.util.k.A(this.bxh.getPageActivity()) - (this.bxh.getResources().getDimensionPixelSize(u.e.ds30) * 2)) - textView.getCompoundPaddingLeft(), TextUtils.TruncateAt.END);
    }

    private void b(FeedData feedData) {
        LikeData likeData;
        if (FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType())) {
            this.dek.setVisibility(8);
            List<LikeData> praiseList = feedData.getPraiseList();
            if (praiseList != null && praiseList.size() > 0 && (likeData = praiseList.get(0)) != null) {
                this.aee.setText(likeData.getNameShow());
                this.dej.setVisibility(8);
                this.bxR.setText(com.baidu.tbadk.core.util.ba.y(feedData.getTime()));
                if (praiseList.size() > 3 && praiseList.get(1) != null && praiseList.get(2) != null) {
                    this.ddB.setText(String.format(getString(u.j.message_praise_like_list_more), likeData.getNameShow(), praiseList.get(1).getNameShow(), praiseList.get(2).getNameShow(), String.valueOf(feedData.getPraiseNum())));
                } else if (praiseList.size() > 2 && praiseList.get(1) != null && praiseList.get(2) != null) {
                    this.ddB.setText(String.format(getString(u.j.message_praise_like_list_3), likeData.getNameShow(), praiseList.get(1).getNameShow(), praiseList.get(2).getNameShow()));
                } else if (praiseList.size() > 1 && praiseList.get(1) != null) {
                    this.ddB.setText(String.format(getString(u.j.message_praise_like_list_2), likeData.getNameShow(), praiseList.get(1).getNameShow()));
                } else {
                    this.ddB.setText(String.format(getString(u.j.message_praise_like_list_1), likeData.getNameShow()));
                }
                this.aSd.setText(this.bxh.getPageActivity().getString(u.j.mention_replyme_original, new Object[]{feedData.getTitle()}));
                if (feedData.getThread_Type() == 33) {
                    this.aSd.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.av.getDrawable(u.f.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
                } else {
                    this.aSd.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (feedData.getFname() != null && feedData.getFname().length() > 0) {
                    this.bad.setVisibility(0);
                    this.bad.setText(com.baidu.tbadk.core.util.ba.j(feedData.getFname(), 12).concat(getString(u.j.forum)));
                } else {
                    this.bad.setVisibility(8);
                }
                this.bBS.setVisibility(0);
                this.bBS.c(likeData.getPortrait(), 12, false);
            }
        }
    }

    private void c(FeedData feedData) {
        LikeData likeData;
        String string;
        String string2;
        String string3;
        String string4;
        this.dek.setVisibility(8);
        List<LikeData> praiseList = feedData.getPraiseList();
        if (praiseList != null && praiseList.size() > 0 && (likeData = praiseList.get(0)) != null) {
            this.aee.setText(likeData.getNameShow());
            this.dej.setVisibility(8);
            this.bxR.setText(com.baidu.tbadk.core.util.ba.y(feedData.getTime()));
            if (praiseList.size() > 3 && praiseList.get(1) != null && praiseList.get(2) != null) {
                if (feedData.isAuthor()) {
                    string4 = getString(u.j.message_praise_graffiti_author_list_more);
                } else {
                    string4 = getString(u.j.message_praise_graffiti_list_more);
                }
                Object[] objArr = new Object[4];
                objArr[0] = StringUtils.isNull(likeData.getNameShow()) ? likeData.getName() : likeData.getNameShow();
                objArr[1] = StringUtils.isNull(praiseList.get(1).getNameShow()) ? praiseList.get(1).getName() : praiseList.get(1).getNameShow();
                objArr[2] = StringUtils.isNull(praiseList.get(2).getNameShow()) ? praiseList.get(2).getName() : praiseList.get(2).getNameShow();
                objArr[3] = com.baidu.tbadk.core.util.ba.E(feedData.getPraiseNum());
                this.ddB.setText(String.format(string4, objArr));
            } else if (praiseList.size() > 2 && praiseList.get(1) != null && praiseList.get(2) != null) {
                if (feedData.isAuthor()) {
                    string3 = getString(u.j.message_praise_graffiti_author_list_3);
                } else {
                    string3 = getString(u.j.message_praise_graffiti_list_3);
                }
                Object[] objArr2 = new Object[3];
                objArr2[0] = StringUtils.isNull(likeData.getNameShow()) ? likeData.getName() : likeData.getNameShow();
                objArr2[1] = StringUtils.isNull(praiseList.get(1).getNameShow()) ? praiseList.get(1).getName() : praiseList.get(1).getNameShow();
                objArr2[2] = StringUtils.isNull(praiseList.get(2).getNameShow()) ? praiseList.get(2).getName() : praiseList.get(2).getNameShow();
                this.ddB.setText(String.format(string3, objArr2));
            } else if (praiseList.size() > 1 && praiseList.get(1) != null) {
                if (feedData.isAuthor()) {
                    string2 = getString(u.j.message_praise_graffiti_author_list_2);
                } else {
                    string2 = getString(u.j.message_praise_graffiti_list_2);
                }
                Object[] objArr3 = new Object[2];
                objArr3[0] = StringUtils.isNull(likeData.getNameShow()) ? likeData.getName() : likeData.getNameShow();
                objArr3[1] = StringUtils.isNull(praiseList.get(1).getNameShow()) ? praiseList.get(1).getName() : praiseList.get(1).getNameShow();
                this.ddB.setText(String.format(string2, objArr3));
            } else {
                if (feedData.isAuthor()) {
                    string = getString(u.j.message_praise_graffiti_author_list_1);
                } else {
                    string = getString(u.j.message_praise_graffiti_list_1);
                }
                Object[] objArr4 = new Object[1];
                objArr4[0] = StringUtils.isNull(likeData.getNameShow()) ? likeData.getName() : likeData.getNameShow();
                this.ddB.setText(String.format(string, objArr4));
            }
            if (feedData.isAuthor()) {
                this.aSd.setText(this.bxh.getPageActivity().getString(u.j.mention_replyme_graffiti_author, new Object[]{feedData.getTitle()}));
            } else {
                this.aSd.setText(this.bxh.getPageActivity().getString(u.j.mention_replyme_graffiti_landlord, new Object[]{feedData.getTitle()}));
            }
            if (feedData.getThread_Type() == 33) {
                this.aSd.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.av.getDrawable(u.f.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.aSd.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            if (feedData.getFname() != null && feedData.getFname().length() > 0) {
                this.bad.setVisibility(0);
                this.bad.setText(com.baidu.tbadk.core.util.ba.j(feedData.getFname(), 12).concat(getString(u.j.forum)));
            } else {
                this.bad.setVisibility(8);
            }
            this.bBS.setVisibility(0);
            this.bBS.c(likeData.getPortrait(), 12, false);
        }
    }
}
