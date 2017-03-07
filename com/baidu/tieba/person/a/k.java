package com.baidu.tieba.person.a;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.person.f;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements AdapterView.OnItemClickListener {
    final /* synthetic */ i eBE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar) {
        this.eBE = iVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        h hVar;
        TbPageContext tbPageContext;
        if (!com.baidu.adp.lib.util.i.gS()) {
            tbPageContext = this.eBE.bIK;
            tbPageContext.showToast(w.l.neterror);
            return;
        }
        hVar = this.eBE.eBD;
        f.a item = hVar.getItem(i);
        if (item == null) {
            return;
        }
        this.eBE.nQ(item.eBn);
        this.eBE.a(item);
    }
}
