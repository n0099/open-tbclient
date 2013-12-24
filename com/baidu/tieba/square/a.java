package com.baidu.tieba.square;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.flist.ForumListActivity;
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
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        c cVar;
        z zVar;
        cVar = this.a.e;
        ArrayList<z> a = cVar.a();
        if (a != null && i < a.size() && (zVar = a.get(i)) != null) {
            ForumListActivity.a(this.a, zVar.b, zVar.a, zVar.c);
        }
    }
}
