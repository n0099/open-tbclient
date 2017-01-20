package com.baidu.tieba.pb.pb.sub;

import android.util.SparseArray;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tieba.pb.pb.sub.ba;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av implements AdapterView.OnItemClickListener {
    final /* synthetic */ ao esl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(ao aoVar) {
        this.esl = aoVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        NewSubPbActivity newSubPbActivity;
        b bVar;
        ArrayList arrayList;
        com.baidu.tbadk.editortools.pb.n nVar;
        com.baidu.tbadk.editortools.pb.n nVar2;
        SubPbModel subPbModel;
        b bVar2;
        newSubPbActivity = this.esl.erI;
        if (bf.ak(newSubPbActivity.getPageContext().getPageActivity())) {
            bVar = this.esl.erz;
            if (bVar != null) {
                bVar2 = this.esl.erz;
                bVar2.aOH();
            }
            this.esl.aOU();
            if (view == null || !(view.getTag() instanceof ba.a)) {
                arrayList = this.esl.esc;
                com.baidu.tieba.tbadkCore.data.p pVar = (com.baidu.tieba.tbadkCore.data.p) com.baidu.tbadk.core.util.w.c(arrayList, i);
                if (pVar == null) {
                    this.esl.esd = null;
                } else {
                    this.esl.esd = pVar.getId();
                }
                SparseArray sparseArray = (SparseArray) view.getTag();
                if (sparseArray != null) {
                    String str = (String) sparseArray.get(r.h.tag_photo_username);
                    String str2 = (String) sparseArray.get(r.h.tag_photo_userid);
                    if (str != null) {
                        nVar = this.esl.dkr;
                        nVar.setReplyId(str2);
                        nVar2 = this.esl.dkr;
                        nVar2.fM(str);
                    }
                }
                this.esl.aOV();
                return;
            }
            this.esl.aOW();
            subPbModel = this.esl.erl;
            subPbModel.aPq();
        }
    }
}
