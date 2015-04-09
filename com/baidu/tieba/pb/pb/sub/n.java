package com.baidu.tieba.pb.pb.sub;

import android.view.View;
import android.widget.AdapterView;
/* loaded from: classes.dex */
class n implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ l bOv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(l lVar) {
        this.bOv = lVar;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.bOv.bOm != null) {
            this.bOv.bOm.onLongClick(view);
            return false;
        }
        return false;
    }
}
