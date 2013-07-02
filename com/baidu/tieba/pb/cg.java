package com.baidu.tieba.pb;

import android.widget.ImageView;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cg implements com.baidu.tbadk.a.d {
    final /* synthetic */ bk a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cg(bk bkVar) {
        this.a = bkVar;
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.b bVar, String str, boolean z) {
        BdListView bdListView;
        BdListView bdListView2;
        if (bVar != null) {
            bdListView = this.a.f;
            ImageView imageView = (ImageView) bdListView.findViewWithTag(str);
            while (imageView != null) {
                imageView.setTag(null);
                bVar.a(imageView);
                bdListView2 = this.a.f;
                imageView = (ImageView) bdListView2.findViewWithTag(str);
            }
        }
    }
}
