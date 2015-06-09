package com.baidu.tieba.write.selectpoi;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
/* loaded from: classes.dex */
class b implements AdapterView.OnItemClickListener {
    final /* synthetic */ SearchLocationActivity czQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(SearchLocationActivity searchLocationActivity) {
        this.czQ = searchLocationActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        g gVar;
        g gVar2;
        g gVar3;
        gVar = this.czQ.czK;
        if (gVar != null) {
            gVar2 = this.czQ.czK;
            if (gVar2.asr()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2002013));
                MessageManager messageManager = MessageManager.getInstance();
                gVar3 = this.czQ.czK;
                com.baidu.tieba.tbadkCore.location.m mVar = (com.baidu.tieba.tbadkCore.location.m) gVar3.getItem(i);
                messageManager.dispatchResponsedMessage(new ResponsedSelectLocation(true, mVar.getName(), mVar.getName(), mVar.getScreatString()));
                this.czQ.finish();
            }
        }
    }
}
