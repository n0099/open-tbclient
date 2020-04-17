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
    protected XfremodeRoundLayout kub;
    protected TbImageView kuc;
    protected TextView kud;
    protected XfremodeRoundLayout kue;
    protected TbImageView kuf;
    protected TextView kug;
    protected XfremodeRoundLayout kuh;
    protected TbImageView kui;
    protected TextView kuj;
    protected View kuk;
    protected TextView kul;

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
        this.kub = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_left);
        this.kuc = (TbImageView) view.findViewById(R.id.advert_app_img_left);
        this.kud = (TextView) view.findViewById(R.id.txt_left);
        this.kue = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_center);
        this.kuf = (TbImageView) view.findViewById(R.id.advert_app_img_center);
        this.kug = (TextView) view.findViewById(R.id.txt_center);
        this.kuh = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_right);
        this.kui = (TbImageView) view.findViewById(R.id.advert_app_img_right);
        this.kuj = (TextView) view.findViewById(R.id.txt_right);
        this.kul = (TextView) view.findViewById(R.id.advert_source_right);
        float dimensionPixelSize = this.duG.getResources().getDimensionPixelSize(R.dimen.tbds10);
        this.kub.setRoundLayoutRadius(new float[]{dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize});
        this.kue.setRoundLayoutRadius(new float[]{dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize});
        this.kuh.setRoundLayoutRadius(new float[]{dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize});
        this.kuc.setPlaceHolder(2);
        this.kuf.setPlaceHolder(2);
        this.kui.setPlaceHolder(2);
        this.kuk = view.findViewById(R.id.channel_ad_right);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void a(AdCard adCard) {
        AdCard.d[] dVarArr = adCard.threadPicList;
        int length = dVarArr != null ? dVarArr.length : 0;
        int dimensionPixelSize = (int) ((this.mMaxWidth - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10) * 2)) / 3.0f);
        if (length <= 0) {
            this.ktc.setVisibility(8);
            return;
        }
        this.kud.setVisibility(8);
        this.kuc.setVisibility(8);
        this.kug.setVisibility(8);
        this.kuf.setVisibility(8);
        this.kuj.setVisibility(8);
        this.kui.setVisibility(8);
        a(this.kuc, dimensionPixelSize, dimensionPixelSize);
        a(this.kuf, dimensionPixelSize, dimensionPixelSize);
        a(this.kui, dimensionPixelSize, dimensionPixelSize);
        if (length == 1) {
            this.kuc.startLoad(dVarArr[0].pic, 30, false);
            this.kuc.setVisibility(0);
            a(this.kuc, dVarArr[0].ksN);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.kud.setVisibility(8);
            } else {
                this.kud.setVisibility(0);
                this.kud.setText(dVarArr[0].desc);
            }
        } else if (length == 2) {
            this.kuc.startLoad(dVarArr[0].pic, 30, false);
            this.kuc.setVisibility(0);
            this.kuf.setVisibility(0);
            a(this.kuc, dVarArr[0].ksN);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.kud.setVisibility(8);
            } else {
                this.kud.setVisibility(0);
                this.kud.setText(dVarArr[0].desc);
            }
            this.kuf.startLoad(dVarArr[1].pic, 30, false);
            a(this.kuf, dVarArr[1].ksN);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.kug.setVisibility(8);
            } else {
                this.kug.setVisibility(0);
                this.kug.setText(dVarArr[1].desc);
            }
        } else if (length >= 3) {
            this.kuc.startLoad(dVarArr[0].pic, 30, false);
            this.kuc.setVisibility(0);
            this.kuf.setVisibility(0);
            this.kui.setVisibility(0);
            a(this.kuc, dVarArr[0].ksN);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.kud.setVisibility(8);
            } else {
                this.kud.setVisibility(0);
                this.kud.setText(dVarArr[0].desc);
            }
            this.kuf.startLoad(dVarArr[1].pic, 30, false);
            a(this.kuf, dVarArr[1].ksN);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.kug.setVisibility(8);
            } else {
                this.kug.setVisibility(0);
                this.kug.setText(dVarArr[1].desc);
            }
            this.kui.startLoad(dVarArr[2].pic, 30, false);
            a(this.kui, dVarArr[2].ksN);
            if (StringUtils.isNull(dVarArr[2].desc, true)) {
                this.kuj.setVisibility(8);
            } else {
                this.kuj.setVisibility(0);
                this.kuj.setText(dVarArr[2].desc);
            }
        }
        AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        if (!StringUtils.isNull(adCard.adSource, true)) {
            this.kul.setText(adCard.adSource);
            this.kuk.setVisibility(0);
        } else if (advertAppInfo != null && advertAppInfo.dmx != null && !TextUtils.isEmpty(advertAppInfo.dmx.adSource)) {
            this.kul.setText(advertAppInfo.dmx.adSource);
            this.kuk.setVisibility(0);
        } else {
            this.kuk.setVisibility(8);
        }
        this.ktc.setVisibility(0);
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
