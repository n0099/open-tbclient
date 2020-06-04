package com.baidu.tieba.recapp.lego.view.postad;

import android.view.View;
import com.baidu.adp.lib.d.b;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.v;
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
    private ConstrainImageGroup gEx;
    private b<TbImageView> kPr;
    private b<ConstrainImageLayout> kPs;

    public AdPostImageView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView
    protected int getCustomLayout() {
        return R.layout.post_ad_image_stub;
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView
    protected void cX(View view) {
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);
        f fVar = new f(3);
        fVar.o(1.0d);
        this.gEx = (ConstrainImageGroup) this.rootView.findViewById(R.id.card_home_page_normal_thread_img_layout);
        this.gEx.setChildClickListener(this.gEC);
        this.gEx.setImageMargin(dimensionPixelSize);
        this.gEx.setImageProcessor(fVar);
        this.gEx.setImageViewPool(this.kPr);
        this.gEx.setConstrainLayoutPool(this.kPs);
    }

    @Override // com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView
    protected void a(AdPost adPost) {
        if (adPost != null && adPost.getAdvertAppInfo() != null) {
            boolean isShowImages = k.aNQ().isShowImages();
            if (adPost.feedData.cUT().size() == 0 || !isShowImages) {
                this.gEx.setVisibility(8);
                return;
            }
            this.gEx.setVisibility(0);
            List<String> cUT = adPost.feedData.cUT();
            if (!v.isEmpty(cUT)) {
                LinkedList linkedList = new LinkedList();
                for (String str : cUT) {
                    MediaData mediaData = new MediaData();
                    mediaData.setPic(str);
                    mediaData.setThumbnails_url(str);
                    linkedList.add(mediaData);
                }
                this.gEx.setImageMediaList(linkedList);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.recapp.lego.view.postad.AdPostBaseView, com.baidu.tieba.recapp.lego.view.postad.PostAdBaseView
    public void a(AdPost adPost, int i) {
        super.a(adPost, i);
        this.gEx.onChangeSkinType();
    }

    public void setConstrainLayoutPool(b<ConstrainImageLayout> bVar) {
        this.kPs = bVar;
    }

    public void setConstrainImagePool(b<TbImageView> bVar) {
        this.kPr = bVar;
    }
}
