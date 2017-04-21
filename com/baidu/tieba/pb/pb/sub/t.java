package com.baidu.tieba.pb.pb.sub;

import android.util.SparseArray;
import android.view.View;
import com.baidu.tbadk.core.dialog.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnLongClickListener {
    final /* synthetic */ NewSubPbActivity evm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(NewSubPbActivity newSubPbActivity) {
        this.evm = newSubPbActivity;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        SparseArray sparseArray;
        ao aoVar;
        c.b bVar;
        SubPbModel subPbModel;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray != null) {
            aoVar = this.evm.euX;
            bVar = this.evm.emb;
            subPbModel = this.evm.euV;
            aoVar.a(bVar, subPbModel.isMarked());
        }
        return true;
    }
}
