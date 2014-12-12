package com.baidu.tieba.pb.main;

import android.widget.ImageView;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
class an implements com.baidu.adp.lib.e.c<ImageView> {
    final /* synthetic */ PbActivity bzj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(PbActivity pbActivity) {
        this.bzj = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: WT */
    public ImageView ed() {
        TbImageView tbImageView = new TbImageView(this.bzj.getPageContext().getPageActivity());
        boolean mg = com.baidu.tbadk.core.l.mc().mg();
        tbImageView.setDefaultBg(com.baidu.tbadk.core.util.ax.getDrawable(com.baidu.tieba.t.pb_default_image_bg));
        if (mg) {
            tbImageView.setAdjustViewBounds(false);
            tbImageView.setInterceptOnClick(false);
        } else {
            tbImageView.setDefaultResource(com.baidu.tieba.v.icon_click);
            tbImageView.setAdjustViewBounds(true);
            tbImageView.setInterceptOnClick(true);
        }
        return tbImageView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: b */
    public void k(ImageView imageView) {
        imageView.setBackgroundDrawable(null);
        imageView.setImageDrawable(null);
        imageView.setTag(null);
        imageView.setOnClickListener(null);
        if (imageView instanceof TbImageView) {
            ((TbImageView) imageView).stopLoading();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: c */
    public ImageView l(ImageView imageView) {
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            tbImageView.setTag(null);
            if (com.baidu.tbadk.core.l.mc().mg()) {
                tbImageView.setAdjustViewBounds(false);
                tbImageView.setInterceptOnClick(false);
            } else {
                tbImageView.setDefaultResource(com.baidu.tieba.v.icon_click);
                tbImageView.setAdjustViewBounds(true);
                tbImageView.setInterceptOnClick(true);
            }
        }
        return imageView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: d */
    public ImageView m(ImageView imageView) {
        imageView.setBackgroundDrawable(null);
        imageView.setImageDrawable(null);
        imageView.setTag(null);
        imageView.setOnClickListener(null);
        if (imageView instanceof TbImageView) {
            ((TbImageView) imageView).stopLoading();
        }
        return imageView;
    }
}
