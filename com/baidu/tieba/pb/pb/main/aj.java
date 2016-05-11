package com.baidu.tieba.pb.pb.main;

import android.util.SparseArray;
import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class aj implements View.OnLongClickListener {
    final /* synthetic */ PbActivity djE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(PbActivity pbActivity) {
        this.djE = pbActivity;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        SparseArray sparseArray;
        com.baidu.tbadk.baseEditMark.a aVar;
        com.baidu.tbadk.baseEditMark.a aVar2;
        boolean z;
        el elVar;
        c.b bVar;
        cw cwVar;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray != null) {
            this.djE.djv = (com.baidu.tieba.tbadkCore.data.s) sparseArray.get(t.g.tag_clip_board);
            if (this.djE.djv != null) {
                aVar = this.djE.cPW;
                if (aVar != null) {
                    aVar2 = this.djE.cPW;
                    if (aVar2.mP() && this.djE.djv.getId() != null) {
                        String id = this.djE.djv.getId();
                        cwVar = this.djE.dih;
                        if (id.equals(cwVar.qT())) {
                            z = true;
                            boolean booleanValue = ((Boolean) sparseArray.get(t.g.tag_is_subpb)).booleanValue();
                            elVar = this.djE.diR;
                            bVar = this.djE.djw;
                            elVar.a(bVar, z, booleanValue);
                        }
                    }
                    z = false;
                    boolean booleanValue2 = ((Boolean) sparseArray.get(t.g.tag_is_subpb)).booleanValue();
                    elVar = this.djE.diR;
                    bVar = this.djE.djw;
                    elVar.a(bVar, z, booleanValue2);
                }
            }
        }
        return true;
    }
}
