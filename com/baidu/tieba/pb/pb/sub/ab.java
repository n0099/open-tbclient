package com.baidu.tieba.pb.pb.sub;

import android.util.SparseArray;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tieba.i;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements AdapterView.OnItemClickListener {
    final /* synthetic */ t cgt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(t tVar) {
        this.cgt = tVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        NewSubPbActivity newSubPbActivity;
        ArrayList arrayList;
        SparseArray sparseArray;
        String str;
        com.baidu.tbadk.editortools.c.n nVar;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        newSubPbActivity = this.cgt.cgc;
        if (bb.ah(newSubPbActivity.getPageContext().getPageActivity())) {
            arrayList = this.cgt.cgo;
            if (arrayList != null) {
                arrayList2 = this.cgt.cgo;
                if (i < arrayList2.size()) {
                    arrayList3 = this.cgt.cgo;
                    if (arrayList3.get(i) != null) {
                        t tVar = this.cgt;
                        arrayList4 = this.cgt.cgo;
                        tVar.cgp = ((com.baidu.tieba.tbadkCore.data.i) arrayList4.get(i)).getId();
                        sparseArray = (SparseArray) view.getTag();
                        if (sparseArray == null && (str = (String) sparseArray.get(i.f.tag_photo_username)) != null) {
                            nVar = this.cgt.bWp;
                            nVar.eU(str);
                            this.cgt.e(i, view);
                            return;
                        }
                    }
                }
            }
            this.cgt.cgp = null;
            sparseArray = (SparseArray) view.getTag();
            if (sparseArray == null) {
            }
        }
    }
}
