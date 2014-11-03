package com.baidu.tieba.square;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.flist.ForumListActivity;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements AdapterView.OnItemClickListener {
    final /* synthetic */ BarFolderFirstDirActivity bMk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BarFolderFirstDirActivity barFolderFirstDirActivity) {
        this.bMk = barFolderFirstDirActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        c cVar;
        q qVar;
        cVar = this.bMk.bMg;
        ArrayList<q> ado = cVar.ado();
        if (ado != null && i < ado.size() && (qVar = ado.get(i)) != null) {
            ForumListActivity.c(this.bMk, qVar.avi, qVar.avj, qVar.avk);
        }
    }
}
