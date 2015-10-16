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
    final /* synthetic */ ForbidActivity ceE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ForbidActivity forbidActivity) {
        this.ceE = forbidActivity;
    }

    @Override // com.baidu.tieba.pb.account.forbid.g.b
    public void a(ForbidTplData forbidTplData) {
        TextView textView;
        String str;
        BdListView bdListView;
        ForbidActivity.a aVar;
        textView = this.ceE.ceB;
        str = this.ceE.air;
        textView.setText(str);
        if (forbidTplData.type == 1) {
            this.ceE.findViewById(i.f.radio_forbid_3).setVisibility(0);
            this.ceE.findViewById(i.f.radio_forbid_10).setVisibility(0);
        }
        this.ceE.ceC = new ForbidActivity.a(forbidTplData.reason);
        bdListView = this.ceE.mListView;
        aVar = this.ceE.ceC;
        bdListView.setAdapter((ListAdapter) aVar);
    }

    @Override // com.baidu.tieba.pb.account.forbid.g.b
    public void b(ForbidTplData forbidTplData) {
        this.ceE.showToast(forbidTplData.error.errMsg);
    }
}
