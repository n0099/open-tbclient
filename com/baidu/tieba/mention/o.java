package com.baidu.tieba.mention;

import android.widget.ImageView;
import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
final class o implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ n a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.a = nVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public final void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        m mVar;
        BdListView bdListView;
        while (true) {
            mVar = this.a.a;
            bdListView = mVar.e;
            ImageView imageView = (ImageView) bdListView.findViewWithTag(str);
            if (imageView != null) {
                imageView.setTag(null);
                if (imageView != null && bVar != null) {
                    bVar.a(imageView);
                }
            } else {
                return;
            }
        }
    }
}
