package com.baidu.tieba.pb.main;

import android.content.DialogInterface;
import android.util.SparseArray;
import android.view.View;
/* loaded from: classes.dex */
class r implements View.OnLongClickListener {
    final /* synthetic */ PbActivity bzj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(PbActivity pbActivity) {
        this.bzj = pbActivity;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        SparseArray sparseArray;
        com.baidu.tbadk.baseEditMark.e eVar;
        boolean z;
        bz bzVar;
        DialogInterface.OnClickListener onClickListener;
        bq bqVar;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray != null) {
            this.bzj.bzh = (com.baidu.tieba.tbadkCore.b.k) sparseArray.get(com.baidu.tieba.w.tag_clip_board);
            if (this.bzj.bzh != null) {
                eVar = this.bzj.byK;
                if (eVar.li() && this.bzj.bzh.getId() != null) {
                    String id = this.bzj.bzh.getId();
                    bqVar = this.bzj.byJ;
                    if (id.equals(bqVar.nx())) {
                        z = true;
                        boolean booleanValue = ((Boolean) sparseArray.get(com.baidu.tieba.w.tag_is_subpb)).booleanValue();
                        bzVar = this.bzj.byO;
                        onClickListener = this.bzj.bzi;
                        bzVar.a(onClickListener, z, booleanValue);
                    }
                }
                z = false;
                boolean booleanValue2 = ((Boolean) sparseArray.get(com.baidu.tieba.w.tag_is_subpb)).booleanValue();
                bzVar = this.bzj.byO;
                onClickListener = this.bzj.bzi;
                bzVar.a(onClickListener, z, booleanValue2);
            }
        }
        return true;
    }
}
