package com.baidu.tieba.recapp.lego.view;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.AdCard;
import d.a.o0.k1.o.k.a;
import d.a.o0.t2.f0.b.c;
import java.util.List;
/* loaded from: classes5.dex */
public class AdCardMultiPicView extends AdCardBaseView {
    public XfremodeRoundLayout n0;
    public TbImageView o0;
    public XfremodeRoundLayout p0;
    public TbImageView q0;
    public XfremodeRoundLayout r0;
    public TbImageView s0;
    public float t0;
    public float u0;

    public AdCardMultiPicView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.u0 = 0.0f;
    }

    public final void K0(TbImageView tbImageView, int i2, int i3) {
        if (tbImageView == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = tbImageView.getLayoutParams();
        layoutParams.height = i3;
        layoutParams.width = i2;
        tbImageView.setLayoutParams(layoutParams);
    }

    public final void L0(XfremodeRoundLayout xfremodeRoundLayout, int i2) {
        if (i2 == 1) {
            float f2 = this.t0;
            float f3 = this.u0;
            xfremodeRoundLayout.setRoundLayoutRadius(new float[]{f2, f2, f3, f3, f3, f3, f2, f2});
        } else if (i2 == 2) {
            float f4 = this.u0;
            xfremodeRoundLayout.setRoundLayoutRadius(new float[]{f4, f4, f4, f4, f4, f4, f4, f4});
        } else if (i2 != 3) {
            float f5 = this.t0;
            xfremodeRoundLayout.setRoundLayoutRadius(new float[]{f5, f5, f5, f5, f5, f5, f5, f5});
        } else {
            float f6 = this.u0;
            float f7 = this.t0;
            xfremodeRoundLayout.setRoundLayoutRadius(new float[]{f6, f6, f7, f7, f7, f7, f6, f6});
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public void d0(AdCard adCard) {
        c cVar = adCard.picInfo;
        List<String> list = cVar == null ? null : cVar.f64884c;
        if (!a.e(list) && cVar != null) {
            int k = a.k(cVar.f64884c);
            int dimensionPixelSize = (int) ((this.G - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.M_W_X002) * 2)) / 3.0f);
            int i2 = cVar.f64886e;
            int i3 = cVar.f64885d;
            int max = (int) (dimensionPixelSize * Math.max(Math.min((i2 == 0 || i3 == 0) ? 1.0f : i2 / i3, 1.0f), 0.0f));
            this.o0.setVisibility(4);
            this.q0.setVisibility(4);
            this.s0.setVisibility(4);
            L0(this.n0, 1);
            L0(this.p0, 2);
            L0(this.r0, 3);
            K0(this.o0, dimensionPixelSize, max);
            K0(this.q0, dimensionPixelSize, max);
            K0(this.s0, dimensionPixelSize, max);
            if (k == 1) {
                this.o0.U((String) a.d(list, 0), 30, false);
                this.o0.setVisibility(0);
                L0(this.n0, 4);
            } else if (k == 2) {
                this.o0.U((String) a.d(list, 0), 30, false);
                this.o0.setVisibility(0);
                this.q0.U((String) a.d(list, 1), 30, false);
                this.q0.setVisibility(0);
                L0(this.p0, 3);
            } else if (k >= 3) {
                this.o0.U((String) a.d(list, 0), 30, false);
                this.o0.setVisibility(0);
                this.q0.U((String) a.d(list, 1), 30, false);
                this.q0.setVisibility(0);
                this.s0.U((String) a.d(list, 2), 30, false);
                this.s0.setVisibility(0);
            }
            this.t.setVisibility(0);
            return;
        }
        this.t.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public int getCustomLayout() {
        return R.layout.card_ad_multi_pic;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public int getLayout() {
        return R.layout.card_ad;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public void k0(View view) {
        this.n0 = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_left);
        this.o0 = (TbImageView) view.findViewById(R.id.advert_app_img_left);
        this.p0 = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_center);
        this.q0 = (TbImageView) view.findViewById(R.id.advert_app_img_center);
        this.r0 = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_right);
        this.s0 = (TbImageView) view.findViewById(R.id.advert_app_img_right);
        this.t0 = e0(R.string.J_X05);
        this.o0.setPlaceHolder(2);
        this.q0.setPlaceHolder(2);
        this.s0.setPlaceHolder(2);
    }
}
