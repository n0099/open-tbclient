package com.baidu.tieba.pb.pb.sub;

import android.util.SparseArray;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.util.bj;
import com.baidu.tieba.n;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements AdapterView.OnItemClickListener {
    final /* synthetic */ w cHA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(w wVar) {
        this.cHA = wVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        NewSubPbActivity newSubPbActivity;
        ArrayList arrayList;
        SparseArray sparseArray;
        String str;
        com.baidu.tbadk.editortools.d.p pVar;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        newSubPbActivity = this.cHA.cHi;
        if (bj.ah(newSubPbActivity.getPageContext().getPageActivity())) {
            arrayList = this.cHA.cHw;
            if (arrayList != null) {
                arrayList2 = this.cHA.cHw;
                if (i < arrayList2.size()) {
                    arrayList3 = this.cHA.cHw;
                    if (arrayList3.get(i) != null) {
                        w wVar = this.cHA;
                        arrayList4 = this.cHA.cHw;
                        wVar.cHx = ((com.baidu.tieba.tbadkCore.data.o) arrayList4.get(i)).getId();
                        sparseArray = (SparseArray) view.getTag();
                        if (sparseArray == null && (str = (String) sparseArray.get(n.f.tag_photo_username)) != null) {
                            pVar = this.cHA.ceY;
                            pVar.fy(str);
                            this.cHA.f(i, view);
                            return;
                        }
                    }
                }
            }
            this.cHA.cHx = null;
            sparseArray = (SparseArray) view.getTag();
            if (sparseArray == null) {
            }
        }
    }
}
