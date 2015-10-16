package com.baidu.tieba.pb.pb.sub;

import android.util.SparseArray;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tieba.i;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements AdapterView.OnItemClickListener {
    final /* synthetic */ t cmX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(t tVar) {
        this.cmX = tVar;
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
        newSubPbActivity = this.cmX.cmG;
        if (bd.ah(newSubPbActivity.getPageContext().getPageActivity())) {
            arrayList = this.cmX.cmT;
            if (arrayList != null) {
                arrayList2 = this.cmX.cmT;
                if (i < arrayList2.size()) {
                    arrayList3 = this.cmX.cmT;
                    if (arrayList3.get(i) != null) {
                        t tVar = this.cmX;
                        arrayList4 = this.cmX.cmT;
                        tVar.cmU = ((com.baidu.tieba.tbadkCore.data.k) arrayList4.get(i)).getId();
                        sparseArray = (SparseArray) view.getTag();
                        if (sparseArray == null && (str = (String) sparseArray.get(i.f.tag_photo_username)) != null) {
                            nVar = this.cmX.caU;
                            nVar.fh(str);
                            this.cmX.f(i, view);
                            return;
                        }
                    }
                }
            }
            this.cmX.cmU = null;
            sparseArray = (SparseArray) view.getTag();
            if (sparseArray == null) {
            }
        }
    }
}
