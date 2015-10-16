package com.baidu.tieba.write.selectpoi;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import com.baidu.tieba.tbadkCore.location.a;
/* loaded from: classes.dex */
class i implements AdapterView.OnItemClickListener {
    final /* synthetic */ SelectLocationActivity dlW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(SelectLocationActivity selectLocationActivity) {
        this.dlW = selectLocationActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        l lVar;
        l lVar2;
        lVar = this.dlW.dlU;
        if (lVar != null) {
            MessageManager messageManager = MessageManager.getInstance();
            if (i != 0) {
                lVar2 = this.dlW.dlU;
                Object item = lVar2.getItem(i);
                if (item instanceof a.C0078a) {
                    a.C0078a c0078a = (a.C0078a) item;
                    messageManager.dispatchResponsedMessage(new ResponsedSelectLocation(true, c0078a.getName(), c0078a.axl(), c0078a.axk()));
                    this.dlW.finish();
                    return;
                }
                return;
            }
            messageManager.dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
            this.dlW.finish();
        }
    }
}
