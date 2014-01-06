package com.baidu.tieba.pb;

import android.widget.ImageView;
import com.baidu.adp.widget.ImageView.BDImageView;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dn implements com.baidu.tbadk.imageManager.c {
    final /* synthetic */ cs a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dn(cs csVar) {
        this.a = csVar;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.d dVar, String str, boolean z) {
        BdListView bdListView;
        bdListView = this.a.i;
        ImageView imageView = (ImageView) bdListView.findViewWithTag(str);
        if (dVar == null) {
            if (imageView != null && (imageView instanceof com.baidu.tieba.view.bg)) {
                ((com.baidu.tieba.view.bg) imageView).a(false);
            }
        } else if (imageView != null) {
            if (imageView instanceof com.baidu.tieba.view.bg) {
                ((com.baidu.tieba.view.bg) imageView).a(true);
                if (!((com.baidu.tieba.view.bg) imageView).getIsLoaded()) {
                    imageView.invalidate();
                }
            } else if (imageView instanceof BDImageView) {
                imageView.setImageBitmap(dVar.h());
                imageView.invalidate();
            } else {
                imageView.invalidate();
            }
        }
    }
}
