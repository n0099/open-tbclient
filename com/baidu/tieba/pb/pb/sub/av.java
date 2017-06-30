package com.baidu.tieba.pb.pb.sub;

import android.util.SparseArray;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.util.bl;
import com.baidu.tieba.pb.pb.sub.ba;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av implements AdapterView.OnItemClickListener {
    final /* synthetic */ ao eIl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(ao aoVar) {
        this.eIl = aoVar;
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
        newSubPbActivity = this.eIl.eHI;
        if (bl.aN(newSubPbActivity.getPageContext().getPageActivity())) {
            bVar = this.eIl.eHz;
            if (bVar != null) {
                bVar2 = this.eIl.eHz;
                bVar2.aRG();
            }
            this.eIl.aRT();
            if (view == null || !(view.getTag() instanceof ba.a)) {
                arrayList = this.eIl.eIc;
                PostData postData = (PostData) com.baidu.tbadk.core.util.z.c(arrayList, i);
                if (postData == null) {
                    this.eIl.eId = null;
                } else {
                    this.eIl.eId = postData.getId();
                }
                SparseArray sparseArray = (SparseArray) view.getTag();
                if (sparseArray != null) {
                    String str = (String) sparseArray.get(w.h.tag_photo_username);
                    String str2 = (String) sparseArray.get(w.h.tag_photo_userid);
                    if (str != null) {
                        nVar = this.eIl.duY;
                        nVar.setReplyId(str2);
                        nVar2 = this.eIl.duY;
                        nVar2.fW(str);
                    }
                }
                this.eIl.aRU();
                return;
            }
            this.eIl.aRV();
            subPbModel = this.eIl.eHl;
            subPbModel.aSp();
        }
    }
}
