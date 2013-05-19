package com.baidu.tieba.pb;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ce implements com.baidu.tieba.d.d {
    final /* synthetic */ bl a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ce(bl blVar) {
        this.a = blVar;
    }

    @Override // com.baidu.tieba.d.d
    public void a(Bitmap bitmap, String str, boolean z) {
        BdListView bdListView;
        cr crVar;
        cr crVar2;
        if (bitmap != null) {
            bdListView = this.a.f;
            ImageView imageView = (ImageView) bdListView.findViewWithTag(str);
            if (imageView != null) {
                imageView.invalidate();
            }
            if (this.a.t()) {
                crVar = this.a.A;
                if (crVar != null) {
                    crVar2 = this.a.A;
                    ImageView imageView2 = (ImageView) crVar2.d().findViewWithTag(str);
                    if (imageView2 != null) {
                        imageView2.invalidate();
                    }
                }
            }
        }
    }
}
