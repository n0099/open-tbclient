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
    final /* synthetic */ ForbidActivity cet;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ForbidActivity forbidActivity) {
        this.cet = forbidActivity;
    }

    @Override // com.baidu.tieba.pb.account.forbid.g.b
    public void a(ForbidTplData forbidTplData) {
        TextView textView;
        String str;
        BdListView bdListView;
        ForbidActivity.a aVar;
        textView = this.cet.ceq;
        str = this.cet.aiq;
        textView.setText(str);
        if (forbidTplData.type == 1) {
            this.cet.findViewById(i.f.radio_forbid_3).setVisibility(0);
            this.cet.findViewById(i.f.radio_forbid_10).setVisibility(0);
        }
        this.cet.cer = new ForbidActivity.a(forbidTplData.reason);
        bdListView = this.cet.mListView;
        aVar = this.cet.cer;
        bdListView.setAdapter((ListAdapter) aVar);
    }

    @Override // com.baidu.tieba.pb.account.forbid.g.b
    public void b(ForbidTplData forbidTplData) {
        this.cet.showToast(forbidTplData.error.errMsg);
    }
}
