package com.baidu.tieba.square;

import android.view.View;
import android.widget.AdapterView;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BarFolderSecondDirActivity f2530a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(BarFolderSecondDirActivity barFolderSecondDirActivity) {
        this.f2530a = barFolderSecondDirActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        q qVar;
        qVar = this.f2530a.i;
        ArrayList<z> arrayList = qVar.a().d().e;
        if (arrayList == null || i >= arrayList.size()) {
        }
    }
}
