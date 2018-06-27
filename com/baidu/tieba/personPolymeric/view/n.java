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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.UserVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.personCenter.view.PersonHeadPendantView;
import com.baidu.tieba.view.PersonHeaderAttentionView;
import java.util.List;
import org.apache.http.HttpHost;
import tbclient.Profile.ForumGodDetailInfo;
import tbclient.Profile.UserAgreeInfo;
/* loaded from: classes3.dex */
public class n {
    private static final int[] gcF = {d.g.img_gift_one, d.g.img_gift_two, d.g.img_gift_three};
    protected TextView azm;
    private TextView bus;
    private com.baidu.tbadk.core.view.userLike.c cvR;
    private View dRm;
    protected TbImageView fVp;
    protected com.baidu.tieba.view.g gcD;
    protected com.baidu.tieba.personPolymeric.c.a gcE;
    protected ImageView gcG;
    protected PersonHeadPendantView gcH;
    protected UserIconBox gcI;
    protected TextView gcJ;
    protected TextView gcK;
    public com.baidu.tieba.view.e gcL;
    protected View gcM;
    private TextView gcN;
    private TextView gcO;
    private TextView gcP;
    private View gcQ;
    private View gcR;
    private TextView gcS;
    private View gcT;
    private View gcU;
    private LinearLayout gcV;
    private TextView gcW;
    private m gcX;
    private View gcY;
    private ImageView gcZ;
    private TextView gda;
    private BlueLikeButton gdb;
    private LinearLayout gdc;
    private RelativeLayout gdd;
    private View gde;
    private TextView gdf;
    private TextView gdg;
    private TextView gdh;
    private int gdi;
    protected Context mContext;
    protected boolean mIsHost;
    private TbPageContext mPageContext;
    protected View mRootView;
    protected UserData mUserData;

    public n(TbPageContext tbPageContext, boolean z) {
        this.gdi = 0;
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.mIsHost = z;
        this.gdi = com.baidu.adp.lib.util.l.e(this.mContext, d.e.tbds46);
        W(agG());
        TextView textView = this.gcJ;
        if (this.mIsHost) {
        }
        textView.setVisibility(8);
    }

