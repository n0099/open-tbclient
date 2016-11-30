package com.baidu.tieba.pb.pb.sub;

import android.util.SparseArray;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.util.bk;
import com.baidu.tieba.pb.pb.sub.ba;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av implements AdapterView.OnItemClickListener {
    final /* synthetic */ ao eFb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(ao aoVar) {
        this.eFb = aoVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        NewSubPbActivity newSubPbActivity;
        b bVar;
        ArrayList arrayList;
        com.baidu.tbadk.editortools.e.p pVar;
        com.baidu.tbadk.editortools.e.p pVar2;
        bc bcVar;
        b bVar2;
        newSubPbActivity = this.eFb.eEy;
        if (bk.ak(newSubPbActivity.getPageContext().getPageActivity())) {
            bVar = this.eFb.eEp;
            if (bVar != null) {
                bVar2 = this.eFb.eEp;
                bVar2.aSV();
            }
            this.eFb.aTh();
            if (view == null || !(view.getTag() instanceof ba.a)) {
                arrayList = this.eFb.eES;
                com.baidu.tieba.tbadkCore.data.q qVar = (com.baidu.tieba.tbadkCore.data.q) com.baidu.tbadk.core.util.x.c(arrayList, i);
                if (qVar == null) {
                    this.eFb.eET = null;
                } else {
                    this.eFb.eET = qVar.getId();
                }
                SparseArray sparseArray = (SparseArray) view.getTag();
                if (sparseArray != null) {
                    String str = (String) sparseArray.get(r.g.tag_photo_username);
                    String str2 = (String) sparseArray.get(r.g.tag_photo_userid);
                    if (str != null) {
                        pVar = this.eFb.dAe;
                        pVar.setReplyId(str2);
                        pVar2 = this.eFb.dAe;
                        pVar2.fT(str);
                    }
                }
                this.eFb.aTi();
                return;
            }
            this.eFb.aTj();
            bcVar = this.eFb.eEb;
            bcVar.aTD();
        }
    }
}
