package com.baidu.tieba.recapp.lego.view.a;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.f;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.lego.model.AdPost;
/* loaded from: classes3.dex */
public class b extends a {
    private ConstrainImageGroup cWW;
    private com.baidu.adp.lib.e.b<TbImageView> gGP;
    private com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> gGQ;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.recapp.lego.view.a.a
    protected int getCustomLayout() {
        return d.h.post_ad_image_stub;
    }

    @Override // com.baidu.tieba.recapp.lego.view.a.a
    protected void cL(View view) {
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds20);
        f fVar = new f(3);
        fVar.h(1.0d);
        this.cWW = (ConstrainImageGroup) this.rootView.findViewById(d.g.card_home_page_normal_thread_img_layout);
        this.cWW.setChildClickListener(this.cVA);
        this.cWW.setImageMargin(dimensionPixelSize);
        this.cWW.setImageProcessor(fVar);
        this.cWW.setImageViewPool(this.gGP);
        this.cWW.setConstrainLayoutPool(this.gGQ);
    }

    @Override // com.baidu.tieba.recapp.lego.view.a.a
    protected void a(AdPost adPost) {
        if (adPost != null && adPost.getAdvertAppInfo() != null) {
            boolean xu = i.xo().xu();
            if (adPost.feedData.bow().size() == 0 || !xu) {
                this.cWW.setVisibility(8);
                return;
            }
            this.cWW.setVisibility(0);
            this.cWW.setImageUrls(adPost.feedData.bow());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.recapp.lego.view.a.a, com.baidu.tieba.recapp.lego.view.a.d
    public void a(AdPost adPost, int i) {
        super.a(adPost, i);
        this.cWW.onChangeSkinType();
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.e.b<com.baidu.tbadk.widget.layout.b> bVar) {
        this.gGQ = bVar;
    }

    public void setConstrainImagePool(com.baidu.adp.lib.e.b<TbImageView> bVar) {
        this.gGP = bVar;
    }
}
