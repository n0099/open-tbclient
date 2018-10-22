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
    private ConstrainImageGroup cNn;
    private b<TbImageView> gIh;
    private b<ConstrainImageLayout> gIi;

    public AdPostImageView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView
    protected int getCustomLayout() {
        return e.h.post_ad_image_stub;
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView
    protected void bL(View view) {
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0175e.tbds20);
        com.baidu.tbadk.widget.layout.e eVar = new com.baidu.tbadk.widget.layout.e(3);
        eVar.g(1.0d);
        this.cNn = (ConstrainImageGroup) this.rootView.findViewById(e.g.card_home_page_normal_thread_img_layout);
        this.cNn.setChildClickListener(this.cKG);
        this.cNn.setImageMargin(dimensionPixelSize);
        this.cNn.setImageProcessor(eVar);
        this.cNn.setImageViewPool(this.gIh);
        this.cNn.setConstrainLayoutPool(this.gIi);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView
    protected void a(AdPost adPost) {
        if (adPost != null && adPost.getAdvertAppInfo() != null) {
            boolean ww = i.ws().ww();
            if (adPost.feedData.btC().size() == 0 || !ww) {
                this.cNn.setVisibility(8);
                return;
            }
            this.cNn.setVisibility(0);
            this.cNn.setImageUrls(adPost.feedData.btC());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView, com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPost adPost, int i) {
        super.a(adPost, i);
        this.cNn.onChangeSkinType();
    }

    public void setConstrainLayoutPool(b<ConstrainImageLayout> bVar) {
        this.gIi = bVar;
    }

    public void setConstrainImagePool(b<TbImageView> bVar) {
        this.gIh = bVar;
    }
}
