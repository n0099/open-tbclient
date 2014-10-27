package com.baidu.tieba.square;

import android.view.View;
import com.baidu.tieba.flist.ForumListActivity;
/* loaded from: classes.dex */
class d implements View.OnClickListener {
    final /* synthetic */ c bLY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.bLY = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        q qVar;
        Object tag = view.getTag();
        if ((tag instanceof e) && (qVar = ((e) tag).bMb) != null) {
            if (qVar.ava == null) {
                BarFolderFirstDirActivity.b(this.bLY.adm(), null);
            } else {
                ForumListActivity.c(this.bLY.adm(), qVar.auZ, qVar.ava, qVar.avb);
            }
        }
    }
}
