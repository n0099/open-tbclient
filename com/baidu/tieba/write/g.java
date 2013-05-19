package com.baidu.tieba.write;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
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
        EditText editText;
        kVar = this.a.k;
        com.baidu.tieba.a.ai aiVar = (com.baidu.tieba.a.ai) kVar.getItem(i);
        if (aiVar != null) {
            AtListActivity atListActivity = this.a;
            editText = this.a.c;
            com.baidu.tieba.d.ag.a(atListActivity, editText);
            Intent intent = new Intent();
            intent.putExtra("name", aiVar.d());
            this.a.setResult(-1, intent);
            this.a.finish();
        }
    }
}
