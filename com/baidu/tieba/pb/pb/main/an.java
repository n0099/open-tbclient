package com.baidu.tieba.pb.pb.main;

import android.util.SparseArray;
import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class an implements View.OnLongClickListener {
    final /* synthetic */ PbActivity ehy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(PbActivity pbActivity) {
        this.ehy = pbActivity;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        SparseArray sparseArray;
        com.baidu.tbadk.baseEditMark.a aVar;
        com.baidu.tbadk.baseEditMark.a aVar2;
        boolean z;
        fm fmVar;
        c.b bVar;
        PbModel pbModel;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray != null) {
            this.ehy.eho = (PostData) sparseArray.get(w.h.tag_clip_board);
            if (this.ehy.eho != null) {
                aVar = this.ehy.dCb;
                if (aVar != null) {
                    aVar2 = this.ehy.dCb;
                    if (aVar2.nL() && this.ehy.eho.getId() != null) {
                        String id = this.ehy.eho.getId();
                        pbModel = this.ehy.efE;
                        if (id.equals(pbModel.rH())) {
                            z = true;
                            boolean booleanValue = ((Boolean) sparseArray.get(w.h.tag_is_subpb)).booleanValue();
                            fmVar = this.ehy.egt;
                            bVar = this.ehy.ehp;
                            fmVar.a(bVar, z, booleanValue);
                        }
                    }
                    z = false;
                    boolean booleanValue2 = ((Boolean) sparseArray.get(w.h.tag_is_subpb)).booleanValue();
                    fmVar = this.ehy.egt;
                    bVar = this.ehy.ehp;
                    fmVar.a(bVar, z, booleanValue2);
                }
            }
        }
        return true;
    }
}
