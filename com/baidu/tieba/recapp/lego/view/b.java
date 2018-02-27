package com.baidu.tieba.recapp.lego.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.lego.view.LoopADView;
import com.baidu.tieba.recapp.lego.view.a;
/* loaded from: classes3.dex */
public class b extends a {
    private View gEd;
    private LoopADView gEe;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.recapp.lego.view.a
    protected int getCustomLayout() {
        return d.h.card_ad_loop_pic;
    }

    @Override // com.baidu.tieba.recapp.lego.view.a
    protected void cL(View view) {
        this.gEd = view.findViewById(d.g.advert_loop_ad_container);
        this.gEe = (LoopADView) view.findViewById(d.g.loop_view);
    }

    @Override // com.baidu.tieba.recapp.lego.view.a
    protected void a(final AdCard adCard) {
        AdCard.c[] cVarArr = adCard.threadPicList;
        boolean xu = com.baidu.tbadk.core.i.xo().xu();
        this.gEe.setBussinessType(getBusinessType());
        if (!xu) {
            this.gEd.setVisibility(8);
            return;
        }
        this.gEd.setVisibility(0);
        F(this.gEd, 0);
        this.gEe.setOnClickCallbackListener(new LoopADView.a() { // from class: com.baidu.tieba.recapp.lego.view.b.1
            @Override // com.baidu.tieba.recapp.lego.view.LoopADView.a
            public void b(TbImageView tbImageView, AdCard.b bVar) {
                b.this.a(tbImageView, bVar, new a.View$OnClickListenerC0229a(adCard));
            }

            @Override // com.baidu.tieba.recapp.lego.view.LoopADView.a
            public String rR(String str) {
                return b.this.rO(am.d(str, 100, "..."));
            }

            @Override // com.baidu.tieba.recapp.lego.view.LoopADView.a
            public void reset() {
                if (b.this.gEd != null) {
                    b.this.gEd.setScrollX(0);
                }
            }
        });
        int i = this.gDN.getHeaderImg().getLayoutParams().width;
        if (!adCard.needResize) {
            this.gEe.a(cVarArr, 30, 0, 0, i);
        } else {
            this.gEe.a(cVarArr, 30, adCard.width, adCard.height, i);
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.a
    protected int getLayout() {
        return d.h.card_ad;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.a, com.baidu.tieba.lego.card.e.b
    public void a(AdCard adCard, int i) {
        super.a(adCard, i);
        if (this.gEe != null && this.gEe.getVisibility() == 0) {
            this.gEe.aNQ();
        }
    }

    private void F(View view, int i) {
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
