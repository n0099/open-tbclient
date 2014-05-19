package com.baidu.tieba.mention;

import android.widget.ImageView;
import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
class o implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ n a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.a = nVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        m mVar;
        BdListView bdListView;
        m mVar2;
        BdListView bdListView2;
        mVar = this.a.a;
        bdListView = mVar.e;
        ImageView imageView = (ImageView) bdListView.findViewWithTag(str);
        while (imageView != null) {
            imageView.setTag(null);
            if (imageView != null && aVar != null) {
                aVar.a(imageView);
            }
            mVar2 = this.a.a;
            bdListView2 = mVar2.e;
            imageView = (ImageView) bdListView2.findViewWithTag(str);
        }
    }
}
