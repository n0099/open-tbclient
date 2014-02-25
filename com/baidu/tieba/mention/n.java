package com.baidu.tieba.mention;

import android.widget.ImageView;
import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
class n implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ m a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.a = mVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        l lVar;
        BdListView bdListView;
        l lVar2;
        BdListView bdListView2;
        lVar = this.a.a;
        bdListView = lVar.e;
        ImageView imageView = (ImageView) bdListView.findViewWithTag(str);
        while (imageView != null) {
            imageView.setTag(null);
            if (imageView != null && bVar != null) {
                bVar.a(imageView);
            }
            lVar2 = this.a.a;
            bdListView2 = lVar2.e;
            imageView = (ImageView) bdListView2.findViewWithTag(str);
        }
    }
}
