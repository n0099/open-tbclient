package com.baidu.tieba.square;

import android.view.View;
import com.baidu.tieba.flist.ForumListActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(c cVar) {
        this.a = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        z zVar;
        Object tag = view.getTag();
        if ((tag instanceof g) && (zVar = ((g) tag).d) != null) {
            if (zVar.a == null) {
                BarFolderFirstDirActivity.a(this.a.b(), (String) null);
            } else {
                ForumListActivity.a(this.a.b(), zVar.b, zVar.a, zVar.c);
            }
        }
    }
}
