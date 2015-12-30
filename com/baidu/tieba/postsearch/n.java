package com.baidu.tieba.postsearch;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements AdapterView.OnItemClickListener {
    final /* synthetic */ l djT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(l lVar) {
        this.djT = lVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        BdListView bdListView;
        PostSearchActivity postSearchActivity;
        PostSearchActivity postSearchActivity2;
        bdListView = this.djT.djP;
        String str = (String) bdListView.getItemAtPosition(i);
        postSearchActivity = this.djT.djG;
        postSearchActivity.lG(str);
        postSearchActivity2 = this.djT.djG;
        postSearchActivity2.jH(str);
    }
}
