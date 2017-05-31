package com.baidu.tieba.pb.pb.sub;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ ao eyO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(ao aoVar) {
        this.eyO = aoVar;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        View.OnLongClickListener onLongClickListener;
        View.OnLongClickListener onLongClickListener2;
        onLongClickListener = this.eyO.ctr;
        if (onLongClickListener != null) {
            onLongClickListener2 = this.eyO.ctr;
            onLongClickListener2.onLongClick(view);
            return false;
        }
        return false;
    }
}
