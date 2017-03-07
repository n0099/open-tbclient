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
    final /* synthetic */ ao evz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(ao aoVar) {
        this.evz = aoVar;
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
        newSubPbActivity = this.evz.euW;
        if (bg.aI(newSubPbActivity.getPageContext().getPageActivity())) {
            bVar = this.evz.euN;
            if (bVar != null) {
                bVar2 = this.evz.euN;
                bVar2.aNY();
            }
            this.evz.aOl();
            if (view == null || !(view.getTag() instanceof ba.a)) {
                arrayList = this.evz.evq;
                PostData postData = (PostData) com.baidu.tbadk.core.util.x.c(arrayList, i);
                if (postData == null) {
                    this.evz.evr = null;
                } else {
                    this.evz.evr = postData.getId();
                }
                SparseArray sparseArray = (SparseArray) view.getTag();
                if (sparseArray != null) {
                    String str = (String) sparseArray.get(w.h.tag_photo_username);
                    String str2 = (String) sparseArray.get(w.h.tag_photo_userid);
                    if (str != null) {
                        nVar = this.evz.dmL;
                        nVar.setReplyId(str2);
                        nVar2 = this.evz.dmL;
                        nVar2.fB(str);
                    }
                }
                this.evz.aOm();
                return;
            }
            this.evz.aOn();
            subPbModel = this.evz.euz;
            subPbModel.aOH();
        }
    }
}
