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
    protected XfremodeRoundLayout iJl;
    protected TbImageView iJm;
    protected TextView iJn;
    protected RelativeLayout iJo;
    protected TbImageView iJp;
    protected TextView iJq;
    protected XfremodeRoundLayout iJr;
    protected TbImageView iJs;
    protected TextView iJt;
    protected View iJu;
    protected TextView iJv;

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
    protected void cQ(View view) {
        this.iJl = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_left);
        this.iJm = (TbImageView) view.findViewById(R.id.advert_app_img_left);
        this.iJn = (TextView) view.findViewById(R.id.txt_left);
        this.iJo = (RelativeLayout) view.findViewById(R.id.rl_img_center);
        this.iJp = (TbImageView) view.findViewById(R.id.advert_app_img_center);
        this.iJq = (TextView) view.findViewById(R.id.txt_center);
        this.iJr = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_right);
        this.iJs = (TbImageView) view.findViewById(R.id.advert_app_img_right);
        this.iJt = (TextView) view.findViewById(R.id.txt_right);
        this.iJv = (TextView) view.findViewById(R.id.advert_source_right);
        float dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds20);
        this.iJl.setRoundLayoutRadius(new float[]{dimensionPixelSize, dimensionPixelSize, 0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize, dimensionPixelSize});
        this.iJr.setRoundLayoutRadius(new float[]{0.0f, 0.0f, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, 0.0f, 0.0f});
        this.iJu = view.findViewById(R.id.channel_ad_right);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void a(AdCard adCard) {
        AdCard.d[] dVarArr = adCard.threadPicList;
        int length = dVarArr != null ? dVarArr.length : 0;
        int dimensionPixelSize = (int) ((this.mMaxWidth - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10) * 2)) / 3.0f);
        if (length <= 0) {
            this.iIs.setVisibility(8);
            return;
        }
        this.iJn.setVisibility(8);
        this.iJm.setVisibility(8);
        this.iJq.setVisibility(8);
        this.iJp.setVisibility(8);
        this.iJt.setVisibility(8);
        this.iJs.setVisibility(8);
        a(this.iJm, dimensionPixelSize, dimensionPixelSize);
        a(this.iJp, dimensionPixelSize, dimensionPixelSize);
        a(this.iJs, dimensionPixelSize, dimensionPixelSize);
        if (length == 1) {
            this.iJm.startLoad(dVarArr[0].pic, 30, false);
            this.iJm.setVisibility(0);
            a(this.iJm, dVarArr[0].iId);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.iJn.setVisibility(8);
            } else {
                this.iJn.setVisibility(0);
                this.iJn.setText(dVarArr[0].desc);
            }
        } else if (length == 2) {
            this.iJm.startLoad(dVarArr[0].pic, 30, false);
            this.iJm.setVisibility(0);
            this.iJp.setVisibility(0);
            a(this.iJm, dVarArr[0].iId);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.iJn.setVisibility(8);
            } else {
                this.iJn.setVisibility(0);
                this.iJn.setText(dVarArr[0].desc);
            }
            this.iJp.startLoad(dVarArr[1].pic, 30, false);
            a(this.iJp, dVarArr[1].iId);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.iJq.setVisibility(8);
            } else {
                this.iJq.setVisibility(0);
                this.iJq.setText(dVarArr[1].desc);
            }
        } else if (length >= 3) {
            this.iJm.startLoad(dVarArr[0].pic, 30, false);
            this.iJm.setVisibility(0);
            this.iJp.setVisibility(0);
            this.iJs.setVisibility(0);
            a(this.iJm, dVarArr[0].iId);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.iJn.setVisibility(8);
            } else {
                this.iJn.setVisibility(0);
                this.iJn.setText(dVarArr[0].desc);
            }
            this.iJp.startLoad(dVarArr[1].pic, 30, false);
            a(this.iJp, dVarArr[1].iId);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.iJq.setVisibility(8);
            } else {
                this.iJq.setVisibility(0);
                this.iJq.setText(dVarArr[1].desc);
            }
            this.iJs.startLoad(dVarArr[2].pic, 30, false);
            a(this.iJs, dVarArr[2].iId);
            if (StringUtils.isNull(dVarArr[2].desc, true)) {
                this.iJt.setVisibility(8);
            } else {
                this.iJt.setVisibility(0);
                this.iJt.setText(dVarArr[2].desc);
            }
        }
        AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        if (!StringUtils.isNull(adCard.adSource, true)) {
            this.iJv.setText(adCard.adSource);
            this.iJu.setVisibility(0);
        } else if (advertAppInfo != null && advertAppInfo.bFe != null && !TextUtils.isEmpty(advertAppInfo.bFe.adSource)) {
            this.iJv.setText(advertAppInfo.bFe.adSource);
            this.iJu.setVisibility(0);
        } else {
            this.iJu.setVisibility(8);
        }
        this.iIs.setVisibility(0);
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
