package com.baidu.tieba.pb.pb.main;

import android.util.SparseArray;
import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class x implements View.OnLongClickListener {
    final /* synthetic */ PbActivity cCm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(PbActivity pbActivity) {
        this.cCm = pbActivity;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        SparseArray sparseArray;
        com.baidu.tbadk.baseEditMark.a aVar;
        com.baidu.tbadk.baseEditMark.a aVar2;
        boolean z;
        da daVar;
        c.b bVar;
        cc ccVar;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray != null) {
            this.cCm.cCi = (com.baidu.tieba.tbadkCore.data.o) sparseArray.get(n.f.tag_clip_board);
            if (this.cCm.cCi != null) {
                aVar = this.cCm.cBH;
                if (aVar != null) {
                    aVar2 = this.cCm.cBH;
                    if (aVar2.qp() && this.cCm.cCi.getId() != null) {
                        String id = this.cCm.cCi.getId();
                        ccVar = this.cCm.cBG;
                        if (id.equals(ccVar.sP())) {
                            z = true;
                            boolean booleanValue = ((Boolean) sparseArray.get(n.f.tag_is_subpb)).booleanValue();
                            daVar = this.cCm.cBL;
                            bVar = this.cCm.cCj;
                            daVar.a(bVar, z, booleanValue);
                        }
                    }
                    z = false;
                    boolean booleanValue2 = ((Boolean) sparseArray.get(n.f.tag_is_subpb)).booleanValue();
                    daVar = this.cCm.cBL;
                    bVar = this.cCm.cCj;
                    daVar.a(bVar, z, booleanValue2);
                }
            }
        }
        return true;
    }
}
