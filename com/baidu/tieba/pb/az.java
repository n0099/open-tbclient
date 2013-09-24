package com.baidu.tieba.pb;

import android.content.DialogInterface;
import android.util.SparseArray;
import android.view.View;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class az implements View.OnLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f1545a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(NewPbActivity newPbActivity) {
        this.f1545a = newPbActivity;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        com.baidu.tieba.model.aw awVar;
        br brVar;
        DialogInterface.OnClickListener onClickListener;
        com.baidu.tieba.model.bd bdVar;
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            this.f1545a.f1516a = (com.baidu.tieba.data.as) sparseArray.get(R.id.tag_clip_board);
            if (this.f1545a.f1516a != null) {
                boolean z = false;
                awVar = this.f1545a.o;
                if (awVar.a() && this.f1545a.f1516a.d() != null) {
                    String d = this.f1545a.f1516a.d();
                    bdVar = this.f1545a.n;
                    if (d.equals(bdVar.j())) {
                        z = true;
                    }
                }
                boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_is_subpb)).booleanValue();
                brVar = this.f1545a.t;
                onClickListener = this.f1545a.Q;
                brVar.a(onClickListener, z, booleanValue);
            }
        }
        return true;
    }
}
