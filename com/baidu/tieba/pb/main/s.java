package com.baidu.tieba.pb.main;

import android.content.DialogInterface;
import android.util.SparseArray;
import android.view.View;
/* loaded from: classes.dex */
class s implements View.OnLongClickListener {
    final /* synthetic */ PbActivity bAS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(PbActivity pbActivity) {
        this.bAS = pbActivity;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        SparseArray sparseArray;
        com.baidu.tbadk.baseEditMark.e eVar;
        boolean z;
        bz bzVar;
        DialogInterface.OnClickListener onClickListener;
        bq bqVar;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray != null) {
            this.bAS.bAQ = (com.baidu.tieba.tbadkCore.b.k) sparseArray.get(com.baidu.tieba.w.tag_clip_board);
            if (this.bAS.bAQ != null) {
                eVar = this.bAS.bAs;
                if (eVar.lb() && this.bAS.bAQ.getId() != null) {
                    String id = this.bAS.bAQ.getId();
                    bqVar = this.bAS.bAr;
                    if (id.equals(bqVar.ns())) {
                        z = true;
                        boolean booleanValue = ((Boolean) sparseArray.get(com.baidu.tieba.w.tag_is_subpb)).booleanValue();
                        bzVar = this.bAS.bAw;
                        onClickListener = this.bAS.bAR;
                        bzVar.a(onClickListener, z, booleanValue);
                    }
                }
                z = false;
                boolean booleanValue2 = ((Boolean) sparseArray.get(com.baidu.tieba.w.tag_is_subpb)).booleanValue();
                bzVar = this.bAS.bAw;
                onClickListener = this.bAS.bAR;
                bzVar.a(onClickListener, z, booleanValue2);
            }
        }
        return true;
    }
}
