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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.UserVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.personCenter.view.PersonHeadPendantView;
import com.baidu.tieba.view.PersonHeaderAttentionView;
import java.util.List;
import org.apache.http.HttpHost;
import tbclient.Profile.ForumGodDetailInfo;
import tbclient.Profile.UserAgreeInfo;
/* loaded from: classes3.dex */
public class n {
    private static final int[] fYF = {d.g.img_gift_one, d.g.img_gift_two, d.g.img_gift_three};
    protected TextView ayt;
    private TextView bsQ;
    private com.baidu.tbadk.core.view.userLike.c cxK;
    private View dNV;
    protected TbImageView fRn;
    protected com.baidu.tieba.view.g fYD;
    protected com.baidu.tieba.personPolymeric.c.a fYE;
    protected ImageView fYG;
    protected PersonHeadPendantView fYH;
    protected UserIconBox fYI;
    protected TextView fYJ;
    protected TextView fYK;
    public com.baidu.tieba.view.e fYL;
    protected View fYM;
    private TextView fYN;
    private TextView fYO;
    private TextView fYP;
    private View fYQ;
    private View fYR;
    private TextView fYS;
    private View fYT;
    private View fYU;
    private LinearLayout fYV;
    private TextView fYW;
    private m fYX;
    private View fYY;
    private ImageView fYZ;
    private TextView fZa;
    private BlueLikeButton fZb;
    private LinearLayout fZc;
    private RelativeLayout fZd;
    private View fZe;
    private TextView fZf;
    private TextView fZg;
    private TextView fZh;
    private int fZi;
    protected Context mContext;
    protected boolean mIsHost;
    private TbPageContext mPageContext;
    protected View mRootView;
    protected UserData mUserData;

    public n(TbPageContext tbPageContext, boolean z) {
        this.fZi = 0;
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.mIsHost = z;
        this.fZi = com.baidu.adp.lib.util.l.e(this.mContext, d.e.tbds46);
        Y(aga());
        TextView textView = this.fYJ;
        if (this.mIsHost) {
        }
        textView.setVisibility(8);
    }

