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
public class am extends com.baidu.tbadk.mvc.g.a<FeedData, com.baidu.tbadk.mvc.d.b> {
    private TextView aRQ;
    private TextView aSh;
    private TextView ahM;
    private View amH;
    private TbPageContext<?> bfx;
    private TextView bgh;
    private HeadImageView bjG;
    private TextView cxO;
    private TextView cxP;
    private SpannableString cxQ;
    private SpannableString cxR;
    private TextView cxh;

    public am(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.bfx = tbPageContext;
        this.bjG = (HeadImageView) view.findViewById(t.g.photo);
        this.ahM = (TextView) view.findViewById(t.g.user_name);
        this.bgh = (TextView) view.findViewById(t.g.time);
        this.cxO = (TextView) view.findViewById(t.g.add_friend_button);
        this.amH = view.findViewById(t.g.line);
        this.cxh = (TextView) view.findViewById(t.g.content);
        this.aSh = (TextView) view.findViewById(t.g.replyme_title);
        this.aRQ = (TextView) view.findViewById(t.g.forum);
        this.cxP = (TextView) view.findViewById(t.g.tv_quick_reply_text);
        this.bjG.setOnClickListener(new an(this));
        this.cxO.setOnClickListener(new ao(this));
        view.setOnClickListener(new ap(this));
        this.cxP.setOnClickListener(new aq(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void B(FeedData feedData) {
        super.B(feedData);
        if (FeedData.TYPE_GRAFFITI.equals(feedData.getPraiseItemType()) || FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType())) {
            if (com.baidu.tieba.graffiti.d.Yf()) {
                c(feedData);
                return;
            } else if (com.baidu.tieba.graffiti.d.af(null)) {
                b(feedData);
                return;
            } else {
                return;
            }
        }
        this.cxP.setVisibility(0);
        this.cxP.setTag(Integer.valueOf(this.position));
        if (feedData.getReplyer() != null) {
            this.ahM.setText(feedData.getReplyer().getName_show());
            if (feedData.getReplyer().getIsMyFriend() == 1) {
                this.cxO.setVisibility(0);
                this.cxO.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                this.cxO.setTextColor(com.baidu.tbadk.core.util.at.getColor(t.d.cp_cont_i));
                this.cxO.setBackgroundDrawable(com.baidu.tbadk.core.util.at.getDrawable(t.f.game_center_start_btn));
                this.cxO.setText(getString(t.j.mention_chatme));
            } else {
                this.cxO.setVisibility(0);
                this.cxO.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                this.cxO.setTextColor(com.baidu.tbadk.core.util.at.getColor(t.d.cp_cont_i));
                this.cxO.setBackgroundDrawable(com.baidu.tbadk.core.util.at.getDrawable(t.f.game_center_start_btn));
                this.cxO.setText(getString(t.j.mention_chatme));
            }
            this.bgh.setText(com.baidu.tbadk.core.util.ay.w(feedData.getTime()));
            this.cxQ = TbFaceManager.EN().a(this.bfx.getPageActivity().getApplicationContext(), feedData.getContent(), null);
            this.cxh.setText(a(this.cxh, this.cxQ));
            if (feedData.getThread_Type() == 33) {
                this.aSh.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.at.getDrawable(t.f.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.aSh.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            if (feedData.getType() == 1) {
                this.cxR = TbFaceManager.EN().a(this.bfx.getPageActivity().getApplicationContext(), this.bfx.getPageActivity().getString(t.j.mention_replyme_original, new Object[]{feedData.getQuote_content()}), null);
                this.aSh.setText(a(this.aSh, this.cxR));
            } else {
                this.aSh.setText(this.bfx.getPageActivity().getString(t.j.mention_replyme_original, new Object[]{feedData.getTitle()}));
            }
            if (feedData.getFname() != null && feedData.getFname().length() > 0) {
                this.aRQ.setVisibility(0);
                this.aRQ.setText(com.baidu.tbadk.core.util.ay.j(feedData.getFname(), 12).concat(getString(t.j.forum)));
            } else {
                this.aRQ.setVisibility(8);
            }
            this.bjG.setVisibility(0);
            String portrait = feedData.getReplyer().getPortrait();
            this.bjG.setTag(null);
            this.bjG.c(portrait, 12, false);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.core.util.at.k(getRootView(), t.f.list_selector);
        com.baidu.tbadk.core.util.at.l(this.amH, t.d.cp_bg_line_b);
        this.cxh.setTextColor(com.baidu.tbadk.core.util.at.getColor(t.d.cp_cont_b));
        this.bgh.setTextColor(com.baidu.tbadk.core.util.at.getColor(t.d.cp_cont_d));
        this.ahM.setTextColor(com.baidu.tbadk.core.util.at.getColor(t.d.cp_cont_f));
        this.aRQ.setTextColor(com.baidu.tbadk.core.util.at.getColor(t.d.cp_cont_d));
        this.aSh.setTextColor(com.baidu.tbadk.core.util.at.getColor(t.d.cp_cont_c));
        com.baidu.tbadk.core.util.at.b(this.cxP, t.d.cp_cont_c, 1);
        this.cxP.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.at.getDrawable(t.f.icon_reply_n), (Drawable) null, (Drawable) null, (Drawable) null);
        com.baidu.tbadk.core.util.at.k(this.aSh, t.f.bg_ta_dialog_content);
        return true;
    }

    private CharSequence a(TextView textView, SpannableString spannableString) {
        if (textView == null || spannableString == null || this.bfx == null) {
            return null;
        }
        return TextUtils.ellipsize(spannableString, textView.getPaint(), (com.baidu.adp.lib.util.k.B(this.bfx.getPageActivity()) - (this.bfx.getResources().getDimensionPixelSize(t.e.ds30) * 2)) - textView.getCompoundPaddingLeft(), TextUtils.TruncateAt.END);
    }

    private void b(FeedData feedData) {
        LikeData likeData;
        if (FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType())) {
            this.cxP.setVisibility(8);
            List<LikeData> praiseList = feedData.getPraiseList();
            if (praiseList != null && praiseList.size() > 0 && (likeData = praiseList.get(0)) != null) {
                this.ahM.setText(likeData.getNameShow());
                this.cxO.setVisibility(8);
                this.bgh.setText(com.baidu.tbadk.core.util.ay.w(feedData.getTime()));
                if (praiseList.size() > 3 && praiseList.get(1) != null && praiseList.get(2) != null) {
                    this.cxh.setText(String.format(getString(t.j.message_praise_like_list_more), likeData.getNameShow(), praiseList.get(1).getNameShow(), praiseList.get(2).getNameShow(), String.valueOf(feedData.getPraiseNum())));
                } else if (praiseList.size() > 2 && praiseList.get(1) != null && praiseList.get(2) != null) {
                    this.cxh.setText(String.format(getString(t.j.message_praise_like_list_3), likeData.getNameShow(), praiseList.get(1).getNameShow(), praiseList.get(2).getNameShow()));
                } else if (praiseList.size() > 1 && praiseList.get(1) != null) {
                    this.cxh.setText(String.format(getString(t.j.message_praise_like_list_2), likeData.getNameShow(), praiseList.get(1).getNameShow()));
                } else {
                    this.cxh.setText(String.format(getString(t.j.message_praise_like_list_1), likeData.getNameShow()));
                }
                this.aSh.setText(this.bfx.getPageActivity().getString(t.j.mention_replyme_original, new Object[]{feedData.getTitle()}));
                if (feedData.getThread_Type() == 33) {
                    this.aSh.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.at.getDrawable(t.f.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
                } else {
                    this.aSh.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (feedData.getFname() != null && feedData.getFname().length() > 0) {
                    this.aRQ.setVisibility(0);
                    this.aRQ.setText(com.baidu.tbadk.core.util.ay.j(feedData.getFname(), 12).concat(getString(t.j.forum)));
                } else {
                    this.aRQ.setVisibility(8);
                }
                this.bjG.setVisibility(0);
                this.bjG.c(likeData.getPortrait(), 12, false);
            }
        }
    }

    private void c(FeedData feedData) {
        LikeData likeData;
        String string;
        String string2;
        String string3;
        String string4;
        this.cxP.setVisibility(8);
        List<LikeData> praiseList = feedData.getPraiseList();
        if (praiseList != null && praiseList.size() > 0 && (likeData = praiseList.get(0)) != null) {
            this.ahM.setText(likeData.getNameShow());
            this.cxO.setVisibility(8);
            this.bgh.setText(com.baidu.tbadk.core.util.ay.w(feedData.getTime()));
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
                objArr[3] = com.baidu.tbadk.core.util.ay.B(feedData.getPraiseNum());
                this.cxh.setText(String.format(string4, objArr));
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
                this.cxh.setText(String.format(string3, objArr2));
            } else if (praiseList.size() > 1 && praiseList.get(1) != null) {
                if (feedData.isAuthor()) {
                    string2 = getString(t.j.message_praise_graffiti_author_list_2);
                } else {
                    string2 = getString(t.j.message_praise_graffiti_list_2);
                }
                Object[] objArr3 = new Object[2];
                objArr3[0] = StringUtils.isNull(likeData.getNameShow()) ? likeData.getName() : likeData.getNameShow();
                objArr3[1] = StringUtils.isNull(praiseList.get(1).getNameShow()) ? praiseList.get(1).getName() : praiseList.get(1).getNameShow();
                this.cxh.setText(String.format(string2, objArr3));
            } else {
                if (feedData.isAuthor()) {
                    string = getString(t.j.message_praise_graffiti_author_list_1);
                } else {
                    string = getString(t.j.message_praise_graffiti_list_1);
                }
                Object[] objArr4 = new Object[1];
                objArr4[0] = StringUtils.isNull(likeData.getNameShow()) ? likeData.getName() : likeData.getNameShow();
                this.cxh.setText(String.format(string, objArr4));
            }
            if (feedData.isAuthor()) {
                this.aSh.setText(this.bfx.getPageActivity().getString(t.j.mention_replyme_graffiti_author, new Object[]{feedData.getTitle()}));
            } else {
                this.aSh.setText(this.bfx.getPageActivity().getString(t.j.mention_replyme_graffiti_landlord, new Object[]{feedData.getTitle()}));
            }
            if (feedData.getThread_Type() == 33) {
                this.aSh.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.at.getDrawable(t.f.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.aSh.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            if (feedData.getFname() != null && feedData.getFname().length() > 0) {
                this.aRQ.setVisibility(0);
                this.aRQ.setText(com.baidu.tbadk.core.util.ay.j(feedData.getFname(), 12).concat(getString(t.j.forum)));
            } else {
                this.aRQ.setVisibility(8);
            }
            this.bjG.setVisibility(0);
            this.bjG.c(likeData.getPortrait(), 12, false);
        }
    }
}
