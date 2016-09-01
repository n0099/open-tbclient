package com.baidu.tieba.pb.pb.sub;

import android.util.SparseArray;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.util.bn;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements AdapterView.OnItemClickListener {
    final /* synthetic */ ag ewi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(ag agVar) {
        this.ewi = agVar;
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
        com.baidu.tbadk.editortools.d.p pVar;
        com.baidu.tbadk.editortools.d.p pVar2;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        newSubPbActivity = this.ewi.evD;
        if (bn.al(newSubPbActivity.getPageContext().getPageActivity())) {
            arrayList = this.ewi.ewc;
            if (arrayList != null) {
                arrayList2 = this.ewi.ewc;
                if (i < arrayList2.size()) {
                    arrayList3 = this.ewi.ewc;
                    if (arrayList3.get(i) != null) {
                        ag agVar = this.ewi;
                        arrayList4 = this.ewi.ewc;
                        agVar.ewd = ((com.baidu.tieba.tbadkCore.data.q) arrayList4.get(i)).getId();
                        sparseArray = (SparseArray) view.getTag();
                        if (sparseArray == null) {
                            String str = (String) sparseArray.get(t.g.tag_photo_username);
                            String str2 = (String) sparseArray.get(t.g.tag_photo_userid);
                            if (str != null) {
                                pVar = this.ewi.dtc;
                                pVar.setReplyId(str2);
                                pVar2 = this.ewi.dtc;
                                pVar2.fM(str);
                                this.ewi.e(i, view);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                }
            }
            this.ewi.ewd = null;
            sparseArray = (SparseArray) view.getTag();
            if (sparseArray == null) {
            }
        }
    }
}
