package com.baidu.tieba.pb;

import android.widget.ImageView;
/* loaded from: classes.dex */
class al implements com.baidu.adp.lib.b.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f1488a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(NewPbActivity newPbActivity) {
        this.f1488a = newPbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.b.c
    /* renamed from: b */
    public ImageView a() {
        return new com.baidu.tieba.view.ay(this.f1488a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.b.c
    public void a(ImageView imageView) {
        imageView.setBackgroundResource(0);
        imageView.setImageDrawable(null);
        imageView.setTag(null);
        imageView.setOnClickListener(null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.b.c
    public ImageView b(ImageView imageView) {
        return imageView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.b.c
    public ImageView c(ImageView imageView) {
        imageView.setBackgroundResource(0);
        imageView.setImageDrawable(null);
        imageView.setTag(null);
        imageView.setOnClickListener(null);
        return imageView;
    }
}
