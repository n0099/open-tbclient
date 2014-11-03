package com.baidu.tieba.square;

import android.view.View;
import com.baidu.tieba.flist.ForumListActivity;
/* loaded from: classes.dex */
class d implements View.OnClickListener {
    final /* synthetic */ c bMn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.bMn = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        q qVar;
        Object tag = view.getTag();
        if ((tag instanceof e) && (qVar = ((e) tag).bMq) != null) {
            if (qVar.avj == null) {
                BarFolderFirstDirActivity.b(this.bMn.adp(), null);
            } else {
                ForumListActivity.c(this.bMn.adp(), qVar.avi, qVar.avj, qVar.avk);
            }
        }
    }
}
