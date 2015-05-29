package com.baidu.tieba.pb.pb.main;

import android.widget.ImageView;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
class ak implements com.baidu.adp.lib.e.c<ImageView> {
    final /* synthetic */ PbActivity bKT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(PbActivity pbActivity) {
        this.bKT = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: abd */
    public ImageView hk() {
        TbImageView tbImageView = new TbImageView(this.bKT.getPageContext().getPageActivity());
        boolean qg = com.baidu.tbadk.core.n.qc().qg();
        tbImageView.setDefaultBg(com.baidu.tbadk.core.util.ay.getDrawable(com.baidu.tieba.n.pb_default_image_bg));
        if (qg) {
            tbImageView.setAdjustViewBounds(false);
            tbImageView.setInterceptOnClick(false);
        } else {
            tbImageView.setDefaultResource(com.baidu.tieba.p.icon_click);
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
            if (com.baidu.tbadk.core.n.qc().qg()) {
                tbImageView.setAdjustViewBounds(false);
                tbImageView.setInterceptOnClick(false);
            } else {
                tbImageView.setDefaultResource(com.baidu.tieba.p.icon_click);
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
