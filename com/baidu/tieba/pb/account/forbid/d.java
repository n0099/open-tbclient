package com.baidu.tieba.pb.account.forbid;

import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.v;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements n {
    final /* synthetic */ ForbidActivity bFw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ForbidActivity forbidActivity) {
        this.bFw = forbidActivity;
    }

    @Override // com.baidu.tieba.pb.account.forbid.n
    public void a(ForbidTplData forbidTplData) {
        TextView textView;
        String str;
        BdListView bdListView;
        e eVar;
        textView = this.bFw.bFt;
        str = this.bFw.acM;
        textView.setText(str);
        if (forbidTplData.type == 1) {
            this.bFw.findViewById(v.radio_forbid_3).setVisibility(0);
            this.bFw.findViewById(v.radio_forbid_10).setVisibility(0);
        }
        this.bFw.bFu = new e(forbidTplData.reason);
        bdListView = this.bFw.mListView;
        eVar = this.bFw.bFu;
        bdListView.setAdapter((ListAdapter) eVar);
    }

    @Override // com.baidu.tieba.pb.account.forbid.n
    public void b(ForbidTplData forbidTplData) {
        this.bFw.showToast(forbidTplData.error.errMsg);
    }
}
