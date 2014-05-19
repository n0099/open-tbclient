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
        com.baidu.tieba.model.ai aiVar;
        boolean z;
        bj bjVar;
        DialogInterface.OnClickListener onClickListener;
        bc bcVar;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray != null) {
            this.a.c = (com.baidu.tieba.data.ah) sparseArray.get(com.baidu.tieba.r.tag_clip_board);
            if (this.a.c != null) {
                aiVar = this.a.z;
                if (aiVar.a() && this.a.c.d() != null) {
                    String d = this.a.c.d();
                    bcVar = this.a.y;
                    if (d.equals(bcVar.o())) {
                        z = true;
                        boolean booleanValue = ((Boolean) sparseArray.get(com.baidu.tieba.r.tag_is_subpb)).booleanValue();
                        bjVar = this.a.E;
                        onClickListener = this.a.an;
                        bjVar.a(onClickListener, z, booleanValue);
                    }
                }
                z = false;
                boolean booleanValue2 = ((Boolean) sparseArray.get(com.baidu.tieba.r.tag_is_subpb)).booleanValue();
                bjVar = this.a.E;
                onClickListener = this.a.an;
                bjVar.a(onClickListener, z, booleanValue2);
            }
        }
        return true;
    }
}
