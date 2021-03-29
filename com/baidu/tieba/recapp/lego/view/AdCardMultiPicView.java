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
/* loaded from: classes5.dex */
public class AdCardMultiPicView extends AdCardBaseView {
    public XfremodeRoundLayout m0;
    public TbImageView n0;
    public TextView o0;
    public XfremodeRoundLayout p0;
    public TbImageView q0;
    public TextView r0;
    public XfremodeRoundLayout s0;
    public TbImageView t0;
    public TextView u0;
    public View v0;
    public TextView w0;
    public float x0;
    public float y0;

    public AdCardMultiPicView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.y0 = 0.0f;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public void A0(AdCard adCard) {
        AdvertAppInfo.a aVar;
        AdCard.d[] dVarArr = adCard.threadPicList;
        int length = dVarArr != null ? dVarArr.length : 0;
        int dimensionPixelSize = (int) ((this.G - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.M_W_X002) * 2)) / 3.0f);
        int i = adCard.height;
        int i2 = adCard.width;
        int max = (int) (dimensionPixelSize * Math.max(Math.min((i == 0 || i2 == 0) ? 1.0f : i / i2, 1.0f), 0.0f));
        if (length <= 0) {
            this.t.setVisibility(8);
            return;
        }
        this.o0.setVisibility(8);
        this.n0.setVisibility(4);
        this.r0.setVisibility(8);
        this.q0.setVisibility(4);
        this.u0.setVisibility(8);
        this.t0.setVisibility(4);
        e1(this.m0, 1);
        e1(this.p0, 2);
        e1(this.s0, 3);
        d1(this.n0, dimensionPixelSize, max);
        d1(this.q0, dimensionPixelSize, max);
        d1(this.t0, dimensionPixelSize, max);
        if (length == 1) {
            this.n0.W(dVarArr[0].f20707a, 30, false);
            this.n0.setVisibility(0);
            Y0(this.n0, dVarArr[0].f20709c);
            if (StringUtils.isNull(dVarArr[0].f20708b, true)) {
                this.o0.setVisibility(8);
            } else {
                this.o0.setVisibility(0);
                this.o0.setText(dVarArr[0].f20708b);
            }
            e1(this.m0, 4);
        } else if (length == 2) {
            this.n0.W(dVarArr[0].f20707a, 30, false);
            this.n0.setVisibility(0);
            this.q0.setVisibility(0);
            Y0(this.n0, dVarArr[0].f20709c);
            if (StringUtils.isNull(dVarArr[0].f20708b, true)) {
                this.o0.setVisibility(8);
            } else {
                this.o0.setVisibility(0);
                this.o0.setText(dVarArr[0].f20708b);
            }
            this.q0.W(dVarArr[1].f20707a, 30, false);
            Y0(this.q0, dVarArr[1].f20709c);
            if (StringUtils.isNull(dVarArr[1].f20708b, true)) {
                this.r0.setVisibility(8);
            } else {
                this.r0.setVisibility(0);
                this.r0.setText(dVarArr[1].f20708b);
            }
            e1(this.p0, 3);
        } else if (length >= 3) {
            this.n0.W(dVarArr[0].f20707a, 30, false);
            this.n0.setVisibility(0);
            this.q0.setVisibility(0);
            this.t0.setVisibility(0);
            Y0(this.n0, dVarArr[0].f20709c);
            if (StringUtils.isNull(dVarArr[0].f20708b, true)) {
                this.o0.setVisibility(8);
            } else {
                this.o0.setVisibility(0);
                this.o0.setText(dVarArr[0].f20708b);
            }
            this.q0.W(dVarArr[1].f20707a, 30, false);
            Y0(this.q0, dVarArr[1].f20709c);
            if (StringUtils.isNull(dVarArr[1].f20708b, true)) {
                this.r0.setVisibility(8);
            } else {
                this.r0.setVisibility(0);
                this.r0.setText(dVarArr[1].f20708b);
            }
            this.t0.W(dVarArr[2].f20707a, 30, false);
            Y0(this.t0, dVarArr[2].f20709c);
            if (StringUtils.isNull(dVarArr[2].f20708b, true)) {
                this.u0.setVisibility(8);
            } else {
                this.u0.setVisibility(0);
                this.u0.setText(dVarArr[2].f20708b);
            }
        }
        AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        if (!StringUtils.isNull(adCard.adSource, true)) {
            this.w0.setText(adCard.adSource);
            this.v0.setVisibility(0);
        } else if (advertAppInfo != null && (aVar = advertAppInfo.U3) != null && !TextUtils.isEmpty(aVar.o)) {
            this.w0.setText(advertAppInfo.U3.o);
            this.v0.setVisibility(0);
        } else {
            this.v0.setVisibility(8);
        }
        this.t.setVisibility(0);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public void G0(View view) {
        this.m0 = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_left);
        this.n0 = (TbImageView) view.findViewById(R.id.advert_app_img_left);
        this.o0 = (TextView) view.findViewById(R.id.txt_left);
        this.p0 = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_center);
        this.q0 = (TbImageView) view.findViewById(R.id.advert_app_img_center);
        this.r0 = (TextView) view.findViewById(R.id.txt_center);
        this.s0 = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_right);
        this.t0 = (TbImageView) view.findViewById(R.id.advert_app_img_right);
        this.u0 = (TextView) view.findViewById(R.id.txt_right);
        this.w0 = (TextView) view.findViewById(R.id.advert_source_right);
        this.x0 = B0(R.string.J_X05);
        this.n0.setPlaceHolder(2);
        this.q0.setPlaceHolder(2);
        this.t0.setPlaceHolder(2);
        this.v0 = view.findViewById(R.id.channel_ad_right);
    }

    public final void d1(TbImageView tbImageView, int i, int i2) {
        if (tbImageView == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = tbImageView.getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i;
        tbImageView.setLayoutParams(layoutParams);
    }

    public final void e1(XfremodeRoundLayout xfremodeRoundLayout, int i) {
        if (i == 1) {
            float f2 = this.x0;
            float f3 = this.y0;
            xfremodeRoundLayout.setRoundLayoutRadius(new float[]{f2, f2, f3, f3, f3, f3, f2, f2});
        } else if (i == 2) {
            float f4 = this.y0;
            xfremodeRoundLayout.setRoundLayoutRadius(new float[]{f4, f4, f4, f4, f4, f4, f4, f4});
        } else if (i != 3) {
            float f5 = this.x0;
            xfremodeRoundLayout.setRoundLayoutRadius(new float[]{f5, f5, f5, f5, f5, f5, f5, f5});
        } else {
            float f6 = this.y0;
            float f7 = this.x0;
            xfremodeRoundLayout.setRoundLayoutRadius(new float[]{f6, f6, f7, f7, f7, f7, f6, f6});
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public int getCustomLayout() {
        return R.layout.card_ad_multi_pic;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public int getLayout() {
        return R.layout.card_ad;
    }
}
