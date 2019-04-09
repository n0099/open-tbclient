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
import com.baidu.tbadk.core.util.ap;
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
/* loaded from: classes6.dex */
public class n {
    private static final int[] hTL = {d.g.img_gift_one, d.g.img_gift_two, d.g.img_gift_three};
    private View bFt;
    protected TextView bUb;
    private TextView daS;
    private com.baidu.tbadk.core.view.userLike.c ehk;
    protected TbImageView hMC;
    protected com.baidu.tieba.view.g hTJ;
    protected com.baidu.tieba.personPolymeric.c.a hTK;
    protected ImageView hTM;
    protected PersonHeadPendantView hTN;
    protected UserIconBox hTO;
    protected TextView hTP;
    protected TextView hTQ;
    public com.baidu.tieba.view.e hTR;
    protected View hTS;
    private TextView hTT;
    private TextView hTU;
    private TextView hTV;
    private View hTW;
    private View hTX;
    private TextView hTY;
    private View hTZ;
    private View hUa;
    private LinearLayout hUb;
    private TextView hUc;
    private m hUd;
    private View hUe;
    private ImageView hUf;
    private TextView hUg;
    private BlueLikeButton hUh;
    private LinearLayout hUi;
    private RelativeLayout hUj;
    private View hUk;
    private TextView hUl;
    private TextView hUm;
    private TextView hUn;
    private int hUo;
    protected Context mContext;
    protected boolean mIsHost;
    private TbPageContext mPageContext;
    protected View mRootView;
    protected UserData mUserData;

    public n(TbPageContext tbPageContext, boolean z) {
        this.hUo = 0;
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.mIsHost = z;
        this.hUo = com.baidu.adp.lib.util.l.h(this.mContext, d.e.tbds46);
        O(aOH());
        TextView textView = this.hTP;
        if (this.mIsHost) {
        }
        textView.setVisibility(8);
    }

