package com.baidu.tieba.pb.pb.main;

import android.widget.ImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class am implements com.baidu.adp.lib.e.c<ImageView> {
    final /* synthetic */ PbActivity cjN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(PbActivity pbActivity) {
        this.cjN = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: aga */
    public ImageView ha() {
        com.baidu.tbadk.widget.d dVar = new com.baidu.tbadk.widget.d(this.cjN.getPageContext().getPageActivity());
        boolean qZ = com.baidu.tbadk.core.m.qV().qZ();
        dVar.setDefaultBg(com.baidu.tbadk.core.util.an.getDrawable(i.c.pb_default_image_bg));
        if (qZ) {
            dVar.setAdjustViewBounds(false);
            dVar.setInterceptOnClick(false);
        } else {
            dVar.setDefaultResource(i.e.icon_click);
            dVar.setAdjustViewBounds(true);
            dVar.setInterceptOnClick(true);
        }
        return dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: b */
    public void l(ImageView imageView) {
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
    public ImageView m(ImageView imageView) {
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            tbImageView.setTag(null);
            if (com.baidu.tbadk.core.m.qV().qZ()) {
                tbImageView.setAdjustViewBounds(false);
                tbImageView.setInterceptOnClick(false);
            } else {
                tbImageView.setDefaultResource(i.e.icon_click);
                tbImageView.setAdjustViewBounds(true);
                tbImageView.setInterceptOnClick(true);
            }
        }
        return imageView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: d */
    public ImageView n(ImageView imageView) {
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
