package com.baidu.tieba.pb.pb.main;

import android.util.SparseArray;
import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class ac implements View.OnLongClickListener {
    final /* synthetic */ PbActivity cNq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(PbActivity pbActivity) {
        this.cNq = pbActivity;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        SparseArray sparseArray;
        com.baidu.tbadk.baseEditMark.a aVar;
        com.baidu.tbadk.baseEditMark.a aVar2;
        boolean z;
        dz dzVar;
        c.b bVar;
        cm cmVar;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray != null) {
            this.cNq.cNm = (com.baidu.tieba.tbadkCore.data.r) sparseArray.get(t.g.tag_clip_board);
            if (this.cNq.cNm != null) {
                aVar = this.cNq.cMG;
                if (aVar != null) {
                    aVar2 = this.cNq.cMG;
                    if (aVar2.qg() && this.cNq.cNm.getId() != null) {
                        String id = this.cNq.cNm.getId();
                        cmVar = this.cNq.cMF;
                        if (id.equals(cmVar.ts())) {
                            z = true;
                            boolean booleanValue = ((Boolean) sparseArray.get(t.g.tag_is_subpb)).booleanValue();
                            dzVar = this.cNq.cMK;
                            bVar = this.cNq.cNn;
                            dzVar.a(bVar, z, booleanValue);
                        }
                    }
                    z = false;
                    boolean booleanValue2 = ((Boolean) sparseArray.get(t.g.tag_is_subpb)).booleanValue();
                    dzVar = this.cNq.cMK;
                    bVar = this.cNq.cNn;
                    dzVar.a(bVar, z, booleanValue2);
                }
            }
        }
        return true;
    }
}
