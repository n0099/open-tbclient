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
    private static final int[] isT = {R.id.img_gift_one, R.id.img_gift_two, R.id.img_gift_three};
    private View bNS;
    protected TextView ccZ;
    private TextView dnf;
    private com.baidu.tbadk.core.view.userLike.c eBX;
    protected TbImageView ilq;
    protected com.baidu.tieba.view.g isR;
    protected com.baidu.tieba.personPolymeric.c.a isS;
    protected ImageView isU;
    protected PersonHeadPendantView isV;
    protected UserIconBox isW;
    protected TextView isX;
    protected TextView isY;
    public com.baidu.tieba.view.e isZ;
    protected View ita;
    private TextView itb;
    private TextView itc;
    private TextView itd;
    private View ite;
    private View itf;
    private TextView itg;
    private View ith;
    private View iti;
    private LinearLayout itj;
    private TextView itk;
    private m itl;
    private View itm;
    private ImageView itn;
    private TextView ito;
    private BlueLikeButton itp;
    private LinearLayout itq;
    private RelativeLayout itr;
    private View its;
    private TextView itt;
    private TextView itu;
    private TextView itv;
    private int itw;
    protected Context mContext;
    protected boolean mIsHost;
    private TbPageContext mPageContext;
    protected View mRootView;
    protected UserData mUserData;

    public n(TbPageContext tbPageContext, boolean z) {
        this.itw = 0;
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.mIsHost = z;
        this.itw = com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.tbds46);
        Q(aWR());
        TextView textView = this.isX;
        if (this.mIsHost) {
        }
        textView.setVisibility(8);
    }

    public View aWR() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.item_person_polymeric_header_view, (ViewGroup) null);
        }
        return this.mRootView;
    }

    public void Q(View view) {
        this.ita = view.findViewById(R.id.person_info_root);
        this.isV = (PersonHeadPendantView) view.findViewById(R.id.person_polymeric_header_user_img);
        this.isV.getHeadView().setGodIconResId(R.drawable.pic_v_avatar_big);
        this.isV.getHeadView().setGodIconWidth(R.dimen.ds40);
        this.isV.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.isV.setDefalutResid(R.drawable.pic_mycenter_avatar_def_i);
        this.isV.setBigVIconResId(R.drawable.pic_v_avatar_big);
        this.isV.setBigVDimenSize(R.dimen.ds40);
        this.ilq = (TbImageView) view.findViewById(R.id.person_polymeric_header_user_vip_icon);
        this.ccZ = (TextView) view.findViewById(R.id.person_polymeric_header_user_name_txt);
        this.isY = (TextView) view.findViewById(R.id.seal_prefix_view);
        this.isW = (UserIconBox) view.findViewById(R.id.person_polymeric_header_label_box);
        this.itb = (TextView) view.findViewById(R.id.person_polymeric_header_bar_age_txt);
        this.dnf = (TextView) view.findViewById(R.id.person_polymeric_header_ala_id);
        this.ite = view.findViewById(R.id.divider_for_alaid_and_age);
        this.isX = (TextView) view.findViewById(R.id.person_polymeric_header_visitor_txt);
        this.itc = (TextView) view.findViewById(R.id.person_polymeric_header_sign_txt);
        this.itd = (TextView) view.findViewById(R.id.person_center_header_tdou_txt);
        this.itg = (TextView) view.findViewById(R.id.textview_get_tdou);
        this.ith = view.findViewById(R.id.divider_for_age_and_tdou);
        this.iti = view.findViewById(R.id.divider_for_tdou_and_get_tdou);
        this.itj = (LinearLayout) view.findViewById(R.id.layout_user_name);
        this.itk = (TextView) view.findViewById(R.id.person_praise_number);
        this.itd.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(R.drawable.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
        this.isZ = (PersonHeaderAttentionView) view.findViewById(R.id.person_center_header_attention_container);
        cdm();
        this.itl = new m(this.mContext);
        this.ilq.setOnClickListener(this.itl);
        this.isW.setOnClickListener(this.itl);
        this.isV.setOnClickListener(this.itl);
        this.isX.setOnClickListener(this.itl);
        this.isY.setOnClickListener(this.itl);
        this.itd.setOnClickListener(this.itl);
        this.itg.setOnClickListener(this.itl);
        this.ccZ.setOnClickListener(this.itl);
        this.itc.setOnClickListener(this.itl);
        this.itm = (LinearLayout) view.findViewById(R.id.container_send_gift);
        this.itn = (ImageView) view.findViewById(R.id.icon_gift);
        this.ito = (TextView) view.findViewById(R.id.btn_give_gift);
        this.itm.setOnClickListener(this.itl);
        this.itp = (BlueLikeButton) view.findViewById(R.id.btn_like_blue);
        this.eBX = new com.baidu.tbadk.core.view.userLike.c(this.mPageContext, this.itp);
        this.eBX.setFromType("2");
        if (this.mIsHost) {
            this.itm.setVisibility(8);
            this.itp.setVisibility(8);
        }
        this.itq = (LinearLayout) view.findViewById(R.id.layout_god_auth_forums);
        this.itq.setVisibility(8);
        this.bNS = view.findViewById(R.id.header_bottom_divider);
        this.itr = (RelativeLayout) view.findViewById(R.id.layout_gift);
        this.itr.setOnClickListener(this.itl);
        this.its = view.findViewById(R.id.gift_top_divider);
        this.itt = (TextView) view.findViewById(R.id.textview_received_gift);
        this.itu = (TextView) view.findViewById(R.id.textview_received_gift_num);
        this.isU = (ImageView) view.findViewById(R.id.img_gift_arrow);
        this.itv = (TextView) view.findViewById(R.id.btn_edit_person_info);
        this.itv.setOnClickListener(this.itl);
        if (!this.mIsHost) {
            this.itv.setVisibility(8);
        }
    }

    public void e(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null) {
            this.isS = aVar;
            this.mUserData = aVar.getUserData();
            this.itl.a(aVar);
            this.itl.setIsHost(this.mIsHost);
            this.isV.a(this.mUserData);
            UserVipInfoData userVipInfo = this.mUserData.getUserVipInfo();
            if (this.mUserData.getIsMem() > 0) {
                if (userVipInfo != null) {
                    this.ilq.startLoad(userVipInfo.getVipIconUrl(), 10, false);
                }
                this.ilq.setVisibility(0);
            } else if (this.mIsHost) {
                this.ilq.setImageDrawable(am.getDrawable(R.drawable.icon_crown_super_non));
                this.ilq.setVisibility(0);
            } else {
                this.ilq.setVisibility(8);
            }
            cbp();
            String name_show = this.mUserData.getName_show();
            if (!TextUtils.isEmpty(name_show)) {
                this.ccZ.setText(name_show);
            }
            int i = R.drawable.icon_mine_boy;
            if (this.mUserData != null) {
                i = this.mUserData.getSex() == 2 ? R.drawable.icon_mine_girl : R.drawable.icon_mine_boy;
            }
            this.ccZ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mContext.getResources().getDrawable(i), (Drawable) null);
            this.isW.a(this.mUserData.getIconInfo(), 9, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds42), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds42), this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds10), true);
            if (this.isZ != null) {
                this.isZ.setData(this.mUserData);
            }
            if (this.mUserData != null && this.mUserData.alaUserData != null && this.mUserData.alaUserData.ala_id != 0) {
                this.dnf.setVisibility(0);
                this.ite.setVisibility(0);
                this.dnf.setText(String.format(this.mContext.getString(R.string.person_center_ala_id), Long.valueOf(this.mUserData.alaUserData.ala_id)));
            } else {
                this.dnf.setVisibility(8);
                this.ite.setVisibility(8);
            }
            this.itb.setText(String.format(this.mContext.getString(R.string.person_center_header_bar_age), this.mUserData.getTb_age()));
            if (this.mIsHost) {
                this.ith.setVisibility(0);
                this.iti.setVisibility(0);
                this.itd.setVisibility(0);
                this.itg.setVisibility(0);
                this.itd.setText(aq.aV(this.mUserData.getTDouNum()));
            } else {
                this.ith.setVisibility(8);
                this.iti.setVisibility(8);
                this.itd.setVisibility(8);
                this.itg.setVisibility(8);
            }
            String intro = this.mUserData.getIntro();
            if (StringUtils.isNull(intro)) {
                am.f(this.itc, R.color.cp_cont_e, 1);
            } else {
                am.f(this.itc, R.color.cp_cont_j, 1);
            }
            if (StringUtils.isNull(intro)) {
                if (this.mIsHost) {
                    intro = this.mContext.getString(R.string.no_person_sign_host);
                } else {
                    intro = this.mContext.getString(R.string.no_person_sign_guest);
                }
            }
            this.itc.setText(this.mContext.getString(R.string.person_sign) + intro);
            if (this.itc.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.itc.getLayoutParams();
                if (!this.mIsHost && this.itc.getLineCount() >= 3 && this.itc.getMaxLines() != 2147483646) {
                    int lineHeight = this.itc.getLineHeight();
                    this.itc.setHeight((lineHeight / 2) + (lineHeight * 3));
                }
                if (this.itc.getLineCount() >= 2) {
                    layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds19);
                } else {
                    layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds80);
                }
                this.itc.setLayoutParams(layoutParams);
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(this.mUserData.getUserId()) && ((!TbadkCoreApplication.isLogin() || (!StringUtils.isNull(currentAccount) && !currentAccount.equals(this.mUserData.getUserId()))) && this.mUserData.getLiveStatus() == 1)) {
                if (this.itf == null) {
                    this.itf = com.baidu.tbadk.ala.b.aak().n(this.mContext, 7);
                }
                com.baidu.tbadk.ala.a aVar2 = new com.baidu.tbadk.ala.a();
                aVar2.bAN = this.mUserData.getAlaUserData();
                aVar2.type = 7;
                if ((this.mUserData.getPersonPrivate() != null && this.mUserData.getPersonPrivate().arx() == 3) || (this.mUserData.getPersonPrivate().arx() == 2 && this.mUserData.getIsFriend() != 1)) {
                    aVar2.bAO = true;
                } else {
                    aVar2.bAO = false;
                }
                if (this.itf != null) {
                    this.itf.setTag(aVar2);
                    if (this.itf.getParent() == null) {
                        this.itj.addView(this.itf);
                        TiebaStatic.log(new an("c12541"));
                    }
                }
            } else if (this.itf != null) {
                this.itf.setVisibility(8);
            }
            a(aVar.iqN);
            this.mUserData.setIsLike(this.mUserData.getHave_attention() == 1);
            this.eBX.a(this.mUserData);
            cdn();
            cdo();
            this.itt.setText(this.mIsHost ? R.string.my_received_gift : R.string.he_received_gift);
            if ((this.mUserData.getPersonPrivate() == null || this.mUserData.getPersonPrivate().arx() != 3) && this.mUserData.getPersonPrivate().arx() == 2 && this.mUserData.getIsFriend() != 1) {
            }
        }
    }

    public void CB(String str) {
        if (!StringUtils.isNull(str)) {
            this.ccZ.setText(str);
        }
    }

    public void CC(String str) {
        if (!StringUtils.isNull(str)) {
            if (this.mUserData != null) {
                this.mUserData.setPortrait(str);
            }
            this.isV.oO(str);
        }
    }

    private void a(UserAgreeInfo userAgreeInfo) {
        if (userAgreeInfo == null) {
            this.itk.setVisibility(8);
            return;
        }
        this.itk.setVisibility(0);
        String aO = aq.aO(userAgreeInfo.total_agree_num.longValue());
        Drawable drawable = am.getDrawable(R.drawable.icon_home_card_like_s);
        drawable.setBounds(0, 0, this.itw, this.itw);
        this.itk.setCompoundDrawables(drawable, null, null, null);
        this.itk.setText(aO);
    }

    public void onChangeSkinType(int i) {
        this.ita.setBackgroundDrawable(am.getDrawable(R.drawable.shape_user_info_bg));
        this.isV.setBackgroundViewDrawable(am.getDrawable(R.drawable.shape_user_img_bg));
        int i2 = R.drawable.icon_mine_boy;
        if (this.mUserData != null) {
            i2 = this.mUserData.getSex() == 1 ? R.drawable.icon_mine_boy : R.drawable.icon_pop_girl;
        }
        if (this.mUserData != null && this.mUserData.getIsMem() <= 0 && this.ilq != null && this.mIsHost) {
            this.ilq.setImageDrawable(am.getDrawable(R.drawable.icon_crown_super_non));
        }
        cbp();
        am.f(this.isY, R.color.cp_link_tip_a, 1);
        this.ccZ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mContext.getResources().getDrawable(i2), (Drawable) null);
        if (this.isZ != null) {
            this.isZ.onChangeSkinType(i);
        }
        am.f(this.isX, R.color.cp_cont_b, 1);
        am.f(this.itb, R.color.cp_cont_b, 1);
        am.f(this.dnf, R.color.cp_cont_b, 1);
        if (this.mUserData == null || StringUtils.isNull(this.mUserData.getIntro())) {
            am.f(this.itc, R.color.cp_cont_e, 1);
        } else {
            am.f(this.itc, R.color.cp_cont_j, 1);
        }
        am.f(this.itd, R.color.cp_cont_b, 1);
        am.f(this.itg, R.color.cp_cont_b, 1);
        am.l(this.ith, R.color.cp_bg_line_b);
        am.l(this.ite, R.color.cp_bg_line_b);
        am.l(this.iti, R.color.cp_bg_line_b);
        am.j(this.itk, R.color.cp_cont_h);
        this.itd.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(R.drawable.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
        Drawable V = am.V(i, R.drawable.icon_home_card_like_s);
        V.setBounds(0, 0, this.itw, this.itw);
        this.itk.setCompoundDrawables(V, null, null, null);
        am.k(this.itm, R.drawable.selector_give_gift_bg);
        am.c(this.itn, (int) R.drawable.selector_gift_icon);
        am.f(this.ito, R.color.selector_give_gift_text_color, 1);
        this.itp.onChangeSkinType(i);
        am.l(this.bNS, R.color.cp_bg_line_e);
        for (int i3 = 0; i3 < this.itq.getChildCount(); i3++) {
            View childAt = this.itq.getChildAt(i3);
            if (childAt != null) {
                TextView textView = (TextView) childAt.findViewById(R.id.bar_name);
                textView.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.pic_v_avatar), (Drawable) null, (Drawable) null, (Drawable) null);
                am.j(textView, R.color.cp_cont_b);
                am.j((TextView) childAt.findViewById(R.id.bar_info), R.color.cp_cont_j);
            }
        }
        for (int i4 = 0; i4 < isT.length; i4++) {
            ((TbImageView) this.mRootView.findViewById(isT[i4])).setBackgroundDrawable(am.getDrawable(R.drawable.shape_gift_icon_bg));
        }
        am.l(this.its, R.color.cp_bg_line_e);
        am.j(this.itt, R.color.cp_cont_b);
        am.j(this.itu, R.color.cp_cont_d);
        am.c(this.isU, (int) R.drawable.icon_arrow_gray_right_n);
        am.k(this.itv, R.drawable.selector_like_button_bg);
        am.f(this.itv, R.color.cp_cont_g, 1);
    }

    public void onDestory() {
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.g gVar) {
        this.isR = gVar;
        if (this.isZ != null) {
            this.isZ.setOnViewResponseListener(this.isR);
        }
        this.itl.setOnViewResponseListener(this.isR);
    }

    public void CT(String str) {
        this.isV.oN(str);
    }

    protected void cdm() {
        this.isV.setHasPendantStyle();
        this.isV.getHeadView().setIsRound(true);
        this.isV.getHeadView().setDrawBorder(false);
        this.isV.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    protected void cbp() {
        if (this.mUserData != null && (this.mUserData.getIsMem() > 0 || this.mUserData.isBigV())) {
            am.f(this.ccZ, R.color.cp_cont_h, 1);
        } else {
            am.f(this.ccZ, R.color.cp_cont_b, 1);
        }
    }

    private void cdn() {
        if (this.isS != null && this.isS.cdh() != null) {
            this.itq.removeAllViews();
            int godType = this.isS.cdh().getGodType();
            if (godType == 2 && v.Z(this.isS.cdh().getForumGodList()) > 0) {
                this.itq.setVisibility(0);
                for (ForumGodDetailInfo forumGodDetailInfo : this.isS.cdh().getForumGodList()) {
                    if (forumGodDetailInfo != null) {
                        dP(forumGodDetailInfo.forum_name, forumGodDetailInfo.intro);
                    }
                }
                return;
            } else if (godType == 1 && this.isS.cdh().getgodDetailInfo() != null && !StringUtils.isNull(this.isS.cdh().getgodDetailInfo().intro)) {
                this.itq.setVisibility(0);
                dP(this.isS.cdh().getgodDetailInfo().intro, "");
                return;
            } else {
                return;
            }
        }
        this.itq.setVisibility(8);
    }

    private void dP(String str, String str2) {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.layout_god_auth_info, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.bar_name);
        textView.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.pic_v_avatar), (Drawable) null, (Drawable) null, (Drawable) null);
        am.j(textView, R.color.cp_cont_b);
        textView.setText(str);
        TextView textView2 = (TextView) inflate.findViewById(R.id.bar_info);
        am.j(textView2, R.color.cp_cont_j);
        textView2.setText(str2);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds14);
        this.itq.addView(inflate, layoutParams);
    }

    private void cdo() {
        int i;
        for (int i2 = 0; i2 < isT.length; i2++) {
            ((TbImageView) this.mRootView.findViewById(isT[i2])).setVisibility(8);
        }
        if (this.isS == null || this.isS.cdg() == null || v.Z(this.isS.cdg().irb) <= 0) {
            i = 0;
        } else {
            int i3 = this.isS.cdg().giftNum;
            List<com.baidu.adp.widget.ListView.m> list = this.isS.cdg().irb;
            for (int i4 = 0; i4 < list.size() && i4 < isT.length; i4++) {
                if (list.get(i4) instanceof com.baidu.tieba.personPolymeric.c.o) {
                    TbImageView tbImageView = (TbImageView) this.mRootView.findViewById(isT[i4]);
                    tbImageView.setVisibility(0);
                    tbImageView.setIsRound(true);
                    tbImageView.startLoad(((com.baidu.tieba.personPolymeric.c.o) list.get(i4)).picUrl, 10, false);
                }
            }
            i = i3;
        }
        this.itu.setText(String.format(this.mContext.getResources().getString(R.string.gift_num), Integer.valueOf(i)));
    }
}
