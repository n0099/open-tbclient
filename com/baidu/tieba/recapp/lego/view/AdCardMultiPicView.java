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
    protected XfremodeRoundLayout mKT;
    protected TbImageView mKU;
    protected TextView mKV;
    protected XfremodeRoundLayout mKW;
    protected TbImageView mKX;
    protected TextView mKY;
    protected XfremodeRoundLayout mKZ;
    protected TbImageView mLa;
    protected TextView mLb;
    protected View mLc;
    protected TextView mLd;
    private final float mLe;
    private final float mLf;
    private float mLg;
    private float mLh;
    private final int mLi;
    private final int mLj;
    private final int mLk;
    private final int mLl;

    public AdCardMultiPicView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mLe = 1.0f;
        this.mLf = 0.0f;
        this.mLh = 0.0f;
        this.mLi = 1;
        this.mLj = 2;
        this.mLk = 3;
        this.mLl = 4;
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
    protected void ec(View view) {
        this.mKT = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_left);
        this.mKU = (TbImageView) view.findViewById(R.id.advert_app_img_left);
        this.mKV = (TextView) view.findViewById(R.id.txt_left);
        this.mKW = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_center);
        this.mKX = (TbImageView) view.findViewById(R.id.advert_app_img_center);
        this.mKY = (TextView) view.findViewById(R.id.txt_center);
        this.mKZ = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_right);
        this.mLa = (TbImageView) view.findViewById(R.id.advert_app_img_right);
        this.mLb = (TextView) view.findViewById(R.id.txt_right);
        this.mLd = (TextView) view.findViewById(R.id.advert_source_right);
        this.mLg = Hz(R.string.J_X05);
        this.mKU.setPlaceHolder(2);
        this.mKX.setPlaceHolder(2);
        this.mLa.setPlaceHolder(2);
        this.mLc = view.findViewById(R.id.channel_ad_right);
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
            this.mJT.setVisibility(8);
            return;
        }
        this.mKV.setVisibility(8);
        this.mKU.setVisibility(4);
        this.mKY.setVisibility(8);
        this.mKX.setVisibility(4);
        this.mLb.setVisibility(8);
        this.mLa.setVisibility(4);
        a(this.mKT, 1);
        a(this.mKW, 2);
        a(this.mKZ, 3);
        b(this.mKU, dimensionPixelSize, max);
        b(this.mKX, dimensionPixelSize, max);
        b(this.mLa, dimensionPixelSize, max);
        if (length == 1) {
            this.mKU.startLoad(dVarArr[0].pic, 30, false);
            this.mKU.setVisibility(0);
            a(this.mKU, dVarArr[0].mJG);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.mKV.setVisibility(8);
            } else {
                this.mKV.setVisibility(0);
                this.mKV.setText(dVarArr[0].desc);
            }
            a(this.mKT, 4);
        } else if (length == 2) {
            this.mKU.startLoad(dVarArr[0].pic, 30, false);
            this.mKU.setVisibility(0);
            this.mKX.setVisibility(0);
            a(this.mKU, dVarArr[0].mJG);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.mKV.setVisibility(8);
            } else {
                this.mKV.setVisibility(0);
                this.mKV.setText(dVarArr[0].desc);
            }
            this.mKX.startLoad(dVarArr[1].pic, 30, false);
            a(this.mKX, dVarArr[1].mJG);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.mKY.setVisibility(8);
            } else {
                this.mKY.setVisibility(0);
                this.mKY.setText(dVarArr[1].desc);
            }
            a(this.mKW, 3);
        } else if (length >= 3) {
            this.mKU.startLoad(dVarArr[0].pic, 30, false);
            this.mKU.setVisibility(0);
            this.mKX.setVisibility(0);
            this.mLa.setVisibility(0);
            a(this.mKU, dVarArr[0].mJG);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.mKV.setVisibility(8);
            } else {
                this.mKV.setVisibility(0);
                this.mKV.setText(dVarArr[0].desc);
            }
            this.mKX.startLoad(dVarArr[1].pic, 30, false);
            a(this.mKX, dVarArr[1].mJG);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.mKY.setVisibility(8);
            } else {
                this.mKY.setVisibility(0);
                this.mKY.setText(dVarArr[1].desc);
            }
            this.mLa.startLoad(dVarArr[2].pic, 30, false);
            a(this.mLa, dVarArr[2].mJG);
            if (StringUtils.isNull(dVarArr[2].desc, true)) {
                this.mLb.setVisibility(8);
            } else {
                this.mLb.setVisibility(0);
                this.mLb.setText(dVarArr[2].desc);
            }
        }
        AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        if (!StringUtils.isNull(adCard.adSource, true)) {
            this.mLd.setText(adCard.adSource);
            this.mLc.setVisibility(0);
        } else if (advertAppInfo != null && advertAppInfo.eJr != null && !TextUtils.isEmpty(advertAppInfo.eJr.adSource)) {
            this.mLd.setText(advertAppInfo.eJr.adSource);
            this.mLc.setVisibility(0);
        } else {
            this.mLc.setVisibility(8);
        }
        this.mJT.setVisibility(0);
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
                xfremodeRoundLayout.setRoundLayoutRadius(new float[]{this.mLg, this.mLg, this.mLh, this.mLh, this.mLh, this.mLh, this.mLg, this.mLg});
                return;
            case 2:
                xfremodeRoundLayout.setRoundLayoutRadius(new float[]{this.mLh, this.mLh, this.mLh, this.mLh, this.mLh, this.mLh, this.mLh, this.mLh});
                return;
            case 3:
                xfremodeRoundLayout.setRoundLayoutRadius(new float[]{this.mLh, this.mLh, this.mLg, this.mLg, this.mLg, this.mLg, this.mLh, this.mLh});
                return;
            default:
                xfremodeRoundLayout.setRoundLayoutRadius(new float[]{this.mLg, this.mLg, this.mLg, this.mLg, this.mLg, this.mLg, this.mLg, this.mLg});
                return;
        }
    }
}
