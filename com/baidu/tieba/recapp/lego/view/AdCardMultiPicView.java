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
    protected TbImageView mPA;
    protected TextView mPB;
    protected XfremodeRoundLayout mPC;
    protected TbImageView mPD;
    protected TextView mPE;
    protected XfremodeRoundLayout mPF;
    protected TbImageView mPG;
    protected TextView mPH;
    protected View mPI;
    protected TextView mPJ;
    private final float mPK;
    private final float mPL;
    private float mPM;
    private float mPN;
    private final int mPO;
    private final int mPP;
    private final int mPQ;
    private final int mPR;
    protected XfremodeRoundLayout mPz;

    public AdCardMultiPicView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mPK = 1.0f;
        this.mPL = 0.0f;
        this.mPN = 0.0f;
        this.mPO = 1;
        this.mPP = 2;
        this.mPQ = 3;
        this.mPR = 4;
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
        this.mPz = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_left);
        this.mPA = (TbImageView) view.findViewById(R.id.advert_app_img_left);
        this.mPB = (TextView) view.findViewById(R.id.txt_left);
        this.mPC = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_center);
        this.mPD = (TbImageView) view.findViewById(R.id.advert_app_img_center);
        this.mPE = (TextView) view.findViewById(R.id.txt_center);
        this.mPF = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_right);
        this.mPG = (TbImageView) view.findViewById(R.id.advert_app_img_right);
        this.mPH = (TextView) view.findViewById(R.id.txt_right);
        this.mPJ = (TextView) view.findViewById(R.id.advert_source_right);
        this.mPM = Jg(R.string.J_X05);
        this.mPA.setPlaceHolder(2);
        this.mPD.setPlaceHolder(2);
        this.mPG.setPlaceHolder(2);
        this.mPI = view.findViewById(R.id.channel_ad_right);
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
            this.mOx.setVisibility(8);
            return;
        }
        this.mPB.setVisibility(8);
        this.mPA.setVisibility(4);
        this.mPE.setVisibility(8);
        this.mPD.setVisibility(4);
        this.mPH.setVisibility(8);
        this.mPG.setVisibility(4);
        a(this.mPz, 1);
        a(this.mPC, 2);
        a(this.mPF, 3);
        b(this.mPA, dimensionPixelSize, max);
        b(this.mPD, dimensionPixelSize, max);
        b(this.mPG, dimensionPixelSize, max);
        if (length == 1) {
            this.mPA.startLoad(dVarArr[0].pic, 30, false);
            this.mPA.setVisibility(0);
            a(this.mPA, dVarArr[0].mOk);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.mPB.setVisibility(8);
            } else {
                this.mPB.setVisibility(0);
                this.mPB.setText(dVarArr[0].desc);
            }
            a(this.mPz, 4);
        } else if (length == 2) {
            this.mPA.startLoad(dVarArr[0].pic, 30, false);
            this.mPA.setVisibility(0);
            this.mPD.setVisibility(0);
            a(this.mPA, dVarArr[0].mOk);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.mPB.setVisibility(8);
            } else {
                this.mPB.setVisibility(0);
                this.mPB.setText(dVarArr[0].desc);
            }
            this.mPD.startLoad(dVarArr[1].pic, 30, false);
            a(this.mPD, dVarArr[1].mOk);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.mPE.setVisibility(8);
            } else {
                this.mPE.setVisibility(0);
                this.mPE.setText(dVarArr[1].desc);
            }
            a(this.mPC, 3);
        } else if (length >= 3) {
            this.mPA.startLoad(dVarArr[0].pic, 30, false);
            this.mPA.setVisibility(0);
            this.mPD.setVisibility(0);
            this.mPG.setVisibility(0);
            a(this.mPA, dVarArr[0].mOk);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.mPB.setVisibility(8);
            } else {
                this.mPB.setVisibility(0);
                this.mPB.setText(dVarArr[0].desc);
            }
            this.mPD.startLoad(dVarArr[1].pic, 30, false);
            a(this.mPD, dVarArr[1].mOk);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.mPE.setVisibility(8);
            } else {
                this.mPE.setVisibility(0);
                this.mPE.setText(dVarArr[1].desc);
            }
            this.mPG.startLoad(dVarArr[2].pic, 30, false);
            a(this.mPG, dVarArr[2].mOk);
            if (StringUtils.isNull(dVarArr[2].desc, true)) {
                this.mPH.setVisibility(8);
            } else {
                this.mPH.setVisibility(0);
                this.mPH.setText(dVarArr[2].desc);
            }
        }
        AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        if (!StringUtils.isNull(adCard.adSource, true)) {
            this.mPJ.setText(adCard.adSource);
            this.mPI.setVisibility(0);
        } else if (advertAppInfo != null && advertAppInfo.eOc != null && !TextUtils.isEmpty(advertAppInfo.eOc.adSource)) {
            this.mPJ.setText(advertAppInfo.eOc.adSource);
            this.mPI.setVisibility(0);
        } else {
            this.mPI.setVisibility(8);
        }
        this.mOx.setVisibility(0);
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
                xfremodeRoundLayout.setRoundLayoutRadius(new float[]{this.mPM, this.mPM, this.mPN, this.mPN, this.mPN, this.mPN, this.mPM, this.mPM});
                return;
            case 2:
                xfremodeRoundLayout.setRoundLayoutRadius(new float[]{this.mPN, this.mPN, this.mPN, this.mPN, this.mPN, this.mPN, this.mPN, this.mPN});
                return;
            case 3:
                xfremodeRoundLayout.setRoundLayoutRadius(new float[]{this.mPN, this.mPN, this.mPM, this.mPM, this.mPM, this.mPM, this.mPN, this.mPN});
                return;
            default:
                xfremodeRoundLayout.setRoundLayoutRadius(new float[]{this.mPM, this.mPM, this.mPM, this.mPM, this.mPM, this.mPM, this.mPM, this.mPM});
                return;
        }
    }
}
