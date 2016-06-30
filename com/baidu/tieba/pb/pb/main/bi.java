package com.baidu.tieba.pb.pb.main;

import android.widget.ImageView;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class bi implements com.baidu.adp.lib.f.c<ImageView> {
    final /* synthetic */ PbActivity dPF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(PbActivity pbActivity) {
        this.dPF = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: aFh */
    public ImageView dF() {
        ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(this.dPF.getPageContext().getPageActivity());
        boolean oc = com.baidu.tbadk.core.l.nW().oc();
        foreDrawableImageView.setDefaultBg(com.baidu.tbadk.core.util.av.getDrawable(u.d.common_color_10220));
        if (oc) {
            foreDrawableImageView.setAdjustViewBounds(false);
            foreDrawableImageView.setInterceptOnClick(false);
        } else {
            foreDrawableImageView.setDefaultResource(u.f.icon_click);
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
            foreDrawableImageView.setDefaultBgResource(u.d.cp_bg_line_c);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: c */
    public ImageView m(ImageView imageView) {
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            tbImageView.setTag(null);
            if (com.baidu.tbadk.core.l.nW().oc()) {
                tbImageView.setAdjustViewBounds(false);
                tbImageView.setInterceptOnClick(false);
            } else {
                tbImageView.setDefaultResource(u.f.icon_click);
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
            foreDrawableImageView.setDefaultBgResource(u.d.cp_bg_line_c);
        }
        return imageView;
    }
}
