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
    protected XfremodeRoundLayout jIB;
    protected TbImageView jIC;
    protected TextView jID;
    protected XfremodeRoundLayout jIE;
    protected TbImageView jIF;
    protected TextView jIG;
    protected XfremodeRoundLayout jIH;
    protected TbImageView jII;
    protected TextView jIJ;
    protected View jIK;
    protected TextView jIL;

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
        this.jIB = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_left);
        this.jIC = (TbImageView) view.findViewById(R.id.advert_app_img_left);
        this.jID = (TextView) view.findViewById(R.id.txt_left);
        this.jIE = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_center);
        this.jIF = (TbImageView) view.findViewById(R.id.advert_app_img_center);
        this.jIG = (TextView) view.findViewById(R.id.txt_center);
        this.jIH = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_right);
        this.jII = (TbImageView) view.findViewById(R.id.advert_app_img_right);
        this.jIJ = (TextView) view.findViewById(R.id.txt_right);
        this.jIL = (TextView) view.findViewById(R.id.advert_source_right);
        float dimensionPixelSize = this.cVg.getResources().getDimensionPixelSize(R.dimen.tbds10);
        this.jIB.setRoundLayoutRadius(new float[]{dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize});
        this.jIE.setRoundLayoutRadius(new float[]{dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize});
        this.jIH.setRoundLayoutRadius(new float[]{dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize});
        this.jIC.setPlaceHolder(2);
        this.jIF.setPlaceHolder(2);
        this.jII.setPlaceHolder(2);
        this.jIK = view.findViewById(R.id.channel_ad_right);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void a(AdCard adCard) {
        AdCard.d[] dVarArr = adCard.threadPicList;
        int length = dVarArr != null ? dVarArr.length : 0;
        int dimensionPixelSize = (int) ((this.mMaxWidth - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10) * 2)) / 3.0f);
        if (length <= 0) {
            this.jHD.setVisibility(8);
            return;
        }
        this.jID.setVisibility(8);
        this.jIC.setVisibility(8);
        this.jIG.setVisibility(8);
        this.jIF.setVisibility(8);
        this.jIJ.setVisibility(8);
        this.jII.setVisibility(8);
        a(this.jIC, dimensionPixelSize, dimensionPixelSize);
        a(this.jIF, dimensionPixelSize, dimensionPixelSize);
        a(this.jII, dimensionPixelSize, dimensionPixelSize);
        if (length == 1) {
            this.jIC.startLoad(dVarArr[0].pic, 30, false);
            this.jIC.setVisibility(0);
            a(this.jIC, dVarArr[0].jHo);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.jID.setVisibility(8);
            } else {
                this.jID.setVisibility(0);
                this.jID.setText(dVarArr[0].desc);
            }
        } else if (length == 2) {
            this.jIC.startLoad(dVarArr[0].pic, 30, false);
            this.jIC.setVisibility(0);
            this.jIF.setVisibility(0);
            a(this.jIC, dVarArr[0].jHo);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.jID.setVisibility(8);
            } else {
                this.jID.setVisibility(0);
                this.jID.setText(dVarArr[0].desc);
            }
            this.jIF.startLoad(dVarArr[1].pic, 30, false);
            a(this.jIF, dVarArr[1].jHo);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.jIG.setVisibility(8);
            } else {
                this.jIG.setVisibility(0);
                this.jIG.setText(dVarArr[1].desc);
            }
        } else if (length >= 3) {
            this.jIC.startLoad(dVarArr[0].pic, 30, false);
            this.jIC.setVisibility(0);
            this.jIF.setVisibility(0);
            this.jII.setVisibility(0);
            a(this.jIC, dVarArr[0].jHo);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.jID.setVisibility(8);
            } else {
                this.jID.setVisibility(0);
                this.jID.setText(dVarArr[0].desc);
            }
            this.jIF.startLoad(dVarArr[1].pic, 30, false);
            a(this.jIF, dVarArr[1].jHo);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.jIG.setVisibility(8);
            } else {
                this.jIG.setVisibility(0);
                this.jIG.setText(dVarArr[1].desc);
            }
            this.jII.startLoad(dVarArr[2].pic, 30, false);
            a(this.jII, dVarArr[2].jHo);
            if (StringUtils.isNull(dVarArr[2].desc, true)) {
                this.jIJ.setVisibility(8);
            } else {
                this.jIJ.setVisibility(0);
                this.jIJ.setText(dVarArr[2].desc);
            }
        }
        AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        if (!StringUtils.isNull(adCard.adSource, true)) {
            this.jIL.setText(adCard.adSource);
            this.jIK.setVisibility(0);
        } else if (advertAppInfo != null && advertAppInfo.cNe != null && !TextUtils.isEmpty(advertAppInfo.cNe.adSource)) {
            this.jIL.setText(advertAppInfo.cNe.adSource);
            this.jIK.setVisibility(0);
        } else {
            this.jIK.setVisibility(8);
        }
        this.jHD.setVisibility(0);
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
