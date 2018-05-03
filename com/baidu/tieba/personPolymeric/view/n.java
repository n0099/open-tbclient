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
    private static final int[] fMn = {d.g.img_gift_one, d.g.img_gift_two, d.g.img_gift_three};
    protected TextView aqm;
    private TextView bkx;
    private com.baidu.tbadk.core.view.userLike.c cnX;
    private View dBG;
    protected TbImageView fEO;
    private TextView fMA;
    private View fMB;
    private View fMC;
    private LinearLayout fMD;
    private TextView fME;
    private m fMF;
    private View fMG;
    private ImageView fMH;
    private TextView fMI;
    private BlueLikeButton fMJ;
    private LinearLayout fMK;
    private RelativeLayout fML;
    private View fMM;
    private TextView fMN;
    private TextView fMO;
    private int fMP;
    protected com.baidu.tieba.view.g fMl;
    protected com.baidu.tieba.personPolymeric.c.a fMm;
    protected ImageView fMo;
    protected PersonHeadPendantView fMp;
    protected UserIconBox fMq;
    protected TextView fMr;
    protected TextView fMs;
    public com.baidu.tieba.view.e fMt;
    protected View fMu;
    private TextView fMv;
    private TextView fMw;
    private TextView fMx;
    private View fMy;
    private View fMz;
    protected Context mContext;
    protected boolean mIsHost;
    private TbPageContext mPageContext;
    protected View mRootView;
    protected UserData mUserData;

    public n(TbPageContext tbPageContext, boolean z) {
        this.fMP = 0;
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.mIsHost = z;
        this.fMP = com.baidu.adp.lib.util.l.e(this.mContext, d.e.tbds46);
        Y(acD());
        TextView textView = this.fMr;
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
        this.fMu = view2.findViewById(d.g.person_info_root);
        this.fMp = (PersonHeadPendantView) view2.findViewById(d.g.person_polymeric_header_user_img);
        this.fMp.getHeadView().setCustomBigViewIconId(d.f.pic_v_avatar_big);
        this.fMp.getHeadView().setIconWidth(this.mContext.getResources().getDimensionPixelSize(d.e.ds40));
        this.fMp.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fEO = (TbImageView) view2.findViewById(d.g.person_polymeric_header_user_vip_icon);
        this.aqm = (TextView) view2.findViewById(d.g.person_polymeric_header_user_name_txt);
        this.fMs = (TextView) view2.findViewById(d.g.seal_prefix_view);
        this.fMq = (UserIconBox) view2.findViewById(d.g.person_polymeric_header_label_box);
        this.fMv = (TextView) view2.findViewById(d.g.person_polymeric_header_bar_age_txt);
        this.bkx = (TextView) view2.findViewById(d.g.person_polymeric_header_ala_id);
        this.fMy = view2.findViewById(d.g.divider_for_alaid_and_age);
        this.fMr = (TextView) view2.findViewById(d.g.person_polymeric_header_visitor_txt);
        this.fMw = (TextView) view2.findViewById(d.g.person_polymeric_header_sign_txt);
        this.fMx = (TextView) view2.findViewById(d.g.person_center_header_tdou_txt);
        this.fMA = (TextView) view2.findViewById(d.g.textview_get_tdou);
        this.fMB = view2.findViewById(d.g.divider_for_age_and_tdou);
        this.fMC = view2.findViewById(d.g.divider_for_tdou_and_get_tdou);
        this.fMD = (LinearLayout) view2.findViewById(d.g.layout_user_name);
        this.fME = (TextView) view2.findViewById(d.g.person_praise_number);
        this.fMx.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(d.f.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
        this.fMt = (PersonHeaderAttentionView) view2.findViewById(d.g.person_center_header_attention_container);
        bfK();
        this.fMF = new m(this.mContext);
        this.fEO.setOnClickListener(this.fMF);
        this.fMq.setOnClickListener(this.fMF);
        this.fMp.setOnClickListener(this.fMF);
        this.fMr.setOnClickListener(this.fMF);
        this.fMs.setOnClickListener(this.fMF);
        this.fMx.setOnClickListener(this.fMF);
        this.fMA.setOnClickListener(this.fMF);
        this.aqm.setOnClickListener(this.fMF);
        this.fMw.setOnClickListener(this.fMF);
        this.fMG = (LinearLayout) view2.findViewById(d.g.container_send_gift);
        this.fMH = (ImageView) view2.findViewById(d.g.icon_gift);
        this.fMI = (TextView) view2.findViewById(d.g.btn_give_gift);
        this.fMG.setOnClickListener(this.fMF);
        this.fMJ = (BlueLikeButton) view2.findViewById(d.g.btn_like_blue);
        this.cnX = new com.baidu.tbadk.core.view.userLike.c(this.mPageContext, this.fMJ);
        this.cnX.setFromType("2");
        if (this.mIsHost) {
            this.fMG.setVisibility(8);
            this.fMJ.setVisibility(8);
        }
        this.fMK = (LinearLayout) view2.findViewById(d.g.layout_god_auth_forums);
        this.fMK.setVisibility(8);
        this.dBG = view2.findViewById(d.g.header_bottom_divider);
        this.fML = (RelativeLayout) view2.findViewById(d.g.layout_gift);
        this.fML.setOnClickListener(this.fMF);
        this.fMM = view2.findViewById(d.g.gift_top_divider);
        this.fMN = (TextView) view2.findViewById(d.g.textview_received_gift);
        this.fMO = (TextView) view2.findViewById(d.g.textview_received_gift_num);
        this.fMo = (ImageView) view2.findViewById(d.g.img_gift_arrow);
    }

    public void e(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null) {
            this.fMm = aVar;
            this.mUserData = aVar.getUserData();
            this.fMF.a(aVar);
            this.fMF.setIsHost(this.mIsHost);
            String portrait = this.mUserData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                if (portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    this.fMp.getHeadView().startLoad(portrait, 10, false);
                } else {
                    String dU = com.baidu.tbadk.core.util.o.dU(portrait);
                    this.fMp.getHeadView().setUrl(dU);
                    this.fMp.getHeadView().startLoad(dU, 25, false);
                }
            } else {
                this.fMp.getHeadView().startLoad(String.valueOf(d.f.pic_mycenter_avatar_def_i), 24, false);
            }
            com.baidu.tbadk.data.h pendantData = this.mUserData.getPendantData();
            if (pendantData != null) {
                this.fMp.eK(pendantData.qG());
            }
            if (this.fMp.wE()) {
                this.fMp.getHeadView().setShowV(false);
            } else if (this.mUserData.isBigV() || !StringUtils.isNull(this.mUserData.getUserTbVipInfoData().getvipV_url())) {
                this.fMp.getHeadView().setShowV(true);
            } else {
                this.fMp.getHeadView().setShowV(false);
            }
            UserVipInfoData userVipInfo = this.mUserData.getUserVipInfo();
            if (this.mUserData.getIsMem() > 0) {
                if (userVipInfo != null) {
                    this.fEO.startLoad(userVipInfo.getVipIconUrl(), 10, false);
                }
                this.fEO.setVisibility(0);
            } else if (this.mIsHost) {
                this.fEO.setImageDrawable(ak.getDrawable(d.f.icon_crown_super_non));
                this.fEO.setVisibility(0);
            } else {
                this.fEO.setVisibility(8);
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
            this.fMq.a(this.mUserData.getIconInfo(), 9, this.mContext.getResources().getDimensionPixelSize(d.e.tbds42), this.mContext.getResources().getDimensionPixelSize(d.e.tbds42), this.mContext.getResources().getDimensionPixelSize(d.e.tbds10), true);
            if (this.fMt != null) {
                this.fMt.setData(this.mUserData);
            }
            if (this.mUserData != null && this.mUserData.alaUserData != null && this.mUserData.alaUserData.ala_id != 0) {
                this.bkx.setVisibility(0);
                this.fMy.setVisibility(0);
                this.bkx.setText(String.format(this.mContext.getString(d.k.person_center_ala_id), Long.valueOf(this.mUserData.alaUserData.ala_id)));
            } else {
                this.bkx.setVisibility(8);
                this.fMy.setVisibility(8);
            }
            this.fMv.setText(String.format(this.mContext.getString(d.k.person_center_header_bar_age), this.mUserData.getTb_age()));
            if (this.mIsHost) {
                this.fMB.setVisibility(0);
                this.fMC.setVisibility(0);
                this.fMx.setVisibility(0);
                this.fMA.setVisibility(0);
                this.fMx.setText(an.H(this.mUserData.getTDouNum()));
            } else {
                this.fMB.setVisibility(8);
                this.fMC.setVisibility(8);
                this.fMx.setVisibility(8);
                this.fMA.setVisibility(8);
            }
            String intro = this.mUserData.getIntro();
            if (StringUtils.isNull(intro)) {
                ak.c(this.fMw, d.C0126d.cp_cont_e, 1);
            } else {
                ak.c(this.fMw, d.C0126d.cp_cont_j, 1);
            }
            if (StringUtils.isNull(intro)) {
                if (this.mIsHost) {
                    intro = this.mContext.getString(d.k.no_person_sign_host);
                } else {
                    intro = this.mContext.getString(d.k.no_person_sign_guest);
                }
            }
            this.fMw.setText(this.mContext.getString(d.k.person_sign) + intro);
            if (this.fMw.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fMw.getLayoutParams();
                if (!this.mIsHost && this.fMw.getLineCount() >= 3 && this.fMw.getMaxLines() != 2147483646) {
                    int lineHeight = this.fMw.getLineHeight();
                    this.fMw.setHeight((lineHeight / 2) + (lineHeight * 3));
                }
                if (this.fMw.getLineCount() >= 2) {
                    layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(d.e.tbds19);
                } else {
                    layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(d.e.tbds80);
                }
                this.fMw.setLayoutParams(layoutParams);
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(this.mUserData.getUserId()) && ((!TbadkCoreApplication.isLogin() || (!StringUtils.isNull(currentAccount) && !currentAccount.equals(this.mUserData.getUserId()))) && this.mUserData.getLiveStatus() == 1)) {
                if (this.fMz == null) {
                    this.fMz = com.baidu.tbadk.ala.b.os().f(this.mContext, 7);
                }
                com.baidu.tbadk.ala.a aVar2 = new com.baidu.tbadk.ala.a();
                aVar2.Se = this.mUserData.getAlaUserData();
                aVar2.type = 7;
                if ((this.mUserData.getPersonPrivate() != null && this.mUserData.getPersonPrivate().Dh() == 3) || (this.mUserData.getPersonPrivate().Dh() == 2 && this.mUserData.getIsFriend() != 1)) {
                    aVar2.Sf = true;
                } else {
                    aVar2.Sf = false;
                }
                if (this.fMz != null) {
                    this.fMz.setTag(aVar2);
                    if (this.fMz.getParent() == null) {
                        this.fMD.addView(this.fMz);
                        TiebaStatic.log(new al("c12541"));
                    }
                }
            } else if (this.fMz != null) {
                this.fMz.setVisibility(8);
            }
            a(aVar.fKg);
            this.mUserData.setIsLike(this.mUserData.getHave_attention() == 1);
            this.cnX.a(this.mUserData);
            bfL();
            bfM();
            this.fMN.setText(this.mIsHost ? d.k.my_received_gift : d.k.he_received_gift);
            if ((this.mUserData.getPersonPrivate() == null || this.mUserData.getPersonPrivate().Dh() != 3) && this.mUserData.getPersonPrivate().Dh() == 2 && this.mUserData.getIsFriend() != 1) {
            }
        }
    }

    private void a(UserAgreeInfo userAgreeInfo) {
        if (userAgreeInfo == null) {
            this.fME.setVisibility(8);
            return;
        }
        this.fME.setVisibility(0);
        String B = an.B(userAgreeInfo.total_agree_num.longValue());
        Drawable drawable = ak.getDrawable(d.f.icon_home_card_like_s);
        drawable.setBounds(0, 0, this.fMP, this.fMP);
        this.fME.setCompoundDrawables(drawable, null, null, null);
        this.fME.setText(B);
    }

    public void onChangeSkinType(int i) {
        this.fMu.setBackgroundDrawable(ak.getDrawable(d.f.shape_user_info_bg));
        this.fMp.setBackgroundViewDrawable(ak.getDrawable(d.f.shape_user_img_bg));
        int i2 = d.f.icon_mine_boy;
        if (this.mUserData != null) {
            i2 = this.mUserData.getSex() == 1 ? d.f.icon_mine_boy : d.f.icon_pop_girl;
        }
        if (this.mUserData != null && this.mUserData.getIsMem() <= 0 && this.fEO != null && this.mIsHost) {
            this.fEO.setImageDrawable(ak.getDrawable(d.f.icon_crown_super_non));
        }
        bdP();
        ak.c(this.fMs, d.C0126d.cp_link_tip_a, 1);
        this.aqm.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mContext.getResources().getDrawable(i2), (Drawable) null);
        if (this.fMt != null) {
            this.fMt.onChangeSkinType(i);
        }
        ak.c(this.fMr, d.C0126d.cp_cont_b, 1);
        ak.c(this.fMv, d.C0126d.cp_cont_b, 1);
        ak.c(this.bkx, d.C0126d.cp_cont_b, 1);
        if (this.mUserData == null || StringUtils.isNull(this.mUserData.getIntro())) {
            ak.c(this.fMw, d.C0126d.cp_cont_e, 1);
        } else {
            ak.c(this.fMw, d.C0126d.cp_cont_j, 1);
        }
        ak.c(this.fMx, d.C0126d.cp_cont_b, 1);
        ak.c(this.fMA, d.C0126d.cp_cont_b, 1);
        ak.j(this.fMB, d.C0126d.cp_bg_line_b);
        ak.j(this.fMy, d.C0126d.cp_bg_line_b);
        ak.j(this.fMC, d.C0126d.cp_bg_line_b);
        ak.h(this.fME, d.C0126d.cp_cont_h);
        this.fMx.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(d.f.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
        Drawable u = ak.u(i, d.f.icon_home_card_like_s);
        u.setBounds(0, 0, this.fMP, this.fMP);
        this.fME.setCompoundDrawables(u, null, null, null);
        ak.i(this.fMG, d.f.selector_give_gift_bg);
        ak.c(this.fMH, d.f.selector_gift_icon);
        ak.c(this.fMI, d.C0126d.selector_give_gift_text_color, 1);
        this.fMJ.onChangeSkinType(i);
        ak.j(this.dBG, d.C0126d.cp_bg_line_e);
        for (int i3 = 0; i3 < this.fMK.getChildCount(); i3++) {
            View childAt = this.fMK.getChildAt(i3);
            if (childAt != null) {
                TextView textView = (TextView) childAt.findViewById(d.g.bar_name);
                textView.setCompoundDrawablesWithIntrinsicBounds(ak.getDrawable(d.f.pic_v_avatar), (Drawable) null, (Drawable) null, (Drawable) null);
                ak.h(textView, d.C0126d.cp_cont_b);
                ak.h((TextView) childAt.findViewById(d.g.bar_info), d.C0126d.cp_cont_j);
            }
        }
        for (int i4 = 0; i4 < fMn.length; i4++) {
            ((TbImageView) this.mRootView.findViewById(fMn[i4])).setBackgroundDrawable(ak.getDrawable(d.f.shape_gift_icon_bg));
        }
        ak.j(this.fMM, d.C0126d.cp_bg_line_e);
        ak.h(this.fMN, d.C0126d.cp_cont_b);
        ak.h(this.fMO, d.C0126d.cp_cont_d);
        ak.c(this.fMo, d.f.icon_arrow_gray_right_n);
    }

    public void onDestory() {
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.g gVar) {
        this.fMl = gVar;
        if (this.fMt != null) {
            this.fMt.setOnViewResponseListener(this.fMl);
        }
        this.fMF.setOnViewResponseListener(this.fMl);
    }

    public void rm(String str) {
        this.fMp.eK(str);
        if (!StringUtils.isNull(str)) {
            this.fMp.getHeadView().setShowV(false);
        } else if (this.mUserData.isBigV() || !StringUtils.isNull(this.mUserData.getUserTbVipInfoData().getvipV_url())) {
            this.fMp.getHeadView().setShowV(true);
        } else {
            this.fMp.getHeadView().setShowV(false);
        }
    }

    protected void bfK() {
        this.fMp.setHasPendantStyle();
        this.fMp.getHeadView().setIsRound(true);
        this.fMp.getHeadView().setDrawBorder(false);
        this.fMp.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    protected void bdP() {
        if (this.mUserData != null && (this.mUserData.getIsMem() > 0 || this.mUserData.isBigV())) {
            ak.c(this.aqm, d.C0126d.cp_cont_h, 1);
        } else {
            ak.c(this.aqm, d.C0126d.cp_cont_b, 1);
        }
    }

    private void bfL() {
        if (this.fMm != null && this.fMm.bfE() != null) {
            this.fMK.removeAllViews();
            int godType = this.fMm.bfE().getGodType();
            if (godType == 2 && v.v(this.fMm.bfE().getForumGodList()) > 0) {
                this.fMK.setVisibility(0);
                for (ForumGodDetailInfo forumGodDetailInfo : this.fMm.bfE().getForumGodList()) {
                    if (forumGodDetailInfo != null) {
                        bJ(forumGodDetailInfo.forum_name, forumGodDetailInfo.intro);
                    }
                }
                return;
            } else if (godType == 1 && this.fMm.bfE().getgodDetailInfo() != null && !StringUtils.isNull(this.fMm.bfE().getgodDetailInfo().intro)) {
                this.fMK.setVisibility(0);
                bJ(this.fMm.bfE().getgodDetailInfo().intro, "");
                return;
            } else {
                return;
            }
        }
        this.fMK.setVisibility(8);
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
        this.fMK.addView(inflate, layoutParams);
    }

    private void bfM() {
        int i;
        for (int i2 = 0; i2 < fMn.length; i2++) {
            ((TbImageView) this.mRootView.findViewById(fMn[i2])).setVisibility(8);
        }
        if (this.fMm == null || this.fMm.bfD() == null || v.v(this.fMm.bfD().fKu) <= 0) {
            i = 0;
        } else {
            int i3 = this.fMm.bfD().giftNum;
            List<com.baidu.adp.widget.ListView.h> list = this.fMm.bfD().fKu;
            for (int i4 = 0; i4 < list.size() && i4 < fMn.length; i4++) {
                if (list.get(i4) instanceof com.baidu.tieba.personPolymeric.c.o) {
                    TbImageView tbImageView = (TbImageView) this.mRootView.findViewById(fMn[i4]);
                    tbImageView.setVisibility(0);
                    tbImageView.setIsRound(true);
                    tbImageView.startLoad(((com.baidu.tieba.personPolymeric.c.o) list.get(i4)).picUrl, 10, false);
                }
            }
            i = i3;
        }
        this.fMO.setText(String.format(this.mContext.getResources().getString(d.k.gift_num), Integer.valueOf(i)));
    }
}
