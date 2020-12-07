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
    private final float mKA;
    private final float mKB;
    private float mKC;
    private float mKD;
    private final int mKE;
    private final int mKF;
    private final int mKG;
    private final int mKH;
    protected XfremodeRoundLayout mKp;
    protected TbImageView mKq;
    protected TextView mKr;
    protected XfremodeRoundLayout mKs;
    protected TbImageView mKt;
    protected TextView mKu;
    protected XfremodeRoundLayout mKv;
    protected TbImageView mKw;
    protected TextView mKx;
    protected View mKy;
    protected TextView mKz;

    public AdCardMultiPicView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mKA = 1.0f;
        this.mKB = 0.0f;
        this.mKD = 0.0f;
        this.mKE = 1;
        this.mKF = 2;
        this.mKG = 3;
        this.mKH = 4;
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
        this.mKp = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_left);
        this.mKq = (TbImageView) view.findViewById(R.id.advert_app_img_left);
        this.mKr = (TextView) view.findViewById(R.id.txt_left);
        this.mKs = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_center);
        this.mKt = (TbImageView) view.findViewById(R.id.advert_app_img_center);
        this.mKu = (TextView) view.findViewById(R.id.txt_center);
        this.mKv = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_right);
        this.mKw = (TbImageView) view.findViewById(R.id.advert_app_img_right);
        this.mKx = (TextView) view.findViewById(R.id.txt_right);
        this.mKz = (TextView) view.findViewById(R.id.advert_source_right);
        this.mKC = Jm(R.string.J_X05);
        this.mKq.setPlaceHolder(2);
        this.mKt.setPlaceHolder(2);
        this.mKw.setPlaceHolder(2);
        this.mKy = view.findViewById(R.id.channel_ad_right);
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
            this.mJp.setVisibility(8);
            return;
        }
        this.mKr.setVisibility(8);
        this.mKq.setVisibility(4);
        this.mKu.setVisibility(8);
        this.mKt.setVisibility(4);
        this.mKx.setVisibility(8);
        this.mKw.setVisibility(4);
        a(this.mKp, 1);
        a(this.mKs, 2);
        a(this.mKv, 3);
        b(this.mKq, dimensionPixelSize, max);
        b(this.mKt, dimensionPixelSize, max);
        b(this.mKw, dimensionPixelSize, max);
        if (length == 1) {
            this.mKq.startLoad(dVarArr[0].pic, 30, false);
            this.mKq.setVisibility(0);
            a(this.mKq, dVarArr[0].mJb);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.mKr.setVisibility(8);
            } else {
                this.mKr.setVisibility(0);
                this.mKr.setText(dVarArr[0].desc);
            }
            a(this.mKp, 4);
        } else if (length == 2) {
            this.mKq.startLoad(dVarArr[0].pic, 30, false);
            this.mKq.setVisibility(0);
            this.mKt.setVisibility(0);
            a(this.mKq, dVarArr[0].mJb);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.mKr.setVisibility(8);
            } else {
                this.mKr.setVisibility(0);
                this.mKr.setText(dVarArr[0].desc);
            }
            this.mKt.startLoad(dVarArr[1].pic, 30, false);
            a(this.mKt, dVarArr[1].mJb);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.mKu.setVisibility(8);
            } else {
                this.mKu.setVisibility(0);
                this.mKu.setText(dVarArr[1].desc);
            }
            a(this.mKs, 3);
        } else if (length >= 3) {
            this.mKq.startLoad(dVarArr[0].pic, 30, false);
            this.mKq.setVisibility(0);
            this.mKt.setVisibility(0);
            this.mKw.setVisibility(0);
            a(this.mKq, dVarArr[0].mJb);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.mKr.setVisibility(8);
            } else {
                this.mKr.setVisibility(0);
                this.mKr.setText(dVarArr[0].desc);
            }
            this.mKt.startLoad(dVarArr[1].pic, 30, false);
            a(this.mKt, dVarArr[1].mJb);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.mKu.setVisibility(8);
            } else {
                this.mKu.setVisibility(0);
                this.mKu.setText(dVarArr[1].desc);
            }
            this.mKw.startLoad(dVarArr[2].pic, 30, false);
            a(this.mKw, dVarArr[2].mJb);
            if (StringUtils.isNull(dVarArr[2].desc, true)) {
                this.mKx.setVisibility(8);
            } else {
                this.mKx.setVisibility(0);
                this.mKx.setText(dVarArr[2].desc);
            }
        }
        AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        if (!StringUtils.isNull(adCard.adSource, true)) {
            this.mKz.setText(adCard.adSource);
            this.mKy.setVisibility(0);
        } else if (advertAppInfo != null && advertAppInfo.eEm != null && !TextUtils.isEmpty(advertAppInfo.eEm.adSource)) {
            this.mKz.setText(advertAppInfo.eEm.adSource);
            this.mKy.setVisibility(0);
        } else {
            this.mKy.setVisibility(8);
        }
        this.mJp.setVisibility(0);
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
                xfremodeRoundLayout.setRoundLayoutRadius(new float[]{this.mKC, this.mKC, this.mKD, this.mKD, this.mKD, this.mKD, this.mKC, this.mKC});
                return;
            case 2:
                xfremodeRoundLayout.setRoundLayoutRadius(new float[]{this.mKD, this.mKD, this.mKD, this.mKD, this.mKD, this.mKD, this.mKD, this.mKD});
                return;
            case 3:
                xfremodeRoundLayout.setRoundLayoutRadius(new float[]{this.mKD, this.mKD, this.mKC, this.mKC, this.mKC, this.mKC, this.mKD, this.mKD});
                return;
            default:
                xfremodeRoundLayout.setRoundLayoutRadius(new float[]{this.mKC, this.mKC, this.mKC, this.mKC, this.mKC, this.mKC, this.mKC, this.mKC});
                return;
        }
    }
}
