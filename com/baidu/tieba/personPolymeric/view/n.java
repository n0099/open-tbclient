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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.UserVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.personCenter.view.PersonHeadPendantView;
import com.baidu.tieba.view.PersonHeaderAttentionView;
import java.util.List;
import org.apache.http.HttpHost;
import tbclient.Profile.ForumGodDetailInfo;
import tbclient.Profile.UserAgreeInfo;
/* loaded from: classes3.dex */
public class n {
    private static final int[] gkn = {e.g.img_gift_one, e.g.img_gift_two, e.g.img_gift_three};
    protected TextView aBX;
    private TextView bAP;
    private com.baidu.tbadk.core.view.userLike.c cEg;
    private View ebn;
    protected TbImageView gcR;
    private TextView gkA;
    private View gkB;
    private View gkC;
    private LinearLayout gkD;
    private TextView gkE;
    private m gkF;
    private View gkG;
    private ImageView gkH;
    private TextView gkI;
    private BlueLikeButton gkJ;
    private LinearLayout gkK;
    private RelativeLayout gkL;
    private View gkM;
    private TextView gkN;
    private TextView gkO;
    private TextView gkP;
    private int gkQ;
    protected com.baidu.tieba.view.g gkl;
    protected com.baidu.tieba.personPolymeric.c.a gkm;
    protected ImageView gko;
    protected PersonHeadPendantView gkp;
    protected UserIconBox gkq;
    protected TextView gkr;
    protected TextView gks;
    public com.baidu.tieba.view.e gkt;
    protected View gku;
    private TextView gkv;
    private TextView gkw;
    private TextView gkx;
    private View gky;
    private View gkz;
    protected Context mContext;
    protected boolean mIsHost;
    private TbPageContext mPageContext;
    protected View mRootView;
    protected UserData mUserData;

    public n(TbPageContext tbPageContext, boolean z) {
        this.gkQ = 0;
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.mIsHost = z;
        this.gkQ = com.baidu.adp.lib.util.l.h(this.mContext, e.C0141e.tbds46);
        am(aiP());
        TextView textView = this.gkr;
        if (this.mIsHost) {
        }
        textView.setVisibility(8);
    }

