package com.baidu.tieba.pb.history;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tieba.data.ai;
/* loaded from: classes.dex */
class e implements AdapterView.OnItemClickListener {
    final /* synthetic */ PbHistoryActivity buz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(PbHistoryActivity pbHistoryActivity) {
        this.buz = pbHistoryActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tbadk.mvc.i.c cVar;
        cVar = this.buz.aXc;
        ai aiVar = (ai) cVar.getItem(i);
        if (aiVar != null) {
            this.buz.sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.buz).createHistoryCfg(aiVar.getThreadId(), aiVar.zX(), aiVar.zY(), aiVar.zZ(), null)));
        }
    }
}
