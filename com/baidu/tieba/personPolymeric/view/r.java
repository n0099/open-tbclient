package com.baidu.tieba.personPolymeric.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.UserVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.view.PersonHeaderAttentionView;
import java.util.List;
import tbclient.Profile.ForumGodDetailInfo;
import tbclient.Profile.UserAgreeInfo;
/* loaded from: classes.dex */
public class r {
    private static final int[] frG = {d.g.img_gift_one, d.g.img_gift_two, d.g.img_gift_three};
    protected TextView aoD;
    private com.baidu.tbadk.core.view.userLike.c bRI;
    private TextView bvd;
    private TextView cVA;
    private View dfj;
    protected PersonHeadPendantView fjO;
    protected TbImageView fjP;
    protected com.baidu.tieba.view.h frE;
    protected com.baidu.tieba.personPolymeric.c.a frF;
    protected UserIconBox frH;
    protected TextView frI;
    protected TextView frJ;
    public com.baidu.tieba.view.f frK;
    protected View frL;
    private TextView frM;
    private TextView frN;
    private TextView frO;
    private View frP;
    private View frQ;
    private View frR;
    private View frS;
    private LinearLayout frT;
    private TextView frU;
    private q frV;
    private TextView frW;
    private BlueLikeButton frX;
    private LinearLayout frY;
    private RelativeLayout frZ;
    private View fsa;
    private TextView fsb;
    private TextView fsc;
    protected Context mContext;
    protected boolean mIsHost;
    private TbPageContext mPageContext;
    protected View mRootView;
    protected UserData mUserData;

