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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.data.UserVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public abstract class x {
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> aJO = new y(this);
    protected TextView anw;
    protected boolean bhl;
    protected r eRa;
    protected BdExpandImageView gaU;
    protected HeadPendantView gaV;
    protected TbImageView gaW;
    protected UserIconBox gaX;
    protected UserIconBox gaY;
    protected TextView gaZ;
    protected TextView gba;
    public p gbb;
    protected com.baidu.tieba.personPolymeric.c.a gbc;
    protected Context mContext;
    protected View mRootView;
    protected UserData mUserData;

    public abstract void F(float f);

    public abstract void O(View view);

    public abstract View Tv();

    public abstract void ahs();

    public abstract void kZ();

    public abstract void onDestory();

    public x(Context context, boolean z) {
        this.mContext = context;
        this.bhl = z;
        O(Tv());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void adm() {
        if (this.gbb != null) {
            this.gbb.setOnViewResponseListener(this.eRa);
        }
    }

    public void setOnViewResponseListener(r rVar) {
        this.eRa = rVar;
        adm();
    }

    public void e(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null) {
            this.gbc = aVar;
            this.mUserData = aVar.getUserData();
            e(this.mUserData);
            String portrait = this.mUserData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                String dC = com.baidu.tbadk.core.util.s.dC(portrait);
                this.gaV.getHeadView().setUrl(dC);
                this.gaV.getHeadView().c(dC, 25, false);
            } else {
                this.gaV.getHeadView().c(String.valueOf(w.g.pic_mycenter_avatar_def_i), 24, false);
            }
            com.baidu.tbadk.data.j pendantData = this.mUserData.getPendantData();
            if (pendantData != null) {
                this.gaV.ek(pendantData.pI());
            }
            if (this.gaV.wl()) {
                this.gaW.setVisibility(8);
            } else if (this.mUserData.isGod() || !StringUtils.isNull(this.mUserData.getUserTbVipInfoData().getvipV_url())) {
                this.gaW.setVisibility(0);
            } else {
                this.gaW.setVisibility(8);
            }
            if (!StringUtils.isNull(this.mUserData.getUserTbVipInfoData().getvipV_url())) {
                this.gaW.c(this.mUserData.getUserTbVipInfoData().getvipV_url(), 10, false);
            } else {
                as.c(this.gaW, w.g.pic_shen_avatar_mine);
            }
            ArrayList<IconData> tShowInfo = this.mUserData.getTShowInfo();
            UserVipInfoData userVipInfo = this.mUserData.getUserVipInfo();
            if (!com.baidu.tbadk.core.util.z.t(tShowInfo) && com.baidu.tbadk.core.util.z.c(tShowInfo, 0) != null) {
                if (userVipInfo != null && userVipInfo.getVipIconUrl() != null) {
                    ((IconData) com.baidu.tbadk.core.util.z.c(tShowInfo, 0)).setIcon(userVipInfo.getVipIconUrl());
                }
                this.gaX.a(tShowInfo, tShowInfo.size(), this.mContext.getResources().getDimensionPixelSize(w.f.ds34), this.mContext.getResources().getDimensionPixelSize(w.f.ds34), this.mContext.getResources().getDimensionPixelSize(w.f.ds10), true);
            }
            bqF();
            String name_show = this.mUserData.getName_show();
            if (!TextUtils.isEmpty(name_show)) {
                if (aw.dP(name_show) > 14) {
                    name_show = aw.d(name_show, 14, "...");
                }
                this.anw.setText(name_show);
            }
            int i = w.g.icon_pop_boy;
            if (this.mUserData != null) {
                i = this.mUserData.getSex() == 2 ? w.g.icon_pop_girl : w.g.icon_pop_boy;
            }
            this.anw.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mContext.getResources().getDrawable(i), (Drawable) null);
            this.gaY.a(this.mUserData.getIconInfo(), 9, this.mContext.getResources().getDimensionPixelSize(w.f.ds34), this.mContext.getResources().getDimensionPixelSize(w.f.ds34), this.mContext.getResources().getDimensionPixelSize(w.f.ds10), true);
            if (this.gbb != null) {
                this.gbb.setData(this.mUserData);
            }
        }
    }

    public void rV(String str) {
        this.gaV.ek(str);
        if (this.gaV.wl()) {
            this.gaW.setVisibility(8);
        } else if (bqD()) {
            this.gaW.setVisibility(0);
        }
    }

    private boolean bqD() {
        if (this.mUserData == null) {
            return false;
        }
        return this.mUserData.isGod() || !(this.mUserData.getUserTbVipInfoData() == null || StringUtils.isNull(this.mUserData.getUserTbVipInfoData().getvipV_url()));
    }

    public void onChangeSkinType(int i) {
        if (this.mUserData != null && StringUtils.isNull(this.mUserData.getUserTbVipInfoData().getvipV_url())) {
            as.c((ImageView) this.gaW, w.g.pic_shen_avatar_mine, i);
        }
        int i2 = w.g.icon_pop_boy;
        if (this.mUserData != null) {
            i2 = this.mUserData.getSex() == 1 ? w.g.icon_pop_boy : w.g.icon_pop_girl;
        }
        bqF();
        as.c(this.gba, w.e.cp_link_tip_a, 1);
        this.anw.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mContext.getResources().getDrawable(i2), (Drawable) null);
        if (this.gbb != null) {
            this.gbb.onChangeSkinType(i);
        }
    }

    public void e(UserData userData) {
        String bg_pic = userData != null ? userData.getBg_pic() : null;
        if (StringUtils.isNull(bg_pic)) {
            com.baidu.tbadk.imageManager.c.Eb().eS(1152000);
            Bitmap logoBitmap = BitmapHelper.getLogoBitmap(this.mContext.getApplicationContext(), w.g.bg_pic_mine);
            if (logoBitmap == null) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = TbConfig.BitmapConfig;
                options.inSampleSize = 2;
                logoBitmap = BitmapHelper.getResBitmap(this.mContext.getApplicationContext(), w.g.bg_pic_mine, options);
            }
            if (logoBitmap != null) {
                this.gaU.setImageBitmap(logoBitmap);
                return;
            }
            return;
        }
        com.baidu.adp.lib.f.c.fL().a(bg_pic, 10, this.aJO, 0, 0, null, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bqE() {
        this.gaV.wm();
        this.gaV.getHeadView().setIsRound(true);
        this.gaV.getHeadView().setDrawBorder(false);
        this.gaV.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    protected void bqF() {
        if (this.mUserData != null && this.mUserData.getIsMem() > 0) {
            as.c(this.anw, w.e.cp_cont_h, 1);
        } else {
            as.c(this.anw, w.e.cp_cont_i, 1);
        }
    }
}