    public View aOH() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(d.h.item_person_polymeric_header_view, (ViewGroup) null);
        }
        return this.mRootView;
    }

    public void O(View view) {
        this.hTS = view.findViewById(d.g.person_info_root);
        this.hTN = (PersonHeadPendantView) view.findViewById(d.g.person_polymeric_header_user_img);
        this.hTN.getHeadView().setGodIconResId(d.f.pic_v_avatar_big);
        this.hTN.getHeadView().setGodIconWidth(d.e.ds40);
        this.hTN.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hTN.setDefalutResid(d.f.pic_mycenter_avatar_def_i);
        this.hTN.setBigVIconResId(d.f.pic_v_avatar_big);
        this.hTN.setBigVDimenSize(d.e.ds40);
        this.hMC = (TbImageView) view.findViewById(d.g.person_polymeric_header_user_vip_icon);
        this.bUb = (TextView) view.findViewById(d.g.person_polymeric_header_user_name_txt);
        this.hTQ = (TextView) view.findViewById(d.g.seal_prefix_view);
        this.hTO = (UserIconBox) view.findViewById(d.g.person_polymeric_header_label_box);
        this.hTT = (TextView) view.findViewById(d.g.person_polymeric_header_bar_age_txt);
        this.daS = (TextView) view.findViewById(d.g.person_polymeric_header_ala_id);
        this.hTW = view.findViewById(d.g.divider_for_alaid_and_age);
        this.hTP = (TextView) view.findViewById(d.g.person_polymeric_header_visitor_txt);
        this.hTU = (TextView) view.findViewById(d.g.person_polymeric_header_sign_txt);
        this.hTV = (TextView) view.findViewById(d.g.person_center_header_tdou_txt);
        this.hTY = (TextView) view.findViewById(d.g.textview_get_tdou);
        this.hTZ = view.findViewById(d.g.divider_for_age_and_tdou);
        this.hUa = view.findViewById(d.g.divider_for_tdou_and_get_tdou);
        this.hUb = (LinearLayout) view.findViewById(d.g.layout_user_name);
        this.hUc = (TextView) view.findViewById(d.g.person_praise_number);
        this.hTV.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(d.f.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
        this.hTR = (PersonHeaderAttentionView) view.findViewById(d.g.person_center_header_attention_container);
        bSs();
        this.hUd = new m(this.mContext);
        this.hMC.setOnClickListener(this.hUd);
        this.hTO.setOnClickListener(this.hUd);
        this.hTN.setOnClickListener(this.hUd);
        this.hTP.setOnClickListener(this.hUd);
        this.hTQ.setOnClickListener(this.hUd);
        this.hTV.setOnClickListener(this.hUd);
        this.hTY.setOnClickListener(this.hUd);
        this.bUb.setOnClickListener(this.hUd);
        this.hTU.setOnClickListener(this.hUd);
        this.hUe = (LinearLayout) view.findViewById(d.g.container_send_gift);
        this.hUf = (ImageView) view.findViewById(d.g.icon_gift);
        this.hUg = (TextView) view.findViewById(d.g.btn_give_gift);
        this.hUe.setOnClickListener(this.hUd);
        this.hUh = (BlueLikeButton) view.findViewById(d.g.btn_like_blue);
        this.ehk = new com.baidu.tbadk.core.view.userLike.c(this.mPageContext, this.hUh);
        this.ehk.setFromType("2");
        if (this.mIsHost) {
            this.hUe.setVisibility(8);
            this.hUh.setVisibility(8);
        }
        this.hUi = (LinearLayout) view.findViewById(d.g.layout_god_auth_forums);
        this.hUi.setVisibility(8);
        this.bFt = view.findViewById(d.g.header_bottom_divider);
        this.hUj = (RelativeLayout) view.findViewById(d.g.layout_gift);
        this.hUj.setOnClickListener(this.hUd);
        this.hUk = view.findViewById(d.g.gift_top_divider);
        this.hUl = (TextView) view.findViewById(d.g.textview_received_gift);
        this.hUm = (TextView) view.findViewById(d.g.textview_received_gift_num);
        this.hTM = (ImageView) view.findViewById(d.g.img_gift_arrow);
        this.hUn = (TextView) view.findViewById(d.g.btn_edit_person_info);
        this.hUn.setOnClickListener(this.hUd);
        if (!this.mIsHost) {
            this.hUn.setVisibility(8);
        }
    }

    public void e(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null) {
            this.hTK = aVar;
            this.mUserData = aVar.getUserData();
            this.hUd.a(aVar);
            this.hUd.setIsHost(this.mIsHost);
            this.hTN.a(this.mUserData);
            UserVipInfoData userVipInfo = this.mUserData.getUserVipInfo();
            if (this.mUserData.getIsMem() > 0) {
                if (userVipInfo != null) {
                    this.hMC.startLoad(userVipInfo.getVipIconUrl(), 10, false);
                }
                this.hMC.setVisibility(0);
            } else if (this.mIsHost) {
                this.hMC.setImageDrawable(al.getDrawable(d.f.icon_crown_super_non));
                this.hMC.setVisibility(0);
            } else {
                this.hMC.setVisibility(8);
            }
            bQA();
            String name_show = this.mUserData.getName_show();
            if (!TextUtils.isEmpty(name_show)) {
                this.bUb.setText(name_show);
            }
            int i = d.f.icon_mine_boy;
            if (this.mUserData != null) {
                i = this.mUserData.getSex() == 2 ? d.f.icon_mine_girl : d.f.icon_mine_boy;
            }
            this.bUb.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mContext.getResources().getDrawable(i), (Drawable) null);
            this.hTO.a(this.mUserData.getIconInfo(), 9, this.mContext.getResources().getDimensionPixelSize(d.e.tbds42), this.mContext.getResources().getDimensionPixelSize(d.e.tbds42), this.mContext.getResources().getDimensionPixelSize(d.e.tbds10), true);
            if (this.hTR != null) {
                this.hTR.setData(this.mUserData);
            }
            if (this.mUserData != null && this.mUserData.alaUserData != null && this.mUserData.alaUserData.ala_id != 0) {
                this.daS.setVisibility(0);
                this.hTW.setVisibility(0);
                this.daS.setText(String.format(this.mContext.getString(d.j.person_center_ala_id), Long.valueOf(this.mUserData.alaUserData.ala_id)));
            } else {
                this.daS.setVisibility(8);
                this.hTW.setVisibility(8);
            }
            this.hTT.setText(String.format(this.mContext.getString(d.j.person_center_header_bar_age), this.mUserData.getTb_age()));
            if (this.mIsHost) {
                this.hTZ.setVisibility(0);
                this.hUa.setVisibility(0);
                this.hTV.setVisibility(0);
                this.hTY.setVisibility(0);
                this.hTV.setText(ap.aF(this.mUserData.getTDouNum()));
            } else {
                this.hTZ.setVisibility(8);
                this.hUa.setVisibility(8);
                this.hTV.setVisibility(8);
                this.hTY.setVisibility(8);
            }
            String intro = this.mUserData.getIntro();
            if (StringUtils.isNull(intro)) {
                al.d(this.hTU, d.C0277d.cp_cont_e, 1);
            } else {
                al.d(this.hTU, d.C0277d.cp_cont_j, 1);
            }
            if (StringUtils.isNull(intro)) {
                if (this.mIsHost) {
                    intro = this.mContext.getString(d.j.no_person_sign_host);
                } else {
                    intro = this.mContext.getString(d.j.no_person_sign_guest);
                }
            }
            this.hTU.setText(this.mContext.getString(d.j.person_sign) + intro);
            if (this.hTU.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hTU.getLayoutParams();
                if (!this.mIsHost && this.hTU.getLineCount() >= 3 && this.hTU.getMaxLines() != 2147483646) {
                    int lineHeight = this.hTU.getLineHeight();
                    this.hTU.setHeight((lineHeight / 2) + (lineHeight * 3));
                }
                if (this.hTU.getLineCount() >= 2) {
                    layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(d.e.tbds19);
                } else {
                    layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(d.e.tbds80);
                }
                this.hTU.setLayoutParams(layoutParams);
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(this.mUserData.getUserId()) && ((!TbadkCoreApplication.isLogin() || (!StringUtils.isNull(currentAccount) && !currentAccount.equals(this.mUserData.getUserId()))) && this.mUserData.getLiveStatus() == 1)) {
                if (this.hTX == null) {
                    this.hTX = com.baidu.tbadk.ala.b.UH().n(this.mContext, 7);
                }
                com.baidu.tbadk.ala.a aVar2 = new com.baidu.tbadk.ala.a();
                aVar2.bsN = this.mUserData.getAlaUserData();
                aVar2.type = 7;
                if ((this.mUserData.getPersonPrivate() != null && this.mUserData.getPersonPrivate().alp() == 3) || (this.mUserData.getPersonPrivate().alp() == 2 && this.mUserData.getIsFriend() != 1)) {
                    aVar2.bsO = true;
                } else {
                    aVar2.bsO = false;
                }
                if (this.hTX != null) {
                    this.hTX.setTag(aVar2);
                    if (this.hTX.getParent() == null) {
                        this.hUb.addView(this.hTX);
                        TiebaStatic.log(new am("c12541"));
                    }
                }
            } else if (this.hTX != null) {
                this.hTX.setVisibility(8);
            }
            a(aVar.hRF);
            this.mUserData.setIsLike(this.mUserData.getHave_attention() == 1);
            this.ehk.a(this.mUserData);
            bSt();
            bSu();
            this.hUl.setText(this.mIsHost ? d.j.my_received_gift : d.j.he_received_gift);
            if ((this.mUserData.getPersonPrivate() == null || this.mUserData.getPersonPrivate().alp() != 3) && this.mUserData.getPersonPrivate().alp() == 2 && this.mUserData.getIsFriend() != 1) {
            }
        }
    }

    public void Aw(String str) {
        if (!StringUtils.isNull(str)) {
            this.bUb.setText(str);
        }
    }

    public void Ax(String str) {
        if (!StringUtils.isNull(str)) {
            if (this.mUserData != null) {
                this.mUserData.setPortrait(str);
            }
            this.hTN.no(str);
        }
    }

    private void a(UserAgreeInfo userAgreeInfo) {
        if (userAgreeInfo == null) {
            this.hUc.setVisibility(8);
            return;
        }
        this.hUc.setVisibility(0);
        String az = ap.az(userAgreeInfo.total_agree_num.longValue());
        Drawable drawable = al.getDrawable(d.f.icon_home_card_like_s);
        drawable.setBounds(0, 0, this.hUo, this.hUo);
        this.hUc.setCompoundDrawables(drawable, null, null, null);
        this.hUc.setText(az);
    }

    public void onChangeSkinType(int i) {
        this.hTS.setBackgroundDrawable(al.getDrawable(d.f.shape_user_info_bg));
        this.hTN.setBackgroundViewDrawable(al.getDrawable(d.f.shape_user_img_bg));
        int i2 = d.f.icon_mine_boy;
        if (this.mUserData != null) {
            i2 = this.mUserData.getSex() == 1 ? d.f.icon_mine_boy : d.f.icon_pop_girl;
        }
        if (this.mUserData != null && this.mUserData.getIsMem() <= 0 && this.hMC != null && this.mIsHost) {
            this.hMC.setImageDrawable(al.getDrawable(d.f.icon_crown_super_non));
        }
        bQA();
        al.d(this.hTQ, d.C0277d.cp_link_tip_a, 1);
        this.bUb.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mContext.getResources().getDrawable(i2), (Drawable) null);
        if (this.hTR != null) {
            this.hTR.onChangeSkinType(i);
        }
        al.d(this.hTP, d.C0277d.cp_cont_b, 1);
        al.d(this.hTT, d.C0277d.cp_cont_b, 1);
        al.d(this.daS, d.C0277d.cp_cont_b, 1);
        if (this.mUserData == null || StringUtils.isNull(this.mUserData.getIntro())) {
            al.d(this.hTU, d.C0277d.cp_cont_e, 1);
        } else {
            al.d(this.hTU, d.C0277d.cp_cont_j, 1);
        }
        al.d(this.hTV, d.C0277d.cp_cont_b, 1);
        al.d(this.hTY, d.C0277d.cp_cont_b, 1);
        al.l(this.hTZ, d.C0277d.cp_bg_line_b);
        al.l(this.hTW, d.C0277d.cp_bg_line_b);
        al.l(this.hUa, d.C0277d.cp_bg_line_b);
        al.j(this.hUc, d.C0277d.cp_cont_h);
        this.hTV.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(d.f.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
        Drawable T = al.T(i, d.f.icon_home_card_like_s);
        T.setBounds(0, 0, this.hUo, this.hUo);
        this.hUc.setCompoundDrawables(T, null, null, null);
        al.k(this.hUe, d.f.selector_give_gift_bg);
        al.c(this.hUf, d.f.selector_gift_icon);
        al.d(this.hUg, d.C0277d.selector_give_gift_text_color, 1);
        this.hUh.onChangeSkinType(i);
        al.l(this.bFt, d.C0277d.cp_bg_line_e);
        for (int i3 = 0; i3 < this.hUi.getChildCount(); i3++) {
            View childAt = this.hUi.getChildAt(i3);
            if (childAt != null) {
                TextView textView = (TextView) childAt.findViewById(d.g.bar_name);
                textView.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.pic_v_avatar), (Drawable) null, (Drawable) null, (Drawable) null);
                al.j(textView, d.C0277d.cp_cont_b);
                al.j((TextView) childAt.findViewById(d.g.bar_info), d.C0277d.cp_cont_j);
            }
        }
        for (int i4 = 0; i4 < hTL.length; i4++) {
            ((TbImageView) this.mRootView.findViewById(hTL[i4])).setBackgroundDrawable(al.getDrawable(d.f.shape_gift_icon_bg));
        }
        al.l(this.hUk, d.C0277d.cp_bg_line_e);
        al.j(this.hUl, d.C0277d.cp_cont_b);
        al.j(this.hUm, d.C0277d.cp_cont_d);
        al.c(this.hTM, d.f.icon_arrow_gray_right_n);
        al.k(this.hUn, d.f.selector_like_button_bg);
        al.d(this.hUn, d.C0277d.cp_cont_g, 1);
    }

    public void onDestory() {
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.g gVar) {
        this.hTJ = gVar;
        if (this.hTR != null) {
            this.hTR.setOnViewResponseListener(this.hTJ);
        }
        this.hUd.setOnViewResponseListener(this.hTJ);
    }

    public void AM(String str) {
        this.hTN.nn(str);
    }

    protected void bSs() {
        this.hTN.setHasPendantStyle();
        this.hTN.getHeadView().setIsRound(true);
        this.hTN.getHeadView().setDrawBorder(false);
        this.hTN.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    protected void bQA() {
        if (this.mUserData != null && (this.mUserData.getIsMem() > 0 || this.mUserData.isBigV())) {
            al.d(this.bUb, d.C0277d.cp_cont_h, 1);
        } else {
            al.d(this.bUb, d.C0277d.cp_cont_b, 1);
        }
    }

    private void bSt() {
        if (this.hTK != null && this.hTK.bSn() != null) {
            this.hUi.removeAllViews();
            int godType = this.hTK.bSn().getGodType();
            if (godType == 2 && v.S(this.hTK.bSn().getForumGodList()) > 0) {
                this.hUi.setVisibility(0);
                for (ForumGodDetailInfo forumGodDetailInfo : this.hTK.bSn().getForumGodList()) {
                    if (forumGodDetailInfo != null) {
                        dC(forumGodDetailInfo.forum_name, forumGodDetailInfo.intro);
                    }
                }
                return;
            } else if (godType == 1 && this.hTK.bSn().getgodDetailInfo() != null && !StringUtils.isNull(this.hTK.bSn().getgodDetailInfo().intro)) {
                this.hUi.setVisibility(0);
                dC(this.hTK.bSn().getgodDetailInfo().intro, "");
                return;
            } else {
                return;
            }
        }
        this.hUi.setVisibility(8);
    }

    private void dC(String str, String str2) {
        View inflate = LayoutInflater.from(this.mContext).inflate(d.h.layout_god_auth_info, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(d.g.bar_name);
        textView.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.pic_v_avatar), (Drawable) null, (Drawable) null, (Drawable) null);
        al.j(textView, d.C0277d.cp_cont_b);
        textView.setText(str);
        TextView textView2 = (TextView) inflate.findViewById(d.g.bar_info);
        al.j(textView2, d.C0277d.cp_cont_j);
        textView2.setText(str2);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.ds14);
        this.hUi.addView(inflate, layoutParams);
    }

    private void bSu() {
        int i;
        for (int i2 = 0; i2 < hTL.length; i2++) {
            ((TbImageView) this.mRootView.findViewById(hTL[i2])).setVisibility(8);
        }
        if (this.hTK == null || this.hTK.bSm() == null || v.S(this.hTK.bSm().hRT) <= 0) {
            i = 0;
        } else {
            int i3 = this.hTK.bSm().giftNum;
            List<com.baidu.adp.widget.ListView.m> list = this.hTK.bSm().hRT;
            for (int i4 = 0; i4 < list.size() && i4 < hTL.length; i4++) {
                if (list.get(i4) instanceof com.baidu.tieba.personPolymeric.c.o) {
                    TbImageView tbImageView = (TbImageView) this.mRootView.findViewById(hTL[i4]);
                    tbImageView.setVisibility(0);
                    tbImageView.setIsRound(true);
                    tbImageView.startLoad(((com.baidu.tieba.personPolymeric.c.o) list.get(i4)).picUrl, 10, false);
                }
            }
            i = i3;
        }
        this.hUm.setText(String.format(this.mContext.getResources().getString(d.j.gift_num), Integer.valueOf(i)));
    }
}
