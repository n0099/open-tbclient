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
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.UserVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.personCenter.view.PersonHeadPendantView;
import com.baidu.tieba.view.PersonHeaderAttentionView;
import java.util.List;
import tbclient.Profile.ForumGodDetailInfo;
import tbclient.Profile.UserAgreeInfo;
/* loaded from: classes6.dex */
public class n {
    private static final int[] ivV = {R.id.img_gift_one, R.id.img_gift_two, R.id.img_gift_three};
    private View bOw;
    protected TextView cdZ;
    private TextView doZ;
    private com.baidu.tbadk.core.view.userLike.c eDN;
    protected TbImageView iow;
    protected com.baidu.tieba.view.g ivT;
    protected com.baidu.tieba.personPolymeric.c.a ivU;
    protected ImageView ivW;
    protected PersonHeadPendantView ivX;
    protected UserIconBox ivY;
    protected TextView ivZ;
    protected TextView iwa;
    public com.baidu.tieba.view.e iwb;
    protected View iwc;
    private TextView iwd;
    private TextView iwe;
    private TextView iwf;
    private View iwg;
    private View iwh;
    private TextView iwi;
    private View iwj;
    private View iwk;
    private LinearLayout iwl;
    private TextView iwm;
    private m iwn;
    private View iwo;
    private ImageView iwp;
    private TextView iwq;
    private BlueLikeButton iwr;
    private LinearLayout iws;
    private RelativeLayout iwt;
    private View iwu;
    private TextView iwv;
    private TextView iww;
    private TextView iwx;
    private int iwy;
    protected Context mContext;
    protected boolean mIsHost;
    private TbPageContext mPageContext;
    protected View mRootView;
    protected UserData mUserData;

