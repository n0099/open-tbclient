package com.baidu.tieba.person;

import android.widget.ImageView;
import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
class bm implements com.baidu.tbadk.a.d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bl f1632a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(bl blVar) {
        this.f1632a = blVar;
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.b bVar, String str, boolean z) {
        PersonListActivity personListActivity;
        BdListView bdListView;
        personListActivity = this.f1632a.f1631a;
        bdListView = personListActivity.c;
        ImageView imageView = (ImageView) bdListView.findViewWithTag(str);
        if (imageView != null && bVar != null) {
            bVar.a(imageView);
            imageView.setTag(null);
        }
    }
}
