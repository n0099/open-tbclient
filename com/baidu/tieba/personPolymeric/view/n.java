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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
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
    private static final int[] fNt = {d.g.img_gift_one, d.g.img_gift_two, d.g.img_gift_three};
    protected TextView aqm;
    private TextView bkM;
    private com.baidu.tbadk.core.view.userLike.c cpg;
    private View dCN;
    protected TbImageView fFU;
    protected View fNA;
    private TextView fNB;
    private TextView fNC;
    private TextView fND;
    private View fNE;
    private View fNF;
    private TextView fNG;
    private View fNH;
    private View fNI;
    private LinearLayout fNJ;
    private TextView fNK;
    private m fNL;
    private View fNM;
    private ImageView fNN;
    private TextView fNO;
    private BlueLikeButton fNP;
    private LinearLayout fNQ;
    private RelativeLayout fNR;
    private View fNS;
    private TextView fNT;
    private TextView fNU;
    private int fNV;
    protected com.baidu.tieba.view.g fNr;
    protected com.baidu.tieba.personPolymeric.c.a fNs;
    protected ImageView fNu;
    protected PersonHeadPendantView fNv;
    protected UserIconBox fNw;
    protected TextView fNx;
    protected TextView fNy;
    public com.baidu.tieba.view.e fNz;
    protected Context mContext;
    protected boolean mIsHost;
    private TbPageContext mPageContext;
    protected View mRootView;
    protected UserData mUserData;

    public n(TbPageContext tbPageContext, boolean z) {
        this.fNV = 0;
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.mIsHost = z;
        this.fNV = com.baidu.adp.lib.util.l.e(this.mContext, d.e.tbds46);
        Y(acD());
        TextView textView = this.fNx;
        if (this.mIsHost) {
        }
        textView.setVisibility(8);
    }

    public View acD() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(d.i.item_person_polymeric_header_view, (ViewGroup) null);
        }
        return this.mRootView;
    }

    public void Y(View view2) {
        this.fNA = view2.findViewById(d.g.person_info_root);
        this.fNv = (PersonHeadPendantView) view2.findViewById(d.g.person_polymeric_header_user_img);
        this.fNv.getHeadView().setCustomBigViewIconId(d.f.pic_v_avatar_big);
        this.fNv.getHeadView().setIconWidth(this.mContext.getResources().getDimensionPixelSize(d.e.ds40));
        this.fNv.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fFU = (TbImageView) view2.findViewById(d.g.person_polymeric_header_user_vip_icon);
        this.aqm = (TextView) view2.findViewById(d.g.person_polymeric_header_user_name_txt);
        this.fNy = (TextView) view2.findViewById(d.g.seal_prefix_view);
        this.fNw = (UserIconBox) view2.findViewById(d.g.person_polymeric_header_label_box);
        this.fNB = (TextView) view2.findViewById(d.g.person_polymeric_header_bar_age_txt);
        this.bkM = (TextView) view2.findViewById(d.g.person_polymeric_header_ala_id);
        this.fNE = view2.findViewById(d.g.divider_for_alaid_and_age);
        this.fNx = (TextView) view2.findViewById(d.g.person_polymeric_header_visitor_txt);
        this.fNC = (TextView) view2.findViewById(d.g.person_polymeric_header_sign_txt);
        this.fND = (TextView) view2.findViewById(d.g.person_center_header_tdou_txt);
        this.fNG = (TextView) view2.findViewById(d.g.textview_get_tdou);
        this.fNH = view2.findViewById(d.g.divider_for_age_and_tdou);
        this.fNI = view2.findViewById(d.g.divider_for_tdou_and_get_tdou);
        this.fNJ = (LinearLayout) view2.findViewById(d.g.layout_user_name);
        this.fNK = (TextView) view2.findViewById(d.g.person_praise_number);
        this.fND.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(d.f.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
        this.fNz = (PersonHeaderAttentionView) view2.findViewById(d.g.person_center_header_attention_container);
        bfK();
        this.fNL = new m(this.mContext);
        this.fFU.setOnClickListener(this.fNL);
        this.fNw.setOnClickListener(this.fNL);
        this.fNv.setOnClickListener(this.fNL);
        this.fNx.setOnClickListener(this.fNL);
        this.fNy.setOnClickListener(this.fNL);
        this.fND.setOnClickListener(this.fNL);
        this.fNG.setOnClickListener(this.fNL);
        this.aqm.setOnClickListener(this.fNL);
        this.fNC.setOnClickListener(this.fNL);
        this.fNM = (LinearLayout) view2.findViewById(d.g.container_send_gift);
        this.fNN = (ImageView) view2.findViewById(d.g.icon_gift);
        this.fNO = (TextView) view2.findViewById(d.g.btn_give_gift);
        this.fNM.setOnClickListener(this.fNL);
        this.fNP = (BlueLikeButton) view2.findViewById(d.g.btn_like_blue);
        this.cpg = new com.baidu.tbadk.core.view.userLike.c(this.mPageContext, this.fNP);
        this.cpg.setFromType("2");
        if (this.mIsHost) {
            this.fNM.setVisibility(8);
            this.fNP.setVisibility(8);
        }
        this.fNQ = (LinearLayout) view2.findViewById(d.g.layout_god_auth_forums);
        this.fNQ.setVisibility(8);
        this.dCN = view2.findViewById(d.g.header_bottom_divider);
        this.fNR = (RelativeLayout) view2.findViewById(d.g.layout_gift);
        this.fNR.setOnClickListener(this.fNL);
        this.fNS = view2.findViewById(d.g.gift_top_divider);
        this.fNT = (TextView) view2.findViewById(d.g.textview_received_gift);
        this.fNU = (TextView) view2.findViewById(d.g.textview_received_gift_num);
        this.fNu = (ImageView) view2.findViewById(d.g.img_gift_arrow);
    }

    public void e(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null) {
            this.fNs = aVar;
            this.mUserData = aVar.getUserData();
            this.fNL.a(aVar);
            this.fNL.setIsHost(this.mIsHost);
            String portrait = this.mUserData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                if (portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    this.fNv.getHeadView().startLoad(portrait, 10, false);
                } else {
                    String dU = com.baidu.tbadk.core.util.o.dU(portrait);
                    this.fNv.getHeadView().setUrl(dU);
                    this.fNv.getHeadView().startLoad(dU, 25, false);
                }
            } else {
                this.fNv.getHeadView().startLoad(String.valueOf(d.f.pic_mycenter_avatar_def_i), 24, false);
            }
            com.baidu.tbadk.data.h pendantData = this.mUserData.getPendantData();
            if (pendantData != null) {
                this.fNv.eK(pendantData.qF());
            }
            if (this.fNv.wD()) {
                this.fNv.getHeadView().setShowV(false);
            } else if (this.mUserData.isBigV() || !StringUtils.isNull(this.mUserData.getUserTbVipInfoData().getvipV_url())) {
                this.fNv.getHeadView().setShowV(true);
            } else {
                this.fNv.getHeadView().setShowV(false);
            }
            UserVipInfoData userVipInfo = this.mUserData.getUserVipInfo();
            if (this.mUserData.getIsMem() > 0) {
                if (userVipInfo != null) {
                    this.fFU.startLoad(userVipInfo.getVipIconUrl(), 10, false);
                }
                this.fFU.setVisibility(0);
            } else if (this.mIsHost) {
                this.fFU.setImageDrawable(ak.getDrawable(d.f.icon_crown_super_non));
                this.fFU.setVisibility(0);
            } else {
                this.fFU.setVisibility(8);
            }
            bdP();
            String name_show = this.mUserData.getName_show();
            if (!TextUtils.isEmpty(name_show)) {
                this.aqm.setText(name_show);
            }
            int i = d.f.icon_mine_boy;
            if (this.mUserData != null) {
                i = this.mUserData.getSex() == 2 ? d.f.icon_mine_girl : d.f.icon_mine_boy;
            }
            this.aqm.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mContext.getResources().getDrawable(i), (Drawable) null);
            this.fNw.a(this.mUserData.getIconInfo(), 9, this.mContext.getResources().getDimensionPixelSize(d.e.tbds42), this.mContext.getResources().getDimensionPixelSize(d.e.tbds42), this.mContext.getResources().getDimensionPixelSize(d.e.tbds10), true);
            if (this.fNz != null) {
                this.fNz.setData(this.mUserData);
            }
            if (this.mUserData != null && this.mUserData.alaUserData != null && this.mUserData.alaUserData.ala_id != 0) {
                this.bkM.setVisibility(0);
                this.fNE.setVisibility(0);
                this.bkM.setText(String.format(this.mContext.getString(d.k.person_center_ala_id), Long.valueOf(this.mUserData.alaUserData.ala_id)));
            } else {
                this.bkM.setVisibility(8);
                this.fNE.setVisibility(8);
            }
            this.fNB.setText(String.format(this.mContext.getString(d.k.person_center_header_bar_age), this.mUserData.getTb_age()));
            if (this.mIsHost) {
                this.fNH.setVisibility(0);
                this.fNI.setVisibility(0);
                this.fND.setVisibility(0);
                this.fNG.setVisibility(0);
                this.fND.setText(an.H(this.mUserData.getTDouNum()));
            } else {
                this.fNH.setVisibility(8);
                this.fNI.setVisibility(8);
                this.fND.setVisibility(8);
                this.fNG.setVisibility(8);
            }
            String intro = this.mUserData.getIntro();
            if (StringUtils.isNull(intro)) {
                ak.c(this.fNC, d.C0126d.cp_cont_e, 1);
            } else {
                ak.c(this.fNC, d.C0126d.cp_cont_j, 1);
            }
            if (StringUtils.isNull(intro)) {
                if (this.mIsHost) {
                    intro = this.mContext.getString(d.k.no_person_sign_host);
                } else {
                    intro = this.mContext.getString(d.k.no_person_sign_guest);
                }
            }
            this.fNC.setText(this.mContext.getString(d.k.person_sign) + intro);
            if (this.fNC.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fNC.getLayoutParams();
                if (!this.mIsHost && this.fNC.getLineCount() >= 3 && this.fNC.getMaxLines() != 2147483646) {
                    int lineHeight = this.fNC.getLineHeight();
                    this.fNC.setHeight((lineHeight / 2) + (lineHeight * 3));
                }
                if (this.fNC.getLineCount() >= 2) {
                    layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(d.e.tbds19);
                } else {
                    layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(d.e.tbds80);
                }
                this.fNC.setLayoutParams(layoutParams);
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(this.mUserData.getUserId()) && ((!TbadkCoreApplication.isLogin() || (!StringUtils.isNull(currentAccount) && !currentAccount.equals(this.mUserData.getUserId()))) && this.mUserData.getLiveStatus() == 1)) {
                if (this.fNF == null) {
                    this.fNF = com.baidu.tbadk.ala.b.or().f(this.mContext, 7);
                }
                com.baidu.tbadk.ala.a aVar2 = new com.baidu.tbadk.ala.a();
                aVar2.Sa = this.mUserData.getAlaUserData();
                aVar2.type = 7;
                if ((this.mUserData.getPersonPrivate() != null && this.mUserData.getPersonPrivate().Df() == 3) || (this.mUserData.getPersonPrivate().Df() == 2 && this.mUserData.getIsFriend() != 1)) {
                    aVar2.Sb = true;
                } else {
                    aVar2.Sb = false;
                }
                if (this.fNF != null) {
                    this.fNF.setTag(aVar2);
                    if (this.fNF.getParent() == null) {
                        this.fNJ.addView(this.fNF);
                        TiebaStatic.log(new al("c12541"));
                    }
                }
            } else if (this.fNF != null) {
                this.fNF.setVisibility(8);
            }
            a(aVar.fLm);
            this.mUserData.setIsLike(this.mUserData.getHave_attention() == 1);
            this.cpg.a(this.mUserData);
            bfL();
            bfM();
            this.fNT.setText(this.mIsHost ? d.k.my_received_gift : d.k.he_received_gift);
            if ((this.mUserData.getPersonPrivate() == null || this.mUserData.getPersonPrivate().Df() != 3) && this.mUserData.getPersonPrivate().Df() == 2 && this.mUserData.getIsFriend() != 1) {
            }
        }
    }

    private void a(UserAgreeInfo userAgreeInfo) {
        if (userAgreeInfo == null) {
            this.fNK.setVisibility(8);
            return;
        }
        this.fNK.setVisibility(0);
        String B = an.B(userAgreeInfo.total_agree_num.longValue());
        Drawable drawable = ak.getDrawable(d.f.icon_home_card_like_s);
        drawable.setBounds(0, 0, this.fNV, this.fNV);
        this.fNK.setCompoundDrawables(drawable, null, null, null);
        this.fNK.setText(B);
    }

    public void onChangeSkinType(int i) {
        this.fNA.setBackgroundDrawable(ak.getDrawable(d.f.shape_user_info_bg));
        this.fNv.setBackgroundViewDrawable(ak.getDrawable(d.f.shape_user_img_bg));
        int i2 = d.f.icon_mine_boy;
        if (this.mUserData != null) {
            i2 = this.mUserData.getSex() == 1 ? d.f.icon_mine_boy : d.f.icon_pop_girl;
        }
        if (this.mUserData != null && this.mUserData.getIsMem() <= 0 && this.fFU != null && this.mIsHost) {
            this.fFU.setImageDrawable(ak.getDrawable(d.f.icon_crown_super_non));
        }
        bdP();
        ak.c(this.fNy, d.C0126d.cp_link_tip_a, 1);
        this.aqm.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mContext.getResources().getDrawable(i2), (Drawable) null);
        if (this.fNz != null) {
            this.fNz.onChangeSkinType(i);
        }
        ak.c(this.fNx, d.C0126d.cp_cont_b, 1);
        ak.c(this.fNB, d.C0126d.cp_cont_b, 1);
        ak.c(this.bkM, d.C0126d.cp_cont_b, 1);
        if (this.mUserData == null || StringUtils.isNull(this.mUserData.getIntro())) {
            ak.c(this.fNC, d.C0126d.cp_cont_e, 1);
        } else {
            ak.c(this.fNC, d.C0126d.cp_cont_j, 1);
        }
        ak.c(this.fND, d.C0126d.cp_cont_b, 1);
        ak.c(this.fNG, d.C0126d.cp_cont_b, 1);
        ak.j(this.fNH, d.C0126d.cp_bg_line_b);
        ak.j(this.fNE, d.C0126d.cp_bg_line_b);
        ak.j(this.fNI, d.C0126d.cp_bg_line_b);
        ak.h(this.fNK, d.C0126d.cp_cont_h);
        this.fND.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(d.f.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
        Drawable u = ak.u(i, d.f.icon_home_card_like_s);
        u.setBounds(0, 0, this.fNV, this.fNV);
        this.fNK.setCompoundDrawables(u, null, null, null);
        ak.i(this.fNM, d.f.selector_give_gift_bg);
        ak.c(this.fNN, d.f.selector_gift_icon);
        ak.c(this.fNO, d.C0126d.selector_give_gift_text_color, 1);
        this.fNP.onChangeSkinType(i);
        ak.j(this.dCN, d.C0126d.cp_bg_line_e);
        for (int i3 = 0; i3 < this.fNQ.getChildCount(); i3++) {
            View childAt = this.fNQ.getChildAt(i3);
            if (childAt != null) {
                TextView textView = (TextView) childAt.findViewById(d.g.bar_name);
                textView.setCompoundDrawablesWithIntrinsicBounds(ak.getDrawable(d.f.pic_v_avatar), (Drawable) null, (Drawable) null, (Drawable) null);
                ak.h(textView, d.C0126d.cp_cont_b);
                ak.h((TextView) childAt.findViewById(d.g.bar_info), d.C0126d.cp_cont_j);
            }
        }
        for (int i4 = 0; i4 < fNt.length; i4++) {
            ((TbImageView) this.mRootView.findViewById(fNt[i4])).setBackgroundDrawable(ak.getDrawable(d.f.shape_gift_icon_bg));
        }
        ak.j(this.fNS, d.C0126d.cp_bg_line_e);
        ak.h(this.fNT, d.C0126d.cp_cont_b);
        ak.h(this.fNU, d.C0126d.cp_cont_d);
        ak.c(this.fNu, d.f.icon_arrow_gray_right_n);
    }

    public void onDestory() {
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.g gVar) {
        this.fNr = gVar;
        if (this.fNz != null) {
            this.fNz.setOnViewResponseListener(this.fNr);
        }
        this.fNL.setOnViewResponseListener(this.fNr);
    }

    public void rp(String str) {
        this.fNv.eK(str);
        if (!StringUtils.isNull(str)) {
            this.fNv.getHeadView().setShowV(false);
        } else if (this.mUserData.isBigV() || !StringUtils.isNull(this.mUserData.getUserTbVipInfoData().getvipV_url())) {
            this.fNv.getHeadView().setShowV(true);
        } else {
            this.fNv.getHeadView().setShowV(false);
        }
    }

    protected void bfK() {
        this.fNv.setHasPendantStyle();
        this.fNv.getHeadView().setIsRound(true);
        this.fNv.getHeadView().setDrawBorder(false);
        this.fNv.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    protected void bdP() {
        if (this.mUserData != null && (this.mUserData.getIsMem() > 0 || this.mUserData.isBigV())) {
            ak.c(this.aqm, d.C0126d.cp_cont_h, 1);
        } else {
            ak.c(this.aqm, d.C0126d.cp_cont_b, 1);
        }
    }

    private void bfL() {
        if (this.fNs != null && this.fNs.bfE() != null) {
            this.fNQ.removeAllViews();
            int godType = this.fNs.bfE().getGodType();
            if (godType == 2 && v.v(this.fNs.bfE().getForumGodList()) > 0) {
                this.fNQ.setVisibility(0);
                for (ForumGodDetailInfo forumGodDetailInfo : this.fNs.bfE().getForumGodList()) {
                    if (forumGodDetailInfo != null) {
                        bJ(forumGodDetailInfo.forum_name, forumGodDetailInfo.intro);
                    }
                }
                return;
            } else if (godType == 1 && this.fNs.bfE().getgodDetailInfo() != null && !StringUtils.isNull(this.fNs.bfE().getgodDetailInfo().intro)) {
                this.fNQ.setVisibility(0);
                bJ(this.fNs.bfE().getgodDetailInfo().intro, "");
                return;
            } else {
                return;
            }
        }
        this.fNQ.setVisibility(8);
    }

    private void bJ(String str, String str2) {
        View inflate = LayoutInflater.from(this.mContext).inflate(d.i.layout_god_auth_info, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(d.g.bar_name);
        textView.setCompoundDrawablesWithIntrinsicBounds(ak.getDrawable(d.f.pic_v_avatar), (Drawable) null, (Drawable) null, (Drawable) null);
        ak.h(textView, d.C0126d.cp_cont_b);
        textView.setText(str);
        TextView textView2 = (TextView) inflate.findViewById(d.g.bar_info);
        ak.h(textView2, d.C0126d.cp_cont_j);
        textView2.setText(str2);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.ds14);
        this.fNQ.addView(inflate, layoutParams);
    }

    private void bfM() {
        int i;
        for (int i2 = 0; i2 < fNt.length; i2++) {
            ((TbImageView) this.mRootView.findViewById(fNt[i2])).setVisibility(8);
        }
        if (this.fNs == null || this.fNs.bfD() == null || v.v(this.fNs.bfD().fLA) <= 0) {
            i = 0;
        } else {
            int i3 = this.fNs.bfD().giftNum;
            List<com.baidu.adp.widget.ListView.h> list = this.fNs.bfD().fLA;
            for (int i4 = 0; i4 < list.size() && i4 < fNt.length; i4++) {
                if (list.get(i4) instanceof com.baidu.tieba.personPolymeric.c.o) {
                    TbImageView tbImageView = (TbImageView) this.mRootView.findViewById(fNt[i4]);
                    tbImageView.setVisibility(0);
                    tbImageView.setIsRound(true);
                    tbImageView.startLoad(((com.baidu.tieba.personPolymeric.c.o) list.get(i4)).picUrl, 10, false);
                }
            }
            i = i3;
        }
        this.fNU.setText(String.format(this.mContext.getResources().getString(d.k.gift_num), Integer.valueOf(i)));
    }
}
