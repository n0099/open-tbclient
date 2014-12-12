package com.baidu.tieba.selectpoi;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
/* loaded from: classes.dex */
class j implements AdapterView.OnItemClickListener {
    final /* synthetic */ SelectLocationActivity bNf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(SelectLocationActivity selectLocationActivity) {
        this.bNf = selectLocationActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        l lVar;
        l lVar2;
        lVar = this.bNf.bNd;
        if (lVar != null) {
            MessageManager messageManager = MessageManager.getInstance();
            if (i != 0) {
                lVar2 = this.bNf.bNd;
                Object item = lVar2.getItem(i);
                if (item instanceof com.baidu.tieba.tbadkCore.location.b) {
                    com.baidu.tieba.tbadkCore.location.b bVar = (com.baidu.tieba.tbadkCore.location.b) item;
                    messageManager.dispatchResponsedMessage(new ResponsedSelectLocation(true, bVar.getName(), bVar.ahx(), bVar.ahw()));
                    this.bNf.finish();
                    return;
                }
                return;
            }
            messageManager.dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
            this.bNf.finish();
        }
    }
}
