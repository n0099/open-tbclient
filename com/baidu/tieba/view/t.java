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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.data.UserVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public abstract class t {
    private final com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> aDV = new u(this);
    protected TextView ahv;
    protected m eFl;
    protected BdExpandImageView fYN;
    protected HeadPendantView fYO;
    protected TbImageView fYP;
    protected UserIconBox fYQ;
    protected UserIconBox fYR;
    protected TextView fYS;
    public PersonHeaderAttentionView fYT;
    protected Context mContext;
    protected View mRootView;
    protected UserData mUserData;

    public abstract void R(View view);

    public abstract View ard();

    public t(Context context) {
        this.mContext = context;
        R(ard());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aSR() {
        this.fYT.setOnViewResponseListener(this.eFl);
    }

    public void setOnViewResponseListener(m mVar) {
        this.eFl = mVar;
        aSR();
    }

    public void h(UserData userData) {
        if (userData != null) {
            this.mUserData = userData;
            k(userData);
            String portrait = userData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                String dm = com.baidu.tbadk.core.util.q.dm(portrait);
                this.fYO.getHeadView().setUrl(dm);
                this.fYO.getHeadView().c(dm, 25, false);
            } else {
                this.fYO.getHeadView().c(String.valueOf(r.f.pic_mycenter_avatar_def_i), 24, false);
            }
            com.baidu.tbadk.data.j pendantData = userData.getPendantData();
            if (pendantData != null) {
                this.fYO.dX(pendantData.pO());
            }
            if (this.fYO.wj()) {
                this.fYP.setVisibility(8);
            } else if (userData.isGodUser || !StringUtils.isNull(userData.getUserTbVipInfoData().getvipV_url())) {
                this.fYP.setVisibility(0);
            } else {
                this.fYP.setVisibility(8);
            }
            if (!StringUtils.isNull(userData.getUserTbVipInfoData().getvipV_url())) {
                this.fYP.c(userData.getUserTbVipInfoData().getvipV_url(), 10, false);
            } else {
                av.c(this.fYP, r.f.pic_shen_avatar_mine);
            }
            ArrayList<IconData> tShowInfo = userData.getTShowInfo();
            UserVipInfoData userVipInfo = userData.getUserVipInfo();
            if (tShowInfo != null && tShowInfo.size() > 0) {
                if (userVipInfo != null && userVipInfo.getVipIconUrl() != null) {
                    tShowInfo.get(0).setIcon(userVipInfo.getVipIconUrl());
                }
                this.fYQ.a(tShowInfo, tShowInfo.size(), this.mContext.getResources().getDimensionPixelSize(r.e.ds34), this.mContext.getResources().getDimensionPixelSize(r.e.ds34), this.mContext.getResources().getDimensionPixelSize(r.e.ds10), true);
            }
            String name_show = userData.getName_show();
            if (!TextUtils.isEmpty(name_show)) {
                if (name_show.length() > 10) {
                    name_show = String.valueOf(name_show.substring(0, 10)) + "...";
                }
                this.ahv.setText(name_show);
                if (userData.getIsMem() > 0) {
                    av.c(this.ahv, r.d.cp_cont_h, 1);
                } else {
                    av.c(this.ahv, r.d.cp_cont_g, 1);
                }
            }
            int i = r.f.icon_pop_boy;
            if (this.mUserData != null) {
                i = this.mUserData.getSex() == 2 ? r.f.icon_pop_girl : r.f.icon_pop_boy;
            }
            this.ahv.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mContext.getResources().getDrawable(i), (Drawable) null);
            this.fYR.a(userData.getIconInfo(), 9, this.mContext.getResources().getDimensionPixelSize(r.e.ds34), this.mContext.getResources().getDimensionPixelSize(r.e.ds34), this.mContext.getResources().getDimensionPixelSize(r.e.ds10), true);
            this.fYS.setText(String.format(this.mContext.getString(r.j.person_center_header_visitor), az.B(userData.getVisitorNum())));
            this.fYT.setData(userData);
        }
    }

    public void pI(String str) {
        this.fYO.dX(str);
        if (this.fYO.wj()) {
            this.fYP.setVisibility(8);
        } else if (bqX()) {
            this.fYP.setVisibility(0);
        }
    }

    private boolean bqX() {
        if (this.mUserData == null) {
            return false;
        }
        return this.mUserData.isGodUser || !(this.mUserData.getUserTbVipInfoData() == null || StringUtils.isNull(this.mUserData.getUserTbVipInfoData().getvipV_url()));
    }

    public void onChangeSkinType(int i) {
        if (this.mUserData != null && StringUtils.isNull(this.mUserData.getUserTbVipInfoData().getvipV_url())) {
            av.c((ImageView) this.fYP, r.f.pic_shen_avatar_mine, i);
        }
        int i2 = r.f.icon_pop_boy;
        if (this.mUserData != null) {
            i2 = this.mUserData.getSex() == 1 ? r.f.icon_pop_boy : r.f.icon_pop_girl;
        }
        if (this.mUserData != null && this.mUserData.getIsMem() > 0) {
            av.c(this.ahv, r.d.cp_cont_h, 1);
        } else {
            av.c(this.ahv, r.d.cp_cont_g, 1);
        }
        this.ahv.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mContext.getResources().getDrawable(i2), (Drawable) null);
        this.fYT.onChangeSkinType(i);
    }

    public void k(UserData userData) {
        String bg_pic = userData != null ? userData.getBg_pic() : null;
        if (StringUtils.isNull(bg_pic)) {
            com.baidu.tbadk.imageManager.c.Ek().eQ(1152000);
            Bitmap logoBitmap = BitmapHelper.getLogoBitmap(this.mContext.getApplicationContext(), r.f.bg_pic_mine);
            if (logoBitmap == null) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = TbConfig.BitmapConfig;
                options.inSampleSize = 2;
                logoBitmap = BitmapHelper.getResBitmap(this.mContext.getApplicationContext(), r.f.bg_pic_mine, options);
            }
            if (logoBitmap != null) {
                this.fYN.setImageBitmap(logoBitmap);
                return;
            }
            return;
        }
        com.baidu.adp.lib.g.c.eA().a(bg_pic, 10, this.aDV, 0, 0, null, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bqY() {
        this.fYO.wk();
        this.fYO.getHeadView().setIsRound(true);
        this.fYO.getHeadView().setDrawBorder(false);
        this.fYO.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
    }
}
