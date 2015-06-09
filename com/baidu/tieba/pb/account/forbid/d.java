package com.baidu.tieba.pb.account.forbid;

import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.q;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements n {
    final /* synthetic */ ForbidActivity bIF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ForbidActivity forbidActivity) {
        this.bIF = forbidActivity;
    }

    @Override // com.baidu.tieba.pb.account.forbid.n
    public void a(ForbidTplData forbidTplData) {
        TextView textView;
        String str;
        BdListView bdListView;
        e eVar;
        textView = this.bIF.bIC;
        str = this.bIF.aec;
        textView.setText(str);
        if (forbidTplData.type == 1) {
            this.bIF.findViewById(q.radio_forbid_3).setVisibility(0);
            this.bIF.findViewById(q.radio_forbid_10).setVisibility(0);
        }
        this.bIF.bID = new e(forbidTplData.reason);
        bdListView = this.bIF.mListView;
        eVar = this.bIF.bID;
        bdListView.setAdapter((ListAdapter) eVar);
    }

    @Override // com.baidu.tieba.pb.account.forbid.n
    public void b(ForbidTplData forbidTplData) {
        this.bIF.showToast(forbidTplData.error.errMsg);
    }
}
