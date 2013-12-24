package com.baidu.tieba.pb;

import android.widget.ImageView;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dm implements com.baidu.tbadk.imageManager.c {
    final /* synthetic */ cr a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dm(cr crVar) {
        this.a = crVar;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        BdListView bdListView;
        ed edVar;
        ed edVar2;
        bdListView = this.a.i;
        ImageView imageView = (ImageView) bdListView.findViewWithTag(str);
        if (eVar == null) {
            if (imageView != null && (imageView instanceof com.baidu.tieba.view.ba)) {
                ((com.baidu.tieba.view.ba) imageView).a(false);
                return;
            }
            return;
        }
        if (imageView != null) {
            if (imageView instanceof com.baidu.tieba.view.ba) {
                ((com.baidu.tieba.view.ba) imageView).a(true);
            }
            imageView.invalidate();
        }
        if (this.a.x()) {
            edVar = this.a.q;
            if (edVar != null) {
                edVar2 = this.a.q;
                ImageView imageView2 = (ImageView) edVar2.n().findViewWithTag(str);
                if (imageView2 != null) {
                    imageView2.invalidate();
                }
            }
        }
    }
}
