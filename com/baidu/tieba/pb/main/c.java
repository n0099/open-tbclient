package com.baidu.tieba.pb.main;

import android.widget.ImageView;
/* loaded from: classes.dex */
final class c implements com.baidu.adp.lib.d.c<ImageView> {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.adp.lib.d.c
    public final /* synthetic */ ImageView a() {
        return new bd(this.a);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.adp.lib.d.c
    public final /* synthetic */ void a(ImageView imageView) {
        ImageView imageView2 = imageView;
        imageView2.setBackgroundDrawable(null);
        imageView2.setImageDrawable(null);
        imageView2.setTag(null);
        imageView2.setOnClickListener(null);
        if (imageView2 instanceof bd) {
            ((bd) imageView2).g();
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.adp.lib.d.c
    public final /* synthetic */ ImageView b(ImageView imageView) {
        ImageView imageView2 = imageView;
        if (imageView2 instanceof bd) {
            ((bd) imageView2).f();
        }
        return imageView2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.adp.lib.d.c
    public final /* synthetic */ ImageView c(ImageView imageView) {
        ImageView imageView2 = imageView;
        imageView2.setBackgroundDrawable(null);
        imageView2.setImageDrawable(null);
        imageView2.setTag(null);
        imageView2.setOnClickListener(null);
        if (imageView2 instanceof bd) {
            ((bd) imageView2).g();
        }
        return imageView2;
    }
}
