package com.baidu.tieba.pb.main;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
class b implements com.baidu.adp.lib.d.c<ImageView> {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.d.c
    /* renamed from: b */
    public ImageView a() {
        Drawable drawable;
        TbImageView tbImageView = new TbImageView(this.a);
        boolean f = com.baidu.tbadk.core.h.a().f();
        if (TbadkApplication.m252getInst().getSkinType() == 1) {
            drawable = this.a.getResources().getDrawable(com.baidu.tieba.r.pb_default_image_bg_1);
        } else {
            drawable = this.a.getResources().getDrawable(com.baidu.tieba.r.pb_default_image_bg);
        }
        tbImageView.setDefaultBg(drawable);
        if (f) {
            tbImageView.setAdjustViewBounds(false);
            tbImageView.setInterceptOnClick(false);
        } else {
            tbImageView.setNightDefaultResource(com.baidu.tieba.t.icon_click_1);
            tbImageView.setDefaultResource(com.baidu.tieba.t.icon_click);
            tbImageView.setAdjustViewBounds(true);
            tbImageView.setInterceptOnClick(true);
        }
        return tbImageView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.d.c
    public void a(ImageView imageView) {
        imageView.setBackgroundDrawable(null);
        imageView.setImageDrawable(null);
        imageView.setTag(null);
        imageView.setOnClickListener(null);
        if (imageView instanceof TbImageView) {
            ((TbImageView) imageView).e();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.d.c
    public ImageView b(ImageView imageView) {
        if (imageView instanceof TbImageView) {
            TbImageView tbImageView = (TbImageView) imageView;
            tbImageView.setTag(null);
            TbadkApplication.m252getInst().getSkinType();
            if (com.baidu.tbadk.core.h.a().f()) {
                tbImageView.setAdjustViewBounds(false);
                tbImageView.setInterceptOnClick(false);
            } else {
                tbImageView.setNightDefaultResource(com.baidu.tieba.t.icon_click_1);
                tbImageView.setDefaultResource(com.baidu.tieba.t.icon_click);
                tbImageView.setAdjustViewBounds(true);
                tbImageView.setInterceptOnClick(true);
            }
        }
        return imageView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.d.c
    public ImageView c(ImageView imageView) {
        imageView.setBackgroundDrawable(null);
        imageView.setImageDrawable(null);
        imageView.setTag(null);
        imageView.setOnClickListener(null);
        if (imageView instanceof TbImageView) {
            ((TbImageView) imageView).e();
        }
        return imageView;
    }
}
