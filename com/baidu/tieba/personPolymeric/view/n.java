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
import tbclient.Profile.ForumGodDetailInfo;
import tbclient.Profile.UserAgreeInfo;
/* loaded from: classes3.dex */
public class n {
    private static final int[] gtn = {e.g.img_gift_one, e.g.img_gift_two, e.g.img_gift_three};
    protected TextView aHt;
    private TextView bKi;
    private com.baidu.tbadk.core.view.userLike.c cNG;
    private View ekB;
    protected TbImageView glT;
    private TextView gtA;
    private View gtB;
    private View gtC;
    private LinearLayout gtD;
    private TextView gtE;
    private m gtF;
    private View gtG;
    private ImageView gtH;
    private TextView gtI;
    private BlueLikeButton gtJ;
    private LinearLayout gtK;
    private RelativeLayout gtL;
    private View gtM;
    private TextView gtN;
    private TextView gtO;
    private TextView gtP;
    private int gtQ;
    protected com.baidu.tieba.view.g gtl;
    protected com.baidu.tieba.personPolymeric.c.a gtm;
    protected ImageView gto;
    protected PersonHeadPendantView gtp;
    protected UserIconBox gtq;
    protected TextView gtr;
    protected TextView gts;
    public com.baidu.tieba.view.e gtt;
    protected View gtu;
    private TextView gtv;
    private TextView gtw;
    private TextView gtx;
    private View gty;
    private View gtz;
    protected Context mContext;
    protected boolean mIsHost;
    private TbPageContext mPageContext;
    protected View mRootView;
    protected UserData mUserData;

    public n(TbPageContext tbPageContext, boolean z) {
        this.gtQ = 0;
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.mIsHost = z;
        this.gtQ = com.baidu.adp.lib.util.l.h(this.mContext, e.C0200e.tbds46);
        initView(alT());
        TextView textView = this.gtr;
        if (this.mIsHost) {
        }
        textView.setVisibility(8);
    }

