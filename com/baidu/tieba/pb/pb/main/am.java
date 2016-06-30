package com.baidu.tieba.pb.pb.main;

import android.util.SparseArray;
import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class am implements View.OnLongClickListener {
    final /* synthetic */ PbActivity dPF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(PbActivity pbActivity) {
        this.dPF = pbActivity;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        SparseArray sparseArray;
        com.baidu.tbadk.baseEditMark.a aVar;
        com.baidu.tbadk.baseEditMark.a aVar2;
        boolean z;
        es esVar;
        c.b bVar;
        dg dgVar;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray != null) {
            this.dPF.dPw = (com.baidu.tieba.tbadkCore.data.s) sparseArray.get(u.g.tag_clip_board);
            if (this.dPF.dPw != null) {
                aVar = this.dPF.dvH;
                if (aVar != null) {
                    aVar2 = this.dPF.dvH;
                    if (aVar2.mK() && this.dPF.dPw.getId() != null) {
                        String id = this.dPF.dPw.getId();
                        dgVar = this.dPF.dOf;
                        if (id.equals(dgVar.qP())) {
                            z = true;
                            boolean booleanValue = ((Boolean) sparseArray.get(u.g.tag_is_subpb)).booleanValue();
                            esVar = this.dPF.dOO;
                            bVar = this.dPF.dPx;
                            esVar.a(bVar, z, booleanValue);
                        }
                    }
                    z = false;
                    boolean booleanValue2 = ((Boolean) sparseArray.get(u.g.tag_is_subpb)).booleanValue();
                    esVar = this.dPF.dOO;
                    bVar = this.dPF.dPx;
                    esVar.a(bVar, z, booleanValue2);
                }
            }
        }
        return true;
    }
}
