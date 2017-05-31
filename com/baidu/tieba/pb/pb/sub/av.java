package com.baidu.tieba.pb.pb.sub;

import android.util.SparseArray;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tieba.pb.pb.sub.ba;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av implements AdapterView.OnItemClickListener {
    final /* synthetic */ ao eyO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(ao aoVar) {
        this.eyO = aoVar;
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
        newSubPbActivity = this.eyO.eyk;
        if (bh.aN(newSubPbActivity.getPageContext().getPageActivity())) {
            bVar = this.eyO.eyb;
            if (bVar != null) {
                bVar2 = this.eyO.eyb;
                bVar2.aNG();
            }
            this.eyO.aNU();
            if (view == null || !(view.getTag() instanceof ba.a)) {
                arrayList = this.eyO.eyF;
                PostData postData = (PostData) com.baidu.tbadk.core.util.x.c(arrayList, i);
                if (postData == null) {
                    this.eyO.eyG = null;
                } else {
                    this.eyO.eyG = postData.getId();
                }
                SparseArray sparseArray = (SparseArray) view.getTag();
                if (sparseArray != null) {
                    String str = (String) sparseArray.get(w.h.tag_photo_username);
                    String str2 = (String) sparseArray.get(w.h.tag_photo_userid);
                    if (str != null) {
                        nVar = this.eyO.dnc;
                        nVar.setReplyId(str2);
                        nVar2 = this.eyO.dnc;
                        nVar2.fC(str);
                    }
                }
                this.eyO.aNV();
                return;
            }
            this.eyO.aNW();
            subPbModel = this.eyO.exN;
            subPbModel.aOq();
        }
    }
}
