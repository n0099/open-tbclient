package com.baidu.tieba.square;

import android.view.View;
import android.widget.AdapterView;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BarFolderSecondDirActivity f1730a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(BarFolderSecondDirActivity barFolderSecondDirActivity) {
        this.f1730a = barFolderSecondDirActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        n nVar;
        nVar = this.f1730a.k;
        ArrayList arrayList = nVar.a().c().e;
        if (arrayList == null || i >= arrayList.size()) {
        }
    }
}
