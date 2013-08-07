package com.baidu.tieba.square;

import android.view.View;
import android.widget.AdapterView;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BarFolderFirstDirActivity f1717a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BarFolderFirstDirActivity barFolderFirstDirActivity) {
        this.f1717a = barFolderFirstDirActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        c cVar;
        r rVar;
        cVar = this.f1717a.k;
        ArrayList c = cVar.a().c();
        if (c != null && i < c.size() && (rVar = (r) c.get(i)) != null) {
            BarFolderSecondDirActivity.a(this.f1717a, rVar.b, rVar.f1734a, rVar.c);
        }
    }
}
