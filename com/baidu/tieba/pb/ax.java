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
        com.baidu.tieba.model.am amVar;
        bk bkVar;
        DialogInterface.OnClickListener onClickListener;
        com.baidu.tieba.model.ax axVar;
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            this.a.a = (com.baidu.tieba.data.an) sparseArray.get(R.id.tag_clip_board);
            if (this.a.a != null) {
                boolean z = false;
                amVar = this.a.k;
                if (amVar.a() && this.a.a.d() != null) {
                    String d = this.a.a.d();
                    axVar = this.a.j;
                    if (d.equals(axVar.i())) {
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
