package com.baidu.tieba.pb.pb.sub;

import android.widget.ImageView;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class n implements com.baidu.adp.lib.f.c<ImageView> {
    final /* synthetic */ NewSubPbActivity dqn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(NewSubPbActivity newSubPbActivity) {
        this.dqn = newSubPbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: awW */
    public ImageView dE() {
        ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(this.dqn.getPageContext().getPageActivity());
        boolean oh = com.baidu.tbadk.core.l.ob().oh();
        foreDrawableImageView.setDefaultBg(at.getDrawable(t.d.pb_default_image_bg));
        if (oh) {
            foreDrawableImageView.setAdjustViewBounds(false);
            foreDrawableImageView.setInterceptOnClick(false);
        } else {
            foreDrawableImageView.setDefaultResource(t.f.icon_click);
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
            foreDrawableImageView.setDefaultBgResource(t.d.cp_bg_line_c);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: c */
    public ImageView m(ImageView imageView) {
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            tbImageView.setTag(null);
            if (com.baidu.tbadk.core.l.ob().oh()) {
                tbImageView.setAdjustViewBounds(false);
                tbImageView.setInterceptOnClick(false);
            } else {
                tbImageView.setDefaultResource(t.f.icon_click);
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
            foreDrawableImageView.setDefaultBgResource(t.d.cp_bg_line_c);
        }
        return imageView;
    }
}
