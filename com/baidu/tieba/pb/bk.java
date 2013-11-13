package com.baidu.tieba.pb;

import android.content.DialogInterface;
import android.util.SparseArray;
import android.view.View;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class bk implements View.OnLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f2095a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(NewPbActivity newPbActivity) {
        this.f2095a = newPbActivity;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        com.baidu.tieba.model.bg bgVar;
        cp cpVar;
        DialogInterface.OnClickListener onClickListener;
        com.baidu.tieba.model.bm bmVar;
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            this.f2095a.b = (com.baidu.tieba.data.as) sparseArray.get(R.id.tag_clip_board);
            if (this.f2095a.b != null) {
                boolean z = false;
                bgVar = this.f2095a.t;
                if (bgVar.a() && this.f2095a.b.d() != null) {
                    String d = this.f2095a.b.d();
                    bmVar = this.f2095a.s;
                    if (d.equals(bmVar.k())) {
                        z = true;
                    }
                }
                boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_is_subpb)).booleanValue();
                cpVar = this.f2095a.y;
                onClickListener = this.f2095a.Y;
                cpVar.a(onClickListener, z, booleanValue);
            }
        }
        return true;
    }
}
