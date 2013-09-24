package com.baidu.tieba.person;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.frs.FrsActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EditBarActivity f1691a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(EditBarActivity editBarActivity) {
        this.f1691a = editBarActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        i iVar;
        h hVar;
        i iVar2;
        iVar = this.f1691a.f;
        if (iVar.getItem(i) != null) {
            hVar = this.f1691a.m;
            if (hVar == null) {
                this.f1691a.k = i;
                iVar2 = this.f1691a.f;
                com.baidu.tieba.data.v vVar = (com.baidu.tieba.data.v) iVar2.getItem(i);
                if (vVar != null) {
                    FrsActivity.a(this.f1691a, vVar.b(), "tb_mytieba");
                }
            }
        }
    }
}
