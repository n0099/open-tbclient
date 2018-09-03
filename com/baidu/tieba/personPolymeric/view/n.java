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
import com.baidu.tieba.f;
import com.baidu.tieba.personCenter.view.PersonHeadPendantView;
import com.baidu.tieba.view.PersonHeaderAttentionView;
import java.util.List;
import org.apache.http.HttpHost;
import tbclient.Profile.ForumGodDetailInfo;
import tbclient.Profile.UserAgreeInfo;
/* loaded from: classes3.dex */
public class n {
    private static final int[] gcW = {f.g.img_gift_one, f.g.img_gift_two, f.g.img_gift_three};
    protected TextView ayV;
    private TextView bva;
    private com.baidu.tbadk.core.view.userLike.c cyq;
    private View dTU;
    protected TbImageView fVC;
    protected com.baidu.tieba.view.g gcU;
    protected com.baidu.tieba.personPolymeric.c.a gcV;
    protected ImageView gcX;
    protected PersonHeadPendantView gcY;
    protected UserIconBox gcZ;
    protected TextView gda;
    protected TextView gdb;
    public com.baidu.tieba.view.e gdc;
    protected View gdd;
    private TextView gde;
    private TextView gdf;
    private TextView gdg;
    private View gdh;
    private View gdi;
    private TextView gdj;
    private View gdk;
    private View gdl;
    private LinearLayout gdm;
    private TextView gdn;
    private m gdo;
    private View gdp;
    private ImageView gdq;
    private TextView gdr;
    private BlueLikeButton gds;
    private LinearLayout gdt;
    private RelativeLayout gdu;
    private View gdv;
    private TextView gdw;
    private TextView gdx;
    private TextView gdy;
    private int gdz;
    protected Context mContext;
    protected boolean mIsHost;
    private TbPageContext mPageContext;
    protected View mRootView;
    protected UserData mUserData;

    public n(TbPageContext tbPageContext, boolean z) {
        this.gdz = 0;
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.mIsHost = z;
        this.gdz = com.baidu.adp.lib.util.l.f(this.mContext, f.e.tbds46);
        Y(ahd());
        TextView textView = this.gda;
        if (this.mIsHost) {
        }
        textView.setVisibility(8);
    }

