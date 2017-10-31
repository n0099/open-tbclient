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
    private static final int[] fri = {d.g.img_gift_one, d.g.img_gift_two, d.g.img_gift_three};
    protected TextView aoE;
    private com.baidu.tbadk.core.view.userLike.c bRv;
    private TextView buT;
    private TextView cVg;
    private View deP;
    protected PersonHeadPendantView fjr;
    protected TbImageView fjs;
    private BlueLikeButton frA;
    private LinearLayout frB;
    private RelativeLayout frC;
    private View frD;
    private TextView frE;
    private TextView frF;
    protected com.baidu.tieba.view.h frg;
    protected com.baidu.tieba.personPolymeric.c.a frh;
    protected UserIconBox frj;
    protected TextView frk;
    protected TextView frl;
    public com.baidu.tieba.view.f frm;
    protected View frn;
    private TextView fro;
    private TextView frp;
    private TextView frq;
    private View frr;
    private View frt;
    private View fru;
    private View frv;
    private LinearLayout frw;
    private TextView frx;
    private q fry;
    private TextView frz;
    protected Context mContext;
    protected boolean mIsHost;
    private TbPageContext mPageContext;
    protected View mRootView;
    protected UserData mUserData;

    public r(TbPageContext tbPageContext, boolean z) {
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.mIsHost = z;
        Z(Yb());
        TextView textView = this.frk;
        if (this.mIsHost) {
        }
        textView.setVisibility(8);
    }

    public View Yb() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(d.h.item_person_polymeric_header_view, (ViewGroup) null);
        }
        return this.mRootView;
    }

    public void Z(View view) {
        this.frn = view.findViewById(d.g.person_info_root);
        this.fjr = (PersonHeadPendantView) view.findViewById(d.g.person_polymeric_header_user_img);
        this.fjr.getHeadView().setCustomBigViewIconId(d.f.pic_v_avatar_big);
        this.fjr.getHeadView().setIconWidth(this.mContext.getResources().getDimensionPixelSize(d.e.ds40));
        this.fjs = (TbImageView) view.findViewById(d.g.person_polymeric_header_user_vip_icon);
        this.aoE = (TextView) view.findViewById(d.g.person_polymeric_header_user_name_txt);
        this.frl = (TextView) view.findViewById(d.g.seal_prefix_view);
        this.frj = (UserIconBox) view.findViewById(d.g.person_polymeric_header_label_box);
        this.fro = (TextView) view.findViewById(d.g.person_polymeric_header_bar_age_txt);
        this.buT = (TextView) view.findViewById(d.g.person_polymeric_header_ala_id);
        this.frr = view.findViewById(d.g.divider_for_alaid_and_age);
        this.frk = (TextView) view.findViewById(d.g.person_polymeric_header_visitor_txt);
        this.frp = (TextView) view.findViewById(d.g.person_polymeric_header_sign_txt);
        this.frq = (TextView) view.findViewById(d.g.person_center_header_tdou_txt);
        this.cVg = (TextView) view.findViewById(d.g.textview_get_tdou);
        this.fru = view.findViewById(d.g.divider_for_age_and_tdou);
        this.frv = view.findViewById(d.g.divider_for_tdou_and_get_tdou);
        this.frw = (LinearLayout) view.findViewById(d.g.layout_user_name);
        this.frx = (TextView) view.findViewById(d.g.person_praise_number);
        this.frq.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(d.f.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
        this.frm = (PersonHeaderAttentionView) view.findViewById(d.g.person_center_header_attention_container);
        bak();
        this.fry = new q(this.mContext);
        this.fjs.setOnClickListener(this.fry);
        this.frj.setOnClickListener(this.fry);
        this.fjr.setOnClickListener(this.fry);
        this.frk.setOnClickListener(this.fry);
        this.frl.setOnClickListener(this.fry);
        this.frq.setOnClickListener(this.fry);
        this.cVg.setOnClickListener(this.fry);
        this.aoE.setOnClickListener(this.fry);
        this.frp.setOnClickListener(this.fry);
        this.frz = (TextView) view.findViewById(d.g.btn_give_gift);
        this.frz.setOnClickListener(this.fry);
        this.frA = (BlueLikeButton) view.findViewById(d.g.btn_like_blue);
        this.bRv = new com.baidu.tbadk.core.view.userLike.c(this.mPageContext, this.frA);
        this.bRv.setFromType("2");
        if (this.mIsHost) {
            this.frz.setVisibility(8);
            this.frA.setVisibility(8);
        }
        this.frB = (LinearLayout) view.findViewById(d.g.layout_god_auth_forums);
        this.frB.setVisibility(8);
        this.deP = view.findViewById(d.g.header_bottom_divider);
        this.frC = (RelativeLayout) view.findViewById(d.g.layout_gift);
        this.frC.setOnClickListener(this.fry);
        this.frD = view.findViewById(d.g.gift_top_divider);
        this.frE = (TextView) view.findViewById(d.g.textview_received_gift);
        this.frF = (TextView) view.findViewById(d.g.textview_received_gift_num);
    }

    public void e(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null) {
            this.frh = aVar;
            this.mUserData = aVar.getUserData();
            this.fry.a(aVar);
            this.fry.setIsHost(this.mIsHost);
            String portrait = this.mUserData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                String dE = com.baidu.tbadk.core.util.o.dE(portrait);
                this.fjr.getHeadView().setUrl(dE);
                this.fjr.getHeadView().startLoad(dE, 25, false);
            } else {
                this.fjr.getHeadView().startLoad(String.valueOf(d.f.pic_mycenter_avatar_def_i), 24, false);
            }
            com.baidu.tbadk.data.k pendantData = this.mUserData.getPendantData();
            if (pendantData != null) {
                this.fjr.en(pendantData.pQ());
            }
            if (this.fjr.wf()) {
                this.fjr.getHeadView().setShowV(false);
            } else if (this.mUserData.isBigV() || !StringUtils.isNull(this.mUserData.getUserTbVipInfoData().getvipV_url())) {
                this.fjr.getHeadView().setShowV(true);
            } else {
                this.fjr.getHeadView().setShowV(false);
            }
            UserVipInfoData userVipInfo = this.mUserData.getUserVipInfo();
            if (this.mUserData.getIsMem() > 0) {
                if (userVipInfo != null) {
                    this.fjs.startLoad(userVipInfo.getVipIconUrl(), 10, false);
                }
                this.fjs.setVisibility(0);
            } else if (this.mIsHost) {
                this.fjs.setImageDrawable(aj.getDrawable(d.f.icon_crown_super_non));
                this.fjs.setVisibility(0);
            } else {
                this.fjs.setVisibility(8);
            }
            aYs();
            String name_show = this.mUserData.getName_show();
            if (!TextUtils.isEmpty(name_show)) {
                this.aoE.setText(name_show);
            }
            int i = d.f.icon_pop_boy;
            if (this.mUserData != null) {
                i = this.mUserData.getSex() == 2 ? d.f.icon_pop_girl : d.f.icon_pop_boy;
            }
            this.aoE.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mContext.getResources().getDrawable(i), (Drawable) null);
            this.frj.a(this.mUserData.getIconInfo(), 9, this.mContext.getResources().getDimensionPixelSize(d.e.ds34), this.mContext.getResources().getDimensionPixelSize(d.e.ds34), this.mContext.getResources().getDimensionPixelSize(d.e.ds10), true);
            if (this.frm != null) {
                this.frm.setData(this.mUserData);
            }
            if (this.mUserData != null && this.mUserData.alaUserData != null && this.mUserData.alaUserData.ala_id != 0) {
                this.buT.setVisibility(0);
                this.frr.setVisibility(0);
                this.buT.setText(String.format(this.mContext.getString(d.j.person_center_ala_id), Long.valueOf(this.mUserData.alaUserData.ala_id)));
            } else {
                this.buT.setVisibility(8);
                this.frr.setVisibility(8);
            }
            this.fro.setText(String.format(this.mContext.getString(d.j.person_center_header_bar_age), this.mUserData.getTb_age()));
            if (this.mIsHost) {
                this.fru.setVisibility(0);
                this.frv.setVisibility(0);
                this.frq.setVisibility(0);
                this.cVg.setVisibility(0);
                this.frq.setText(am.H(this.mUserData.getTDouNum()));
            } else {
                this.fru.setVisibility(8);
                this.frv.setVisibility(8);
                this.frq.setVisibility(8);
                this.cVg.setVisibility(8);
            }
            String intro = this.mUserData.getIntro();
            if (StringUtils.isNull(intro)) {
                aj.c(this.frp, d.C0080d.cp_cont_e, 1);
            } else {
                aj.c(this.frp, d.C0080d.cp_cont_j, 1);
            }
            if (StringUtils.isNull(intro)) {
                if (this.mIsHost) {
                    intro = this.mContext.getString(d.j.no_person_sign_host);
                } else {
                    intro = this.mContext.getString(d.j.no_person_sign_guest);
                }
            }
            this.frp.setText(this.mContext.getString(d.j.person_sign) + intro);
            if (this.frp.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.frp.getLayoutParams();
                if (this.frp.getLineCount() >= 2) {
                    layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(d.e.ds32);
                } else {
                    layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(d.e.ds70);
                }
                this.frp.setLayoutParams(layoutParams);
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(this.mUserData.getUserId()) && (!TbadkCoreApplication.isLogin() || (!StringUtils.isNull(currentAccount) && !currentAccount.equals(this.mUserData.getUserId()) && this.mUserData.getLiveStatus() == 1))) {
                if (this.frt == null) {
                    this.frt = com.baidu.tbadk.ala.b.nu().g(this.mContext, 7);
                }
                com.baidu.tbadk.ala.a aVar2 = new com.baidu.tbadk.ala.a();
                aVar2.QK = this.mUserData.getAlaUserData();
                aVar2.type = 7;
                if ((this.mUserData.getPersonPrivate() != null && this.mUserData.getPersonPrivate().Cg() == 3) || (this.mUserData.getPersonPrivate().Cg() == 2 && this.mUserData.getIsFriend() != 1)) {
                    aVar2.QL = true;
                } else {
                    aVar2.QL = false;
                }
                if (this.frt != null) {
                    this.frt.setTag(aVar2);
                    if (this.frt.getParent() == null) {
                        this.frw.addView(this.frt);
                        TiebaStatic.log(new ak("c12541"));
                    }
                }
            } else if (this.frt != null) {
                this.frt.setVisibility(8);
            }
            a(aVar.foX);
            this.mUserData.setIsLike(this.mUserData.getHave_attention() == 1);
            this.bRv.a(this.mUserData);
            bal();
            bam();
            this.frE.setText(this.mIsHost ? d.j.my_received_gift : d.j.he_received_gift);
            if ((this.mUserData.getPersonPrivate() == null || this.mUserData.getPersonPrivate().Cg() != 3) && this.mUserData.getPersonPrivate().Cg() == 2 && this.mUserData.getIsFriend() != 1) {
            }
        }
    }

    private void a(UserAgreeInfo userAgreeInfo) {
        if (userAgreeInfo == null) {
            this.frx.setVisibility(8);
            return;
        }
        this.frx.setVisibility(0);
        String A = am.A(userAgreeInfo.total_agree_num.longValue());
        Drawable drawable = aj.getDrawable(d.f.icon_home_card_like_s);
        drawable.setBounds(0, 0, com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds36), com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds36));
        this.frx.setCompoundDrawables(drawable, null, null, null);
        this.frx.setText(A);
    }

    public void onChangeSkinType(int i) {
        this.frn.setBackgroundDrawable(aj.getDrawable(d.f.shape_user_info_bg));
        this.fjr.setBackgroundViewDrawable(aj.getDrawable(d.f.shape_user_img_bg));
        int i2 = d.f.icon_pop_boy;
        if (this.mUserData != null) {
            i2 = this.mUserData.getSex() == 1 ? d.f.icon_pop_boy : d.f.icon_pop_girl;
        }
        if (this.mUserData != null && this.mUserData.getIsMem() <= 0 && this.fjs != null && this.mIsHost) {
            this.fjs.setImageDrawable(aj.getDrawable(d.f.icon_crown_super_non));
        }
        aYs();
        aj.c(this.frl, d.C0080d.cp_link_tip_a, 1);
        this.aoE.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mContext.getResources().getDrawable(i2), (Drawable) null);
        if (this.frm != null) {
            this.frm.onChangeSkinType(i);
        }
        aj.c(this.frk, d.C0080d.cp_cont_b, 1);
        aj.c(this.fro, d.C0080d.cp_cont_b, 1);
        aj.c(this.buT, d.C0080d.cp_cont_b, 1);
        if (this.mUserData == null || StringUtils.isNull(this.mUserData.getIntro())) {
            aj.c(this.frp, d.C0080d.cp_cont_e, 1);
        } else {
            aj.c(this.frp, d.C0080d.cp_cont_j, 1);
        }
        aj.c(this.frq, d.C0080d.cp_cont_b, 1);
        aj.c(this.cVg, d.C0080d.cp_cont_b, 1);
        aj.k(this.fru, d.C0080d.cp_bg_line_b);
        aj.k(this.frr, d.C0080d.cp_bg_line_b);
        aj.k(this.frv, d.C0080d.cp_bg_line_b);
        aj.i(this.frx, d.C0080d.cp_cont_h);
        this.frq.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(d.f.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
        Drawable u = aj.u(i, d.f.icon_home_card_like_s);
        u.setBounds(0, 0, com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds36), com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds36));
        this.frx.setCompoundDrawables(u, null, null, null);
        aj.c(this.frz, d.C0080d.selector_give_gift_text_color, 1);
        this.frz.setBackgroundDrawable(aj.getDrawable(d.f.selector_give_gift_bg));
        this.frz.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.selector_gift_icon), (Drawable) null, (Drawable) null, (Drawable) null);
        this.frA.onChangeSkinType(i);
        aj.k(this.deP, d.C0080d.cp_bg_line_e);
        for (int i3 = 0; i3 < this.frB.getChildCount(); i3++) {
            View childAt = this.frB.getChildAt(i3);
            if (childAt != null) {
                TextView textView = (TextView) childAt.findViewById(d.g.bar_name);
                textView.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(d.f.pic_v_avatar), (Drawable) null, (Drawable) null, (Drawable) null);
                aj.i(textView, d.C0080d.cp_cont_b);
                aj.i((TextView) childAt.findViewById(d.g.bar_info), d.C0080d.cp_cont_j);
            }
        }
        for (int i4 = 0; i4 < fri.length; i4++) {
            ((TbImageView) this.mRootView.findViewById(fri[i4])).setBackgroundDrawable(aj.getDrawable(d.f.shape_gift_icon_bg));
        }
        aj.k(this.frD, d.C0080d.cp_bg_line_e);
        aj.i(this.frE, d.C0080d.cp_cont_b);
        aj.i(this.frF, d.C0080d.cp_cont_d);
    }

    public void onDestory() {
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.h hVar) {
        this.frg = hVar;
        if (this.frm != null) {
            this.frm.setOnViewResponseListener(this.frg);
        }
        this.fry.setOnViewResponseListener(this.frg);
    }

    public void qi(String str) {
        this.fjr.en(str);
        if (!StringUtils.isNull(str)) {
            this.fjr.getHeadView().setShowV(false);
        } else if (this.mUserData.isBigV() || !StringUtils.isNull(this.mUserData.getUserTbVipInfoData().getvipV_url())) {
            this.fjr.getHeadView().setShowV(true);
        } else {
            this.fjr.getHeadView().setShowV(false);
        }
    }

    protected void bak() {
        this.fjr.wg();
        this.fjr.getHeadView().setIsRound(true);
        this.fjr.getHeadView().setDrawBorder(false);
        this.fjr.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    protected void aYs() {
        if (this.mUserData != null && (this.mUserData.getIsMem() > 0 || this.mUserData.isBigV())) {
            aj.c(this.aoE, d.C0080d.cp_cont_h, 1);
        } else {
            aj.c(this.aoE, d.C0080d.cp_cont_b, 1);
        }
    }

    private void bal() {
        if (this.frh != null && this.frh.bae() != null) {
            this.frB.removeAllViews();
            int godType = this.frh.bae().getGodType();
            if (godType == 2 && v.u(this.frh.bae().getForumGodList()) > 0) {
                this.frB.setVisibility(0);
                for (ForumGodDetailInfo forumGodDetailInfo : this.frh.bae().getForumGodList()) {
                    if (forumGodDetailInfo != null) {
                        bF(forumGodDetailInfo.forum_name, forumGodDetailInfo.intro);
                    }
                }
                return;
            } else if (godType == 1 && this.frh.bae().getgodDetailInfo() != null && !StringUtils.isNull(this.frh.bae().getgodDetailInfo().intro)) {
                this.frB.setVisibility(0);
                bF(this.frh.bae().getgodDetailInfo().intro, "");
                return;
            } else {
                return;
            }
        }
        this.frB.setVisibility(8);
    }

    private void bF(String str, String str2) {
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
        this.frB.addView(inflate, layoutParams);
    }

    private void bam() {
        int i;
        for (int i2 = 0; i2 < fri.length; i2++) {
            ((TbImageView) this.mRootView.findViewById(fri[i2])).setVisibility(8);
        }
        if (this.frh == null || this.frh.bad() == null || v.u(this.frh.bad().fpm) <= 0) {
            i = 0;
        } else {
            int i3 = this.frh.bad().giftNum;
            List<com.baidu.adp.widget.ListView.f> list = this.frh.bad().fpm;
            for (int i4 = 0; i4 < list.size() && i4 < fri.length; i4++) {
                if (list.get(i4) instanceof com.baidu.tieba.personPolymeric.c.p) {
                    TbImageView tbImageView = (TbImageView) this.mRootView.findViewById(fri[i4]);
                    tbImageView.setVisibility(0);
                    tbImageView.setIsRound(true);
                    tbImageView.startLoad(((com.baidu.tieba.personPolymeric.c.p) list.get(i4)).picUrl, 10, false);
                }
            }
            i = i3;
        }
        this.frF.setText(String.format(this.mContext.getResources().getString(d.j.gift_num), Integer.valueOf(i)));
    }
}
