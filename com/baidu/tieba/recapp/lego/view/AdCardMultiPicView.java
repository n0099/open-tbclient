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
/* loaded from: classes26.dex */
public class AdCardMultiPicView extends AdCardBaseView {
    protected View mKA;
    protected TextView mKB;
    private final float mKC;
    private final float mKD;
    private float mKE;
    private float mKF;
    private final int mKG;
    private final int mKH;
    private final int mKI;
    private final int mKJ;
    protected XfremodeRoundLayout mKr;
    protected TbImageView mKs;
    protected TextView mKt;
    protected XfremodeRoundLayout mKu;
    protected TbImageView mKv;
    protected TextView mKw;
    protected XfremodeRoundLayout mKx;
    protected TbImageView mKy;
    protected TextView mKz;

    public AdCardMultiPicView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mKC = 1.0f;
        this.mKD = 0.0f;
        this.mKF = 0.0f;
        this.mKG = 1;
        this.mKH = 2;
        this.mKI = 3;
        this.mKJ = 4;
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
    protected void dS(View view) {
        this.mKr = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_left);
        this.mKs = (TbImageView) view.findViewById(R.id.advert_app_img_left);
        this.mKt = (TextView) view.findViewById(R.id.txt_left);
        this.mKu = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_center);
        this.mKv = (TbImageView) view.findViewById(R.id.advert_app_img_center);
        this.mKw = (TextView) view.findViewById(R.id.txt_center);
        this.mKx = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_right);
        this.mKy = (TbImageView) view.findViewById(R.id.advert_app_img_right);
        this.mKz = (TextView) view.findViewById(R.id.txt_right);
        this.mKB = (TextView) view.findViewById(R.id.advert_source_right);
        this.mKE = Jm(R.string.J_X05);
        this.mKs.setPlaceHolder(2);
        this.mKv.setPlaceHolder(2);
        this.mKy.setPlaceHolder(2);
        this.mKA = view.findViewById(R.id.channel_ad_right);
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
            this.mJr.setVisibility(8);
            return;
        }
        this.mKt.setVisibility(8);
        this.mKs.setVisibility(4);
        this.mKw.setVisibility(8);
        this.mKv.setVisibility(4);
        this.mKz.setVisibility(8);
        this.mKy.setVisibility(4);
        a(this.mKr, 1);
        a(this.mKu, 2);
        a(this.mKx, 3);
        b(this.mKs, dimensionPixelSize, max);
        b(this.mKv, dimensionPixelSize, max);
        b(this.mKy, dimensionPixelSize, max);
        if (length == 1) {
            this.mKs.startLoad(dVarArr[0].pic, 30, false);
            this.mKs.setVisibility(0);
            a(this.mKs, dVarArr[0].mJd);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.mKt.setVisibility(8);
            } else {
                this.mKt.setVisibility(0);
                this.mKt.setText(dVarArr[0].desc);
            }
            a(this.mKr, 4);
        } else if (length == 2) {
            this.mKs.startLoad(dVarArr[0].pic, 30, false);
            this.mKs.setVisibility(0);
            this.mKv.setVisibility(0);
            a(this.mKs, dVarArr[0].mJd);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.mKt.setVisibility(8);
            } else {
                this.mKt.setVisibility(0);
                this.mKt.setText(dVarArr[0].desc);
            }
            this.mKv.startLoad(dVarArr[1].pic, 30, false);
            a(this.mKv, dVarArr[1].mJd);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.mKw.setVisibility(8);
            } else {
                this.mKw.setVisibility(0);
                this.mKw.setText(dVarArr[1].desc);
            }
            a(this.mKu, 3);
        } else if (length >= 3) {
            this.mKs.startLoad(dVarArr[0].pic, 30, false);
            this.mKs.setVisibility(0);
            this.mKv.setVisibility(0);
            this.mKy.setVisibility(0);
            a(this.mKs, dVarArr[0].mJd);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.mKt.setVisibility(8);
            } else {
                this.mKt.setVisibility(0);
                this.mKt.setText(dVarArr[0].desc);
            }
            this.mKv.startLoad(dVarArr[1].pic, 30, false);
            a(this.mKv, dVarArr[1].mJd);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.mKw.setVisibility(8);
            } else {
                this.mKw.setVisibility(0);
                this.mKw.setText(dVarArr[1].desc);
            }
            this.mKy.startLoad(dVarArr[2].pic, 30, false);
            a(this.mKy, dVarArr[2].mJd);
            if (StringUtils.isNull(dVarArr[2].desc, true)) {
                this.mKz.setVisibility(8);
            } else {
                this.mKz.setVisibility(0);
                this.mKz.setText(dVarArr[2].desc);
            }
        }
        AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        if (!StringUtils.isNull(adCard.adSource, true)) {
            this.mKB.setText(adCard.adSource);
            this.mKA.setVisibility(0);
        } else if (advertAppInfo != null && advertAppInfo.eEm != null && !TextUtils.isEmpty(advertAppInfo.eEm.adSource)) {
            this.mKB.setText(advertAppInfo.eEm.adSource);
            this.mKA.setVisibility(0);
        } else {
            this.mKA.setVisibility(8);
        }
        this.mJr.setVisibility(0);
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
                xfremodeRoundLayout.setRoundLayoutRadius(new float[]{this.mKE, this.mKE, this.mKF, this.mKF, this.mKF, this.mKF, this.mKE, this.mKE});
                return;
            case 2:
                xfremodeRoundLayout.setRoundLayoutRadius(new float[]{this.mKF, this.mKF, this.mKF, this.mKF, this.mKF, this.mKF, this.mKF, this.mKF});
                return;
            case 3:
                xfremodeRoundLayout.setRoundLayoutRadius(new float[]{this.mKF, this.mKF, this.mKE, this.mKE, this.mKE, this.mKE, this.mKF, this.mKF});
                return;
            default:
                xfremodeRoundLayout.setRoundLayoutRadius(new float[]{this.mKE, this.mKE, this.mKE, this.mKE, this.mKE, this.mKE, this.mKE, this.mKE});
                return;
        }
    }
}
