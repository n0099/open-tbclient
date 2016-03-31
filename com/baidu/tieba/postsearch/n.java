package com.baidu.tieba.postsearch;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements AdapterView.OnItemClickListener {
    final /* synthetic */ l dSt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(l lVar) {
        this.dSt = lVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        BdListView bdListView;
        PostSearchActivity postSearchActivity;
        PostSearchActivity postSearchActivity2;
        bdListView = this.dSt.dSp;
        String str = (String) bdListView.getItemAtPosition(i);
        postSearchActivity = this.dSt.dSg;
        postSearchActivity.nk(str);
        postSearchActivity2 = this.dSt.dSg;
        postSearchActivity2.kz(str);
    }
}
