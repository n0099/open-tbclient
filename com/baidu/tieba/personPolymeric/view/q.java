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
    private static final int[] grP = {d.g.img_gift_one, d.g.img_gift_two, d.g.img_gift_three};
    protected TextView beW;
    private com.baidu.tbadk.core.view.userLike.c cWa;
    private TextView cax;
    private View ehd;
    protected TbImageView gku;
    protected com.baidu.tieba.view.i grN;
    protected com.baidu.tieba.personPolymeric.c.a grO;
    protected ImageView grQ;
    protected PersonHeadPendantView grR;
    protected UserIconBox grS;
    protected TextView grT;
    protected TextView grU;
    public com.baidu.tieba.view.g grV;
    protected View grW;
    private TextView grX;
    private TextView grY;
    private TextView grZ;
    private View gsa;
    private View gsb;
    private TextView gsc;
    private View gsd;
    private View gse;
    private LinearLayout gsf;
    private TextView gsg;
    private p gsh;
    private View gsi;
    private ImageView gsj;
    private TextView gsk;
    private BlueLikeButton gsl;
    private LinearLayout gsm;
    private RelativeLayout gsn;
    private View gso;
    private TextView gsp;
    private TextView gsq;
    private int gsr;
    protected Context mContext;
    protected boolean mIsHost;
    private TbPageContext mPageContext;
    protected View mRootView;
    protected UserData mUserData;

    public q(TbPageContext tbPageContext, boolean z) {
        this.gsr = 0;
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.mIsHost = z;
        this.gsr = com.baidu.adp.lib.util.l.t(this.mContext, d.e.tbds46);
        bu(aix());
        TextView textView = this.grT;
        if (this.mIsHost) {
        }
        textView.setVisibility(8);
    }

    public View aix() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(d.h.item_person_polymeric_header_view, (ViewGroup) null);
        }
        return this.mRootView;
    }

    public void bu(View view) {
        this.grW = view.findViewById(d.g.person_info_root);
        this.grR = (PersonHeadPendantView) view.findViewById(d.g.person_polymeric_header_user_img);
        this.grR.getHeadView().setCustomBigViewIconId(d.f.pic_v_avatar_big);
        this.grR.getHeadView().setIconWidth(this.mContext.getResources().getDimensionPixelSize(d.e.ds40));
        this.grR.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gku = (TbImageView) view.findViewById(d.g.person_polymeric_header_user_vip_icon);
        this.beW = (TextView) view.findViewById(d.g.person_polymeric_header_user_name_txt);
        this.grU = (TextView) view.findViewById(d.g.seal_prefix_view);
        this.grS = (UserIconBox) view.findViewById(d.g.person_polymeric_header_label_box);
        this.grX = (TextView) view.findViewById(d.g.person_polymeric_header_bar_age_txt);
        this.cax = (TextView) view.findViewById(d.g.person_polymeric_header_ala_id);
        this.gsa = view.findViewById(d.g.divider_for_alaid_and_age);
        this.grT = (TextView) view.findViewById(d.g.person_polymeric_header_visitor_txt);
        this.grY = (TextView) view.findViewById(d.g.person_polymeric_header_sign_txt);
        this.grZ = (TextView) view.findViewById(d.g.person_center_header_tdou_txt);
        this.gsc = (TextView) view.findViewById(d.g.textview_get_tdou);
        this.gsd = view.findViewById(d.g.divider_for_age_and_tdou);
        this.gse = view.findViewById(d.g.divider_for_tdou_and_get_tdou);
        this.gsf = (LinearLayout) view.findViewById(d.g.layout_user_name);
        this.gsg = (TextView) view.findViewById(d.g.person_praise_number);
        this.grZ.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(d.f.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
        this.grV = (PersonHeaderAttentionView) view.findViewById(d.g.person_center_header_attention_container);
        bkG();
        this.gsh = new p(this.mContext);
        this.gku.setOnClickListener(this.gsh);
        this.grS.setOnClickListener(this.gsh);
        this.grR.setOnClickListener(this.gsh);
        this.grT.setOnClickListener(this.gsh);
        this.grU.setOnClickListener(this.gsh);
        this.grZ.setOnClickListener(this.gsh);
        this.gsc.setOnClickListener(this.gsh);
        this.beW.setOnClickListener(this.gsh);
        this.grY.setOnClickListener(this.gsh);
        this.gsi = (LinearLayout) view.findViewById(d.g.container_send_gift);
        this.gsj = (ImageView) view.findViewById(d.g.icon_gift);
        this.gsk = (TextView) view.findViewById(d.g.btn_give_gift);
        this.gsi.setOnClickListener(this.gsh);
        this.gsl = (BlueLikeButton) view.findViewById(d.g.btn_like_blue);
        this.cWa = new com.baidu.tbadk.core.view.userLike.c(this.mPageContext, this.gsl);
        this.cWa.setFromType("2");
        if (this.mIsHost) {
            this.gsi.setVisibility(8);
            this.gsl.setVisibility(8);
        }
        this.gsm = (LinearLayout) view.findViewById(d.g.layout_god_auth_forums);
        this.gsm.setVisibility(8);
        this.ehd = view.findViewById(d.g.header_bottom_divider);
        this.gsn = (RelativeLayout) view.findViewById(d.g.layout_gift);
        this.gsn.setOnClickListener(this.gsh);
        this.gso = view.findViewById(d.g.gift_top_divider);
        this.gsp = (TextView) view.findViewById(d.g.textview_received_gift);
        this.gsq = (TextView) view.findViewById(d.g.textview_received_gift_num);
        this.grQ = (ImageView) view.findViewById(d.g.img_gift_arrow);
    }

    public void e(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null) {
            this.grO = aVar;
            this.mUserData = aVar.getUserData();
            this.gsh.a(aVar);
            this.gsh.setIsHost(this.mIsHost);
            String portrait = this.mUserData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                String ec = com.baidu.tbadk.core.util.o.ec(portrait);
                this.grR.getHeadView().setUrl(ec);
                this.grR.getHeadView().startLoad(ec, 25, false);
            } else {
                this.grR.getHeadView().startLoad(String.valueOf(d.f.pic_mycenter_avatar_def_i), 24, false);
            }
            com.baidu.tbadk.data.h pendantData = this.mUserData.getPendantData();
            if (pendantData != null) {
                this.grR.eS(pendantData.ya());
            }
            if (this.grR.DS()) {
                this.grR.getHeadView().setShowV(false);
            } else if (this.mUserData.isBigV() || !StringUtils.isNull(this.mUserData.getUserTbVipInfoData().getvipV_url())) {
                this.grR.getHeadView().setShowV(true);
            } else {
                this.grR.getHeadView().setShowV(false);
            }
            UserVipInfoData userVipInfo = this.mUserData.getUserVipInfo();
            if (this.mUserData.getIsMem() > 0) {
                if (userVipInfo != null) {
                    this.gku.startLoad(userVipInfo.getVipIconUrl(), 10, false);
                }
                this.gku.setVisibility(0);
            } else if (this.mIsHost) {
                this.gku.setImageDrawable(aj.getDrawable(d.f.icon_crown_super_non));
                this.gku.setVisibility(0);
            } else {
                this.gku.setVisibility(8);
            }
            biO();
            String name_show = this.mUserData.getName_show();
            if (!TextUtils.isEmpty(name_show)) {
                this.beW.setText(name_show);
            }
            int i = d.f.icon_mine_boy;
            if (this.mUserData != null) {
                i = this.mUserData.getSex() == 2 ? d.f.icon_mine_girl : d.f.icon_mine_boy;
            }
            this.beW.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mContext.getResources().getDrawable(i), (Drawable) null);
            this.grS.a(this.mUserData.getIconInfo(), 9, this.mContext.getResources().getDimensionPixelSize(d.e.tbds42), this.mContext.getResources().getDimensionPixelSize(d.e.tbds42), this.mContext.getResources().getDimensionPixelSize(d.e.tbds10), true);
            if (this.grV != null) {
                this.grV.setData(this.mUserData);
            }
            if (this.mUserData != null && this.mUserData.alaUserData != null && this.mUserData.alaUserData.ala_id != 0) {
                this.cax.setVisibility(0);
                this.gsa.setVisibility(0);
                this.cax.setText(String.format(this.mContext.getString(d.j.person_center_ala_id), Long.valueOf(this.mUserData.alaUserData.ala_id)));
            } else {
                this.cax.setVisibility(8);
                this.gsa.setVisibility(8);
            }
            this.grX.setText(String.format(this.mContext.getString(d.j.person_center_header_bar_age), this.mUserData.getTb_age()));
            if (this.mIsHost) {
                this.gsd.setVisibility(0);
                this.gse.setVisibility(0);
                this.grZ.setVisibility(0);
                this.gsc.setVisibility(0);
                this.grZ.setText(am.P(this.mUserData.getTDouNum()));
            } else {
                this.gsd.setVisibility(8);
                this.gse.setVisibility(8);
                this.grZ.setVisibility(8);
                this.gsc.setVisibility(8);
            }
            String intro = this.mUserData.getIntro();
            if (StringUtils.isNull(intro)) {
                aj.e(this.grY, d.C0141d.cp_cont_e, 1);
            } else {
                aj.e(this.grY, d.C0141d.cp_cont_j, 1);
            }
            if (StringUtils.isNull(intro)) {
                if (this.mIsHost) {
                    intro = this.mContext.getString(d.j.no_person_sign_host);
                } else {
                    intro = this.mContext.getString(d.j.no_person_sign_guest);
                }
            }
            this.grY.setText(this.mContext.getString(d.j.person_sign) + intro);
            if (this.grY.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.grY.getLayoutParams();
                if (!this.mIsHost && this.grY.getLineCount() >= 3 && this.grY.getMaxLines() != 2147483646) {
                    int lineHeight = this.grY.getLineHeight();
                    this.grY.setHeight((lineHeight / 2) + (lineHeight * 3));
                }
                if (this.grY.getLineCount() >= 2) {
                    layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(d.e.tbds19);
                } else {
                    layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(d.e.tbds80);
                }
                this.grY.setLayoutParams(layoutParams);
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(this.mUserData.getUserId()) && ((!TbadkCoreApplication.isLogin() || (!StringUtils.isNull(currentAccount) && !currentAccount.equals(this.mUserData.getUserId()))) && this.mUserData.getLiveStatus() == 1)) {
                if (this.gsb == null) {
                    this.gsb = com.baidu.tbadk.ala.b.vL().u(this.mContext, 7);
                }
                com.baidu.tbadk.ala.a aVar2 = new com.baidu.tbadk.ala.a();
                aVar2.aGU = this.mUserData.getAlaUserData();
                aVar2.type = 7;
                if ((this.mUserData.getPersonPrivate() != null && this.mUserData.getPersonPrivate().KB() == 3) || (this.mUserData.getPersonPrivate().KB() == 2 && this.mUserData.getIsFriend() != 1)) {
                    aVar2.aGV = true;
                } else {
                    aVar2.aGV = false;
                }
                if (this.gsb != null) {
                    this.gsb.setTag(aVar2);
                    if (this.gsb.getParent() == null) {
                        this.gsf.addView(this.gsb);
                        TiebaStatic.log(new ak("c12541"));
                    }
                }
            } else if (this.gsb != null) {
                this.gsb.setVisibility(8);
            }
            a(aVar.gpH);
            this.mUserData.setIsLike(this.mUserData.getHave_attention() == 1);
            this.cWa.a(this.mUserData);
            bkH();
            bkI();
            this.gsp.setText(this.mIsHost ? d.j.my_received_gift : d.j.he_received_gift);
            if ((this.mUserData.getPersonPrivate() == null || this.mUserData.getPersonPrivate().KB() != 3) && this.mUserData.getPersonPrivate().KB() == 2 && this.mUserData.getIsFriend() != 1) {
            }
        }
    }

    private void a(UserAgreeInfo userAgreeInfo) {
        if (userAgreeInfo == null) {
            this.gsg.setVisibility(8);
            return;
        }
        this.gsg.setVisibility(0);
        String J = am.J(userAgreeInfo.total_agree_num.longValue());
        Drawable drawable = aj.getDrawable(d.f.icon_home_card_like_s);
        drawable.setBounds(0, 0, this.gsr, this.gsr);
        this.gsg.setCompoundDrawables(drawable, null, null, null);
        this.gsg.setText(J);
    }

    public void onChangeSkinType(int i) {
        this.grW.setBackgroundDrawable(aj.getDrawable(d.f.shape_user_info_bg));
        this.grR.setBackgroundViewDrawable(aj.getDrawable(d.f.shape_user_img_bg));
        int i2 = d.f.icon_mine_boy;
        if (this.mUserData != null) {
            i2 = this.mUserData.getSex() == 1 ? d.f.icon_mine_boy : d.f.icon_pop_girl;
        }
        if (this.mUserData != null && this.mUserData.getIsMem() <= 0 && this.gku != null && this.mIsHost) {
            this.gku.setImageDrawable(aj.getDrawable(d.f.icon_crown_super_non));
        }
        biO();
        aj.e(this.grU, d.C0141d.cp_link_tip_a, 1);
        this.beW.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mContext.getResources().getDrawable(i2), (Drawable) null);
        if (this.grV != null) {
            this.grV.onChangeSkinType(i);
        }
        aj.e(this.grT, d.C0141d.cp_cont_b, 1);
        aj.e(this.grX, d.C0141d.cp_cont_b, 1);
        aj.e(this.cax, d.C0141d.cp_cont_b, 1);
        if (this.mUserData == null || StringUtils.isNull(this.mUserData.getIntro())) {
            aj.e(this.grY, d.C0141d.cp_cont_e, 1);
        } else {
            aj.e(this.grY, d.C0141d.cp_cont_j, 1);
        }
        aj.e(this.grZ, d.C0141d.cp_cont_b, 1);
        aj.e(this.gsc, d.C0141d.cp_cont_b, 1);
        aj.t(this.gsd, d.C0141d.cp_bg_line_b);
        aj.t(this.gsa, d.C0141d.cp_bg_line_b);
        aj.t(this.gse, d.C0141d.cp_bg_line_b);
        aj.r(this.gsg, d.C0141d.cp_cont_h);
        this.grZ.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(d.f.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
        Drawable au = aj.au(i, d.f.icon_home_card_like_s);
        au.setBounds(0, 0, this.gsr, this.gsr);
        this.gsg.setCompoundDrawables(au, null, null, null);
        aj.s(this.gsi, d.f.selector_give_gift_bg);
        aj.c(this.gsj, d.f.selector_gift_icon);
        aj.e(this.gsk, d.C0141d.selector_give_gift_text_color, 1);
        this.gsl.onChangeSkinType(i);
        aj.t(this.ehd, d.C0141d.cp_bg_line_e);
        for (int i3 = 0; i3 < this.gsm.getChildCount(); i3++) {
            View childAt = this.gsm.getChildAt(i3);
            if (childAt != null) {
                TextView textView = (TextView) childAt.findViewById(d.g.bar_name);
                textView.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.pic_v_avatar), (Drawable) null, (Drawable) null, (Drawable) null);
                aj.r(textView, d.C0141d.cp_cont_b);
                aj.r((TextView) childAt.findViewById(d.g.bar_info), d.C0141d.cp_cont_j);
            }
        }
        for (int i4 = 0; i4 < grP.length; i4++) {
            ((TbImageView) this.mRootView.findViewById(grP[i4])).setBackgroundDrawable(aj.getDrawable(d.f.shape_gift_icon_bg));
        }
        aj.t(this.gso, d.C0141d.cp_bg_line_e);
        aj.r(this.gsp, d.C0141d.cp_cont_b);
        aj.r(this.gsq, d.C0141d.cp_cont_d);
        aj.c(this.grQ, d.f.icon_arrow_gray_right_n);
    }

    public void onDestory() {
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.i iVar) {
        this.grN = iVar;
        if (this.grV != null) {
            this.grV.setOnViewResponseListener(this.grN);
        }
        this.gsh.setOnViewResponseListener(this.grN);
    }

    public void rf(String str) {
        this.grR.eS(str);
        if (!StringUtils.isNull(str)) {
            this.grR.getHeadView().setShowV(false);
        } else if (this.mUserData.isBigV() || !StringUtils.isNull(this.mUserData.getUserTbVipInfoData().getvipV_url())) {
            this.grR.getHeadView().setShowV(true);
        } else {
            this.grR.getHeadView().setShowV(false);
        }
    }

    protected void bkG() {
        this.grR.DT();
        this.grR.getHeadView().setIsRound(true);
        this.grR.getHeadView().setDrawBorder(false);
        this.grR.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    protected void biO() {
        if (this.mUserData != null && (this.mUserData.getIsMem() > 0 || this.mUserData.isBigV())) {
            aj.e(this.beW, d.C0141d.cp_cont_h, 1);
        } else {
            aj.e(this.beW, d.C0141d.cp_cont_b, 1);
        }
    }

    private void bkH() {
        if (this.grO != null && this.grO.bkA() != null) {
            this.gsm.removeAllViews();
            int godType = this.grO.bkA().getGodType();
            if (godType == 2 && v.D(this.grO.bkA().getForumGodList()) > 0) {
                this.gsm.setVisibility(0);
                for (ForumGodDetailInfo forumGodDetailInfo : this.grO.bkA().getForumGodList()) {
                    if (forumGodDetailInfo != null) {
                        bJ(forumGodDetailInfo.forum_name, forumGodDetailInfo.intro);
                    }
                }
                return;
            } else if (godType == 1 && this.grO.bkA().getgodDetailInfo() != null && !StringUtils.isNull(this.grO.bkA().getgodDetailInfo().intro)) {
                this.gsm.setVisibility(0);
                bJ(this.grO.bkA().getgodDetailInfo().intro, "");
                return;
            } else {
                return;
            }
        }
        this.gsm.setVisibility(8);
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
        this.gsm.addView(inflate, layoutParams);
    }

    private void bkI() {
        int i;
        for (int i2 = 0; i2 < grP.length; i2++) {
            ((TbImageView) this.mRootView.findViewById(grP[i2])).setVisibility(8);
        }
        if (this.grO == null || this.grO.bkz() == null || v.D(this.grO.bkz().gpV) <= 0) {
            i = 0;
        } else {
            int i3 = this.grO.bkz().giftNum;
            List<com.baidu.adp.widget.ListView.i> list = this.grO.bkz().gpV;
            for (int i4 = 0; i4 < list.size() && i4 < grP.length; i4++) {
                if (list.get(i4) instanceof com.baidu.tieba.personPolymeric.c.o) {
                    TbImageView tbImageView = (TbImageView) this.mRootView.findViewById(grP[i4]);
                    tbImageView.setVisibility(0);
                    tbImageView.setIsRound(true);
                    tbImageView.startLoad(((com.baidu.tieba.personPolymeric.c.o) list.get(i4)).picUrl, 10, false);
                }
            }
            i = i3;
        }
        this.gsq.setText(String.format(this.mContext.getResources().getString(d.j.gift_num), Integer.valueOf(i)));
    }
}
