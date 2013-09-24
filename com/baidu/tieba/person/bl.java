package com.baidu.tieba.person;

import android.widget.ImageView;
import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
class bl implements com.baidu.tbadk.a.d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bk f1681a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(bk bkVar) {
        this.f1681a = bkVar;
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.c cVar, String str, boolean z) {
        PersonListActivity personListActivity;
        BdListView bdListView;
        personListActivity = this.f1681a.f1680a;
        bdListView = personListActivity.b;
        ImageView imageView = (ImageView) bdListView.findViewWithTag(str);
        if (imageView != null && cVar != null) {
            cVar.a(imageView);
            imageView.setTag(null);
        }
    }
}