    public View ahd() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(f.h.item_person_polymeric_header_view, (ViewGroup) null);
        }
        return this.mRootView;
    }

    public void Y(View view) {
        this.gdd = view.findViewById(f.g.person_info_root);
        this.gcY = (PersonHeadPendantView) view.findViewById(f.g.person_polymeric_header_user_img);
        this.gcY.getHeadView().setCustomBigViewIconId(f.C0146f.pic_v_avatar_big);
        this.gcY.getHeadView().setIconWidth(this.mContext.getResources().getDimensionPixelSize(f.e.ds40));
        this.gcY.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fVC = (TbImageView) view.findViewById(f.g.person_polymeric_header_user_vip_icon);
        this.ayV = (TextView) view.findViewById(f.g.person_polymeric_header_user_name_txt);
        this.gdb = (TextView) view.findViewById(f.g.seal_prefix_view);
        this.gcZ = (UserIconBox) view.findViewById(f.g.person_polymeric_header_label_box);
        this.gde = (TextView) view.findViewById(f.g.person_polymeric_header_bar_age_txt);
        this.bva = (TextView) view.findViewById(f.g.person_polymeric_header_ala_id);
        this.gdh = view.findViewById(f.g.divider_for_alaid_and_age);
        this.gda = (TextView) view.findViewById(f.g.person_polymeric_header_visitor_txt);
        this.gdf = (TextView) view.findViewById(f.g.person_polymeric_header_sign_txt);
        this.gdg = (TextView) view.findViewById(f.g.person_center_header_tdou_txt);
        this.gdj = (TextView) view.findViewById(f.g.textview_get_tdou);
        this.gdk = view.findViewById(f.g.divider_for_age_and_tdou);
        this.gdl = view.findViewById(f.g.divider_for_tdou_and_get_tdou);
        this.gdm = (LinearLayout) view.findViewById(f.g.layout_user_name);
        this.gdn = (TextView) view.findViewById(f.g.person_praise_number);
        this.gdg.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(f.C0146f.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
        this.gdc = (PersonHeaderAttentionView) view.findViewById(f.g.person_center_header_attention_container);
        bjE();
        this.gdo = new m(this.mContext);
        this.fVC.setOnClickListener(this.gdo);
        this.gcZ.setOnClickListener(this.gdo);
        this.gcY.setOnClickListener(this.gdo);
        this.gda.setOnClickListener(this.gdo);
        this.gdb.setOnClickListener(this.gdo);
        this.gdg.setOnClickListener(this.gdo);
        this.gdj.setOnClickListener(this.gdo);
        this.ayV.setOnClickListener(this.gdo);
        this.gdf.setOnClickListener(this.gdo);
        this.gdp = (LinearLayout) view.findViewById(f.g.container_send_gift);
        this.gdq = (ImageView) view.findViewById(f.g.icon_gift);
        this.gdr = (TextView) view.findViewById(f.g.btn_give_gift);
        this.gdp.setOnClickListener(this.gdo);
        this.gds = (BlueLikeButton) view.findViewById(f.g.btn_like_blue);
        this.cyq = new com.baidu.tbadk.core.view.userLike.c(this.mPageContext, this.gds);
        this.cyq.setFromType("2");
        if (this.mIsHost) {
            this.gdp.setVisibility(8);
            this.gds.setVisibility(8);
        }
        this.gdt = (LinearLayout) view.findViewById(f.g.layout_god_auth_forums);
        this.gdt.setVisibility(8);
        this.dTU = view.findViewById(f.g.header_bottom_divider);
        this.gdu = (RelativeLayout) view.findViewById(f.g.layout_gift);
        this.gdu.setOnClickListener(this.gdo);
        this.gdv = view.findViewById(f.g.gift_top_divider);
        this.gdw = (TextView) view.findViewById(f.g.textview_received_gift);
        this.gdx = (TextView) view.findViewById(f.g.textview_received_gift_num);
        this.gcX = (ImageView) view.findViewById(f.g.img_gift_arrow);
        this.gdy = (TextView) view.findViewById(f.g.btn_edit_person_info);
        this.gdy.setOnClickListener(this.gdo);
        if (!this.mIsHost) {
            this.gdy.setVisibility(8);
        }
    }

    public void e(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null) {
            this.gcV = aVar;
            this.mUserData = aVar.getUserData();
            this.gdo.a(aVar);
            this.gdo.setIsHost(this.mIsHost);
            String portrait = this.mUserData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                if (portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    this.gcY.getHeadView().startLoad(portrait, 10, false);
                } else {
                    String ev = com.baidu.tbadk.core.util.p.ev(portrait);
                    this.gcY.getHeadView().setUrl(ev);
                    this.gcY.getHeadView().startLoad(ev, 25, false);
                }
            } else {
                this.gcY.getHeadView().startLoad(String.valueOf(f.C0146f.pic_mycenter_avatar_def_i), 24, false);
            }
            com.baidu.tbadk.data.i pendantData = this.mUserData.getPendantData();
            if (pendantData != null) {
                this.gcY.fl(pendantData.tT());
            }
            if (this.gcY.Ah()) {
                this.gcY.getHeadView().setShowV(false);
            } else if (this.mUserData.isBigV() || !StringUtils.isNull(this.mUserData.getUserTbVipInfoData().getvipV_url())) {
                this.gcY.getHeadView().setShowV(true);
            } else {
                this.gcY.getHeadView().setShowV(false);
            }
            UserVipInfoData userVipInfo = this.mUserData.getUserVipInfo();
            if (this.mUserData.getIsMem() > 0) {
                if (userVipInfo != null) {
                    this.fVC.startLoad(userVipInfo.getVipIconUrl(), 10, false);
                }
                this.fVC.setVisibility(0);
            } else if (this.mIsHost) {
                this.fVC.setImageDrawable(am.getDrawable(f.C0146f.icon_crown_super_non));
                this.fVC.setVisibility(0);
            } else {
                this.fVC.setVisibility(8);
            }
            bhL();
            String name_show = this.mUserData.getName_show();
            if (!TextUtils.isEmpty(name_show)) {
                this.ayV.setText(name_show);
            }
            int i = f.C0146f.icon_mine_boy;
            if (this.mUserData != null) {
                i = this.mUserData.getSex() == 2 ? f.C0146f.icon_mine_girl : f.C0146f.icon_mine_boy;
            }
            this.ayV.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mContext.getResources().getDrawable(i), (Drawable) null);
            this.gcZ.a(this.mUserData.getIconInfo(), 9, this.mContext.getResources().getDimensionPixelSize(f.e.tbds42), this.mContext.getResources().getDimensionPixelSize(f.e.tbds42), this.mContext.getResources().getDimensionPixelSize(f.e.tbds10), true);
            if (this.gdc != null) {
                this.gdc.setData(this.mUserData);
            }
            if (this.mUserData != null && this.mUserData.alaUserData != null && this.mUserData.alaUserData.ala_id != 0) {
                this.bva.setVisibility(0);
                this.gdh.setVisibility(0);
                this.bva.setText(String.format(this.mContext.getString(f.j.person_center_ala_id), Long.valueOf(this.mUserData.alaUserData.ala_id)));
            } else {
                this.bva.setVisibility(8);
                this.gdh.setVisibility(8);
            }
            this.gde.setText(String.format(this.mContext.getString(f.j.person_center_header_bar_age), this.mUserData.getTb_age()));
            if (this.mIsHost) {
                this.gdk.setVisibility(0);
                this.gdl.setVisibility(0);
                this.gdg.setVisibility(0);
                this.gdj.setVisibility(0);
                this.gdg.setText(ap.N(this.mUserData.getTDouNum()));
            } else {
                this.gdk.setVisibility(8);
                this.gdl.setVisibility(8);
                this.gdg.setVisibility(8);
                this.gdj.setVisibility(8);
            }
            String intro = this.mUserData.getIntro();
            if (StringUtils.isNull(intro)) {
                am.c(this.gdf, f.d.cp_cont_e, 1);
            } else {
                am.c(this.gdf, f.d.cp_cont_j, 1);
            }
            if (StringUtils.isNull(intro)) {
                if (this.mIsHost) {
                    intro = this.mContext.getString(f.j.no_person_sign_host);
                } else {
                    intro = this.mContext.getString(f.j.no_person_sign_guest);
                }
            }
            this.gdf.setText(this.mContext.getString(f.j.person_sign) + intro);
            if (this.gdf.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gdf.getLayoutParams();
                if (!this.mIsHost && this.gdf.getLineCount() >= 3 && this.gdf.getMaxLines() != 2147483646) {
                    int lineHeight = this.gdf.getLineHeight();
                    this.gdf.setHeight((lineHeight / 2) + (lineHeight * 3));
                }
                if (this.gdf.getLineCount() >= 2) {
                    layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(f.e.tbds19);
                } else {
                    layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(f.e.tbds80);
                }
                this.gdf.setLayoutParams(layoutParams);
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(this.mUserData.getUserId()) && ((!TbadkCoreApplication.isLogin() || (!StringUtils.isNull(currentAccount) && !currentAccount.equals(this.mUserData.getUserId()))) && this.mUserData.getLiveStatus() == 1)) {
                if (this.gdi == null) {
                    this.gdi = com.baidu.tbadk.ala.b.rv().g(this.mContext, 7);
                }
                com.baidu.tbadk.ala.a aVar2 = new com.baidu.tbadk.ala.a();
                aVar2.ZS = this.mUserData.getAlaUserData();
                aVar2.type = 7;
                if ((this.mUserData.getPersonPrivate() != null && this.mUserData.getPersonPrivate().GW() == 3) || (this.mUserData.getPersonPrivate().GW() == 2 && this.mUserData.getIsFriend() != 1)) {
                    aVar2.ZT = true;
                } else {
                    aVar2.ZT = false;
                }
                if (this.gdi != null) {
                    this.gdi.setTag(aVar2);
                    if (this.gdi.getParent() == null) {
                        this.gdm.addView(this.gdi);
                        TiebaStatic.log(new an("c12541"));
                    }
                }
            } else if (this.gdi != null) {
                this.gdi.setVisibility(8);
            }
            a(aVar.gaP);
            this.mUserData.setIsLike(this.mUserData.getHave_attention() == 1);
            this.cyq.a(this.mUserData);
            bjF();
            bjG();
            this.gdw.setText(this.mIsHost ? f.j.my_received_gift : f.j.he_received_gift);
            if ((this.mUserData.getPersonPrivate() == null || this.mUserData.getPersonPrivate().GW() != 3) && this.mUserData.getPersonPrivate().GW() == 2 && this.mUserData.getIsFriend() != 1) {
            }
        }
    }

    private void a(UserAgreeInfo userAgreeInfo) {
        if (userAgreeInfo == null) {
            this.gdn.setVisibility(8);
            return;
        }
        this.gdn.setVisibility(0);
        String H = ap.H(userAgreeInfo.total_agree_num.longValue());
        Drawable drawable = am.getDrawable(f.C0146f.icon_home_card_like_s);
        drawable.setBounds(0, 0, this.gdz, this.gdz);
        this.gdn.setCompoundDrawables(drawable, null, null, null);
        this.gdn.setText(H);
    }

    public void onChangeSkinType(int i) {
        this.gdd.setBackgroundDrawable(am.getDrawable(f.C0146f.shape_user_info_bg));
        this.gcY.setBackgroundViewDrawable(am.getDrawable(f.C0146f.shape_user_img_bg));
        int i2 = f.C0146f.icon_mine_boy;
        if (this.mUserData != null) {
            i2 = this.mUserData.getSex() == 1 ? f.C0146f.icon_mine_boy : f.C0146f.icon_pop_girl;
        }
        if (this.mUserData != null && this.mUserData.getIsMem() <= 0 && this.fVC != null && this.mIsHost) {
            this.fVC.setImageDrawable(am.getDrawable(f.C0146f.icon_crown_super_non));
        }
        bhL();
        am.c(this.gdb, f.d.cp_link_tip_a, 1);
        this.ayV.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mContext.getResources().getDrawable(i2), (Drawable) null);
        if (this.gdc != null) {
            this.gdc.onChangeSkinType(i);
        }
        am.c(this.gda, f.d.cp_cont_b, 1);
        am.c(this.gde, f.d.cp_cont_b, 1);
        am.c(this.bva, f.d.cp_cont_b, 1);
        if (this.mUserData == null || StringUtils.isNull(this.mUserData.getIntro())) {
            am.c(this.gdf, f.d.cp_cont_e, 1);
        } else {
            am.c(this.gdf, f.d.cp_cont_j, 1);
        }
        am.c(this.gdg, f.d.cp_cont_b, 1);
        am.c(this.gdj, f.d.cp_cont_b, 1);
        am.j(this.gdk, f.d.cp_bg_line_b);
        am.j(this.gdh, f.d.cp_bg_line_b);
        am.j(this.gdl, f.d.cp_bg_line_b);
        am.h(this.gdn, f.d.cp_cont_h);
        this.gdg.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(f.C0146f.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
        Drawable v = am.v(i, f.C0146f.icon_home_card_like_s);
        v.setBounds(0, 0, this.gdz, this.gdz);
        this.gdn.setCompoundDrawables(v, null, null, null);
        am.i(this.gdp, f.C0146f.selector_give_gift_bg);
        am.c(this.gdq, f.C0146f.selector_gift_icon);
        am.c(this.gdr, f.d.selector_give_gift_text_color, 1);
        this.gds.onChangeSkinType(i);
        am.j(this.dTU, f.d.cp_bg_line_e);
        for (int i3 = 0; i3 < this.gdt.getChildCount(); i3++) {
            View childAt = this.gdt.getChildAt(i3);
            if (childAt != null) {
                TextView textView = (TextView) childAt.findViewById(f.g.bar_name);
                textView.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(f.C0146f.pic_v_avatar), (Drawable) null, (Drawable) null, (Drawable) null);
                am.h(textView, f.d.cp_cont_b);
                am.h((TextView) childAt.findViewById(f.g.bar_info), f.d.cp_cont_j);
            }
        }
        for (int i4 = 0; i4 < gcW.length; i4++) {
            ((TbImageView) this.mRootView.findViewById(gcW[i4])).setBackgroundDrawable(am.getDrawable(f.C0146f.shape_gift_icon_bg));
        }
        am.j(this.gdv, f.d.cp_bg_line_e);
        am.h(this.gdw, f.d.cp_cont_b);
        am.h(this.gdx, f.d.cp_cont_d);
        am.c(this.gcX, f.C0146f.icon_arrow_gray_right_n);
        am.i(this.gdy, f.C0146f.selector_like_button_bg);
        am.c(this.gdy, f.d.cp_cont_g, 1);
    }

    public void onDestory() {
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.g gVar) {
        this.gcU = gVar;
        if (this.gdc != null) {
            this.gdc.setOnViewResponseListener(this.gcU);
        }
        this.gdo.setOnViewResponseListener(this.gcU);
    }

    public void sc(String str) {
        this.gcY.fl(str);
        if (!StringUtils.isNull(str)) {
            this.gcY.getHeadView().setShowV(false);
        } else if (this.mUserData.isBigV() || !StringUtils.isNull(this.mUserData.getUserTbVipInfoData().getvipV_url())) {
            this.gcY.getHeadView().setShowV(true);
        } else {
            this.gcY.getHeadView().setShowV(false);
        }
    }

    protected void bjE() {
        this.gcY.setHasPendantStyle();
        this.gcY.getHeadView().setIsRound(true);
        this.gcY.getHeadView().setDrawBorder(false);
        this.gcY.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    protected void bhL() {
        if (this.mUserData != null && (this.mUserData.getIsMem() > 0 || this.mUserData.isBigV())) {
            am.c(this.ayV, f.d.cp_cont_h, 1);
        } else {
            am.c(this.ayV, f.d.cp_cont_b, 1);
        }
    }

    private void bjF() {
        if (this.gcV != null && this.gcV.bjz() != null) {
            this.gdt.removeAllViews();
            int godType = this.gcV.bjz().getGodType();
            if (godType == 2 && w.y(this.gcV.bjz().getForumGodList()) > 0) {
                this.gdt.setVisibility(0);
                for (ForumGodDetailInfo forumGodDetailInfo : this.gcV.bjz().getForumGodList()) {
                    if (forumGodDetailInfo != null) {
                        bR(forumGodDetailInfo.forum_name, forumGodDetailInfo.intro);
                    }
                }
                return;
            } else if (godType == 1 && this.gcV.bjz().getgodDetailInfo() != null && !StringUtils.isNull(this.gcV.bjz().getgodDetailInfo().intro)) {
                this.gdt.setVisibility(0);
                bR(this.gcV.bjz().getgodDetailInfo().intro, "");
                return;
            } else {
                return;
            }
        }
        this.gdt.setVisibility(8);
    }

    private void bR(String str, String str2) {
        View inflate = LayoutInflater.from(this.mContext).inflate(f.h.layout_god_auth_info, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(f.g.bar_name);
        textView.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(f.C0146f.pic_v_avatar), (Drawable) null, (Drawable) null, (Drawable) null);
        am.h(textView, f.d.cp_cont_b);
        textView.setText(str);
        TextView textView2 = (TextView) inflate.findViewById(f.g.bar_info);
        am.h(textView2, f.d.cp_cont_j);
        textView2.setText(str2);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(f.e.ds14);
        this.gdt.addView(inflate, layoutParams);
    }

    private void bjG() {
        int i;
        for (int i2 = 0; i2 < gcW.length; i2++) {
            ((TbImageView) this.mRootView.findViewById(gcW[i2])).setVisibility(8);
        }
        if (this.gcV == null || this.gcV.bjy() == null || w.y(this.gcV.bjy().gbd) <= 0) {
            i = 0;
        } else {
            int i3 = this.gcV.bjy().giftNum;
            List<com.baidu.adp.widget.ListView.h> list = this.gcV.bjy().gbd;
            for (int i4 = 0; i4 < list.size() && i4 < gcW.length; i4++) {
                if (list.get(i4) instanceof com.baidu.tieba.personPolymeric.c.o) {
                    TbImageView tbImageView = (TbImageView) this.mRootView.findViewById(gcW[i4]);
                    tbImageView.setVisibility(0);
                    tbImageView.setIsRound(true);
                    tbImageView.startLoad(((com.baidu.tieba.personPolymeric.c.o) list.get(i4)).picUrl, 10, false);
                }
            }
            i = i3;
        }
        this.gdx.setText(String.format(this.mContext.getResources().getString(f.j.gift_num), Integer.valueOf(i)));
    }
}
