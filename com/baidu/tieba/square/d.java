package com.baidu.tieba.square;

import android.view.View;
/* loaded from: classes.dex */
class d implements View.OnClickListener {
    final /* synthetic */ c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.a = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        q qVar;
        Object tag = view.getTag();
        if ((tag instanceof j) && (qVar = ((j) tag).d) != null) {
            if (qVar.a == null) {
                BarFolderFirstDirActivity.a(this.a.b());
            } else {
                BarFolderSecondDirActivity.a(this.a.b(), qVar.b, qVar.a, qVar.c);
            }
        }
    }
}
