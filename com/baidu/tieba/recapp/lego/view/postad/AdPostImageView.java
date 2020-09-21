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
/* loaded from: classes25.dex */
public class AdPostImageView extends AdPostBaseView {
    private ConstrainImageGroup hqS;
    private b<TbImageView> lQh;
    private b<ConstrainImageLayout> lQi;

    public AdPostImageView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView
    protected int getCustomLayout() {
        return R.layout.post_ad_image_stub;
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView
    protected void dq(View view) {
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);
        f fVar = new f(3);
        fVar.u(1.0d);
        this.hqS = (ConstrainImageGroup) this.rootView.findViewById(R.id.card_home_page_normal_thread_img_layout);
        this.hqS.setChildClickListener(this.hqX);
        this.hqS.setImageMargin(dimensionPixelSize);
        this.hqS.setImageProcessor(fVar);
        this.hqS.setImageViewPool(this.lQh);
        this.hqS.setConstrainLayoutPool(this.lQi);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView
    protected void a(AdPost adPost) {
        if (adPost != null && adPost.getAdvertAppInfo() != null) {
            boolean isShowImages = k.bcG().isShowImages();
            if (adPost.feedData.drl().size() == 0 || !isShowImages) {
                this.hqS.setVisibility(8);
                return;
            }
            this.hqS.setVisibility(0);
            List<String> drl = adPost.feedData.drl();
            if (!y.isEmpty(drl)) {
                LinkedList linkedList = new LinkedList();
                for (String str : drl) {
                    MediaData mediaData = new MediaData();
                    mediaData.setPic(str);
                    mediaData.setThumbnails_url(str);
                    linkedList.add(mediaData);
                }
                this.hqS.setImageMediaList(linkedList);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView, com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPost adPost, int i) {
        super.a(adPost, i);
        this.hqS.onChangeSkinType();
    }

    public void setConstrainLayoutPool(b<ConstrainImageLayout> bVar) {
        this.lQi = bVar;
    }

    public void setConstrainImagePool(b<TbImageView> bVar) {
        this.lQh = bVar;
    }
}
