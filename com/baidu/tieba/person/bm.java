package com.baidu.tieba.person;

import android.widget.ImageView;
import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
class bm implements com.baidu.tbadk.a.d {
    final /* synthetic */ bl a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(bl blVar) {
        this.a = blVar;
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.b bVar, String str, boolean z) {
        PersonListActivity personListActivity;
        BdListView bdListView;
        personListActivity = this.a.a;
        bdListView = personListActivity.e;
        ImageView imageView = (ImageView) bdListView.findViewWithTag(str);
        if (imageView != null && bVar != null) {
            bVar.b(imageView);
            imageView.setTag(null);
        }
    }
}
