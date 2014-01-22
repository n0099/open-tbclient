package com.baidu.tieba.pb;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class en implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ eb a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public en(eb ebVar) {
        this.a = ebVar;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.a.K != null) {
            this.a.K.onLongClick(view);
            return false;
        }
        return false;
    }
}
