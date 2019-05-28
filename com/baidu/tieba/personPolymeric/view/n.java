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
    private static final int[] imB = {R.id.img_gift_one, R.id.img_gift_two, R.id.img_gift_three};
    private View bMQ;
    protected TextView cbV;
    private TextView dly;
    private com.baidu.tbadk.core.view.userLike.c ewY;
    protected TbImageView ieZ;
    protected com.baidu.tieba.personPolymeric.c.a imA;
    protected ImageView imC;
    protected PersonHeadPendantView imD;
    protected UserIconBox imE;
    protected TextView imF;
    protected TextView imG;
    public com.baidu.tieba.view.e imH;
    protected View imI;
    private TextView imJ;
    private TextView imK;
    private TextView imL;
    private View imM;
    private View imN;
    private TextView imO;
    private View imP;
    private View imQ;
    private LinearLayout imR;
    private TextView imS;
    private m imT;
    private View imU;
    private ImageView imV;
    private TextView imW;
    private BlueLikeButton imX;
    private LinearLayout imY;
    private RelativeLayout imZ;
    protected com.baidu.tieba.view.g imz;
    private View ina;
    private TextView inb;
    private TextView inc;
    private TextView ind;
    private int ine;
    protected Context mContext;
    protected boolean mIsHost;
    private TbPageContext mPageContext;
    protected View mRootView;
    protected UserData mUserData;

    public n(TbPageContext tbPageContext, boolean z) {
        this.ine = 0;
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.mIsHost = z;
        this.ine = com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.tbds46);
        O(aUW());
        TextView textView = this.imF;
        if (this.mIsHost) {
        }
        textView.setVisibility(8);
    }

    public View aUW() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.item_person_polymeric_header_view, (ViewGroup) null);
        }
        return this.mRootView;
    }

    public void O(View view) {
        this.imI = view.findViewById(R.id.person_info_root);
        this.imD = (PersonHeadPendantView) view.findViewById(R.id.person_polymeric_header_user_img);
        this.imD.getHeadView().setGodIconResId(R.drawable.pic_v_avatar_big);
        this.imD.getHeadView().setGodIconWidth(R.dimen.ds40);
        this.imD.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.imD.setDefalutResid(R.drawable.pic_mycenter_avatar_def_i);
        this.imD.setBigVIconResId(R.drawable.pic_v_avatar_big);
        this.imD.setBigVDimenSize(R.dimen.ds40);
        this.ieZ = (TbImageView) view.findViewById(R.id.person_polymeric_header_user_vip_icon);
        this.cbV = (TextView) view.findViewById(R.id.person_polymeric_header_user_name_txt);
        this.imG = (TextView) view.findViewById(R.id.seal_prefix_view);
        this.imE = (UserIconBox) view.findViewById(R.id.person_polymeric_header_label_box);
        this.imJ = (TextView) view.findViewById(R.id.person_polymeric_header_bar_age_txt);
        this.dly = (TextView) view.findViewById(R.id.person_polymeric_header_ala_id);
        this.imM = view.findViewById(R.id.divider_for_alaid_and_age);
        this.imF = (TextView) view.findViewById(R.id.person_polymeric_header_visitor_txt);
        this.imK = (TextView) view.findViewById(R.id.person_polymeric_header_sign_txt);
        this.imL = (TextView) view.findViewById(R.id.person_center_header_tdou_txt);
        this.imO = (TextView) view.findViewById(R.id.textview_get_tdou);
        this.imP = view.findViewById(R.id.divider_for_age_and_tdou);
        this.imQ = view.findViewById(R.id.divider_for_tdou_and_get_tdou);
        this.imR = (LinearLayout) view.findViewById(R.id.layout_user_name);
        this.imS = (TextView) view.findViewById(R.id.person_praise_number);
        this.imL.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(R.drawable.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
        this.imH = (PersonHeaderAttentionView) view.findViewById(R.id.person_center_header_attention_container);
        caw();
        this.imT = new m(this.mContext);
        this.ieZ.setOnClickListener(this.imT);
        this.imE.setOnClickListener(this.imT);
        this.imD.setOnClickListener(this.imT);
        this.imF.setOnClickListener(this.imT);
        this.imG.setOnClickListener(this.imT);
        this.imL.setOnClickListener(this.imT);
        this.imO.setOnClickListener(this.imT);
        this.cbV.setOnClickListener(this.imT);
        this.imK.setOnClickListener(this.imT);
        this.imU = (LinearLayout) view.findViewById(R.id.container_send_gift);
        this.imV = (ImageView) view.findViewById(R.id.icon_gift);
        this.imW = (TextView) view.findViewById(R.id.btn_give_gift);
        this.imU.setOnClickListener(this.imT);
        this.imX = (BlueLikeButton) view.findViewById(R.id.btn_like_blue);
        this.ewY = new com.baidu.tbadk.core.view.userLike.c(this.mPageContext, this.imX);
        this.ewY.setFromType("2");
        if (this.mIsHost) {
            this.imU.setVisibility(8);
            this.imX.setVisibility(8);
        }
        this.imY = (LinearLayout) view.findViewById(R.id.layout_god_auth_forums);
        this.imY.setVisibility(8);
        this.bMQ = view.findViewById(R.id.header_bottom_divider);
        this.imZ = (RelativeLayout) view.findViewById(R.id.layout_gift);
        this.imZ.setOnClickListener(this.imT);
        this.ina = view.findViewById(R.id.gift_top_divider);
        this.inb = (TextView) view.findViewById(R.id.textview_received_gift);
        this.inc = (TextView) view.findViewById(R.id.textview_received_gift_num);
        this.imC = (ImageView) view.findViewById(R.id.img_gift_arrow);
        this.ind = (TextView) view.findViewById(R.id.btn_edit_person_info);
        this.ind.setOnClickListener(this.imT);
        if (!this.mIsHost) {
            this.ind.setVisibility(8);
        }
    }

    public void e(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null) {
            this.imA = aVar;
            this.mUserData = aVar.getUserData();
            this.imT.a(aVar);
            this.imT.setIsHost(this.mIsHost);
            this.imD.a(this.mUserData);
            UserVipInfoData userVipInfo = this.mUserData.getUserVipInfo();
            if (this.mUserData.getIsMem() > 0) {
                if (userVipInfo != null) {
                    this.ieZ.startLoad(userVipInfo.getVipIconUrl(), 10, false);
                }
                this.ieZ.setVisibility(0);
            } else if (this.mIsHost) {
                this.ieZ.setImageDrawable(al.getDrawable(R.drawable.icon_crown_super_non));
                this.ieZ.setVisibility(0);
            } else {
                this.ieZ.setVisibility(8);
            }
            bYz();
            String name_show = this.mUserData.getName_show();
            if (!TextUtils.isEmpty(name_show)) {
                this.cbV.setText(name_show);
            }
            int i = R.drawable.icon_mine_boy;
            if (this.mUserData != null) {
                i = this.mUserData.getSex() == 2 ? R.drawable.icon_mine_girl : R.drawable.icon_mine_boy;
            }
            this.cbV.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mContext.getResources().getDrawable(i), (Drawable) null);
            this.imE.a(this.mUserData.getIconInfo(), 9, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds42), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds42), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds10), true);
            if (this.imH != null) {
                this.imH.setData(this.mUserData);
            }
            if (this.mUserData != null && this.mUserData.alaUserData != null && this.mUserData.alaUserData.ala_id != 0) {
                this.dly.setVisibility(0);
                this.imM.setVisibility(0);
                this.dly.setText(String.format(this.mContext.getString(R.string.person_center_ala_id), Long.valueOf(this.mUserData.alaUserData.ala_id)));
            } else {
                this.dly.setVisibility(8);
                this.imM.setVisibility(8);
            }
            this.imJ.setText(String.format(this.mContext.getString(R.string.person_center_header_bar_age), this.mUserData.getTb_age()));
            if (this.mIsHost) {
                this.imP.setVisibility(0);
                this.imQ.setVisibility(0);
                this.imL.setVisibility(0);
                this.imO.setVisibility(0);
                this.imL.setText(ap.aU(this.mUserData.getTDouNum()));
            } else {
                this.imP.setVisibility(8);
                this.imQ.setVisibility(8);
                this.imL.setVisibility(8);
                this.imO.setVisibility(8);
            }
            String intro = this.mUserData.getIntro();
            if (StringUtils.isNull(intro)) {
                al.f(this.imK, R.color.cp_cont_e, 1);
            } else {
                al.f(this.imK, R.color.cp_cont_j, 1);
            }
            if (StringUtils.isNull(intro)) {
                if (this.mIsHost) {
                    intro = this.mContext.getString(R.string.no_person_sign_host);
                } else {
                    intro = this.mContext.getString(R.string.no_person_sign_guest);
                }
            }
            this.imK.setText(this.mContext.getString(R.string.person_sign) + intro);
            if (this.imK.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.imK.getLayoutParams();
                if (!this.mIsHost && this.imK.getLineCount() >= 3 && this.imK.getMaxLines() != 2147483646) {
                    int lineHeight = this.imK.getLineHeight();
                    this.imK.setHeight((lineHeight / 2) + (lineHeight * 3));
                }
                if (this.imK.getLineCount() >= 2) {
                    layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds19);
                } else {
                    layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds80);
                }
                this.imK.setLayoutParams(layoutParams);
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(this.mUserData.getUserId()) && ((!TbadkCoreApplication.isLogin() || (!StringUtils.isNull(currentAccount) && !currentAccount.equals(this.mUserData.getUserId()))) && this.mUserData.getLiveStatus() == 1)) {
                if (this.imN == null) {
                    this.imN = com.baidu.tbadk.ala.b.Zl().n(this.mContext, 7);
                }
                com.baidu.tbadk.ala.a aVar2 = new com.baidu.tbadk.ala.a();
                aVar2.bzQ = this.mUserData.getAlaUserData();
                aVar2.type = 7;
                if ((this.mUserData.getPersonPrivate() != null && this.mUserData.getPersonPrivate().aqs() == 3) || (this.mUserData.getPersonPrivate().aqs() == 2 && this.mUserData.getIsFriend() != 1)) {
                    aVar2.bzR = true;
                } else {
                    aVar2.bzR = false;
                }
                if (this.imN != null) {
                    this.imN.setTag(aVar2);
                    if (this.imN.getParent() == null) {
                        this.imR.addView(this.imN);
                        TiebaStatic.log(new am("c12541"));
                    }
                }
            } else if (this.imN != null) {
                this.imN.setVisibility(8);
            }
            a(aVar.iku);
            this.mUserData.setIsLike(this.mUserData.getHave_attention() == 1);
            this.ewY.a(this.mUserData);
            cax();
            cay();
            this.inb.setText(this.mIsHost ? R.string.my_received_gift : R.string.he_received_gift);
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
            this.imD.oy(str);
        }
    }

    private void a(UserAgreeInfo userAgreeInfo) {
        if (userAgreeInfo == null) {
            this.imS.setVisibility(8);
            return;
        }
        this.imS.setVisibility(0);
        String aN = ap.aN(userAgreeInfo.total_agree_num.longValue());
        Drawable drawable = al.getDrawable(R.drawable.icon_home_card_like_s);
        drawable.setBounds(0, 0, this.ine, this.ine);
        this.imS.setCompoundDrawables(drawable, null, null, null);
        this.imS.setText(aN);
    }

    public void onChangeSkinType(int i) {
        this.imI.setBackgroundDrawable(al.getDrawable(R.drawable.shape_user_info_bg));
        this.imD.setBackgroundViewDrawable(al.getDrawable(R.drawable.shape_user_img_bg));
        int i2 = R.drawable.icon_mine_boy;
        if (this.mUserData != null) {
            i2 = this.mUserData.getSex() == 1 ? R.drawable.icon_mine_boy : R.drawable.icon_pop_girl;
        }
        if (this.mUserData != null && this.mUserData.getIsMem() <= 0 && this.ieZ != null && this.mIsHost) {
            this.ieZ.setImageDrawable(al.getDrawable(R.drawable.icon_crown_super_non));
        }
        bYz();
        al.f(this.imG, R.color.cp_link_tip_a, 1);
        this.cbV.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mContext.getResources().getDrawable(i2), (Drawable) null);
        if (this.imH != null) {
            this.imH.onChangeSkinType(i);
        }
        al.f(this.imF, R.color.cp_cont_b, 1);
        al.f(this.imJ, R.color.cp_cont_b, 1);
        al.f(this.dly, R.color.cp_cont_b, 1);
        if (this.mUserData == null || StringUtils.isNull(this.mUserData.getIntro())) {
            al.f(this.imK, R.color.cp_cont_e, 1);
        } else {
            al.f(this.imK, R.color.cp_cont_j, 1);
        }
        al.f(this.imL, R.color.cp_cont_b, 1);
        al.f(this.imO, R.color.cp_cont_b, 1);
        al.l(this.imP, R.color.cp_bg_line_b);
        al.l(this.imM, R.color.cp_bg_line_b);
        al.l(this.imQ, R.color.cp_bg_line_b);
        al.j(this.imS, R.color.cp_cont_h);
        this.imL.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(R.drawable.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
        Drawable S = al.S(i, R.drawable.icon_home_card_like_s);
        S.setBounds(0, 0, this.ine, this.ine);
        this.imS.setCompoundDrawables(S, null, null, null);
        al.k(this.imU, R.drawable.selector_give_gift_bg);
        al.c(this.imV, (int) R.drawable.selector_gift_icon);
        al.f(this.imW, R.color.selector_give_gift_text_color, 1);
        this.imX.onChangeSkinType(i);
        al.l(this.bMQ, R.color.cp_bg_line_e);
        for (int i3 = 0; i3 < this.imY.getChildCount(); i3++) {
            View childAt = this.imY.getChildAt(i3);
            if (childAt != null) {
                TextView textView = (TextView) childAt.findViewById(R.id.bar_name);
                textView.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(R.drawable.pic_v_avatar), (Drawable) null, (Drawable) null, (Drawable) null);
                al.j(textView, R.color.cp_cont_b);
                al.j((TextView) childAt.findViewById(R.id.bar_info), R.color.cp_cont_j);
            }
        }
        for (int i4 = 0; i4 < imB.length; i4++) {
            ((TbImageView) this.mRootView.findViewById(imB[i4])).setBackgroundDrawable(al.getDrawable(R.drawable.shape_gift_icon_bg));
        }
        al.l(this.ina, R.color.cp_bg_line_e);
        al.j(this.inb, R.color.cp_cont_b);
        al.j(this.inc, R.color.cp_cont_d);
        al.c(this.imC, (int) R.drawable.icon_arrow_gray_right_n);
        al.k(this.ind, R.drawable.selector_like_button_bg);
        al.f(this.ind, R.color.cp_cont_g, 1);
    }

    public void onDestory() {
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.g gVar) {
        this.imz = gVar;
        if (this.imH != null) {
            this.imH.setOnViewResponseListener(this.imz);
        }
        this.imT.setOnViewResponseListener(this.imz);
    }

    public void Ce(String str) {
        this.imD.ox(str);
    }

    protected void caw() {
        this.imD.setHasPendantStyle();
        this.imD.getHeadView().setIsRound(true);
        this.imD.getHeadView().setDrawBorder(false);
        this.imD.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    protected void bYz() {
        if (this.mUserData != null && (this.mUserData.getIsMem() > 0 || this.mUserData.isBigV())) {
            al.f(this.cbV, R.color.cp_cont_h, 1);
        } else {
            al.f(this.cbV, R.color.cp_cont_b, 1);
        }
    }

    private void cax() {
        if (this.imA != null && this.imA.car() != null) {
            this.imY.removeAllViews();
            int godType = this.imA.car().getGodType();
            if (godType == 2 && v.Z(this.imA.car().getForumGodList()) > 0) {
                this.imY.setVisibility(0);
                for (ForumGodDetailInfo forumGodDetailInfo : this.imA.car().getForumGodList()) {
                    if (forumGodDetailInfo != null) {
                        dO(forumGodDetailInfo.forum_name, forumGodDetailInfo.intro);
                    }
                }
                return;
            } else if (godType == 1 && this.imA.car().getgodDetailInfo() != null && !StringUtils.isNull(this.imA.car().getgodDetailInfo().intro)) {
                this.imY.setVisibility(0);
                dO(this.imA.car().getgodDetailInfo().intro, "");
                return;
            } else {
                return;
            }
        }
        this.imY.setVisibility(8);
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
        this.imY.addView(inflate, layoutParams);
    }

    private void cay() {
        int i;
        for (int i2 = 0; i2 < imB.length; i2++) {
            ((TbImageView) this.mRootView.findViewById(imB[i2])).setVisibility(8);
        }
        if (this.imA == null || this.imA.caq() == null || v.Z(this.imA.caq().ikI) <= 0) {
            i = 0;
        } else {
            int i3 = this.imA.caq().giftNum;
            List<com.baidu.adp.widget.ListView.m> list = this.imA.caq().ikI;
            for (int i4 = 0; i4 < list.size() && i4 < imB.length; i4++) {
                if (list.get(i4) instanceof com.baidu.tieba.personPolymeric.c.o) {
                    TbImageView tbImageView = (TbImageView) this.mRootView.findViewById(imB[i4]);
                    tbImageView.setVisibility(0);
                    tbImageView.setIsRound(true);
                    tbImageView.startLoad(((com.baidu.tieba.personPolymeric.c.o) list.get(i4)).picUrl, 10, false);
                }
            }
            i = i3;
        }
        this.inc.setText(String.format(this.mContext.getResources().getString(R.string.gift_num), Integer.valueOf(i)));
    }
}
