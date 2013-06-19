package com.baidu.tieba.pb;

import android.content.DialogInterface;
import android.util.SparseArray;
import android.view.View;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class ax implements View.OnLongClickListener {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        com.baidu.tieba.c.ak akVar;
        bk bkVar;
        DialogInterface.OnClickListener onClickListener;
        com.baidu.tieba.c.ax axVar;
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            this.a.c = (com.baidu.tieba.a.ar) sparseArray.get(R.id.tag_clip_board);
            if (this.a.c != null) {
                boolean z = false;
                akVar = this.a.k;
                if (akVar.d() && this.a.c.d() != null) {
                    String d = this.a.c.d();
                    axVar = this.a.j;
                    if (d.equals(axVar.l())) {
                        z = true;
                    }
                }
                bkVar = this.a.p;
                onClickListener = this.a.J;
                bkVar.a(onClickListener, z);
            }
        }
        return true;
    }
}
