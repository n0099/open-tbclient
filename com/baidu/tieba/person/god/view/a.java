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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.q;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.data.UserVipInfoData;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.personInfo.bp;
import com.baidu.tieba.personInfo.f;
import com.baidu.tieba.u;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.personInfo.a implements com.baidu.tieba.person.a.a {
    private TextView aee;
    private View bUM;
    private ViewEventCenter bfx;
    private ImageView bnb;
    private boolean cgJ;
    private f efz;
    private TextView ejA;
    private ImageView ejB;
    private View ejC;
    private TextView ejD;
    private LinearLayout ejE;
    private bp eje;
    private BdExpandImageView ejn;
    private ImageView ejo;
    private View ejp;
    private HeadImageView ejq;
    private UserIconBox ejr;
    private View ejs;
    private View ejt;
    private View eju;
    private LinearLayout ejv;
    private ImageView ejw;
    private TextView ejx;
    private ImageView ejy;
    private TextView ejz;
    private Activity mActivity;
    private View mRootView;
    private float bRH = 360.0f;
    final View.OnClickListener aew = new b(this);
    private final com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> aAA = new c(this);

    public a(f fVar, boolean z, ViewEventCenter viewEventCenter) {
        this.efz = fVar;
        this.mActivity = fVar.getActivity();
        this.cgJ = z;
        this.bfx = viewEventCenter;
        this.mRootView = LayoutInflater.from(this.mActivity).inflate(u.h.personinfo_god_head_view, (ViewGroup) null);
        initView();
    }

    private void initView() {
        this.bUM = this.mRootView.findViewById(u.g.root);
        this.ejn = (BdExpandImageView) this.mRootView.findViewById(u.g.expand_image);
        this.ejo = (ImageView) this.mRootView.findViewById(u.g.refresh_image);
        this.ejp = this.mRootView.findViewById(u.g.layout_head);
        this.ejq = (HeadImageView) this.mRootView.findViewById(u.g.user_head);
        this.ejq.setContentDescription(this.efz.getResources().getString(u.j.my_portrait));
        this.bnb = (ImageView) this.mRootView.findViewById(u.g.user_head_mask);
        this.ejr = (UserIconBox) this.mRootView.findViewById(u.g.user_vip_icon);
        this.aee = (TextView) this.mRootView.findViewById(u.g.user_name);
        this.ejD = (TextView) this.mRootView.findViewById(u.g.my_tdou_value);
        this.ejE = (LinearLayout) this.mRootView.findViewById(u.g.personinfo_tdou_wrapper);
        this.ejt = this.mRootView.findViewById(u.g.layout_blank);
        this.ejs = this.mRootView.findViewById(u.g.layout_user_fans);
        this.eju = this.mRootView.findViewById(u.g.layout_add_follow);
        this.ejv = (LinearLayout) this.mRootView.findViewById(u.g.view_add_follow);
        this.ejw = (ImageView) this.mRootView.findViewById(u.g.iv_add_follow);
        this.ejx = (TextView) this.mRootView.findViewById(u.g.tv_add_follow);
        this.ejy = (ImageView) this.mRootView.findViewById(u.g.user_msg);
        this.ejz = (TextView) this.mRootView.findViewById(u.g.user_followers);
        this.ejA = (TextView) this.mRootView.findViewById(u.g.user_fans);
        this.ejB = (ImageView) this.mRootView.findViewById(u.g.red_tip);
        this.ejC = this.mRootView.findViewById(u.g.line_fans);
        this.ejA.setOnClickListener(this.aew);
        this.ejz.setOnClickListener(this.aew);
        this.ejy.setOnClickListener(this.aew);
        this.ejt.setOnClickListener(this.aew);
        this.eju.setOnClickListener(this.aew);
        this.ejv.setOnClickListener(this.efz);
        this.ejn.setOnClickListener(this.efz);
        this.ejr.setOnClickListener(this.efz);
        aLH();
        aLI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aLF() {
        return TbadkCoreApplication.m9getInst().appResponseToIntentClass(PersonListActivityConfig.class);
    }

    @Override // com.baidu.tieba.personInfo.a
    public void setBackBitmap(UserData userData) {
        String bg_pic = userData != null ? userData.getBg_pic() : null;
        if (StringUtils.isNull(bg_pic)) {
            com.baidu.tbadk.imageManager.c.CQ().eD(1152000);
            Bitmap logoBitmap = BitmapHelper.getLogoBitmap(this.mActivity.getApplicationContext(), u.f.pic_mycenter_bg_def);
            if (logoBitmap == null) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = TbConfig.BitmapConfig;
                options.inSampleSize = 2;
                logoBitmap = BitmapHelper.getResBitmap(this.mActivity.getApplicationContext(), u.f.pic_mycenter_bg_def, options);
            }
            if (logoBitmap != null) {
                this.ejn.setImageBitmap(logoBitmap);
                return;
            }
            return;
        }
        com.baidu.adp.lib.g.c.dG().a(bg_pic, 10, this.aAA, 0, 0, null, new Object[0]);
    }

    @Override // com.baidu.tieba.personInfo.a
    public void aLG() {
        if (this.ejq != null) {
            this.ejq.CN();
        }
        this.ejn.setImageBitmap(null);
    }

    private void aLH() {
        if (this.cgJ) {
            this.ejy.setVisibility(8);
            this.ejE.setVisibility(0);
            this.ejn.setMinimumHeight(this.mActivity.getResources().getDimensionPixelOffset(u.e.ds640));
            return;
        }
        this.ejy.setVisibility(0);
        this.ejE.setVisibility(8);
        this.ejn.setMinimumHeight(this.mActivity.getResources().getDimensionPixelOffset(u.e.ds710));
    }

    @Override // com.baidu.tieba.personInfo.a
    public void kX() {
        av.l(this.bUM, u.d.cp_bg_line_d);
        if (this.eje != null && this.eje.getUserData() != null) {
            if (this.eje.getUserData().getIsMem() > 0) {
                av.c(this.aee, u.d.cp_other_b, 1);
            } else {
                av.c(this.aee, u.d.cp_cont_b, 1);
            }
        }
        if (this.ejD != null) {
            av.c(this.ejD, u.d.tdou_focus_color, 1);
            this.ejD.setCompoundDrawablesWithIntrinsicBounds(av.getDrawable(u.f.icon_huobi_tdou_selector), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        if (this.eje != null) {
            g(this.eje.getUserData());
        }
        av.c(this.ejy, u.f.personinfo_msg_selector);
        av.c(this.bnb, u.f.pic_shen_avatar_mine);
        av.k(this.ejt, u.d.cp_bg_line_d);
        av.k(this.ejC, u.d.cp_cont_j);
        av.k(this.ejp, u.f.bg_mycenter_avatar);
        av.k(this.ejE, u.f.bg_mine_tdou);
        av.l(this.eju, u.d.cp_bg_line_d);
        av.l(this.ejs, u.d.cp_bg_line_d);
        av.c(this.ejz, u.d.cp_cont_j, 1);
        av.c(this.ejA, u.d.cp_cont_j, 1);
        av.c(this.ejB, u.f.icon_news_down_bar_one);
    }

    private void g(UserData userData) {
        if (this.ejv != null && this.ejx != null && this.ejw != null) {
            if (userData == null || this.cgJ) {
                this.eju.setVisibility(8);
                return;
            }
            this.eju.setVisibility(0);
            if (userData.getHave_attention() == 1) {
                av.c(this.ejx, u.d.cp_cont_d, 1);
                this.ejx.setText(u.j.attention_cancel);
                this.ejw.setImageDrawable(null);
                this.ejw.setVisibility(8);
                av.k(this.ejv, u.f.btn_non_white_selector);
                return;
            }
            this.ejw.setVisibility(0);
            av.c(this.ejx, u.d.btn_forum_focus_color, 1);
            this.ejx.setText(u.j.attention_n);
            av.k(this.ejv, u.f.btn_focus_border_bg);
            av.c(this.ejw, u.f.icon_add_mine_selector);
        }
    }

    private void aLI() {
        this.ejq.setIsRound(true);
        this.ejq.setDrawBorder(false);
        this.ejq.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ejq.setOnClickListener(this.efz);
    }

    @Override // com.baidu.tieba.personInfo.a
    public HeadImageView getHeadImage() {
        return this.ejq;
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
        if (!this.ejo.isShown()) {
            this.ejo.setVisibility(0);
            this.ejo.setImageDrawable(this.mActivity.getResources().getDrawable(u.f.icon_pop_refresh));
        }
        RotateAnimation rotateAnimation = new RotateAnimation(this.bRH, f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setFillBefore(true);
        rotateAnimation.setFillAfter(true);
        this.ejo.startAnimation(rotateAnimation);
        this.bRH = f;
    }

    @Override // com.baidu.tieba.personInfo.a
    public void US() {
        this.ejo.clearAnimation();
        this.ejo.setImageDrawable(null);
        this.ejo.setVisibility(8);
    }

    @Override // com.baidu.tieba.personInfo.a
    public void jn() {
        if (!this.ejo.isShown()) {
            this.ejo.setVisibility(0);
            this.ejo.setImageDrawable(this.mActivity.getResources().getDrawable(u.f.icon_pop_refresh));
        }
        this.ejo.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.mActivity, u.a.user_info_center_head_rotate));
    }

    @Override // com.baidu.tieba.personInfo.a
    public void Ri() {
        this.eje = this.efz.aLZ();
        if (this.eje != null) {
            UserData userData = this.eje.getUserData();
            setBackBitmap(userData);
            i(userData);
            h(userData);
            g(userData);
        }
    }

    public void h(UserData userData) {
        if (!aLJ() || userData == null) {
            this.ejE.setVisibility(8);
            return;
        }
        if (this.cgJ) {
            this.ejE.setVisibility(0);
        } else {
            this.ejE.setVisibility(8);
        }
        this.ejD.setText(ba.M(userData.getTDouNum()));
        this.ejE.setOnClickListener(new d(this));
    }

    private void i(UserData userData) {
        if (userData != null) {
            String portrait = userData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                String di = q.di(portrait);
                this.ejq.setUrl(di);
                this.ejq.c(di, 25, false);
            } else {
                this.ejq.setImageResource(u.f.pic_mycenter_avatar_def_i);
            }
            ArrayList<IconData> tShowInfo = userData.getTShowInfo();
            UserVipInfoData userVipInfo = userData.getUserVipInfo();
            if (tShowInfo != null && tShowInfo.size() > 0) {
                if (userVipInfo != null && userVipInfo.getVipIconUrl() != null) {
                    tShowInfo.get(0).setIcon(userVipInfo.getVipIconUrl());
                }
                this.ejr.setVisibility(0);
                this.ejr.a(tShowInfo, tShowInfo.size(), this.mActivity.getResources().getDimensionPixelSize(u.e.ds34), this.mActivity.getResources().getDimensionPixelSize(u.e.ds34), this.mActivity.getResources().getDimensionPixelSize(u.e.ds10), true);
            } else {
                this.ejr.setVisibility(8);
            }
            String name_show = userData.getName_show();
            if (!TextUtils.isEmpty(name_show)) {
                if (name_show.length() > 14) {
                    name_show = String.valueOf(name_show.substring(0, 14)) + "...";
                }
                this.aee.setText(name_show);
                if (userData.getIsMem() > 0) {
                    av.c(this.aee, u.d.cp_other_b, 1);
                } else {
                    av.c(this.aee, u.d.cp_cont_b, 1);
                }
            }
            int dimensionPixelOffset = this.mActivity.getResources().getDimensionPixelOffset(u.e.ds10);
            if (this.cgJ) {
                this.ejs.setPadding(0, dimensionPixelOffset, 0, this.mActivity.getResources().getDimensionPixelOffset(u.e.ds36));
            } else {
                this.ejs.setPadding(0, dimensionPixelOffset, 0, this.mActivity.getResources().getDimensionPixelOffset(u.e.ds28));
            }
            this.ejz.setText(this.mActivity.getResources().getString(u.j.user_followers, ba.B(userData.getConcernNum())));
            this.ejA.setText(this.mActivity.getResources().getString(u.j.user_fans, ba.B(userData.getFansNum())));
        }
    }

    @Override // com.baidu.tieba.personInfo.a
    public LinearLayout getMyGiftIcon() {
        return null;
    }

    @Override // com.baidu.tieba.personInfo.a
    public View getAttentionView() {
        return this.ejv;
    }

    @Override // com.baidu.tieba.personInfo.a
    public UserIconBox getVipIcon() {
        return this.ejr;
    }

    @Override // com.baidu.tieba.personInfo.a
    public LinearLayout getYinjiWraper() {
        return null;
    }

    @Override // com.baidu.tieba.personInfo.a
    public View getRootView() {
        return this.mRootView;
    }

    private boolean aLJ() {
        return TbadkCoreApplication.m9getInst().appResponseToIntentClass(BuyTBeanActivityConfig.class);
    }

    @Override // com.baidu.tieba.person.a.a
    public void setRedTipShow(boolean z) {
        il(z);
    }

    @Override // com.baidu.tieba.person.a.a
    public void l(boolean z, int i) {
        il(z);
    }

    private void il(boolean z) {
        if (this.ejB != null) {
            if (z) {
                this.ejB.setVisibility(0);
            } else {
                this.ejB.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.personInfo.a
    public BdExpandImageView getExpandImg() {
        return this.ejn;
    }
}
