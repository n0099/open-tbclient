package com.baidu.tieba.pb.pb.sub;

import android.util.SparseArray;
import android.view.View;
import com.baidu.tbadk.core.dialog.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnLongClickListener {
    final /* synthetic */ NewSubPbActivity cnS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(NewSubPbActivity newSubPbActivity) {
        this.cnS = newSubPbActivity;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        SparseArray sparseArray;
        v vVar;
        c.b bVar;
        am amVar;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray != null) {
            vVar = this.cnS.cnJ;
            bVar = this.cnS.cjM;
            amVar = this.cnS.cnH;
            vVar.a(bVar, amVar.isMarked());
        }
        return true;
    }
}
