package com.baidu.tieba.pb.pb.sub;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ x dpf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(x xVar) {
        this.dpf = xVar;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        View.OnLongClickListener onLongClickListener;
        View.OnLongClickListener onLongClickListener2;
        onLongClickListener = this.dpf.bdQ;
        if (onLongClickListener != null) {
            onLongClickListener2 = this.dpf.bdQ;
            onLongClickListener2.onLongClick(view);
            return false;
        }
        return false;
    }
}
