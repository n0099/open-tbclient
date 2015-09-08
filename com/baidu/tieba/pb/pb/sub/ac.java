package com.baidu.tieba.pb.pb.sub;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ t chq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(t tVar) {
        this.chq = tVar;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        View.OnLongClickListener onLongClickListener;
        View.OnLongClickListener onLongClickListener2;
        onLongClickListener = this.chq.chh;
        if (onLongClickListener != null) {
            onLongClickListener2 = this.chq.chh;
            onLongClickListener2.onLongClick(view);
            return false;
        }
        return false;
    }
}
