package com.baidu.tieba.pb.pb.sub;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ y dqN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(y yVar) {
        this.dqN = yVar;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        View.OnLongClickListener onLongClickListener;
        View.OnLongClickListener onLongClickListener2;
        onLongClickListener = this.dqN.aZy;
        if (onLongClickListener != null) {
            onLongClickListener2 = this.dqN.aZy;
            onLongClickListener2.onLongClick(view);
            return false;
        }
        return false;
    }
}
