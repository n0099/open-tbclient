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
    private static final int[] grK = {d.g.img_gift_one, d.g.img_gift_two, d.g.img_gift_three};
    protected TextView bfg;
    private com.baidu.tbadk.core.view.userLike.c cWj;
    private TextView caG;
    private View egZ;
    protected TbImageView gkp;
    protected com.baidu.tieba.view.i grI;
    protected com.baidu.tieba.personPolymeric.c.a grJ;
    protected ImageView grL;
    protected PersonHeadPendantView grM;
    protected UserIconBox grN;
    protected TextView grO;
    protected TextView grP;
    public com.baidu.tieba.view.g grQ;
    protected View grR;
    private TextView grS;
    private TextView grT;
    private TextView grU;
    private View grV;
    private View grW;
    private TextView grX;
    private View grY;
    private View grZ;
    private LinearLayout gsa;
    private TextView gsb;
    private p gsc;
    private View gsd;
    private ImageView gse;
    private TextView gsf;
    private BlueLikeButton gsg;
    private LinearLayout gsh;
    private RelativeLayout gsi;
    private View gsj;
    private TextView gsk;
    private TextView gsl;
    private int gsm;
    protected Context mContext;
    protected boolean mIsHost;
    private TbPageContext mPageContext;
    protected View mRootView;
    protected UserData mUserData;

    public q(TbPageContext tbPageContext, boolean z) {
        this.gsm = 0;
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.mIsHost = z;
        this.gsm = com.baidu.adp.lib.util.l.t(this.mContext, d.e.tbds46);
        bu(aix());
        TextView textView = this.grO;
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
        this.grR = view.findViewById(d.g.person_info_root);
        this.grM = (PersonHeadPendantView) view.findViewById(d.g.person_polymeric_header_user_img);
        this.grM.getHeadView().setCustomBigViewIconId(d.f.pic_v_avatar_big);
        this.grM.getHeadView().setIconWidth(this.mContext.getResources().getDimensionPixelSize(d.e.ds40));
        this.grM.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gkp = (TbImageView) view.findViewById(d.g.person_polymeric_header_user_vip_icon);
        this.bfg = (TextView) view.findViewById(d.g.person_polymeric_header_user_name_txt);
        this.grP = (TextView) view.findViewById(d.g.seal_prefix_view);
        this.grN = (UserIconBox) view.findViewById(d.g.person_polymeric_header_label_box);
        this.grS = (TextView) view.findViewById(d.g.person_polymeric_header_bar_age_txt);
        this.caG = (TextView) view.findViewById(d.g.person_polymeric_header_ala_id);
        this.grV = view.findViewById(d.g.divider_for_alaid_and_age);
        this.grO = (TextView) view.findViewById(d.g.person_polymeric_header_visitor_txt);
        this.grT = (TextView) view.findViewById(d.g.person_polymeric_header_sign_txt);
        this.grU = (TextView) view.findViewById(d.g.person_center_header_tdou_txt);
        this.grX = (TextView) view.findViewById(d.g.textview_get_tdou);
        this.grY = view.findViewById(d.g.divider_for_age_and_tdou);
        this.grZ = view.findViewById(d.g.divider_for_tdou_and_get_tdou);
        this.gsa = (LinearLayout) view.findViewById(d.g.layout_user_name);
        this.gsb = (TextView) view.findViewById(d.g.person_praise_number);
        this.grU.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(d.f.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
        this.grQ = (PersonHeaderAttentionView) view.findViewById(d.g.person_center_header_attention_container);
        bkG();
        this.gsc = new p(this.mContext);
        this.gkp.setOnClickListener(this.gsc);
        this.grN.setOnClickListener(this.gsc);
        this.grM.setOnClickListener(this.gsc);
        this.grO.setOnClickListener(this.gsc);
        this.grP.setOnClickListener(this.gsc);
        this.grU.setOnClickListener(this.gsc);
        this.grX.setOnClickListener(this.gsc);
        this.bfg.setOnClickListener(this.gsc);
        this.grT.setOnClickListener(this.gsc);
        this.gsd = (LinearLayout) view.findViewById(d.g.container_send_gift);
        this.gse = (ImageView) view.findViewById(d.g.icon_gift);
        this.gsf = (TextView) view.findViewById(d.g.btn_give_gift);
        this.gsd.setOnClickListener(this.gsc);
        this.gsg = (BlueLikeButton) view.findViewById(d.g.btn_like_blue);
        this.cWj = new com.baidu.tbadk.core.view.userLike.c(this.mPageContext, this.gsg);
        this.cWj.setFromType("2");
        if (this.mIsHost) {
            this.gsd.setVisibility(8);
            this.gsg.setVisibility(8);
        }
        this.gsh = (LinearLayout) view.findViewById(d.g.layout_god_auth_forums);
        this.gsh.setVisibility(8);
        this.egZ = view.findViewById(d.g.header_bottom_divider);
        this.gsi = (RelativeLayout) view.findViewById(d.g.layout_gift);
        this.gsi.setOnClickListener(this.gsc);
        this.gsj = view.findViewById(d.g.gift_top_divider);
        this.gsk = (TextView) view.findViewById(d.g.textview_received_gift);
        this.gsl = (TextView) view.findViewById(d.g.textview_received_gift_num);
        this.grL = (ImageView) view.findViewById(d.g.img_gift_arrow);
    }

    public void e(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null) {
            this.grJ = aVar;
            this.mUserData = aVar.getUserData();
            this.gsc.a(aVar);
            this.gsc.setIsHost(this.mIsHost);
            String portrait = this.mUserData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                String ec = com.baidu.tbadk.core.util.o.ec(portrait);
                this.grM.getHeadView().setUrl(ec);
                this.grM.getHeadView().startLoad(ec, 25, false);
            } else {
                this.grM.getHeadView().startLoad(String.valueOf(d.f.pic_mycenter_avatar_def_i), 24, false);
            }
            com.baidu.tbadk.data.h pendantData = this.mUserData.getPendantData();
            if (pendantData != null) {
                this.grM.eS(pendantData.ya());
            }
            if (this.grM.DS()) {
                this.grM.getHeadView().setShowV(false);
            } else if (this.mUserData.isBigV() || !StringUtils.isNull(this.mUserData.getUserTbVipInfoData().getvipV_url())) {
                this.grM.getHeadView().setShowV(true);
            } else {
                this.grM.getHeadView().setShowV(false);
            }
            UserVipInfoData userVipInfo = this.mUserData.getUserVipInfo();
            if (this.mUserData.getIsMem() > 0) {
                if (userVipInfo != null) {
                    this.gkp.startLoad(userVipInfo.getVipIconUrl(), 10, false);
                }
                this.gkp.setVisibility(0);
            } else if (this.mIsHost) {
                this.gkp.setImageDrawable(aj.getDrawable(d.f.icon_crown_super_non));
                this.gkp.setVisibility(0);
            } else {
                this.gkp.setVisibility(8);
            }
            biO();
            String name_show = this.mUserData.getName_show();
            if (!TextUtils.isEmpty(name_show)) {
                this.bfg.setText(name_show);
            }
            int i = d.f.icon_mine_boy;
            if (this.mUserData != null) {
                i = this.mUserData.getSex() == 2 ? d.f.icon_mine_girl : d.f.icon_mine_boy;
            }
            this.bfg.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mContext.getResources().getDrawable(i), (Drawable) null);
            this.grN.a(this.mUserData.getIconInfo(), 9, this.mContext.getResources().getDimensionPixelSize(d.e.tbds42), this.mContext.getResources().getDimensionPixelSize(d.e.tbds42), this.mContext.getResources().getDimensionPixelSize(d.e.tbds10), true);
            if (this.grQ != null) {
                this.grQ.setData(this.mUserData);
            }
            if (this.mUserData != null && this.mUserData.alaUserData != null && this.mUserData.alaUserData.ala_id != 0) {
                this.caG.setVisibility(0);
                this.grV.setVisibility(0);
                this.caG.setText(String.format(this.mContext.getString(d.j.person_center_ala_id), Long.valueOf(this.mUserData.alaUserData.ala_id)));
            } else {
                this.caG.setVisibility(8);
                this.grV.setVisibility(8);
            }
            this.grS.setText(String.format(this.mContext.getString(d.j.person_center_header_bar_age), this.mUserData.getTb_age()));
            if (this.mIsHost) {
                this.grY.setVisibility(0);
                this.grZ.setVisibility(0);
                this.grU.setVisibility(0);
                this.grX.setVisibility(0);
                this.grU.setText(am.P(this.mUserData.getTDouNum()));
            } else {
                this.grY.setVisibility(8);
                this.grZ.setVisibility(8);
                this.grU.setVisibility(8);
                this.grX.setVisibility(8);
            }
            String intro = this.mUserData.getIntro();
            if (StringUtils.isNull(intro)) {
                aj.e(this.grT, d.C0140d.cp_cont_e, 1);
            } else {
                aj.e(this.grT, d.C0140d.cp_cont_j, 1);
            }
            if (StringUtils.isNull(intro)) {
                if (this.mIsHost) {
                    intro = this.mContext.getString(d.j.no_person_sign_host);
                } else {
                    intro = this.mContext.getString(d.j.no_person_sign_guest);
                }
            }
            this.grT.setText(this.mContext.getString(d.j.person_sign) + intro);
            if (this.grT.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.grT.getLayoutParams();
                if (!this.mIsHost && this.grT.getLineCount() >= 3 && this.grT.getMaxLines() != 2147483646) {
                    int lineHeight = this.grT.getLineHeight();
                    this.grT.setHeight((lineHeight / 2) + (lineHeight * 3));
                }
                if (this.grT.getLineCount() >= 2) {
                    layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(d.e.tbds19);
                } else {
                    layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(d.e.tbds80);
                }
                this.grT.setLayoutParams(layoutParams);
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(this.mUserData.getUserId()) && ((!TbadkCoreApplication.isLogin() || (!StringUtils.isNull(currentAccount) && !currentAccount.equals(this.mUserData.getUserId()))) && this.mUserData.getLiveStatus() == 1)) {
                if (this.grW == null) {
                    this.grW = com.baidu.tbadk.ala.b.vL().u(this.mContext, 7);
                }
                com.baidu.tbadk.ala.a aVar2 = new com.baidu.tbadk.ala.a();
                aVar2.aHe = this.mUserData.getAlaUserData();
                aVar2.type = 7;
                if ((this.mUserData.getPersonPrivate() != null && this.mUserData.getPersonPrivate().KB() == 3) || (this.mUserData.getPersonPrivate().KB() == 2 && this.mUserData.getIsFriend() != 1)) {
                    aVar2.aHf = true;
                } else {
                    aVar2.aHf = false;
                }
                if (this.grW != null) {
                    this.grW.setTag(aVar2);
                    if (this.grW.getParent() == null) {
                        this.gsa.addView(this.grW);
                        TiebaStatic.log(new ak("c12541"));
                    }
                }
            } else if (this.grW != null) {
                this.grW.setVisibility(8);
            }
            a(aVar.gpC);
            this.mUserData.setIsLike(this.mUserData.getHave_attention() == 1);
            this.cWj.a(this.mUserData);
            bkH();
            bkI();
            this.gsk.setText(this.mIsHost ? d.j.my_received_gift : d.j.he_received_gift);
            if ((this.mUserData.getPersonPrivate() == null || this.mUserData.getPersonPrivate().KB() != 3) && this.mUserData.getPersonPrivate().KB() == 2 && this.mUserData.getIsFriend() != 1) {
            }
        }
    }

    private void a(UserAgreeInfo userAgreeInfo) {
        if (userAgreeInfo == null) {
            this.gsb.setVisibility(8);
            return;
        }
        this.gsb.setVisibility(0);
        String J = am.J(userAgreeInfo.total_agree_num.longValue());
        Drawable drawable = aj.getDrawable(d.f.icon_home_card_like_s);
        drawable.setBounds(0, 0, this.gsm, this.gsm);
        this.gsb.setCompoundDrawables(drawable, null, null, null);
        this.gsb.setText(J);
    }

    public void onChangeSkinType(int i) {
        this.grR.setBackgroundDrawable(aj.getDrawable(d.f.shape_user_info_bg));
        this.grM.setBackgroundViewDrawable(aj.getDrawable(d.f.shape_user_img_bg));
        int i2 = d.f.icon_mine_boy;
        if (this.mUserData != null) {
            i2 = this.mUserData.getSex() == 1 ? d.f.icon_mine_boy : d.f.icon_pop_girl;
        }
        if (this.mUserData != null && this.mUserData.getIsMem() <= 0 && this.gkp != null && this.mIsHost) {
            this.gkp.setImageDrawable(aj.getDrawable(d.f.icon_crown_super_non));
        }
        biO();
        aj.e(this.grP, d.C0140d.cp_link_tip_a, 1);
        this.bfg.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mContext.getResources().getDrawable(i2), (Drawable) null);
        if (this.grQ != null) {
            this.grQ.onChangeSkinType(i);
        }
        aj.e(this.grO, d.C0140d.cp_cont_b, 1);
        aj.e(this.grS, d.C0140d.cp_cont_b, 1);
        aj.e(this.caG, d.C0140d.cp_cont_b, 1);
        if (this.mUserData == null || StringUtils.isNull(this.mUserData.getIntro())) {
            aj.e(this.grT, d.C0140d.cp_cont_e, 1);
        } else {
            aj.e(this.grT, d.C0140d.cp_cont_j, 1);
        }
        aj.e(this.grU, d.C0140d.cp_cont_b, 1);
        aj.e(this.grX, d.C0140d.cp_cont_b, 1);
        aj.t(this.grY, d.C0140d.cp_bg_line_b);
        aj.t(this.grV, d.C0140d.cp_bg_line_b);
        aj.t(this.grZ, d.C0140d.cp_bg_line_b);
        aj.r(this.gsb, d.C0140d.cp_cont_h);
        this.grU.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(d.f.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
        Drawable au = aj.au(i, d.f.icon_home_card_like_s);
        au.setBounds(0, 0, this.gsm, this.gsm);
        this.gsb.setCompoundDrawables(au, null, null, null);
        aj.s(this.gsd, d.f.selector_give_gift_bg);
        aj.c(this.gse, d.f.selector_gift_icon);
        aj.e(this.gsf, d.C0140d.selector_give_gift_text_color, 1);
        this.gsg.onChangeSkinType(i);
        aj.t(this.egZ, d.C0140d.cp_bg_line_e);
        for (int i3 = 0; i3 < this.gsh.getChildCount(); i3++) {
            View childAt = this.gsh.getChildAt(i3);
            if (childAt != null) {
                TextView textView = (TextView) childAt.findViewById(d.g.bar_name);
                textView.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.pic_v_avatar), (Drawable) null, (Drawable) null, (Drawable) null);
                aj.r(textView, d.C0140d.cp_cont_b);
                aj.r((TextView) childAt.findViewById(d.g.bar_info), d.C0140d.cp_cont_j);
            }
        }
        for (int i4 = 0; i4 < grK.length; i4++) {
            ((TbImageView) this.mRootView.findViewById(grK[i4])).setBackgroundDrawable(aj.getDrawable(d.f.shape_gift_icon_bg));
        }
        aj.t(this.gsj, d.C0140d.cp_bg_line_e);
        aj.r(this.gsk, d.C0140d.cp_cont_b);
        aj.r(this.gsl, d.C0140d.cp_cont_d);
        aj.c(this.grL, d.f.icon_arrow_gray_right_n);
    }

    public void onDestory() {
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.i iVar) {
        this.grI = iVar;
        if (this.grQ != null) {
            this.grQ.setOnViewResponseListener(this.grI);
        }
        this.gsc.setOnViewResponseListener(this.grI);
    }

    public void rf(String str) {
        this.grM.eS(str);
        if (!StringUtils.isNull(str)) {
            this.grM.getHeadView().setShowV(false);
        } else if (this.mUserData.isBigV() || !StringUtils.isNull(this.mUserData.getUserTbVipInfoData().getvipV_url())) {
            this.grM.getHeadView().setShowV(true);
        } else {
            this.grM.getHeadView().setShowV(false);
        }
    }

    protected void bkG() {
        this.grM.DT();
        this.grM.getHeadView().setIsRound(true);
        this.grM.getHeadView().setDrawBorder(false);
        this.grM.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    protected void biO() {
        if (this.mUserData != null && (this.mUserData.getIsMem() > 0 || this.mUserData.isBigV())) {
            aj.e(this.bfg, d.C0140d.cp_cont_h, 1);
        } else {
            aj.e(this.bfg, d.C0140d.cp_cont_b, 1);
        }
    }

    private void bkH() {
        if (this.grJ != null && this.grJ.bkA() != null) {
            this.gsh.removeAllViews();
            int godType = this.grJ.bkA().getGodType();
            if (godType == 2 && v.D(this.grJ.bkA().getForumGodList()) > 0) {
                this.gsh.setVisibility(0);
                for (ForumGodDetailInfo forumGodDetailInfo : this.grJ.bkA().getForumGodList()) {
                    if (forumGodDetailInfo != null) {
                        bJ(forumGodDetailInfo.forum_name, forumGodDetailInfo.intro);
                    }
                }
                return;
            } else if (godType == 1 && this.grJ.bkA().getgodDetailInfo() != null && !StringUtils.isNull(this.grJ.bkA().getgodDetailInfo().intro)) {
                this.gsh.setVisibility(0);
                bJ(this.grJ.bkA().getgodDetailInfo().intro, "");
                return;
            } else {
                return;
            }
        }
        this.gsh.setVisibility(8);
    }

    private void bJ(String str, String str2) {
        View inflate = LayoutInflater.from(this.mContext).inflate(d.h.layout_god_auth_info, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(d.g.bar_name);
        textView.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.pic_v_avatar), (Drawable) null, (Drawable) null, (Drawable) null);
        aj.r(textView, d.C0140d.cp_cont_b);
        textView.setText(str);
        TextView textView2 = (TextView) inflate.findViewById(d.g.bar_info);
        aj.r(textView2, d.C0140d.cp_cont_j);
        textView2.setText(str2);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.ds14);
        this.gsh.addView(inflate, layoutParams);
    }

    private void bkI() {
        int i;
        for (int i2 = 0; i2 < grK.length; i2++) {
            ((TbImageView) this.mRootView.findViewById(grK[i2])).setVisibility(8);
        }
        if (this.grJ == null || this.grJ.bkz() == null || v.D(this.grJ.bkz().gpQ) <= 0) {
            i = 0;
        } else {
            int i3 = this.grJ.bkz().giftNum;
            List<com.baidu.adp.widget.ListView.i> list = this.grJ.bkz().gpQ;
            for (int i4 = 0; i4 < list.size() && i4 < grK.length; i4++) {
                if (list.get(i4) instanceof com.baidu.tieba.personPolymeric.c.o) {
                    TbImageView tbImageView = (TbImageView) this.mRootView.findViewById(grK[i4]);
                    tbImageView.setVisibility(0);
                    tbImageView.setIsRound(true);
                    tbImageView.startLoad(((com.baidu.tieba.personPolymeric.c.o) list.get(i4)).picUrl, 10, false);
                }
            }
            i = i3;
        }
        this.gsl.setText(String.format(this.mContext.getResources().getString(d.j.gift_num), Integer.valueOf(i)));
    }
}
