package com.baidu.tieba.person;

import android.widget.ImageView;
import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
class bx implements com.baidu.tbadk.imageManager.c {
    final /* synthetic */ bw a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bx(bw bwVar) {
        this.a = bwVar;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.d dVar, String str, boolean z) {
        BdListView bdListView;
        bdListView = this.a.a.b;
        ImageView imageView = (ImageView) bdListView.findViewWithTag(str);
        if (imageView != null && dVar != null) {
            dVar.a(imageView);
            imageView.setTag(null);
        }
    }
}
