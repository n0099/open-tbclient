package com.baidu.tieba.pb.pb.main;

import android.util.SparseArray;
import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class an implements View.OnLongClickListener {
    final /* synthetic */ PbActivity eqa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(PbActivity pbActivity) {
        this.eqa = pbActivity;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        SparseArray sparseArray;
        com.baidu.tbadk.baseEditMark.a aVar;
        com.baidu.tbadk.baseEditMark.a aVar2;
        boolean z;
        ex exVar;
        c.b bVar;
        dh dhVar;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray != null) {
            this.eqa.epR = (com.baidu.tieba.tbadkCore.data.q) sparseArray.get(r.g.tag_clip_board);
            if (this.eqa.epR != null) {
                aVar = this.eqa.dMU;
                if (aVar != null) {
                    aVar2 = this.eqa.dMU;
                    if (aVar2.nv() && this.eqa.epR.getId() != null) {
                        String id = this.eqa.epR.getId();
                        dhVar = this.eqa.eov;
                        if (id.equals(dhVar.rV())) {
                            z = true;
                            boolean booleanValue = ((Boolean) sparseArray.get(r.g.tag_is_subpb)).booleanValue();
                            exVar = this.eqa.epe;
                            bVar = this.eqa.epS;
                            exVar.a(bVar, z, booleanValue);
                        }
                    }
                    z = false;
                    boolean booleanValue2 = ((Boolean) sparseArray.get(r.g.tag_is_subpb)).booleanValue();
                    exVar = this.eqa.epe;
                    bVar = this.eqa.epS;
                    exVar.a(bVar, z, booleanValue2);
                }
            }
        }
        return true;
    }
}
