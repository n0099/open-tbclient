package com.baidu.tieba.write.video;

import android.view.KeyEvent;
import android.view.View;
/* loaded from: classes.dex */
class o implements View.OnKeyListener {
    final /* synthetic */ m eJV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(m mVar) {
        this.eJV = mVar;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        return keyEvent != null && keyEvent.getKeyCode() == 66;
    }
}
