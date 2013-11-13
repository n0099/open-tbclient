package com.baidu.tieba.pb;

import android.widget.ImageView;
/* loaded from: classes.dex */
class ak implements com.baidu.adp.lib.d.c<ImageView> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f2068a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(NewPbActivity newPbActivity) {
        this.f2068a = newPbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.d.c
    /* renamed from: b */
    public ImageView a() {
        return new com.baidu.tieba.view.ba(this.f2068a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.d.c
    public void a(ImageView imageView) {
        imageView.setBackgroundDrawable(null);
        imageView.setImageDrawable(null);
        imageView.setTag(null);
        imageView.setOnClickListener(null);
        if (imageView instanceof com.baidu.tieba.view.ba) {
            ((com.baidu.tieba.view.ba) imageView).j();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.d.c
    public ImageView b(ImageView imageView) {
        if (imageView instanceof com.baidu.tieba.view.ba) {
            ((com.baidu.tieba.view.ba) imageView).i();
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
        if (imageView instanceof com.baidu.tieba.view.ba) {
            ((com.baidu.tieba.view.ba) imageView).j();
        }
        return imageView;
    }
}
