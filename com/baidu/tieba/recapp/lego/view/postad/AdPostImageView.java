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
    private ConstrainImageGroup cyH;
    private b<TbImageView> goh;
    private b<ConstrainImageLayout> goi;

    public AdPostImageView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView
    protected int getCustomLayout() {
        return d.i.post_ad_image_stub;
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView
    protected void bu(View view) {
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds20);
        e eVar = new e(3);
        eVar.j(1.0d);
        this.cyH = (ConstrainImageGroup) this.rootView.findViewById(d.g.card_home_page_normal_thread_img_layout);
        this.cyH.setChildClickListener(this.cvP);
        this.cyH.setImageMargin(dimensionPixelSize);
        this.cyH.setImageProcessor(eVar);
        this.cyH.setImageViewPool(this.goh);
        this.cyH.setConstrainLayoutPool(this.goi);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView
    protected void a(AdPost adPost) {
        if (adPost != null && adPost.getAdvertAppInfo() != null) {
            boolean tz = i.tt().tz();
            if (adPost.feedData.boA().size() == 0 || !tz) {
                this.cyH.setVisibility(8);
                return;
            }
            this.cyH.setVisibility(0);
            this.cyH.setImageUrls(adPost.feedData.boA());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView, com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPost adPost, int i) {
        super.a(adPost, i);
        this.cyH.onChangeSkinType();
    }

    public void setConstrainLayoutPool(b<ConstrainImageLayout> bVar) {
        this.goi = bVar;
    }

    public void setConstrainImagePool(b<TbImageView> bVar) {
        this.goh = bVar;
    }
}
