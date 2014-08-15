package com.baidu.tieba.pb.main;

import android.content.DialogInterface;
import android.util.SparseArray;
import android.view.View;
/* loaded from: classes.dex */
class y implements View.OnLongClickListener {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        SparseArray sparseArray;
        com.baidu.tieba.model.ai aiVar;
        boolean z;
        bs bsVar;
        DialogInterface.OnClickListener onClickListener;
        bl blVar;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray != null) {
            this.a.c = (com.baidu.tieba.data.an) sparseArray.get(com.baidu.tieba.u.tag_clip_board);
            if (this.a.c != null) {
                aiVar = this.a.y;
                if (aiVar.a() && this.a.c.d() != null) {
                    String d = this.a.c.d();
                    blVar = this.a.x;
                    if (d.equals(blVar.q())) {
                        z = true;
                        boolean booleanValue = ((Boolean) sparseArray.get(com.baidu.tieba.u.tag_is_subpb)).booleanValue();
                        bsVar = this.a.D;
                        onClickListener = this.a.am;
                        bsVar.a(onClickListener, z, booleanValue);
                    }
                }
                z = false;
                boolean booleanValue2 = ((Boolean) sparseArray.get(com.baidu.tieba.u.tag_is_subpb)).booleanValue();
                bsVar = this.a.D;
                onClickListener = this.a.am;
                bsVar.a(onClickListener, z, booleanValue2);
            }
        }
        return true;
    }
}
