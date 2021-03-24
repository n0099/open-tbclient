package com.baidu.tieba.lego.card.view;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.lego.card.model.BigImgCard;
import d.b.b.e.p.l;
/* loaded from: classes4.dex */
public class BigImgView extends BaseCardView<BigImgCard> {
    public TbImageView r;

    public BigImgView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: K */
    public void y(BigImgCard bigImgCard, int i) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: L */
    public void z(BigImgCard bigImgCard) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.r.getLayoutParams();
        if (bigImgCard.getRatio() > 0.0d) {
            double ratio = bigImgCard.getRatio();
            double k = l.k(getContext());
            Double.isNaN(k);
            int i = (int) (ratio * k);
            if (Math.abs(i - layoutParams.height) > 10) {
                layoutParams.height = i;
                this.r.setLayoutParams(layoutParams);
            }
        } else {
            layoutParams.height = (int) ((l.k(getContext()) * 0.5f) + 0.5f);
            this.r.setLayoutParams(layoutParams);
        }
        this.r.W(bigImgCard.getUrl(), 10, false);
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public View v() {
        TbImageView tbImageView = new TbImageView(getContext());
        this.r = tbImageView;
        return tbImageView;
    }
}
