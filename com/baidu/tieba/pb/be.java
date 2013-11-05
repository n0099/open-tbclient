package com.baidu.tieba.pb;

import android.content.DialogInterface;
import android.util.SparseArray;
import android.view.View;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class be implements View.OnLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f2068a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(NewPbActivity newPbActivity) {
        this.f2068a = newPbActivity;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        com.baidu.tieba.model.bf bfVar;
        bt btVar;
        DialogInterface.OnClickListener onClickListener;
        com.baidu.tieba.model.bl blVar;
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            this.f2068a.f2033a = (com.baidu.tieba.data.as) sparseArray.get(R.id.tag_clip_board);
            if (this.f2068a.f2033a != null) {
                boolean z = false;
                bfVar = this.f2068a.p;
                if (bfVar.a() && this.f2068a.f2033a.d() != null) {
                    String d = this.f2068a.f2033a.d();
                    blVar = this.f2068a.o;
                    if (d.equals(blVar.j())) {
                        z = true;
                    }
                }
                boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_is_subpb)).booleanValue();
                btVar = this.f2068a.u;
                onClickListener = this.f2068a.R;
                btVar.a(onClickListener, z, booleanValue);
            }
        }
        return true;
    }
}
