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
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> aKW = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.view.j.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
            if (aVar != null) {
                aVar.e(j.this.gvp);
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
    protected TextView aom;
    protected boolean bkz;
    protected g fdz;
    protected BdExpandImageView gvp;
    protected HeadPendantView gvq;
    protected TbImageView gvr;
    protected UserIconBox gvs;
    protected UserIconBox gvt;
    protected TextView gvu;
    protected TextView gvv;
    public e gvw;
    protected com.baidu.tieba.personPolymeric.c.a gvx;
    protected Context mContext;
    protected View mRootView;
    protected UserData mUserData;

    public abstract void F(float f);

    public abstract void O(View view);

    public abstract View Uf();

    public abstract void aiQ();

    public abstract void kX();

    public abstract void onDestory();

    public j(Context context, boolean z) {
        this.mContext = context;
        this.bkz = z;
        O(Uf());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aek() {
        if (this.gvw != null) {
            this.gvw.setOnViewResponseListener(this.fdz);
        }
    }

    public void setOnViewResponseListener(g gVar) {
        this.fdz = gVar;
        aek();
    }

    public void e(com.baidu.tieba.personPolymeric.c.a aVar) {
        if (aVar != null && aVar.getUserData() != null) {
            this.gvx = aVar;
            this.mUserData = aVar.getUserData();
            d(this.mUserData);
            String portrait = this.mUserData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                String dF = n.dF(portrait);
                this.gvq.getHeadView().setUrl(dF);
                this.gvq.getHeadView().c(dF, 25, false);
            } else {
                this.gvq.getHeadView().c(String.valueOf(d.g.pic_mycenter_avatar_def_i), 24, false);
            }
            com.baidu.tbadk.data.j pendantData = this.mUserData.getPendantData();
            if (pendantData != null) {
                this.gvq.en(pendantData.pL());
            }
            if (this.gvq.ws()) {
                this.gvr.setVisibility(8);
            } else if (this.mUserData.isGod() || !StringUtils.isNull(this.mUserData.getUserTbVipInfoData().getvipV_url())) {
                this.gvr.setVisibility(0);
            } else {
                this.gvr.setVisibility(8);
            }
            if (!StringUtils.isNull(this.mUserData.getUserTbVipInfoData().getvipV_url())) {
                this.gvr.c(this.mUserData.getUserTbVipInfoData().getvipV_url(), 10, false);
            } else {
                ai.c(this.gvr, d.g.pic_shen_avatar_mine);
            }
            ArrayList<IconData> tShowInfo = this.mUserData.getTShowInfo();
            UserVipInfoData userVipInfo = this.mUserData.getUserVipInfo();
            if (!u.v(tShowInfo) && u.c(tShowInfo, 0) != null) {
                if (userVipInfo != null && userVipInfo.getVipIconUrl() != null) {
                    ((IconData) u.c(tShowInfo, 0)).setIcon(userVipInfo.getVipIconUrl());
                }
                this.gvs.a(tShowInfo, tShowInfo.size(), this.mContext.getResources().getDimensionPixelSize(d.f.ds34), this.mContext.getResources().getDimensionPixelSize(d.f.ds34), this.mContext.getResources().getDimensionPixelSize(d.f.ds10), true);
            }
            bwB();
            String name_show = this.mUserData.getName_show();
            if (!TextUtils.isEmpty(name_show)) {
                if (al.dS(name_show) > 14) {
                    name_show = al.d(name_show, 14, "...");
                }
                this.aom.setText(name_show);
            }
            int i = d.g.icon_pop_boy;
            if (this.mUserData != null) {
                i = this.mUserData.getSex() == 2 ? d.g.icon_pop_girl : d.g.icon_pop_boy;
            }
            this.aom.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mContext.getResources().getDrawable(i), (Drawable) null);
            this.gvt.a(this.mUserData.getIconInfo(), 9, this.mContext.getResources().getDimensionPixelSize(d.f.ds34), this.mContext.getResources().getDimensionPixelSize(d.f.ds34), this.mContext.getResources().getDimensionPixelSize(d.f.ds10), true);
            if (this.gvw != null) {
                this.gvw.setData(this.mUserData);
            }
        }
    }

    public void sF(String str) {
        this.gvq.en(str);
        if (this.gvq.ws()) {
            this.gvr.setVisibility(8);
        } else if (bwz()) {
            this.gvr.setVisibility(0);
        }
    }

    private boolean bwz() {
        if (this.mUserData == null) {
            return false;
        }
        return this.mUserData.isGod() || !(this.mUserData.getUserTbVipInfoData() == null || StringUtils.isNull(this.mUserData.getUserTbVipInfoData().getvipV_url()));
    }

    public void onChangeSkinType(int i) {
        if (this.mUserData != null && StringUtils.isNull(this.mUserData.getUserTbVipInfoData().getvipV_url())) {
            ai.c((ImageView) this.gvr, d.g.pic_shen_avatar_mine, i);
        }
        int i2 = d.g.icon_pop_boy;
        if (this.mUserData != null) {
            i2 = this.mUserData.getSex() == 1 ? d.g.icon_pop_boy : d.g.icon_pop_girl;
        }
        bwB();
        ai.c(this.gvv, d.e.cp_link_tip_a, 1);
        this.aom.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mContext.getResources().getDrawable(i2), (Drawable) null);
        if (this.gvw != null) {
            this.gvw.onChangeSkinType(i);
        }
    }

    public void d(UserData userData) {
        String bg_pic = userData != null ? userData.getBg_pic() : null;
        if (StringUtils.isNull(bg_pic)) {
            com.baidu.tbadk.imageManager.c.Ep().eV(1152000);
            Bitmap logoBitmap = BitmapHelper.getLogoBitmap(this.mContext.getApplicationContext(), d.g.bg_pic_mine);
            if (logoBitmap == null) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = TbConfig.BitmapConfig;
                options.inSampleSize = 2;
                logoBitmap = BitmapHelper.getResBitmap(this.mContext.getApplicationContext(), d.g.bg_pic_mine, options);
            }
            if (logoBitmap != null) {
                this.gvp.setImageBitmap(logoBitmap);
                return;
            }
            return;
        }
        com.baidu.adp.lib.f.c.fJ().a(bg_pic, 10, this.aKW, 0, 0, null, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bwA() {
        this.gvq.wt();
        this.gvq.getHeadView().setIsRound(true);
        this.gvq.getHeadView().setDrawBorder(false);
        this.gvq.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    protected void bwB() {
        if (this.mUserData != null && this.mUserData.getIsMem() > 0) {
            ai.c(this.aom, d.e.cp_cont_h, 1);
        } else {
            ai.c(this.aom, d.e.cp_cont_i, 1);
        }
    }
}
