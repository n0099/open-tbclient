package com.baidu.tieba.person;

import android.widget.ImageView;
import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
class cb implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ ca a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cb(ca caVar) {
        this.a = caVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        PersonListActivity personListActivity;
        BdListView bdListView;
        personListActivity = this.a.a;
        bdListView = personListActivity.b;
        ImageView imageView = (ImageView) bdListView.findViewWithTag(str);
        if (imageView != null && aVar != null) {
            aVar.a(imageView);
            imageView.setTag(null);
        }
    }
}
