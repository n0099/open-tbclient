package com.baidu.tieba.pb.main;

import android.content.DialogInterface;
import android.util.SparseArray;
import android.view.View;
/* loaded from: classes.dex */
class q implements View.OnLongClickListener {
    final /* synthetic */ PbActivity bvu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(PbActivity pbActivity) {
        this.bvu = pbActivity;
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
            this.bvu.bvs = (com.baidu.tieba.data.ak) sparseArray.get(com.baidu.tieba.v.tag_clip_board);
            if (this.bvu.bvs != null) {
                ajVar = this.bvu.buV;
                if (ajVar.zP() && this.bvu.bvs.getId() != null) {
                    String id = this.bvu.bvs.getId();
                    bnVar = this.bvu.buU;
                    if (id.equals(bnVar.kD())) {
                        z = true;
                        boolean booleanValue = ((Boolean) sparseArray.get(com.baidu.tieba.v.tag_is_subpb)).booleanValue();
                        bvVar = this.bvu.buZ;
                        onClickListener = this.bvu.bvt;
                        bvVar.a(onClickListener, z, booleanValue);
                    }
                }
                z = false;
                boolean booleanValue2 = ((Boolean) sparseArray.get(com.baidu.tieba.v.tag_is_subpb)).booleanValue();
                bvVar = this.bvu.buZ;
                onClickListener = this.bvu.bvt;
                bvVar.a(onClickListener, z, booleanValue2);
            }
        }
        return true;
    }
}
