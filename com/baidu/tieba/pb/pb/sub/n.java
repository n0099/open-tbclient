package com.baidu.tieba.pb.pb.sub;

import android.view.View;
import android.widget.AdapterView;
/* loaded from: classes.dex */
class n implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ l bOf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(l lVar) {
        this.bOf = lVar;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.bOf.bNW != null) {
            this.bOf.bNW.onLongClick(view);
            return false;
        }
        return false;
    }
}
