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
public class ay {
    private View bAG;
    private TextView bMg;
    private d cQj;
    private BdExpandImageView cWZ;
    private ImageView cXa;
    private RelativeLayout cXc;
    private HeadImageView cXd;
    private UserIconBox cXe;
    private TextView cXf;
    private ImageView cXg;
    private TextView cXh;
    private TextView cXi;
    private UserIconBox cXj;
    private LinearLayout cXk;
    private LinearLayout cXl;
    private LinearLayout cXm;
    private ImageView cXn;
    private TextView cXo;
    private ImageView cXp;
    private LinearLayout cXq;
    private ImageView cXr;
    private LinearLayout cXs;
    private ImageView cXt;
    private TextView cXu;
    private LinearLayout cXv;
    private TextView cXw;
    private TextView cXx;
    private ImageView cXy;
    private TextView cfS;
    private TextView czv;
    private BaseFragmentActivity mActivity;
    private Bitmap mBitmap;
    private boolean mIsHost;
    private View mRootView;
    private float cXb = 360.0f;
    private int cXz = 12;
    private final com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> aBQ = new az(this);

    public ay(d dVar, boolean z) {
        this.cQj = dVar;
        this.mActivity = dVar.getBaseFragmentActivity();
        this.mIsHost = z;
        this.mRootView = LayoutInflater.from(this.mActivity.getPageContext().getPageActivity()).inflate(n.h.personinfo_head_view, (ViewGroup) null);
        this.mRootView.setLayoutParams(new AbsListView.LayoutParams(-1, this.mActivity.getResources().getDimensionPixelSize(n.e.ds568)));
        initView();
    }

    private void initView() {
        this.bAG = this.mRootView.findViewById(n.g.root);
        this.cWZ = (BdExpandImageView) this.mRootView.findViewById(n.g.expand_image);
        this.cXa = (ImageView) this.mRootView.findViewById(n.g.refresh_image);
        this.cXc = (RelativeLayout) this.mRootView.findViewById(n.g.head);
        this.cXd = (HeadImageView) this.mRootView.findViewById(n.g.user_head);
        this.cXe = (UserIconBox) this.mRootView.findViewById(n.g.user_vip_icon);
        this.cXk = (LinearLayout) this.mRootView.findViewById(n.g.yinji_wrapper);
        this.cXl = (LinearLayout) this.mRootView.findViewById(n.g.sign_wrapper);
        this.cXe.setOnClickListener(this.cQj);
        this.czv = (TextView) this.mRootView.findViewById(n.g.user_name);
        this.cXf = (TextView) this.mRootView.findViewById(n.g.user_signs);
        this.cXg = (ImageView) this.mRootView.findViewById(n.g.user_sex);
        this.cXh = (TextView) this.mRootView.findViewById(n.g.user_bar_age);
        this.cXi = (TextView) this.mRootView.findViewById(n.g.user_bar_age_num);
        this.cXj = (UserIconBox) this.mRootView.findViewById(n.g.user_icon);
        this.cXj.setOnClickListener(this.cQj);
        this.cXo = (TextView) this.mRootView.findViewById(n.g.btn_attention);
        this.cXn = (ImageView) this.mRootView.findViewById(n.g.follow_icon);
        this.cXm = (LinearLayout) this.mRootView.findViewById(n.g.btn_attention_wrapper);
        this.cXm.setOnClickListener(this.cQj);
        this.cXs = (LinearLayout) this.mRootView.findViewById(n.g.my_gift_ll);
        this.cXs.setOnClickListener(this.cQj);
        this.cXt = (ImageView) this.mRootView.findViewById(n.g.my_gift);
        this.cXu = (TextView) this.mRootView.findViewById(n.g.my_tdou_value);
        this.cXv = (LinearLayout) this.mRootView.findViewById(n.g.personinfo_tdou_wrapper);
        this.cXw = (TextView) this.mRootView.findViewById(n.g.my_tdou_get);
        this.cXx = (TextView) this.mRootView.findViewById(n.g.tdou_divider);
        this.cXy = (ImageView) this.mRootView.findViewById(n.g.my_tdou_arrow);
        aqh();
        aqi();
    }

