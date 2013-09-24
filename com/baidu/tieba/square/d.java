package com.baidu.tieba.square;

import android.view.View;
import com.baidu.tieba.flist.ForumListActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f1838a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.f1838a = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        s sVar;
        Object tag = view.getTag();
        if ((tag instanceof l) && (sVar = ((l) tag).d) != null) {
            if (sVar.f1853a == null) {
                BarFolderFirstDirActivity.a(this.f1838a.b());
            } else {
                ForumListActivity.a(this.f1838a.b(), sVar.b, sVar.f1853a, sVar.c);
            }
        }
    }
}
