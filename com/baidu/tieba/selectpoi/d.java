package com.baidu.tieba.selectpoi;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
/* loaded from: classes.dex */
class d implements AdapterView.OnItemClickListener {
    final /* synthetic */ SearchLocationActivity bOH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(SearchLocationActivity searchLocationActivity) {
        this.bOH = searchLocationActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        h hVar;
        h hVar2;
        h hVar3;
        hVar = this.bOH.bOC;
        if (hVar != null) {
            hVar2 = this.bOH.bOC;
            if (hVar2.acR()) {
                MessageManager messageManager = MessageManager.getInstance();
                hVar3 = this.bOH.bOC;
                com.baidu.tieba.tbadkCore.location.l lVar = (com.baidu.tieba.tbadkCore.location.l) hVar3.getItem(i);
                messageManager.dispatchResponsedMessage(new ResponsedSelectLocation(true, lVar.getName(), lVar.getName(), lVar.getScreatString()));
                this.bOH.setResult(-1);
                this.bOH.finish();
            }
        }
    }
}
