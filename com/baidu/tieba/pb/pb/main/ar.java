package com.baidu.tieba.pb.pb.main;

import android.util.SparseArray;
import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class ar implements View.OnLongClickListener {
    final /* synthetic */ PbActivity enc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(PbActivity pbActivity) {
        this.enc = pbActivity;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        SparseArray sparseArray;
        com.baidu.tbadk.baseEditMark.a aVar;
        com.baidu.tbadk.baseEditMark.a aVar2;
        boolean z;
        fx fxVar;
        c.b bVar;
        PbModel pbModel;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray != null) {
            this.enc.emS = (PostData) sparseArray.get(w.h.tag_clip_board);
            if (this.enc.emS != null) {
                aVar = this.enc.dHz;
                if (aVar != null) {
                    aVar2 = this.enc.dHz;
                    if (aVar2.nD() && this.enc.emS.getId() != null) {
                        String id = this.enc.emS.getId();
                        pbModel = this.enc.ele;
                        if (id.equals(pbModel.rD())) {
                            z = true;
                            boolean booleanValue = ((Boolean) sparseArray.get(w.h.tag_is_subpb)).booleanValue();
                            fxVar = this.enc.elU;
                            bVar = this.enc.emT;
                            fxVar.a(bVar, z, booleanValue);
                        }
                    }
                    z = false;
                    boolean booleanValue2 = ((Boolean) sparseArray.get(w.h.tag_is_subpb)).booleanValue();
                    fxVar = this.enc.elU;
                    bVar = this.enc.emT;
                    fxVar.a(bVar, z, booleanValue2);
                }
            }
        }
        return true;
    }
}