    public n(TbPageContext tbPageContext, boolean z) {
        this.iwy = 0;
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.mIsHost = z;
        this.iwy = com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.tbds46);
        Q(aXx());
        TextView textView = this.ivZ;
        if (this.mIsHost) {
        }
        textView.setVisibility(8);
    }

    public View aXx() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.item_person_polymeric_header_view, (ViewGroup) null);
        }
        return this.mRootView;
    }

    public void Q(View view) {
        this.iwc = view.findViewById(R.id.person_info_root);
        this.ivX = (PersonHeadPendantView) view.findViewById(R.id.person_polymeric_header_user_img);
        this.ivX.getHeadView().setGodIconResId(R.drawable.pic_v_avatar_big);
        this.ivX.getHeadView().setGodIconWidth(R.dimen.ds40);
        this.ivX.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ivX.setDefalutResid(R.drawable.pic_mycenter_avatar_def_i);
        this.ivX.setBigVIconResId(R.drawable.pic_v_avatar_big);
        this.ivX.setBigVDimenSize(R.dimen.ds40);
        this.iow = (TbImageView) view.findViewById(R.id.person_polymeric_header_user_vip_icon);
        this.cdZ = (TextView) view.findViewById(R.id.person_polymeric_header_user_name_txt);
        this.iwa = (TextView) view.findViewById(R.id.seal_prefix_view);
        this.ivY = (UserIconBox) view.findViewById(R.id.person_polymeric_header_label_box);
        this.iwd = (TextView) view.findViewById(R.id.person_polymeric_header_bar_age_txt);
        this.doZ = (TextView) view.findViewById(R.id.person_polymeric_header_ala_id);
        this.iwg = view.findViewById(R.id.divider_for_alaid_and_age);
        this.ivZ = (TextView) view.findViewById(R.id.person_polymeric_header_visitor_txt);
        this.iwe = (TextView) view.findViewById(R.id.person_polymeric_header_sign_txt);
        this.iwf = (TextView) view.findViewById(R.id.person_center_header_tdou_txt);
        this.iwi = (TextView) view.findViewById(R.id.textview_get_tdou);
        this.iwj = view.findViewById(R.id.divider_for_age_and_tdou);
        this.iwk = view.findViewById(R.id.divider_for_tdou_and_get_tdou);
        this.iwl = (LinearLayout) view.findViewById(R.id.layout_user_name);
        this.iwm = (TextView) view.findViewById(R.id.person_praise_number);
        this.iwf.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(R.drawable.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
        this.iwb = (PersonHeaderAttentionView) view.findViewById(R.id.person_center_header_attention_container);
        ces();
        this.iwn = new m(this.mContext);
        this.iow.setOnClickListener(this.iwn);
        this.ivY.setOnClickListener(this.iwn);
        this.ivX.setOnClickListener(this.iwn);
        this.ivZ.setOnClickListener(this.iwn);
        this.iwa.setOnClickListener(this.iwn);
        this.iwf.setOnClickListener(this.iwn);
        this.iwi.setOnClickListener(this.iwn);
        this.cdZ.setOnClickListener(this.iwn);
        this.iwe.setOnClickListener(this.iwn);
        this.iwo = (LinearLayout) view.findViewById(R.id.container_send_gift);
        this.iwp = (ImageView) view.findViewById(R.id.icon_gift);
        this.iwq = (TextView) view.findViewById(R.id.btn_give_gift);
        this.iwo.setOnClickListener(this.iwn);
        this.iwr = (BlueLikeButton) view.findViewById(R.id.btn_like_blue);
        this.eDN = new com.baidu.tbadk.core.view.userLike.c(this.mPageContext, this.iwr);
        this.eDN.setFromType("2");
        if (this.mIsHost) {
            this.iwo.setVisibility(8);
            this.iwr.setVisibility(8);
        }
        this.iws = (LinearLayout) view.findViewById(R.id.layout_god_auth_forums);
        this.iws.setVisibility(8);
        this.bOw = view.findViewById(R.id.header_bottom_divider);
        this.iwt = (RelativeLayout) view.findViewById(R.id.layout_gift);
        this.iwt.setOnClickListener(this.iwn);
        this.iwu = view.findViewById(R.id.gift_top_divider);
        this.iwv = (TextView) view.findViewById(R.id.textview_received_gift);
        this.iww = (TextView) view.findViewById(R.id.textview_received_gift_num);
        this.ivW = (ImageView) view.findViewById(R.id.img_gift_arrow);
        this.iwx = (TextView) view.findViewById(R.id.btn_edit_person_info);
        this.iwx.setOnClickListener(this.iwn);
        if (!this.mIsHost) {
            this.iwx.setVisibility(8);
        }
    }

    public void e(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null) {
            this.ivU = aVar;
            this.mUserData = aVar.getUserData();
            this.iwn.a(aVar);
            this.iwn.setIsHost(this.mIsHost);
            this.ivX.a(this.mUserData);
            UserVipInfoData userVipInfo = this.mUserData.getUserVipInfo();
            if (this.mUserData.getIsMem() > 0) {
                if (userVipInfo != null) {
                    this.iow.startLoad(userVipInfo.getVipIconUrl(), 10, false);
                }
                this.iow.setVisibility(0);
            } else if (this.mIsHost) {
                this.iow.setImageDrawable(am.getDrawable(R.drawable.icon_crown_super_non));
                this.iow.setVisibility(0);
            } else {
                this.iow.setVisibility(8);
            }
            ccv();
            String name_show = this.mUserData.getName_show();
            if (!TextUtils.isEmpty(name_show)) {
                this.cdZ.setText(name_show);
            }
            int i = R.drawable.icon_mask_boy_n_svg;
            if (this.mUserData != null) {
                i = this.mUserData.getSex() == 2 ? R.drawable.icon_mask_girl_n_svg : R.drawable.icon_mask_boy_n_svg;
            }
            this.cdZ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.ajv().a(i, null), (Drawable) null);
            this.ivY.a(this.mUserData.getIconInfo(), 9, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds42), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds42), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds10), true);
            if (this.iwb != null) {
                this.iwb.setData(this.mUserData);
            }
            if (this.mUserData != null && this.mUserData.alaUserData != null && this.mUserData.alaUserData.ala_id != 0) {
                this.doZ.setVisibility(0);
                this.iwg.setVisibility(0);
                this.doZ.setText(String.format(this.mContext.getString(R.string.person_center_ala_id), Long.valueOf(this.mUserData.alaUserData.ala_id)));
            } else {
                this.doZ.setVisibility(8);
                this.iwg.setVisibility(8);
            }
            this.iwd.setText(String.format(this.mContext.getString(R.string.person_center_header_bar_age), this.mUserData.getTb_age()));
            if (this.mIsHost) {
                this.iwj.setVisibility(0);
                this.iwk.setVisibility(0);
                this.iwf.setVisibility(0);
                this.iwi.setVisibility(0);
                this.iwf.setText(aq.aV(this.mUserData.getTDouNum()));
            } else {
                this.iwj.setVisibility(8);
                this.iwk.setVisibility(8);
                this.iwf.setVisibility(8);
                this.iwi.setVisibility(8);
            }
            String intro = this.mUserData.getIntro();
            if (StringUtils.isNull(intro)) {
                am.f(this.iwe, R.color.cp_cont_e, 1);
            } else {
                am.f(this.iwe, R.color.cp_cont_j, 1);
            }
            if (StringUtils.isNull(intro)) {
                if (this.mIsHost) {
                    intro = this.mContext.getString(R.string.no_person_sign_host);
                } else {
                    intro = this.mContext.getString(R.string.no_person_sign_guest);
                }
            }
            this.iwe.setText(this.mContext.getString(R.string.person_sign) + intro);
            if (this.iwe.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iwe.getLayoutParams();
                if (!this.mIsHost && this.iwe.getLineCount() >= 3 && this.iwe.getMaxLines() != 2147483646) {
                    int lineHeight = this.iwe.getLineHeight();
                    this.iwe.setHeight((lineHeight / 2) + (lineHeight * 3));
                }
                if (this.iwe.getLineCount() >= 2) {
                    layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds19);
                } else {
                    layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds80);
                }
                this.iwe.setLayoutParams(layoutParams);
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(this.mUserData.getUserId()) && ((!TbadkCoreApplication.isLogin() || (!StringUtils.isNull(currentAccount) && !currentAccount.equals(this.mUserData.getUserId()))) && this.mUserData.getLiveStatus() == 1)) {
                if (this.iwh == null) {
                    this.iwh = com.baidu.tbadk.ala.b.aao().n(this.mContext, 7);
                }
                com.baidu.tbadk.ala.a aVar2 = new com.baidu.tbadk.ala.a();
                aVar2.bBl = this.mUserData.getAlaUserData();
                aVar2.type = 7;
                if ((this.mUserData.getPersonPrivate() != null && this.mUserData.getPersonPrivate().arL() == 3) || (this.mUserData.getPersonPrivate().arL() == 2 && this.mUserData.getIsFriend() != 1)) {
                    aVar2.bBm = true;
                } else {
                    aVar2.bBm = false;
                }
                if (this.iwh != null) {
                    this.iwh.setTag(aVar2);
                    if (this.iwh.getParent() == null) {
                        this.iwl.addView(this.iwh);
                        TiebaStatic.log(new an("c12541"));
                    }
                }
            } else if (this.iwh != null) {
                this.iwh.setVisibility(8);
            }
            a(aVar.itQ);
            this.mUserData.setIsLike(this.mUserData.getHave_attention() == 1);
            this.eDN.a(this.mUserData);
            cet();
            ceu();
            this.iwv.setText(this.mIsHost ? R.string.my_received_gift : R.string.he_received_gift);
            if ((this.mUserData.getPersonPrivate() == null || this.mUserData.getPersonPrivate().arL() != 3) && this.mUserData.getPersonPrivate().arL() == 2 && this.mUserData.getIsFriend() != 1) {
            }
        }
    }

    public void Db(String str) {
        if (!StringUtils.isNull(str)) {
            this.cdZ.setText(str);
        }
    }

    public void Dc(String str) {
        if (!StringUtils.isNull(str)) {
            if (this.mUserData != null) {
                this.mUserData.setPortrait(str);
            }
            this.ivX.oW(str);
        }
    }

    private void a(UserAgreeInfo userAgreeInfo) {
        if (userAgreeInfo == null) {
            this.iwm.setVisibility(8);
            return;
        }
        this.iwm.setVisibility(0);
        String aO = aq.aO(userAgreeInfo.total_agree_num.longValue());
        Drawable drawable = am.getDrawable(R.drawable.icon_home_card_like_s);
        drawable.setBounds(0, 0, this.iwy, this.iwy);
        this.iwm.setCompoundDrawables(drawable, null, null, null);
        this.iwm.setText(aO);
    }

    public void onChangeSkinType(int i) {
        this.iwc.setBackgroundDrawable(am.getDrawable(R.drawable.shape_user_info_bg));
        this.ivX.setBackgroundViewDrawable(am.getDrawable(R.drawable.shape_user_img_bg));
        int i2 = R.drawable.icon_mask_boy_n_svg;
        if (this.mUserData != null) {
            i2 = this.mUserData.getSex() == 1 ? R.drawable.icon_mask_boy_n_svg : R.drawable.icon_mask_girl_n_svg;
        }
        if (this.mUserData != null && this.mUserData.getIsMem() <= 0 && this.iow != null && this.mIsHost) {
            this.iow.setImageDrawable(am.getDrawable(R.drawable.icon_crown_super_non));
        }
        ccv();
        am.f(this.iwa, R.color.cp_link_tip_a, 1);
        this.cdZ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.ajv().a(i2, null), (Drawable) null);
        if (this.iwb != null) {
            this.iwb.onChangeSkinType(i);
        }
        am.f(this.ivZ, R.color.cp_cont_b, 1);
        am.f(this.iwd, R.color.cp_cont_b, 1);
        am.f(this.doZ, R.color.cp_cont_b, 1);
        if (this.mUserData == null || StringUtils.isNull(this.mUserData.getIntro())) {
            am.f(this.iwe, R.color.cp_cont_e, 1);
        } else {
            am.f(this.iwe, R.color.cp_cont_j, 1);
        }
        am.f(this.iwf, R.color.cp_cont_b, 1);
        am.f(this.iwi, R.color.cp_cont_b, 1);
        am.l(this.iwj, R.color.cp_bg_line_c);
        am.l(this.iwg, R.color.cp_bg_line_c);
        am.l(this.iwk, R.color.cp_bg_line_c);
        am.j(this.iwm, R.color.cp_cont_h);
        this.iwf.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(R.drawable.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
        Drawable V = am.V(i, R.drawable.icon_home_card_like_s);
        V.setBounds(0, 0, this.iwy, this.iwy);
        this.iwm.setCompoundDrawables(V, null, null, null);
        am.k(this.iwo, R.drawable.selector_give_gift_bg);
        am.c(this.iwp, (int) R.drawable.selector_gift_icon);
        am.f(this.iwq, R.color.selector_give_gift_text_color, 1);
        this.iwr.onChangeSkinType(i);
        am.l(this.bOw, R.color.cp_bg_line_c);
        for (int i3 = 0; i3 < this.iws.getChildCount(); i3++) {
            View childAt = this.iws.getChildAt(i3);
            if (childAt != null) {
                TextView textView = (TextView) childAt.findViewById(R.id.bar_name);
                textView.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.pic_v_avatar), (Drawable) null, (Drawable) null, (Drawable) null);
                am.j(textView, R.color.cp_cont_b);
                am.j((TextView) childAt.findViewById(R.id.bar_info), R.color.cp_cont_j);
            }
        }
        for (int i4 = 0; i4 < ivV.length; i4++) {
            ((TbImageView) this.mRootView.findViewById(ivV[i4])).setBackgroundDrawable(am.getDrawable(R.drawable.shape_gift_icon_bg));
        }
        am.l(this.iwu, R.color.cp_bg_line_c);
        am.j(this.iwv, R.color.cp_cont_b);
        am.j(this.iww, R.color.cp_cont_d);
        SvgManager.ajv().a(this.ivW, R.drawable.icon_pure_list_arrow16_right_tint_n_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        am.k(this.iwx, R.drawable.selector_like_button_bg);
        am.f(this.iwx, R.color.cp_cont_g, 1);
    }

    public void onDestory() {
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.g gVar) {
        this.ivT = gVar;
        if (this.iwb != null) {
            this.iwb.setOnViewResponseListener(this.ivT);
        }
        this.iwn.setOnViewResponseListener(this.ivT);
    }

    public void Dt(String str) {
        this.ivX.oV(str);
    }

    protected void ces() {
        this.ivX.setHasPendantStyle();
        this.ivX.getHeadView().setIsRound(true);
        this.ivX.getHeadView().setDrawBorder(false);
        this.ivX.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    protected void ccv() {
        if (this.mUserData != null && (this.mUserData.getIsMem() > 0 || this.mUserData.isBigV())) {
            am.f(this.cdZ, R.color.cp_cont_h, 1);
        } else {
            am.f(this.cdZ, R.color.cp_cont_b, 1);
        }
    }

    private void cet() {
        if (this.ivU != null && this.ivU.cen() != null) {
            this.iws.removeAllViews();
            int godType = this.ivU.cen().getGodType();
            if (godType == 2 && v.Z(this.ivU.cen().getForumGodList()) > 0) {
                this.iws.setVisibility(0);
                for (ForumGodDetailInfo forumGodDetailInfo : this.ivU.cen().getForumGodList()) {
                    if (forumGodDetailInfo != null) {
                        dR(forumGodDetailInfo.forum_name, forumGodDetailInfo.intro);
                    }
                }
                return;
            } else if (godType == 1 && this.ivU.cen().getgodDetailInfo() != null && !StringUtils.isNull(this.ivU.cen().getgodDetailInfo().intro)) {
                this.iws.setVisibility(0);
                dR(this.ivU.cen().getgodDetailInfo().intro, "");
                return;
            } else {
                return;
            }
        }
        this.iws.setVisibility(8);
    }

    private void dR(String str, String str2) {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.layout_god_auth_info, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.bar_name);
        textView.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.pic_v_avatar), (Drawable) null, (Drawable) null, (Drawable) null);
        am.j(textView, R.color.cp_cont_b);
        textView.setText(str);
        TextView textView2 = (TextView) inflate.findViewById(R.id.bar_info);
        am.j(textView2, R.color.cp_cont_j);
        textView2.setText(str2);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds14);
        this.iws.addView(inflate, layoutParams);
    }

    private void ceu() {
        int i;
        for (int i2 = 0; i2 < ivV.length; i2++) {
            ((TbImageView) this.mRootView.findViewById(ivV[i2])).setVisibility(8);
        }
        if (this.ivU == null || this.ivU.cem() == null || v.Z(this.ivU.cem().iue) <= 0) {
            i = 0;
        } else {
            int i3 = this.ivU.cem().giftNum;
            List<com.baidu.adp.widget.ListView.m> list = this.ivU.cem().iue;
            for (int i4 = 0; i4 < list.size() && i4 < ivV.length; i4++) {
                if (list.get(i4) instanceof com.baidu.tieba.personPolymeric.c.o) {
                    TbImageView tbImageView = (TbImageView) this.mRootView.findViewById(ivV[i4]);
                    tbImageView.setVisibility(0);
                    tbImageView.setIsRound(true);
                    tbImageView.startLoad(((com.baidu.tieba.personPolymeric.c.o) list.get(i4)).picUrl, 10, false);
                }
            }
            i = i3;
        }
        this.iww.setText(String.format(this.mContext.getResources().getString(R.string.gift_num), Integer.valueOf(i)));
    }
}
