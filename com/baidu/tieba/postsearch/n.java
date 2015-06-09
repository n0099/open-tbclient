package com.baidu.tieba.postsearch;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements AdapterView.OnItemClickListener {
    final /* synthetic */ l bXZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(l lVar) {
        this.bXZ = lVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        BdListView bdListView;
        PostSearchActivity postSearchActivity;
        PostSearchActivity postSearchActivity2;
        bdListView = this.bXZ.bXV;
        String str = (String) bdListView.getItemAtPosition(i);
        postSearchActivity = this.bXZ.bXN;
        postSearchActivity.iK(str);
        postSearchActivity2 = this.bXZ.bXN;
        postSearchActivity2.iL(str);
    }
}
