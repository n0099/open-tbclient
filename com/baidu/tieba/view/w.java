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
public abstract class w {
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> aIM = new x(this);
    protected TextView amB;
    protected p eyy;
    protected BdExpandImageView fJm;
    protected HeadPendantView fJn;
    protected TbImageView fJo;
    protected UserIconBox fJp;
    protected UserIconBox fJq;
    protected TextView fJr;
    protected TextView fJs;
    public PersonHeaderAttentionView fJt;
    protected Context mContext;
    protected View mRootView;
    protected UserData mUserData;

    public abstract void O(View view);

    public abstract View Ru();

    public w(Context context) {
        this.mContext = context;
        O(Ru());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aQd() {
        this.fJt.setOnViewResponseListener(this.eyy);
    }

    public void setOnViewResponseListener(p pVar) {
        this.eyy = pVar;
        aQd();
    }

    public void d(UserData userData) {
        if (userData != null) {
            this.mUserData = userData;
            f(userData);
            String portrait = userData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                String dl = com.baidu.tbadk.core.util.q.dl(portrait);
                this.fJn.getHeadView().setUrl(dl);
                this.fJn.getHeadView().c(dl, 25, false);
            } else {
                this.fJn.getHeadView().c(String.valueOf(w.g.pic_mycenter_avatar_def_i), 24, false);
            }
            com.baidu.tbadk.data.i pendantData = userData.getPendantData();
            if (pendantData != null) {
                this.fJn.dS(pendantData.pT());
            }
            if (this.fJn.vX()) {
                this.fJo.setVisibility(8);
            } else if (userData.isGod() || !StringUtils.isNull(userData.getUserTbVipInfoData().getvipV_url())) {
                this.fJo.setVisibility(0);
            } else {
                this.fJo.setVisibility(8);
            }
            if (!StringUtils.isNull(userData.getUserTbVipInfoData().getvipV_url())) {
                this.fJo.c(userData.getUserTbVipInfoData().getvipV_url(), 10, false);
            } else {
                aq.c(this.fJo, w.g.pic_shen_avatar_mine);
            }
            ArrayList<IconData> tShowInfo = userData.getTShowInfo();
            UserVipInfoData userVipInfo = userData.getUserVipInfo();
            if (!com.baidu.tbadk.core.util.x.r(tShowInfo) && com.baidu.tbadk.core.util.x.c(tShowInfo, 0) != null) {
                if (userVipInfo != null && userVipInfo.getVipIconUrl() != null) {
                    ((IconData) com.baidu.tbadk.core.util.x.c(tShowInfo, 0)).setIcon(userVipInfo.getVipIconUrl());
                }
                this.fJp.a(tShowInfo, tShowInfo.size(), this.mContext.getResources().getDimensionPixelSize(w.f.ds34), this.mContext.getResources().getDimensionPixelSize(w.f.ds34), this.mContext.getResources().getDimensionPixelSize(w.f.ds10), true);
                aq.c(this.amB, w.e.cp_cont_h, 1);
            } else {
                aq.c(this.amB, w.e.cp_cont_i, 1);
            }
            String name_show = userData.getName_show();
            if (!TextUtils.isEmpty(name_show)) {
                if (au.dy(name_show) > 14) {
                    name_show = au.d(name_show, 14, "...");
                }
                this.amB.setText(name_show);
            }
            int i = w.g.icon_pop_boy;
            if (this.mUserData != null) {
                i = this.mUserData.getSex() == 2 ? w.g.icon_pop_girl : w.g.icon_pop_boy;
            }
            this.amB.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mContext.getResources().getDrawable(i), (Drawable) null);
            this.fJq.a(userData.getIconInfo(), 9, this.mContext.getResources().getDimensionPixelSize(w.f.ds34), this.mContext.getResources().getDimensionPixelSize(w.f.ds34), this.mContext.getResources().getDimensionPixelSize(w.f.ds10), true);
            this.fJt.setData(userData);
        }
    }

    public void qK(String str) {
        this.fJn.dS(str);
        if (this.fJn.vX()) {
            this.fJo.setVisibility(8);
        } else if (bkX()) {
            this.fJo.setVisibility(0);
        }
    }

    private boolean bkX() {
        if (this.mUserData == null) {
            return false;
        }
        return this.mUserData.isGod() || !(this.mUserData.getUserTbVipInfoData() == null || StringUtils.isNull(this.mUserData.getUserTbVipInfoData().getvipV_url()));
    }

    public void onChangeSkinType(int i) {
        if (this.mUserData != null && StringUtils.isNull(this.mUserData.getUserTbVipInfoData().getvipV_url())) {
            aq.c((ImageView) this.fJo, w.g.pic_shen_avatar_mine, i);
        }
        int i2 = w.g.icon_pop_boy;
        if (this.mUserData != null) {
            i2 = this.mUserData.getSex() == 1 ? w.g.icon_pop_boy : w.g.icon_pop_girl;
        }
        if (this.mUserData != null && this.mUserData.getIsMem() > 0) {
            aq.c(this.amB, w.e.cp_cont_r, 1);
        } else {
            aq.c(this.amB, w.e.cp_cont_i, 1);
        }
        aq.c(this.fJs, w.e.cp_link_tip_a, 1);
        this.amB.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mContext.getResources().getDrawable(i2), (Drawable) null);
        this.fJt.onChangeSkinType(i);
    }

    public void f(UserData userData) {
        String bg_pic = userData != null ? userData.getBg_pic() : null;
        if (StringUtils.isNull(bg_pic)) {
            com.baidu.tbadk.imageManager.c.DN().eP(1152000);
            Bitmap logoBitmap = BitmapHelper.getLogoBitmap(this.mContext.getApplicationContext(), w.g.bg_pic_mine);
            if (logoBitmap == null) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = TbConfig.BitmapConfig;
                options.inSampleSize = 2;
                logoBitmap = BitmapHelper.getResBitmap(this.mContext.getApplicationContext(), w.g.bg_pic_mine, options);
            }
            if (logoBitmap != null) {
                this.fJm.setImageBitmap(logoBitmap);
                return;
            }
            return;
        }
        com.baidu.adp.lib.f.c.fM().a(bg_pic, 10, this.aIM, 0, 0, null, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bkY() {
        this.fJn.vY();
        this.fJn.getHeadView().setIsRound(true);
        this.fJn.getHeadView().setDrawBorder(false);
        this.fJn.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    public void onDestory() {
    }
}
