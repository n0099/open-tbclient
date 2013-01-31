package com.baidu.tieba.person;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bg implements AdapterView.OnItemClickListener {
    final /* synthetic */ PersonListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(PersonListActivity personListActivity) {
        this.a = personListActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        com.baidu.tieba.write.k kVar;
        if (j != -1) {
            kVar = this.a.f;
            com.baidu.tieba.a.ai aiVar = (com.baidu.tieba.a.ai) kVar.getItem(i);
            if (aiVar != null && aiVar.a() != null) {
                PersonInfoActivity.a(this.a, aiVar.a(), aiVar.c());
                return;
            }
            return;
        }
        this.a.a(true);
    }
}
