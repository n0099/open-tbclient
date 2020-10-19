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
/* loaded from: classes26.dex */
public class AdCardMultiPicView extends AdCardBaseView {
    protected XfremodeRoundLayout mdm;
    protected TbImageView mdn;
    protected TextView mdo;
    protected XfremodeRoundLayout mdp;
    protected TbImageView mdq;
    protected TextView mdr;
    protected XfremodeRoundLayout mds;
    protected TbImageView mdt;
    protected TextView mdu;
    protected View mdv;
    protected TextView mdw;
    private final float mdx;
    private final float mdy;

    public AdCardMultiPicView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mdx = 1.0f;
        this.mdy = 0.0f;
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
    protected void du(View view) {
        this.mdm = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_left);
        this.mdn = (TbImageView) view.findViewById(R.id.advert_app_img_left);
        this.mdo = (TextView) view.findViewById(R.id.txt_left);
        this.mdp = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_center);
        this.mdq = (TbImageView) view.findViewById(R.id.advert_app_img_center);
        this.mdr = (TextView) view.findViewById(R.id.txt_center);
        this.mds = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_right);
        this.mdt = (TbImageView) view.findViewById(R.id.advert_app_img_right);
        this.mdu = (TextView) view.findViewById(R.id.txt_right);
        this.mdw = (TextView) view.findViewById(R.id.advert_source_right);
        float dimensionPixelSize = this.etO.getResources().getDimensionPixelSize(R.dimen.tbds10);
        this.mdm.setRoundLayoutRadius(new float[]{dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize});
        this.mdp.setRoundLayoutRadius(new float[]{dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize});
        this.mds.setRoundLayoutRadius(new float[]{dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize});
        this.mdn.setPlaceHolder(2);
        this.mdq.setPlaceHolder(2);
        this.mdt.setPlaceHolder(2);
        this.mdv = view.findViewById(R.id.channel_ad_right);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void a(AdCard adCard) {
        AdCard.d[] dVarArr = adCard.threadPicList;
        int length = dVarArr != null ? dVarArr.length : 0;
        int dimensionPixelSize = (int) ((this.mMaxWidth - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10) * 2)) / 3.0f);
        int i = adCard.height;
        int i2 = adCard.width;
        int max = (int) (Math.max(Math.min((i == 0 || i2 == 0) ? 1.0f : i / i2, 1.0f), 0.0f) * dimensionPixelSize);
        if (length <= 0) {
            this.mcq.setVisibility(8);
            return;
        }
        this.mdo.setVisibility(8);
        this.mdn.setVisibility(8);
        this.mdr.setVisibility(8);
        this.mdq.setVisibility(8);
        this.mdu.setVisibility(8);
        this.mdt.setVisibility(8);
        a(this.mdn, dimensionPixelSize, max);
        a(this.mdq, dimensionPixelSize, max);
        a(this.mdt, dimensionPixelSize, max);
        if (length == 1) {
            this.mdn.startLoad(dVarArr[0].pic, 30, false);
            this.mdn.setVisibility(0);
            a(this.mdn, dVarArr[0].mcb);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.mdo.setVisibility(8);
            } else {
                this.mdo.setVisibility(0);
                this.mdo.setText(dVarArr[0].desc);
            }
        } else if (length == 2) {
            this.mdn.startLoad(dVarArr[0].pic, 30, false);
            this.mdn.setVisibility(0);
            this.mdq.setVisibility(0);
            a(this.mdn, dVarArr[0].mcb);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.mdo.setVisibility(8);
            } else {
                this.mdo.setVisibility(0);
                this.mdo.setText(dVarArr[0].desc);
            }
            this.mdq.startLoad(dVarArr[1].pic, 30, false);
            a(this.mdq, dVarArr[1].mcb);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.mdr.setVisibility(8);
            } else {
                this.mdr.setVisibility(0);
                this.mdr.setText(dVarArr[1].desc);
            }
        } else if (length >= 3) {
            this.mdn.startLoad(dVarArr[0].pic, 30, false);
            this.mdn.setVisibility(0);
            this.mdq.setVisibility(0);
            this.mdt.setVisibility(0);
            a(this.mdn, dVarArr[0].mcb);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.mdo.setVisibility(8);
            } else {
                this.mdo.setVisibility(0);
                this.mdo.setText(dVarArr[0].desc);
            }
            this.mdq.startLoad(dVarArr[1].pic, 30, false);
            a(this.mdq, dVarArr[1].mcb);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.mdr.setVisibility(8);
            } else {
                this.mdr.setVisibility(0);
                this.mdr.setText(dVarArr[1].desc);
            }
            this.mdt.startLoad(dVarArr[2].pic, 30, false);
            a(this.mdt, dVarArr[2].mcb);
            if (StringUtils.isNull(dVarArr[2].desc, true)) {
                this.mdu.setVisibility(8);
            } else {
                this.mdu.setVisibility(0);
                this.mdu.setText(dVarArr[2].desc);
            }
        }
        AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        if (!StringUtils.isNull(adCard.adSource, true)) {
            this.mdw.setText(adCard.adSource);
            this.mdv.setVisibility(0);
        } else if (advertAppInfo != null && advertAppInfo.ekE != null && !TextUtils.isEmpty(advertAppInfo.ekE.adSource)) {
            this.mdw.setText(advertAppInfo.ekE.adSource);
            this.mdv.setVisibility(0);
        } else {
            this.mdv.setVisibility(8);
        }
        this.mcq.setVisibility(0);
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
