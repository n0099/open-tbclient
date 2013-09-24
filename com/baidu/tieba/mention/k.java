package com.baidu.tieba.mention;

import android.widget.ImageView;
import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
class k implements com.baidu.tbadk.a.d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ j f1369a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.f1369a = jVar;
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.c cVar, String str, boolean z) {
        i iVar;
        BdListView bdListView;
        i iVar2;
        BdListView bdListView2;
        iVar = this.f1369a.f1368a;
        bdListView = iVar.e;
        ImageView imageView = (ImageView) bdListView.findViewWithTag(str);
        while (imageView != null) {
            imageView.setTag(null);
            if (imageView != null && cVar != null) {
                cVar.a(imageView);
            }
            iVar2 = this.f1369a.f1368a;
            bdListView2 = iVar2.e;
            imageView = (ImageView) bdListView2.findViewWithTag(str);
        }
    }
}
