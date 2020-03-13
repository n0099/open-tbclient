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
/* loaded from: classes13.dex */
public class AdCardMultiPicView extends AdCardBaseView {
    protected XfremodeRoundLayout jIP;
    protected TbImageView jIQ;
    protected TextView jIR;
    protected XfremodeRoundLayout jIS;
    protected TbImageView jIT;
    protected TextView jIU;
    protected XfremodeRoundLayout jIV;
    protected TbImageView jIW;
    protected TextView jIX;
    protected View jIY;
    protected TextView jIZ;

    public AdCardMultiPicView(TbPageContext tbPageContext) {
        super(tbPageContext);
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
    protected void cO(View view) {
        this.jIP = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_left);
        this.jIQ = (TbImageView) view.findViewById(R.id.advert_app_img_left);
        this.jIR = (TextView) view.findViewById(R.id.txt_left);
        this.jIS = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_center);
        this.jIT = (TbImageView) view.findViewById(R.id.advert_app_img_center);
        this.jIU = (TextView) view.findViewById(R.id.txt_center);
        this.jIV = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_right);
        this.jIW = (TbImageView) view.findViewById(R.id.advert_app_img_right);
        this.jIX = (TextView) view.findViewById(R.id.txt_right);
        this.jIZ = (TextView) view.findViewById(R.id.advert_source_right);
        float dimensionPixelSize = this.cVi.getResources().getDimensionPixelSize(R.dimen.tbds10);
        this.jIP.setRoundLayoutRadius(new float[]{dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize});
        this.jIS.setRoundLayoutRadius(new float[]{dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize});
        this.jIV.setRoundLayoutRadius(new float[]{dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize});
        this.jIQ.setPlaceHolder(2);
        this.jIT.setPlaceHolder(2);
        this.jIW.setPlaceHolder(2);
        this.jIY = view.findViewById(R.id.channel_ad_right);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void a(AdCard adCard) {
        AdCard.d[] dVarArr = adCard.threadPicList;
        int length = dVarArr != null ? dVarArr.length : 0;
        int dimensionPixelSize = (int) ((this.mMaxWidth - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10) * 2)) / 3.0f);
        if (length <= 0) {
            this.jHR.setVisibility(8);
            return;
        }
        this.jIR.setVisibility(8);
        this.jIQ.setVisibility(8);
        this.jIU.setVisibility(8);
        this.jIT.setVisibility(8);
        this.jIX.setVisibility(8);
        this.jIW.setVisibility(8);
        a(this.jIQ, dimensionPixelSize, dimensionPixelSize);
        a(this.jIT, dimensionPixelSize, dimensionPixelSize);
        a(this.jIW, dimensionPixelSize, dimensionPixelSize);
        if (length == 1) {
            this.jIQ.startLoad(dVarArr[0].pic, 30, false);
            this.jIQ.setVisibility(0);
            a(this.jIQ, dVarArr[0].jHC);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.jIR.setVisibility(8);
            } else {
                this.jIR.setVisibility(0);
                this.jIR.setText(dVarArr[0].desc);
            }
        } else if (length == 2) {
            this.jIQ.startLoad(dVarArr[0].pic, 30, false);
            this.jIQ.setVisibility(0);
            this.jIT.setVisibility(0);
            a(this.jIQ, dVarArr[0].jHC);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.jIR.setVisibility(8);
            } else {
                this.jIR.setVisibility(0);
                this.jIR.setText(dVarArr[0].desc);
            }
            this.jIT.startLoad(dVarArr[1].pic, 30, false);
            a(this.jIT, dVarArr[1].jHC);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.jIU.setVisibility(8);
            } else {
                this.jIU.setVisibility(0);
                this.jIU.setText(dVarArr[1].desc);
            }
        } else if (length >= 3) {
            this.jIQ.startLoad(dVarArr[0].pic, 30, false);
            this.jIQ.setVisibility(0);
            this.jIT.setVisibility(0);
            this.jIW.setVisibility(0);
            a(this.jIQ, dVarArr[0].jHC);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.jIR.setVisibility(8);
            } else {
                this.jIR.setVisibility(0);
                this.jIR.setText(dVarArr[0].desc);
            }
            this.jIT.startLoad(dVarArr[1].pic, 30, false);
            a(this.jIT, dVarArr[1].jHC);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.jIU.setVisibility(8);
            } else {
                this.jIU.setVisibility(0);
                this.jIU.setText(dVarArr[1].desc);
            }
            this.jIW.startLoad(dVarArr[2].pic, 30, false);
            a(this.jIW, dVarArr[2].jHC);
            if (StringUtils.isNull(dVarArr[2].desc, true)) {
                this.jIX.setVisibility(8);
            } else {
                this.jIX.setVisibility(0);
                this.jIX.setText(dVarArr[2].desc);
            }
        }
        AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        if (!StringUtils.isNull(adCard.adSource, true)) {
            this.jIZ.setText(adCard.adSource);
            this.jIY.setVisibility(0);
        } else if (advertAppInfo != null && advertAppInfo.cNg != null && !TextUtils.isEmpty(advertAppInfo.cNg.adSource)) {
            this.jIZ.setText(advertAppInfo.cNg.adSource);
            this.jIY.setVisibility(0);
        } else {
            this.jIY.setVisibility(8);
        }
        this.jHR.setVisibility(0);
    }

    private void a(TbImageView tbImageView, int i, int i2) {
        if (tbImageView != null) {
            ViewGroup.LayoutParams layoutParams = tbImageView.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.width = i;
            tbImageView.setLayoutParams(layoutParams);
        }
    }
}
