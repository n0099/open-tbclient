package com.baidu.tieba.pb.pb.main;

import android.util.SparseArray;
import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class t implements View.OnLongClickListener {
    final /* synthetic */ PbActivity ccj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(PbActivity pbActivity) {
        this.ccj = pbActivity;
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
            this.ccj.cch = (com.baidu.tieba.tbadkCore.data.i) sparseArray.get(i.f.tag_clip_board);
            if (this.ccj.cch != null) {
                aVar = this.ccj.cbH;
                if (aVar != null) {
                    aVar2 = this.ccj.cbH;
                    if (aVar2.qo() && this.ccj.cch.getId() != null) {
                        String id = this.ccj.cch.getId();
                        bkVar = this.ccj.cbG;
                        if (id.equals(bkVar.ss())) {
                            z = true;
                            boolean booleanValue = ((Boolean) sparseArray.get(i.f.tag_is_subpb)).booleanValue();
                            cbVar = this.ccj.cbL;
                            bVar = this.ccj.cci;
                            cbVar.a(bVar, z, booleanValue);
                        }
                    }
                    z = false;
                    boolean booleanValue2 = ((Boolean) sparseArray.get(i.f.tag_is_subpb)).booleanValue();
                    cbVar = this.ccj.cbL;
                    bVar = this.ccj.cci;
                    cbVar.a(bVar, z, booleanValue2);
                }
            }
        }
        return true;
    }
}
