package com.baidu.tieba.pb.pb.sub;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ w cHA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(w wVar) {
        this.cHA = wVar;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        View.OnLongClickListener onLongClickListener;
        View.OnLongClickListener onLongClickListener2;
        onLongClickListener = this.cHA.aSQ;
        if (onLongClickListener != null) {
            onLongClickListener2 = this.cHA.aSQ;
            onLongClickListener2.onLongClick(view);
            return false;
        }
        return false;
    }
}
