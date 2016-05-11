package com.baidu.tieba.person.god.view;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.q;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.data.UserVipInfoData;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.personInfo.bg;
import com.baidu.tieba.personInfo.f;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.personInfo.a implements com.baidu.tieba.person.a.a {
    private ViewEventCenter aXs;
    private TextView adG;
    private boolean bIW;
    private View bxh;
    private BdExpandImageView dAH;
    private ImageView dAI;
    private View dAJ;
    private HeadImageView dAK;
    private ImageView dAL;
    private UserIconBox dAM;
    private View dAN;
    private View dAO;
    private View dAP;
    private LinearLayout dAQ;
    private ImageView dAR;
    private TextView dAS;
    private ImageView dAT;
    private TextView dAU;
    private TextView dAV;
    private ImageView dAW;
    private View dAX;
    private TextView dAY;
    private LinearLayout dAZ;
    private bg dAy;
    private f dxd;
    private Activity mActivity;
    private View mRootView;
    private float btX = 360.0f;
    final View.OnClickListener Fn = new b(this);
    private final com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> azI = new c(this);

    public a(f fVar, boolean z, ViewEventCenter viewEventCenter) {
        this.dxd = fVar;
        this.mActivity = fVar.getActivity();
        this.bIW = z;
        this.aXs = viewEventCenter;
        this.mRootView = LayoutInflater.from(this.mActivity).inflate(t.h.personinfo_god_head_view, (ViewGroup) null);
        initView();
    }

    private void initView() {
        this.bxh = this.mRootView.findViewById(t.g.root);
        this.dAH = (BdExpandImageView) this.mRootView.findViewById(t.g.expand_image);
        this.dAI = (ImageView) this.mRootView.findViewById(t.g.refresh_image);
        this.dAJ = this.mRootView.findViewById(t.g.layout_head);
        this.dAK = (HeadImageView) this.mRootView.findViewById(t.g.user_head);
        this.dAK.setContentDescription(this.dxd.getResources().getString(t.j.my_portrait));
        this.dAL = (ImageView) this.mRootView.findViewById(t.g.user_head_mask);
        this.dAM = (UserIconBox) this.mRootView.findViewById(t.g.user_vip_icon);
        this.adG = (TextView) this.mRootView.findViewById(t.g.user_name);
        this.dAY = (TextView) this.mRootView.findViewById(t.g.my_tdou_value);
        this.dAZ = (LinearLayout) this.mRootView.findViewById(t.g.personinfo_tdou_wrapper);
        this.dAO = this.mRootView.findViewById(t.g.layout_blank);
        this.dAN = this.mRootView.findViewById(t.g.layout_user_fans);
        this.dAP = this.mRootView.findViewById(t.g.layout_add_follow);
        this.dAQ = (LinearLayout) this.mRootView.findViewById(t.g.view_add_follow);
        this.dAR = (ImageView) this.mRootView.findViewById(t.g.iv_add_follow);
        this.dAS = (TextView) this.mRootView.findViewById(t.g.tv_add_follow);
        this.dAT = (ImageView) this.mRootView.findViewById(t.g.user_msg);
        this.dAU = (TextView) this.mRootView.findViewById(t.g.user_followers);
        this.dAV = (TextView) this.mRootView.findViewById(t.g.user_fans);
        this.dAW = (ImageView) this.mRootView.findViewById(t.g.red_tip);
        this.dAX = this.mRootView.findViewById(t.g.line_fans);
        this.dAV.setOnClickListener(this.Fn);
        this.dAU.setOnClickListener(this.Fn);
        this.dAT.setOnClickListener(this.Fn);
        this.dAO.setOnClickListener(this.Fn);
        this.dAP.setOnClickListener(this.Fn);
        this.dAQ.setOnClickListener(this.dxd);
        this.dAH.setOnClickListener(this.dxd);
        this.dAM.setOnClickListener(this.dxd);
        aCK();
        aCL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aCI() {
        return TbadkCoreApplication.m11getInst().appResponseToIntentClass(PersonListActivityConfig.class);
    }

    @Override // com.baidu.tieba.personInfo.a
    public void setBackBitmap(UserData userData) {
        String bg_pic = userData != null ? userData.getBg_pic() : null;
        if (StringUtils.isNull(bg_pic)) {
            com.baidu.tbadk.imageManager.c.CH().ez(1152000);
            Bitmap logoBitmap = BitmapHelper.getLogoBitmap(this.mActivity.getApplicationContext(), t.f.pic_mycenter_bg_def);
            if (logoBitmap == null) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = TbConfig.BitmapConfig;
                options.inSampleSize = 2;
                logoBitmap = BitmapHelper.getResBitmap(this.mActivity.getApplicationContext(), t.f.pic_mycenter_bg_def, options);
            }
            if (logoBitmap != null) {
                this.dAH.setImageBitmap(logoBitmap);
                return;
            }
            return;
        }
        com.baidu.adp.lib.g.c.dF().a(bg_pic, 10, this.azI, 0, 0, null, new Object[0]);
    }

    @Override // com.baidu.tieba.personInfo.a
    public void aCJ() {
        if (this.dAK != null) {
            this.dAK.CE();
        }
        this.dAH.setImageBitmap(null);
    }

    private void aCK() {
        if (this.bIW) {
            this.dAT.setVisibility(8);
            this.dAZ.setVisibility(0);
            this.dAH.setMinimumHeight(this.mActivity.getResources().getDimensionPixelOffset(t.e.ds640));
            return;
        }
        this.dAT.setVisibility(0);
        this.dAZ.setVisibility(8);
        this.dAH.setMinimumHeight(this.mActivity.getResources().getDimensionPixelOffset(t.e.ds710));
    }

    @Override // com.baidu.tieba.personInfo.a
    public void kU() {
        at.l(this.bxh, t.d.cp_bg_line_d);
        if (this.dAy != null && this.dAy.getUserData() != null) {
            if (this.dAy.getUserData().getIsMem() > 0) {
                at.c(this.adG, t.d.cp_other_b, 1);
            } else {
                at.c(this.adG, t.d.cp_cont_b, 1);
            }
        }
        if (this.dAY != null) {
            at.c(this.dAY, t.d.tdou_focus_color, 1);
            this.dAY.setCompoundDrawablesWithIntrinsicBounds(at.getDrawable(t.f.icon_huobi_tdou_selector), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        if (this.dAy != null) {
            g(this.dAy.getUserData());
        }
        at.c(this.dAT, t.f.personinfo_msg_selector);
        at.c(this.dAL, t.f.pic_shen_avatar_mine);
        at.k(this.dAO, t.d.cp_bg_line_d);
        at.k(this.dAX, t.d.cp_cont_j);
        at.k(this.dAJ, t.f.bg_mycenter_avatar);
        at.k(this.dAZ, t.f.bg_mine_tdou);
        at.l(this.dAP, t.d.cp_bg_line_d);
        at.l(this.dAN, t.d.cp_bg_line_d);
        at.c(this.dAU, t.d.cp_cont_j, 1);
        at.c(this.dAV, t.d.cp_cont_j, 1);
        at.c(this.dAW, t.f.icon_news_down_bar_one);
    }

    private void g(UserData userData) {
        if (this.dAQ != null && this.dAS != null && this.dAR != null) {
            if (userData == null || this.bIW) {
                this.dAP.setVisibility(8);
                return;
            }
            this.dAP.setVisibility(0);
            if (userData.getHave_attention() == 1) {
                at.c(this.dAS, t.d.cp_cont_d, 1);
                this.dAS.setText(t.j.attention_cancel);
                this.dAR.setImageDrawable(null);
                this.dAR.setVisibility(8);
                at.k(this.dAQ, t.f.btn_non_white_selector);
                return;
            }
            this.dAR.setVisibility(0);
            at.c(this.dAS, t.d.btn_forum_focus_color, 1);
            this.dAS.setText(t.j.attention_n);
            at.k(this.dAQ, t.f.btn_focus_border_bg);
            at.c(this.dAR, t.f.icon_add_mine_selector);
        }
    }

    private void aCL() {
        this.dAK.setIsRound(true);
        this.dAK.setDrawBorder(false);
        this.dAK.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.dAK.setOnClickListener(this.dxd);
    }

    @Override // com.baidu.tieba.personInfo.a
    public HeadImageView getHeadImage() {
        return this.dAK;
    }

    @Override // com.baidu.tieba.personInfo.a
    public UserIconBox getUserIcon() {
        return null;
    }

    @Override // com.baidu.tieba.personInfo.a
    public void setGiftIcon(boolean z) {
    }

    @Override // com.baidu.tieba.personInfo.a
    public void j(float f) {
        if (!this.dAI.isShown()) {
            this.dAI.setVisibility(0);
            this.dAI.setImageDrawable(this.mActivity.getResources().getDrawable(t.f.icon_pop_refresh));
        }
        RotateAnimation rotateAnimation = new RotateAnimation(this.btX, f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setFillBefore(true);
        rotateAnimation.setFillAfter(true);
        this.dAI.startAnimation(rotateAnimation);
        this.btX = f;
    }

    @Override // com.baidu.tieba.personInfo.a
    public void Pl() {
        this.dAI.clearAnimation();
        this.dAI.setImageDrawable(null);
        this.dAI.setVisibility(8);
    }

    @Override // com.baidu.tieba.personInfo.a
    public void jk() {
        if (!this.dAI.isShown()) {
            this.dAI.setVisibility(0);
            this.dAI.setImageDrawable(this.mActivity.getResources().getDrawable(t.f.icon_pop_refresh));
        }
        this.dAI.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.mActivity, t.a.user_info_center_head_rotate));
    }

    @Override // com.baidu.tieba.personInfo.a
    public void aBX() {
        this.dAy = this.dxd.aDb();
        if (this.dAy != null) {
            UserData userData = this.dAy.getUserData();
            setBackBitmap(userData);
            i(userData);
            h(userData);
            g(userData);
        }
    }

    public void h(UserData userData) {
        if (!aCM() || userData == null) {
            this.dAZ.setVisibility(8);
            return;
        }
        if (this.bIW) {
            this.dAZ.setVisibility(0);
        } else {
            this.dAZ.setVisibility(8);
        }
        this.dAY.setText(ay.J(userData.getTDouNum()));
        this.dAZ.setOnClickListener(new d(this));
    }

    private void i(UserData userData) {
        if (userData != null) {
            String portrait = userData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                String dk = q.dk(portrait);
                this.dAK.setUrl(dk);
                this.dAK.c(dk, 25, false);
            } else {
                this.dAK.setImageResource(t.f.pic_mycenter_avatar_def_i);
            }
            ArrayList<IconData> tShowInfo = userData.getTShowInfo();
            UserVipInfoData userVipInfo = userData.getUserVipInfo();
            if (tShowInfo != null && tShowInfo.size() > 0) {
                if (userVipInfo != null && userVipInfo.getVipIconUrl() != null) {
                    tShowInfo.get(0).setIcon(userVipInfo.getVipIconUrl());
                }
                this.dAM.setVisibility(0);
                this.dAM.a(tShowInfo, tShowInfo.size(), this.mActivity.getResources().getDimensionPixelSize(t.e.ds34), this.mActivity.getResources().getDimensionPixelSize(t.e.ds34), this.mActivity.getResources().getDimensionPixelSize(t.e.ds10), true);
            } else {
                this.dAM.setVisibility(8);
            }
            String name_show = userData.getName_show();
            if (!TextUtils.isEmpty(name_show)) {
                if (name_show.length() > 14) {
                    name_show = String.valueOf(name_show.substring(0, 14)) + "...";
                }
                this.adG.setText(name_show);
                if (userData.getIsMem() > 0) {
                    at.c(this.adG, t.d.cp_other_b, 1);
                } else {
                    at.c(this.adG, t.d.cp_cont_b, 1);
                }
            }
            int dimensionPixelOffset = this.mActivity.getResources().getDimensionPixelOffset(t.e.ds10);
            if (this.bIW) {
                this.dAN.setPadding(0, dimensionPixelOffset, 0, this.mActivity.getResources().getDimensionPixelOffset(t.e.ds36));
            } else {
                this.dAN.setPadding(0, dimensionPixelOffset, 0, this.mActivity.getResources().getDimensionPixelOffset(t.e.ds28));
            }
            this.dAU.setText(this.mActivity.getResources().getString(t.j.user_followers, ay.A(userData.getConcernNum())));
            this.dAV.setText(this.mActivity.getResources().getString(t.j.user_fans, ay.A(userData.getFansNum())));
        }
    }

    @Override // com.baidu.tieba.personInfo.a
    public LinearLayout getMyGiftIcon() {
        return null;
    }

    @Override // com.baidu.tieba.personInfo.a
    public View getAttentionView() {
        return this.dAQ;
    }

    @Override // com.baidu.tieba.personInfo.a
    public UserIconBox getVipIcon() {
        return this.dAM;
    }

    @Override // com.baidu.tieba.personInfo.a
    public LinearLayout getYinjiWraper() {
        return null;
    }

    @Override // com.baidu.tieba.personInfo.a
    public View getRootView() {
        return this.mRootView;
    }

    private boolean aCM() {
        return TbadkCoreApplication.m11getInst().appResponseToIntentClass(BuyTBeanActivityConfig.class);
    }

    @Override // com.baidu.tieba.person.a.a
    public void setRedTipShow(boolean z) {
        hq(z);
    }

    @Override // com.baidu.tieba.person.a.a
    public void i(boolean z, int i) {
        hq(z);
    }

    private void hq(boolean z) {
        if (this.dAW != null) {
            if (z) {
                this.dAW.setVisibility(0);
            } else {
                this.dAW.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.personInfo.a
    public BdExpandImageView getExpandImg() {
        return this.dAH;
    }
}
