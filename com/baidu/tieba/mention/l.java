package com.baidu.tieba.mention;

import android.widget.ImageView;
import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
class l implements com.baidu.tbadk.imageManager.c {
    final /* synthetic */ k a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.a = kVar;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.d dVar, String str, boolean z) {
        BdListView bdListView;
        BdListView bdListView2;
        bdListView = this.a.a.e;
        ImageView imageView = (ImageView) bdListView.findViewWithTag(str);
        while (imageView != null) {
            imageView.setTag(null);
            if (imageView != null && dVar != null) {
                dVar.a(imageView);
            }
            bdListView2 = this.a.a.e;
            imageView = (ImageView) bdListView2.findViewWithTag(str);
        }
    }
}
