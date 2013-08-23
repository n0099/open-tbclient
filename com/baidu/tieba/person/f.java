package com.baidu.tieba.person;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.frs.FrsActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EditBarActivity f1644a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(EditBarActivity editBarActivity) {
        this.f1644a = editBarActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        j jVar;
        i iVar;
        j jVar2;
        jVar = this.f1644a.e;
        if (jVar.getItem(i) != null) {
            iVar = this.f1644a.l;
            if (iVar == null) {
                this.f1644a.j = i;
                jVar2 = this.f1644a.e;
                com.baidu.tieba.data.v vVar = (com.baidu.tieba.data.v) jVar2.getItem(i);
                if (vVar != null) {
                    FrsActivity.a(this.f1644a, vVar.b(), "tb_mytieba");
                }
            }
        }
    }
}
