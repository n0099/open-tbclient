package com.baidu.tieba.pb.pb.main;

import android.util.SparseArray;
import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class w implements View.OnLongClickListener {
    final /* synthetic */ PbActivity cjN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(PbActivity pbActivity) {
        this.cjN = pbActivity;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        SparseArray sparseArray;
        com.baidu.tbadk.baseEditMark.a aVar;
        com.baidu.tbadk.baseEditMark.a aVar2;
        boolean z;
        ct ctVar;
        c.b bVar;
        ca caVar;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray != null) {
            this.cjN.cjL = (com.baidu.tieba.tbadkCore.data.o) sparseArray.get(i.f.tag_clip_board);
            if (this.cjN.cjL != null) {
                aVar = this.cjN.cjk;
                if (aVar != null) {
                    aVar2 = this.cjN.cjk;
                    if (aVar2.qi() && this.cjN.cjL.getId() != null) {
                        String id = this.cjN.cjL.getId();
                        caVar = this.cjN.cjj;
                        if (id.equals(caVar.sn())) {
                            z = true;
                            boolean booleanValue = ((Boolean) sparseArray.get(i.f.tag_is_subpb)).booleanValue();
                            ctVar = this.cjN.cjo;
                            bVar = this.cjN.cjM;
                            ctVar.a(bVar, z, booleanValue);
                        }
                    }
                    z = false;
                    boolean booleanValue2 = ((Boolean) sparseArray.get(i.f.tag_is_subpb)).booleanValue();
                    ctVar = this.cjN.cjo;
                    bVar = this.cjN.cjM;
                    ctVar.a(bVar, z, booleanValue2);
                }
            }
        }
        return true;
    }
}
