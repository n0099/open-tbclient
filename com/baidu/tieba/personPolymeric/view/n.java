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
    private static final int[] gDY = {e.g.img_gift_one, e.g.img_gift_two, e.g.img_gift_three};
    protected TextView aLx;
    private TextView bOM;
    private com.baidu.tbadk.core.view.userLike.c cXO;
    private View euT;
    protected com.baidu.tieba.view.g gDW;
    protected com.baidu.tieba.personPolymeric.c.a gDX;
    protected ImageView gDZ;
    private TextView gEA;
    private int gEB;
    protected PersonHeadPendantView gEa;
    protected UserIconBox gEb;
    protected TextView gEc;
    protected TextView gEd;
    public com.baidu.tieba.view.e gEe;
    protected View gEf;
    private TextView gEg;
    private TextView gEh;
    private TextView gEi;
    private View gEj;
    private View gEk;
    private TextView gEl;
    private View gEm;
    private View gEn;
    private LinearLayout gEo;
    private TextView gEp;
    private m gEq;
    private View gEr;
    private ImageView gEs;
    private TextView gEt;
    private BlueLikeButton gEu;
    private LinearLayout gEv;
    private RelativeLayout gEw;
    private View gEx;
    private TextView gEy;
    private TextView gEz;
    protected TbImageView gwE;
    protected Context mContext;
    protected boolean mIsHost;
    private TbPageContext mPageContext;
    protected View mRootView;
    protected UserData mUserData;

    public n(TbPageContext tbPageContext, boolean z) {
        this.gEB = 0;
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.mIsHost = z;
        this.gEB = com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.tbds46);
        initView(anZ());
        TextView textView = this.gEc;
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
        this.gEf = view.findViewById(e.g.person_info_root);
        this.gEa = (PersonHeadPendantView) view.findViewById(e.g.person_polymeric_header_user_img);
        this.gEa.getHeadView().setGodIconResId(e.f.pic_v_avatar_big);
        this.gEa.getHeadView().setGodIconWidth(e.C0210e.ds40);
        this.gEa.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gEa.setDefalutResid(e.f.pic_mycenter_avatar_def_i);
        this.gEa.setBigVIconResId(e.f.pic_v_avatar_big);
        this.gEa.setBigVDimenSize(e.C0210e.ds40);
        this.gwE = (TbImageView) view.findViewById(e.g.person_polymeric_header_user_vip_icon);
        this.aLx = (TextView) view.findViewById(e.g.person_polymeric_header_user_name_txt);
        this.gEd = (TextView) view.findViewById(e.g.seal_prefix_view);
        this.gEb = (UserIconBox) view.findViewById(e.g.person_polymeric_header_label_box);
        this.gEg = (TextView) view.findViewById(e.g.person_polymeric_header_bar_age_txt);
        this.bOM = (TextView) view.findViewById(e.g.person_polymeric_header_ala_id);
        this.gEj = view.findViewById(e.g.divider_for_alaid_and_age);
        this.gEc = (TextView) view.findViewById(e.g.person_polymeric_header_visitor_txt);
        this.gEh = (TextView) view.findViewById(e.g.person_polymeric_header_sign_txt);
        this.gEi = (TextView) view.findViewById(e.g.person_center_header_tdou_txt);
        this.gEl = (TextView) view.findViewById(e.g.textview_get_tdou);
        this.gEm = view.findViewById(e.g.divider_for_age_and_tdou);
        this.gEn = view.findViewById(e.g.divider_for_tdou_and_get_tdou);
        this.gEo = (LinearLayout) view.findViewById(e.g.layout_user_name);
        this.gEp = (TextView) view.findViewById(e.g.person_praise_number);
        this.gEi.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(e.f.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
        this.gEe = (PersonHeaderAttentionView) view.findViewById(e.g.person_center_header_attention_container);
        brY();
        this.gEq = new m(this.mContext);
        this.gwE.setOnClickListener(this.gEq);
        this.gEb.setOnClickListener(this.gEq);
        this.gEa.setOnClickListener(this.gEq);
        this.gEc.setOnClickListener(this.gEq);
        this.gEd.setOnClickListener(this.gEq);
        this.gEi.setOnClickListener(this.gEq);
        this.gEl.setOnClickListener(this.gEq);
        this.aLx.setOnClickListener(this.gEq);
        this.gEh.setOnClickListener(this.gEq);
        this.gEr = (LinearLayout) view.findViewById(e.g.container_send_gift);
        this.gEs = (ImageView) view.findViewById(e.g.icon_gift);
        this.gEt = (TextView) view.findViewById(e.g.btn_give_gift);
        this.gEr.setOnClickListener(this.gEq);
        this.gEu = (BlueLikeButton) view.findViewById(e.g.btn_like_blue);
        this.cXO = new com.baidu.tbadk.core.view.userLike.c(this.mPageContext, this.gEu);
        this.cXO.setFromType("2");
        if (this.mIsHost) {
            this.gEr.setVisibility(8);
            this.gEu.setVisibility(8);
        }
        this.gEv = (LinearLayout) view.findViewById(e.g.layout_god_auth_forums);
        this.gEv.setVisibility(8);
        this.euT = view.findViewById(e.g.header_bottom_divider);
        this.gEw = (RelativeLayout) view.findViewById(e.g.layout_gift);
        this.gEw.setOnClickListener(this.gEq);
        this.gEx = view.findViewById(e.g.gift_top_divider);
        this.gEy = (TextView) view.findViewById(e.g.textview_received_gift);
        this.gEz = (TextView) view.findViewById(e.g.textview_received_gift_num);
        this.gDZ = (ImageView) view.findViewById(e.g.img_gift_arrow);
        this.gEA = (TextView) view.findViewById(e.g.btn_edit_person_info);
        this.gEA.setOnClickListener(this.gEq);
        if (!this.mIsHost) {
            this.gEA.setVisibility(8);
        }
    }

    public void e(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null) {
            this.gDX = aVar;
            this.mUserData = aVar.getUserData();
            this.gEq.a(aVar);
            this.gEq.setIsHost(this.mIsHost);
            this.gEa.a(this.mUserData);
            UserVipInfoData userVipInfo = this.mUserData.getUserVipInfo();
            if (this.mUserData.getIsMem() > 0) {
                if (userVipInfo != null) {
                    this.gwE.startLoad(userVipInfo.getVipIconUrl(), 10, false);
                }
                this.gwE.setVisibility(0);
            } else if (this.mIsHost) {
                this.gwE.setImageDrawable(al.getDrawable(e.f.icon_crown_super_non));
                this.gwE.setVisibility(0);
            } else {
                this.gwE.setVisibility(8);
            }
            bqf();
            String name_show = this.mUserData.getName_show();
            if (!TextUtils.isEmpty(name_show)) {
                this.aLx.setText(name_show);
            }
            int i = e.f.icon_mine_boy;
            if (this.mUserData != null) {
                i = this.mUserData.getSex() == 2 ? e.f.icon_mine_girl : e.f.icon_mine_boy;
            }
            this.aLx.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mContext.getResources().getDrawable(i), (Drawable) null);
            this.gEb.a(this.mUserData.getIconInfo(), 9, this.mContext.getResources().getDimensionPixelSize(e.C0210e.tbds42), this.mContext.getResources().getDimensionPixelSize(e.C0210e.tbds42), this.mContext.getResources().getDimensionPixelSize(e.C0210e.tbds10), true);
            if (this.gEe != null) {
                this.gEe.setData(this.mUserData);
            }
            if (this.mUserData != null && this.mUserData.alaUserData != null && this.mUserData.alaUserData.ala_id != 0) {
                this.bOM.setVisibility(0);
                this.gEj.setVisibility(0);
                this.bOM.setText(String.format(this.mContext.getString(e.j.person_center_ala_id), Long.valueOf(this.mUserData.alaUserData.ala_id)));
            } else {
                this.bOM.setVisibility(8);
                this.gEj.setVisibility(8);
            }
            this.gEg.setText(String.format(this.mContext.getString(e.j.person_center_header_bar_age), this.mUserData.getTb_age()));
            if (this.mIsHost) {
                this.gEm.setVisibility(0);
                this.gEn.setVisibility(0);
                this.gEi.setVisibility(0);
                this.gEl.setVisibility(0);
                this.gEi.setText(ao.ad(this.mUserData.getTDouNum()));
            } else {
                this.gEm.setVisibility(8);
                this.gEn.setVisibility(8);
                this.gEi.setVisibility(8);
                this.gEl.setVisibility(8);
            }
            String intro = this.mUserData.getIntro();
            if (StringUtils.isNull(intro)) {
                al.c(this.gEh, e.d.cp_cont_e, 1);
            } else {
                al.c(this.gEh, e.d.cp_cont_j, 1);
            }
            if (StringUtils.isNull(intro)) {
                if (this.mIsHost) {
                    intro = this.mContext.getString(e.j.no_person_sign_host);
                } else {
                    intro = this.mContext.getString(e.j.no_person_sign_guest);
                }
            }
            this.gEh.setText(this.mContext.getString(e.j.person_sign) + intro);
            if (this.gEh.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gEh.getLayoutParams();
                if (!this.mIsHost && this.gEh.getLineCount() >= 3 && this.gEh.getMaxLines() != 2147483646) {
                    int lineHeight = this.gEh.getLineHeight();
                    this.gEh.setHeight((lineHeight / 2) + (lineHeight * 3));
                }
                if (this.gEh.getLineCount() >= 2) {
                    layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(e.C0210e.tbds19);
                } else {
                    layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(e.C0210e.tbds80);
                }
                this.gEh.setLayoutParams(layoutParams);
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(this.mUserData.getUserId()) && ((!TbadkCoreApplication.isLogin() || (!StringUtils.isNull(currentAccount) && !currentAccount.equals(this.mUserData.getUserId()))) && this.mUserData.getLiveStatus() == 1)) {
                if (this.gEk == null) {
                    this.gEk = com.baidu.tbadk.ala.b.wg().j(this.mContext, 7);
                }
                com.baidu.tbadk.ala.a aVar2 = new com.baidu.tbadk.ala.a();
                aVar2.amc = this.mUserData.getAlaUserData();
                aVar2.type = 7;
                if ((this.mUserData.getPersonPrivate() != null && this.mUserData.getPersonPrivate().LR() == 3) || (this.mUserData.getPersonPrivate().LR() == 2 && this.mUserData.getIsFriend() != 1)) {
                    aVar2.amd = true;
                } else {
                    aVar2.amd = false;
                }
                if (this.gEk != null) {
                    this.gEk.setTag(aVar2);
                    if (this.gEk.getParent() == null) {
                        this.gEo.addView(this.gEk);
                        TiebaStatic.log(new am("c12541"));
                    }
                }
            } else if (this.gEk != null) {
                this.gEk.setVisibility(8);
            }
            a(aVar.gBS);
            this.mUserData.setIsLike(this.mUserData.getHave_attention() == 1);
            this.cXO.a(this.mUserData);
            brZ();
            bsa();
            this.gEy.setText(this.mIsHost ? e.j.my_received_gift : e.j.he_received_gift);
            if ((this.mUserData.getPersonPrivate() == null || this.mUserData.getPersonPrivate().LR() != 3) && this.mUserData.getPersonPrivate().LR() == 2 && this.mUserData.getIsFriend() != 1) {
            }
        }
    }

    public void tS(String str) {
        if (!StringUtils.isNull(str)) {
            this.aLx.setText(str);
        }
    }

    public void tT(String str) {
        if (!StringUtils.isNull(str)) {
            if (this.mUserData != null) {
                this.mUserData.setPortrait(str);
            }
            this.gEa.gB(str);
        }
    }

    private void a(UserAgreeInfo userAgreeInfo) {
        if (userAgreeInfo == null) {
            this.gEp.setVisibility(8);
            return;
        }
        this.gEp.setVisibility(0);
        String X = ao.X(userAgreeInfo.total_agree_num.longValue());
        Drawable drawable = al.getDrawable(e.f.icon_home_card_like_s);
        drawable.setBounds(0, 0, this.gEB, this.gEB);
        this.gEp.setCompoundDrawables(drawable, null, null, null);
        this.gEp.setText(X);
    }

    public void onChangeSkinType(int i) {
        this.gEf.setBackgroundDrawable(al.getDrawable(e.f.shape_user_info_bg));
        this.gEa.setBackgroundViewDrawable(al.getDrawable(e.f.shape_user_img_bg));
        int i2 = e.f.icon_mine_boy;
        if (this.mUserData != null) {
            i2 = this.mUserData.getSex() == 1 ? e.f.icon_mine_boy : e.f.icon_pop_girl;
        }
        if (this.mUserData != null && this.mUserData.getIsMem() <= 0 && this.gwE != null && this.mIsHost) {
            this.gwE.setImageDrawable(al.getDrawable(e.f.icon_crown_super_non));
        }
        bqf();
        al.c(this.gEd, e.d.cp_link_tip_a, 1);
        this.aLx.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mContext.getResources().getDrawable(i2), (Drawable) null);
        if (this.gEe != null) {
            this.gEe.onChangeSkinType(i);
        }
        al.c(this.gEc, e.d.cp_cont_b, 1);
        al.c(this.gEg, e.d.cp_cont_b, 1);
        al.c(this.bOM, e.d.cp_cont_b, 1);
        if (this.mUserData == null || StringUtils.isNull(this.mUserData.getIntro())) {
            al.c(this.gEh, e.d.cp_cont_e, 1);
        } else {
            al.c(this.gEh, e.d.cp_cont_j, 1);
        }
        al.c(this.gEi, e.d.cp_cont_b, 1);
        al.c(this.gEl, e.d.cp_cont_b, 1);
        al.j(this.gEm, e.d.cp_bg_line_b);
        al.j(this.gEj, e.d.cp_bg_line_b);
        al.j(this.gEn, e.d.cp_bg_line_b);
        al.h(this.gEp, e.d.cp_cont_h);
        this.gEi.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(e.f.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
        Drawable y = al.y(i, e.f.icon_home_card_like_s);
        y.setBounds(0, 0, this.gEB, this.gEB);
        this.gEp.setCompoundDrawables(y, null, null, null);
        al.i(this.gEr, e.f.selector_give_gift_bg);
        al.c(this.gEs, e.f.selector_gift_icon);
        al.c(this.gEt, e.d.selector_give_gift_text_color, 1);
        this.gEu.onChangeSkinType(i);
        al.j(this.euT, e.d.cp_bg_line_e);
        for (int i3 = 0; i3 < this.gEv.getChildCount(); i3++) {
            View childAt = this.gEv.getChildAt(i3);
            if (childAt != null) {
                TextView textView = (TextView) childAt.findViewById(e.g.bar_name);
                textView.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.pic_v_avatar), (Drawable) null, (Drawable) null, (Drawable) null);
                al.h(textView, e.d.cp_cont_b);
                al.h((TextView) childAt.findViewById(e.g.bar_info), e.d.cp_cont_j);
            }
        }
        for (int i4 = 0; i4 < gDY.length; i4++) {
            ((TbImageView) this.mRootView.findViewById(gDY[i4])).setBackgroundDrawable(al.getDrawable(e.f.shape_gift_icon_bg));
        }
        al.j(this.gEx, e.d.cp_bg_line_e);
        al.h(this.gEy, e.d.cp_cont_b);
        al.h(this.gEz, e.d.cp_cont_d);
        al.c(this.gDZ, e.f.icon_arrow_gray_right_n);
        al.i(this.gEA, e.f.selector_like_button_bg);
        al.c(this.gEA, e.d.cp_cont_g, 1);
    }

    public void onDestory() {
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.g gVar) {
        this.gDW = gVar;
        if (this.gEe != null) {
            this.gEe.setOnViewResponseListener(this.gDW);
        }
        this.gEq.setOnViewResponseListener(this.gDW);
    }

    public void uj(String str) {
        this.gEa.gA(str);
    }

    protected void brY() {
        this.gEa.setHasPendantStyle();
        this.gEa.getHeadView().setIsRound(true);
        this.gEa.getHeadView().setDrawBorder(false);
        this.gEa.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    protected void bqf() {
        if (this.mUserData != null && (this.mUserData.getIsMem() > 0 || this.mUserData.isBigV())) {
            al.c(this.aLx, e.d.cp_cont_h, 1);
        } else {
            al.c(this.aLx, e.d.cp_cont_b, 1);
        }
    }

    private void brZ() {
        if (this.gDX != null && this.gDX.brT() != null) {
            this.gEv.removeAllViews();
            int godType = this.gDX.brT().getGodType();
            if (godType == 2 && v.H(this.gDX.brT().getForumGodList()) > 0) {
                this.gEv.setVisibility(0);
                for (ForumGodDetailInfo forumGodDetailInfo : this.gDX.brT().getForumGodList()) {
                    if (forumGodDetailInfo != null) {
                        cr(forumGodDetailInfo.forum_name, forumGodDetailInfo.intro);
                    }
                }
                return;
            } else if (godType == 1 && this.gDX.brT().getgodDetailInfo() != null && !StringUtils.isNull(this.gDX.brT().getgodDetailInfo().intro)) {
                this.gEv.setVisibility(0);
                cr(this.gDX.brT().getgodDetailInfo().intro, "");
                return;
            } else {
                return;
            }
        }
        this.gEv.setVisibility(8);
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
        this.gEv.addView(inflate, layoutParams);
    }

    private void bsa() {
        int i;
        for (int i2 = 0; i2 < gDY.length; i2++) {
            ((TbImageView) this.mRootView.findViewById(gDY[i2])).setVisibility(8);
        }
        if (this.gDX == null || this.gDX.brS() == null || v.H(this.gDX.brS().gCg) <= 0) {
            i = 0;
        } else {
            int i3 = this.gDX.brS().giftNum;
            List<com.baidu.adp.widget.ListView.h> list = this.gDX.brS().gCg;
            for (int i4 = 0; i4 < list.size() && i4 < gDY.length; i4++) {
                if (list.get(i4) instanceof com.baidu.tieba.personPolymeric.c.o) {
                    TbImageView tbImageView = (TbImageView) this.mRootView.findViewById(gDY[i4]);
                    tbImageView.setVisibility(0);
                    tbImageView.setIsRound(true);
                    tbImageView.startLoad(((com.baidu.tieba.personPolymeric.c.o) list.get(i4)).picUrl, 10, false);
                }
            }
            i = i3;
        }
        this.gEz.setText(String.format(this.mContext.getResources().getString(e.j.gift_num), Integer.valueOf(i)));
    }
}
