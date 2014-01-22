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
    public void a(com.baidu.adp.widget.ImageView.d dVar, String str, boolean z) {
        BdListView bdListView;
        BdListView bdListView2;
        if (dVar != null) {
            bdListView = this.a.i;
            ImageView imageView = (ImageView) bdListView.findViewWithTag(str);
            while (imageView != null) {
                imageView.setTag(null);
                imageView.setImageBitmap(dVar.h());
                bdListView2 = this.a.i;
                imageView = (ImageView) bdListView2.findViewWithTag(str);
            }
        }
    }
}
