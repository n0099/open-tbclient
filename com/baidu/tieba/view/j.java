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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.u;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.data.UserVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public abstract class j {
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> aMl = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.view.j.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
            if (aVar != null) {
                aVar.e(j.this.gwA);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onProgressUpdate(Object... objArr) {
            super.onProgressUpdate(objArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onCancelled(String str) {
            super.onCancelled(str);
        }
    };
    protected TextView apG;
    protected boolean blJ;
    protected g feL;
    protected BdExpandImageView gwA;
    protected HeadPendantView gwB;
    protected TbImageView gwC;
    protected UserIconBox gwD;
    protected UserIconBox gwE;
    protected TextView gwF;
    protected TextView gwG;
    public e gwH;
    protected com.baidu.tieba.personPolymeric.c.a gwI;
    protected Context mContext;
    protected View mRootView;
    protected UserData mUserData;

    public abstract void F(float f);

    public abstract void O(View view);

    public abstract View Uk();

    public abstract void ajc();

    public abstract void lh();

    public abstract void onDestory();

    public j(Context context, boolean z) {
        this.mContext = context;
        this.blJ = z;
        O(Uk());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aep() {
        if (this.gwH != null) {
            this.gwH.setOnViewResponseListener(this.feL);
        }
    }

    public void setOnViewResponseListener(g gVar) {
        this.feL = gVar;
        aep();
    }

    public void e(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null) {
            this.gwI = aVar;
            this.mUserData = aVar.getUserData();
            d(this.mUserData);
            String portrait = this.mUserData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                String dL = n.dL(portrait);
                this.gwB.getHeadView().setUrl(dL);
                this.gwB.getHeadView().c(dL, 25, false);
            } else {
                this.gwB.getHeadView().c(String.valueOf(d.g.pic_mycenter_avatar_def_i), 24, false);
            }
            com.baidu.tbadk.data.j pendantData = this.mUserData.getPendantData();
            if (pendantData != null) {
                this.gwB.et(pendantData.pV());
            }
            if (this.gwB.wC()) {
                this.gwC.setVisibility(8);
            } else if (this.mUserData.isGod() || !StringUtils.isNull(this.mUserData.getUserTbVipInfoData().getvipV_url())) {
                this.gwC.setVisibility(0);
            } else {
                this.gwC.setVisibility(8);
            }
            if (!StringUtils.isNull(this.mUserData.getUserTbVipInfoData().getvipV_url())) {
                this.gwC.c(this.mUserData.getUserTbVipInfoData().getvipV_url(), 10, false);
            } else {
                ai.c(this.gwC, d.g.pic_shen_avatar_mine);
            }
            ArrayList<IconData> tShowInfo = this.mUserData.getTShowInfo();
            UserVipInfoData userVipInfo = this.mUserData.getUserVipInfo();
            if (!u.v(tShowInfo) && u.c(tShowInfo, 0) != null) {
                if (userVipInfo != null && userVipInfo.getVipIconUrl() != null) {
                    ((IconData) u.c(tShowInfo, 0)).setIcon(userVipInfo.getVipIconUrl());
                }
                this.gwD.a(tShowInfo, tShowInfo.size(), this.mContext.getResources().getDimensionPixelSize(d.f.ds34), this.mContext.getResources().getDimensionPixelSize(d.f.ds34), this.mContext.getResources().getDimensionPixelSize(d.f.ds10), true);
            }
            bwI();
            String name_show = this.mUserData.getName_show();
            if (!TextUtils.isEmpty(name_show)) {
                if (al.dY(name_show) > 14) {
                    name_show = al.d(name_show, 14, "...");
                }
                this.apG.setText(name_show);
            }
            int i = d.g.icon_pop_boy;
            if (this.mUserData != null) {
                i = this.mUserData.getSex() == 2 ? d.g.icon_pop_girl : d.g.icon_pop_boy;
            }
            this.apG.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mContext.getResources().getDrawable(i), (Drawable) null);
            this.gwE.a(this.mUserData.getIconInfo(), 9, this.mContext.getResources().getDimensionPixelSize(d.f.ds34), this.mContext.getResources().getDimensionPixelSize(d.f.ds34), this.mContext.getResources().getDimensionPixelSize(d.f.ds10), true);
            if (this.gwH != null) {
                this.gwH.setData(this.mUserData);
            }
        }
    }

    public void sK(String str) {
        this.gwB.et(str);
        if (this.gwB.wC()) {
            this.gwC.setVisibility(8);
        } else if (bwG()) {
            this.gwC.setVisibility(0);
        }
    }

    private boolean bwG() {
        if (this.mUserData == null) {
            return false;
        }
        return this.mUserData.isGod() || !(this.mUserData.getUserTbVipInfoData() == null || StringUtils.isNull(this.mUserData.getUserTbVipInfoData().getvipV_url()));
    }

    public void onChangeSkinType(int i) {
        if (this.mUserData != null && StringUtils.isNull(this.mUserData.getUserTbVipInfoData().getvipV_url())) {
            ai.c((ImageView) this.gwC, d.g.pic_shen_avatar_mine, i);
        }
        int i2 = d.g.icon_pop_boy;
        if (this.mUserData != null) {
            i2 = this.mUserData.getSex() == 1 ? d.g.icon_pop_boy : d.g.icon_pop_girl;
        }
        bwI();
        ai.c(this.gwG, d.e.cp_link_tip_a, 1);
        this.apG.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mContext.getResources().getDrawable(i2), (Drawable) null);
        if (this.gwH != null) {
            this.gwH.onChangeSkinType(i);
        }
    }

    public void d(UserData userData) {
        String bg_pic = userData != null ? userData.getBg_pic() : null;
        if (StringUtils.isNull(bg_pic)) {
            com.baidu.tbadk.imageManager.c.Ex().eX(1152000);
            Bitmap logoBitmap = BitmapHelper.getLogoBitmap(this.mContext.getApplicationContext(), d.g.bg_pic_mine);
            if (logoBitmap == null) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = TbConfig.BitmapConfig;
                options.inSampleSize = 2;
                logoBitmap = BitmapHelper.getResBitmap(this.mContext.getApplicationContext(), d.g.bg_pic_mine, options);
            }
            if (logoBitmap != null) {
                this.gwA.setImageBitmap(logoBitmap);
                return;
            }
            return;
        }
        com.baidu.adp.lib.f.c.fU().a(bg_pic, 10, this.aMl, 0, 0, null, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bwH() {
        this.gwB.wD();
        this.gwB.getHeadView().setIsRound(true);
        this.gwB.getHeadView().setDrawBorder(false);
        this.gwB.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    protected void bwI() {
        if (this.mUserData != null && this.mUserData.getIsMem() > 0) {
            ai.c(this.apG, d.e.cp_cont_h, 1);
        } else {
            ai.c(this.apG, d.e.cp_cont_i, 1);
        }
    }
}
