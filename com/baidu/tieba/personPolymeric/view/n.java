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
    private static final int[] fMq = {d.g.img_gift_one, d.g.img_gift_two, d.g.img_gift_three};
    protected TextView aqm;
    private TextView bkx;
    private com.baidu.tbadk.core.view.userLike.c coa;
    private View dBJ;
    protected TbImageView fER;
    private TextView fMA;
    private View fMB;
    private View fMC;
    private TextView fMD;
    private View fME;
    private View fMF;
    private LinearLayout fMG;
    private TextView fMH;
    private m fMI;
    private View fMJ;
    private ImageView fMK;
    private TextView fML;
    private BlueLikeButton fMM;
    private LinearLayout fMN;
    private RelativeLayout fMO;
    private View fMP;
    private TextView fMQ;
    private TextView fMR;
    private int fMS;
    protected com.baidu.tieba.view.g fMo;
    protected com.baidu.tieba.personPolymeric.c.a fMp;
    protected ImageView fMr;
    protected PersonHeadPendantView fMs;
    protected UserIconBox fMt;
    protected TextView fMu;
    protected TextView fMv;
    public com.baidu.tieba.view.e fMw;
    protected View fMx;
    private TextView fMy;
    private TextView fMz;
    protected Context mContext;
    protected boolean mIsHost;
    private TbPageContext mPageContext;
    protected View mRootView;
    protected UserData mUserData;

    public n(TbPageContext tbPageContext, boolean z) {
        this.fMS = 0;
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.mIsHost = z;
        this.fMS = com.baidu.adp.lib.util.l.e(this.mContext, d.e.tbds46);
        Y(acD());
        TextView textView = this.fMu;
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
        this.fMx = view2.findViewById(d.g.person_info_root);
        this.fMs = (PersonHeadPendantView) view2.findViewById(d.g.person_polymeric_header_user_img);
        this.fMs.getHeadView().setCustomBigViewIconId(d.f.pic_v_avatar_big);
        this.fMs.getHeadView().setIconWidth(this.mContext.getResources().getDimensionPixelSize(d.e.ds40));
        this.fMs.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fER = (TbImageView) view2.findViewById(d.g.person_polymeric_header_user_vip_icon);
        this.aqm = (TextView) view2.findViewById(d.g.person_polymeric_header_user_name_txt);
        this.fMv = (TextView) view2.findViewById(d.g.seal_prefix_view);
        this.fMt = (UserIconBox) view2.findViewById(d.g.person_polymeric_header_label_box);
        this.fMy = (TextView) view2.findViewById(d.g.person_polymeric_header_bar_age_txt);
        this.bkx = (TextView) view2.findViewById(d.g.person_polymeric_header_ala_id);
        this.fMB = view2.findViewById(d.g.divider_for_alaid_and_age);
        this.fMu = (TextView) view2.findViewById(d.g.person_polymeric_header_visitor_txt);
        this.fMz = (TextView) view2.findViewById(d.g.person_polymeric_header_sign_txt);
        this.fMA = (TextView) view2.findViewById(d.g.person_center_header_tdou_txt);
        this.fMD = (TextView) view2.findViewById(d.g.textview_get_tdou);
        this.fME = view2.findViewById(d.g.divider_for_age_and_tdou);
        this.fMF = view2.findViewById(d.g.divider_for_tdou_and_get_tdou);
        this.fMG = (LinearLayout) view2.findViewById(d.g.layout_user_name);
        this.fMH = (TextView) view2.findViewById(d.g.person_praise_number);
        this.fMA.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(d.f.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
        this.fMw = (PersonHeaderAttentionView) view2.findViewById(d.g.person_center_header_attention_container);
        bfK();
        this.fMI = new m(this.mContext);
        this.fER.setOnClickListener(this.fMI);
        this.fMt.setOnClickListener(this.fMI);
        this.fMs.setOnClickListener(this.fMI);
        this.fMu.setOnClickListener(this.fMI);
        this.fMv.setOnClickListener(this.fMI);
        this.fMA.setOnClickListener(this.fMI);
        this.fMD.setOnClickListener(this.fMI);
        this.aqm.setOnClickListener(this.fMI);
        this.fMz.setOnClickListener(this.fMI);
        this.fMJ = (LinearLayout) view2.findViewById(d.g.container_send_gift);
        this.fMK = (ImageView) view2.findViewById(d.g.icon_gift);
        this.fML = (TextView) view2.findViewById(d.g.btn_give_gift);
        this.fMJ.setOnClickListener(this.fMI);
        this.fMM = (BlueLikeButton) view2.findViewById(d.g.btn_like_blue);
        this.coa = new com.baidu.tbadk.core.view.userLike.c(this.mPageContext, this.fMM);
        this.coa.setFromType("2");
        if (this.mIsHost) {
            this.fMJ.setVisibility(8);
            this.fMM.setVisibility(8);
        }
        this.fMN = (LinearLayout) view2.findViewById(d.g.layout_god_auth_forums);
        this.fMN.setVisibility(8);
        this.dBJ = view2.findViewById(d.g.header_bottom_divider);
        this.fMO = (RelativeLayout) view2.findViewById(d.g.layout_gift);
        this.fMO.setOnClickListener(this.fMI);
        this.fMP = view2.findViewById(d.g.gift_top_divider);
        this.fMQ = (TextView) view2.findViewById(d.g.textview_received_gift);
        this.fMR = (TextView) view2.findViewById(d.g.textview_received_gift_num);
        this.fMr = (ImageView) view2.findViewById(d.g.img_gift_arrow);
    }

    public void e(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null) {
            this.fMp = aVar;
            this.mUserData = aVar.getUserData();
            this.fMI.a(aVar);
            this.fMI.setIsHost(this.mIsHost);
            String portrait = this.mUserData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                if (portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    this.fMs.getHeadView().startLoad(portrait, 10, false);
                } else {
                    String dU = com.baidu.tbadk.core.util.o.dU(portrait);
                    this.fMs.getHeadView().setUrl(dU);
                    this.fMs.getHeadView().startLoad(dU, 25, false);
                }
            } else {
                this.fMs.getHeadView().startLoad(String.valueOf(d.f.pic_mycenter_avatar_def_i), 24, false);
            }
            com.baidu.tbadk.data.h pendantData = this.mUserData.getPendantData();
            if (pendantData != null) {
                this.fMs.eK(pendantData.qG());
            }
            if (this.fMs.wE()) {
                this.fMs.getHeadView().setShowV(false);
            } else if (this.mUserData.isBigV() || !StringUtils.isNull(this.mUserData.getUserTbVipInfoData().getvipV_url())) {
                this.fMs.getHeadView().setShowV(true);
            } else {
                this.fMs.getHeadView().setShowV(false);
            }
            UserVipInfoData userVipInfo = this.mUserData.getUserVipInfo();
            if (this.mUserData.getIsMem() > 0) {
                if (userVipInfo != null) {
                    this.fER.startLoad(userVipInfo.getVipIconUrl(), 10, false);
                }
                this.fER.setVisibility(0);
            } else if (this.mIsHost) {
                this.fER.setImageDrawable(ak.getDrawable(d.f.icon_crown_super_non));
                this.fER.setVisibility(0);
            } else {
                this.fER.setVisibility(8);
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
            this.fMt.a(this.mUserData.getIconInfo(), 9, this.mContext.getResources().getDimensionPixelSize(d.e.tbds42), this.mContext.getResources().getDimensionPixelSize(d.e.tbds42), this.mContext.getResources().getDimensionPixelSize(d.e.tbds10), true);
            if (this.fMw != null) {
                this.fMw.setData(this.mUserData);
            }
            if (this.mUserData != null && this.mUserData.alaUserData != null && this.mUserData.alaUserData.ala_id != 0) {
                this.bkx.setVisibility(0);
                this.fMB.setVisibility(0);
                this.bkx.setText(String.format(this.mContext.getString(d.k.person_center_ala_id), Long.valueOf(this.mUserData.alaUserData.ala_id)));
            } else {
                this.bkx.setVisibility(8);
                this.fMB.setVisibility(8);
            }
            this.fMy.setText(String.format(this.mContext.getString(d.k.person_center_header_bar_age), this.mUserData.getTb_age()));
            if (this.mIsHost) {
                this.fME.setVisibility(0);
                this.fMF.setVisibility(0);
                this.fMA.setVisibility(0);
                this.fMD.setVisibility(0);
                this.fMA.setText(an.H(this.mUserData.getTDouNum()));
            } else {
                this.fME.setVisibility(8);
                this.fMF.setVisibility(8);
                this.fMA.setVisibility(8);
                this.fMD.setVisibility(8);
            }
            String intro = this.mUserData.getIntro();
            if (StringUtils.isNull(intro)) {
                ak.c(this.fMz, d.C0126d.cp_cont_e, 1);
            } else {
                ak.c(this.fMz, d.C0126d.cp_cont_j, 1);
            }
            if (StringUtils.isNull(intro)) {
                if (this.mIsHost) {
                    intro = this.mContext.getString(d.k.no_person_sign_host);
                } else {
                    intro = this.mContext.getString(d.k.no_person_sign_guest);
                }
            }
            this.fMz.setText(this.mContext.getString(d.k.person_sign) + intro);
            if (this.fMz.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fMz.getLayoutParams();
                if (!this.mIsHost && this.fMz.getLineCount() >= 3 && this.fMz.getMaxLines() != 2147483646) {
                    int lineHeight = this.fMz.getLineHeight();
                    this.fMz.setHeight((lineHeight / 2) + (lineHeight * 3));
                }
                if (this.fMz.getLineCount() >= 2) {
                    layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(d.e.tbds19);
                } else {
                    layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(d.e.tbds80);
                }
                this.fMz.setLayoutParams(layoutParams);
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(this.mUserData.getUserId()) && ((!TbadkCoreApplication.isLogin() || (!StringUtils.isNull(currentAccount) && !currentAccount.equals(this.mUserData.getUserId()))) && this.mUserData.getLiveStatus() == 1)) {
                if (this.fMC == null) {
                    this.fMC = com.baidu.tbadk.ala.b.os().f(this.mContext, 7);
                }
                com.baidu.tbadk.ala.a aVar2 = new com.baidu.tbadk.ala.a();
                aVar2.Se = this.mUserData.getAlaUserData();
                aVar2.type = 7;
                if ((this.mUserData.getPersonPrivate() != null && this.mUserData.getPersonPrivate().Dh() == 3) || (this.mUserData.getPersonPrivate().Dh() == 2 && this.mUserData.getIsFriend() != 1)) {
                    aVar2.Sf = true;
                } else {
                    aVar2.Sf = false;
                }
                if (this.fMC != null) {
                    this.fMC.setTag(aVar2);
                    if (this.fMC.getParent() == null) {
                        this.fMG.addView(this.fMC);
                        TiebaStatic.log(new al("c12541"));
                    }
                }
            } else if (this.fMC != null) {
                this.fMC.setVisibility(8);
            }
            a(aVar.fKj);
            this.mUserData.setIsLike(this.mUserData.getHave_attention() == 1);
            this.coa.a(this.mUserData);
            bfL();
            bfM();
            this.fMQ.setText(this.mIsHost ? d.k.my_received_gift : d.k.he_received_gift);
            if ((this.mUserData.getPersonPrivate() == null || this.mUserData.getPersonPrivate().Dh() != 3) && this.mUserData.getPersonPrivate().Dh() == 2 && this.mUserData.getIsFriend() != 1) {
            }
        }
    }

    private void a(UserAgreeInfo userAgreeInfo) {
        if (userAgreeInfo == null) {
            this.fMH.setVisibility(8);
            return;
        }
        this.fMH.setVisibility(0);
        String B = an.B(userAgreeInfo.total_agree_num.longValue());
        Drawable drawable = ak.getDrawable(d.f.icon_home_card_like_s);
        drawable.setBounds(0, 0, this.fMS, this.fMS);
        this.fMH.setCompoundDrawables(drawable, null, null, null);
        this.fMH.setText(B);
    }

    public void onChangeSkinType(int i) {
        this.fMx.setBackgroundDrawable(ak.getDrawable(d.f.shape_user_info_bg));
        this.fMs.setBackgroundViewDrawable(ak.getDrawable(d.f.shape_user_img_bg));
        int i2 = d.f.icon_mine_boy;
        if (this.mUserData != null) {
            i2 = this.mUserData.getSex() == 1 ? d.f.icon_mine_boy : d.f.icon_pop_girl;
        }
        if (this.mUserData != null && this.mUserData.getIsMem() <= 0 && this.fER != null && this.mIsHost) {
            this.fER.setImageDrawable(ak.getDrawable(d.f.icon_crown_super_non));
        }
        bdP();
        ak.c(this.fMv, d.C0126d.cp_link_tip_a, 1);
        this.aqm.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mContext.getResources().getDrawable(i2), (Drawable) null);
        if (this.fMw != null) {
            this.fMw.onChangeSkinType(i);
        }
        ak.c(this.fMu, d.C0126d.cp_cont_b, 1);
        ak.c(this.fMy, d.C0126d.cp_cont_b, 1);
        ak.c(this.bkx, d.C0126d.cp_cont_b, 1);
        if (this.mUserData == null || StringUtils.isNull(this.mUserData.getIntro())) {
            ak.c(this.fMz, d.C0126d.cp_cont_e, 1);
        } else {
            ak.c(this.fMz, d.C0126d.cp_cont_j, 1);
        }
        ak.c(this.fMA, d.C0126d.cp_cont_b, 1);
        ak.c(this.fMD, d.C0126d.cp_cont_b, 1);
        ak.j(this.fME, d.C0126d.cp_bg_line_b);
        ak.j(this.fMB, d.C0126d.cp_bg_line_b);
        ak.j(this.fMF, d.C0126d.cp_bg_line_b);
        ak.h(this.fMH, d.C0126d.cp_cont_h);
        this.fMA.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(d.f.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
        Drawable u = ak.u(i, d.f.icon_home_card_like_s);
        u.setBounds(0, 0, this.fMS, this.fMS);
        this.fMH.setCompoundDrawables(u, null, null, null);
        ak.i(this.fMJ, d.f.selector_give_gift_bg);
        ak.c(this.fMK, d.f.selector_gift_icon);
        ak.c(this.fML, d.C0126d.selector_give_gift_text_color, 1);
        this.fMM.onChangeSkinType(i);
        ak.j(this.dBJ, d.C0126d.cp_bg_line_e);
        for (int i3 = 0; i3 < this.fMN.getChildCount(); i3++) {
            View childAt = this.fMN.getChildAt(i3);
            if (childAt != null) {
                TextView textView = (TextView) childAt.findViewById(d.g.bar_name);
                textView.setCompoundDrawablesWithIntrinsicBounds(ak.getDrawable(d.f.pic_v_avatar), (Drawable) null, (Drawable) null, (Drawable) null);
                ak.h(textView, d.C0126d.cp_cont_b);
                ak.h((TextView) childAt.findViewById(d.g.bar_info), d.C0126d.cp_cont_j);
            }
        }
        for (int i4 = 0; i4 < fMq.length; i4++) {
            ((TbImageView) this.mRootView.findViewById(fMq[i4])).setBackgroundDrawable(ak.getDrawable(d.f.shape_gift_icon_bg));
        }
        ak.j(this.fMP, d.C0126d.cp_bg_line_e);
        ak.h(this.fMQ, d.C0126d.cp_cont_b);
        ak.h(this.fMR, d.C0126d.cp_cont_d);
        ak.c(this.fMr, d.f.icon_arrow_gray_right_n);
    }

    public void onDestory() {
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.g gVar) {
        this.fMo = gVar;
        if (this.fMw != null) {
            this.fMw.setOnViewResponseListener(this.fMo);
        }
        this.fMI.setOnViewResponseListener(this.fMo);
    }

    public void rm(String str) {
        this.fMs.eK(str);
        if (!StringUtils.isNull(str)) {
            this.fMs.getHeadView().setShowV(false);
        } else if (this.mUserData.isBigV() || !StringUtils.isNull(this.mUserData.getUserTbVipInfoData().getvipV_url())) {
            this.fMs.getHeadView().setShowV(true);
        } else {
            this.fMs.getHeadView().setShowV(false);
        }
    }

    protected void bfK() {
        this.fMs.setHasPendantStyle();
        this.fMs.getHeadView().setIsRound(true);
        this.fMs.getHeadView().setDrawBorder(false);
        this.fMs.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    protected void bdP() {
        if (this.mUserData != null && (this.mUserData.getIsMem() > 0 || this.mUserData.isBigV())) {
            ak.c(this.aqm, d.C0126d.cp_cont_h, 1);
        } else {
            ak.c(this.aqm, d.C0126d.cp_cont_b, 1);
        }
    }

    private void bfL() {
        if (this.fMp != null && this.fMp.bfE() != null) {
            this.fMN.removeAllViews();
            int godType = this.fMp.bfE().getGodType();
            if (godType == 2 && v.v(this.fMp.bfE().getForumGodList()) > 0) {
                this.fMN.setVisibility(0);
                for (ForumGodDetailInfo forumGodDetailInfo : this.fMp.bfE().getForumGodList()) {
                    if (forumGodDetailInfo != null) {
                        bJ(forumGodDetailInfo.forum_name, forumGodDetailInfo.intro);
                    }
                }
                return;
            } else if (godType == 1 && this.fMp.bfE().getgodDetailInfo() != null && !StringUtils.isNull(this.fMp.bfE().getgodDetailInfo().intro)) {
                this.fMN.setVisibility(0);
                bJ(this.fMp.bfE().getgodDetailInfo().intro, "");
                return;
            } else {
                return;
            }
        }
        this.fMN.setVisibility(8);
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
        this.fMN.addView(inflate, layoutParams);
    }

    private void bfM() {
        int i;
        for (int i2 = 0; i2 < fMq.length; i2++) {
            ((TbImageView) this.mRootView.findViewById(fMq[i2])).setVisibility(8);
        }
        if (this.fMp == null || this.fMp.bfD() == null || v.v(this.fMp.bfD().fKx) <= 0) {
            i = 0;
        } else {
            int i3 = this.fMp.bfD().giftNum;
            List<com.baidu.adp.widget.ListView.h> list = this.fMp.bfD().fKx;
            for (int i4 = 0; i4 < list.size() && i4 < fMq.length; i4++) {
                if (list.get(i4) instanceof com.baidu.tieba.personPolymeric.c.o) {
                    TbImageView tbImageView = (TbImageView) this.mRootView.findViewById(fMq[i4]);
                    tbImageView.setVisibility(0);
                    tbImageView.setIsRound(true);
                    tbImageView.startLoad(((com.baidu.tieba.personPolymeric.c.o) list.get(i4)).picUrl, 10, false);
                }
            }
            i = i3;
        }
        this.fMR.setText(String.format(this.mContext.getResources().getString(d.k.gift_num), Integer.valueOf(i)));
    }
}