    public void g(UserData userData) {
        String bg_pic = userData != null ? userData.getBg_pic() : null;
        if (StringUtils.isNull(bg_pic)) {
            com.baidu.tbadk.imageManager.c.CM().et(1152000);
            Bitmap f = com.baidu.tbadk.core.util.c.f(this.mActivity.getApplicationContext(), n.f.pic_mycenter_bg_def);
            if (f == null) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = TbConfig.BitmapConfig;
                options.inSampleSize = 2;
                f = com.baidu.tbadk.core.util.c.a(this.mActivity.getApplicationContext(), n.f.pic_mycenter_bg_def, options);
            }
            if (f != null) {
                this.cWZ.setImageBitmap(f);
                return;
            }
            return;
        }
        com.baidu.adp.lib.g.c.hd().a(bg_pic, 10, this.aBQ, 0, 0, null, new Object[0]);
    }

    public void aqg() {
        if (this.mBitmap != null) {
            this.mBitmap.recycle();
            com.baidu.tbadk.core.util.c.ch(n.f.bg_mycenter_banner);
            System.gc();
        }
        if (this.cXd != null) {
            this.cXd.CJ();
        }
        this.cWZ.setImageBitmap(null);
    }

    private void aqh() {
        if (TbadkCoreApplication.m411getInst().isGiftSwitchOn()) {
            this.cXs.setVisibility(0);
        } else {
            this.cXs.setVisibility(8);
        }
        if (TbadkCoreApplication.m411getInst().getIntentClass(MyGiftListActivityConfig.class) == null) {
            this.cXs.setVisibility(8);
        }
        if (this.mIsHost) {
            this.cXs.setVisibility(8);
            this.cXm.setVisibility(8);
            return;
        }
        this.cXv.setVisibility(8);
    }

    public void ot() {
        com.baidu.tbadk.core.util.as.j(this.bAG, n.d.cp_bg_line_c);
        UserData userData = this.cQj.apO().getUserData();
        if (userData != null) {
            if (userData.getIsMem() > 0) {
                this.czv.setTextColor(this.mActivity.getResources().getColor(n.d.cp_other_b));
            } else {
                this.czv.setTextColor(this.mActivity.getResources().getColor(n.d.cp_cont_g));
            }
        } else {
            this.czv.setTextColor(this.mActivity.getResources().getColor(n.d.cp_cont_g));
        }
        if (userData != null) {
            if (!TextUtils.isEmpty(userData.getIntro())) {
                com.baidu.tbadk.core.util.as.b(this.cXf, n.d.cp_cont_f, 1);
            } else {
                com.baidu.tbadk.core.util.as.b(this.cXf, n.d.cp_cont_d, 1);
            }
        } else {
            com.baidu.tbadk.core.util.as.b(this.cXf, n.d.cp_cont_d, 1);
        }
        this.cXh.setTextColor(this.mActivity.getResources().getColor(n.d.cp_cont_g));
        this.cXi.setTextColor(this.mActivity.getResources().getColor(n.d.cp_cont_g));
        com.baidu.tbadk.core.util.as.i(this.cXs, n.f.personinfo_head_icon);
        com.baidu.tbadk.core.util.as.c(this.cXt, n.f.icon_mycenter_gift);
        if (userData != null) {
            if (userData.getHave_attention() == 1) {
                com.baidu.tbadk.core.util.as.i(this.cXm, n.f.btn_pop_news);
                com.baidu.tbadk.core.util.as.b(this.cXo, n.d.cp_link_tip_c, 1);
            } else {
                com.baidu.tbadk.core.util.as.i(this.cXm, n.f.personinfo_follow_btn);
                com.baidu.tbadk.core.util.as.i(this.cXn, n.f.icon_person_add_n);
                com.baidu.tbadk.core.util.as.b(this.cXo, n.d.cp_cont_i, 1);
            }
        } else {
            com.baidu.tbadk.core.util.as.i(this.cXm, n.f.personinfo_follow_btn);
            com.baidu.tbadk.core.util.as.i(this.cXn, n.f.icon_person_add_n);
            com.baidu.tbadk.core.util.as.b(this.cXo, n.d.cp_cont_i, 1);
        }
        com.baidu.tbadk.core.util.as.b(this.cfS, n.d.cp_cont_g, 1);
        com.baidu.tbadk.core.util.as.b(this.bMg, n.d.cp_cont_g, 1);
        com.baidu.tbadk.core.util.as.i(this.cXp, n.f.icon_mycenter_bar_site);
        com.baidu.tbadk.core.util.as.i(this.cXr, n.f.icon_mycenter_bar_date);
        com.baidu.tbadk.core.util.as.i(this.cXk, n.d.cp_bg_line_d);
        com.baidu.tbadk.core.util.as.i(this.cXl, n.d.cp_bg_line_d);
        this.cXu.setCompoundDrawablesWithIntrinsicBounds(this.mActivity.getResources().getDrawable(n.f.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    private void aqi() {
        this.cXd.setIsRound(true);
        this.cXd.setDrawBorder(false);
        this.cXd.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.cXd.setOnClickListener(this.cQj);
    }

    public HeadImageView aqj() {
        return this.cXd;
    }

    public UserIconBox aqk() {
        return this.cXj;
    }

    public void fL(boolean z) {
        if (this.cXt != null) {
            if (z) {
                com.baidu.tbadk.core.util.as.c(this.cXt, n.f.icon_mycenter_gift_open);
            } else {
                com.baidu.tbadk.core.util.as.c(this.cXt, n.f.icon_mycenter_gift);
            }
        }
    }

    public void j(float f) {
        if (!this.cXa.isShown()) {
            this.cXa.setVisibility(0);
            this.cXa.setImageDrawable(this.mActivity.getResources().getDrawable(n.f.icon_pop_refresh));
        }
        RotateAnimation rotateAnimation = new RotateAnimation(this.cXb, f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setFillBefore(true);
        rotateAnimation.setFillAfter(true);
        this.cXa.startAnimation(rotateAnimation);
        this.cXb = f;
    }

    public void hideProgress() {
        this.cXa.clearAnimation();
        this.cXa.setImageDrawable(null);
        this.cXa.setVisibility(8);
    }

    public void mQ() {
        if (!this.cXa.isShown()) {
            this.cXa.setVisibility(0);
            this.cXa.setImageDrawable(this.mActivity.getResources().getDrawable(n.f.icon_pop_refresh));
        }
        this.cXa.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.mActivity.getPageContext().getPageActivity(), n.a.user_info_center_head_rotate));
    }

    public void agW() {
        bb apO = this.cQj.apO();
        UserData userData = apO.getUserData();
        g(userData);
        i(userData);
        h(userData);
        apO.aqp();
    }

    public void h(UserData userData) {
        if (!aqo()) {
            this.cXv.setVisibility(8);
            return;
        }
        if (this.mIsHost) {
            this.cXv.setVisibility(0);
        } else {
            this.cXv.setVisibility(8);
        }
        if (userData != null) {
            this.cXu.setText(com.baidu.tbadk.core.util.ax.E(userData.getTDouNum()));
            this.cXv.setOnClickListener(new ba(this));
        }
    }

    private void i(UserData userData) {
        if (userData != null) {
            String portrait = userData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                String dm = com.baidu.tbadk.core.util.r.dm(portrait);
                this.cXd.setUrl(dm);
                this.cXd.d(dm, 25, false);
            } else {
                this.cXd.setImageResource(n.f.pic_mycenter_avatar_def_i);
            }
            ArrayList<IconData> tShowInfo = userData.getTShowInfo();
            UserVipInfoData userVipInfo = userData.getUserVipInfo();
            if (tShowInfo != null && tShowInfo.size() > 0) {
                if (userVipInfo != null && userVipInfo.getVipIconUrl() != null) {
                    tShowInfo.get(0).setIcon(userVipInfo.getVipIconUrl());
                }
                this.cXe.setVisibility(0);
                this.cXe.a(tShowInfo, tShowInfo.size(), this.mActivity.getResources().getDimensionPixelSize(n.e.ds34), this.mActivity.getResources().getDimensionPixelSize(n.e.ds34), this.mActivity.getResources().getDimensionPixelSize(n.e.ds10), true);
            } else {
                this.cXe.setVisibility(8);
            }
            String name_show = userData.getName_show();
            int isMem = userData.getIsMem();
            if (!TextUtils.isEmpty(name_show)) {
                this.czv.setText(name_show);
                if (isMem > 0) {
                    this.czv.setTextColor(this.mActivity.getResources().getColor(n.d.cp_other_b));
                } else {
                    this.czv.setTextColor(this.mActivity.getResources().getColor(n.d.cp_cont_g));
                }
            }
            String intro = userData.getIntro();
            if (!TextUtils.isEmpty(intro)) {
                this.cXf.setText(intro);
                com.baidu.tbadk.core.util.as.b(this.cXf, n.d.cp_cont_f, 1);
            } else {
                this.cXf.setText(n.j.no_person_sign);
                com.baidu.tbadk.core.util.as.b(this.cXf, n.d.cp_cont_d, 1);
            }
            int sex = userData.getSex();
            if (sex == 1) {
                this.cXg.setImageResource(n.f.icon_pop_boy);
            } else if (sex == 2) {
                this.cXg.setImageResource(n.f.icon_pop_girl);
            } else {
                this.cXg.setVisibility(8);
            }
            String tb_age = userData.getTb_age();
            if (!TextUtils.isEmpty(name_show)) {
                this.cXi.setText(String.valueOf(tb_age) + this.mActivity.getResources().getString(n.j.user_info_center_head_viewpager_tb_age));
            }
            this.cXj.a(userData.getIconInfo(), 9, this.mActivity.getResources().getDimensionPixelSize(n.e.ds34), this.mActivity.getResources().getDimensionPixelSize(n.e.ds34), this.mActivity.getResources().getDimensionPixelSize(n.e.ds10), true);
            if (userData.getHave_attention() == 1) {
                this.cXo.setText(n.j.attention_cancel);
                this.cXn.setVisibility(8);
                com.baidu.tbadk.core.util.as.i(this.cXm, n.f.btn_pop_news);
                com.baidu.tbadk.core.util.as.b(this.cXo, n.d.cp_link_tip_c, 1);
            } else {
                this.cXo.setText(n.j.attention);
                this.cXn.setVisibility(0);
                com.baidu.tbadk.core.util.as.i(this.cXm, n.f.personinfo_follow_btn);
                com.baidu.tbadk.core.util.as.i(this.cXn, n.f.icon_person_add_n);
                com.baidu.tbadk.core.util.as.b(this.cXo, n.d.cp_cont_i, 1);
            }
            j(userData);
        }
    }

    private void j(UserData userData) {
        if (userData.getIsOfficialAccount() == 1) {
            this.cXm.setVisibility(8);
            this.cXq.setVisibility(8);
            this.cXs.setVisibility(8);
        }
    }

    public LinearLayout aql() {
        return this.cXs;
    }

    public LinearLayout aqm() {
        return this.cXm;
    }

    public UserIconBox aqn() {
        return this.cXe;
    }

    public View getRootView() {
        return this.mRootView;
    }

    private boolean aqo() {
        return TbadkCoreApplication.m411getInst().appResponseToIntentClass(BuyTBeanActivityConfig.class);
    }
}
