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
    private static final int[] itW = {R.id.img_gift_one, R.id.img_gift_two, R.id.img_gift_three};
    private View bNX;
    protected TextView cdg;
    private TextView dnm;
    private com.baidu.tbadk.core.view.userLike.c eCe;
    protected TbImageView imv;
    protected com.baidu.tieba.view.g itU;
    protected com.baidu.tieba.personPolymeric.c.a itV;
    protected ImageView itX;
    protected PersonHeadPendantView itY;
    protected UserIconBox itZ;
    protected TextView iua;
    protected TextView iub;
    public com.baidu.tieba.view.e iuc;
    protected View iud;
    private TextView iue;
    private TextView iuf;
    private TextView iug;
    private View iuh;
    private View iui;
    private TextView iuj;
    private View iuk;
    private View iul;
    private LinearLayout ium;
    private TextView iun;
    private m iuo;
    private View iup;
    private ImageView iuq;
    private TextView iur;
    private BlueLikeButton ius;
    private LinearLayout iut;
    private RelativeLayout iuu;
    private View iuv;
    private TextView iuw;
    private TextView iux;
    private TextView iuy;
    private int iuz;
    protected Context mContext;
    protected boolean mIsHost;
    private TbPageContext mPageContext;
    protected View mRootView;
    protected UserData mUserData;

    public n(TbPageContext tbPageContext, boolean z) {
        this.iuz = 0;
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.mIsHost = z;
        this.iuz = com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.tbds46);
        Q(aWT());
        TextView textView = this.iua;
        if (this.mIsHost) {
        }
        textView.setVisibility(8);
    }

    public View aWT() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.item_person_polymeric_header_view, (ViewGroup) null);
        }
        return this.mRootView;
    }

    public void Q(View view) {
        this.iud = view.findViewById(R.id.person_info_root);
        this.itY = (PersonHeadPendantView) view.findViewById(R.id.person_polymeric_header_user_img);
        this.itY.getHeadView().setGodIconResId(R.drawable.pic_v_avatar_big);
        this.itY.getHeadView().setGodIconWidth(R.dimen.ds40);
        this.itY.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.itY.setDefalutResid(R.drawable.pic_mycenter_avatar_def_i);
        this.itY.setBigVIconResId(R.drawable.pic_v_avatar_big);
        this.itY.setBigVDimenSize(R.dimen.ds40);
        this.imv = (TbImageView) view.findViewById(R.id.person_polymeric_header_user_vip_icon);
        this.cdg = (TextView) view.findViewById(R.id.person_polymeric_header_user_name_txt);
        this.iub = (TextView) view.findViewById(R.id.seal_prefix_view);
        this.itZ = (UserIconBox) view.findViewById(R.id.person_polymeric_header_label_box);
        this.iue = (TextView) view.findViewById(R.id.person_polymeric_header_bar_age_txt);
        this.dnm = (TextView) view.findViewById(R.id.person_polymeric_header_ala_id);
        this.iuh = view.findViewById(R.id.divider_for_alaid_and_age);
        this.iua = (TextView) view.findViewById(R.id.person_polymeric_header_visitor_txt);
        this.iuf = (TextView) view.findViewById(R.id.person_polymeric_header_sign_txt);
        this.iug = (TextView) view.findViewById(R.id.person_center_header_tdou_txt);
        this.iuj = (TextView) view.findViewById(R.id.textview_get_tdou);
        this.iuk = view.findViewById(R.id.divider_for_age_and_tdou);
        this.iul = view.findViewById(R.id.divider_for_tdou_and_get_tdou);
        this.ium = (LinearLayout) view.findViewById(R.id.layout_user_name);
        this.iun = (TextView) view.findViewById(R.id.person_praise_number);
        this.iug.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(R.drawable.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
        this.iuc = (PersonHeaderAttentionView) view.findViewById(R.id.person_center_header_attention_container);
        cdE();
        this.iuo = new m(this.mContext);
        this.imv.setOnClickListener(this.iuo);
        this.itZ.setOnClickListener(this.iuo);
        this.itY.setOnClickListener(this.iuo);
        this.iua.setOnClickListener(this.iuo);
        this.iub.setOnClickListener(this.iuo);
        this.iug.setOnClickListener(this.iuo);
        this.iuj.setOnClickListener(this.iuo);
        this.cdg.setOnClickListener(this.iuo);
        this.iuf.setOnClickListener(this.iuo);
        this.iup = (LinearLayout) view.findViewById(R.id.container_send_gift);
        this.iuq = (ImageView) view.findViewById(R.id.icon_gift);
        this.iur = (TextView) view.findViewById(R.id.btn_give_gift);
        this.iup.setOnClickListener(this.iuo);
        this.ius = (BlueLikeButton) view.findViewById(R.id.btn_like_blue);
        this.eCe = new com.baidu.tbadk.core.view.userLike.c(this.mPageContext, this.ius);
        this.eCe.setFromType("2");
        if (this.mIsHost) {
            this.iup.setVisibility(8);
            this.ius.setVisibility(8);
        }
        this.iut = (LinearLayout) view.findViewById(R.id.layout_god_auth_forums);
        this.iut.setVisibility(8);
        this.bNX = view.findViewById(R.id.header_bottom_divider);
        this.iuu = (RelativeLayout) view.findViewById(R.id.layout_gift);
        this.iuu.setOnClickListener(this.iuo);
        this.iuv = view.findViewById(R.id.gift_top_divider);
        this.iuw = (TextView) view.findViewById(R.id.textview_received_gift);
        this.iux = (TextView) view.findViewById(R.id.textview_received_gift_num);
        this.itX = (ImageView) view.findViewById(R.id.img_gift_arrow);
        this.iuy = (TextView) view.findViewById(R.id.btn_edit_person_info);
        this.iuy.setOnClickListener(this.iuo);
        if (!this.mIsHost) {
            this.iuy.setVisibility(8);
        }
    }

    public void e(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null) {
            this.itV = aVar;
            this.mUserData = aVar.getUserData();
            this.iuo.a(aVar);
            this.iuo.setIsHost(this.mIsHost);
            this.itY.a(this.mUserData);
            UserVipInfoData userVipInfo = this.mUserData.getUserVipInfo();
            if (this.mUserData.getIsMem() > 0) {
                if (userVipInfo != null) {
                    this.imv.startLoad(userVipInfo.getVipIconUrl(), 10, false);
                }
                this.imv.setVisibility(0);
            } else if (this.mIsHost) {
                this.imv.setImageDrawable(am.getDrawable(R.drawable.icon_crown_super_non));
                this.imv.setVisibility(0);
            } else {
                this.imv.setVisibility(8);
            }
            cbH();
            String name_show = this.mUserData.getName_show();
            if (!TextUtils.isEmpty(name_show)) {
                this.cdg.setText(name_show);
            }
            int i = R.drawable.icon_mine_boy;
            if (this.mUserData != null) {
                i = this.mUserData.getSex() == 2 ? R.drawable.icon_mine_girl : R.drawable.icon_mine_boy;
            }
            this.cdg.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mContext.getResources().getDrawable(i), (Drawable) null);
            this.itZ.a(this.mUserData.getIconInfo(), 9, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds42), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds42), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds10), true);
            if (this.iuc != null) {
                this.iuc.setData(this.mUserData);
            }
            if (this.mUserData != null && this.mUserData.alaUserData != null && this.mUserData.alaUserData.ala_id != 0) {
                this.dnm.setVisibility(0);
                this.iuh.setVisibility(0);
                this.dnm.setText(String.format(this.mContext.getString(R.string.person_center_ala_id), Long.valueOf(this.mUserData.alaUserData.ala_id)));
            } else {
                this.dnm.setVisibility(8);
                this.iuh.setVisibility(8);
            }
            this.iue.setText(String.format(this.mContext.getString(R.string.person_center_header_bar_age), this.mUserData.getTb_age()));
            if (this.mIsHost) {
                this.iuk.setVisibility(0);
                this.iul.setVisibility(0);
                this.iug.setVisibility(0);
                this.iuj.setVisibility(0);
                this.iug.setText(aq.aV(this.mUserData.getTDouNum()));
            } else {
                this.iuk.setVisibility(8);
                this.iul.setVisibility(8);
                this.iug.setVisibility(8);
                this.iuj.setVisibility(8);
            }
            String intro = this.mUserData.getIntro();
            if (StringUtils.isNull(intro)) {
                am.f(this.iuf, R.color.cp_cont_e, 1);
            } else {
                am.f(this.iuf, R.color.cp_cont_j, 1);
            }
            if (StringUtils.isNull(intro)) {
                if (this.mIsHost) {
                    intro = this.mContext.getString(R.string.no_person_sign_host);
                } else {
                    intro = this.mContext.getString(R.string.no_person_sign_guest);
                }
            }
            this.iuf.setText(this.mContext.getString(R.string.person_sign) + intro);
            if (this.iuf.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iuf.getLayoutParams();
                if (!this.mIsHost && this.iuf.getLineCount() >= 3 && this.iuf.getMaxLines() != 2147483646) {
                    int lineHeight = this.iuf.getLineHeight();
                    this.iuf.setHeight((lineHeight / 2) + (lineHeight * 3));
                }
                if (this.iuf.getLineCount() >= 2) {
                    layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds19);
                } else {
                    layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds80);
                }
                this.iuf.setLayoutParams(layoutParams);
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(this.mUserData.getUserId()) && ((!TbadkCoreApplication.isLogin() || (!StringUtils.isNull(currentAccount) && !currentAccount.equals(this.mUserData.getUserId()))) && this.mUserData.getLiveStatus() == 1)) {
                if (this.iui == null) {
                    this.iui = com.baidu.tbadk.ala.b.aak().n(this.mContext, 7);
                }
                com.baidu.tbadk.ala.a aVar2 = new com.baidu.tbadk.ala.a();
                aVar2.bAN = this.mUserData.getAlaUserData();
                aVar2.type = 7;
                if ((this.mUserData.getPersonPrivate() != null && this.mUserData.getPersonPrivate().arz() == 3) || (this.mUserData.getPersonPrivate().arz() == 2 && this.mUserData.getIsFriend() != 1)) {
                    aVar2.bAO = true;
                } else {
                    aVar2.bAO = false;
                }
                if (this.iui != null) {
                    this.iui.setTag(aVar2);
                    if (this.iui.getParent() == null) {
                        this.ium.addView(this.iui);
                        TiebaStatic.log(new an("c12541"));
                    }
                }
            } else if (this.iui != null) {
                this.iui.setVisibility(8);
            }
            a(aVar.irR);
            this.mUserData.setIsLike(this.mUserData.getHave_attention() == 1);
            this.eCe.a(this.mUserData);
            cdF();
            cdG();
            this.iuw.setText(this.mIsHost ? R.string.my_received_gift : R.string.he_received_gift);
            if ((this.mUserData.getPersonPrivate() == null || this.mUserData.getPersonPrivate().arz() != 3) && this.mUserData.getPersonPrivate().arz() == 2 && this.mUserData.getIsFriend() != 1) {
            }
        }
    }

    public void CC(String str) {
        if (!StringUtils.isNull(str)) {
            this.cdg.setText(str);
        }
    }

    public void CD(String str) {
        if (!StringUtils.isNull(str)) {
            if (this.mUserData != null) {
                this.mUserData.setPortrait(str);
            }
            this.itY.oO(str);
        }
    }

    private void a(UserAgreeInfo userAgreeInfo) {
        if (userAgreeInfo == null) {
            this.iun.setVisibility(8);
            return;
        }
        this.iun.setVisibility(0);
        String aO = aq.aO(userAgreeInfo.total_agree_num.longValue());
        Drawable drawable = am.getDrawable(R.drawable.icon_home_card_like_s);
        drawable.setBounds(0, 0, this.iuz, this.iuz);
        this.iun.setCompoundDrawables(drawable, null, null, null);
        this.iun.setText(aO);
    }

    public void onChangeSkinType(int i) {
        this.iud.setBackgroundDrawable(am.getDrawable(R.drawable.shape_user_info_bg));
        this.itY.setBackgroundViewDrawable(am.getDrawable(R.drawable.shape_user_img_bg));
        int i2 = R.drawable.icon_mine_boy;
        if (this.mUserData != null) {
            i2 = this.mUserData.getSex() == 1 ? R.drawable.icon_mine_boy : R.drawable.icon_pop_girl;
        }
        if (this.mUserData != null && this.mUserData.getIsMem() <= 0 && this.imv != null && this.mIsHost) {
            this.imv.setImageDrawable(am.getDrawable(R.drawable.icon_crown_super_non));
        }
        cbH();
        am.f(this.iub, R.color.cp_link_tip_a, 1);
        this.cdg.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mContext.getResources().getDrawable(i2), (Drawable) null);
        if (this.iuc != null) {
            this.iuc.onChangeSkinType(i);
        }
        am.f(this.iua, R.color.cp_cont_b, 1);
        am.f(this.iue, R.color.cp_cont_b, 1);
        am.f(this.dnm, R.color.cp_cont_b, 1);
        if (this.mUserData == null || StringUtils.isNull(this.mUserData.getIntro())) {
            am.f(this.iuf, R.color.cp_cont_e, 1);
        } else {
            am.f(this.iuf, R.color.cp_cont_j, 1);
        }
        am.f(this.iug, R.color.cp_cont_b, 1);
        am.f(this.iuj, R.color.cp_cont_b, 1);
        am.l(this.iuk, R.color.cp_bg_line_b);
        am.l(this.iuh, R.color.cp_bg_line_b);
        am.l(this.iul, R.color.cp_bg_line_b);
        am.j(this.iun, R.color.cp_cont_h);
        this.iug.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(R.drawable.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
        Drawable V = am.V(i, R.drawable.icon_home_card_like_s);
        V.setBounds(0, 0, this.iuz, this.iuz);
        this.iun.setCompoundDrawables(V, null, null, null);
        am.k(this.iup, R.drawable.selector_give_gift_bg);
        am.c(this.iuq, (int) R.drawable.selector_gift_icon);
        am.f(this.iur, R.color.selector_give_gift_text_color, 1);
        this.ius.onChangeSkinType(i);
        am.l(this.bNX, R.color.cp_bg_line_e);
        for (int i3 = 0; i3 < this.iut.getChildCount(); i3++) {
            View childAt = this.iut.getChildAt(i3);
            if (childAt != null) {
                TextView textView = (TextView) childAt.findViewById(R.id.bar_name);
                textView.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.pic_v_avatar), (Drawable) null, (Drawable) null, (Drawable) null);
                am.j(textView, R.color.cp_cont_b);
                am.j((TextView) childAt.findViewById(R.id.bar_info), R.color.cp_cont_j);
            }
        }
        for (int i4 = 0; i4 < itW.length; i4++) {
            ((TbImageView) this.mRootView.findViewById(itW[i4])).setBackgroundDrawable(am.getDrawable(R.drawable.shape_gift_icon_bg));
        }
        am.l(this.iuv, R.color.cp_bg_line_e);
        am.j(this.iuw, R.color.cp_cont_b);
        am.j(this.iux, R.color.cp_cont_d);
        am.c(this.itX, (int) R.drawable.icon_arrow_gray_right_n);
        am.k(this.iuy, R.drawable.selector_like_button_bg);
        am.f(this.iuy, R.color.cp_cont_g, 1);
    }

    public void onDestory() {
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.g gVar) {
        this.itU = gVar;
        if (this.iuc != null) {
            this.iuc.setOnViewResponseListener(this.itU);
        }
        this.iuo.setOnViewResponseListener(this.itU);
    }

    public void CU(String str) {
        this.itY.oN(str);
    }

    protected void cdE() {
        this.itY.setHasPendantStyle();
        this.itY.getHeadView().setIsRound(true);
        this.itY.getHeadView().setDrawBorder(false);
        this.itY.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    protected void cbH() {
        if (this.mUserData != null && (this.mUserData.getIsMem() > 0 || this.mUserData.isBigV())) {
            am.f(this.cdg, R.color.cp_cont_h, 1);
        } else {
            am.f(this.cdg, R.color.cp_cont_b, 1);
        }
    }

    private void cdF() {
        if (this.itV != null && this.itV.cdz() != null) {
            this.iut.removeAllViews();
            int godType = this.itV.cdz().getGodType();
            if (godType == 2 && v.Z(this.itV.cdz().getForumGodList()) > 0) {
                this.iut.setVisibility(0);
                for (ForumGodDetailInfo forumGodDetailInfo : this.itV.cdz().getForumGodList()) {
                    if (forumGodDetailInfo != null) {
                        dP(forumGodDetailInfo.forum_name, forumGodDetailInfo.intro);
                    }
                }
                return;
            } else if (godType == 1 && this.itV.cdz().getgodDetailInfo() != null && !StringUtils.isNull(this.itV.cdz().getgodDetailInfo().intro)) {
                this.iut.setVisibility(0);
                dP(this.itV.cdz().getgodDetailInfo().intro, "");
                return;
            } else {
                return;
            }
        }
        this.iut.setVisibility(8);
    }

    private void dP(String str, String str2) {
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
        this.iut.addView(inflate, layoutParams);
    }

    private void cdG() {
        int i;
        for (int i2 = 0; i2 < itW.length; i2++) {
            ((TbImageView) this.mRootView.findViewById(itW[i2])).setVisibility(8);
        }
        if (this.itV == null || this.itV.cdy() == null || v.Z(this.itV.cdy().isf) <= 0) {
            i = 0;
        } else {
            int i3 = this.itV.cdy().giftNum;
            List<com.baidu.adp.widget.ListView.m> list = this.itV.cdy().isf;
            for (int i4 = 0; i4 < list.size() && i4 < itW.length; i4++) {
                if (list.get(i4) instanceof com.baidu.tieba.personPolymeric.c.o) {
                    TbImageView tbImageView = (TbImageView) this.mRootView.findViewById(itW[i4]);
                    tbImageView.setVisibility(0);
                    tbImageView.setIsRound(true);
                    tbImageView.startLoad(((com.baidu.tieba.personPolymeric.c.o) list.get(i4)).picUrl, 10, false);
                }
            }
            i = i3;
        }
        this.iux.setText(String.format(this.mContext.getResources().getString(R.string.gift_num), Integer.valueOf(i)));
    }
}
