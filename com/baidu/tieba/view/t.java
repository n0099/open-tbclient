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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.data.UserVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.at;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public abstract class t {
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> aIr = new u(this);
    protected TextView amc;
    protected m eCA;
    protected TextView fIA;
    protected TextView fIB;
    public PersonHeaderAttentionView fIC;
    protected BdExpandImageView fIv;
    protected HeadPendantView fIw;
    protected TbImageView fIx;
    protected UserIconBox fIy;
    protected UserIconBox fIz;
    protected Context mContext;
    protected View mRootView;
    protected UserData mUserData;

    public abstract void P(View view);

    public abstract View Qz();

    public t(Context context) {
        this.mContext = context;
        P(Qz());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aQl() {
        this.fIC.setOnViewResponseListener(this.eCA);
    }

    public void setOnViewResponseListener(m mVar) {
        this.eCA = mVar;
        aQl();
    }

    public void f(UserData userData) {
        if (userData != null) {
            this.mUserData = userData;
            i(userData);
            String portrait = userData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                String dg = com.baidu.tbadk.core.util.q.dg(portrait);
                this.fIw.getHeadView().setUrl(dg);
                this.fIw.getHeadView().c(dg, 25, false);
            } else {
                this.fIw.getHeadView().c(String.valueOf(w.g.pic_mycenter_avatar_def_i), 24, false);
            }
            com.baidu.tbadk.data.j pendantData = userData.getPendantData();
            if (pendantData != null) {
                this.fIw.dO(pendantData.qd());
            }
            if (this.fIw.wo()) {
                this.fIx.setVisibility(8);
            } else if (userData.isGod() || !StringUtils.isNull(userData.getUserTbVipInfoData().getvipV_url())) {
                this.fIx.setVisibility(0);
            } else {
                this.fIx.setVisibility(8);
            }
            if (!StringUtils.isNull(userData.getUserTbVipInfoData().getvipV_url())) {
                this.fIx.c(userData.getUserTbVipInfoData().getvipV_url(), 10, false);
            } else {
                aq.c(this.fIx, w.g.pic_shen_avatar_mine);
            }
            ArrayList<IconData> tShowInfo = userData.getTShowInfo();
            UserVipInfoData userVipInfo = userData.getUserVipInfo();
            if (tShowInfo != null && tShowInfo.size() > 0) {
                if (userVipInfo != null && userVipInfo.getVipIconUrl() != null) {
                    tShowInfo.get(0).setIcon(userVipInfo.getVipIconUrl());
                }
                this.fIy.a(tShowInfo, tShowInfo.size(), this.mContext.getResources().getDimensionPixelSize(w.f.ds34), this.mContext.getResources().getDimensionPixelSize(w.f.ds34), this.mContext.getResources().getDimensionPixelSize(w.f.ds10), true);
            }
            String name_show = userData.getName_show();
            if (!TextUtils.isEmpty(name_show)) {
                this.amc.setText(qy(name_show));
                if (userData.getIsMem() > 0) {
                    aq.c(this.amc, w.e.cp_cont_h, 1);
                } else {
                    aq.c(this.amc, w.e.cp_cont_g, 1);
                }
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            if (!StringUtils.isNull(this.mUserData.getSealPrefix())) {
                layoutParams.setMargins(0, 0, 0, 0);
                this.amc.setLayoutParams(layoutParams);
                this.fIB.setVisibility(0);
                this.fIB.setText(ae(this.mUserData.getSealPrefix(), "space"));
            } else {
                layoutParams.setMargins((int) this.mContext.getResources().getDimension(w.f.ds10), 0, 0, 0);
                this.amc.setLayoutParams(layoutParams);
                this.fIB.setVisibility(8);
            }
            int i = w.g.icon_pop_boy;
            if (this.mUserData != null) {
                i = this.mUserData.getSex() == 2 ? w.g.icon_pop_girl : w.g.icon_pop_boy;
            }
            this.amc.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mContext.getResources().getDrawable(i), (Drawable) null);
            this.fIz.a(userData.getIconInfo(), 9, this.mContext.getResources().getDimensionPixelSize(w.f.ds34), this.mContext.getResources().getDimensionPixelSize(w.f.ds34), this.mContext.getResources().getDimensionPixelSize(w.f.ds10), true);
            this.fIA.setText(String.format(this.mContext.getString(w.l.person_center_header_visitor), au.y(userData.getVisitorNum())));
            this.fIC.setData(userData);
        }
    }

    private String qy(String str) {
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

    private SpannableStringBuilder ae(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            at.a aVar = new at.a(str);
            aVar.gG(com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds2));
            arrayList.add(aVar);
            return at.a(this.mContext, str2, (ArrayList<at.a>) arrayList, false);
        }
        return spannableStringBuilder;
    }

    public void nX(String str) {
        this.fIw.dO(str);
        if (this.fIw.wo()) {
            this.fIx.setVisibility(8);
        } else if (blH()) {
            this.fIx.setVisibility(0);
        }
    }

    private boolean blH() {
        if (this.mUserData == null) {
            return false;
        }
        return this.mUserData.isGod() || !(this.mUserData.getUserTbVipInfoData() == null || StringUtils.isNull(this.mUserData.getUserTbVipInfoData().getvipV_url()));
    }

    public void onChangeSkinType(int i) {
        if (this.mUserData != null && StringUtils.isNull(this.mUserData.getUserTbVipInfoData().getvipV_url())) {
            aq.c((ImageView) this.fIx, w.g.pic_shen_avatar_mine, i);
        }
        int i2 = w.g.icon_pop_boy;
        if (this.mUserData != null) {
            i2 = this.mUserData.getSex() == 1 ? w.g.icon_pop_boy : w.g.icon_pop_girl;
        }
        if (this.mUserData != null && this.mUserData.getIsMem() > 0) {
            aq.c(this.amc, w.e.cp_cont_h, 1);
        } else {
            aq.c(this.amc, w.e.cp_cont_g, 1);
        }
        aq.c(this.fIB, w.e.cp_link_tip_a, 1);
        this.amc.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.mContext.getResources().getDrawable(i2), (Drawable) null);
        this.fIC.onChangeSkinType(i);
    }

    public void i(UserData userData) {
        String bg_pic = userData != null ? userData.getBg_pic() : null;
        if (StringUtils.isNull(bg_pic)) {
            com.baidu.tbadk.imageManager.c.El().eQ(1152000);
            Bitmap logoBitmap = BitmapHelper.getLogoBitmap(this.mContext.getApplicationContext(), w.g.bg_pic_mine);
            if (logoBitmap == null) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = TbConfig.BitmapConfig;
                options.inSampleSize = 2;
                logoBitmap = BitmapHelper.getResBitmap(this.mContext.getApplicationContext(), w.g.bg_pic_mine, options);
            }
            if (logoBitmap != null) {
                this.fIv.setImageBitmap(logoBitmap);
                return;
            }
            return;
        }
        com.baidu.adp.lib.f.c.fG().a(bg_pic, 10, this.aIr, 0, 0, null, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void blI() {
        this.fIw.wp();
        this.fIw.getHeadView().setIsRound(true);
        this.fIw.getHeadView().setDrawBorder(false);
        this.fIw.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    public void onDestory() {
    }
}
