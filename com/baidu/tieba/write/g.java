package com.baidu.tieba.write;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements AdapterView.OnItemClickListener {
    final /* synthetic */ AtListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(AtListActivity atListActivity) {
        this.a = atListActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        k kVar;
        kVar = this.a.j;
        com.baidu.tieba.a.ah ahVar = (com.baidu.tieba.a.ah) kVar.getItem(i);
        if (ahVar != null) {
            Intent intent = new Intent();
            intent.putExtra("name", ahVar.c());
            this.a.setResult(-1, intent);
            this.a.finish();
        }
    }
}
