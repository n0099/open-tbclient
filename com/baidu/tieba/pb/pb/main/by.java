package com.baidu.tieba.pb.pb.main;

import android.widget.ImageView;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class by implements com.baidu.adp.lib.e.c<ImageView> {
    final /* synthetic */ PbActivity ewh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public by(PbActivity pbActivity) {
        this.ewh = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: SE */
    public ImageView fK() {
        ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(this.ewh.getPageContext().getPageActivity());
        boolean oQ = com.baidu.tbadk.core.r.oK().oQ();
        foreDrawableImageView.setDefaultBg(com.baidu.tbadk.core.util.as.getDrawable(w.e.common_color_10220));
        if (oQ) {
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
            if (com.baidu.tbadk.core.r.oK().oQ()) {
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
