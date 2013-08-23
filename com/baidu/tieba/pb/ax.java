package com.baidu.tieba.pb;

import android.content.DialogInterface;
import android.util.SparseArray;
import android.view.View;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class ax implements View.OnLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f1500a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(NewPbActivity newPbActivity) {
        this.f1500a = newPbActivity;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        com.baidu.tieba.model.au auVar;
        bo boVar;
        DialogInterface.OnClickListener onClickListener;
        com.baidu.tieba.model.bb bbVar;
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            this.f1500a.f1474a = (com.baidu.tieba.data.as) sparseArray.get(R.id.tag_clip_board);
            if (this.f1500a.f1474a != null) {
                boolean z = false;
                auVar = this.f1500a.l;
                if (auVar.a() && this.f1500a.f1474a.d() != null) {
                    String d = this.f1500a.f1474a.d();
                    bbVar = this.f1500a.k;
                    if (d.equals(bbVar.j())) {
                        z = true;
                    }
                }
                boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_is_subpb)).booleanValue();
                boVar = this.f1500a.q;
                onClickListener = this.f1500a.M;
                boVar.a(onClickListener, z, booleanValue);
            }
        }
        return true;
    }
}
