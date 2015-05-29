package com.baidu.tieba.pb.pb.sub;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ s bPT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(s sVar) {
        this.bPT = sVar;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        View.OnLongClickListener onLongClickListener;
        View.OnLongClickListener onLongClickListener2;
        onLongClickListener = this.bPT.bPI;
        if (onLongClickListener != null) {
            onLongClickListener2 = this.bPT.bPI;
            onLongClickListener2.onLongClick(view);
            return false;
        }
        return false;
    }
}
