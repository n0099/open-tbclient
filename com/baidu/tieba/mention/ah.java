package com.baidu.tieba.mention;

import android.widget.ImageView;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah extends com.baidu.adp.lib.resourceLoader.c<com.baidu.adp.widget.a.a> {
    final /* synthetic */ PostActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(PostActivity postActivity) {
        this.a = postActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.resourceLoader.c
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        super.a((ah) aVar, str, i);
        linearLayout = this.a.a;
        ImageView imageView = (ImageView) linearLayout.findViewWithTag(str);
        while (imageView != null) {
            imageView.setTag(null);
            if (imageView != null && aVar != null) {
                aVar.a(imageView);
            }
            linearLayout2 = this.a.a;
            imageView = (ImageView) linearLayout2.findViewWithTag(str);
        }
    }
}
