package com.baidu.tieba.person.a;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.person.g;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements AdapterView.OnItemClickListener {
    final /* synthetic */ l eKw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(l lVar) {
        this.eKw = lVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        h hVar;
        TbPageContext tbPageContext;
        if (!i.fZ()) {
            tbPageContext = this.eKw.bNR;
            tbPageContext.showToast(r.j.neterror);
            return;
        }
        hVar = this.eKw.eKv;
        g.a item = hVar.getItem(i);
        if (item == null) {
            return;
        }
        this.eKw.pP(item.eKc);
        this.eKw.a(item);
    }
}
