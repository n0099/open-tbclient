package com.baidu.tieba.pb.pb.main;

import android.widget.ImageView;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class bn implements com.baidu.adp.lib.e.c<ImageView> {
    final /* synthetic */ PbActivity ejU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(PbActivity pbActivity) {
        this.ejU = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: Qf */
    public ImageView fK() {
        ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(this.ejU.getPageContext().getPageActivity());
        boolean pu = com.baidu.tbadk.core.q.po().pu();
        foreDrawableImageView.setDefaultBg(com.baidu.tbadk.core.util.aq.getDrawable(w.e.common_color_10220));
        if (pu) {
            foreDrawableImageView.setAdjustViewBounds(false);
            foreDrawableImageView.setInterceptOnClick(false);
        } else {
            foreDrawableImageView.setDefaultResource(w.g.icon_click);
            foreDrawableImageView.setAdjustViewBounds(true);
            foreDrawableImageView.setInterceptOnClick(true);
        }
        return foreDrawableImageView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: g */
    public void o(ImageView imageView) {
        imageView.setBackgroundDrawable(null);
        imageView.setImageDrawable(null);
        imageView.setTag(null);
        imageView.setOnClickListener(null);
        if (imageView instanceof ForeDrawableImageView) {
            ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
            ((ForeDrawableImageView) imageView).stopLoading();
            foreDrawableImageView.setForegroundDrawable(0);
            foreDrawableImageView.setDefaultBgResource(w.e.common_color_10220);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: f */
    public ImageView p(ImageView imageView) {
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            tbImageView.setTag(null);
            if (com.baidu.tbadk.core.q.po().pu()) {
                tbImageView.setAdjustViewBounds(false);
                tbImageView.setInterceptOnClick(false);
            } else {
                tbImageView.setDefaultResource(w.g.icon_click);
                tbImageView.setAdjustViewBounds(true);
                tbImageView.setInterceptOnClick(true);
            }
        }
        return imageView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: h */
    public ImageView q(ImageView imageView) {
        imageView.setBackgroundDrawable(null);
        imageView.setImageDrawable(null);
        imageView.setTag(null);
        imageView.setOnClickListener(null);
        if (imageView instanceof ForeDrawableImageView) {
            ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
            ((ForeDrawableImageView) imageView).stopLoading();
            foreDrawableImageView.setForegroundDrawable(0);
            foreDrawableImageView.setDefaultBgResource(w.e.common_color_10220);
        }
        return imageView;
    }
}
