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
    private static final int[] grN = {e.g.img_gift_one, e.g.img_gift_two, e.g.img_gift_three};
    protected TextView aGD;
    private TextView bJx;
    private com.baidu.tbadk.core.view.userLike.c cMA;
    private View ejh;
    protected TbImageView gku;
    protected com.baidu.tieba.view.g grL;
    protected com.baidu.tieba.personPolymeric.c.a grM;
    protected ImageView grO;
    protected PersonHeadPendantView grP;
    protected UserIconBox grQ;
    protected TextView grR;
    protected TextView grS;
    public com.baidu.tieba.view.e grT;
    protected View grU;
    private TextView grV;
    private TextView grW;
    private TextView grX;
    private View grY;
    private View grZ;
    private TextView gsa;
    private View gsb;
    private View gsc;
    private LinearLayout gsd;
    private TextView gse;
    private m gsf;
    private View gsg;
    private ImageView gsh;
    private TextView gsi;
    private BlueLikeButton gsj;
    private LinearLayout gsk;
    private RelativeLayout gsl;
    private View gsm;
    private TextView gsn;
    private TextView gso;
    private TextView gsp;
    private int gsq;
    protected Context mContext;
    protected boolean mIsHost;
    private TbPageContext mPageContext;
    protected View mRootView;
    protected UserData mUserData;

    public n(TbPageContext tbPageContext, boolean z) {
        this.gsq = 0;
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.mIsHost = z;
        this.gsq = com.baidu.adp.lib.util.l.h(this.mContext, e.C0175e.tbds46);
        initView(amu());
        TextView textView = this.grR;
        if (this.mIsHost) {
        }
        textView.setVisibility(8);
    }

    public View amu() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(e.h.item_person_polymeric_header_view, (ViewGroup) null);
        }
        return this.mRootView;
    }

    public void initView(View view) {
        this.grU = view.findViewById(e.g.person_info_root);
        this.grP = (PersonHeadPendantView) view.findViewById(e.g.person_polymeric_header_user_img);
        this.grP.getHeadView().setCustomBigViewIconId(e.f.pic_v_avatar_big);
        this.grP.getHeadView().setIconWidth(this.mContext.getResources().getDimensionPixelSize(e.C0175e.ds40));
        this.grP.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gku = (TbImageView) view.findViewById(e.g.person_polymeric_header_user_vip_icon);
        this.aGD = (TextView) view.findViewById(e.g.person_polymeric_header_user_name_txt);
        this.grS = (TextView) view.findViewById(e.g.seal_prefix_view);
        this.grQ = (UserIconBox) view.findViewById(e.g.person_polymeric_header_label_box);
        this.grV = (TextView) view.findViewById(e.g.person_polymeric_header_bar_age_txt);
        this.bJx = (TextView) view.findViewById(e.g.person_polymeric_header_ala_id);
        this.grY = view.findViewById(e.g.divider_for_alaid_and_age);
        this.grR = (TextView) view.findViewById(e.g.person_polymeric_header_visitor_txt);
        this.grW = (TextView) view.findViewById(e.g.person_polymeric_header_sign_txt);
        this.grX = (TextView) view.findViewById(e.g.person_center_header_tdou_txt);
        this.gsa = (TextView) view.findViewById(e.g.textview_get_tdou);
        this.gsb = view.findViewById(e.g.divider_for_age_and_tdou);
        this.gsc = view.findViewById(e.g.divider_for_tdou_and_get_tdou);
        this.gsd = (LinearLayout) view.findViewById(e.g.layout_user_name);
        this.gse = (TextView) view.findViewById(e.g.person_praise_number);
        this.grX.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(e.f.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
        this.grT = (PersonHeaderAttentionView) view.findViewById(e.g.person_center_header_attention_container);
        bpq();
        this.gsf = new m(this.mContext);
        this.gku.setOnClickListener(this.gsf);
        this.grQ.setOnClickListener(this.gsf);
        this.grP.setOnClickListener(this.gsf);
        this.grR.setOnClickListener(this.gsf);
        this.grS.setOnClickListener(this.gsf);
        this.grX.setOnClickListener(this.gsf);
        this.gsa.setOnClickListener(this.gsf);
        this.aGD.setOnClickListener(this.gsf);
        this.grW.setOnClickListener(this.gsf);
        this.gsg = (LinearLayout) view.findViewById(e.g.container_send_gift);
        this.gsh = (ImageView) view.findViewById(e.g.icon_gift);
        this.gsi = (TextView) view.findViewById(e.g.btn_give_gift);
        this.gsg.setOnClickListener(this.gsf);
        this.gsj = (BlueLikeButton) view.findViewById(e.g.btn_like_blue);
        this.cMA = new com.baidu.tbadk.core.view.userLike.c(this.mPageContext, this.gsj);
        this.cMA.setFromType("2");
        if (this.mIsHost) {
            this.gsg.setVisibility(8);
            this.gsj.setVisibility(8);
        }
        this.gsk = (LinearLayout) view.findViewById(e.g.layout_god_auth_forums);
        this.gsk.setVisibility(8);
        this.ejh = view.findViewById(e.g.header_bottom_divider);
        this.gsl = (RelativeLayout) view.findViewById(e.g.layout_gift);
        this.gsl.setOnClickListener(this.gsf);
        this.gsm = view.findViewById(e.g.gift_top_divider);
        this.gsn = (TextView) view.findViewById(e.g.textview_received_gift);
        this.gso = (TextView) view.findViewById(e.g.textview_received_gift_num);
        this.grO = (ImageView) view.findViewById(e.g.img_gift_arrow);
        this.gsp = (TextView) view.findViewById(e.g.btn_edit_person_info);
        this.gsp.setOnClickListener(this.gsf);
        if (!this.mIsHost) {
            this.gsp.setVisibility(8);
        }
    }

    public void e(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null) {
            this.grM = aVar;
            this.mUserData = aVar.getUserData();
            this.gsf.a(aVar);
            this.gsf.setIsHost(this.mIsHost);
            String portrait = this.mUserData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                if (portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    this.grP.getHeadView().startLoad(portrait, 10, false);
                } else {
                    String fc = com.baidu.tbadk.core.util.o.fc(portrait);
                    this.grP.getHeadView().setUrl(fc);
                    this.grP.getHeadView().startLoad(fc, 25, false);
                }
            } else {
                this.grP.getHeadView().startLoad(String.valueOf(e.f.pic_mycenter_avatar_def_i), 24, false);
            }
            com.baidu.tbadk.data.j pendantData = this.mUserData.getPendantData();
            if (pendantData != null) {
                this.grP.fT(pendantData.xf());
            }
            if (this.grP.DB()) {
                this.grP.getHeadView().setShowV(false);
            } else if (this.mUserData.isBigV() || !StringUtils.isNull(this.mUserData.getUserTbVipInfoData().getvipV_url())) {
                this.grP.getHeadView().setShowV(true);
            } else {
                this.grP.getHeadView().setShowV(false);
            }
            UserVipInfoData userVipInfo = this.mUserData.getUserVipInfo();
            if (this.mUserData.getIsMem() > 0) {
                if (userVipInfo != null) {
                    this.gku.startLoad(userVipInfo.getVipIconUrl(), 10, false);
                }
                this.gku.setVisibility(0);
            } else if (this.mIsHost) {
                this.gku.setImageDrawable(al.getDrawable(e.f.icon_crown_super_non));
                this.gku.setVisibility(0);
            } else {
                this.gku.setVisibility(8);
            }
            bnx();
            String name_show = this.mUserData.getName_show();
            if (!TextUtils.isEmpty(name_show)) {
                this.aGD.setText(name_show);
            }
            int i = e.f.icon_mine_boy;
            if (this.mUserData != null) {
                i = this.mUserData.getSex() == 2 ? e.f.icon_mine_girl : e.f.icon_mine_boy;
            }
            this.aGD.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mContext.getResources().getDrawable(i), (Drawable) null);
            this.grQ.a(this.mUserData.getIconInfo(), 9, this.mContext.getResources().getDimensionPixelSize(e.C0175e.tbds42), this.mContext.getResources().getDimensionPixelSize(e.C0175e.tbds42), this.mContext.getResources().getDimensionPixelSize(e.C0175e.tbds10), true);
            if (this.grT != null) {
                this.grT.setData(this.mUserData);
            }
            if (this.mUserData != null && this.mUserData.alaUserData != null && this.mUserData.alaUserData.ala_id != 0) {
                this.bJx.setVisibility(0);
                this.grY.setVisibility(0);
                this.bJx.setText(String.format(this.mContext.getString(e.j.person_center_ala_id), Long.valueOf(this.mUserData.alaUserData.ala_id)));
            } else {
                this.bJx.setVisibility(8);
                this.grY.setVisibility(8);
            }
            this.grV.setText(String.format(this.mContext.getString(e.j.person_center_header_bar_age), this.mUserData.getTb_age()));
            if (this.mIsHost) {
                this.gsb.setVisibility(0);
                this.gsc.setVisibility(0);
                this.grX.setVisibility(0);
                this.gsa.setVisibility(0);
                this.grX.setText(ao.T(this.mUserData.getTDouNum()));
            } else {
                this.gsb.setVisibility(8);
                this.gsc.setVisibility(8);
                this.grX.setVisibility(8);
                this.gsa.setVisibility(8);
            }
            String intro = this.mUserData.getIntro();
            if (StringUtils.isNull(intro)) {
                al.c(this.grW, e.d.cp_cont_e, 1);
            } else {
                al.c(this.grW, e.d.cp_cont_j, 1);
            }
            if (StringUtils.isNull(intro)) {
                if (this.mIsHost) {
                    intro = this.mContext.getString(e.j.no_person_sign_host);
                } else {
                    intro = this.mContext.getString(e.j.no_person_sign_guest);
                }
            }
            this.grW.setText(this.mContext.getString(e.j.person_sign) + intro);
            if (this.grW.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.grW.getLayoutParams();
                if (!this.mIsHost && this.grW.getLineCount() >= 3 && this.grW.getMaxLines() != 2147483646) {
                    int lineHeight = this.grW.getLineHeight();
                    this.grW.setHeight((lineHeight / 2) + (lineHeight * 3));
                }
                if (this.grW.getLineCount() >= 2) {
                    layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(e.C0175e.tbds19);
                } else {
                    layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(e.C0175e.tbds80);
                }
                this.grW.setLayoutParams(layoutParams);
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(this.mUserData.getUserId()) && ((!TbadkCoreApplication.isLogin() || (!StringUtils.isNull(currentAccount) && !currentAccount.equals(this.mUserData.getUserId()))) && this.mUserData.getLiveStatus() == 1)) {
                if (this.grZ == null) {
                    this.grZ = com.baidu.tbadk.ala.b.uL().j(this.mContext, 7);
                }
                com.baidu.tbadk.ala.a aVar2 = new com.baidu.tbadk.ala.a();
                aVar2.aht = this.mUserData.getAlaUserData();
                aVar2.type = 7;
                if ((this.mUserData.getPersonPrivate() != null && this.mUserData.getPersonPrivate().Kl() == 3) || (this.mUserData.getPersonPrivate().Kl() == 2 && this.mUserData.getIsFriend() != 1)) {
                    aVar2.ahu = true;
                } else {
                    aVar2.ahu = false;
                }
                if (this.grZ != null) {
                    this.grZ.setTag(aVar2);
                    if (this.grZ.getParent() == null) {
                        this.gsd.addView(this.grZ);
                        TiebaStatic.log(new am("c12541"));
                    }
                }
            } else if (this.grZ != null) {
                this.grZ.setVisibility(8);
            }
            a(aVar.gpI);
            this.mUserData.setIsLike(this.mUserData.getHave_attention() == 1);
            this.cMA.a(this.mUserData);
            bpr();
            bps();
            this.gsn.setText(this.mIsHost ? e.j.my_received_gift : e.j.he_received_gift);
            if ((this.mUserData.getPersonPrivate() == null || this.mUserData.getPersonPrivate().Kl() != 3) && this.mUserData.getPersonPrivate().Kl() == 2 && this.mUserData.getIsFriend() != 1) {
            }
        }
    }

    private void a(UserAgreeInfo userAgreeInfo) {
        if (userAgreeInfo == null) {
            this.gse.setVisibility(8);
            return;
        }
        this.gse.setVisibility(0);
        String N = ao.N(userAgreeInfo.total_agree_num.longValue());
        Drawable drawable = al.getDrawable(e.f.icon_home_card_like_s);
        drawable.setBounds(0, 0, this.gsq, this.gsq);
        this.gse.setCompoundDrawables(drawable, null, null, null);
        this.gse.setText(N);
    }

    public void onChangeSkinType(int i) {
        this.grU.setBackgroundDrawable(al.getDrawable(e.f.shape_user_info_bg));
        this.grP.setBackgroundViewDrawable(al.getDrawable(e.f.shape_user_img_bg));
        int i2 = e.f.icon_mine_boy;
        if (this.mUserData != null) {
            i2 = this.mUserData.getSex() == 1 ? e.f.icon_mine_boy : e.f.icon_pop_girl;
        }
        if (this.mUserData != null && this.mUserData.getIsMem() <= 0 && this.gku != null && this.mIsHost) {
            this.gku.setImageDrawable(al.getDrawable(e.f.icon_crown_super_non));
        }
        bnx();
        al.c(this.grS, e.d.cp_link_tip_a, 1);
        this.aGD.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mContext.getResources().getDrawable(i2), (Drawable) null);
        if (this.grT != null) {
            this.grT.onChangeSkinType(i);
        }
        al.c(this.grR, e.d.cp_cont_b, 1);
        al.c(this.grV, e.d.cp_cont_b, 1);
        al.c(this.bJx, e.d.cp_cont_b, 1);
        if (this.mUserData == null || StringUtils.isNull(this.mUserData.getIntro())) {
            al.c(this.grW, e.d.cp_cont_e, 1);
        } else {
            al.c(this.grW, e.d.cp_cont_j, 1);
        }
        al.c(this.grX, e.d.cp_cont_b, 1);
        al.c(this.gsa, e.d.cp_cont_b, 1);
        al.j(this.gsb, e.d.cp_bg_line_b);
        al.j(this.grY, e.d.cp_bg_line_b);
        al.j(this.gsc, e.d.cp_bg_line_b);
        al.h(this.gse, e.d.cp_cont_h);
        this.grX.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(e.f.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
        Drawable x = al.x(i, e.f.icon_home_card_like_s);
        x.setBounds(0, 0, this.gsq, this.gsq);
        this.gse.setCompoundDrawables(x, null, null, null);
        al.i(this.gsg, e.f.selector_give_gift_bg);
        al.c(this.gsh, e.f.selector_gift_icon);
        al.c(this.gsi, e.d.selector_give_gift_text_color, 1);
        this.gsj.onChangeSkinType(i);
        al.j(this.ejh, e.d.cp_bg_line_e);
        for (int i3 = 0; i3 < this.gsk.getChildCount(); i3++) {
            View childAt = this.gsk.getChildAt(i3);
            if (childAt != null) {
                TextView textView = (TextView) childAt.findViewById(e.g.bar_name);
                textView.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.pic_v_avatar), (Drawable) null, (Drawable) null, (Drawable) null);
                al.h(textView, e.d.cp_cont_b);
                al.h((TextView) childAt.findViewById(e.g.bar_info), e.d.cp_cont_j);
            }
        }
        for (int i4 = 0; i4 < grN.length; i4++) {
            ((TbImageView) this.mRootView.findViewById(grN[i4])).setBackgroundDrawable(al.getDrawable(e.f.shape_gift_icon_bg));
        }
        al.j(this.gsm, e.d.cp_bg_line_e);
        al.h(this.gsn, e.d.cp_cont_b);
        al.h(this.gso, e.d.cp_cont_d);
        al.c(this.grO, e.f.icon_arrow_gray_right_n);
        al.i(this.gsp, e.f.selector_like_button_bg);
        al.c(this.gsp, e.d.cp_cont_g, 1);
    }

    public void onDestory() {
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.g gVar) {
        this.grL = gVar;
        if (this.grT != null) {
            this.grT.setOnViewResponseListener(this.grL);
        }
        this.gsf.setOnViewResponseListener(this.grL);
    }

    public void tj(String str) {
        this.grP.fT(str);
        if (!StringUtils.isNull(str)) {
            this.grP.getHeadView().setShowV(false);
        } else if (this.mUserData.isBigV() || !StringUtils.isNull(this.mUserData.getUserTbVipInfoData().getvipV_url())) {
            this.grP.getHeadView().setShowV(true);
        } else {
            this.grP.getHeadView().setShowV(false);
        }
    }

    protected void bpq() {
        this.grP.setHasPendantStyle();
        this.grP.getHeadView().setIsRound(true);
        this.grP.getHeadView().setDrawBorder(false);
        this.grP.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    protected void bnx() {
        if (this.mUserData != null && (this.mUserData.getIsMem() > 0 || this.mUserData.isBigV())) {
            al.c(this.aGD, e.d.cp_cont_h, 1);
        } else {
            al.c(this.aGD, e.d.cp_cont_b, 1);
        }
    }

    private void bpr() {
        if (this.grM != null && this.grM.bpl() != null) {
            this.gsk.removeAllViews();
            int godType = this.grM.bpl().getGodType();
            if (godType == 2 && v.I(this.grM.bpl().getForumGodList()) > 0) {
                this.gsk.setVisibility(0);
                for (ForumGodDetailInfo forumGodDetailInfo : this.grM.bpl().getForumGodList()) {
                    if (forumGodDetailInfo != null) {
                        cl(forumGodDetailInfo.forum_name, forumGodDetailInfo.intro);
                    }
                }
                return;
            } else if (godType == 1 && this.grM.bpl().getgodDetailInfo() != null && !StringUtils.isNull(this.grM.bpl().getgodDetailInfo().intro)) {
                this.gsk.setVisibility(0);
                cl(this.grM.bpl().getgodDetailInfo().intro, "");
                return;
            } else {
                return;
            }
        }
        this.gsk.setVisibility(8);
    }

    private void cl(String str, String str2) {
        View inflate = LayoutInflater.from(this.mContext).inflate(e.h.layout_god_auth_info, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(e.g.bar_name);
        textView.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.pic_v_avatar), (Drawable) null, (Drawable) null, (Drawable) null);
        al.h(textView, e.d.cp_cont_b);
        textView.setText(str);
        TextView textView2 = (TextView) inflate.findViewById(e.g.bar_info);
        al.h(textView2, e.d.cp_cont_j);
        textView2.setText(str2);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(e.C0175e.ds14);
        this.gsk.addView(inflate, layoutParams);
    }

    private void bps() {
        int i;
        for (int i2 = 0; i2 < grN.length; i2++) {
            ((TbImageView) this.mRootView.findViewById(grN[i2])).setVisibility(8);
        }
        if (this.grM == null || this.grM.bpk() == null || v.I(this.grM.bpk().gpW) <= 0) {
            i = 0;
        } else {
            int i3 = this.grM.bpk().giftNum;
            List<com.baidu.adp.widget.ListView.h> list = this.grM.bpk().gpW;
            for (int i4 = 0; i4 < list.size() && i4 < grN.length; i4++) {
                if (list.get(i4) instanceof com.baidu.tieba.personPolymeric.c.o) {
                    TbImageView tbImageView = (TbImageView) this.mRootView.findViewById(grN[i4]);
                    tbImageView.setVisibility(0);
                    tbImageView.setIsRound(true);
                    tbImageView.startLoad(((com.baidu.tieba.personPolymeric.c.o) list.get(i4)).picUrl, 10, false);
                }
            }
            i = i3;
        }
        this.gso.setText(String.format(this.mContext.getResources().getString(e.j.gift_num), Integer.valueOf(i)));
    }
}
