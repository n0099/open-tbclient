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
    private static final int[] gCU = {e.g.img_gift_one, e.g.img_gift_two, e.g.img_gift_three};
    protected TextView aKV;
    private TextView bOa;
    private com.baidu.tbadk.core.view.userLike.c cXd;
    private View eun;
    protected com.baidu.tieba.view.g gCS;
    protected com.baidu.tieba.personPolymeric.c.a gCT;
    protected ImageView gCV;
    protected PersonHeadPendantView gCW;
    protected UserIconBox gCX;
    protected TextView gCY;
    protected TextView gCZ;
    public com.baidu.tieba.view.e gDa;
    protected View gDb;
    private TextView gDc;
    private TextView gDd;
    private TextView gDe;
    private View gDf;
    private View gDg;
    private TextView gDh;
    private View gDi;
    private View gDj;
    private LinearLayout gDk;
    private TextView gDl;
    private m gDm;
    private View gDn;
    private ImageView gDo;
    private TextView gDp;
    private BlueLikeButton gDq;
    private LinearLayout gDr;
    private RelativeLayout gDs;
    private View gDt;
    private TextView gDu;
    private TextView gDv;
    private TextView gDw;
    private int gDx;
    protected TbImageView gvA;
    protected Context mContext;
    protected boolean mIsHost;
    private TbPageContext mPageContext;
    protected View mRootView;
    protected UserData mUserData;

    public n(TbPageContext tbPageContext, boolean z) {
        this.gDx = 0;
        this.mPageContext = tbPageContext;
        this.mContext = tbPageContext.getPageActivity();
        this.mIsHost = z;
        this.gDx = com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.tbds46);
        initView(anC());
        TextView textView = this.gCY;
        if (this.mIsHost) {
        }
        textView.setVisibility(8);
    }

    public View anC() {
        if (this.mRootView == null) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(e.h.item_person_polymeric_header_view, (ViewGroup) null);
        }
        return this.mRootView;
    }

    public void initView(View view) {
        this.gDb = view.findViewById(e.g.person_info_root);
        this.gCW = (PersonHeadPendantView) view.findViewById(e.g.person_polymeric_header_user_img);
        this.gCW.getHeadView().setGodIconResId(e.f.pic_v_avatar_big);
        this.gCW.getHeadView().setGodIconWidth(e.C0210e.ds40);
        this.gCW.getHeadView().setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gCW.setDefalutResid(e.f.pic_mycenter_avatar_def_i);
        this.gCW.setBigVIconResId(e.f.pic_v_avatar_big);
        this.gCW.setBigVDimenSize(e.C0210e.ds40);
        this.gvA = (TbImageView) view.findViewById(e.g.person_polymeric_header_user_vip_icon);
        this.aKV = (TextView) view.findViewById(e.g.person_polymeric_header_user_name_txt);
        this.gCZ = (TextView) view.findViewById(e.g.seal_prefix_view);
        this.gCX = (UserIconBox) view.findViewById(e.g.person_polymeric_header_label_box);
        this.gDc = (TextView) view.findViewById(e.g.person_polymeric_header_bar_age_txt);
        this.bOa = (TextView) view.findViewById(e.g.person_polymeric_header_ala_id);
        this.gDf = view.findViewById(e.g.divider_for_alaid_and_age);
        this.gCY = (TextView) view.findViewById(e.g.person_polymeric_header_visitor_txt);
        this.gDd = (TextView) view.findViewById(e.g.person_polymeric_header_sign_txt);
        this.gDe = (TextView) view.findViewById(e.g.person_center_header_tdou_txt);
        this.gDh = (TextView) view.findViewById(e.g.textview_get_tdou);
        this.gDi = view.findViewById(e.g.divider_for_age_and_tdou);
        this.gDj = view.findViewById(e.g.divider_for_tdou_and_get_tdou);
        this.gDk = (LinearLayout) view.findViewById(e.g.layout_user_name);
        this.gDl = (TextView) view.findViewById(e.g.person_praise_number);
        this.gDe.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(e.f.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
        this.gDa = (PersonHeaderAttentionView) view.findViewById(e.g.person_center_header_attention_container);
        brp();
        this.gDm = new m(this.mContext);
        this.gvA.setOnClickListener(this.gDm);
        this.gCX.setOnClickListener(this.gDm);
        this.gCW.setOnClickListener(this.gDm);
        this.gCY.setOnClickListener(this.gDm);
        this.gCZ.setOnClickListener(this.gDm);
        this.gDe.setOnClickListener(this.gDm);
        this.gDh.setOnClickListener(this.gDm);
        this.aKV.setOnClickListener(this.gDm);
        this.gDd.setOnClickListener(this.gDm);
        this.gDn = (LinearLayout) view.findViewById(e.g.container_send_gift);
        this.gDo = (ImageView) view.findViewById(e.g.icon_gift);
        this.gDp = (TextView) view.findViewById(e.g.btn_give_gift);
        this.gDn.setOnClickListener(this.gDm);
        this.gDq = (BlueLikeButton) view.findViewById(e.g.btn_like_blue);
        this.cXd = new com.baidu.tbadk.core.view.userLike.c(this.mPageContext, this.gDq);
        this.cXd.setFromType("2");
        if (this.mIsHost) {
            this.gDn.setVisibility(8);
            this.gDq.setVisibility(8);
        }
        this.gDr = (LinearLayout) view.findViewById(e.g.layout_god_auth_forums);
        this.gDr.setVisibility(8);
        this.eun = view.findViewById(e.g.header_bottom_divider);
        this.gDs = (RelativeLayout) view.findViewById(e.g.layout_gift);
        this.gDs.setOnClickListener(this.gDm);
        this.gDt = view.findViewById(e.g.gift_top_divider);
        this.gDu = (TextView) view.findViewById(e.g.textview_received_gift);
        this.gDv = (TextView) view.findViewById(e.g.textview_received_gift_num);
        this.gCV = (ImageView) view.findViewById(e.g.img_gift_arrow);
        this.gDw = (TextView) view.findViewById(e.g.btn_edit_person_info);
        this.gDw.setOnClickListener(this.gDm);
        if (!this.mIsHost) {
            this.gDw.setVisibility(8);
        }
    }

    public void e(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null) {
            this.gCT = aVar;
            this.mUserData = aVar.getUserData();
            this.gDm.a(aVar);
            this.gDm.setIsHost(this.mIsHost);
            this.gCW.a(this.mUserData);
            UserVipInfoData userVipInfo = this.mUserData.getUserVipInfo();
            if (this.mUserData.getIsMem() > 0) {
                if (userVipInfo != null) {
                    this.gvA.startLoad(userVipInfo.getVipIconUrl(), 10, false);
                }
                this.gvA.setVisibility(0);
            } else if (this.mIsHost) {
                this.gvA.setImageDrawable(al.getDrawable(e.f.icon_crown_super_non));
                this.gvA.setVisibility(0);
            } else {
                this.gvA.setVisibility(8);
            }
            bpw();
            String name_show = this.mUserData.getName_show();
            if (!TextUtils.isEmpty(name_show)) {
                this.aKV.setText(name_show);
            }
            int i = e.f.icon_mine_boy;
            if (this.mUserData != null) {
                i = this.mUserData.getSex() == 2 ? e.f.icon_mine_girl : e.f.icon_mine_boy;
            }
            this.aKV.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mContext.getResources().getDrawable(i), (Drawable) null);
            this.gCX.a(this.mUserData.getIconInfo(), 9, this.mContext.getResources().getDimensionPixelSize(e.C0210e.tbds42), this.mContext.getResources().getDimensionPixelSize(e.C0210e.tbds42), this.mContext.getResources().getDimensionPixelSize(e.C0210e.tbds10), true);
            if (this.gDa != null) {
                this.gDa.setData(this.mUserData);
            }
            if (this.mUserData != null && this.mUserData.alaUserData != null && this.mUserData.alaUserData.ala_id != 0) {
                this.bOa.setVisibility(0);
                this.gDf.setVisibility(0);
                this.bOa.setText(String.format(this.mContext.getString(e.j.person_center_ala_id), Long.valueOf(this.mUserData.alaUserData.ala_id)));
            } else {
                this.bOa.setVisibility(8);
                this.gDf.setVisibility(8);
            }
            this.gDc.setText(String.format(this.mContext.getString(e.j.person_center_header_bar_age), this.mUserData.getTb_age()));
            if (this.mIsHost) {
                this.gDi.setVisibility(0);
                this.gDj.setVisibility(0);
                this.gDe.setVisibility(0);
                this.gDh.setVisibility(0);
                this.gDe.setText(ao.ad(this.mUserData.getTDouNum()));
            } else {
                this.gDi.setVisibility(8);
                this.gDj.setVisibility(8);
                this.gDe.setVisibility(8);
                this.gDh.setVisibility(8);
            }
            String intro = this.mUserData.getIntro();
            if (StringUtils.isNull(intro)) {
                al.c(this.gDd, e.d.cp_cont_e, 1);
            } else {
                al.c(this.gDd, e.d.cp_cont_j, 1);
            }
            if (StringUtils.isNull(intro)) {
                if (this.mIsHost) {
                    intro = this.mContext.getString(e.j.no_person_sign_host);
                } else {
                    intro = this.mContext.getString(e.j.no_person_sign_guest);
                }
            }
            this.gDd.setText(this.mContext.getString(e.j.person_sign) + intro);
            if (this.gDd.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gDd.getLayoutParams();
                if (!this.mIsHost && this.gDd.getLineCount() >= 3 && this.gDd.getMaxLines() != 2147483646) {
                    int lineHeight = this.gDd.getLineHeight();
                    this.gDd.setHeight((lineHeight / 2) + (lineHeight * 3));
                }
                if (this.gDd.getLineCount() >= 2) {
                    layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(e.C0210e.tbds19);
                } else {
                    layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(e.C0210e.tbds80);
                }
                this.gDd.setLayoutParams(layoutParams);
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(this.mUserData.getUserId()) && ((!TbadkCoreApplication.isLogin() || (!StringUtils.isNull(currentAccount) && !currentAccount.equals(this.mUserData.getUserId()))) && this.mUserData.getLiveStatus() == 1)) {
                if (this.gDg == null) {
                    this.gDg = com.baidu.tbadk.ala.b.vZ().j(this.mContext, 7);
                }
                com.baidu.tbadk.ala.a aVar2 = new com.baidu.tbadk.ala.a();
                aVar2.alI = this.mUserData.getAlaUserData();
                aVar2.type = 7;
                if ((this.mUserData.getPersonPrivate() != null && this.mUserData.getPersonPrivate().LC() == 3) || (this.mUserData.getPersonPrivate().LC() == 2 && this.mUserData.getIsFriend() != 1)) {
                    aVar2.alJ = true;
                } else {
                    aVar2.alJ = false;
                }
                if (this.gDg != null) {
                    this.gDg.setTag(aVar2);
                    if (this.gDg.getParent() == null) {
                        this.gDk.addView(this.gDg);
                        TiebaStatic.log(new am("c12541"));
                    }
                }
            } else if (this.gDg != null) {
                this.gDg.setVisibility(8);
            }
            a(aVar.gAO);
            this.mUserData.setIsLike(this.mUserData.getHave_attention() == 1);
            this.cXd.a(this.mUserData);
            brq();
            brr();
            this.gDu.setText(this.mIsHost ? e.j.my_received_gift : e.j.he_received_gift);
            if ((this.mUserData.getPersonPrivate() == null || this.mUserData.getPersonPrivate().LC() != 3) && this.mUserData.getPersonPrivate().LC() == 2 && this.mUserData.getIsFriend() != 1) {
            }
        }
    }

    public void tC(String str) {
        if (!StringUtils.isNull(str)) {
            this.aKV.setText(str);
        }
    }

    public void tD(String str) {
        if (!StringUtils.isNull(str)) {
            if (this.mUserData != null) {
                this.mUserData.setPortrait(str);
            }
            this.gCW.gn(str);
        }
    }

    private void a(UserAgreeInfo userAgreeInfo) {
        if (userAgreeInfo == null) {
            this.gDl.setVisibility(8);
            return;
        }
        this.gDl.setVisibility(0);
        String X = ao.X(userAgreeInfo.total_agree_num.longValue());
        Drawable drawable = al.getDrawable(e.f.icon_home_card_like_s);
        drawable.setBounds(0, 0, this.gDx, this.gDx);
        this.gDl.setCompoundDrawables(drawable, null, null, null);
        this.gDl.setText(X);
    }

    public void onChangeSkinType(int i) {
        this.gDb.setBackgroundDrawable(al.getDrawable(e.f.shape_user_info_bg));
        this.gCW.setBackgroundViewDrawable(al.getDrawable(e.f.shape_user_img_bg));
        int i2 = e.f.icon_mine_boy;
        if (this.mUserData != null) {
            i2 = this.mUserData.getSex() == 1 ? e.f.icon_mine_boy : e.f.icon_pop_girl;
        }
        if (this.mUserData != null && this.mUserData.getIsMem() <= 0 && this.gvA != null && this.mIsHost) {
            this.gvA.setImageDrawable(al.getDrawable(e.f.icon_crown_super_non));
        }
        bpw();
        al.c(this.gCZ, e.d.cp_link_tip_a, 1);
        this.aKV.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mContext.getResources().getDrawable(i2), (Drawable) null);
        if (this.gDa != null) {
            this.gDa.onChangeSkinType(i);
        }
        al.c(this.gCY, e.d.cp_cont_b, 1);
        al.c(this.gDc, e.d.cp_cont_b, 1);
        al.c(this.bOa, e.d.cp_cont_b, 1);
        if (this.mUserData == null || StringUtils.isNull(this.mUserData.getIntro())) {
            al.c(this.gDd, e.d.cp_cont_e, 1);
        } else {
            al.c(this.gDd, e.d.cp_cont_j, 1);
        }
        al.c(this.gDe, e.d.cp_cont_b, 1);
        al.c(this.gDh, e.d.cp_cont_b, 1);
        al.j(this.gDi, e.d.cp_bg_line_b);
        al.j(this.gDf, e.d.cp_bg_line_b);
        al.j(this.gDj, e.d.cp_bg_line_b);
        al.h(this.gDl, e.d.cp_cont_h);
        this.gDe.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(e.f.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
        Drawable y = al.y(i, e.f.icon_home_card_like_s);
        y.setBounds(0, 0, this.gDx, this.gDx);
        this.gDl.setCompoundDrawables(y, null, null, null);
        al.i(this.gDn, e.f.selector_give_gift_bg);
        al.c(this.gDo, e.f.selector_gift_icon);
        al.c(this.gDp, e.d.selector_give_gift_text_color, 1);
        this.gDq.onChangeSkinType(i);
        al.j(this.eun, e.d.cp_bg_line_e);
        for (int i3 = 0; i3 < this.gDr.getChildCount(); i3++) {
            View childAt = this.gDr.getChildAt(i3);
            if (childAt != null) {
                TextView textView = (TextView) childAt.findViewById(e.g.bar_name);
                textView.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.pic_v_avatar), (Drawable) null, (Drawable) null, (Drawable) null);
                al.h(textView, e.d.cp_cont_b);
                al.h((TextView) childAt.findViewById(e.g.bar_info), e.d.cp_cont_j);
            }
        }
        for (int i4 = 0; i4 < gCU.length; i4++) {
            ((TbImageView) this.mRootView.findViewById(gCU[i4])).setBackgroundDrawable(al.getDrawable(e.f.shape_gift_icon_bg));
        }
        al.j(this.gDt, e.d.cp_bg_line_e);
        al.h(this.gDu, e.d.cp_cont_b);
        al.h(this.gDv, e.d.cp_cont_d);
        al.c(this.gCV, e.f.icon_arrow_gray_right_n);
        al.i(this.gDw, e.f.selector_like_button_bg);
        al.c(this.gDw, e.d.cp_cont_g, 1);
    }

    public void onDestory() {
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.g gVar) {
        this.gCS = gVar;
        if (this.gDa != null) {
            this.gDa.setOnViewResponseListener(this.gCS);
        }
        this.gDm.setOnViewResponseListener(this.gCS);
    }

    public void tT(String str) {
        this.gCW.gm(str);
    }

    protected void brp() {
        this.gCW.setHasPendantStyle();
        this.gCW.getHeadView().setIsRound(true);
        this.gCW.getHeadView().setDrawBorder(false);
        this.gCW.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    protected void bpw() {
        if (this.mUserData != null && (this.mUserData.getIsMem() > 0 || this.mUserData.isBigV())) {
            al.c(this.aKV, e.d.cp_cont_h, 1);
        } else {
            al.c(this.aKV, e.d.cp_cont_b, 1);
        }
    }

    private void brq() {
        if (this.gCT != null && this.gCT.brk() != null) {
            this.gDr.removeAllViews();
            int godType = this.gCT.brk().getGodType();
            if (godType == 2 && v.H(this.gCT.brk().getForumGodList()) > 0) {
                this.gDr.setVisibility(0);
                for (ForumGodDetailInfo forumGodDetailInfo : this.gCT.brk().getForumGodList()) {
                    if (forumGodDetailInfo != null) {
                        cq(forumGodDetailInfo.forum_name, forumGodDetailInfo.intro);
                    }
                }
                return;
            } else if (godType == 1 && this.gCT.brk().getgodDetailInfo() != null && !StringUtils.isNull(this.gCT.brk().getgodDetailInfo().intro)) {
                this.gDr.setVisibility(0);
                cq(this.gCT.brk().getgodDetailInfo().intro, "");
                return;
            } else {
                return;
            }
        }
        this.gDr.setVisibility(8);
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
        this.gDr.addView(inflate, layoutParams);
    }

    private void brr() {
        int i;
        for (int i2 = 0; i2 < gCU.length; i2++) {
            ((TbImageView) this.mRootView.findViewById(gCU[i2])).setVisibility(8);
        }
        if (this.gCT == null || this.gCT.brj() == null || v.H(this.gCT.brj().gBc) <= 0) {
            i = 0;
        } else {
            int i3 = this.gCT.brj().giftNum;
            List<com.baidu.adp.widget.ListView.h> list = this.gCT.brj().gBc;
            for (int i4 = 0; i4 < list.size() && i4 < gCU.length; i4++) {
                if (list.get(i4) instanceof com.baidu.tieba.personPolymeric.c.o) {
                    TbImageView tbImageView = (TbImageView) this.mRootView.findViewById(gCU[i4]);
                    tbImageView.setVisibility(0);
                    tbImageView.setIsRound(true);
                    tbImageView.startLoad(((com.baidu.tieba.personPolymeric.c.o) list.get(i4)).picUrl, 10, false);
                }
            }
            i = i3;
        }
        this.gDv.setText(String.format(this.mContext.getResources().getString(e.j.gift_num), Integer.valueOf(i)));
    }
}
