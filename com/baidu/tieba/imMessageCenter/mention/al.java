package com.baidu.tieba.imMessageCenter.mention;

import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.n;
import java.util.List;
/* loaded from: classes.dex */
public class al extends com.baidu.tbadk.mvc.g.a<FeedData, com.baidu.tbadk.mvc.d.b> {
    private TextView aNz;
    private TextView aOn;
    private TbPageContext<?> aYy;
    private TextView aZi;
    private TextView agS;
    private HeadImageView bcC;
    private TextView ciM;
    private TextView ciN;
    private SpannableString ciO;
    private SpannableString ciP;
    private TextView cif;
    private View mLine;

    public al(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.aYy = tbPageContext;
        this.bcC = (HeadImageView) view.findViewById(n.g.photo);
        this.agS = (TextView) view.findViewById(n.g.user_name);
        this.aZi = (TextView) view.findViewById(n.g.time);
        this.ciM = (TextView) view.findViewById(n.g.add_friend_button);
        this.mLine = view.findViewById(n.g.line);
        this.cif = (TextView) view.findViewById(n.g.content);
        this.aOn = (TextView) view.findViewById(n.g.replyme_title);
        this.aNz = (TextView) view.findViewById(n.g.forum);
        this.ciN = (TextView) view.findViewById(n.g.tv_quick_reply_text);
        this.bcC.setOnClickListener(new am(this));
        this.ciM.setOnClickListener(new an(this));
        view.setOnClickListener(new ao(this));
        this.ciN.setOnClickListener(new ap(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.g.e
    /* renamed from: a */
    public void B(FeedData feedData) {
        LikeData likeData;
        super.B(feedData);
        if (FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType())) {
            this.ciN.setVisibility(8);
            List<LikeData> praiseList = feedData.getPraiseList();
            if (praiseList != null && praiseList.size() > 0 && (likeData = praiseList.get(0)) != null) {
                this.agS.setText(likeData.getNameShow());
                this.ciM.setVisibility(8);
                this.aZi.setText(com.baidu.tbadk.core.util.ax.s(feedData.getTime()));
                if (praiseList.size() > 3 && praiseList.get(1) != null && praiseList.get(2) != null) {
                    this.cif.setText(String.format(getString(n.j.message_praise_like_list_more), likeData.getNameShow(), praiseList.get(1).getNameShow(), praiseList.get(2).getNameShow(), String.valueOf(feedData.getPraiseNum())));
                } else if (praiseList.size() > 2 && praiseList.get(1) != null && praiseList.get(2) != null) {
                    this.cif.setText(String.format(getString(n.j.message_praise_like_list_3), likeData.getNameShow(), praiseList.get(1).getNameShow(), praiseList.get(2).getNameShow()));
                } else if (praiseList.size() > 1 && praiseList.get(1) != null) {
                    this.cif.setText(String.format(getString(n.j.message_praise_like_list_2), likeData.getNameShow(), praiseList.get(1).getNameShow()));
                } else {
                    this.cif.setText(String.format(getString(n.j.message_praise_like_list_1), likeData.getNameShow()));
                }
                this.aOn.setText(this.aYy.getPageActivity().getString(n.j.mention_replyme_original, new Object[]{feedData.getTitle()}));
                if (feedData.getThread_Type() == 33) {
                    this.aOn.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.as.getDrawable(n.f.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
                } else {
                    this.aOn.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (feedData.getFname() != null && feedData.getFname().length() > 0) {
                    this.aNz.setVisibility(0);
                    this.aNz.setText(com.baidu.tbadk.core.util.ax.i(feedData.getFname(), 12).concat(getString(n.j.forum)));
                } else {
                    this.aNz.setVisibility(8);
                }
                this.bcC.setVisibility(0);
                this.bcC.d(likeData.getPortrait(), 12, false);
                return;
            }
            return;
        }
        this.ciN.setVisibility(0);
        this.ciN.setTag(Integer.valueOf(this.position));
        if (feedData.getReplyer() != null) {
            this.agS.setText(feedData.getReplyer().getName_show());
            if (feedData.getReplyer().getIsMyFriend() == 1) {
                this.ciM.setVisibility(0);
                this.ciM.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                this.ciM.setTextColor(com.baidu.tbadk.core.util.as.getColor(n.d.cp_cont_i));
                this.ciM.setBackgroundDrawable(com.baidu.tbadk.core.util.as.getDrawable(n.f.game_center_start_btn));
                this.ciM.setText(getString(n.j.mention_chatme));
            } else {
                this.ciM.setVisibility(0);
                this.ciM.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                this.ciM.setTextColor(com.baidu.tbadk.core.util.as.getColor(n.d.cp_cont_i));
                this.ciM.setBackgroundDrawable(com.baidu.tbadk.core.util.as.getDrawable(n.f.game_center_start_btn));
                this.ciM.setText(getString(n.j.mention_chatme));
            }
            this.aZi.setText(com.baidu.tbadk.core.util.ax.s(feedData.getTime()));
            this.ciO = TbFaceManager.CL().a(this.aYy.getPageActivity().getApplicationContext(), feedData.getContent(), null);
            this.cif.setText(a(this.cif, this.ciO));
            if (feedData.getThread_Type() == 33) {
                this.aOn.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.as.getDrawable(n.f.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                this.aOn.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            if (feedData.getType() == 1) {
                this.ciP = TbFaceManager.CL().a(this.aYy.getPageActivity().getApplicationContext(), this.aYy.getPageActivity().getString(n.j.mention_replyme_original, new Object[]{feedData.getQuote_content()}), null);
                this.aOn.setText(a(this.aOn, this.ciP));
            } else {
                this.aOn.setText(this.aYy.getPageActivity().getString(n.j.mention_replyme_original, new Object[]{feedData.getTitle()}));
            }
            if (feedData.getFname() != null && feedData.getFname().length() > 0) {
                this.aNz.setVisibility(0);
                this.aNz.setText(com.baidu.tbadk.core.util.ax.i(feedData.getFname(), 12).concat(getString(n.j.forum)));
            } else {
                this.aNz.setVisibility(8);
            }
            this.bcC.setVisibility(0);
            String portrait = feedData.getReplyer().getPortrait();
            this.bcC.setTag(null);
            this.bcC.d(portrait, 12, false);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.t
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.core.util.as.i(getRootView(), n.f.list_selector);
        com.baidu.tbadk.core.util.as.j(this.mLine, n.d.cp_bg_line_b);
        this.cif.setTextColor(com.baidu.tbadk.core.util.as.getColor(n.d.cp_cont_b));
        this.aZi.setTextColor(com.baidu.tbadk.core.util.as.getColor(n.d.cp_cont_d));
        this.agS.setTextColor(com.baidu.tbadk.core.util.as.getColor(n.d.cp_cont_f));
        this.aNz.setTextColor(com.baidu.tbadk.core.util.as.getColor(n.d.cp_cont_d));
        this.aOn.setTextColor(com.baidu.tbadk.core.util.as.getColor(n.d.cp_cont_c));
        com.baidu.tbadk.core.util.as.b(this.ciN, n.d.cp_cont_c, 1);
        this.ciN.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.as.getDrawable(n.f.icon_reply_n), (Drawable) null, (Drawable) null, (Drawable) null);
        com.baidu.tbadk.core.util.as.i((View) this.aOn, n.f.bg_ta_dialog_content);
        return true;
    }

    private CharSequence a(TextView textView, SpannableString spannableString) {
        if (textView == null || spannableString == null || this.aYy == null) {
            return null;
        }
        return TextUtils.ellipsize(spannableString, textView.getPaint(), (com.baidu.adp.lib.util.k.K(this.aYy.getPageActivity()) - (this.aYy.getResources().getDimensionPixelSize(n.e.ds30) * 2)) - textView.getCompoundPaddingLeft(), TextUtils.TruncateAt.END);
    }
}
