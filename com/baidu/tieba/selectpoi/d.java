package com.baidu.tieba.selectpoi;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
/* loaded from: classes.dex */
class d implements AdapterView.OnItemClickListener {
    final /* synthetic */ SearchLocationActivity bOG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(SearchLocationActivity searchLocationActivity) {
        this.bOG = searchLocationActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        h hVar;
        h hVar2;
        h hVar3;
        hVar = this.bOG.bOB;
        if (hVar != null) {
            hVar2 = this.bOG.bOB;
            if (hVar2.acM()) {
                MessageManager messageManager = MessageManager.getInstance();
                hVar3 = this.bOG.bOB;
                com.baidu.tieba.tbadkCore.location.l lVar = (com.baidu.tieba.tbadkCore.location.l) hVar3.getItem(i);
                messageManager.dispatchResponsedMessage(new ResponsedSelectLocation(true, lVar.getName(), lVar.getName(), lVar.getScreatString()));
                this.bOG.setResult(-1);
                this.bOG.finish();
            }
        }
    }
}
