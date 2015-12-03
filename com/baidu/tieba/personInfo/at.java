package com.baidu.tieba.personInfo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdExpandImageView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BuyTBeanActivityConfig;
import com.baidu.tbadk.core.atomData.MyGiftListActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.data.UserVipInfoData;
import com.baidu.tieba.n;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class at {
    private TextView bIz;
    private View bwP;
    private d cLT;
    private TextView cSA;
    private UserIconBox cSB;
    private LinearLayout cSC;
    private LinearLayout cSD;
    private LinearLayout cSE;
    private ImageView cSF;
    private TextView cSG;
    private ImageView cSH;
    private LinearLayout cSI;
    private ImageView cSJ;
    private LinearLayout cSK;
    private ImageView cSL;
    private TextView cSM;
    private LinearLayout cSN;
    private TextView cSO;
    private TextView cSP;
    private ImageView cSQ;
    private BdExpandImageView cSr;
    private ImageView cSs;
    private RelativeLayout cSu;
    private HeadImageView cSv;
    private UserIconBox cSw;
    private TextView cSx;
    private ImageView cSy;
    private TextView cSz;
    private TextView cbS;
    private TextView cvv;
    private BaseFragmentActivity mActivity;
    private Bitmap mBitmap;
    private boolean mIsHost;
    private View mRootView;
    private float cSt = 360.0f;
    private int cSR = 12;
    private final com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> aAj = new au(this);

    public at(d dVar, boolean z) {
        this.cLT = dVar;
        this.mActivity = dVar.getBaseFragmentActivity();
        this.mIsHost = z;
        this.mRootView = LayoutInflater.from(this.mActivity.getPageContext().getPageActivity()).inflate(n.g.personinfo_head_view, (ViewGroup) null);
        this.mRootView.setLayoutParams(new AbsListView.LayoutParams(-1, this.mActivity.getResources().getDimensionPixelSize(n.d.ds560)));
        initView();
    }

    private void initView() {
        this.bwP = this.mRootView.findViewById(n.f.root);
        this.cSr = (BdExpandImageView) this.mRootView.findViewById(n.f.expand_image);
        this.cSs = (ImageView) this.mRootView.findViewById(n.f.refresh_image);
        this.cSu = (RelativeLayout) this.mRootView.findViewById(n.f.head);
        this.cSv = (HeadImageView) this.mRootView.findViewById(n.f.user_head);
        this.cSw = (UserIconBox) this.mRootView.findViewById(n.f.user_vip_icon);
        this.cSC = (LinearLayout) this.mRootView.findViewById(n.f.yinji_wrapper);
        this.cSD = (LinearLayout) this.mRootView.findViewById(n.f.sign_wrapper);
        this.cSw.setOnClickListener(this.cLT);
        this.cvv = (TextView) this.mRootView.findViewById(n.f.user_name);
        this.cSx = (TextView) this.mRootView.findViewById(n.f.user_signs);
        this.cSy = (ImageView) this.mRootView.findViewById(n.f.user_sex);
        this.cSz = (TextView) this.mRootView.findViewById(n.f.user_bar_age);
        this.cSA = (TextView) this.mRootView.findViewById(n.f.user_bar_age_num);
        this.cSB = (UserIconBox) this.mRootView.findViewById(n.f.user_icon);
        this.cSB.setOnClickListener(this.cLT);
        this.cSG = (TextView) this.mRootView.findViewById(n.f.btn_attention);
        this.cSF = (ImageView) this.mRootView.findViewById(n.f.follow_icon);
        this.cSE = (LinearLayout) this.mRootView.findViewById(n.f.btn_attention_wrapper);
        this.cSE.setOnClickListener(this.cLT);
        this.cSK = (LinearLayout) this.mRootView.findViewById(n.f.my_gift_ll);
        this.cSK.setOnClickListener(this.cLT);
        this.cSL = (ImageView) this.mRootView.findViewById(n.f.my_gift);
        this.cSM = (TextView) this.mRootView.findViewById(n.f.my_tdou_value);
        this.cSN = (LinearLayout) this.mRootView.findViewById(n.f.personinfo_tdou_wrapper);
        this.cSO = (TextView) this.mRootView.findViewById(n.f.my_tdou_get);
        this.cSP = (TextView) this.mRootView.findViewById(n.f.tdou_divider);
        this.cSQ = (ImageView) this.mRootView.findViewById(n.f.my_tdou_arrow);
        aoU();
        aoV();
    }

    public void g(UserData userData) {
        String bg_pic = userData.getBg_pic();
        if (StringUtils.isNull(bg_pic)) {
            com.baidu.tbadk.imageManager.c.CX().ez(1152000);
            Bitmap f = com.baidu.tbadk.core.util.c.f(this.mActivity.getApplicationContext(), n.e.pic_mycenter_bg_def);
            if (f == null) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = TbConfig.BitmapConfig;
                options.inSampleSize = 2;
                f = com.baidu.tbadk.core.util.c.a(this.mActivity.getApplicationContext(), n.e.pic_mycenter_bg_def, options);
            }
            if (f != null) {
                this.cSr.setImageBitmap(f);
                return;
            }
            return;
        }
        com.baidu.adp.lib.g.c.hd().a(bg_pic, 10, this.aAj, 0, 0, null, new Object[0]);
    }

    public void aoT() {
        if (this.mBitmap != null) {
            this.mBitmap.recycle();
            com.baidu.tbadk.core.util.c.co(n.e.bg_mycenter_banner);
            System.gc();
        }
        if (this.cSv != null) {
            this.cSv.CU();
        }
        this.cSr.setImageBitmap(null);
    }

    private void aoU() {
        if (TbadkCoreApplication.m411getInst().isGiftSwitchOn()) {
            this.cSK.setVisibility(0);
        } else {
            this.cSK.setVisibility(8);
        }
        if (TbadkCoreApplication.m411getInst().getIntentClass(MyGiftListActivityConfig.class) == null) {
            this.cSK.setVisibility(8);
        }
        if (this.mIsHost) {
            this.cSK.setVisibility(8);
            this.cSE.setVisibility(8);
            return;
        }
        this.cSN.setVisibility(8);
    }

    public void oV() {
        com.baidu.tbadk.core.util.as.j(this.bwP, n.c.cp_bg_line_c);
        UserData userData = this.cLT.aoE().getUserData();
        if (userData != null) {
            if (userData.getIsMem() > 0) {
                this.cvv.setTextColor(this.mActivity.getResources().getColor(n.c.cp_other_b));
            } else {
                this.cvv.setTextColor(this.mActivity.getResources().getColor(n.c.cp_cont_g));
            }
        } else {
            this.cvv.setTextColor(this.mActivity.getResources().getColor(n.c.cp_cont_g));
        }
        if (userData != null) {
            if (!TextUtils.isEmpty(userData.getIntro())) {
                com.baidu.tbadk.core.util.as.b(this.cSx, n.c.cp_cont_f, 1);
            } else {
                com.baidu.tbadk.core.util.as.b(this.cSx, n.c.cp_cont_d, 1);
            }
        } else {
            com.baidu.tbadk.core.util.as.b(this.cSx, n.c.cp_cont_d, 1);
        }
        this.cSz.setTextColor(this.mActivity.getResources().getColor(n.c.cp_cont_g));
        this.cSA.setTextColor(this.mActivity.getResources().getColor(n.c.cp_cont_g));
        com.baidu.tbadk.core.util.as.i(this.cSK, n.e.personinfo_head_icon);
        com.baidu.tbadk.core.util.as.c(this.cSL, n.e.icon_mycenter_gift);
        if (userData != null) {
            if (userData.getHave_attention() == 1) {
                com.baidu.tbadk.core.util.as.i(this.cSE, n.e.btn_pop_news);
                com.baidu.tbadk.core.util.as.b(this.cSG, n.c.cp_link_tip_c, 1);
            } else {
                com.baidu.tbadk.core.util.as.i(this.cSE, n.e.personinfo_follow_btn);
                com.baidu.tbadk.core.util.as.i(this.cSF, n.e.icon_person_add_n);
                com.baidu.tbadk.core.util.as.b(this.cSG, n.c.cp_cont_i, 1);
            }
        } else {
            com.baidu.tbadk.core.util.as.i(this.cSE, n.e.personinfo_follow_btn);
            com.baidu.tbadk.core.util.as.i(this.cSF, n.e.icon_person_add_n);
            com.baidu.tbadk.core.util.as.b(this.cSG, n.c.cp_cont_i, 1);
        }
        com.baidu.tbadk.core.util.as.b(this.cbS, n.c.cp_cont_g, 1);
        com.baidu.tbadk.core.util.as.b(this.bIz, n.c.cp_cont_g, 1);
        com.baidu.tbadk.core.util.as.i(this.cSH, n.e.icon_mycenter_bar_site);
        com.baidu.tbadk.core.util.as.i(this.cSJ, n.e.icon_mycenter_bar_date);
        com.baidu.tbadk.core.util.as.i(this.cSC, n.c.cp_bg_line_d);
        com.baidu.tbadk.core.util.as.i(this.cSD, n.c.cp_bg_line_d);
        this.cSM.setCompoundDrawablesWithIntrinsicBounds(this.mActivity.getResources().getDrawable(n.e.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    private void aoV() {
        this.cSv.setIsRound(true);
        this.cSv.setDrawBorder(false);
        this.cSv.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.cSv.setOnClickListener(this.cLT);
    }

    public HeadImageView aoW() {
        return this.cSv;
    }

    public UserIconBox aoX() {
        return this.cSB;
    }

    public void fM(boolean z) {
        if (this.cSL != null) {
            if (z) {
                com.baidu.tbadk.core.util.as.c(this.cSL, n.e.icon_mycenter_gift_open);
            } else {
                com.baidu.tbadk.core.util.as.c(this.cSL, n.e.icon_mycenter_gift);
            }
        }
    }

    public void j(float f) {
        if (!this.cSs.isShown()) {
            this.cSs.setVisibility(0);
            this.cSs.setImageDrawable(this.mActivity.getResources().getDrawable(n.e.icon_pop_refresh));
        }
        RotateAnimation rotateAnimation = new RotateAnimation(this.cSt, f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setFillBefore(true);
        rotateAnimation.setFillAfter(true);
        this.cSs.startAnimation(rotateAnimation);
        this.cSt = f;
    }

    public void hideProgress() {
        this.cSs.clearAnimation();
        this.cSs.setImageDrawable(null);
        this.cSs.setVisibility(8);
    }

    public void ns() {
        if (!this.cSs.isShown()) {
            this.cSs.setVisibility(0);
            this.cSs.setImageDrawable(this.mActivity.getResources().getDrawable(n.e.icon_pop_refresh));
        }
        this.cSs.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.mActivity.getPageContext().getPageActivity(), n.a.user_info_center_head_rotate));
    }

    public void afN() {
        aw aoE = this.cLT.aoE();
        UserData userData = aoE.getUserData();
        g(userData);
        i(userData);
        h(userData);
        aoE.apc();
    }

    public void h(UserData userData) {
        if (!apb()) {
            this.cSN.setVisibility(8);
            return;
        }
        if (this.mIsHost) {
            this.cSN.setVisibility(0);
        } else {
            this.cSN.setVisibility(8);
        }
        if (userData != null) {
            this.cSM.setText(com.baidu.tbadk.core.util.ax.D(userData.getTDouNum()));
            this.cSN.setOnClickListener(new av(this));
        }
    }

    private void i(UserData userData) {
        if (userData != null) {
            String portrait = userData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                String dj = com.baidu.tbadk.core.util.r.dj(portrait);
                this.cSv.setUrl(dj);
                this.cSv.d(dj, 25, false);
            } else {
                this.cSv.setImageResource(n.e.pic_mycenter_avatar_def_i);
            }
            ArrayList<IconData> tShowInfo = userData.getTShowInfo();
            UserVipInfoData userVipInfo = userData.getUserVipInfo();
            if (tShowInfo != null && tShowInfo.size() > 0) {
                if (userVipInfo != null && userVipInfo.getVipIconUrl() != null) {
                    tShowInfo.get(0).setIcon(userVipInfo.getVipIconUrl());
                }
                this.cSw.setVisibility(0);
                this.cSw.a(tShowInfo, tShowInfo.size(), this.mActivity.getResources().getDimensionPixelSize(n.d.ds34), this.mActivity.getResources().getDimensionPixelSize(n.d.ds34), this.mActivity.getResources().getDimensionPixelSize(n.d.ds10), true);
            } else {
                this.cSw.setVisibility(8);
            }
            String name_show = userData.getName_show();
            int isMem = userData.getIsMem();
            if (!TextUtils.isEmpty(name_show)) {
                this.cvv.setText(name_show);
                if (isMem > 0) {
                    this.cvv.setTextColor(this.mActivity.getResources().getColor(n.c.cp_other_b));
                } else {
                    this.cvv.setTextColor(this.mActivity.getResources().getColor(n.c.cp_cont_g));
                }
            }
            String intro = userData.getIntro();
            if (!TextUtils.isEmpty(intro)) {
                this.cSx.setText(intro);
                com.baidu.tbadk.core.util.as.b(this.cSx, n.c.cp_cont_f, 1);
            } else {
                this.cSx.setText(n.i.no_person_sign);
                com.baidu.tbadk.core.util.as.b(this.cSx, n.c.cp_cont_d, 1);
            }
            int sex = userData.getSex();
            if (sex == 1) {
                this.cSy.setImageResource(n.e.icon_pop_boy);
            } else if (sex == 2) {
                this.cSy.setImageResource(n.e.icon_pop_girl);
            } else {
                this.cSy.setVisibility(8);
            }
            String tb_age = userData.getTb_age();
            if (!TextUtils.isEmpty(name_show)) {
                this.cSA.setText(String.valueOf(tb_age) + this.mActivity.getResources().getString(n.i.user_info_center_head_viewpager_tb_age));
            }
            this.cSB.a(userData.getIconInfo(), 9, this.mActivity.getResources().getDimensionPixelSize(n.d.ds34), this.mActivity.getResources().getDimensionPixelSize(n.d.ds34), this.mActivity.getResources().getDimensionPixelSize(n.d.ds10), true);
            if (userData.getHave_attention() == 1) {
                this.cSG.setText(n.i.attention_cancel);
                this.cSF.setVisibility(8);
                com.baidu.tbadk.core.util.as.i(this.cSE, n.e.btn_pop_news);
                com.baidu.tbadk.core.util.as.b(this.cSG, n.c.cp_link_tip_c, 1);
            } else {
                this.cSG.setText(n.i.attention);
                this.cSF.setVisibility(0);
                com.baidu.tbadk.core.util.as.i(this.cSE, n.e.personinfo_follow_btn);
                com.baidu.tbadk.core.util.as.i(this.cSF, n.e.icon_person_add_n);
                com.baidu.tbadk.core.util.as.b(this.cSG, n.c.cp_cont_i, 1);
            }
            j(userData);
        }
    }

    private void j(UserData userData) {
        if (userData.getIsOfficialAccount() == 1) {
            this.cSE.setVisibility(8);
            this.cSI.setVisibility(8);
            this.cSK.setVisibility(8);
        }
    }

    public LinearLayout aoY() {
        return this.cSK;
    }

    public LinearLayout aoZ() {
        return this.cSE;
    }

    public UserIconBox apa() {
        return this.cSw;
    }

    public View getRootView() {
        return this.mRootView;
    }

    private boolean apb() {
        return TbadkCoreApplication.m411getInst().appResponseToIntentClass(BuyTBeanActivityConfig.class);
    }
}
