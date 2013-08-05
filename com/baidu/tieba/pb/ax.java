package com.baidu.tieba.pb;

import android.content.DialogInterface;
import android.util.SparseArray;
import android.view.View;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class ax implements View.OnLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f1465a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(NewPbActivity newPbActivity) {
        this.f1465a = newPbActivity;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        com.baidu.tieba.model.av avVar;
        bn bnVar;
        DialogInterface.OnClickListener onClickListener;
        com.baidu.tieba.model.bc bcVar;
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            this.f1465a.f1439a = (com.baidu.tieba.data.aw) sparseArray.get(R.id.tag_clip_board);
            if (this.f1465a.f1439a != null) {
                boolean z = false;
                avVar = this.f1465a.k;
                if (avVar.a() && this.f1465a.f1439a.d() != null) {
                    String d = this.f1465a.f1439a.d();
                    bcVar = this.f1465a.j;
                    if (d.equals(bcVar.i())) {
                        z = true;
                    }
                }
                boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_is_subpb)).booleanValue();
                bnVar = this.f1465a.p;
                onClickListener = this.f1465a.L;
                bnVar.a(onClickListener, z, booleanValue);
            }
        }
        return true;
    }
}
