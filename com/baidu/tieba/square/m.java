package com.baidu.tieba.square;

import android.view.View;
import android.widget.AdapterView;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BarFolderSecondDirActivity f2369a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(BarFolderSecondDirActivity barFolderSecondDirActivity) {
        this.f2369a = barFolderSecondDirActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        o oVar;
        oVar = this.f2369a.k;
        ArrayList<s> arrayList = oVar.a().d().e;
        if (arrayList == null || i >= arrayList.size()) {
        }
    }
}
