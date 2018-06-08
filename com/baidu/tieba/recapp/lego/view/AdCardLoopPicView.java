package com.baidu.tieba.recapp.lego.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.lego.view.AdCardBaseView;
import com.baidu.tieba.recapp.lego.view.LoopADView;
/* loaded from: classes3.dex */
public class AdCardLoopPicView extends AdCardBaseView {
    private View glB;
    private LoopADView glC;

    public AdCardLoopPicView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected int getCustomLayout() {
        return d.i.card_ad_loop_pic;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void bu(View view) {
        this.glB = view.findViewById(d.g.advert_loop_ad_container);
        this.glC = (LoopADView) view.findViewById(d.g.loop_view);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void a(final AdCard adCard) {
        AdCard.d[] dVarArr = adCard.threadPicList;
        boolean tz = i.tt().tz();
        this.glC.setBussinessType(getBusinessType());
        if (!tz) {
            this.glB.setVisibility(8);
            return;
        }
        this.glB.setVisibility(0);
        v(this.glB, 0);
        this.glC.setOnClickCallbackListener(new LoopADView.a() { // from class: com.baidu.tieba.recapp.lego.view.AdCardLoopPicView.1
            @Override // com.baidu.tieba.recapp.lego.view.LoopADView.a
            public void b(TbImageView tbImageView, AdCard.b bVar) {
                AdCardLoopPicView.this.a(tbImageView, bVar, new AdCardBaseView.b(adCard));
            }

            @Override // com.baidu.tieba.recapp.lego.view.LoopADView.a
            public String sS(String str) {
                return AdCardLoopPicView.this.sP(ao.d(str, 100, "..."));
            }

            @Override // com.baidu.tieba.recapp.lego.view.LoopADView.a
            public void reset() {
                if (AdCardLoopPicView.this.glB != null) {
                    AdCardLoopPicView.this.glB.setScrollX(0);
                }
            }
        });
        int i = this.gll.getHeaderImg().getLayoutParams().width;
        if (!adCard.needResize) {
            this.glC.a(dVarArr, 30, 0, 0, i);
        } else {
            this.glC.a(dVarArr, 30, adCard.width, adCard.height, i);
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected int getLayout() {
        return d.i.card_ad;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView, com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(AdCard adCard, int i) {
        super.a(adCard, i);
        if (this.glC != null && this.glC.getVisibility() == 0) {
            this.glC.aNN();
        }
    }

    private void v(View view, int i) {
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
