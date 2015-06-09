package com.baidu.tieba.myCollection.history;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
/* loaded from: classes.dex */
class f implements AdapterView.OnItemClickListener {
    final /* synthetic */ PbHistoryActivity bHJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(PbHistoryActivity pbHistoryActivity) {
        this.bHJ = pbHistoryActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tbadk.mvc.j.d dVar;
        dVar = this.bHJ.aDG;
        com.baidu.tieba.myCollection.baseHistory.b bVar = (com.baidu.tieba.myCollection.baseHistory.b) dVar.getItem(i);
        if (bVar != null) {
            this.bHJ.sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.bHJ.getPageContext().getPageActivity()).createHistoryCfg(bVar.getThreadId(), bVar.ZQ(), bVar.ZR(), bVar.ZS(), null)));
        }
    }
}
