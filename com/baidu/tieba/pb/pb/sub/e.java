package com.baidu.tieba.pb.pb.sub;

import android.util.SparseArray;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnLongClickListener {
    final /* synthetic */ NewSubPbActivity bPx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(NewSubPbActivity newSubPbActivity) {
        this.bPx = newSubPbActivity;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        SparseArray sparseArray;
        s sVar;
        com.baidu.tbadk.core.dialog.h hVar;
        ak akVar;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray != null) {
            sVar = this.bPx.bPr;
            hVar = this.bPx.bKT;
            akVar = this.bPx.bPo;
            sVar.a(hVar, akVar.isMarked());
        }
        return true;
    }
}
