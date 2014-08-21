package com.baidu.tieba.neighbors;

import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes.dex */
class j implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ NeighborsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(NeighborsActivity neighborsActivity) {
        this.a = neighborsActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.a.sendMessage(new HttpMessage(CmdConfigHttp.CLEAR_LOCATION_INFO));
        this.a.showProgressBarWithOffset(0, 0);
        aVar.d();
    }
}
