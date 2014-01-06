package com.baidu.tieba.pb;

import android.widget.ImageView;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.baidu.tieba.pb.do  reason: invalid class name */
/* loaded from: classes.dex */
public class Cdo implements com.baidu.tbadk.imageManager.c {
    final /* synthetic */ cs a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Cdo(cs csVar) {
        this.a = csVar;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.d dVar, String str, boolean z) {
        BdListView bdListView;
        ed edVar;
        ed edVar2;
        bdListView = this.a.i;
        ImageView imageView = (ImageView) bdListView.findViewWithTag(str);
        if (dVar == null) {
            if (imageView != null && (imageView instanceof com.baidu.tieba.view.bg)) {
                ((com.baidu.tieba.view.bg) imageView).a(false);
                return;
            }
            return;
        }
        if (imageView != null) {
            if (imageView instanceof com.baidu.tieba.view.bg) {
                ((com.baidu.tieba.view.bg) imageView).a(true);
            }
            imageView.invalidate();
        }
        if (this.a.y()) {
            edVar = this.a.r;
            if (edVar != null) {
                edVar2 = this.a.r;
                ImageView imageView2 = (ImageView) edVar2.n().findViewWithTag(str);
                if (imageView2 != null) {
                    imageView2.invalidate();
                }
            }
        }
    }
}
