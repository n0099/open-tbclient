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
import com.baidu.tbadk.core.util.aj;
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
public class q {
    private static final int[] fiA = {d.h.img_gift_one, d.h.img_gift_two, d.h.img_gift_three};
    protected TextView aoi;
    private com.baidu.tbadk.core.view.userLike.c bJP;
    private TextView cLV;
    private View cUK;
    protected PersonHeadPendantView fba;
    protected TbImageView fbb;
    protected UserIconBox fiB;
    protected TextView fiC;
    protected TextView fiD;
    public com.baidu.tieba.view.e fiE;
    protected View fiF;
    private TextView fiG;
    private TextView fiH;
    private TextView fiI;
    private View fiJ;
    private View fiK;
    private View fiL;
    private LinearLayout fiM;
    private TextView fiN;
    private p fiO;
    private TextView fiP;
    private BlueLikeButton fiQ;
    private LinearLayout fiR;
    private RelativeLayout fiS;
    private View fiT;
    private TextView fiU;
    private TextView fiV;
    protected com.baidu.tieba.view.g fiy;
    protected com.baidu.tieba.personPolymeric.c.a fiz;
    protected Context mContext;
    private TbPageContext mH;
    protected boolean mIsHost;
    protected View mRootView;
    protected UserData mUserData;

    public q(TbPageContext tbPageContext, boolean z) {
        this.mH = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.mIsHost = z;
        X(VR());
        TextView textView = this.fiC;
        if (this.mIsHost) {
        }
        textView.setVisibility(8);
    }

