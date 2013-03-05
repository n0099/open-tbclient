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
        kVar = this.a.k;
        com.baidu.tieba.a.af afVar = (com.baidu.tieba.a.af) kVar.getItem(i);
        if (afVar != null) {
            Intent intent = new Intent();
            intent.putExtra("name", afVar.c());
            this.a.setResult(-1, intent);
            this.a.finish();
        }
    }
}
