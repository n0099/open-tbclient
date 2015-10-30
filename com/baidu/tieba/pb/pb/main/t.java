package com.baidu.tieba.pb.pb.main;

import android.util.SparseArray;
import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class t implements View.OnLongClickListener {
    final /* synthetic */ PbActivity ciK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(PbActivity pbActivity) {
        this.ciK = pbActivity;
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
            this.ciK.ciI = (com.baidu.tieba.tbadkCore.data.k) sparseArray.get(i.f.tag_clip_board);
            if (this.ciK.ciI != null) {
                aVar = this.ciK.cii;
                if (aVar != null) {
                    aVar2 = this.ciK.cii;
                    if (aVar2.qh() && this.ciK.ciI.getId() != null) {
                        String id = this.ciK.ciI.getId();
                        blVar = this.ciK.cih;
                        if (id.equals(blVar.sk())) {
                            z = true;
                            boolean booleanValue = ((Boolean) sparseArray.get(i.f.tag_is_subpb)).booleanValue();
                            ccVar = this.ciK.cim;
                            bVar = this.ciK.ciJ;
                            ccVar.a(bVar, z, booleanValue);
                        }
                    }
                    z = false;
                    boolean booleanValue2 = ((Boolean) sparseArray.get(i.f.tag_is_subpb)).booleanValue();
                    ccVar = this.ciK.cim;
                    bVar = this.ciK.ciJ;
                    ccVar.a(bVar, z, booleanValue2);
                }
            }
        }
        return true;
    }
}
