package com.baidu.tieba.square;

import android.view.View;
/* loaded from: classes.dex */
class d implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f1430a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.f1430a = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        q qVar;
        Object tag = view.getTag();
        if ((tag instanceof j) && (qVar = ((j) tag).d) != null) {
            if (qVar.f1441a == null) {
                BarFolderFirstDirActivity.a(this.f1430a.b());
            } else {
                BarFolderSecondDirActivity.a(this.f1430a.b(), qVar.b, qVar.f1441a, qVar.c);
            }
        }
    }
}