    public View VR() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(d.j.item_person_polymeric_header_view, (ViewGroup) null);
        }
        return this.mRootView;
    }

    public void X(View view) {
        this.fiF = view.findViewById(d.h.person_info_root);
        this.fba = (PersonHeadPendantView) view.findViewById(d.h.person_polymeric_header_user_img);
        this.fba.getHeadView().setCustomBigViewIconId(d.g.pic_v_avatar_big);
        this.fba.getHeadView().setIconWidth(this.mContext.getResources().getDimensionPixelSize(d.f.ds40));
        this.fbb = (TbImageView) view.findViewById(d.h.person_polymeric_header_user_vip_icon);
        this.aoi = (TextView) view.findViewById(d.h.person_polymeric_header_user_name_txt);
        this.fiD = (TextView) view.findViewById(d.h.seal_prefix_view);
        this.fiB = (UserIconBox) view.findViewById(d.h.person_polymeric_header_label_box);
        this.fiG = (TextView) view.findViewById(d.h.person_polymeric_header_bar_age_txt);
        this.fiC = (TextView) view.findViewById(d.h.person_polymeric_header_visitor_txt);
        this.fiH = (TextView) view.findViewById(d.h.person_polymeric_header_sign_txt);
        this.fiI = (TextView) view.findViewById(d.h.person_center_header_tdou_txt);
        this.cLV = (TextView) view.findViewById(d.h.textview_get_tdou);
        this.fiK = view.findViewById(d.h.divider_for_age_and_tdou);
        this.fiL = view.findViewById(d.h.divider_for_tdou_and_get_tdou);
        this.fiM = (LinearLayout) view.findViewById(d.h.layout_user_name);
        this.fiN = (TextView) view.findViewById(d.h.person_praise_number);
        this.fiI.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(d.g.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
        this.fiE = (PersonHeaderAttentionView) view.findViewById(d.h.person_center_header_attention_container);
        aXc();
        this.fiO = new p(this.mContext);
        this.fbb.setOnClickListener(this.fiO);
        this.fiB.setOnClickListener(this.fiO);
        this.fba.setOnClickListener(this.fiO);
        this.fiC.setOnClickListener(this.fiO);
        this.fiD.setOnClickListener(this.fiO);
        this.fiI.setOnClickListener(this.fiO);
        this.cLV.setOnClickListener(this.fiO);
        this.aoi.setOnClickListener(this.fiO);
        this.fiH.setOnClickListener(this.fiO);
        this.fiP = (TextView) view.findViewById(d.h.btn_give_gift);
        this.fiP.setOnClickListener(this.fiO);
        this.fiQ = (BlueLikeButton) view.findViewById(d.h.btn_like_blue);
        this.bJP = new com.baidu.tbadk.core.view.userLike.c(this.mH, this.fiQ);
        this.bJP.setFromType("2");
        if (this.mIsHost) {
            this.fiP.setVisibility(8);
            this.fiQ.setVisibility(8);
        }
        this.fiR = (LinearLayout) view.findViewById(d.h.layout_god_auth_forums);
        this.fiR.setVisibility(8);
        this.cUK = view.findViewById(d.h.header_bottom_divider);
        this.fiS = (RelativeLayout) view.findViewById(d.h.layout_gift);
        this.fiS.setOnClickListener(this.fiO);
        this.fiT = view.findViewById(d.h.gift_top_divider);
        this.fiU = (TextView) view.findViewById(d.h.textview_received_gift);
        this.fiV = (TextView) view.findViewById(d.h.textview_received_gift_num);
    }

    public void e(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null) {
            this.fiz = aVar;
            this.mUserData = aVar.getUserData();
            this.fiO.a(aVar);
            this.fiO.setIsHost(this.mIsHost);
            String portrait = this.mUserData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                String dy = com.baidu.tbadk.core.util.o.dy(portrait);
                this.fba.getHeadView().setUrl(dy);
                this.fba.getHeadView().c(dy, 25, false);
            } else {
                this.fba.getHeadView().c(String.valueOf(d.g.pic_mycenter_avatar_def_i), 24, false);
            }
            com.baidu.tbadk.data.i pendantData = this.mUserData.getPendantData();
            if (pendantData != null) {
                this.fba.eh(pendantData.pL());
            }
            if (this.fba.vY()) {
                this.fba.getHeadView().setShowV(false);
            } else if (this.mUserData.isBigV() || !StringUtils.isNull(this.mUserData.getUserTbVipInfoData().getvipV_url())) {
                this.fba.getHeadView().setShowV(true);
            } else {
                this.fba.getHeadView().setShowV(false);
            }
            UserVipInfoData userVipInfo = this.mUserData.getUserVipInfo();
            if (this.mUserData.getIsMem() > 0) {
                if (userVipInfo != null) {
                    this.fbb.c(userVipInfo.getVipIconUrl(), 10, false);
                }
                this.fbb.setVisibility(0);
            } else if (this.mIsHost) {
                this.fbb.setImageDrawable(aj.getDrawable(d.g.icon_crown_super_non));
                this.fbb.setVisibility(0);
            } else {
                this.fbb.setVisibility(8);
            }
            aVq();
            String name_show = this.mUserData.getName_show();
            if (!TextUtils.isEmpty(name_show)) {
                this.aoi.setText(name_show);
            }
            int i = d.g.icon_pop_boy;
            if (this.mUserData != null) {
                i = this.mUserData.getSex() == 2 ? d.g.icon_pop_girl : d.g.icon_pop_boy;
            }
            this.aoi.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mContext.getResources().getDrawable(i), (Drawable) null);
            this.fiB.a(this.mUserData.getIconInfo(), 9, this.mContext.getResources().getDimensionPixelSize(d.f.ds34), this.mContext.getResources().getDimensionPixelSize(d.f.ds34), this.mContext.getResources().getDimensionPixelSize(d.f.ds10), true);
            if (this.fiE != null) {
                this.fiE.setData(this.mUserData);
            }
            this.fiG.setText(String.format(this.mContext.getString(d.l.person_center_header_bar_age), this.mUserData.getTb_age()));
            if (this.mIsHost) {
                this.fiK.setVisibility(0);
                this.fiL.setVisibility(0);
                this.fiI.setVisibility(0);
                this.cLV.setVisibility(0);
                this.fiI.setText(am.H(this.mUserData.getTDouNum()));
            } else {
                this.fiK.setVisibility(8);
                this.fiL.setVisibility(8);
                this.fiI.setVisibility(8);
                this.cLV.setVisibility(8);
            }
            String intro = this.mUserData.getIntro();
            if (StringUtils.isNull(intro)) {
                aj.c(this.fiH, d.e.cp_cont_e, 1);
            } else {
                aj.c(this.fiH, d.e.cp_cont_j, 1);
            }
            if (StringUtils.isNull(intro)) {
                if (this.mIsHost) {
                    intro = this.mContext.getString(d.l.no_person_sign_host);
                } else {
                    intro = this.mContext.getString(d.l.no_person_sign_guest);
                }
            }
            this.fiH.setText(this.mContext.getString(d.l.person_sign) + intro);
            if (this.fiH.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fiH.getLayoutParams();
                if (this.fiH.getLineCount() >= 2) {
                    layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(d.f.ds32);
                } else {
                    layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(d.f.ds70);
                }
                this.fiH.setLayoutParams(layoutParams);
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(this.mUserData.getUserId()) && (!TbadkCoreApplication.isLogin() || (!StringUtils.isNull(currentAccount) && !currentAccount.equals(this.mUserData.getUserId()) && this.mUserData.getLiveStatus() == 1))) {
                if (this.fiJ == null) {
                    this.fiJ = com.baidu.tbadk.ala.b.nr().g(this.mContext, 7);
                }
                com.baidu.tbadk.ala.a aVar2 = new com.baidu.tbadk.ala.a();
                aVar2.Qv = this.mUserData.getAlaUserData();
                aVar2.type = 7;
                if ((this.mUserData.getPersonPrivate() != null && this.mUserData.getPersonPrivate().BR() == 3) || (this.mUserData.getPersonPrivate().BR() == 2 && this.mUserData.getIsFriend() != 1)) {
                    aVar2.Qw = true;
                } else {
                    aVar2.Qw = false;
                }
                if (this.fiJ != null) {
                    this.fiJ.setTag(aVar2);
                    this.fiM.addView(this.fiJ);
                }
            } else if (this.fiJ != null) {
                this.fiJ.setVisibility(8);
            }
            a(aVar.fgz);
            this.mUserData.setIsLike(this.mUserData.getHave_attention() == 1);
            this.bJP.a(this.mUserData);
            aXd();
            aXe();
            this.fiU.setText(this.mIsHost ? d.l.my_received_gift : d.l.he_received_gift);
            if ((this.mUserData.getPersonPrivate() == null || this.mUserData.getPersonPrivate().BR() != 3) && this.mUserData.getPersonPrivate().BR() == 2 && this.mUserData.getIsFriend() != 1) {
            }
        }
    }

    private void a(UserAgreeInfo userAgreeInfo) {
        if (userAgreeInfo == null) {
            this.fiN.setVisibility(8);
            return;
        }
        this.fiN.setVisibility(0);
        String A = am.A(userAgreeInfo.total_agree_num.longValue());
        Drawable drawable = aj.getDrawable(d.g.icon_home_card_like_s);
        drawable.setBounds(0, 0, com.baidu.adp.lib.util.l.f(this.mContext, d.f.ds36), com.baidu.adp.lib.util.l.f(this.mContext, d.f.ds36));
        this.fiN.setCompoundDrawables(drawable, null, null, null);
        this.fiN.setText(A);
    }

    public void onChangeSkinType(int i) {
        this.fiF.setBackgroundDrawable(aj.getDrawable(d.g.shape_user_info_bg));
        this.fba.setBackgroundViewDrawable(aj.getDrawable(d.g.shape_user_img_bg));
        int i2 = d.g.icon_pop_boy;
        if (this.mUserData != null) {
            i2 = this.mUserData.getSex() == 1 ? d.g.icon_pop_boy : d.g.icon_pop_girl;
        }
        if (this.mUserData != null && this.mUserData.getIsMem() <= 0 && this.fbb != null && this.mIsHost) {
            this.fbb.setImageDrawable(aj.getDrawable(d.g.icon_crown_super_non));
        }
        aVq();
        aj.c(this.fiD, d.e.cp_link_tip_a, 1);
        this.aoi.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mContext.getResources().getDrawable(i2), (Drawable) null);
        if (this.fiE != null) {
            this.fiE.onChangeSkinType(i);
        }
        aj.c(this.fiC, d.e.cp_cont_b, 1);
        aj.c(this.fiG, d.e.cp_cont_b, 1);
        if (this.mUserData == null || StringUtils.isNull(this.mUserData.getIntro())) {
            aj.c(this.fiH, d.e.cp_cont_e, 1);
        } else {
            aj.c(this.fiH, d.e.cp_cont_j, 1);
        }
        aj.c(this.fiI, d.e.cp_cont_b, 1);
        aj.c(this.cLV, d.e.cp_cont_b, 1);
        aj.k(this.fiK, d.e.cp_bg_line_b);
        aj.k(this.fiL, d.e.cp_bg_line_b);
        aj.i(this.fiN, d.e.cp_cont_h);
        this.fiI.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(d.g.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
        Drawable u = aj.u(i, d.g.icon_home_card_like_s);
        u.setBounds(0, 0, com.baidu.adp.lib.util.l.f(this.mContext, d.f.ds36), com.baidu.adp.lib.util.l.f(this.mContext, d.f.ds36));
        this.fiN.setCompoundDrawables(u, null, null, null);
        aj.c(this.fiP, d.e.selector_give_gift_text_color, 1);
        this.fiP.setBackgroundDrawable(aj.getDrawable(d.g.selector_give_gift_bg));
        this.fiP.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.g.selector_gift_icon), (Drawable) null, (Drawable) null, (Drawable) null);
        this.fiQ.onChangeSkinType(i);
        aj.k(this.cUK, d.e.cp_bg_line_e);
        for (int i3 = 0; i3 < this.fiR.getChildCount(); i3++) {
            View childAt = this.fiR.getChildAt(i3);
            if (childAt != null) {
                TextView textView = (TextView) childAt.findViewById(d.h.bar_name);
                textView.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(d.g.pic_v_avatar), (Drawable) null, (Drawable) null, (Drawable) null);
                aj.i(textView, d.e.cp_cont_b);
                aj.i((TextView) childAt.findViewById(d.h.bar_info), d.e.cp_cont_j);
            }
        }
        for (int i4 = 0; i4 < fiA.length; i4++) {
            ((TbImageView) this.mRootView.findViewById(fiA[i4])).setBackgroundDrawable(aj.getDrawable(d.g.shape_gift_icon_bg));
        }
        aj.k(this.fiT, d.e.cp_bg_line_e);
        aj.i(this.fiU, d.e.cp_cont_b);
        aj.i(this.fiV, d.e.cp_cont_d);
    }

    public void onDestory() {
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.g gVar) {
        this.fiy = gVar;
        if (this.fiE != null) {
            this.fiE.setOnViewResponseListener(this.fiy);
        }
        this.fiO.setOnViewResponseListener(this.fiy);
    }

    public void pC(String str) {
        this.fba.eh(str);
        if (!StringUtils.isNull(str)) {
            this.fba.getHeadView().setShowV(false);
        } else if (this.mUserData.isBigV() || !StringUtils.isNull(this.mUserData.getUserTbVipInfoData().getvipV_url())) {
            this.fba.getHeadView().setShowV(true);
        } else {
            this.fba.getHeadView().setShowV(false);
        }
    }

    protected void aXc() {
        this.fba.vZ();
        this.fba.getHeadView().setIsRound(true);
        this.fba.getHeadView().setDrawBorder(false);
        this.fba.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    protected void aVq() {
        if (this.mUserData != null && (this.mUserData.getIsMem() > 0 || this.mUserData.isBigV())) {
            aj.c(this.aoi, d.e.cp_cont_h, 1);
        } else {
            aj.c(this.aoi, d.e.cp_cont_b, 1);
        }
    }

    private void aXd() {
        if (this.fiz != null && this.fiz.aWX() != null) {
            this.fiR.removeAllViews();
            int godType = this.fiz.aWX().getGodType();
            if (godType == 2 && v.t(this.fiz.aWX().getForumGodList()) > 0) {
                this.fiR.setVisibility(0);
                for (ForumGodDetailInfo forumGodDetailInfo : this.fiz.aWX().getForumGodList()) {
                    if (forumGodDetailInfo != null) {
                        bJ(forumGodDetailInfo.forum_name, forumGodDetailInfo.intro);
                    }
                }
                return;
            } else if (godType == 1 && this.fiz.aWX().getgodDetailInfo() != null && !StringUtils.isNull(this.fiz.aWX().getgodDetailInfo().intro)) {
                this.fiR.setVisibility(0);
                bJ(this.fiz.aWX().getgodDetailInfo().intro, "");
                return;
            } else {
                return;
            }
        }
        this.fiR.setVisibility(8);
    }

    private void bJ(String str, String str2) {
        View inflate = LayoutInflater.from(this.mContext).inflate(d.j.layout_god_auth_info, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(d.h.bar_name);
        textView.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(d.g.pic_v_avatar), (Drawable) null, (Drawable) null, (Drawable) null);
        aj.i(textView, d.e.cp_cont_b);
        textView.setText(str);
        TextView textView2 = (TextView) inflate.findViewById(d.h.bar_info);
        aj.i(textView2, d.e.cp_cont_j);
        textView2.setText(str2);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(d.f.ds14);
        this.fiR.addView(inflate, layoutParams);
    }

    private void aXe() {
        int i;
        for (int i2 = 0; i2 < fiA.length; i2++) {
            ((TbImageView) this.mRootView.findViewById(fiA[i2])).setVisibility(8);
        }
        if (this.fiz == null || this.fiz.aWW() == null || v.t(this.fiz.aWW().fgO) <= 0) {
            i = 0;
        } else {
            int i3 = this.fiz.aWW().giftNum;
            List<com.baidu.adp.widget.ListView.f> list = this.fiz.aWW().fgO;
            for (int i4 = 0; i4 < list.size() && i4 < fiA.length; i4++) {
                if (list.get(i4) instanceof com.baidu.tieba.personPolymeric.c.p) {
                    TbImageView tbImageView = (TbImageView) this.mRootView.findViewById(fiA[i4]);
                    tbImageView.setVisibility(0);
                    tbImageView.setIsRound(true);
                    tbImageView.c(((com.baidu.tieba.personPolymeric.c.p) list.get(i4)).picUrl, 10, false);
                }
            }
            i = i3;
        }
        this.fiV.setText(String.format(this.mContext.getResources().getString(d.l.gift_num), Integer.valueOf(i)));
    }
}
