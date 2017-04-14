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
    final /* synthetic */ ao etF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(ao aoVar) {
        this.etF = aoVar;
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
        newSubPbActivity = this.etF.etb;
        if (bg.aK(newSubPbActivity.getPageContext().getPageActivity())) {
            bVar = this.etF.esS;
            if (bVar != null) {
                bVar2 = this.etF.esS;
                bVar2.aOh();
            }
            this.etF.aOu();
            if (view == null || !(view.getTag() instanceof ba.a)) {
                arrayList = this.etF.etw;
                PostData postData = (PostData) com.baidu.tbadk.core.util.x.c(arrayList, i);
                if (postData == null) {
                    this.etF.etx = null;
                } else {
                    this.etF.etx = postData.getId();
                }
                SparseArray sparseArray = (SparseArray) view.getTag();
                if (sparseArray != null) {
                    String str = (String) sparseArray.get(w.h.tag_photo_username);
                    String str2 = (String) sparseArray.get(w.h.tag_photo_userid);
                    if (str != null) {
                        nVar = this.etF.dlk;
                        nVar.setReplyId(str2);
                        nVar2 = this.etF.dlk;
                        nVar2.fH(str);
                    }
                }
                this.etF.aOv();
                return;
            }
            this.etF.aOw();
            subPbModel = this.etF.esE;
            subPbModel.aOQ();
        }
    }
}
