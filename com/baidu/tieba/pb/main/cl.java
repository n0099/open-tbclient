package com.baidu.tieba.pb.main;

import android.widget.ImageView;
import com.baidu.adp.widget.ImageView.BDImageView;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class cl implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ bk a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cl(bk bkVar) {
        this.a = bkVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public final void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        BdListView bdListView;
        bdListView = this.a.o;
        ImageView imageView = (ImageView) bdListView.findViewWithTag(str);
        if (bVar == null) {
            if (imageView != null && (imageView instanceof bb)) {
                ((bb) imageView).a(false);
            }
        } else if (imageView != null) {
            if (imageView instanceof bb) {
                ((bb) imageView).a(true);
                if (((bb) imageView).getIsLoaded()) {
                    return;
                }
            } else if (imageView instanceof BDImageView) {
                imageView.setImageBitmap(bVar.h());
            }
            imageView.invalidate();
        }
    }
}
