package com.baidu.tieba.pb.pb.main;

import android.util.SparseArray;
import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class am implements View.OnLongClickListener {
    final /* synthetic */ PbActivity elO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(PbActivity pbActivity) {
        this.elO = pbActivity;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        SparseArray sparseArray;
        com.baidu.tbadk.baseEditMark.a aVar;
        com.baidu.tbadk.baseEditMark.a aVar2;
        boolean z;
        fa faVar;
        c.b bVar;
        PbModel pbModel;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray != null) {
            this.elO.elE = (PostData) sparseArray.get(w.h.tag_clip_board);
            if (this.elO.elE != null) {
                aVar = this.elO.dIP;
                if (aVar != null) {
                    aVar2 = this.elO.dIP;
                    if (aVar2.nH() && this.elO.elE.getId() != null) {
                        String id = this.elO.elE.getId();
                        pbModel = this.elO.ejZ;
                        if (id.equals(pbModel.rZ())) {
                            z = true;
                            boolean booleanValue = ((Boolean) sparseArray.get(w.h.tag_is_subpb)).booleanValue();
                            faVar = this.elO.ekM;
                            bVar = this.elO.elF;
                            faVar.a(bVar, z, booleanValue);
                        }
                    }
                    z = false;
                    boolean booleanValue2 = ((Boolean) sparseArray.get(w.h.tag_is_subpb)).booleanValue();
                    faVar = this.elO.ekM;
                    bVar = this.elO.elF;
                    faVar.a(bVar, z, booleanValue2);
                }
            }
        }
        return true;
    }
}
