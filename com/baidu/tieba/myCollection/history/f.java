package com.baidu.tieba.myCollection.history;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class f implements AdapterView.OnItemClickListener {
    final /* synthetic */ PbHistoryActivity ccQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(PbHistoryActivity pbHistoryActivity) {
        this.ccQ = pbHistoryActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tbadk.mvc.g.d dVar;
        dVar = this.ccQ.aJn;
        com.baidu.tieba.myCollection.baseHistory.b bVar = (com.baidu.tieba.myCollection.baseHistory.b) dVar.getItem(i);
        if (bVar != null) {
            if (bVar.sq() == 33) {
                this.ccQ.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(this.ccQ.getPageContext().getPageActivity(), bVar.getThreadId()).ce(bVar.AV()).ri()));
                return;
            }
            this.ccQ.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.ccQ.getPageContext().getPageActivity()).createHistoryCfg(bVar.getThreadId(), bVar.AV(), bVar.adY(), bVar.adZ(), null)));
        }
    }
}
