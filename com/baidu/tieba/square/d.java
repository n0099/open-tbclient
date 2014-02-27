package com.baidu.tieba.square;

import android.view.View;
import com.baidu.tieba.flist.ForumListActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class d implements View.OnClickListener {
    final /* synthetic */ c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.a = cVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ab abVar;
        Object tag = view.getTag();
        if ((tag instanceof g) && (abVar = ((g) tag).d) != null) {
            if (abVar.a == null) {
                BarFolderFirstDirActivity.a(this.a.b(), (String) null);
            } else {
                ForumListActivity.a(this.a.b(), abVar.b, abVar.a, abVar.c);
            }
        }
    }
}
