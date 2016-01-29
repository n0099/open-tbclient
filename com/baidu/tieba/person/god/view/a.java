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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.aw;
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
    private ViewEventCenter aWA;
    private TextView ahH;
    private View bDS;
    private boolean bDs;
    private f cZH;
    private bf dcQ;
    private BdExpandImageView dcZ;
    private ImageView dda;
    private View ddc;
    private HeadImageView ddd;
    private ImageView dde;
    private UserIconBox ddf;
    private View ddg;
    private View ddh;
    private View ddi;
    private LinearLayout ddj;
    private ImageView ddk;
    private TextView ddl;
    private ImageView ddm;
    private TextView ddn;
    private TextView ddo;
    private ImageView ddp;
    private View ddq;
    private TextView ddr;
    private LinearLayout dds;
    private Activity mActivity;
    private View mRootView;
    private float ddb = 360.0f;
    final View.OnClickListener OS = new b(this);
    private final com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> aCG = new c(this);

    public a(f fVar, boolean z, ViewEventCenter viewEventCenter) {
        this.cZH = fVar;
        this.mActivity = fVar.getActivity();
        this.bDs = z;
        this.aWA = viewEventCenter;
        this.mRootView = LayoutInflater.from(this.mActivity).inflate(t.h.personinfo_god_head_view, (ViewGroup) null);
        initView();
    }

    private void initView() {
        this.bDS = this.mRootView.findViewById(t.g.root);
        this.dcZ = (BdExpandImageView) this.mRootView.findViewById(t.g.expand_image);
        this.dda = (ImageView) this.mRootView.findViewById(t.g.refresh_image);
        this.ddc = this.mRootView.findViewById(t.g.layout_head);
        this.ddd = (HeadImageView) this.mRootView.findViewById(t.g.user_head);
        this.dde = (ImageView) this.mRootView.findViewById(t.g.user_head_mask);
        this.ddf = (UserIconBox) this.mRootView.findViewById(t.g.user_vip_icon);
        this.ahH = (TextView) this.mRootView.findViewById(t.g.user_name);
        this.ddr = (TextView) this.mRootView.findViewById(t.g.my_tdou_value);
        this.dds = (LinearLayout) this.mRootView.findViewById(t.g.personinfo_tdou_wrapper);
        this.ddh = this.mRootView.findViewById(t.g.layout_blank);
        this.ddg = this.mRootView.findViewById(t.g.layout_user_fans);
        this.ddi = this.mRootView.findViewById(t.g.layout_add_follow);
        this.ddj = (LinearLayout) this.mRootView.findViewById(t.g.view_add_follow);
        this.ddk = (ImageView) this.mRootView.findViewById(t.g.iv_add_follow);
        this.ddl = (TextView) this.mRootView.findViewById(t.g.tv_add_follow);
        this.ddm = (ImageView) this.mRootView.findViewById(t.g.user_msg);
        this.ddn = (TextView) this.mRootView.findViewById(t.g.user_followers);
        this.ddo = (TextView) this.mRootView.findViewById(t.g.user_fans);
        this.ddp = (ImageView) this.mRootView.findViewById(t.g.red_tip);
        this.ddq = this.mRootView.findViewById(t.g.line_fans);
        this.ddo.setOnClickListener(this.OS);
        this.ddn.setOnClickListener(this.OS);
        this.ddm.setOnClickListener(this.OS);
        this.ddj.setOnClickListener(this.cZH);
        this.ddf.setOnClickListener(this.cZH);
        auM();
        auN();
    }

    @Override // com.baidu.tieba.personInfo.a
    public void setBackBitmap(UserData userData) {
        String bg_pic = userData != null ? userData.getBg_pic() : null;
        if (StringUtils.isNull(bg_pic)) {
            com.baidu.tbadk.imageManager.c.Ed().eN(1152000);
            Bitmap logoBitmap = BitmapHelper.getLogoBitmap(this.mActivity.getApplicationContext(), t.f.pic_mycenter_bg_def);
            if (logoBitmap == null) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = TbConfig.BitmapConfig;
                options.inSampleSize = 2;
                logoBitmap = BitmapHelper.getResBitmap(this.mActivity.getApplicationContext(), t.f.pic_mycenter_bg_def, options);
            }
            if (logoBitmap != null) {
                this.dcZ.setImageBitmap(logoBitmap);
                return;
            }
            return;
        }
        com.baidu.adp.lib.g.c.hl().a(bg_pic, 10, this.aCG, 0, 0, null, new Object[0]);
    }

    @Override // com.baidu.tieba.personInfo.a
    public void auL() {
        if (this.ddd != null) {
            this.ddd.Ea();
        }
        this.dcZ.setImageBitmap(null);
    }

    private void auM() {
        if (this.bDs) {
            this.ddm.setVisibility(8);
            this.dds.setVisibility(0);
            this.dcZ.setMinimumHeight(this.mActivity.getResources().getDimensionPixelOffset(t.e.ds640));
            return;
        }
        this.ddm.setVisibility(0);
        this.dds.setVisibility(8);
        this.dcZ.setMinimumHeight(this.mActivity.getResources().getDimensionPixelOffset(t.e.ds710));
    }

    @Override // com.baidu.tieba.personInfo.a
    public void oO() {
        ar.l(this.bDS, t.d.cp_bg_line_d);
        if (this.dcQ != null && this.dcQ.getUserData() != null) {
            if (this.dcQ.getUserData().getIsMem() > 0) {
                ar.b(this.ahH, t.d.cp_other_b, 1);
            } else {
                ar.b(this.ahH, t.d.cp_cont_b, 1);
            }
        }
        if (this.ddr != null) {
            ar.b(this.ddr, t.d.tdou_focus_color, 1);
            this.ddr.setCompoundDrawablesWithIntrinsicBounds(ar.getDrawable(t.f.icon_huobi_tdou_selector), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        if (this.dcQ != null) {
            g(this.dcQ.getUserData());
        }
        ar.c(this.ddm, t.f.personinfo_msg_selector);
        ar.c(this.dde, t.f.pic_shen_avatar_mine);
        ar.k(this.ddh, t.d.cp_bg_line_d);
        ar.k(this.ddq, t.d.cp_cont_j);
        ar.k(this.ddc, t.f.bg_mycenter_avatar);
        ar.k(this.dds, t.f.bg_mine_tdou);
        ar.l(this.ddi, t.d.cp_bg_line_d);
        ar.l(this.ddg, t.d.cp_bg_line_d);
        ar.b(this.ddn, t.d.cp_cont_j, 1);
        ar.b(this.ddo, t.d.cp_cont_j, 1);
        ar.c(this.ddp, t.f.icon_news_down_bar_one);
    }

    private void g(UserData userData) {
        if (this.ddj != null && this.ddl != null && this.ddk != null) {
            if (userData == null || this.bDs) {
                this.ddi.setVisibility(8);
                return;
            }
            this.ddi.setVisibility(0);
            if (userData.getHave_attention() == 1) {
                ar.b(this.ddl, t.d.cp_cont_d, 1);
                this.ddl.setText(t.j.attention_cancel);
                this.ddk.setImageDrawable(null);
                this.ddk.setVisibility(8);
                ar.k(this.ddj, t.f.btn_non_white_selector);
                return;
            }
            this.ddk.setVisibility(0);
            ar.b(this.ddl, t.d.btn_forum_focus_color, 1);
            this.ddl.setText(t.j.attention_n);
            ar.k(this.ddj, t.f.btn_focus_border_bg);
            ar.c(this.ddk, t.f.icon_add_mine_selector);
        }
    }

    private void auN() {
        this.ddd.setIsRound(true);
        this.ddd.setDrawBorder(false);
        this.ddd.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ddd.setOnClickListener(this.cZH);
    }

    @Override // com.baidu.tieba.personInfo.a
    public HeadImageView getHeadImage() {
        return this.ddd;
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
        if (!this.dda.isShown()) {
            this.dda.setVisibility(0);
            this.dda.setImageDrawable(this.mActivity.getResources().getDrawable(t.f.icon_pop_refresh));
        }
        RotateAnimation rotateAnimation = new RotateAnimation(this.ddb, f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setFillBefore(true);
        rotateAnimation.setFillAfter(true);
        this.dda.startAnimation(rotateAnimation);
        this.ddb = f;
    }

    @Override // com.baidu.tieba.personInfo.a
    public void Oz() {
        this.dda.clearAnimation();
        this.dda.setImageDrawable(null);
        this.dda.setVisibility(8);
    }

    @Override // com.baidu.tieba.personInfo.a
    public void nf() {
        if (!this.dda.isShown()) {
            this.dda.setVisibility(0);
            this.dda.setImageDrawable(this.mActivity.getResources().getDrawable(t.f.icon_pop_refresh));
        }
        this.dda.startAnimation((RotateAnimation) AnimationUtils.loadAnimation(this.mActivity, t.a.user_info_center_head_rotate));
    }

    @Override // com.baidu.tieba.personInfo.a
    public void akY() {
        this.dcQ = this.cZH.avb();
        if (this.dcQ != null) {
            UserData userData = this.dcQ.getUserData();
            setBackBitmap(userData);
            i(userData);
            h(userData);
            g(userData);
        }
    }

    public void h(UserData userData) {
        if (!auO() || userData == null) {
            this.dds.setVisibility(8);
            return;
        }
        if (this.bDs) {
            this.dds.setVisibility(0);
        } else {
            this.dds.setVisibility(8);
        }
        this.ddr.setText(aw.G(userData.getTDouNum()));
        this.dds.setOnClickListener(new d(this));
    }

    private void i(UserData userData) {
        if (userData != null) {
            String portrait = userData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                String dj = q.dj(portrait);
                this.ddd.setUrl(dj);
                this.ddd.d(dj, 25, false);
            } else {
                this.ddd.setImageResource(t.f.pic_mycenter_avatar_def_i);
            }
            ArrayList<IconData> tShowInfo = userData.getTShowInfo();
            UserVipInfoData userVipInfo = userData.getUserVipInfo();
            if (tShowInfo != null && tShowInfo.size() > 0) {
                if (userVipInfo != null && userVipInfo.getVipIconUrl() != null) {
                    tShowInfo.get(0).setIcon(userVipInfo.getVipIconUrl());
                }
                this.ddf.setVisibility(0);
                this.ddf.a(tShowInfo, tShowInfo.size(), this.mActivity.getResources().getDimensionPixelSize(t.e.ds34), this.mActivity.getResources().getDimensionPixelSize(t.e.ds34), this.mActivity.getResources().getDimensionPixelSize(t.e.ds10), true);
            } else {
                this.ddf.setVisibility(8);
            }
            String name_show = userData.getName_show();
            if (!TextUtils.isEmpty(name_show)) {
                if (name_show.length() > 14) {
                    name_show = String.valueOf(name_show.substring(0, 14)) + "...";
                }
                this.ahH.setText(name_show);
                if (userData.getIsMem() > 0) {
                    ar.b(this.ahH, t.d.cp_other_b, 1);
                } else {
                    ar.b(this.ahH, t.d.cp_cont_b, 1);
                }
            }
            int dimensionPixelOffset = this.mActivity.getResources().getDimensionPixelOffset(t.e.ds10);
            if (this.bDs) {
                this.ddg.setPadding(0, dimensionPixelOffset, 0, this.mActivity.getResources().getDimensionPixelOffset(t.e.ds36));
            } else {
                this.ddg.setPadding(0, dimensionPixelOffset, 0, this.mActivity.getResources().getDimensionPixelOffset(t.e.ds28));
            }
            this.ddn.setText(this.mActivity.getResources().getString(t.j.user_followers, aw.x(userData.getConcernNum())));
            this.ddo.setText(this.mActivity.getResources().getString(t.j.user_fans, aw.x(userData.getFansNum())));
        }
    }

    @Override // com.baidu.tieba.personInfo.a
    public LinearLayout getMyGiftIcon() {
        return null;
    }

    @Override // com.baidu.tieba.personInfo.a
    public View getAttentionView() {
        return this.ddj;
    }

    @Override // com.baidu.tieba.personInfo.a
    public UserIconBox getVipIcon() {
        return this.ddf;
    }

    @Override // com.baidu.tieba.personInfo.a
    public LinearLayout getYinjiWraper() {
        return null;
    }

    @Override // com.baidu.tieba.personInfo.a
    public View getRootView() {
        return this.mRootView;
    }

    private boolean auO() {
        return TbadkCoreApplication.m411getInst().appResponseToIntentClass(BuyTBeanActivityConfig.class);
    }

    @Override // com.baidu.tieba.person.a.a
    public void setRedTipShow(boolean z) {
        fX(z);
    }

    @Override // com.baidu.tieba.person.a.a
    public void e(boolean z, int i) {
        fX(z);
    }

    private void fX(boolean z) {
        if (this.ddp != null) {
            if (z) {
                this.ddp.setVisibility(0);
            } else {
                this.ddp.setVisibility(8);
            }
        }
    }
}
