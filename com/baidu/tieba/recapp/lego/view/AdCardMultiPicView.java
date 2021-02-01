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
/* loaded from: classes8.dex */
public class AdCardMultiPicView extends AdCardBaseView {
    protected XfremodeRoundLayout mUg;
    protected TbImageView mUh;
    protected TextView mUi;
    protected XfremodeRoundLayout mUj;
    protected TbImageView mUl;
    protected TextView mUm;
    protected XfremodeRoundLayout mUn;
    protected TbImageView mUo;
    protected TextView mUp;
    protected View mUq;
    protected TextView mUr;
    private final float mUs;
    private final float mUt;
    private float mUu;
    private float mUv;
    private final int mUw;
    private final int mUx;
    private final int mUy;
    private final int mUz;

    public AdCardMultiPicView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mUs = 1.0f;
        this.mUt = 0.0f;
        this.mUv = 0.0f;
        this.mUw = 1;
        this.mUx = 2;
        this.mUy = 3;
        this.mUz = 4;
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
        this.mUg = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_left);
        this.mUh = (TbImageView) view.findViewById(R.id.advert_app_img_left);
        this.mUi = (TextView) view.findViewById(R.id.txt_left);
        this.mUj = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_center);
        this.mUl = (TbImageView) view.findViewById(R.id.advert_app_img_center);
        this.mUm = (TextView) view.findViewById(R.id.txt_center);
        this.mUn = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_right);
        this.mUo = (TbImageView) view.findViewById(R.id.advert_app_img_right);
        this.mUp = (TextView) view.findViewById(R.id.txt_right);
        this.mUr = (TextView) view.findViewById(R.id.advert_source_right);
        this.mUu = HS(R.string.J_X05);
        this.mUh.setPlaceHolder(2);
        this.mUl.setPlaceHolder(2);
        this.mUo.setPlaceHolder(2);
        this.mUq = view.findViewById(R.id.channel_ad_right);
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
            this.mTc.setVisibility(8);
            return;
        }
        this.mUi.setVisibility(8);
        this.mUh.setVisibility(4);
        this.mUm.setVisibility(8);
        this.mUl.setVisibility(4);
        this.mUp.setVisibility(8);
        this.mUo.setVisibility(4);
        a(this.mUg, 1);
        a(this.mUj, 2);
        a(this.mUn, 3);
        b(this.mUh, dimensionPixelSize, max);
        b(this.mUl, dimensionPixelSize, max);
        b(this.mUo, dimensionPixelSize, max);
        if (length == 1) {
            this.mUh.startLoad(dVarArr[0].pic, 30, false);
            this.mUh.setVisibility(0);
            a(this.mUh, dVarArr[0].mSO);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.mUi.setVisibility(8);
            } else {
                this.mUi.setVisibility(0);
                this.mUi.setText(dVarArr[0].desc);
            }
            a(this.mUg, 4);
        } else if (length == 2) {
            this.mUh.startLoad(dVarArr[0].pic, 30, false);
            this.mUh.setVisibility(0);
            this.mUl.setVisibility(0);
            a(this.mUh, dVarArr[0].mSO);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.mUi.setVisibility(8);
            } else {
                this.mUi.setVisibility(0);
                this.mUi.setText(dVarArr[0].desc);
            }
            this.mUl.startLoad(dVarArr[1].pic, 30, false);
            a(this.mUl, dVarArr[1].mSO);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.mUm.setVisibility(8);
            } else {
                this.mUm.setVisibility(0);
                this.mUm.setText(dVarArr[1].desc);
            }
            a(this.mUj, 3);
        } else if (length >= 3) {
            this.mUh.startLoad(dVarArr[0].pic, 30, false);
            this.mUh.setVisibility(0);
            this.mUl.setVisibility(0);
            this.mUo.setVisibility(0);
            a(this.mUh, dVarArr[0].mSO);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.mUi.setVisibility(8);
            } else {
                this.mUi.setVisibility(0);
                this.mUi.setText(dVarArr[0].desc);
            }
            this.mUl.startLoad(dVarArr[1].pic, 30, false);
            a(this.mUl, dVarArr[1].mSO);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.mUm.setVisibility(8);
            } else {
                this.mUm.setVisibility(0);
                this.mUm.setText(dVarArr[1].desc);
            }
            this.mUo.startLoad(dVarArr[2].pic, 30, false);
            a(this.mUo, dVarArr[2].mSO);
            if (StringUtils.isNull(dVarArr[2].desc, true)) {
                this.mUp.setVisibility(8);
            } else {
                this.mUp.setVisibility(0);
                this.mUp.setText(dVarArr[2].desc);
            }
        }
        AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        if (!StringUtils.isNull(adCard.adSource, true)) {
            this.mUr.setText(adCard.adSource);
            this.mUq.setVisibility(0);
        } else if (advertAppInfo != null && advertAppInfo.eLD != null && !TextUtils.isEmpty(advertAppInfo.eLD.adSource)) {
            this.mUr.setText(advertAppInfo.eLD.adSource);
            this.mUq.setVisibility(0);
        } else {
            this.mUq.setVisibility(8);
        }
        this.mTc.setVisibility(0);
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
                xfremodeRoundLayout.setRoundLayoutRadius(new float[]{this.mUu, this.mUu, this.mUv, this.mUv, this.mUv, this.mUv, this.mUu, this.mUu});
                return;
            case 2:
                xfremodeRoundLayout.setRoundLayoutRadius(new float[]{this.mUv, this.mUv, this.mUv, this.mUv, this.mUv, this.mUv, this.mUv, this.mUv});
                return;
            case 3:
                xfremodeRoundLayout.setRoundLayoutRadius(new float[]{this.mUv, this.mUv, this.mUu, this.mUu, this.mUu, this.mUu, this.mUv, this.mUv});
                return;
            default:
                xfremodeRoundLayout.setRoundLayoutRadius(new float[]{this.mUu, this.mUu, this.mUu, this.mUu, this.mUu, this.mUu, this.mUu, this.mUu});
                return;
        }
    }
}
