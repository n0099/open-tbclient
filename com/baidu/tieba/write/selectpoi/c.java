package com.baidu.tieba.write.selectpoi;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import com.baidu.tieba.write.data.b;
/* loaded from: classes.dex */
class c implements AdapterView.OnItemClickListener {
    final /* synthetic */ SearchLocationActivity dMC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(SearchLocationActivity searchLocationActivity) {
        this.dMC = searchLocationActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        h hVar;
        h hVar2;
        h hVar3;
        hVar = this.dMC.dMw;
        if (hVar != null) {
            hVar2 = this.dMC.dMw;
            if (hVar2.aIa()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CLOSE_SELECT_LOCATION_ACTIVITY));
                MessageManager messageManager = MessageManager.getInstance();
                hVar3 = this.dMC.dMw;
                b.a aVar = (b.a) hVar3.getItem(i);
                messageManager.dispatchResponsedMessage(new ResponsedSelectLocation(true, aVar.getName(), aVar.getName(), aVar.getScreatString()));
                this.dMC.finish();
            }
        }
    }
}
