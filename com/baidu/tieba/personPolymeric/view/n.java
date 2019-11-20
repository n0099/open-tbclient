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
    private static final int[] itG = {R.id.img_gift_one, R.id.img_gift_two, R.id.img_gift_three};
    private View ceJ;
    protected TextView crw;
    private TextView dvs;
    private com.baidu.tbadk.core.view.userLike.c eLD;
    protected TbImageView imp;
    protected com.baidu.tieba.view.g itE;
    protected com.baidu.tieba.personPolymeric.c.a itF;
    protected ImageView itH;
    protected PersonHeadPendantView itI;
    protected UserIconBox itJ;
    protected TextView itK;
    protected TextView itL;
    public com.baidu.tieba.view.e itM;
    protected View itN;
    private TextView itO;
    private TextView itP;
    private TextView itQ;
    private View itR;
    private View itS;
    private TextView itT;
    private View itU;
    private View itV;
    private LinearLayout itW;
    private TextView itX;
    private m itY;
    private View itZ;
    private ImageView iua;
    private TextView iub;
    private BlueLikeButton iuc;
    private LinearLayout iud;
    private RelativeLayout iue;
    private View iuf;
    private TextView iug;
    private TextView iuh;
    private TextView iui;
    private int iuj;
    protected Context mContext;
    protected boolean mIsHost;
    private TbPageContext mPageContext;
    protected View mRootView;
    protected UserData mUserData;

    public n(TbPageContext tbPageContext, boolean z) {
        this.iuj = 0;
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.mIsHost = z;
        this.iuj = com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds46);
        W(aMv());
        TextView textView = this.itK;
        if (this.mIsHost) {
        }
        textView.setVisibility(8);
    }

    public View aMv() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.item_person_polymeric_header_view, (ViewGroup) null);
        }
        return this.mRootView;
    }

    public void W(View view) {
        this.itN = view.findViewById(R.id.person_info_root);
        this.itI = (PersonHeadPendantView) view.findViewById(R.id.person_polymeric_header_user_img);
        this.itI.getHeadView().setGodIconResId(R.drawable.pic_v_avatar_big);
        this.itI.getHeadView().setGodIconWidth(R.dimen.ds40);
        this.itI.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.itI.setDefalutResid(R.drawable.pic_mycenter_avatar_def_i);
        this.itI.setBigVIconResId(R.drawable.pic_v_avatar_big);
        this.itI.setBigVDimenSize(R.dimen.ds40);
        this.imp = (TbImageView) view.findViewById(R.id.person_polymeric_header_user_vip_icon);
        this.crw = (TextView) view.findViewById(R.id.person_polymeric_header_user_name_txt);
        this.itL = (TextView) view.findViewById(R.id.seal_prefix_view);
        this.itJ = (UserIconBox) view.findViewById(R.id.person_polymeric_header_label_box);
        this.itO = (TextView) view.findViewById(R.id.person_polymeric_header_bar_age_txt);
        this.dvs = (TextView) view.findViewById(R.id.person_polymeric_header_ala_id);
        this.itR = view.findViewById(R.id.divider_for_alaid_and_age);
        this.itK = (TextView) view.findViewById(R.id.person_polymeric_header_visitor_txt);
        this.itP = (TextView) view.findViewById(R.id.person_polymeric_header_sign_txt);
        this.itQ = (TextView) view.findViewById(R.id.person_center_header_tdou_txt);
        this.itT = (TextView) view.findViewById(R.id.textview_get_tdou);
        this.itU = view.findViewById(R.id.divider_for_age_and_tdou);
        this.itV = view.findViewById(R.id.divider_for_tdou_and_get_tdou);
        this.itW = (LinearLayout) view.findViewById(R.id.layout_user_name);
        this.itX = (TextView) view.findViewById(R.id.person_praise_number);
        this.itQ.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(R.drawable.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
        this.itM = (PersonHeaderAttentionView) view.findViewById(R.id.person_center_header_attention_container);
        cbs();
        this.itY = new m(this.mContext);
        this.imp.setOnClickListener(this.itY);
        this.itJ.setOnClickListener(this.itY);
        this.itI.setOnClickListener(this.itY);
        this.itK.setOnClickListener(this.itY);
        this.itL.setOnClickListener(this.itY);
        this.itQ.setOnClickListener(this.itY);
        this.itT.setOnClickListener(this.itY);
        this.crw.setOnClickListener(this.itY);
        this.itP.setOnClickListener(this.itY);
        this.itZ = (LinearLayout) view.findViewById(R.id.container_send_gift);
        this.iua = (ImageView) view.findViewById(R.id.icon_gift);
        this.iub = (TextView) view.findViewById(R.id.btn_give_gift);
        this.itZ.setOnClickListener(this.itY);
        this.iuc = (BlueLikeButton) view.findViewById(R.id.btn_like_blue);
        this.eLD = new com.baidu.tbadk.core.view.userLike.c(this.mPageContext, this.iuc);
        this.eLD.mX("2");
        if (this.mIsHost) {
            this.itZ.setVisibility(8);
            this.iuc.setVisibility(8);
        }
        this.iud = (LinearLayout) view.findViewById(R.id.layout_god_auth_forums);
        this.iud.setVisibility(8);
        this.ceJ = view.findViewById(R.id.header_bottom_divider);
        this.iue = (RelativeLayout) view.findViewById(R.id.layout_gift);
        this.iue.setOnClickListener(this.itY);
        this.iuf = view.findViewById(R.id.gift_top_divider);
        this.iug = (TextView) view.findViewById(R.id.textview_received_gift);
        this.iuh = (TextView) view.findViewById(R.id.textview_received_gift_num);
        this.itH = (ImageView) view.findViewById(R.id.img_gift_arrow);
        this.iui = (TextView) view.findViewById(R.id.btn_edit_person_info);
        this.iui.setOnClickListener(this.itY);
        if (!this.mIsHost) {
            this.iui.setVisibility(8);
        }
    }

    public void e(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null) {
            this.itF = aVar;
            this.mUserData = aVar.getUserData();
            this.itY.a(aVar);
            this.itY.setIsHost(this.mIsHost);
            this.itI.a(this.mUserData);
            UserVipInfoData userVipInfo = this.mUserData.getUserVipInfo();
            if (this.mUserData.getIsMem() > 0) {
                if (userVipInfo != null) {
                    this.imp.startLoad(userVipInfo.getVipIconUrl(), 10, false);
                }
                this.imp.setVisibility(0);
            } else if (this.mIsHost) {
                this.imp.setImageDrawable(am.getDrawable(R.drawable.icon_crown_super_non));
                this.imp.setVisibility(0);
            } else {
                this.imp.setVisibility(8);
            }
            bZv();
            String name_show = this.mUserData.getName_show();
            if (!TextUtils.isEmpty(name_show)) {
                this.crw.setText(name_show);
            }
            int i = R.drawable.icon_mask_boy_n_svg;
            if (this.mUserData != null) {
                i = this.mUserData.getSex() == 2 ? R.drawable.icon_mask_girl_n_svg : R.drawable.icon_mask_boy_n_svg;
            }
            this.crw.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.amL().a(i, null), (Drawable) null);
            this.itJ.a(this.mUserData.getIconInfo(), 9, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds42), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds42), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds10), true);
            if (this.itM != null) {
                this.itM.setData(this.mUserData);
            }
            if (this.mUserData != null && this.mUserData.alaUserData != null && this.mUserData.alaUserData.ala_id != 0) {
                this.dvs.setVisibility(0);
                this.itR.setVisibility(0);
                this.dvs.setText(String.format(this.mContext.getString(R.string.person_center_ala_id), Long.valueOf(this.mUserData.alaUserData.ala_id)));
            } else {
                this.dvs.setVisibility(8);
                this.itR.setVisibility(8);
            }
            this.itO.setText(String.format(this.mContext.getString(R.string.person_center_header_bar_age), this.mUserData.getTb_age()));
            if (this.mIsHost) {
                this.itU.setVisibility(0);
                this.itV.setVisibility(0);
                this.itQ.setVisibility(0);
                this.itT.setVisibility(0);
                this.itQ.setText(aq.formatNumForTdouDisPlay(this.mUserData.getTDouNum()));
            } else {
                this.itU.setVisibility(8);
                this.itV.setVisibility(8);
                this.itQ.setVisibility(8);
                this.itT.setVisibility(8);
            }
            String intro = this.mUserData.getIntro();
            if (StringUtils.isNull(intro)) {
                am.setViewTextColor(this.itP, R.color.cp_cont_e, 1);
            } else {
                am.setViewTextColor(this.itP, R.color.cp_cont_j, 1);
            }
            if (StringUtils.isNull(intro)) {
                if (this.mIsHost) {
                    intro = this.mContext.getString(R.string.no_person_sign_host);
                } else {
                    intro = this.mContext.getString(R.string.no_person_sign_guest);
                }
            }
            this.itP.setText(this.mContext.getString(R.string.person_sign) + intro);
            if (this.itP.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.itP.getLayoutParams();
                if (!this.mIsHost && this.itP.getLineCount() >= 3 && this.itP.getMaxLines() != 2147483646) {
                    int lineHeight = this.itP.getLineHeight();
                    this.itP.setHeight((lineHeight / 2) + (lineHeight * 3));
                }
                if (this.itP.getLineCount() >= 2) {
                    layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds19);
                } else {
                    layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds80);
                }
                this.itP.setLayoutParams(layoutParams);
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(this.mUserData.getUserId()) && ((!TbadkCoreApplication.isLogin() || (!StringUtils.isNull(currentAccount) && !currentAccount.equals(this.mUserData.getUserId()))) && this.mUserData.getLiveStatus() == 1)) {
                if (this.itS == null) {
                    this.itS = com.baidu.tbadk.ala.b.afa().l(this.mContext, 7);
                }
                com.baidu.tbadk.ala.a aVar2 = new com.baidu.tbadk.ala.a();
                aVar2.bTc = this.mUserData.getAlaUserData();
                aVar2.type = 7;
                if ((this.mUserData.getPersonPrivate() != null && this.mUserData.getPersonPrivate().atx() == 3) || (this.mUserData.getPersonPrivate().atx() == 2 && this.mUserData.getIsFriend() != 1)) {
                    aVar2.bTd = true;
                } else {
                    aVar2.bTd = false;
                }
                if (this.itS != null) {
                    this.itS.setTag(aVar2);
                    if (this.itS.getParent() == null) {
                        this.itW.addView(this.itS);
                        TiebaStatic.log(new an("c12541"));
                    }
                }
            } else if (this.itS != null) {
                this.itS.setVisibility(8);
            }
            a(aVar.irz);
            this.mUserData.setIsLike(this.mUserData.getHave_attention() == 1);
            this.eLD.a(this.mUserData);
            cbt();
            cbu();
            this.iug.setText(this.mIsHost ? R.string.my_received_gift : R.string.he_received_gift);
            if ((this.mUserData.getPersonPrivate() == null || this.mUserData.getPersonPrivate().atx() != 3) && this.mUserData.getPersonPrivate().atx() == 2 && this.mUserData.getIsFriend() != 1) {
            }
        }
    }

    public void Bu(String str) {
        if (!StringUtils.isNull(str)) {
            this.crw.setText(str);
        }
    }

    public void Bv(String str) {
        if (!StringUtils.isNull(str)) {
            if (this.mUserData != null) {
                this.mUserData.setPortrait(str);
            }
            this.itI.ov(str);
        }
    }

    private void a(UserAgreeInfo userAgreeInfo) {
        if (userAgreeInfo == null) {
            this.itX.setVisibility(8);
            return;
        }
        this.itX.setVisibility(0);
        String numFormatOverWan = aq.numFormatOverWan(userAgreeInfo.total_agree_num.longValue());
        Drawable drawable = am.getDrawable(R.drawable.icon_home_card_like_s);
        drawable.setBounds(0, 0, this.iuj, this.iuj);
        this.itX.setCompoundDrawables(drawable, null, null, null);
        this.itX.setText(numFormatOverWan);
    }

    public void onChangeSkinType(int i) {
        this.itN.setBackgroundDrawable(am.getDrawable(R.drawable.shape_user_info_bg));
        this.itI.setBackgroundViewDrawable(am.getDrawable(R.drawable.shape_user_img_bg));
        int i2 = R.drawable.icon_mask_boy_n_svg;
        if (this.mUserData != null) {
            i2 = this.mUserData.getSex() == 1 ? R.drawable.icon_mask_boy_n_svg : R.drawable.icon_mask_girl_n_svg;
        }
        if (this.mUserData != null && this.mUserData.getIsMem() <= 0 && this.imp != null && this.mIsHost) {
            this.imp.setImageDrawable(am.getDrawable(R.drawable.icon_crown_super_non));
        }
        bZv();
        am.setViewTextColor(this.itL, R.color.cp_link_tip_a, 1);
        this.crw.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SvgManager.amL().a(i2, null), (Drawable) null);
        if (this.itM != null) {
            this.itM.onChangeSkinType(i);
        }
        am.setViewTextColor(this.itK, R.color.cp_cont_b, 1);
        am.setViewTextColor(this.itO, R.color.cp_cont_b, 1);
        am.setViewTextColor(this.dvs, R.color.cp_cont_b, 1);
        if (this.mUserData == null || StringUtils.isNull(this.mUserData.getIntro())) {
            am.setViewTextColor(this.itP, R.color.cp_cont_e, 1);
        } else {
            am.setViewTextColor(this.itP, R.color.cp_cont_j, 1);
        }
        am.setViewTextColor(this.itQ, R.color.cp_cont_b, 1);
        am.setViewTextColor(this.itT, R.color.cp_cont_b, 1);
        am.setBackgroundColor(this.itU, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.itR, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.itV, R.color.cp_bg_line_c);
        am.setViewTextColor(this.itX, (int) R.color.cp_cont_h);
        this.itQ.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(R.drawable.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
        Drawable drawable = am.getDrawable(i, (int) R.drawable.icon_home_card_like_s);
        drawable.setBounds(0, 0, this.iuj, this.iuj);
        this.itX.setCompoundDrawables(drawable, null, null, null);
        am.setBackgroundResource(this.itZ, R.drawable.selector_give_gift_bg);
        am.setImageResource(this.iua, R.drawable.selector_gift_icon);
        am.setViewTextColor(this.iub, R.color.selector_give_gift_text_color, 1);
        this.iuc.onChangeSkinType(i);
        am.setBackgroundColor(this.ceJ, R.color.cp_bg_line_c);
        for (int i3 = 0; i3 < this.iud.getChildCount(); i3++) {
            View childAt = this.iud.getChildAt(i3);
            if (childAt != null) {
                TextView textView = (TextView) childAt.findViewById(R.id.bar_name);
                textView.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.pic_v_avatar), (Drawable) null, (Drawable) null, (Drawable) null);
                am.setViewTextColor(textView, (int) R.color.cp_cont_b);
                am.setViewTextColor((TextView) childAt.findViewById(R.id.bar_info), (int) R.color.cp_cont_j);
            }
        }
        for (int i4 = 0; i4 < itG.length; i4++) {
            ((TbImageView) this.mRootView.findViewById(itG[i4])).setBackgroundDrawable(am.getDrawable(R.drawable.shape_gift_icon_bg));
        }
        am.setBackgroundColor(this.iuf, R.color.cp_bg_line_c);
        am.setViewTextColor(this.iug, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.iuh, (int) R.color.cp_cont_d);
        SvgManager.amL().a(this.itH, R.drawable.icon_pure_list_arrow16_right_tint_n_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        am.setBackgroundResource(this.iui, R.drawable.selector_like_button_bg);
        am.setViewTextColor(this.iui, R.color.cp_cont_g, 1);
    }

    public void onDestory() {
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.g gVar) {
        this.itE = gVar;
        if (this.itM != null) {
            this.itM.setOnViewResponseListener(this.itE);
        }
        this.itY.setOnViewResponseListener(this.itE);
    }

    public void BM(String str) {
        this.itI.ou(str);
    }

    protected void cbs() {
        this.itI.setHasPendantStyle();
        this.itI.getHeadView().setIsRound(true);
        this.itI.getHeadView().setDrawBorder(false);
        this.itI.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    protected void bZv() {
        if (this.mUserData != null && (this.mUserData.getIsMem() > 0 || this.mUserData.isBigV())) {
            am.setViewTextColor(this.crw, R.color.cp_cont_h, 1);
        } else {
            am.setViewTextColor(this.crw, R.color.cp_cont_b, 1);
        }
    }

    private void cbt() {
        if (this.itF != null && this.itF.cbn() != null) {
            this.iud.removeAllViews();
            int godType = this.itF.cbn().getGodType();
            if (godType == 2 && v.getCount(this.itF.cbn().getForumGodList()) > 0) {
                this.iud.setVisibility(0);
                for (ForumGodDetailInfo forumGodDetailInfo : this.itF.cbn().getForumGodList()) {
                    if (forumGodDetailInfo != null) {
                        dD(forumGodDetailInfo.forum_name, forumGodDetailInfo.intro);
                    }
                }
                return;
            } else if (godType == 1 && this.itF.cbn().getgodDetailInfo() != null && !StringUtils.isNull(this.itF.cbn().getgodDetailInfo().intro)) {
                this.iud.setVisibility(0);
                dD(this.itF.cbn().getgodDetailInfo().intro, "");
                return;
            } else {
                return;
            }
        }
        this.iud.setVisibility(8);
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
        this.iud.addView(inflate, layoutParams);
    }

    private void cbu() {
        int i;
        for (int i2 = 0; i2 < itG.length; i2++) {
            ((TbImageView) this.mRootView.findViewById(itG[i2])).setVisibility(8);
        }
        if (this.itF == null || this.itF.cbm() == null || v.getCount(this.itF.cbm().irN) <= 0) {
            i = 0;
        } else {
            int i3 = this.itF.cbm().giftNum;
            List<com.baidu.adp.widget.ListView.m> list = this.itF.cbm().irN;
            for (int i4 = 0; i4 < list.size() && i4 < itG.length; i4++) {
                if (list.get(i4) instanceof com.baidu.tieba.personPolymeric.c.o) {
                    TbImageView tbImageView = (TbImageView) this.mRootView.findViewById(itG[i4]);
                    tbImageView.setVisibility(0);
                    tbImageView.setIsRound(true);
                    tbImageView.startLoad(((com.baidu.tieba.personPolymeric.c.o) list.get(i4)).picUrl, 10, false);
                }
            }
            i = i3;
        }
        this.iuh.setText(String.format(this.mContext.getResources().getString(R.string.gift_num), Integer.valueOf(i)));
    }
}
