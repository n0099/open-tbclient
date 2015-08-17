package com.baidu.tieba.postsearch;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements AdapterView.OnItemClickListener {
    final /* synthetic */ k coS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(k kVar) {
        this.coS = kVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        BdListView bdListView;
        PostSearchActivity postSearchActivity;
        PostSearchActivity postSearchActivity2;
        bdListView = this.coS.coO;
        String str = (String) bdListView.getItemAtPosition(i);
        postSearchActivity = this.coS.coG;
        postSearchActivity.jE(str);
        postSearchActivity2 = this.coS.coG;
        postSearchActivity2.jF(str);
    }
}
