package com.baidu.tieba.pb.pb.sub;

import android.util.SparseArray;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tieba.pb.pb.sub.ba;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av implements AdapterView.OnItemClickListener {
    final /* synthetic */ ao evV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(ao aoVar) {
        this.evV = aoVar;
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
        newSubPbActivity = this.evV.evs;
        if (bg.aK(newSubPbActivity.getPageContext().getPageActivity())) {
            bVar = this.evV.evj;
            if (bVar != null) {
                bVar2 = this.evV.evj;
                bVar2.aPi();
            }
            this.evV.aPv();
            if (view == null || !(view.getTag() instanceof ba.a)) {
                arrayList = this.evV.evM;
                PostData postData = (PostData) com.baidu.tbadk.core.util.x.c(arrayList, i);
                if (postData == null) {
                    this.evV.evN = null;
                } else {
                    this.evV.evN = postData.getId();
                }
                SparseArray sparseArray = (SparseArray) view.getTag();
                if (sparseArray != null) {
                    String str = (String) sparseArray.get(w.h.tag_photo_username);
                    String str2 = (String) sparseArray.get(w.h.tag_photo_userid);
                    if (str != null) {
                        nVar = this.evV.dnB;
                        nVar.setReplyId(str2);
                        nVar2 = this.evV.dnB;
                        nVar2.fH(str);
                    }
                }
                this.evV.aPw();
                return;
            }
            this.evV.aPx();
            subPbModel = this.evV.euV;
            subPbModel.aPR();
        }
    }
}
