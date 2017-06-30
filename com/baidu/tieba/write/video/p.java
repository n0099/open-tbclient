package com.baidu.tieba.write.video;

import android.view.KeyEvent;
import android.view.View;
/* loaded from: classes.dex */
class p implements View.OnKeyListener {
    final /* synthetic */ n giA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(n nVar) {
        this.giA = nVar;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        return keyEvent != null && keyEvent.getKeyCode() == 66;
    }
}
