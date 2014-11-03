package com.baidu.tieba.pb.sub;

import android.view.View;
import android.widget.AdapterView;
/* loaded from: classes.dex */
class n implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ l bAZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(l lVar) {
        this.bAZ = lVar;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.bAZ.bAS != null) {
            this.bAZ.bAS.onLongClick(view);
            return false;
        }
        return false;
    }
}
