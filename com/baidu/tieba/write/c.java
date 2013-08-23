package com.baidu.tieba.write;

import android.widget.ImageView;
import android.widget.ListView;
/* loaded from: classes.dex */
class c implements com.baidu.tbadk.a.d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f1927a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.f1927a = bVar;
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.b bVar, String str, boolean z) {
        AtListActivity atListActivity;
        ListView listView;
        atListActivity = this.f1927a.f1926a;
        listView = atListActivity.e;
        ImageView imageView = (ImageView) listView.findViewWithTag(str);
        if (imageView != null && bVar != null) {
            bVar.a(imageView);
            imageView.setTag(null);
        }
    }
}
