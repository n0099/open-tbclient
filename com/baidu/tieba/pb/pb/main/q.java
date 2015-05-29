package com.baidu.tieba.pb.pb.main;

import android.util.SparseArray;
import android.view.View;
/* loaded from: classes.dex */
class q implements View.OnLongClickListener {
    final /* synthetic */ PbActivity bKT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(PbActivity pbActivity) {
        this.bKT = pbActivity;
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
            this.bKT.bKR = (com.baidu.tieba.tbadkCore.data.j) sparseArray.get(com.baidu.tieba.q.tag_clip_board);
            if (this.bKT.bKR != null) {
                aVar = this.bKT.bKw;
                if (aVar != null) {
                    aVar2 = this.bKT.bKw;
                    if (aVar2.pq() && this.bKT.bKR.getId() != null) {
                        String id = this.bKT.bKR.getId();
                        boVar = this.bKT.bKv;
                        if (id.equals(boVar.ro())) {
                            z = true;
                            boolean booleanValue = ((Boolean) sparseArray.get(com.baidu.tieba.q.tag_is_subpb)).booleanValue();
                            chVar = this.bKT.bKz;
                            hVar = this.bKT.bKS;
                            chVar.a(hVar, z, booleanValue);
                        }
                    }
                    z = false;
                    boolean booleanValue2 = ((Boolean) sparseArray.get(com.baidu.tieba.q.tag_is_subpb)).booleanValue();
                    chVar = this.bKT.bKz;
                    hVar = this.bKT.bKS;
                    chVar.a(hVar, z, booleanValue2);
                }
            }
        }
        return true;
    }
}
