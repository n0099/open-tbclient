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
    protected XfremodeRoundLayout mPA;
    protected TbImageView mPB;
    protected TextView mPC;
    protected XfremodeRoundLayout mPD;
    protected TbImageView mPE;
    protected TextView mPF;
    protected XfremodeRoundLayout mPG;
    protected TbImageView mPH;
    protected TextView mPI;
    protected View mPJ;
    protected TextView mPK;
    private final float mPL;
    private final float mPM;
    private float mPN;
    private float mPO;
    private final int mPP;
    private final int mPQ;
    private final int mPR;
    private final int mPS;

    public AdCardMultiPicView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mPL = 1.0f;
        this.mPM = 0.0f;
        this.mPO = 0.0f;
        this.mPP = 1;
        this.mPQ = 2;
        this.mPR = 3;
        this.mPS = 4;
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
        this.mPA = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_left);
        this.mPB = (TbImageView) view.findViewById(R.id.advert_app_img_left);
        this.mPC = (TextView) view.findViewById(R.id.txt_left);
        this.mPD = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_center);
        this.mPE = (TbImageView) view.findViewById(R.id.advert_app_img_center);
        this.mPF = (TextView) view.findViewById(R.id.txt_center);
        this.mPG = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_right);
        this.mPH = (TbImageView) view.findViewById(R.id.advert_app_img_right);
        this.mPI = (TextView) view.findViewById(R.id.txt_right);
        this.mPK = (TextView) view.findViewById(R.id.advert_source_right);
        this.mPN = Jg(R.string.J_X05);
        this.mPB.setPlaceHolder(2);
        this.mPE.setPlaceHolder(2);
        this.mPH.setPlaceHolder(2);
        this.mPJ = view.findViewById(R.id.channel_ad_right);
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
            this.mOy.setVisibility(8);
            return;
        }
        this.mPC.setVisibility(8);
        this.mPB.setVisibility(4);
        this.mPF.setVisibility(8);
        this.mPE.setVisibility(4);
        this.mPI.setVisibility(8);
        this.mPH.setVisibility(4);
        a(this.mPA, 1);
        a(this.mPD, 2);
        a(this.mPG, 3);
        b(this.mPB, dimensionPixelSize, max);
        b(this.mPE, dimensionPixelSize, max);
        b(this.mPH, dimensionPixelSize, max);
        if (length == 1) {
            this.mPB.startLoad(dVarArr[0].pic, 30, false);
            this.mPB.setVisibility(0);
            a(this.mPB, dVarArr[0].mOl);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.mPC.setVisibility(8);
            } else {
                this.mPC.setVisibility(0);
                this.mPC.setText(dVarArr[0].desc);
            }
            a(this.mPA, 4);
        } else if (length == 2) {
            this.mPB.startLoad(dVarArr[0].pic, 30, false);
            this.mPB.setVisibility(0);
            this.mPE.setVisibility(0);
            a(this.mPB, dVarArr[0].mOl);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.mPC.setVisibility(8);
            } else {
                this.mPC.setVisibility(0);
                this.mPC.setText(dVarArr[0].desc);
            }
            this.mPE.startLoad(dVarArr[1].pic, 30, false);
            a(this.mPE, dVarArr[1].mOl);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.mPF.setVisibility(8);
            } else {
                this.mPF.setVisibility(0);
                this.mPF.setText(dVarArr[1].desc);
            }
            a(this.mPD, 3);
        } else if (length >= 3) {
            this.mPB.startLoad(dVarArr[0].pic, 30, false);
            this.mPB.setVisibility(0);
            this.mPE.setVisibility(0);
            this.mPH.setVisibility(0);
            a(this.mPB, dVarArr[0].mOl);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.mPC.setVisibility(8);
            } else {
                this.mPC.setVisibility(0);
                this.mPC.setText(dVarArr[0].desc);
            }
            this.mPE.startLoad(dVarArr[1].pic, 30, false);
            a(this.mPE, dVarArr[1].mOl);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.mPF.setVisibility(8);
            } else {
                this.mPF.setVisibility(0);
                this.mPF.setText(dVarArr[1].desc);
            }
            this.mPH.startLoad(dVarArr[2].pic, 30, false);
            a(this.mPH, dVarArr[2].mOl);
            if (StringUtils.isNull(dVarArr[2].desc, true)) {
                this.mPI.setVisibility(8);
            } else {
                this.mPI.setVisibility(0);
                this.mPI.setText(dVarArr[2].desc);
            }
        }
        AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        if (!StringUtils.isNull(adCard.adSource, true)) {
            this.mPK.setText(adCard.adSource);
            this.mPJ.setVisibility(0);
        } else if (advertAppInfo != null && advertAppInfo.eOc != null && !TextUtils.isEmpty(advertAppInfo.eOc.adSource)) {
            this.mPK.setText(advertAppInfo.eOc.adSource);
            this.mPJ.setVisibility(0);
        } else {
            this.mPJ.setVisibility(8);
        }
        this.mOy.setVisibility(0);
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
                xfremodeRoundLayout.setRoundLayoutRadius(new float[]{this.mPN, this.mPN, this.mPO, this.mPO, this.mPO, this.mPO, this.mPN, this.mPN});
                return;
            case 2:
                xfremodeRoundLayout.setRoundLayoutRadius(new float[]{this.mPO, this.mPO, this.mPO, this.mPO, this.mPO, this.mPO, this.mPO, this.mPO});
                return;
            case 3:
                xfremodeRoundLayout.setRoundLayoutRadius(new float[]{this.mPO, this.mPO, this.mPN, this.mPN, this.mPN, this.mPN, this.mPO, this.mPO});
                return;
            default:
                xfremodeRoundLayout.setRoundLayoutRadius(new float[]{this.mPN, this.mPN, this.mPN, this.mPN, this.mPN, this.mPN, this.mPN, this.mPN});
                return;
        }
    }
}
