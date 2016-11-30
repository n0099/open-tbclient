package com.baidu.tieba.pb.pb.main;

import android.util.SparseArray;
import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class an implements View.OnLongClickListener {
    final /* synthetic */ PbActivity evL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(PbActivity pbActivity) {
        this.evL = pbActivity;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        SparseArray sparseArray;
        com.baidu.tbadk.baseEditMark.a aVar;
        com.baidu.tbadk.baseEditMark.a aVar2;
        boolean z;
        ey eyVar;
        c.b bVar;
        dj djVar;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray != null) {
            this.evL.evC = (com.baidu.tieba.tbadkCore.data.q) sparseArray.get(r.g.tag_clip_board);
            if (this.evL.evC != null) {
                aVar = this.evL.dSz;
                if (aVar != null) {
                    aVar2 = this.evL.dSz;
                    if (aVar2.nz() && this.evL.evC.getId() != null) {
                        String id = this.evL.evC.getId();
                        djVar = this.evL.euf;
                        if (id.equals(djVar.rX())) {
                            z = true;
                            boolean booleanValue = ((Boolean) sparseArray.get(r.g.tag_is_subpb)).booleanValue();
                            eyVar = this.evL.euP;
                            bVar = this.evL.evD;
                            eyVar.a(bVar, z, booleanValue);
                        }
                    }
                    z = false;
                    boolean booleanValue2 = ((Boolean) sparseArray.get(r.g.tag_is_subpb)).booleanValue();
                    eyVar = this.evL.euP;
                    bVar = this.evL.evD;
                    eyVar.a(bVar, z, booleanValue2);
                }
            }
        }
        return true;
    }
}
