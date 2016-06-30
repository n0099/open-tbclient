package com.baidu.tieba.pb.pb.sub;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ af dXy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(af afVar) {
        this.dXy = afVar;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        View.OnLongClickListener onLongClickListener;
        View.OnLongClickListener onLongClickListener2;
        onLongClickListener = this.dXy.bvu;
        if (onLongClickListener != null) {
            onLongClickListener2 = this.dXy.bvu;
            onLongClickListener2.onLongClick(view);
            return false;
        }
        return false;
    }
}
