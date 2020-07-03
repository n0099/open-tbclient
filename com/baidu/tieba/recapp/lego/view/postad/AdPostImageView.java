package com.baidu.tieba.recapp.lego.view.postad;

import android.view.View;
import com.baidu.adp.lib.d.b;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.layout.f;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.AdPost;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes13.dex */
public class AdPostImageView extends AdPostBaseView {
    private ConstrainImageGroup gRn;
    private b<TbImageView> ljk;
    private b<ConstrainImageLayout> ljl;

    public AdPostImageView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView
    protected int getCustomLayout() {
        return R.layout.post_ad_image_stub;
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView
    protected void cY(View view) {
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);
        f fVar = new f(3);
        fVar.o(1.0d);
        this.gRn = (ConstrainImageGroup) this.rootView.findViewById(R.id.card_home_page_normal_thread_img_layout);
        this.gRn.setChildClickListener(this.gRs);
        this.gRn.setImageMargin(dimensionPixelSize);
        this.gRn.setImageProcessor(fVar);
        this.gRn.setImageViewPool(this.ljk);
        this.gRn.setConstrainLayoutPool(this.ljl);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView
    protected void a(AdPost adPost) {
        if (adPost != null && adPost.getAdvertAppInfo() != null) {
            boolean isShowImages = k.aPA().isShowImages();
            if (adPost.feedData.cZj().size() == 0 || !isShowImages) {
                this.gRn.setVisibility(8);
                return;
            }
            this.gRn.setVisibility(0);
            List<String> cZj = adPost.feedData.cZj();
            if (!w.isEmpty(cZj)) {
                LinkedList linkedList = new LinkedList();
                for (String str : cZj) {
                    MediaData mediaData = new MediaData();
                    mediaData.setPic(str);
                    mediaData.setThumbnails_url(str);
                    linkedList.add(mediaData);
                }
                this.gRn.setImageMediaList(linkedList);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView, com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPost adPost, int i) {
        super.a(adPost, i);
        this.gRn.onChangeSkinType();
    }

    public void setConstrainLayoutPool(b<ConstrainImageLayout> bVar) {
        this.ljl = bVar;
    }

    public void setConstrainImagePool(b<TbImageView> bVar) {
        this.ljk = bVar;
    }
}
