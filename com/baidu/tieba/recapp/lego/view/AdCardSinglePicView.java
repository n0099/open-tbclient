package com.baidu.tieba.recapp.lego.view;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.AdCard;
import d.a.j0.s2.e0.c.a;
/* loaded from: classes3.dex */
public class AdCardSinglePicView extends AdCardBaseView {
    public XfremodeRoundLayout m0;
    public TbImageView n0;
    public View o0;
    public TextView p0;

    public AdCardSinglePicView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public void A0(AdCard adCard) {
        AdvertAppInfo.a aVar;
        AdCard.d[] dVarArr = adCard.threadPicList;
        if (dVarArr != null && dVarArr.length >= 1) {
            String str = dVarArr[0].f20950a;
            boolean d1 = d1(this.n0, adCard);
            if (!TextUtils.isEmpty(str) && d1) {
                this.t.setVisibility(0);
                this.n0.V(str, 17, false);
                AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
                if (!StringUtils.isNull(adCard.adSource, true)) {
                    this.p0.setText(adCard.adSource);
                    this.o0.setVisibility(0);
                } else if (advertAppInfo != null && (aVar = advertAppInfo.U3) != null && !TextUtils.isEmpty(aVar.o)) {
                    this.p0.setText(advertAppInfo.U3.o);
                    this.o0.setVisibility(0);
                } else {
                    this.o0.setVisibility(8);
                }
                Y0(this.n0, adCard.threadPicList[0].f20952c);
                return;
            }
            this.t.setVisibility(8);
            return;
        }
        this.t.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public void G0(View view) {
        float B0 = B0(R.string.J_X05);
        if (view instanceof XfremodeRoundLayout) {
            ((XfremodeRoundLayout) view).setRoundLayoutRadius(new float[]{B0, B0, B0, B0, B0, B0, B0, B0});
        }
        this.m0 = (XfremodeRoundLayout) view.findViewById(R.id.rl_ad_image);
        TbImageView tbImageView = (TbImageView) view.findViewById(R.id.ad_img);
        this.n0 = tbImageView;
        tbImageView.setPlaceHolder(3);
        this.o0 = view.findViewById(R.id.channel_ad);
        this.p0 = (TextView) view.findViewById(R.id.advert_source_img);
        this.m0.setRoundLayoutRadius(new float[]{B0, B0, B0, B0, B0, B0, B0, B0});
    }

    public boolean d1(TbImageView tbImageView, AdCard adCard) {
        int i2;
        if (adCard == null || tbImageView == null) {
            return false;
        }
        double d2 = adCard.showWidthScale;
        if (d2 <= 0.0d || d2 >= 1.0d) {
            d2 = 1.0d;
        }
        int i3 = (int) (this.G * d2);
        int b2 = (int) (a.b(i2) * d2);
        if (!adCard.needResize) {
            e1(tbImageView, b2, i3);
            return true;
        }
        int i4 = adCard.height;
        int i5 = adCard.width;
        if (i3 > 0 && i4 > 0 && i5 > 0) {
            int i6 = (i4 * i3) / i5;
            if (i6 > i3) {
                return false;
            }
            e1(tbImageView, i6, i3);
            return true;
        }
        int i7 = this.G;
        e1(tbImageView, i7, (int) (i7 * 0.0f));
        return true;
    }

    public void e1(TbImageView tbImageView, int i2, int i3) {
        if (tbImageView == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = tbImageView.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(i3, i2);
        } else {
            layoutParams.height = i2;
            layoutParams.width = i3;
        }
        this.m0.setLayoutParams(layoutParams);
        tbImageView.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public int getCustomLayout() {
        return R.layout.card_ad_single_pic;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public int getLayout() {
        return R.layout.card_ad;
    }
}
