package com.baidu.tieba.square;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.flist.ForumListActivity;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BarFolderFirstDirActivity f1735a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BarFolderFirstDirActivity barFolderFirstDirActivity) {
        this.f1735a = barFolderFirstDirActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        c cVar;
        s sVar;
        cVar = this.f1735a.k;
        ArrayList a2 = cVar.a();
        if (a2 != null && i < a2.size() && (sVar = (s) a2.get(i)) != null) {
            ForumListActivity.a(this.f1735a, sVar.b, sVar.f1754a, sVar.c);
        }
    }
}
