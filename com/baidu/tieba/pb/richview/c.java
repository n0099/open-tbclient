package com.baidu.tieba.pb.richview;

import android.util.SparseArray;
import android.view.View;
/* loaded from: classes.dex */
public class c {
    private SparseArray<com.baidu.tieba.pb.richview.b.a<View>> bOj = new SparseArray<>();

    public void a(com.baidu.tieba.pb.richview.b.a<View> aVar) {
        if (aVar != null) {
            int acx = aVar.acx();
            if (this.bOj.get(acx) == null) {
                this.bOj.put(acx, aVar);
            }
        }
    }

    public View a(com.baidu.tieba.pb.richview.a.c cVar) {
        com.baidu.tieba.pb.richview.b.a<View> aVar;
        if (cVar != null && (aVar = this.bOj.get(cVar.getType())) != null) {
            return aVar.b(cVar);
        }
        return null;
    }

    public void O(View view) {
        if (view != null) {
            int size = this.bOj.size();
            for (int i = 0; i < size; i++) {
                com.baidu.tieba.pb.richview.b.a<View> valueAt = this.bOj.valueAt(i);
                if (valueAt != null && valueAt.P(view)) {
                    valueAt.O(view);
                    return;
                }
            }
        }
    }
}
