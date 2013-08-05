package com.baidu.tieba.square;

import android.view.View;
import android.widget.AdapterView;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BarFolderFirstDirActivity f1719a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BarFolderFirstDirActivity barFolderFirstDirActivity) {
        this.f1719a = barFolderFirstDirActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        c cVar;
        r rVar;
        cVar = this.f1719a.k;
        ArrayList c = cVar.a().c();
        if (c != null && i < c.size() && (rVar = (r) c.get(i)) != null) {
            BarFolderSecondDirActivity.a(this.f1719a, rVar.b, rVar.f1736a, rVar.c);
        }
    }
}
