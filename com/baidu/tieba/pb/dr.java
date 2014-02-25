package com.baidu.tieba.pb;

import android.widget.ImageView;
import com.baidu.adp.widget.ImageView.BDImageView;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dr implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ cu a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dr(cu cuVar) {
        this.a = cuVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        BdListView bdListView;
        bdListView = this.a.j;
        ImageView imageView = (ImageView) bdListView.findViewWithTag(str);
        if (bVar == null) {
            if (imageView != null && (imageView instanceof com.baidu.tieba.view.cb)) {
                ((com.baidu.tieba.view.cb) imageView).a(false);
            }
        } else if (imageView != null) {
            if (imageView instanceof com.baidu.tieba.view.cb) {
                ((com.baidu.tieba.view.cb) imageView).a(true);
                if (!((com.baidu.tieba.view.cb) imageView).getIsLoaded()) {
                    imageView.invalidate();
                }
            } else if (imageView instanceof BDImageView) {
                imageView.setImageBitmap(bVar.h());
                imageView.invalidate();
            } else {
                imageView.invalidate();
            }
        }
    }
}
