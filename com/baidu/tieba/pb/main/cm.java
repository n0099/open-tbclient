package com.baidu.tieba.pb.main;

import android.widget.ImageView;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class cm implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ bk a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cm(bk bkVar) {
        this.a = bkVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public final void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        BdListView bdListView;
        com.baidu.tieba.pb.sub.m mVar;
        com.baidu.tieba.pb.sub.m mVar2;
        bdListView = this.a.o;
        ImageView imageView = (ImageView) bdListView.findViewWithTag(str);
        if (bVar == null) {
            if (imageView != null && (imageView instanceof bb)) {
                ((bb) imageView).a(false);
                return;
            }
            return;
        }
        if (imageView != null) {
            if (imageView instanceof bb) {
                ((bb) imageView).a(true);
            }
            imageView.invalidate();
        }
        if (this.a.D()) {
            mVar = this.a.N;
            if (mVar != null) {
                mVar2 = this.a.N;
                ImageView imageView2 = (ImageView) mVar2.l().findViewWithTag(str);
                if (imageView2 != null) {
                    imageView2.invalidate();
                }
            }
        }
    }
}
