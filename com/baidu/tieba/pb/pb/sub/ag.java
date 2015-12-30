package com.baidu.tieba.pb.pb.sub;

import android.util.SparseArray;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.util.bj;
import com.baidu.tieba.n;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements AdapterView.OnItemClickListener {
    final /* synthetic */ w cLC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(w wVar) {
        this.cLC = wVar;
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
        newSubPbActivity = this.cLC.cLg;
        if (bj.ah(newSubPbActivity.getPageContext().getPageActivity())) {
            arrayList = this.cLC.cLy;
            if (arrayList != null) {
                arrayList2 = this.cLC.cLy;
                if (i < arrayList2.size()) {
                    arrayList3 = this.cLC.cLy;
                    if (arrayList3.get(i) != null) {
                        w wVar = this.cLC;
                        arrayList4 = this.cLC.cLy;
                        wVar.cLz = ((com.baidu.tieba.tbadkCore.data.r) arrayList4.get(i)).getId();
                        sparseArray = (SparseArray) view.getTag();
                        if (sparseArray == null && (str = (String) sparseArray.get(n.g.tag_photo_username)) != null) {
                            pVar = this.cLC.cjc;
                            pVar.fC(str);
                            this.cLC.g(i, view);
                            return;
                        }
                    }
                }
            }
            this.cLC.cLz = null;
            sparseArray = (SparseArray) view.getTag();
            if (sparseArray == null) {
            }
        }
    }
}
