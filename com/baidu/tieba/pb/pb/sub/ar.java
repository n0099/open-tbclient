package com.baidu.tieba.pb.pb.sub;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ ag ewi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(ag agVar) {
        this.ewi = agVar;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        View.OnLongClickListener onLongClickListener;
        View.OnLongClickListener onLongClickListener2;
        onLongClickListener = this.ewi.bIX;
        if (onLongClickListener != null) {
            onLongClickListener2 = this.ewi.bIX;
            onLongClickListener2.onLongClick(view);
            return false;
        }
        return false;
    }
}
