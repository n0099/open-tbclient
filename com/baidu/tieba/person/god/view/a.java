package com.baidu.tieba.person.god.view;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdExpandImageView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BuyTBeanActivityConfig;
import com.baidu.tbadk.core.atomData.PersonListActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.q;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tbadk.data.UserVipInfoData;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.personInfo.bn;
import com.baidu.tieba.personInfo.h;
import com.baidu.tieba.u;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.personInfo.a implements com.baidu.tieba.person.a.a {
    private boolean abg;
    private TextView aeS;
    private View bWM;
    private ViewEventCenter bgJ;
    private ImageView boJ;
    private boolean ciS;
    private h epz;
    private View etA;
    private View etB;
    private View etC;
    private LinearLayout etD;
    private ImageView etE;
    private TextView etF;
    private ImageView etG;
    private ViewStub etH;
    private LinearLayout etI;
    private TextView etJ;
    private TextView etK;
    private TextView etL;
    private ImageView etM;
    private View etN;
    private TextView etO;
    private LinearLayout etP;
    private bn etj;
    private BdExpandImageView ets;
    private ImageView ett;
    private View etu;
    private HeadImageView etv;
    private ViewStub etw;
    private TbImageView etx;
    private String ety;
    private UserIconBox etz;
    private Activity mActivity;
    private View mRootView;
    private float bTH = 360.0f;
    final View.OnClickListener afk = new b(this);
    private final com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> aBq = new c(this);

    public a(h hVar, boolean z, ViewEventCenter viewEventCenter, int i) {
        this.abg = false;
        this.epz = hVar;
        this.mActivity = hVar.getActivity();
        this.ciS = z;
        if (3 == i) {
            this.abg = true;
        }
        this.bgJ = viewEventCenter;
        this.mRootView = LayoutInflater.from(this.mActivity).inflate(u.h.personinfo_god_head_view, (ViewGroup) null);
        initView();
    }

    private void initView() {
        this.bWM = this.mRootView.findViewById(u.g.root);
        this.ets = (BdExpandImageView) this.mRootView.findViewById(u.g.expand_image);
        this.ett = (ImageView) this.mRootView.findViewById(u.g.refresh_image);
        this.etu = this.mRootView.findViewById(u.g.layout_head);
        this.etv = (HeadImageView) this.mRootView.findViewById(u.g.user_head);
        this.etv.setContentDescription(this.epz.getResources().getString(u.j.my_portrait));
        if (this.abg) {
            this.etw = (ViewStub) this.mRootView.findViewById(u.g.viewsub_headimage_bigv);
            this.etw.inflate();
            this.etx = (TbImageView) this.mRootView.findViewById(u.g.user_head_mask_bigv);
        } else {
            this.etw = (ViewStub) this.mRootView.findViewById(u.g.viewsub_headimage_god);
            this.etw.inflate();
            this.boJ = (ImageView) this.mRootView.findViewById(u.g.user_head_mask);
        }
        this.etz = (UserIconBox) this.mRootView.findViewById(u.g.user_vip_icon);
        this.aeS = (TextView) this.mRootView.findViewById(u.g.user_name);
        this.etO = (TextView) this.mRootView.findViewById(u.g.my_tdou_value);
        this.etP = (LinearLayout) this.mRootView.findViewById(u.g.personinfo_tdou_wrapper);
        this.etB = this.mRootView.findViewById(u.g.layout_blank);
        this.etA = this.mRootView.findViewById(u.g.layout_user_fans);
        this.etC = this.mRootView.findViewById(u.g.layout_add_follow);
        this.etD = (LinearLayout) this.mRootView.findViewById(u.g.view_add_follow);
        this.etE = (ImageView) this.mRootView.findViewById(u.g.iv_add_follow);
        this.etF = (TextView) this.mRootView.findViewById(u.g.tv_add_follow);
        this.etG = (ImageView) this.mRootView.findViewById(u.g.user_msg);
        this.etK = (TextView) this.mRootView.findViewById(u.g.user_followers);
        this.etL = (TextView) this.mRootView.findViewById(u.g.user_fans);
        this.etM = (ImageView) this.mRootView.findViewById(u.g.red_tip);
        this.etN = this.mRootView.findViewById(u.g.line_fans);
        if (this.abg) {
            this.etH = (ViewStub) this.mRootView.findViewById(u.g.viewsub_bigv);
            this.etH.inflate();
            this.etI = (LinearLayout) this.mRootView.findViewById(u.g.viewsub_bigv_inflate);
            this.etJ = (TextView) this.mRootView.findViewById(u.g.tv_bigv);
            this.etJ.setOnClickListener(this.afk);
        }
        this.etL.setOnClickListener(this.afk);
        this.etK.setOnClickListener(this.afk);
        this.etG.setOnClickListener(this.afk);
        this.etB.setOnClickListener(this.afk);
        this.etC.setOnClickListener(this.afk);
        this.etD.setOnClickListener(this.epz);
        this.ets.setOnClickListener(this.epz);
        this.etz.setOnClickListener(this.epz);
        aOk();
        aOl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aOi() {
        return TbadkCoreApplication.m10getInst().appResponseToIntentClass(PersonListActivityConfig.class);
    }

    @Override // com.baidu.tieba.personInfo.a
    public void setBackBitmap(UserData userData) {
        String bg_pic = userData != null ? userData.getBg_pic() : null;
        if (StringUtils.isNull(bg_pic)) {
            com.baidu.tbadk.imageManager.c.CP().eD(1152000);
            Bitmap logoBitmap = BitmapHelper.getLogoBitmap(this.mActivity.getApplicationContext(), u.f.pic_mycenter_bg_def);
            if (logoBitmap == null) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = TbConfig.BitmapConfig;
                options.inSampleSize = 2;
                logoBitmap = BitmapHelper.getResBitmap(this.mActivity.getApplicationContext(), u.f.pic_mycenter_bg_def, options);
            }
            if (logoBitmap != null) {
                this.ets.setImageBitmap(logoBitmap);
                return;
            }
            return;
        }
        com.baidu.adp.lib.g.c.dF().a(bg_pic, 10, this.aBq, 0, 0, null, new Object[0]);
    }

    @Override // com.baidu.tieba.personInfo.a
    public void aOj() {
        if (this.etv != null) {
            this.etv.CM();
        }
        this.ets.setImageBitmap(null);
    }

    private void aOk() {
        if (this.ciS) {
            this.etG.setVisibility(8);
            this.etP.setVisibility(0);
            this.ets.setMinimumHeight(this.mActivity.getResources().getDimensionPixelOffset(u.e.ds640));
            return;
        }
        this.etG.setVisibility(0);
        this.etP.setVisibility(8);
        this.ets.setMinimumHeight(this.mActivity.getResources().getDimensionPixelOffset(u.e.ds710));
    }

    @Override // com.baidu.tieba.personInfo.a
    public void kT() {
        av.l(this.bWM, u.d.cp_bg_line_d);
        if (this.etj != null && this.etj.getUserData() != null) {
            if (this.etj.getUserData().getIsMem() > 0) {
                av.c(this.aeS, u.d.cp_other_b, 1);
            } else {
                av.c(this.aeS, u.d.cp_cont_b, 1);
            }
        }
        if (this.etO != null) {
            av.c(this.etO, u.d.tdou_focus_color, 1);
            this.etO.setCompoundDrawablesWithIntrinsicBounds(av.getDrawable(u.f.icon_huobi_tdou_selector), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        if (this.etj != null) {
            g(this.etj.getUserData());
        }
        av.c(this.etG, u.f.personinfo_msg_selector);
        if (this.boJ != null && !this.abg) {
            av.c(this.boJ, u.f.pic_shen_avatar_mine);
        }
        av.k(this.etB, u.d.cp_bg_line_d);
        av.k(this.etN, u.d.cp_cont_j);
        av.k(this.etu, u.f.bg_mycenter_avatar);
        av.k(this.etP, u.f.bg_mine_tdou);
        av.l(this.etC, u.d.cp_bg_line_d);
        av.l(this.etA, u.d.cp_bg_line_d);
        if (this.abg && this.etI != null) {
            av.l(this.etI, u.d.cp_bg_line_d);
            if (this.etJ != null) {
                av.c(this.etJ, u.d.cp_cont_j, 1);
            }
        }
        av.c(this.etK, u.d.cp_cont_j, 1);
        av.c(this.etL, u.d.cp_cont_j, 1);
        av.c(this.etM, u.f.icon_news_down_bar_one);
    }

    private void g(UserData userData) {
        if (this.etD != null && this.etF != null && this.etE != null) {
            if (userData == null || this.ciS) {
                this.etC.setVisibility(8);
                return;
            }
            this.etC.setVisibility(0);
            if (userData.getHave_attention() == 1) {
                av.c(this.etF, u.d.cp_cont_d, 1);
                this.etF.setText(u.j.attention_cancel);
                this.etE.setImageDrawable(null);
                this.etE.setVisibility(8);
                av.k(this.etD, u.f.btn_non_white_selector);
                return;
            }
            this.etE.setVisibility(0);
            av.c(this.etF, u.d.btn_forum_focus_color, 1);
            this.etF.setText(u.j.attention_n);
            av.k(this.etD, u.f.btn_focus_border_bg);
            av.c(this.etE, u.f.icon_add_mine_selector);
        }
    }

    private void aOl() {
        this.etv.setIsRound(true);
        this.etv.setDrawBorder(false);
        this.etv.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.etv.setOnClickListener(this.epz);
    }

    @Override // com.baidu.tieba.personInfo.a
    public HeadImageView getHeadImage() {
        return this.etv;
    }

    @Override // com.baidu.tieba.personInfo.a
    public UserIconBox getUserIcon() {
        return null;
    }

    @Override // com.baidu.tieba.personInfo.a
    public void setGiftIcon(boolean z) {
    }

    @Override // com.baidu.tieba.personInfo.a
    public void t(float f) {
        if (!this.ett.isShown()) {
            this.ett.setVisibility(0);
            this.ett.setImageDrawable(this.mActivity.getResources().getDrawable(u.f.icon_pop_refresh));
        }
        RotateAnimation rotateAnimation = new RotateAnimation(this.bTH, f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setFillBefore(true);
        rotateAnimation.setFillAfter(true);
        this.ett.startAnimation(rotateAnimation);
        this.bTH = f;
    }

    @Override // com.baidu.tieba.personInfo.a
    public void aap() {
        this.ett.clearAnimation();
        this.ett.setImageDrawable(null);
        this.ett.setVisibility(8);
    }

    @Override // com.baidu.tieba.personInfo.a
    public void jm() {
        if (!this.ett.isShown()) {
            this.ett.setVisibility(0);
            this.ett.setImageDrawable(this.mActivity.getResources().getDrawable(u.f.icon_pop_refresh));
        }
        this.ett.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.mActivity, u.a.user_info_center_head_rotate));
    }

    @Override // com.baidu.tieba.personInfo.a
    public void RP() {
        this.etj = this.epz.aPe();
        if (this.etj != null) {
            UserData userData = this.etj.getUserData();
            setBackBitmap(userData);
            i(userData);
            h(userData);
            g(userData);
        }
    }

    public void h(UserData userData) {
        if (!aOm() || userData == null) {
            this.etP.setVisibility(8);
            return;
        }
        if (this.ciS) {
            this.etP.setVisibility(0);
        } else {
            this.etP.setVisibility(8);
        }
        this.etO.setText(ba.H(userData.getTDouNum()));
        this.etP.setOnClickListener(new d(this));
    }

    private void i(UserData userData) {
        if (userData != null) {
            String portrait = userData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                String dh = q.dh(portrait);
                this.etv.setUrl(dh);
                this.etv.c(dh, 25, false);
            } else {
                this.etv.setImageResource(u.f.pic_mycenter_avatar_def_i);
            }
            UserTbVipInfoData userTbVipInfoData = userData.getUserTbVipInfoData();
            if (this.abg && userTbVipInfoData != null && this.etJ != null) {
                this.etJ.setText(this.mActivity.getResources().getString(u.j.user_bigv, userTbVipInfoData.getvipIntro()));
                if (this.etx != null && userTbVipInfoData.getvipV_url() != null) {
                    this.etx.c(userTbVipInfoData.getvipV_url(), 10, false);
                    this.ety = userTbVipInfoData.getvipV_detail();
                    this.etx.setOnClickListener(this.afk);
                }
            }
            ArrayList<IconData> tShowInfo = userData.getTShowInfo();
            UserVipInfoData userVipInfo = userData.getUserVipInfo();
            if (tShowInfo != null && tShowInfo.size() > 0) {
                if (userVipInfo != null && userVipInfo.getVipIconUrl() != null) {
                    tShowInfo.get(0).setIcon(userVipInfo.getVipIconUrl());
                }
                this.etz.setVisibility(0);
                this.etz.a(tShowInfo, tShowInfo.size(), this.mActivity.getResources().getDimensionPixelSize(u.e.ds34), this.mActivity.getResources().getDimensionPixelSize(u.e.ds34), this.mActivity.getResources().getDimensionPixelSize(u.e.ds10), true);
            } else {
                this.etz.setVisibility(8);
            }
            String name_show = userData.getName_show();
            if (!TextUtils.isEmpty(name_show)) {
                if (name_show.length() > 14) {
                    name_show = String.valueOf(name_show.substring(0, 14)) + "...";
                }
                this.aeS.setText(name_show);
                if (userData.getIsMem() > 0) {
                    av.c(this.aeS, u.d.cp_other_b, 1);
                } else {
                    av.c(this.aeS, u.d.cp_cont_b, 1);
                }
            }
            int dimensionPixelOffset = this.mActivity.getResources().getDimensionPixelOffset(u.e.ds10);
            if (this.ciS) {
                int dimensionPixelOffset2 = this.mActivity.getResources().getDimensionPixelOffset(u.e.ds36);
                if (this.abg && this.etI != null) {
                    this.etI.setPadding(0, dimensionPixelOffset, 0, dimensionPixelOffset2);
                    this.etA.setPadding(0, dimensionPixelOffset, 0, this.mActivity.getResources().getDimensionPixelOffset(u.e.ds10));
                } else {
                    this.etA.setPadding(0, dimensionPixelOffset, 0, dimensionPixelOffset2);
                }
            } else {
                int dimensionPixelOffset3 = this.mActivity.getResources().getDimensionPixelOffset(u.e.ds28);
                if (this.abg && this.etI != null) {
                    this.etI.setPadding(0, dimensionPixelOffset, 0, dimensionPixelOffset3);
                    this.etA.setPadding(0, dimensionPixelOffset, 0, this.mActivity.getResources().getDimensionPixelOffset(u.e.ds10));
                } else {
                    this.etA.setPadding(0, dimensionPixelOffset, 0, dimensionPixelOffset3);
                }
            }
            this.etK.setText(this.mActivity.getResources().getString(u.j.user_followers, ba.w(userData.getConcernNum())));
            this.etL.setText(this.mActivity.getResources().getString(u.j.user_fans, ba.w(userData.getFansNum())));
        }
    }

    @Override // com.baidu.tieba.personInfo.a
    public LinearLayout getMyGiftIcon() {
        return null;
    }

    @Override // com.baidu.tieba.personInfo.a
    public View getAttentionView() {
        return this.etD;
    }

    @Override // com.baidu.tieba.personInfo.a
    public UserIconBox getVipIcon() {
        return this.etz;
    }

    @Override // com.baidu.tieba.personInfo.a
    public LinearLayout getYinjiWraper() {
        return null;
    }

    @Override // com.baidu.tieba.personInfo.a
    public View getRootView() {
        return this.mRootView;
    }

    private boolean aOm() {
        return TbadkCoreApplication.m10getInst().appResponseToIntentClass(BuyTBeanActivityConfig.class);
    }

    @Override // com.baidu.tieba.person.a.a
    public void setRedTipShow(boolean z) {
        iu(z);
    }

    @Override // com.baidu.tieba.person.a.a
    public void m(boolean z, int i) {
        iu(z);
    }

    private void iu(boolean z) {
        if (this.etM != null) {
            if (z) {
                this.etM.setVisibility(0);
            } else {
                this.etM.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.personInfo.a
    public BdExpandImageView getExpandImg() {
        return this.ets;
    }
}
