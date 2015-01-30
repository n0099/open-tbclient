package com.baidu.tieba.pb.main;

import android.content.DialogInterface;
import android.util.SparseArray;
import android.view.View;
/* loaded from: classes.dex */
class s implements View.OnLongClickListener {
    final /* synthetic */ PbActivity bAT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(PbActivity pbActivity) {
        this.bAT = pbActivity;
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
            this.bAT.bAR = (com.baidu.tieba.tbadkCore.b.k) sparseArray.get(com.baidu.tieba.w.tag_clip_board);
            if (this.bAT.bAR != null) {
                eVar = this.bAT.bAt;
                if (eVar.li() && this.bAT.bAR.getId() != null) {
                    String id = this.bAT.bAR.getId();
                    bqVar = this.bAT.bAs;
                    if (id.equals(bqVar.nz())) {
                        z = true;
                        boolean booleanValue = ((Boolean) sparseArray.get(com.baidu.tieba.w.tag_is_subpb)).booleanValue();
                        bzVar = this.bAT.bAx;
                        onClickListener = this.bAT.bAS;
                        bzVar.a(onClickListener, z, booleanValue);
                    }
                }
                z = false;
                boolean booleanValue2 = ((Boolean) sparseArray.get(com.baidu.tieba.w.tag_is_subpb)).booleanValue();
                bzVar = this.bAT.bAx;
                onClickListener = this.bAT.bAS;
                bzVar.a(onClickListener, z, booleanValue2);
            }
        }
        return true;
    }
}
