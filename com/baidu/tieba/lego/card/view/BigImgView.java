package com.baidu.tieba.lego.card.view;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.lego.card.model.BigImgCard;
import d.a.c.e.p.l;
/* loaded from: classes4.dex */
public class BigImgView extends BaseCardView<BigImgCard> {
    public TbImageView r;

    public BigImgView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: I */
    public void w(BigImgCard bigImgCard, int i2) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: J */
    public void x(BigImgCard bigImgCard) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.r.getLayoutParams();
        if (bigImgCard.getRatio() > 0.0d) {
            int ratio = (int) (bigImgCard.getRatio() * l.k(getContext()));
            if (Math.abs(ratio - layoutParams.height) > 10) {
                layoutParams.height = ratio;
                this.r.setLayoutParams(layoutParams);
            }
        } else {
            layoutParams.height = (int) ((l.k(getContext()) * 0.5f) + 0.5f);
            this.r.setLayoutParams(layoutParams);
        }
        this.r.V(bigImgCard.getUrl(), 10, false);
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public View t() {
        TbImageView tbImageView = new TbImageView(getContext());
        this.r = tbImageView;
        return tbImageView;
    }
}
