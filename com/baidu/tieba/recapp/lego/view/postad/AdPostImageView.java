package com.baidu.tieba.recapp.lego.view.postad;

import android.view.View;
import com.baidu.adp.lib.d.b;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.layout.f;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.AdPost;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes26.dex */
public class AdPostImageView extends AdPostBaseView {
    private ConstrainImageGroup hYg;
    private b<TbImageView> mxU;
    private b<ConstrainImageLayout> mxV;

    public AdPostImageView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView
    protected int getCustomLayout() {
        return R.layout.post_ad_image_stub;
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView
    protected void dD(View view) {
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);
        f fVar = new f(3);
        fVar.y(1.0d);
        this.hYg = (ConstrainImageGroup) this.rootView.findViewById(R.id.card_home_page_normal_thread_img_layout);
        this.hYg.setChildClickListener(this.hYl);
        this.hYg.setImageMargin(dimensionPixelSize);
        this.hYg.setImageProcessor(fVar);
        this.hYg.setImageViewPool(this.mxU);
        this.hYg.setConstrainLayoutPool(this.mxV);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView
    protected void a(AdPost adPost) {
        if (adPost != null && adPost.getAdvertAppInfo() != null) {
            boolean isShowImages = k.bjH().isShowImages();
            if (adPost.feedData.dAF().size() == 0 || !isShowImages) {
                this.hYg.setVisibility(8);
                return;
            }
            this.hYg.setVisibility(0);
            List<String> dAF = adPost.feedData.dAF();
            if (!y.isEmpty(dAF)) {
                LinkedList linkedList = new LinkedList();
                for (String str : dAF) {
                    MediaData mediaData = new MediaData();
                    mediaData.setPic(str);
                    mediaData.setThumbnails_url(str);
                    linkedList.add(mediaData);
                }
                this.hYg.setImageMediaList(linkedList);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView, com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPost adPost, int i) {
        super.a(adPost, i);
        this.hYg.onChangeSkinType();
    }

    public void setConstrainLayoutPool(b<ConstrainImageLayout> bVar) {
        this.mxV = bVar;
    }

    public void setConstrainImagePool(b<TbImageView> bVar) {
        this.mxU = bVar;
    }
}
