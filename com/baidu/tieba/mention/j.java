package com.baidu.tieba.mention;

import android.widget.ImageView;
import android.widget.ListView;
/* loaded from: classes.dex */
class j implements com.baidu.tbadk.a.d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ i f1299a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.f1299a = iVar;
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.b bVar, String str, boolean z) {
        h hVar;
        ListView listView;
        h hVar2;
        ListView listView2;
        hVar = this.f1299a.f1298a;
        listView = hVar.d;
        ImageView imageView = (ImageView) listView.findViewWithTag(str);
        while (imageView != null) {
            imageView.setTag(null);
            if (imageView != null && bVar != null) {
                bVar.b(imageView);
            }
            hVar2 = this.f1299a.f1298a;
            listView2 = hVar2.d;
            imageView = (ImageView) listView2.findViewWithTag(str);
        }
    }
}
