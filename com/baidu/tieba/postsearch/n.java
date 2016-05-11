package com.baidu.tieba.postsearch;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements AdapterView.OnItemClickListener {
    final /* synthetic */ l dVl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(l lVar) {
        this.dVl = lVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        BdListView bdListView;
        PostSearchActivity postSearchActivity;
        PostSearchActivity postSearchActivity2;
        bdListView = this.dVl.dVh;
        String str = (String) bdListView.getItemAtPosition(i + 1);
        postSearchActivity = this.dVl.dUY;
        postSearchActivity.nj(str);
        postSearchActivity2 = this.dVl.dUY;
        postSearchActivity2.kD(str);
    }
}
