package com.baidu.tieba.write;

import android.widget.ImageView;
import android.widget.ListView;
/* loaded from: classes.dex */
class c implements com.baidu.tbadk.a.d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f1896a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.f1896a = bVar;
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.b bVar, String str, boolean z) {
        AtListActivity atListActivity;
        ListView listView;
        atListActivity = this.f1896a.f1895a;
        listView = atListActivity.d;
        ImageView imageView = (ImageView) listView.findViewWithTag(str);
        if (imageView != null && bVar != null) {
            bVar.b(imageView);
            imageView.setTag(null);
        }
    }
}
