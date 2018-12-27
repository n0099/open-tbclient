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
    private ConstrainImageGroup cXQ;
    private b<TbImageView> gTq;
    private b<ConstrainImageLayout> gTr;

    public AdPostImageView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView
    protected int getCustomLayout() {
        return e.h.post_ad_image_stub;
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView
    protected void bQ(View view) {
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.tbds20);
        com.baidu.tbadk.widget.layout.e eVar = new com.baidu.tbadk.widget.layout.e(3);
        eVar.g(1.0d);
        this.cXQ = (ConstrainImageGroup) this.rootView.findViewById(e.g.card_home_page_normal_thread_img_layout);
        this.cXQ.setChildClickListener(this.cVj);
        this.cXQ.setImageMargin(dimensionPixelSize);
        this.cXQ.setImageProcessor(eVar);
        this.cXQ.setImageViewPool(this.gTq);
        this.cXQ.setConstrainLayoutPool(this.gTr);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView
    protected void a(AdPost adPost) {
        if (adPost != null && adPost.getAdvertAppInfo() != null) {
            boolean xI = i.xE().xI();
            if (adPost.feedData.bvC().size() == 0 || !xI) {
                this.cXQ.setVisibility(8);
                return;
            }
            this.cXQ.setVisibility(0);
            this.cXQ.setImageUrls(adPost.feedData.bvC());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView, com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPost adPost, int i) {
        super.a(adPost, i);
        this.cXQ.onChangeSkinType();
    }

    public void setConstrainLayoutPool(b<ConstrainImageLayout> bVar) {
        this.gTr = bVar;
    }

    public void setConstrainImagePool(b<TbImageView> bVar) {
        this.gTq = bVar;
    }
}
