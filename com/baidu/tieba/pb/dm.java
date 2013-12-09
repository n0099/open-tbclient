package com.baidu.tieba.pb;

import android.widget.ImageView;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dm implements com.baidu.tbadk.imageManager.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ cr f2236a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dm(cr crVar) {
        this.f2236a = crVar;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        BdListView bdListView;
        ed edVar;
        ed edVar2;
        bdListView = this.f2236a.i;
        ImageView imageView = (ImageView) bdListView.findViewWithTag(str);
        if (eVar == null) {
            if (imageView != null && (imageView instanceof com.baidu.tieba.view.bb)) {
                ((com.baidu.tieba.view.bb) imageView).a(false);
                return;
            }
            return;
        }
        if (imageView != null) {
            if (imageView instanceof com.baidu.tieba.view.bb) {
                ((com.baidu.tieba.view.bb) imageView).a(true);
            }
            imageView.invalidate();
        }
        if (this.f2236a.x()) {
            edVar = this.f2236a.q;
            if (edVar != null) {
                edVar2 = this.f2236a.q;
                ImageView imageView2 = (ImageView) edVar2.n().findViewWithTag(str);
                if (imageView2 != null) {
                    imageView2.invalidate();
                }
            }
        }
    }
}
