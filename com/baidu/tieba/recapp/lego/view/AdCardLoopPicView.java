package com.baidu.tieba.recapp.lego.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.lego.view.AdCardBaseView;
import com.baidu.tieba.recapp.lego.view.LoopADView;
/* loaded from: classes3.dex */
public class AdCardLoopPicView extends AdCardBaseView {
    private View gGZ;
    private LoopADView gHa;

    public AdCardLoopPicView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected int getCustomLayout() {
        return e.h.card_ad_loop_pic;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void bN(View view) {
        this.gGZ = view.findViewById(e.g.advert_loop_ad_container);
        this.gHa = (LoopADView) view.findViewById(e.g.loop_view);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void a(final AdCard adCard) {
        AdCard.d[] dVarArr = adCard.threadPicList;
        boolean wE = i.wA().wE();
        this.gHa.setBussinessType(getBusinessType());
        if (!wE) {
            this.gGZ.setVisibility(8);
            return;
        }
        this.gGZ.setVisibility(0);
        z(this.gGZ, 0);
        this.gHa.setOnClickCallbackListener(new LoopADView.a() { // from class: com.baidu.tieba.recapp.lego.view.AdCardLoopPicView.1
            @Override // com.baidu.tieba.recapp.lego.view.LoopADView.a
            public void b(TbImageView tbImageView, AdCard.b bVar) {
                AdCardLoopPicView.this.a(tbImageView, bVar, new AdCardBaseView.b(adCard));
            }

            @Override // com.baidu.tieba.recapp.lego.view.LoopADView.a
            public String ue(String str) {
                return AdCardLoopPicView.this.ub(ao.c(str, 100, "..."));
            }

            @Override // com.baidu.tieba.recapp.lego.view.LoopADView.a
            public void reset() {
                if (AdCardLoopPicView.this.gGZ != null) {
                    AdCardLoopPicView.this.gGZ.setScrollX(0);
                }
            }
        });
        int i = this.gGJ.getHeaderImg().getLayoutParams().width;
        if (!adCard.needResize) {
            this.gHa.a(dVarArr, 30, 0, 0, i);
        } else {
            this.gHa.a(dVarArr, 30, adCard.width, adCard.height, i);
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected int getLayout() {
        return e.h.card_ad;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView, com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(AdCard adCard, int i) {
        super.a(adCard, i);
        if (this.gHa != null && this.gHa.getVisibility() == 0) {
            this.gHa.aUo();
        }
    }

    private void z(View view, int i) {
        if (view != null && view.getVisibility() == 0) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams).rightMargin = i;
            } else if (layoutParams instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) layoutParams).rightMargin = i;
            }
        }
    }
}
