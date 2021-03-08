package com.baidu.tieba.lego.card.view;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.lego.card.model.BigImgCard;
/* loaded from: classes8.dex */
public class BigImgView extends BaseCardView<BigImgCard> {
    private TbImageView acX;

    public BigImgView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View dce() {
        this.acX = new TbImageView(getContext());
        return this.acX;
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
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.acX.getLayoutParams();
        if (bigImgCard.getRatio() > 0.0d) {
            int ratio = (int) (bigImgCard.getRatio() * com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()));
            if (Math.abs(ratio - layoutParams.height) > 10) {
                layoutParams.height = ratio;
                this.acX.setLayoutParams(layoutParams);
            }
        } else {
            layoutParams.height = (int) ((com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) * 0.5f) + 0.5f);
            this.acX.setLayoutParams(layoutParams);
        }
        this.acX.startLoad(bigImgCard.getUrl(), 10, false);
    }
}
