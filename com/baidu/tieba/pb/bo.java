package com.baidu.tieba.pb;

import android.content.DialogInterface;
import android.util.SparseArray;
import android.view.View;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class bo implements View.OnLongClickListener {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bo(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
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
            this.a.b = (com.baidu.tieba.data.as) sparseArray.get(R.id.tag_clip_board);
            if (this.a.b != null) {
                bgVar = this.a.v;
                if (bgVar.a() && this.a.b.d() != null) {
                    String d = this.a.b.d();
                    bmVar = this.a.u;
                    if (d.equals(bmVar.k())) {
                        z = true;
                        boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_is_subpb)).booleanValue();
                        crVar = this.a.A;
                        onClickListener = this.a.ac;
                        crVar.a(onClickListener, z, booleanValue);
                    }
                }
                z = false;
                boolean booleanValue2 = ((Boolean) sparseArray.get(R.id.tag_is_subpb)).booleanValue();
                crVar = this.a.A;
                onClickListener = this.a.ac;
                crVar.a(onClickListener, z, booleanValue2);
            }
        }
        return true;
    }
}
