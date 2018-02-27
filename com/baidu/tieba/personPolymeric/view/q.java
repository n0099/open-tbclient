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
import com.baidu.tieba.personCenter.view.PersonHeadPendantView;
import com.baidu.tieba.view.PersonHeaderAttentionView;
import java.util.List;
import tbclient.Profile.ForumGodDetailInfo;
import tbclient.Profile.UserAgreeInfo;
/* loaded from: classes3.dex */
public class q {
    private static final int[] grz = {d.g.img_gift_one, d.g.img_gift_two, d.g.img_gift_three};
    protected TextView beT;
    private com.baidu.tbadk.core.view.userLike.c cVX;
    private TextView cau;
    private View egN;
    protected TbImageView gke;
    protected ImageView grA;
    protected PersonHeadPendantView grB;
    protected UserIconBox grC;
    protected TextView grD;
    protected TextView grE;
    public com.baidu.tieba.view.g grF;
    protected View grG;
    private TextView grH;
    private TextView grI;
    private TextView grJ;
    private View grK;
    private View grL;
    private TextView grM;
    private View grN;
    private View grO;
    private LinearLayout grP;
    private TextView grQ;
    private p grR;
    private View grS;
    private ImageView grT;
    private TextView grU;
    private BlueLikeButton grV;
    private LinearLayout grW;
    private RelativeLayout grX;
    private View grY;
    private TextView grZ;
    protected com.baidu.tieba.view.i grx;
    protected com.baidu.tieba.personPolymeric.c.a gry;
    private TextView gsa;
    private int gsb;
    protected Context mContext;
    protected boolean mIsHost;
    private TbPageContext mPageContext;
    protected View mRootView;
    protected UserData mUserData;

    public q(TbPageContext tbPageContext, boolean z) {
        this.gsb = 0;
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.mIsHost = z;
        this.gsb = com.baidu.adp.lib.util.l.t(this.mContext, d.e.tbds46);
        bu(aiw());
        TextView textView = this.grD;
        if (this.mIsHost) {
        }
        textView.setVisibility(8);
    }

