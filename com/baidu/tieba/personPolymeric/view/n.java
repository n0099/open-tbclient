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
    private static final int[] hTK = {d.g.img_gift_one, d.g.img_gift_two, d.g.img_gift_three};
    private View bFs;
    protected TextView bUa;
    private TextView daR;
    private com.baidu.tbadk.core.view.userLike.c ehj;
    protected TbImageView hMB;
    protected com.baidu.tieba.view.g hTI;
    protected com.baidu.tieba.personPolymeric.c.a hTJ;
    protected ImageView hTL;
    protected PersonHeadPendantView hTM;
    protected UserIconBox hTN;
    protected TextView hTO;
    protected TextView hTP;
    public com.baidu.tieba.view.e hTQ;
    protected View hTR;
    private TextView hTS;
    private TextView hTT;
    private TextView hTU;
    private View hTV;
    private View hTW;
    private TextView hTX;
    private View hTY;
    private View hTZ;
    private LinearLayout hUa;
    private TextView hUb;
    private m hUc;
    private View hUd;
    private ImageView hUe;
    private TextView hUf;
    private BlueLikeButton hUg;
    private LinearLayout hUh;
    private RelativeLayout hUi;
    private View hUj;
    private TextView hUk;
    private TextView hUl;
    private TextView hUm;
    private int hUn;
    protected Context mContext;
    protected boolean mIsHost;
    private TbPageContext mPageContext;
    protected View mRootView;
    protected UserData mUserData;

    public n(TbPageContext tbPageContext, boolean z) {
        this.hUn = 0;
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.mIsHost = z;
        this.hUn = com.baidu.adp.lib.util.l.h(this.mContext, d.e.tbds46);
        O(aOH());
        TextView textView = this.hTO;
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
        this.hTR = view.findViewById(d.g.person_info_root);
        this.hTM = (PersonHeadPendantView) view.findViewById(d.g.person_polymeric_header_user_img);
        this.hTM.getHeadView().setGodIconResId(d.f.pic_v_avatar_big);
        this.hTM.getHeadView().setGodIconWidth(d.e.ds40);
        this.hTM.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hTM.setDefalutResid(d.f.pic_mycenter_avatar_def_i);
        this.hTM.setBigVIconResId(d.f.pic_v_avatar_big);
        this.hTM.setBigVDimenSize(d.e.ds40);
        this.hMB = (TbImageView) view.findViewById(d.g.person_polymeric_header_user_vip_icon);
        this.bUa = (TextView) view.findViewById(d.g.person_polymeric_header_user_name_txt);
        this.hTP = (TextView) view.findViewById(d.g.seal_prefix_view);
        this.hTN = (UserIconBox) view.findViewById(d.g.person_polymeric_header_label_box);
        this.hTS = (TextView) view.findViewById(d.g.person_polymeric_header_bar_age_txt);
        this.daR = (TextView) view.findViewById(d.g.person_polymeric_header_ala_id);
        this.hTV = view.findViewById(d.g.divider_for_alaid_and_age);
        this.hTO = (TextView) view.findViewById(d.g.person_polymeric_header_visitor_txt);
        this.hTT = (TextView) view.findViewById(d.g.person_polymeric_header_sign_txt);
        this.hTU = (TextView) view.findViewById(d.g.person_center_header_tdou_txt);
        this.hTX = (TextView) view.findViewById(d.g.textview_get_tdou);
        this.hTY = view.findViewById(d.g.divider_for_age_and_tdou);
        this.hTZ = view.findViewById(d.g.divider_for_tdou_and_get_tdou);
        this.hUa = (LinearLayout) view.findViewById(d.g.layout_user_name);
        this.hUb = (TextView) view.findViewById(d.g.person_praise_number);
        this.hTU.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(d.f.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
        this.hTQ = (PersonHeaderAttentionView) view.findViewById(d.g.person_center_header_attention_container);
        bSs();
        this.hUc = new m(this.mContext);
        this.hMB.setOnClickListener(this.hUc);
        this.hTN.setOnClickListener(this.hUc);
        this.hTM.setOnClickListener(this.hUc);
        this.hTO.setOnClickListener(this.hUc);
        this.hTP.setOnClickListener(this.hUc);
        this.hTU.setOnClickListener(this.hUc);
        this.hTX.setOnClickListener(this.hUc);
        this.bUa.setOnClickListener(this.hUc);
        this.hTT.setOnClickListener(this.hUc);
        this.hUd = (LinearLayout) view.findViewById(d.g.container_send_gift);
        this.hUe = (ImageView) view.findViewById(d.g.icon_gift);
        this.hUf = (TextView) view.findViewById(d.g.btn_give_gift);
        this.hUd.setOnClickListener(this.hUc);
        this.hUg = (BlueLikeButton) view.findViewById(d.g.btn_like_blue);
        this.ehj = new com.baidu.tbadk.core.view.userLike.c(this.mPageContext, this.hUg);
        this.ehj.setFromType("2");
        if (this.mIsHost) {
            this.hUd.setVisibility(8);
            this.hUg.setVisibility(8);
        }
        this.hUh = (LinearLayout) view.findViewById(d.g.layout_god_auth_forums);
        this.hUh.setVisibility(8);
        this.bFs = view.findViewById(d.g.header_bottom_divider);
        this.hUi = (RelativeLayout) view.findViewById(d.g.layout_gift);
        this.hUi.setOnClickListener(this.hUc);
        this.hUj = view.findViewById(d.g.gift_top_divider);
        this.hUk = (TextView) view.findViewById(d.g.textview_received_gift);
        this.hUl = (TextView) view.findViewById(d.g.textview_received_gift_num);
        this.hTL = (ImageView) view.findViewById(d.g.img_gift_arrow);
        this.hUm = (TextView) view.findViewById(d.g.btn_edit_person_info);
        this.hUm.setOnClickListener(this.hUc);
        if (!this.mIsHost) {
            this.hUm.setVisibility(8);
        }
    }

    public void e(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null) {
            this.hTJ = aVar;
            this.mUserData = aVar.getUserData();
            this.hUc.a(aVar);
            this.hUc.setIsHost(this.mIsHost);
            this.hTM.a(this.mUserData);
            UserVipInfoData userVipInfo = this.mUserData.getUserVipInfo();
            if (this.mUserData.getIsMem() > 0) {
                if (userVipInfo != null) {
                    this.hMB.startLoad(userVipInfo.getVipIconUrl(), 10, false);
                }
                this.hMB.setVisibility(0);
            } else if (this.mIsHost) {
                this.hMB.setImageDrawable(al.getDrawable(d.f.icon_crown_super_non));
                this.hMB.setVisibility(0);
            } else {
                this.hMB.setVisibility(8);
            }
            bQA();
            String name_show = this.mUserData.getName_show();
            if (!TextUtils.isEmpty(name_show)) {
                this.bUa.setText(name_show);
            }
            int i = d.f.icon_mine_boy;
            if (this.mUserData != null) {
                i = this.mUserData.getSex() == 2 ? d.f.icon_mine_girl : d.f.icon_mine_boy;
            }
            this.bUa.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mContext.getResources().getDrawable(i), (Drawable) null);
            this.hTN.a(this.mUserData.getIconInfo(), 9, this.mContext.getResources().getDimensionPixelSize(d.e.tbds42), this.mContext.getResources().getDimensionPixelSize(d.e.tbds42), this.mContext.getResources().getDimensionPixelSize(d.e.tbds10), true);
            if (this.hTQ != null) {
                this.hTQ.setData(this.mUserData);
            }
            if (this.mUserData != null && this.mUserData.alaUserData != null && this.mUserData.alaUserData.ala_id != 0) {
                this.daR.setVisibility(0);
                this.hTV.setVisibility(0);
                this.daR.setText(String.format(this.mContext.getString(d.j.person_center_ala_id), Long.valueOf(this.mUserData.alaUserData.ala_id)));
            } else {
                this.daR.setVisibility(8);
                this.hTV.setVisibility(8);
            }
            this.hTS.setText(String.format(this.mContext.getString(d.j.person_center_header_bar_age), this.mUserData.getTb_age()));
            if (this.mIsHost) {
                this.hTY.setVisibility(0);
                this.hTZ.setVisibility(0);
                this.hTU.setVisibility(0);
                this.hTX.setVisibility(0);
                this.hTU.setText(ap.aF(this.mUserData.getTDouNum()));
            } else {
                this.hTY.setVisibility(8);
                this.hTZ.setVisibility(8);
                this.hTU.setVisibility(8);
                this.hTX.setVisibility(8);
            }
            String intro = this.mUserData.getIntro();
            if (StringUtils.isNull(intro)) {
                al.d(this.hTT, d.C0277d.cp_cont_e, 1);
            } else {
                al.d(this.hTT, d.C0277d.cp_cont_j, 1);
            }
            if (StringUtils.isNull(intro)) {
                if (this.mIsHost) {
                    intro = this.mContext.getString(d.j.no_person_sign_host);
                } else {
                    intro = this.mContext.getString(d.j.no_person_sign_guest);
                }
            }
            this.hTT.setText(this.mContext.getString(d.j.person_sign) + intro);
            if (this.hTT.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hTT.getLayoutParams();
                if (!this.mIsHost && this.hTT.getLineCount() >= 3 && this.hTT.getMaxLines() != 2147483646) {
                    int lineHeight = this.hTT.getLineHeight();
                    this.hTT.setHeight((lineHeight / 2) + (lineHeight * 3));
                }
                if (this.hTT.getLineCount() >= 2) {
                    layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(d.e.tbds19);
                } else {
                    layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(d.e.tbds80);
                }
                this.hTT.setLayoutParams(layoutParams);
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(this.mUserData.getUserId()) && ((!TbadkCoreApplication.isLogin() || (!StringUtils.isNull(currentAccount) && !currentAccount.equals(this.mUserData.getUserId()))) && this.mUserData.getLiveStatus() == 1)) {
                if (this.hTW == null) {
                    this.hTW = com.baidu.tbadk.ala.b.UH().n(this.mContext, 7);
                }
                com.baidu.tbadk.ala.a aVar2 = new com.baidu.tbadk.ala.a();
                aVar2.bsM = this.mUserData.getAlaUserData();
                aVar2.type = 7;
                if ((this.mUserData.getPersonPrivate() != null && this.mUserData.getPersonPrivate().alp() == 3) || (this.mUserData.getPersonPrivate().alp() == 2 && this.mUserData.getIsFriend() != 1)) {
                    aVar2.bsN = true;
                } else {
                    aVar2.bsN = false;
                }
                if (this.hTW != null) {
                    this.hTW.setTag(aVar2);
                    if (this.hTW.getParent() == null) {
                        this.hUa.addView(this.hTW);
                        TiebaStatic.log(new am("c12541"));
                    }
                }
            } else if (this.hTW != null) {
                this.hTW.setVisibility(8);
            }
            a(aVar.hRE);
            this.mUserData.setIsLike(this.mUserData.getHave_attention() == 1);
            this.ehj.a(this.mUserData);
            bSt();
            bSu();
            this.hUk.setText(this.mIsHost ? d.j.my_received_gift : d.j.he_received_gift);
            if ((this.mUserData.getPersonPrivate() == null || this.mUserData.getPersonPrivate().alp() != 3) && this.mUserData.getPersonPrivate().alp() == 2 && this.mUserData.getIsFriend() != 1) {
            }
        }
    }

    public void Aw(String str) {
        if (!StringUtils.isNull(str)) {
            this.bUa.setText(str);
        }
    }

    public void Ax(String str) {
        if (!StringUtils.isNull(str)) {
            if (this.mUserData != null) {
                this.mUserData.setPortrait(str);
            }
            this.hTM.no(str);
        }
    }

    private void a(UserAgreeInfo userAgreeInfo) {
        if (userAgreeInfo == null) {
            this.hUb.setVisibility(8);
            return;
        }
        this.hUb.setVisibility(0);
        String az = ap.az(userAgreeInfo.total_agree_num.longValue());
        Drawable drawable = al.getDrawable(d.f.icon_home_card_like_s);
        drawable.setBounds(0, 0, this.hUn, this.hUn);
        this.hUb.setCompoundDrawables(drawable, null, null, null);
        this.hUb.setText(az);
    }

    public void onChangeSkinType(int i) {
        this.hTR.setBackgroundDrawable(al.getDrawable(d.f.shape_user_info_bg));
        this.hTM.setBackgroundViewDrawable(al.getDrawable(d.f.shape_user_img_bg));
        int i2 = d.f.icon_mine_boy;
        if (this.mUserData != null) {
            i2 = this.mUserData.getSex() == 1 ? d.f.icon_mine_boy : d.f.icon_pop_girl;
        }
        if (this.mUserData != null && this.mUserData.getIsMem() <= 0 && this.hMB != null && this.mIsHost) {
            this.hMB.setImageDrawable(al.getDrawable(d.f.icon_crown_super_non));
        }
        bQA();
        al.d(this.hTP, d.C0277d.cp_link_tip_a, 1);
        this.bUa.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mContext.getResources().getDrawable(i2), (Drawable) null);
        if (this.hTQ != null) {
            this.hTQ.onChangeSkinType(i);
        }
        al.d(this.hTO, d.C0277d.cp_cont_b, 1);
        al.d(this.hTS, d.C0277d.cp_cont_b, 1);
        al.d(this.daR, d.C0277d.cp_cont_b, 1);
        if (this.mUserData == null || StringUtils.isNull(this.mUserData.getIntro())) {
            al.d(this.hTT, d.C0277d.cp_cont_e, 1);
        } else {
            al.d(this.hTT, d.C0277d.cp_cont_j, 1);
        }
        al.d(this.hTU, d.C0277d.cp_cont_b, 1);
        al.d(this.hTX, d.C0277d.cp_cont_b, 1);
        al.l(this.hTY, d.C0277d.cp_bg_line_b);
        al.l(this.hTV, d.C0277d.cp_bg_line_b);
        al.l(this.hTZ, d.C0277d.cp_bg_line_b);
        al.j(this.hUb, d.C0277d.cp_cont_h);
        this.hTU.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(d.f.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
        Drawable T = al.T(i, d.f.icon_home_card_like_s);
        T.setBounds(0, 0, this.hUn, this.hUn);
        this.hUb.setCompoundDrawables(T, null, null, null);
        al.k(this.hUd, d.f.selector_give_gift_bg);
        al.c(this.hUe, d.f.selector_gift_icon);
        al.d(this.hUf, d.C0277d.selector_give_gift_text_color, 1);
        this.hUg.onChangeSkinType(i);
        al.l(this.bFs, d.C0277d.cp_bg_line_e);
        for (int i3 = 0; i3 < this.hUh.getChildCount(); i3++) {
            View childAt = this.hUh.getChildAt(i3);
            if (childAt != null) {
                TextView textView = (TextView) childAt.findViewById(d.g.bar_name);
                textView.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.pic_v_avatar), (Drawable) null, (Drawable) null, (Drawable) null);
                al.j(textView, d.C0277d.cp_cont_b);
                al.j((TextView) childAt.findViewById(d.g.bar_info), d.C0277d.cp_cont_j);
            }
        }
        for (int i4 = 0; i4 < hTK.length; i4++) {
            ((TbImageView) this.mRootView.findViewById(hTK[i4])).setBackgroundDrawable(al.getDrawable(d.f.shape_gift_icon_bg));
        }
        al.l(this.hUj, d.C0277d.cp_bg_line_e);
        al.j(this.hUk, d.C0277d.cp_cont_b);
        al.j(this.hUl, d.C0277d.cp_cont_d);
        al.c(this.hTL, d.f.icon_arrow_gray_right_n);
        al.k(this.hUm, d.f.selector_like_button_bg);
        al.d(this.hUm, d.C0277d.cp_cont_g, 1);
    }

    public void onDestory() {
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.g gVar) {
        this.hTI = gVar;
        if (this.hTQ != null) {
            this.hTQ.setOnViewResponseListener(this.hTI);
        }
        this.hUc.setOnViewResponseListener(this.hTI);
    }

    public void AM(String str) {
        this.hTM.nn(str);
    }

    protected void bSs() {
        this.hTM.setHasPendantStyle();
        this.hTM.getHeadView().setIsRound(true);
        this.hTM.getHeadView().setDrawBorder(false);
        this.hTM.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    protected void bQA() {
        if (this.mUserData != null && (this.mUserData.getIsMem() > 0 || this.mUserData.isBigV())) {
            al.d(this.bUa, d.C0277d.cp_cont_h, 1);
        } else {
            al.d(this.bUa, d.C0277d.cp_cont_b, 1);
        }
    }

    private void bSt() {
        if (this.hTJ != null && this.hTJ.bSn() != null) {
            this.hUh.removeAllViews();
            int godType = this.hTJ.bSn().getGodType();
            if (godType == 2 && v.S(this.hTJ.bSn().getForumGodList()) > 0) {
                this.hUh.setVisibility(0);
                for (ForumGodDetailInfo forumGodDetailInfo : this.hTJ.bSn().getForumGodList()) {
                    if (forumGodDetailInfo != null) {
                        dC(forumGodDetailInfo.forum_name, forumGodDetailInfo.intro);
                    }
                }
                return;
            } else if (godType == 1 && this.hTJ.bSn().getgodDetailInfo() != null && !StringUtils.isNull(this.hTJ.bSn().getgodDetailInfo().intro)) {
                this.hUh.setVisibility(0);
                dC(this.hTJ.bSn().getgodDetailInfo().intro, "");
                return;
            } else {
                return;
            }
        }
        this.hUh.setVisibility(8);
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
        this.hUh.addView(inflate, layoutParams);
    }

    private void bSu() {
        int i;
        for (int i2 = 0; i2 < hTK.length; i2++) {
            ((TbImageView) this.mRootView.findViewById(hTK[i2])).setVisibility(8);
        }
        if (this.hTJ == null || this.hTJ.bSm() == null || v.S(this.hTJ.bSm().hRS) <= 0) {
            i = 0;
        } else {
            int i3 = this.hTJ.bSm().giftNum;
            List<com.baidu.adp.widget.ListView.m> list = this.hTJ.bSm().hRS;
            for (int i4 = 0; i4 < list.size() && i4 < hTK.length; i4++) {
                if (list.get(i4) instanceof com.baidu.tieba.personPolymeric.c.o) {
                    TbImageView tbImageView = (TbImageView) this.mRootView.findViewById(hTK[i4]);
                    tbImageView.setVisibility(0);
                    tbImageView.setIsRound(true);
                    tbImageView.startLoad(((com.baidu.tieba.personPolymeric.c.o) list.get(i4)).picUrl, 10, false);
                }
            }
            i = i3;
        }
        this.hUl.setText(String.format(this.mContext.getResources().getString(d.j.gift_num), Integer.valueOf(i)));
    }
}
