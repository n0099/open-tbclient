package com.baidu.tieba.person;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.pb.PbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements AdapterView.OnItemClickListener {
    final /* synthetic */ EditMarkActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(EditMarkActivity editMarkActivity) {
        this.a = editMarkActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        com.baidu.tieba.home.af afVar;
        afVar = this.a.c;
        com.baidu.tieba.a.ac acVar = (com.baidu.tieba.a.ac) afVar.getItem(i);
        if (acVar != null) {
            PbActivity.a(this.a, acVar);
        }
    }
}
