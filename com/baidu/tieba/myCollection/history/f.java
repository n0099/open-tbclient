package com.baidu.tieba.myCollection.history;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class f implements AdapterView.OnItemClickListener {
    final /* synthetic */ PbHistoryActivity ccp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(PbHistoryActivity pbHistoryActivity) {
        this.ccp = pbHistoryActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tbadk.mvc.g.d dVar;
        dVar = this.ccp.aKt;
        com.baidu.tieba.myCollection.baseHistory.b bVar = (com.baidu.tieba.myCollection.baseHistory.b) dVar.getItem(i);
        if (bVar != null) {
            if (bVar.sn() == 33) {
                this.ccp.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(this.ccp.getPageContext().getPageActivity(), bVar.getThreadId()).cg(bVar.Bi()).rh()));
                return;
            }
            this.ccp.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.ccp.getPageContext().getPageActivity()).createHistoryCfg(bVar.getThreadId(), bVar.Bi(), bVar.adD(), bVar.adE(), null)));
        }
    }
}
