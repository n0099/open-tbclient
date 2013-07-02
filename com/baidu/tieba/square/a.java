package com.baidu.tieba.square;

import android.view.View;
import android.widget.AdapterView;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements AdapterView.OnItemClickListener {
    final /* synthetic */ BarFolderFirstDirActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BarFolderFirstDirActivity barFolderFirstDirActivity) {
        this.a = barFolderFirstDirActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        c cVar;
        q qVar;
        cVar = this.a.k;
        ArrayList c = cVar.a().c();
        if (c != null && i < c.size() && (qVar = (q) c.get(i)) != null) {
            BarFolderSecondDirActivity.a(this.a, qVar.b, qVar.a, qVar.c);
        }
    }
}
