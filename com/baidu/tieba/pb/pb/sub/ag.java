package com.baidu.tieba.pb.pb.sub;

import android.util.SparseArray;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.util.bi;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements AdapterView.OnItemClickListener {
    final /* synthetic */ w cUl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(w wVar) {
        this.cUl = wVar;
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
        newSubPbActivity = this.cUl.cTO;
        if (bi.ah(newSubPbActivity.getPageContext().getPageActivity())) {
            arrayList = this.cUl.cUh;
            if (arrayList != null) {
                arrayList2 = this.cUl.cUh;
                if (i < arrayList2.size()) {
                    arrayList3 = this.cUl.cUh;
                    if (arrayList3.get(i) != null) {
                        w wVar = this.cUl;
                        arrayList4 = this.cUl.cUh;
                        wVar.cUi = ((com.baidu.tieba.tbadkCore.data.r) arrayList4.get(i)).getId();
                        sparseArray = (SparseArray) view.getTag();
                        if (sparseArray == null && (str = (String) sparseArray.get(t.g.tag_photo_username)) != null) {
                            pVar = this.cUl.cnC;
                            pVar.fA(str);
                            this.cUl.g(i, view);
                            return;
                        }
                    }
                }
            }
            this.cUl.cUi = null;
            sparseArray = (SparseArray) view.getTag();
            if (sparseArray == null) {
            }
        }
    }
}
