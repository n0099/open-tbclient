package com.baidu.tieba.pb.history;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.aw;
import com.baidu.tieba.data.aj;
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
        aj item = gVar.getItem(i);
        if (item != null) {
            this.a.sendMessage(new CustomMessage(2004001, new aw(this.a).a(item.b(), null, null)));
        }
    }
}
