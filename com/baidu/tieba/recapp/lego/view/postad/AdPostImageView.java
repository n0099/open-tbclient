package com.baidu.tieba.recapp.lego.view.postad;

import android.view.View;
import com.baidu.adp.lib.e.b;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.layout.e;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.lego.model.AdPost;
/* loaded from: classes3.dex */
public class AdPostImageView extends AdPostBaseView {
    private ConstrainImageGroup cze;
    private b<TbImageView> gtk;
    private b<ConstrainImageLayout> gtl;

    public AdPostImageView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView
    protected int getCustomLayout() {
        return d.h.post_ad_image_stub;
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView
    protected void by(View view) {
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds20);
        e eVar = new e(3);
        eVar.h(1.0d);
        this.cze = (ConstrainImageGroup) this.rootView.findViewById(d.g.card_home_page_normal_thread_img_layout);
        this.cze.setChildClickListener(this.cwy);
        this.cze.setImageMargin(dimensionPixelSize);
        this.cze.setImageProcessor(eVar);
        this.cze.setImageViewPool(this.gtk);
        this.cze.setConstrainLayoutPool(this.gtl);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView
    protected void a(AdPost adPost) {
        if (adPost != null && adPost.getAdvertAppInfo() != null) {
            boolean tk = i.te().tk();
            if (adPost.feedData.bnF().size() == 0 || !tk) {
                this.cze.setVisibility(8);
                return;
            }
            this.cze.setVisibility(0);
            this.cze.setImageUrls(adPost.feedData.bnF());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView, com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPost adPost, int i) {
        super.a(adPost, i);
        this.cze.onChangeSkinType();
    }

    public void setConstrainLayoutPool(b<ConstrainImageLayout> bVar) {
        this.gtl = bVar;
    }

    public void setConstrainImagePool(b<TbImageView> bVar) {
        this.gtk = bVar;
    }
}