    public View aiP() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(e.h.item_person_polymeric_header_view, (ViewGroup) null);
        }
        return this.mRootView;
    }

    public void am(View view) {
        this.gku = view.findViewById(e.g.person_info_root);
        this.gkp = (PersonHeadPendantView) view.findViewById(e.g.person_polymeric_header_user_img);
        this.gkp.getHeadView().setCustomBigViewIconId(e.f.pic_v_avatar_big);
        this.gkp.getHeadView().setIconWidth(this.mContext.getResources().getDimensionPixelSize(e.C0141e.ds40));
        this.gkp.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gcR = (TbImageView) view.findViewById(e.g.person_polymeric_header_user_vip_icon);
        this.aBX = (TextView) view.findViewById(e.g.person_polymeric_header_user_name_txt);
        this.gks = (TextView) view.findViewById(e.g.seal_prefix_view);
        this.gkq = (UserIconBox) view.findViewById(e.g.person_polymeric_header_label_box);
        this.gkv = (TextView) view.findViewById(e.g.person_polymeric_header_bar_age_txt);
        this.bAP = (TextView) view.findViewById(e.g.person_polymeric_header_ala_id);
        this.gky = view.findViewById(e.g.divider_for_alaid_and_age);
        this.gkr = (TextView) view.findViewById(e.g.person_polymeric_header_visitor_txt);
        this.gkw = (TextView) view.findViewById(e.g.person_polymeric_header_sign_txt);
        this.gkx = (TextView) view.findViewById(e.g.person_center_header_tdou_txt);
        this.gkA = (TextView) view.findViewById(e.g.textview_get_tdou);
        this.gkB = view.findViewById(e.g.divider_for_age_and_tdou);
        this.gkC = view.findViewById(e.g.divider_for_tdou_and_get_tdou);
        this.gkD = (LinearLayout) view.findViewById(e.g.layout_user_name);
        this.gkE = (TextView) view.findViewById(e.g.person_praise_number);
        this.gkx.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(e.f.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
        this.gkt = (PersonHeaderAttentionView) view.findViewById(e.g.person_center_header_attention_container);
        bmf();
        this.gkF = new m(this.mContext);
        this.gcR.setOnClickListener(this.gkF);
        this.gkq.setOnClickListener(this.gkF);
        this.gkp.setOnClickListener(this.gkF);
        this.gkr.setOnClickListener(this.gkF);
        this.gks.setOnClickListener(this.gkF);
        this.gkx.setOnClickListener(this.gkF);
        this.gkA.setOnClickListener(this.gkF);
        this.aBX.setOnClickListener(this.gkF);
        this.gkw.setOnClickListener(this.gkF);
        this.gkG = (LinearLayout) view.findViewById(e.g.container_send_gift);
        this.gkH = (ImageView) view.findViewById(e.g.icon_gift);
        this.gkI = (TextView) view.findViewById(e.g.btn_give_gift);
        this.gkG.setOnClickListener(this.gkF);
        this.gkJ = (BlueLikeButton) view.findViewById(e.g.btn_like_blue);
        this.cEg = new com.baidu.tbadk.core.view.userLike.c(this.mPageContext, this.gkJ);
        this.cEg.setFromType("2");
        if (this.mIsHost) {
            this.gkG.setVisibility(8);
            this.gkJ.setVisibility(8);
        }
        this.gkK = (LinearLayout) view.findViewById(e.g.layout_god_auth_forums);
        this.gkK.setVisibility(8);
        this.ebn = view.findViewById(e.g.header_bottom_divider);
        this.gkL = (RelativeLayout) view.findViewById(e.g.layout_gift);
        this.gkL.setOnClickListener(this.gkF);
        this.gkM = view.findViewById(e.g.gift_top_divider);
        this.gkN = (TextView) view.findViewById(e.g.textview_received_gift);
        this.gkO = (TextView) view.findViewById(e.g.textview_received_gift_num);
        this.gko = (ImageView) view.findViewById(e.g.img_gift_arrow);
        this.gkP = (TextView) view.findViewById(e.g.btn_edit_person_info);
        this.gkP.setOnClickListener(this.gkF);
        if (!this.mIsHost) {
            this.gkP.setVisibility(8);
        }
    }

    public void e(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null) {
            this.gkm = aVar;
            this.mUserData = aVar.getUserData();
            this.gkF.a(aVar);
            this.gkF.setIsHost(this.mIsHost);
            String portrait = this.mUserData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                if (portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    this.gkp.getHeadView().startLoad(portrait, 10, false);
                } else {
                    String eN = com.baidu.tbadk.core.util.o.eN(portrait);
                    this.gkp.getHeadView().setUrl(eN);
                    this.gkp.getHeadView().startLoad(eN, 25, false);
                }
            } else {
                this.gkp.getHeadView().startLoad(String.valueOf(e.f.pic_mycenter_avatar_def_i), 24, false);
            }
            com.baidu.tbadk.data.j pendantData = this.mUserData.getPendantData();
            if (pendantData != null) {
                this.gkp.fF(pendantData.uW());
            }
            if (this.gkp.Bv()) {
                this.gkp.getHeadView().setShowV(false);
            } else if (this.mUserData.isBigV() || !StringUtils.isNull(this.mUserData.getUserTbVipInfoData().getvipV_url())) {
                this.gkp.getHeadView().setShowV(true);
            } else {
                this.gkp.getHeadView().setShowV(false);
            }
            UserVipInfoData userVipInfo = this.mUserData.getUserVipInfo();
            if (this.mUserData.getIsMem() > 0) {
                if (userVipInfo != null) {
                    this.gcR.startLoad(userVipInfo.getVipIconUrl(), 10, false);
                }
                this.gcR.setVisibility(0);
            } else if (this.mIsHost) {
                this.gcR.setImageDrawable(al.getDrawable(e.f.icon_crown_super_non));
                this.gcR.setVisibility(0);
            } else {
                this.gcR.setVisibility(8);
            }
            bkm();
            String name_show = this.mUserData.getName_show();
            if (!TextUtils.isEmpty(name_show)) {
                this.aBX.setText(name_show);
            }
            int i = e.f.icon_mine_boy;
            if (this.mUserData != null) {
                i = this.mUserData.getSex() == 2 ? e.f.icon_mine_girl : e.f.icon_mine_boy;
            }
            this.aBX.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mContext.getResources().getDrawable(i), (Drawable) null);
            this.gkq.a(this.mUserData.getIconInfo(), 9, this.mContext.getResources().getDimensionPixelSize(e.C0141e.tbds42), this.mContext.getResources().getDimensionPixelSize(e.C0141e.tbds42), this.mContext.getResources().getDimensionPixelSize(e.C0141e.tbds10), true);
            if (this.gkt != null) {
                this.gkt.setData(this.mUserData);
            }
            if (this.mUserData != null && this.mUserData.alaUserData != null && this.mUserData.alaUserData.ala_id != 0) {
                this.bAP.setVisibility(0);
                this.gky.setVisibility(0);
                this.bAP.setText(String.format(this.mContext.getString(e.j.person_center_ala_id), Long.valueOf(this.mUserData.alaUserData.ala_id)));
            } else {
                this.bAP.setVisibility(8);
                this.gky.setVisibility(8);
            }
            this.gkv.setText(String.format(this.mContext.getString(e.j.person_center_header_bar_age), this.mUserData.getTb_age()));
            if (this.mIsHost) {
                this.gkB.setVisibility(0);
                this.gkC.setVisibility(0);
                this.gkx.setVisibility(0);
                this.gkA.setVisibility(0);
                this.gkx.setText(ao.R(this.mUserData.getTDouNum()));
            } else {
                this.gkB.setVisibility(8);
                this.gkC.setVisibility(8);
                this.gkx.setVisibility(8);
                this.gkA.setVisibility(8);
            }
            String intro = this.mUserData.getIntro();
            if (StringUtils.isNull(intro)) {
                al.c(this.gkw, e.d.cp_cont_e, 1);
            } else {
                al.c(this.gkw, e.d.cp_cont_j, 1);
            }
            if (StringUtils.isNull(intro)) {
                if (this.mIsHost) {
                    intro = this.mContext.getString(e.j.no_person_sign_host);
                } else {
                    intro = this.mContext.getString(e.j.no_person_sign_guest);
                }
            }
            this.gkw.setText(this.mContext.getString(e.j.person_sign) + intro);
            if (this.gkw.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gkw.getLayoutParams();
                if (!this.mIsHost && this.gkw.getLineCount() >= 3 && this.gkw.getMaxLines() != 2147483646) {
                    int lineHeight = this.gkw.getLineHeight();
                    this.gkw.setHeight((lineHeight / 2) + (lineHeight * 3));
                }
                if (this.gkw.getLineCount() >= 2) {
                    layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(e.C0141e.tbds19);
                } else {
                    layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(e.C0141e.tbds80);
                }
                this.gkw.setLayoutParams(layoutParams);
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(this.mUserData.getUserId()) && ((!TbadkCoreApplication.isLogin() || (!StringUtils.isNull(currentAccount) && !currentAccount.equals(this.mUserData.getUserId()))) && this.mUserData.getLiveStatus() == 1)) {
                if (this.gkz == null) {
                    this.gkz = com.baidu.tbadk.ala.b.sB().i(this.mContext, 7);
                }
                com.baidu.tbadk.ala.a aVar2 = new com.baidu.tbadk.ala.a();
                aVar2.acu = this.mUserData.getAlaUserData();
                aVar2.type = 7;
                if ((this.mUserData.getPersonPrivate() != null && this.mUserData.getPersonPrivate().Im() == 3) || (this.mUserData.getPersonPrivate().Im() == 2 && this.mUserData.getIsFriend() != 1)) {
                    aVar2.acv = true;
                } else {
                    aVar2.acv = false;
                }
                if (this.gkz != null) {
                    this.gkz.setTag(aVar2);
                    if (this.gkz.getParent() == null) {
                        this.gkD.addView(this.gkz);
                        TiebaStatic.log(new am("c12541"));
                    }
                }
            } else if (this.gkz != null) {
                this.gkz.setVisibility(8);
            }
            a(aVar.gih);
            this.mUserData.setIsLike(this.mUserData.getHave_attention() == 1);
            this.cEg.a(this.mUserData);
            bmg();
            bmh();
            this.gkN.setText(this.mIsHost ? e.j.my_received_gift : e.j.he_received_gift);
            if ((this.mUserData.getPersonPrivate() == null || this.mUserData.getPersonPrivate().Im() != 3) && this.mUserData.getPersonPrivate().Im() == 2 && this.mUserData.getIsFriend() != 1) {
            }
        }
    }

    private void a(UserAgreeInfo userAgreeInfo) {
        if (userAgreeInfo == null) {
            this.gkE.setVisibility(8);
            return;
        }
        this.gkE.setVisibility(0);
        String L = ao.L(userAgreeInfo.total_agree_num.longValue());
        Drawable drawable = al.getDrawable(e.f.icon_home_card_like_s);
        drawable.setBounds(0, 0, this.gkQ, this.gkQ);
        this.gkE.setCompoundDrawables(drawable, null, null, null);
        this.gkE.setText(L);
    }

    public void onChangeSkinType(int i) {
        this.gku.setBackgroundDrawable(al.getDrawable(e.f.shape_user_info_bg));
        this.gkp.setBackgroundViewDrawable(al.getDrawable(e.f.shape_user_img_bg));
        int i2 = e.f.icon_mine_boy;
        if (this.mUserData != null) {
            i2 = this.mUserData.getSex() == 1 ? e.f.icon_mine_boy : e.f.icon_pop_girl;
        }
        if (this.mUserData != null && this.mUserData.getIsMem() <= 0 && this.gcR != null && this.mIsHost) {
            this.gcR.setImageDrawable(al.getDrawable(e.f.icon_crown_super_non));
        }
        bkm();
        al.c(this.gks, e.d.cp_link_tip_a, 1);
        this.aBX.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mContext.getResources().getDrawable(i2), (Drawable) null);
        if (this.gkt != null) {
            this.gkt.onChangeSkinType(i);
        }
        al.c(this.gkr, e.d.cp_cont_b, 1);
        al.c(this.gkv, e.d.cp_cont_b, 1);
        al.c(this.bAP, e.d.cp_cont_b, 1);
        if (this.mUserData == null || StringUtils.isNull(this.mUserData.getIntro())) {
            al.c(this.gkw, e.d.cp_cont_e, 1);
        } else {
            al.c(this.gkw, e.d.cp_cont_j, 1);
        }
        al.c(this.gkx, e.d.cp_cont_b, 1);
        al.c(this.gkA, e.d.cp_cont_b, 1);
        al.j(this.gkB, e.d.cp_bg_line_b);
        al.j(this.gky, e.d.cp_bg_line_b);
        al.j(this.gkC, e.d.cp_bg_line_b);
        al.h(this.gkE, e.d.cp_cont_h);
        this.gkx.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(e.f.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
        Drawable x = al.x(i, e.f.icon_home_card_like_s);
        x.setBounds(0, 0, this.gkQ, this.gkQ);
        this.gkE.setCompoundDrawables(x, null, null, null);
        al.i(this.gkG, e.f.selector_give_gift_bg);
        al.c(this.gkH, e.f.selector_gift_icon);
        al.c(this.gkI, e.d.selector_give_gift_text_color, 1);
        this.gkJ.onChangeSkinType(i);
        al.j(this.ebn, e.d.cp_bg_line_e);
        for (int i3 = 0; i3 < this.gkK.getChildCount(); i3++) {
            View childAt = this.gkK.getChildAt(i3);
            if (childAt != null) {
                TextView textView = (TextView) childAt.findViewById(e.g.bar_name);
                textView.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.pic_v_avatar), (Drawable) null, (Drawable) null, (Drawable) null);
                al.h(textView, e.d.cp_cont_b);
                al.h((TextView) childAt.findViewById(e.g.bar_info), e.d.cp_cont_j);
            }
        }
        for (int i4 = 0; i4 < gkn.length; i4++) {
            ((TbImageView) this.mRootView.findViewById(gkn[i4])).setBackgroundDrawable(al.getDrawable(e.f.shape_gift_icon_bg));
        }
        al.j(this.gkM, e.d.cp_bg_line_e);
        al.h(this.gkN, e.d.cp_cont_b);
        al.h(this.gkO, e.d.cp_cont_d);
        al.c(this.gko, e.f.icon_arrow_gray_right_n);
        al.i(this.gkP, e.f.selector_like_button_bg);
        al.c(this.gkP, e.d.cp_cont_g, 1);
    }

    public void onDestory() {
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.g gVar) {
        this.gkl = gVar;
        if (this.gkt != null) {
            this.gkt.setOnViewResponseListener(this.gkl);
        }
        this.gkF.setOnViewResponseListener(this.gkl);
    }

    public void sJ(String str) {
        this.gkp.fF(str);
        if (!StringUtils.isNull(str)) {
            this.gkp.getHeadView().setShowV(false);
        } else if (this.mUserData.isBigV() || !StringUtils.isNull(this.mUserData.getUserTbVipInfoData().getvipV_url())) {
            this.gkp.getHeadView().setShowV(true);
        } else {
            this.gkp.getHeadView().setShowV(false);
        }
    }

    protected void bmf() {
        this.gkp.setHasPendantStyle();
        this.gkp.getHeadView().setIsRound(true);
        this.gkp.getHeadView().setDrawBorder(false);
        this.gkp.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    protected void bkm() {
        if (this.mUserData != null && (this.mUserData.getIsMem() > 0 || this.mUserData.isBigV())) {
            al.c(this.aBX, e.d.cp_cont_h, 1);
        } else {
            al.c(this.aBX, e.d.cp_cont_b, 1);
        }
    }

    private void bmg() {
        if (this.gkm != null && this.gkm.bma() != null) {
            this.gkK.removeAllViews();
            int godType = this.gkm.bma().getGodType();
            if (godType == 2 && v.y(this.gkm.bma().getForumGodList()) > 0) {
                this.gkK.setVisibility(0);
                for (ForumGodDetailInfo forumGodDetailInfo : this.gkm.bma().getForumGodList()) {
                    if (forumGodDetailInfo != null) {
                        bZ(forumGodDetailInfo.forum_name, forumGodDetailInfo.intro);
                    }
                }
                return;
            } else if (godType == 1 && this.gkm.bma().getgodDetailInfo() != null && !StringUtils.isNull(this.gkm.bma().getgodDetailInfo().intro)) {
                this.gkK.setVisibility(0);
                bZ(this.gkm.bma().getgodDetailInfo().intro, "");
                return;
            } else {
                return;
            }
        }
        this.gkK.setVisibility(8);
    }

    private void bZ(String str, String str2) {
        View inflate = LayoutInflater.from(this.mContext).inflate(e.h.layout_god_auth_info, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(e.g.bar_name);
        textView.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.pic_v_avatar), (Drawable) null, (Drawable) null, (Drawable) null);
        al.h(textView, e.d.cp_cont_b);
        textView.setText(str);
        TextView textView2 = (TextView) inflate.findViewById(e.g.bar_info);
        al.h(textView2, e.d.cp_cont_j);
        textView2.setText(str2);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(e.C0141e.ds14);
        this.gkK.addView(inflate, layoutParams);
    }

    private void bmh() {
        int i;
        for (int i2 = 0; i2 < gkn.length; i2++) {
            ((TbImageView) this.mRootView.findViewById(gkn[i2])).setVisibility(8);
        }
        if (this.gkm == null || this.gkm.blZ() == null || v.y(this.gkm.blZ().giv) <= 0) {
            i = 0;
        } else {
            int i3 = this.gkm.blZ().giftNum;
            List<com.baidu.adp.widget.ListView.h> list = this.gkm.blZ().giv;
            for (int i4 = 0; i4 < list.size() && i4 < gkn.length; i4++) {
                if (list.get(i4) instanceof com.baidu.tieba.personPolymeric.c.o) {
                    TbImageView tbImageView = (TbImageView) this.mRootView.findViewById(gkn[i4]);
                    tbImageView.setVisibility(0);
                    tbImageView.setIsRound(true);
                    tbImageView.startLoad(((com.baidu.tieba.personPolymeric.c.o) list.get(i4)).picUrl, 10, false);
                }
            }
            i = i3;
        }
        this.gkO.setText(String.format(this.mContext.getResources().getString(e.j.gift_num), Integer.valueOf(i)));
    }
}
