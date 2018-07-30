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
    private static final int[] gcX = {d.g.img_gift_one, d.g.img_gift_two, d.g.img_gift_three};
    protected TextView ayY;
    private TextView buY;
    private com.baidu.tbadk.core.view.userLike.c cyt;
    private View dTZ;
    protected TbImageView fVC;
    protected com.baidu.tieba.view.g gcV;
    protected com.baidu.tieba.personPolymeric.c.a gcW;
    protected ImageView gcY;
    protected PersonHeadPendantView gcZ;
    private int gdA;
    protected UserIconBox gda;
    protected TextView gdb;
    protected TextView gdc;
    public com.baidu.tieba.view.e gdd;
    protected View gde;
    private TextView gdf;
    private TextView gdg;
    private TextView gdh;
    private View gdi;
    private View gdj;
    private TextView gdk;
    private View gdl;
    private View gdm;
    private LinearLayout gdn;
    private TextView gdo;
    private m gdp;
    private View gdq;
    private ImageView gdr;
    private TextView gds;
    private BlueLikeButton gdt;
    private LinearLayout gdu;
    private RelativeLayout gdv;
    private View gdw;
    private TextView gdx;
    private TextView gdy;
    private TextView gdz;
    protected Context mContext;
    protected boolean mIsHost;
    private TbPageContext mPageContext;
    protected View mRootView;
    protected UserData mUserData;

    public n(TbPageContext tbPageContext, boolean z) {
        this.gdA = 0;
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.mIsHost = z;
        this.gdA = com.baidu.adp.lib.util.l.f(this.mContext, d.e.tbds46);
        Y(ahb());
        TextView textView = this.gdb;
        if (this.mIsHost) {
        }
        textView.setVisibility(8);
    }

    public View ahb() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(d.h.item_person_polymeric_header_view, (ViewGroup) null);
        }
        return this.mRootView;
    }

    public void Y(View view) {
        this.gde = view.findViewById(d.g.person_info_root);
        this.gcZ = (PersonHeadPendantView) view.findViewById(d.g.person_polymeric_header_user_img);
        this.gcZ.getHeadView().setCustomBigViewIconId(d.f.pic_v_avatar_big);
        this.gcZ.getHeadView().setIconWidth(this.mContext.getResources().getDimensionPixelSize(d.e.ds40));
        this.gcZ.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fVC = (TbImageView) view.findViewById(d.g.person_polymeric_header_user_vip_icon);
        this.ayY = (TextView) view.findViewById(d.g.person_polymeric_header_user_name_txt);
        this.gdc = (TextView) view.findViewById(d.g.seal_prefix_view);
        this.gda = (UserIconBox) view.findViewById(d.g.person_polymeric_header_label_box);
        this.gdf = (TextView) view.findViewById(d.g.person_polymeric_header_bar_age_txt);
        this.buY = (TextView) view.findViewById(d.g.person_polymeric_header_ala_id);
        this.gdi = view.findViewById(d.g.divider_for_alaid_and_age);
        this.gdb = (TextView) view.findViewById(d.g.person_polymeric_header_visitor_txt);
        this.gdg = (TextView) view.findViewById(d.g.person_polymeric_header_sign_txt);
        this.gdh = (TextView) view.findViewById(d.g.person_center_header_tdou_txt);
        this.gdk = (TextView) view.findViewById(d.g.textview_get_tdou);
        this.gdl = view.findViewById(d.g.divider_for_age_and_tdou);
        this.gdm = view.findViewById(d.g.divider_for_tdou_and_get_tdou);
        this.gdn = (LinearLayout) view.findViewById(d.g.layout_user_name);
        this.gdo = (TextView) view.findViewById(d.g.person_praise_number);
        this.gdh.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(d.f.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
        this.gdd = (PersonHeaderAttentionView) view.findViewById(d.g.person_center_header_attention_container);
        bjH();
        this.gdp = new m(this.mContext);
        this.fVC.setOnClickListener(this.gdp);
        this.gda.setOnClickListener(this.gdp);
        this.gcZ.setOnClickListener(this.gdp);
        this.gdb.setOnClickListener(this.gdp);
        this.gdc.setOnClickListener(this.gdp);
        this.gdh.setOnClickListener(this.gdp);
        this.gdk.setOnClickListener(this.gdp);
        this.ayY.setOnClickListener(this.gdp);
        this.gdg.setOnClickListener(this.gdp);
        this.gdq = (LinearLayout) view.findViewById(d.g.container_send_gift);
        this.gdr = (ImageView) view.findViewById(d.g.icon_gift);
        this.gds = (TextView) view.findViewById(d.g.btn_give_gift);
        this.gdq.setOnClickListener(this.gdp);
        this.gdt = (BlueLikeButton) view.findViewById(d.g.btn_like_blue);
        this.cyt = new com.baidu.tbadk.core.view.userLike.c(this.mPageContext, this.gdt);
        this.cyt.setFromType("2");
        if (this.mIsHost) {
            this.gdq.setVisibility(8);
            this.gdt.setVisibility(8);
        }
        this.gdu = (LinearLayout) view.findViewById(d.g.layout_god_auth_forums);
        this.gdu.setVisibility(8);
        this.dTZ = view.findViewById(d.g.header_bottom_divider);
        this.gdv = (RelativeLayout) view.findViewById(d.g.layout_gift);
        this.gdv.setOnClickListener(this.gdp);
        this.gdw = view.findViewById(d.g.gift_top_divider);
        this.gdx = (TextView) view.findViewById(d.g.textview_received_gift);
        this.gdy = (TextView) view.findViewById(d.g.textview_received_gift_num);
        this.gcY = (ImageView) view.findViewById(d.g.img_gift_arrow);
        this.gdz = (TextView) view.findViewById(d.g.btn_edit_person_info);
        this.gdz.setOnClickListener(this.gdp);
        if (!this.mIsHost) {
            this.gdz.setVisibility(8);
        }
    }

    public void e(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null) {
            this.gcW = aVar;
            this.mUserData = aVar.getUserData();
            this.gdp.a(aVar);
            this.gdp.setIsHost(this.mIsHost);
            String portrait = this.mUserData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                if (portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    this.gcZ.getHeadView().startLoad(portrait, 10, false);
                } else {
                    String ev = com.baidu.tbadk.core.util.p.ev(portrait);
                    this.gcZ.getHeadView().setUrl(ev);
                    this.gcZ.getHeadView().startLoad(ev, 25, false);
                }
            } else {
                this.gcZ.getHeadView().startLoad(String.valueOf(d.f.pic_mycenter_avatar_def_i), 24, false);
            }
            com.baidu.tbadk.data.i pendantData = this.mUserData.getPendantData();
            if (pendantData != null) {
                this.gcZ.fl(pendantData.tU());
            }
            if (this.gcZ.Aj()) {
                this.gcZ.getHeadView().setShowV(false);
            } else if (this.mUserData.isBigV() || !StringUtils.isNull(this.mUserData.getUserTbVipInfoData().getvipV_url())) {
                this.gcZ.getHeadView().setShowV(true);
            } else {
                this.gcZ.getHeadView().setShowV(false);
            }
            UserVipInfoData userVipInfo = this.mUserData.getUserVipInfo();
            if (this.mUserData.getIsMem() > 0) {
                if (userVipInfo != null) {
                    this.fVC.startLoad(userVipInfo.getVipIconUrl(), 10, false);
                }
                this.fVC.setVisibility(0);
            } else if (this.mIsHost) {
                this.fVC.setImageDrawable(am.getDrawable(d.f.icon_crown_super_non));
                this.fVC.setVisibility(0);
            } else {
                this.fVC.setVisibility(8);
            }
            bhO();
            String name_show = this.mUserData.getName_show();
            if (!TextUtils.isEmpty(name_show)) {
                this.ayY.setText(name_show);
            }
            int i = d.f.icon_mine_boy;
            if (this.mUserData != null) {
                i = this.mUserData.getSex() == 2 ? d.f.icon_mine_girl : d.f.icon_mine_boy;
            }
            this.ayY.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mContext.getResources().getDrawable(i), (Drawable) null);
            this.gda.a(this.mUserData.getIconInfo(), 9, this.mContext.getResources().getDimensionPixelSize(d.e.tbds42), this.mContext.getResources().getDimensionPixelSize(d.e.tbds42), this.mContext.getResources().getDimensionPixelSize(d.e.tbds10), true);
            if (this.gdd != null) {
                this.gdd.setData(this.mUserData);
            }
            if (this.mUserData != null && this.mUserData.alaUserData != null && this.mUserData.alaUserData.ala_id != 0) {
                this.buY.setVisibility(0);
                this.gdi.setVisibility(0);
                this.buY.setText(String.format(this.mContext.getString(d.j.person_center_ala_id), Long.valueOf(this.mUserData.alaUserData.ala_id)));
            } else {
                this.buY.setVisibility(8);
                this.gdi.setVisibility(8);
            }
            this.gdf.setText(String.format(this.mContext.getString(d.j.person_center_header_bar_age), this.mUserData.getTb_age()));
            if (this.mIsHost) {
                this.gdl.setVisibility(0);
                this.gdm.setVisibility(0);
                this.gdh.setVisibility(0);
                this.gdk.setVisibility(0);
                this.gdh.setText(ap.N(this.mUserData.getTDouNum()));
            } else {
                this.gdl.setVisibility(8);
                this.gdm.setVisibility(8);
                this.gdh.setVisibility(8);
                this.gdk.setVisibility(8);
            }
            String intro = this.mUserData.getIntro();
            if (StringUtils.isNull(intro)) {
                am.c(this.gdg, d.C0140d.cp_cont_e, 1);
            } else {
                am.c(this.gdg, d.C0140d.cp_cont_j, 1);
            }
            if (StringUtils.isNull(intro)) {
                if (this.mIsHost) {
                    intro = this.mContext.getString(d.j.no_person_sign_host);
                } else {
                    intro = this.mContext.getString(d.j.no_person_sign_guest);
                }
            }
            this.gdg.setText(this.mContext.getString(d.j.person_sign) + intro);
            if (this.gdg.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gdg.getLayoutParams();
                if (!this.mIsHost && this.gdg.getLineCount() >= 3 && this.gdg.getMaxLines() != 2147483646) {
                    int lineHeight = this.gdg.getLineHeight();
                    this.gdg.setHeight((lineHeight / 2) + (lineHeight * 3));
                }
                if (this.gdg.getLineCount() >= 2) {
                    layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(d.e.tbds19);
                } else {
                    layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(d.e.tbds80);
                }
                this.gdg.setLayoutParams(layoutParams);
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(this.mUserData.getUserId()) && ((!TbadkCoreApplication.isLogin() || (!StringUtils.isNull(currentAccount) && !currentAccount.equals(this.mUserData.getUserId()))) && this.mUserData.getLiveStatus() == 1)) {
                if (this.gdj == null) {
                    this.gdj = com.baidu.tbadk.ala.b.rx().g(this.mContext, 7);
                }
                com.baidu.tbadk.ala.a aVar2 = new com.baidu.tbadk.ala.a();
                aVar2.ZR = this.mUserData.getAlaUserData();
                aVar2.type = 7;
                if ((this.mUserData.getPersonPrivate() != null && this.mUserData.getPersonPrivate().GW() == 3) || (this.mUserData.getPersonPrivate().GW() == 2 && this.mUserData.getIsFriend() != 1)) {
                    aVar2.ZS = true;
                } else {
                    aVar2.ZS = false;
                }
                if (this.gdj != null) {
                    this.gdj.setTag(aVar2);
                    if (this.gdj.getParent() == null) {
                        this.gdn.addView(this.gdj);
                        TiebaStatic.log(new an("c12541"));
                    }
                }
            } else if (this.gdj != null) {
                this.gdj.setVisibility(8);
            }
            a(aVar.gaP);
            this.mUserData.setIsLike(this.mUserData.getHave_attention() == 1);
            this.cyt.a(this.mUserData);
            bjI();
            bjJ();
            this.gdx.setText(this.mIsHost ? d.j.my_received_gift : d.j.he_received_gift);
            if ((this.mUserData.getPersonPrivate() == null || this.mUserData.getPersonPrivate().GW() != 3) && this.mUserData.getPersonPrivate().GW() == 2 && this.mUserData.getIsFriend() != 1) {
            }
        }
    }

    private void a(UserAgreeInfo userAgreeInfo) {
        if (userAgreeInfo == null) {
            this.gdo.setVisibility(8);
            return;
        }
        this.gdo.setVisibility(0);
        String H = ap.H(userAgreeInfo.total_agree_num.longValue());
        Drawable drawable = am.getDrawable(d.f.icon_home_card_like_s);
        drawable.setBounds(0, 0, this.gdA, this.gdA);
        this.gdo.setCompoundDrawables(drawable, null, null, null);
        this.gdo.setText(H);
    }

    public void onChangeSkinType(int i) {
        this.gde.setBackgroundDrawable(am.getDrawable(d.f.shape_user_info_bg));
        this.gcZ.setBackgroundViewDrawable(am.getDrawable(d.f.shape_user_img_bg));
        int i2 = d.f.icon_mine_boy;
        if (this.mUserData != null) {
            i2 = this.mUserData.getSex() == 1 ? d.f.icon_mine_boy : d.f.icon_pop_girl;
        }
        if (this.mUserData != null && this.mUserData.getIsMem() <= 0 && this.fVC != null && this.mIsHost) {
            this.fVC.setImageDrawable(am.getDrawable(d.f.icon_crown_super_non));
        }
        bhO();
        am.c(this.gdc, d.C0140d.cp_link_tip_a, 1);
        this.ayY.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mContext.getResources().getDrawable(i2), (Drawable) null);
        if (this.gdd != null) {
            this.gdd.onChangeSkinType(i);
        }
        am.c(this.gdb, d.C0140d.cp_cont_b, 1);
        am.c(this.gdf, d.C0140d.cp_cont_b, 1);
        am.c(this.buY, d.C0140d.cp_cont_b, 1);
        if (this.mUserData == null || StringUtils.isNull(this.mUserData.getIntro())) {
            am.c(this.gdg, d.C0140d.cp_cont_e, 1);
        } else {
            am.c(this.gdg, d.C0140d.cp_cont_j, 1);
        }
        am.c(this.gdh, d.C0140d.cp_cont_b, 1);
        am.c(this.gdk, d.C0140d.cp_cont_b, 1);
        am.j(this.gdl, d.C0140d.cp_bg_line_b);
        am.j(this.gdi, d.C0140d.cp_bg_line_b);
        am.j(this.gdm, d.C0140d.cp_bg_line_b);
        am.h(this.gdo, d.C0140d.cp_cont_h);
        this.gdh.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(d.f.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
        Drawable v = am.v(i, d.f.icon_home_card_like_s);
        v.setBounds(0, 0, this.gdA, this.gdA);
        this.gdo.setCompoundDrawables(v, null, null, null);
        am.i(this.gdq, d.f.selector_give_gift_bg);
        am.c(this.gdr, d.f.selector_gift_icon);
        am.c(this.gds, d.C0140d.selector_give_gift_text_color, 1);
        this.gdt.onChangeSkinType(i);
        am.j(this.dTZ, d.C0140d.cp_bg_line_e);
        for (int i3 = 0; i3 < this.gdu.getChildCount(); i3++) {
            View childAt = this.gdu.getChildAt(i3);
            if (childAt != null) {
                TextView textView = (TextView) childAt.findViewById(d.g.bar_name);
                textView.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(d.f.pic_v_avatar), (Drawable) null, (Drawable) null, (Drawable) null);
                am.h(textView, d.C0140d.cp_cont_b);
                am.h((TextView) childAt.findViewById(d.g.bar_info), d.C0140d.cp_cont_j);
            }
        }
        for (int i4 = 0; i4 < gcX.length; i4++) {
            ((TbImageView) this.mRootView.findViewById(gcX[i4])).setBackgroundDrawable(am.getDrawable(d.f.shape_gift_icon_bg));
        }
        am.j(this.gdw, d.C0140d.cp_bg_line_e);
        am.h(this.gdx, d.C0140d.cp_cont_b);
        am.h(this.gdy, d.C0140d.cp_cont_d);
        am.c(this.gcY, d.f.icon_arrow_gray_right_n);
        am.i(this.gdz, d.f.selector_like_button_bg);
        am.c(this.gdz, d.C0140d.cp_cont_g, 1);
    }

    public void onDestory() {
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.g gVar) {
        this.gcV = gVar;
        if (this.gdd != null) {
            this.gdd.setOnViewResponseListener(this.gcV);
        }
        this.gdp.setOnViewResponseListener(this.gcV);
    }

    public void rZ(String str) {
        this.gcZ.fl(str);
        if (!StringUtils.isNull(str)) {
            this.gcZ.getHeadView().setShowV(false);
        } else if (this.mUserData.isBigV() || !StringUtils.isNull(this.mUserData.getUserTbVipInfoData().getvipV_url())) {
            this.gcZ.getHeadView().setShowV(true);
        } else {
            this.gcZ.getHeadView().setShowV(false);
        }
    }

    protected void bjH() {
        this.gcZ.setHasPendantStyle();
        this.gcZ.getHeadView().setIsRound(true);
        this.gcZ.getHeadView().setDrawBorder(false);
        this.gcZ.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    protected void bhO() {
        if (this.mUserData != null && (this.mUserData.getIsMem() > 0 || this.mUserData.isBigV())) {
            am.c(this.ayY, d.C0140d.cp_cont_h, 1);
        } else {
            am.c(this.ayY, d.C0140d.cp_cont_b, 1);
        }
    }

    private void bjI() {
        if (this.gcW != null && this.gcW.bjC() != null) {
            this.gdu.removeAllViews();
            int godType = this.gcW.bjC().getGodType();
            if (godType == 2 && w.y(this.gcW.bjC().getForumGodList()) > 0) {
                this.gdu.setVisibility(0);
                for (ForumGodDetailInfo forumGodDetailInfo : this.gcW.bjC().getForumGodList()) {
                    if (forumGodDetailInfo != null) {
                        bR(forumGodDetailInfo.forum_name, forumGodDetailInfo.intro);
                    }
                }
                return;
            } else if (godType == 1 && this.gcW.bjC().getgodDetailInfo() != null && !StringUtils.isNull(this.gcW.bjC().getgodDetailInfo().intro)) {
                this.gdu.setVisibility(0);
                bR(this.gcW.bjC().getgodDetailInfo().intro, "");
                return;
            } else {
                return;
            }
        }
        this.gdu.setVisibility(8);
    }

    private void bR(String str, String str2) {
        View inflate = LayoutInflater.from(this.mContext).inflate(d.h.layout_god_auth_info, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(d.g.bar_name);
        textView.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(d.f.pic_v_avatar), (Drawable) null, (Drawable) null, (Drawable) null);
        am.h(textView, d.C0140d.cp_cont_b);
        textView.setText(str);
        TextView textView2 = (TextView) inflate.findViewById(d.g.bar_info);
        am.h(textView2, d.C0140d.cp_cont_j);
        textView2.setText(str2);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(d.e.ds14);
        this.gdu.addView(inflate, layoutParams);
    }

    private void bjJ() {
        int i;
        for (int i2 = 0; i2 < gcX.length; i2++) {
            ((TbImageView) this.mRootView.findViewById(gcX[i2])).setVisibility(8);
        }
        if (this.gcW == null || this.gcW.bjB() == null || w.y(this.gcW.bjB().gbd) <= 0) {
            i = 0;
        } else {
            int i3 = this.gcW.bjB().giftNum;
            List<com.baidu.adp.widget.ListView.h> list = this.gcW.bjB().gbd;
            for (int i4 = 0; i4 < list.size() && i4 < gcX.length; i4++) {
                if (list.get(i4) instanceof com.baidu.tieba.personPolymeric.c.o) {
                    TbImageView tbImageView = (TbImageView) this.mRootView.findViewById(gcX[i4]);
                    tbImageView.setVisibility(0);
                    tbImageView.setIsRound(true);
                    tbImageView.startLoad(((com.baidu.tieba.personPolymeric.c.o) list.get(i4)).picUrl, 10, false);
                }
            }
            i = i3;
        }
        this.gdy.setText(String.format(this.mContext.getResources().getString(d.j.gift_num), Integer.valueOf(i)));
    }
}
