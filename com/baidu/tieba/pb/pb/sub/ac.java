package com.baidu.tieba.pb.pb.sub;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ t cmM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(t tVar) {
        this.cmM = tVar;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        View.OnLongClickListener onLongClickListener;
        View.OnLongClickListener onLongClickListener2;
        onLongClickListener = this.cmM.cmD;
        if (onLongClickListener != null) {
            onLongClickListener2 = this.cmM.cmD;
            onLongClickListener2.onLongClick(view);
            return false;
        }
        return false;
    }
}
