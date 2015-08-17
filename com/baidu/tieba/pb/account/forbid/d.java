package com.baidu.tieba.pb.account.forbid;

import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.i;
import com.baidu.tieba.pb.account.forbid.ForbidActivity;
import com.baidu.tieba.pb.account.forbid.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements g.b {
    final /* synthetic */ ForbidActivity bYr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ForbidActivity forbidActivity) {
        this.bYr = forbidActivity;
    }

    @Override // com.baidu.tieba.pb.account.forbid.g.b
    public void a(ForbidTplData forbidTplData) {
        TextView textView;
        String str;
        BdListView bdListView;
        ForbidActivity.a aVar;
        textView = this.bYr.bYo;
        str = this.bYr.ajl;
        textView.setText(str);
        if (forbidTplData.type == 1) {
            this.bYr.findViewById(i.f.radio_forbid_3).setVisibility(0);
            this.bYr.findViewById(i.f.radio_forbid_10).setVisibility(0);
        }
        this.bYr.bYp = new ForbidActivity.a(forbidTplData.reason);
        bdListView = this.bYr.mListView;
        aVar = this.bYr.bYp;
        bdListView.setAdapter((ListAdapter) aVar);
    }

    @Override // com.baidu.tieba.pb.account.forbid.g.b
    public void b(ForbidTplData forbidTplData) {
        this.bYr.showToast(forbidTplData.error.errMsg);
    }
}
