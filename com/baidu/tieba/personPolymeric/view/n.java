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
    private static final int[] gAd = {e.g.img_gift_one, e.g.img_gift_two, e.g.img_gift_three};
    protected TextView aKT;
    private TextView bNX;
    private com.baidu.tbadk.core.view.userLike.c cUn;
    private View erw;
    private LinearLayout gAA;
    private RelativeLayout gAB;
    private View gAC;
    private TextView gAD;
    private TextView gAE;
    private TextView gAF;
    private int gAG;
    protected com.baidu.tieba.view.g gAb;
    protected com.baidu.tieba.personPolymeric.c.a gAc;
    protected ImageView gAe;
    protected PersonHeadPendantView gAf;
    protected UserIconBox gAg;
    protected TextView gAh;
    protected TextView gAi;
    public com.baidu.tieba.view.e gAj;
    protected View gAk;
    private TextView gAl;
    private TextView gAm;
    private TextView gAn;
    private View gAo;
    private View gAp;
    private TextView gAq;
    private View gAr;
    private View gAs;
    private LinearLayout gAt;
    private TextView gAu;
    private m gAv;
    private View gAw;
    private ImageView gAx;
    private TextView gAy;
    private BlueLikeButton gAz;
    protected TbImageView gsJ;
    protected Context mContext;
    protected boolean mIsHost;
    private TbPageContext mPageContext;
    protected View mRootView;
    protected UserData mUserData;

    public n(TbPageContext tbPageContext, boolean z) {
        this.gAG = 0;
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.mIsHost = z;
        this.gAG = com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.tbds46);
        initView(ana());
        TextView textView = this.gAh;
        if (this.mIsHost) {
        }
        textView.setVisibility(8);
    }

    public View ana() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(e.h.item_person_polymeric_header_view, (ViewGroup) null);
        }
        return this.mRootView;
    }

    public void initView(View view) {
        this.gAk = view.findViewById(e.g.person_info_root);
        this.gAf = (PersonHeadPendantView) view.findViewById(e.g.person_polymeric_header_user_img);
        this.gAf.getHeadView().setGodIconResId(e.f.pic_v_avatar_big);
        this.gAf.getHeadView().setGodIconWidth(e.C0210e.ds40);
        this.gAf.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gAf.setDefalutResid(e.f.pic_mycenter_avatar_def_i);
        this.gAf.setBigVIconResId(e.f.pic_v_avatar_big);
        this.gAf.setBigVDimenSize(e.C0210e.ds40);
        this.gsJ = (TbImageView) view.findViewById(e.g.person_polymeric_header_user_vip_icon);
        this.aKT = (TextView) view.findViewById(e.g.person_polymeric_header_user_name_txt);
        this.gAi = (TextView) view.findViewById(e.g.seal_prefix_view);
        this.gAg = (UserIconBox) view.findViewById(e.g.person_polymeric_header_label_box);
        this.gAl = (TextView) view.findViewById(e.g.person_polymeric_header_bar_age_txt);
        this.bNX = (TextView) view.findViewById(e.g.person_polymeric_header_ala_id);
        this.gAo = view.findViewById(e.g.divider_for_alaid_and_age);
        this.gAh = (TextView) view.findViewById(e.g.person_polymeric_header_visitor_txt);
        this.gAm = (TextView) view.findViewById(e.g.person_polymeric_header_sign_txt);
        this.gAn = (TextView) view.findViewById(e.g.person_center_header_tdou_txt);
        this.gAq = (TextView) view.findViewById(e.g.textview_get_tdou);
        this.gAr = view.findViewById(e.g.divider_for_age_and_tdou);
        this.gAs = view.findViewById(e.g.divider_for_tdou_and_get_tdou);
        this.gAt = (LinearLayout) view.findViewById(e.g.layout_user_name);
        this.gAu = (TextView) view.findViewById(e.g.person_praise_number);
        this.gAn.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(e.f.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
        this.gAj = (PersonHeaderAttentionView) view.findViewById(e.g.person_center_header_attention_container);
        bqD();
        this.gAv = new m(this.mContext);
        this.gsJ.setOnClickListener(this.gAv);
        this.gAg.setOnClickListener(this.gAv);
        this.gAf.setOnClickListener(this.gAv);
        this.gAh.setOnClickListener(this.gAv);
        this.gAi.setOnClickListener(this.gAv);
        this.gAn.setOnClickListener(this.gAv);
        this.gAq.setOnClickListener(this.gAv);
        this.aKT.setOnClickListener(this.gAv);
        this.gAm.setOnClickListener(this.gAv);
        this.gAw = (LinearLayout) view.findViewById(e.g.container_send_gift);
        this.gAx = (ImageView) view.findViewById(e.g.icon_gift);
        this.gAy = (TextView) view.findViewById(e.g.btn_give_gift);
        this.gAw.setOnClickListener(this.gAv);
        this.gAz = (BlueLikeButton) view.findViewById(e.g.btn_like_blue);
        this.cUn = new com.baidu.tbadk.core.view.userLike.c(this.mPageContext, this.gAz);
        this.cUn.setFromType("2");
        if (this.mIsHost) {
            this.gAw.setVisibility(8);
            this.gAz.setVisibility(8);
        }
        this.gAA = (LinearLayout) view.findViewById(e.g.layout_god_auth_forums);
        this.gAA.setVisibility(8);
        this.erw = view.findViewById(e.g.header_bottom_divider);
        this.gAB = (RelativeLayout) view.findViewById(e.g.layout_gift);
        this.gAB.setOnClickListener(this.gAv);
        this.gAC = view.findViewById(e.g.gift_top_divider);
        this.gAD = (TextView) view.findViewById(e.g.textview_received_gift);
        this.gAE = (TextView) view.findViewById(e.g.textview_received_gift_num);
        this.gAe = (ImageView) view.findViewById(e.g.img_gift_arrow);
        this.gAF = (TextView) view.findViewById(e.g.btn_edit_person_info);
        this.gAF.setOnClickListener(this.gAv);
        if (!this.mIsHost) {
            this.gAF.setVisibility(8);
        }
    }

    public void e(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null) {
            this.gAc = aVar;
            this.mUserData = aVar.getUserData();
            this.gAv.a(aVar);
            this.gAv.setIsHost(this.mIsHost);
            this.gAf.a(this.mUserData);
            UserVipInfoData userVipInfo = this.mUserData.getUserVipInfo();
            if (this.mUserData.getIsMem() > 0) {
                if (userVipInfo != null) {
                    this.gsJ.startLoad(userVipInfo.getVipIconUrl(), 10, false);
                }
                this.gsJ.setVisibility(0);
            } else if (this.mIsHost) {
                this.gsJ.setImageDrawable(al.getDrawable(e.f.icon_crown_super_non));
                this.gsJ.setVisibility(0);
            } else {
                this.gsJ.setVisibility(8);
            }
            boK();
            String name_show = this.mUserData.getName_show();
            if (!TextUtils.isEmpty(name_show)) {
                this.aKT.setText(name_show);
            }
            int i = e.f.icon_mine_boy;
            if (this.mUserData != null) {
                i = this.mUserData.getSex() == 2 ? e.f.icon_mine_girl : e.f.icon_mine_boy;
            }
            this.aKT.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mContext.getResources().getDrawable(i), (Drawable) null);
            this.gAg.a(this.mUserData.getIconInfo(), 9, this.mContext.getResources().getDimensionPixelSize(e.C0210e.tbds42), this.mContext.getResources().getDimensionPixelSize(e.C0210e.tbds42), this.mContext.getResources().getDimensionPixelSize(e.C0210e.tbds10), true);
            if (this.gAj != null) {
                this.gAj.setData(this.mUserData);
            }
            if (this.mUserData != null && this.mUserData.alaUserData != null && this.mUserData.alaUserData.ala_id != 0) {
                this.bNX.setVisibility(0);
                this.gAo.setVisibility(0);
                this.bNX.setText(String.format(this.mContext.getString(e.j.person_center_ala_id), Long.valueOf(this.mUserData.alaUserData.ala_id)));
            } else {
                this.bNX.setVisibility(8);
                this.gAo.setVisibility(8);
            }
            this.gAl.setText(String.format(this.mContext.getString(e.j.person_center_header_bar_age), this.mUserData.getTb_age()));
            if (this.mIsHost) {
                this.gAr.setVisibility(0);
                this.gAs.setVisibility(0);
                this.gAn.setVisibility(0);
                this.gAq.setVisibility(0);
                this.gAn.setText(ao.ac(this.mUserData.getTDouNum()));
            } else {
                this.gAr.setVisibility(8);
                this.gAs.setVisibility(8);
                this.gAn.setVisibility(8);
                this.gAq.setVisibility(8);
            }
            String intro = this.mUserData.getIntro();
            if (StringUtils.isNull(intro)) {
                al.c(this.gAm, e.d.cp_cont_e, 1);
            } else {
                al.c(this.gAm, e.d.cp_cont_j, 1);
            }
            if (StringUtils.isNull(intro)) {
                if (this.mIsHost) {
                    intro = this.mContext.getString(e.j.no_person_sign_host);
                } else {
                    intro = this.mContext.getString(e.j.no_person_sign_guest);
                }
            }
            this.gAm.setText(this.mContext.getString(e.j.person_sign) + intro);
            if (this.gAm.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gAm.getLayoutParams();
                if (!this.mIsHost && this.gAm.getLineCount() >= 3 && this.gAm.getMaxLines() != 2147483646) {
                    int lineHeight = this.gAm.getLineHeight();
                    this.gAm.setHeight((lineHeight / 2) + (lineHeight * 3));
                }
                if (this.gAm.getLineCount() >= 2) {
                    layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(e.C0210e.tbds19);
                } else {
                    layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(e.C0210e.tbds80);
                }
                this.gAm.setLayoutParams(layoutParams);
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(this.mUserData.getUserId()) && ((!TbadkCoreApplication.isLogin() || (!StringUtils.isNull(currentAccount) && !currentAccount.equals(this.mUserData.getUserId()))) && this.mUserData.getLiveStatus() == 1)) {
                if (this.gAp == null) {
                    this.gAp = com.baidu.tbadk.ala.b.vZ().j(this.mContext, 7);
                }
                com.baidu.tbadk.ala.a aVar2 = new com.baidu.tbadk.ala.a();
                aVar2.alI = this.mUserData.getAlaUserData();
                aVar2.type = 7;
                if ((this.mUserData.getPersonPrivate() != null && this.mUserData.getPersonPrivate().LB() == 3) || (this.mUserData.getPersonPrivate().LB() == 2 && this.mUserData.getIsFriend() != 1)) {
                    aVar2.alJ = true;
                } else {
                    aVar2.alJ = false;
                }
                if (this.gAp != null) {
                    this.gAp.setTag(aVar2);
                    if (this.gAp.getParent() == null) {
                        this.gAt.addView(this.gAp);
                        TiebaStatic.log(new am("c12541"));
                    }
                }
            } else if (this.gAp != null) {
                this.gAp.setVisibility(8);
            }
            a(aVar.gxX);
            this.mUserData.setIsLike(this.mUserData.getHave_attention() == 1);
            this.cUn.a(this.mUserData);
            bqE();
            bqF();
            this.gAD.setText(this.mIsHost ? e.j.my_received_gift : e.j.he_received_gift);
            if ((this.mUserData.getPersonPrivate() == null || this.mUserData.getPersonPrivate().LB() != 3) && this.mUserData.getPersonPrivate().LB() == 2 && this.mUserData.getIsFriend() != 1) {
            }
        }
    }

    public void tz(String str) {
        if (!StringUtils.isNull(str)) {
            this.aKT.setText(str);
        }
    }

    public void tA(String str) {
        if (!StringUtils.isNull(str)) {
            if (this.mUserData != null) {
                this.mUserData.setPortrait(str);
            }
            this.gAf.gm(str);
        }
    }

    private void a(UserAgreeInfo userAgreeInfo) {
        if (userAgreeInfo == null) {
            this.gAu.setVisibility(8);
            return;
        }
        this.gAu.setVisibility(0);
        String W = ao.W(userAgreeInfo.total_agree_num.longValue());
        Drawable drawable = al.getDrawable(e.f.icon_home_card_like_s);
        drawable.setBounds(0, 0, this.gAG, this.gAG);
        this.gAu.setCompoundDrawables(drawable, null, null, null);
        this.gAu.setText(W);
    }

    public void onChangeSkinType(int i) {
        this.gAk.setBackgroundDrawable(al.getDrawable(e.f.shape_user_info_bg));
        this.gAf.setBackgroundViewDrawable(al.getDrawable(e.f.shape_user_img_bg));
        int i2 = e.f.icon_mine_boy;
        if (this.mUserData != null) {
            i2 = this.mUserData.getSex() == 1 ? e.f.icon_mine_boy : e.f.icon_pop_girl;
        }
        if (this.mUserData != null && this.mUserData.getIsMem() <= 0 && this.gsJ != null && this.mIsHost) {
            this.gsJ.setImageDrawable(al.getDrawable(e.f.icon_crown_super_non));
        }
        boK();
        al.c(this.gAi, e.d.cp_link_tip_a, 1);
        this.aKT.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mContext.getResources().getDrawable(i2), (Drawable) null);
        if (this.gAj != null) {
            this.gAj.onChangeSkinType(i);
        }
        al.c(this.gAh, e.d.cp_cont_b, 1);
        al.c(this.gAl, e.d.cp_cont_b, 1);
        al.c(this.bNX, e.d.cp_cont_b, 1);
        if (this.mUserData == null || StringUtils.isNull(this.mUserData.getIntro())) {
            al.c(this.gAm, e.d.cp_cont_e, 1);
        } else {
            al.c(this.gAm, e.d.cp_cont_j, 1);
        }
        al.c(this.gAn, e.d.cp_cont_b, 1);
        al.c(this.gAq, e.d.cp_cont_b, 1);
        al.j(this.gAr, e.d.cp_bg_line_b);
        al.j(this.gAo, e.d.cp_bg_line_b);
        al.j(this.gAs, e.d.cp_bg_line_b);
        al.h(this.gAu, e.d.cp_cont_h);
        this.gAn.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(e.f.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
        Drawable y = al.y(i, e.f.icon_home_card_like_s);
        y.setBounds(0, 0, this.gAG, this.gAG);
        this.gAu.setCompoundDrawables(y, null, null, null);
        al.i(this.gAw, e.f.selector_give_gift_bg);
        al.c(this.gAx, e.f.selector_gift_icon);
        al.c(this.gAy, e.d.selector_give_gift_text_color, 1);
        this.gAz.onChangeSkinType(i);
        al.j(this.erw, e.d.cp_bg_line_e);
        for (int i3 = 0; i3 < this.gAA.getChildCount(); i3++) {
            View childAt = this.gAA.getChildAt(i3);
            if (childAt != null) {
                TextView textView = (TextView) childAt.findViewById(e.g.bar_name);
                textView.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.pic_v_avatar), (Drawable) null, (Drawable) null, (Drawable) null);
                al.h(textView, e.d.cp_cont_b);
                al.h((TextView) childAt.findViewById(e.g.bar_info), e.d.cp_cont_j);
            }
        }
        for (int i4 = 0; i4 < gAd.length; i4++) {
            ((TbImageView) this.mRootView.findViewById(gAd[i4])).setBackgroundDrawable(al.getDrawable(e.f.shape_gift_icon_bg));
        }
        al.j(this.gAC, e.d.cp_bg_line_e);
        al.h(this.gAD, e.d.cp_cont_b);
        al.h(this.gAE, e.d.cp_cont_d);
        al.c(this.gAe, e.f.icon_arrow_gray_right_n);
        al.i(this.gAF, e.f.selector_like_button_bg);
        al.c(this.gAF, e.d.cp_cont_g, 1);
    }

    public void onDestory() {
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.g gVar) {
        this.gAb = gVar;
        if (this.gAj != null) {
            this.gAj.setOnViewResponseListener(this.gAb);
        }
        this.gAv.setOnViewResponseListener(this.gAb);
    }

    public void tQ(String str) {
        this.gAf.gl(str);
    }

    protected void bqD() {
        this.gAf.setHasPendantStyle();
        this.gAf.getHeadView().setIsRound(true);
        this.gAf.getHeadView().setDrawBorder(false);
        this.gAf.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    protected void boK() {
        if (this.mUserData != null && (this.mUserData.getIsMem() > 0 || this.mUserData.isBigV())) {
            al.c(this.aKT, e.d.cp_cont_h, 1);
        } else {
            al.c(this.aKT, e.d.cp_cont_b, 1);
        }
    }

    private void bqE() {
        if (this.gAc != null && this.gAc.bqy() != null) {
            this.gAA.removeAllViews();
            int godType = this.gAc.bqy().getGodType();
            if (godType == 2 && v.H(this.gAc.bqy().getForumGodList()) > 0) {
                this.gAA.setVisibility(0);
                for (ForumGodDetailInfo forumGodDetailInfo : this.gAc.bqy().getForumGodList()) {
                    if (forumGodDetailInfo != null) {
                        cq(forumGodDetailInfo.forum_name, forumGodDetailInfo.intro);
                    }
                }
                return;
            } else if (godType == 1 && this.gAc.bqy().getgodDetailInfo() != null && !StringUtils.isNull(this.gAc.bqy().getgodDetailInfo().intro)) {
                this.gAA.setVisibility(0);
                cq(this.gAc.bqy().getgodDetailInfo().intro, "");
                return;
            } else {
                return;
            }
        }
        this.gAA.setVisibility(8);
    }

    private void cq(String str, String str2) {
        View inflate = LayoutInflater.from(this.mContext).inflate(e.h.layout_god_auth_info, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(e.g.bar_name);
        textView.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.pic_v_avatar), (Drawable) null, (Drawable) null, (Drawable) null);
        al.h(textView, e.d.cp_cont_b);
        textView.setText(str);
        TextView textView2 = (TextView) inflate.findViewById(e.g.bar_info);
        al.h(textView2, e.d.cp_cont_j);
        textView2.setText(str2);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds14);
        this.gAA.addView(inflate, layoutParams);
    }

    private void bqF() {
        int i;
        for (int i2 = 0; i2 < gAd.length; i2++) {
            ((TbImageView) this.mRootView.findViewById(gAd[i2])).setVisibility(8);
        }
        if (this.gAc == null || this.gAc.bqx() == null || v.H(this.gAc.bqx().gyl) <= 0) {
            i = 0;
        } else {
            int i3 = this.gAc.bqx().giftNum;
            List<com.baidu.adp.widget.ListView.h> list = this.gAc.bqx().gyl;
            for (int i4 = 0; i4 < list.size() && i4 < gAd.length; i4++) {
                if (list.get(i4) instanceof com.baidu.tieba.personPolymeric.c.o) {
                    TbImageView tbImageView = (TbImageView) this.mRootView.findViewById(gAd[i4]);
                    tbImageView.setVisibility(0);
                    tbImageView.setIsRound(true);
                    tbImageView.startLoad(((com.baidu.tieba.personPolymeric.c.o) list.get(i4)).picUrl, 10, false);
                }
            }
            i = i3;
        }
        this.gAE.setText(String.format(this.mContext.getResources().getString(e.j.gift_num), Integer.valueOf(i)));
    }
}
