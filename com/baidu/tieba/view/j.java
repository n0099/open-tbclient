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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.data.UserVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public abstract class j {
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> aLT = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.view.j.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
            if (aVar != null) {
                aVar.a(j.this.gwS);
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
    protected TextView apl;
    protected boolean bmo;
    protected g feW;
    protected BdExpandImageView gwS;
    protected HeadPendantView gwT;
    protected TbImageView gwU;
    protected UserIconBox gwV;
    protected UserIconBox gwW;
    protected TextView gwX;
    protected TextView gwY;
    public e gwZ;
    protected com.baidu.tieba.personPolymeric.c.a gxa;
    protected Context mContext;
    protected View mRootView;
    protected UserData mUserData;

    public abstract View Vq();

    public abstract void X(View view);

    public abstract void aln();

    public abstract void kY();

    public abstract void onDestory();

    public abstract void u(float f);

    public j(Context context, boolean z) {
        this.mContext = context;
        this.bmo = z;
        X(Vq());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void agc() {
        if (this.gwZ != null) {
            this.gwZ.setOnViewResponseListener(this.feW);
        }
    }

    public void setOnViewResponseListener(g gVar) {
        this.feW = gVar;
        agc();
    }

    public void e(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null) {
            this.gxa = aVar;
            this.mUserData = aVar.getUserData();
            d(this.mUserData);
            String portrait = this.mUserData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                String dG = o.dG(portrait);
                this.gwT.getHeadView().setUrl(dG);
                this.gwT.getHeadView().c(dG, 25, false);
            } else {
                this.gwT.getHeadView().c(String.valueOf(d.g.pic_mycenter_avatar_def_i), 24, false);
            }
            com.baidu.tbadk.data.j pendantData = this.mUserData.getPendantData();
            if (pendantData != null) {
                this.gwT.eq(pendantData.pR());
            }
            if (this.gwT.wA()) {
                this.gwU.setVisibility(8);
            } else if (this.mUserData.isGod() || !StringUtils.isNull(this.mUserData.getUserTbVipInfoData().getvipV_url())) {
                this.gwU.setVisibility(0);
            } else {
                this.gwU.setVisibility(8);
            }
            if (!StringUtils.isNull(this.mUserData.getUserTbVipInfoData().getvipV_url())) {
                this.gwU.c(this.mUserData.getUserTbVipInfoData().getvipV_url(), 10, false);
            } else {
                aj.c(this.gwU, d.g.pic_shen_avatar_mine);
            }
            ArrayList<IconData> tShowInfo = this.mUserData.getTShowInfo();
            UserVipInfoData userVipInfo = this.mUserData.getUserVipInfo();
            if (!v.v(tShowInfo) && v.c(tShowInfo, 0) != null) {
                if (userVipInfo != null && userVipInfo.getVipIconUrl() != null) {
                    ((IconData) v.c(tShowInfo, 0)).setIcon(userVipInfo.getVipIconUrl());
                }
                this.gwV.a(tShowInfo, tShowInfo.size(), this.mContext.getResources().getDimensionPixelSize(d.f.ds34), this.mContext.getResources().getDimensionPixelSize(d.f.ds34), this.mContext.getResources().getDimensionPixelSize(d.f.ds10), true);
            }
            bwz();
            String name_show = this.mUserData.getName_show();
            if (!TextUtils.isEmpty(name_show)) {
                if (am.dU(name_show) > 14) {
                    name_show = am.e(name_show, 14, "...");
                }
                this.apl.setText(name_show);
            }
            int i = d.g.icon_pop_boy;
            if (this.mUserData != null) {
                i = this.mUserData.getSex() == 2 ? d.g.icon_pop_girl : d.g.icon_pop_boy;
            }
            this.apl.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mContext.getResources().getDrawable(i), (Drawable) null);
            this.gwW.a(this.mUserData.getIconInfo(), 9, this.mContext.getResources().getDimensionPixelSize(d.f.ds34), this.mContext.getResources().getDimensionPixelSize(d.f.ds34), this.mContext.getResources().getDimensionPixelSize(d.f.ds10), true);
            if (this.gwZ != null) {
                this.gwZ.setData(this.mUserData);
            }
        }
    }

    public void sM(String str) {
        this.gwT.eq(str);
        if (this.gwT.wA()) {
            this.gwU.setVisibility(8);
        } else if (bwx()) {
            this.gwU.setVisibility(0);
        }
    }

    private boolean bwx() {
        if (this.mUserData == null) {
            return false;
        }
        return this.mUserData.isGod() || !(this.mUserData.getUserTbVipInfoData() == null || StringUtils.isNull(this.mUserData.getUserTbVipInfoData().getvipV_url()));
    }

    public void onChangeSkinType(int i) {
        if (this.mUserData != null && StringUtils.isNull(this.mUserData.getUserTbVipInfoData().getvipV_url())) {
            aj.b((ImageView) this.gwU, d.g.pic_shen_avatar_mine, i);
        }
        int i2 = d.g.icon_pop_boy;
        if (this.mUserData != null) {
            i2 = this.mUserData.getSex() == 1 ? d.g.icon_pop_boy : d.g.icon_pop_girl;
        }
        bwz();
        aj.c(this.gwY, d.e.cp_link_tip_a, 1);
        this.apl.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mContext.getResources().getDrawable(i2), (Drawable) null);
        if (this.gwZ != null) {
            this.gwZ.onChangeSkinType(i);
        }
    }

    public void d(UserData userData) {
        String bg_pic = userData != null ? userData.getBg_pic() : null;
        if (StringUtils.isNull(bg_pic)) {
            com.baidu.tbadk.imageManager.c.Ev().eX(1152000);
            Bitmap logoBitmap = BitmapHelper.getLogoBitmap(this.mContext.getApplicationContext(), d.g.bg_pic_mine);
            if (logoBitmap == null) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = TbConfig.BitmapConfig;
                options.inSampleSize = 2;
                logoBitmap = BitmapHelper.getResBitmap(this.mContext.getApplicationContext(), d.g.bg_pic_mine, options);
            }
            if (logoBitmap != null) {
                this.gwS.setImageBitmap(logoBitmap);
                return;
            }
            return;
        }
        com.baidu.adp.lib.f.c.fK().a(bg_pic, 10, this.aLT, 0, 0, null, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bwy() {
        this.gwT.wB();
        this.gwT.getHeadView().setIsRound(true);
        this.gwT.getHeadView().setDrawBorder(false);
        this.gwT.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    protected void bwz() {
        if (this.mUserData != null && this.mUserData.getIsMem() > 0) {
            aj.c(this.apl, d.e.cp_cont_h, 1);
        } else {
            aj.c(this.apl, d.e.cp_cont_i, 1);
        }
    }
}
