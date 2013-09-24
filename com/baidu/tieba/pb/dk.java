package com.baidu.tieba.pb;

import android.widget.ImageView;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dk implements com.baidu.tbadk.a.d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ db f1608a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dk(db dbVar) {
        this.f1608a = dbVar;
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.c cVar, String str, boolean z) {
        BdListView bdListView;
        BdListView bdListView2;
        if (cVar != null) {
            bdListView = this.f1608a.c;
            ImageView imageView = (ImageView) bdListView.findViewWithTag(str);
            while (imageView != null) {
                imageView.setTag(null);
                cVar.a(imageView);
                bdListView2 = this.f1608a.c;
                imageView = (ImageView) bdListView2.findViewWithTag(str);
            }
        }
    }
}
