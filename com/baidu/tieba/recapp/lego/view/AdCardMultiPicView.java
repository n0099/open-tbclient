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
    protected XfremodeRoundLayout kuf;
    protected TbImageView kug;
    protected TextView kuh;
    protected XfremodeRoundLayout kui;
    protected TbImageView kuj;
    protected TextView kuk;
    protected XfremodeRoundLayout kul;
    protected TbImageView kum;
    protected TextView kun;
    protected View kuo;
    protected TextView kup;

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
    protected void cW(View view) {
        this.kuf = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_left);
        this.kug = (TbImageView) view.findViewById(R.id.advert_app_img_left);
        this.kuh = (TextView) view.findViewById(R.id.txt_left);
        this.kui = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_center);
        this.kuj = (TbImageView) view.findViewById(R.id.advert_app_img_center);
        this.kuk = (TextView) view.findViewById(R.id.txt_center);
        this.kul = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_right);
        this.kum = (TbImageView) view.findViewById(R.id.advert_app_img_right);
        this.kun = (TextView) view.findViewById(R.id.txt_right);
        this.kup = (TextView) view.findViewById(R.id.advert_source_right);
        float dimensionPixelSize = this.duK.getResources().getDimensionPixelSize(R.dimen.tbds10);
        this.kuf.setRoundLayoutRadius(new float[]{dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize});
        this.kui.setRoundLayoutRadius(new float[]{dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize});
        this.kul.setRoundLayoutRadius(new float[]{dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize});
        this.kug.setPlaceHolder(2);
        this.kuj.setPlaceHolder(2);
        this.kum.setPlaceHolder(2);
        this.kuo = view.findViewById(R.id.channel_ad_right);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void a(AdCard adCard) {
        AdCard.d[] dVarArr = adCard.threadPicList;
        int length = dVarArr != null ? dVarArr.length : 0;
        int dimensionPixelSize = (int) ((this.mMaxWidth - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10) * 2)) / 3.0f);
        if (length <= 0) {
            this.ktg.setVisibility(8);
            return;
        }
        this.kuh.setVisibility(8);
        this.kug.setVisibility(8);
        this.kuk.setVisibility(8);
        this.kuj.setVisibility(8);
        this.kun.setVisibility(8);
        this.kum.setVisibility(8);
        a(this.kug, dimensionPixelSize, dimensionPixelSize);
        a(this.kuj, dimensionPixelSize, dimensionPixelSize);
        a(this.kum, dimensionPixelSize, dimensionPixelSize);
        if (length == 1) {
            this.kug.startLoad(dVarArr[0].pic, 30, false);
            this.kug.setVisibility(0);
            a(this.kug, dVarArr[0].ksR);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.kuh.setVisibility(8);
            } else {
                this.kuh.setVisibility(0);
                this.kuh.setText(dVarArr[0].desc);
            }
        } else if (length == 2) {
            this.kug.startLoad(dVarArr[0].pic, 30, false);
            this.kug.setVisibility(0);
            this.kuj.setVisibility(0);
            a(this.kug, dVarArr[0].ksR);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.kuh.setVisibility(8);
            } else {
                this.kuh.setVisibility(0);
                this.kuh.setText(dVarArr[0].desc);
            }
            this.kuj.startLoad(dVarArr[1].pic, 30, false);
            a(this.kuj, dVarArr[1].ksR);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.kuk.setVisibility(8);
            } else {
                this.kuk.setVisibility(0);
                this.kuk.setText(dVarArr[1].desc);
            }
        } else if (length >= 3) {
            this.kug.startLoad(dVarArr[0].pic, 30, false);
            this.kug.setVisibility(0);
            this.kuj.setVisibility(0);
            this.kum.setVisibility(0);
            a(this.kug, dVarArr[0].ksR);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.kuh.setVisibility(8);
            } else {
                this.kuh.setVisibility(0);
                this.kuh.setText(dVarArr[0].desc);
            }
            this.kuj.startLoad(dVarArr[1].pic, 30, false);
            a(this.kuj, dVarArr[1].ksR);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.kuk.setVisibility(8);
            } else {
                this.kuk.setVisibility(0);
                this.kuk.setText(dVarArr[1].desc);
            }
            this.kum.startLoad(dVarArr[2].pic, 30, false);
            a(this.kum, dVarArr[2].ksR);
            if (StringUtils.isNull(dVarArr[2].desc, true)) {
                this.kun.setVisibility(8);
            } else {
                this.kun.setVisibility(0);
                this.kun.setText(dVarArr[2].desc);
            }
        }
        AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        if (!StringUtils.isNull(adCard.adSource, true)) {
            this.kup.setText(adCard.adSource);
            this.kuo.setVisibility(0);
        } else if (advertAppInfo != null && advertAppInfo.dmB != null && !TextUtils.isEmpty(advertAppInfo.dmB.adSource)) {
            this.kup.setText(advertAppInfo.dmB.adSource);
            this.kuo.setVisibility(0);
        } else {
            this.kuo.setVisibility(8);
        }
        this.ktg.setVisibility(0);
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
