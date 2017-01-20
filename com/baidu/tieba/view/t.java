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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.data.UserVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.at;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public abstract class t {
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> aCU = new u(this);
    protected TextView agJ;
    protected m ezb;
    protected BdExpandImageView fDU;
    protected HeadPendantView fDV;
    protected TbImageView fDW;
    protected UserIconBox fDX;
    protected UserIconBox fDY;
    protected TextView fDZ;
    protected TextView fEa;
    public PersonHeaderAttentionView fEb;
    protected Context mContext;
    protected View mRootView;
    protected UserData mUserData;

    public abstract View PG();

    public abstract void R(View view);

    public t(Context context) {
        this.mContext = context;
        R(PG());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aQI() {
        this.fEb.setOnViewResponseListener(this.ezb);
    }

    public void setOnViewResponseListener(m mVar) {
        this.ezb = mVar;
        aQI();
    }

    public void f(UserData userData) {
        if (userData != null) {
            this.mUserData = userData;
            i(userData);
            String portrait = userData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                String dn = com.baidu.tbadk.core.util.p.dn(portrait);
                this.fDV.getHeadView().setUrl(dn);
                this.fDV.getHeadView().c(dn, 25, false);
            } else {
                this.fDV.getHeadView().c(String.valueOf(r.g.pic_mycenter_avatar_def_i), 24, false);
            }
            com.baidu.tbadk.data.j pendantData = userData.getPendantData();
            if (pendantData != null) {
                this.fDV.dU(pendantData.pL());
            }
            if (this.fDV.vR()) {
                this.fDW.setVisibility(8);
            } else if (userData.isGod() || !StringUtils.isNull(userData.getUserTbVipInfoData().getvipV_url())) {
                this.fDW.setVisibility(0);
            } else {
                this.fDW.setVisibility(8);
            }
            if (!StringUtils.isNull(userData.getUserTbVipInfoData().getvipV_url())) {
                this.fDW.c(userData.getUserTbVipInfoData().getvipV_url(), 10, false);
            } else {
                ap.c(this.fDW, r.g.pic_shen_avatar_mine);
            }
            ArrayList<IconData> tShowInfo = userData.getTShowInfo();
            UserVipInfoData userVipInfo = userData.getUserVipInfo();
            if (tShowInfo != null && tShowInfo.size() > 0) {
                if (userVipInfo != null && userVipInfo.getVipIconUrl() != null) {
                    tShowInfo.get(0).setIcon(userVipInfo.getVipIconUrl());
                }
                this.fDX.a(tShowInfo, tShowInfo.size(), this.mContext.getResources().getDimensionPixelSize(r.f.ds34), this.mContext.getResources().getDimensionPixelSize(r.f.ds34), this.mContext.getResources().getDimensionPixelSize(r.f.ds10), true);
            }
            String name_show = userData.getName_show();
            if (!TextUtils.isEmpty(name_show)) {
                this.agJ.setText(rq(name_show));
                if (userData.getIsMem() > 0) {
                    ap.c(this.agJ, r.e.cp_cont_h, 1);
                } else {
                    ap.c(this.agJ, r.e.cp_cont_g, 1);
                }
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            if (!StringUtils.isNull(this.mUserData.getSealPrefix())) {
                layoutParams.setMargins(0, 0, 0, 0);
                this.agJ.setLayoutParams(layoutParams);
                this.fEa.setVisibility(0);
                this.fEa.setText(ag(this.mUserData.getSealPrefix(), "space"));
            } else {
                layoutParams.setMargins((int) this.mContext.getResources().getDimension(r.f.ds10), 0, 0, 0);
                this.agJ.setLayoutParams(layoutParams);
                this.fEa.setVisibility(8);
            }
            int i = r.g.icon_pop_boy;
            if (this.mUserData != null) {
                i = this.mUserData.getSex() == 2 ? r.g.icon_pop_girl : r.g.icon_pop_boy;
            }
            this.agJ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mContext.getResources().getDrawable(i), (Drawable) null);
            this.fDY.a(userData.getIconInfo(), 9, this.mContext.getResources().getDimensionPixelSize(r.f.ds34), this.mContext.getResources().getDimensionPixelSize(r.f.ds34), this.mContext.getResources().getDimensionPixelSize(r.f.ds10), true);
            this.fDZ.setText(String.format(this.mContext.getString(r.l.person_center_header_visitor), at.y(userData.getVisitorNum())));
            this.fEb.setData(userData);
        }
    }

    private String rq(String str) {
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
            at.a aVar = new at.a(str);
            aVar.gJ(com.baidu.adp.lib.util.k.e(this.mContext, r.f.ds2));
            arrayList.add(aVar);
            return com.baidu.tieba.card.at.a(this.mContext, str2, (ArrayList<at.a>) arrayList, false);
        }
        return spannableStringBuilder;
    }

    public void oP(String str) {
        this.fDV.dU(str);
        if (this.fDV.vR()) {
            this.fDW.setVisibility(8);
        } else if (blS()) {
            this.fDW.setVisibility(0);
        }
    }

    private boolean blS() {
        if (this.mUserData == null) {
            return false;
        }
        return this.mUserData.isGod() || !(this.mUserData.getUserTbVipInfoData() == null || StringUtils.isNull(this.mUserData.getUserTbVipInfoData().getvipV_url()));
    }

    public void onChangeSkinType(int i) {
        if (this.mUserData != null && StringUtils.isNull(this.mUserData.getUserTbVipInfoData().getvipV_url())) {
            ap.c((ImageView) this.fDW, r.g.pic_shen_avatar_mine, i);
        }
        int i2 = r.g.icon_pop_boy;
        if (this.mUserData != null) {
            i2 = this.mUserData.getSex() == 1 ? r.g.icon_pop_boy : r.g.icon_pop_girl;
        }
        if (this.mUserData != null && this.mUserData.getIsMem() > 0) {
            ap.c(this.agJ, r.e.cp_cont_h, 1);
        } else {
            ap.c(this.agJ, r.e.cp_cont_g, 1);
        }
        ap.c(this.fEa, r.e.cp_link_tip_a, 1);
        this.agJ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mContext.getResources().getDrawable(i2), (Drawable) null);
        this.fEb.onChangeSkinType(i);
    }

    public void i(UserData userData) {
        String bg_pic = userData != null ? userData.getBg_pic() : null;
        if (StringUtils.isNull(bg_pic)) {
            com.baidu.tbadk.imageManager.c.DS().eV(1152000);
            Bitmap logoBitmap = BitmapHelper.getLogoBitmap(this.mContext.getApplicationContext(), r.g.bg_pic_mine);
            if (logoBitmap == null) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = TbConfig.BitmapConfig;
                options.inSampleSize = 2;
                logoBitmap = BitmapHelper.getResBitmap(this.mContext.getApplicationContext(), r.g.bg_pic_mine, options);
            }
            if (logoBitmap != null) {
                this.fDU.setImageBitmap(logoBitmap);
                return;
            }
            return;
        }
        com.baidu.adp.lib.f.c.ey().a(bg_pic, 10, this.aCU, 0, 0, null, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void blT() {
        this.fDV.vS();
        this.fDV.getHeadView().setIsRound(true);
        this.fDV.getHeadView().setDrawBorder(false);
        this.fDV.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    public void onDestory() {
    }
}
