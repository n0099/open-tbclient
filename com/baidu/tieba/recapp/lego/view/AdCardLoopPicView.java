package com.baidu.tieba.recapp.lego.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.lego.view.AdCardBaseView;
import com.baidu.tieba.recapp.lego.view.LoopADView;
/* loaded from: classes26.dex */
public class AdCardLoopPicView extends AdCardBaseView {
    private View mvE;
    private LoopADView mvF;

    public AdCardLoopPicView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected int getCustomLayout() {
        return R.layout.card_ad_loop_pic;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void dD(View view) {
        this.mvE = view.findViewById(R.id.advert_loop_ad_container);
        this.mvF = (LoopADView) view.findViewById(R.id.loop_view);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void a(final AdCard adCard) {
        AdCard.d[] dVarArr = adCard.threadPicList;
        boolean isShowImages = k.bjH().isShowImages();
        this.mvF.setBussinessType(getBusinessType());
        if (!isShowImages) {
            this.mvE.setVisibility(8);
            return;
        }
        this.mvE.setVisibility(0);
        y(this.mvE, 0);
        this.mvF.setOnClickCallbackListener(new LoopADView.a() { // from class: com.baidu.tieba.recapp.lego.view.AdCardLoopPicView.1
            @Override // com.baidu.tieba.recapp.lego.view.LoopADView.a
            public void b(TbImageView tbImageView, AdCard.b bVar) {
                AdCardLoopPicView.this.a(tbImageView, bVar, new AdCardBaseView.b(adCard));
            }

            @Override // com.baidu.tieba.recapp.lego.view.LoopADView.a
            public String Rz(String str) {
                return at.cutStringWithSuffix(str, 100, StringHelper.STRING_MORE);
            }

            @Override // com.baidu.tieba.recapp.lego.view.LoopADView.a
            public void reset() {
                if (AdCardLoopPicView.this.mvE != null) {
                    AdCardLoopPicView.this.mvE.setScrollX(0);
                }
            }
        });
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds92);
        if (!adCard.needResize) {
            this.mvF.a(dVarArr, 30, 0, 0, dimensionPixelSize);
        } else {
            this.mvF.a(dVarArr, 30, adCard.width, adCard.height, dimensionPixelSize);
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
        if (this.mvF != null && this.mvF.getVisibility() == 0) {
            this.mvF.changeSkin();
        }
    }

    private void y(View view, int i) {
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
