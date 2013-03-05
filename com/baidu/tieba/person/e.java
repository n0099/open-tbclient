package com.baidu.tieba.person;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.frs.FrsActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements AdapterView.OnItemClickListener {
    final /* synthetic */ EditBarActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(EditBarActivity editBarActivity) {
        this.a = editBarActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        i iVar;
        h hVar;
        i iVar2;
        iVar = this.a.g;
        if (iVar.getItem(i) != null) {
            hVar = this.a.k;
            if (hVar == null) {
                this.a.j = i;
                iVar2 = this.a.g;
                com.baidu.tieba.a.q qVar = (com.baidu.tieba.a.q) iVar2.getItem(i);
                if (qVar != null) {
                    FrsActivity.a(this.a, qVar.c(), "tb_mytieba");
                }
            }
        }
    }
}
