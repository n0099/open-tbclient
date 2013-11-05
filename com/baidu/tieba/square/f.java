package com.baidu.tieba.square;

import android.view.View;
import com.baidu.tieba.flist.ForumListActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f2362a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(c cVar) {
        this.f2362a = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        s sVar;
        Object tag = view.getTag();
        if ((tag instanceof l) && (sVar = ((l) tag).d) != null) {
            if (sVar.f2375a == null) {
                BarFolderFirstDirActivity.a(this.f2362a.b());
            } else {
                ForumListActivity.a(this.f2362a.b(), sVar.b, sVar.f2375a, sVar.c);
            }
        }
    }
}