    public View alT() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(e.h.item_person_polymeric_header_view, (ViewGroup) null);
        }
        return this.mRootView;
    }

    public void initView(View view) {
        this.gtu = view.findViewById(e.g.person_info_root);
        this.gtp = (PersonHeadPendantView) view.findViewById(e.g.person_polymeric_header_user_img);
        this.gtp.getHeadView().setGodIconResId(e.f.pic_v_avatar_big);
        this.gtp.getHeadView().setGodIconWidth(e.C0200e.ds40);
        this.gtp.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gtp.setDefalutResid(e.f.pic_mycenter_avatar_def_i);
        this.gtp.setBigVIconResId(e.f.pic_v_avatar_big);
        this.gtp.setBigVDimenSize(e.C0200e.ds40);
        this.glT = (TbImageView) view.findViewById(e.g.person_polymeric_header_user_vip_icon);
        this.aHt = (TextView) view.findViewById(e.g.person_polymeric_header_user_name_txt);
        this.gts = (TextView) view.findViewById(e.g.seal_prefix_view);
        this.gtq = (UserIconBox) view.findViewById(e.g.person_polymeric_header_label_box);
        this.gtv = (TextView) view.findViewById(e.g.person_polymeric_header_bar_age_txt);
        this.bKi = (TextView) view.findViewById(e.g.person_polymeric_header_ala_id);
        this.gty = view.findViewById(e.g.divider_for_alaid_and_age);
        this.gtr = (TextView) view.findViewById(e.g.person_polymeric_header_visitor_txt);
        this.gtw = (TextView) view.findViewById(e.g.person_polymeric_header_sign_txt);
        this.gtx = (TextView) view.findViewById(e.g.person_center_header_tdou_txt);
        this.gtA = (TextView) view.findViewById(e.g.textview_get_tdou);
        this.gtB = view.findViewById(e.g.divider_for_age_and_tdou);
        this.gtC = view.findViewById(e.g.divider_for_tdou_and_get_tdou);
        this.gtD = (LinearLayout) view.findViewById(e.g.layout_user_name);
        this.gtE = (TextView) view.findViewById(e.g.person_praise_number);
        this.gtx.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(e.f.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
        this.gtt = (PersonHeaderAttentionView) view.findViewById(e.g.person_center_header_attention_container);
        boL();
        this.gtF = new m(this.mContext);
        this.glT.setOnClickListener(this.gtF);
        this.gtq.setOnClickListener(this.gtF);
        this.gtp.setOnClickListener(this.gtF);
        this.gtr.setOnClickListener(this.gtF);
        this.gts.setOnClickListener(this.gtF);
        this.gtx.setOnClickListener(this.gtF);
        this.gtA.setOnClickListener(this.gtF);
        this.aHt.setOnClickListener(this.gtF);
        this.gtw.setOnClickListener(this.gtF);
        this.gtG = (LinearLayout) view.findViewById(e.g.container_send_gift);
        this.gtH = (ImageView) view.findViewById(e.g.icon_gift);
        this.gtI = (TextView) view.findViewById(e.g.btn_give_gift);
        this.gtG.setOnClickListener(this.gtF);
        this.gtJ = (BlueLikeButton) view.findViewById(e.g.btn_like_blue);
        this.cNG = new com.baidu.tbadk.core.view.userLike.c(this.mPageContext, this.gtJ);
        this.cNG.setFromType("2");
        if (this.mIsHost) {
            this.gtG.setVisibility(8);
            this.gtJ.setVisibility(8);
        }
        this.gtK = (LinearLayout) view.findViewById(e.g.layout_god_auth_forums);
        this.gtK.setVisibility(8);
        this.ekB = view.findViewById(e.g.header_bottom_divider);
        this.gtL = (RelativeLayout) view.findViewById(e.g.layout_gift);
        this.gtL.setOnClickListener(this.gtF);
        this.gtM = view.findViewById(e.g.gift_top_divider);
        this.gtN = (TextView) view.findViewById(e.g.textview_received_gift);
        this.gtO = (TextView) view.findViewById(e.g.textview_received_gift_num);
        this.gto = (ImageView) view.findViewById(e.g.img_gift_arrow);
        this.gtP = (TextView) view.findViewById(e.g.btn_edit_person_info);
        this.gtP.setOnClickListener(this.gtF);
        if (!this.mIsHost) {
            this.gtP.setVisibility(8);
        }
    }

    public void e(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null) {
            this.gtm = aVar;
            this.mUserData = aVar.getUserData();
            this.gtF.a(aVar);
            this.gtF.setIsHost(this.mIsHost);
            this.gtp.a(this.mUserData);
            UserVipInfoData userVipInfo = this.mUserData.getUserVipInfo();
            if (this.mUserData.getIsMem() > 0) {
                if (userVipInfo != null) {
                    this.glT.startLoad(userVipInfo.getVipIconUrl(), 10, false);
                }
                this.glT.setVisibility(0);
            } else if (this.mIsHost) {
                this.glT.setImageDrawable(al.getDrawable(e.f.icon_crown_super_non));
                this.glT.setVisibility(0);
            } else {
                this.glT.setVisibility(8);
            }
            bmS();
            String name_show = this.mUserData.getName_show();
            if (!TextUtils.isEmpty(name_show)) {
                this.aHt.setText(name_show);
            }
            int i = e.f.icon_mine_boy;
            if (this.mUserData != null) {
                i = this.mUserData.getSex() == 2 ? e.f.icon_mine_girl : e.f.icon_mine_boy;
            }
            this.aHt.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mContext.getResources().getDrawable(i), (Drawable) null);
            this.gtq.a(this.mUserData.getIconInfo(), 9, this.mContext.getResources().getDimensionPixelSize(e.C0200e.tbds42), this.mContext.getResources().getDimensionPixelSize(e.C0200e.tbds42), this.mContext.getResources().getDimensionPixelSize(e.C0200e.tbds10), true);
            if (this.gtt != null) {
                this.gtt.setData(this.mUserData);
            }
            if (this.mUserData != null && this.mUserData.alaUserData != null && this.mUserData.alaUserData.ala_id != 0) {
                this.bKi.setVisibility(0);
                this.gty.setVisibility(0);
                this.bKi.setText(String.format(this.mContext.getString(e.j.person_center_ala_id), Long.valueOf(this.mUserData.alaUserData.ala_id)));
            } else {
                this.bKi.setVisibility(8);
                this.gty.setVisibility(8);
            }
            this.gtv.setText(String.format(this.mContext.getString(e.j.person_center_header_bar_age), this.mUserData.getTb_age()));
            if (this.mIsHost) {
                this.gtB.setVisibility(0);
                this.gtC.setVisibility(0);
                this.gtx.setVisibility(0);
                this.gtA.setVisibility(0);
                this.gtx.setText(ao.V(this.mUserData.getTDouNum()));
            } else {
                this.gtB.setVisibility(8);
                this.gtC.setVisibility(8);
                this.gtx.setVisibility(8);
                this.gtA.setVisibility(8);
            }
            String intro = this.mUserData.getIntro();
            if (StringUtils.isNull(intro)) {
                al.c(this.gtw, e.d.cp_cont_e, 1);
            } else {
                al.c(this.gtw, e.d.cp_cont_j, 1);
            }
            if (StringUtils.isNull(intro)) {
                if (this.mIsHost) {
                    intro = this.mContext.getString(e.j.no_person_sign_host);
                } else {
                    intro = this.mContext.getString(e.j.no_person_sign_guest);
                }
            }
            this.gtw.setText(this.mContext.getString(e.j.person_sign) + intro);
            if (this.gtw.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gtw.getLayoutParams();
                if (!this.mIsHost && this.gtw.getLineCount() >= 3 && this.gtw.getMaxLines() != 2147483646) {
                    int lineHeight = this.gtw.getLineHeight();
                    this.gtw.setHeight((lineHeight / 2) + (lineHeight * 3));
                }
                if (this.gtw.getLineCount() >= 2) {
                    layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(e.C0200e.tbds19);
                } else {
                    layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(e.C0200e.tbds80);
                }
                this.gtw.setLayoutParams(layoutParams);
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(this.mUserData.getUserId()) && ((!TbadkCoreApplication.isLogin() || (!StringUtils.isNull(currentAccount) && !currentAccount.equals(this.mUserData.getUserId()))) && this.mUserData.getLiveStatus() == 1)) {
                if (this.gtz == null) {
                    this.gtz = com.baidu.tbadk.ala.b.uV().j(this.mContext, 7);
                }
                com.baidu.tbadk.ala.a aVar2 = new com.baidu.tbadk.ala.a();
                aVar2.aig = this.mUserData.getAlaUserData();
                aVar2.type = 7;
                if ((this.mUserData.getPersonPrivate() != null && this.mUserData.getPersonPrivate().Kx() == 3) || (this.mUserData.getPersonPrivate().Kx() == 2 && this.mUserData.getIsFriend() != 1)) {
                    aVar2.aih = true;
                } else {
                    aVar2.aih = false;
                }
                if (this.gtz != null) {
                    this.gtz.setTag(aVar2);
                    if (this.gtz.getParent() == null) {
                        this.gtD.addView(this.gtz);
                        TiebaStatic.log(new am("c12541"));
                    }
                }
            } else if (this.gtz != null) {
                this.gtz.setVisibility(8);
            }
            a(aVar.grh);
            this.mUserData.setIsLike(this.mUserData.getHave_attention() == 1);
            this.cNG.a(this.mUserData);
            boM();
            boN();
            this.gtN.setText(this.mIsHost ? e.j.my_received_gift : e.j.he_received_gift);
            if ((this.mUserData.getPersonPrivate() == null || this.mUserData.getPersonPrivate().Kx() != 3) && this.mUserData.getPersonPrivate().Kx() == 2 && this.mUserData.getIsFriend() != 1) {
            }
        }
    }

    public void sX(String str) {
        if (!StringUtils.isNull(str)) {
            this.aHt.setText(str);
        }
    }

    public void sY(String str) {
        if (!StringUtils.isNull(str)) {
            if (this.mUserData != null) {
                this.mUserData.setPortrait(str);
            }
            this.gtp.fU(str);
        }
    }

    private void a(UserAgreeInfo userAgreeInfo) {
        if (userAgreeInfo == null) {
            this.gtE.setVisibility(8);
            return;
        }
        this.gtE.setVisibility(0);
        String P = ao.P(userAgreeInfo.total_agree_num.longValue());
        Drawable drawable = al.getDrawable(e.f.icon_home_card_like_s);
        drawable.setBounds(0, 0, this.gtQ, this.gtQ);
        this.gtE.setCompoundDrawables(drawable, null, null, null);
        this.gtE.setText(P);
    }

    public void onChangeSkinType(int i) {
        this.gtu.setBackgroundDrawable(al.getDrawable(e.f.shape_user_info_bg));
        this.gtp.setBackgroundViewDrawable(al.getDrawable(e.f.shape_user_img_bg));
        int i2 = e.f.icon_mine_boy;
        if (this.mUserData != null) {
            i2 = this.mUserData.getSex() == 1 ? e.f.icon_mine_boy : e.f.icon_pop_girl;
        }
        if (this.mUserData != null && this.mUserData.getIsMem() <= 0 && this.glT != null && this.mIsHost) {
            this.glT.setImageDrawable(al.getDrawable(e.f.icon_crown_super_non));
        }
        bmS();
        al.c(this.gts, e.d.cp_link_tip_a, 1);
        this.aHt.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mContext.getResources().getDrawable(i2), (Drawable) null);
        if (this.gtt != null) {
            this.gtt.onChangeSkinType(i);
        }
        al.c(this.gtr, e.d.cp_cont_b, 1);
        al.c(this.gtv, e.d.cp_cont_b, 1);
        al.c(this.bKi, e.d.cp_cont_b, 1);
        if (this.mUserData == null || StringUtils.isNull(this.mUserData.getIntro())) {
            al.c(this.gtw, e.d.cp_cont_e, 1);
        } else {
            al.c(this.gtw, e.d.cp_cont_j, 1);
        }
        al.c(this.gtx, e.d.cp_cont_b, 1);
        al.c(this.gtA, e.d.cp_cont_b, 1);
        al.j(this.gtB, e.d.cp_bg_line_b);
        al.j(this.gty, e.d.cp_bg_line_b);
        al.j(this.gtC, e.d.cp_bg_line_b);
        al.h(this.gtE, e.d.cp_cont_h);
        this.gtx.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(e.f.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
        Drawable x = al.x(i, e.f.icon_home_card_like_s);
        x.setBounds(0, 0, this.gtQ, this.gtQ);
        this.gtE.setCompoundDrawables(x, null, null, null);
        al.i(this.gtG, e.f.selector_give_gift_bg);
        al.c(this.gtH, e.f.selector_gift_icon);
        al.c(this.gtI, e.d.selector_give_gift_text_color, 1);
        this.gtJ.onChangeSkinType(i);
        al.j(this.ekB, e.d.cp_bg_line_e);
        for (int i3 = 0; i3 < this.gtK.getChildCount(); i3++) {
            View childAt = this.gtK.getChildAt(i3);
            if (childAt != null) {
                TextView textView = (TextView) childAt.findViewById(e.g.bar_name);
                textView.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.pic_v_avatar), (Drawable) null, (Drawable) null, (Drawable) null);
                al.h(textView, e.d.cp_cont_b);
                al.h((TextView) childAt.findViewById(e.g.bar_info), e.d.cp_cont_j);
            }
        }
        for (int i4 = 0; i4 < gtn.length; i4++) {
            ((TbImageView) this.mRootView.findViewById(gtn[i4])).setBackgroundDrawable(al.getDrawable(e.f.shape_gift_icon_bg));
        }
        al.j(this.gtM, e.d.cp_bg_line_e);
        al.h(this.gtN, e.d.cp_cont_b);
        al.h(this.gtO, e.d.cp_cont_d);
        al.c(this.gto, e.f.icon_arrow_gray_right_n);
        al.i(this.gtP, e.f.selector_like_button_bg);
        al.c(this.gtP, e.d.cp_cont_g, 1);
    }

    public void onDestory() {
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.g gVar) {
        this.gtl = gVar;
        if (this.gtt != null) {
            this.gtt.setOnViewResponseListener(this.gtl);
        }
        this.gtF.setOnViewResponseListener(this.gtl);
    }

    public void to(String str) {
        this.gtp.fT(str);
    }

    protected void boL() {
        this.gtp.setHasPendantStyle();
        this.gtp.getHeadView().setIsRound(true);
        this.gtp.getHeadView().setDrawBorder(false);
        this.gtp.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    protected void bmS() {
        if (this.mUserData != null && (this.mUserData.getIsMem() > 0 || this.mUserData.isBigV())) {
            al.c(this.aHt, e.d.cp_cont_h, 1);
        } else {
            al.c(this.aHt, e.d.cp_cont_b, 1);
        }
    }

    private void boM() {
        if (this.gtm != null && this.gtm.boG() != null) {
            this.gtK.removeAllViews();
            int godType = this.gtm.boG().getGodType();
            if (godType == 2 && v.H(this.gtm.boG().getForumGodList()) > 0) {
                this.gtK.setVisibility(0);
                for (ForumGodDetailInfo forumGodDetailInfo : this.gtm.boG().getForumGodList()) {
                    if (forumGodDetailInfo != null) {
                        cl(forumGodDetailInfo.forum_name, forumGodDetailInfo.intro);
                    }
                }
                return;
            } else if (godType == 1 && this.gtm.boG().getgodDetailInfo() != null && !StringUtils.isNull(this.gtm.boG().getgodDetailInfo().intro)) {
                this.gtK.setVisibility(0);
                cl(this.gtm.boG().getgodDetailInfo().intro, "");
                return;
            } else {
                return;
            }
        }
        this.gtK.setVisibility(8);
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
        layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(e.C0200e.ds14);
        this.gtK.addView(inflate, layoutParams);
    }

    private void boN() {
        int i;
        for (int i2 = 0; i2 < gtn.length; i2++) {
            ((TbImageView) this.mRootView.findViewById(gtn[i2])).setVisibility(8);
        }
        if (this.gtm == null || this.gtm.boF() == null || v.H(this.gtm.boF().grv) <= 0) {
            i = 0;
        } else {
            int i3 = this.gtm.boF().giftNum;
            List<com.baidu.adp.widget.ListView.h> list = this.gtm.boF().grv;
            for (int i4 = 0; i4 < list.size() && i4 < gtn.length; i4++) {
                if (list.get(i4) instanceof com.baidu.tieba.personPolymeric.c.o) {
                    TbImageView tbImageView = (TbImageView) this.mRootView.findViewById(gtn[i4]);
                    tbImageView.setVisibility(0);
                    tbImageView.setIsRound(true);
                    tbImageView.startLoad(((com.baidu.tieba.personPolymeric.c.o) list.get(i4)).picUrl, 10, false);
                }
            }
            i = i3;
        }
        this.gtO.setText(String.format(this.mContext.getResources().getString(e.j.gift_num), Integer.valueOf(i)));
    }
}