    public r(TbPageContext tbPageContext, boolean z) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.mIsHost = z;
        Z(Yn());
        TextView textView = this.frI;
        if (this.mIsHost) {
        }
        textView.setVisibility(8);
    }

    public View Yn() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(d.h.item_person_polymeric_header_view, (ViewGroup) null);
        }
        return this.mRootView;
    }

    public void Z(View view) {
        this.frL = view.findViewById(d.g.person_info_root);
        this.fjO = (PersonHeadPendantView) view.findViewById(d.g.person_polymeric_header_user_img);
        this.fjO.getHeadView().setCustomBigViewIconId(d.f.pic_v_avatar_big);
        this.fjO.getHeadView().setIconWidth(this.mContext.getResources().getDimensionPixelSize(d.e.ds40));
        this.fjP = (TbImageView) view.findViewById(d.g.person_polymeric_header_user_vip_icon);
        this.aoD = (TextView) view.findViewById(d.g.person_polymeric_header_user_name_txt);
        this.frJ = (TextView) view.findViewById(d.g.seal_prefix_view);
        this.frH = (UserIconBox) view.findViewById(d.g.person_polymeric_header_label_box);
        this.frM = (TextView) view.findViewById(d.g.person_polymeric_header_bar_age_txt);
        this.bvd = (TextView) view.findViewById(d.g.person_polymeric_header_ala_id);
        this.frP = view.findViewById(d.g.divider_for_alaid_and_age);
        this.frI = (TextView) view.findViewById(d.g.person_polymeric_header_visitor_txt);
        this.frN = (TextView) view.findViewById(d.g.person_polymeric_header_sign_txt);
        this.frO = (TextView) view.findViewById(d.g.person_center_header_tdou_txt);
        this.cVA = (TextView) view.findViewById(d.g.textview_get_tdou);
        this.frR = view.findViewById(d.g.divider_for_age_and_tdou);
        this.frS = view.findViewById(d.g.divider_for_tdou_and_get_tdou);
        this.frT = (LinearLayout) view.findViewById(d.g.layout_user_name);
        this.frU = (TextView) view.findViewById(d.g.person_praise_number);
        this.frO.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(d.f.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
        this.frK = (PersonHeaderAttentionView) view.findViewById(d.g.person_center_header_attention_container);
        bas();
        this.frV = new q(this.mContext);
        this.fjP.setOnClickListener(this.frV);
        this.frH.setOnClickListener(this.frV);
        this.fjO.setOnClickListener(this.frV);
        this.frI.setOnClickListener(this.frV);
        this.frJ.setOnClickListener(this.frV);
        this.frO.setOnClickListener(this.frV);
        this.cVA.setOnClickListener(this.frV);
        this.aoD.setOnClickListener(this.frV);
        this.frN.setOnClickListener(this.frV);
        this.frW = (TextView) view.findViewById(d.g.btn_give_gift);
        this.frW.setOnClickListener(this.frV);
        this.frX = (BlueLikeButton) view.findViewById(d.g.btn_like_blue);
        this.bRI = new com.baidu.tbadk.core.view.userLike.c(this.mPageContext, this.frX);
        this.bRI.setFromType("2");
        if (this.mIsHost) {
            this.frW.setVisibility(8);
            this.frX.setVisibility(8);
        }
        this.frY = (LinearLayout) view.findViewById(d.g.layout_god_auth_forums);
        this.frY.setVisibility(8);
        this.dfj = view.findViewById(d.g.header_bottom_divider);
        this.frZ = (RelativeLayout) view.findViewById(d.g.layout_gift);
        this.frZ.setOnClickListener(this.frV);
        this.fsa = view.findViewById(d.g.gift_top_divider);
        this.fsb = (TextView) view.findViewById(d.g.textview_received_gift);
        this.fsc = (TextView) view.findViewById(d.g.textview_received_gift_num);
    }

    public void e(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null) {
            this.frF = aVar;
            this.mUserData = aVar.getUserData();
            this.frV.a(aVar);
            this.frV.setIsHost(this.mIsHost);
            String portrait = this.mUserData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                String dE = com.baidu.tbadk.core.util.o.dE(portrait);
                this.fjO.getHeadView().setUrl(dE);
                this.fjO.getHeadView().startLoad(dE, 25, false);
            } else {
                this.fjO.getHeadView().startLoad(String.valueOf(d.f.pic_mycenter_avatar_def_i), 24, false);
            }
            com.baidu.tbadk.data.k pendantData = this.mUserData.getPendantData();
            if (pendantData != null) {
                this.fjO.en(pendantData.pQ());
            }
            if (this.fjO.wf()) {
                this.fjO.getHeadView().setShowV(false);
            } else if (this.mUserData.isBigV() || !StringUtils.isNull(this.mUserData.getUserTbVipInfoData().getvipV_url())) {
                this.fjO.getHeadView().setShowV(true);
            } else {
                this.fjO.getHeadView().setShowV(false);
            }
            UserVipInfoData userVipInfo = this.mUserData.getUserVipInfo();
            if (this.mUserData.getIsMem() > 0) {
                if (userVipInfo != null) {
                    this.fjP.startLoad(userVipInfo.getVipIconUrl(), 10, false);
                }
                this.fjP.setVisibility(0);
            } else if (this.mIsHost) {
                this.fjP.setImageDrawable(aj.getDrawable(d.f.icon_crown_super_non));
                this.fjP.setVisibility(0);
            } else {
                this.fjP.setVisibility(8);
            }
            aYA();
            String name_show = this.mUserData.getName_show();
            if (!TextUtils.isEmpty(name_show)) {
                this.aoD.setText(name_show);
            }
            int i = d.f.icon_pop_boy;
            if (this.mUserData != null) {
                i = this.mUserData.getSex() == 2 ? d.f.icon_pop_girl : d.f.icon_pop_boy;
            }
            this.aoD.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mContext.getResources().getDrawable(i), (Drawable) null);
            this.frH.a(this.mUserData.getIconInfo(), 9, this.mContext.getResources().getDimensionPixelSize(d.e.ds34), this.mContext.getResources().getDimensionPixelSize(d.e.ds34), this.mContext.getResources().getDimensionPixelSize(d.e.ds10), true);
            if (this.frK != null) {
                this.frK.setData(this.mUserData);
            }
            if (this.mUserData != null && this.mUserData.alaUserData != null && this.mUserData.alaUserData.ala_id != 0) {
                this.bvd.setVisibility(0);
                this.frP.setVisibility(0);
                this.bvd.setText(String.format(this.mContext.getString(d.j.person_center_ala_id), Long.valueOf(this.mUserData.alaUserData.ala_id)));
            } else {
                this.bvd.setVisibility(8);
                this.frP.setVisibility(8);
            }
            this.frM.setText(String.format(this.mContext.getString(d.j.person_center_header_bar_age), this.mUserData.getTb_age()));
            if (this.mIsHost) {
                this.frR.setVisibility(0);
                this.frS.setVisibility(0);
                this.frO.setVisibility(0);
                this.cVA.setVisibility(0);
                this.frO.setText(am.H(this.mUserData.getTDouNum()));
            } else {
                this.frR.setVisibility(8);
                this.frS.setVisibility(8);
                this.frO.setVisibility(8);
                this.cVA.setVisibility(8);
            }
            String intro = this.mUserData.getIntro();
            if (StringUtils.isNull(intro)) {
                aj.c(this.frN, d.C0080d.cp_cont_e, 1);
            } else {
                aj.c(this.frN, d.C0080d.cp_cont_j, 1);
            }
            if (StringUtils.isNull(intro)) {
                if (this.mIsHost) {
                    intro = this.mContext.getString(d.j.no_person_sign_host);
                } else {
                    intro = this.mContext.getString(d.j.no_person_sign_guest);
                }
            }
            this.frN.setText(this.mContext.getString(d.j.person_sign) + intro);
            if (this.frN.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.frN.getLayoutParams();
                if (this.frN.getLineCount() >= 2) {
                    layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(d.e.ds32);
                } else {
                    layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(d.e.ds70);
                }
                this.frN.setLayoutParams(layoutParams);
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(this.mUserData.getUserId()) && (!TbadkCoreApplication.isLogin() || (!StringUtils.isNull(currentAccount) && !currentAccount.equals(this.mUserData.getUserId()) && this.mUserData.getLiveStatus() == 1))) {
                if (this.frQ == null) {
                    this.frQ = com.baidu.tbadk.ala.b.nu().g(this.mContext, 7);
                }
                com.baidu.tbadk.ala.a aVar2 = new com.baidu.tbadk.ala.a();
                aVar2.QK = this.mUserData.getAlaUserData();
                aVar2.type = 7;
                if ((this.mUserData.getPersonPrivate() != null && this.mUserData.getPersonPrivate().Cs() == 3) || (this.mUserData.getPersonPrivate().Cs() == 2 && this.mUserData.getIsFriend() != 1)) {
                    aVar2.QL = true;
                } else {
                    aVar2.QL = false;
                }
                if (this.frQ != null) {
                    this.frQ.setTag(aVar2);
                    if (this.frQ.getParent() == null) {
                        this.frT.addView(this.frQ);
                        TiebaStatic.log(new ak("c12541"));
                    }
                }
            } else if (this.frQ != null) {
                this.frQ.setVisibility(8);
            }
            a(aVar.fpv);
            this.mUserData.setIsLike(this.mUserData.getHave_attention() == 1);
            this.bRI.a(this.mUserData);
            bat();
            bau();
            this.fsb.setText(this.mIsHost ? d.j.my_received_gift : d.j.he_received_gift);
            if ((this.mUserData.getPersonPrivate() == null || this.mUserData.getPersonPrivate().Cs() != 3) && this.mUserData.getPersonPrivate().Cs() == 2 && this.mUserData.getIsFriend() != 1) {
            }
        }
    }

    private void a(UserAgreeInfo userAgreeInfo) {
        if (userAgreeInfo == null) {
            this.frU.setVisibility(8);
            return;
        }
        this.frU.setVisibility(0);
        String A = am.A(userAgreeInfo.total_agree_num.longValue());
        Drawable drawable = aj.getDrawable(d.f.icon_home_card_like_s);
        drawable.setBounds(0, 0, com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds36), com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds36));
        this.frU.setCompoundDrawables(drawable, null, null, null);
        this.frU.setText(A);
    }

    public void onChangeSkinType(int i) {
        this.frL.setBackgroundDrawable(aj.getDrawable(d.f.shape_user_info_bg));
        this.fjO.setBackgroundViewDrawable(aj.getDrawable(d.f.shape_user_img_bg));
        int i2 = d.f.icon_pop_boy;
        if (this.mUserData != null) {
            i2 = this.mUserData.getSex() == 1 ? d.f.icon_pop_boy : d.f.icon_pop_girl;
        }
        if (this.mUserData != null && this.mUserData.getIsMem() <= 0 && this.fjP != null && this.mIsHost) {
            this.fjP.setImageDrawable(aj.getDrawable(d.f.icon_crown_super_non));
        }
        aYA();
        aj.c(this.frJ, d.C0080d.cp_link_tip_a, 1);
        this.aoD.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mContext.getResources().getDrawable(i2), (Drawable) null);
        if (this.frK != null) {
            this.frK.onChangeSkinType(i);
        }
        aj.c(this.frI, d.C0080d.cp_cont_b, 1);
        aj.c(this.frM, d.C0080d.cp_cont_b, 1);
        aj.c(this.bvd, d.C0080d.cp_cont_b, 1);
        if (this.mUserData == null || StringUtils.isNull(this.mUserData.getIntro())) {
            aj.c(this.frN, d.C0080d.cp_cont_e, 1);
        } else {
            aj.c(this.frN, d.C0080d.cp_cont_j, 1);
        }
        aj.c(this.frO, d.C0080d.cp_cont_b, 1);
        aj.c(this.cVA, d.C0080d.cp_cont_b, 1);
        aj.k(this.frR, d.C0080d.cp_bg_line_b);
        aj.k(this.frP, d.C0080d.cp_bg_line_b);
        aj.k(this.frS, d.C0080d.cp_bg_line_b);
        aj.i(this.frU, d.C0080d.cp_cont_h);
        this.frO.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(d.f.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
        Drawable u = aj.u(i, d.f.icon_home_card_like_s);
        u.setBounds(0, 0, com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds36), com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds36));
        this.frU.setCompoundDrawables(u, null, null, null);
        aj.c(this.frW, d.C0080d.selector_give_gift_text_color, 1);
        this.frW.setBackgroundDrawable(aj.getDrawable(d.f.selector_give_gift_bg));
        this.frW.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.selector_gift_icon), (Drawable) null, (Drawable) null, (Drawable) null);
        this.frX.onChangeSkinType(i);
        aj.k(this.dfj, d.C0080d.cp_bg_line_e);
        for (int i3 = 0; i3 < this.frY.getChildCount(); i3++) {
            View childAt = this.frY.getChildAt(i3);
            if (childAt != null) {
                TextView textView = (TextView) childAt.findViewById(d.g.bar_name);
                textView.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(d.f.pic_v_avatar), (Drawable) null, (Drawable) null, (Drawable) null);
                aj.i(textView, d.C0080d.cp_cont_b);
                aj.i((TextView) childAt.findViewById(d.g.bar_info), d.C0080d.cp_cont_j);
            }
        }
        for (int i4 = 0; i4 < frG.length; i4++) {
            ((TbImageView) this.mRootView.findViewById(frG[i4])).setBackgroundDrawable(aj.getDrawable(d.f.shape_gift_icon_bg));
        }
        aj.k(this.fsa, d.C0080d.cp_bg_line_e);
        aj.i(this.fsb, d.C0080d.cp_cont_b);
        aj.i(this.fsc, d.C0080d.cp_cont_d);
    }

    public void onDestory() {
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.h hVar) {
        this.frE = hVar;
        if (this.frK != null) {
            this.frK.setOnViewResponseListener(this.frE);
        }
        this.frV.setOnViewResponseListener(this.frE);
    }

    public void qm(String str) {
        this.fjO.en(str);
        if (!StringUtils.isNull(str)) {
            this.fjO.getHeadView().setShowV(false);
        } else if (this.mUserData.isBigV() || !StringUtils.isNull(this.mUserData.getUserTbVipInfoData().getvipV_url())) {
            this.fjO.getHeadView().setShowV(true);
        } else {
            this.fjO.getHeadView().setShowV(false);
        }
    }

    protected void bas() {
        this.fjO.wg();
        this.fjO.getHeadView().setIsRound(true);
        this.fjO.getHeadView().setDrawBorder(false);
        this.fjO.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    protected void aYA() {
        if (this.mUserData != null && (this.mUserData.getIsMem() > 0 || this.mUserData.isBigV())) {
            aj.c(this.aoD, d.C0080d.cp_cont_h, 1);
        } else {
            aj.c(this.aoD, d.C0080d.cp_cont_b, 1);
        }
    }

    private void bat() {
        if (this.frF != null && this.frF.bam() != null) {
            this.frY.removeAllViews();
            int godType = this.frF.bam().getGodType();
            if (godType == 2 && v.u(this.frF.bam().getForumGodList()) > 0) {
                this.frY.setVisibility(0);
                for (ForumGodDetailInfo forumGodDetailInfo : this.frF.bam().getForumGodList()) {
                    if (forumGodDetailInfo != null) {
                        bG(forumGodDetailInfo.forum_name, forumGodDetailInfo.intro);
                    }
                }
                return;
            } else if (godType == 1 && this.frF.bam().getgodDetailInfo() != null && !StringUtils.isNull(this.frF.bam().getgodDetailInfo().intro)) {
                this.frY.setVisibility(0);
                bG(this.frF.bam().getgodDetailInfo().intro, "");
                return;
            } else {
                return;
            }
        }
        this.frY.setVisibility(8);
    }

    private void bG(String str, String str2) {
        View inflate = LayoutInflater.from(this.mContext).inflate(d.h.layout_god_auth_info, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(d.g.bar_name);
        textView.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(d.f.pic_v_avatar), (Drawable) null, (Drawable) null, (Drawable) null);
        aj.i(textView, d.C0080d.cp_cont_b);
        textView.setText(str);
        TextView textView2 = (TextView) inflate.findViewById(d.g.bar_info);
        aj.i(textView2, d.C0080d.cp_cont_j);
        textView2.setText(str2);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.ds14);
        this.frY.addView(inflate, layoutParams);
    }

    private void bau() {
        int i;
        for (int i2 = 0; i2 < frG.length; i2++) {
            ((TbImageView) this.mRootView.findViewById(frG[i2])).setVisibility(8);
        }
        if (this.frF == null || this.frF.bal() == null || v.u(this.frF.bal().fpK) <= 0) {
            i = 0;
        } else {
            int i3 = this.frF.bal().giftNum;
            List<com.baidu.adp.widget.ListView.f> list = this.frF.bal().fpK;
            for (int i4 = 0; i4 < list.size() && i4 < frG.length; i4++) {
                if (list.get(i4) instanceof com.baidu.tieba.personPolymeric.c.p) {
                    TbImageView tbImageView = (TbImageView) this.mRootView.findViewById(frG[i4]);
                    tbImageView.setVisibility(0);
                    tbImageView.setIsRound(true);
                    tbImageView.startLoad(((com.baidu.tieba.personPolymeric.c.p) list.get(i4)).picUrl, 10, false);
                }
            }
            i = i3;
        }
        this.fsc.setText(String.format(this.mContext.getResources().getString(d.j.gift_num), Integer.valueOf(i)));
    }
}
