package com.baidu.tieba.person;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.pb.PbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements AdapterView.OnItemClickListener {
    final /* synthetic */ EditMarkActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(EditMarkActivity editMarkActivity) {
        this.a = editMarkActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        com.baidu.tieba.home.ab abVar;
        com.baidu.tieba.home.ab abVar2;
        abVar = this.a.c;
        if (abVar.getItemId(i) >= 0) {
            this.a.p = i;
            abVar2 = this.a.c;
            com.baidu.tieba.a.ae aeVar = (com.baidu.tieba.a.ae) abVar2.getItem(i);
            if (aeVar != null) {
                PbActivity.a(this.a, 1700001, aeVar);
                return;
            }
            return;
        }
        this.a.n();
    }
}
