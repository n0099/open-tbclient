package com.baidu.tieba.postsearch;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements AdapterView.OnItemClickListener {
    final /* synthetic */ l dxN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(l lVar) {
        this.dxN = lVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        BdListView bdListView;
        PostSearchActivity postSearchActivity;
        PostSearchActivity postSearchActivity2;
        bdListView = this.dxN.dxJ;
        String str = (String) bdListView.getItemAtPosition(i);
        postSearchActivity = this.dxN.dxA;
        postSearchActivity.lV(str);
        postSearchActivity2 = this.dxN.dxA;
        postSearchActivity2.jM(str);
    }
}
