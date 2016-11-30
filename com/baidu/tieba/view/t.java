package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdExpandImageView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.data.UserVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.an;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public abstract class t {
    private final com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> aEL = new u(this);
    protected TextView ahV;
    protected m eLK;
    protected BdExpandImageView ggi;
    protected HeadPendantView ggj;
    protected TbImageView ggk;
    protected UserIconBox ggl;
    protected UserIconBox ggm;
    protected TextView ggn;
    protected TextView ggo;
    public PersonHeaderAttentionView ggp;
    protected Context mContext;
    protected View mRootView;
    protected UserData mUserData;

    public abstract void S(View view);

    public abstract View ata();

    public t(Context context) {
        this.mContext = context;
        S(ata());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aUY() {
        this.ggp.setOnViewResponseListener(this.eLK);
    }

    public void setOnViewResponseListener(m mVar) {
        this.eLK = mVar;
        aUY();
    }

    public void h(UserData userData) {
        if (userData != null) {
            this.mUserData = userData;
            k(userData);
            String portrait = userData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                String m11do = com.baidu.tbadk.core.util.q.m11do(portrait);
                this.ggj.getHeadView().setUrl(m11do);
                this.ggj.getHeadView().c(m11do, 25, false);
            } else {
                this.ggj.getHeadView().c(String.valueOf(r.f.pic_mycenter_avatar_def_i), 24, false);
            }
            com.baidu.tbadk.data.k pendantData = userData.getPendantData();
            if (pendantData != null) {
                this.ggj.dZ(pendantData.pR());
            }
            if (this.ggj.wn()) {
                this.ggk.setVisibility(8);
            } else if (userData.isGod() || !StringUtils.isNull(userData.getUserTbVipInfoData().getvipV_url())) {
                this.ggk.setVisibility(0);
            } else {
                this.ggk.setVisibility(8);
            }
            if (!StringUtils.isNull(userData.getUserTbVipInfoData().getvipV_url())) {
                this.ggk.c(userData.getUserTbVipInfoData().getvipV_url(), 10, false);
            } else {
                at.c(this.ggk, r.f.pic_shen_avatar_mine);
            }
            ArrayList<IconData> tShowInfo = userData.getTShowInfo();
            UserVipInfoData userVipInfo = userData.getUserVipInfo();
            if (tShowInfo != null && tShowInfo.size() > 0) {
                if (userVipInfo != null && userVipInfo.getVipIconUrl() != null) {
                    tShowInfo.get(0).setIcon(userVipInfo.getVipIconUrl());
                }
                this.ggl.a(tShowInfo, tShowInfo.size(), this.mContext.getResources().getDimensionPixelSize(r.e.ds34), this.mContext.getResources().getDimensionPixelSize(r.e.ds34), this.mContext.getResources().getDimensionPixelSize(r.e.ds10), true);
            }
            String name_show = userData.getName_show();
            if (!TextUtils.isEmpty(name_show)) {
                this.ahV.setText(sI(name_show));
                if (userData.getIsMem() > 0) {
                    at.c(this.ahV, r.d.cp_cont_h, 1);
                } else {
                    at.c(this.ahV, r.d.cp_cont_g, 1);
                }
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            if (!StringUtils.isNull(this.mUserData.getSealPrefix())) {
                layoutParams.setMargins(0, 0, 0, 0);
                this.ahV.setLayoutParams(layoutParams);
                this.ggo.setVisibility(0);
                this.ggo.setText(ag(this.mUserData.getSealPrefix(), "space"));
            } else {
                layoutParams.setMargins((int) this.mContext.getResources().getDimension(r.e.ds10), 0, 0, 0);
                this.ahV.setLayoutParams(layoutParams);
                this.ggo.setVisibility(8);
            }
            int i = r.f.icon_pop_boy;
            if (this.mUserData != null) {
                i = this.mUserData.getSex() == 2 ? r.f.icon_pop_girl : r.f.icon_pop_boy;
            }
            this.ahV.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mContext.getResources().getDrawable(i), (Drawable) null);
            this.ggm.a(userData.getIconInfo(), 9, this.mContext.getResources().getDimensionPixelSize(r.e.ds34), this.mContext.getResources().getDimensionPixelSize(r.e.ds34), this.mContext.getResources().getDimensionPixelSize(r.e.ds10), true);
            this.ggn.setText(String.format(this.mContext.getString(r.j.person_center_header_visitor), ax.A(userData.getVisitorNum())));
            this.ggp.setData(userData);
        }
    }

    private String sI(String str) {
        if (this.mUserData == null || StringUtils.isNull(str)) {
            return "";
        }
        if (StringUtils.isNull(this.mUserData.getSealPrefix())) {
            if (str.length() > 10) {
                return String.valueOf(str.substring(0, 10)) + "...";
            }
            return str;
        } else if (str.length() > 7) {
            return String.valueOf(str.substring(0, 7)) + "...";
        } else {
            return str;
        }
    }

    private SpannableStringBuilder ag(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            an.a aVar = new an.a(str);
            aVar.gi(com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds2));
            arrayList.add(aVar);
            return an.a(this.mContext, str2, (ArrayList<an.a>) arrayList, false);
        }
        return spannableStringBuilder;
    }

    public void pV(String str) {
        this.ggj.dZ(str);
        if (this.ggj.wn()) {
            this.ggk.setVisibility(8);
        } else if (btq()) {
            this.ggk.setVisibility(0);
        }
    }

    private boolean btq() {
        if (this.mUserData == null) {
            return false;
        }
        return this.mUserData.isGod() || !(this.mUserData.getUserTbVipInfoData() == null || StringUtils.isNull(this.mUserData.getUserTbVipInfoData().getvipV_url()));
    }

    public void onChangeSkinType(int i) {
        if (this.mUserData != null && StringUtils.isNull(this.mUserData.getUserTbVipInfoData().getvipV_url())) {
            at.c((ImageView) this.ggk, r.f.pic_shen_avatar_mine, i);
        }
        int i2 = r.f.icon_pop_boy;
        if (this.mUserData != null) {
            i2 = this.mUserData.getSex() == 1 ? r.f.icon_pop_boy : r.f.icon_pop_girl;
        }
        if (this.mUserData != null && this.mUserData.getIsMem() > 0) {
            at.c(this.ahV, r.d.cp_cont_h, 1);
        } else {
            at.c(this.ahV, r.d.cp_cont_g, 1);
        }
        at.c(this.ggo, r.d.cp_link_tip_a, 1);
        this.ahV.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mContext.getResources().getDrawable(i2), (Drawable) null);
        this.ggp.onChangeSkinType(i);
    }

    public void k(UserData userData) {
        String bg_pic = userData != null ? userData.getBg_pic() : null;
        if (StringUtils.isNull(bg_pic)) {
            com.baidu.tbadk.imageManager.c.Ep().eT(1152000);
            Bitmap logoBitmap = BitmapHelper.getLogoBitmap(this.mContext.getApplicationContext(), r.f.bg_pic_mine);
            if (logoBitmap == null) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = TbConfig.BitmapConfig;
                options.inSampleSize = 2;
                logoBitmap = BitmapHelper.getResBitmap(this.mContext.getApplicationContext(), r.f.bg_pic_mine, options);
            }
            if (logoBitmap != null) {
                this.ggi.setImageBitmap(logoBitmap);
                return;
            }
            return;
        }
        com.baidu.adp.lib.g.c.eA().a(bg_pic, 10, this.aEL, 0, 0, null, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void btr() {
        this.ggj.wo();
        this.ggj.getHeadView().setIsRound(true);
        this.ggj.getHeadView().setDrawBorder(false);
        this.ggj.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
    }
}
