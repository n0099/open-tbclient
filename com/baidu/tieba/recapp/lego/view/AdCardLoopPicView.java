package com.baidu.tieba.recapp.lego.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.lego.view.AdCardBaseView;
import com.baidu.tieba.recapp.lego.view.LoopADView;
/* loaded from: classes11.dex */
public class AdCardLoopPicView extends AdCardBaseView {
    private View jHw;
    private LoopADView jHx;

    public AdCardLoopPicView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected int getCustomLayout() {
        return R.layout.card_ad_loop_pic;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void cN(View view) {
        this.jHw = view.findViewById(R.id.advert_loop_ad_container);
        this.jHx = (LoopADView) view.findViewById(R.id.loop_view);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void a(final AdCard adCard) {
        AdCard.d[] dVarArr = adCard.threadPicList;
        boolean isShowImages = i.axy().isShowImages();
        this.jHx.setBussinessType(getBusinessType());
        if (!isShowImages) {
            this.jHw.setVisibility(8);
            return;
        }
        this.jHw.setVisibility(0);
        t(this.jHw, 0);
        this.jHx.setOnClickCallbackListener(new LoopADView.a() { // from class: com.baidu.tieba.recapp.lego.view.AdCardLoopPicView.1
            @Override // com.baidu.tieba.recapp.lego.view.LoopADView.a
            public void b(TbImageView tbImageView, AdCard.b bVar) {
                AdCardLoopPicView.this.a(tbImageView, bVar, new AdCardBaseView.b(adCard));
            }

            @Override // com.baidu.tieba.recapp.lego.view.LoopADView.a
            public String HF(String str) {
                return AdCardLoopPicView.this.HC(aq.cutStringWithSuffix(str, 100, StringHelper.STRING_MORE));
            }

            @Override // com.baidu.tieba.recapp.lego.view.LoopADView.a
            public void reset() {
                if (AdCardLoopPicView.this.jHw != null) {
                    AdCardLoopPicView.this.jHw.setScrollX(0);
                }
            }
        });
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds92);
        if (!adCard.needResize) {
            this.jHx.a(dVarArr, 30, 0, 0, dimensionPixelSize);
        } else {
            this.jHx.a(dVarArr, 30, adCard.width, adCard.height, dimensionPixelSize);
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected int getLayout() {
        return R.layout.card_ad;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView, com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(AdCard adCard, int i) {
        super.a(adCard, i);
        if (this.jHx != null && this.jHx.getVisibility() == 0) {
            this.jHx.bFO();
        }
    }

    private void t(View view, int i) {
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
