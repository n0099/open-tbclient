package com.baidu.tieba.recapp.lego.view.postad;

import android.view.View;
import com.baidu.adp.lib.e.b;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.e;
import com.baidu.tieba.recapp.lego.model.AdPost;
/* loaded from: classes3.dex */
public class AdPostImageView extends AdPostBaseView {
    private ConstrainImageGroup cOt;
    private b<TbImageView> gJI;
    private b<ConstrainImageLayout> gJJ;

    public AdPostImageView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView
    protected int getCustomLayout() {
        return e.h.post_ad_image_stub;
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView
    protected void bN(View view) {
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0200e.tbds20);
        com.baidu.tbadk.widget.layout.e eVar = new com.baidu.tbadk.widget.layout.e(3);
        eVar.g(1.0d);
        this.cOt = (ConstrainImageGroup) this.rootView.findViewById(e.g.card_home_page_normal_thread_img_layout);
        this.cOt.setChildClickListener(this.cLM);
        this.cOt.setImageMargin(dimensionPixelSize);
        this.cOt.setImageProcessor(eVar);
        this.cOt.setImageViewPool(this.gJI);
        this.cOt.setConstrainLayoutPool(this.gJJ);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView
    protected void a(AdPost adPost) {
        if (adPost != null && adPost.getAdvertAppInfo() != null) {
            boolean wE = i.wA().wE();
            if (adPost.feedData.bsY().size() == 0 || !wE) {
                this.cOt.setVisibility(8);
                return;
            }
            this.cOt.setVisibility(0);
            this.cOt.setImageUrls(adPost.feedData.bsY());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView, com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPost adPost, int i) {
        super.a(adPost, i);
        this.cOt.onChangeSkinType();
    }

    public void setConstrainLayoutPool(b<ConstrainImageLayout> bVar) {
        this.gJJ = bVar;
    }

    public void setConstrainImagePool(b<TbImageView> bVar) {
        this.gJI = bVar;
    }
}
