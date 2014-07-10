package com.baidu.tieba.square;

import android.view.View;
import android.widget.AdapterView;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements AdapterView.OnItemClickListener {
    final /* synthetic */ BarFolderSecondDirActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(BarFolderSecondDirActivity barFolderSecondDirActivity) {
        this.a = barFolderSecondDirActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        l lVar;
        lVar = this.a.i;
        ArrayList<w> arrayList = lVar.a().d().e;
        if (arrayList == null || i >= arrayList.size()) {
        }
    }
}
