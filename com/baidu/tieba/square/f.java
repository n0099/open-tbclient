package com.baidu.tieba.square;

import android.view.View;
import com.baidu.tieba.flist.ForumListActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f2404a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(c cVar) {
        this.f2404a = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        z zVar;
        Object tag = view.getTag();
        if ((tag instanceof g) && (zVar = ((g) tag).d) != null) {
            if (zVar.f2424a == null) {
                BarFolderFirstDirActivity.a(this.f2404a.b(), (String) null);
            } else {
                ForumListActivity.a(this.f2404a.b(), zVar.b, zVar.f2424a, zVar.c);
            }
        }
    }
}
