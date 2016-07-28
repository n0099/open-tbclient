package com.baidu.tieba.person.a;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.person.f;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements AdapterView.OnItemClickListener {
    final /* synthetic */ ao erp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(ao aoVar) {
        this.erp = aoVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ak akVar;
        akVar = this.erp.ero;
        f.a item = akVar.getItem(i);
        if (item == null) {
            return;
        }
        this.erp.oH(item.epw);
        this.erp.a(item);
    }
}
