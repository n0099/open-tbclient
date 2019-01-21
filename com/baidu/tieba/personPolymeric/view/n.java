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
    private static final int[] gDZ = {e.g.img_gift_one, e.g.img_gift_two, e.g.img_gift_three};
    protected TextView aLy;
    private TextView bON;
    private com.baidu.tbadk.core.view.userLike.c cXP;
    private View euU;
    protected com.baidu.tieba.view.g gDX;
    protected com.baidu.tieba.personPolymeric.c.a gDY;
    private TextView gEA;
    private TextView gEB;
    private int gEC;
    protected ImageView gEa;
    protected PersonHeadPendantView gEb;
    protected UserIconBox gEc;
    protected TextView gEd;
    protected TextView gEe;
    public com.baidu.tieba.view.e gEf;
    protected View gEg;
    private TextView gEh;
    private TextView gEi;
    private TextView gEj;
    private View gEk;
    private View gEl;
    private TextView gEm;
    private View gEn;
    private View gEo;
    private LinearLayout gEp;
    private TextView gEq;
    private m gEr;
    private View gEs;
    private ImageView gEt;
    private TextView gEu;
    private BlueLikeButton gEv;
    private LinearLayout gEw;
    private RelativeLayout gEx;
    private View gEy;
    private TextView gEz;
    protected TbImageView gwF;
    protected Context mContext;
    protected boolean mIsHost;
    private TbPageContext mPageContext;
    protected View mRootView;
    protected UserData mUserData;

    public n(TbPageContext tbPageContext, boolean z) {
        this.gEC = 0;
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.mIsHost = z;
        this.gEC = com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.tbds46);
        initView(anZ());
        TextView textView = this.gEd;
        if (this.mIsHost) {
        }
        textView.setVisibility(8);
    }

    public View anZ() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(e.h.item_person_polymeric_header_view, (ViewGroup) null);
        }
        return this.mRootView;
    }

    public void initView(View view) {
        this.gEg = view.findViewById(e.g.person_info_root);
        this.gEb = (PersonHeadPendantView) view.findViewById(e.g.person_polymeric_header_user_img);
        this.gEb.getHeadView().setGodIconResId(e.f.pic_v_avatar_big);
        this.gEb.getHeadView().setGodIconWidth(e.C0210e.ds40);
        this.gEb.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gEb.setDefalutResid(e.f.pic_mycenter_avatar_def_i);
        this.gEb.setBigVIconResId(e.f.pic_v_avatar_big);
        this.gEb.setBigVDimenSize(e.C0210e.ds40);
        this.gwF = (TbImageView) view.findViewById(e.g.person_polymeric_header_user_vip_icon);
        this.aLy = (TextView) view.findViewById(e.g.person_polymeric_header_user_name_txt);
        this.gEe = (TextView) view.findViewById(e.g.seal_prefix_view);
        this.gEc = (UserIconBox) view.findViewById(e.g.person_polymeric_header_label_box);
        this.gEh = (TextView) view.findViewById(e.g.person_polymeric_header_bar_age_txt);
        this.bON = (TextView) view.findViewById(e.g.person_polymeric_header_ala_id);
        this.gEk = view.findViewById(e.g.divider_for_alaid_and_age);
        this.gEd = (TextView) view.findViewById(e.g.person_polymeric_header_visitor_txt);
        this.gEi = (TextView) view.findViewById(e.g.person_polymeric_header_sign_txt);
        this.gEj = (TextView) view.findViewById(e.g.person_center_header_tdou_txt);
        this.gEm = (TextView) view.findViewById(e.g.textview_get_tdou);
        this.gEn = view.findViewById(e.g.divider_for_age_and_tdou);
        this.gEo = view.findViewById(e.g.divider_for_tdou_and_get_tdou);
        this.gEp = (LinearLayout) view.findViewById(e.g.layout_user_name);
        this.gEq = (TextView) view.findViewById(e.g.person_praise_number);
        this.gEj.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(e.f.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
        this.gEf = (PersonHeaderAttentionView) view.findViewById(e.g.person_center_header_attention_container);
        brY();
        this.gEr = new m(this.mContext);
        this.gwF.setOnClickListener(this.gEr);
        this.gEc.setOnClickListener(this.gEr);
        this.gEb.setOnClickListener(this.gEr);
        this.gEd.setOnClickListener(this.gEr);
        this.gEe.setOnClickListener(this.gEr);
        this.gEj.setOnClickListener(this.gEr);
        this.gEm.setOnClickListener(this.gEr);
        this.aLy.setOnClickListener(this.gEr);
        this.gEi.setOnClickListener(this.gEr);
        this.gEs = (LinearLayout) view.findViewById(e.g.container_send_gift);
        this.gEt = (ImageView) view.findViewById(e.g.icon_gift);
        this.gEu = (TextView) view.findViewById(e.g.btn_give_gift);
        this.gEs.setOnClickListener(this.gEr);
        this.gEv = (BlueLikeButton) view.findViewById(e.g.btn_like_blue);
        this.cXP = new com.baidu.tbadk.core.view.userLike.c(this.mPageContext, this.gEv);
        this.cXP.setFromType("2");
        if (this.mIsHost) {
            this.gEs.setVisibility(8);
            this.gEv.setVisibility(8);
        }
        this.gEw = (LinearLayout) view.findViewById(e.g.layout_god_auth_forums);
        this.gEw.setVisibility(8);
        this.euU = view.findViewById(e.g.header_bottom_divider);
        this.gEx = (RelativeLayout) view.findViewById(e.g.layout_gift);
        this.gEx.setOnClickListener(this.gEr);
        this.gEy = view.findViewById(e.g.gift_top_divider);
        this.gEz = (TextView) view.findViewById(e.g.textview_received_gift);
        this.gEA = (TextView) view.findViewById(e.g.textview_received_gift_num);
        this.gEa = (ImageView) view.findViewById(e.g.img_gift_arrow);
        this.gEB = (TextView) view.findViewById(e.g.btn_edit_person_info);
        this.gEB.setOnClickListener(this.gEr);
        if (!this.mIsHost) {
            this.gEB.setVisibility(8);
        }
    }

    public void e(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null) {
            this.gDY = aVar;
            this.mUserData = aVar.getUserData();
            this.gEr.a(aVar);
            this.gEr.setIsHost(this.mIsHost);
            this.gEb.a(this.mUserData);
            UserVipInfoData userVipInfo = this.mUserData.getUserVipInfo();
            if (this.mUserData.getIsMem() > 0) {
                if (userVipInfo != null) {
                    this.gwF.startLoad(userVipInfo.getVipIconUrl(), 10, false);
                }
                this.gwF.setVisibility(0);
            } else if (this.mIsHost) {
                this.gwF.setImageDrawable(al.getDrawable(e.f.icon_crown_super_non));
                this.gwF.setVisibility(0);
            } else {
                this.gwF.setVisibility(8);
            }
            bqf();
            String name_show = this.mUserData.getName_show();
            if (!TextUtils.isEmpty(name_show)) {
                this.aLy.setText(name_show);
            }
            int i = e.f.icon_mine_boy;
            if (this.mUserData != null) {
                i = this.mUserData.getSex() == 2 ? e.f.icon_mine_girl : e.f.icon_mine_boy;
            }
            this.aLy.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mContext.getResources().getDrawable(i), (Drawable) null);
            this.gEc.a(this.mUserData.getIconInfo(), 9, this.mContext.getResources().getDimensionPixelSize(e.C0210e.tbds42), this.mContext.getResources().getDimensionPixelSize(e.C0210e.tbds42), this.mContext.getResources().getDimensionPixelSize(e.C0210e.tbds10), true);
            if (this.gEf != null) {
                this.gEf.setData(this.mUserData);
            }
            if (this.mUserData != null && this.mUserData.alaUserData != null && this.mUserData.alaUserData.ala_id != 0) {
                this.bON.setVisibility(0);
                this.gEk.setVisibility(0);
                this.bON.setText(String.format(this.mContext.getString(e.j.person_center_ala_id), Long.valueOf(this.mUserData.alaUserData.ala_id)));
            } else {
                this.bON.setVisibility(8);
                this.gEk.setVisibility(8);
            }
            this.gEh.setText(String.format(this.mContext.getString(e.j.person_center_header_bar_age), this.mUserData.getTb_age()));
            if (this.mIsHost) {
                this.gEn.setVisibility(0);
                this.gEo.setVisibility(0);
                this.gEj.setVisibility(0);
                this.gEm.setVisibility(0);
                this.gEj.setText(ao.ad(this.mUserData.getTDouNum()));
            } else {
                this.gEn.setVisibility(8);
                this.gEo.setVisibility(8);
                this.gEj.setVisibility(8);
                this.gEm.setVisibility(8);
            }
            String intro = this.mUserData.getIntro();
            if (StringUtils.isNull(intro)) {
                al.c(this.gEi, e.d.cp_cont_e, 1);
            } else {
                al.c(this.gEi, e.d.cp_cont_j, 1);
            }
            if (StringUtils.isNull(intro)) {
                if (this.mIsHost) {
                    intro = this.mContext.getString(e.j.no_person_sign_host);
                } else {
                    intro = this.mContext.getString(e.j.no_person_sign_guest);
                }
            }
            this.gEi.setText(this.mContext.getString(e.j.person_sign) + intro);
            if (this.gEi.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gEi.getLayoutParams();
                if (!this.mIsHost && this.gEi.getLineCount() >= 3 && this.gEi.getMaxLines() != 2147483646) {
                    int lineHeight = this.gEi.getLineHeight();
                    this.gEi.setHeight((lineHeight / 2) + (lineHeight * 3));
                }
                if (this.gEi.getLineCount() >= 2) {
                    layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(e.C0210e.tbds19);
                } else {
                    layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(e.C0210e.tbds80);
                }
                this.gEi.setLayoutParams(layoutParams);
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(this.mUserData.getUserId()) && ((!TbadkCoreApplication.isLogin() || (!StringUtils.isNull(currentAccount) && !currentAccount.equals(this.mUserData.getUserId()))) && this.mUserData.getLiveStatus() == 1)) {
                if (this.gEl == null) {
                    this.gEl = com.baidu.tbadk.ala.b.wg().j(this.mContext, 7);
                }
                com.baidu.tbadk.ala.a aVar2 = new com.baidu.tbadk.ala.a();
                aVar2.amc = this.mUserData.getAlaUserData();
                aVar2.type = 7;
                if ((this.mUserData.getPersonPrivate() != null && this.mUserData.getPersonPrivate().LR() == 3) || (this.mUserData.getPersonPrivate().LR() == 2 && this.mUserData.getIsFriend() != 1)) {
                    aVar2.amd = true;
                } else {
                    aVar2.amd = false;
                }
                if (this.gEl != null) {
                    this.gEl.setTag(aVar2);
                    if (this.gEl.getParent() == null) {
                        this.gEp.addView(this.gEl);
                        TiebaStatic.log(new am("c12541"));
                    }
                }
            } else if (this.gEl != null) {
                this.gEl.setVisibility(8);
            }
            a(aVar.gBT);
            this.mUserData.setIsLike(this.mUserData.getHave_attention() == 1);
            this.cXP.a(this.mUserData);
            brZ();
            bsa();
            this.gEz.setText(this.mIsHost ? e.j.my_received_gift : e.j.he_received_gift);
            if ((this.mUserData.getPersonPrivate() == null || this.mUserData.getPersonPrivate().LR() != 3) && this.mUserData.getPersonPrivate().LR() == 2 && this.mUserData.getIsFriend() != 1) {
            }
        }
    }

    public void tS(String str) {
        if (!StringUtils.isNull(str)) {
            this.aLy.setText(str);
        }
    }

    public void tT(String str) {
        if (!StringUtils.isNull(str)) {
            if (this.mUserData != null) {
                this.mUserData.setPortrait(str);
            }
            this.gEb.gB(str);
        }
    }

    private void a(UserAgreeInfo userAgreeInfo) {
        if (userAgreeInfo == null) {
            this.gEq.setVisibility(8);
            return;
        }
        this.gEq.setVisibility(0);
        String X = ao.X(userAgreeInfo.total_agree_num.longValue());
        Drawable drawable = al.getDrawable(e.f.icon_home_card_like_s);
        drawable.setBounds(0, 0, this.gEC, this.gEC);
        this.gEq.setCompoundDrawables(drawable, null, null, null);
        this.gEq.setText(X);
    }

    public void onChangeSkinType(int i) {
        this.gEg.setBackgroundDrawable(al.getDrawable(e.f.shape_user_info_bg));
        this.gEb.setBackgroundViewDrawable(al.getDrawable(e.f.shape_user_img_bg));
        int i2 = e.f.icon_mine_boy;
        if (this.mUserData != null) {
            i2 = this.mUserData.getSex() == 1 ? e.f.icon_mine_boy : e.f.icon_pop_girl;
        }
        if (this.mUserData != null && this.mUserData.getIsMem() <= 0 && this.gwF != null && this.mIsHost) {
            this.gwF.setImageDrawable(al.getDrawable(e.f.icon_crown_super_non));
        }
        bqf();
        al.c(this.gEe, e.d.cp_link_tip_a, 1);
        this.aLy.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mContext.getResources().getDrawable(i2), (Drawable) null);
        if (this.gEf != null) {
            this.gEf.onChangeSkinType(i);
        }
        al.c(this.gEd, e.d.cp_cont_b, 1);
        al.c(this.gEh, e.d.cp_cont_b, 1);
        al.c(this.bON, e.d.cp_cont_b, 1);
        if (this.mUserData == null || StringUtils.isNull(this.mUserData.getIntro())) {
            al.c(this.gEi, e.d.cp_cont_e, 1);
        } else {
            al.c(this.gEi, e.d.cp_cont_j, 1);
        }
        al.c(this.gEj, e.d.cp_cont_b, 1);
        al.c(this.gEm, e.d.cp_cont_b, 1);
        al.j(this.gEn, e.d.cp_bg_line_b);
        al.j(this.gEk, e.d.cp_bg_line_b);
        al.j(this.gEo, e.d.cp_bg_line_b);
        al.h(this.gEq, e.d.cp_cont_h);
        this.gEj.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(e.f.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
        Drawable y = al.y(i, e.f.icon_home_card_like_s);
        y.setBounds(0, 0, this.gEC, this.gEC);
        this.gEq.setCompoundDrawables(y, null, null, null);
        al.i(this.gEs, e.f.selector_give_gift_bg);
        al.c(this.gEt, e.f.selector_gift_icon);
        al.c(this.gEu, e.d.selector_give_gift_text_color, 1);
        this.gEv.onChangeSkinType(i);
        al.j(this.euU, e.d.cp_bg_line_e);
        for (int i3 = 0; i3 < this.gEw.getChildCount(); i3++) {
            View childAt = this.gEw.getChildAt(i3);
            if (childAt != null) {
                TextView textView = (TextView) childAt.findViewById(e.g.bar_name);
                textView.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.pic_v_avatar), (Drawable) null, (Drawable) null, (Drawable) null);
                al.h(textView, e.d.cp_cont_b);
                al.h((TextView) childAt.findViewById(e.g.bar_info), e.d.cp_cont_j);
            }
        }
        for (int i4 = 0; i4 < gDZ.length; i4++) {
            ((TbImageView) this.mRootView.findViewById(gDZ[i4])).setBackgroundDrawable(al.getDrawable(e.f.shape_gift_icon_bg));
        }
        al.j(this.gEy, e.d.cp_bg_line_e);
        al.h(this.gEz, e.d.cp_cont_b);
        al.h(this.gEA, e.d.cp_cont_d);
        al.c(this.gEa, e.f.icon_arrow_gray_right_n);
        al.i(this.gEB, e.f.selector_like_button_bg);
        al.c(this.gEB, e.d.cp_cont_g, 1);
    }

    public void onDestory() {
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.g gVar) {
        this.gDX = gVar;
        if (this.gEf != null) {
            this.gEf.setOnViewResponseListener(this.gDX);
        }
        this.gEr.setOnViewResponseListener(this.gDX);
    }

    public void uj(String str) {
        this.gEb.gA(str);
    }

    protected void brY() {
        this.gEb.setHasPendantStyle();
        this.gEb.getHeadView().setIsRound(true);
        this.gEb.getHeadView().setDrawBorder(false);
        this.gEb.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    protected void bqf() {
        if (this.mUserData != null && (this.mUserData.getIsMem() > 0 || this.mUserData.isBigV())) {
            al.c(this.aLy, e.d.cp_cont_h, 1);
        } else {
            al.c(this.aLy, e.d.cp_cont_b, 1);
        }
    }

    private void brZ() {
        if (this.gDY != null && this.gDY.brT() != null) {
            this.gEw.removeAllViews();
            int godType = this.gDY.brT().getGodType();
            if (godType == 2 && v.H(this.gDY.brT().getForumGodList()) > 0) {
                this.gEw.setVisibility(0);
                for (ForumGodDetailInfo forumGodDetailInfo : this.gDY.brT().getForumGodList()) {
                    if (forumGodDetailInfo != null) {
                        cr(forumGodDetailInfo.forum_name, forumGodDetailInfo.intro);
                    }
                }
                return;
            } else if (godType == 1 && this.gDY.brT().getgodDetailInfo() != null && !StringUtils.isNull(this.gDY.brT().getgodDetailInfo().intro)) {
                this.gEw.setVisibility(0);
                cr(this.gDY.brT().getgodDetailInfo().intro, "");
                return;
            } else {
                return;
            }
        }
        this.gEw.setVisibility(8);
    }

    private void cr(String str, String str2) {
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
        this.gEw.addView(inflate, layoutParams);
    }

    private void bsa() {
        int i;
        for (int i2 = 0; i2 < gDZ.length; i2++) {
            ((TbImageView) this.mRootView.findViewById(gDZ[i2])).setVisibility(8);
        }
        if (this.gDY == null || this.gDY.brS() == null || v.H(this.gDY.brS().gCh) <= 0) {
            i = 0;
        } else {
            int i3 = this.gDY.brS().giftNum;
            List<com.baidu.adp.widget.ListView.h> list = this.gDY.brS().gCh;
            for (int i4 = 0; i4 < list.size() && i4 < gDZ.length; i4++) {
                if (list.get(i4) instanceof com.baidu.tieba.personPolymeric.c.o) {
                    TbImageView tbImageView = (TbImageView) this.mRootView.findViewById(gDZ[i4]);
                    tbImageView.setVisibility(0);
                    tbImageView.setIsRound(true);
                    tbImageView.startLoad(((com.baidu.tieba.personPolymeric.c.o) list.get(i4)).picUrl, 10, false);
                }
            }
            i = i3;
        }
        this.gEA.setText(String.format(this.mContext.getResources().getString(e.j.gift_num), Integer.valueOf(i)));
    }
}
