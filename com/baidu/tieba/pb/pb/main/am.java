package com.baidu.tieba.pb.pb.main;

import android.util.SparseArray;
import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class am implements View.OnLongClickListener {
    final /* synthetic */ PbActivity eiV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(PbActivity pbActivity) {
        this.eiV = pbActivity;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        SparseArray sparseArray;
        com.baidu.tbadk.baseEditMark.a aVar;
        com.baidu.tbadk.baseEditMark.a aVar2;
        boolean z;
        ez ezVar;
        c.b bVar;
        PbModel pbModel;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray != null) {
            this.eiV.eiL = (com.baidu.tieba.tbadkCore.data.p) sparseArray.get(r.h.tag_clip_board);
            if (this.eiV.eiL != null) {
                aVar = this.eiV.dGi;
                if (aVar != null) {
                    aVar2 = this.eiV.dGi;
                    if (aVar2.nt() && this.eiV.eiL.getId() != null) {
                        String id = this.eiV.eiL.getId();
                        pbModel = this.eiV.ehh;
                        if (id.equals(pbModel.rF())) {
                            z = true;
                            boolean booleanValue = ((Boolean) sparseArray.get(r.h.tag_is_subpb)).booleanValue();
                            ezVar = this.eiV.ehV;
                            bVar = this.eiV.eiM;
                            ezVar.a(bVar, z, booleanValue);
                        }
                    }
                    z = false;
                    boolean booleanValue2 = ((Boolean) sparseArray.get(r.h.tag_is_subpb)).booleanValue();
                    ezVar = this.eiV.ehV;
                    bVar = this.eiV.eiM;
                    ezVar.a(bVar, z, booleanValue2);
                }
            }
        }
        return true;
    }
}
