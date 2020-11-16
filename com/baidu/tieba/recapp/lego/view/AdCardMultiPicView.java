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
/* loaded from: classes25.dex */
public class AdCardMultiPicView extends AdCardBaseView {
    protected XfremodeRoundLayout mwd;
    protected TbImageView mwe;
    protected TextView mwf;
    protected XfremodeRoundLayout mwg;
    protected TbImageView mwh;
    protected TextView mwi;
    protected XfremodeRoundLayout mwj;
    protected TbImageView mwk;
    protected TextView mwl;
    protected View mwm;
    protected TextView mwn;
    private final float mwo;
    private final float mwp;
    private float mwq;
    private float mwr;
    private final int mws;
    private final int mwt;
    private final int mwu;
    private final int mwv;

    public AdCardMultiPicView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mwo = 1.0f;
        this.mwp = 0.0f;
        this.mwr = 0.0f;
        this.mws = 1;
        this.mwt = 2;
        this.mwu = 3;
        this.mwv = 4;
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
    protected void dH(View view) {
        this.mwd = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_left);
        this.mwe = (TbImageView) view.findViewById(R.id.advert_app_img_left);
        this.mwf = (TextView) view.findViewById(R.id.txt_left);
        this.mwg = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_center);
        this.mwh = (TbImageView) view.findViewById(R.id.advert_app_img_center);
        this.mwi = (TextView) view.findViewById(R.id.txt_center);
        this.mwj = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_right);
        this.mwk = (TbImageView) view.findViewById(R.id.advert_app_img_right);
        this.mwl = (TextView) view.findViewById(R.id.txt_right);
        this.mwn = (TextView) view.findViewById(R.id.advert_source_right);
        this.mwq = Iv(R.string.J_X05);
        this.mwe.setPlaceHolder(2);
        this.mwh.setPlaceHolder(2);
        this.mwk.setPlaceHolder(2);
        this.mwm = view.findViewById(R.id.channel_ad_right);
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
            this.mvd.setVisibility(8);
            return;
        }
        this.mwf.setVisibility(8);
        this.mwe.setVisibility(4);
        this.mwi.setVisibility(8);
        this.mwh.setVisibility(4);
        this.mwl.setVisibility(8);
        this.mwk.setVisibility(4);
        a(this.mwd, 1);
        a(this.mwg, 2);
        a(this.mwj, 3);
        b(this.mwe, dimensionPixelSize, max);
        b(this.mwh, dimensionPixelSize, max);
        b(this.mwk, dimensionPixelSize, max);
        if (length == 1) {
            this.mwe.startLoad(dVarArr[0].pic, 30, false);
            this.mwe.setVisibility(0);
            a(this.mwe, dVarArr[0].muP);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.mwf.setVisibility(8);
            } else {
                this.mwf.setVisibility(0);
                this.mwf.setText(dVarArr[0].desc);
            }
            a(this.mwd, 4);
        } else if (length == 2) {
            this.mwe.startLoad(dVarArr[0].pic, 30, false);
            this.mwe.setVisibility(0);
            this.mwh.setVisibility(0);
            a(this.mwe, dVarArr[0].muP);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.mwf.setVisibility(8);
            } else {
                this.mwf.setVisibility(0);
                this.mwf.setText(dVarArr[0].desc);
            }
            this.mwh.startLoad(dVarArr[1].pic, 30, false);
            a(this.mwh, dVarArr[1].muP);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.mwi.setVisibility(8);
            } else {
                this.mwi.setVisibility(0);
                this.mwi.setText(dVarArr[1].desc);
            }
            a(this.mwg, 3);
        } else if (length >= 3) {
            this.mwe.startLoad(dVarArr[0].pic, 30, false);
            this.mwe.setVisibility(0);
            this.mwh.setVisibility(0);
            this.mwk.setVisibility(0);
            a(this.mwe, dVarArr[0].muP);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.mwf.setVisibility(8);
            } else {
                this.mwf.setVisibility(0);
                this.mwf.setText(dVarArr[0].desc);
            }
            this.mwh.startLoad(dVarArr[1].pic, 30, false);
            a(this.mwh, dVarArr[1].muP);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.mwi.setVisibility(8);
            } else {
                this.mwi.setVisibility(0);
                this.mwi.setText(dVarArr[1].desc);
            }
            this.mwk.startLoad(dVarArr[2].pic, 30, false);
            a(this.mwk, dVarArr[2].muP);
            if (StringUtils.isNull(dVarArr[2].desc, true)) {
                this.mwl.setVisibility(8);
            } else {
                this.mwl.setVisibility(0);
                this.mwl.setText(dVarArr[2].desc);
            }
        }
        AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        if (!StringUtils.isNull(adCard.adSource, true)) {
            this.mwn.setText(adCard.adSource);
            this.mwm.setVisibility(0);
        } else if (advertAppInfo != null && advertAppInfo.exl != null && !TextUtils.isEmpty(advertAppInfo.exl.adSource)) {
            this.mwn.setText(advertAppInfo.exl.adSource);
            this.mwm.setVisibility(0);
        } else {
            this.mwm.setVisibility(8);
        }
        this.mvd.setVisibility(0);
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
                xfremodeRoundLayout.setRoundLayoutRadius(new float[]{this.mwq, this.mwq, this.mwr, this.mwr, this.mwr, this.mwr, this.mwq, this.mwq});
                return;
            case 2:
                xfremodeRoundLayout.setRoundLayoutRadius(new float[]{this.mwr, this.mwr, this.mwr, this.mwr, this.mwr, this.mwr, this.mwr, this.mwr});
                return;
            case 3:
                xfremodeRoundLayout.setRoundLayoutRadius(new float[]{this.mwr, this.mwr, this.mwq, this.mwq, this.mwq, this.mwq, this.mwr, this.mwr});
                return;
            default:
                xfremodeRoundLayout.setRoundLayoutRadius(new float[]{this.mwq, this.mwq, this.mwq, this.mwq, this.mwq, this.mwq, this.mwq, this.mwq});
                return;
        }
    }
}
