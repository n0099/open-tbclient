package com.baidu.tieba.pb.account.forbid;

import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.v;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements n {
    final /* synthetic */ ForbidActivity bFJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ForbidActivity forbidActivity) {
        this.bFJ = forbidActivity;
    }

    @Override // com.baidu.tieba.pb.account.forbid.n
    public void a(ForbidTplData forbidTplData) {
        TextView textView;
        String str;
        BdListView bdListView;
        e eVar;
        textView = this.bFJ.bFG;
        str = this.bFJ.acU;
        textView.setText(str);
        if (forbidTplData.type == 1) {
            this.bFJ.findViewById(v.radio_forbid_3).setVisibility(0);
            this.bFJ.findViewById(v.radio_forbid_10).setVisibility(0);
        }
        this.bFJ.bFH = new e(forbidTplData.reason);
        bdListView = this.bFJ.mListView;
        eVar = this.bFJ.bFH;
        bdListView.setAdapter((ListAdapter) eVar);
    }

    @Override // com.baidu.tieba.pb.account.forbid.n
    public void b(ForbidTplData forbidTplData) {
        this.bFJ.showToast(forbidTplData.error.errMsg);
    }
}
