package com.baidu.tieba.pb.sub;

import android.view.View;
import android.widget.AdapterView;
/* loaded from: classes.dex */
class n implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ l bAL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(l lVar) {
        this.bAL = lVar;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.bAL.bAE != null) {
            this.bAL.bAE.onLongClick(view);
            return false;
        }
        return false;
    }
}
