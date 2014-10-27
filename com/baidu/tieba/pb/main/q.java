package com.baidu.tieba.pb.main;

import android.content.DialogInterface;
import android.util.SparseArray;
import android.view.View;
/* loaded from: classes.dex */
class q implements View.OnLongClickListener {
    final /* synthetic */ PbActivity bvg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(PbActivity pbActivity) {
        this.bvg = pbActivity;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        SparseArray sparseArray;
        com.baidu.tieba.model.aj ajVar;
        boolean z;
        bv bvVar;
        DialogInterface.OnClickListener onClickListener;
        bn bnVar;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray != null) {
            this.bvg.bve = (com.baidu.tieba.data.ak) sparseArray.get(com.baidu.tieba.v.tag_clip_board);
            if (this.bvg.bve != null) {
                ajVar = this.bvg.buH;
                if (ajVar.zN() && this.bvg.bve.getId() != null) {
                    String id = this.bvg.bve.getId();
                    bnVar = this.bvg.buG;
                    if (id.equals(bnVar.kD())) {
                        z = true;
                        boolean booleanValue = ((Boolean) sparseArray.get(com.baidu.tieba.v.tag_is_subpb)).booleanValue();
                        bvVar = this.bvg.buL;
                        onClickListener = this.bvg.bvf;
                        bvVar.a(onClickListener, z, booleanValue);
                    }
                }
                z = false;
                boolean booleanValue2 = ((Boolean) sparseArray.get(com.baidu.tieba.v.tag_is_subpb)).booleanValue();
                bvVar = this.bvg.buL;
                onClickListener = this.bvg.bvf;
                bvVar.a(onClickListener, z, booleanValue2);
            }
        }
        return true;
    }
}
