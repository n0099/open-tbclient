package com.baidu.tieba.pb.pb.sub;

import android.util.SparseArray;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.util.bm;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements AdapterView.OnItemClickListener {
    final /* synthetic */ ag eyq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(ag agVar) {
        this.eyq = agVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    @Override // android.widget.AdapterView.OnItemClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        NewSubPbActivity newSubPbActivity;
        ArrayList arrayList;
        SparseArray sparseArray;
        com.baidu.tbadk.editortools.e.p pVar;
        com.baidu.tbadk.editortools.e.p pVar2;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        newSubPbActivity = this.eyq.exK;
        if (bm.ak(newSubPbActivity.getPageContext().getPageActivity())) {
            arrayList = this.eyq.eyj;
            if (arrayList != null) {
                arrayList2 = this.eyq.eyj;
                if (i < arrayList2.size()) {
                    arrayList3 = this.eyq.eyj;
                    if (arrayList3.get(i) != null) {
                        ag agVar = this.eyq;
                        arrayList4 = this.eyq.eyj;
                        agVar.eyk = ((com.baidu.tieba.tbadkCore.data.q) arrayList4.get(i)).getId();
                        sparseArray = (SparseArray) view.getTag();
                        if (sparseArray == null) {
                            String str = (String) sparseArray.get(r.g.tag_photo_username);
                            String str2 = (String) sparseArray.get(r.g.tag_photo_userid);
                            if (str != null) {
                                pVar = this.eyq.duz;
                                pVar.setReplyId(str2);
                                pVar2 = this.eyq.duz;
                                pVar2.fQ(str);
                                this.eyq.e(i, view);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                }
            }
            this.eyq.eyk = null;
            sparseArray = (SparseArray) view.getTag();
            if (sparseArray == null) {
            }
        }
    }
}
