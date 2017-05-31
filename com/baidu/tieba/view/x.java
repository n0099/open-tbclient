package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdExpandImageView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.data.UserVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public abstract class x {
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> aIz = new y(this);
    protected TextView amy;
    protected boolean beq;
    protected r bxW;
    protected BdExpandImageView fQT;
    protected HeadPendantView fQU;
    protected TbImageView fQV;
    protected UserIconBox fQW;
    protected UserIconBox fQX;
    protected TextView fQY;
    protected TextView fQZ;
    public p fRa;
    protected Context mContext;
    protected View mRootView;
    protected UserData mUserData;

    public abstract void F(float f);

    public abstract void N(View view);

    public abstract View RG();

    public abstract void Tx();

    public abstract void lb();

    public abstract void onDestory();

    public x(Context context, boolean z) {
        this.mContext = context;
        this.beq = z;
        N(RG());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void TA() {
        if (this.fRa != null) {
            this.fRa.setOnViewResponseListener(this.bxW);
        }
    }

    public void setOnViewResponseListener(r rVar) {
        this.bxW = rVar;
        TA();
    }

    public void b(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null) {
            this.mUserData = aVar.getUserData();
            e(this.mUserData);
            String portrait = this.mUserData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                String di = com.baidu.tbadk.core.util.q.di(portrait);
                this.fQU.getHeadView().setUrl(di);
                this.fQU.getHeadView().c(di, 25, false);
            } else {
                this.fQU.getHeadView().c(String.valueOf(w.g.pic_mycenter_avatar_def_i), 24, false);
            }
            com.baidu.tbadk.data.j pendantData = this.mUserData.getPendantData();
            if (pendantData != null) {
                this.fQU.dP(pendantData.pL());
            }
            if (this.fQU.vU()) {
                this.fQV.setVisibility(8);
            } else if (this.mUserData.isGod() || !StringUtils.isNull(this.mUserData.getUserTbVipInfoData().getvipV_url())) {
                this.fQV.setVisibility(0);
            } else {
                this.fQV.setVisibility(8);
            }
            if (!StringUtils.isNull(this.mUserData.getUserTbVipInfoData().getvipV_url())) {
                this.fQV.c(this.mUserData.getUserTbVipInfoData().getvipV_url(), 10, false);
            } else {
                aq.c(this.fQV, w.g.pic_shen_avatar_mine);
            }
            ArrayList<IconData> tShowInfo = this.mUserData.getTShowInfo();
            UserVipInfoData userVipInfo = this.mUserData.getUserVipInfo();
            if (!com.baidu.tbadk.core.util.x.r(tShowInfo) && com.baidu.tbadk.core.util.x.c(tShowInfo, 0) != null) {
                if (userVipInfo != null && userVipInfo.getVipIconUrl() != null) {
                    ((IconData) com.baidu.tbadk.core.util.x.c(tShowInfo, 0)).setIcon(userVipInfo.getVipIconUrl());
                }
                this.fQW.a(tShowInfo, tShowInfo.size(), this.mContext.getResources().getDimensionPixelSize(w.f.ds34), this.mContext.getResources().getDimensionPixelSize(w.f.ds34), this.mContext.getResources().getDimensionPixelSize(w.f.ds10), true);
            }
            bmv();
            String name_show = this.mUserData.getName_show();
            if (!TextUtils.isEmpty(name_show)) {
                if (au.dv(name_show) > 14) {
                    name_show = au.d(name_show, 14, "...");
                }
                this.amy.setText(name_show);
            }
            int i = w.g.icon_pop_boy;
            if (this.mUserData != null) {
                i = this.mUserData.getSex() == 2 ? w.g.icon_pop_girl : w.g.icon_pop_boy;
            }
            this.amy.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mContext.getResources().getDrawable(i), (Drawable) null);
            this.fQX.a(this.mUserData.getIconInfo(), 9, this.mContext.getResources().getDimensionPixelSize(w.f.ds34), this.mContext.getResources().getDimensionPixelSize(w.f.ds34), this.mContext.getResources().getDimensionPixelSize(w.f.ds10), true);
            if (this.fRa != null) {
                this.fRa.setData(this.mUserData);
            }
        }
    }

    public void hZ(String str) {
        this.fQU.dP(str);
        if (this.fQU.vU()) {
            this.fQV.setVisibility(8);
        } else if (bmt()) {
            this.fQV.setVisibility(0);
        }
    }

    private boolean bmt() {
        if (this.mUserData == null) {
            return false;
        }
        return this.mUserData.isGod() || !(this.mUserData.getUserTbVipInfoData() == null || StringUtils.isNull(this.mUserData.getUserTbVipInfoData().getvipV_url()));
    }

    public void onChangeSkinType(int i) {
        if (this.mUserData != null && StringUtils.isNull(this.mUserData.getUserTbVipInfoData().getvipV_url())) {
            aq.c((ImageView) this.fQV, w.g.pic_shen_avatar_mine, i);
        }
        int i2 = w.g.icon_pop_boy;
        if (this.mUserData != null) {
            i2 = this.mUserData.getSex() == 1 ? w.g.icon_pop_boy : w.g.icon_pop_girl;
        }
        bmv();
        aq.c(this.fQZ, w.e.cp_link_tip_a, 1);
        this.amy.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mContext.getResources().getDrawable(i2), (Drawable) null);
        if (this.fRa != null) {
            this.fRa.onChangeSkinType(i);
        }
    }

    public void e(UserData userData) {
        String bg_pic = userData != null ? userData.getBg_pic() : null;
        if (StringUtils.isNull(bg_pic)) {
            com.baidu.tbadk.imageManager.c.DH().eQ(1152000);
            Bitmap logoBitmap = BitmapHelper.getLogoBitmap(this.mContext.getApplicationContext(), w.g.bg_pic_mine);
            if (logoBitmap == null) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = TbConfig.BitmapConfig;
                options.inSampleSize = 2;
                logoBitmap = BitmapHelper.getResBitmap(this.mContext.getApplicationContext(), w.g.bg_pic_mine, options);
            }
            if (logoBitmap != null) {
                this.fQT.setImageBitmap(logoBitmap);
                return;
            }
            return;
        }
        com.baidu.adp.lib.f.c.fM().a(bg_pic, 10, this.aIz, 0, 0, null, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bmu() {
        this.fQU.vV();
        this.fQU.getHeadView().setIsRound(true);
        this.fQU.getHeadView().setDrawBorder(false);
        this.fQU.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    protected void bmv() {
        if (this.mUserData != null && this.mUserData.getIsMem() > 0) {
            aq.c(this.amy, w.e.cp_cont_h, 1);
        } else {
            aq.c(this.amy, w.e.cp_cont_i, 1);
        }
    }
}
