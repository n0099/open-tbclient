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
import com.baidu.tieba.f;
import com.baidu.tieba.recapp.lego.model.AdPost;
/* loaded from: classes3.dex */
public class AdPostImageView extends AdPostBaseView {
    private ConstrainImageGroup czb;
    private b<TbImageView> gtn;
    private b<ConstrainImageLayout> gto;

    public AdPostImageView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView
    protected int getCustomLayout() {
        return f.h.post_ad_image_stub;
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView
    protected void by(View view) {
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(f.e.tbds20);
        e eVar = new e(3);
        eVar.g(1.0d);
        this.czb = (ConstrainImageGroup) this.rootView.findViewById(f.g.card_home_page_normal_thread_img_layout);
        this.czb.setChildClickListener(this.cwv);
        this.czb.setImageMargin(dimensionPixelSize);
        this.czb.setImageProcessor(eVar);
        this.czb.setImageViewPool(this.gtn);
        this.czb.setConstrainLayoutPool(this.gto);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView
    protected void a(AdPost adPost) {
        if (adPost != null && adPost.getAdvertAppInfo() != null) {
            boolean tj = i.td().tj();
            if (adPost.feedData.bnG().size() == 0 || !tj) {
                this.czb.setVisibility(8);
                return;
            }
            this.czb.setVisibility(0);
            this.czb.setImageUrls(adPost.feedData.bnG());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView, com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPost adPost, int i) {
        super.a(adPost, i);
        this.czb.onChangeSkinType();
    }

    public void setConstrainLayoutPool(b<ConstrainImageLayout> bVar) {
        this.gto = bVar;
    }

    public void setConstrainImagePool(b<TbImageView> bVar) {
        this.gtn = bVar;
    }
}
