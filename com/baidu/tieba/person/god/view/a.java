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
import com.baidu.tieba.personInfo.bf;
import com.baidu.tieba.personInfo.f;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.personInfo.a implements com.baidu.tieba.person.a.a {
    private TextView ahM;
    private boolean bIP;
    private View bJp;
    private ViewEventCenter bbj;
    private f duk;
    private BdExpandImageView dxB;
    private ImageView dxC;
    private View dxE;
    private HeadImageView dxF;
    private ImageView dxG;
    private UserIconBox dxH;
    private View dxI;
    private View dxJ;
    private View dxK;
    private LinearLayout dxL;
    private ImageView dxM;
    private TextView dxN;
    private ImageView dxO;
    private TextView dxP;
    private TextView dxQ;
    private ImageView dxR;
    private View dxS;
    private TextView dxT;
    private LinearLayout dxU;
    private bf dxs;
    private Activity mActivity;
    private View mRootView;
    private float dxD = 360.0f;
    final View.OnClickListener OZ = new b(this);
    private final com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> aDE = new c(this);

    public a(f fVar, boolean z, ViewEventCenter viewEventCenter) {
        this.duk = fVar;
        this.mActivity = fVar.getActivity();
        this.bIP = z;
        this.bbj = viewEventCenter;
        this.mRootView = LayoutInflater.from(this.mActivity).inflate(t.h.personinfo_god_head_view, (ViewGroup) null);
        initView();
    }

    private void initView() {
        this.bJp = this.mRootView.findViewById(t.g.root);
        this.dxB = (BdExpandImageView) this.mRootView.findViewById(t.g.expand_image);
        this.dxC = (ImageView) this.mRootView.findViewById(t.g.refresh_image);
        this.dxE = this.mRootView.findViewById(t.g.layout_head);
        this.dxF = (HeadImageView) this.mRootView.findViewById(t.g.user_head);
        this.dxF.setContentDescription(this.duk.getResources().getString(t.j.my_portrait));
        this.dxG = (ImageView) this.mRootView.findViewById(t.g.user_head_mask);
        this.dxH = (UserIconBox) this.mRootView.findViewById(t.g.user_vip_icon);
        this.ahM = (TextView) this.mRootView.findViewById(t.g.user_name);
        this.dxT = (TextView) this.mRootView.findViewById(t.g.my_tdou_value);
        this.dxU = (LinearLayout) this.mRootView.findViewById(t.g.personinfo_tdou_wrapper);
        this.dxJ = this.mRootView.findViewById(t.g.layout_blank);
        this.dxI = this.mRootView.findViewById(t.g.layout_user_fans);
        this.dxK = this.mRootView.findViewById(t.g.layout_add_follow);
        this.dxL = (LinearLayout) this.mRootView.findViewById(t.g.view_add_follow);
        this.dxM = (ImageView) this.mRootView.findViewById(t.g.iv_add_follow);
        this.dxN = (TextView) this.mRootView.findViewById(t.g.tv_add_follow);
        this.dxO = (ImageView) this.mRootView.findViewById(t.g.user_msg);
        this.dxP = (TextView) this.mRootView.findViewById(t.g.user_followers);
        this.dxQ = (TextView) this.mRootView.findViewById(t.g.user_fans);
        this.dxR = (ImageView) this.mRootView.findViewById(t.g.red_tip);
        this.dxS = this.mRootView.findViewById(t.g.line_fans);
        this.dxQ.setOnClickListener(this.OZ);
        this.dxP.setOnClickListener(this.OZ);
        this.dxO.setOnClickListener(this.OZ);
        this.dxL.setOnClickListener(this.duk);
        this.dxB.setOnClickListener(this.duk);
        this.dxH.setOnClickListener(this.duk);
        aCs();
        aCt();
    }

    @Override // com.baidu.tieba.personInfo.a
    public void setBackBitmap(UserData userData) {
        String bg_pic = userData != null ? userData.getBg_pic() : null;
        if (StringUtils.isNull(bg_pic)) {
            com.baidu.tbadk.imageManager.c.EO().eT(1152000);
            Bitmap logoBitmap = BitmapHelper.getLogoBitmap(this.mActivity.getApplicationContext(), t.f.pic_mycenter_bg_def);
            if (logoBitmap == null) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = TbConfig.BitmapConfig;
                options.inSampleSize = 2;
                logoBitmap = BitmapHelper.getResBitmap(this.mActivity.getApplicationContext(), t.f.pic_mycenter_bg_def, options);
            }
            if (logoBitmap != null) {
                this.dxB.setImageBitmap(logoBitmap);
                return;
            }
            return;
        }
        com.baidu.adp.lib.g.c.hr().a(bg_pic, 10, this.aDE, 0, 0, null, new Object[0]);
    }

    @Override // com.baidu.tieba.personInfo.a
    public void aCr() {
        if (this.dxF != null) {
            this.dxF.EL();
        }
        this.dxB.setImageBitmap(null);
    }

    private void aCs() {
        if (this.bIP) {
            this.dxO.setVisibility(8);
            this.dxU.setVisibility(0);
            this.dxB.setMinimumHeight(this.mActivity.getResources().getDimensionPixelOffset(t.e.ds640));
            return;
        }
        this.dxO.setVisibility(0);
        this.dxU.setVisibility(8);
        this.dxB.setMinimumHeight(this.mActivity.getResources().getDimensionPixelOffset(t.e.ds710));
    }

    @Override // com.baidu.tieba.personInfo.a
    public void oH() {
        at.l(this.bJp, t.d.cp_bg_line_d);
        if (this.dxs != null && this.dxs.getUserData() != null) {
            if (this.dxs.getUserData().getIsMem() > 0) {
                at.b(this.ahM, t.d.cp_other_b, 1);
            } else {
                at.b(this.ahM, t.d.cp_cont_b, 1);
            }
        }
        if (this.dxT != null) {
            at.b(this.dxT, t.d.tdou_focus_color, 1);
            this.dxT.setCompoundDrawablesWithIntrinsicBounds(at.getDrawable(t.f.icon_huobi_tdou_selector), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        if (this.dxs != null) {
            g(this.dxs.getUserData());
        }
        at.c(this.dxO, t.f.personinfo_msg_selector);
        at.c(this.dxG, t.f.pic_shen_avatar_mine);
        at.k(this.dxJ, t.d.cp_bg_line_d);
        at.k(this.dxS, t.d.cp_cont_j);
        at.k(this.dxE, t.f.bg_mycenter_avatar);
        at.k(this.dxU, t.f.bg_mine_tdou);
        at.l(this.dxK, t.d.cp_bg_line_d);
        at.l(this.dxI, t.d.cp_bg_line_d);
        at.b(this.dxP, t.d.cp_cont_j, 1);
        at.b(this.dxQ, t.d.cp_cont_j, 1);
        at.c(this.dxR, t.f.icon_news_down_bar_one);
    }

    private void g(UserData userData) {
        if (this.dxL != null && this.dxN != null && this.dxM != null) {
            if (userData == null || this.bIP) {
                this.dxK.setVisibility(8);
                return;
            }
            this.dxK.setVisibility(0);
            if (userData.getHave_attention() == 1) {
                at.b(this.dxN, t.d.cp_cont_d, 1);
                this.dxN.setText(t.j.attention_cancel);
                this.dxM.setImageDrawable(null);
                this.dxM.setVisibility(8);
                at.k(this.dxL, t.f.btn_non_white_selector);
                return;
            }
            this.dxM.setVisibility(0);
            at.b(this.dxN, t.d.btn_forum_focus_color, 1);
            this.dxN.setText(t.j.attention_n);
            at.k(this.dxL, t.f.btn_focus_border_bg);
            at.c(this.dxM, t.f.icon_add_mine_selector);
        }
    }

    private void aCt() {
        this.dxF.setIsRound(true);
        this.dxF.setDrawBorder(false);
        this.dxF.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.dxF.setOnClickListener(this.duk);
    }

    @Override // com.baidu.tieba.personInfo.a
    public HeadImageView getHeadImage() {
        return this.dxF;
    }

    @Override // com.baidu.tieba.personInfo.a
    public UserIconBox getUserIcon() {
        return null;
    }

    @Override // com.baidu.tieba.personInfo.a
    public void setGiftIcon(boolean z) {
    }

    @Override // com.baidu.tieba.personInfo.a
    public void l(float f) {
        if (!this.dxC.isShown()) {
            this.dxC.setVisibility(0);
            this.dxC.setImageDrawable(this.mActivity.getResources().getDrawable(t.f.icon_pop_refresh));
        }
        RotateAnimation rotateAnimation = new RotateAnimation(this.dxD, f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setFillBefore(true);
        rotateAnimation.setFillAfter(true);
        this.dxC.startAnimation(rotateAnimation);
        this.dxD = f;
    }

    @Override // com.baidu.tieba.personInfo.a
    public void Qo() {
        this.dxC.clearAnimation();
        this.dxC.setImageDrawable(null);
        this.dxC.setVisibility(8);
    }

    @Override // com.baidu.tieba.personInfo.a
    public void mW() {
        if (!this.dxC.isShown()) {
            this.dxC.setVisibility(0);
            this.dxC.setImageDrawable(this.mActivity.getResources().getDrawable(t.f.icon_pop_refresh));
        }
        this.dxC.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.mActivity, t.a.user_info_center_head_rotate));
    }

    @Override // com.baidu.tieba.personInfo.a
    public void arP() {
        this.dxs = this.duk.aCH();
        if (this.dxs != null) {
            UserData userData = this.dxs.getUserData();
            setBackBitmap(userData);
            i(userData);
            h(userData);
            g(userData);
        }
    }

    public void h(UserData userData) {
        if (!aCu() || userData == null) {
            this.dxU.setVisibility(8);
            return;
        }
        if (this.bIP) {
            this.dxU.setVisibility(0);
        } else {
            this.dxU.setVisibility(8);
        }
        this.dxT.setText(ay.I(userData.getTDouNum()));
        this.dxU.setOnClickListener(new d(this));
    }

    private void i(UserData userData) {
        if (userData != null) {
            String portrait = userData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                String dm = q.dm(portrait);
                this.dxF.setUrl(dm);
                this.dxF.c(dm, 25, false);
            } else {
                this.dxF.setImageResource(t.f.pic_mycenter_avatar_def_i);
            }
            ArrayList<IconData> tShowInfo = userData.getTShowInfo();
            UserVipInfoData userVipInfo = userData.getUserVipInfo();
            if (tShowInfo != null && tShowInfo.size() > 0) {
                if (userVipInfo != null && userVipInfo.getVipIconUrl() != null) {
                    tShowInfo.get(0).setIcon(userVipInfo.getVipIconUrl());
                }
                this.dxH.setVisibility(0);
                this.dxH.a(tShowInfo, tShowInfo.size(), this.mActivity.getResources().getDimensionPixelSize(t.e.ds34), this.mActivity.getResources().getDimensionPixelSize(t.e.ds34), this.mActivity.getResources().getDimensionPixelSize(t.e.ds10), true);
            } else {
                this.dxH.setVisibility(8);
            }
            String name_show = userData.getName_show();
            if (!TextUtils.isEmpty(name_show)) {
                if (name_show.length() > 14) {
                    name_show = String.valueOf(name_show.substring(0, 14)) + "...";
                }
                this.ahM.setText(name_show);
                if (userData.getIsMem() > 0) {
                    at.b(this.ahM, t.d.cp_other_b, 1);
                } else {
                    at.b(this.ahM, t.d.cp_cont_b, 1);
                }
            }
            int dimensionPixelOffset = this.mActivity.getResources().getDimensionPixelOffset(t.e.ds10);
            if (this.bIP) {
                this.dxI.setPadding(0, dimensionPixelOffset, 0, this.mActivity.getResources().getDimensionPixelOffset(t.e.ds36));
            } else {
                this.dxI.setPadding(0, dimensionPixelOffset, 0, this.mActivity.getResources().getDimensionPixelOffset(t.e.ds28));
            }
            this.dxP.setText(this.mActivity.getResources().getString(t.j.user_followers, ay.z(userData.getConcernNum())));
            this.dxQ.setText(this.mActivity.getResources().getString(t.j.user_fans, ay.z(userData.getFansNum())));
        }
    }

    @Override // com.baidu.tieba.personInfo.a
    public LinearLayout getMyGiftIcon() {
        return null;
    }

    @Override // com.baidu.tieba.personInfo.a
    public View getAttentionView() {
        return this.dxL;
    }

    @Override // com.baidu.tieba.personInfo.a
    public UserIconBox getVipIcon() {
        return this.dxH;
    }

    @Override // com.baidu.tieba.personInfo.a
    public LinearLayout getYinjiWraper() {
        return null;
    }

    @Override // com.baidu.tieba.personInfo.a
    public View getRootView() {
        return this.mRootView;
    }

    private boolean aCu() {
        return TbadkCoreApplication.m411getInst().appResponseToIntentClass(BuyTBeanActivityConfig.class);
    }

    @Override // com.baidu.tieba.person.a.a
    public void setRedTipShow(boolean z) {
        gK(z);
    }

    @Override // com.baidu.tieba.person.a.a
    public void g(boolean z, int i) {
        gK(z);
    }

    private void gK(boolean z) {
        if (this.dxR != null) {
            if (z) {
                this.dxR.setVisibility(0);
            } else {
                this.dxR.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.personInfo.a
    public BdExpandImageView getExpandImg() {
        return this.dxB;
    }
}
