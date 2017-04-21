package com.baidu.tieba.pb.pb.sub;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.tbadkCore.data.PostData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements c.b {
    final /* synthetic */ NewSubPbActivity evm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(NewSubPbActivity newSubPbActivity) {
        this.evm = newSubPbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        SubPbModel subPbModel;
        SubPbModel subPbModel2;
        cVar.dismiss();
        PostData postData = null;
        subPbModel = this.evm.euV;
        if (subPbModel.aPO() != null) {
            subPbModel2 = this.evm.euV;
            postData = subPbModel2.aPO().aKW();
        }
        if (postData != null) {
            if (i == 0) {
                postData.bM(this.evm.getPageContext().getPageActivity());
            } else if (i == 1) {
                this.evm.d(postData);
            }
        }
    }
}
