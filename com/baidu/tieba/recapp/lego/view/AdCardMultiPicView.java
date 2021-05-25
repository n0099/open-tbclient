package com.baidu.tieba.recapp.lego.view;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.AdCard;
import d.a.n0.k1.o.k.a;
import d.a.n0.t2.f0.b.c;
import java.util.List;
/* loaded from: classes5.dex */
public class AdCardMultiPicView extends AdCardBaseView {
    public XfremodeRoundLayout i0;
    public TbImageView j0;
    public XfremodeRoundLayout k0;
    public TbImageView l0;
    public XfremodeRoundLayout m0;
    public TbImageView n0;
    public float o0;
    public float p0;

    public AdCardMultiPicView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.p0 = 0.0f;
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
            float f2 = this.o0;
            float f3 = this.p0;
            xfremodeRoundLayout.setRoundLayoutRadius(new float[]{f2, f2, f3, f3, f3, f3, f2, f2});
        } else if (i2 == 2) {
            float f4 = this.p0;
            xfremodeRoundLayout.setRoundLayoutRadius(new float[]{f4, f4, f4, f4, f4, f4, f4, f4});
        } else if (i2 != 3) {
            float f5 = this.o0;
            xfremodeRoundLayout.setRoundLayoutRadius(new float[]{f5, f5, f5, f5, f5, f5, f5, f5});
        } else {
            float f6 = this.p0;
            float f7 = this.o0;
            xfremodeRoundLayout.setRoundLayoutRadius(new float[]{f6, f6, f7, f7, f7, f7, f6, f6});
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public void e0(AdCard adCard) {
        c cVar = adCard.picInfo;
        List<String> list = cVar == null ? null : cVar.f61067c;
        if (!a.e(list) && cVar != null) {
            int k = a.k(cVar.f61067c);
            int dimensionPixelSize = (int) ((this.G - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.M_W_X002) * 2)) / 3.0f);
            int i2 = cVar.f61069e;
            int i3 = cVar.f61068d;
            int max = (int) (dimensionPixelSize * Math.max(Math.min((i2 == 0 || i3 == 0) ? 1.0f : i2 / i3, 1.0f), 0.0f));
            this.j0.setVisibility(4);
            this.l0.setVisibility(4);
            this.n0.setVisibility(4);
            L0(this.i0, 1);
            L0(this.k0, 2);
            L0(this.m0, 3);
            K0(this.j0, dimensionPixelSize, max);
            K0(this.l0, dimensionPixelSize, max);
            K0(this.n0, dimensionPixelSize, max);
            if (k == 1) {
                this.j0.V((String) a.d(list, 0), 30, false);
                this.j0.setVisibility(0);
                L0(this.i0, 4);
            } else if (k == 2) {
                this.j0.V((String) a.d(list, 0), 30, false);
                this.j0.setVisibility(0);
                this.l0.V((String) a.d(list, 1), 30, false);
                this.l0.setVisibility(0);
                L0(this.k0, 3);
            } else if (k >= 3) {
                this.j0.V((String) a.d(list, 0), 30, false);
                this.j0.setVisibility(0);
                this.l0.V((String) a.d(list, 1), 30, false);
                this.l0.setVisibility(0);
                this.n0.V((String) a.d(list, 2), 30, false);
                this.n0.setVisibility(0);
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
    public void m0(View view) {
        this.i0 = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_left);
        this.j0 = (TbImageView) view.findViewById(R.id.advert_app_img_left);
        this.k0 = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_center);
        this.l0 = (TbImageView) view.findViewById(R.id.advert_app_img_center);
        this.m0 = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_right);
        this.n0 = (TbImageView) view.findViewById(R.id.advert_app_img_right);
        this.o0 = f0(R.string.J_X05);
        this.j0.setPlaceHolder(2);
        this.l0.setPlaceHolder(2);
        this.n0.setPlaceHolder(2);
    }
}
