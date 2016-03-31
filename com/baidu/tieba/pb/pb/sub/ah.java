package com.baidu.tieba.pb.pb.sub;

import android.util.SparseArray;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.util.bl;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements AdapterView.OnItemClickListener {
    final /* synthetic */ x dpf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(x xVar) {
        this.dpf = xVar;
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
        newSubPbActivity = this.dpf.doJ;
        if (bl.ad(newSubPbActivity.getPageContext().getPageActivity())) {
            arrayList = this.dpf.dpb;
            if (arrayList != null) {
                arrayList2 = this.dpf.dpb;
                if (i < arrayList2.size()) {
                    arrayList3 = this.dpf.dpb;
                    if (arrayList3.get(i) != null) {
                        x xVar = this.dpf;
                        arrayList4 = this.dpf.dpb;
                        xVar.dpc = ((com.baidu.tieba.tbadkCore.data.s) arrayList4.get(i)).getId();
                        sparseArray = (SparseArray) view.getTag();
                        if (sparseArray == null) {
                            String str = (String) sparseArray.get(t.g.tag_photo_username);
                            String str2 = (String) sparseArray.get(t.g.tag_photo_userid);
                            if (str != null) {
                                pVar = this.dpf.cye;
                                pVar.setReplyId(str2);
                                pVar2 = this.dpf.cye;
                                pVar2.fI(str);
                                this.dpf.f(i, view);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                }
            }
            this.dpf.dpc = null;
            sparseArray = (SparseArray) view.getTag();
            if (sparseArray == null) {
            }
        }
    }
}
