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
    protected XfremodeRoundLayout mUH;
    protected TbImageView mUI;
    protected TextView mUJ;
    protected XfremodeRoundLayout mUL;
    protected TbImageView mUM;
    protected TextView mUN;
    protected XfremodeRoundLayout mUO;
    protected TbImageView mUP;
    protected TextView mUQ;
    protected View mUR;
    protected TextView mUS;
    private final float mUT;
    private final float mUU;
    private float mUV;
    private float mUW;
    private final int mUX;
    private final int mUY;
    private final int mUZ;
    private final int mVa;

    public AdCardMultiPicView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mUT = 1.0f;
        this.mUU = 0.0f;
        this.mUW = 0.0f;
        this.mUX = 1;
        this.mUY = 2;
        this.mUZ = 3;
        this.mVa = 4;
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
        this.mUH = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_left);
        this.mUI = (TbImageView) view.findViewById(R.id.advert_app_img_left);
        this.mUJ = (TextView) view.findViewById(R.id.txt_left);
        this.mUL = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_center);
        this.mUM = (TbImageView) view.findViewById(R.id.advert_app_img_center);
        this.mUN = (TextView) view.findViewById(R.id.txt_center);
        this.mUO = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_right);
        this.mUP = (TbImageView) view.findViewById(R.id.advert_app_img_right);
        this.mUQ = (TextView) view.findViewById(R.id.txt_right);
        this.mUS = (TextView) view.findViewById(R.id.advert_source_right);
        this.mUV = HS(R.string.J_X05);
        this.mUI.setPlaceHolder(2);
        this.mUM.setPlaceHolder(2);
        this.mUP.setPlaceHolder(2);
        this.mUR = view.findViewById(R.id.channel_ad_right);
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
            this.mTE.setVisibility(8);
            return;
        }
        this.mUJ.setVisibility(8);
        this.mUI.setVisibility(4);
        this.mUN.setVisibility(8);
        this.mUM.setVisibility(4);
        this.mUQ.setVisibility(8);
        this.mUP.setVisibility(4);
        a(this.mUH, 1);
        a(this.mUL, 2);
        a(this.mUO, 3);
        b(this.mUI, dimensionPixelSize, max);
        b(this.mUM, dimensionPixelSize, max);
        b(this.mUP, dimensionPixelSize, max);
        if (length == 1) {
            this.mUI.startLoad(dVarArr[0].pic, 30, false);
            this.mUI.setVisibility(0);
            a(this.mUI, dVarArr[0].mTr);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.mUJ.setVisibility(8);
            } else {
                this.mUJ.setVisibility(0);
                this.mUJ.setText(dVarArr[0].desc);
            }
            a(this.mUH, 4);
        } else if (length == 2) {
            this.mUI.startLoad(dVarArr[0].pic, 30, false);
            this.mUI.setVisibility(0);
            this.mUM.setVisibility(0);
            a(this.mUI, dVarArr[0].mTr);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.mUJ.setVisibility(8);
            } else {
                this.mUJ.setVisibility(0);
                this.mUJ.setText(dVarArr[0].desc);
            }
            this.mUM.startLoad(dVarArr[1].pic, 30, false);
            a(this.mUM, dVarArr[1].mTr);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.mUN.setVisibility(8);
            } else {
                this.mUN.setVisibility(0);
                this.mUN.setText(dVarArr[1].desc);
            }
            a(this.mUL, 3);
        } else if (length >= 3) {
            this.mUI.startLoad(dVarArr[0].pic, 30, false);
            this.mUI.setVisibility(0);
            this.mUM.setVisibility(0);
            this.mUP.setVisibility(0);
            a(this.mUI, dVarArr[0].mTr);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.mUJ.setVisibility(8);
            } else {
                this.mUJ.setVisibility(0);
                this.mUJ.setText(dVarArr[0].desc);
            }
            this.mUM.startLoad(dVarArr[1].pic, 30, false);
            a(this.mUM, dVarArr[1].mTr);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.mUN.setVisibility(8);
            } else {
                this.mUN.setVisibility(0);
                this.mUN.setText(dVarArr[1].desc);
            }
            this.mUP.startLoad(dVarArr[2].pic, 30, false);
            a(this.mUP, dVarArr[2].mTr);
            if (StringUtils.isNull(dVarArr[2].desc, true)) {
                this.mUQ.setVisibility(8);
            } else {
                this.mUQ.setVisibility(0);
                this.mUQ.setText(dVarArr[2].desc);
            }
        }
        AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        if (!StringUtils.isNull(adCard.adSource, true)) {
            this.mUS.setText(adCard.adSource);
            this.mUR.setVisibility(0);
        } else if (advertAppInfo != null && advertAppInfo.eLC != null && !TextUtils.isEmpty(advertAppInfo.eLC.adSource)) {
            this.mUS.setText(advertAppInfo.eLC.adSource);
            this.mUR.setVisibility(0);
        } else {
            this.mUR.setVisibility(8);
        }
        this.mTE.setVisibility(0);
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
                xfremodeRoundLayout.setRoundLayoutRadius(new float[]{this.mUV, this.mUV, this.mUW, this.mUW, this.mUW, this.mUW, this.mUV, this.mUV});
                return;
            case 2:
                xfremodeRoundLayout.setRoundLayoutRadius(new float[]{this.mUW, this.mUW, this.mUW, this.mUW, this.mUW, this.mUW, this.mUW, this.mUW});
                return;
            case 3:
                xfremodeRoundLayout.setRoundLayoutRadius(new float[]{this.mUW, this.mUW, this.mUV, this.mUV, this.mUV, this.mUV, this.mUW, this.mUW});
                return;
            default:
                xfremodeRoundLayout.setRoundLayoutRadius(new float[]{this.mUV, this.mUV, this.mUV, this.mUV, this.mUV, this.mUV, this.mUV, this.mUV});
                return;
        }
    }
}
