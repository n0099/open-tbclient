package com.baidu.tieba.person;

import android.widget.ImageView;
import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
class bn implements com.baidu.tbadk.a.d {
    final /* synthetic */ bm a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(bm bmVar) {
        this.a = bmVar;
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.b bVar, String str, boolean z) {
        PersonListActivity personListActivity;
        BdListView bdListView;
        personListActivity = this.a.a;
        bdListView = personListActivity.c;
        ImageView imageView = (ImageView) bdListView.findViewWithTag(str);
        if (imageView != null && bVar != null) {
            bVar.b(imageView);
            imageView.setTag(null);
        }
    }
}
