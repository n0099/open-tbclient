package com.baidu.tieba.selectpoi;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
/* loaded from: classes.dex */
class d implements AdapterView.OnItemClickListener {
    final /* synthetic */ SearchLocationActivity bMX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(SearchLocationActivity searchLocationActivity) {
        this.bMX = searchLocationActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        h hVar;
        h hVar2;
        h hVar3;
        hVar = this.bMX.bMS;
        if (hVar != null) {
            hVar2 = this.bMX.bMS;
            if (hVar2.acn()) {
                MessageManager messageManager = MessageManager.getInstance();
                hVar3 = this.bMX.bMS;
                com.baidu.tieba.tbadkCore.location.l lVar = (com.baidu.tieba.tbadkCore.location.l) hVar3.getItem(i);
                messageManager.dispatchResponsedMessage(new ResponsedSelectLocation(true, lVar.getName(), lVar.getName(), lVar.getScreatString()));
                this.bMX.setResult(-1);
                this.bMX.finish();
            }
        }
    }
}
