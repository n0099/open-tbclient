package com.baidu.tieba.pb.pb.sub;

import android.util.SparseArray;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tieba.i;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements AdapterView.OnItemClickListener {
    final /* synthetic */ v coo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(v vVar) {
        this.coo = vVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        NewSubPbActivity newSubPbActivity;
        ArrayList arrayList;
        SparseArray sparseArray;
        String str;
        com.baidu.tbadk.editortools.c.p pVar;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        newSubPbActivity = this.coo.cnX;
        if (bd.ah(newSubPbActivity.getPageContext().getPageActivity())) {
            arrayList = this.coo.cok;
            if (arrayList != null) {
                arrayList2 = this.coo.cok;
                if (i < arrayList2.size()) {
                    arrayList3 = this.coo.cok;
                    if (arrayList3.get(i) != null) {
                        v vVar = this.coo;
                        arrayList4 = this.coo.cok;
                        vVar.col = ((com.baidu.tieba.tbadkCore.data.o) arrayList4.get(i)).getId();
                        sparseArray = (SparseArray) view.getTag();
                        if (sparseArray == null && (str = (String) sparseArray.get(i.f.tag_photo_username)) != null) {
                            pVar = this.coo.cbv;
                            pVar.fj(str);
                            this.coo.f(i, view);
                            return;
                        }
                    }
                }
            }
            this.coo.col = null;
            sparseArray = (SparseArray) view.getTag();
            if (sparseArray == null) {
            }
        }
    }
}
