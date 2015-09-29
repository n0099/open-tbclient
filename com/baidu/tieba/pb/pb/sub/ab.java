package com.baidu.tieba.pb.pb.sub;

import android.util.SparseArray;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.i;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements AdapterView.OnItemClickListener {
    final /* synthetic */ t cmM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(t tVar) {
        this.cmM = tVar;
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
        newSubPbActivity = this.cmM.cmv;
        if (bc.ah(newSubPbActivity.getPageContext().getPageActivity())) {
            arrayList = this.cmM.cmI;
            if (arrayList != null) {
                arrayList2 = this.cmM.cmI;
                if (i < arrayList2.size()) {
                    arrayList3 = this.cmM.cmI;
                    if (arrayList3.get(i) != null) {
                        t tVar = this.cmM;
                        arrayList4 = this.cmM.cmI;
                        tVar.cmJ = ((com.baidu.tieba.tbadkCore.data.k) arrayList4.get(i)).getId();
                        sparseArray = (SparseArray) view.getTag();
                        if (sparseArray == null && (str = (String) sparseArray.get(i.f.tag_photo_username)) != null) {
                            nVar = this.cmM.caJ;
                            nVar.fh(str);
                            this.cmM.f(i, view);
                            return;
                        }
                    }
                }
            }
            this.cmM.cmJ = null;
            sparseArray = (SparseArray) view.getTag();
            if (sparseArray == null) {
            }
        }
    }
}
