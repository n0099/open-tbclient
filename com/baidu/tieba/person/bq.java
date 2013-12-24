package com.baidu.tieba.person;

import android.widget.ImageView;
import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
class bq implements com.baidu.tbadk.imageManager.c {
    final /* synthetic */ bp a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(bp bpVar) {
        this.a = bpVar;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        BdListView bdListView;
        bdListView = this.a.a.b;
        ImageView imageView = (ImageView) bdListView.findViewWithTag(str);
        if (imageView != null && eVar != null) {
            eVar.a(imageView);
            imageView.setTag(null);
        }
    }
}
