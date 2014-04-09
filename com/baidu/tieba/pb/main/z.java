package com.baidu.tieba.pb.main;

import android.content.DialogInterface;
import android.util.SparseArray;
import android.view.View;
/* loaded from: classes.dex */
final class z implements View.OnLongClickListener {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        SparseArray sparseArray;
        com.baidu.tieba.model.ai aiVar;
        boolean z;
        bm bmVar;
        DialogInterface.OnClickListener onClickListener;
        bf bfVar;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray != null) {
            this.a.c = (com.baidu.tieba.data.ai) sparseArray.get(com.baidu.tieba.a.h.tag_clip_board);
            if (this.a.c != null) {
                aiVar = this.a.y;
                if (aiVar.a() && this.a.c.d() != null) {
                    String d = this.a.c.d();
                    bfVar = this.a.x;
                    if (d.equals(bfVar.o())) {
                        z = true;
                        boolean booleanValue = ((Boolean) sparseArray.get(com.baidu.tieba.a.h.tag_is_subpb)).booleanValue();
                        bmVar = this.a.D;
                        onClickListener = this.a.an;
                        bmVar.a(onClickListener, z, booleanValue);
                    }
                }
                z = false;
                boolean booleanValue2 = ((Boolean) sparseArray.get(com.baidu.tieba.a.h.tag_is_subpb)).booleanValue();
                bmVar = this.a.D;
                onClickListener = this.a.an;
                bmVar.a(onClickListener, z, booleanValue2);
            }
        }
        return true;
    }
}
