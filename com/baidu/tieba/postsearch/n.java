package com.baidu.tieba.postsearch;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements AdapterView.OnItemClickListener {
    final /* synthetic */ l bXY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(l lVar) {
        this.bXY = lVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        BdListView bdListView;
        PostSearchActivity postSearchActivity;
        PostSearchActivity postSearchActivity2;
        bdListView = this.bXY.bXU;
        String str = (String) bdListView.getItemAtPosition(i);
        postSearchActivity = this.bXY.bXM;
        postSearchActivity.iK(str);
        postSearchActivity2 = this.bXY.bXM;
        postSearchActivity2.iL(str);
    }
}
