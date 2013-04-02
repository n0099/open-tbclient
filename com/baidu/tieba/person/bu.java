package com.baidu.tieba.person;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bu implements AdapterView.OnItemClickListener {
    final /* synthetic */ PersonListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bu(PersonListActivity personListActivity) {
        this.a = personListActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        com.baidu.tieba.write.k kVar;
        if (j != -1) {
            kVar = this.a.f;
            com.baidu.tieba.a.ah ahVar = (com.baidu.tieba.a.ah) kVar.getItem(i);
            if (ahVar != null && ahVar.a() != null) {
                PersonInfoActivity.a(this.a, ahVar.a(), ahVar.c());
                return;
            }
            return;
        }
        this.a.a(true);
    }
}
