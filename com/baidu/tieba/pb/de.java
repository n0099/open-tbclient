package com.baidu.tieba.pb;

import android.widget.ImageView;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class de implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ cu a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public de(cu cuVar) {
        this.a = cuVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        BdListView bdListView;
        BdListView bdListView2;
        if (bVar != null) {
            bdListView = this.a.j;
            ImageView imageView = (ImageView) bdListView.findViewWithTag(str);
            while (imageView != null) {
                imageView.setTag(null);
                imageView.setImageBitmap(bVar.h());
                bdListView2 = this.a.j;
                imageView = (ImageView) bdListView2.findViewWithTag(str);
            }
        }
    }
}
