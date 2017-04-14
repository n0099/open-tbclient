package com.baidu.tieba.pb.pb.main;

import android.util.SparseArray;
import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class am implements View.OnLongClickListener {
    final /* synthetic */ PbActivity ejU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(PbActivity pbActivity) {
        this.ejU = pbActivity;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        SparseArray sparseArray;
        com.baidu.tbadk.baseEditMark.a aVar;
        com.baidu.tbadk.baseEditMark.a aVar2;
        boolean z;
        ey eyVar;
        c.b bVar;
        PbModel pbModel;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray != null) {
            this.ejU.ejK = (PostData) sparseArray.get(w.h.tag_clip_board);
            if (this.ejU.ejK != null) {
                aVar = this.ejU.dFo;
                if (aVar != null) {
                    aVar2 = this.ejU.dFo;
                    if (aVar2.oe() && this.ejU.ejK.getId() != null) {
                        String id = this.ejU.ejK.getId();
                        pbModel = this.ejU.eif;
                        if (id.equals(pbModel.sx())) {
                            z = true;
                            boolean booleanValue = ((Boolean) sparseArray.get(w.h.tag_is_subpb)).booleanValue();
                            eyVar = this.ejU.eiS;
                            bVar = this.ejU.ejL;
                            eyVar.a(bVar, z, booleanValue);
                        }
                    }
                    z = false;
                    boolean booleanValue2 = ((Boolean) sparseArray.get(w.h.tag_is_subpb)).booleanValue();
                    eyVar = this.ejU.eiS;
                    bVar = this.ejU.ejL;
                    eyVar.a(bVar, z, booleanValue2);
                }
            }
        }
        return true;
    }
}
