package com.baidu.tieba.pb;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cg implements com.baidu.tieba.d.d {
    final /* synthetic */ bl a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cg(bl blVar) {
        this.a = blVar;
    }

    @Override // com.baidu.tieba.d.d
    public void a(Bitmap bitmap, String str, boolean z) {
        BdListView bdListView;
        BdListView bdListView2;
        if (bitmap != null) {
            bdListView = this.a.f;
            ImageView imageView = (ImageView) bdListView.findViewWithTag(str);
            while (imageView != null) {
                imageView.setTag(null);
                imageView.setBackgroundDrawable(new BitmapDrawable(bitmap));
                bdListView2 = this.a.f;
                imageView = (ImageView) bdListView2.findViewWithTag(str);
            }
        }
    }
}
