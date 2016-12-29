package com.baidu.tieba.pb.pb.sub;

import android.util.SparseArray;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tieba.pb.pb.sub.ba;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av implements AdapterView.OnItemClickListener {
    final /* synthetic */ ao ejb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(ao aoVar) {
        this.ejb = aoVar;
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
        newSubPbActivity = this.ejb.eiy;
        if (bh.ai(newSubPbActivity.getPageContext().getPageActivity())) {
            bVar = this.ejb.eip;
            if (bVar != null) {
                bVar2 = this.ejb.eip;
                bVar2.aMM();
            }
            this.ejb.aMY();
            if (view == null || !(view.getTag() instanceof ba.a)) {
                arrayList = this.ejb.eiS;
                com.baidu.tieba.tbadkCore.data.q qVar = (com.baidu.tieba.tbadkCore.data.q) com.baidu.tbadk.core.util.x.c(arrayList, i);
                if (qVar == null) {
                    this.ejb.eiT = null;
                } else {
                    this.ejb.eiT = qVar.getId();
                }
                SparseArray sparseArray = (SparseArray) view.getTag();
                if (sparseArray != null) {
                    String str = (String) sparseArray.get(r.g.tag_photo_username);
                    String str2 = (String) sparseArray.get(r.g.tag_photo_userid);
                    if (str != null) {
                        pVar = this.ejb.ddg;
                        pVar.setReplyId(str2);
                        pVar2 = this.ejb.ddg;
                        pVar2.fP(str);
                    }
                }
                this.ejb.aMZ();
                return;
            }
            this.ejb.aNa();
            bcVar = this.ejb.eib;
            bcVar.aNu();
        }
    }
}
