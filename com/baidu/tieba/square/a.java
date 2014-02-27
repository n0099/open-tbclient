package com.baidu.tieba.square;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.flist.ForumListActivity;
import java.util.ArrayList;
/* loaded from: classes.dex */
final class a implements AdapterView.OnItemClickListener {
    final /* synthetic */ BarFolderFirstDirActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BarFolderFirstDirActivity barFolderFirstDirActivity) {
        this.a = barFolderFirstDirActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        c cVar;
        ab abVar;
        cVar = this.a.e;
        ArrayList<ab> a = cVar.a();
        if (a != null && i < a.size() && (abVar = a.get(i)) != null) {
            ForumListActivity.a(this.a, abVar.b, abVar.a, abVar.c);
        }
    }
}
