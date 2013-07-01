package com.baidu.tieba.pb;

import android.content.DialogInterface;
import android.util.SparseArray;
import android.view.View;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class ax implements View.OnLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f1215a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(NewPbActivity newPbActivity) {
        this.f1215a = newPbActivity;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        com.baidu.tieba.model.am amVar;
        bk bkVar;
        DialogInterface.OnClickListener onClickListener;
        com.baidu.tieba.model.ax axVar;
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            this.f1215a.f1189a = (com.baidu.tieba.data.an) sparseArray.get(R.id.tag_clip_board);
            if (this.f1215a.f1189a != null) {
                boolean z = false;
                amVar = this.f1215a.k;
                if (amVar.a() && this.f1215a.f1189a.d() != null) {
                    String d = this.f1215a.f1189a.d();
                    axVar = this.f1215a.j;
                    if (d.equals(axVar.i())) {
                        z = true;
                    }
                }
                bkVar = this.f1215a.p;
                onClickListener = this.f1215a.J;
                bkVar.a(onClickListener, z);
            }
        }
        return true;
    }
}
