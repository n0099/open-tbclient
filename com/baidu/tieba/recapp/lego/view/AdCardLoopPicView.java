package com.baidu.tieba.recapp.lego.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.lego.view.AdCardBaseView;
import com.baidu.tieba.recapp.lego.view.LoopADView;
import d.a.i0.r.k;
/* loaded from: classes3.dex */
public class AdCardLoopPicView extends AdCardBaseView {
    public View m0;
    public LoopADView n0;

    /* loaded from: classes3.dex */
    public class a implements LoopADView.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AdCard f21001a;

        public a(AdCard adCard) {
            this.f21001a = adCard;
        }

        @Override // com.baidu.tieba.recapp.lego.view.LoopADView.a
        public void a(TbImageView tbImageView, AdCard.b bVar) {
            AdCardLoopPicView.this.X0(tbImageView, bVar, new AdCardBaseView.k(this.f21001a));
        }

        @Override // com.baidu.tieba.recapp.lego.view.LoopADView.a
        public String b(String str) {
            return StringHelper.cutStringWithSuffix(str, 100, StringHelper.STRING_MORE);
        }

        @Override // com.baidu.tieba.recapp.lego.view.LoopADView.a
        public void reset() {
            if (AdCardLoopPicView.this.m0 != null) {
                AdCardLoopPicView.this.m0.setScrollX(0);
            }
        }
    }

    public AdCardLoopPicView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public void A0(AdCard adCard) {
        AdCard.d[] dVarArr = adCard.threadPicList;
        boolean g2 = k.c().g();
        this.n0.setBussinessType(getBusinessType());
        if (!g2) {
            this.m0.setVisibility(8);
            return;
        }
        this.m0.setVisibility(0);
        e1(this.m0, 0);
        this.n0.setOnClickCallbackListener(new a(adCard));
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds92);
        if (adCard.needResize) {
            this.n0.h(dVarArr, 30, adCard.width, adCard.height, dimensionPixelSize);
        } else {
            this.n0.h(dVarArr, 30, 0, 0, dimensionPixelSize);
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public void G0(View view) {
        this.m0 = view.findViewById(R.id.advert_loop_ad_container);
        this.n0 = (LoopADView) view.findViewById(R.id.loop_view);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView, com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: S0 */
    public void x(AdCard adCard, int i2) {
        super.x(adCard, i2);
        LoopADView loopADView = this.n0;
        if (loopADView == null || loopADView.getVisibility() != 0) {
            return;
        }
        this.n0.b();
    }

    public final void e1(View view, int i2) {
        if (view == null || view.getVisibility() != 0) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            ((RelativeLayout.LayoutParams) layoutParams).rightMargin = i2;
        } else if (layoutParams instanceof LinearLayout.LayoutParams) {
            ((LinearLayout.LayoutParams) layoutParams).rightMargin = i2;
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public int getCustomLayout() {
        return R.layout.card_ad_loop_pic;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    public int getLayout() {
        return R.layout.card_ad;
    }
}
