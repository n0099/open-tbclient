package com.baidu.tieba.person;

import android.widget.ImageView;
import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
final class ca implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ bz a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ca(bz bzVar) {
        this.a = bzVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public final void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        PersonListActivity personListActivity;
        BdListView bdListView;
        personListActivity = this.a.a;
        bdListView = personListActivity.b;
        ImageView imageView = (ImageView) bdListView.findViewWithTag(str);
        if (imageView != null && bVar != null) {
            bVar.a(imageView);
            imageView.setTag(null);
        }
    }
}
