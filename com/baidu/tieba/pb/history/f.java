package com.baidu.tieba.pb.history;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.bc;
import com.baidu.tieba.data.ak;
/* loaded from: classes.dex */
class f implements AdapterView.OnItemClickListener {
    final /* synthetic */ PbHistoryActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(PbHistoryActivity pbHistoryActivity) {
        this.a = pbHistoryActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        g gVar;
        gVar = this.a.e;
        ak item = gVar.getItem(i);
        if (item != null) {
            this.a.sendMessage(new CustomMessage(2004001, new bc(this.a).a(item.b(), item.f(), item.g(), item.h(), null)));
        }
    }
}
