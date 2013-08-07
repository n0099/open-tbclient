package com.baidu.tieba.square;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f1720a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.f1720a = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        r rVar;
        Object tag = view.getTag();
        if ((tag instanceof k) && (rVar = ((k) tag).d) != null) {
            if (rVar.f1734a == null) {
                BarFolderFirstDirActivity.a(this.f1720a.b());
            } else {
                BarFolderSecondDirActivity.a(this.f1720a.b(), rVar.b, rVar.f1734a, rVar.c);
            }
        }
    }
}
