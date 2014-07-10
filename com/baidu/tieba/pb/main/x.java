package com.baidu.tieba.pb.main;

import android.content.DialogInterface;
import android.util.SparseArray;
import android.view.View;
/* loaded from: classes.dex */
class x implements View.OnLongClickListener {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        SparseArray sparseArray;
        com.baidu.tieba.model.ah ahVar;
        boolean z;
        bt btVar;
        DialogInterface.OnClickListener onClickListener;
        bm bmVar;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray != null) {
            this.a.c = (com.baidu.tieba.data.am) sparseArray.get(com.baidu.tieba.v.tag_clip_board);
            if (this.a.c != null) {
                ahVar = this.a.y;
                if (ahVar.a() && this.a.c.l() != null) {
                    String l = this.a.c.l();
                    bmVar = this.a.x;
                    if (l.equals(bmVar.q())) {
                        z = true;
                        boolean booleanValue = ((Boolean) sparseArray.get(com.baidu.tieba.v.tag_is_subpb)).booleanValue();
                        btVar = this.a.D;
                        onClickListener = this.a.al;
                        btVar.a(onClickListener, z, booleanValue);
                    }
                }
                z = false;
                boolean booleanValue2 = ((Boolean) sparseArray.get(com.baidu.tieba.v.tag_is_subpb)).booleanValue();
                btVar = this.a.D;
                onClickListener = this.a.al;
                btVar.a(onClickListener, z, booleanValue2);
            }
        }
        return true;
    }
}
