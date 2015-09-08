package com.baidu.tieba.postsearch;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements AdapterView.OnItemClickListener {
    final /* synthetic */ k cxp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(k kVar) {
        this.cxp = kVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        BdListView bdListView;
        PostSearchActivity postSearchActivity;
        PostSearchActivity postSearchActivity2;
        bdListView = this.cxp.cxl;
        String str = (String) bdListView.getItemAtPosition(i);
        postSearchActivity = this.cxp.cxd;
        postSearchActivity.kj(str);
        postSearchActivity2 = this.cxp.cxd;
        postSearchActivity2.kk(str);
    }
}
