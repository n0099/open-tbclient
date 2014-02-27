package com.baidu.tieba.pb;

import android.widget.ImageView;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ds implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ cu a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ds(cu cuVar) {
        this.a = cuVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public final void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        BdListView bdListView;
        ed edVar;
        ed edVar2;
        bdListView = this.a.j;
        ImageView imageView = (ImageView) bdListView.findViewWithTag(str);
        if (bVar == null) {
            if (imageView != null && (imageView instanceof com.baidu.tieba.view.cb)) {
                ((com.baidu.tieba.view.cb) imageView).a(false);
                return;
            }
            return;
        }
        if (imageView != null) {
            if (imageView instanceof com.baidu.tieba.view.cb) {
                ((com.baidu.tieba.view.cb) imageView).a(true);
            }
            imageView.invalidate();
        }
        if (this.a.x()) {
            edVar = this.a.s;
            if (edVar != null) {
                edVar2 = this.a.s;
                ImageView imageView2 = (ImageView) edVar2.l().findViewWithTag(str);
                if (imageView2 != null) {
                    imageView2.invalidate();
                }
            }
        }
    }
}
