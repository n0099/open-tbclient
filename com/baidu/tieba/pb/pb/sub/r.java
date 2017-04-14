package com.baidu.tieba.pb.pb.sub;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.tbadkCore.data.PostData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements c.b {
    final /* synthetic */ NewSubPbActivity esV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(NewSubPbActivity newSubPbActivity) {
        this.esV = newSubPbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        SubPbModel subPbModel;
        SubPbModel subPbModel2;
        cVar.dismiss();
        PostData postData = null;
        subPbModel = this.esV.esE;
        if (subPbModel.aON() != null) {
            subPbModel2 = this.esV.esE;
            postData = subPbModel2.aON().aJV();
        }
        if (postData != null) {
            if (i == 0) {
                postData.bM(this.esV.getPageContext().getPageActivity());
            } else if (i == 1) {
                this.esV.d(postData);
            }
        }
    }
}
