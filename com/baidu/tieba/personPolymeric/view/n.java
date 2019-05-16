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
import com.baidu.tbadk.core.util.ap;
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
    private static final int[] imy = {R.id.img_gift_one, R.id.img_gift_two, R.id.img_gift_three};
    private View bMQ;
    protected TextView cbV;
    private TextView dlx;
    private com.baidu.tbadk.core.view.userLike.c ewX;
    protected TbImageView ieW;
    protected PersonHeadPendantView imA;
    protected UserIconBox imB;
    protected TextView imC;
    protected TextView imD;
    public com.baidu.tieba.view.e imE;
    protected View imF;
    private TextView imG;
    private TextView imH;
    private TextView imI;
    private View imJ;
    private View imK;
    private TextView imL;
    private View imM;
    private View imN;
    private LinearLayout imO;
    private TextView imP;
    private m imQ;
    private View imR;
    private ImageView imS;
    private TextView imT;
    private BlueLikeButton imU;
    private LinearLayout imV;
    private RelativeLayout imW;
    private View imX;
    private TextView imY;
    private TextView imZ;
    protected com.baidu.tieba.view.g imw;
    protected com.baidu.tieba.personPolymeric.c.a imx;
    protected ImageView imz;
    private TextView ina;
    private int inb;
    protected Context mContext;
    protected boolean mIsHost;
    private TbPageContext mPageContext;
    protected View mRootView;
    protected UserData mUserData;

    public n(TbPageContext tbPageContext, boolean z) {
        this.inb = 0;
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.mIsHost = z;
        this.inb = com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.tbds46);
        O(aUT());
        TextView textView = this.imC;
        if (this.mIsHost) {
        }
        textView.setVisibility(8);
    }

    public View aUT() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.item_person_polymeric_header_view, (ViewGroup) null);
        }
        return this.mRootView;
    }

    public void O(View view) {
        this.imF = view.findViewById(R.id.person_info_root);
        this.imA = (PersonHeadPendantView) view.findViewById(R.id.person_polymeric_header_user_img);
        this.imA.getHeadView().setGodIconResId(R.drawable.pic_v_avatar_big);
        this.imA.getHeadView().setGodIconWidth(R.dimen.ds40);
        this.imA.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.imA.setDefalutResid(R.drawable.pic_mycenter_avatar_def_i);
        this.imA.setBigVIconResId(R.drawable.pic_v_avatar_big);
        this.imA.setBigVDimenSize(R.dimen.ds40);
        this.ieW = (TbImageView) view.findViewById(R.id.person_polymeric_header_user_vip_icon);
        this.cbV = (TextView) view.findViewById(R.id.person_polymeric_header_user_name_txt);
        this.imD = (TextView) view.findViewById(R.id.seal_prefix_view);
        this.imB = (UserIconBox) view.findViewById(R.id.person_polymeric_header_label_box);
        this.imG = (TextView) view.findViewById(R.id.person_polymeric_header_bar_age_txt);
        this.dlx = (TextView) view.findViewById(R.id.person_polymeric_header_ala_id);
        this.imJ = view.findViewById(R.id.divider_for_alaid_and_age);
        this.imC = (TextView) view.findViewById(R.id.person_polymeric_header_visitor_txt);
        this.imH = (TextView) view.findViewById(R.id.person_polymeric_header_sign_txt);
        this.imI = (TextView) view.findViewById(R.id.person_center_header_tdou_txt);
        this.imL = (TextView) view.findViewById(R.id.textview_get_tdou);
        this.imM = view.findViewById(R.id.divider_for_age_and_tdou);
        this.imN = view.findViewById(R.id.divider_for_tdou_and_get_tdou);
        this.imO = (LinearLayout) view.findViewById(R.id.layout_user_name);
        this.imP = (TextView) view.findViewById(R.id.person_praise_number);
        this.imI.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(R.drawable.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
        this.imE = (PersonHeaderAttentionView) view.findViewById(R.id.person_center_header_attention_container);
        cat();
        this.imQ = new m(this.mContext);
        this.ieW.setOnClickListener(this.imQ);
        this.imB.setOnClickListener(this.imQ);
        this.imA.setOnClickListener(this.imQ);
        this.imC.setOnClickListener(this.imQ);
        this.imD.setOnClickListener(this.imQ);
        this.imI.setOnClickListener(this.imQ);
        this.imL.setOnClickListener(this.imQ);
        this.cbV.setOnClickListener(this.imQ);
        this.imH.setOnClickListener(this.imQ);
        this.imR = (LinearLayout) view.findViewById(R.id.container_send_gift);
        this.imS = (ImageView) view.findViewById(R.id.icon_gift);
        this.imT = (TextView) view.findViewById(R.id.btn_give_gift);
        this.imR.setOnClickListener(this.imQ);
        this.imU = (BlueLikeButton) view.findViewById(R.id.btn_like_blue);
        this.ewX = new com.baidu.tbadk.core.view.userLike.c(this.mPageContext, this.imU);
        this.ewX.setFromType("2");
        if (this.mIsHost) {
            this.imR.setVisibility(8);
            this.imU.setVisibility(8);
        }
        this.imV = (LinearLayout) view.findViewById(R.id.layout_god_auth_forums);
        this.imV.setVisibility(8);
        this.bMQ = view.findViewById(R.id.header_bottom_divider);
        this.imW = (RelativeLayout) view.findViewById(R.id.layout_gift);
        this.imW.setOnClickListener(this.imQ);
        this.imX = view.findViewById(R.id.gift_top_divider);
        this.imY = (TextView) view.findViewById(R.id.textview_received_gift);
        this.imZ = (TextView) view.findViewById(R.id.textview_received_gift_num);
        this.imz = (ImageView) view.findViewById(R.id.img_gift_arrow);
        this.ina = (TextView) view.findViewById(R.id.btn_edit_person_info);
        this.ina.setOnClickListener(this.imQ);
        if (!this.mIsHost) {
            this.ina.setVisibility(8);
        }
    }

    public void e(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null) {
            this.imx = aVar;
            this.mUserData = aVar.getUserData();
            this.imQ.a(aVar);
            this.imQ.setIsHost(this.mIsHost);
            this.imA.a(this.mUserData);
            UserVipInfoData userVipInfo = this.mUserData.getUserVipInfo();
            if (this.mUserData.getIsMem() > 0) {
                if (userVipInfo != null) {
                    this.ieW.startLoad(userVipInfo.getVipIconUrl(), 10, false);
                }
                this.ieW.setVisibility(0);
            } else if (this.mIsHost) {
                this.ieW.setImageDrawable(al.getDrawable(R.drawable.icon_crown_super_non));
                this.ieW.setVisibility(0);
            } else {
                this.ieW.setVisibility(8);
            }
            bYw();
            String name_show = this.mUserData.getName_show();
            if (!TextUtils.isEmpty(name_show)) {
                this.cbV.setText(name_show);
            }
            int i = R.drawable.icon_mine_boy;
            if (this.mUserData != null) {
                i = this.mUserData.getSex() == 2 ? R.drawable.icon_mine_girl : R.drawable.icon_mine_boy;
            }
            this.cbV.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mContext.getResources().getDrawable(i), (Drawable) null);
            this.imB.a(this.mUserData.getIconInfo(), 9, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds42), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds42), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds10), true);
            if (this.imE != null) {
                this.imE.setData(this.mUserData);
            }
            if (this.mUserData != null && this.mUserData.alaUserData != null && this.mUserData.alaUserData.ala_id != 0) {
                this.dlx.setVisibility(0);
                this.imJ.setVisibility(0);
                this.dlx.setText(String.format(this.mContext.getString(R.string.person_center_ala_id), Long.valueOf(this.mUserData.alaUserData.ala_id)));
            } else {
                this.dlx.setVisibility(8);
                this.imJ.setVisibility(8);
            }
            this.imG.setText(String.format(this.mContext.getString(R.string.person_center_header_bar_age), this.mUserData.getTb_age()));
            if (this.mIsHost) {
                this.imM.setVisibility(0);
                this.imN.setVisibility(0);
                this.imI.setVisibility(0);
                this.imL.setVisibility(0);
                this.imI.setText(ap.aU(this.mUserData.getTDouNum()));
            } else {
                this.imM.setVisibility(8);
                this.imN.setVisibility(8);
                this.imI.setVisibility(8);
                this.imL.setVisibility(8);
            }
            String intro = this.mUserData.getIntro();
            if (StringUtils.isNull(intro)) {
                al.f(this.imH, R.color.cp_cont_e, 1);
            } else {
                al.f(this.imH, R.color.cp_cont_j, 1);
            }
            if (StringUtils.isNull(intro)) {
                if (this.mIsHost) {
                    intro = this.mContext.getString(R.string.no_person_sign_host);
                } else {
                    intro = this.mContext.getString(R.string.no_person_sign_guest);
                }
            }
            this.imH.setText(this.mContext.getString(R.string.person_sign) + intro);
            if (this.imH.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.imH.getLayoutParams();
                if (!this.mIsHost && this.imH.getLineCount() >= 3 && this.imH.getMaxLines() != 2147483646) {
                    int lineHeight = this.imH.getLineHeight();
                    this.imH.setHeight((lineHeight / 2) + (lineHeight * 3));
                }
                if (this.imH.getLineCount() >= 2) {
                    layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds19);
                } else {
                    layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds80);
                }
                this.imH.setLayoutParams(layoutParams);
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(this.mUserData.getUserId()) && ((!TbadkCoreApplication.isLogin() || (!StringUtils.isNull(currentAccount) && !currentAccount.equals(this.mUserData.getUserId()))) && this.mUserData.getLiveStatus() == 1)) {
                if (this.imK == null) {
                    this.imK = com.baidu.tbadk.ala.b.Zl().n(this.mContext, 7);
                }
                com.baidu.tbadk.ala.a aVar2 = new com.baidu.tbadk.ala.a();
                aVar2.bzQ = this.mUserData.getAlaUserData();
                aVar2.type = 7;
                if ((this.mUserData.getPersonPrivate() != null && this.mUserData.getPersonPrivate().aqs() == 3) || (this.mUserData.getPersonPrivate().aqs() == 2 && this.mUserData.getIsFriend() != 1)) {
                    aVar2.bzR = true;
                } else {
                    aVar2.bzR = false;
                }
                if (this.imK != null) {
                    this.imK.setTag(aVar2);
                    if (this.imK.getParent() == null) {
                        this.imO.addView(this.imK);
                        TiebaStatic.log(new am("c12541"));
                    }
                }
            } else if (this.imK != null) {
                this.imK.setVisibility(8);
            }
            a(aVar.ikr);
            this.mUserData.setIsLike(this.mUserData.getHave_attention() == 1);
            this.ewX.a(this.mUserData);
            cau();
            cav();
            this.imY.setText(this.mIsHost ? R.string.my_received_gift : R.string.he_received_gift);
            if ((this.mUserData.getPersonPrivate() == null || this.mUserData.getPersonPrivate().aqs() != 3) && this.mUserData.getPersonPrivate().aqs() == 2 && this.mUserData.getIsFriend() != 1) {
            }
        }
    }

    public void BM(String str) {
        if (!StringUtils.isNull(str)) {
            this.cbV.setText(str);
        }
    }

    public void BN(String str) {
        if (!StringUtils.isNull(str)) {
            if (this.mUserData != null) {
                this.mUserData.setPortrait(str);
            }
            this.imA.oy(str);
        }
    }

    private void a(UserAgreeInfo userAgreeInfo) {
        if (userAgreeInfo == null) {
            this.imP.setVisibility(8);
            return;
        }
        this.imP.setVisibility(0);
        String aN = ap.aN(userAgreeInfo.total_agree_num.longValue());
        Drawable drawable = al.getDrawable(R.drawable.icon_home_card_like_s);
        drawable.setBounds(0, 0, this.inb, this.inb);
        this.imP.setCompoundDrawables(drawable, null, null, null);
        this.imP.setText(aN);
    }

    public void onChangeSkinType(int i) {
        this.imF.setBackgroundDrawable(al.getDrawable(R.drawable.shape_user_info_bg));
        this.imA.setBackgroundViewDrawable(al.getDrawable(R.drawable.shape_user_img_bg));
        int i2 = R.drawable.icon_mine_boy;
        if (this.mUserData != null) {
            i2 = this.mUserData.getSex() == 1 ? R.drawable.icon_mine_boy : R.drawable.icon_pop_girl;
        }
        if (this.mUserData != null && this.mUserData.getIsMem() <= 0 && this.ieW != null && this.mIsHost) {
            this.ieW.setImageDrawable(al.getDrawable(R.drawable.icon_crown_super_non));
        }
        bYw();
        al.f(this.imD, R.color.cp_link_tip_a, 1);
        this.cbV.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mContext.getResources().getDrawable(i2), (Drawable) null);
        if (this.imE != null) {
            this.imE.onChangeSkinType(i);
        }
        al.f(this.imC, R.color.cp_cont_b, 1);
        al.f(this.imG, R.color.cp_cont_b, 1);
        al.f(this.dlx, R.color.cp_cont_b, 1);
        if (this.mUserData == null || StringUtils.isNull(this.mUserData.getIntro())) {
            al.f(this.imH, R.color.cp_cont_e, 1);
        } else {
            al.f(this.imH, R.color.cp_cont_j, 1);
        }
        al.f(this.imI, R.color.cp_cont_b, 1);
        al.f(this.imL, R.color.cp_cont_b, 1);
        al.l(this.imM, R.color.cp_bg_line_b);
        al.l(this.imJ, R.color.cp_bg_line_b);
        al.l(this.imN, R.color.cp_bg_line_b);
        al.j(this.imP, R.color.cp_cont_h);
        this.imI.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(R.drawable.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
        Drawable S = al.S(i, R.drawable.icon_home_card_like_s);
        S.setBounds(0, 0, this.inb, this.inb);
        this.imP.setCompoundDrawables(S, null, null, null);
        al.k(this.imR, R.drawable.selector_give_gift_bg);
        al.c(this.imS, (int) R.drawable.selector_gift_icon);
        al.f(this.imT, R.color.selector_give_gift_text_color, 1);
        this.imU.onChangeSkinType(i);
        al.l(this.bMQ, R.color.cp_bg_line_e);
        for (int i3 = 0; i3 < this.imV.getChildCount(); i3++) {
            View childAt = this.imV.getChildAt(i3);
            if (childAt != null) {
                TextView textView = (TextView) childAt.findViewById(R.id.bar_name);
                textView.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(R.drawable.pic_v_avatar), (Drawable) null, (Drawable) null, (Drawable) null);
                al.j(textView, R.color.cp_cont_b);
                al.j((TextView) childAt.findViewById(R.id.bar_info), R.color.cp_cont_j);
            }
        }
        for (int i4 = 0; i4 < imy.length; i4++) {
            ((TbImageView) this.mRootView.findViewById(imy[i4])).setBackgroundDrawable(al.getDrawable(R.drawable.shape_gift_icon_bg));
        }
        al.l(this.imX, R.color.cp_bg_line_e);
        al.j(this.imY, R.color.cp_cont_b);
        al.j(this.imZ, R.color.cp_cont_d);
        al.c(this.imz, (int) R.drawable.icon_arrow_gray_right_n);
        al.k(this.ina, R.drawable.selector_like_button_bg);
        al.f(this.ina, R.color.cp_cont_g, 1);
    }

    public void onDestory() {
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.g gVar) {
        this.imw = gVar;
        if (this.imE != null) {
            this.imE.setOnViewResponseListener(this.imw);
        }
        this.imQ.setOnViewResponseListener(this.imw);
    }

    public void Ce(String str) {
        this.imA.ox(str);
    }

    protected void cat() {
        this.imA.setHasPendantStyle();
        this.imA.getHeadView().setIsRound(true);
        this.imA.getHeadView().setDrawBorder(false);
        this.imA.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    protected void bYw() {
        if (this.mUserData != null && (this.mUserData.getIsMem() > 0 || this.mUserData.isBigV())) {
            al.f(this.cbV, R.color.cp_cont_h, 1);
        } else {
            al.f(this.cbV, R.color.cp_cont_b, 1);
        }
    }

    private void cau() {
        if (this.imx != null && this.imx.cao() != null) {
            this.imV.removeAllViews();
            int godType = this.imx.cao().getGodType();
            if (godType == 2 && v.Z(this.imx.cao().getForumGodList()) > 0) {
                this.imV.setVisibility(0);
                for (ForumGodDetailInfo forumGodDetailInfo : this.imx.cao().getForumGodList()) {
                    if (forumGodDetailInfo != null) {
                        dO(forumGodDetailInfo.forum_name, forumGodDetailInfo.intro);
                    }
                }
                return;
            } else if (godType == 1 && this.imx.cao().getgodDetailInfo() != null && !StringUtils.isNull(this.imx.cao().getgodDetailInfo().intro)) {
                this.imV.setVisibility(0);
                dO(this.imx.cao().getgodDetailInfo().intro, "");
                return;
            } else {
                return;
            }
        }
        this.imV.setVisibility(8);
    }

    private void dO(String str, String str2) {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.layout_god_auth_info, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.bar_name);
        textView.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(R.drawable.pic_v_avatar), (Drawable) null, (Drawable) null, (Drawable) null);
        al.j(textView, R.color.cp_cont_b);
        textView.setText(str);
        TextView textView2 = (TextView) inflate.findViewById(R.id.bar_info);
        al.j(textView2, R.color.cp_cont_j);
        textView2.setText(str2);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds14);
        this.imV.addView(inflate, layoutParams);
    }

    private void cav() {
        int i;
        for (int i2 = 0; i2 < imy.length; i2++) {
            ((TbImageView) this.mRootView.findViewById(imy[i2])).setVisibility(8);
        }
        if (this.imx == null || this.imx.can() == null || v.Z(this.imx.can().ikF) <= 0) {
            i = 0;
        } else {
            int i3 = this.imx.can().giftNum;
            List<com.baidu.adp.widget.ListView.m> list = this.imx.can().ikF;
            for (int i4 = 0; i4 < list.size() && i4 < imy.length; i4++) {
                if (list.get(i4) instanceof com.baidu.tieba.personPolymeric.c.o) {
                    TbImageView tbImageView = (TbImageView) this.mRootView.findViewById(imy[i4]);
                    tbImageView.setVisibility(0);
                    tbImageView.setIsRound(true);
                    tbImageView.startLoad(((com.baidu.tieba.personPolymeric.c.o) list.get(i4)).picUrl, 10, false);
                }
            }
            i = i3;
        }
        this.imZ.setText(String.format(this.mContext.getResources().getString(R.string.gift_num), Integer.valueOf(i)));
    }
}
