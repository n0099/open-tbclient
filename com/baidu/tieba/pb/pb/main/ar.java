package com.baidu.tieba.pb.pb.main;

import android.util.SparseArray;
import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class ar implements View.OnLongClickListener {
    final /* synthetic */ PbActivity dht;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(PbActivity pbActivity) {
        this.dht = pbActivity;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        SparseArray sparseArray;
        com.baidu.tbadk.baseEditMark.a aVar;
        com.baidu.tbadk.baseEditMark.a aVar2;
        boolean z;
        eu euVar;
        c.b bVar;
        df dfVar;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray != null) {
            this.dht.dhl = (com.baidu.tieba.tbadkCore.data.s) sparseArray.get(t.g.tag_clip_board);
            if (this.dht.dhl != null) {
                aVar = this.dht.cOZ;
                if (aVar != null) {
                    aVar2 = this.dht.cOZ;
                    if (aVar2.pu() && this.dht.dhl.getId() != null) {
                        String id = this.dht.dhl.getId();
                        dfVar = this.dht.dfV;
                        if (id.equals(dfVar.tv())) {
                            z = true;
                            boolean booleanValue = ((Boolean) sparseArray.get(t.g.tag_is_subpb)).booleanValue();
                            euVar = this.dht.dgF;
                            bVar = this.dht.dhm;
                            euVar.a(bVar, z, booleanValue);
                        }
                    }
                    z = false;
                    boolean booleanValue2 = ((Boolean) sparseArray.get(t.g.tag_is_subpb)).booleanValue();
                    euVar = this.dht.dgF;
                    bVar = this.dht.dhm;
                    euVar.a(bVar, z, booleanValue2);
                }
            }
        }
        return true;
    }
}
