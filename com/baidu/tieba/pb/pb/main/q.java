package com.baidu.tieba.pb.pb.main;

import android.util.SparseArray;
import android.view.View;
/* loaded from: classes.dex */
class q implements View.OnLongClickListener {
    final /* synthetic */ PbActivity bKU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(PbActivity pbActivity) {
        this.bKU = pbActivity;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        SparseArray sparseArray;
        com.baidu.tbadk.baseEditMark.a aVar;
        com.baidu.tbadk.baseEditMark.a aVar2;
        boolean z;
        ch chVar;
        com.baidu.tbadk.core.dialog.h hVar;
        bo boVar;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray != null) {
            this.bKU.bKS = (com.baidu.tieba.tbadkCore.data.j) sparseArray.get(com.baidu.tieba.q.tag_clip_board);
            if (this.bKU.bKS != null) {
                aVar = this.bKU.bKx;
                if (aVar != null) {
                    aVar2 = this.bKU.bKx;
                    if (aVar2.pq() && this.bKU.bKS.getId() != null) {
                        String id = this.bKU.bKS.getId();
                        boVar = this.bKU.bKw;
                        if (id.equals(boVar.ro())) {
                            z = true;
                            boolean booleanValue = ((Boolean) sparseArray.get(com.baidu.tieba.q.tag_is_subpb)).booleanValue();
                            chVar = this.bKU.bKA;
                            hVar = this.bKU.bKT;
                            chVar.a(hVar, z, booleanValue);
                        }
                    }
                    z = false;
                    boolean booleanValue2 = ((Boolean) sparseArray.get(com.baidu.tieba.q.tag_is_subpb)).booleanValue();
                    chVar = this.bKU.bKA;
                    hVar = this.bKU.bKT;
                    chVar.a(hVar, z, booleanValue2);
                }
            }
        }
        return true;
    }
}
