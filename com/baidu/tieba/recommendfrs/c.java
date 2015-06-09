package com.baidu.tieba.recommendfrs;

import android.view.View;
import com.baidu.adp.lib.util.n;
import com.baidu.tbadk.core.view.PbListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ b cbF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.cbF = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        boolean z2;
        PbListView pbListView;
        com.baidu.tieba.recommendfrs.control.a.b bVar;
        int ahr;
        String str;
        z = this.cbF.mHasMore;
        if (z && n.isNetOk()) {
            z2 = this.cbF.aKm;
            if (!z2) {
                this.cbF.aKm = true;
                pbListView = this.cbF.aOg;
                pbListView.startLoadData();
                bVar = this.cbF.cbw;
                ahr = this.cbF.ahr();
                str = this.cbF.cbC;
                bVar.B(ahr, str);
            }
        }
    }
}
