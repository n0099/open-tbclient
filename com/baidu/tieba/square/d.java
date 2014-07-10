package com.baidu.tieba.square;

import android.view.View;
import com.baidu.tieba.flist.ForumListActivity;
/* loaded from: classes.dex */
class d implements View.OnClickListener {
    final /* synthetic */ c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.a = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        w wVar;
        Object tag = view.getTag();
        if ((tag instanceof e) && (wVar = ((e) tag).d) != null) {
            if (wVar.a == null) {
                BarFolderFirstDirActivity.a(this.a.b(), (String) null);
            } else {
                ForumListActivity.a(this.a.b(), wVar.b, wVar.a, wVar.c);
            }
        }
    }
}
