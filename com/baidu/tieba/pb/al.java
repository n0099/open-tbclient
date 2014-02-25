package com.baidu.tieba.pb;

import android.widget.ImageView;
/* loaded from: classes.dex */
class al implements com.baidu.adp.lib.d.c<ImageView> {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.d.c
    /* renamed from: b */
    public ImageView a() {
        return new com.baidu.tieba.view.cb(this.a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.d.c
    public void a(ImageView imageView) {
        imageView.setBackgroundDrawable(null);
        imageView.setImageDrawable(null);
        imageView.setTag(null);
        imageView.setOnClickListener(null);
        if (imageView instanceof com.baidu.tieba.view.cb) {
            ((com.baidu.tieba.view.cb) imageView).i();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.d.c
    public ImageView b(ImageView imageView) {
        if (imageView instanceof com.baidu.tieba.view.cb) {
            ((com.baidu.tieba.view.cb) imageView).h();
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
        if (imageView instanceof com.baidu.tieba.view.cb) {
            ((com.baidu.tieba.view.cb) imageView).i();
        }
        return imageView;
    }
}
