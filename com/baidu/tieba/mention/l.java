package com.baidu.tieba.mention;

import android.widget.ImageView;
import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
class l implements com.baidu.tbadk.imageManager.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ k f1846a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.f1846a = kVar;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        BdListView bdListView;
        BdListView bdListView2;
        bdListView = this.f1846a.f1845a.e;
        ImageView imageView = (ImageView) bdListView.findViewWithTag(str);
        while (imageView != null) {
            imageView.setTag(null);
            if (imageView != null && eVar != null) {
                eVar.a(imageView);
            }
            bdListView2 = this.f1846a.f1845a.e;
            imageView = (ImageView) bdListView2.findViewWithTag(str);
        }
    }
}
