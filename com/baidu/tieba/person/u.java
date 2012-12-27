package com.baidu.tieba.person;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.pb.PbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements AdapterView.OnItemClickListener {
    final /* synthetic */ EditMarkActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(EditMarkActivity editMarkActivity) {
        this.a = editMarkActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        com.baidu.tieba.home.y yVar;
        yVar = this.a.b;
        com.baidu.tieba.a.ae aeVar = (com.baidu.tieba.a.ae) yVar.getItem(i);
        if (aeVar != null) {
            PbActivity.a(this.a, aeVar);
        }
    }
}
