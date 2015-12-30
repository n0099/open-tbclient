package com.baidu.tieba.pb.pb.main;

import android.util.SparseArray;
import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class y implements View.OnLongClickListener {
    final /* synthetic */ PbActivity cFS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(PbActivity pbActivity) {
        this.cFS = pbActivity;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        SparseArray sparseArray;
        com.baidu.tbadk.baseEditMark.a aVar;
        com.baidu.tbadk.baseEditMark.a aVar2;
        boolean z;
        dk dkVar;
        c.b bVar;
        cf cfVar;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray != null) {
            this.cFS.cFO = (com.baidu.tieba.tbadkCore.data.r) sparseArray.get(n.g.tag_clip_board);
            if (this.cFS.cFO != null) {
                aVar = this.cFS.cFm;
                if (aVar != null) {
                    aVar2 = this.cFS.cFm;
                    if (aVar2.pN() && this.cFS.cFO.getId() != null) {
                        String id = this.cFS.cFO.getId();
                        cfVar = this.cFS.cFl;
                        if (id.equals(cfVar.sz())) {
                            z = true;
                            boolean booleanValue = ((Boolean) sparseArray.get(n.g.tag_is_subpb)).booleanValue();
                            dkVar = this.cFS.cFq;
                            bVar = this.cFS.cFP;
                            dkVar.a(bVar, z, booleanValue);
                        }
                    }
                    z = false;
                    boolean booleanValue2 = ((Boolean) sparseArray.get(n.g.tag_is_subpb)).booleanValue();
                    dkVar = this.cFS.cFq;
                    bVar = this.cFS.cFP;
                    dkVar.a(bVar, z, booleanValue2);
                }
            }
        }
        return true;
    }
}
