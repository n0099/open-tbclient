package com.baidu.tieba.mention;

import android.widget.ImageView;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ PostActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(PostActivity postActivity) {
        this.a = postActivity;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        linearLayout = this.a.a;
        ImageView imageView = (ImageView) linearLayout.findViewWithTag(str);
        while (imageView != null) {
            imageView.setTag(null);
            if (imageView != null && bVar != null) {
                bVar.a(imageView);
            }
            linearLayout2 = this.a.a;
            imageView = (ImageView) linearLayout2.findViewWithTag(str);
        }
    }
}
