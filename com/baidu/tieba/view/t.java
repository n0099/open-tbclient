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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.data.UserVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public abstract class t {
    protected TextView ahN;
    protected m eDi;
    protected BdExpandImageView fWI;
    protected HeadPendantView fWJ;
    protected TbImageView fWK;
    protected UserIconBox fWL;
    protected UserIconBox fWM;
    protected TextView fWN;
    public PersonHeaderAttentionView fWO;
    protected Context mContext;
    protected View mRootView;
    protected UserData mUserData;
    private boolean fWP = false;
    private final com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> aEx = new u(this);

    public abstract void R(View view);

    public abstract View aqE();

    public t(Context context) {
        this.mContext = context;
        R(aqE());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aSt() {
        this.fWO.setOnViewResponseListener(this.eDi);
    }

    public void setOnViewResponseListener(m mVar) {
        this.eDi = mVar;
        aSt();
    }

    public void h(UserData userData) {
        if (userData != null) {
            this.mUserData = userData;
            k(userData);
            String portrait = userData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                String dk = com.baidu.tbadk.core.util.q.dk(portrait);
                this.fWJ.getHeadView().setUrl(dk);
                this.fWJ.getHeadView().c(dk, 25, false);
            } else {
                this.fWJ.getHeadView().c(String.valueOf(t.f.pic_mycenter_avatar_def_i), 24, false);
            }
            com.baidu.tbadk.data.j pendantData = userData.getPendantData();
            if (pendantData != null) {
                this.fWJ.dU(pendantData.rc());
            }
            if (this.fWJ.vV()) {
                this.fWK.setVisibility(8);
            } else if (userData.isGodUser || !StringUtils.isNull(userData.getUserTbVipInfoData().getvipV_url())) {
                this.fWK.setVisibility(0);
                this.fWP = true;
            } else {
                this.fWK.setVisibility(8);
            }
            if (!StringUtils.isNull(userData.getUserTbVipInfoData().getvipV_url())) {
                this.fWK.c(userData.getUserTbVipInfoData().getvipV_url(), 10, false);
            } else {
                av.c(this.fWK, t.f.pic_shen_avatar_mine);
            }
            ArrayList<IconData> tShowInfo = userData.getTShowInfo();
            UserVipInfoData userVipInfo = userData.getUserVipInfo();
            if (tShowInfo != null && tShowInfo.size() > 0) {
                if (userVipInfo != null && userVipInfo.getVipIconUrl() != null) {
                    tShowInfo.get(0).setIcon(userVipInfo.getVipIconUrl());
                }
                this.fWL.a(tShowInfo, tShowInfo.size(), this.mContext.getResources().getDimensionPixelSize(t.e.ds34), this.mContext.getResources().getDimensionPixelSize(t.e.ds34), this.mContext.getResources().getDimensionPixelSize(t.e.ds10), true);
            }
            String name_show = userData.getName_show();
            if (!TextUtils.isEmpty(name_show)) {
                if (name_show.length() > 10) {
                    name_show = String.valueOf(name_show.substring(0, 10)) + "...";
                }
                this.ahN.setText(name_show);
                if (userData.getIsMem() > 0) {
                    av.c(this.ahN, t.d.cp_cont_h, 1);
                } else {
                    av.c(this.ahN, t.d.cp_cont_g, 1);
                }
            }
            int i = t.f.icon_pop_boy;
            if (this.mUserData != null) {
                i = this.mUserData.getSex() == 2 ? t.f.icon_pop_girl : t.f.icon_pop_boy;
            }
            this.ahN.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mContext.getResources().getDrawable(i), (Drawable) null);
            this.fWM.a(userData.getIconInfo(), 9, this.mContext.getResources().getDimensionPixelSize(t.e.ds34), this.mContext.getResources().getDimensionPixelSize(t.e.ds34), this.mContext.getResources().getDimensionPixelSize(t.e.ds10), true);
            this.fWN.setText(String.format(this.mContext.getString(t.j.person_center_header_visitor), ba.A(userData.getVisitorNum())));
            this.fWO.setData(userData);
        }
    }

    public void pw(String str) {
        this.fWJ.dU(str);
        if (this.fWJ.vV()) {
            this.fWK.setVisibility(8);
        } else if (this.fWP) {
            this.fWK.setVisibility(0);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mUserData != null && StringUtils.isNull(this.mUserData.getUserTbVipInfoData().getvipV_url())) {
            av.c((ImageView) this.fWK, t.f.pic_shen_avatar_mine, i);
        }
        int i2 = t.f.icon_pop_boy;
        if (this.mUserData != null) {
            i2 = this.mUserData.getSex() == 1 ? t.f.icon_pop_boy : t.f.icon_pop_girl;
        }
        if (this.mUserData != null && this.mUserData.getIsMem() > 0) {
            av.c(this.ahN, t.d.cp_cont_h, 1);
        } else {
            av.c(this.ahN, t.d.cp_cont_g, 1);
        }
        this.ahN.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mContext.getResources().getDrawable(i2), (Drawable) null);
        this.fWO.onChangeSkinType(i);
    }

    public void k(UserData userData) {
        String bg_pic = userData != null ? userData.getBg_pic() : null;
        if (StringUtils.isNull(bg_pic)) {
            com.baidu.tbadk.imageManager.c.Ek().eR(1152000);
            Bitmap logoBitmap = BitmapHelper.getLogoBitmap(this.mContext.getApplicationContext(), t.f.bg_pic_mine);
            if (logoBitmap == null) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = TbConfig.BitmapConfig;
                options.inSampleSize = 2;
                logoBitmap = BitmapHelper.getResBitmap(this.mContext.getApplicationContext(), t.f.bg_pic_mine, options);
            }
            if (logoBitmap != null) {
                this.fWI.setImageBitmap(logoBitmap);
                return;
            }
            return;
        }
        com.baidu.adp.lib.g.c.eA().a(bg_pic, 10, this.aEx, 0, 0, null, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bqt() {
        this.fWJ.vW();
        this.fWJ.getHeadView().setIsRound(true);
        this.fWJ.getHeadView().setDrawBorder(false);
        this.fWJ.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
    }
}
