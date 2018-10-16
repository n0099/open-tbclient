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
    private static final int[] grM = {e.g.img_gift_one, e.g.img_gift_two, e.g.img_gift_three};
    protected TextView aGD;
    private TextView bJx;
    private com.baidu.tbadk.core.view.userLike.c cMA;
    private View ejg;
    protected TbImageView gkt;
    protected com.baidu.tieba.view.g grK;
    protected com.baidu.tieba.personPolymeric.c.a grL;
    protected ImageView grN;
    protected PersonHeadPendantView grO;
    protected UserIconBox grP;
    protected TextView grQ;
    protected TextView grR;
    public com.baidu.tieba.view.e grS;
    protected View grT;
    private TextView grU;
    private TextView grV;
    private TextView grW;
    private View grX;
    private View grY;
    private TextView grZ;
    private View gsa;
    private View gsb;
    private LinearLayout gsc;
    private TextView gsd;
    private m gse;
    private View gsf;
    private ImageView gsg;
    private TextView gsh;
    private BlueLikeButton gsi;
    private LinearLayout gsj;
    private RelativeLayout gsk;
    private View gsl;
    private TextView gsm;
    private TextView gsn;
    private TextView gso;
    private int gsp;
    protected Context mContext;
    protected boolean mIsHost;
    private TbPageContext mPageContext;
    protected View mRootView;
    protected UserData mUserData;

    public n(TbPageContext tbPageContext, boolean z) {
        this.gsp = 0;
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.mIsHost = z;
        this.gsp = com.baidu.adp.lib.util.l.h(this.mContext, e.C0175e.tbds46);
        initView(amt());
        TextView textView = this.grQ;
        if (this.mIsHost) {
        }
        textView.setVisibility(8);
    }

    public View amt() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(e.h.item_person_polymeric_header_view, (ViewGroup) null);
        }
        return this.mRootView;
    }

    public void initView(View view) {
        this.grT = view.findViewById(e.g.person_info_root);
        this.grO = (PersonHeadPendantView) view.findViewById(e.g.person_polymeric_header_user_img);
        this.grO.getHeadView().setCustomBigViewIconId(e.f.pic_v_avatar_big);
        this.grO.getHeadView().setIconWidth(this.mContext.getResources().getDimensionPixelSize(e.C0175e.ds40));
        this.grO.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gkt = (TbImageView) view.findViewById(e.g.person_polymeric_header_user_vip_icon);
        this.aGD = (TextView) view.findViewById(e.g.person_polymeric_header_user_name_txt);
        this.grR = (TextView) view.findViewById(e.g.seal_prefix_view);
        this.grP = (UserIconBox) view.findViewById(e.g.person_polymeric_header_label_box);
        this.grU = (TextView) view.findViewById(e.g.person_polymeric_header_bar_age_txt);
        this.bJx = (TextView) view.findViewById(e.g.person_polymeric_header_ala_id);
        this.grX = view.findViewById(e.g.divider_for_alaid_and_age);
        this.grQ = (TextView) view.findViewById(e.g.person_polymeric_header_visitor_txt);
        this.grV = (TextView) view.findViewById(e.g.person_polymeric_header_sign_txt);
        this.grW = (TextView) view.findViewById(e.g.person_center_header_tdou_txt);
        this.grZ = (TextView) view.findViewById(e.g.textview_get_tdou);
        this.gsa = view.findViewById(e.g.divider_for_age_and_tdou);
        this.gsb = view.findViewById(e.g.divider_for_tdou_and_get_tdou);
        this.gsc = (LinearLayout) view.findViewById(e.g.layout_user_name);
        this.gsd = (TextView) view.findViewById(e.g.person_praise_number);
        this.grW.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(e.f.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
        this.grS = (PersonHeaderAttentionView) view.findViewById(e.g.person_center_header_attention_container);
        bpq();
        this.gse = new m(this.mContext);
        this.gkt.setOnClickListener(this.gse);
        this.grP.setOnClickListener(this.gse);
        this.grO.setOnClickListener(this.gse);
        this.grQ.setOnClickListener(this.gse);
        this.grR.setOnClickListener(this.gse);
        this.grW.setOnClickListener(this.gse);
        this.grZ.setOnClickListener(this.gse);
        this.aGD.setOnClickListener(this.gse);
        this.grV.setOnClickListener(this.gse);
        this.gsf = (LinearLayout) view.findViewById(e.g.container_send_gift);
        this.gsg = (ImageView) view.findViewById(e.g.icon_gift);
        this.gsh = (TextView) view.findViewById(e.g.btn_give_gift);
        this.gsf.setOnClickListener(this.gse);
        this.gsi = (BlueLikeButton) view.findViewById(e.g.btn_like_blue);
        this.cMA = new com.baidu.tbadk.core.view.userLike.c(this.mPageContext, this.gsi);
        this.cMA.setFromType("2");
        if (this.mIsHost) {
            this.gsf.setVisibility(8);
            this.gsi.setVisibility(8);
        }
        this.gsj = (LinearLayout) view.findViewById(e.g.layout_god_auth_forums);
        this.gsj.setVisibility(8);
        this.ejg = view.findViewById(e.g.header_bottom_divider);
        this.gsk = (RelativeLayout) view.findViewById(e.g.layout_gift);
        this.gsk.setOnClickListener(this.gse);
        this.gsl = view.findViewById(e.g.gift_top_divider);
        this.gsm = (TextView) view.findViewById(e.g.textview_received_gift);
        this.gsn = (TextView) view.findViewById(e.g.textview_received_gift_num);
        this.grN = (ImageView) view.findViewById(e.g.img_gift_arrow);
        this.gso = (TextView) view.findViewById(e.g.btn_edit_person_info);
        this.gso.setOnClickListener(this.gse);
        if (!this.mIsHost) {
            this.gso.setVisibility(8);
        }
    }

    public void e(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null) {
            this.grL = aVar;
            this.mUserData = aVar.getUserData();
            this.gse.a(aVar);
            this.gse.setIsHost(this.mIsHost);
            String portrait = this.mUserData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                if (portrait.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    this.grO.getHeadView().startLoad(portrait, 10, false);
                } else {
                    String fc = com.baidu.tbadk.core.util.o.fc(portrait);
                    this.grO.getHeadView().setUrl(fc);
                    this.grO.getHeadView().startLoad(fc, 25, false);
                }
            } else {
                this.grO.getHeadView().startLoad(String.valueOf(e.f.pic_mycenter_avatar_def_i), 24, false);
            }
            com.baidu.tbadk.data.j pendantData = this.mUserData.getPendantData();
            if (pendantData != null) {
                this.grO.fT(pendantData.xf());
            }
            if (this.grO.DB()) {
                this.grO.getHeadView().setShowV(false);
            } else if (this.mUserData.isBigV() || !StringUtils.isNull(this.mUserData.getUserTbVipInfoData().getvipV_url())) {
                this.grO.getHeadView().setShowV(true);
            } else {
                this.grO.getHeadView().setShowV(false);
            }
            UserVipInfoData userVipInfo = this.mUserData.getUserVipInfo();
            if (this.mUserData.getIsMem() > 0) {
                if (userVipInfo != null) {
                    this.gkt.startLoad(userVipInfo.getVipIconUrl(), 10, false);
                }
                this.gkt.setVisibility(0);
            } else if (this.mIsHost) {
                this.gkt.setImageDrawable(al.getDrawable(e.f.icon_crown_super_non));
                this.gkt.setVisibility(0);
            } else {
                this.gkt.setVisibility(8);
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
            this.grP.a(this.mUserData.getIconInfo(), 9, this.mContext.getResources().getDimensionPixelSize(e.C0175e.tbds42), this.mContext.getResources().getDimensionPixelSize(e.C0175e.tbds42), this.mContext.getResources().getDimensionPixelSize(e.C0175e.tbds10), true);
            if (this.grS != null) {
                this.grS.setData(this.mUserData);
            }
            if (this.mUserData != null && this.mUserData.alaUserData != null && this.mUserData.alaUserData.ala_id != 0) {
                this.bJx.setVisibility(0);
                this.grX.setVisibility(0);
                this.bJx.setText(String.format(this.mContext.getString(e.j.person_center_ala_id), Long.valueOf(this.mUserData.alaUserData.ala_id)));
            } else {
                this.bJx.setVisibility(8);
                this.grX.setVisibility(8);
            }
            this.grU.setText(String.format(this.mContext.getString(e.j.person_center_header_bar_age), this.mUserData.getTb_age()));
            if (this.mIsHost) {
                this.gsa.setVisibility(0);
                this.gsb.setVisibility(0);
                this.grW.setVisibility(0);
                this.grZ.setVisibility(0);
                this.grW.setText(ao.T(this.mUserData.getTDouNum()));
            } else {
                this.gsa.setVisibility(8);
                this.gsb.setVisibility(8);
                this.grW.setVisibility(8);
                this.grZ.setVisibility(8);
            }
            String intro = this.mUserData.getIntro();
            if (StringUtils.isNull(intro)) {
                al.c(this.grV, e.d.cp_cont_e, 1);
            } else {
                al.c(this.grV, e.d.cp_cont_j, 1);
            }
            if (StringUtils.isNull(intro)) {
                if (this.mIsHost) {
                    intro = this.mContext.getString(e.j.no_person_sign_host);
                } else {
                    intro = this.mContext.getString(e.j.no_person_sign_guest);
                }
            }
            this.grV.setText(this.mContext.getString(e.j.person_sign) + intro);
            if (this.grV.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.grV.getLayoutParams();
                if (!this.mIsHost && this.grV.getLineCount() >= 3 && this.grV.getMaxLines() != 2147483646) {
                    int lineHeight = this.grV.getLineHeight();
                    this.grV.setHeight((lineHeight / 2) + (lineHeight * 3));
                }
                if (this.grV.getLineCount() >= 2) {
                    layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(e.C0175e.tbds19);
                } else {
                    layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(e.C0175e.tbds80);
                }
                this.grV.setLayoutParams(layoutParams);
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(this.mUserData.getUserId()) && ((!TbadkCoreApplication.isLogin() || (!StringUtils.isNull(currentAccount) && !currentAccount.equals(this.mUserData.getUserId()))) && this.mUserData.getLiveStatus() == 1)) {
                if (this.grY == null) {
                    this.grY = com.baidu.tbadk.ala.b.uL().j(this.mContext, 7);
                }
                com.baidu.tbadk.ala.a aVar2 = new com.baidu.tbadk.ala.a();
                aVar2.aht = this.mUserData.getAlaUserData();
                aVar2.type = 7;
                if ((this.mUserData.getPersonPrivate() != null && this.mUserData.getPersonPrivate().Kl() == 3) || (this.mUserData.getPersonPrivate().Kl() == 2 && this.mUserData.getIsFriend() != 1)) {
                    aVar2.ahu = true;
                } else {
                    aVar2.ahu = false;
                }
                if (this.grY != null) {
                    this.grY.setTag(aVar2);
                    if (this.grY.getParent() == null) {
                        this.gsc.addView(this.grY);
                        TiebaStatic.log(new am("c12541"));
                    }
                }
            } else if (this.grY != null) {
                this.grY.setVisibility(8);
            }
            a(aVar.gpH);
            this.mUserData.setIsLike(this.mUserData.getHave_attention() == 1);
            this.cMA.a(this.mUserData);
            bpr();
            bps();
            this.gsm.setText(this.mIsHost ? e.j.my_received_gift : e.j.he_received_gift);
            if ((this.mUserData.getPersonPrivate() == null || this.mUserData.getPersonPrivate().Kl() != 3) && this.mUserData.getPersonPrivate().Kl() == 2 && this.mUserData.getIsFriend() != 1) {
            }
        }
    }

    private void a(UserAgreeInfo userAgreeInfo) {
        if (userAgreeInfo == null) {
            this.gsd.setVisibility(8);
            return;
        }
        this.gsd.setVisibility(0);
        String N = ao.N(userAgreeInfo.total_agree_num.longValue());
        Drawable drawable = al.getDrawable(e.f.icon_home_card_like_s);
        drawable.setBounds(0, 0, this.gsp, this.gsp);
        this.gsd.setCompoundDrawables(drawable, null, null, null);
        this.gsd.setText(N);
    }

    public void onChangeSkinType(int i) {
        this.grT.setBackgroundDrawable(al.getDrawable(e.f.shape_user_info_bg));
        this.grO.setBackgroundViewDrawable(al.getDrawable(e.f.shape_user_img_bg));
        int i2 = e.f.icon_mine_boy;
        if (this.mUserData != null) {
            i2 = this.mUserData.getSex() == 1 ? e.f.icon_mine_boy : e.f.icon_pop_girl;
        }
        if (this.mUserData != null && this.mUserData.getIsMem() <= 0 && this.gkt != null && this.mIsHost) {
            this.gkt.setImageDrawable(al.getDrawable(e.f.icon_crown_super_non));
        }
        bnx();
        al.c(this.grR, e.d.cp_link_tip_a, 1);
        this.aGD.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mContext.getResources().getDrawable(i2), (Drawable) null);
        if (this.grS != null) {
            this.grS.onChangeSkinType(i);
        }
        al.c(this.grQ, e.d.cp_cont_b, 1);
        al.c(this.grU, e.d.cp_cont_b, 1);
        al.c(this.bJx, e.d.cp_cont_b, 1);
        if (this.mUserData == null || StringUtils.isNull(this.mUserData.getIntro())) {
            al.c(this.grV, e.d.cp_cont_e, 1);
        } else {
            al.c(this.grV, e.d.cp_cont_j, 1);
        }
        al.c(this.grW, e.d.cp_cont_b, 1);
        al.c(this.grZ, e.d.cp_cont_b, 1);
        al.j(this.gsa, e.d.cp_bg_line_b);
        al.j(this.grX, e.d.cp_bg_line_b);
        al.j(this.gsb, e.d.cp_bg_line_b);
        al.h(this.gsd, e.d.cp_cont_h);
        this.grW.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(e.f.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
        Drawable x = al.x(i, e.f.icon_home_card_like_s);
        x.setBounds(0, 0, this.gsp, this.gsp);
        this.gsd.setCompoundDrawables(x, null, null, null);
        al.i(this.gsf, e.f.selector_give_gift_bg);
        al.c(this.gsg, e.f.selector_gift_icon);
        al.c(this.gsh, e.d.selector_give_gift_text_color, 1);
        this.gsi.onChangeSkinType(i);
        al.j(this.ejg, e.d.cp_bg_line_e);
        for (int i3 = 0; i3 < this.gsj.getChildCount(); i3++) {
            View childAt = this.gsj.getChildAt(i3);
            if (childAt != null) {
                TextView textView = (TextView) childAt.findViewById(e.g.bar_name);
                textView.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.pic_v_avatar), (Drawable) null, (Drawable) null, (Drawable) null);
                al.h(textView, e.d.cp_cont_b);
                al.h((TextView) childAt.findViewById(e.g.bar_info), e.d.cp_cont_j);
            }
        }
        for (int i4 = 0; i4 < grM.length; i4++) {
            ((TbImageView) this.mRootView.findViewById(grM[i4])).setBackgroundDrawable(al.getDrawable(e.f.shape_gift_icon_bg));
        }
        al.j(this.gsl, e.d.cp_bg_line_e);
        al.h(this.gsm, e.d.cp_cont_b);
        al.h(this.gsn, e.d.cp_cont_d);
        al.c(this.grN, e.f.icon_arrow_gray_right_n);
        al.i(this.gso, e.f.selector_like_button_bg);
        al.c(this.gso, e.d.cp_cont_g, 1);
    }

    public void onDestory() {
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.g gVar) {
        this.grK = gVar;
        if (this.grS != null) {
            this.grS.setOnViewResponseListener(this.grK);
        }
        this.gse.setOnViewResponseListener(this.grK);
    }

    public void tj(String str) {
        this.grO.fT(str);
        if (!StringUtils.isNull(str)) {
            this.grO.getHeadView().setShowV(false);
        } else if (this.mUserData.isBigV() || !StringUtils.isNull(this.mUserData.getUserTbVipInfoData().getvipV_url())) {
            this.grO.getHeadView().setShowV(true);
        } else {
            this.grO.getHeadView().setShowV(false);
        }
    }

    protected void bpq() {
        this.grO.setHasPendantStyle();
        this.grO.getHeadView().setIsRound(true);
        this.grO.getHeadView().setDrawBorder(false);
        this.grO.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    protected void bnx() {
        if (this.mUserData != null && (this.mUserData.getIsMem() > 0 || this.mUserData.isBigV())) {
            al.c(this.aGD, e.d.cp_cont_h, 1);
        } else {
            al.c(this.aGD, e.d.cp_cont_b, 1);
        }
    }

    private void bpr() {
        if (this.grL != null && this.grL.bpl() != null) {
            this.gsj.removeAllViews();
            int godType = this.grL.bpl().getGodType();
            if (godType == 2 && v.I(this.grL.bpl().getForumGodList()) > 0) {
                this.gsj.setVisibility(0);
                for (ForumGodDetailInfo forumGodDetailInfo : this.grL.bpl().getForumGodList()) {
                    if (forumGodDetailInfo != null) {
                        cl(forumGodDetailInfo.forum_name, forumGodDetailInfo.intro);
                    }
                }
                return;
            } else if (godType == 1 && this.grL.bpl().getgodDetailInfo() != null && !StringUtils.isNull(this.grL.bpl().getgodDetailInfo().intro)) {
                this.gsj.setVisibility(0);
                cl(this.grL.bpl().getgodDetailInfo().intro, "");
                return;
            } else {
                return;
            }
        }
        this.gsj.setVisibility(8);
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
        this.gsj.addView(inflate, layoutParams);
    }

    private void bps() {
        int i;
        for (int i2 = 0; i2 < grM.length; i2++) {
            ((TbImageView) this.mRootView.findViewById(grM[i2])).setVisibility(8);
        }
        if (this.grL == null || this.grL.bpk() == null || v.I(this.grL.bpk().gpV) <= 0) {
            i = 0;
        } else {
            int i3 = this.grL.bpk().giftNum;
            List<com.baidu.adp.widget.ListView.h> list = this.grL.bpk().gpV;
            for (int i4 = 0; i4 < list.size() && i4 < grM.length; i4++) {
                if (list.get(i4) instanceof com.baidu.tieba.personPolymeric.c.o) {
                    TbImageView tbImageView = (TbImageView) this.mRootView.findViewById(grM[i4]);
                    tbImageView.setVisibility(0);
                    tbImageView.setIsRound(true);
                    tbImageView.startLoad(((com.baidu.tieba.personPolymeric.c.o) list.get(i4)).picUrl, 10, false);
                }
            }
            i = i3;
        }
        this.gsn.setText(String.format(this.mContext.getResources().getString(e.j.gift_num), Integer.valueOf(i)));
    }
}
