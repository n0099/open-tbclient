package com.baidu.tieba.pb;

import android.content.DialogInterface;
import android.util.SparseArray;
import android.view.View;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class bf implements View.OnLongClickListener {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        SparseArray sparseArray;
        com.baidu.tieba.model.av avVar;
        boolean z;
        cu cuVar;
        DialogInterface.OnClickListener onClickListener;
        com.baidu.tieba.model.bb bbVar;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray != null) {
            this.a.b = (com.baidu.tieba.data.aq) sparseArray.get(R.id.tag_clip_board);
            if (this.a.b != null) {
                avVar = this.a.x;
                if (avVar.a() && this.a.b.d() != null) {
                    String d = this.a.b.d();
                    bbVar = this.a.w;
                    if (d.equals(bbVar.l())) {
                        z = true;
                        boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_is_subpb)).booleanValue();
                        cuVar = this.a.C;
                        onClickListener = this.a.af;
                        cuVar.a(onClickListener, z, booleanValue);
                    }
                }
                z = false;
                boolean booleanValue2 = ((Boolean) sparseArray.get(R.id.tag_is_subpb)).booleanValue();
                cuVar = this.a.C;
                onClickListener = this.a.af;
                cuVar.a(onClickListener, z, booleanValue2);
            }
        }
        return true;
    }
}
