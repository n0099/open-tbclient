package com.baidu.tieba.pb.pb.sub;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ w cUl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(w wVar) {
        this.cUl = wVar;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        View.OnLongClickListener onLongClickListener;
        View.OnLongClickListener onLongClickListener2;
        onLongClickListener = this.cUl.aZg;
        if (onLongClickListener != null) {
            onLongClickListener2 = this.cUl.aZg;
            onLongClickListener2.onLongClick(view);
            return false;
        }
        return false;
    }
}
