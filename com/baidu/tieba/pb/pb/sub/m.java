package com.baidu.tieba.pb.pb.sub;

import android.widget.ImageView;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class m implements com.baidu.adp.lib.f.c<ImageView> {
    final /* synthetic */ NewSubPbActivity cLc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(NewSubPbActivity newSubPbActivity) {
        this.cLc = newSubPbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: alz */
    public ImageView hc() {
        ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(this.cLc.getPageContext().getPageActivity());
        boolean qW = com.baidu.tbadk.core.m.qQ().qW();
        foreDrawableImageView.setDefaultBg(as.getDrawable(n.d.pb_default_image_bg));
        if (qW) {
            foreDrawableImageView.setAdjustViewBounds(false);
            foreDrawableImageView.setInterceptOnClick(false);
        } else {
            foreDrawableImageView.setDefaultResource(n.f.icon_click);
            foreDrawableImageView.setAdjustViewBounds(true);
            foreDrawableImageView.setInterceptOnClick(true);
        }
        return foreDrawableImageView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: b */
    public void l(ImageView imageView) {
        imageView.setBackgroundDrawable(null);
        imageView.setImageDrawable(null);
        imageView.setTag(null);
        imageView.setOnClickListener(null);
        if (imageView instanceof ForeDrawableImageView) {
            ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
            ((ForeDrawableImageView) imageView).stopLoading();
            foreDrawableImageView.setForegroundDrawable(0);
            foreDrawableImageView.setDefaultBgResource(n.d.cp_bg_line_c);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: c */
    public ImageView m(ImageView imageView) {
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            tbImageView.setTag(null);
            if (com.baidu.tbadk.core.m.qQ().qW()) {
                tbImageView.setAdjustViewBounds(false);
                tbImageView.setInterceptOnClick(false);
            } else {
                tbImageView.setDefaultResource(n.f.icon_click);
                tbImageView.setAdjustViewBounds(true);
                tbImageView.setInterceptOnClick(true);
            }
        }
        return imageView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: d */
    public ImageView n(ImageView imageView) {
        imageView.setBackgroundDrawable(null);
        imageView.setImageDrawable(null);
        imageView.setTag(null);
        imageView.setOnClickListener(null);
        if (imageView instanceof ForeDrawableImageView) {
            ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
            ((ForeDrawableImageView) imageView).stopLoading();
            foreDrawableImageView.setForegroundDrawable(0);
            foreDrawableImageView.setDefaultBgResource(n.d.cp_bg_line_c);
        }
        return imageView;
    }
}
