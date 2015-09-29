package com.baidu.tieba.pb.pb.main;

import android.util.SparseArray;
import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class t implements View.OnLongClickListener {
    final /* synthetic */ PbActivity ciz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(PbActivity pbActivity) {
        this.ciz = pbActivity;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        SparseArray sparseArray;
        com.baidu.tbadk.baseEditMark.a aVar;
        com.baidu.tbadk.baseEditMark.a aVar2;
        boolean z;
        cc ccVar;
        c.b bVar;
        bl blVar;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray != null) {
            this.ciz.cix = (com.baidu.tieba.tbadkCore.data.k) sparseArray.get(i.f.tag_clip_board);
            if (this.ciz.cix != null) {
                aVar = this.ciz.chW;
                if (aVar != null) {
                    aVar2 = this.ciz.chW;
                    if (aVar2.qk() && this.ciz.cix.getId() != null) {
                        String id = this.ciz.cix.getId();
                        blVar = this.ciz.chV;
                        if (id.equals(blVar.sn())) {
                            z = true;
                            boolean booleanValue = ((Boolean) sparseArray.get(i.f.tag_is_subpb)).booleanValue();
                            ccVar = this.ciz.cia;
                            bVar = this.ciz.ciy;
                            ccVar.a(bVar, z, booleanValue);
                        }
                    }
                    z = false;
                    boolean booleanValue2 = ((Boolean) sparseArray.get(i.f.tag_is_subpb)).booleanValue();
                    ccVar = this.ciz.cia;
                    bVar = this.ciz.ciy;
                    ccVar.a(bVar, z, booleanValue2);
                }
            }
        }
        return true;
    }
}
