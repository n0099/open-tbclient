package com.baidu.tieba.postsearch;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements AdapterView.OnItemClickListener {
    final /* synthetic */ k cDX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(k kVar) {
        this.cDX = kVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        BdListView bdListView;
        PostSearchActivity postSearchActivity;
        PostSearchActivity postSearchActivity2;
        bdListView = this.cDX.cDT;
        String str = (String) bdListView.getItemAtPosition(i);
        postSearchActivity = this.cDX.cDL;
        postSearchActivity.kI(str);
        postSearchActivity2 = this.cDX.cDL;
        postSearchActivity2.iW(str);
    }
}
