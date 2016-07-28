package com.baidu.tieba.pb.pb.main;

import android.util.SparseArray;
import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class am implements View.OnLongClickListener {
    final /* synthetic */ PbActivity ebT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(PbActivity pbActivity) {
        this.ebT = pbActivity;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        SparseArray sparseArray;
        com.baidu.tbadk.baseEditMark.a aVar;
        com.baidu.tbadk.baseEditMark.a aVar2;
        boolean z;
        ew ewVar;
        c.b bVar;
        dh dhVar;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray != null) {
            this.ebT.ebK = (com.baidu.tieba.tbadkCore.data.s) sparseArray.get(u.g.tag_clip_board);
            if (this.ebT.ebK != null) {
                aVar = this.ebT.dzj;
                if (aVar != null) {
                    aVar2 = this.ebT.dzj;
                    if (aVar2.mA() && this.ebT.ebK.getId() != null) {
                        String id = this.ebT.ebK.getId();
                        dhVar = this.ebT.eas;
                        if (id.equals(dhVar.qE())) {
                            z = true;
                            boolean booleanValue = ((Boolean) sparseArray.get(u.g.tag_is_subpb)).booleanValue();
                            ewVar = this.ebT.ebb;
                            bVar = this.ebT.ebL;
                            ewVar.a(bVar, z, booleanValue);
                        }
                    }
                    z = false;
                    boolean booleanValue2 = ((Boolean) sparseArray.get(u.g.tag_is_subpb)).booleanValue();
                    ewVar = this.ebT.ebb;
                    bVar = this.ebT.ebL;
                    ewVar.a(bVar, z, booleanValue2);
                }
            }
        }
        return true;
    }
}
