package com.baidu.tieba.pb.pb.main;

import android.util.SparseArray;
import android.view.View;
/* loaded from: classes.dex */
class r implements View.OnLongClickListener {
    final /* synthetic */ PbActivity bIv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(PbActivity pbActivity) {
        this.bIv = pbActivity;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        SparseArray sparseArray;
        com.baidu.tbadk.baseEditMark.a aVar;
        com.baidu.tbadk.baseEditMark.a aVar2;
        boolean z;
        ci ciVar;
        com.baidu.tbadk.core.dialog.h hVar;
        bq bqVar;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray != null) {
            this.bIv.bIt = (com.baidu.tieba.tbadkCore.c.j) sparseArray.get(com.baidu.tieba.v.tag_clip_board);
            if (this.bIv.bIt != null) {
                aVar = this.bIv.bHU;
                if (aVar != null) {
                    aVar2 = this.bIv.bHU;
                    if (aVar2.oQ() && this.bIv.bIt.getId() != null) {
                        String id = this.bIv.bIt.getId();
                        bqVar = this.bIv.bHT;
                        if (id.equals(bqVar.qI())) {
                            z = true;
                            boolean booleanValue = ((Boolean) sparseArray.get(com.baidu.tieba.v.tag_is_subpb)).booleanValue();
                            ciVar = this.bIv.bHY;
                            hVar = this.bIv.bIu;
                            ciVar.a(hVar, z, booleanValue);
                        }
                    }
                    z = false;
                    boolean booleanValue2 = ((Boolean) sparseArray.get(com.baidu.tieba.v.tag_is_subpb)).booleanValue();
                    ciVar = this.bIv.bHY;
                    hVar = this.bIv.bIu;
                    ciVar.a(hVar, z, booleanValue2);
                }
            }
        }
        return true;
    }
}
