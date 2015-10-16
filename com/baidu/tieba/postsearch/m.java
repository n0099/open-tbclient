package com.baidu.tieba.postsearch;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements AdapterView.OnItemClickListener {
    final /* synthetic */ k cEi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(k kVar) {
        this.cEi = kVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        BdListView bdListView;
        PostSearchActivity postSearchActivity;
        PostSearchActivity postSearchActivity2;
        bdListView = this.cEi.cEe;
        String str = (String) bdListView.getItemAtPosition(i);
        postSearchActivity = this.cEi.cDW;
        postSearchActivity.kI(str);
        postSearchActivity2 = this.cEi.cDW;
        postSearchActivity2.iW(str);
    }
}
