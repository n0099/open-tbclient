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
    private static final int[] fiO = {d.h.img_gift_one, d.h.img_gift_two, d.h.img_gift_three};
    protected TextView aou;
    private com.baidu.tbadk.core.view.userLike.c bKb;
    private TextView cMh;
    private View cUW;
    protected PersonHeadPendantView fbo;
    protected TbImageView fbp;
    protected com.baidu.tieba.view.g fiM;
    protected com.baidu.tieba.personPolymeric.c.a fiN;
    protected UserIconBox fiP;
    protected TextView fiQ;
    protected TextView fiR;
    public com.baidu.tieba.view.e fiS;
    protected View fiT;
    private TextView fiU;
    private TextView fiV;
    private TextView fiW;
    private View fiX;
    private View fiY;
    private View fiZ;
    private LinearLayout fja;
    private TextView fjb;
    private p fjc;
    private TextView fjd;
    private BlueLikeButton fje;
    private LinearLayout fjf;
    private RelativeLayout fjg;
    private View fjh;
    private TextView fji;
    private TextView fjj;
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
        TextView textView = this.fiQ;
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
        this.fiT = view.findViewById(d.h.person_info_root);
        this.fbo = (PersonHeadPendantView) view.findViewById(d.h.person_polymeric_header_user_img);
        this.fbo.getHeadView().setCustomBigViewIconId(d.g.pic_v_avatar_big);
        this.fbo.getHeadView().setIconWidth(this.mContext.getResources().getDimensionPixelSize(d.f.ds40));
        this.fbp = (TbImageView) view.findViewById(d.h.person_polymeric_header_user_vip_icon);
        this.aou = (TextView) view.findViewById(d.h.person_polymeric_header_user_name_txt);
        this.fiR = (TextView) view.findViewById(d.h.seal_prefix_view);
        this.fiP = (UserIconBox) view.findViewById(d.h.person_polymeric_header_label_box);
        this.fiU = (TextView) view.findViewById(d.h.person_polymeric_header_bar_age_txt);
        this.fiQ = (TextView) view.findViewById(d.h.person_polymeric_header_visitor_txt);
        this.fiV = (TextView) view.findViewById(d.h.person_polymeric_header_sign_txt);
        this.fiW = (TextView) view.findViewById(d.h.person_center_header_tdou_txt);
        this.cMh = (TextView) view.findViewById(d.h.textview_get_tdou);
        this.fiY = view.findViewById(d.h.divider_for_age_and_tdou);
        this.fiZ = view.findViewById(d.h.divider_for_tdou_and_get_tdou);
        this.fja = (LinearLayout) view.findViewById(d.h.layout_user_name);
        this.fjb = (TextView) view.findViewById(d.h.person_praise_number);
        this.fiW.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(d.g.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
        this.fiS = (PersonHeaderAttentionView) view.findViewById(d.h.person_center_header_attention_container);
        aXh();
        this.fjc = new p(this.mContext);
        this.fbp.setOnClickListener(this.fjc);
        this.fiP.setOnClickListener(this.fjc);
        this.fbo.setOnClickListener(this.fjc);
        this.fiQ.setOnClickListener(this.fjc);
        this.fiR.setOnClickListener(this.fjc);
        this.fiW.setOnClickListener(this.fjc);
        this.cMh.setOnClickListener(this.fjc);
        this.aou.setOnClickListener(this.fjc);
        this.fiV.setOnClickListener(this.fjc);
        this.fjd = (TextView) view.findViewById(d.h.btn_give_gift);
        this.fjd.setOnClickListener(this.fjc);
        this.fje = (BlueLikeButton) view.findViewById(d.h.btn_like_blue);
        this.bKb = new com.baidu.tbadk.core.view.userLike.c(this.mG, this.fje);
        this.bKb.setFromType("2");
        if (this.mIsHost) {
            this.fjd.setVisibility(8);
            this.fje.setVisibility(8);
        }
        this.fjf = (LinearLayout) view.findViewById(d.h.layout_god_auth_forums);
        this.fjf.setVisibility(8);
        this.cUW = view.findViewById(d.h.header_bottom_divider);
        this.fjg = (RelativeLayout) view.findViewById(d.h.layout_gift);
        this.fjg.setOnClickListener(this.fjc);
        this.fjh = view.findViewById(d.h.gift_top_divider);
        this.fji = (TextView) view.findViewById(d.h.textview_received_gift);
        this.fjj = (TextView) view.findViewById(d.h.textview_received_gift_num);
    }

    public void e(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null) {
            this.fiN = aVar;
            this.mUserData = aVar.getUserData();
            this.fjc.a(aVar);
            this.fjc.setIsHost(this.mIsHost);
            String portrait = this.mUserData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                String dz = com.baidu.tbadk.core.util.o.dz(portrait);
                this.fbo.getHeadView().setUrl(dz);
                this.fbo.getHeadView().c(dz, 25, false);
            } else {
                this.fbo.getHeadView().c(String.valueOf(d.g.pic_mycenter_avatar_def_i), 24, false);
            }
            com.baidu.tbadk.data.i pendantData = this.mUserData.getPendantData();
            if (pendantData != null) {
                this.fbo.ei(pendantData.pS());
            }
            if (this.fbo.wf()) {
                this.fbo.getHeadView().setShowV(false);
            } else if (this.mUserData.isBigV() || !StringUtils.isNull(this.mUserData.getUserTbVipInfoData().getvipV_url())) {
                this.fbo.getHeadView().setShowV(true);
            } else {
                this.fbo.getHeadView().setShowV(false);
            }
            UserVipInfoData userVipInfo = this.mUserData.getUserVipInfo();
            if (this.mUserData.getIsMem() > 0) {
                if (userVipInfo != null) {
                    this.fbp.c(userVipInfo.getVipIconUrl(), 10, false);
                }
                this.fbp.setVisibility(0);
            } else if (this.mIsHost) {
                this.fbp.setImageDrawable(aj.getDrawable(d.g.icon_crown_super_non));
                this.fbp.setVisibility(0);
            } else {
                this.fbp.setVisibility(8);
            }
            aVv();
            String name_show = this.mUserData.getName_show();
            if (!TextUtils.isEmpty(name_show)) {
                this.aou.setText(name_show);
            }
            int i = d.g.icon_pop_boy;
            if (this.mUserData != null) {
                i = this.mUserData.getSex() == 2 ? d.g.icon_pop_girl : d.g.icon_pop_boy;
            }
            this.aou.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mContext.getResources().getDrawable(i), (Drawable) null);
            this.fiP.a(this.mUserData.getIconInfo(), 9, this.mContext.getResources().getDimensionPixelSize(d.f.ds34), this.mContext.getResources().getDimensionPixelSize(d.f.ds34), this.mContext.getResources().getDimensionPixelSize(d.f.ds10), true);
            if (this.fiS != null) {
                this.fiS.setData(this.mUserData);
            }
            this.fiU.setText(String.format(this.mContext.getString(d.l.person_center_header_bar_age), this.mUserData.getTb_age()));
            if (this.mIsHost) {
                this.fiY.setVisibility(0);
                this.fiZ.setVisibility(0);
                this.fiW.setVisibility(0);
                this.cMh.setVisibility(0);
                this.fiW.setText(am.G(this.mUserData.getTDouNum()));
            } else {
                this.fiY.setVisibility(8);
                this.fiZ.setVisibility(8);
                this.fiW.setVisibility(8);
                this.cMh.setVisibility(8);
            }
            String intro = this.mUserData.getIntro();
            if (StringUtils.isNull(intro)) {
                aj.c(this.fiV, d.e.cp_cont_e, 1);
            } else {
                aj.c(this.fiV, d.e.cp_cont_j, 1);
            }
            if (StringUtils.isNull(intro)) {
                if (this.mIsHost) {
                    intro = this.mContext.getString(d.l.no_person_sign_host);
                } else {
                    intro = this.mContext.getString(d.l.no_person_sign_guest);
                }
            }
            this.fiV.setText(this.mContext.getString(d.l.person_sign) + intro);
            if (this.fiV.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fiV.getLayoutParams();
                if (this.fiV.getLineCount() >= 2) {
                    layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(d.f.ds32);
                } else {
                    layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(d.f.ds70);
                }
                this.fiV.setLayoutParams(layoutParams);
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(this.mUserData.getUserId()) && (!TbadkCoreApplication.isLogin() || (!StringUtils.isNull(currentAccount) && !currentAccount.equals(this.mUserData.getUserId()) && this.mUserData.getLiveStatus() == 1))) {
                if (this.fiX == null) {
                    this.fiX = com.baidu.tbadk.ala.b.nz().h(this.mContext, 7);
                }
                com.baidu.tbadk.ala.a aVar2 = new com.baidu.tbadk.ala.a();
                aVar2.QH = this.mUserData.getAlaUserData();
                aVar2.type = 7;
                if ((this.mUserData.getPersonPrivate() != null && this.mUserData.getPersonPrivate().BX() == 3) || (this.mUserData.getPersonPrivate().BX() == 2 && this.mUserData.getIsFriend() != 1)) {
                    aVar2.QI = true;
                } else {
                    aVar2.QI = false;
                }
                if (this.fiX != null) {
                    this.fiX.setTag(aVar2);
                    this.fja.addView(this.fiX);
                }
            } else if (this.fiX != null) {
                this.fiX.setVisibility(8);
            }
            a(aVar.fgN);
            this.mUserData.setIsLike(this.mUserData.getHave_attention() == 1);
            this.bKb.a(this.mUserData);
            aXi();
            aXj();
            this.fji.setText(this.mIsHost ? d.l.my_received_gift : d.l.he_received_gift);
            if ((this.mUserData.getPersonPrivate() == null || this.mUserData.getPersonPrivate().BX() != 3) && this.mUserData.getPersonPrivate().BX() == 2 && this.mUserData.getIsFriend() != 1) {
            }
        }
    }

    private void a(UserAgreeInfo userAgreeInfo) {
        if (userAgreeInfo == null) {
            this.fjb.setVisibility(8);
            return;
        }
        this.fjb.setVisibility(0);
        String z = am.z(userAgreeInfo.total_agree_num.longValue());
        Drawable drawable = aj.getDrawable(d.g.icon_home_card_like_s);
        drawable.setBounds(0, 0, com.baidu.adp.lib.util.l.f(this.mContext, d.f.ds36), com.baidu.adp.lib.util.l.f(this.mContext, d.f.ds36));
        this.fjb.setCompoundDrawables(drawable, null, null, null);
        this.fjb.setText(z);
    }

    public void onChangeSkinType(int i) {
        this.fiT.setBackgroundDrawable(aj.getDrawable(d.g.shape_user_info_bg));
        this.fbo.setBackgroundViewDrawable(aj.getDrawable(d.g.shape_user_img_bg));
        int i2 = d.g.icon_pop_boy;
        if (this.mUserData != null) {
            i2 = this.mUserData.getSex() == 1 ? d.g.icon_pop_boy : d.g.icon_pop_girl;
        }
        if (this.mUserData != null && this.mUserData.getIsMem() <= 0 && this.fbp != null && this.mIsHost) {
            this.fbp.setImageDrawable(aj.getDrawable(d.g.icon_crown_super_non));
        }
        aVv();
        aj.c(this.fiR, d.e.cp_link_tip_a, 1);
        this.aou.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mContext.getResources().getDrawable(i2), (Drawable) null);
        if (this.fiS != null) {
            this.fiS.onChangeSkinType(i);
        }
        aj.c(this.fiQ, d.e.cp_cont_b, 1);
        aj.c(this.fiU, d.e.cp_cont_b, 1);
        if (this.mUserData == null || StringUtils.isNull(this.mUserData.getIntro())) {
            aj.c(this.fiV, d.e.cp_cont_e, 1);
        } else {
            aj.c(this.fiV, d.e.cp_cont_j, 1);
        }
        aj.c(this.fiW, d.e.cp_cont_b, 1);
        aj.c(this.cMh, d.e.cp_cont_b, 1);
        aj.k(this.fiY, d.e.cp_bg_line_b);
        aj.k(this.fiZ, d.e.cp_bg_line_b);
        aj.i(this.fjb, d.e.cp_cont_h);
        this.fiW.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(d.g.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
        Drawable u = aj.u(i, d.g.icon_home_card_like_s);
        u.setBounds(0, 0, com.baidu.adp.lib.util.l.f(this.mContext, d.f.ds36), com.baidu.adp.lib.util.l.f(this.mContext, d.f.ds36));
        this.fjb.setCompoundDrawables(u, null, null, null);
        aj.c(this.fjd, d.e.selector_give_gift_text_color, 1);
        this.fjd.setBackgroundDrawable(aj.getDrawable(d.g.selector_give_gift_bg));
        this.fjd.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.g.selector_gift_icon), (Drawable) null, (Drawable) null, (Drawable) null);
        this.fje.onChangeSkinType(i);
        aj.k(this.cUW, d.e.cp_bg_line_e);
        for (int i3 = 0; i3 < this.fjf.getChildCount(); i3++) {
            View childAt = this.fjf.getChildAt(i3);
            if (childAt != null) {
                TextView textView = (TextView) childAt.findViewById(d.h.bar_name);
                textView.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(d.g.pic_v_avatar), (Drawable) null, (Drawable) null, (Drawable) null);
                aj.i(textView, d.e.cp_cont_b);
                aj.i((TextView) childAt.findViewById(d.h.bar_info), d.e.cp_cont_j);
            }
        }
        for (int i4 = 0; i4 < fiO.length; i4++) {
            ((TbImageView) this.mRootView.findViewById(fiO[i4])).setBackgroundDrawable(aj.getDrawable(d.g.shape_gift_icon_bg));
        }
        aj.k(this.fjh, d.e.cp_bg_line_e);
        aj.i(this.fji, d.e.cp_cont_b);
        aj.i(this.fjj, d.e.cp_cont_d);
    }

    public void onDestory() {
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.g gVar) {
        this.fiM = gVar;
        if (this.fiS != null) {
            this.fiS.setOnViewResponseListener(this.fiM);
        }
        this.fjc.setOnViewResponseListener(this.fiM);
    }

    public void pD(String str) {
        this.fbo.ei(str);
        if (!StringUtils.isNull(str)) {
            this.fbo.getHeadView().setShowV(false);
        } else if (this.mUserData.isBigV() || !StringUtils.isNull(this.mUserData.getUserTbVipInfoData().getvipV_url())) {
            this.fbo.getHeadView().setShowV(true);
        } else {
            this.fbo.getHeadView().setShowV(false);
        }
    }

    protected void aXh() {
        this.fbo.wg();
        this.fbo.getHeadView().setIsRound(true);
        this.fbo.getHeadView().setDrawBorder(false);
        this.fbo.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    protected void aVv() {
        if (this.mUserData != null && (this.mUserData.getIsMem() > 0 || this.mUserData.isBigV())) {
            aj.c(this.aou, d.e.cp_cont_h, 1);
        } else {
            aj.c(this.aou, d.e.cp_cont_b, 1);
        }
    }

    private void aXi() {
        if (this.fiN != null && this.fiN.aXc() != null) {
            this.fjf.removeAllViews();
            int godType = this.fiN.aXc().getGodType();
            if (godType == 2 && v.t(this.fiN.aXc().getForumGodList()) > 0) {
                this.fjf.setVisibility(0);
                for (ForumGodDetailInfo forumGodDetailInfo : this.fiN.aXc().getForumGodList()) {
                    if (forumGodDetailInfo != null) {
                        bK(forumGodDetailInfo.forum_name, forumGodDetailInfo.intro);
                    }
                }
                return;
            } else if (godType == 1 && this.fiN.aXc().getgodDetailInfo() != null && !StringUtils.isNull(this.fiN.aXc().getgodDetailInfo().intro)) {
                this.fjf.setVisibility(0);
                bK(this.fiN.aXc().getgodDetailInfo().intro, "");
                return;
            } else {
                return;
            }
        }
        this.fjf.setVisibility(8);
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
        this.fjf.addView(inflate, layoutParams);
    }

    private void aXj() {
        int i;
        for (int i2 = 0; i2 < fiO.length; i2++) {
            ((TbImageView) this.mRootView.findViewById(fiO[i2])).setVisibility(8);
        }
        if (this.fiN == null || this.fiN.aXb() == null || v.t(this.fiN.aXb().fhc) <= 0) {
            i = 0;
        } else {
            int i3 = this.fiN.aXb().giftNum;
            List<com.baidu.adp.widget.ListView.f> list = this.fiN.aXb().fhc;
            for (int i4 = 0; i4 < list.size() && i4 < fiO.length; i4++) {
                if (list.get(i4) instanceof com.baidu.tieba.personPolymeric.c.p) {
                    TbImageView tbImageView = (TbImageView) this.mRootView.findViewById(fiO[i4]);
                    tbImageView.setVisibility(0);
                    tbImageView.setIsRound(true);
                    tbImageView.c(((com.baidu.tieba.personPolymeric.c.p) list.get(i4)).picUrl, 10, false);
                }
            }
            i = i3;
        }
        this.fjj.setText(String.format(this.mContext.getResources().getString(d.l.gift_num), Integer.valueOf(i)));
    }
}
