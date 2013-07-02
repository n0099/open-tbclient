package com.baidu.tieba.person;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.frs.FrsActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements AdapterView.OnItemClickListener {
    final /* synthetic */ EditBarActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(EditBarActivity editBarActivity) {
        this.a = editBarActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        j jVar;
        i iVar;
        j jVar2;
        jVar = this.a.e;
        if (jVar.getItem(i) != null) {
            iVar = this.a.k;
            if (iVar == null) {
                this.a.j = i;
                jVar2 = this.a.e;
                com.baidu.tieba.data.r rVar = (com.baidu.tieba.data.r) jVar2.getItem(i);
                if (rVar != null) {
                    FrsActivity.a(this.a, rVar.b(), "tb_mytieba");
                }
            }
        }
    }
}
