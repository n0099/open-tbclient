package com.baidu.tieba.recapp.lego.view;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.AdCard;
import d.a.o0.t2.f0.b.c;
import d.a.o0.t2.f0.c.a;
/* loaded from: classes5.dex */
public class AdCardSinglePicView extends AdCardBaseView {
    public XfremodeRoundLayout n0;
    public TbImageView o0;

    public AdCardSinglePicView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    public boolean K0(TbImageView tbImageView, AdCard adCard, @NonNull c cVar) {
        if (adCard == null || tbImageView == null) {
            return false;
        }
        double d2 = 1.0d;
        if (adCard.getPicScale() > 0.0d && adCard.getPicScale() < 1.0d) {
            d2 = adCard.getPicScale();
        }
        int i2 = this.G;
        int i3 = (int) (i2 * d2);
        int b2 = (int) (a.b(i2) * d2);
        if (!adCard.isNeedResize()) {
            L0(tbImageView, b2, i3);
            return true;
        }
        int i4 = cVar.f64886e;
        int i5 = cVar.f64885d;
        if (i3 > 0 && i4 > 0 && i5 > 0) {
            int i6 = (i4 * i3) / i5;
            if (i6 > i3) {
                return false;
            }
            L0(tbImageView, i6, i3);
            return true;
        }
        int i7 = this.G;
        L0(tbImageView, (int) (i7 * 0.75f), i7);
        return true;
    }

    public void L0(TbImageView tbImageView, int i2, int i3) {
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
        this.n0.setLayoutParams(layoutParams);
        tbImageView.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public void d0(AdCard adCard) {
        c cVar = adCard.picInfo;
        if (cVar != null && !d.a.o0.k1.o.k.a.e(cVar.f64884c)) {
            String str = cVar.f64884c.get(0);
            boolean K0 = K0(this.o0, adCard, cVar);
            if (!TextUtils.isEmpty(str) && K0) {
                this.t.setVisibility(0);
                this.o0.U(str, 17, false);
                return;
            }
            this.t.setVisibility(8);
            return;
        }
        this.t.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public int getCustomLayout() {
        return R.layout.card_ad_single_pic;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public int getLayout() {
        return R.layout.card_ad;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public void k0(View view) {
        float e0 = e0(R.string.J_X05);
        if (view instanceof XfremodeRoundLayout) {
            ((XfremodeRoundLayout) view).setRoundLayoutRadius(new float[]{e0, e0, e0, e0, e0, e0, e0, e0});
        }
        this.n0 = (XfremodeRoundLayout) view.findViewById(R.id.rl_ad_image);
        TbImageView tbImageView = (TbImageView) view.findViewById(R.id.ad_img);
        this.o0 = tbImageView;
        tbImageView.setPlaceHolder(3);
        this.n0.setRoundLayoutRadius(new float[]{e0, e0, e0, e0, e0, e0, e0, e0});
    }
}
