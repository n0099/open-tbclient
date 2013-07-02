package com.baidu.tieba.square;

import android.view.View;
import android.widget.AdapterView;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements AdapterView.OnItemClickListener {
    final /* synthetic */ BarFolderSecondDirActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(BarFolderSecondDirActivity barFolderSecondDirActivity) {
        this.a = barFolderSecondDirActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        m mVar;
        mVar = this.a.k;
        ArrayList arrayList = mVar.a().c().e;
        if (arrayList == null || i >= arrayList.size()) {
        }
    }
}
