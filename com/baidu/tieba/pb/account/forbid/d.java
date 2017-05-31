package com.baidu.tieba.pb.account.forbid;

import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.pb.account.forbid.ForbidActivity;
import com.baidu.tieba.pb.account.forbid.g;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements g.b {
    final /* synthetic */ ForbidActivity egH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ForbidActivity forbidActivity) {
        this.egH = forbidActivity;
    }

    @Override // com.baidu.tieba.pb.account.forbid.g.b
    public void a(ForbidTplData forbidTplData) {
        TextView textView;
        String str;
        BdListView bdListView;
        ForbidActivity.a aVar;
        textView = this.egH.egE;
        str = this.egH.mUserName;
        textView.setText(str);
        if (forbidTplData.type == 1 || forbidTplData.type == 2) {
            this.egH.findViewById(w.h.radio_forbid_3).setVisibility(0);
            this.egH.findViewById(w.h.radio_forbid_10).setVisibility(0);
        }
        this.egH.egF = new ForbidActivity.a(forbidTplData.reason);
        bdListView = this.egH.Ic;
        aVar = this.egH.egF;
        bdListView.setAdapter((ListAdapter) aVar);
    }

    @Override // com.baidu.tieba.pb.account.forbid.g.b
    public void b(ForbidTplData forbidTplData) {
        this.egH.showToast(forbidTplData.error.errMsg);
    }
}
