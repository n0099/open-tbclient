package com.baidu.tieba.pb;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cy implements com.baidu.tieba.d.d {
    final /* synthetic */ cr a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cy(cr crVar) {
        this.a = crVar;
    }

    @Override // com.baidu.tieba.d.d
    public void a(Bitmap bitmap, String str, boolean z) {
        BdListView bdListView;
        BdListView bdListView2;
        if (bitmap != null) {
            bdListView = this.a.c;
            ImageView imageView = (ImageView) bdListView.findViewWithTag(str);
            while (imageView != null) {
                imageView.setTag(null);
                imageView.setImageBitmap(bitmap);
                bdListView2 = this.a.c;
                imageView = (ImageView) bdListView2.findViewWithTag(str);
            }
        }
    }
}