    public View agG() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(d.i.item_person_polymeric_header_view, (ViewGroup) null);
        }
        return this.mRootView;
    }

    public void W(View view) {
        this.gcM = view.findViewById(d.g.person_info_root);
        this.gcH = (PersonHeadPendantView) view.findViewById(d.g.person_polymeric_header_user_img);
        this.gcH.getHeadView().setCustomBigViewIconId(d.f.pic_v_avatar_big);
        this.gcH.getHeadView().setIconWidth(this.mContext.getResources().getDimensionPixelSize(d.e.ds40));
        this.gcH.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fVp = (TbImageView) view.findViewById(d.g.person_polymeric_header_user_vip_icon);
        this.azm = (TextView) view.findViewById(d.g.person_polymeric_header_user_name_txt);
        this.gcK = (TextView) view.findViewById(d.g.seal_prefix_view);
        this.gcI = (UserIconBox) view.findViewById(d.g.person_polymeric_header_label_box);
        this.gcN = (TextView) view.findViewById(d.g.person_polymeric_header_bar_age_txt);
        this.bus = (TextView) view.findViewById(d.g.person_polymeric_header_ala_id);
        this.gcQ = view.findViewById(d.g.divider_for_alaid_and_age);
        this.gcJ = (TextView) view.findViewById(d.g.person_polymeric_header_visitor_txt);
        this.gcO = (TextView) view.findViewById(d.g.person_polymeric_header_sign_txt);
        this.gcP = (TextView) view.findViewById(d.g.person_center_header_tdou_txt);
        this.gcS = (TextView) view.findViewById(d.g.textview_get_tdou);
        this.gcT = view.findViewById(d.g.divider_for_age_and_tdou);
        this.gcU = view.findViewById(d.g.divider_for_tdou_and_get_tdou);
        this.gcV = (LinearLayout) view.findViewById(d.g.layout_user_name);
        this.gcW = (TextView) view.findViewById(d.g.person_praise_number);
        this.gcP.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(d.f.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
        this.gcL = (PersonHeaderAttentionView) view.findViewById(d.g.person_center_header_attention_container);
        bln();
        this.gcX = new m(this.mContext);
        this.fVp.setOnClickListener(this.gcX);
        this.gcI.setOnClickListener(this.gcX);
        this.gcH.setOnClickListener(this.gcX);
        this.gcJ.setOnClickListener(this.gcX);
        this.gcK.setOnClickListener(this.gcX);
        this.gcP.setOnClickListener(this.gcX);
        this.gcS.setOnClickListener(this.gcX);
        this.azm.setOnClickListener(this.gcX);
        this.gcO.setOnClickListener(this.gcX);
        this.gcY = (LinearLayout) view.findViewById(d.g.container_send_gift);
        this.gcZ = (ImageView) view.findViewById(d.g.icon_gift);
        this.gda = (TextView) view.findViewById(d.g.btn_give_gift);
        this.gcY.setOnClickListener(this.gcX);
        this.gdb = (BlueLikeButton) view.findViewById(d.g.btn_like_blue);
        this.cvR = new com.baidu.tbadk.core.view.userLike.c(this.mPageContext, this.gdb);
        this.cvR.setFromType("2");
        if (this.mIsHost) {
            this.gcY.setVisibility(8);
            this.gdb.setVisibility(8);
        }
        this.gdc = (LinearLayout) view.findViewById(d.g.layout_god_auth_forums);
        this.gdc.setVisibility(8);
        this.dRm = view.findViewById(d.g.header_bottom_divider);
        this.gdd = (RelativeLayout) view.findViewById(d.g.layout_gift);
        this.gdd.setOnClickListener(this.gcX);
        this.gde = view.findViewById(d.g.gift_top_divider);
        this.gdf = (TextView) view.findViewById(d.g.textview_received_gift);
        this.gdg = (TextView) view.findViewById(d.g.textview_received_gift_num);
        this.gcG = (ImageView) view.findViewById(d.g.img_gift_arrow);
        this.gdh = (TextView) view.findViewById(d.g.btn_edit_person_info);
        this.gdh.setOnClickListener(this.gcX);
        if (!this.mIsHost) {
            this.gdh.setVisibility(8);
        }
    }

    public void e(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null) {
            this.gcE = aVar;
            this.mUserData = aVar.getUserData();
            this.gcX.a(aVar);
            this.gcX.setIsHost(this.mIsHost);
            String portrait = this.mUserData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                if (portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    this.gcH.getHeadView().startLoad(portrait, 10, false);
                } else {
                    String ex = com.baidu.tbadk.core.util.p.ex(portrait);
                    this.gcH.getHeadView().setUrl(ex);
                    this.gcH.getHeadView().startLoad(ex, 25, false);
                }
            } else {
                this.gcH.getHeadView().startLoad(String.valueOf(d.f.pic_mycenter_avatar_def_i), 24, false);
            }
            com.baidu.tbadk.data.i pendantData = this.mUserData.getPendantData();
            if (pendantData != null) {
                this.gcH.fn(pendantData.uh());
            }
            if (this.gcH.At()) {
                this.gcH.getHeadView().setShowV(false);
            } else if (this.mUserData.isBigV() || !StringUtils.isNull(this.mUserData.getUserTbVipInfoData().getvipV_url())) {
                this.gcH.getHeadView().setShowV(true);
            } else {
                this.gcH.getHeadView().setShowV(false);
            }
            UserVipInfoData userVipInfo = this.mUserData.getUserVipInfo();
            if (this.mUserData.getIsMem() > 0) {
                if (userVipInfo != null) {
                    this.fVp.startLoad(userVipInfo.getVipIconUrl(), 10, false);
                }
                this.fVp.setVisibility(0);
            } else if (this.mIsHost) {
                this.fVp.setImageDrawable(am.getDrawable(d.f.icon_crown_super_non));
                this.fVp.setVisibility(0);
            } else {
                this.fVp.setVisibility(8);
            }
            bjv();
            String name_show = this.mUserData.getName_show();
            if (!TextUtils.isEmpty(name_show)) {
                this.azm.setText(name_show);
            }
            int i = d.f.icon_mine_boy;
            if (this.mUserData != null) {
                i = this.mUserData.getSex() == 2 ? d.f.icon_mine_girl : d.f.icon_mine_boy;
            }
            this.azm.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mContext.getResources().getDrawable(i), (Drawable) null);
            this.gcI.a(this.mUserData.getIconInfo(), 9, this.mContext.getResources().getDimensionPixelSize(d.e.tbds42), this.mContext.getResources().getDimensionPixelSize(d.e.tbds42), this.mContext.getResources().getDimensionPixelSize(d.e.tbds10), true);
            if (this.gcL != null) {
                this.gcL.setData(this.mUserData);
            }
            if (this.mUserData != null && this.mUserData.alaUserData != null && this.mUserData.alaUserData.ala_id != 0) {
                this.bus.setVisibility(0);
                this.gcQ.setVisibility(0);
                this.bus.setText(String.format(this.mContext.getString(d.k.person_center_ala_id), Long.valueOf(this.mUserData.alaUserData.ala_id)));
            } else {
                this.bus.setVisibility(8);
                this.gcQ.setVisibility(8);
            }
            this.gcN.setText(String.format(this.mContext.getString(d.k.person_center_header_bar_age), this.mUserData.getTb_age()));
            if (this.mIsHost) {
                this.gcT.setVisibility(0);
                this.gcU.setVisibility(0);
                this.gcP.setVisibility(0);
                this.gcS.setVisibility(0);
                this.gcP.setText(ap.L(this.mUserData.getTDouNum()));
            } else {
                this.gcT.setVisibility(8);
                this.gcU.setVisibility(8);
                this.gcP.setVisibility(8);
                this.gcS.setVisibility(8);
            }
            String intro = this.mUserData.getIntro();
            if (StringUtils.isNull(intro)) {
                am.c(this.gcO, d.C0142d.cp_cont_e, 1);
            } else {
                am.c(this.gcO, d.C0142d.cp_cont_j, 1);
            }
            if (StringUtils.isNull(intro)) {
                if (this.mIsHost) {
                    intro = this.mContext.getString(d.k.no_person_sign_host);
                } else {
                    intro = this.mContext.getString(d.k.no_person_sign_guest);
                }
            }
            this.gcO.setText(this.mContext.getString(d.k.person_sign) + intro);
            if (this.gcO.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gcO.getLayoutParams();
                if (!this.mIsHost && this.gcO.getLineCount() >= 3 && this.gcO.getMaxLines() != 2147483646) {
                    int lineHeight = this.gcO.getLineHeight();
                    this.gcO.setHeight((lineHeight / 2) + (lineHeight * 3));
                }
                if (this.gcO.getLineCount() >= 2) {
                    layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(d.e.tbds19);
                } else {
                    layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(d.e.tbds80);
                }
                this.gcO.setLayoutParams(layoutParams);
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(this.mUserData.getUserId()) && ((!TbadkCoreApplication.isLogin() || (!StringUtils.isNull(currentAccount) && !currentAccount.equals(this.mUserData.getUserId()))) && this.mUserData.getLiveStatus() == 1)) {
                if (this.gcR == null) {
                    this.gcR = com.baidu.tbadk.ala.b.rM().f(this.mContext, 7);
                }
                com.baidu.tbadk.ala.a aVar2 = new com.baidu.tbadk.ala.a();
                aVar2.aan = this.mUserData.getAlaUserData();
                aVar2.type = 7;
                if ((this.mUserData.getPersonPrivate() != null && this.mUserData.getPersonPrivate().Ha() == 3) || (this.mUserData.getPersonPrivate().Ha() == 2 && this.mUserData.getIsFriend() != 1)) {
                    aVar2.aao = true;
                } else {
                    aVar2.aao = false;
                }
                if (this.gcR != null) {
                    this.gcR.setTag(aVar2);
                    if (this.gcR.getParent() == null) {
                        this.gcV.addView(this.gcR);
                        TiebaStatic.log(new an("c12541"));
                    }
                }
            } else if (this.gcR != null) {
                this.gcR.setVisibility(8);
            }
            a(aVar.gay);
            this.mUserData.setIsLike(this.mUserData.getHave_attention() == 1);
            this.cvR.a(this.mUserData);
            blo();
            blp();
            this.gdf.setText(this.mIsHost ? d.k.my_received_gift : d.k.he_received_gift);
            if ((this.mUserData.getPersonPrivate() == null || this.mUserData.getPersonPrivate().Ha() != 3) && this.mUserData.getPersonPrivate().Ha() == 2 && this.mUserData.getIsFriend() != 1) {
            }
        }
    }

    private void a(UserAgreeInfo userAgreeInfo) {
        if (userAgreeInfo == null) {
            this.gcW.setVisibility(8);
            return;
        }
        this.gcW.setVisibility(0);
        String F = ap.F(userAgreeInfo.total_agree_num.longValue());
        Drawable drawable = am.getDrawable(d.f.icon_home_card_like_s);
        drawable.setBounds(0, 0, this.gdi, this.gdi);
        this.gcW.setCompoundDrawables(drawable, null, null, null);
        this.gcW.setText(F);
    }

    public void onChangeSkinType(int i) {
        this.gcM.setBackgroundDrawable(am.getDrawable(d.f.shape_user_info_bg));
        this.gcH.setBackgroundViewDrawable(am.getDrawable(d.f.shape_user_img_bg));
        int i2 = d.f.icon_mine_boy;
        if (this.mUserData != null) {
            i2 = this.mUserData.getSex() == 1 ? d.f.icon_mine_boy : d.f.icon_pop_girl;
        }
        if (this.mUserData != null && this.mUserData.getIsMem() <= 0 && this.fVp != null && this.mIsHost) {
            this.fVp.setImageDrawable(am.getDrawable(d.f.icon_crown_super_non));
        }
        bjv();
        am.c(this.gcK, d.C0142d.cp_link_tip_a, 1);
        this.azm.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mContext.getResources().getDrawable(i2), (Drawable) null);
        if (this.gcL != null) {
            this.gcL.onChangeSkinType(i);
        }
        am.c(this.gcJ, d.C0142d.cp_cont_b, 1);
        am.c(this.gcN, d.C0142d.cp_cont_b, 1);
        am.c(this.bus, d.C0142d.cp_cont_b, 1);
        if (this.mUserData == null || StringUtils.isNull(this.mUserData.getIntro())) {
            am.c(this.gcO, d.C0142d.cp_cont_e, 1);
        } else {
            am.c(this.gcO, d.C0142d.cp_cont_j, 1);
        }
        am.c(this.gcP, d.C0142d.cp_cont_b, 1);
        am.c(this.gcS, d.C0142d.cp_cont_b, 1);
        am.j(this.gcT, d.C0142d.cp_bg_line_b);
        am.j(this.gcQ, d.C0142d.cp_bg_line_b);
        am.j(this.gcU, d.C0142d.cp_bg_line_b);
        am.h(this.gcW, d.C0142d.cp_cont_h);
        this.gcP.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(d.f.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
        Drawable v = am.v(i, d.f.icon_home_card_like_s);
        v.setBounds(0, 0, this.gdi, this.gdi);
        this.gcW.setCompoundDrawables(v, null, null, null);
        am.i(this.gcY, d.f.selector_give_gift_bg);
        am.c(this.gcZ, d.f.selector_gift_icon);
        am.c(this.gda, d.C0142d.selector_give_gift_text_color, 1);
        this.gdb.onChangeSkinType(i);
        am.j(this.dRm, d.C0142d.cp_bg_line_e);
        for (int i3 = 0; i3 < this.gdc.getChildCount(); i3++) {
            View childAt = this.gdc.getChildAt(i3);
            if (childAt != null) {
                TextView textView = (TextView) childAt.findViewById(d.g.bar_name);
                textView.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(d.f.pic_v_avatar), (Drawable) null, (Drawable) null, (Drawable) null);
                am.h(textView, d.C0142d.cp_cont_b);
                am.h((TextView) childAt.findViewById(d.g.bar_info), d.C0142d.cp_cont_j);
            }
        }
        for (int i4 = 0; i4 < gcF.length; i4++) {
            ((TbImageView) this.mRootView.findViewById(gcF[i4])).setBackgroundDrawable(am.getDrawable(d.f.shape_gift_icon_bg));
        }
        am.j(this.gde, d.C0142d.cp_bg_line_e);
        am.h(this.gdf, d.C0142d.cp_cont_b);
        am.h(this.gdg, d.C0142d.cp_cont_d);
        am.c(this.gcG, d.f.icon_arrow_gray_right_n);
        am.i(this.gdh, d.f.selector_like_button_bg);
        am.c(this.gdh, d.C0142d.cp_cont_g, 1);
    }

    public void onDestory() {
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.g gVar) {
        this.gcD = gVar;
        if (this.gcL != null) {
            this.gcL.setOnViewResponseListener(this.gcD);
        }
        this.gcX.setOnViewResponseListener(this.gcD);
    }

    public void sf(String str) {
        this.gcH.fn(str);
        if (!StringUtils.isNull(str)) {
            this.gcH.getHeadView().setShowV(false);
        } else if (this.mUserData.isBigV() || !StringUtils.isNull(this.mUserData.getUserTbVipInfoData().getvipV_url())) {
            this.gcH.getHeadView().setShowV(true);
        } else {
            this.gcH.getHeadView().setShowV(false);
        }
    }

    protected void bln() {
        this.gcH.setHasPendantStyle();
        this.gcH.getHeadView().setIsRound(true);
        this.gcH.getHeadView().setDrawBorder(false);
        this.gcH.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    protected void bjv() {
        if (this.mUserData != null && (this.mUserData.getIsMem() > 0 || this.mUserData.isBigV())) {
            am.c(this.azm, d.C0142d.cp_cont_h, 1);
        } else {
            am.c(this.azm, d.C0142d.cp_cont_b, 1);
        }
    }

    private void blo() {
        if (this.gcE != null && this.gcE.bli() != null) {
            this.gdc.removeAllViews();
            int godType = this.gcE.bli().getGodType();
            if (godType == 2 && w.z(this.gcE.bli().getForumGodList()) > 0) {
                this.gdc.setVisibility(0);
                for (ForumGodDetailInfo forumGodDetailInfo : this.gcE.bli().getForumGodList()) {
                    if (forumGodDetailInfo != null) {
                        bV(forumGodDetailInfo.forum_name, forumGodDetailInfo.intro);
                    }
                }
                return;
            } else if (godType == 1 && this.gcE.bli().getgodDetailInfo() != null && !StringUtils.isNull(this.gcE.bli().getgodDetailInfo().intro)) {
                this.gdc.setVisibility(0);
                bV(this.gcE.bli().getgodDetailInfo().intro, "");
                return;
            } else {
                return;
            }
        }
        this.gdc.setVisibility(8);
    }

    private void bV(String str, String str2) {
        View inflate = LayoutInflater.from(this.mContext).inflate(d.i.layout_god_auth_info, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(d.g.bar_name);
        textView.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(d.f.pic_v_avatar), (Drawable) null, (Drawable) null, (Drawable) null);
        am.h(textView, d.C0142d.cp_cont_b);
        textView.setText(str);
        TextView textView2 = (TextView) inflate.findViewById(d.g.bar_info);
        am.h(textView2, d.C0142d.cp_cont_j);
        textView2.setText(str2);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.ds14);
        this.gdc.addView(inflate, layoutParams);
    }

    private void blp() {
        int i;
        for (int i2 = 0; i2 < gcF.length; i2++) {
            ((TbImageView) this.mRootView.findViewById(gcF[i2])).setVisibility(8);
        }
        if (this.gcE == null || this.gcE.blh() == null || w.z(this.gcE.blh().gaM) <= 0) {
            i = 0;
        } else {
            int i3 = this.gcE.blh().giftNum;
            List<com.baidu.adp.widget.ListView.h> list = this.gcE.blh().gaM;
            for (int i4 = 0; i4 < list.size() && i4 < gcF.length; i4++) {
                if (list.get(i4) instanceof com.baidu.tieba.personPolymeric.c.o) {
                    TbImageView tbImageView = (TbImageView) this.mRootView.findViewById(gcF[i4]);
                    tbImageView.setVisibility(0);
                    tbImageView.setIsRound(true);
                    tbImageView.startLoad(((com.baidu.tieba.personPolymeric.c.o) list.get(i4)).picUrl, 10, false);
                }
            }
            i = i3;
        }
        this.gdg.setText(String.format(this.mContext.getResources().getString(d.k.gift_num), Integer.valueOf(i)));
    }
}
