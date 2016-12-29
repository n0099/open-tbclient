package com.baidu.tieba.person.a;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.person.f;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements AdapterView.OnItemClickListener {
    final /* synthetic */ i eol;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar) {
        this.eol = iVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        h hVar;
        TbPageContext tbPageContext;
        if (!com.baidu.adp.lib.util.i.fZ()) {
            tbPageContext = this.eol.btW;
            tbPageContext.showToast(r.j.neterror);
            return;
        }
        hVar = this.eol.eok;
        f.a item = hVar.getItem(i);
        if (item == null) {
            return;
        }
        this.eol.oq(item.enT);
        this.eol.a(item);
    }
}
