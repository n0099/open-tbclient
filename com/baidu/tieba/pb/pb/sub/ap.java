package com.baidu.tieba.pb.pb.sub;

import android.util.SparseArray;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.util.bn;
import com.baidu.tieba.u;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements AdapterView.OnItemClickListener {
    final /* synthetic */ af dXy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(af afVar) {
        this.dXy = afVar;
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
        newSubPbActivity = this.dXy.dWU;
        if (bn.ab(newSubPbActivity.getPageContext().getPageActivity())) {
            arrayList = this.dXy.dXs;
            if (arrayList != null) {
                arrayList2 = this.dXy.dXs;
                if (i < arrayList2.size()) {
                    arrayList3 = this.dXy.dXs;
                    if (arrayList3.get(i) != null) {
                        af afVar = this.dXy;
                        arrayList4 = this.dXy.dXs;
                        afVar.dXt = ((com.baidu.tieba.tbadkCore.data.s) arrayList4.get(i)).getId();
                        sparseArray = (SparseArray) view.getTag();
                        if (sparseArray == null) {
                            String str = (String) sparseArray.get(u.g.tag_photo_username);
                            String str2 = (String) sparseArray.get(u.g.tag_photo_userid);
                            if (str != null) {
                                pVar = this.dXy.deA;
                                pVar.setReplyId(str2);
                                pVar2 = this.dXy.deA;
                                pVar2.fL(str);
                                this.dXy.e(i, view);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                }
            }
            this.dXy.dXt = null;
            sparseArray = (SparseArray) view.getTag();
            if (sparseArray == null) {
            }
        }
    }
}
