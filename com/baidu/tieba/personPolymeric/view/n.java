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
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
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
    private static final int[] iux = {R.id.img_gift_one, R.id.img_gift_two, R.id.img_gift_three};
    private View cfA;
    protected TextView csn;
    private TextView dwj;
    private com.baidu.tbadk.core.view.userLike.c eMu;
    protected TbImageView ing;
    protected UserIconBox iuA;
    protected TextView iuB;
    protected TextView iuC;
    public com.baidu.tieba.view.e iuD;
    protected View iuE;
    private TextView iuF;
    private TextView iuG;
    private TextView iuH;
    private View iuI;
    private View iuJ;
    private TextView iuK;
    private View iuL;
    private View iuM;
    private LinearLayout iuN;
    private TextView iuO;
    private m iuP;
    private View iuQ;
    private ImageView iuR;
    private TextView iuS;
    private BlueLikeButton iuT;
    private LinearLayout iuU;
    private RelativeLayout iuV;
    private View iuW;
    private TextView iuX;
    private TextView iuY;
    private TextView iuZ;
    protected com.baidu.tieba.view.g iuv;
    protected com.baidu.tieba.personPolymeric.c.a iuw;
    protected ImageView iuy;
    protected PersonHeadPendantView iuz;
    private int iva;
    protected Context mContext;
    protected boolean mIsHost;
    private TbPageContext mPageContext;
    protected View mRootView;
    protected UserData mUserData;

    public n(TbPageContext tbPageContext, boolean z) {
        this.iva = 0;
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.mIsHost = z;
        this.iva = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds46);
        W(aMx());
        TextView textView = this.iuB;
        if (this.mIsHost) {
        }
        textView.setVisibility(8);
    }

    public View aMx() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.item_person_polymeric_header_view, (ViewGroup) null);
        }
        return this.mRootView;
    }

    public void W(View view) {
        this.iuE = view.findViewById(R.id.person_info_root);
        this.iuz = (PersonHeadPendantView) view.findViewById(R.id.person_polymeric_header_user_img);
        this.iuz.getHeadView().setGodIconResId(R.drawable.pic_v_avatar_big);
        this.iuz.getHeadView().setGodIconWidth(R.dimen.ds40);
        this.iuz.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.iuz.setDefalutResid(R.drawable.pic_mycenter_avatar_def_i);
        this.iuz.setBigVIconResId(R.drawable.pic_v_avatar_big);
        this.iuz.setBigVDimenSize(R.dimen.ds40);
        this.ing = (TbImageView) view.findViewById(R.id.person_polymeric_header_user_vip_icon);
        this.csn = (TextView) view.findViewById(R.id.person_polymeric_header_user_name_txt);
        this.iuC = (TextView) view.findViewById(R.id.seal_prefix_view);
        this.iuA = (UserIconBox) view.findViewById(R.id.person_polymeric_header_label_box);
        this.iuF = (TextView) view.findViewById(R.id.person_polymeric_header_bar_age_txt);
        this.dwj = (TextView) view.findViewById(R.id.person_polymeric_header_ala_id);
        this.iuI = view.findViewById(R.id.divider_for_alaid_and_age);
        this.iuB = (TextView) view.findViewById(R.id.person_polymeric_header_visitor_txt);
        this.iuG = (TextView) view.findViewById(R.id.person_polymeric_header_sign_txt);
        this.iuH = (TextView) view.findViewById(R.id.person_center_header_tdou_txt);
        this.iuK = (TextView) view.findViewById(R.id.textview_get_tdou);
        this.iuL = view.findViewById(R.id.divider_for_age_and_tdou);
        this.iuM = view.findViewById(R.id.divider_for_tdou_and_get_tdou);
        this.iuN = (LinearLayout) view.findViewById(R.id.layout_user_name);
        this.iuO = (TextView) view.findViewById(R.id.person_praise_number);
        this.iuH.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(R.drawable.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
        this.iuD = (PersonHeaderAttentionView) view.findViewById(R.id.person_center_header_attention_container);
        cbu();
        this.iuP = new m(this.mContext);
        this.ing.setOnClickListener(this.iuP);
        this.iuA.setOnClickListener(this.iuP);
        this.iuz.setOnClickListener(this.iuP);
        this.iuB.setOnClickListener(this.iuP);
        this.iuC.setOnClickListener(this.iuP);
        this.iuH.setOnClickListener(this.iuP);
        this.iuK.setOnClickListener(this.iuP);
        this.csn.setOnClickListener(this.iuP);
        this.iuG.setOnClickListener(this.iuP);
        this.iuQ = (LinearLayout) view.findViewById(R.id.container_send_gift);
        this.iuR = (ImageView) view.findViewById(R.id.icon_gift);
        this.iuS = (TextView) view.findViewById(R.id.btn_give_gift);
        this.iuQ.setOnClickListener(this.iuP);
        this.iuT = (BlueLikeButton) view.findViewById(R.id.btn_like_blue);
        this.eMu = new com.baidu.tbadk.core.view.userLike.c(this.mPageContext, this.iuT);
        this.eMu.mX("2");
        if (this.mIsHost) {
            this.iuQ.setVisibility(8);
            this.iuT.setVisibility(8);
        }
        this.iuU = (LinearLayout) view.findViewById(R.id.layout_god_auth_forums);
        this.iuU.setVisibility(8);
        this.cfA = view.findViewById(R.id.header_bottom_divider);
        this.iuV = (RelativeLayout) view.findViewById(R.id.layout_gift);
        this.iuV.setOnClickListener(this.iuP);
        this.iuW = view.findViewById(R.id.gift_top_divider);
        this.iuX = (TextView) view.findViewById(R.id.textview_received_gift);
        this.iuY = (TextView) view.findViewById(R.id.textview_received_gift_num);
        this.iuy = (ImageView) view.findViewById(R.id.img_gift_arrow);
        this.iuZ = (TextView) view.findViewById(R.id.btn_edit_person_info);
        this.iuZ.setOnClickListener(this.iuP);
        if (!this.mIsHost) {
            this.iuZ.setVisibility(8);
        }
    }

    public void e(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null) {
            this.iuw = aVar;
            this.mUserData = aVar.getUserData();
            this.iuP.a(aVar);
            this.iuP.setIsHost(this.mIsHost);
            this.iuz.a(this.mUserData);
            UserVipInfoData userVipInfo = this.mUserData.getUserVipInfo();
            if (this.mUserData.getIsMem() > 0) {
                if (userVipInfo != null) {
                    this.ing.startLoad(userVipInfo.getVipIconUrl(), 10, false);
                }
                this.ing.setVisibility(0);
            } else if (this.mIsHost) {
                this.ing.setImageDrawable(am.getDrawable(R.drawable.icon_crown_super_non));
                this.ing.setVisibility(0);
            } else {
                this.ing.setVisibility(8);
            }
            bZx();
            String name_show = this.mUserData.getName_show();
            if (!TextUtils.isEmpty(name_show)) {
                this.csn.setText(name_show);
            }
            int i = R.drawable.icon_mask_boy_n_svg;
            if (this.mUserData != null) {
                i = this.mUserData.getSex() == 2 ? R.drawable.icon_mask_girl_n_svg : R.drawable.icon_mask_boy_n_svg;
            }
            this.csn.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.amN().a(i, null), (Drawable) null);
            this.iuA.a(this.mUserData.getIconInfo(), 9, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds42), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds42), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds10), true);
            if (this.iuD != null) {
                this.iuD.setData(this.mUserData);
            }
            if (this.mUserData != null && this.mUserData.alaUserData != null && this.mUserData.alaUserData.ala_id != 0) {
                this.dwj.setVisibility(0);
                this.iuI.setVisibility(0);
                this.dwj.setText(String.format(this.mContext.getString(R.string.person_center_ala_id), Long.valueOf(this.mUserData.alaUserData.ala_id)));
            } else {
                this.dwj.setVisibility(8);
                this.iuI.setVisibility(8);
            }
            this.iuF.setText(String.format(this.mContext.getString(R.string.person_center_header_bar_age), this.mUserData.getTb_age()));
            if (this.mIsHost) {
                this.iuL.setVisibility(0);
                this.iuM.setVisibility(0);
                this.iuH.setVisibility(0);
                this.iuK.setVisibility(0);
                this.iuH.setText(aq.formatNumForTdouDisPlay(this.mUserData.getTDouNum()));
            } else {
                this.iuL.setVisibility(8);
                this.iuM.setVisibility(8);
                this.iuH.setVisibility(8);
                this.iuK.setVisibility(8);
            }
            String intro = this.mUserData.getIntro();
            if (StringUtils.isNull(intro)) {
                am.setViewTextColor(this.iuG, R.color.cp_cont_e, 1);
            } else {
                am.setViewTextColor(this.iuG, R.color.cp_cont_j, 1);
            }
            if (StringUtils.isNull(intro)) {
                if (this.mIsHost) {
                    intro = this.mContext.getString(R.string.no_person_sign_host);
                } else {
                    intro = this.mContext.getString(R.string.no_person_sign_guest);
                }
            }
            this.iuG.setText(this.mContext.getString(R.string.person_sign) + intro);
            if (this.iuG.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iuG.getLayoutParams();
                if (!this.mIsHost && this.iuG.getLineCount() >= 3 && this.iuG.getMaxLines() != 2147483646) {
                    int lineHeight = this.iuG.getLineHeight();
                    this.iuG.setHeight((lineHeight / 2) + (lineHeight * 3));
                }
                if (this.iuG.getLineCount() >= 2) {
                    layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds19);
                } else {
                    layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds80);
                }
                this.iuG.setLayoutParams(layoutParams);
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(this.mUserData.getUserId()) && ((!TbadkCoreApplication.isLogin() || (!StringUtils.isNull(currentAccount) && !currentAccount.equals(this.mUserData.getUserId()))) && this.mUserData.getLiveStatus() == 1)) {
                if (this.iuJ == null) {
                    this.iuJ = com.baidu.tbadk.ala.b.afc().l(this.mContext, 7);
                }
                com.baidu.tbadk.ala.a aVar2 = new com.baidu.tbadk.ala.a();
                aVar2.bTT = this.mUserData.getAlaUserData();
                aVar2.type = 7;
                if ((this.mUserData.getPersonPrivate() != null && this.mUserData.getPersonPrivate().atz() == 3) || (this.mUserData.getPersonPrivate().atz() == 2 && this.mUserData.getIsFriend() != 1)) {
                    aVar2.bTU = true;
                } else {
                    aVar2.bTU = false;
                }
                if (this.iuJ != null) {
                    this.iuJ.setTag(aVar2);
                    if (this.iuJ.getParent() == null) {
                        this.iuN.addView(this.iuJ);
                        TiebaStatic.log(new an("c12541"));
                    }
                }
            } else if (this.iuJ != null) {
                this.iuJ.setVisibility(8);
            }
            a(aVar.isq);
            this.mUserData.setIsLike(this.mUserData.getHave_attention() == 1);
            this.eMu.a(this.mUserData);
            cbv();
            cbw();
            this.iuX.setText(this.mIsHost ? R.string.my_received_gift : R.string.he_received_gift);
            if ((this.mUserData.getPersonPrivate() == null || this.mUserData.getPersonPrivate().atz() != 3) && this.mUserData.getPersonPrivate().atz() == 2 && this.mUserData.getIsFriend() != 1) {
            }
        }
    }

    public void Bu(String str) {
        if (!StringUtils.isNull(str)) {
            this.csn.setText(str);
        }
    }

    public void Bv(String str) {
        if (!StringUtils.isNull(str)) {
            if (this.mUserData != null) {
                this.mUserData.setPortrait(str);
            }
            this.iuz.ov(str);
        }
    }

    private void a(UserAgreeInfo userAgreeInfo) {
        if (userAgreeInfo == null) {
            this.iuO.setVisibility(8);
            return;
        }
        this.iuO.setVisibility(0);
        String numFormatOverWan = aq.numFormatOverWan(userAgreeInfo.total_agree_num.longValue());
        Drawable drawable = am.getDrawable(R.drawable.icon_home_card_like_s);
        drawable.setBounds(0, 0, this.iva, this.iva);
        this.iuO.setCompoundDrawables(drawable, null, null, null);
        this.iuO.setText(numFormatOverWan);
    }

    public void onChangeSkinType(int i) {
        this.iuE.setBackgroundDrawable(am.getDrawable(R.drawable.shape_user_info_bg));
        this.iuz.setBackgroundViewDrawable(am.getDrawable(R.drawable.shape_user_img_bg));
        int i2 = R.drawable.icon_mask_boy_n_svg;
        if (this.mUserData != null) {
            i2 = this.mUserData.getSex() == 1 ? R.drawable.icon_mask_boy_n_svg : R.drawable.icon_mask_girl_n_svg;
        }
        if (this.mUserData != null && this.mUserData.getIsMem() <= 0 && this.ing != null && this.mIsHost) {
            this.ing.setImageDrawable(am.getDrawable(R.drawable.icon_crown_super_non));
        }
        bZx();
        am.setViewTextColor(this.iuC, R.color.cp_link_tip_a, 1);
        this.csn.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.amN().a(i2, null), (Drawable) null);
        if (this.iuD != null) {
            this.iuD.onChangeSkinType(i);
        }
        am.setViewTextColor(this.iuB, R.color.cp_cont_b, 1);
        am.setViewTextColor(this.iuF, R.color.cp_cont_b, 1);
        am.setViewTextColor(this.dwj, R.color.cp_cont_b, 1);
        if (this.mUserData == null || StringUtils.isNull(this.mUserData.getIntro())) {
            am.setViewTextColor(this.iuG, R.color.cp_cont_e, 1);
        } else {
            am.setViewTextColor(this.iuG, R.color.cp_cont_j, 1);
        }
        am.setViewTextColor(this.iuH, R.color.cp_cont_b, 1);
        am.setViewTextColor(this.iuK, R.color.cp_cont_b, 1);
        am.setBackgroundColor(this.iuL, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.iuI, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.iuM, R.color.cp_bg_line_c);
        am.setViewTextColor(this.iuO, (int) R.color.cp_cont_h);
        this.iuH.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(R.drawable.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
        Drawable drawable = am.getDrawable(i, (int) R.drawable.icon_home_card_like_s);
        drawable.setBounds(0, 0, this.iva, this.iva);
        this.iuO.setCompoundDrawables(drawable, null, null, null);
        am.setBackgroundResource(this.iuQ, R.drawable.selector_give_gift_bg);
        am.setImageResource(this.iuR, R.drawable.selector_gift_icon);
        am.setViewTextColor(this.iuS, R.color.selector_give_gift_text_color, 1);
        this.iuT.onChangeSkinType(i);
        am.setBackgroundColor(this.cfA, R.color.cp_bg_line_c);
        for (int i3 = 0; i3 < this.iuU.getChildCount(); i3++) {
            View childAt = this.iuU.getChildAt(i3);
            if (childAt != null) {
                TextView textView = (TextView) childAt.findViewById(R.id.bar_name);
                textView.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.pic_v_avatar), (Drawable) null, (Drawable) null, (Drawable) null);
                am.setViewTextColor(textView, (int) R.color.cp_cont_b);
                am.setViewTextColor((TextView) childAt.findViewById(R.id.bar_info), (int) R.color.cp_cont_j);
            }
        }
        for (int i4 = 0; i4 < iux.length; i4++) {
            ((TbImageView) this.mRootView.findViewById(iux[i4])).setBackgroundDrawable(am.getDrawable(R.drawable.shape_gift_icon_bg));
        }
        am.setBackgroundColor(this.iuW, R.color.cp_bg_line_c);
        am.setViewTextColor(this.iuX, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.iuY, (int) R.color.cp_cont_d);
        SvgManager.amN().a(this.iuy, R.drawable.icon_pure_list_arrow16_right_tint_n_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        am.setBackgroundResource(this.iuZ, R.drawable.selector_like_button_bg);
        am.setViewTextColor(this.iuZ, R.color.cp_cont_g, 1);
    }

    public void onDestory() {
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.g gVar) {
        this.iuv = gVar;
        if (this.iuD != null) {
            this.iuD.setOnViewResponseListener(this.iuv);
        }
        this.iuP.setOnViewResponseListener(this.iuv);
    }

    public void BM(String str) {
        this.iuz.ou(str);
    }

    protected void cbu() {
        this.iuz.setHasPendantStyle();
        this.iuz.getHeadView().setIsRound(true);
        this.iuz.getHeadView().setDrawBorder(false);
        this.iuz.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    protected void bZx() {
        if (this.mUserData != null && (this.mUserData.getIsMem() > 0 || this.mUserData.isBigV())) {
            am.setViewTextColor(this.csn, R.color.cp_cont_h, 1);
        } else {
            am.setViewTextColor(this.csn, R.color.cp_cont_b, 1);
        }
    }

    private void cbv() {
        if (this.iuw != null && this.iuw.cbp() != null) {
            this.iuU.removeAllViews();
            int godType = this.iuw.cbp().getGodType();
            if (godType == 2 && v.getCount(this.iuw.cbp().getForumGodList()) > 0) {
                this.iuU.setVisibility(0);
                for (ForumGodDetailInfo forumGodDetailInfo : this.iuw.cbp().getForumGodList()) {
                    if (forumGodDetailInfo != null) {
                        dD(forumGodDetailInfo.forum_name, forumGodDetailInfo.intro);
                    }
                }
                return;
            } else if (godType == 1 && this.iuw.cbp().getgodDetailInfo() != null && !StringUtils.isNull(this.iuw.cbp().getgodDetailInfo().intro)) {
                this.iuU.setVisibility(0);
                dD(this.iuw.cbp().getgodDetailInfo().intro, "");
                return;
            } else {
                return;
            }
        }
        this.iuU.setVisibility(8);
    }

    private void dD(String str, String str2) {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.layout_god_auth_info, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.bar_name);
        textView.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.pic_v_avatar), (Drawable) null, (Drawable) null, (Drawable) null);
        am.setViewTextColor(textView, (int) R.color.cp_cont_b);
        textView.setText(str);
        TextView textView2 = (TextView) inflate.findViewById(R.id.bar_info);
        am.setViewTextColor(textView2, (int) R.color.cp_cont_j);
        textView2.setText(str2);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds14);
        this.iuU.addView(inflate, layoutParams);
    }

    private void cbw() {
        int i;
        for (int i2 = 0; i2 < iux.length; i2++) {
            ((TbImageView) this.mRootView.findViewById(iux[i2])).setVisibility(8);
        }
        if (this.iuw == null || this.iuw.cbo() == null || v.getCount(this.iuw.cbo().isE) <= 0) {
            i = 0;
        } else {
            int i3 = this.iuw.cbo().giftNum;
            List<com.baidu.adp.widget.ListView.m> list = this.iuw.cbo().isE;
            for (int i4 = 0; i4 < list.size() && i4 < iux.length; i4++) {
                if (list.get(i4) instanceof com.baidu.tieba.personPolymeric.c.o) {
                    TbImageView tbImageView = (TbImageView) this.mRootView.findViewById(iux[i4]);
                    tbImageView.setVisibility(0);
                    tbImageView.setIsRound(true);
                    tbImageView.startLoad(((com.baidu.tieba.personPolymeric.c.o) list.get(i4)).picUrl, 10, false);
                }
            }
            i = i3;
        }
        this.iuY.setText(String.format(this.mContext.getResources().getString(R.string.gift_num), Integer.valueOf(i)));
    }
}
