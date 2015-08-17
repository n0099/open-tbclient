package com.baidu.tieba.pb.pb.main;

import android.util.SparseArray;
import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class t implements View.OnLongClickListener {
    final /* synthetic */ PbActivity cbo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(PbActivity pbActivity) {
        this.cbo = pbActivity;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        SparseArray sparseArray;
        com.baidu.tbadk.baseEditMark.a aVar;
        com.baidu.tbadk.baseEditMark.a aVar2;
        boolean z;
        cb cbVar;
        c.b bVar;
        bk bkVar;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray != null) {
            this.cbo.cbm = (com.baidu.tieba.tbadkCore.data.i) sparseArray.get(i.f.tag_clip_board);
            if (this.cbo.cbm != null) {
                aVar = this.cbo.caM;
                if (aVar != null) {
                    aVar2 = this.cbo.caM;
                    if (aVar2.qr() && this.cbo.cbm.getId() != null) {
                        String id = this.cbo.cbm.getId();
                        bkVar = this.cbo.caL;
                        if (id.equals(bkVar.sr())) {
                            z = true;
                            boolean booleanValue = ((Boolean) sparseArray.get(i.f.tag_is_subpb)).booleanValue();
                            cbVar = this.cbo.caQ;
                            bVar = this.cbo.cbn;
                            cbVar.a(bVar, z, booleanValue);
                        }
                    }
                    z = false;
                    boolean booleanValue2 = ((Boolean) sparseArray.get(i.f.tag_is_subpb)).booleanValue();
                    cbVar = this.cbo.caQ;
                    bVar = this.cbo.cbn;
                    cbVar.a(bVar, z, booleanValue2);
                }
            }
        }
        return true;
    }
}
