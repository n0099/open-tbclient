package com.baidu.tieba.pb.pb.sub;

import android.util.SparseArray;
import android.view.View;
import com.baidu.tbadk.core.dialog.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnLongClickListener {
    final /* synthetic */ NewSubPbActivity dqn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(NewSubPbActivity newSubPbActivity) {
        this.dqn = newSubPbActivity;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        SparseArray sparseArray;
        y yVar;
        c.b bVar;
        ap apVar;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray != null) {
            yVar = this.dqn.dqe;
            bVar = this.dqn.djw;
            apVar = this.dqn.dqc;
            yVar.a(bVar, apVar.isMarked());
        }
        return true;
    }
}
