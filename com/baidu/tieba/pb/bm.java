package com.baidu.tieba.pb;

import android.content.DialogInterface;
import android.util.SparseArray;
import android.view.View;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class bm implements View.OnLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f2080a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(NewPbActivity newPbActivity) {
        this.f2080a = newPbActivity;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        SparseArray sparseArray;
        com.baidu.tieba.model.bg bgVar;
        boolean z;
        cr crVar;
        DialogInterface.OnClickListener onClickListener;
        com.baidu.tieba.model.bm bmVar;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray != null) {
            this.f2080a.b = (com.baidu.tieba.data.ar) sparseArray.get(R.id.tag_clip_board);
            if (this.f2080a.b != null) {
                bgVar = this.f2080a.t;
                if (bgVar.a() && this.f2080a.b.d() != null) {
                    String d = this.f2080a.b.d();
                    bmVar = this.f2080a.s;
                    if (d.equals(bmVar.k())) {
                        z = true;
                        boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_is_subpb)).booleanValue();
                        crVar = this.f2080a.y;
                        onClickListener = this.f2080a.Y;
                        crVar.a(onClickListener, z, booleanValue);
                    }
                }
                z = false;
                boolean booleanValue2 = ((Boolean) sparseArray.get(R.id.tag_is_subpb)).booleanValue();
                crVar = this.f2080a.y;
                onClickListener = this.f2080a.Y;
                crVar.a(onClickListener, z, booleanValue2);
            }
        }
        return true;
    }
}
