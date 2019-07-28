package com.baidu.tieba.recapp.lego.view;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.AdCard;
/* loaded from: classes3.dex */
public class AdCardMultiPicView extends AdCardBaseView {
    protected XfremodeRoundLayout iIh;
    protected TbImageView iIi;
    protected TextView iIj;
    protected RelativeLayout iIk;
    protected TbImageView iIl;
    protected TextView iIm;
    protected XfremodeRoundLayout iIn;
    protected TbImageView iIo;
    protected TextView iIp;
    protected View iIq;
    protected TextView iIr;

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
        this.iIh = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_left);
        this.iIi = (TbImageView) view.findViewById(R.id.advert_app_img_left);
        this.iIj = (TextView) view.findViewById(R.id.txt_left);
        this.iIk = (RelativeLayout) view.findViewById(R.id.rl_img_center);
        this.iIl = (TbImageView) view.findViewById(R.id.advert_app_img_center);
        this.iIm = (TextView) view.findViewById(R.id.txt_center);
        this.iIn = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_right);
        this.iIo = (TbImageView) view.findViewById(R.id.advert_app_img_right);
        this.iIp = (TextView) view.findViewById(R.id.txt_right);
        this.iIr = (TextView) view.findViewById(R.id.advert_source_right);
        float dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds20);
        this.iIh.setRoundLayoutRadius(new float[]{dimensionPixelSize, dimensionPixelSize, 0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize, dimensionPixelSize});
        this.iIn.setRoundLayoutRadius(new float[]{0.0f, 0.0f, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, 0.0f, 0.0f});
        this.iIq = view.findViewById(R.id.channel_ad_right);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void a(AdCard adCard) {
        AdCard.d[] dVarArr = adCard.threadPicList;
        int length = dVarArr != null ? dVarArr.length : 0;
        int dimensionPixelSize = (int) ((this.mMaxWidth - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10) * 2)) / 3.0f);
        if (length <= 0) {
            this.iHo.setVisibility(8);
            return;
        }
        this.iIj.setVisibility(8);
        this.iIi.setVisibility(8);
        this.iIm.setVisibility(8);
        this.iIl.setVisibility(8);
        this.iIp.setVisibility(8);
        this.iIo.setVisibility(8);
        a(this.iIi, dimensionPixelSize, dimensionPixelSize);
        a(this.iIl, dimensionPixelSize, dimensionPixelSize);
        a(this.iIo, dimensionPixelSize, dimensionPixelSize);
        if (length == 1) {
            this.iIi.startLoad(dVarArr[0].pic, 30, false);
            this.iIi.setVisibility(0);
            a(this.iIi, dVarArr[0].iGZ);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.iIj.setVisibility(8);
            } else {
                this.iIj.setVisibility(0);
                this.iIj.setText(dVarArr[0].desc);
            }
        } else if (length == 2) {
            this.iIi.startLoad(dVarArr[0].pic, 30, false);
            this.iIi.setVisibility(0);
            this.iIl.setVisibility(0);
            a(this.iIi, dVarArr[0].iGZ);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.iIj.setVisibility(8);
            } else {
                this.iIj.setVisibility(0);
                this.iIj.setText(dVarArr[0].desc);
            }
            this.iIl.startLoad(dVarArr[1].pic, 30, false);
            a(this.iIl, dVarArr[1].iGZ);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.iIm.setVisibility(8);
            } else {
                this.iIm.setVisibility(0);
                this.iIm.setText(dVarArr[1].desc);
            }
        } else if (length >= 3) {
            this.iIi.startLoad(dVarArr[0].pic, 30, false);
            this.iIi.setVisibility(0);
            this.iIl.setVisibility(0);
            this.iIo.setVisibility(0);
            a(this.iIi, dVarArr[0].iGZ);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.iIj.setVisibility(8);
            } else {
                this.iIj.setVisibility(0);
                this.iIj.setText(dVarArr[0].desc);
            }
            this.iIl.startLoad(dVarArr[1].pic, 30, false);
            a(this.iIl, dVarArr[1].iGZ);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.iIm.setVisibility(8);
            } else {
                this.iIm.setVisibility(0);
                this.iIm.setText(dVarArr[1].desc);
            }
            this.iIo.startLoad(dVarArr[2].pic, 30, false);
            a(this.iIo, dVarArr[2].iGZ);
            if (StringUtils.isNull(dVarArr[2].desc, true)) {
                this.iIp.setVisibility(8);
            } else {
                this.iIp.setVisibility(0);
                this.iIp.setText(dVarArr[2].desc);
            }
        }
        AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        if (!StringUtils.isNull(adCard.adSource, true)) {
            this.iIr.setText(adCard.adSource);
            this.iIq.setVisibility(0);
        } else if (advertAppInfo != null && advertAppInfo.bFd != null && !TextUtils.isEmpty(advertAppInfo.bFd.adSource)) {
            this.iIr.setText(advertAppInfo.bFd.adSource);
            this.iIq.setVisibility(0);
        } else {
            this.iIq.setVisibility(8);
        }
        this.iHo.setVisibility(0);
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
