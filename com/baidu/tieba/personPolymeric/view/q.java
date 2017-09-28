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
    private static final int[] fiP = {d.h.img_gift_one, d.h.img_gift_two, d.h.img_gift_three};
    protected TextView aou;
    private com.baidu.tbadk.core.view.userLike.c bKb;
    private TextView cMh;
    private View cUW;
    protected PersonHeadPendantView fbp;
    protected TbImageView fbq;
    protected com.baidu.tieba.view.g fiN;
    protected com.baidu.tieba.personPolymeric.c.a fiO;
    protected UserIconBox fiQ;
    protected TextView fiR;
    protected TextView fiS;
    public com.baidu.tieba.view.e fiT;
    protected View fiU;
    private TextView fiV;
    private TextView fiW;
    private TextView fiX;
    private View fiY;
    private View fiZ;
    private View fja;
    private LinearLayout fjb;
    private TextView fjc;
    private p fjd;
    private TextView fje;
    private BlueLikeButton fjf;
    private LinearLayout fjg;
    private RelativeLayout fjh;
    private View fji;
    private TextView fjj;
    private TextView fjk;
    protected Context mContext;
    private TbPageContext mG;
    protected boolean mIsHost;
    protected View mRootView;
    protected UserData mUserData;

    public q(TbPageContext tbPageContext, boolean z) {
        this.mG = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.mIsHost = z;
        X(VV());
        TextView textView = this.fiR;
        if (this.mIsHost) {
        }
        textView.setVisibility(8);
    }

    public View VV() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(d.j.item_person_polymeric_header_view, (ViewGroup) null);
        }
        return this.mRootView;
    }

    public void X(View view) {
        this.fiU = view.findViewById(d.h.person_info_root);
        this.fbp = (PersonHeadPendantView) view.findViewById(d.h.person_polymeric_header_user_img);
        this.fbp.getHeadView().setCustomBigViewIconId(d.g.pic_v_avatar_big);
        this.fbp.getHeadView().setIconWidth(this.mContext.getResources().getDimensionPixelSize(d.f.ds40));
        this.fbq = (TbImageView) view.findViewById(d.h.person_polymeric_header_user_vip_icon);
        this.aou = (TextView) view.findViewById(d.h.person_polymeric_header_user_name_txt);
        this.fiS = (TextView) view.findViewById(d.h.seal_prefix_view);
        this.fiQ = (UserIconBox) view.findViewById(d.h.person_polymeric_header_label_box);
        this.fiV = (TextView) view.findViewById(d.h.person_polymeric_header_bar_age_txt);
        this.fiR = (TextView) view.findViewById(d.h.person_polymeric_header_visitor_txt);
        this.fiW = (TextView) view.findViewById(d.h.person_polymeric_header_sign_txt);
        this.fiX = (TextView) view.findViewById(d.h.person_center_header_tdou_txt);
        this.cMh = (TextView) view.findViewById(d.h.textview_get_tdou);
        this.fiZ = view.findViewById(d.h.divider_for_age_and_tdou);
        this.fja = view.findViewById(d.h.divider_for_tdou_and_get_tdou);
        this.fjb = (LinearLayout) view.findViewById(d.h.layout_user_name);
        this.fjc = (TextView) view.findViewById(d.h.person_praise_number);
        this.fiX.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(d.g.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
        this.fiT = (PersonHeaderAttentionView) view.findViewById(d.h.person_center_header_attention_container);
        aXi();
        this.fjd = new p(this.mContext);
        this.fbq.setOnClickListener(this.fjd);
        this.fiQ.setOnClickListener(this.fjd);
        this.fbp.setOnClickListener(this.fjd);
        this.fiR.setOnClickListener(this.fjd);
        this.fiS.setOnClickListener(this.fjd);
        this.fiX.setOnClickListener(this.fjd);
        this.cMh.setOnClickListener(this.fjd);
        this.aou.setOnClickListener(this.fjd);
        this.fiW.setOnClickListener(this.fjd);
        this.fje = (TextView) view.findViewById(d.h.btn_give_gift);
        this.fje.setOnClickListener(this.fjd);
        this.fjf = (BlueLikeButton) view.findViewById(d.h.btn_like_blue);
        this.bKb = new com.baidu.tbadk.core.view.userLike.c(this.mG, this.fjf);
        this.bKb.setFromType("2");
        if (this.mIsHost) {
            this.fje.setVisibility(8);
            this.fjf.setVisibility(8);
        }
        this.fjg = (LinearLayout) view.findViewById(d.h.layout_god_auth_forums);
        this.fjg.setVisibility(8);
        this.cUW = view.findViewById(d.h.header_bottom_divider);
        this.fjh = (RelativeLayout) view.findViewById(d.h.layout_gift);
        this.fjh.setOnClickListener(this.fjd);
        this.fji = view.findViewById(d.h.gift_top_divider);
        this.fjj = (TextView) view.findViewById(d.h.textview_received_gift);
        this.fjk = (TextView) view.findViewById(d.h.textview_received_gift_num);
    }

    public void e(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null) {
            this.fiO = aVar;
            this.mUserData = aVar.getUserData();
            this.fjd.a(aVar);
            this.fjd.setIsHost(this.mIsHost);
            String portrait = this.mUserData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                String dz = com.baidu.tbadk.core.util.o.dz(portrait);
                this.fbp.getHeadView().setUrl(dz);
                this.fbp.getHeadView().c(dz, 25, false);
            } else {
                this.fbp.getHeadView().c(String.valueOf(d.g.pic_mycenter_avatar_def_i), 24, false);
            }
            com.baidu.tbadk.data.i pendantData = this.mUserData.getPendantData();
            if (pendantData != null) {
                this.fbp.ei(pendantData.pS());
            }
            if (this.fbp.wf()) {
                this.fbp.getHeadView().setShowV(false);
            } else if (this.mUserData.isBigV() || !StringUtils.isNull(this.mUserData.getUserTbVipInfoData().getvipV_url())) {
                this.fbp.getHeadView().setShowV(true);
            } else {
                this.fbp.getHeadView().setShowV(false);
            }
            UserVipInfoData userVipInfo = this.mUserData.getUserVipInfo();
            if (this.mUserData.getIsMem() > 0) {
                if (userVipInfo != null) {
                    this.fbq.c(userVipInfo.getVipIconUrl(), 10, false);
                }
                this.fbq.setVisibility(0);
            } else if (this.mIsHost) {
                this.fbq.setImageDrawable(aj.getDrawable(d.g.icon_crown_super_non));
                this.fbq.setVisibility(0);
            } else {
                this.fbq.setVisibility(8);
            }
            aVw();
            String name_show = this.mUserData.getName_show();
            if (!TextUtils.isEmpty(name_show)) {
                this.aou.setText(name_show);
            }
            int i = d.g.icon_pop_boy;
            if (this.mUserData != null) {
                i = this.mUserData.getSex() == 2 ? d.g.icon_pop_girl : d.g.icon_pop_boy;
            }
            this.aou.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mContext.getResources().getDrawable(i), (Drawable) null);
            this.fiQ.a(this.mUserData.getIconInfo(), 9, this.mContext.getResources().getDimensionPixelSize(d.f.ds34), this.mContext.getResources().getDimensionPixelSize(d.f.ds34), this.mContext.getResources().getDimensionPixelSize(d.f.ds10), true);
            if (this.fiT != null) {
                this.fiT.setData(this.mUserData);
            }
            this.fiV.setText(String.format(this.mContext.getString(d.l.person_center_header_bar_age), this.mUserData.getTb_age()));
            if (this.mIsHost) {
                this.fiZ.setVisibility(0);
                this.fja.setVisibility(0);
                this.fiX.setVisibility(0);
                this.cMh.setVisibility(0);
                this.fiX.setText(am.G(this.mUserData.getTDouNum()));
            } else {
                this.fiZ.setVisibility(8);
                this.fja.setVisibility(8);
                this.fiX.setVisibility(8);
                this.cMh.setVisibility(8);
            }
            String intro = this.mUserData.getIntro();
            if (StringUtils.isNull(intro)) {
                aj.c(this.fiW, d.e.cp_cont_e, 1);
            } else {
                aj.c(this.fiW, d.e.cp_cont_j, 1);
            }
            if (StringUtils.isNull(intro)) {
                if (this.mIsHost) {
                    intro = this.mContext.getString(d.l.no_person_sign_host);
                } else {
                    intro = this.mContext.getString(d.l.no_person_sign_guest);
                }
            }
            this.fiW.setText(this.mContext.getString(d.l.person_sign) + intro);
            if (this.fiW.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fiW.getLayoutParams();
                if (this.fiW.getLineCount() >= 2) {
                    layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(d.f.ds32);
                } else {
                    layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(d.f.ds70);
                }
                this.fiW.setLayoutParams(layoutParams);
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(this.mUserData.getUserId()) && (!TbadkCoreApplication.isLogin() || (!StringUtils.isNull(currentAccount) && !currentAccount.equals(this.mUserData.getUserId()) && this.mUserData.getLiveStatus() == 1))) {
                if (this.fiY == null) {
                    this.fiY = com.baidu.tbadk.ala.b.nz().h(this.mContext, 7);
                }
                com.baidu.tbadk.ala.a aVar2 = new com.baidu.tbadk.ala.a();
                aVar2.QH = this.mUserData.getAlaUserData();
                aVar2.type = 7;
                if ((this.mUserData.getPersonPrivate() != null && this.mUserData.getPersonPrivate().BX() == 3) || (this.mUserData.getPersonPrivate().BX() == 2 && this.mUserData.getIsFriend() != 1)) {
                    aVar2.QI = true;
                } else {
                    aVar2.QI = false;
                }
                if (this.fiY != null) {
                    this.fiY.setTag(aVar2);
                    this.fjb.addView(this.fiY);
                }
            } else if (this.fiY != null) {
                this.fiY.setVisibility(8);
            }
            a(aVar.fgO);
            this.mUserData.setIsLike(this.mUserData.getHave_attention() == 1);
            this.bKb.a(this.mUserData);
            aXj();
            aXk();
            this.fjj.setText(this.mIsHost ? d.l.my_received_gift : d.l.he_received_gift);
            if ((this.mUserData.getPersonPrivate() == null || this.mUserData.getPersonPrivate().BX() != 3) && this.mUserData.getPersonPrivate().BX() == 2 && this.mUserData.getIsFriend() != 1) {
            }
        }
    }

    private void a(UserAgreeInfo userAgreeInfo) {
        if (userAgreeInfo == null) {
            this.fjc.setVisibility(8);
            return;
        }
        this.fjc.setVisibility(0);
        String z = am.z(userAgreeInfo.total_agree_num.longValue());
        Drawable drawable = aj.getDrawable(d.g.icon_home_card_like_s);
        drawable.setBounds(0, 0, com.baidu.adp.lib.util.l.f(this.mContext, d.f.ds36), com.baidu.adp.lib.util.l.f(this.mContext, d.f.ds36));
        this.fjc.setCompoundDrawables(drawable, null, null, null);
        this.fjc.setText(z);
    }

    public void onChangeSkinType(int i) {
        this.fiU.setBackgroundDrawable(aj.getDrawable(d.g.shape_user_info_bg));
        this.fbp.setBackgroundViewDrawable(aj.getDrawable(d.g.shape_user_img_bg));
        int i2 = d.g.icon_pop_boy;
        if (this.mUserData != null) {
            i2 = this.mUserData.getSex() == 1 ? d.g.icon_pop_boy : d.g.icon_pop_girl;
        }
        if (this.mUserData != null && this.mUserData.getIsMem() <= 0 && this.fbq != null && this.mIsHost) {
            this.fbq.setImageDrawable(aj.getDrawable(d.g.icon_crown_super_non));
        }
        aVw();
        aj.c(this.fiS, d.e.cp_link_tip_a, 1);
        this.aou.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mContext.getResources().getDrawable(i2), (Drawable) null);
        if (this.fiT != null) {
            this.fiT.onChangeSkinType(i);
        }
        aj.c(this.fiR, d.e.cp_cont_b, 1);
        aj.c(this.fiV, d.e.cp_cont_b, 1);
        if (this.mUserData == null || StringUtils.isNull(this.mUserData.getIntro())) {
            aj.c(this.fiW, d.e.cp_cont_e, 1);
        } else {
            aj.c(this.fiW, d.e.cp_cont_j, 1);
        }
        aj.c(this.fiX, d.e.cp_cont_b, 1);
        aj.c(this.cMh, d.e.cp_cont_b, 1);
        aj.k(this.fiZ, d.e.cp_bg_line_b);
        aj.k(this.fja, d.e.cp_bg_line_b);
        aj.i(this.fjc, d.e.cp_cont_h);
        this.fiX.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(d.g.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
        Drawable u = aj.u(i, d.g.icon_home_card_like_s);
        u.setBounds(0, 0, com.baidu.adp.lib.util.l.f(this.mContext, d.f.ds36), com.baidu.adp.lib.util.l.f(this.mContext, d.f.ds36));
        this.fjc.setCompoundDrawables(u, null, null, null);
        aj.c(this.fje, d.e.selector_give_gift_text_color, 1);
        this.fje.setBackgroundDrawable(aj.getDrawable(d.g.selector_give_gift_bg));
        this.fje.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.g.selector_gift_icon), (Drawable) null, (Drawable) null, (Drawable) null);
        this.fjf.onChangeSkinType(i);
        aj.k(this.cUW, d.e.cp_bg_line_e);
        for (int i3 = 0; i3 < this.fjg.getChildCount(); i3++) {
            View childAt = this.fjg.getChildAt(i3);
            if (childAt != null) {
                TextView textView = (TextView) childAt.findViewById(d.h.bar_name);
                textView.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(d.g.pic_v_avatar), (Drawable) null, (Drawable) null, (Drawable) null);
                aj.i(textView, d.e.cp_cont_b);
                aj.i((TextView) childAt.findViewById(d.h.bar_info), d.e.cp_cont_j);
            }
        }
        for (int i4 = 0; i4 < fiP.length; i4++) {
            ((TbImageView) this.mRootView.findViewById(fiP[i4])).setBackgroundDrawable(aj.getDrawable(d.g.shape_gift_icon_bg));
        }
        aj.k(this.fji, d.e.cp_bg_line_e);
        aj.i(this.fjj, d.e.cp_cont_b);
        aj.i(this.fjk, d.e.cp_cont_d);
    }

    public void onDestory() {
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.g gVar) {
        this.fiN = gVar;
        if (this.fiT != null) {
            this.fiT.setOnViewResponseListener(this.fiN);
        }
        this.fjd.setOnViewResponseListener(this.fiN);
    }

    public void pD(String str) {
        this.fbp.ei(str);
        if (!StringUtils.isNull(str)) {
            this.fbp.getHeadView().setShowV(false);
        } else if (this.mUserData.isBigV() || !StringUtils.isNull(this.mUserData.getUserTbVipInfoData().getvipV_url())) {
            this.fbp.getHeadView().setShowV(true);
        } else {
            this.fbp.getHeadView().setShowV(false);
        }
    }

    protected void aXi() {
        this.fbp.wg();
        this.fbp.getHeadView().setIsRound(true);
        this.fbp.getHeadView().setDrawBorder(false);
        this.fbp.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    protected void aVw() {
        if (this.mUserData != null && (this.mUserData.getIsMem() > 0 || this.mUserData.isBigV())) {
            aj.c(this.aou, d.e.cp_cont_h, 1);
        } else {
            aj.c(this.aou, d.e.cp_cont_b, 1);
        }
    }

    private void aXj() {
        if (this.fiO != null && this.fiO.aXd() != null) {
            this.fjg.removeAllViews();
            int godType = this.fiO.aXd().getGodType();
            if (godType == 2 && v.t(this.fiO.aXd().getForumGodList()) > 0) {
                this.fjg.setVisibility(0);
                for (ForumGodDetailInfo forumGodDetailInfo : this.fiO.aXd().getForumGodList()) {
                    if (forumGodDetailInfo != null) {
                        bK(forumGodDetailInfo.forum_name, forumGodDetailInfo.intro);
                    }
                }
                return;
            } else if (godType == 1 && this.fiO.aXd().getgodDetailInfo() != null && !StringUtils.isNull(this.fiO.aXd().getgodDetailInfo().intro)) {
                this.fjg.setVisibility(0);
                bK(this.fiO.aXd().getgodDetailInfo().intro, "");
                return;
            } else {
                return;
            }
        }
        this.fjg.setVisibility(8);
    }

    private void bK(String str, String str2) {
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
        this.fjg.addView(inflate, layoutParams);
    }

    private void aXk() {
        int i;
        for (int i2 = 0; i2 < fiP.length; i2++) {
            ((TbImageView) this.mRootView.findViewById(fiP[i2])).setVisibility(8);
        }
        if (this.fiO == null || this.fiO.aXc() == null || v.t(this.fiO.aXc().fhd) <= 0) {
            i = 0;
        } else {
            int i3 = this.fiO.aXc().giftNum;
            List<com.baidu.adp.widget.ListView.f> list = this.fiO.aXc().fhd;
            for (int i4 = 0; i4 < list.size() && i4 < fiP.length; i4++) {
                if (list.get(i4) instanceof com.baidu.tieba.personPolymeric.c.p) {
                    TbImageView tbImageView = (TbImageView) this.mRootView.findViewById(fiP[i4]);
                    tbImageView.setVisibility(0);
                    tbImageView.setIsRound(true);
                    tbImageView.c(((com.baidu.tieba.personPolymeric.c.p) list.get(i4)).picUrl, 10, false);
                }
            }
            i = i3;
        }
        this.fjk.setText(String.format(this.mContext.getResources().getString(d.l.gift_num), Integer.valueOf(i)));
    }
}
