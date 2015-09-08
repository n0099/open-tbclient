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
    final /* synthetic */ ForbidActivity bZl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ForbidActivity forbidActivity) {
        this.bZl = forbidActivity;
    }

    @Override // com.baidu.tieba.pb.account.forbid.g.b
    public void a(ForbidTplData forbidTplData) {
        TextView textView;
        String str;
        BdListView bdListView;
        ForbidActivity.a aVar;
        textView = this.bZl.bZi;
        str = this.bZl.aju;
        textView.setText(str);
        if (forbidTplData.type == 1) {
            this.bZl.findViewById(i.f.radio_forbid_3).setVisibility(0);
            this.bZl.findViewById(i.f.radio_forbid_10).setVisibility(0);
        }
        this.bZl.bZj = new ForbidActivity.a(forbidTplData.reason);
        bdListView = this.bZl.mListView;
        aVar = this.bZl.bZj;
        bdListView.setAdapter((ListAdapter) aVar);
    }

    @Override // com.baidu.tieba.pb.account.forbid.g.b
    public void b(ForbidTplData forbidTplData) {
        this.bZl.showToast(forbidTplData.error.errMsg);
    }
}
