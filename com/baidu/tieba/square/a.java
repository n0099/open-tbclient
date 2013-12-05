package com.baidu.tieba.square;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.flist.ForumListActivity;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BarFolderFirstDirActivity f2470a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BarFolderFirstDirActivity barFolderFirstDirActivity) {
        this.f2470a = barFolderFirstDirActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        c cVar;
        z zVar;
        cVar = this.f2470a.e;
        ArrayList<z> a2 = cVar.a();
        if (a2 != null && i < a2.size() && (zVar = a2.get(i)) != null) {
            ForumListActivity.a(this.f2470a, zVar.b, zVar.f2541a, zVar.c);
        }
    }
}
