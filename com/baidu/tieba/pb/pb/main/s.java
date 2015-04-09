package com.baidu.tieba.pb.pb.main;

import android.util.SparseArray;
import android.view.View;
/* loaded from: classes.dex */
class s implements View.OnLongClickListener {
    final /* synthetic */ PbActivity bIJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(PbActivity pbActivity) {
        this.bIJ = pbActivity;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        SparseArray sparseArray;
        com.baidu.tbadk.baseEditMark.a aVar;
        com.baidu.tbadk.baseEditMark.a aVar2;
        boolean z;
        cj cjVar;
        com.baidu.tbadk.core.dialog.h hVar;
        br brVar;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray != null) {
            this.bIJ.bIH = (com.baidu.tieba.tbadkCore.c.j) sparseArray.get(com.baidu.tieba.v.tag_clip_board);
            if (this.bIJ.bIH != null) {
                aVar = this.bIJ.bIh;
                if (aVar != null) {
                    aVar2 = this.bIJ.bIh;
                    if (aVar2.oQ() && this.bIJ.bIH.getId() != null) {
                        String id = this.bIJ.bIH.getId();
                        brVar = this.bIJ.bIg;
                        if (id.equals(brVar.qI())) {
                            z = true;
                            boolean booleanValue = ((Boolean) sparseArray.get(com.baidu.tieba.v.tag_is_subpb)).booleanValue();
                            cjVar = this.bIJ.bIl;
                            hVar = this.bIJ.bII;
                            cjVar.a(hVar, z, booleanValue);
                        }
                    }
                    z = false;
                    boolean booleanValue2 = ((Boolean) sparseArray.get(com.baidu.tieba.v.tag_is_subpb)).booleanValue();
                    cjVar = this.bIJ.bIl;
                    hVar = this.bIJ.bII;
                    cjVar.a(hVar, z, booleanValue2);
                }
            }
        }
        return true;
    }
}
