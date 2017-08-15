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
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> aMm = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.view.j.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
            if (aVar != null) {
                aVar.e(j.this.gys);
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
    protected TextView apH;
    protected boolean blR;
    protected g fgE;
    protected com.baidu.tieba.personPolymeric.c.a gyA;
    protected BdExpandImageView gys;
    protected HeadPendantView gyt;
    protected TbImageView gyu;
    protected UserIconBox gyv;
    protected UserIconBox gyw;
    protected TextView gyx;
    protected TextView gyy;
    public e gyz;
    protected Context mContext;
    protected View mRootView;
    protected UserData mUserData;

    public abstract void F(float f);

    public abstract void P(View view);

    public abstract View UG();

    public abstract void ajJ();

    public abstract void lh();

    public abstract void onDestory();

    public j(Context context, boolean z) {
        this.mContext = context;
        this.blR = z;
        P(UG());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aeK() {
        if (this.gyz != null) {
            this.gyz.setOnViewResponseListener(this.fgE);
        }
    }

    public void setOnViewResponseListener(g gVar) {
        this.fgE = gVar;
        aeK();
    }

    public void e(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null) {
            this.gyA = aVar;
            this.mUserData = aVar.getUserData();
            d(this.mUserData);
            String portrait = this.mUserData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                String dL = n.dL(portrait);
                this.gyt.getHeadView().setUrl(dL);
                this.gyt.getHeadView().c(dL, 25, false);
            } else {
                this.gyt.getHeadView().c(String.valueOf(d.g.pic_mycenter_avatar_def_i), 24, false);
            }
            com.baidu.tbadk.data.j pendantData = this.mUserData.getPendantData();
            if (pendantData != null) {
                this.gyt.et(pendantData.pV());
            }
            if (this.gyt.wC()) {
                this.gyu.setVisibility(8);
            } else if (this.mUserData.isGod() || !StringUtils.isNull(this.mUserData.getUserTbVipInfoData().getvipV_url())) {
                this.gyu.setVisibility(0);
            } else {
                this.gyu.setVisibility(8);
            }
            if (!StringUtils.isNull(this.mUserData.getUserTbVipInfoData().getvipV_url())) {
                this.gyu.c(this.mUserData.getUserTbVipInfoData().getvipV_url(), 10, false);
            } else {
                ai.c(this.gyu, d.g.pic_shen_avatar_mine);
            }
            ArrayList<IconData> tShowInfo = this.mUserData.getTShowInfo();
            UserVipInfoData userVipInfo = this.mUserData.getUserVipInfo();
            if (!u.v(tShowInfo) && u.c(tShowInfo, 0) != null) {
                if (userVipInfo != null && userVipInfo.getVipIconUrl() != null) {
                    ((IconData) u.c(tShowInfo, 0)).setIcon(userVipInfo.getVipIconUrl());
                }
                this.gyv.a(tShowInfo, tShowInfo.size(), this.mContext.getResources().getDimensionPixelSize(d.f.ds34), this.mContext.getResources().getDimensionPixelSize(d.f.ds34), this.mContext.getResources().getDimensionPixelSize(d.f.ds10), true);
            }
            bxq();
            String name_show = this.mUserData.getName_show();
            if (!TextUtils.isEmpty(name_show)) {
                if (al.dY(name_show) > 14) {
                    name_show = al.d(name_show, 14, "...");
                }
                this.apH.setText(name_show);
            }
            int i = d.g.icon_pop_boy;
            if (this.mUserData != null) {
                i = this.mUserData.getSex() == 2 ? d.g.icon_pop_girl : d.g.icon_pop_boy;
            }
            this.apH.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mContext.getResources().getDrawable(i), (Drawable) null);
            this.gyw.a(this.mUserData.getIconInfo(), 9, this.mContext.getResources().getDimensionPixelSize(d.f.ds34), this.mContext.getResources().getDimensionPixelSize(d.f.ds34), this.mContext.getResources().getDimensionPixelSize(d.f.ds10), true);
            if (this.gyz != null) {
                this.gyz.setData(this.mUserData);
            }
        }
    }

    public void sM(String str) {
        this.gyt.et(str);
        if (this.gyt.wC()) {
            this.gyu.setVisibility(8);
        } else if (bxo()) {
            this.gyu.setVisibility(0);
        }
    }

    private boolean bxo() {
        if (this.mUserData == null) {
            return false;
        }
        return this.mUserData.isGod() || !(this.mUserData.getUserTbVipInfoData() == null || StringUtils.isNull(this.mUserData.getUserTbVipInfoData().getvipV_url()));
    }

    public void onChangeSkinType(int i) {
        if (this.mUserData != null && StringUtils.isNull(this.mUserData.getUserTbVipInfoData().getvipV_url())) {
            ai.c((ImageView) this.gyu, d.g.pic_shen_avatar_mine, i);
        }
        int i2 = d.g.icon_pop_boy;
        if (this.mUserData != null) {
            i2 = this.mUserData.getSex() == 1 ? d.g.icon_pop_boy : d.g.icon_pop_girl;
        }
        bxq();
        ai.c(this.gyy, d.e.cp_link_tip_a, 1);
        this.apH.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mContext.getResources().getDrawable(i2), (Drawable) null);
        if (this.gyz != null) {
            this.gyz.onChangeSkinType(i);
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
                this.gys.setImageBitmap(logoBitmap);
                return;
            }
            return;
        }
        com.baidu.adp.lib.f.c.fU().a(bg_pic, 10, this.aMm, 0, 0, null, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bxp() {
        this.gyt.wD();
        this.gyt.getHeadView().setIsRound(true);
        this.gyt.getHeadView().setDrawBorder(false);
        this.gyt.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    protected void bxq() {
        if (this.mUserData != null && this.mUserData.getIsMem() > 0) {
            ai.c(this.apH, d.e.cp_cont_h, 1);
        } else {
            ai.c(this.apH, d.e.cp_cont_i, 1);
        }
    }
}
