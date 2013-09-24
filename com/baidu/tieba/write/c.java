package com.baidu.tieba.write;

import android.widget.ImageView;
import android.widget.ListView;
/* loaded from: classes.dex */
class c implements com.baidu.tbadk.a.d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f2110a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.f2110a = bVar;
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.c cVar, String str, boolean z) {
        AtListActivity atListActivity;
        ListView listView;
        atListActivity = this.f2110a.f2104a;
        listView = atListActivity.e;
        ImageView imageView = (ImageView) listView.findViewWithTag(str);
        if (imageView != null && cVar != null) {
            cVar.a(imageView);
            imageView.setTag(null);
        }
    }
}
