package com.baidu.tieba.person;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.frs.FrsActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EditBarActivity f1359a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(EditBarActivity editBarActivity) {
        this.f1359a = editBarActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        j jVar;
        i iVar;
        j jVar2;
        jVar = this.f1359a.e;
        if (jVar.getItem(i) != null) {
            iVar = this.f1359a.k;
            if (iVar == null) {
                this.f1359a.j = i;
                jVar2 = this.f1359a.e;
                com.baidu.tieba.data.r rVar = (com.baidu.tieba.data.r) jVar2.getItem(i);
                if (rVar != null) {
                    FrsActivity.a(this.f1359a, rVar.b(), "tb_mytieba");
                }
            }
        }
    }
}
