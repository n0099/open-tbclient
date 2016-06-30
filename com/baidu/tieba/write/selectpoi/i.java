package com.baidu.tieba.write.selectpoi;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import com.baidu.tieba.tbadkCore.location.a;
/* loaded from: classes.dex */
class i implements AdapterView.OnItemClickListener {
    final /* synthetic */ SelectLocationActivity fEE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(SelectLocationActivity selectLocationActivity) {
        this.fEE = selectLocationActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        l lVar;
        l lVar2;
        lVar = this.fEE.fEC;
        if (lVar != null) {
            MessageManager messageManager = MessageManager.getInstance();
            if (i != 0) {
                lVar2 = this.fEE.fEC;
                Object item = lVar2.getItem(i);
                if (item instanceof a.C0079a) {
                    a.C0079a c0079a = (a.C0079a) item;
                    messageManager.dispatchResponsedMessage(new ResponsedSelectLocation(true, c0079a.getName(), c0079a.getAddr(), c0079a.getSn()));
                    this.fEE.finish();
                    return;
                }
                return;
            }
            messageManager.dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
            this.fEE.finish();
        }
    }
}
