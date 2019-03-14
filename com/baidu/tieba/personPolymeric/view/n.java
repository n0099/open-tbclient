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
    private static final int[] hTY = {d.g.img_gift_one, d.g.img_gift_two, d.g.img_gift_three};
    private View bFq;
    protected TextView bTY;
    private TextView daO;
    private com.baidu.tbadk.core.view.userLike.c ehx;
    protected TbImageView hMP;
    protected com.baidu.tieba.view.g hTW;
    protected com.baidu.tieba.personPolymeric.c.a hTX;
    protected ImageView hTZ;
    private TextView hUA;
    private int hUB;
    protected PersonHeadPendantView hUa;
    protected UserIconBox hUb;
    protected TextView hUc;
    protected TextView hUd;
    public com.baidu.tieba.view.e hUe;
    protected View hUf;
    private TextView hUg;
    private TextView hUh;
    private TextView hUi;
    private View hUj;
    private View hUk;
    private TextView hUl;
    private View hUm;
    private View hUn;
    private LinearLayout hUo;
    private TextView hUp;
    private m hUq;
    private View hUr;
    private ImageView hUs;
    private TextView hUt;
    private BlueLikeButton hUu;
    private LinearLayout hUv;
    private RelativeLayout hUw;
    private View hUx;
    private TextView hUy;
    private TextView hUz;
    protected Context mContext;
    protected boolean mIsHost;
    private TbPageContext mPageContext;
    protected View mRootView;
    protected UserData mUserData;

    public n(TbPageContext tbPageContext, boolean z) {
        this.hUB = 0;
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.mIsHost = z;
        this.hUB = com.baidu.adp.lib.util.l.h(this.mContext, d.e.tbds46);
        O(aOM());
        TextView textView = this.hUc;
        if (this.mIsHost) {
        }
        textView.setVisibility(8);
    }

    public View aOM() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(d.h.item_person_polymeric_header_view, (ViewGroup) null);
        }
        return this.mRootView;
    }

    public void O(View view) {
        this.hUf = view.findViewById(d.g.person_info_root);
        this.hUa = (PersonHeadPendantView) view.findViewById(d.g.person_polymeric_header_user_img);
        this.hUa.getHeadView().setGodIconResId(d.f.pic_v_avatar_big);
        this.hUa.getHeadView().setGodIconWidth(d.e.ds40);
        this.hUa.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hUa.setDefalutResid(d.f.pic_mycenter_avatar_def_i);
        this.hUa.setBigVIconResId(d.f.pic_v_avatar_big);
        this.hUa.setBigVDimenSize(d.e.ds40);
        this.hMP = (TbImageView) view.findViewById(d.g.person_polymeric_header_user_vip_icon);
        this.bTY = (TextView) view.findViewById(d.g.person_polymeric_header_user_name_txt);
        this.hUd = (TextView) view.findViewById(d.g.seal_prefix_view);
        this.hUb = (UserIconBox) view.findViewById(d.g.person_polymeric_header_label_box);
        this.hUg = (TextView) view.findViewById(d.g.person_polymeric_header_bar_age_txt);
        this.daO = (TextView) view.findViewById(d.g.person_polymeric_header_ala_id);
        this.hUj = view.findViewById(d.g.divider_for_alaid_and_age);
        this.hUc = (TextView) view.findViewById(d.g.person_polymeric_header_visitor_txt);
        this.hUh = (TextView) view.findViewById(d.g.person_polymeric_header_sign_txt);
        this.hUi = (TextView) view.findViewById(d.g.person_center_header_tdou_txt);
        this.hUl = (TextView) view.findViewById(d.g.textview_get_tdou);
        this.hUm = view.findViewById(d.g.divider_for_age_and_tdou);
        this.hUn = view.findViewById(d.g.divider_for_tdou_and_get_tdou);
        this.hUo = (LinearLayout) view.findViewById(d.g.layout_user_name);
        this.hUp = (TextView) view.findViewById(d.g.person_praise_number);
        this.hUi.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(d.f.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
        this.hUe = (PersonHeaderAttentionView) view.findViewById(d.g.person_center_header_attention_container);
        bSw();
        this.hUq = new m(this.mContext);
        this.hMP.setOnClickListener(this.hUq);
        this.hUb.setOnClickListener(this.hUq);
        this.hUa.setOnClickListener(this.hUq);
        this.hUc.setOnClickListener(this.hUq);
        this.hUd.setOnClickListener(this.hUq);
        this.hUi.setOnClickListener(this.hUq);
        this.hUl.setOnClickListener(this.hUq);
        this.bTY.setOnClickListener(this.hUq);
        this.hUh.setOnClickListener(this.hUq);
        this.hUr = (LinearLayout) view.findViewById(d.g.container_send_gift);
        this.hUs = (ImageView) view.findViewById(d.g.icon_gift);
        this.hUt = (TextView) view.findViewById(d.g.btn_give_gift);
        this.hUr.setOnClickListener(this.hUq);
        this.hUu = (BlueLikeButton) view.findViewById(d.g.btn_like_blue);
        this.ehx = new com.baidu.tbadk.core.view.userLike.c(this.mPageContext, this.hUu);
        this.ehx.setFromType("2");
        if (this.mIsHost) {
            this.hUr.setVisibility(8);
            this.hUu.setVisibility(8);
        }
        this.hUv = (LinearLayout) view.findViewById(d.g.layout_god_auth_forums);
        this.hUv.setVisibility(8);
        this.bFq = view.findViewById(d.g.header_bottom_divider);
        this.hUw = (RelativeLayout) view.findViewById(d.g.layout_gift);
        this.hUw.setOnClickListener(this.hUq);
        this.hUx = view.findViewById(d.g.gift_top_divider);
        this.hUy = (TextView) view.findViewById(d.g.textview_received_gift);
        this.hUz = (TextView) view.findViewById(d.g.textview_received_gift_num);
        this.hTZ = (ImageView) view.findViewById(d.g.img_gift_arrow);
        this.hUA = (TextView) view.findViewById(d.g.btn_edit_person_info);
        this.hUA.setOnClickListener(this.hUq);
        if (!this.mIsHost) {
            this.hUA.setVisibility(8);
        }
    }

    public void e(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null) {
            this.hTX = aVar;
            this.mUserData = aVar.getUserData();
            this.hUq.a(aVar);
            this.hUq.setIsHost(this.mIsHost);
            this.hUa.a(this.mUserData);
            UserVipInfoData userVipInfo = this.mUserData.getUserVipInfo();
            if (this.mUserData.getIsMem() > 0) {
                if (userVipInfo != null) {
                    this.hMP.startLoad(userVipInfo.getVipIconUrl(), 10, false);
                }
                this.hMP.setVisibility(0);
            } else if (this.mIsHost) {
                this.hMP.setImageDrawable(al.getDrawable(d.f.icon_crown_super_non));
                this.hMP.setVisibility(0);
            } else {
                this.hMP.setVisibility(8);
            }
            bQE();
            String name_show = this.mUserData.getName_show();
            if (!TextUtils.isEmpty(name_show)) {
                this.bTY.setText(name_show);
            }
            int i = d.f.icon_mine_boy;
            if (this.mUserData != null) {
                i = this.mUserData.getSex() == 2 ? d.f.icon_mine_girl : d.f.icon_mine_boy;
            }
            this.bTY.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mContext.getResources().getDrawable(i), (Drawable) null);
            this.hUb.a(this.mUserData.getIconInfo(), 9, this.mContext.getResources().getDimensionPixelSize(d.e.tbds42), this.mContext.getResources().getDimensionPixelSize(d.e.tbds42), this.mContext.getResources().getDimensionPixelSize(d.e.tbds10), true);
            if (this.hUe != null) {
                this.hUe.setData(this.mUserData);
            }
            if (this.mUserData != null && this.mUserData.alaUserData != null && this.mUserData.alaUserData.ala_id != 0) {
                this.daO.setVisibility(0);
                this.hUj.setVisibility(0);
                this.daO.setText(String.format(this.mContext.getString(d.j.person_center_ala_id), Long.valueOf(this.mUserData.alaUserData.ala_id)));
            } else {
                this.daO.setVisibility(8);
                this.hUj.setVisibility(8);
            }
            this.hUg.setText(String.format(this.mContext.getString(d.j.person_center_header_bar_age), this.mUserData.getTb_age()));
            if (this.mIsHost) {
                this.hUm.setVisibility(0);
                this.hUn.setVisibility(0);
                this.hUi.setVisibility(0);
                this.hUl.setVisibility(0);
                this.hUi.setText(ap.aF(this.mUserData.getTDouNum()));
            } else {
                this.hUm.setVisibility(8);
                this.hUn.setVisibility(8);
                this.hUi.setVisibility(8);
                this.hUl.setVisibility(8);
            }
            String intro = this.mUserData.getIntro();
            if (StringUtils.isNull(intro)) {
                al.d(this.hUh, d.C0277d.cp_cont_e, 1);
            } else {
                al.d(this.hUh, d.C0277d.cp_cont_j, 1);
            }
            if (StringUtils.isNull(intro)) {
                if (this.mIsHost) {
                    intro = this.mContext.getString(d.j.no_person_sign_host);
                } else {
                    intro = this.mContext.getString(d.j.no_person_sign_guest);
                }
            }
            this.hUh.setText(this.mContext.getString(d.j.person_sign) + intro);
            if (this.hUh.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hUh.getLayoutParams();
                if (!this.mIsHost && this.hUh.getLineCount() >= 3 && this.hUh.getMaxLines() != 2147483646) {
                    int lineHeight = this.hUh.getLineHeight();
                    this.hUh.setHeight((lineHeight / 2) + (lineHeight * 3));
                }
                if (this.hUh.getLineCount() >= 2) {
                    layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(d.e.tbds19);
                } else {
                    layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(d.e.tbds80);
                }
                this.hUh.setLayoutParams(layoutParams);
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(this.mUserData.getUserId()) && ((!TbadkCoreApplication.isLogin() || (!StringUtils.isNull(currentAccount) && !currentAccount.equals(this.mUserData.getUserId()))) && this.mUserData.getLiveStatus() == 1)) {
                if (this.hUk == null) {
                    this.hUk = com.baidu.tbadk.ala.b.UK().n(this.mContext, 7);
                }
                com.baidu.tbadk.ala.a aVar2 = new com.baidu.tbadk.ala.a();
                aVar2.bsJ = this.mUserData.getAlaUserData();
                aVar2.type = 7;
                if ((this.mUserData.getPersonPrivate() != null && this.mUserData.getPersonPrivate().als() == 3) || (this.mUserData.getPersonPrivate().als() == 2 && this.mUserData.getIsFriend() != 1)) {
                    aVar2.bsK = true;
                } else {
                    aVar2.bsK = false;
                }
                if (this.hUk != null) {
                    this.hUk.setTag(aVar2);
                    if (this.hUk.getParent() == null) {
                        this.hUo.addView(this.hUk);
                        TiebaStatic.log(new am("c12541"));
                    }
                }
            } else if (this.hUk != null) {
                this.hUk.setVisibility(8);
            }
            a(aVar.hRS);
            this.mUserData.setIsLike(this.mUserData.getHave_attention() == 1);
            this.ehx.a(this.mUserData);
            bSx();
            bSy();
            this.hUy.setText(this.mIsHost ? d.j.my_received_gift : d.j.he_received_gift);
            if ((this.mUserData.getPersonPrivate() == null || this.mUserData.getPersonPrivate().als() != 3) && this.mUserData.getPersonPrivate().als() == 2 && this.mUserData.getIsFriend() != 1) {
            }
        }
    }

    public void Ax(String str) {
        if (!StringUtils.isNull(str)) {
            this.bTY.setText(str);
        }
    }

    public void Ay(String str) {
        if (!StringUtils.isNull(str)) {
            if (this.mUserData != null) {
                this.mUserData.setPortrait(str);
            }
            this.hUa.nn(str);
        }
    }

    private void a(UserAgreeInfo userAgreeInfo) {
        if (userAgreeInfo == null) {
            this.hUp.setVisibility(8);
            return;
        }
        this.hUp.setVisibility(0);
        String az = ap.az(userAgreeInfo.total_agree_num.longValue());
        Drawable drawable = al.getDrawable(d.f.icon_home_card_like_s);
        drawable.setBounds(0, 0, this.hUB, this.hUB);
        this.hUp.setCompoundDrawables(drawable, null, null, null);
        this.hUp.setText(az);
    }

    public void onChangeSkinType(int i) {
        this.hUf.setBackgroundDrawable(al.getDrawable(d.f.shape_user_info_bg));
        this.hUa.setBackgroundViewDrawable(al.getDrawable(d.f.shape_user_img_bg));
        int i2 = d.f.icon_mine_boy;
        if (this.mUserData != null) {
            i2 = this.mUserData.getSex() == 1 ? d.f.icon_mine_boy : d.f.icon_pop_girl;
        }
        if (this.mUserData != null && this.mUserData.getIsMem() <= 0 && this.hMP != null && this.mIsHost) {
            this.hMP.setImageDrawable(al.getDrawable(d.f.icon_crown_super_non));
        }
        bQE();
        al.d(this.hUd, d.C0277d.cp_link_tip_a, 1);
        this.bTY.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mContext.getResources().getDrawable(i2), (Drawable) null);
        if (this.hUe != null) {
            this.hUe.onChangeSkinType(i);
        }
        al.d(this.hUc, d.C0277d.cp_cont_b, 1);
        al.d(this.hUg, d.C0277d.cp_cont_b, 1);
        al.d(this.daO, d.C0277d.cp_cont_b, 1);
        if (this.mUserData == null || StringUtils.isNull(this.mUserData.getIntro())) {
            al.d(this.hUh, d.C0277d.cp_cont_e, 1);
        } else {
            al.d(this.hUh, d.C0277d.cp_cont_j, 1);
        }
        al.d(this.hUi, d.C0277d.cp_cont_b, 1);
        al.d(this.hUl, d.C0277d.cp_cont_b, 1);
        al.l(this.hUm, d.C0277d.cp_bg_line_b);
        al.l(this.hUj, d.C0277d.cp_bg_line_b);
        al.l(this.hUn, d.C0277d.cp_bg_line_b);
        al.j(this.hUp, d.C0277d.cp_cont_h);
        this.hUi.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(d.f.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
        Drawable T = al.T(i, d.f.icon_home_card_like_s);
        T.setBounds(0, 0, this.hUB, this.hUB);
        this.hUp.setCompoundDrawables(T, null, null, null);
        al.k(this.hUr, d.f.selector_give_gift_bg);
        al.c(this.hUs, d.f.selector_gift_icon);
        al.d(this.hUt, d.C0277d.selector_give_gift_text_color, 1);
        this.hUu.onChangeSkinType(i);
        al.l(this.bFq, d.C0277d.cp_bg_line_e);
        for (int i3 = 0; i3 < this.hUv.getChildCount(); i3++) {
            View childAt = this.hUv.getChildAt(i3);
            if (childAt != null) {
                TextView textView = (TextView) childAt.findViewById(d.g.bar_name);
                textView.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.pic_v_avatar), (Drawable) null, (Drawable) null, (Drawable) null);
                al.j(textView, d.C0277d.cp_cont_b);
                al.j((TextView) childAt.findViewById(d.g.bar_info), d.C0277d.cp_cont_j);
            }
        }
        for (int i4 = 0; i4 < hTY.length; i4++) {
            ((TbImageView) this.mRootView.findViewById(hTY[i4])).setBackgroundDrawable(al.getDrawable(d.f.shape_gift_icon_bg));
        }
        al.l(this.hUx, d.C0277d.cp_bg_line_e);
        al.j(this.hUy, d.C0277d.cp_cont_b);
        al.j(this.hUz, d.C0277d.cp_cont_d);
        al.c(this.hTZ, d.f.icon_arrow_gray_right_n);
        al.k(this.hUA, d.f.selector_like_button_bg);
        al.d(this.hUA, d.C0277d.cp_cont_g, 1);
    }

    public void onDestory() {
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.g gVar) {
        this.hTW = gVar;
        if (this.hUe != null) {
            this.hUe.setOnViewResponseListener(this.hTW);
        }
        this.hUq.setOnViewResponseListener(this.hTW);
    }

    public void AN(String str) {
        this.hUa.nm(str);
    }

    protected void bSw() {
        this.hUa.setHasPendantStyle();
        this.hUa.getHeadView().setIsRound(true);
        this.hUa.getHeadView().setDrawBorder(false);
        this.hUa.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    protected void bQE() {
        if (this.mUserData != null && (this.mUserData.getIsMem() > 0 || this.mUserData.isBigV())) {
            al.d(this.bTY, d.C0277d.cp_cont_h, 1);
        } else {
            al.d(this.bTY, d.C0277d.cp_cont_b, 1);
        }
    }

    private void bSx() {
        if (this.hTX != null && this.hTX.bSr() != null) {
            this.hUv.removeAllViews();
            int godType = this.hTX.bSr().getGodType();
            if (godType == 2 && v.S(this.hTX.bSr().getForumGodList()) > 0) {
                this.hUv.setVisibility(0);
                for (ForumGodDetailInfo forumGodDetailInfo : this.hTX.bSr().getForumGodList()) {
                    if (forumGodDetailInfo != null) {
                        dB(forumGodDetailInfo.forum_name, forumGodDetailInfo.intro);
                    }
                }
                return;
            } else if (godType == 1 && this.hTX.bSr().getgodDetailInfo() != null && !StringUtils.isNull(this.hTX.bSr().getgodDetailInfo().intro)) {
                this.hUv.setVisibility(0);
                dB(this.hTX.bSr().getgodDetailInfo().intro, "");
                return;
            } else {
                return;
            }
        }
        this.hUv.setVisibility(8);
    }

    private void dB(String str, String str2) {
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
        this.hUv.addView(inflate, layoutParams);
    }

    private void bSy() {
        int i;
        for (int i2 = 0; i2 < hTY.length; i2++) {
            ((TbImageView) this.mRootView.findViewById(hTY[i2])).setVisibility(8);
        }
        if (this.hTX == null || this.hTX.bSq() == null || v.S(this.hTX.bSq().hSg) <= 0) {
            i = 0;
        } else {
            int i3 = this.hTX.bSq().giftNum;
            List<com.baidu.adp.widget.ListView.m> list = this.hTX.bSq().hSg;
            for (int i4 = 0; i4 < list.size() && i4 < hTY.length; i4++) {
                if (list.get(i4) instanceof com.baidu.tieba.personPolymeric.c.o) {
                    TbImageView tbImageView = (TbImageView) this.mRootView.findViewById(hTY[i4]);
                    tbImageView.setVisibility(0);
                    tbImageView.setIsRound(true);
                    tbImageView.startLoad(((com.baidu.tieba.personPolymeric.c.o) list.get(i4)).picUrl, 10, false);
                }
            }
            i = i3;
        }
        this.hUz.setText(String.format(this.mContext.getResources().getString(d.j.gift_num), Integer.valueOf(i)));
    }
}
