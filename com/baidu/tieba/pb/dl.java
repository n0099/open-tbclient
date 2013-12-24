package com.baidu.tieba.pb;

import android.widget.ImageView;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dl implements com.baidu.tbadk.imageManager.c {
    final /* synthetic */ cr a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dl(cr crVar) {
        this.a = crVar;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        BdListView bdListView;
        bdListView = this.a.i;
        ImageView imageView = (ImageView) bdListView.findViewWithTag(str);
        if (eVar == null) {
            if (imageView != null && (imageView instanceof com.baidu.tieba.view.ba)) {
                ((com.baidu.tieba.view.ba) imageView).a(false);
            }
        } else if (imageView != null) {
            if (imageView instanceof com.baidu.tieba.view.ba) {
                ((com.baidu.tieba.view.ba) imageView).a(true);
                if (!((com.baidu.tieba.view.ba) imageView).getIsLoaded()) {
                    imageView.invalidate();
                    return;
                }
                return;
            }
            imageView.invalidate();
        }
    }
}
