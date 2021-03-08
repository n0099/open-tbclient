package com.baidu.tieba.recapp.lego.view;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.AdCard;
/* loaded from: classes7.dex */
public class AdCardMultiPicView extends AdCardBaseView {
    protected XfremodeRoundLayout mWR;
    protected TbImageView mWS;
    protected TextView mWT;
    protected XfremodeRoundLayout mWU;
    protected TbImageView mWV;
    protected TextView mWW;
    protected XfremodeRoundLayout mWX;
    protected TbImageView mWY;
    protected TextView mWZ;
    protected View mXa;
    protected TextView mXb;
    private final float mXc;
    private final float mXd;
    private float mXe;
    private float mXf;
    private final int mXg;
    private final int mXh;
    private final int mXi;
    private final int mXj;

    public AdCardMultiPicView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mXc = 1.0f;
        this.mXd = 0.0f;
        this.mXf = 0.0f;
        this.mXg = 1;
        this.mXh = 2;
        this.mXi = 3;
        this.mXj = 4;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected int getLayout() {
        return R.layout.card_ad;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected int getCustomLayout() {
        return R.layout.card_ad_multi_pic;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void ea(View view) {
        this.mWR = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_left);
        this.mWS = (TbImageView) view.findViewById(R.id.advert_app_img_left);
        this.mWT = (TextView) view.findViewById(R.id.txt_left);
        this.mWU = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_center);
        this.mWV = (TbImageView) view.findViewById(R.id.advert_app_img_center);
        this.mWW = (TextView) view.findViewById(R.id.txt_center);
        this.mWX = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_right);
        this.mWY = (TbImageView) view.findViewById(R.id.advert_app_img_right);
        this.mWZ = (TextView) view.findViewById(R.id.txt_right);
        this.mXb = (TextView) view.findViewById(R.id.advert_source_right);
        this.mXe = HW(R.string.J_X05);
        this.mWS.setPlaceHolder(2);
        this.mWV.setPlaceHolder(2);
        this.mWY.setPlaceHolder(2);
        this.mXa = view.findViewById(R.id.channel_ad_right);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void a(AdCard adCard) {
        AdCard.d[] dVarArr = adCard.threadPicList;
        int length = dVarArr != null ? dVarArr.length : 0;
        int dimensionPixelSize = (int) ((this.mMaxWidth - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.M_W_X002) * 2)) / 3.0f);
        int i = adCard.height;
        int i2 = adCard.width;
        float f = 1.0f;
        if (i != 0 && i2 != 0) {
            f = i / i2;
        }
        int max = (int) (Math.max(Math.min(f, 1.0f), 0.0f) * dimensionPixelSize);
        if (length <= 0) {
            this.mVP.setVisibility(8);
            return;
        }
        this.mWT.setVisibility(8);
        this.mWS.setVisibility(4);
        this.mWW.setVisibility(8);
        this.mWV.setVisibility(4);
        this.mWZ.setVisibility(8);
        this.mWY.setVisibility(4);
        a(this.mWR, 1);
        a(this.mWU, 2);
        a(this.mWX, 3);
        b(this.mWS, dimensionPixelSize, max);
        b(this.mWV, dimensionPixelSize, max);
        b(this.mWY, dimensionPixelSize, max);
        if (length == 1) {
            this.mWS.startLoad(dVarArr[0].pic, 30, false);
            this.mWS.setVisibility(0);
            a(this.mWS, dVarArr[0].mVw);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.mWT.setVisibility(8);
            } else {
                this.mWT.setVisibility(0);
                this.mWT.setText(dVarArr[0].desc);
            }
            a(this.mWR, 4);
        } else if (length == 2) {
            this.mWS.startLoad(dVarArr[0].pic, 30, false);
            this.mWS.setVisibility(0);
            this.mWV.setVisibility(0);
            a(this.mWS, dVarArr[0].mVw);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.mWT.setVisibility(8);
            } else {
                this.mWT.setVisibility(0);
                this.mWT.setText(dVarArr[0].desc);
            }
            this.mWV.startLoad(dVarArr[1].pic, 30, false);
            a(this.mWV, dVarArr[1].mVw);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.mWW.setVisibility(8);
            } else {
                this.mWW.setVisibility(0);
                this.mWW.setText(dVarArr[1].desc);
            }
            a(this.mWU, 3);
        } else if (length >= 3) {
            this.mWS.startLoad(dVarArr[0].pic, 30, false);
            this.mWS.setVisibility(0);
            this.mWV.setVisibility(0);
            this.mWY.setVisibility(0);
            a(this.mWS, dVarArr[0].mVw);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.mWT.setVisibility(8);
            } else {
                this.mWT.setVisibility(0);
                this.mWT.setText(dVarArr[0].desc);
            }
            this.mWV.startLoad(dVarArr[1].pic, 30, false);
            a(this.mWV, dVarArr[1].mVw);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.mWW.setVisibility(8);
            } else {
                this.mWW.setVisibility(0);
                this.mWW.setText(dVarArr[1].desc);
            }
            this.mWY.startLoad(dVarArr[2].pic, 30, false);
            a(this.mWY, dVarArr[2].mVw);
            if (StringUtils.isNull(dVarArr[2].desc, true)) {
                this.mWZ.setVisibility(8);
            } else {
                this.mWZ.setVisibility(0);
                this.mWZ.setText(dVarArr[2].desc);
            }
        }
        AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        if (!StringUtils.isNull(adCard.adSource, true)) {
            this.mXb.setText(adCard.adSource);
            this.mXa.setVisibility(0);
        } else if (advertAppInfo != null && advertAppInfo.eNd != null && !TextUtils.isEmpty(advertAppInfo.eNd.adSource)) {
            this.mXb.setText(advertAppInfo.eNd.adSource);
            this.mXa.setVisibility(0);
        } else {
            this.mXa.setVisibility(8);
        }
        this.mVP.setVisibility(0);
    }

    private void b(TbImageView tbImageView, int i, int i2) {
        if (tbImageView != null) {
            ViewGroup.LayoutParams layoutParams = tbImageView.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.width = i;
            tbImageView.setLayoutParams(layoutParams);
        }
    }

    private void a(XfremodeRoundLayout xfremodeRoundLayout, int i) {
        switch (i) {
            case 1:
                xfremodeRoundLayout.setRoundLayoutRadius(new float[]{this.mXe, this.mXe, this.mXf, this.mXf, this.mXf, this.mXf, this.mXe, this.mXe});
                return;
            case 2:
                xfremodeRoundLayout.setRoundLayoutRadius(new float[]{this.mXf, this.mXf, this.mXf, this.mXf, this.mXf, this.mXf, this.mXf, this.mXf});
                return;
            case 3:
                xfremodeRoundLayout.setRoundLayoutRadius(new float[]{this.mXf, this.mXf, this.mXe, this.mXe, this.mXe, this.mXe, this.mXf, this.mXf});
                return;
            default:
                xfremodeRoundLayout.setRoundLayoutRadius(new float[]{this.mXe, this.mXe, this.mXe, this.mXe, this.mXe, this.mXe, this.mXe, this.mXe});
                return;
        }
    }
}
