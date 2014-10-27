package com.baidu.tieba.selectpoi;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
/* loaded from: classes.dex */
class b implements AdapterView.OnItemClickListener {
    final /* synthetic */ SelectLocationActivity bID;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(SelectLocationActivity selectLocationActivity) {
        this.bID = selectLocationActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        c cVar;
        c cVar2;
        cVar = this.bID.bIB;
        if (cVar != null) {
            MessageManager messageManager = MessageManager.getInstance();
            if (i != 0) {
                cVar2 = this.bID.bIB;
                Object item = cVar2.getItem(i);
                if (item instanceof com.baidu.tieba.location.b) {
                    com.baidu.tieba.location.b bVar = (com.baidu.tieba.location.b) item;
                    messageManager.dispatchResponsedMessage(new ResponsedSelectLocation(true, bVar.getName(), bVar.Sn()));
                    this.bID.finish();
                    return;
                }
                return;
            }
            messageManager.dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null));
            this.bID.finish();
        }
    }
}
