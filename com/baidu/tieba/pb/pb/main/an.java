package com.baidu.tieba.pb.pb.main;

import android.util.SparseArray;
import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class an implements View.OnLongClickListener {
    final /* synthetic */ PbActivity eob;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(PbActivity pbActivity) {
        this.eob = pbActivity;
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
            this.eob.enS = (com.baidu.tieba.tbadkCore.data.q) sparseArray.get(t.g.tag_clip_board);
            if (this.eob.enS != null) {
                aVar = this.eob.dKY;
                if (aVar != null) {
                    aVar2 = this.eob.dKY;
                    if (aVar2.nv() && this.eob.enS.getId() != null) {
                        String id = this.eob.enS.getId();
                        dhVar = this.eob.emx;
                        if (id.equals(dhVar.rJ())) {
                            z = true;
                            boolean booleanValue = ((Boolean) sparseArray.get(t.g.tag_is_subpb)).booleanValue();
                            exVar = this.eob.enh;
                            bVar = this.eob.enT;
                            exVar.a(bVar, z, booleanValue);
                        }
                    }
                    z = false;
                    boolean booleanValue2 = ((Boolean) sparseArray.get(t.g.tag_is_subpb)).booleanValue();
                    exVar = this.eob.enh;
                    bVar = this.eob.enT;
                    exVar.a(bVar, z, booleanValue2);
                }
            }
        }
        return true;
    }
}
