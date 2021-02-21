package com.baidu.tieba.lego.card.view;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.lego.card.model.BigImgCard;
/* loaded from: classes9.dex */
public class BigImgView extends BaseCardView<BigImgCard> {
    private TbImageView abB;

    public BigImgView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View dbV() {
        this.abB = new TbImageView(getContext());
        return this.abB;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(BigImgCard bigImgCard, int i) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void d(BigImgCard bigImgCard) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.abB.getLayoutParams();
        if (bigImgCard.getRatio() > 0.0d) {
            int ratio = (int) (bigImgCard.getRatio() * com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()));
            if (Math.abs(ratio - layoutParams.height) > 10) {
                layoutParams.height = ratio;
                this.abB.setLayoutParams(layoutParams);
            }
        } else {
            layoutParams.height = (int) ((com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) * 0.5f) + 0.5f);
            this.abB.setLayoutParams(layoutParams);
        }
        this.abB.startLoad(bigImgCard.getUrl(), 10, false);
    }
}
