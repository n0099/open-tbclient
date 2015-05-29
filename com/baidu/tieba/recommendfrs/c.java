package com.baidu.tieba.recommendfrs;

import android.view.View;
import com.baidu.adp.lib.util.n;
import com.baidu.tbadk.core.view.PbListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ b cbE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.cbE = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        boolean z2;
        PbListView pbListView;
        com.baidu.tieba.recommendfrs.control.a.b bVar;
        int ahq;
        String str;
        z = this.cbE.mHasMore;
        if (z && n.isNetOk()) {
            z2 = this.cbE.aKl;
            if (!z2) {
                this.cbE.aKl = true;
                pbListView = this.cbE.aOf;
                pbListView.startLoadData();
                bVar = this.cbE.cbv;
                ahq = this.cbE.ahq();
                str = this.cbE.cbB;
                bVar.B(ahq, str);
            }
        }
    }
}
