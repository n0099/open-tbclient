package com.baidu.tieba.person;

import android.widget.ImageView;
import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
class bn implements com.baidu.tbadk.imageManager.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bm f2202a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(bm bmVar) {
        this.f2202a = bmVar;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        BdListView bdListView;
        bdListView = this.f2202a.f2201a.b;
        ImageView imageView = (ImageView) bdListView.findViewWithTag(str);
        if (imageView != null && eVar != null) {
            eVar.a(imageView);
            imageView.setTag(null);
        }
    }
}
