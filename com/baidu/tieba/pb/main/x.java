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
        bq bqVar;
        DialogInterface.OnClickListener onClickListener;
        bj bjVar;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray != null) {
            this.a.c = (com.baidu.tieba.data.ai) sparseArray.get(com.baidu.tieba.v.tag_clip_board);
            if (this.a.c != null) {
                aiVar = this.a.y;
                if (aiVar.a() && this.a.c.l() != null) {
                    String l = this.a.c.l();
                    bjVar = this.a.x;
                    if (l.equals(bjVar.p())) {
                        z = true;
                        boolean booleanValue = ((Boolean) sparseArray.get(com.baidu.tieba.v.tag_is_subpb)).booleanValue();
                        bqVar = this.a.D;
                        onClickListener = this.a.al;
                        bqVar.a(onClickListener, z, booleanValue);
                    }
                }
                z = false;
                boolean booleanValue2 = ((Boolean) sparseArray.get(com.baidu.tieba.v.tag_is_subpb)).booleanValue();
                bqVar = this.a.D;
                onClickListener = this.a.al;
                bqVar.a(onClickListener, z, booleanValue2);
            }
        }
        return true;
    }
}
