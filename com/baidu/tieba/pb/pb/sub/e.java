package com.baidu.tieba.pb.pb.sub;

import android.util.SparseArray;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnLongClickListener {
    final /* synthetic */ NewSubPbActivity bPw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(NewSubPbActivity newSubPbActivity) {
        this.bPw = newSubPbActivity;
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
            sVar = this.bPw.bPq;
            hVar = this.bPw.bKS;
            akVar = this.bPw.bPn;
            sVar.a(hVar, akVar.isMarked());
        }
        return true;
    }
}
