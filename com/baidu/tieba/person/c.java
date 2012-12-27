package com.baidu.tieba.person;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.frs.FrsActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements AdapterView.OnItemClickListener {
    final /* synthetic */ EditBarActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(EditBarActivity editBarActivity) {
        this.a = editBarActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        g gVar;
        f fVar;
        g gVar2;
        gVar = this.a.f;
        if (gVar.getItem(i) != null) {
            fVar = this.a.j;
            if (fVar == null) {
                this.a.i = i;
                gVar2 = this.a.f;
                com.baidu.tieba.a.p pVar = (com.baidu.tieba.a.p) gVar2.getItem(i);
                if (pVar != null) {
                    FrsActivity.a(this.a, pVar.c(), "tb_mytieba");
                }
            }
        }
    }
}
