package com.baidu.tieba.pb.pb.main;

import android.util.SparseArray;
import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class am implements View.OnLongClickListener {
    final /* synthetic */ PbActivity eah;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(PbActivity pbActivity) {
        this.eah = pbActivity;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        SparseArray sparseArray;
        com.baidu.tbadk.baseEditMark.a aVar;
        com.baidu.tbadk.baseEditMark.a aVar2;
        boolean z;
        er erVar;
        c.b bVar;
        dc dcVar;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray != null) {
            this.eah.dZY = (com.baidu.tieba.tbadkCore.data.q) sparseArray.get(r.g.tag_clip_board);
            if (this.eah.dZY != null) {
                aVar = this.eah.dxb;
                if (aVar != null) {
                    aVar2 = this.eah.dxb;
                    if (aVar2.nz() && this.eah.dZY.getId() != null) {
                        String id = this.eah.dZY.getId();
                        dcVar = this.eah.dYA;
                        if (id.equals(dcVar.rO())) {
                            z = true;
                            boolean booleanValue = ((Boolean) sparseArray.get(r.g.tag_is_subpb)).booleanValue();
                            erVar = this.eah.dZk;
                            bVar = this.eah.dZZ;
                            erVar.a(bVar, z, booleanValue);
                        }
                    }
                    z = false;
                    boolean booleanValue2 = ((Boolean) sparseArray.get(r.g.tag_is_subpb)).booleanValue();
                    erVar = this.eah.dZk;
                    bVar = this.eah.dZZ;
                    erVar.a(bVar, z, booleanValue2);
                }
            }
        }
        return true;
    }
}