    public View aga() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(d.i.item_person_polymeric_header_view, (ViewGroup) null);
        }
        return this.mRootView;
    }

    public void Y(View view) {
        this.fYM = view.findViewById(d.g.person_info_root);
        this.fYH = (PersonHeadPendantView) view.findViewById(d.g.person_polymeric_header_user_img);
        this.fYH.getHeadView().setCustomBigViewIconId(d.f.pic_v_avatar_big);
        this.fYH.getHeadView().setIconWidth(this.mContext.getResources().getDimensionPixelSize(d.e.ds40));
        this.fYH.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fRn = (TbImageView) view.findViewById(d.g.person_polymeric_header_user_vip_icon);
        this.ayt = (TextView) view.findViewById(d.g.person_polymeric_header_user_name_txt);
        this.fYK = (TextView) view.findViewById(d.g.seal_prefix_view);
        this.fYI = (UserIconBox) view.findViewById(d.g.person_polymeric_header_label_box);
        this.fYN = (TextView) view.findViewById(d.g.person_polymeric_header_bar_age_txt);
        this.bsQ = (TextView) view.findViewById(d.g.person_polymeric_header_ala_id);
        this.fYQ = view.findViewById(d.g.divider_for_alaid_and_age);
        this.fYJ = (TextView) view.findViewById(d.g.person_polymeric_header_visitor_txt);
        this.fYO = (TextView) view.findViewById(d.g.person_polymeric_header_sign_txt);
        this.fYP = (TextView) view.findViewById(d.g.person_center_header_tdou_txt);
        this.fYS = (TextView) view.findViewById(d.g.textview_get_tdou);
        this.fYT = view.findViewById(d.g.divider_for_age_and_tdou);
        this.fYU = view.findViewById(d.g.divider_for_tdou_and_get_tdou);
        this.fYV = (LinearLayout) view.findViewById(d.g.layout_user_name);
        this.fYW = (TextView) view.findViewById(d.g.person_praise_number);
        this.fYP.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(d.f.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
        this.fYL = (PersonHeaderAttentionView) view.findViewById(d.g.person_center_header_attention_container);
        bkJ();
        this.fYX = new m(this.mContext);
        this.fRn.setOnClickListener(this.fYX);
        this.fYI.setOnClickListener(this.fYX);
        this.fYH.setOnClickListener(this.fYX);
        this.fYJ.setOnClickListener(this.fYX);
        this.fYK.setOnClickListener(this.fYX);
        this.fYP.setOnClickListener(this.fYX);
        this.fYS.setOnClickListener(this.fYX);
        this.ayt.setOnClickListener(this.fYX);
        this.fYO.setOnClickListener(this.fYX);
        this.fYY = (LinearLayout) view.findViewById(d.g.container_send_gift);
        this.fYZ = (ImageView) view.findViewById(d.g.icon_gift);
        this.fZa = (TextView) view.findViewById(d.g.btn_give_gift);
        this.fYY.setOnClickListener(this.fYX);
        this.fZb = (BlueLikeButton) view.findViewById(d.g.btn_like_blue);
        this.cxK = new com.baidu.tbadk.core.view.userLike.c(this.mPageContext, this.fZb);
        this.cxK.setFromType("2");
        if (this.mIsHost) {
            this.fYY.setVisibility(8);
            this.fZb.setVisibility(8);
        }
        this.fZc = (LinearLayout) view.findViewById(d.g.layout_god_auth_forums);
        this.fZc.setVisibility(8);
        this.dNV = view.findViewById(d.g.header_bottom_divider);
        this.fZd = (RelativeLayout) view.findViewById(d.g.layout_gift);
        this.fZd.setOnClickListener(this.fYX);
        this.fZe = view.findViewById(d.g.gift_top_divider);
        this.fZf = (TextView) view.findViewById(d.g.textview_received_gift);
        this.fZg = (TextView) view.findViewById(d.g.textview_received_gift_num);
        this.fYG = (ImageView) view.findViewById(d.g.img_gift_arrow);
        this.fZh = (TextView) view.findViewById(d.g.btn_edit_person_info);
        this.fZh.setOnClickListener(this.fYX);
        if (!this.mIsHost) {
            this.fZh.setVisibility(8);
        }
    }

    public void e(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null) {
            this.fYE = aVar;
            this.mUserData = aVar.getUserData();
            this.fYX.a(aVar);
            this.fYX.setIsHost(this.mIsHost);
            String portrait = this.mUserData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                if (portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    this.fYH.getHeadView().startLoad(portrait, 10, false);
                } else {
                    String eu = com.baidu.tbadk.core.util.p.eu(portrait);
                    this.fYH.getHeadView().setUrl(eu);
                    this.fYH.getHeadView().startLoad(eu, 25, false);
                }
            } else {
                this.fYH.getHeadView().startLoad(String.valueOf(d.f.pic_mycenter_avatar_def_i), 24, false);
            }
            com.baidu.tbadk.data.i pendantData = this.mUserData.getPendantData();
            if (pendantData != null) {
                this.fYH.fj(pendantData.ub());
            }
            if (this.fYH.Ae()) {
                this.fYH.getHeadView().setShowV(false);
            } else if (this.mUserData.isBigV() || !StringUtils.isNull(this.mUserData.getUserTbVipInfoData().getvipV_url())) {
                this.fYH.getHeadView().setShowV(true);
            } else {
                this.fYH.getHeadView().setShowV(false);
            }
            UserVipInfoData userVipInfo = this.mUserData.getUserVipInfo();
            if (this.mUserData.getIsMem() > 0) {
                if (userVipInfo != null) {
                    this.fRn.startLoad(userVipInfo.getVipIconUrl(), 10, false);
                }
                this.fRn.setVisibility(0);
            } else if (this.mIsHost) {
                this.fRn.setImageDrawable(al.getDrawable(d.f.icon_crown_super_non));
                this.fRn.setVisibility(0);
            } else {
                this.fRn.setVisibility(8);
            }
            biP();
            String name_show = this.mUserData.getName_show();
            if (!TextUtils.isEmpty(name_show)) {
                this.ayt.setText(name_show);
            }
            int i = d.f.icon_mine_boy;
            if (this.mUserData != null) {
                i = this.mUserData.getSex() == 2 ? d.f.icon_mine_girl : d.f.icon_mine_boy;
            }
            this.ayt.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mContext.getResources().getDrawable(i), (Drawable) null);
            this.fYI.a(this.mUserData.getIconInfo(), 9, this.mContext.getResources().getDimensionPixelSize(d.e.tbds42), this.mContext.getResources().getDimensionPixelSize(d.e.tbds42), this.mContext.getResources().getDimensionPixelSize(d.e.tbds10), true);
            if (this.fYL != null) {
                this.fYL.setData(this.mUserData);
            }
            if (this.mUserData != null && this.mUserData.alaUserData != null && this.mUserData.alaUserData.ala_id != 0) {
                this.bsQ.setVisibility(0);
                this.fYQ.setVisibility(0);
                this.bsQ.setText(String.format(this.mContext.getString(d.k.person_center_ala_id), Long.valueOf(this.mUserData.alaUserData.ala_id)));
            } else {
                this.bsQ.setVisibility(8);
                this.fYQ.setVisibility(8);
            }
            this.fYN.setText(String.format(this.mContext.getString(d.k.person_center_header_bar_age), this.mUserData.getTb_age()));
            if (this.mIsHost) {
                this.fYT.setVisibility(0);
                this.fYU.setVisibility(0);
                this.fYP.setVisibility(0);
                this.fYS.setVisibility(0);
                this.fYP.setText(ao.K(this.mUserData.getTDouNum()));
            } else {
                this.fYT.setVisibility(8);
                this.fYU.setVisibility(8);
                this.fYP.setVisibility(8);
                this.fYS.setVisibility(8);
            }
            String intro = this.mUserData.getIntro();
            if (StringUtils.isNull(intro)) {
                al.c(this.fYO, d.C0141d.cp_cont_e, 1);
            } else {
                al.c(this.fYO, d.C0141d.cp_cont_j, 1);
            }
            if (StringUtils.isNull(intro)) {
                if (this.mIsHost) {
                    intro = this.mContext.getString(d.k.no_person_sign_host);
                } else {
                    intro = this.mContext.getString(d.k.no_person_sign_guest);
                }
            }
            this.fYO.setText(this.mContext.getString(d.k.person_sign) + intro);
            if (this.fYO.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fYO.getLayoutParams();
                if (!this.mIsHost && this.fYO.getLineCount() >= 3 && this.fYO.getMaxLines() != 2147483646) {
                    int lineHeight = this.fYO.getLineHeight();
                    this.fYO.setHeight((lineHeight / 2) + (lineHeight * 3));
                }
                if (this.fYO.getLineCount() >= 2) {
                    layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(d.e.tbds19);
                } else {
                    layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(d.e.tbds80);
                }
                this.fYO.setLayoutParams(layoutParams);
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(this.mUserData.getUserId()) && ((!TbadkCoreApplication.isLogin() || (!StringUtils.isNull(currentAccount) && !currentAccount.equals(this.mUserData.getUserId()))) && this.mUserData.getLiveStatus() == 1)) {
                if (this.fYR == null) {
                    this.fYR = com.baidu.tbadk.ala.b.rM().f(this.mContext, 7);
                }
                com.baidu.tbadk.ala.a aVar2 = new com.baidu.tbadk.ala.a();
                aVar2.aak = this.mUserData.getAlaUserData();
                aVar2.type = 7;
                if ((this.mUserData.getPersonPrivate() != null && this.mUserData.getPersonPrivate().GI() == 3) || (this.mUserData.getPersonPrivate().GI() == 2 && this.mUserData.getIsFriend() != 1)) {
                    aVar2.aal = true;
                } else {
                    aVar2.aal = false;
                }
                if (this.fYR != null) {
                    this.fYR.setTag(aVar2);
                    if (this.fYR.getParent() == null) {
                        this.fYV.addView(this.fYR);
                        TiebaStatic.log(new am("c12541"));
                    }
                }
            } else if (this.fYR != null) {
                this.fYR.setVisibility(8);
            }
            a(aVar.fWy);
            this.mUserData.setIsLike(this.mUserData.getHave_attention() == 1);
            this.cxK.a(this.mUserData);
            bkK();
            bkL();
            this.fZf.setText(this.mIsHost ? d.k.my_received_gift : d.k.he_received_gift);
            if ((this.mUserData.getPersonPrivate() == null || this.mUserData.getPersonPrivate().GI() != 3) && this.mUserData.getPersonPrivate().GI() == 2 && this.mUserData.getIsFriend() != 1) {
            }
        }
    }

    private void a(UserAgreeInfo userAgreeInfo) {
        if (userAgreeInfo == null) {
            this.fYW.setVisibility(8);
            return;
        }
        this.fYW.setVisibility(0);
        String E = ao.E(userAgreeInfo.total_agree_num.longValue());
        Drawable drawable = al.getDrawable(d.f.icon_home_card_like_s);
        drawable.setBounds(0, 0, this.fZi, this.fZi);
        this.fYW.setCompoundDrawables(drawable, null, null, null);
        this.fYW.setText(E);
    }

    public void onChangeSkinType(int i) {
        this.fYM.setBackgroundDrawable(al.getDrawable(d.f.shape_user_info_bg));
        this.fYH.setBackgroundViewDrawable(al.getDrawable(d.f.shape_user_img_bg));
        int i2 = d.f.icon_mine_boy;
        if (this.mUserData != null) {
            i2 = this.mUserData.getSex() == 1 ? d.f.icon_mine_boy : d.f.icon_pop_girl;
        }
        if (this.mUserData != null && this.mUserData.getIsMem() <= 0 && this.fRn != null && this.mIsHost) {
            this.fRn.setImageDrawable(al.getDrawable(d.f.icon_crown_super_non));
        }
        biP();
        al.c(this.fYK, d.C0141d.cp_link_tip_a, 1);
        this.ayt.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mContext.getResources().getDrawable(i2), (Drawable) null);
        if (this.fYL != null) {
            this.fYL.onChangeSkinType(i);
        }
        al.c(this.fYJ, d.C0141d.cp_cont_b, 1);
        al.c(this.fYN, d.C0141d.cp_cont_b, 1);
        al.c(this.bsQ, d.C0141d.cp_cont_b, 1);
        if (this.mUserData == null || StringUtils.isNull(this.mUserData.getIntro())) {
            al.c(this.fYO, d.C0141d.cp_cont_e, 1);
        } else {
            al.c(this.fYO, d.C0141d.cp_cont_j, 1);
        }
        al.c(this.fYP, d.C0141d.cp_cont_b, 1);
        al.c(this.fYS, d.C0141d.cp_cont_b, 1);
        al.j(this.fYT, d.C0141d.cp_bg_line_b);
        al.j(this.fYQ, d.C0141d.cp_bg_line_b);
        al.j(this.fYU, d.C0141d.cp_bg_line_b);
        al.h(this.fYW, d.C0141d.cp_cont_h);
        this.fYP.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(d.f.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
        Drawable v = al.v(i, d.f.icon_home_card_like_s);
        v.setBounds(0, 0, this.fZi, this.fZi);
        this.fYW.setCompoundDrawables(v, null, null, null);
        al.i(this.fYY, d.f.selector_give_gift_bg);
        al.c(this.fYZ, d.f.selector_gift_icon);
        al.c(this.fZa, d.C0141d.selector_give_gift_text_color, 1);
        this.fZb.onChangeSkinType(i);
        al.j(this.dNV, d.C0141d.cp_bg_line_e);
        for (int i3 = 0; i3 < this.fZc.getChildCount(); i3++) {
            View childAt = this.fZc.getChildAt(i3);
            if (childAt != null) {
                TextView textView = (TextView) childAt.findViewById(d.g.bar_name);
                textView.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.pic_v_avatar), (Drawable) null, (Drawable) null, (Drawable) null);
                al.h(textView, d.C0141d.cp_cont_b);
                al.h((TextView) childAt.findViewById(d.g.bar_info), d.C0141d.cp_cont_j);
            }
        }
        for (int i4 = 0; i4 < fYF.length; i4++) {
            ((TbImageView) this.mRootView.findViewById(fYF[i4])).setBackgroundDrawable(al.getDrawable(d.f.shape_gift_icon_bg));
        }
        al.j(this.fZe, d.C0141d.cp_bg_line_e);
        al.h(this.fZf, d.C0141d.cp_cont_b);
        al.h(this.fZg, d.C0141d.cp_cont_d);
        al.c(this.fYG, d.f.icon_arrow_gray_right_n);
        al.i(this.fZh, d.f.selector_like_button_bg);
        al.c(this.fZh, d.C0141d.cp_cont_g, 1);
    }

    public void onDestory() {
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.g gVar) {
        this.fYD = gVar;
        if (this.fYL != null) {
            this.fYL.setOnViewResponseListener(this.fYD);
        }
        this.fYX.setOnViewResponseListener(this.fYD);
    }

    public void sg(String str) {
        this.fYH.fj(str);
        if (!StringUtils.isNull(str)) {
            this.fYH.getHeadView().setShowV(false);
        } else if (this.mUserData.isBigV() || !StringUtils.isNull(this.mUserData.getUserTbVipInfoData().getvipV_url())) {
            this.fYH.getHeadView().setShowV(true);
        } else {
            this.fYH.getHeadView().setShowV(false);
        }
    }

    protected void bkJ() {
        this.fYH.setHasPendantStyle();
        this.fYH.getHeadView().setIsRound(true);
        this.fYH.getHeadView().setDrawBorder(false);
        this.fYH.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    protected void biP() {
        if (this.mUserData != null && (this.mUserData.getIsMem() > 0 || this.mUserData.isBigV())) {
            al.c(this.ayt, d.C0141d.cp_cont_h, 1);
        } else {
            al.c(this.ayt, d.C0141d.cp_cont_b, 1);
        }
    }

    private void bkK() {
        if (this.fYE != null && this.fYE.bkD() != null) {
            this.fZc.removeAllViews();
            int godType = this.fYE.bkD().getGodType();
            if (godType == 2 && w.y(this.fYE.bkD().getForumGodList()) > 0) {
                this.fZc.setVisibility(0);
                for (ForumGodDetailInfo forumGodDetailInfo : this.fYE.bkD().getForumGodList()) {
                    if (forumGodDetailInfo != null) {
                        bR(forumGodDetailInfo.forum_name, forumGodDetailInfo.intro);
                    }
                }
                return;
            } else if (godType == 1 && this.fYE.bkD().getgodDetailInfo() != null && !StringUtils.isNull(this.fYE.bkD().getgodDetailInfo().intro)) {
                this.fZc.setVisibility(0);
                bR(this.fYE.bkD().getgodDetailInfo().intro, "");
                return;
            } else {
                return;
            }
        }
        this.fZc.setVisibility(8);
    }

    private void bR(String str, String str2) {
        View inflate = LayoutInflater.from(this.mContext).inflate(d.i.layout_god_auth_info, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(d.g.bar_name);
        textView.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.pic_v_avatar), (Drawable) null, (Drawable) null, (Drawable) null);
        al.h(textView, d.C0141d.cp_cont_b);
        textView.setText(str);
        TextView textView2 = (TextView) inflate.findViewById(d.g.bar_info);
        al.h(textView2, d.C0141d.cp_cont_j);
        textView2.setText(str2);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.ds14);
        this.fZc.addView(inflate, layoutParams);
    }

    private void bkL() {
        int i;
        for (int i2 = 0; i2 < fYF.length; i2++) {
            ((TbImageView) this.mRootView.findViewById(fYF[i2])).setVisibility(8);
        }
        if (this.fYE == null || this.fYE.bkC() == null || w.y(this.fYE.bkC().fWM) <= 0) {
            i = 0;
        } else {
            int i3 = this.fYE.bkC().giftNum;
            List<com.baidu.adp.widget.ListView.h> list = this.fYE.bkC().fWM;
            for (int i4 = 0; i4 < list.size() && i4 < fYF.length; i4++) {
                if (list.get(i4) instanceof com.baidu.tieba.personPolymeric.c.o) {
                    TbImageView tbImageView = (TbImageView) this.mRootView.findViewById(fYF[i4]);
                    tbImageView.setVisibility(0);
                    tbImageView.setIsRound(true);
                    tbImageView.startLoad(((com.baidu.tieba.personPolymeric.c.o) list.get(i4)).picUrl, 10, false);
                }
            }
            i = i3;
        }
        this.fZg.setText(String.format(this.mContext.getResources().getString(d.k.gift_num), Integer.valueOf(i)));
    }
}
