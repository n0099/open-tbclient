package com.baidu.tieba.pb;

import android.widget.ImageView;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dn implements com.baidu.tbadk.imageManager.c {
    final /* synthetic */ cr a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dn(cr crVar) {
        this.a = crVar;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.d dVar, String str, boolean z) {
        BdListView bdListView;
        eb ebVar;
        eb ebVar2;
        bdListView = this.a.i;
        ImageView imageView = (ImageView) bdListView.findViewWithTag(str);
        if (dVar == null) {
            if (imageView != null && (imageView instanceof com.baidu.tieba.view.bu)) {
                ((com.baidu.tieba.view.bu) imageView).a(false);
                return;
            }
            return;
        }
        if (imageView != null) {
            if (imageView instanceof com.baidu.tieba.view.bu) {
                ((com.baidu.tieba.view.bu) imageView).a(true);
            }
            imageView.invalidate();
        }
        if (this.a.y()) {
            ebVar = this.a.r;
            if (ebVar != null) {
                ebVar2 = this.a.r;
                ImageView imageView2 = (ImageView) ebVar2.n().findViewWithTag(str);
                if (imageView2 != null) {
                    imageView2.invalidate();
                }
            }
        }
    }
}