    public View aiw() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(d.h.item_person_polymeric_header_view, (ViewGroup) null);
        }
        return this.mRootView;
    }

    public void bu(View view) {
        this.grG = view.findViewById(d.g.person_info_root);
        this.grB = (PersonHeadPendantView) view.findViewById(d.g.person_polymeric_header_user_img);
        this.grB.getHeadView().setCustomBigViewIconId(d.f.pic_v_avatar_big);
        this.grB.getHeadView().setIconWidth(this.mContext.getResources().getDimensionPixelSize(d.e.ds40));
        this.grB.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gke = (TbImageView) view.findViewById(d.g.person_polymeric_header_user_vip_icon);
        this.beT = (TextView) view.findViewById(d.g.person_polymeric_header_user_name_txt);
        this.grE = (TextView) view.findViewById(d.g.seal_prefix_view);
        this.grC = (UserIconBox) view.findViewById(d.g.person_polymeric_header_label_box);
        this.grH = (TextView) view.findViewById(d.g.person_polymeric_header_bar_age_txt);
        this.cau = (TextView) view.findViewById(d.g.person_polymeric_header_ala_id);
        this.grK = view.findViewById(d.g.divider_for_alaid_and_age);
        this.grD = (TextView) view.findViewById(d.g.person_polymeric_header_visitor_txt);
        this.grI = (TextView) view.findViewById(d.g.person_polymeric_header_sign_txt);
        this.grJ = (TextView) view.findViewById(d.g.person_center_header_tdou_txt);
        this.grM = (TextView) view.findViewById(d.g.textview_get_tdou);
        this.grN = view.findViewById(d.g.divider_for_age_and_tdou);
        this.grO = view.findViewById(d.g.divider_for_tdou_and_get_tdou);
        this.grP = (LinearLayout) view.findViewById(d.g.layout_user_name);
        this.grQ = (TextView) view.findViewById(d.g.person_praise_number);
        this.grJ.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(d.f.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
        this.grF = (PersonHeaderAttentionView) view.findViewById(d.g.person_center_header_attention_container);
        bkF();
        this.grR = new p(this.mContext);
        this.gke.setOnClickListener(this.grR);
        this.grC.setOnClickListener(this.grR);
        this.grB.setOnClickListener(this.grR);
        this.grD.setOnClickListener(this.grR);
        this.grE.setOnClickListener(this.grR);
        this.grJ.setOnClickListener(this.grR);
        this.grM.setOnClickListener(this.grR);
        this.beT.setOnClickListener(this.grR);
        this.grI.setOnClickListener(this.grR);
        this.grS = (LinearLayout) view.findViewById(d.g.container_send_gift);
        this.grT = (ImageView) view.findViewById(d.g.icon_gift);
        this.grU = (TextView) view.findViewById(d.g.btn_give_gift);
        this.grS.setOnClickListener(this.grR);
        this.grV = (BlueLikeButton) view.findViewById(d.g.btn_like_blue);
        this.cVX = new com.baidu.tbadk.core.view.userLike.c(this.mPageContext, this.grV);
        this.cVX.setFromType("2");
        if (this.mIsHost) {
            this.grS.setVisibility(8);
            this.grV.setVisibility(8);
        }
        this.grW = (LinearLayout) view.findViewById(d.g.layout_god_auth_forums);
        this.grW.setVisibility(8);
        this.egN = view.findViewById(d.g.header_bottom_divider);
        this.grX = (RelativeLayout) view.findViewById(d.g.layout_gift);
        this.grX.setOnClickListener(this.grR);
        this.grY = view.findViewById(d.g.gift_top_divider);
        this.grZ = (TextView) view.findViewById(d.g.textview_received_gift);
        this.gsa = (TextView) view.findViewById(d.g.textview_received_gift_num);
        this.grA = (ImageView) view.findViewById(d.g.img_gift_arrow);
    }

    public void e(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null) {
            this.gry = aVar;
            this.mUserData = aVar.getUserData();
            this.grR.a(aVar);
            this.grR.setIsHost(this.mIsHost);
            String portrait = this.mUserData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                String ec = com.baidu.tbadk.core.util.o.ec(portrait);
                this.grB.getHeadView().setUrl(ec);
                this.grB.getHeadView().startLoad(ec, 25, false);
            } else {
                this.grB.getHeadView().startLoad(String.valueOf(d.f.pic_mycenter_avatar_def_i), 24, false);
            }
            com.baidu.tbadk.data.h pendantData = this.mUserData.getPendantData();
            if (pendantData != null) {
                this.grB.eS(pendantData.ya());
            }
            if (this.grB.DR()) {
                this.grB.getHeadView().setShowV(false);
            } else if (this.mUserData.isBigV() || !StringUtils.isNull(this.mUserData.getUserTbVipInfoData().getvipV_url())) {
                this.grB.getHeadView().setShowV(true);
            } else {
                this.grB.getHeadView().setShowV(false);
            }
            UserVipInfoData userVipInfo = this.mUserData.getUserVipInfo();
            if (this.mUserData.getIsMem() > 0) {
                if (userVipInfo != null) {
                    this.gke.startLoad(userVipInfo.getVipIconUrl(), 10, false);
                }
                this.gke.setVisibility(0);
            } else if (this.mIsHost) {
                this.gke.setImageDrawable(aj.getDrawable(d.f.icon_crown_super_non));
                this.gke.setVisibility(0);
            } else {
                this.gke.setVisibility(8);
            }
            biN();
            String name_show = this.mUserData.getName_show();
            if (!TextUtils.isEmpty(name_show)) {
                this.beT.setText(name_show);
            }
            int i = d.f.icon_mine_boy;
            if (this.mUserData != null) {
                i = this.mUserData.getSex() == 2 ? d.f.icon_mine_girl : d.f.icon_mine_boy;
            }
            this.beT.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mContext.getResources().getDrawable(i), (Drawable) null);
            this.grC.a(this.mUserData.getIconInfo(), 9, this.mContext.getResources().getDimensionPixelSize(d.e.tbds42), this.mContext.getResources().getDimensionPixelSize(d.e.tbds42), this.mContext.getResources().getDimensionPixelSize(d.e.tbds10), true);
            if (this.grF != null) {
                this.grF.setData(this.mUserData);
            }
            if (this.mUserData != null && this.mUserData.alaUserData != null && this.mUserData.alaUserData.ala_id != 0) {
                this.cau.setVisibility(0);
                this.grK.setVisibility(0);
                this.cau.setText(String.format(this.mContext.getString(d.j.person_center_ala_id), Long.valueOf(this.mUserData.alaUserData.ala_id)));
            } else {
                this.cau.setVisibility(8);
                this.grK.setVisibility(8);
            }
            this.grH.setText(String.format(this.mContext.getString(d.j.person_center_header_bar_age), this.mUserData.getTb_age()));
            if (this.mIsHost) {
                this.grN.setVisibility(0);
                this.grO.setVisibility(0);
                this.grJ.setVisibility(0);
                this.grM.setVisibility(0);
                this.grJ.setText(am.P(this.mUserData.getTDouNum()));
            } else {
                this.grN.setVisibility(8);
                this.grO.setVisibility(8);
                this.grJ.setVisibility(8);
                this.grM.setVisibility(8);
            }
            String intro = this.mUserData.getIntro();
            if (StringUtils.isNull(intro)) {
                aj.e(this.grI, d.C0141d.cp_cont_e, 1);
            } else {
                aj.e(this.grI, d.C0141d.cp_cont_j, 1);
            }
            if (StringUtils.isNull(intro)) {
                if (this.mIsHost) {
                    intro = this.mContext.getString(d.j.no_person_sign_host);
                } else {
                    intro = this.mContext.getString(d.j.no_person_sign_guest);
                }
            }
            this.grI.setText(this.mContext.getString(d.j.person_sign) + intro);
            if (this.grI.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.grI.getLayoutParams();
                if (!this.mIsHost && this.grI.getLineCount() >= 3 && this.grI.getMaxLines() != 2147483646) {
                    int lineHeight = this.grI.getLineHeight();
                    this.grI.setHeight((lineHeight / 2) + (lineHeight * 3));
                }
                if (this.grI.getLineCount() >= 2) {
                    layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(d.e.tbds19);
                } else {
                    layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(d.e.tbds80);
                }
                this.grI.setLayoutParams(layoutParams);
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(this.mUserData.getUserId()) && ((!TbadkCoreApplication.isLogin() || (!StringUtils.isNull(currentAccount) && !currentAccount.equals(this.mUserData.getUserId()))) && this.mUserData.getLiveStatus() == 1)) {
                if (this.grL == null) {
                    this.grL = com.baidu.tbadk.ala.b.vL().u(this.mContext, 7);
                }
                com.baidu.tbadk.ala.a aVar2 = new com.baidu.tbadk.ala.a();
                aVar2.aGT = this.mUserData.getAlaUserData();
                aVar2.type = 7;
                if ((this.mUserData.getPersonPrivate() != null && this.mUserData.getPersonPrivate().KA() == 3) || (this.mUserData.getPersonPrivate().KA() == 2 && this.mUserData.getIsFriend() != 1)) {
                    aVar2.aGU = true;
                } else {
                    aVar2.aGU = false;
                }
                if (this.grL != null) {
                    this.grL.setTag(aVar2);
                    if (this.grL.getParent() == null) {
                        this.grP.addView(this.grL);
                        TiebaStatic.log(new ak("c12541"));
                    }
                }
            } else if (this.grL != null) {
                this.grL.setVisibility(8);
            }
            a(aVar.gpr);
            this.mUserData.setIsLike(this.mUserData.getHave_attention() == 1);
            this.cVX.a(this.mUserData);
            bkG();
            bkH();
            this.grZ.setText(this.mIsHost ? d.j.my_received_gift : d.j.he_received_gift);
            if ((this.mUserData.getPersonPrivate() == null || this.mUserData.getPersonPrivate().KA() != 3) && this.mUserData.getPersonPrivate().KA() == 2 && this.mUserData.getIsFriend() != 1) {
            }
        }
    }

    private void a(UserAgreeInfo userAgreeInfo) {
        if (userAgreeInfo == null) {
            this.grQ.setVisibility(8);
            return;
        }
        this.grQ.setVisibility(0);
        String J = am.J(userAgreeInfo.total_agree_num.longValue());
        Drawable drawable = aj.getDrawable(d.f.icon_home_card_like_s);
        drawable.setBounds(0, 0, this.gsb, this.gsb);
        this.grQ.setCompoundDrawables(drawable, null, null, null);
        this.grQ.setText(J);
    }

    public void onChangeSkinType(int i) {
        this.grG.setBackgroundDrawable(aj.getDrawable(d.f.shape_user_info_bg));
        this.grB.setBackgroundViewDrawable(aj.getDrawable(d.f.shape_user_img_bg));
        int i2 = d.f.icon_mine_boy;
        if (this.mUserData != null) {
            i2 = this.mUserData.getSex() == 1 ? d.f.icon_mine_boy : d.f.icon_pop_girl;
        }
        if (this.mUserData != null && this.mUserData.getIsMem() <= 0 && this.gke != null && this.mIsHost) {
            this.gke.setImageDrawable(aj.getDrawable(d.f.icon_crown_super_non));
        }
        biN();
        aj.e(this.grE, d.C0141d.cp_link_tip_a, 1);
        this.beT.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mContext.getResources().getDrawable(i2), (Drawable) null);
        if (this.grF != null) {
            this.grF.onChangeSkinType(i);
        }
        aj.e(this.grD, d.C0141d.cp_cont_b, 1);
        aj.e(this.grH, d.C0141d.cp_cont_b, 1);
        aj.e(this.cau, d.C0141d.cp_cont_b, 1);
        if (this.mUserData == null || StringUtils.isNull(this.mUserData.getIntro())) {
            aj.e(this.grI, d.C0141d.cp_cont_e, 1);
        } else {
            aj.e(this.grI, d.C0141d.cp_cont_j, 1);
        }
        aj.e(this.grJ, d.C0141d.cp_cont_b, 1);
        aj.e(this.grM, d.C0141d.cp_cont_b, 1);
        aj.t(this.grN, d.C0141d.cp_bg_line_b);
        aj.t(this.grK, d.C0141d.cp_bg_line_b);
        aj.t(this.grO, d.C0141d.cp_bg_line_b);
        aj.r(this.grQ, d.C0141d.cp_cont_h);
        this.grJ.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(d.f.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
        Drawable au = aj.au(i, d.f.icon_home_card_like_s);
        au.setBounds(0, 0, this.gsb, this.gsb);
        this.grQ.setCompoundDrawables(au, null, null, null);
        aj.s(this.grS, d.f.selector_give_gift_bg);
        aj.c(this.grT, d.f.selector_gift_icon);
        aj.e(this.grU, d.C0141d.selector_give_gift_text_color, 1);
        this.grV.onChangeSkinType(i);
        aj.t(this.egN, d.C0141d.cp_bg_line_e);
        for (int i3 = 0; i3 < this.grW.getChildCount(); i3++) {
            View childAt = this.grW.getChildAt(i3);
            if (childAt != null) {
                TextView textView = (TextView) childAt.findViewById(d.g.bar_name);
                textView.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.pic_v_avatar), (Drawable) null, (Drawable) null, (Drawable) null);
                aj.r(textView, d.C0141d.cp_cont_b);
                aj.r((TextView) childAt.findViewById(d.g.bar_info), d.C0141d.cp_cont_j);
            }
        }
        for (int i4 = 0; i4 < grz.length; i4++) {
            ((TbImageView) this.mRootView.findViewById(grz[i4])).setBackgroundDrawable(aj.getDrawable(d.f.shape_gift_icon_bg));
        }
        aj.t(this.grY, d.C0141d.cp_bg_line_e);
        aj.r(this.grZ, d.C0141d.cp_cont_b);
        aj.r(this.gsa, d.C0141d.cp_cont_d);
        aj.c(this.grA, d.f.icon_arrow_gray_right_n);
    }

    public void onDestory() {
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.i iVar) {
        this.grx = iVar;
        if (this.grF != null) {
            this.grF.setOnViewResponseListener(this.grx);
        }
        this.grR.setOnViewResponseListener(this.grx);
    }

    public void rf(String str) {
        this.grB.eS(str);
        if (!StringUtils.isNull(str)) {
            this.grB.getHeadView().setShowV(false);
        } else if (this.mUserData.isBigV() || !StringUtils.isNull(this.mUserData.getUserTbVipInfoData().getvipV_url())) {
            this.grB.getHeadView().setShowV(true);
        } else {
            this.grB.getHeadView().setShowV(false);
        }
    }

    protected void bkF() {
        this.grB.DS();
        this.grB.getHeadView().setIsRound(true);
        this.grB.getHeadView().setDrawBorder(false);
        this.grB.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    protected void biN() {
        if (this.mUserData != null && (this.mUserData.getIsMem() > 0 || this.mUserData.isBigV())) {
            aj.e(this.beT, d.C0141d.cp_cont_h, 1);
        } else {
            aj.e(this.beT, d.C0141d.cp_cont_b, 1);
        }
    }

    private void bkG() {
        if (this.gry != null && this.gry.bkz() != null) {
            this.grW.removeAllViews();
            int godType = this.gry.bkz().getGodType();
            if (godType == 2 && v.D(this.gry.bkz().getForumGodList()) > 0) {
                this.grW.setVisibility(0);
                for (ForumGodDetailInfo forumGodDetailInfo : this.gry.bkz().getForumGodList()) {
                    if (forumGodDetailInfo != null) {
                        bJ(forumGodDetailInfo.forum_name, forumGodDetailInfo.intro);
                    }
                }
                return;
            } else if (godType == 1 && this.gry.bkz().getgodDetailInfo() != null && !StringUtils.isNull(this.gry.bkz().getgodDetailInfo().intro)) {
                this.grW.setVisibility(0);
                bJ(this.gry.bkz().getgodDetailInfo().intro, "");
                return;
            } else {
                return;
            }
        }
        this.grW.setVisibility(8);
    }

    private void bJ(String str, String str2) {
        View inflate = LayoutInflater.from(this.mContext).inflate(d.h.layout_god_auth_info, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(d.g.bar_name);
        textView.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.pic_v_avatar), (Drawable) null, (Drawable) null, (Drawable) null);
        aj.r(textView, d.C0141d.cp_cont_b);
        textView.setText(str);
        TextView textView2 = (TextView) inflate.findViewById(d.g.bar_info);
        aj.r(textView2, d.C0141d.cp_cont_j);
        textView2.setText(str2);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.ds14);
        this.grW.addView(inflate, layoutParams);
    }

    private void bkH() {
        int i;
        for (int i2 = 0; i2 < grz.length; i2++) {
            ((TbImageView) this.mRootView.findViewById(grz[i2])).setVisibility(8);
        }
        if (this.gry == null || this.gry.bky() == null || v.D(this.gry.bky().gpF) <= 0) {
            i = 0;
        } else {
            int i3 = this.gry.bky().giftNum;
            List<com.baidu.adp.widget.ListView.i> list = this.gry.bky().gpF;
            for (int i4 = 0; i4 < list.size() && i4 < grz.length; i4++) {
                if (list.get(i4) instanceof com.baidu.tieba.personPolymeric.c.o) {
                    TbImageView tbImageView = (TbImageView) this.mRootView.findViewById(grz[i4]);
                    tbImageView.setVisibility(0);
                    tbImageView.setIsRound(true);
                    tbImageView.startLoad(((com.baidu.tieba.personPolymeric.c.o) list.get(i4)).picUrl, 10, false);
                }
            }
            i = i3;
        }
        this.gsa.setText(String.format(this.mContext.getResources().getString(d.j.gift_num), Integer.valueOf(i)));
    }
}
