package com.baidu.tieba.pb.richview;

import android.util.SparseArray;
import android.view.View;
/* loaded from: classes.dex */
public class c {
    private SparseArray<com.baidu.tieba.pb.richview.b.a<View>> bOz = new SparseArray<>();

    public void a(com.baidu.tieba.pb.richview.b.a<View> aVar) {
        if (aVar != null) {
            int acM = aVar.acM();
            if (this.bOz.get(acM) == null) {
                this.bOz.put(acM, aVar);
            }
        }
    }

    public View a(com.baidu.tieba.pb.richview.a.c cVar) {
        com.baidu.tieba.pb.richview.b.a<View> aVar;
        if (cVar != null && (aVar = this.bOz.get(cVar.getType())) != null) {
            return aVar.b(cVar);
        }
        return null;
    }

    public void O(View view) {
        if (view != null) {
            int size = this.bOz.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.pb.richview.b.a<View> valueAt = this.bOz.valueAt(i);
                if (valueAt != null && valueAt.P(view)) {
                    valueAt.O(view);
                    return;
                }
            }
        }
    }
}
