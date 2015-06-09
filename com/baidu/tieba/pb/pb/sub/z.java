package com.baidu.tieba.pb.pb.sub;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ s bPU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(s sVar) {
        this.bPU = sVar;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        View.OnLongClickListener onLongClickListener;
        View.OnLongClickListener onLongClickListener2;
        onLongClickListener = this.bPU.bPJ;
        if (onLongClickListener != null) {
            onLongClickListener2 = this.bPU.bPJ;
            onLongClickListener2.onLongClick(view);
            return false;
        }
        return false;
    }
}
